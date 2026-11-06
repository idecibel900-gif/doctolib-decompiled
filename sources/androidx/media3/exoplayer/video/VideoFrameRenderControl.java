package androidx.media3.exoplayer.video;

import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.TimedValueQueue;

/* JADX INFO: loaded from: classes.dex */
final class VideoFrameRenderControl {
    private final FrameRenderer frameRenderer;
    private long outputStreamStartPositionUs;
    private final VideoFrameReleaseControl videoFrameReleaseControl;
    private final VideoFrameReleaseControl.FrameReleaseInfo videoFrameReleaseInfo = new VideoFrameReleaseControl.FrameReleaseInfo();
    private final TimedValueQueue videoSizes = new TimedValueQueue();
    private final TimedValueQueue streamStartPositionsUs = new TimedValueQueue();
    private final LongArrayQueue presentationTimestampsUs = new LongArrayQueue();
    private long latestInputPresentationTimeUs = -9223372036854775807L;
    private VideoSize outputVideoSize = VideoSize.UNKNOWN;
    private long latestOutputPresentationTimeUs = -9223372036854775807L;
    private long lastPresentationTimeUs = -9223372036854775807L;

    interface FrameRenderer {
        void dropFrame();

        void onVideoSizeChanged(VideoSize videoSize);

        void renderFrame(long j, long j2, boolean z);
    }

    public VideoFrameRenderControl(FrameRenderer frameRenderer, VideoFrameReleaseControl videoFrameReleaseControl) {
        this.frameRenderer = frameRenderer;
        this.videoFrameReleaseControl = videoFrameReleaseControl;
    }

    public void flush() {
        this.presentationTimestampsUs.clear();
        this.latestInputPresentationTimeUs = -9223372036854775807L;
        this.latestOutputPresentationTimeUs = -9223372036854775807L;
        this.lastPresentationTimeUs = -9223372036854775807L;
        if (this.streamStartPositionsUs.size() > 0) {
            this.outputStreamStartPositionUs = ((Long) getLastAndClear(this.streamStartPositionsUs)).longValue();
        }
        if (this.videoSizes.size() > 0) {
            this.videoSizes.add(0L, (VideoSize) getLastAndClear(this.videoSizes));
        }
    }

    public void render(long j, long j2) {
        while (!this.presentationTimestampsUs.isEmpty()) {
            long jElement = this.presentationTimestampsUs.element();
            if (maybeUpdateOutputStream(jElement)) {
                this.videoFrameReleaseControl.onStreamChanged(2);
            }
            int frameReleaseAction = this.videoFrameReleaseControl.getFrameReleaseAction(jElement, j, j2, this.outputStreamStartPositionUs, false, false, this.videoFrameReleaseInfo);
            if (frameReleaseAction == 0 || frameReleaseAction == 1) {
                this.latestOutputPresentationTimeUs = jElement;
                renderFrame(frameReleaseAction == 0);
            } else if (frameReleaseAction == 2 || frameReleaseAction == 3) {
                this.latestOutputPresentationTimeUs = jElement;
                dropFrame();
            } else {
                if (frameReleaseAction != 4) {
                    if (frameReleaseAction != 5) {
                        throw new IllegalStateException(String.valueOf(frameReleaseAction));
                    }
                    return;
                }
                this.latestOutputPresentationTimeUs = jElement;
            }
        }
    }

    public void onVideoSizeChanged(int i, int i2) {
        TimedValueQueue timedValueQueue = this.videoSizes;
        long j = this.latestInputPresentationTimeUs;
        timedValueQueue.add(j == -9223372036854775807L ? 0L : j + 1, new VideoSize(i, i2));
    }

    public void onStreamChanged(int i, long j) {
        if (this.presentationTimestampsUs.isEmpty()) {
            this.videoFrameReleaseControl.onStreamChanged(i);
            this.outputStreamStartPositionUs = j;
        } else {
            TimedValueQueue timedValueQueue = this.streamStartPositionsUs;
            long j2 = this.latestInputPresentationTimeUs;
            timedValueQueue.add(j2 == -9223372036854775807L ? -4611686018427387904L : j2 + 1, Long.valueOf(j));
        }
    }

    public void onFrameAvailableForRendering(long j) {
        this.presentationTimestampsUs.add(j);
        this.latestInputPresentationTimeUs = j;
        this.lastPresentationTimeUs = -9223372036854775807L;
    }

    public void signalEndOfInput() {
        if (this.latestInputPresentationTimeUs == -9223372036854775807L) {
            this.latestInputPresentationTimeUs = Long.MIN_VALUE;
            this.latestOutputPresentationTimeUs = Long.MIN_VALUE;
        }
        this.lastPresentationTimeUs = this.latestInputPresentationTimeUs;
    }

    public boolean isEnded() {
        long j = this.lastPresentationTimeUs;
        return j != -9223372036854775807L && this.latestOutputPresentationTimeUs == j;
    }

    private void dropFrame() {
        this.presentationTimestampsUs.remove();
        this.frameRenderer.dropFrame();
    }

    private void renderFrame(boolean z) {
        long releaseTimeNs;
        long jRemove = this.presentationTimestampsUs.remove();
        if (maybeUpdateOutputVideoSize(jRemove)) {
            this.frameRenderer.onVideoSizeChanged(this.outputVideoSize);
        }
        if (z) {
            releaseTimeNs = Clock.DEFAULT.nanoTime();
        } else {
            releaseTimeNs = this.videoFrameReleaseInfo.getReleaseTimeNs();
        }
        this.frameRenderer.renderFrame(releaseTimeNs, jRemove, this.videoFrameReleaseControl.onFrameReleasedIsFirstFrame());
    }

    private boolean maybeUpdateOutputStream(long j) {
        Long l = (Long) this.streamStartPositionsUs.pollFloor(j);
        if (l == null || l.longValue() == this.outputStreamStartPositionUs) {
            return false;
        }
        this.outputStreamStartPositionUs = l.longValue();
        return true;
    }

    private boolean maybeUpdateOutputVideoSize(long j) {
        VideoSize videoSize = (VideoSize) this.videoSizes.pollFloor(j);
        if (videoSize == null || videoSize.equals(VideoSize.UNKNOWN) || videoSize.equals(this.outputVideoSize)) {
            return false;
        }
        this.outputVideoSize = videoSize;
        return true;
    }

    private static Object getLastAndClear(TimedValueQueue timedValueQueue) {
        Assertions.checkArgument(timedValueQueue.size() > 0);
        while (timedValueQueue.size() > 1) {
            timedValueQueue.pollFirst();
        }
        return Assertions.checkNotNull(timedValueQueue.pollFirst());
    }
}
