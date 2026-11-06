package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class PagerState implements ScrollableState {
    private float accumulator;
    private final LazyLayoutAnimateScrollScope animatedScrollScope;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    private Density density;
    private int firstVisiblePage;
    private int firstVisiblePageOffset;
    private int indexToPrefetch;
    private final MutableInteractionSource internalInteractionSource;
    private final MutableState isLastScrollBackwardState;
    private final MutableState isLastScrollForwardState;
    private int layoutWithMeasurement;
    private int layoutWithoutMeasurement;
    private long maxScrollOffset;
    private final MutableState measurementScopeInvalidator;
    private long minScrollOffset;
    private MutableState pagerLayoutInfoState;
    private final LazyLayoutPinnedItemList pinnedPages;
    private final MutableState placementScopeInvalidator;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private long premeasureConstraints;
    private float previousPassDelta;
    private final MutableIntState programmaticScrollTargetPage$delegate;
    private final MutableState remeasurement$delegate;
    private final RemeasurementModifier remeasurementModifier;
    private final PagerScrollPosition scrollPosition;
    private final ScrollableState scrollableState;
    private final State settledPage$delegate;
    private final MutableIntState settledPageState$delegate;
    private final State targetPage$delegate;
    private final MutableState upDownDifference$delegate;
    private boolean wasPrefetchingForward;

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$animateScrollToPage$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return PagerState.this.animateScrollToPage(0, 0.0f, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$scroll$1, reason: invalid class name and case insensitive filesystem */
    static final class C02071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02071(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return PagerState.scroll$suspendImpl(PagerState.this, null, null, this);
        }
    }

    public abstract int getPageCount();

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
        return scroll$suspendImpl(this, mutatePriority, function2, continuation);
    }

    public PagerState(int i, float f, PrefetchScheduler prefetchScheduler) {
        double d = f;
        if (-0.5d <= d && d <= 0.5d) {
            this.upDownDifference$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m1214boximpl(Offset.Companion.m1235getZeroF1C5BW0()), null, 2, null);
            this.animatedScrollScope = PagerLazyAnimateScrollScopeKt.PagerLazyAnimateScrollScope(this);
            PagerScrollPosition pagerScrollPosition = new PagerScrollPosition(i, f, this);
            this.scrollPosition = pagerScrollPosition;
            this.firstVisiblePage = i;
            this.maxScrollOffset = Long.MAX_VALUE;
            this.scrollableState = ScrollableStateKt.ScrollableState(new Function1() { // from class: androidx.compose.foundation.pager.PagerState$scrollableState$1
                {
                    super(1);
                }

                public final Float invoke(float f2) {
                    return Float.valueOf(this.this$0.performScroll(f2));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).floatValue());
                }
            });
            this.prefetchingEnabled = true;
            this.indexToPrefetch = -1;
            this.pagerLayoutInfoState = SnapshotStateKt.mutableStateOf(PagerStateKt.getEmptyLayoutInfo(), SnapshotStateKt.neverEqualPolicy());
            this.density = PagerStateKt.UnitDensity;
            this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
            this.programmaticScrollTargetPage$delegate = SnapshotIntStateKt.mutableIntStateOf(-1);
            this.settledPageState$delegate = SnapshotIntStateKt.mutableIntStateOf(i);
            this.settledPage$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.foundation.pager.PagerState$settledPage$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    int currentPage;
                    if (this.this$0.isScrollInProgress()) {
                        currentPage = this.this$0.getSettledPageState();
                    } else {
                        currentPage = this.this$0.getCurrentPage();
                    }
                    return Integer.valueOf(currentPage);
                }
            });
            this.targetPage$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.foundation.pager.PagerState$targetPage$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    int currentPage;
                    if (this.this$0.isScrollInProgress()) {
                        if (this.this$0.getProgrammaticScrollTargetPage() != -1) {
                            currentPage = this.this$0.getProgrammaticScrollTargetPage();
                        } else if (Math.abs(this.this$0.getCurrentPageOffsetFraction()) >= Math.abs(this.this$0.getPositionThresholdFraction$foundation_release())) {
                            if (this.this$0.getLastScrolledForward()) {
                                currentPage = this.this$0.getFirstVisiblePage$foundation_release() + 1;
                            } else {
                                currentPage = this.this$0.getFirstVisiblePage$foundation_release();
                            }
                        } else {
                            currentPage = this.this$0.getCurrentPage();
                        }
                    } else {
                        currentPage = this.this$0.getCurrentPage();
                    }
                    return Integer.valueOf(this.this$0.coerceInPageRange(currentPage));
                }
            });
            this.prefetchState = new LazyLayoutPrefetchState(prefetchScheduler, null, 2, null);
            this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
            this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
            this.remeasurement$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            this.remeasurementModifier = new RemeasurementModifier() { // from class: androidx.compose.foundation.pager.PagerState$remeasurementModifier$1
                @Override // androidx.compose.ui.layout.RemeasurementModifier
                public void onRemeasurementAvailable(Remeasurement remeasurement) {
                    this.this$0.setRemeasurement(remeasurement);
                }
            };
            this.premeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
            this.pinnedPages = new LazyLayoutPinnedItemList();
            pagerScrollPosition.getNearestRangeState();
            this.placementScopeInvalidator = ObservableScopeInvalidator.m425constructorimpl$default(null, 1, null);
            this.measurementScopeInvalidator = ObservableScopeInvalidator.m425constructorimpl$default(null, 1, null);
            Boolean bool = Boolean.FALSE;
            this.canScrollForward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
            this.canScrollBackward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
            this.isLastScrollForwardState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
            this.isLastScrollBackwardState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
            return;
        }
        throw new IllegalArgumentException(("currentPageOffsetFraction " + f + " is not within the range -0.5 to 0.5").toString());
    }

    public PagerState(int i, float f) {
        this(i, f, null);
    }

    /* JADX INFO: renamed from: getUpDownDifference-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m445getUpDownDifferenceF1C5BW0$foundation_release() {
        return ((Offset) this.upDownDifference$delegate.getValue()).m1232unboximpl();
    }

    /* JADX INFO: renamed from: setUpDownDifference-k-4lQ0M$foundation_release, reason: not valid java name */
    public final void m447setUpDownDifferencek4lQ0M$foundation_release(long j) {
        this.upDownDifference$delegate.setValue(Offset.m1214boximpl(j));
    }

    public final int getFirstVisiblePage$foundation_release() {
        return this.firstVisiblePage;
    }

    public final int getFirstVisiblePageOffset$foundation_release() {
        return this.firstVisiblePageOffset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float performScroll(float f) {
        long jCurrentAbsoluteScrollOffset = PagerScrollPositionKt.currentAbsoluteScrollOffset(this);
        float f2 = this.accumulator + f;
        long jRoundToLong = MathKt.roundToLong(f2);
        this.accumulator = f2 - jRoundToLong;
        if (Math.abs(f) < 1.0E-4f) {
            return f;
        }
        long j = jCurrentAbsoluteScrollOffset + jRoundToLong;
        long jCoerceIn = RangesKt.coerceIn(j, this.minScrollOffset, this.maxScrollOffset);
        boolean z = j != jCoerceIn;
        long j2 = jCoerceIn - jCurrentAbsoluteScrollOffset;
        float f3 = j2;
        this.previousPassDelta = f3;
        if (Math.abs(j2) != 0) {
            this.isLastScrollForwardState.setValue(Boolean.valueOf(f3 > 0.0f));
            this.isLastScrollBackwardState.setValue(Boolean.valueOf(f3 < 0.0f));
        }
        PagerMeasureResult pagerMeasureResult = (PagerMeasureResult) this.pagerLayoutInfoState.getValue();
        int i = (int) j2;
        if (pagerMeasureResult.tryToApplyScrollWithoutRemeasure(-i)) {
            applyMeasureResult$foundation_release(pagerMeasureResult, true);
            ObservableScopeInvalidator.m426invalidateScopeimpl(this.placementScopeInvalidator);
            this.layoutWithoutMeasurement++;
        } else {
            this.scrollPosition.applyScrollDelta(i);
            Remeasurement remeasurement$foundation_release = getRemeasurement$foundation_release();
            if (remeasurement$foundation_release != null) {
                remeasurement$foundation_release.forceRemeasure();
            }
            this.layoutWithMeasurement++;
        }
        return (z ? Long.valueOf(j2) : Float.valueOf(f)).floatValue();
    }

    public final PagerLayoutInfo getLayoutInfo() {
        return (PagerLayoutInfo) this.pagerLayoutInfoState.getValue();
    }

    public final int getPageSpacing$foundation_release() {
        return ((PagerMeasureResult) this.pagerLayoutInfoState.getValue()).getPageSpacing();
    }

    public final int getPageSize$foundation_release() {
        return ((PagerMeasureResult) this.pagerLayoutInfoState.getValue()).getPageSize();
    }

    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final void setDensity$foundation_release(Density density) {
        this.density = density;
    }

    public final int getPageSizeWithSpacing$foundation_release() {
        return getPageSize$foundation_release() + getPageSpacing$foundation_release();
    }

    public final float getPositionThresholdFraction$foundation_release() {
        return Math.min(this.density.mo231toPx0680j_4(PagerStateKt.getDefaultPositionThreshold()), getPageSize$foundation_release() / 2.0f) / getPageSize$foundation_release();
    }

    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    public final int getCurrentPage() {
        return this.scrollPosition.getCurrentPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getProgrammaticScrollTargetPage() {
        return this.programmaticScrollTargetPage$delegate.getIntValue();
    }

    private final void setProgrammaticScrollTargetPage(int i) {
        this.programmaticScrollTargetPage$delegate.setIntValue(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSettledPageState() {
        return this.settledPageState$delegate.getIntValue();
    }

    private final void setSettledPageState(int i) {
        this.settledPageState$delegate.setIntValue(i);
    }

    public final float getCurrentPageOffsetFraction() {
        return this.scrollPosition.getCurrentPageOffsetFraction();
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo$foundation_release() {
        return this.beyondBoundsInfo;
    }

    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation_release() {
        return this.awaitLayoutModifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRemeasurement(Remeasurement remeasurement) {
        this.remeasurement$delegate.setValue(remeasurement);
    }

    public final Remeasurement getRemeasurement$foundation_release() {
        return (Remeasurement) this.remeasurement$delegate.getValue();
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    /* JADX INFO: renamed from: setPremeasureConstraints-BRTryo0$foundation_release, reason: not valid java name */
    public final void m446setPremeasureConstraintsBRTryo0$foundation_release(long j) {
        this.premeasureConstraints = j;
    }

    public final LazyLayoutPinnedItemList getPinnedPages$foundation_release() {
        return this.pinnedPages;
    }

    public final IntRange getNearestRange$foundation_release() {
        return (IntRange) this.scrollPosition.getNearestRangeState().getValue();
    }

    /* JADX INFO: renamed from: getPlacementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState m444getPlacementScopeInvalidatorzYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    public static /* synthetic */ Object scrollToPage$default(PagerState pagerState, int i, float f, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToPage");
        }
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        return pagerState.scrollToPage(i, f, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$scrollToPage$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $page;
        final /* synthetic */ float $pageOffsetFraction;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(float f, int i, Continuation continuation) {
            super(2, continuation);
            this.$pageOffsetFraction = f;
            this.$page = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PagerState.this.new AnonymousClass2(this.$pageOffsetFraction, this.$page, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation continuation) {
            return ((AnonymousClass2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PagerState pagerState = PagerState.this;
                this.label = 1;
                if (pagerState.awaitScrollDependencies(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            float f = this.$pageOffsetFraction;
            double d = f;
            boolean z = false;
            if (-0.5d <= d && d <= 0.5d) {
                z = true;
            }
            if (z) {
                PagerState.this.snapToItem$foundation_release(PagerState.this.coerceInPageRange(this.$page), this.$pageOffsetFraction, true);
                return Unit.INSTANCE;
            }
            throw new IllegalArgumentException(("pageOffsetFraction " + f + " is not within the range -0.5 to 0.5").toString());
        }
    }

    public final Object scrollToPage(int i, float f, Continuation continuation) {
        Object objScroll$default = ScrollableState.scroll$default(this, null, new AnonymousClass2(f, i, null), continuation, 1, null);
        return objScroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll$default : Unit.INSTANCE;
    }

    public final void updateTargetPage(ScrollScope scrollScope, int i) {
        setProgrammaticScrollTargetPage(coerceInPageRange(i));
    }

    public final void snapToItem$foundation_release(int i, float f, boolean z) {
        this.scrollPosition.requestPositionAndForgetLastKnownKey(i, f);
        if (z) {
            Remeasurement remeasurement$foundation_release = getRemeasurement$foundation_release();
            if (remeasurement$foundation_release != null) {
                remeasurement$foundation_release.forceRemeasure();
                return;
            }
            return;
        }
        ObservableScopeInvalidator.m426invalidateScopeimpl(this.measurementScopeInvalidator);
    }

    /* JADX INFO: renamed from: getMeasurementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState m443getMeasurementScopeInvalidatorzYiylxw$foundation_release() {
        return this.measurementScopeInvalidator;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a2, code lost:
    
        if (androidx.compose.foundation.pager.PagerStateKt.animateScrollToPage(r1, r10, r3, r4, r5, r6) == r0) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateScrollToPage(int r10, float r11, androidx.compose.animation.core.AnimationSpec r12, kotlin.coroutines.Continuation r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof androidx.compose.foundation.pager.PagerState.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r13
            androidx.compose.foundation.pager.PagerState$animateScrollToPage$1 r0 = (androidx.compose.foundation.pager.PagerState.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            androidx.compose.foundation.pager.PagerState$animateScrollToPage$1 r0 = new androidx.compose.foundation.pager.PagerState$animateScrollToPage$1
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L48
            if (r1 == r3) goto L37
            if (r1 != r2) goto L2f
            kotlin.ResultKt.throwOnFailure(r13)
            goto La5
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            float r11 = r6.F$0
            int r10 = r6.I$0
            java.lang.Object r12 = r6.L$1
            androidx.compose.animation.core.AnimationSpec r12 = (androidx.compose.animation.core.AnimationSpec) r12
            java.lang.Object r1 = r6.L$0
            androidx.compose.foundation.pager.PagerState r1 = (androidx.compose.foundation.pager.PagerState) r1
            kotlin.ResultKt.throwOnFailure(r13)
        L46:
            r4 = r12
            goto L76
        L48:
            kotlin.ResultKt.throwOnFailure(r13)
            int r13 = r9.getCurrentPage()
            if (r10 != r13) goto L5a
            float r13 = r9.getCurrentPageOffsetFraction()
            int r13 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r13 != 0) goto L5a
            goto L60
        L5a:
            int r13 = r9.getPageCount()
            if (r13 != 0) goto L63
        L60:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L63:
            r6.L$0 = r9
            r6.L$1 = r12
            r6.I$0 = r10
            r6.F$0 = r11
            r6.label = r3
            java.lang.Object r13 = r9.awaitScrollDependencies(r6)
            if (r13 != r0) goto L74
            goto La4
        L74:
            r1 = r9
            goto L46
        L76:
            double r12 = (double) r11
            r7 = -4620693217682128896(0xbfe0000000000000, double:-0.5)
            int r3 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r3 > 0) goto La8
            r7 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r12 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r12 > 0) goto La8
            int r10 = r1.coerceInPageRange(r10)
            int r12 = r1.getPageSizeWithSpacing$foundation_release()
            float r12 = (float) r12
            float r3 = r11 * r12
            r11 = r1
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r1 = r11.animatedScrollScope
            androidx.compose.foundation.pager.PagerState$animateScrollToPage$3 r5 = new androidx.compose.foundation.pager.PagerState$animateScrollToPage$3
            r5.<init>()
            r11 = 0
            r6.L$0 = r11
            r6.L$1 = r11
            r6.label = r2
            r2 = r10
            java.lang.Object r10 = androidx.compose.foundation.pager.PagerStateKt.access$animateScrollToPage(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto La5
        La4:
            return r0
        La5:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        La8:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = "pageOffsetFraction "
            r10.append(r12)
            r10.append(r11)
            java.lang.String r11 = " is not within the range -0.5 to 0.5"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r10 = r10.toString()
            r11.<init>(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.animateScrollToPage(int, float, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object animateScrollToPage$default(PagerState pagerState, int i, float f, AnimationSpec animationSpec, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateScrollToPage");
        }
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        if ((i2 & 4) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return pagerState.animateScrollToPage(i, f, animationSpec, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitScrollDependencies(Continuation continuation) {
        Object objWaitForFirstLayout = this.awaitLayoutModifier.waitForFirstLayout(continuation);
        return objWaitForFirstLayout == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWaitForFirstLayout : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
    
        if (r8.scroll(r6, r7, r0) == r1) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object scroll$suspendImpl(androidx.compose.foundation.pager.PagerState r5, androidx.compose.foundation.MutatePriority r6, kotlin.jvm.functions.Function2 r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.pager.PagerState.C02071
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.pager.PagerState$scroll$1 r0 = (androidx.compose.foundation.pager.PagerState.C02071) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.pager.PagerState$scroll$1 r0 = new androidx.compose.foundation.pager.PagerState$scroll$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.pager.PagerState r5 = (androidx.compose.foundation.pager.PagerState) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7b
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            java.lang.Object r5 = r0.L$2
            r7 = r5
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r5 = r0.L$1
            r6 = r5
            androidx.compose.foundation.MutatePriority r6 = (androidx.compose.foundation.MutatePriority) r6
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.pager.PagerState r5 = (androidx.compose.foundation.pager.PagerState) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5c
        L4a:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r8 = r5.awaitScrollDependencies(r0)
            if (r8 != r1) goto L5c
            goto L7a
        L5c:
            boolean r8 = r5.isScrollInProgress()
            if (r8 != 0) goto L69
            int r8 = r5.getCurrentPage()
            r5.setSettledPageState(r8)
        L69:
            androidx.compose.foundation.gestures.ScrollableState r8 = r5.scrollableState
            r0.L$0 = r5
            r2 = 0
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r6 = r8.scroll(r6, r7, r0)
            if (r6 != r1) goto L7b
        L7a:
            return r1
        L7b:
            r6 = -1
            r5.setProgrammaticScrollTargetPage(r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.scroll$suspendImpl(androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float f) {
        return this.scrollableState.dispatchRawDelta(f);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    private final void setCanScrollForward(boolean z) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    private final void setCanScrollBackward(boolean z) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    public boolean getLastScrolledForward() {
        return ((Boolean) this.isLastScrollForwardState.getValue()).booleanValue();
    }

    public static /* synthetic */ void applyMeasureResult$foundation_release$default(PagerState pagerState, PagerMeasureResult pagerMeasureResult, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyMeasureResult");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        pagerState.applyMeasureResult$foundation_release(pagerMeasureResult, z);
    }

    public final void applyMeasureResult$foundation_release(PagerMeasureResult pagerMeasureResult, boolean z) {
        if (z) {
            this.scrollPosition.updateCurrentPageOffsetFraction(pagerMeasureResult.getCurrentPageOffsetFraction());
        } else {
            this.scrollPosition.updateFromMeasureResult(pagerMeasureResult);
            cancelPrefetchIfVisibleItemsChanged(pagerMeasureResult);
        }
        this.pagerLayoutInfoState.setValue(pagerMeasureResult);
        setCanScrollForward(pagerMeasureResult.getCanScrollForward());
        setCanScrollBackward(pagerMeasureResult.getCanScrollBackward());
        MeasuredPage firstVisiblePage = pagerMeasureResult.getFirstVisiblePage();
        if (firstVisiblePage != null) {
            this.firstVisiblePage = firstVisiblePage.getIndex();
        }
        this.firstVisiblePageOffset = pagerMeasureResult.getFirstVisiblePageScrollOffset();
        tryRunPrefetch(pagerMeasureResult);
        this.maxScrollOffset = PagerStateKt.calculateNewMaxScrollOffset(pagerMeasureResult, getPageCount());
        this.minScrollOffset = PagerStateKt.calculateNewMinScrollOffset(pagerMeasureResult, getPageCount());
    }

    private final void tryRunPrefetch(PagerMeasureResult pagerMeasureResult) {
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (Math.abs(this.previousPassDelta) > 0.5f && this.prefetchingEnabled && isGestureActionMatchesScroll(this.previousPassDelta)) {
                notifyPrefetch(this.previousPassDelta, pagerMeasureResult);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int coerceInPageRange(int i) {
        if (getPageCount() > 0) {
            return RangesKt.coerceIn(i, 0, getPageCount() - 1);
        }
        return 0;
    }

    private final boolean isGestureActionMatchesScroll(float f) {
        if (getLayoutInfo().getOrientation() == Orientation.Vertical) {
            if (Math.signum(f) == Math.signum(-Offset.m1224getYimpl(m445getUpDownDifferenceF1C5BW0$foundation_release()))) {
                return true;
            }
        } else if (Math.signum(f) == Math.signum(-Offset.m1223getXimpl(m445getUpDownDifferenceF1C5BW0$foundation_release()))) {
            return true;
        }
        return isNotGestureAction();
    }

    private final boolean isNotGestureAction() {
        return ((int) Offset.m1223getXimpl(m445getUpDownDifferenceF1C5BW0$foundation_release())) == 0 && ((int) Offset.m1224getYimpl(m445getUpDownDifferenceF1C5BW0$foundation_release())) == 0;
    }

    private final void notifyPrefetch(float f, PagerLayoutInfo pagerLayoutInfo) {
        int index;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle2;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle3;
        if (this.prefetchingEnabled && !pagerLayoutInfo.getVisiblePagesInfo().isEmpty()) {
            boolean z = f > 0.0f;
            if (z) {
                index = ((PageInfo) CollectionsKt.last(pagerLayoutInfo.getVisiblePagesInfo())).getIndex() + pagerLayoutInfo.getBeyondViewportPageCount() + 1;
            } else {
                index = (((PageInfo) CollectionsKt.first(pagerLayoutInfo.getVisiblePagesInfo())).getIndex() - pagerLayoutInfo.getBeyondViewportPageCount()) - 1;
            }
            if (index < 0 || index >= getPageCount()) {
                return;
            }
            if (index != this.indexToPrefetch) {
                if (this.wasPrefetchingForward != z && (prefetchHandle3 = this.currentPrefetchHandle) != null) {
                    prefetchHandle3.cancel();
                }
                this.wasPrefetchingForward = z;
                this.indexToPrefetch = index;
                this.currentPrefetchHandle = this.prefetchState.m421schedulePrefetch0kLqBqw(index, this.premeasureConstraints);
            }
            if (z) {
                if ((((PageInfo) CollectionsKt.last(pagerLayoutInfo.getVisiblePagesInfo())).getOffset() + (pagerLayoutInfo.getPageSize() + pagerLayoutInfo.getPageSpacing())) - pagerLayoutInfo.getViewportEndOffset() >= f || (prefetchHandle2 = this.currentPrefetchHandle) == null) {
                    return;
                }
                prefetchHandle2.markAsUrgent();
                return;
            }
            if (pagerLayoutInfo.getViewportStartOffset() - ((PageInfo) CollectionsKt.first(pagerLayoutInfo.getVisiblePagesInfo())).getOffset() >= (-f) || (prefetchHandle = this.currentPrefetchHandle) == null) {
                return;
            }
            prefetchHandle.markAsUrgent();
        }
    }

    private final void cancelPrefetchIfVisibleItemsChanged(PagerLayoutInfo pagerLayoutInfo) {
        int index;
        if (this.indexToPrefetch == -1 || pagerLayoutInfo.getVisiblePagesInfo().isEmpty()) {
            return;
        }
        if (this.wasPrefetchingForward) {
            index = ((PageInfo) CollectionsKt.last(pagerLayoutInfo.getVisiblePagesInfo())).getIndex() + pagerLayoutInfo.getBeyondViewportPageCount() + 1;
        } else {
            index = (((PageInfo) CollectionsKt.first(pagerLayoutInfo.getVisiblePagesInfo())).getIndex() - pagerLayoutInfo.getBeyondViewportPageCount()) - 1;
        }
        if (this.indexToPrefetch != index) {
            this.indexToPrefetch = -1;
            LazyLayoutPrefetchState.PrefetchHandle prefetchHandle = this.currentPrefetchHandle;
            if (prefetchHandle != null) {
                prefetchHandle.cancel();
            }
            this.currentPrefetchHandle = null;
        }
    }

    public final int matchScrollPositionWithKey$foundation_release(PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i) {
        return this.scrollPosition.matchPageWithKey(pagerLazyLayoutItemProvider, i);
    }
}
