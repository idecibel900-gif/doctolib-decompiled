package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class CharRange extends CharProgression implements ClosedRange {
    public static final Companion Companion = new Companion(null);
    private static final CharRange EMPTY = new CharRange(1, 0);

    public CharRange(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // kotlin.ranges.ClosedRange
    public Character getStart() {
        return Character.valueOf(getFirst());
    }

    @Override // kotlin.ranges.ClosedRange
    public Character getEndInclusive() {
        return Character.valueOf(getLast());
    }

    public boolean contains(char c) {
        return Intrinsics.compare((int) getFirst(), (int) c) <= 0 && Intrinsics.compare((int) c, (int) getLast()) <= 0;
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return Intrinsics.compare((int) getFirst(), (int) getLast()) > 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CharRange)) {
            return false;
        }
        if (isEmpty() && ((CharRange) obj).isEmpty()) {
            return true;
        }
        CharRange charRange = (CharRange) obj;
        return getFirst() == charRange.getFirst() && getLast() == charRange.getLast();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    public String toString() {
        return getFirst() + ".." + getLast();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
