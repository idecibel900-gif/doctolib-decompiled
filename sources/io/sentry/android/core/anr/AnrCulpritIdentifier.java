package io.sentry.android.core.anr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AnrCulpritIdentifier {
    private static final List systemAndFrameworkPackages;

    static {
        ArrayList arrayList = new ArrayList(11);
        systemAndFrameworkPackages = arrayList;
        arrayList.add("java.lang");
        arrayList.add("java.util");
        arrayList.add("android.app");
        arrayList.add("android.os.Handler");
        arrayList.add("android.os.Looper");
        arrayList.add("android.view");
        arrayList.add("android.widget");
        arrayList.add("com.android.internal");
        arrayList.add("com.google.android");
        arrayList.add("kotlin");
        arrayList.add("kotlinx.coroutines");
    }

    private static final class StackTraceKey {
        private final int endIdx;
        private final int hashCode = computeHashCode();
        private final StackTraceElement[] stack;
        private final int startIdx;

        StackTraceKey(StackTraceElement[] stackTraceElementArr, int i, int i2) {
            this.stack = stackTraceElementArr;
            this.startIdx = i;
            this.endIdx = i2;
        }

        private int computeHashCode() {
            int iHashCode = 1;
            for (int i = this.startIdx; i <= this.endIdx; i++) {
                iHashCode = (iHashCode * 31) + this.stack[i].hashCode();
            }
            return iHashCode;
        }

        public int hashCode() {
            return this.hashCode;
        }

        public boolean equals(Object obj) {
            int i;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StackTraceKey)) {
                return false;
            }
            StackTraceKey stackTraceKey = (StackTraceKey) obj;
            if (this.hashCode != stackTraceKey.hashCode || (i = (this.endIdx - this.startIdx) + 1) != (stackTraceKey.endIdx - stackTraceKey.startIdx) + 1) {
                return false;
            }
            for (int i2 = 0; i2 < i; i2++) {
                if (!this.stack[this.startIdx + i2].equals(stackTraceKey.stack[stackTraceKey.startIdx + i2])) {
                    return false;
                }
            }
            return true;
        }
    }

    public static AggregatedStackTrace identify(List list) {
        if (list.isEmpty()) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AnrStackTrace anrStackTrace = (AnrStackTrace) it.next();
            StackTraceElement[] stackTraceElementArr = anrStackTrace.stack;
            if (stackTraceElementArr.length >= 2) {
                int i = 0;
                for (int length = stackTraceElementArr.length - 1; length >= 0; length--) {
                    if (!isSystemFrame(anrStackTrace.stack[length].getClassName())) {
                        i++;
                    }
                    StackTraceElement[] stackTraceElementArr2 = anrStackTrace.stack;
                    float length2 = i / (stackTraceElementArr2.length - length);
                    StackTraceKey stackTraceKey = new StackTraceKey(stackTraceElementArr2, length, stackTraceElementArr2.length - 1);
                    AggregatedStackTrace aggregatedStackTrace = (AggregatedStackTrace) map.get(stackTraceKey);
                    if (aggregatedStackTrace == null) {
                        StackTraceElement[] stackTraceElementArr3 = anrStackTrace.stack;
                        map.put(stackTraceKey, new AggregatedStackTrace(stackTraceElementArr3, length, stackTraceElementArr3.length - 1, anrStackTrace.timestampMs, length2));
                    } else {
                        aggregatedStackTrace.addOccurrence(anrStackTrace.timestampMs);
                    }
                }
            }
        }
        if (map.isEmpty()) {
            return null;
        }
        return (AggregatedStackTrace) Collections.max(map.values(), new Comparator() { // from class: io.sentry.android.core.anr.AnrCulpritIdentifier$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                AggregatedStackTrace aggregatedStackTrace2 = (AggregatedStackTrace) obj;
                AggregatedStackTrace aggregatedStackTrace3 = (AggregatedStackTrace) obj2;
                return Float.compare(aggregatedStackTrace2.count * (aggregatedStackTrace2.quality + 1.0f) * aggregatedStackTrace2.depth, aggregatedStackTrace3.count * (aggregatedStackTrace3.quality + 1.0f) * aggregatedStackTrace3.depth);
            }
        });
    }

    public static boolean isSystemFrame(String str) {
        Iterator it = systemAndFrameworkPackages.iterator();
        while (it.hasNext()) {
            if (str.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }
}
