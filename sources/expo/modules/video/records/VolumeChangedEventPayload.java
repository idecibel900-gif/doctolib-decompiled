package expo.modules.video.records;

import expo.modules.kotlin.records.Field;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lexpo/modules/video/records/VolumeChangedEventPayload;", "Lexpo/modules/video/records/VideoEventPayload;", "volume", "", "oldVolume", "<init>", "(FLjava/lang/Float;)V", "getVolume$annotations", "()V", "getVolume", "()F", "getOldVolume$annotations", "getOldVolume", "()Ljava/lang/Float;", "Ljava/lang/Float;", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VolumeChangedEventPayload implements VideoEventPayload {
    private final Float oldVolume;
    private final float volume;

    @Field
    public static /* synthetic */ void getOldVolume$annotations() {
    }

    @Field
    public static /* synthetic */ void getVolume$annotations() {
    }

    public VolumeChangedEventPayload(float f, Float f2) {
        this.volume = f;
        this.oldVolume = f2;
    }

    public final float getVolume() {
        return this.volume;
    }

    public final Float getOldVolume() {
        return this.oldVolume;
    }
}
