package expo.modules.video.records;

import androidx.media3.exoplayer.ScrubbingModeParameters;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.video.player.VideoPlayer;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\"H\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R$\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R$\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010¨\u0006#"}, d2 = {"Lexpo/modules/video/records/ScrubbingModeOptions;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "scrubbingModeEnabled", "", "increaseCodecOperatingRate", "enableDynamicScheduling", "useDecodeOnlyFlag", "allowSkippingMediaCodecFlush", "<init>", "(ZZZZZ)V", "getScrubbingModeEnabled$annotations", "()V", "getScrubbingModeEnabled", "()Z", "setScrubbingModeEnabled", "(Z)V", "getIncreaseCodecOperatingRate$annotations", "getIncreaseCodecOperatingRate", "setIncreaseCodecOperatingRate", "getEnableDynamicScheduling$annotations", "getEnableDynamicScheduling", "setEnableDynamicScheduling", "getUseDecodeOnlyFlag$annotations", "getUseDecodeOnlyFlag", "setUseDecodeOnlyFlag", "getAllowSkippingMediaCodecFlush$annotations", "getAllowSkippingMediaCodecFlush", "setAllowSkippingMediaCodecFlush", "applyToPlayer", "", "videoPlayer", "Lexpo/modules/video/player/VideoPlayer;", "toScrubbingModeParameters", "Landroidx/media3/exoplayer/ScrubbingModeParameters;", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScrubbingModeOptions implements Record, Serializable {
    private boolean allowSkippingMediaCodecFlush;
    private boolean enableDynamicScheduling;
    private boolean increaseCodecOperatingRate;
    private boolean scrubbingModeEnabled;
    private boolean useDecodeOnlyFlag;

    public ScrubbingModeOptions() {
        this(false, false, false, false, false, 31, null);
    }

    @Field
    public static /* synthetic */ void getAllowSkippingMediaCodecFlush$annotations() {
    }

    @Field
    public static /* synthetic */ void getEnableDynamicScheduling$annotations() {
    }

    @Field
    public static /* synthetic */ void getIncreaseCodecOperatingRate$annotations() {
    }

    @Field
    public static /* synthetic */ void getScrubbingModeEnabled$annotations() {
    }

    @Field
    public static /* synthetic */ void getUseDecodeOnlyFlag$annotations() {
    }

    public ScrubbingModeOptions(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.scrubbingModeEnabled = z;
        this.increaseCodecOperatingRate = z2;
        this.enableDynamicScheduling = z3;
        this.useDecodeOnlyFlag = z4;
        this.allowSkippingMediaCodecFlush = z5;
    }

    public /* synthetic */ ScrubbingModeOptions(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? true : z4, (i & 16) != 0 ? true : z5);
    }

    public final boolean getScrubbingModeEnabled() {
        return this.scrubbingModeEnabled;
    }

    public final void setScrubbingModeEnabled(boolean z) {
        this.scrubbingModeEnabled = z;
    }

    public final boolean getIncreaseCodecOperatingRate() {
        return this.increaseCodecOperatingRate;
    }

    public final void setIncreaseCodecOperatingRate(boolean z) {
        this.increaseCodecOperatingRate = z;
    }

    public final boolean getEnableDynamicScheduling() {
        return this.enableDynamicScheduling;
    }

    public final void setEnableDynamicScheduling(boolean z) {
        this.enableDynamicScheduling = z;
    }

    public final boolean getUseDecodeOnlyFlag() {
        return this.useDecodeOnlyFlag;
    }

    public final void setUseDecodeOnlyFlag(boolean z) {
        this.useDecodeOnlyFlag = z;
    }

    public final boolean getAllowSkippingMediaCodecFlush() {
        return this.allowSkippingMediaCodecFlush;
    }

    public final void setAllowSkippingMediaCodecFlush(boolean z) {
        this.allowSkippingMediaCodecFlush = z;
    }

    public final void applyToPlayer(VideoPlayer videoPlayer) {
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        videoPlayer.getPlayer().setScrubbingModeEnabled(this.scrubbingModeEnabled);
        videoPlayer.getPlayer().setScrubbingModeParameters(toScrubbingModeParameters());
    }

    private final ScrubbingModeParameters toScrubbingModeParameters() {
        ScrubbingModeParameters scrubbingModeParametersBuild = new ScrubbingModeParameters.Builder().setUseDecodeOnlyFlag(this.useDecodeOnlyFlag).setAllowSkippingMediaCodecFlush(this.allowSkippingMediaCodecFlush).setShouldIncreaseCodecOperatingRate(this.increaseCodecOperatingRate).setShouldEnableDynamicScheduling(this.enableDynamicScheduling).build();
        Intrinsics.checkNotNullExpressionValue(scrubbingModeParametersBuild, "build(...)");
        return scrubbingModeParametersBuild;
    }
}
