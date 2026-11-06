package kotlin.ranges;

/* JADX INFO: loaded from: classes5.dex */
final class ClosedFloatRange implements ClosedFloatingPointRange {
    private final float _endInclusive;
    private final float _start;

    public boolean lessThanOrEquals(float f, float f2) {
        return f <= f2;
    }

    public ClosedFloatRange(float f, float f2) {
        this._start = f;
        this._endInclusive = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Comparable comparable, Comparable comparable2) {
        return lessThanOrEquals(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    @Override // kotlin.ranges.ClosedRange
    public Float getStart() {
        return Float.valueOf(this._start);
    }

    @Override // kotlin.ranges.ClosedRange
    public Float getEndInclusive() {
        return Float.valueOf(this._endInclusive);
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return this._start > this._endInclusive;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ClosedFloatRange)) {
            return false;
        }
        if (isEmpty() && ((ClosedFloatRange) obj).isEmpty()) {
            return true;
        }
        ClosedFloatRange closedFloatRange = (ClosedFloatRange) obj;
        return this._start == closedFloatRange._start && this._endInclusive == closedFloatRange._endInclusive;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.hashCode(this._start) * 31) + Float.hashCode(this._endInclusive);
    }

    public String toString() {
        return this._start + ".." + this._endInclusive;
    }
}
