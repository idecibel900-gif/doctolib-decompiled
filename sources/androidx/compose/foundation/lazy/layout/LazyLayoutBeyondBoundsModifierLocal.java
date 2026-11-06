package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutBeyondBoundsModifierLocal implements ModifierLocalProvider, BeyondBoundsLayout {
    public static final Companion Companion = new Companion(null);
    private static final LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1 emptyBeyondBoundsScope = new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1
        private final boolean hasMoreContent;

        @Override // androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope
        public boolean getHasMoreContent() {
            return this.hasMoreContent;
        }
    };
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final LayoutDirection layoutDirection;
    private final Orientation orientation;
    private final boolean reverseLayout;
    private final LazyLayoutBeyondBoundsState state;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public BeyondBoundsLayout getValue() {
        return this;
    }

    public LazyLayoutBeyondBoundsModifierLocal(LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsState, LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo, boolean z, LayoutDirection layoutDirection, Orientation orientation) {
        this.state = lazyLayoutBeyondBoundsState;
        this.beyondBoundsInfo = lazyLayoutBeyondBoundsInfo;
        this.reverseLayout = z;
        this.layoutDirection = layoutDirection;
        this.orientation = orientation;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal getKey() {
        return BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // androidx.compose.ui.layout.BeyondBoundsLayout
    /* JADX INFO: renamed from: layout-o7g1Pn8, reason: not valid java name */
    public Object mo405layouto7g1Pn8(final int i, Function1 function1) {
        int firstPlacedIndex;
        if (this.state.getItemCount() <= 0 || !this.state.getHasVisibleItems()) {
            return function1.invoke(emptyBeyondBoundsScope);
        }
        if (m403isForward4vf7U8o(i)) {
            firstPlacedIndex = this.state.getLastPlacedIndex();
        } else {
            firstPlacedIndex = this.state.getFirstPlacedIndex();
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = this.beyondBoundsInfo.addInterval(firstPlacedIndex, firstPlacedIndex);
        Object objInvoke = null;
        while (objInvoke == null && m402hasMoreContentFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element, i)) {
            LazyLayoutBeyondBoundsInfo.Interval intervalM401addNextIntervalFR3nfPY = m401addNextIntervalFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element, i);
            this.beyondBoundsInfo.removeInterval((LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element);
            ref$ObjectRef.element = intervalM401addNextIntervalFR3nfPY;
            this.state.remeasure();
            objInvoke = function1.invoke(new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal$layout$2
                @Override // androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope
                public boolean getHasMoreContent() {
                    return this.this$0.m402hasMoreContentFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element, i);
                }
            });
        }
        this.beyondBoundsInfo.removeInterval((LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element);
        this.state.remeasure();
        return objInvoke;
    }

    /* JADX INFO: renamed from: isForward-4vf7U8o, reason: not valid java name */
    private final boolean m403isForward4vf7U8o(int i) {
        BeyondBoundsLayout.LayoutDirection.Companion companion = BeyondBoundsLayout.LayoutDirection.Companion;
        if (BeyondBoundsLayout.LayoutDirection.m1826equalsimpl0(i, companion.m1829getBeforehoxUOeE())) {
            return false;
        }
        if (BeyondBoundsLayout.LayoutDirection.m1826equalsimpl0(i, companion.m1828getAfterhoxUOeE())) {
            return true;
        }
        if (BeyondBoundsLayout.LayoutDirection.m1826equalsimpl0(i, companion.m1827getAbovehoxUOeE())) {
            return this.reverseLayout;
        }
        if (BeyondBoundsLayout.LayoutDirection.m1826equalsimpl0(i, companion.m1830getBelowhoxUOeE())) {
            return !this.reverseLayout;
        }
        if (BeyondBoundsLayout.LayoutDirection.m1826equalsimpl0(i, companion.m1831getLefthoxUOeE())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
            if (i2 == 1) {
                return this.reverseLayout;
            }
            if (i2 == 2) {
                return !this.reverseLayout;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!BeyondBoundsLayout.LayoutDirection.m1826equalsimpl0(i, companion.m1832getRighthoxUOeE())) {
            LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
            throw new KotlinNothingValueException();
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
        if (i3 == 1) {
            return !this.reverseLayout;
        }
        if (i3 == 2) {
            return this.reverseLayout;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: addNextInterval-FR3nfPY, reason: not valid java name */
    private final LazyLayoutBeyondBoundsInfo.Interval m401addNextIntervalFR3nfPY(LazyLayoutBeyondBoundsInfo.Interval interval, int i) {
        int start = interval.getStart();
        int end = interval.getEnd();
        if (m403isForward4vf7U8o(i)) {
            end++;
        } else {
            start--;
        }
        return this.beyondBoundsInfo.addInterval(start, end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hasMoreContent-FR3nfPY, reason: not valid java name */
    public final boolean m402hasMoreContentFR3nfPY(LazyLayoutBeyondBoundsInfo.Interval interval, int i) {
        if (m404isOppositeToOrientation4vf7U8o(i)) {
            return false;
        }
        if (m403isForward4vf7U8o(i)) {
            return interval.getEnd() < this.state.getItemCount() - 1;
        }
        return interval.getStart() > 0;
    }

    /* JADX INFO: renamed from: isOppositeToOrientation-4vf7U8o, reason: not valid java name */
    private final boolean m404isOppositeToOrientation4vf7U8o(int i) {
        BeyondBoundsLayout.LayoutDirection.Companion companion = BeyondBoundsLayout.LayoutDirection.Companion;
        if (BeyondBoundsLayout.LayoutDirection.m1826equalsimpl0(i, companion.m1827getAbovehoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m1826equalsimpl0(i, companion.m1830getBelowhoxUOeE())) {
            return this.orientation == Orientation.Horizontal;
        }
        if (BeyondBoundsLayout.LayoutDirection.m1826equalsimpl0(i, companion.m1831getLefthoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m1826equalsimpl0(i, companion.m1832getRighthoxUOeE())) {
            return this.orientation == Orientation.Vertical;
        }
        if (BeyondBoundsLayout.LayoutDirection.m1826equalsimpl0(i, companion.m1829getBeforehoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m1826equalsimpl0(i, companion.m1828getAfterhoxUOeE())) {
            return false;
        }
        LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
        throw new KotlinNothingValueException();
    }
}
