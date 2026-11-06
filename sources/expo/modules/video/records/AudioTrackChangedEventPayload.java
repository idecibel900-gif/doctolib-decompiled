package expo.modules.video.records;

import expo.modules.kotlin.records.Field;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lexpo/modules/video/records/AudioTrackChangedEventPayload;", "Lexpo/modules/video/records/VideoEventPayload;", "audioTrack", "Lexpo/modules/video/records/AudioTrack;", "oldAudioTrack", "<init>", "(Lexpo/modules/video/records/AudioTrack;Lexpo/modules/video/records/AudioTrack;)V", "getAudioTrack$annotations", "()V", "getAudioTrack", "()Lexpo/modules/video/records/AudioTrack;", "getOldAudioTrack$annotations", "getOldAudioTrack", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioTrackChangedEventPayload implements VideoEventPayload {
    private final AudioTrack audioTrack;
    private final AudioTrack oldAudioTrack;

    @Field
    public static /* synthetic */ void getAudioTrack$annotations() {
    }

    @Field
    public static /* synthetic */ void getOldAudioTrack$annotations() {
    }

    public AudioTrackChangedEventPayload(AudioTrack audioTrack, AudioTrack audioTrack2) {
        this.audioTrack = audioTrack;
        this.oldAudioTrack = audioTrack2;
    }

    public final AudioTrack getAudioTrack() {
        return this.audioTrack;
    }

    public final AudioTrack getOldAudioTrack() {
        return this.oldAudioTrack;
    }
}
