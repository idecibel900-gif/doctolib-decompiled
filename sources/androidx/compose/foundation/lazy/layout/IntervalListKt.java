package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.collection.MutableVector;

/* JADX INFO: loaded from: classes.dex */
public abstract class IntervalListKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int binarySearch(MutableVector mutableVector, int i) {
        int size = mutableVector.getSize() - 1;
        int i2 = 0;
        while (i2 < size) {
            int i3 = ((size - i2) / 2) + i2;
            int startIndex = ((IntervalList.Interval) mutableVector.getContent()[i3]).getStartIndex();
            if (startIndex != i) {
                if (startIndex < i) {
                    i2 = i3 + 1;
                    if (i < ((IntervalList.Interval) mutableVector.getContent()[i2]).getStartIndex()) {
                    }
                } else {
                    size = i3 - 1;
                }
            }
            return i3;
        }
        return i2;
    }
}
