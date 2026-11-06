package expo.modules.video.records;

import expo.modules.kotlin.records.Field;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lexpo/modules/video/records/AvailableAudioTracksChangedEventPayload;", "Lexpo/modules/video/records/VideoEventPayload;", "availableAudioTracks", "", "Lexpo/modules/video/records/AudioTrack;", "oldAvailableAudioTracks", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getAvailableAudioTracks$annotations", "()V", "getAvailableAudioTracks", "()Ljava/util/List;", "getOldAvailableAudioTracks$annotations", "getOldAvailableAudioTracks", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvailableAudioTracksChangedEventPayload implements VideoEventPayload {
    private final List<AudioTrack> availableAudioTracks;
    private final List<AudioTrack> oldAvailableAudioTracks;

    @Field
    public static /* synthetic */ void getAvailableAudioTracks$annotations() {
    }

    @Field
    public static /* synthetic */ void getOldAvailableAudioTracks$annotations() {
    }

    public AvailableAudioTracksChangedEventPayload(List<AudioTrack> availableAudioTracks, List<AudioTrack> oldAvailableAudioTracks) {
        Intrinsics.checkNotNullParameter(availableAudioTracks, "availableAudioTracks");
        Intrinsics.checkNotNullParameter(oldAvailableAudioTracks, "oldAvailableAudioTracks");
        this.availableAudioTracks = availableAudioTracks;
        this.oldAvailableAudioTracks = oldAvailableAudioTracks;
    }

    public final List<AudioTrack> getAvailableAudioTracks() {
        return this.availableAudioTracks;
    }

    public final List<AudioTrack> getOldAvailableAudioTracks() {
        return this.oldAvailableAudioTracks;
    }
}
