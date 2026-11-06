package expo.modules.video.records;

import expo.modules.kotlin.records.Field;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0018R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0018¨\u0006\u001d"}, d2 = {"Lexpo/modules/video/records/VideoSourceLoadedEventPayload;", "Lexpo/modules/video/records/VideoEventPayload;", "videoSource", "Lexpo/modules/video/records/VideoSource;", "duration", "", "availableVideoTracks", "", "Lexpo/modules/video/records/VideoTrack;", "availableSubtitleTracks", "Lexpo/modules/video/records/SubtitleTrack;", "availableAudioTracks", "Lexpo/modules/video/records/AudioTrack;", "<init>", "(Lexpo/modules/video/records/VideoSource;DLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getVideoSource$annotations", "()V", "getVideoSource", "()Lexpo/modules/video/records/VideoSource;", "getDuration$annotations", "getDuration", "()D", "getAvailableVideoTracks$annotations", "getAvailableVideoTracks", "()Ljava/util/List;", "getAvailableSubtitleTracks$annotations", "getAvailableSubtitleTracks", "getAvailableAudioTracks$annotations", "getAvailableAudioTracks", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoSourceLoadedEventPayload implements VideoEventPayload {
    private final List<AudioTrack> availableAudioTracks;
    private final List<SubtitleTrack> availableSubtitleTracks;
    private final List<VideoTrack> availableVideoTracks;
    private final double duration;
    private final VideoSource videoSource;

    @Field
    public static /* synthetic */ void getAvailableAudioTracks$annotations() {
    }

    @Field
    public static /* synthetic */ void getAvailableSubtitleTracks$annotations() {
    }

    @Field
    public static /* synthetic */ void getAvailableVideoTracks$annotations() {
    }

    @Field
    public static /* synthetic */ void getDuration$annotations() {
    }

    @Field
    public static /* synthetic */ void getVideoSource$annotations() {
    }

    public VideoSourceLoadedEventPayload(VideoSource videoSource, double d, List<VideoTrack> availableVideoTracks, List<SubtitleTrack> availableSubtitleTracks, List<AudioTrack> availableAudioTracks) {
        Intrinsics.checkNotNullParameter(availableVideoTracks, "availableVideoTracks");
        Intrinsics.checkNotNullParameter(availableSubtitleTracks, "availableSubtitleTracks");
        Intrinsics.checkNotNullParameter(availableAudioTracks, "availableAudioTracks");
        this.videoSource = videoSource;
        this.duration = d;
        this.availableVideoTracks = availableVideoTracks;
        this.availableSubtitleTracks = availableSubtitleTracks;
        this.availableAudioTracks = availableAudioTracks;
    }

    public final VideoSource getVideoSource() {
        return this.videoSource;
    }

    public final double getDuration() {
        return this.duration;
    }

    public final List<VideoTrack> getAvailableVideoTracks() {
        return this.availableVideoTracks;
    }

    public final List<SubtitleTrack> getAvailableSubtitleTracks() {
        return this.availableSubtitleTracks;
    }

    public final List<AudioTrack> getAvailableAudioTracks() {
        return this.availableAudioTracks;
    }
}
