package expo.modules.video.records;

import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.SeekParameters;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.video.player.VideoPlayer;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0017"}, d2 = {"Lexpo/modules/video/records/SeekTolerance;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "toleranceBefore", "", "toleranceAfter", "<init>", "(DD)V", "getToleranceBefore$annotations", "()V", "getToleranceBefore", "()D", "setToleranceBefore", "(D)V", "getToleranceAfter$annotations", "getToleranceAfter", "setToleranceAfter", "applyToPlayer", "", "videoPlayer", "Lexpo/modules/video/player/VideoPlayer;", "toSeekParameters", "Landroidx/media3/exoplayer/SeekParameters;", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SeekTolerance implements Record, Serializable {
    private double toleranceAfter;
    private double toleranceBefore;

    public SeekTolerance() {
        this(0.0d, 0.0d, 3, null);
    }

    @Field
    public static /* synthetic */ void getToleranceAfter$annotations() {
    }

    @Field
    public static /* synthetic */ void getToleranceBefore$annotations() {
    }

    public SeekTolerance(double d, double d2) {
        this.toleranceBefore = d;
        this.toleranceAfter = d2;
    }

    public /* synthetic */ SeekTolerance(double d, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2);
    }

    public final double getToleranceBefore() {
        return this.toleranceBefore;
    }

    public final void setToleranceBefore(double d) {
        this.toleranceBefore = d;
    }

    public final double getToleranceAfter() {
        return this.toleranceAfter;
    }

    public final void setToleranceAfter(double d) {
        this.toleranceAfter = d;
    }

    public final void applyToPlayer(VideoPlayer videoPlayer) {
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        videoPlayer.getPlayer().setSeekParameters(toSeekParameters());
    }

    private final SeekParameters toSeekParameters() {
        double d = 1000;
        return new SeekParameters(Util.msToUs((long) (this.toleranceBefore * d)), Util.msToUs((long) (this.toleranceAfter * d)));
    }
}
