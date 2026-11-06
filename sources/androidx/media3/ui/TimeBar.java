package androidx.media3.ui;

/* JADX INFO: loaded from: classes.dex */
public interface TimeBar {

    public interface OnScrubListener {
        void onScrubMove(TimeBar timeBar, long j);

        void onScrubStart(TimeBar timeBar, long j);

        void onScrubStop(TimeBar timeBar, long j, boolean z);
    }

    void addListener(OnScrubListener onScrubListener);

    long getPreferredUpdateDelay();

    void setAdGroupTimesMs(long[] jArr, boolean[] zArr, int i);

    void setBufferedPosition(long j);

    void setDuration(long j);

    void setEnabled(boolean z);

    void setPosition(long j);
}
