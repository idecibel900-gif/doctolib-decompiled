package expo.modules.video.records;

import com.google.firebase.messaging.Constants;
import expo.modules.kotlin.records.Field;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lexpo/modules/video/records/SourceChangedEventPayload;", "Lexpo/modules/video/records/VideoEventPayload;", Constants.ScionAnalytics.PARAM_SOURCE, "Lexpo/modules/video/records/VideoSource;", "oldSource", "<init>", "(Lexpo/modules/video/records/VideoSource;Lexpo/modules/video/records/VideoSource;)V", "getSource$annotations", "()V", "getSource", "()Lexpo/modules/video/records/VideoSource;", "getOldSource$annotations", "getOldSource", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SourceChangedEventPayload implements VideoEventPayload {
    private final VideoSource oldSource;
    private final VideoSource source;

    @Field
    public static /* synthetic */ void getOldSource$annotations() {
    }

    @Field
    public static /* synthetic */ void getSource$annotations() {
    }

    public SourceChangedEventPayload(VideoSource videoSource, VideoSource videoSource2) {
        this.source = videoSource;
        this.oldSource = videoSource2;
    }

    public final VideoSource getSource() {
        return this.source;
    }

    public final VideoSource getOldSource() {
        return this.oldSource;
    }
}
