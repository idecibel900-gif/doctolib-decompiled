package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class TextLayoutResultProxy {
    private LayoutCoordinates decorationBoxCoordinates;
    private LayoutCoordinates innerTextFieldCoordinates;
    private final TextLayoutResult value;

    public TextLayoutResultProxy(TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2) {
        this.value = textLayoutResult;
        this.innerTextFieldCoordinates = layoutCoordinates;
        this.decorationBoxCoordinates = layoutCoordinates2;
    }

    public /* synthetic */ TextLayoutResultProxy(TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textLayoutResult, (i & 2) != 0 ? null : layoutCoordinates, (i & 4) != 0 ? null : layoutCoordinates2);
    }

    public final TextLayoutResult getValue() {
        return this.value;
    }

    public final LayoutCoordinates getInnerTextFieldCoordinates() {
        return this.innerTextFieldCoordinates;
    }

    public final void setInnerTextFieldCoordinates(LayoutCoordinates layoutCoordinates) {
        this.innerTextFieldCoordinates = layoutCoordinates;
    }

    public final LayoutCoordinates getDecorationBoxCoordinates() {
        return this.decorationBoxCoordinates;
    }

    public final void setDecorationBoxCoordinates(LayoutCoordinates layoutCoordinates) {
        this.decorationBoxCoordinates = layoutCoordinates;
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k$default, reason: not valid java name */
    public static /* synthetic */ int m552getOffsetForPosition3MmeM6k$default(TextLayoutResultProxy textLayoutResultProxy, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return textLayoutResultProxy.m553getOffsetForPosition3MmeM6k(j, z);
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    public final int m553getOffsetForPosition3MmeM6k(long j, boolean z) {
        if (z) {
            j = m551coercedInVisibleBoundsOfInputTextMKHz9U(j);
        }
        return this.value.m2202getOffsetForPositionk4lQ0M(m555translateDecorationToInnerCoordinatesMKHz9U$foundation_release(j));
    }

    /* JADX INFO: renamed from: isPositionOnText-k-4lQ0M, reason: not valid java name */
    public final boolean m554isPositionOnTextk4lQ0M(long j) {
        long jM555translateDecorationToInnerCoordinatesMKHz9U$foundation_release = m555translateDecorationToInnerCoordinatesMKHz9U$foundation_release(m551coercedInVisibleBoundsOfInputTextMKHz9U(j));
        int lineForVerticalPosition = this.value.getLineForVerticalPosition(Offset.m1224getYimpl(jM555translateDecorationToInnerCoordinatesMKHz9U$foundation_release));
        return Offset.m1223getXimpl(jM555translateDecorationToInnerCoordinatesMKHz9U$foundation_release) >= this.value.getLineLeft(lineForVerticalPosition) && Offset.m1223getXimpl(jM555translateDecorationToInnerCoordinatesMKHz9U$foundation_release) <= this.value.getLineRight(lineForVerticalPosition);
    }

    /* JADX INFO: renamed from: translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release, reason: not valid java name */
    public final long m555translateDecorationToInnerCoordinatesMKHz9U$foundation_release(long j) {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.innerTextFieldCoordinates;
        if (layoutCoordinates2 == null) {
            return j;
        }
        if (!layoutCoordinates2.isAttached()) {
            layoutCoordinates2 = null;
        }
        if (layoutCoordinates2 == null || (layoutCoordinates = this.decorationBoxCoordinates) == null) {
            return j;
        }
        LayoutCoordinates layoutCoordinates3 = layoutCoordinates.isAttached() ? layoutCoordinates : null;
        return layoutCoordinates3 == null ? j : layoutCoordinates2.mo1846localPositionOfR5De75A(layoutCoordinates3, j);
    }

    /* JADX INFO: renamed from: translateInnerToDecorationCoordinates-MK-Hz9U$foundation_release, reason: not valid java name */
    public final long m556translateInnerToDecorationCoordinatesMKHz9U$foundation_release(long j) {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.innerTextFieldCoordinates;
        if (layoutCoordinates2 == null) {
            return j;
        }
        if (!layoutCoordinates2.isAttached()) {
            layoutCoordinates2 = null;
        }
        if (layoutCoordinates2 == null || (layoutCoordinates = this.decorationBoxCoordinates) == null) {
            return j;
        }
        LayoutCoordinates layoutCoordinates3 = layoutCoordinates.isAttached() ? layoutCoordinates : null;
        return layoutCoordinates3 == null ? j : layoutCoordinates3.mo1846localPositionOfR5De75A(layoutCoordinates2, j);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    /* JADX INFO: renamed from: coercedInVisibleBoundsOfInputText-MK-Hz9U, reason: not valid java name */
    private final long m551coercedInVisibleBoundsOfInputTextMKHz9U(long j) {
        Rect zero;
        LayoutCoordinates layoutCoordinates = this.innerTextFieldCoordinates;
        if (layoutCoordinates != null) {
            if (layoutCoordinates.isAttached()) {
                LayoutCoordinates layoutCoordinates2 = this.decorationBoxCoordinates;
                zero = null;
                if (layoutCoordinates2 != null) {
                    zero = LayoutCoordinates.localBoundingBoxOf$default(layoutCoordinates2, layoutCoordinates, false, 2, null);
                }
            } else {
                zero = Rect.Companion.getZero();
            }
            if (zero == null) {
                zero = Rect.Companion.getZero();
            }
        } else {
            zero = Rect.Companion.getZero();
        }
        return TextLayoutResultProxyKt.m558coerceIn3MmeM6k(j, zero);
    }
}
