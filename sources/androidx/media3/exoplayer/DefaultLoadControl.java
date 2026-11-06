package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.DefaultAllocator;
import com.google.android.play.core.review.model.ReviewErrorCode;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class DefaultLoadControl implements LoadControl {
    private final DefaultAllocator allocator;
    private final long backBufferDurationUs;
    private final long bufferForPlaybackAfterRebufferUs;
    private final long bufferForPlaybackUs;
    private final HashMap loadingStates;
    private final long maxBufferUs;
    private final long minBufferUs;
    private final boolean prioritizeTimeOverSizeThresholds;
    private final boolean retainBackBufferFromKeyframe;
    private final int targetBufferBytesOverwrite;
    private long threadId;

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, 65536), 50000, 50000, 1000, 2000, -1, false, 0, false);
    }

    protected DefaultLoadControl(DefaultAllocator defaultAllocator, int i, int i2, int i3, int i4, int i5, boolean z, int i6, boolean z2) {
        assertGreaterOrEqual(i3, 0, "bufferForPlaybackMs", "0");
        assertGreaterOrEqual(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        assertGreaterOrEqual(i, i3, "minBufferMs", "bufferForPlaybackMs");
        assertGreaterOrEqual(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        assertGreaterOrEqual(i2, i, "maxBufferMs", "minBufferMs");
        assertGreaterOrEqual(i6, 0, "backBufferDurationMs", "0");
        this.allocator = defaultAllocator;
        this.minBufferUs = Util.msToUs(i);
        this.maxBufferUs = Util.msToUs(i2);
        this.bufferForPlaybackUs = Util.msToUs(i3);
        this.bufferForPlaybackAfterRebufferUs = Util.msToUs(i4);
        this.targetBufferBytesOverwrite = i5;
        this.prioritizeTimeOverSizeThresholds = z;
        this.backBufferDurationUs = Util.msToUs(i6);
        this.retainBackBufferFromKeyframe = z2;
        this.loadingStates = new HashMap();
        this.threadId = -1L;
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public void onPrepared(PlayerId playerId) {
        long id = Thread.currentThread().getId();
        long j = this.threadId;
        Assertions.checkState(j == -1 || j == id, "Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).");
        this.threadId = id;
        if (!this.loadingStates.containsKey(playerId)) {
            this.loadingStates.put(playerId, new PlayerLoadingState());
        }
        resetPlayerLoadingState(playerId);
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public void onTracksSelected(LoadControl.Parameters parameters, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        PlayerLoadingState playerLoadingState = (PlayerLoadingState) Assertions.checkNotNull((PlayerLoadingState) this.loadingStates.get(parameters.playerId));
        int iCalculateTargetBufferBytes = this.targetBufferBytesOverwrite;
        if (iCalculateTargetBufferBytes == -1) {
            iCalculateTargetBufferBytes = calculateTargetBufferBytes(exoTrackSelectionArr);
        }
        playerLoadingState.targetBufferBytes = iCalculateTargetBufferBytes;
        updateAllocator();
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public void onStopped(PlayerId playerId) {
        removePlayer(playerId);
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public void onReleased(PlayerId playerId) {
        removePlayer(playerId);
        if (this.loadingStates.isEmpty()) {
            this.threadId = -1L;
        }
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public Allocator getAllocator() {
        return this.allocator;
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public long getBackBufferDurationUs(PlayerId playerId) {
        return this.backBufferDurationUs;
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public boolean retainBackBufferFromKeyframe(PlayerId playerId) {
        return this.retainBackBufferFromKeyframe;
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public boolean shouldContinueLoading(LoadControl.Parameters parameters) {
        PlayerLoadingState playerLoadingState = (PlayerLoadingState) Assertions.checkNotNull((PlayerLoadingState) this.loadingStates.get(parameters.playerId));
        boolean z = true;
        boolean z2 = this.allocator.getTotalBytesAllocated() >= calculateTotalTargetBufferBytes();
        long jMin = this.minBufferUs;
        float f = parameters.playbackSpeed;
        if (f > 1.0f) {
            jMin = Math.min(Util.getMediaDurationForPlayoutDuration(jMin, f), this.maxBufferUs);
        }
        long jMax = Math.max(jMin, 500000L);
        long j = parameters.bufferedDurationUs;
        if (j < jMax) {
            if (!this.prioritizeTimeOverSizeThresholds && z2) {
                z = false;
            }
            playerLoadingState.isLoading = z;
            if (!z && j < 500000) {
                Log.w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j >= this.maxBufferUs || z2) {
            playerLoadingState.isLoading = false;
        }
        return playerLoadingState.isLoading;
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public boolean shouldStartPlayback(LoadControl.Parameters parameters) {
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(parameters.bufferedDurationUs, parameters.playbackSpeed);
        long jMin = parameters.rebuffering ? this.bufferForPlaybackAfterRebufferUs : this.bufferForPlaybackUs;
        long j = parameters.targetLiveOffsetUs;
        if (j != -9223372036854775807L) {
            jMin = Math.min(j / 2, jMin);
        }
        if (jMin <= 0 || playoutDurationForMediaDuration >= jMin) {
            return true;
        }
        return !this.prioritizeTimeOverSizeThresholds && this.allocator.getTotalBytesAllocated() >= calculateTotalTargetBufferBytes();
    }

    @Override // androidx.media3.exoplayer.LoadControl
    public boolean shouldContinuePreloading(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j) {
        Iterator it = this.loadingStates.values().iterator();
        while (it.hasNext()) {
            if (((PlayerLoadingState) it.next()).isLoading) {
                return false;
            }
        }
        return true;
    }

    protected int calculateTargetBufferBytes(ExoTrackSelection[] exoTrackSelectionArr) {
        int defaultBufferSize = 0;
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                defaultBufferSize += getDefaultBufferSize(exoTrackSelection.getTrackGroup().type);
            }
        }
        return Math.max(13107200, defaultBufferSize);
    }

    int calculateTotalTargetBufferBytes() {
        Iterator it = this.loadingStates.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((PlayerLoadingState) it.next()).targetBufferBytes;
        }
        return i;
    }

    private void resetPlayerLoadingState(PlayerId playerId) {
        PlayerLoadingState playerLoadingState = (PlayerLoadingState) Assertions.checkNotNull((PlayerLoadingState) this.loadingStates.get(playerId));
        int i = this.targetBufferBytesOverwrite;
        if (i == -1) {
            i = 13107200;
        }
        playerLoadingState.targetBufferBytes = i;
        playerLoadingState.isLoading = false;
    }

    private void removePlayer(PlayerId playerId) {
        if (this.loadingStates.remove(playerId) != null) {
            updateAllocator();
        }
    }

    private void updateAllocator() {
        if (this.loadingStates.isEmpty()) {
            this.allocator.reset();
        } else {
            this.allocator.setTargetBufferSize(calculateTotalTargetBufferBytes());
        }
    }

    private static int getDefaultBufferSize(int i) {
        switch (i) {
            case ReviewErrorCode.INVALID_REQUEST /* -2 */:
                return 0;
            case -1:
                return 13107200;
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                return 131072000;
            case 3:
                return 131072;
            case 4:
                return 26214400;
            case 5:
            case 6:
                return 131072;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static void assertGreaterOrEqual(int i, int i2, String str, String str2) {
        Assertions.checkArgument(i >= i2, str + " cannot be less than " + str2);
    }

    private static class PlayerLoadingState {
        public boolean isLoading;
        public int targetBufferBytes;

        private PlayerLoadingState() {
        }
    }
}
