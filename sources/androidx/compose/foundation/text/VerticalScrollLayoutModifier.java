package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.unit.Constraints;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class VerticalScrollLayoutModifier implements LayoutModifier {
    private final int cursorOffset;
    private final TextFieldScrollerPosition scrollerPosition;
    private final Function0 textLayoutResultProvider;
    private final TransformedText transformedText;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerticalScrollLayoutModifier)) {
            return false;
        }
        VerticalScrollLayoutModifier verticalScrollLayoutModifier = (VerticalScrollLayoutModifier) obj;
        return Intrinsics.areEqual(this.scrollerPosition, verticalScrollLayoutModifier.scrollerPosition) && this.cursorOffset == verticalScrollLayoutModifier.cursorOffset && Intrinsics.areEqual(this.transformedText, verticalScrollLayoutModifier.transformedText) && Intrinsics.areEqual(this.textLayoutResultProvider, verticalScrollLayoutModifier.textLayoutResultProvider);
    }

    public int hashCode() {
        return (((((this.scrollerPosition.hashCode() * 31) + Integer.hashCode(this.cursorOffset)) * 31) + this.transformedText.hashCode()) * 31) + this.textLayoutResultProvider.hashCode();
    }

    public String toString() {
        return "VerticalScrollLayoutModifier(scrollerPosition=" + this.scrollerPosition + ", cursorOffset=" + this.cursorOffset + ", transformedText=" + this.transformedText + ", textLayoutResultProvider=" + this.textLayoutResultProvider + ')';
    }

    public VerticalScrollLayoutModifier(TextFieldScrollerPosition textFieldScrollerPosition, int i, TransformedText transformedText, Function0 function0) {
        this.scrollerPosition = textFieldScrollerPosition;
        this.cursorOffset = i;
        this.transformedText = transformedText;
        this.textLayoutResultProvider = function0;
    }

    public final TextFieldScrollerPosition getScrollerPosition() {
        return this.scrollerPosition;
    }

    public final int getCursorOffset() {
        return this.cursorOffset;
    }

    public final TransformedText getTransformedText() {
        return this.transformedText;
    }

    public final Function0 getTextLayoutResultProvider() {
        return this.textLayoutResultProvider;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo32measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable placeableMo1843measureBRTryo0 = measurable.mo1843measureBRTryo0(Constraints.m2522copyZbe2FdA$default(j, 0, 0, 0, Integer.MAX_VALUE, 7, null));
        final int iMin = Math.min(placeableMo1843measureBRTryo0.getHeight(), Constraints.m2529getMaxHeightimpl(j));
        return MeasureScope.layout$default(measureScope, placeableMo1843measureBRTryo0.getWidth(), iMin, null, new Function1() { // from class: androidx.compose.foundation.text.VerticalScrollLayoutModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                MeasureScope measureScope2 = measureScope;
                int cursorOffset = this.getCursorOffset();
                TransformedText transformedText = this.getTransformedText();
                TextLayoutResultProxy textLayoutResultProxy = (TextLayoutResultProxy) this.getTextLayoutResultProvider().invoke();
                this.getScrollerPosition().update(Orientation.Vertical, TextFieldScrollKt.getCursorRectInScroller(measureScope2, cursorOffset, transformedText, textLayoutResultProxy != null ? textLayoutResultProxy.getValue() : null, false, placeableMo1843measureBRTryo0.getWidth()), iMin, placeableMo1843measureBRTryo0.getHeight());
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo1843measureBRTryo0, 0, Math.round(-this.getScrollerPosition().getOffset()), 0.0f, 4, null);
            }
        }, 4, null);
    }
}
