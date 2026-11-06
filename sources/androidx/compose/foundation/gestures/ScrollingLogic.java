package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;

/* JADX INFO: loaded from: classes.dex */
public final class ScrollingLogic {
    private FlingBehavior flingBehavior;
    private NestedScrollDispatcher nestedScrollDispatcher;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    private boolean reverseDirection;
    private ScrollableState scrollableState;
    private int latestScrollSource = NestedScrollSource.Companion.m1739getUserInputWNlRxjI();
    private ScrollScope outerStateScope = ScrollableKt.NoOpScrollScope;
    private final ScrollingLogic$nestedScrollScope$1 nestedScrollScope = new NestedScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1
        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        /* JADX INFO: renamed from: scrollBy-OzD1aCk */
        public long mo223scrollByOzD1aCk(long j, int i) {
            return this.this$0.m245performScroll3eAAhYA(this.this$0.outerStateScope, j, i);
        }

        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        /* JADX INFO: renamed from: scrollByWithOverscroll-OzD1aCk */
        public long mo224scrollByWithOverscrollOzD1aCk(long j, int i) {
            this.this$0.latestScrollSource = i;
            OverscrollEffect overscrollEffect = this.this$0.overscrollEffect;
            if (overscrollEffect == null || !this.this$0.getShouldDispatchOverscroll()) {
                return this.this$0.m245performScroll3eAAhYA(this.this$0.outerStateScope, j, i);
            }
            return overscrollEffect.mo112applyToScrollRhakbz0(j, this.this$0.latestScrollSource, this.this$0.performScrollForOverscroll);
        }
    };
    private final Function1 performScrollForOverscroll = new Function1() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$performScrollForOverscroll$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Offset.m1214boximpl(m257invokeMKHz9U(((Offset) obj).m1232unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-MK-Hz9U, reason: not valid java name */
        public final long m257invokeMKHz9U(long j) {
            ScrollScope scrollScope = this.this$0.outerStateScope;
            ScrollingLogic scrollingLogic = this.this$0;
            return scrollingLogic.m245performScroll3eAAhYA(scrollScope, j, scrollingLogic.latestScrollSource);
        }
    };

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1] */
    public ScrollingLogic(ScrollableState scrollableState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, Orientation orientation, boolean z, NestedScrollDispatcher nestedScrollDispatcher) {
        this.scrollableState = scrollableState;
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        this.orientation = orientation;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
    }

    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m255toOffsettuRUvjQ(float f) {
        if (f == 0.0f) {
            return Offset.Companion.m1235getZeroF1C5BW0();
        }
        return this.orientation == Orientation.Horizontal ? OffsetKt.Offset(f, 0.0f) : OffsetKt.Offset(0.0f, f);
    }

    /* JADX INFO: renamed from: singleAxisOffset-MK-Hz9U, reason: not valid java name */
    public final long m253singleAxisOffsetMKHz9U(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m1217copydBAh8RU$default(j, 0.0f, 0.0f, 1, null) : Offset.m1217copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m254toFloatk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m1223getXimpl(j) : Offset.m1224getYimpl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m247toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m2648getXimpl(j) : Velocity.m2649getYimpl(j);
    }

    /* JADX INFO: renamed from: singleAxisVelocity-AH228Gc, reason: not valid java name */
    private final long m246singleAxisVelocityAH228Gc(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m2645copyOhffZ5M$default(j, 0.0f, 0.0f, 1, null) : Velocity.m2645copyOhffZ5M$default(j, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m248updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m2645copyOhffZ5M$default(j, f, 0.0f, 2, null) : Velocity.m2645copyOhffZ5M$default(j, 0.0f, f, 1, null);
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * (-1) : f;
    }

    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m252reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m1229timestuRUvjQ(j, -1.0f) : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: performScroll-3eAAhYA, reason: not valid java name */
    public final long m245performScroll3eAAhYA(ScrollScope scrollScope, long j, int i) {
        long jM1735dispatchPreScrollOzD1aCk = this.nestedScrollDispatcher.m1735dispatchPreScrollOzD1aCk(j, i);
        long jM1227minusMKHz9U = Offset.m1227minusMKHz9U(j, jM1735dispatchPreScrollOzD1aCk);
        long jM252reverseIfNeededMKHz9U = m252reverseIfNeededMKHz9U(m255toOffsettuRUvjQ(scrollScope.scrollBy(m254toFloatk4lQ0M(m252reverseIfNeededMKHz9U(m253singleAxisOffsetMKHz9U(jM1227minusMKHz9U))))));
        return Offset.m1228plusMKHz9U(Offset.m1228plusMKHz9U(jM1735dispatchPreScrollOzD1aCk, jM252reverseIfNeededMKHz9U), this.nestedScrollDispatcher.m1733dispatchPostScrollDzOQY0M(jM252reverseIfNeededMKHz9U, Offset.m1227minusMKHz9U(jM1227minusMKHz9U, jM252reverseIfNeededMKHz9U), i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    /* JADX INFO: renamed from: performRawScroll-MK-Hz9U, reason: not valid java name */
    public final long m251performRawScrollMKHz9U(long j) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.Companion.m1235getZeroF1C5BW0();
        }
        return m255toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m254toFloatk4lQ0M(j)))));
    }

    /* JADX INFO: renamed from: onDragStopped-sF-c-tU, reason: not valid java name */
    public final Object m250onDragStoppedsFctU(long j, Continuation continuation) {
        long jM246singleAxisVelocityAH228Gc = m246singleAxisVelocityAH228Gc(j);
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this, null);
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        if (overscrollEffect != null && getShouldDispatchOverscroll()) {
            Object objMo111applyToFlingBMRW4eQ = overscrollEffect.mo111applyToFlingBMRW4eQ(jM246singleAxisVelocityAH228Gc, scrollingLogic$onDragStopped$performFling$1, continuation);
            return objMo111applyToFlingBMRW4eQ == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo111applyToFlingBMRW4eQ : Unit.INSTANCE;
        }
        Object objInvoke = scrollingLogic$onDragStopped$performFling$1.invoke(Velocity.m2642boximpl(jM246singleAxisVelocityAH228Gc), continuation);
        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    public final Object m249doFlingAnimationQWom1Mo(long j, Continuation continuation) {
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$1;
        Ref$LongRef ref$LongRef;
        if (continuation instanceof ScrollingLogic$doFlingAnimation$1) {
            scrollingLogic$doFlingAnimation$1 = (ScrollingLogic$doFlingAnimation$1) continuation;
            int i = scrollingLogic$doFlingAnimation$1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                scrollingLogic$doFlingAnimation$1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuation);
            }
        } else {
            scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuation);
        }
        Object obj = scrollingLogic$doFlingAnimation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = scrollingLogic$doFlingAnimation$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref$LongRef ref$LongRef2 = new Ref$LongRef();
            ref$LongRef2.element = j;
            MutatePriority mutatePriority = MutatePriority.Default;
            Function2 scrollingLogic$doFlingAnimation$2 = new ScrollingLogic$doFlingAnimation$2(this, ref$LongRef2, j, null);
            scrollingLogic$doFlingAnimation$1.L$0 = ref$LongRef2;
            scrollingLogic$doFlingAnimation$1.label = 1;
            if (scroll(mutatePriority, scrollingLogic$doFlingAnimation$2, scrollingLogic$doFlingAnimation$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            ref$LongRef = ref$LongRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$LongRef = (Ref$LongRef) scrollingLogic$doFlingAnimation$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Velocity.m2642boximpl(ref$LongRef.element);
    }

    public final boolean shouldScrollImmediately() {
        if (this.scrollableState.isScrollInProgress()) {
            return true;
        }
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        return overscrollEffect != null ? overscrollEffect.isInProgress() : false;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollingLogic$scroll$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function2 $block;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = ScrollingLogic.this.new AnonymousClass2(this.$block, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
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
                ScrollingLogic.this.outerStateScope = (ScrollScope) this.L$0;
                Function2 function2 = this.$block;
                ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = ScrollingLogic.this.nestedScrollScope;
                this.label = 1;
                if (function2.invoke(scrollingLogic$nestedScrollScope$1, this) == coroutine_suspended) {
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

    public final Object scroll(MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
        Object objScroll = this.scrollableState.scroll(mutatePriority, new AnonymousClass2(function2, null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }

    public final boolean update(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        boolean z2;
        boolean z3 = true;
        if (Intrinsics.areEqual(this.scrollableState, scrollableState)) {
            z2 = false;
        } else {
            this.scrollableState = scrollableState;
            z2 = true;
        }
        this.overscrollEffect = overscrollEffect;
        if (this.orientation != orientation) {
            this.orientation = orientation;
            z2 = true;
        }
        if (this.reverseDirection != z) {
            this.reverseDirection = z;
        } else {
            z3 = z2;
        }
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        return z3;
    }

    public final boolean isVertical() {
        return this.orientation == Orientation.Vertical;
    }
}
