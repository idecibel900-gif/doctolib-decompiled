package com.opentok.android;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import com.vonage.webrtc.MediaStreamTrack;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class BluetoothManager {
    public static final int MAX_SCO_CONNECTION_ATTEMPTS = 6;
    public static final int SCO_CONNECTION_ATTEMPT_DELAY = 25;
    DefaultAudioDevice audioDevice;
    Context audioDeviceContext;
    private final AudioManager audioManager;
    private BluetoothAdapter bluetoothAdapter;
    final BroadcastReceiver bluetoothBroadcastReceiver;
    private State bluetoothConnectionState;
    BluetoothDevice bluetoothDevice;
    BluetoothProfile bluetoothProfile;
    private final BluetoothProfile.ServiceListener bluetoothProfileServiceListener;
    private boolean isBluetoothBroadcastReceiverRegistered;
    final OtLog.LogToken log;
    int scoConnectionAttempts;

    private enum State {
        SCO_DISCONNECTED,
        SCO_CONNECTING,
        SCO_CONNECT_ATTEMPT,
        SCO_CONNECTED
    }

    protected BluetoothManager(Context context, DefaultAudioDevice defaultAudioDevice) {
        OtLog.LogToken logToken = new OtLog.LogToken(this);
        this.log = logToken;
        this.scoConnectionAttempts = 0;
        this.bluetoothProfileServiceListener = new BluetoothProfile.ServiceListener() { // from class: com.opentok.android.BluetoothManager.1
            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                synchronized (BluetoothManager.this) {
                    try {
                        if (BluetoothManager.this.hasBluetoothPermission()) {
                            BluetoothManager.this.log.d("BluetoothProfile.ServiceListener.onServiceConnected() enter.", new Object[0]);
                            if (1 == i) {
                                BluetoothManager.this.bluetoothProfile = bluetoothProfile;
                                List<BluetoothDevice> connectedDevices = bluetoothProfile.getConnectedDevices();
                                if (connectedDevices.isEmpty() || 2 != bluetoothProfile.getConnectionState(connectedDevices.get(0))) {
                                    BluetoothManager.this.log.d("No bluetooth headset connected.", new Object[0]);
                                } else {
                                    BluetoothManager.this.bluetoothDevice = connectedDevices.get(0);
                                    BluetoothManager.this.log.d("Connected to bluetooth headset " + BluetoothManager.this.bluetoothDevice.getName(), new Object[0]);
                                    Intent intent = new Intent("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                                    intent.putExtra("android.bluetooth.profile.extra.STATE", 2);
                                    BluetoothManager bluetoothManager = BluetoothManager.this;
                                    bluetoothManager.bluetoothBroadcastReceiver.onReceive(bluetoothManager.audioDeviceContext, intent);
                                }
                            } else {
                                BluetoothManager.this.log.d("profile = " + i, new Object[0]);
                            }
                            BluetoothManager.this.log.d("BluetoothProfile.ServiceListener.onServiceConnected() exit.", new Object[0]);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceDisconnected(int i) {
                synchronized (BluetoothManager.this) {
                    try {
                        BluetoothManager.this.log.d("BluetoothProfile.ServiceListener.onServiceDisconnected() enter.", new Object[0]);
                        if (i != 1) {
                            return;
                        }
                        BluetoothManager bluetoothManager = BluetoothManager.this;
                        bluetoothManager.bluetoothDevice = null;
                        bluetoothManager.bluetoothProfile = null;
                        bluetoothManager.log.d("BluetoothProfile.ServiceListener.onServiceDisconnected() exit.", new Object[0]);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        this.bluetoothBroadcastReceiver = new BroadcastReceiver() { // from class: com.opentok.android.BluetoothManager.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                synchronized (BluetoothManager.this) {
                    try {
                        String action = intent.getAction();
                        if (action == null) {
                            BluetoothManager.this.log.e("bluetoothBroadcastReceiver.onReceive(): error !!", new Object[0]);
                            return;
                        }
                        int iHashCode = action.hashCode();
                        if (iHashCode != -1692127708) {
                            if (iHashCode == 545516589 && action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                                if (intExtra == 0) {
                                    BluetoothManager.this.log.d("bluetoothBroadcastReceiver.onReceive(): BluetoothHeadset.STATE_DISCONNECTED", new Object[0]);
                                    BluetoothManager.this.stopBluetoothSCO();
                                } else if (intExtra == 2) {
                                    BluetoothManager.this.log.d("bluetoothBroadcastReceiver.onReceive(): BluetoothHeadset.STATE_CONNECTED", new Object[0]);
                                    BluetoothManager.this.startBluetoothSCO();
                                } else if (intExtra == 3) {
                                    BluetoothManager.this.log.d("bluetoothBroadcastReceiver.onReceive(): BluetoothHeadset.STATE_DISCONNECTING", new Object[0]);
                                }
                            }
                        } else if (action.equals("android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
                            int intExtra2 = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
                            if (intExtra2 == -1) {
                                BluetoothManager.this.log.d("bluetoothBroadcastReceiver.onReceive(): AudioManager.SCO_AUDIO_STATE_ERROR", new Object[0]);
                            } else if (intExtra2 == 0) {
                                BluetoothManager.this.log.d("bluetoothBroadcastReceiver.onReceive(): AudioManager.SCO_AUDIO_STATE_DISCONNECTED", new Object[0]);
                                if (isInitialStickyBroadcast()) {
                                    BluetoothManager.this.log.d("Ignore STATE_AUDIO_DISCONNECTED initial sticky broadcast.", new Object[0]);
                                    return;
                                }
                                BluetoothManager bluetoothManager = BluetoothManager.this;
                                int i = bluetoothManager.scoConnectionAttempts;
                                if (i == -1 || i >= 6) {
                                    bluetoothManager.setBluetoothState(State.SCO_DISCONNECTED);
                                    BluetoothManager.this.audioDevice.restoreAudioAfterBluetoothDisconnect();
                                } else {
                                    bluetoothManager.log.d("bluetoothBroadcastReceiver.onReceive(): Forcing bluetooth reconnection as it was unexpectedly disconnected, attempt: " + BluetoothManager.this.scoConnectionAttempts, new Object[0]);
                                    BluetoothManager.this.setBluetoothState(State.SCO_CONNECTING);
                                    BluetoothManager.this.tryStartBluetoothSCO();
                                }
                            } else if (intExtra2 == 1) {
                                BluetoothManager.this.log.d("bluetoothBroadcastReceiver.onReceive(): AudioManager.SCO_AUDIO_STATE_CONNECTED", new Object[0]);
                                BluetoothManager.this.setBluetoothState(State.SCO_CONNECTED);
                                BluetoothManager bluetoothManager2 = BluetoothManager.this;
                                if (bluetoothManager2.scoConnectionAttempts == -1) {
                                    bluetoothManager2.stopBluetoothSCO();
                                } else {
                                    bluetoothManager2.setConnectionAttempts(0);
                                    BluetoothManager.this.audioManager.setSpeakerphoneOn(false);
                                }
                            } else if (intExtra2 == 2) {
                                BluetoothManager.this.log.d("bluetoothBroadcastReceiver.onReceive(): AudioManager.SCO_AUDIO_STATE_CONNECTING", new Object[0]);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        logToken.d("BluetoothManager constructor enter.", new Object[0]);
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.audioManager = audioManager;
        if (!audioManager.isBluetoothScoAvailableOffCall()) {
            logToken.e("Bluetooth SCO audio is not available off call", new Object[0]);
            return;
        }
        this.audioDeviceContext = context;
        this.audioDevice = defaultAudioDevice;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.bluetoothAdapter = defaultAdapter;
        if (defaultAdapter == null) {
            logToken.w("Device does not support Bluetooth", new Object[0]);
        } else {
            logToken.d("BluetoothManager constructor exit.", new Object[0]);
        }
    }

    private void audioManagerStartBluetoothSCO() {
        this.log.d("audioManagerStartBluetoothSCO() enter <-", new Object[0]);
        this.audioManager.startBluetoothSco();
        this.log.d("audioManagerStartBluetoothSCO() exit <-", new Object[0]);
    }

    static BluetoothManager create(Context context, DefaultAudioDevice defaultAudioDevice) {
        return new BluetoothManager(context, defaultAudioDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryStartBluetoothSCO$0() {
        if (this.bluetoothConnectionState == State.SCO_CONNECTED) {
            setConnectionAttempts(0);
            return;
        }
        try {
            audioManagerStopBluetoothSCO();
            audioManagerStartBluetoothSCO();
        } catch (NullPointerException e) {
            this.log.e("tryStartBluetoothSco(): " + e.getMessage(), new Object[0]);
        }
    }

    synchronized void audioManagerStopBluetoothSCO() {
        this.log.d("audioManagerStopBluetoothSCO() enter <-", new Object[0]);
        this.audioManager.stopBluetoothSco();
        this.log.d("audioManagerStopBluetoothSCO() exit ->", new Object[0]);
    }

    protected void finalize() throws Throwable {
        BluetoothAdapter bluetoothAdapter;
        super.finalize();
        this.audioManager.setBluetoothScoOn(false);
        BluetoothProfile bluetoothProfile = this.bluetoothProfile;
        if (bluetoothProfile == null || (bluetoothAdapter = this.bluetoothAdapter) == null) {
            return;
        }
        bluetoothAdapter.closeProfileProxy(1, bluetoothProfile);
    }

    synchronized void forceInvokeConnectBluetooth() {
        try {
            if (this.audioDevice == null) {
                return;
            }
            this.log.d("forceInvokeConnectBluetooth() enter", new Object[0]);
            BluetoothAdapter bluetoothAdapter = this.bluetoothAdapter;
            if (bluetoothAdapter != null) {
                bluetoothAdapter.getProfileProxy(this.audioDeviceContext, this.bluetoothProfileServiceListener, 1);
            }
            this.log.d("forceInvokeConnectBluetooth() exit", new Object[0]);
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized BaseAudioDevice.BluetoothState getBluetoothState() {
        this.log.d("getBluetoothState(). Current bluetoothState = " + this.bluetoothConnectionState, new Object[0]);
        if (this.bluetoothConnectionState == State.SCO_CONNECTED) {
            return BaseAudioDevice.BluetoothState.Connected;
        }
        return BaseAudioDevice.BluetoothState.Disconnected;
    }

    boolean hasBluetoothPermission() {
        if (Build.VERSION.SDK_INT < 31 || this.audioDeviceContext.checkSelfPermission("android.permission.BLUETOOTH_CONNECT") == 0) {
            return true;
        }
        this.log.e("Audio may not route through paired Bluetooth device unless the bluetooth permission has been granted explicitly in the App settings.", new Object[0]);
        return false;
    }

    public synchronized boolean isBluetoothConnected() {
        boolean z;
        z = this.bluetoothDevice != null;
        this.log.d("isBluetoothConnected = " + z, new Object[0]);
        return z;
    }

    void onPause() {
        this.log.d("onPause() enter.", new Object[0]);
        this.log.d("onPause() exit.", new Object[0]);
    }

    void onResume() {
        this.log.d("onResume() enter.", new Object[0]);
        forceInvokeConnectBluetooth();
        this.log.d("onResume() exit.", new Object[0]);
    }

    public synchronized void registerBtReceiver() {
        this.log.d("isBluetoothBroadcastReceiverRegistered = " + this.isBluetoothBroadcastReceiverRegistered, new Object[0]);
        if (this.isBluetoothBroadcastReceiverRegistered) {
            return;
        }
        setBluetoothState(State.SCO_DISCONNECTED);
        this.audioManager.setBluetoothScoOn(true);
        audioManagerStartBluetoothSCO();
        this.log.d("registerBtReceiver() enter.", new Object[0]);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
        this.audioDeviceContext.registerReceiver(this.bluetoothBroadcastReceiver, intentFilter);
        this.isBluetoothBroadcastReceiverRegistered = true;
        this.log.d("registerBtReceiver() exit", new Object[0]);
    }

    synchronized void setBluetoothState(State state) {
        this.bluetoothConnectionState = state;
        this.log.d("setBluetoothState(). bluetoothState set to " + this.bluetoothConnectionState, new Object[0]);
    }

    synchronized void setConnectionAttempts(int i) {
        this.scoConnectionAttempts = i;
        this.log.d("setConnectionAttempts(). scoConnectionAttempts set to " + i, new Object[0]);
    }

    synchronized void startBluetoothSCO() {
        if (this.audioDevice.isWiredHeadSetConnected()) {
            this.log.e("Bluetooth cannot be turned on when wired headset is connected.", new Object[0]);
        } else {
            setConnectionAttempts(0);
            tryStartBluetoothSCO();
        }
    }

    synchronized void stopBluetoothSCO() {
        this.log.d("stopBluetoothSCO() enter <-", new Object[0]);
        setConnectionAttempts(-1);
        if (this.bluetoothConnectionState == State.SCO_CONNECT_ATTEMPT) {
            return;
        }
        try {
            audioManagerStopBluetoothSCO();
        } catch (NullPointerException e) {
            this.log.e("stopBluetoothSco(): " + e.getMessage(), new Object[0]);
        }
        this.log.d("stopBluetoothSCO() exit ->", new Object[0]);
    }

    synchronized void tryStartBluetoothSCO() {
        State state;
        this.log.d("tryStartBluetoothSCO() enter <-", new Object[0]);
        State state2 = this.bluetoothConnectionState;
        if (state2 != State.SCO_CONNECTED && state2 != (state = State.SCO_CONNECT_ATTEMPT)) {
            setBluetoothState(state);
            Handler handler = new Handler();
            Runnable runnable = new Runnable() { // from class: com.opentok.android.BluetoothManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$tryStartBluetoothSCO$0();
                }
            };
            int i = this.scoConnectionAttempts;
            handler.postDelayed(runnable, (long) (i == 0 ? 0.0d : Math.pow(2.0d, i) * 25.0d));
            setConnectionAttempts(this.scoConnectionAttempts + 1);
            this.log.d("tryStartBluetoothSCO() exit ->", new Object[0]);
        }
    }

    public synchronized void unregisterBtReceiver() {
        this.log.d("isBluetoothBroadcastReceiverRegistered = " + this.isBluetoothBroadcastReceiverRegistered, new Object[0]);
        if (this.isBluetoothBroadcastReceiverRegistered) {
            this.log.d("unregisterBtReceiver() enter", new Object[0]);
            this.audioDeviceContext.unregisterReceiver(this.bluetoothBroadcastReceiver);
            this.isBluetoothBroadcastReceiverRegistered = false;
            this.log.d("unregisterBtReceiver() exit", new Object[0]);
        }
    }
}
