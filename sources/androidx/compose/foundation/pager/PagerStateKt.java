package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class PagerStateKt {
    private static final float DefaultPositionThreshold = Dp.m2551constructorimpl(56);
    private static final PagerMeasureResult EmptyLayoutInfo = new PagerMeasureResult(CollectionsKt.emptyList(), 0, 0, 0, Orientation.Horizontal, 0, 0, false, 0, null, null, 0.0f, 0, false, SnapPosition.Start.INSTANCE, new MeasureResult() { // from class: androidx.compose.foundation.pager.PagerStateKt$EmptyLayoutInfo$1
        private final Map alignmentLines = MapsKt.emptyMap();
        private final int height;
        private final int width;

        @Override // androidx.compose.ui.layout.MeasureResult
        public void placeChildren() {
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        public int getWidth() {
            return this.width;
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        public int getHeight() {
            return this.height;
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        public Map getAlignmentLines() {
            return this.alignmentLines;
        }
    }, false, null, null, CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), 393216, null);
    private static final PagerStateKt$UnitDensity$1 UnitDensity = new Density() { // from class: androidx.compose.foundation.pager.PagerStateKt$UnitDensity$1
        private final float density = 1.0f;
        private final float fontScale = 1.0f;

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.density;
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return this.fontScale;
        }
    };

    public static final PagerState rememberPagerState(final int i, final float f, final Function0 function0, Composer composer, int i2, int i3) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            f = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1210768637, i2, -1, "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:86)");
        }
        Object[] objArr = new Object[0];
        Saver saver = DefaultPagerState.Companion.getSaver();
        boolean z = ((((i2 & 14) ^ 6) > 4 && composer.changed(i)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(f)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(function0)) || (i2 & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final DefaultPagerState invoke() {
                    return new DefaultPagerState(i, f, function0);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        DefaultPagerState defaultPagerState = (DefaultPagerState) RememberSaveableKt.rememberSaveable(objArr, saver, null, (Function0) objRememberedValue, composer, 0, 4);
        defaultPagerState.getPageCountState().setValue(function0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultPagerState;
    }

    public static final Object animateToNextPage(PagerState pagerState, Continuation continuation) {
        if (pagerState.getCurrentPage() + 1 >= pagerState.getPageCount()) {
            return Unit.INSTANCE;
        }
        Object objAnimateScrollToPage$default = PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() + 1, 0.0f, null, continuation, 6, null);
        return objAnimateScrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateScrollToPage$default : Unit.INSTANCE;
    }

    public static final Object animateToPreviousPage(PagerState pagerState, Continuation continuation) {
        if (pagerState.getCurrentPage() - 1 < 0) {
            return Unit.INSTANCE;
        }
        Object objAnimateScrollToPage$default = PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() - 1, 0.0f, null, continuation, 6, null);
        return objAnimateScrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateScrollToPage$default : Unit.INSTANCE;
    }

    public static final float getDefaultPositionThreshold() {
        return DefaultPositionThreshold;
    }

    public static final PagerMeasureResult getEmptyLayoutInfo() {
        return EmptyLayoutInfo;
    }

    public static final long calculateNewMaxScrollOffset(PagerLayoutInfo pagerLayoutInfo, int i) {
        long pageSpacing = (((long) i) * ((long) (pagerLayoutInfo.getPageSpacing() + pagerLayoutInfo.getPageSize()))) + ((long) pagerLayoutInfo.getBeforeContentPadding()) + ((long) pagerLayoutInfo.getAfterContentPadding());
        int iM2609getWidthimpl = pagerLayoutInfo.getOrientation() == Orientation.Horizontal ? IntSize.m2609getWidthimpl(pagerLayoutInfo.mo437getViewportSizeYbymL2g()) : IntSize.m2608getHeightimpl(pagerLayoutInfo.mo437getViewportSizeYbymL2g());
        return RangesKt.coerceAtLeast(pageSpacing - ((long) (iM2609getWidthimpl - RangesKt.coerceIn(pagerLayoutInfo.getSnapPosition().position(iM2609getWidthimpl, pagerLayoutInfo.getPageSize(), pagerLayoutInfo.getBeforeContentPadding(), pagerLayoutInfo.getAfterContentPadding(), i - 1, i), 0, iM2609getWidthimpl))), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long calculateNewMinScrollOffset(PagerMeasureResult pagerMeasureResult, int i) {
        int iM2609getWidthimpl = pagerMeasureResult.getOrientation() == Orientation.Horizontal ? IntSize.m2609getWidthimpl(pagerMeasureResult.mo437getViewportSizeYbymL2g()) : IntSize.m2608getHeightimpl(pagerMeasureResult.mo437getViewportSizeYbymL2g());
        return RangesKt.coerceIn(pagerMeasureResult.getSnapPosition().position(iM2609getWidthimpl, pagerMeasureResult.getPageSize(), pagerMeasureResult.getBeforeContentPadding(), pagerMeasureResult.getAfterContentPadding(), 0, i), 0, iM2609getWidthimpl);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerStateKt$animateScrollToPage$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ AnimationSpec $animationSpec;
        final /* synthetic */ int $targetPage;
        final /* synthetic */ float $targetPageOffsetToSnappedPosition;
        final /* synthetic */ LazyLayoutAnimateScrollScope $this_animateScrollToPage;
        final /* synthetic */ Function2 $updateTargetPage;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Function2 function2, int i, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, float f, AnimationSpec animationSpec, Continuation continuation) {
            super(2, continuation);
            this.$updateTargetPage = function2;
            this.$targetPage = i;
            this.$this_animateScrollToPage = lazyLayoutAnimateScrollScope;
            this.$targetPageOffsetToSnappedPosition = f;
            this.$animationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$updateTargetPage, this.$targetPage, this.$this_animateScrollToPage, this.$targetPageOffsetToSnappedPosition, this.$animationSpec, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation continuation) {
            return ((AnonymousClass2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int iCoerceAtMost;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ScrollScope scrollScope = (ScrollScope) this.L$0;
                this.$updateTargetPage.invoke(scrollScope, Boxing.boxInt(this.$targetPage));
                boolean z = this.$targetPage > this.$this_animateScrollToPage.getFirstVisibleItemIndex();
                int lastVisibleItemIndex = (this.$this_animateScrollToPage.getLastVisibleItemIndex() - this.$this_animateScrollToPage.getFirstVisibleItemIndex()) + 1;
                if (((z && this.$targetPage > this.$this_animateScrollToPage.getLastVisibleItemIndex()) || (!z && this.$targetPage < this.$this_animateScrollToPage.getFirstVisibleItemIndex())) && Math.abs(this.$targetPage - this.$this_animateScrollToPage.getFirstVisibleItemIndex()) >= 3) {
                    if (z) {
                        iCoerceAtMost = RangesKt.coerceAtLeast(this.$targetPage - lastVisibleItemIndex, this.$this_animateScrollToPage.getFirstVisibleItemIndex());
                    } else {
                        iCoerceAtMost = RangesKt.coerceAtMost(this.$targetPage + lastVisibleItemIndex, this.$this_animateScrollToPage.getFirstVisibleItemIndex());
                    }
                    this.$this_animateScrollToPage.snapToItem(scrollScope, iCoerceAtMost, 0);
                }
                float fCalculateDistanceTo = this.$this_animateScrollToPage.calculateDistanceTo(this.$targetPage) + this.$targetPageOffsetToSnappedPosition;
                final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
                AnimationSpec animationSpec = this.$animationSpec;
                Function2 function2 = new Function2() { // from class: androidx.compose.foundation.pager.PagerStateKt.animateScrollToPage.2.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f, float f2) {
                        ref$FloatRef.element += scrollScope.scrollBy(f - ref$FloatRef.element);
                    }
                };
                this.label = 1;
                if (SuspendAnimationKt.animate$default(0.0f, fCalculateDistanceTo, 0.0f, animationSpec, function2, this, 4, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object animateScrollToPage(LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i, float f, AnimationSpec animationSpec, Function2 function2, Continuation continuation) {
        Object objScroll = lazyLayoutAnimateScrollScope.scroll(new AnonymousClass2(function2, i, lazyLayoutAnimateScrollScope, f, animationSpec, null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }
}
