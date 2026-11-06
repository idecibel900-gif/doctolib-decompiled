package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.unit.Density;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;

/* JADX INFO: loaded from: classes.dex */
public abstract class ScrollableKt {
    private static final Function1 CanDragCalculation = new Function1() { // from class: androidx.compose.foundation.gestures.ScrollableKt$CanDragCalculation$1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(PointerInputChange pointerInputChange) {
            return Boolean.valueOf(!PointerType.m1801equalsimpl0(pointerInputChange.m1781getTypeT8wyACA(), PointerType.Companion.m1805getMouseT8wyACA()));
        }
    };
    private static final ScrollScope NoOpScrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollableKt$NoOpScrollScope$1
        @Override // androidx.compose.foundation.gestures.ScrollScope
        public float scrollBy(float f) {
            return f;
        }
    };
    private static final MotionDurationScale DefaultScrollMotionDurationScale = new MotionDurationScale() { // from class: androidx.compose.foundation.gestures.ScrollableKt$DefaultScrollMotionDurationScale$1
        @Override // androidx.compose.ui.MotionDurationScale
        public float getScaleFactor() {
            return 1.0f;
        }

        @Override // kotlin.coroutines.CoroutineContext
        public Object fold(Object obj, Function2 function2) {
            return MotionDurationScale.DefaultImpls.fold(this, obj, function2);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public CoroutineContext.Element get(CoroutineContext.Key key) {
            return MotionDurationScale.DefaultImpls.get(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext
        public CoroutineContext minusKey(CoroutineContext.Key key) {
            return MotionDurationScale.DefaultImpls.minusKey(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext
        public CoroutineContext plus(CoroutineContext coroutineContext) {
            return MotionDurationScale.DefaultImpls.plus(this, coroutineContext);
        }
    };
    private static final ScrollableKt$UnityDensity$1 UnityDensity = new Density() { // from class: androidx.compose.foundation.gestures.ScrollableKt$UnityDensity$1
        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return 1.0f;
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return 1.0f;
        }
    };

    public static /* synthetic */ Modifier scrollable$default(Modifier modifier, ScrollableState scrollableState, Orientation orientation, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = false;
        }
        return scrollable(modifier, scrollableState, orientation, z3, z2, (i & 16) != 0 ? null : flingBehavior, (i & 32) != 0 ? null : mutableInteractionSource);
    }

    public static final Modifier scrollable(Modifier modifier, ScrollableState scrollableState, Orientation orientation, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource) {
        return scrollable$default(modifier, scrollableState, orientation, null, z, z2, flingBehavior, mutableInteractionSource, null, 128, null);
    }

    public static /* synthetic */ Modifier scrollable$default(Modifier modifier, ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return scrollable(modifier, scrollableState, orientation, overscrollEffect, z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? null : flingBehavior, (i & 64) != 0 ? null : mutableInteractionSource, (i & 128) != 0 ? null : bringIntoViewSpec);
    }

    public static final Modifier scrollable(Modifier modifier, ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        return modifier.then(new ScrollableElement(scrollableState, orientation, overscrollEffect, z, z2, flingBehavior, mutableInteractionSource, bringIntoViewSpec));
    }

    public static final MotionDurationScale getDefaultScrollMotionDurationScale() {
        return DefaultScrollMotionDurationScale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: semanticsScrollBy-d-4ec7I, reason: not valid java name */
    public static final Object m236semanticsScrollByd4ec7I(ScrollingLogic scrollingLogic, long j, Continuation continuation) {
        ScrollableKt$semanticsScrollBy$1 scrollableKt$semanticsScrollBy$1;
        Ref$FloatRef ref$FloatRef;
        ScrollingLogic scrollingLogic2;
        if (continuation instanceof ScrollableKt$semanticsScrollBy$1) {
            scrollableKt$semanticsScrollBy$1 = (ScrollableKt$semanticsScrollBy$1) continuation;
            int i = scrollableKt$semanticsScrollBy$1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                scrollableKt$semanticsScrollBy$1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                scrollableKt$semanticsScrollBy$1 = new ScrollableKt$semanticsScrollBy$1(continuation);
            }
        } else {
            scrollableKt$semanticsScrollBy$1 = new ScrollableKt$semanticsScrollBy$1(continuation);
        }
        Object obj = scrollableKt$semanticsScrollBy$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = scrollableKt$semanticsScrollBy$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ref$FloatRef = new Ref$FloatRef();
            MutatePriority mutatePriority = MutatePriority.Default;
            ScrollableKt$semanticsScrollBy$2 scrollableKt$semanticsScrollBy$2 = new ScrollableKt$semanticsScrollBy$2(scrollingLogic, j, ref$FloatRef, null);
            scrollableKt$semanticsScrollBy$1.L$0 = scrollingLogic;
            scrollableKt$semanticsScrollBy$1.L$1 = ref$FloatRef;
            scrollableKt$semanticsScrollBy$1.label = 1;
            if (scrollingLogic.scroll(mutatePriority, scrollableKt$semanticsScrollBy$2, scrollableKt$semanticsScrollBy$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            scrollingLogic2 = scrollingLogic;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref$FloatRef ref$FloatRef2 = (Ref$FloatRef) scrollableKt$semanticsScrollBy$1.L$1;
            ScrollingLogic scrollingLogic3 = (ScrollingLogic) scrollableKt$semanticsScrollBy$1.L$0;
            ResultKt.throwOnFailure(obj);
            ref$FloatRef = ref$FloatRef2;
            scrollingLogic2 = scrollingLogic3;
        }
        return Offset.m1214boximpl(scrollingLogic2.m255toOffsettuRUvjQ(ref$FloatRef.element));
    }
}
