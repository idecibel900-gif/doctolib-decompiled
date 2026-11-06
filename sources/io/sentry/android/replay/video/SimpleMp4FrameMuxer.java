package io.sentry.android.replay.video;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class SimpleMp4FrameMuxer {
    private long finalVideoTime;
    private final long frameDurationUsec;
    private final MediaMuxer muxer;
    private boolean started;
    private int videoFrames;
    private int videoTrackIndex;

    public SimpleMp4FrameMuxer(String path, float f) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.frameDurationUsec = (long) (TimeUnit.SECONDS.toMicros(1L) / f);
        this.muxer = new MediaMuxer(path, 0);
    }

    public boolean isStarted() {
        return this.started;
    }

    public void start(MediaFormat videoFormat) {
        Intrinsics.checkNotNullParameter(videoFormat, "videoFormat");
        this.videoTrackIndex = this.muxer.addTrack(videoFormat);
        this.muxer.start();
        this.started = true;
    }

    public void muxVideoFrame(ByteBuffer encodedData, MediaCodec.BufferInfo bufferInfo) {
        Intrinsics.checkNotNullParameter(encodedData, "encodedData");
        Intrinsics.checkNotNullParameter(bufferInfo, "bufferInfo");
        long j = this.frameDurationUsec;
        int i = this.videoFrames;
        this.videoFrames = i + 1;
        long j2 = j * ((long) i);
        this.finalVideoTime = j2;
        bufferInfo.presentationTimeUs = j2;
        this.muxer.writeSampleData(this.videoTrackIndex, encodedData, bufferInfo);
    }

    public void release() {
        this.muxer.stop();
        this.muxer.release();
    }

    public long getVideoTime() {
        if (this.videoFrames == 0) {
            return 0L;
        }
        return TimeUnit.MILLISECONDS.convert(this.finalVideoTime + this.frameDurationUsec, TimeUnit.MICROSECONDS);
    }
}
