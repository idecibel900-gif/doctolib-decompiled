package io.sentry;

import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import io.sentry.protocol.SdkVersion;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.SampleRateUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryReplayOptions extends SentryMaskingOptions {
    private static final List DEFAULT_HEADERS = Collections.unmodifiableList(Arrays.asList("Content-Type", "Content-Length", "Accept"));
    private boolean networkCaptureBodies;
    private List networkDetailAllowUrls;
    private List networkDetailDenyUrls;
    private List networkRequestHeaders;
    private List networkResponseHeaders;
    private Double onErrorSampleRate;
    private SdkVersion sdkVersion;
    private Double sessionSampleRate;
    private volatile boolean customMaskingTracked = false;
    private SentryReplayQuality quality = SentryReplayQuality.MEDIUM;
    private int frameRate = 1;
    private long errorReplayDuration = HTTPTimeoutManager.DEFAULT_TIMEOUT_MS;
    private long sessionSegmentDuration = HTTPTimeoutManager.SUPPORTED_FALLBACK_TIMEOUT_MS;
    private long sessionDuration = 3600000;
    private boolean trackConfiguration = true;
    private boolean debug = false;
    private ScreenshotStrategyType screenshotStrategy = ScreenshotStrategyType.PIXEL_COPY;
    private boolean captureSurfaceViews = false;

    public interface BeforeErrorSamplingCallback {
    }

    public interface ReplayFrameObserver {
    }

    public BeforeErrorSamplingCallback getBeforeErrorSampling() {
        return null;
    }

    public ReplayFrameObserver getFrameObserver() {
        return null;
    }

    public enum SentryReplayQuality {
        LOW(0.8f, 50000, 10),
        MEDIUM(1.0f, 75000, 30),
        HIGH(1.0f, 100000, 50);

        public final int bitRate;
        public final int screenshotQuality;
        public final float sizeScale;

        SentryReplayQuality(float f, int i, int i2) {
            this.sizeScale = f;
            this.bitRate = i;
            this.screenshotQuality = i2;
        }

        public String serializedName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

    public static List getNetworkDetailsDefaultHeaders() {
        return DEFAULT_HEADERS;
    }

    public SentryReplayOptions(boolean z, SdkVersion sdkVersion) {
        List list = Collections.EMPTY_LIST;
        this.networkDetailAllowUrls = list;
        this.networkDetailDenyUrls = list;
        this.networkCaptureBodies = true;
        List list2 = DEFAULT_HEADERS;
        this.networkRequestHeaders = list2;
        this.networkResponseHeaders = list2;
        if (z) {
            return;
        }
        this.maskViewClasses.add("android.widget.TextView");
        this.maskViewClasses.add("android.widget.ImageView");
        this.maskViewClasses.add("android.webkit.WebView");
        this.maskViewClasses.add("android.widget.VideoView");
        this.maskViewClasses.add("androidx.camera.view.PreviewView");
        this.maskViewClasses.add("androidx.media3.ui.PlayerView");
        this.maskViewClasses.add("com.google.android.exoplayer2.ui.PlayerView");
        this.maskViewClasses.add("com.google.android.exoplayer2.ui.StyledPlayerView");
        this.sdkVersion = sdkVersion;
    }

    public Double getOnErrorSampleRate() {
        return this.onErrorSampleRate;
    }

    public boolean isSessionReplayEnabled() {
        return getSessionSampleRate() != null && getSessionSampleRate().doubleValue() > 0.0d;
    }

    public void setOnErrorSampleRate(Double d) {
        if (!SampleRateUtils.isValidSampleRate(d)) {
            throw new IllegalArgumentException("The value " + d + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
        }
        this.onErrorSampleRate = d;
    }

    public Double getSessionSampleRate() {
        return this.sessionSampleRate;
    }

    public boolean isSessionReplayForErrorsEnabled() {
        return getOnErrorSampleRate() != null && getOnErrorSampleRate().doubleValue() > 0.0d;
    }

    public void setSessionSampleRate(Double d) {
        if (!SampleRateUtils.isValidSampleRate(d)) {
            throw new IllegalArgumentException("The value " + d + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
        }
        this.sessionSampleRate = d;
    }

    @Override // io.sentry.SentryMaskingOptions
    public void setMaskAllText(boolean z) {
        if (!z) {
            trackCustomMasking();
        }
        super.setMaskAllText(z);
    }

    @Override // io.sentry.SentryMaskingOptions
    public void setMaskAllImages(boolean z) {
        if (!z) {
            trackCustomMasking();
        }
        super.setMaskAllImages(z);
    }

    @Override // io.sentry.SentryMaskingOptions
    public void addMaskViewClass(String str) {
        trackCustomMasking();
        super.addMaskViewClass(str);
    }

    public SentryReplayQuality getQuality() {
        return this.quality;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public long getErrorReplayDuration() {
        return this.errorReplayDuration;
    }

    public long getSessionSegmentDuration() {
        return this.sessionSegmentDuration;
    }

    public long getSessionDuration() {
        return this.sessionDuration;
    }

    @Override // io.sentry.SentryMaskingOptions
    public void trackCustomMasking() {
        if (this.customMaskingTracked) {
            return;
        }
        this.customMaskingTracked = true;
        IntegrationUtils.addIntegrationToSdkVersion("ReplayCustomMasking");
    }

    public boolean isTrackConfiguration() {
        return this.trackConfiguration;
    }

    public SdkVersion getSdkVersion() {
        return this.sdkVersion;
    }

    public void setSdkVersion(SdkVersion sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public ScreenshotStrategyType getScreenshotStrategy() {
        return this.screenshotStrategy;
    }

    public void setScreenshotStrategy(ScreenshotStrategyType screenshotStrategyType) {
        this.screenshotStrategy = screenshotStrategyType;
    }

    public boolean isCaptureSurfaceViews() {
        return this.captureSurfaceViews;
    }

    public void setCaptureSurfaceViews(boolean z) {
        this.captureSurfaceViews = z;
    }

    public List getNetworkDetailAllowUrls() {
        return this.networkDetailAllowUrls;
    }

    public void setNetworkDetailAllowUrls(List list) {
        this.networkDetailAllowUrls = Collections.unmodifiableList(new ArrayList(list));
    }

    public List getNetworkDetailDenyUrls() {
        return this.networkDetailDenyUrls;
    }

    public void setNetworkDetailDenyUrls(List list) {
        this.networkDetailDenyUrls = Collections.unmodifiableList(new ArrayList(list));
    }

    public boolean isNetworkCaptureBodies() {
        return this.networkCaptureBodies;
    }

    public void setNetworkCaptureBodies(boolean z) {
        this.networkCaptureBodies = z;
    }

    public List getNetworkRequestHeaders() {
        return this.networkRequestHeaders;
    }

    public void setNetworkRequestHeaders(List list) {
        this.networkRequestHeaders = mergeHeaders(DEFAULT_HEADERS, list);
    }

    public List getNetworkResponseHeaders() {
        return this.networkResponseHeaders;
    }

    public void setNetworkResponseHeaders(List list) {
        this.networkResponseHeaders = mergeHeaders(DEFAULT_HEADERS, list);
    }

    private static List mergeHeaders(List list, List list2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(list);
        linkedHashSet.addAll(list2);
        return Collections.unmodifiableList(new ArrayList(linkedHashSet));
    }
}
