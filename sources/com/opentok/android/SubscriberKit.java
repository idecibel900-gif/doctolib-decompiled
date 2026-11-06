package com.opentok.android;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import com.opentok.otc.SWIGTYPE_p_otc_stream;
import com.opentok.otc.SWIGTYPE_p_otc_subscriber;
import com.opentok.otc.d;
import com.opentok.otc.e;
import com.opentok.otc.otc_subscriber_callbacks;
import com.opentok.otc.otc_subscriber_rtc_stats_report_cb;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes4.dex */
public class SubscriberKit implements Observer {
    public static final float NO_PREFERRED_FRAMERATE = Float.MAX_VALUE;
    public static final VideoUtils.Size NO_PREFERRED_RESOLUTION;
    public static final String VIDEO_REASON_CODEC_CHANGE = "codecChange";
    public static final String VIDEO_REASON_CODEC_NOT_SUPPORTED = "codecNotSupported";
    public static final String VIDEO_REASON_INTERRUPTION = "videoInterruption";
    public static final String VIDEO_REASON_NONE = "none";
    public static final String VIDEO_REASON_PUBLISH_VIDEO = "publishVideo";
    public static final String VIDEO_REASON_QUALITY = "quality";
    public static final String VIDEO_REASON_RESOLUTION_CHANGE = "resolutionChange";
    public static final String VIDEO_REASON_SUBSCRIBE_TO_VIDEO = "subscribeToVideo";
    private static final SparseArray<String> VideoReasonMap;
    protected AudioLevelListener audioLevelListener;
    protected AudioStatsListener audioStatsListener;
    protected CaptionsListener captionsListener;
    private Handler handler;
    SWIGTYPE_p_otc_subscriber otc_subscriber;
    protected BaseVideoRenderer renderer;
    protected SubscriberRtcStatsReportListener rtcStatsReportListener;
    swig_otc_rtc_stats_report_cb rtc_stats_report_cb;
    protected Session session;
    protected Stream stream;
    protected StreamListener streamListener;
    protected SubscriberListener subscriberListener;
    swig_otc_subscriber_cb subscriber_cb;
    protected VideoListener videoListener;
    protected VideoStatsListener videoStatsListener;
    boolean resumeSubscribeToVideoOnSessionResume = false;
    boolean isPaused = false;
    private final OtLog.LogToken log = new OtLog.LogToken(this);

    public interface AudioLevelListener {
        void onAudioLevelUpdated(SubscriberKit subscriberKit, float f);
    }

    public interface AudioStatsListener {
        void onAudioStats(SubscriberKit subscriberKit, SubscriberAudioStats subscriberAudioStats);
    }

    public static class Builder {
        Context context;
        BaseVideoRenderer renderer;
        Stream stream;

        public Builder(Context context, Stream stream) {
            this.context = context;
            this.stream = stream;
        }

        public SubscriberKit build() {
            return new SubscriberKit(this);
        }

        public Builder renderer(BaseVideoRenderer baseVideoRenderer) {
            this.renderer = baseVideoRenderer;
            return this;
        }
    }

    public interface CaptionsListener {
        void onCaptionText(SubscriberKit subscriberKit, String str, boolean z);
    }

    public static class SenderStats {
        public long connectionEstimatedBandwidth;
        public long connectionMaxAllocatedBitrate;

        public SenderStats(long j, long j2) {
            this.connectionMaxAllocatedBitrate = j;
            this.connectionEstimatedBandwidth = j2;
        }
    }

    public interface StreamListener {
        default void onAudioDisabled(SubscriberKit subscriberKit) {
        }

        default void onAudioEnabled(SubscriberKit subscriberKit) {
        }

        void onDisconnected(SubscriberKit subscriberKit);

        void onReconnected(SubscriberKit subscriberKit);
    }

    public static class SubscriberAudioStats {
        public int audioBytesReceived;
        public int audioPacketsLost;
        public int audioPacketsReceived;
        public SenderStats senderStats;
        public double timeStamp;

        SubscriberAudioStats(int i, int i2, int i3, double d, SenderStats senderStats) {
            this.audioPacketsLost = i;
            this.audioPacketsReceived = i2;
            this.audioBytesReceived = i3;
            this.timeStamp = d;
            this.senderStats = senderStats;
        }
    }

    public interface SubscriberListener {
        void onConnected(SubscriberKit subscriberKit);

        void onDisconnected(SubscriberKit subscriberKit);

        void onError(SubscriberKit subscriberKit, OpentokError opentokError);
    }

    public interface SubscriberRtcStatsReportListener {
        void onRtcStatsReport(SubscriberKit subscriberKit, String str);
    }

    public static class SubscriberVideoStats {
        public long bitrate;
        public String codec;
        public double decodedFrameRate;
        public long freezeCount;
        public int height;
        public long pauseCount;
        public SenderStats senderStats;
        public double timeStamp;
        public long totalBitrate;
        public long totalFreezesDuration;
        public long totalPausesDuration;
        public int videoBytesReceived;
        public int videoPacketsLost;
        public int videoPacketsReceived;
        public int width;

        SubscriberVideoStats(int i, int i2, int i3, double d, SenderStats senderStats, int i4, int i5, double d2, long j, long j2, long j3, long j4, long j5, long j6, String str) {
            this.videoPacketsLost = i;
            this.videoPacketsReceived = i2;
            this.videoBytesReceived = i3;
            this.timeStamp = d;
            this.senderStats = senderStats;
            this.width = i4;
            this.height = i5;
            this.decodedFrameRate = d2;
            this.bitrate = j;
            this.totalBitrate = j2;
            this.pauseCount = j3;
            this.totalPausesDuration = j4;
            this.freezeCount = j5;
            this.totalFreezesDuration = j6;
            this.codec = str;
        }
    }

    public interface VideoListener {
        void onVideoDataReceived(SubscriberKit subscriberKit);

        void onVideoDisableWarning(SubscriberKit subscriberKit);

        void onVideoDisableWarningLifted(SubscriberKit subscriberKit);

        void onVideoDisabled(SubscriberKit subscriberKit, String str);

        void onVideoEnabled(SubscriberKit subscriberKit, String str);
    }

    public interface VideoStatsListener {
        default void onVideoQualityChanged(SubscriberKit subscriberKit, SubscriberVideoStats subscriberVideoStats, String str) {
        }

        void onVideoStats(SubscriberKit subscriberKit, SubscriberVideoStats subscriberVideoStats);
    }

    static class swig_otc_rtc_stats_report_cb extends otc_subscriber_rtc_stats_report_cb {
        public swig_otc_rtc_stats_report_cb(long j) {
            super(j, false);
        }

        public long getCPointer() {
            return otc_subscriber_rtc_stats_report_cb.getCPtr(this);
        }
    }

    static class swig_otc_subscriber_cb extends otc_subscriber_callbacks {
        public swig_otc_subscriber_cb(long j) {
            super(j, false);
        }

        public long getCPointer() {
            return otc_subscriber_callbacks.getCPtr(this);
        }
    }

    static {
        Loader.load();
        NO_PREFERRED_RESOLUTION = new VideoUtils.Size(Integer.MAX_VALUE, Integer.MAX_VALUE);
        VideoReasonMap = new SparseArray<String>() { // from class: com.opentok.android.SubscriberKit.1
            {
                append(0, "none");
                append(1, SubscriberKit.VIDEO_REASON_PUBLISH_VIDEO);
                append(2, SubscriberKit.VIDEO_REASON_SUBSCRIBE_TO_VIDEO);
                append(3, "quality");
                append(4, SubscriberKit.VIDEO_REASON_CODEC_NOT_SUPPORTED);
                append(8, "codecChange");
                append(9, "resolutionChange");
                append(10, SubscriberKit.VIDEO_REASON_INTERRUPTION);
            }
        };
    }

    protected SubscriberKit(Builder builder) {
        if (builder == null) {
            throw new IllegalArgumentException("Builder builder is null.");
        }
        if (builder.renderer == null) {
            throw new IllegalArgumentException("Renderer is null.");
        }
        this.handler = new Handler(Looper.myLooper());
        this.renderer = builder.renderer;
        this.session = null;
        this.subscriber_cb = new swig_otc_subscriber_cb(build_native_subscriber_cb());
        this.otc_subscriber = d.a(builder.stream.getOtc_stream(), this.subscriber_cb);
    }

    private static String getReasonForCodeJNI(int i) {
        String str = VideoReasonMap.get(i);
        return str != null ? str : "Unknown";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAudioDisabledJNI$13() {
        StreamListener streamListener = this.streamListener;
        if (streamListener != null) {
            streamListener.onAudioDisabled(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAudioEnabledJNI$11() {
        StreamListener streamListener = this.streamListener;
        if (streamListener != null) {
            streamListener.onAudioEnabled(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAudioLevelUpdatedJNI$27(float f) {
        AudioLevelListener audioLevelListener = this.audioLevelListener;
        if (audioLevelListener != null) {
            audioLevelListener.onAudioLevelUpdated(this, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAudioStatsJNI$30(SubscriberAudioStats subscriberAudioStats) {
        AudioStatsListener audioStatsListener = this.audioStatsListener;
        if (audioStatsListener != null) {
            audioStatsListener.onAudioStats(this, subscriberAudioStats);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCaptionTextJNI$29(String str, boolean z) {
        CaptionsListener captionsListener = this.captionsListener;
        if (captionsListener != null) {
            captionsListener.onCaptionText(this, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnectedJNI$3() {
        SubscriberListener subscriberListener = this.subscriberListener;
        if (subscriberListener != null) {
            subscriberListener.onConnected(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onErrorJNI$5(OpentokError opentokError) {
        SubscriberListener subscriberListener = this.subscriberListener;
        if (subscriberListener != null) {
            subscriberListener.onError(this, opentokError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRtcStatsReportJNI$1(String str) {
        SubscriberRtcStatsReportListener subscriberRtcStatsReportListener = this.rtcStatsReportListener;
        if (subscriberRtcStatsReportListener != null) {
            subscriberRtcStatsReportListener.onRtcStatsReport(this, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStreamDisconnectedJNI$7() {
        StreamListener streamListener = this.streamListener;
        if (streamListener != null) {
            streamListener.onDisconnected(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStreamReconnectedJNI$9() {
        StreamListener streamListener = this.streamListener;
        if (streamListener != null) {
            streamListener.onReconnected(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onVideoDataReceivedJNI$25() {
        VideoListener videoListener = this.videoListener;
        if (videoListener != null) {
            videoListener.onVideoDataReceived(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onVideoDisableWarningJNI$21() {
        VideoListener videoListener = this.videoListener;
        if (videoListener != null) {
            videoListener.onVideoDisableWarning(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onVideoDisableWarningLiftedJNI$23() {
        VideoListener videoListener = this.videoListener;
        if (videoListener != null) {
            videoListener.onVideoDisableWarningLifted(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onVideoDisabledJNI$15(String str) {
        VideoListener videoListener = this.videoListener;
        if (videoListener != null) {
            videoListener.onVideoDisabled(this, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onVideoDisabledJNI$16() {
        BaseVideoRenderer baseVideoRenderer = this.renderer;
        if (baseVideoRenderer != null) {
            baseVideoRenderer.onVideoPropertiesChanged(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onVideoEnabledJNI$18(String str) {
        VideoListener videoListener = this.videoListener;
        if (videoListener != null) {
            videoListener.onVideoEnabled(this, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onVideoEnabledJNI$19() {
        BaseVideoRenderer baseVideoRenderer = this.renderer;
        if (baseVideoRenderer != null) {
            baseVideoRenderer.onVideoPropertiesChanged(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onVideoQualityChangedJNI$32(SubscriberVideoStats subscriberVideoStats, String str) {
        VideoStatsListener videoStatsListener = this.videoStatsListener;
        if (videoStatsListener != null) {
            videoStatsListener.onVideoQualityChanged(this, subscriberVideoStats, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onVideoStatsJNI$31(SubscriberVideoStats subscriberVideoStats) {
        VideoStatsListener videoStatsListener = this.videoStatsListener;
        if (videoStatsListener != null) {
            videoStatsListener.onVideoStats(this, subscriberVideoStats);
        }
    }

    protected void attachToSession(Session session) {
        this.session = session;
    }

    native long build_native_subscriber_cb();

    native long build_rtc_stats_report_cb();

    @Deprecated
    public void destroy() {
        this.log.d("Destroy(...) called", new Object[0]);
    }

    native void destroy_native_subscriber_cb(long j, long j2);

    protected void detachFromSession(Session session) {
        this.session = null;
    }

    void error(SubscriberKit subscriberKit, int i, String str) {
        throwError(new OpentokError(OpentokError.Domain.SubscriberErrorDomain, i, str));
    }

    protected void finalize() throws Throwable {
        this.log.d("finalize()", new Object[0]);
        SWIGTYPE_p_otc_subscriber sWIGTYPE_p_otc_subscriber = this.otc_subscriber;
        if (sWIGTYPE_p_otc_subscriber != null) {
            d.a(sWIGTYPE_p_otc_subscriber);
            this.otc_subscriber = null;
            swig_otc_rtc_stats_report_cb swig_otc_rtc_stats_report_cbVar = this.rtc_stats_report_cb;
            long cPointer = swig_otc_rtc_stats_report_cbVar != null ? swig_otc_rtc_stats_report_cbVar.getCPointer() : 0L;
            swig_otc_subscriber_cb swig_otc_subscriber_cbVar = this.subscriber_cb;
            if (swig_otc_subscriber_cbVar != null) {
                destroy_native_subscriber_cb(swig_otc_subscriber_cbVar.getCPointer(), cPointer);
            }
        }
        super.finalize();
    }

    public double getAudioVolume() {
        double[] dArr = new double[1];
        d.a(this.otc_subscriber, dArr);
        return dArr[0];
    }

    SWIGTYPE_p_otc_subscriber getOtcSubscriber() {
        return this.otc_subscriber;
    }

    public float getPreferredFrameRate() {
        float[] fArr = new float[1];
        if (d.a(this.otc_subscriber, fArr) == e.c.a()) {
            return fArr[0];
        }
        return -1.0f;
    }

    public VideoUtils.Size getPreferredResolution() {
        long[] jArr = new long[1];
        long[] jArr2 = new long[1];
        return d.a(this.otc_subscriber, jArr, jArr2) == e.c.a() ? new VideoUtils.Size((int) jArr[0], (int) jArr2[0]) : NO_PREFERRED_RESOLUTION;
    }

    public BaseVideoRenderer getRenderer() {
        return this.renderer;
    }

    public void getRtcStatsReport() {
        int iB = d.b(this.otc_subscriber);
        if (iB != e.c.a()) {
            throwError(new OpentokError(OpentokError.Domain.SubscriberErrorDomain, iB, "Error getting stats report"));
        }
    }

    public Session getSession() {
        return new Session(d.c(this.otc_subscriber), false);
    }

    public Stream getStream() {
        SWIGTYPE_p_otc_stream sWIGTYPE_p_otc_streamD = d.d(this.otc_subscriber);
        if (sWIGTYPE_p_otc_streamD == null) {
            return null;
        }
        return new Stream(sWIGTYPE_p_otc_streamD, true);
    }

    public boolean getSubscribeToAudio() {
        return Utils.intToBoolean(d.e(this.otc_subscriber));
    }

    public boolean getSubscribeToCaptions() {
        return Utils.intToBoolean(d.f(this.otc_subscriber));
    }

    public boolean getSubscribeToVideo() {
        return Utils.intToBoolean(d.g(this.otc_subscriber));
    }

    public View getView() {
        BaseVideoRenderer baseVideoRenderer = this.renderer;
        if (baseVideoRenderer != null) {
            return baseVideoRenderer.getView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onAudioDisabled, reason: merged with bridge method [inline-methods] */
    public void lambda$onAudioDisabledJNI$12() {
    }

    void onAudioDisabledJNI() {
        this.log.i("Stream: %s has audio disabled", getStream().getStreamId());
        this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onAudioDisabledJNI$12();
            }
        });
        if (this.streamListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda24
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAudioDisabledJNI$13();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onAudioEnabled, reason: merged with bridge method [inline-methods] */
    public void lambda$onAudioEnabledJNI$10() {
    }

    void onAudioEnabledJNI() {
        this.log.i("Stream: %s has audio enabled", getStream().getStreamId());
        this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onAudioEnabledJNI$10();
            }
        });
        if (this.streamListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAudioEnabledJNI$11();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onAudioLevelUpdated, reason: merged with bridge method [inline-methods] */
    public void lambda$onAudioLevelUpdatedJNI$26(float f) {
    }

    void onAudioLevelUpdatedJNI(final float f) {
        this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onAudioLevelUpdatedJNI$26(f);
            }
        });
        if (this.audioLevelListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAudioLevelUpdatedJNI$27(f);
                }
            });
        }
    }

    void onAudioStatsJNI(final SubscriberAudioStats subscriberAudioStats) {
        if (this.audioStatsListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAudioStatsJNI$30(subscriberAudioStats);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onCaptionText, reason: merged with bridge method [inline-methods] */
    public void lambda$onCaptionTextJNI$28(String str, boolean z) {
    }

    void onCaptionTextJNI(final String str, final boolean z) {
        this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCaptionTextJNI$28(str, z);
            }
        });
        if (this.captionsListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda32
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCaptionTextJNI$29(str, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onConnected, reason: merged with bridge method [inline-methods] */
    public void lambda$onConnectedJNI$2() {
    }

    void onConnectedJNI() {
        this.log.d("onConnected(...) called", new Object[0]);
        this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onConnectedJNI$2();
            }
        });
        if (this.subscriberListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onConnectedJNI$3();
                }
            });
        }
    }

    @Deprecated
    protected void onDisconnected() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onError, reason: merged with bridge method [inline-methods] */
    public void lambda$onErrorJNI$4(OpentokError opentokError) {
    }

    void onErrorJNI(String str, int i) {
        final OpentokError opentokError = new OpentokError(OpentokError.Domain.SubscriberErrorDomain, i, str);
        this.log.d("onError(...) called", new Object[0]);
        this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onErrorJNI$4(opentokError);
            }
        });
        if (this.subscriberListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onErrorJNI$5(opentokError);
                }
            });
        }
    }

    void onFrameJNI(long j) {
        BaseVideoRenderer baseVideoRenderer = this.renderer;
        if (baseVideoRenderer != null) {
            BaseVideoRenderer.Frame frameBuildFrameInstance = baseVideoRenderer.buildFrameInstance();
            frameBuildFrameInstance.copyOtcFrame(j, null);
            this.renderer.onFrame(frameBuildFrameInstance);
        }
    }

    public void onPause() {
        this.log.d("onPause() called", new Object[0]);
        BaseVideoRenderer baseVideoRenderer = this.renderer;
        if (baseVideoRenderer != null) {
            baseVideoRenderer.onPause();
        }
        this.resumeSubscribeToVideoOnSessionResume = getSubscribeToVideo();
        setSubscribeToVideo(false);
        this.isPaused = true;
    }

    public void onResume() {
        this.log.d("onResume() called", new Object[0]);
        if (this.isPaused) {
            this.isPaused = false;
            setSubscribeToVideo(this.resumeSubscribeToVideoOnSessionResume);
            BaseVideoRenderer baseVideoRenderer = this.renderer;
            if (baseVideoRenderer != null) {
                baseVideoRenderer.onResume();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onRtcStatsReport, reason: merged with bridge method [inline-methods] */
    public void lambda$onRtcStatsReportJNI$0(String str) {
    }

    void onRtcStatsReportJNI(final String str) {
        this.log.d("onRtcStatsReportJNI(...) called", new Object[0]);
        this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onRtcStatsReportJNI$0(str);
            }
        });
        if (this.rtcStatsReportListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onRtcStatsReportJNI$1(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onStreamDisconnected, reason: merged with bridge method [inline-methods] */
    public void lambda$onStreamDisconnectedJNI$6() {
    }

    void onStreamDisconnectedJNI() {
        this.log.d("onStreamDisconnected(...) called", new Object[0]);
        this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStreamDisconnectedJNI$6();
            }
        });
        if (this.streamListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStreamDisconnectedJNI$7();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onStreamReconnected, reason: merged with bridge method [inline-methods] */
    public void lambda$onStreamReconnectedJNI$8() {
    }

    void onStreamReconnectedJNI() {
        this.log.d("onStreamReconnected(...) called", new Object[0]);
        this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStreamReconnectedJNI$8();
            }
        });
        if (this.streamListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStreamReconnectedJNI$9();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onVideoDataReceived, reason: merged with bridge method [inline-methods] */
    public void lambda$onVideoDataReceivedJNI$24() {
    }

    void onVideoDataReceivedJNI() {
        this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onVideoDataReceivedJNI$24();
            }
        });
        if (this.videoListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda22
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onVideoDataReceivedJNI$25();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onVideoDisableWarning, reason: merged with bridge method [inline-methods] */
    public void lambda$onVideoDisableWarningJNI$20() {
    }

    void onVideoDisableWarningJNI() {
        this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onVideoDisableWarningJNI$20();
            }
        });
        if (this.videoListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onVideoDisableWarningJNI$21();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onVideoDisableWarningLifted, reason: merged with bridge method [inline-methods] */
    public void lambda$onVideoDisableWarningLiftedJNI$22() {
    }

    void onVideoDisableWarningLiftedJNI() {
        this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onVideoDisableWarningLiftedJNI$22();
            }
        });
        if (this.videoListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onVideoDisableWarningLiftedJNI$23();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onVideoDisabled, reason: merged with bridge method [inline-methods] */
    public void lambda$onVideoDisabledJNI$14(String str) {
    }

    void onVideoDisabledJNI(int i) {
        this.log.d("onVideoDisabled(...) called", new Object[0]);
        final String str = VideoReasonMap.get(i);
        this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onVideoDisabledJNI$14(str);
            }
        });
        if (this.videoListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onVideoDisabledJNI$15(str);
                }
            });
        }
        if (this.renderer != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onVideoDisabledJNI$16();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: onVideoEnabled, reason: merged with bridge method [inline-methods] */
    public void lambda$onVideoEnabledJNI$17(String str) {
    }

    void onVideoEnabledJNI(int i) {
        this.log.d("onVideoEnabled(...) called", new Object[0]);
        final String str = VideoReasonMap.get(i);
        this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onVideoEnabledJNI$17(str);
            }
        });
        if (this.videoListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onVideoEnabledJNI$18(str);
                }
            });
        }
        if (this.renderer != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onVideoEnabledJNI$19();
                }
            });
        }
    }

    void onVideoQualityChangedJNI(final SubscriberVideoStats subscriberVideoStats, final String str) {
        if (this.videoStatsListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onVideoQualityChangedJNI$32(subscriberVideoStats, str);
                }
            });
        }
    }

    void onVideoStatsJNI(final SubscriberVideoStats subscriberVideoStats) {
        if (this.videoStatsListener != null) {
            this.handler.post(new Runnable() { // from class: com.opentok.android.SubscriberKit$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onVideoStatsJNI$31(subscriberVideoStats);
                }
            });
        }
    }

    public void setAudioLevelListener(AudioLevelListener audioLevelListener) {
        this.audioLevelListener = audioLevelListener;
    }

    public void setAudioStatsListener(AudioStatsListener audioStatsListener) {
        this.audioStatsListener = audioStatsListener;
    }

    public void setAudioVolume(double d) {
        d.a(this.otc_subscriber, d);
    }

    public void setCaptionsListener(CaptionsListener captionsListener) {
        this.captionsListener = captionsListener;
    }

    public void setPreferredFrameRate(float f) {
        d.a(this.otc_subscriber, f);
    }

    public void setPreferredResolution(VideoUtils.Size size) {
        d.a(this.otc_subscriber, size.width, size.height);
    }

    @Deprecated
    public void setRenderer(BaseVideoRenderer baseVideoRenderer) {
        this.log.e("Renderer cannot be changed after the subscriber has been built. From 2.17 this method is empty", new Object[0]);
    }

    public void setRtcStatsReportListener(SubscriberRtcStatsReportListener subscriberRtcStatsReportListener) {
        swig_otc_rtc_stats_report_cb swig_otc_rtc_stats_report_cbVar = new swig_otc_rtc_stats_report_cb(build_rtc_stats_report_cb());
        this.rtc_stats_report_cb = swig_otc_rtc_stats_report_cbVar;
        d.a(this.otc_subscriber, swig_otc_rtc_stats_report_cbVar);
        this.rtcStatsReportListener = subscriberRtcStatsReportListener;
    }

    public void setStreamListener(StreamListener streamListener) {
        this.streamListener = streamListener;
    }

    public void setStyle(String str, String str2) {
        BaseVideoRenderer baseVideoRenderer = this.renderer;
        if (baseVideoRenderer != null) {
            baseVideoRenderer.setStyle(str, str2);
        }
    }

    public void setSubscribeToAudio(boolean z) {
        d.a(this.otc_subscriber, Utils.booleanToInt(z));
    }

    public void setSubscribeToCaptions(boolean z) {
        d.b(this.otc_subscriber, Utils.booleanToInt(z));
    }

    public void setSubscribeToVideo(boolean z) {
        d.c(this.otc_subscriber, Utils.booleanToInt(z));
    }

    public void setSubscriberListener(SubscriberListener subscriberListener) {
        this.subscriberListener = subscriberListener;
    }

    public void setVideoListener(VideoListener videoListener) {
        this.videoListener = videoListener;
    }

    public void setVideoStatsListener(VideoStatsListener videoStatsListener) {
        this.videoStatsListener = videoStatsListener;
    }

    void throwError(OpentokError opentokError) {
        onErrorJNI(opentokError.errorMessage, opentokError.errorCode.getErrorCode());
    }

    @Override // java.util.Observer
    @Deprecated
    public void update(Observable observable, Object obj) {
        if ((observable instanceof Session) && (obj instanceof Session.SessionPauseResumeEvent)) {
            if (((Session.SessionPauseResumeEvent) obj).isSessionPaused()) {
                onPause();
            } else {
                onResume();
            }
        }
    }
}
