package expo.modules.video.records;

import expo.modules.kotlin.records.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR$\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0016\u0012\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001c\u0012\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010¨\u0006 "}, d2 = {"Lexpo/modules/video/records/TimeUpdate;", "Lexpo/modules/video/records/VideoEventPayload;", "currentTime", "", "currentOffsetFromLive", "", "currentLiveTimestamp", "", "bufferedPosition", "<init>", "(DLjava/lang/Float;Ljava/lang/Long;D)V", "getCurrentTime$annotations", "()V", "getCurrentTime", "()D", "setCurrentTime", "(D)V", "getCurrentOffsetFromLive$annotations", "getCurrentOffsetFromLive", "()Ljava/lang/Float;", "setCurrentOffsetFromLive", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getCurrentLiveTimestamp$annotations", "getCurrentLiveTimestamp", "()Ljava/lang/Long;", "setCurrentLiveTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getBufferedPosition$annotations", "getBufferedPosition", "setBufferedPosition", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeUpdate implements VideoEventPayload {
    private double bufferedPosition;
    private Long currentLiveTimestamp;
    private Float currentOffsetFromLive;
    private double currentTime;

    @Field
    public static /* synthetic */ void getBufferedPosition$annotations() {
    }

    @Field
    public static /* synthetic */ void getCurrentLiveTimestamp$annotations() {
    }

    @Field
    public static /* synthetic */ void getCurrentOffsetFromLive$annotations() {
    }

    @Field
    public static /* synthetic */ void getCurrentTime$annotations() {
    }

    public TimeUpdate(double d, Float f, Long l, double d2) {
        this.currentTime = d;
        this.currentOffsetFromLive = f;
        this.currentLiveTimestamp = l;
        this.bufferedPosition = d2;
    }

    public /* synthetic */ TimeUpdate(double d, Float f, Long l, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0d : d, f, l, (i & 8) != 0 ? 0.0d : d2);
    }

    public final double getCurrentTime() {
        return this.currentTime;
    }

    public final void setCurrentTime(double d) {
        this.currentTime = d;
    }

    public final Float getCurrentOffsetFromLive() {
        return this.currentOffsetFromLive;
    }

    public final void setCurrentOffsetFromLive(Float f) {
        this.currentOffsetFromLive = f;
    }

    public final Long getCurrentLiveTimestamp() {
        return this.currentLiveTimestamp;
    }

    public final void setCurrentLiveTimestamp(Long l) {
        this.currentLiveTimestamp = l;
    }

    public final double getBufferedPosition() {
        return this.bufferedPosition;
    }

    public final void setBufferedPosition(double d) {
        this.bufferedPosition = d;
    }
}
