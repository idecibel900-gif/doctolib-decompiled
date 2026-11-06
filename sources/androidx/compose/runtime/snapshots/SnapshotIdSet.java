package androidx.compose.runtime.snapshots;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotIdSet implements Iterable, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, null);
    private final int[] belowBound;
    private final int lowerBound;
    private final long lowerSet;
    private final long upperSet;

    private SnapshotIdSet(long j, long j2, int i, int[] iArr) {
        this.upperSet = j;
        this.lowerSet = j2;
        this.lowerBound = i;
        this.belowBound = iArr;
    }

    public final boolean get(int i) {
        int[] iArr;
        int i2 = i - this.lowerBound;
        if (i2 >= 0 && i2 < 64) {
            return ((1 << i2) & this.lowerSet) != 0;
        }
        if (i2 < 64 || i2 >= 128) {
            return i2 <= 0 && (iArr = this.belowBound) != null && SnapshotIdSetKt.binarySearch(iArr, i) >= 0;
        }
        return ((1 << (i2 - 64)) & this.upperSet) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0084 A[PHI: r9
      0x0084: PHI (r9v5 java.util.ArrayList) = (r9v2 java.util.ArrayList), (r9v7 java.util.ArrayList) binds: [B:24:0x0063, B:26:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    public final SnapshotIdSet set(int i) {
        int i2;
        int[] intArray;
        long j;
        int i3 = this.lowerBound;
        int i4 = i - i3;
        long j2 = 1;
        long j3 = 0;
        if (i4 >= 0 && i4 < 64) {
            long j4 = 1 << i4;
            long j5 = this.lowerSet;
            if ((j5 & j4) == 0) {
                return new SnapshotIdSet(this.upperSet, j5 | j4, i3, this.belowBound);
            }
        } else if (i4 >= 64 && i4 < 128) {
            long j6 = 1 << (i4 - 64);
            long j7 = this.upperSet;
            if ((j7 & j6) == 0) {
                return new SnapshotIdSet(j7 | j6, this.lowerSet, i3, this.belowBound);
            }
        } else if (i4 >= 128) {
            if (!get(i)) {
                long j8 = this.upperSet;
                long j9 = this.lowerSet;
                int i5 = this.lowerBound;
                int i6 = ((i + 1) / 64) * 64;
                ArrayList arrayList = null;
                long j10 = j9;
                long j11 = j8;
                while (true) {
                    if (i5 >= i6) {
                        i2 = i5;
                        break;
                    }
                    if (j10 != j3) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            int[] iArr = this.belowBound;
                            if (iArr != null) {
                                int length = iArr.length;
                                int i7 = 0;
                                while (i7 < length) {
                                    arrayList.add(Integer.valueOf(iArr[i7]));
                                    i7++;
                                    j3 = j3;
                                }
                            }
                        }
                        j = j3;
                        for (int i8 = 0; i8 < 64; i8++) {
                            if (((j2 << i8) & j10) != j) {
                                arrayList.add(Integer.valueOf(i8 + i5));
                            }
                        }
                    } else {
                        j2 = j2;
                        j = j3;
                    }
                    if (j11 == j) {
                        i2 = i6;
                        j10 = j;
                        break;
                    }
                    i5 += 64;
                    j10 = j11;
                    j2 = j2;
                    j3 = j;
                    j11 = j3;
                }
                if (arrayList == null || (intArray = CollectionsKt.toIntArray(arrayList)) == null) {
                    intArray = this.belowBound;
                }
                return new SnapshotIdSet(j11, j10, i2, intArray).set(i);
            }
        } else {
            int[] iArr2 = this.belowBound;
            if (iArr2 == null) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, i3, new int[]{i});
            }
            int iBinarySearch = SnapshotIdSetKt.binarySearch(iArr2, i);
            if (iBinarySearch < 0) {
                int i9 = -(iBinarySearch + 1);
                int length2 = iArr2.length;
                int[] iArr3 = new int[length2 + 1];
                ArraysKt.copyInto(iArr2, iArr3, 0, 0, i9);
                ArraysKt.copyInto(iArr2, iArr3, i9 + 1, i9, length2);
                iArr3[i9] = i;
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr3);
            }
        }
        return this;
    }

    public final SnapshotIdSet clear(int i) {
        int[] iArr;
        int iBinarySearch;
        int i2 = this.lowerBound;
        int i3 = i - i2;
        if (i3 >= 0 && i3 < 64) {
            long j = 1 << i3;
            long j2 = this.lowerSet;
            if ((j2 & j) != 0) {
                return new SnapshotIdSet(this.upperSet, (~j) & j2, i2, this.belowBound);
            }
        } else if (i3 >= 64 && i3 < 128) {
            long j3 = 1 << (i3 - 64);
            long j4 = this.upperSet;
            if ((j4 & j3) != 0) {
                return new SnapshotIdSet((~j3) & j4, this.lowerSet, i2, this.belowBound);
            }
        } else if (i3 < 0 && (iArr = this.belowBound) != null && (iBinarySearch = SnapshotIdSetKt.binarySearch(iArr, i)) >= 0) {
            int length = iArr.length;
            int i4 = length - 1;
            if (i4 == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, null);
            }
            int[] iArr2 = new int[i4];
            if (iBinarySearch > 0) {
                ArraysKt.copyInto(iArr, iArr2, 0, 0, iBinarySearch);
            }
            if (iBinarySearch < i4) {
                ArraysKt.copyInto(iArr, iArr2, iBinarySearch, iBinarySearch + 1, length);
            }
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr2);
        }
        return this;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSetClear;
        SnapshotIdSet snapshotIdSet2 = EMPTY;
        if (snapshotIdSet == snapshotIdSet2) {
            return this;
        }
        if (this == snapshotIdSet2) {
            return snapshotIdSet2;
        }
        int i = snapshotIdSet.lowerBound;
        int i2 = this.lowerBound;
        if (i == i2) {
            int[] iArr = snapshotIdSet.belowBound;
            int[] iArr2 = this.belowBound;
            if (iArr == iArr2) {
                return new SnapshotIdSet(this.upperSet & (~snapshotIdSet.upperSet), this.lowerSet & (~snapshotIdSet.lowerSet), i2, iArr2);
            }
        }
        int[] iArr3 = snapshotIdSet.belowBound;
        if (iArr3 != null) {
            snapshotIdSetClear = this;
            for (int i3 : iArr3) {
                snapshotIdSetClear = snapshotIdSetClear.clear(i3);
            }
        } else {
            snapshotIdSetClear = this;
        }
        if (snapshotIdSet.lowerSet != 0) {
            for (int i4 = 0; i4 < 64; i4++) {
                if ((snapshotIdSet.lowerSet & (1 << i4)) != 0) {
                    snapshotIdSetClear = snapshotIdSetClear.clear(snapshotIdSet.lowerBound + i4);
                }
            }
        }
        if (snapshotIdSet.upperSet != 0) {
            for (int i5 = 0; i5 < 64; i5++) {
                if ((snapshotIdSet.upperSet & (1 << i5)) != 0) {
                    snapshotIdSetClear = snapshotIdSetClear.clear(i5 + 64 + snapshotIdSet.lowerBound);
                }
            }
        }
        return snapshotIdSetClear;
    }

    public final SnapshotIdSet or(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSet2;
        SnapshotIdSet snapshotIdSet3 = EMPTY;
        if (snapshotIdSet == snapshotIdSet3) {
            return this;
        }
        if (this == snapshotIdSet3) {
            return snapshotIdSet;
        }
        int i = snapshotIdSet.lowerBound;
        int i2 = this.lowerBound;
        if (i == i2) {
            int[] iArr = snapshotIdSet.belowBound;
            int[] iArr2 = this.belowBound;
            if (iArr == iArr2) {
                return new SnapshotIdSet(this.upperSet | snapshotIdSet.upperSet, this.lowerSet | snapshotIdSet.lowerSet, i2, iArr2);
            }
        }
        int i3 = 0;
        if (this.belowBound == null) {
            int[] iArr3 = this.belowBound;
            if (iArr3 != null) {
                for (int i4 : iArr3) {
                    snapshotIdSet = snapshotIdSet.set(i4);
                }
            }
            if (this.lowerSet != 0) {
                for (int i5 = 0; i5 < 64; i5++) {
                    if ((this.lowerSet & (1 << i5)) != 0) {
                        snapshotIdSet = snapshotIdSet.set(this.lowerBound + i5);
                    }
                }
            }
            if (this.upperSet != 0) {
                while (i3 < 64) {
                    if ((this.upperSet & (1 << i3)) != 0) {
                        snapshotIdSet = snapshotIdSet.set(i3 + 64 + this.lowerBound);
                    }
                    i3++;
                }
            }
            return snapshotIdSet;
        }
        int[] iArr4 = snapshotIdSet.belowBound;
        if (iArr4 != null) {
            snapshotIdSet2 = this;
            for (int i6 : iArr4) {
                snapshotIdSet2 = snapshotIdSet2.set(i6);
            }
        } else {
            snapshotIdSet2 = this;
        }
        if (snapshotIdSet.lowerSet != 0) {
            for (int i7 = 0; i7 < 64; i7++) {
                if ((snapshotIdSet.lowerSet & (1 << i7)) != 0) {
                    snapshotIdSet2 = snapshotIdSet2.set(snapshotIdSet.lowerBound + i7);
                }
            }
        }
        if (snapshotIdSet.upperSet != 0) {
            while (i3 < 64) {
                if ((snapshotIdSet.upperSet & (1 << i3)) != 0) {
                    snapshotIdSet2 = snapshotIdSet2.set(i3 + 64 + snapshotIdSet.lowerBound);
                }
                i3++;
            }
        }
        return snapshotIdSet2;
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1, reason: invalid class name */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2 {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = SnapshotIdSet.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:36:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:38:0x00d4  */
        /* JADX WARN: Code duplicated, block: B:41:0x00f0  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0079 -> B:19:0x007d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x009b -> B:30:0x00b7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00b4 -> B:30:0x00b7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00d2 -> B:43:0x00f2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00f0 -> B:42:0x00f1). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instruction units count: 247
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return SequencesKt.sequence(new AnonymousClass1(null)).iterator();
    }

    public final int lowest(int i) {
        int[] iArr = this.belowBound;
        if (iArr != null) {
            return iArr[0];
        }
        long j = this.lowerSet;
        if (j != 0) {
            return this.lowerBound + Long.numberOfTrailingZeros(j);
        }
        long j2 = this.upperSet;
        return j2 != 0 ? this.lowerBound + 64 + Long.numberOfTrailingZeros(j2) : i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" [");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(this, 10));
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).intValue()));
        }
        sb.append(ListUtilsKt.fastJoinToString$default(arrayList, null, null, null, 0, null, null, 63, null));
        sb.append(']');
        return sb.toString();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }
    }
}
