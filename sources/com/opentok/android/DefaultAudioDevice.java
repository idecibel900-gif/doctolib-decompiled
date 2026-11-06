package com.opentok.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.NoiseSuppressor;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import com.vonage.webrtc.MediaStreamTrack;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes4.dex */
class DefaultAudioDevice extends BaseAudioDevice implements BaseAudioDevice.AudioFocusManager {
    private static final int DEFAULT_BUFFER_SIZE = 1760;
    private static final int DEFAULT_SAMPLES_PER_BUFFER = 440;
    private static final int DEFAULT_SAMPLE_RATE = 44100;
    private static final int DEFAULT_START_RENDERER_AND_CAPTURER_DELAY = 5000;
    private static final String HEADSET_PLUG_STATE_KEY = "state";
    private static final int NUM_CHANNELS_CAPTURING = 1;
    private static final int NUM_CHANNELS_RENDERING = 1;
    private static final int SAMPLE_SIZE_IN_BYTES = 2;
    private static final int STEREO_CHANNELS = 2;
    private AtomicBoolean audioFocusActive;
    private final AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
    private final AudioManager audioManager;
    private final AudioManagerMode audioManagerMode;
    private OutputType audioOutputType;
    private AudioRecord audioRecord;
    private final AudioState audioState;
    private AudioTrack audioTrack;
    private BluetoothManager bluetoothManager;
    private int bufferedPlaySamples;
    private final Condition captureEvent;
    private final ReentrantLock captureLock;
    private final int captureSamplingRate;
    private final BaseAudioDevice.AudioSettings captureSettings;
    private final Runnable captureThread;
    private final Context context;
    private AcousticEchoCanceler echoCanceler;
    private int estimatedCaptureDelay;
    private int estimatedRenderDelay;
    private final BroadcastReceiver headsetBroadcastReceiver;
    private volatile boolean isCapturing;
    private boolean isHeadsetReceiverRegistered;
    private boolean isPhoneStateListenerRegistered;
    private volatile boolean isRendering;
    private boolean isResumingAfterPaused;
    private final OtLog.LogToken log;
    private NoiseSuppressor noiseSuppressor;
    private int outputSamplingRate;
    private final PhoneStateListener phoneStateListener;
    private ByteBuffer playBuffer;
    private int playPosition;
    private ByteBuffer recBuffer;
    private final Condition renderEvent;
    private final Runnable renderThread;
    private final ReentrantLock rendererLock;
    private final BaseAudioDevice.AudioSettings rendererSettings;
    private int samplesPerBuffer;
    private volatile boolean sdkHandlesAudioFocus;
    private volatile boolean shutdownCaptureThread;
    private volatile boolean shutdownRenderThread;
    private AtomicBoolean startRendererRequested;
    private TelephonyManager telephonyManager;
    private byte[] tempBufPlay;
    private byte[] tempBufRec;
    private boolean wasCapturing;
    private boolean wasRendering;

    /* JADX INFO: renamed from: com.opentok.android.DefaultAudioDevice$2, reason: invalid class name */
    class AnonymousClass2 extends PhoneStateListener {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCallStateChanged$0() {
            DefaultAudioDevice.this.startRendererAndCapturer();
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            DefaultAudioDevice.this.log.d("PhoneStateListener.onCallStateChanged() enter <-", new Object[0]);
            super.onCallStateChanged(i, str);
            if (i == 0) {
                DefaultAudioDevice.this.log.d("PhoneStateListener.onCallStateChanged(): TelephonyManager.CALL_STATE_IDLE", new Object[0]);
                new Handler().postDelayed(new Runnable() { // from class: com.opentok.android.DefaultAudioDevice$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onCallStateChanged$0();
                    }
                }, HTTPTimeoutManager.SUPPORTED_FALLBACK_TIMEOUT_MS);
            } else if (i == 1) {
                DefaultAudioDevice.this.log.d("PhoneStateListener.onCallStateChanged(): TelephonyManager.CALL_STATE_RINGING", new Object[0]);
                DefaultAudioDevice.this.stopRendererAndCapturer();
            } else if (i != 2) {
                DefaultAudioDevice.this.log.d("PhoneStateListener.onCallStateChanged() default", new Object[0]);
            } else {
                DefaultAudioDevice.this.log.d("PhoneStateListener.onCallStateChanged(): TelephonyManager.CALL_STATE_OFFHOOK", new Object[0]);
                DefaultAudioDevice.this.stopRendererAndCapturer();
            }
            DefaultAudioDevice.this.log.d("PhoneStateListener.onCallStateChanged() exit ->", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: com.opentok.android.DefaultAudioDevice$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$opentok$android$BaseAudioDevice$OutputMode;
        static final /* synthetic */ int[] $SwitchMap$com$opentok$android$DefaultAudioDevice$OutputType;

        static {
            int[] iArr = new int[BaseAudioDevice.OutputMode.values().length];
            $SwitchMap$com$opentok$android$BaseAudioDevice$OutputMode = iArr;
            try {
                iArr[BaseAudioDevice.OutputMode.SpeakerPhone.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$opentok$android$BaseAudioDevice$OutputMode[BaseAudioDevice.OutputMode.Handset.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[OutputType.values().length];
            $SwitchMap$com$opentok$android$DefaultAudioDevice$OutputType = iArr2;
            try {
                iArr2[OutputType.BLUETOOTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$opentok$android$DefaultAudioDevice$OutputType[OutputType.SPEAKER_PHONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$opentok$android$DefaultAudioDevice$OutputType[OutputType.EAR_PIECE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static class AudioManagerMode {
        private final OtLog.LogToken log = new OtLog.LogToken(this);
        private int oldMode = 0;
        private int naquire = 0;

        AudioManagerMode() {
        }

        void acquireMode(AudioManager audioManager) {
            this.log.d("AudioManagerMode.acquireMode() called", new Object[0]);
            int i = this.naquire;
            this.naquire = i + 1;
            if (i == 0) {
                this.oldMode = audioManager.getMode();
                audioManager.setMode(3);
            }
        }

        void releaseMode(AudioManager audioManager) {
            this.log.d("AudioManagerMode.releaseMode() called", new Object[0]);
            int i = this.naquire - 1;
            this.naquire = i;
            if (i == 0) {
                audioManager.setMode(this.oldMode);
            }
        }
    }

    private static class AudioState {
        private int lastKnownFocusState;
        private OutputType lastOutputType;
        private int lastStreamVolume;
        private final OtLog.LogToken log;

        private AudioState() {
            this.lastStreamVolume = 0;
            this.lastKnownFocusState = 0;
            this.lastOutputType = OutputType.SPEAKER_PHONE;
            this.log = new OtLog.LogToken(this);
        }

        int getLastKnownFocusState() {
            return this.lastKnownFocusState;
        }

        int getLastStreamVolume() {
            return this.lastStreamVolume;
        }

        OutputType getPreviousOutputType() {
            this.log.d("AudioState.getPreviousOutputType() = " + this.lastOutputType, new Object[0]);
            return this.lastOutputType;
        }

        void setLastKnownFocusState(int i) {
            this.lastKnownFocusState = i;
        }

        void setLastStreamVolume(int i) {
            this.lastStreamVolume = i;
        }

        void setPreviousOutputType(OutputType outputType) {
            this.log.d("AudioState.setPreviousOutputType() = " + outputType, new Object[0]);
            this.lastOutputType = outputType;
        }
    }

    public enum OutputType {
        SPEAKER_PHONE,
        EAR_PIECE,
        HEAD_PHONES,
        BLUETOOTH
    }

    public DefaultAudioDevice(Context context) {
        OtLog.LogToken logToken = new OtLog.LogToken(this);
        this.log = logToken;
        ReentrantLock reentrantLock = new ReentrantLock(true);
        this.rendererLock = reentrantLock;
        this.renderEvent = reentrantLock.newCondition();
        this.isRendering = false;
        this.shutdownRenderThread = false;
        ReentrantLock reentrantLock2 = new ReentrantLock(true);
        this.captureLock = reentrantLock2;
        this.captureEvent = reentrantLock2.newCondition();
        this.isCapturing = false;
        this.shutdownCaptureThread = false;
        this.estimatedCaptureDelay = 0;
        this.bufferedPlaySamples = 0;
        this.playPosition = 0;
        this.estimatedRenderDelay = 0;
        this.audioManagerMode = new AudioManagerMode();
        this.outputSamplingRate = DEFAULT_SAMPLE_RATE;
        this.captureSamplingRate = DEFAULT_SAMPLE_RATE;
        this.samplesPerBuffer = DEFAULT_SAMPLES_PER_BUFFER;
        this.audioOutputType = OutputType.SPEAKER_PHONE;
        this.sdkHandlesAudioFocus = true;
        this.audioFocusActive = new AtomicBoolean(false);
        this.startRendererRequested = new AtomicBoolean(false);
        this.audioState = new AudioState();
        this.headsetBroadcastReceiver = new BroadcastReceiver() { // from class: com.opentok.android.DefaultAudioDevice.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
                    if (intent.getIntExtra(DefaultAudioDevice.HEADSET_PLUG_STATE_KEY, 0) == 1) {
                        DefaultAudioDevice.this.log.d("headsetBroadcastReceiver.onReceive():  Headphones connected", new Object[0]);
                        DefaultAudioDevice defaultAudioDevice = DefaultAudioDevice.this;
                        defaultAudioDevice.audioState.setPreviousOutputType(defaultAudioDevice.getOutputType());
                        DefaultAudioDevice.this.setOutputType(OutputType.HEAD_PHONES);
                        DefaultAudioDevice.this.audioManager.setSpeakerphoneOn(false);
                        DefaultAudioDevice.this.bluetoothManager.stopBluetoothSCO();
                        return;
                    }
                    DefaultAudioDevice.this.log.d("headsetBroadcastReceiver.onReceive():  Headphones disconnected", new Object[0]);
                    if (DefaultAudioDevice.this.getOutputType() == OutputType.HEAD_PHONES) {
                        OutputType previousOutputType = DefaultAudioDevice.this.audioState.getPreviousOutputType();
                        int i = AnonymousClass4.$SwitchMap$com$opentok$android$DefaultAudioDevice$OutputType[previousOutputType.ordinal()];
                        if (i == 1) {
                            DefaultAudioDevice.this.bluetoothManager.startBluetoothSCO();
                            return;
                        }
                        if (i == 2) {
                            DefaultAudioDevice.this.audioManager.setSpeakerphoneOn(true);
                            DefaultAudioDevice.this.setOutputType(previousOutputType);
                        } else if (i != 3) {
                            DefaultAudioDevice.this.log.e("This should not happen :(", new Object[0]);
                        } else {
                            DefaultAudioDevice.this.audioManager.setSpeakerphoneOn(false);
                            DefaultAudioDevice.this.setOutputType(previousOutputType);
                        }
                    }
                }
            }
        };
        this.phoneStateListener = new AnonymousClass2();
        this.audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.opentok.android.DefaultAudioDevice.3
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i) {
                DefaultAudioDevice.this.log.d("AudioManager.OnAudioFocusChangeListener.onAudioFocusChange() enter <-", new Object[0]);
                if (i == -3) {
                    DefaultAudioDevice.this.log.d("AudioManager.OnAudioFocusChangeListener.onAudioFocusChange(" + i + "): AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK", new Object[0]);
                    DefaultAudioDevice defaultAudioDevice = DefaultAudioDevice.this;
                    defaultAudioDevice.audioState.setLastStreamVolume(defaultAudioDevice.audioManager.getStreamVolume(0));
                    DefaultAudioDevice.this.audioManager.setStreamVolume(0, 0, 0);
                } else if (i == -2) {
                    DefaultAudioDevice.this.log.d("AudioManager.OnAudioFocusChangeListener.onAudioFocusChange(" + i + "): AudioManager.AUDIOFOCUS_LOSS_TRANSIENT", new Object[0]);
                } else if (i == -1) {
                    DefaultAudioDevice.this.log.d("AudioManager.OnAudioFocusChangeListener.onAudioFocusChange(" + i + "): AudioManager.AUDIOFOCUS_LOSS", new Object[0]);
                } else if (i == 0) {
                    DefaultAudioDevice.this.log.d("AudioManager.OnAudioFocusChangeListener.onAudioFocusChange(" + i + "): AudioManager.AUDIOFOCUS_NONE", new Object[0]);
                } else if (i != 1) {
                    DefaultAudioDevice.this.log.d("AudioManager.OnAudioFocusChangeListener.onAudioFocusChange(" + i + "): default", new Object[0]);
                } else {
                    DefaultAudioDevice.this.log.d("AudioManager.OnAudioFocusChangeListener.onAudioFocusChange(" + i + "): ", new Object[0]);
                    int lastKnownFocusState = DefaultAudioDevice.this.audioState.getLastKnownFocusState();
                    if (lastKnownFocusState == -3) {
                        DefaultAudioDevice defaultAudioDevice2 = DefaultAudioDevice.this;
                        defaultAudioDevice2.audioManager.setStreamVolume(0, defaultAudioDevice2.audioState.getLastStreamVolume(), 0);
                    } else if (lastKnownFocusState != -2 && lastKnownFocusState != -1) {
                        DefaultAudioDevice.this.log.d("focusChange = " + i, new Object[0]);
                    }
                    DefaultAudioDevice defaultAudioDevice3 = DefaultAudioDevice.this;
                    defaultAudioDevice3.setOutputType(defaultAudioDevice3.audioState.getPreviousOutputType());
                    DefaultAudioDevice.this.bluetoothManager.forceInvokeConnectBluetooth();
                }
                DefaultAudioDevice defaultAudioDevice4 = DefaultAudioDevice.this;
                defaultAudioDevice4.audioState.setPreviousOutputType(defaultAudioDevice4.getOutputType());
                DefaultAudioDevice.this.audioState.setLastKnownFocusState(i);
                DefaultAudioDevice.this.log.d("AudioManager.OnAudioFocusChangeListener.onAudioFocusChange() exit ->", new Object[0]);
            }
        };
        this.captureThread = new Runnable() { // from class: com.opentok.android.DefaultAudioDevice$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
        this.renderThread = new Runnable() { // from class: com.opentok.android.DefaultAudioDevice$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$1();
            }
        };
        this.isPhoneStateListenerRegistered = false;
        logToken.d("DefaultAudioDevice() enter " + this, new Object[0]);
        this.context = context;
        int i = DEFAULT_BUFFER_SIZE;
        try {
            this.recBuffer = ByteBuffer.allocateDirect(DEFAULT_BUFFER_SIZE);
        } catch (Exception e) {
            this.log.e(e.getMessage(), new Object[0]);
        }
        this.tempBufRec = new byte[DEFAULT_BUFFER_SIZE];
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.audioManager = audioManager;
        this.bluetoothManager = BluetoothManager.create(context, this);
        try {
            try {
                int i2 = Integer.parseInt(audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE"));
                this.outputSamplingRate = i2;
                if (i2 == 0) {
                    this.outputSamplingRate = DEFAULT_SAMPLE_RATE;
                }
            } catch (NumberFormatException e2) {
                this.log.e("DefaultAudioDevice(): " + e2.getMessage(), new Object[0]);
                if (this.outputSamplingRate == 0) {
                }
            }
            try {
                int i3 = Integer.parseInt(this.audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER"));
                this.samplesPerBuffer = i3;
                int i4 = i3 * 2;
                if (i4 == 0) {
                    this.samplesPerBuffer = DEFAULT_SAMPLES_PER_BUFFER;
                } else {
                    i = i4;
                }
            } catch (NumberFormatException e3) {
                this.log.e("DefaultAudioDevice(): " + e3.getMessage(), new Object[0]);
            }
            try {
                this.playBuffer = ByteBuffer.allocateDirect(i);
            } catch (Exception e4) {
                this.log.e(e4.getMessage(), new Object[0]);
            }
            this.tempBufPlay = new byte[i];
            this.captureSettings = new BaseAudioDevice.AudioSettings(DEFAULT_SAMPLE_RATE, 1);
            this.rendererSettings = new BaseAudioDevice.AudioSettings(this.outputSamplingRate, 1);
            try {
                this.telephonyManager = (TelephonyManager) context.getSystemService(AuthorizationRequest.Scope.PHONE);
            } catch (SecurityException e5) {
                e5.printStackTrace();
            }
            this.isPhoneStateListenerRegistered = false;
            this.wasCapturing = false;
            this.wasRendering = false;
            this.isResumingAfterPaused = false;
            this.log.d("DefaultAudioDevice() exit  " + this, new Object[0]);
        } catch (Throwable th) {
            if (this.outputSamplingRate == 0) {
                this.outputSamplingRate = DEFAULT_SAMPLE_RATE;
            }
            throw th;
        }
    }

    private void abandonAudioFocus() {
        this.audioFocusActive.set(false);
        this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
    }

    private void destroyAudioTrack() {
        this.rendererLock.lock();
        this.audioTrack.release();
        this.audioTrack = null;
        this.shutdownRenderThread = true;
        this.startRendererRequested.set(false);
        this.renderEvent.signal();
        this.rendererLock.unlock();
    }

    private boolean hasPhoneStatePermission() {
        if (Build.VERSION.SDK_INT < 31 || this.context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            return true;
        }
        this.log.e("Some features may not be available unless the phone permissions has been granted explicitly in the App settings.", new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        try {
            Process.setThreadPriority(-19);
        } catch (Exception e) {
            this.log.e("android.os.Process.setThreadPriority(): " + e.getMessage(), new Object[0]);
        }
        while (!this.shutdownCaptureThread) {
            this.captureLock.lock();
            try {
                try {
                    if (this.isCapturing) {
                        AudioRecord audioRecord = this.audioRecord;
                        if (audioRecord == null) {
                            this.captureLock.unlock();
                        } else {
                            int i = audioRecord.read(this.tempBufRec, 0, 882);
                            if (i < 0) {
                                if (i == -3) {
                                    throw new RuntimeException("captureThread(): AudioRecord.ERROR_INVALID_OPERATION");
                                }
                                if (i == -2) {
                                    throw new RuntimeException("captureThread(): AudioRecord.ERROR_BAD_VALUE");
                                }
                                throw new RuntimeException("captureThread(): AudioRecord.ERROR or default");
                            }
                            this.recBuffer.rewind();
                            this.recBuffer.put(this.tempBufRec);
                            int i2 = i >> 1;
                            this.captureLock.unlock();
                            getAudioBus().writeCaptureData(this.recBuffer, i2);
                            this.estimatedCaptureDelay = (i2 * 1000) / DEFAULT_SAMPLE_RATE;
                        }
                    } else {
                        this.captureEvent.await();
                        this.captureLock.unlock();
                    }
                } catch (Exception e2) {
                    this.log.e("Audio device capture error: " + e2.getMessage(), new Object[0]);
                    this.captureLock.unlock();
                    return;
                }
            } catch (Throwable th) {
                this.captureLock.unlock();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        int i = this.samplesPerBuffer;
        try {
            Process.setThreadPriority(-19);
        } catch (Exception e) {
            this.log.e("android.os.Process.setThreadPriority(): " + e.getMessage(), new Object[0]);
        }
        while (!this.shutdownRenderThread) {
            this.rendererLock.lock();
            try {
                try {
                    if (this.isRendering) {
                        this.rendererLock.unlock();
                        this.playBuffer.clear();
                        int renderData = getAudioBus().readRenderData(this.playBuffer, i);
                        this.rendererLock.lock();
                        if (this.audioTrack != null && this.isRendering) {
                            int i2 = renderData << 1;
                            this.playBuffer.get(this.tempBufPlay, 0, i2);
                            int iWrite = this.audioTrack.write(this.tempBufPlay, 0, i2);
                            if (iWrite <= 0) {
                                if (iWrite == -3) {
                                    throw new RuntimeException("renderThread(): AudioTrack.ERROR_INVALID_OPERATION");
                                }
                                if (iWrite == -2) {
                                    throw new RuntimeException("renderThread(): AudioTrack.ERROR_BAD_VALUE");
                                }
                                throw new RuntimeException("renderThread(): AudioTrack.ERROR or default");
                            }
                            this.bufferedPlaySamples += iWrite >> 1;
                            int playbackHeadPosition = this.audioTrack.getPlaybackHeadPosition();
                            if (playbackHeadPosition < this.playPosition) {
                                this.playPosition = 0;
                            }
                            int i3 = this.bufferedPlaySamples - (playbackHeadPosition - this.playPosition);
                            this.bufferedPlaySamples = i3;
                            this.playPosition = playbackHeadPosition;
                            this.estimatedRenderDelay = (i3 * 1000) / this.outputSamplingRate;
                        }
                    } else {
                        this.renderEvent.await();
                    }
                    this.rendererLock.unlock();
                } catch (Exception e2) {
                    this.log.e("Audio device capture error: " + e2.getMessage(), new Object[0]);
                    this.rendererLock.unlock();
                    return;
                }
            } catch (Throwable th) {
                this.rendererLock.unlock();
                throw th;
            }
        }
    }

    private synchronized void registerHeadsetReceiver() {
        try {
            this.log.d("registerHeadsetReceiver() enter ... isHeadsetReceiverRegistered = " + this.isHeadsetReceiverRegistered, new Object[0]);
            if (!this.isHeadsetReceiverRegistered) {
                this.context.registerReceiver(this.headsetBroadcastReceiver, new IntentFilter("android.intent.action.HEADSET_PLUG"));
                this.isHeadsetReceiverRegistered = true;
            }
            this.log.d("registerHeadsetReceiver() exit ... isHeadsetReceiverRegistered = " + this.isHeadsetReceiverRegistered, new Object[0]);
        } catch (Throwable th) {
            throw th;
        }
    }

    private void registerPhoneStateListener() {
        this.log.d("registerPhoneStateListener() enter", new Object[0]);
        if (this.isPhoneStateListenerRegistered) {
            this.log.d("phoneStateListener is already registered.", new Object[0]);
            return;
        }
        if (!hasPhoneStatePermission()) {
            this.log.d("No Phone State permissions. Register phoneStateListener cannot be completed.", new Object[0]);
            return;
        }
        TelephonyManager telephonyManager = this.telephonyManager;
        if (telephonyManager != null) {
            telephonyManager.listen(this.phoneStateListener, 32);
            this.isPhoneStateListenerRegistered = true;
        }
        this.log.d("registerPhoneStateListener() exit", new Object[0]);
    }

    private boolean requestAudioFocus() {
        if (this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 0, 1) != 1) {
            this.log.d("initRenderer(): !AudioManager.AUDIOFOCUS_REQUEST_GRANTED", new Object[0]);
            return false;
        }
        this.log.d("initRenderer(): AudioManager.AUDIOFOCUS_REQUEST_GRANTED", new Object[0]);
        this.audioFocusActive.set(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRendererAndCapturer() {
        this.log.d("startRendererAndCapturer() enter <-", new Object[0]);
        if (this.wasRendering) {
            startRenderer();
        }
        if (this.wasCapturing) {
            startCapturer();
        }
        this.log.d("startRendererAndCapturer() exit ->", new Object[0]);
    }

    private void startRendererIfNeeded() {
        if (this.sdkHandlesAudioFocus) {
            return;
        }
        this.log.d("startRendererIfNeeded() called. startRendererRequested = " + this.startRendererRequested.get() + ", audioFocusActive = " + this.audioFocusActive, new Object[0]);
        if (!this.startRendererRequested.get() || !this.audioFocusActive.get()) {
            this.log.d("Not starting renderer as either not requested or audio focus is inactive", new Object[0]);
        } else {
            this.log.d("Starting renderer as requested and audio focus is active", new Object[0]);
            startRenderer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopRendererAndCapturer() {
        this.log.d("stopRendererAndCapturer() enter <-", new Object[0]);
        if (this.isRendering) {
            stopRenderer();
            this.wasRendering = true;
        }
        if (this.isCapturing) {
            stopCapturer();
            this.wasCapturing = true;
        }
        this.log.d("stopRendererAndCapturer() exit ->", new Object[0]);
    }

    private void unRegisterPhoneStateListener() {
        this.log.d("unRegisterPhoneStateListener() enter.", new Object[0]);
        if (!this.isPhoneStateListenerRegistered) {
            this.log.d("phoneStateListener is already unregistered.", new Object[0]);
            return;
        }
        if (!hasPhoneStatePermission()) {
            this.log.d("No Phone State permissions. Unregister phoneStateListener cannot be completed.", new Object[0]);
            return;
        }
        TelephonyManager telephonyManager = this.telephonyManager;
        if (telephonyManager != null) {
            telephonyManager.listen(this.phoneStateListener, 0);
            this.isPhoneStateListenerRegistered = false;
        }
        this.log.d("unRegisterPhoneStateListener() exit.", new Object[0]);
    }

    private synchronized void unregisterHeadsetReceiver() {
        try {
            this.log.d("unregisterHeadsetReceiver() enter .. isHeadsetReceiverRegistered = " + this.isHeadsetReceiverRegistered, new Object[0]);
            if (this.isHeadsetReceiverRegistered) {
                this.context.unregisterReceiver(this.headsetBroadcastReceiver);
                this.isHeadsetReceiverRegistered = false;
            }
            this.log.d("unregisterHeadsetReceiver() exit .. isHeadsetReceiverRegistered = " + this.isHeadsetReceiverRegistered, new Object[0]);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.opentok.android.BaseAudioDevice.AudioFocusManager
    public void audioFocusActivated() {
        if (this.sdkHandlesAudioFocus) {
            this.log.d("Ignored audio focus activated callback because manual audio focus (setRequestAudioFocus(false)) was not requested", new Object[0]);
            return;
        }
        this.log.d("SDK notified audio focus was granted", new Object[0]);
        this.audioFocusActive.set(true);
        startRendererIfNeeded();
    }

    @Override // com.opentok.android.BaseAudioDevice.AudioFocusManager
    public void audioFocusDeactivated() {
        if (this.sdkHandlesAudioFocus) {
            this.log.d("Ignored audio focus deactivated callback because manual audio focus (setRequestAudioFocus(false)) was not requested", new Object[0]);
            return;
        }
        this.log.d("SDK notified audio focus was lost", new Object[0]);
        if (this.isRendering) {
            stopRenderer();
        }
        this.audioFocusActive.set(false);
    }

    @Override // com.opentok.android.BaseAudioDevice
    public boolean destroyCapturer() {
        this.log.d("destroyCapturer() enter <-", new Object[0]);
        this.captureLock.lock();
        AcousticEchoCanceler acousticEchoCanceler = this.echoCanceler;
        if (acousticEchoCanceler != null) {
            acousticEchoCanceler.release();
            this.echoCanceler = null;
        }
        NoiseSuppressor noiseSuppressor = this.noiseSuppressor;
        if (noiseSuppressor != null) {
            noiseSuppressor.release();
            this.noiseSuppressor = null;
        }
        this.audioRecord.release();
        this.audioRecord = null;
        this.shutdownCaptureThread = true;
        this.captureEvent.signal();
        this.captureLock.unlock();
        if (this.sdkHandlesAudioFocus) {
            unRegisterPhoneStateListener();
        }
        this.wasCapturing = false;
        this.log.d("destroyCapturer() exit ->", new Object[0]);
        return true;
    }

    @Override // com.opentok.android.BaseAudioDevice
    public boolean destroyRenderer() {
        this.log.d("destroyRenderer() enter <-", new Object[0]);
        this.log.d("destroyRenderer() audioFocusActive " + this.audioFocusActive.get() + " sdkHandlesAudioFocus " + this.sdkHandlesAudioFocus, new Object[0]);
        destroyAudioTrack();
        if (this.sdkHandlesAudioFocus) {
            unregisterHeadsetReceiver();
            this.bluetoothManager.unregisterBtReceiver();
            this.audioManager.setSpeakerphoneOn(false);
            abandonAudioFocus();
            unRegisterPhoneStateListener();
        }
        this.wasRendering = false;
        this.log.d("destroyRenderer() exit ->", new Object[0]);
        return true;
    }

    @Override // com.opentok.android.BaseAudioDevice
    public BaseAudioDevice.BluetoothState getBluetoothState() {
        return this.bluetoothManager.getBluetoothState();
    }

    @Override // com.opentok.android.BaseAudioDevice
    public BaseAudioDevice.AudioSettings getCaptureSettings() {
        return this.captureSettings;
    }

    @Override // com.opentok.android.BaseAudioDevice
    public int getEstimatedCaptureDelay() {
        return this.estimatedCaptureDelay;
    }

    @Override // com.opentok.android.BaseAudioDevice
    public int getEstimatedRenderDelay() {
        return this.estimatedRenderDelay;
    }

    public OutputType getOutputType() {
        return this.audioOutputType;
    }

    @Override // com.opentok.android.BaseAudioDevice
    public BaseAudioDevice.AudioSettings getRenderSettings() {
        return this.rendererSettings;
    }

    @Override // com.opentok.android.BaseAudioDevice
    public boolean initCapturer() {
        this.log.d("initCapturer() enter <-", new Object[0]);
        int minBufferSize = AudioRecord.getMinBufferSize(this.captureSettings.getSampleRate(), 16, 2);
        int i = minBufferSize * 2;
        NoiseSuppressor noiseSuppressor = this.noiseSuppressor;
        if (noiseSuppressor != null) {
            noiseSuppressor.release();
            this.noiseSuppressor = null;
        }
        AcousticEchoCanceler acousticEchoCanceler = this.echoCanceler;
        if (acousticEchoCanceler != null) {
            acousticEchoCanceler.release();
            this.echoCanceler = null;
        }
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            audioRecord.release();
            this.audioRecord = null;
        }
        try {
            this.audioRecord = new AudioRecord(7, this.captureSettings.getSampleRate(), 16, 2, i);
            if (NoiseSuppressor.isAvailable()) {
                this.noiseSuppressor = NoiseSuppressor.create(this.audioRecord.getAudioSessionId());
            }
            if (AcousticEchoCanceler.isAvailable()) {
                this.echoCanceler = AcousticEchoCanceler.create(this.audioRecord.getAudioSessionId());
            }
            if (this.audioRecord.getState() != 1) {
                String str = String.format(Locale.getDefault(), "Audio capture could not be initialized.\nRequested parameters\n  Sampling Rate: %d\n  Number of channels: %d\n  Buffer size: %d\n", Integer.valueOf(this.captureSettings.getSampleRate()), Integer.valueOf(this.captureSettings.getNumChannels()), Integer.valueOf(minBufferSize));
                this.log.e(str, new Object[0]);
                throw new RuntimeException(str);
            }
            if (this.sdkHandlesAudioFocus) {
                registerPhoneStateListener();
            }
            this.shutdownCaptureThread = false;
            new Thread(this.captureThread).start();
            this.log.d("initCapturer() exit ->", new Object[0]);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override // com.opentok.android.BaseAudioDevice
    public boolean initRenderer() {
        this.log.d("initRenderer() enter <-", new Object[0]);
        this.log.d("initRenderer() audioFocusActive " + this.audioFocusActive.get() + " sdkHandlesAudioFocus " + this.sdkHandlesAudioFocus, new Object[0]);
        if (this.sdkHandlesAudioFocus && !requestAudioFocus()) {
            return false;
        }
        int minBufferSize = AudioTrack.getMinBufferSize(this.rendererSettings.getSampleRate(), 4, 2);
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            audioTrack.release();
            this.audioTrack = null;
        }
        try {
            int sampleRate = this.rendererSettings.getSampleRate();
            if (minBufferSize < 6000) {
                minBufferSize *= 2;
            }
            AudioTrack audioTrack2 = new AudioTrack(0, sampleRate, 4, 2, minBufferSize, 1);
            this.audioTrack = audioTrack2;
            if (audioTrack2.getState() != 1) {
                throw new RuntimeException("Audio renderer not initialized " + this.rendererSettings.getSampleRate());
            }
            this.bufferedPlaySamples = 0;
            if (this.sdkHandlesAudioFocus) {
                this.bluetoothManager.registerBtReceiver();
                registerPhoneStateListener();
            }
            this.shutdownRenderThread = false;
            new Thread(this.renderThread).start();
            this.log.d("initRenderer() exit ->", new Object[0]);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    boolean isWiredHeadSetConnected() {
        this.log.d("isWiredHeadSetConnected enter.", new Object[0]);
        for (AudioDeviceInfo audioDeviceInfo : this.audioManager.getDevices(2)) {
            this.log.d("Detected connected audio output device of type: " + audioDeviceInfo.getType(), new Object[0]);
            if (audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 22) {
                this.log.d("Detected connected wired headset", new Object[0]);
                return true;
            }
        }
        return false;
    }

    @Override // com.opentok.android.BaseAudioDevice
    public synchronized void onPause() {
        try {
            this.log.d("onPause() enter <-", new Object[0]);
            if (this.sdkHandlesAudioFocus) {
                this.audioState.setPreviousOutputType(getOutputType());
                this.bluetoothManager.onPause();
                unregisterHeadsetReceiver();
                this.isResumingAfterPaused = true;
            }
            this.log.d("onPause() exit ->", new Object[0]);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.opentok.android.BaseAudioDevice
    public synchronized void onResume() {
        try {
            this.log.d("onResume() enter. isResumingAfterPaused = " + this.isResumingAfterPaused, new Object[0]);
            this.log.d("startRenderer() audioFocusActive " + this.audioFocusActive.get() + " sdkHandlesAudioFocus " + this.sdkHandlesAudioFocus, new Object[0]);
            if (this.sdkHandlesAudioFocus) {
                registerHeadsetReceiver();
                this.bluetoothManager.onResume();
                if (this.isResumingAfterPaused) {
                    if (getBluetoothState() == BaseAudioDevice.BluetoothState.Disconnected && this.isRendering && this.audioState.getPreviousOutputType() == OutputType.SPEAKER_PHONE && !isWiredHeadSetConnected()) {
                        this.log.d("onResume() - Set Speaker Phone ON True", new Object[0]);
                        this.audioManager.setSpeakerphoneOn(true);
                    }
                    this.isResumingAfterPaused = false;
                }
            }
            this.log.d("onResume() exit ->", new Object[0]);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void restoreAudioAfterBluetoothDisconnect() {
        this.log.d("restoreAudioAfterBluetoothDisconnect enter.", new Object[0]);
        if (!this.sdkHandlesAudioFocus) {
            this.log.d("SDK does not handle audio. Skipping restoreAudioAfterBluetoothDisconnect()", new Object[0]);
            return;
        }
        if (isWiredHeadSetConnected()) {
            setOutputType(OutputType.HEAD_PHONES);
            this.audioManager.setSpeakerphoneOn(false);
        } else {
            int i = AnonymousClass4.$SwitchMap$com$opentok$android$BaseAudioDevice$OutputMode[getOutputMode().ordinal()];
            if (i == 1) {
                this.log.d("Falling back to speaker mode.", new Object[0]);
                setOutputType(OutputType.SPEAKER_PHONE);
                this.audioManager.setSpeakerphoneOn(true);
            } else if (i != 2) {
                this.log.e("This should not happen. :(", new Object[0]);
            } else {
                this.log.d("Falling back to handset mode.", new Object[0]);
                setOutputType(OutputType.EAR_PIECE);
                this.audioManager.setSpeakerphoneOn(false);
            }
        }
        this.log.d("restoreAudioAfterBluetoothDisconnect exit.", new Object[0]);
    }

    @Override // com.opentok.android.BaseAudioDevice
    public boolean setOutputMode(BaseAudioDevice.OutputMode outputMode) {
        this.log.d("setOutputMode(). Audio Output mode set to --> " + outputMode, new Object[0]);
        if (!this.sdkHandlesAudioFocus) {
            this.log.d("setOutputMode() - SDK does not handle audio focus. Skipping setOutputMode.", new Object[0]);
            return false;
        }
        super.setOutputMode(outputMode);
        if (BaseAudioDevice.OutputMode.SpeakerPhone == outputMode) {
            this.audioState.setPreviousOutputType(getOutputType());
            setOutputType(OutputType.SPEAKER_PHONE);
            this.audioManager.setSpeakerphoneOn(true);
            this.bluetoothManager.stopBluetoothSCO();
        } else {
            this.audioManager.setSpeakerphoneOn(false);
            OutputType previousOutputType = this.audioState.getPreviousOutputType();
            OutputType outputType = OutputType.BLUETOOTH;
            if (previousOutputType == outputType || getBluetoothState() == BaseAudioDevice.BluetoothState.Connected) {
                setOutputType(outputType);
            } else {
                this.audioState.setPreviousOutputType(getOutputType());
                setOutputType(OutputType.EAR_PIECE);
                this.bluetoothManager.stopBluetoothSCO();
            }
        }
        return true;
    }

    public void setOutputType(OutputType outputType) {
        this.log.d("setOutputType(). Setting output type to " + outputType, new Object[0]);
        this.audioOutputType = outputType;
    }

    @Override // com.opentok.android.BaseAudioDevice.AudioFocusManager
    public void setRequestAudioFocus(boolean z) {
        this.log.d("setRequestAudioFocus(). SDK handles audio focus is " + z, new Object[0]);
        this.sdkHandlesAudioFocus = z;
        if (z) {
            if (this.audioTrack != null) {
                this.log.e("setRequestAudioFocus(). setRequestAudioFocus() needs to be called on app startup", new Object[0]);
            }
        } else {
            BluetoothManager bluetoothManager = this.bluetoothManager;
            if (bluetoothManager != null) {
                bluetoothManager.unregisterBtReceiver();
                this.bluetoothManager = null;
            }
        }
    }

    @Override // com.opentok.android.BaseAudioDevice
    public boolean startCapturer() {
        this.log.d("startCapturer() enter <-", new Object[0]);
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord == null) {
            throw new IllegalStateException("startCapturer(): startRecording() called on an uninitialized AudioRecord.");
        }
        try {
            audioRecord.startRecording();
            this.captureLock.lock();
            this.isCapturing = true;
            this.captureEvent.signal();
            this.captureLock.unlock();
            this.audioManagerMode.acquireMode(this.audioManager);
            this.log.d("startCapturer() exit ->", new Object[0]);
            return true;
        } catch (IllegalStateException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override // com.opentok.android.BaseAudioDevice
    public boolean startRenderer() {
        this.log.d("startRenderer() enter <-", new Object[0]);
        this.log.d("startRenderer() audioFocusActive " + this.audioFocusActive.get() + " sdkHandlesAudioFocus " + this.sdkHandlesAudioFocus, new Object[0]);
        this.startRendererRequested.set(true);
        if (!this.audioFocusActive.get()) {
            this.log.d("startRenderer() audioFocusActive is false. Not starting renderer.", new Object[0]);
            return false;
        }
        if (this.sdkHandlesAudioFocus) {
            this.bluetoothManager.forceInvokeConnectBluetooth();
            if (!this.bluetoothManager.isBluetoothConnected()) {
                if (isWiredHeadSetConnected()) {
                    this.log.d("startRenderer(): Turn off Speaker phone", new Object[0]);
                    this.audioManager.setSpeakerphoneOn(false);
                } else if (getOutputType() == OutputType.SPEAKER_PHONE && !this.bluetoothManager.isBluetoothConnected()) {
                    this.log.d("startRenderer(): Turn on Speaker phone", new Object[0]);
                    this.audioManager.setSpeakerphoneOn(true);
                }
            }
        }
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack == null) {
            throw new IllegalStateException("startRenderer(): play() called on uninitialized AudioTrack.");
        }
        try {
            audioTrack.play();
            this.rendererLock.lock();
            this.isRendering = true;
            this.renderEvent.signal();
            this.rendererLock.unlock();
            if (this.sdkHandlesAudioFocus) {
                this.log.d("startRenderer() acquireMode()", new Object[0]);
                this.audioManagerMode.acquireMode(this.audioManager);
                registerHeadsetReceiver();
            }
            this.log.d("startRenderer() exit ->", new Object[0]);
            return true;
        } catch (IllegalStateException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override // com.opentok.android.BaseAudioDevice
    public boolean stopCapturer() {
        this.log.d("stopCapturer() enter <-", new Object[0]);
        if (this.audioRecord == null) {
            throw new IllegalStateException("stopCapturer(): stop() called on an uninitialized AudioRecord.");
        }
        this.captureLock.lock();
        try {
            try {
                if (this.audioRecord.getRecordingState() == 3) {
                    this.audioRecord.stop();
                }
                this.isCapturing = false;
                this.captureLock.unlock();
                this.audioManagerMode.releaseMode(this.audioManager);
                this.log.d("stopCapturer() exit ->", new Object[0]);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (Throwable th) {
            this.isCapturing = false;
            this.captureLock.unlock();
            throw th;
        }
    }

    @Override // com.opentok.android.BaseAudioDevice
    public boolean stopRenderer() {
        this.log.d("stopRenderer() enter <-", new Object[0]);
        this.log.d("stopRenderer() audioFocusActive " + this.audioFocusActive.get() + " sdkHandlesAudioFocus " + this.sdkHandlesAudioFocus, new Object[0]);
        if (!this.audioFocusActive.get()) {
            return true;
        }
        if (this.audioTrack == null) {
            throw new IllegalStateException("stopRenderer(): stop() called on uninitialized AudioTrack.");
        }
        this.rendererLock.lock();
        try {
            try {
                if (this.audioTrack.getPlayState() == 3) {
                    this.audioTrack.stop();
                }
                this.audioTrack.flush();
                this.isRendering = false;
                this.rendererLock.unlock();
                if (this.sdkHandlesAudioFocus) {
                    this.log.d("stopRenderer() releaseMode()", new Object[0]);
                    this.audioManagerMode.releaseMode(this.audioManager);
                    unregisterHeadsetReceiver();
                }
                this.log.d("stopRenderer() exit ->", new Object[0]);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (Throwable th) {
            this.isRendering = false;
            this.rendererLock.unlock();
            throw th;
        }
    }
}
