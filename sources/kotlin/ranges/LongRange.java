package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
public final class LongRange extends LongProgression implements ClosedRange {
    public static final Companion Companion = new Companion(null);
    private static final LongRange EMPTY = new LongRange(1, 0);

    public LongRange(long j, long j2) {
        super(j, j2, 1L);
    }

    @Override // kotlin.ranges.ClosedRange
    public Long getStart() {
        return Long.valueOf(getFirst());
    }

    @Override // kotlin.ranges.ClosedRange
    public Long getEndInclusive() {
        return Long.valueOf(getLast());
    }

    @Override // kotlin.ranges.LongProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // kotlin.ranges.LongProgression
    public boolean equals(Object obj) {
        if (!(obj instanceof LongRange)) {
            return false;
        }
        if (isEmpty() && ((LongRange) obj).isEmpty()) {
            return true;
        }
        LongRange longRange = (LongRange) obj;
        return getFirst() == longRange.getFirst() && getLast() == longRange.getLast();
    }

    @Override // kotlin.ranges.LongProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (getFirst() ^ (getFirst() >>> 32))) + (getLast() ^ (getLast() >>> 32)));
    }

    @Override // kotlin.ranges.LongProgression
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LongRange getEMPTY() {
            return LongRange.EMPTY;
        }
    }
}
