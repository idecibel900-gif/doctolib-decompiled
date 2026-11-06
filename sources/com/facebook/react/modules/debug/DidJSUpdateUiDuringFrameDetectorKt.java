package com.facebook.react.modules.debug;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DidJSUpdateUiDuringFrameDetectorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long getLastEventBetweenTimestamps(ArrayList arrayList, long j, long j2) {
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        long j3 = -1;
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            long jLongValue = ((Number) next).longValue();
            if (j <= jLongValue && jLongValue < j2) {
                j3 = jLongValue;
            } else if (jLongValue >= j2) {
                break;
            }
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cleanUp(ArrayList arrayList, long j) {
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (((Number) arrayList.get(i2)).longValue() < j) {
                i++;
            }
        }
        if (i > 0) {
            int i3 = size - i;
            for (int i4 = 0; i4 < i3; i4++) {
                arrayList.set(i4, arrayList.get(i4 + i));
            }
            CollectionsKt.dropLast(arrayList, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasEventBetweenTimestamps(ArrayList arrayList, long j, long j2) {
        if (arrayList != null && arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            if (j <= jLongValue && jLongValue < j2) {
                return true;
            }
        }
        return false;
    }
}
