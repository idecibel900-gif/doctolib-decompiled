package expo.modules.video.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lexpo/modules/video/records/PlayerBuilderOptions;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "seekBackwardIncrement", "Lkotlin/time/Duration;", "seekForwardIncrement", "<init>", "(Lkotlin/time/Duration;Lkotlin/time/Duration;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSeekBackwardIncrement-FghU774$annotations", "()V", "getSeekBackwardIncrement-FghU774", "()Lkotlin/time/Duration;", "setSeekBackwardIncrement-BwNAW2A", "(Lkotlin/time/Duration;)V", "getSeekForwardIncrement-FghU774$annotations", "getSeekForwardIncrement-FghU774", "setSeekForwardIncrement-BwNAW2A", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlayerBuilderOptions implements Record, Serializable {
    private Duration seekBackwardIncrement;
    private Duration seekForwardIncrement;

    public /* synthetic */ PlayerBuilderOptions(Duration duration, Duration duration2, DefaultConstructorMarker defaultConstructorMarker) {
        this(duration, duration2);
    }

    @Field
    /* JADX INFO: renamed from: getSeekBackwardIncrement-FghU774$annotations, reason: not valid java name */
    public static /* synthetic */ void m5014getSeekBackwardIncrementFghU774$annotations() {
    }

    @Field
    /* JADX INFO: renamed from: getSeekForwardIncrement-FghU774$annotations, reason: not valid java name */
    public static /* synthetic */ void m5015getSeekForwardIncrementFghU774$annotations() {
    }

    private PlayerBuilderOptions(Duration duration, Duration duration2) {
        this.seekBackwardIncrement = duration;
        this.seekForwardIncrement = duration2;
    }

    public /* synthetic */ PlayerBuilderOptions(Duration duration, Duration duration2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : duration, (i & 2) != 0 ? null : duration2, null);
    }

    /* JADX INFO: renamed from: getSeekBackwardIncrement-FghU774, reason: not valid java name and from getter */
    public final Duration getSeekBackwardIncrement() {
        return this.seekBackwardIncrement;
    }

    /* JADX INFO: renamed from: setSeekBackwardIncrement-BwNAW2A, reason: not valid java name */
    public final void m5018setSeekBackwardIncrementBwNAW2A(Duration duration) {
        this.seekBackwardIncrement = duration;
    }

    /* JADX INFO: renamed from: getSeekForwardIncrement-FghU774, reason: not valid java name and from getter */
    public final Duration getSeekForwardIncrement() {
        return this.seekForwardIncrement;
    }

    /* JADX INFO: renamed from: setSeekForwardIncrement-BwNAW2A, reason: not valid java name */
    public final void m5019setSeekForwardIncrementBwNAW2A(Duration duration) {
        this.seekForwardIncrement = duration;
    }
}
