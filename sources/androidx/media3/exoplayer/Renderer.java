package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;

/* JADX INFO: loaded from: classes.dex */
public interface Renderer extends PlayerMessage.Target {

    public interface WakeupListener {
        void onSleep();

        void onWakeup();
    }

    void disable();

    void enable(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j, boolean z, boolean z2, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId);

    default void enableMayRenderStartOfStream() {
    }

    RendererCapabilities getCapabilities();

    MediaClock getMediaClock();

    String getName();

    long getReadingPositionUs();

    int getState();

    SampleStream getStream();

    int getTrackType();

    boolean hasReadStreamToEnd();

    void init(int i, PlayerId playerId, Clock clock);

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReady();

    void maybeThrowStreamError();

    void release();

    void render(long j, long j2);

    void replaceStream(Format[] formatArr, SampleStream sampleStream, long j, long j2, MediaSource.MediaPeriodId mediaPeriodId);

    void reset();

    void resetPosition(long j);

    void setCurrentStreamFinal();

    default void setPlaybackSpeed(float f, float f2) {
    }

    void setTimeline(Timeline timeline);

    void start();

    void stop();

    default long getDurationToProgressUs(long j, long j2) {
        if (getState() == 1) {
            return (isReady() || isEnded()) ? 1000000L : 10000L;
        }
        return 10000L;
    }
}
