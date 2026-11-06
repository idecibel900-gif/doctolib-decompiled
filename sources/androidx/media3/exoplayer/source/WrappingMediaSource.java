package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.datasource.TransferListener;

/* JADX INFO: loaded from: classes.dex */
public abstract class WrappingMediaSource extends CompositeMediaSource {
    private static final Void CHILD_SOURCE_ID = null;
    protected final MediaSource mediaSource;

    protected MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    protected long getMediaTimeForChildMediaTime(long j, MediaSource.MediaPeriodId mediaPeriodId) {
        return j;
    }

    protected int getWindowIndexForChildWindowIndex(int i) {
        return i;
    }

    protected abstract void onChildSourceInfoRefreshed(Timeline timeline);

    protected WrappingMediaSource(MediaSource mediaSource) {
        this.mediaSource = mediaSource;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected final void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareSourceInternal();
    }

    protected void prepareSourceInternal() {
        prepareChildSource();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public Timeline getInitialTimeline() {
        return this.mediaSource.getInitialTimeline();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public boolean isSingleWindow() {
        return this.mediaSource.isSingleWindow();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaItem getMediaItem() {
        return this.mediaSource.getMediaItem();
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void updateMediaItem(MediaItem mediaItem) {
        this.mediaSource.updateMediaItem(mediaItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final void onChildSourceInfoRefreshed(Void r1, MediaSource mediaSource, Timeline timeline) {
        onChildSourceInfoRefreshed(timeline);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final int getWindowIndexForChildWindowIndex(Void r1, int i) {
        return getWindowIndexForChildWindowIndex(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Void r1, MediaSource.MediaPeriodId mediaPeriodId) {
        return getMediaPeriodIdForChildMediaPeriodId(mediaPeriodId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public final long getMediaTimeForChildMediaTime(Void r1, long j, MediaSource.MediaPeriodId mediaPeriodId) {
        return getMediaTimeForChildMediaTime(j, mediaPeriodId);
    }

    protected final void prepareChildSource() {
        prepareChildSource(CHILD_SOURCE_ID, this.mediaSource);
    }
}
