package expo.modules.video.records;

import expo.modules.kotlin.records.Field;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0002\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\n\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lexpo/modules/video/records/IsPlayingEventPayload;", "Lexpo/modules/video/records/VideoEventPayload;", "isPlaying", "", "oldIsPlaying", "<init>", "(ZLjava/lang/Boolean;)V", "isPlaying$annotations", "()V", "()Z", "getOldIsPlaying$annotations", "getOldIsPlaying", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IsPlayingEventPayload implements VideoEventPayload {
    private final boolean isPlaying;
    private final Boolean oldIsPlaying;

    @Field
    public static /* synthetic */ void getOldIsPlaying$annotations() {
    }

    @Field
    public static /* synthetic */ void isPlaying$annotations() {
    }

    public IsPlayingEventPayload(boolean z, Boolean bool) {
        this.isPlaying = z;
        this.oldIsPlaying = bool;
    }

    /* JADX INFO: renamed from: isPlaying, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    public final Boolean getOldIsPlaying() {
        return this.oldIsPlaying;
    }
}
