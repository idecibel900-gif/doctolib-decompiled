package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.IntervalList;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridSpanLayoutProvider {
    private final ArrayList buckets;
    private final List cachedBucket;
    private int cachedBucketIndex;
    private final LazyGridIntervalContent gridContent;
    private int lastLineIndex;
    private int lastLineStartItemIndex;
    private int lastLineStartKnownSpan;
    private List previousDefaultSpans;
    private int slotsPerLine;

    public LazyGridSpanLayoutProvider(LazyGridIntervalContent lazyGridIntervalContent) {
        this.gridContent = lazyGridIntervalContent;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        arrayList.add(new Bucket(i, i, 2, null));
        this.buckets = arrayList;
        this.cachedBucketIndex = -1;
        this.cachedBucket = new ArrayList();
        this.previousDefaultSpans = CollectionsKt.emptyList();
    }

    public static final class LineConfiguration {
        private final int firstItemIndex;
        private final List spans;

        public LineConfiguration(int i, List list) {
            this.firstItemIndex = i;
            this.spans = list;
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final List getSpans() {
            return this.spans;
        }
    }

    private final int getBucketSize() {
        return ((int) Math.sqrt((((double) getTotalSize()) * 1.0d) / ((double) this.slotsPerLine))) + 1;
    }

    private final List getDefaultSpans(int i) {
        if (i == this.previousDefaultSpans.size()) {
            return this.previousDefaultSpans;
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(GridItemSpan.m379boximpl(LazyGridSpanKt.GridItemSpan(1)));
        }
        this.previousDefaultSpans = arrayList;
        return arrayList;
    }

    public final int getTotalSize() {
        return this.gridContent.getIntervals().getSize();
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    public final void setSlotsPerLine(int i) {
        if (i != this.slotsPerLine) {
            this.slotsPerLine = i;
            invalidateCache();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0090  */
    public final LineConfiguration getLineConfiguration(int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        if (!this.gridContent.getHasCustomSpans$foundation_release()) {
            int i5 = i * this.slotsPerLine;
            return new LineConfiguration(i5, getDefaultSpans(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(this.slotsPerLine, getTotalSize() - i5), 0)));
        }
        int iMin = Math.min(i / getBucketSize(), this.buckets.size() - 1);
        int bucketSize = getBucketSize() * iMin;
        int firstItemIndex = ((Bucket) this.buckets.get(iMin)).getFirstItemIndex();
        int firstItemKnownSpan = ((Bucket) this.buckets.get(iMin)).getFirstItemKnownSpan();
        int i6 = this.lastLineIndex;
        if (bucketSize <= i6 && i6 <= i) {
            firstItemIndex = this.lastLineStartItemIndex;
            firstItemKnownSpan = this.lastLineStartKnownSpan;
            bucketSize = i6;
        } else if (iMin == this.cachedBucketIndex && (i2 = i - bucketSize) < this.cachedBucket.size()) {
            firstItemIndex = ((Number) this.cachedBucket.get(i2)).intValue();
            bucketSize = i;
            firstItemKnownSpan = 0;
        }
        if (bucketSize % getBucketSize() == 0) {
            int i7 = i - bucketSize;
            z = 2 <= i7 && i7 < getBucketSize();
        }
        if (z) {
            this.cachedBucketIndex = iMin;
            this.cachedBucket.clear();
        }
        if (bucketSize > i) {
            throw new IllegalStateException("currentLine > lineIndex");
        }
        while (bucketSize < i && firstItemIndex < getTotalSize()) {
            if (z) {
                this.cachedBucket.add(Integer.valueOf(firstItemIndex));
            }
            int i8 = 0;
            while (i8 < this.slotsPerLine && firstItemIndex < getTotalSize()) {
                if (firstItemKnownSpan == 0) {
                    i4 = firstItemKnownSpan;
                    firstItemKnownSpan = spanOf(firstItemIndex, this.slotsPerLine - i8);
                } else {
                    i4 = 0;
                }
                i8 += firstItemKnownSpan;
                if (i8 > this.slotsPerLine) {
                    break;
                }
                firstItemIndex++;
                firstItemKnownSpan = i4;
            }
            bucketSize++;
            if (bucketSize % getBucketSize() == 0 && firstItemIndex < getTotalSize()) {
                if (this.buckets.size() != bucketSize / getBucketSize()) {
                    throw new IllegalStateException("invalid starting point");
                }
                this.buckets.add(new Bucket(firstItemIndex, firstItemKnownSpan));
            }
        }
        this.lastLineIndex = i;
        this.lastLineStartItemIndex = firstItemIndex;
        this.lastLineStartKnownSpan = firstItemKnownSpan;
        ArrayList arrayList = new ArrayList();
        int i9 = 0;
        int i10 = firstItemIndex;
        while (i9 < this.slotsPerLine && i10 < getTotalSize()) {
            if (firstItemKnownSpan == 0) {
                int i11 = firstItemKnownSpan;
                firstItemKnownSpan = spanOf(i10, this.slotsPerLine - i9);
                i3 = i11;
            } else {
                i3 = 0;
            }
            i9 += firstItemKnownSpan;
            if (i9 > this.slotsPerLine) {
                break;
            }
            i10++;
            arrayList.add(GridItemSpan.m379boximpl(LazyGridSpanKt.GridItemSpan(firstItemKnownSpan)));
            firstItemKnownSpan = i3;
        }
        return new LineConfiguration(firstItemIndex, arrayList);
    }

    public final int getLineIndexOfItem(final int i) {
        int i2 = 0;
        if (getTotalSize() <= 0) {
            return 0;
        }
        if (i >= getTotalSize()) {
            throw new IllegalArgumentException("ItemIndex > total count");
        }
        if (!this.gridContent.getHasCustomSpans$foundation_release()) {
            return i / this.slotsPerLine;
        }
        int iBinarySearch$default = CollectionsKt.binarySearch$default(this.buckets, 0, 0, new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$getLineIndexOfItem$lowerBoundBucket$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(LazyGridSpanLayoutProvider.Bucket bucket) {
                return Integer.valueOf(bucket.getFirstItemIndex() - i);
            }
        }, 3, (Object) null);
        int i3 = 2;
        if (iBinarySearch$default < 0) {
            iBinarySearch$default = (-iBinarySearch$default) - 2;
        }
        int bucketSize = getBucketSize() * iBinarySearch$default;
        int firstItemIndex = ((Bucket) this.buckets.get(iBinarySearch$default)).getFirstItemIndex();
        if (firstItemIndex > i) {
            throw new IllegalArgumentException("currentItemIndex > itemIndex");
        }
        int i4 = 0;
        while (true) {
            if (firstItemIndex >= i) {
                break;
            }
            int i5 = firstItemIndex + 1;
            int iSpanOf = spanOf(firstItemIndex, this.slotsPerLine - i4);
            i4 += iSpanOf;
            int i6 = this.slotsPerLine;
            if (i4 >= i6) {
                if (i4 == i6) {
                    bucketSize++;
                    i4 = 0;
                } else {
                    bucketSize++;
                    i4 = iSpanOf;
                }
            }
            if (bucketSize % getBucketSize() == 0 && bucketSize / getBucketSize() >= this.buckets.size()) {
                this.buckets.add(new Bucket(i5 - (i4 <= 0 ? 0 : 1), i2, i3, null));
            }
            firstItemIndex = i5;
        }
        return i4 + spanOf(i, this.slotsPerLine - i4) > this.slotsPerLine ? bucketSize + 1 : bucketSize;
    }

    public final int spanOf(int i, int i2) {
        LazyGridItemSpanScopeImpl lazyGridItemSpanScopeImpl = LazyGridItemSpanScopeImpl.INSTANCE;
        lazyGridItemSpanScopeImpl.setMaxCurrentLineSpan(i2);
        lazyGridItemSpanScopeImpl.setMaxLineSpan(this.slotsPerLine);
        IntervalList.Interval interval = this.gridContent.getIntervals().get(i);
        return GridItemSpan.m382getCurrentLineSpanimpl(((GridItemSpan) ((LazyGridInterval) interval.getValue()).getSpan().invoke(lazyGridItemSpanScopeImpl, Integer.valueOf(i - interval.getStartIndex()))).m385unboximpl());
    }

    private final void invalidateCache() {
        this.buckets.clear();
        int i = 0;
        this.buckets.add(new Bucket(i, i, 2, null));
        this.lastLineIndex = 0;
        this.lastLineStartItemIndex = 0;
        this.lastLineStartKnownSpan = 0;
        this.cachedBucketIndex = -1;
        this.cachedBucket.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class Bucket {
        private final int firstItemIndex;
        private final int firstItemKnownSpan;

        public Bucket(int i, int i2) {
            this.firstItemIndex = i;
            this.firstItemKnownSpan = i2;
        }

        public /* synthetic */ Bucket(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? 0 : i2);
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final int getFirstItemKnownSpan() {
            return this.firstItemKnownSpan;
        }
    }

    private static final class LazyGridItemSpanScopeImpl implements LazyGridItemSpanScope {
        public static final LazyGridItemSpanScopeImpl INSTANCE = new LazyGridItemSpanScopeImpl();
        private static int maxCurrentLineSpan;
        private static int maxLineSpan;

        private LazyGridItemSpanScopeImpl() {
        }

        public void setMaxCurrentLineSpan(int i) {
            maxCurrentLineSpan = i;
        }

        public void setMaxLineSpan(int i) {
            maxLineSpan = i;
        }
    }
}
