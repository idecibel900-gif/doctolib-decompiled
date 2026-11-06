package expo.modules.video.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0012\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lexpo/modules/video/records/BufferOptions;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "preferredForwardBufferDuration", "", "maxBufferBytes", "", "prioritizeTimeOverSizeThreshold", "", "minBufferForPlayback", "<init>", "(Ljava/lang/Double;JZD)V", "getPreferredForwardBufferDuration$annotations", "()V", "getPreferredForwardBufferDuration", "()Ljava/lang/Double;", "setPreferredForwardBufferDuration", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getMaxBufferBytes$annotations", "getMaxBufferBytes", "()J", "setMaxBufferBytes", "(J)V", "getPrioritizeTimeOverSizeThreshold$annotations", "getPrioritizeTimeOverSizeThreshold", "()Z", "setPrioritizeTimeOverSizeThreshold", "(Z)V", "getMinBufferForPlayback$annotations", "getMinBufferForPlayback", "()D", "setMinBufferForPlayback", "(D)V", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BufferOptions implements Record, Serializable {
    private long maxBufferBytes;
    private double minBufferForPlayback;
    private Double preferredForwardBufferDuration;
    private boolean prioritizeTimeOverSizeThreshold;

    public BufferOptions() {
        this(null, 0L, false, 0.0d, 15, null);
    }

    @Field
    public static /* synthetic */ void getMaxBufferBytes$annotations() {
    }

    @Field
    public static /* synthetic */ void getMinBufferForPlayback$annotations() {
    }

    @Field
    public static /* synthetic */ void getPreferredForwardBufferDuration$annotations() {
    }

    @Field
    public static /* synthetic */ void getPrioritizeTimeOverSizeThreshold$annotations() {
    }

    public BufferOptions(Double d, long j, boolean z, double d2) {
        this.preferredForwardBufferDuration = d;
        this.maxBufferBytes = j;
        this.prioritizeTimeOverSizeThreshold = z;
        this.minBufferForPlayback = d2;
    }

    public /* synthetic */ BufferOptions(Double d, long j, boolean z, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? false : z, (i & 8) != 0 ? 1.0d : d2);
    }

    public final Double getPreferredForwardBufferDuration() {
        return this.preferredForwardBufferDuration;
    }

    public final void setPreferredForwardBufferDuration(Double d) {
        this.preferredForwardBufferDuration = d;
    }

    public final long getMaxBufferBytes() {
        return this.maxBufferBytes;
    }

    public final void setMaxBufferBytes(long j) {
        this.maxBufferBytes = j;
    }

    public final boolean getPrioritizeTimeOverSizeThreshold() {
        return this.prioritizeTimeOverSizeThreshold;
    }

    public final void setPrioritizeTimeOverSizeThreshold(boolean z) {
        this.prioritizeTimeOverSizeThreshold = z;
    }

    public final double getMinBufferForPlayback() {
        return this.minBufferForPlayback;
    }

    public final void setMinBufferForPlayback(double d) {
        this.minBufferForPlayback = d;
    }
}
