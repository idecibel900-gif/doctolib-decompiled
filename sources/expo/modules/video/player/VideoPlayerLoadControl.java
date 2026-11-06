package expo.modules.video.player;

import androidx.media3.common.util.Util;
import expo.modules.video.records.BufferOptions;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class VideoPlayerLoadControl extends DefaultLoadControl {
    private final long getTargetBufferMs() {
        return this.maxBufferUs / ((long) 1000);
    }

    private final void setTargetBufferMs(long j) {
        this.minBufferUs = Util.msToUs(j);
        this.maxBufferUs = Util.msToUs(j);
    }

    private final void setBufferForPlaybackMs(long j) {
        this.bufferForPlaybackUs = Util.msToUs(j);
    }

    private final void setBufferForPlaybackAfterRebufferMs(long j) {
        this.bufferForPlaybackAfterRebufferUs = Util.msToUs(j);
    }

    public final void applyBufferOptions(BufferOptions bufferOptions) {
        long minBufferForPlayback;
        Intrinsics.checkNotNullParameter(bufferOptions, "bufferOptions");
        Double preferredForwardBufferDuration = bufferOptions.getPreferredForwardBufferDuration();
        setTargetBufferMs(preferredForwardBufferDuration != null ? (long) (preferredForwardBufferDuration.doubleValue() * ((double) 1000)) : 50000L);
        int maxBufferBytes = bufferOptions.getMaxBufferBytes() == 0 ? -1 : (int) bufferOptions.getMaxBufferBytes();
        this.targetBufferBytesOverwrite = maxBufferBytes;
        if (maxBufferBytes != -1) {
            Iterator it = this.loadingStates.values().iterator();
            while (it.hasNext()) {
                ((DefaultLoadControl.PlayerLoadingState) it.next()).targetBufferBytes = this.targetBufferBytesOverwrite;
            }
        }
        this.prioritizeTimeOverSizeThresholds = bufferOptions.getPrioritizeTimeOverSizeThreshold();
        double d = 1000;
        if (bufferOptions.getMinBufferForPlayback() * d > getTargetBufferMs()) {
            minBufferForPlayback = getTargetBufferMs();
        } else {
            minBufferForPlayback = (long) (bufferOptions.getMinBufferForPlayback() * d);
        }
        setBufferForPlaybackMs(minBufferForPlayback);
        setBufferForPlaybackAfterRebufferMs(minBufferForPlayback);
        updateAllocator();
    }
}
