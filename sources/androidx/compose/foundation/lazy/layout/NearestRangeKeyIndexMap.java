package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes.dex */
public final class NearestRangeKeyIndexMap implements LazyLayoutKeyIndexMap {
    private final Object[] keys;
    private final int keysStartIndex;
    private final ObjectIntMap map;

    public NearestRangeKeyIndexMap(IntRange intRange, LazyLayoutIntervalContent lazyLayoutIntervalContent) {
        IntervalList intervals = lazyLayoutIntervalContent.getIntervals();
        final int first = intRange.getFirst();
        if (first < 0) {
            throw new IllegalStateException("negative nearestRange.first");
        }
        final int iMin = Math.min(intRange.getLast(), intervals.getSize() - 1);
        if (iMin < first) {
            this.map = ObjectIntMapKt.emptyObjectIntMap();
            this.keys = new Object[0];
            this.keysStartIndex = 0;
        } else {
            int i = (iMin - first) + 1;
            this.keys = new Object[i];
            this.keysStartIndex = first;
            final MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(i);
            intervals.forEach(first, iMin, new Function1() { // from class: androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((IntervalList.Interval) obj);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0039  */
                public final void invoke(IntervalList.Interval interval) {
                    Object defaultLazyLayoutKey;
                    Function1 key = ((LazyLayoutIntervalContent.Interval) interval.getValue()).getKey();
                    int iMax = Math.max(first, interval.getStartIndex());
                    int iMin2 = Math.min(iMin, (interval.getStartIndex() + interval.getSize()) - 1);
                    if (iMax > iMin2) {
                        return;
                    }
                    while (true) {
                        if (key == null) {
                            defaultLazyLayoutKey = Lazy_androidKt.getDefaultLazyLayoutKey(iMax);
                        } else {
                            defaultLazyLayoutKey = key.invoke(Integer.valueOf(iMax - interval.getStartIndex()));
                            if (defaultLazyLayoutKey == null) {
                                defaultLazyLayoutKey = Lazy_androidKt.getDefaultLazyLayoutKey(iMax);
                            }
                        }
                        mutableObjectIntMap.set(defaultLazyLayoutKey, iMax);
                        this.keys[iMax - this.keysStartIndex] = defaultLazyLayoutKey;
                        if (iMax == iMin2) {
                            return;
                        } else {
                            iMax++;
                        }
                    }
                }
            });
            this.map = mutableObjectIntMap;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public int getIndex(Object obj) {
        ObjectIntMap objectIntMap = this.map;
        int iFindKeyIndex = objectIntMap.findKeyIndex(obj);
        if (iFindKeyIndex >= 0) {
            return objectIntMap.values[iFindKeyIndex];
        }
        return -1;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public Object getKey(int i) {
        Object[] objArr = this.keys;
        int i2 = i - this.keysStartIndex;
        if (i2 < 0 || i2 > ArraysKt.getLastIndex(objArr)) {
            return null;
        }
        return objArr[i2];
    }
}
