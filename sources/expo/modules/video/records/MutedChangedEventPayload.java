package expo.modules.video.records;

import expo.modules.kotlin.records.Field;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lexpo/modules/video/records/MutedChangedEventPayload;", "Lexpo/modules/video/records/VideoEventPayload;", "muted", "", "oldMuted", "<init>", "(ZLjava/lang/Boolean;)V", "getMuted$annotations", "()V", "getMuted", "()Z", "getOldMuted$annotations", "getOldMuted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MutedChangedEventPayload implements VideoEventPayload {
    private final boolean muted;
    private final Boolean oldMuted;

    @Field
    public static /* synthetic */ void getMuted$annotations() {
    }

    @Field
    public static /* synthetic */ void getOldMuted$annotations() {
    }

    public MutedChangedEventPayload(boolean z, Boolean bool) {
        this.muted = z;
        this.oldMuted = bool;
    }

    public final boolean getMuted() {
        return this.muted;
    }

    public final Boolean getOldMuted() {
        return this.oldMuted;
    }
}
