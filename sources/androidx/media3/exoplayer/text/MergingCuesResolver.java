package androidx.media3.exoplayer.text;

import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.text.CuesWithTiming;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class MergingCuesResolver implements CuesResolver {
    private static final Ordering CUES_DISPLAY_PRIORITY_COMPARATOR = Ordering.natural().onResultOf(new Function() { // from class: androidx.media3.exoplayer.text.MergingCuesResolver$$ExternalSyntheticLambda0
        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            return Long.valueOf(((CuesWithTiming) obj).startTimeUs);
        }
    }).compound(Ordering.natural().reverse().onResultOf(new Function() { // from class: androidx.media3.exoplayer.text.MergingCuesResolver$$ExternalSyntheticLambda1
        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            return Long.valueOf(((CuesWithTiming) obj).durationUs);
        }
    }));
    private final List cuesWithTimingList = new ArrayList();

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public boolean addCues(CuesWithTiming cuesWithTiming, long j) {
        Assertions.checkArgument(cuesWithTiming.startTimeUs != -9223372036854775807L);
        Assertions.checkArgument(cuesWithTiming.durationUs != -9223372036854775807L);
        boolean z = cuesWithTiming.startTimeUs <= j && j < cuesWithTiming.endTimeUs;
        for (int size = this.cuesWithTimingList.size() - 1; size >= 0; size--) {
            if (cuesWithTiming.startTimeUs >= ((CuesWithTiming) this.cuesWithTimingList.get(size)).startTimeUs) {
                this.cuesWithTimingList.add(size + 1, cuesWithTiming);
                return z;
            }
        }
        this.cuesWithTimingList.add(0, cuesWithTiming);
        return z;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public ImmutableList getCuesAtTimeUs(long j) {
        if (!this.cuesWithTimingList.isEmpty()) {
            if (j >= ((CuesWithTiming) this.cuesWithTimingList.get(0)).startTimeUs) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < this.cuesWithTimingList.size(); i++) {
                    CuesWithTiming cuesWithTiming = (CuesWithTiming) this.cuesWithTimingList.get(i);
                    if (j >= cuesWithTiming.startTimeUs && j < cuesWithTiming.endTimeUs) {
                        arrayList.add(cuesWithTiming);
                    }
                    if (j < cuesWithTiming.startTimeUs) {
                        break;
                    }
                }
                ImmutableList immutableListSortedCopyOf = ImmutableList.sortedCopyOf(CUES_DISPLAY_PRIORITY_COMPARATOR, arrayList);
                ImmutableList.Builder builder = ImmutableList.builder();
                for (int i2 = 0; i2 < immutableListSortedCopyOf.size(); i2++) {
                    builder.addAll((Iterable) ((CuesWithTiming) immutableListSortedCopyOf.get(i2)).cues);
                }
                return builder.build();
            }
        }
        return ImmutableList.of();
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public void discardCuesBeforeTimeUs(long j) {
        int i = 0;
        while (i < this.cuesWithTimingList.size()) {
            long j2 = ((CuesWithTiming) this.cuesWithTimingList.get(i)).startTimeUs;
            if (j > j2 && j > ((CuesWithTiming) this.cuesWithTimingList.get(i)).endTimeUs) {
                this.cuesWithTimingList.remove(i);
                i--;
            } else if (j < j2) {
                return;
            }
            i++;
        }
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public long getPreviousCueChangeTimeUs(long j) {
        if (this.cuesWithTimingList.isEmpty()) {
            return -9223372036854775807L;
        }
        if (j < ((CuesWithTiming) this.cuesWithTimingList.get(0)).startTimeUs) {
            return -9223372036854775807L;
        }
        long jMax = ((CuesWithTiming) this.cuesWithTimingList.get(0)).startTimeUs;
        for (int i = 0; i < this.cuesWithTimingList.size(); i++) {
            long j2 = ((CuesWithTiming) this.cuesWithTimingList.get(i)).startTimeUs;
            long j3 = ((CuesWithTiming) this.cuesWithTimingList.get(i)).endTimeUs;
            if (j3 <= j) {
                jMax = Math.max(jMax, j3);
            } else {
                if (j2 > j) {
                    break;
                }
                jMax = Math.max(jMax, j2);
            }
        }
        return jMax;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public long getNextCueChangeTimeUs(long j) {
        long jMin = -9223372036854775807L;
        for (int i = 0; i < this.cuesWithTimingList.size(); i++) {
            long j2 = ((CuesWithTiming) this.cuesWithTimingList.get(i)).startTimeUs;
            long j3 = ((CuesWithTiming) this.cuesWithTimingList.get(i)).endTimeUs;
            if (j < j2) {
                if (jMin != -9223372036854775807L) {
                    jMin = Math.min(jMin, j2);
                    break;
                }
                jMin = j2;
                break;
            }
            if (j < j3) {
                jMin = jMin == -9223372036854775807L ? j3 : Math.min(jMin, j3);
            }
        }
        if (jMin != -9223372036854775807L) {
            return jMin;
        }
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.text.CuesResolver
    public void clear() {
        this.cuesWithTimingList.clear();
    }
}
