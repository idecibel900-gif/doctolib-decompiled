package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.VelocityKt;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3, ComposeNodeLifecycleCallback, OwnerScope {
    private final int compositeKeyHash;
    private Density density;
    private final NestedScrollDispatcher dispatcher;
    private boolean hasUpdateBlock;
    private boolean isDrawing;
    private int lastHeightMeasureSpec;
    private int lastWidthMeasureSpec;
    private final LayoutNode layoutNode;
    private LifecycleOwner lifecycleOwner;
    private final int[] location;
    private Modifier modifier;
    private final NestedScrollingParentHelper nestedScrollingParentHelper;
    private Function1 onDensityChanged;
    private Function1 onModifierChanged;
    private Function1 onRequestDisallowInterceptTouchEvent;
    private final Owner owner;
    private Function0 release;
    private Function0 reset;
    private final Function0 runInvalidate;
    private final Function0 runUpdate;
    private SavedStateRegistryOwner savedStateRegistryOwner;
    private Function0 update;
    private final View view;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Function1 OnCommitAffectingUpdate = AndroidViewHolder$Companion$OnCommitAffectingUpdate$1.INSTANCE;

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return ((i & 2) == 0 && (i & 1) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final View getView() {
        return this.view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidViewHolder(Context context, CompositionContext compositionContext, int i, NestedScrollDispatcher nestedScrollDispatcher, View view, Owner owner) {
        super(context);
        this.compositeKeyHash = i;
        this.dispatcher = nestedScrollDispatcher;
        this.view = view;
        this.owner = owner;
        if (compositionContext != null) {
            WindowRecomposer_androidKt.setCompositionContext(this, compositionContext);
        }
        setSaveFromParentEnabled(false);
        addView(view);
        this.update = new Function0() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$update$1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m2661invoke() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2661invoke();
                return Unit.INSTANCE;
            }
        };
        this.reset = new Function0() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$reset$1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m2658invoke() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2658invoke();
                return Unit.INSTANCE;
            }
        };
        this.release = new Function0() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$release$1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m2657invoke() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2657invoke();
                return Unit.INSTANCE;
            }
        };
        Modifier.Companion companion = Modifier.Companion;
        this.modifier = companion;
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
        this.runUpdate = new Function0() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$runUpdate$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2660invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m2660invoke() {
                if (this.this$0.hasUpdateBlock && this.this$0.isAttachedToWindow()) {
                    ViewParent parent = this.this$0.getView().getParent();
                    AndroidViewHolder androidViewHolder = this.this$0;
                    if (parent == androidViewHolder) {
                        androidViewHolder.getSnapshotObserver().observeReads$ui_release(this.this$0, AndroidViewHolder.OnCommitAffectingUpdate, this.this$0.getUpdate());
                    }
                }
            }
        };
        this.runInvalidate = new Function0() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$runInvalidate$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2659invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m2659invoke() {
                this.this$0.getLayoutNode().invalidateLayer$ui_release();
            }
        };
        this.location = new int[2];
        this.lastWidthMeasureSpec = LinearLayoutManager.INVALID_OFFSET;
        this.lastHeightMeasureSpec = LinearLayoutManager.INVALID_OFFSET;
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        Object[] objArr = 0 == true ? 1 : 0;
        final LayoutNode layoutNode = new LayoutNode(false, objArr, 3, null);
        layoutNode.setInteropViewFactoryHolder$ui_release(this);
        final Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(DrawModifierKt.drawBehind(PointerInteropFilter_androidKt.pointerInteropFilter(SemanticsModifierKt.semantics(NestedScrollModifierKt.nestedScroll(companion, AndroidViewHolder_androidKt.NoOpScrollConnection, nestedScrollDispatcher), true, new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$1
            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            }
        }), this), new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(DrawScope drawScope) {
                AndroidViewHolder androidViewHolder = this.$this_run;
                LayoutNode layoutNode2 = layoutNode;
                AndroidViewHolder androidViewHolder2 = this;
                Canvas canvas = drawScope.getDrawContext().getCanvas();
                if (androidViewHolder.getView().getVisibility() != 8) {
                    androidViewHolder.isDrawing = true;
                    Owner owner$ui_release = layoutNode2.getOwner$ui_release();
                    AndroidComposeView androidComposeView = owner$ui_release instanceof AndroidComposeView ? (AndroidComposeView) owner$ui_release : null;
                    if (androidComposeView != null) {
                        androidComposeView.drawAndroidView(androidViewHolder2, AndroidCanvas_androidKt.getNativeCanvas(canvas));
                    }
                    androidViewHolder.isDrawing = false;
                }
            }
        }), new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutCoordinates) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(LayoutCoordinates layoutCoordinates) {
                AndroidViewHolder_androidKt.layoutAccordingTo(this.$this_run, layoutNode);
                this.$this_run.owner.onInteropViewLayoutChange(this.$this_run);
            }
        });
        layoutNode.setCompositeKeyHash(i);
        layoutNode.setModifier(this.modifier.then(modifierOnGloballyPositioned));
        this.onModifierChanged = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Modifier) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Modifier modifier) {
                layoutNode.setModifier(modifier.then(modifierOnGloballyPositioned));
            }
        };
        layoutNode.setDensity(this.density);
        this.onDensityChanged = new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Density) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Density density) {
                layoutNode.setDensity(density);
            }
        };
        layoutNode.setOnAttach$ui_release(new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Owner) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Owner owner2) {
                AndroidComposeView androidComposeView = owner2 instanceof AndroidComposeView ? (AndroidComposeView) owner2 : null;
                if (androidComposeView != null) {
                    androidComposeView.addAndroidView(this.$this_run, layoutNode);
                }
                ViewParent parent = this.$this_run.getView().getParent();
                AndroidViewHolder androidViewHolder = this.$this_run;
                if (parent != androidViewHolder) {
                    androidViewHolder.addView(androidViewHolder.getView());
                }
            }
        });
        layoutNode.setOnDetach$ui_release(new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Owner) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Owner owner2) {
                AndroidComposeView androidComposeView = owner2 instanceof AndroidComposeView ? (AndroidComposeView) owner2 : null;
                if (androidComposeView != null) {
                    androidComposeView.removeAndroidView(this.$this_run);
                }
                this.$this_run.removeAllViewsInLayout();
            }
        });
        layoutNode.setMeasurePolicy(new MeasurePolicy() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public MeasureResult mo30measure3p2s80s(MeasureScope measureScope, List list, long j) {
                if (this.$this_run.getChildCount() == 0) {
                    return MeasureScope.layout$default(measureScope, Constraints.m2532getMinWidthimpl(j), Constraints.m2531getMinHeightimpl(j), null, new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5$measure$1
                        public final void invoke(Placeable.PlacementScope placementScope) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable.PlacementScope) obj);
                            return Unit.INSTANCE;
                        }
                    }, 4, null);
                }
                if (Constraints.m2532getMinWidthimpl(j) != 0) {
                    this.$this_run.getChildAt(0).setMinimumWidth(Constraints.m2532getMinWidthimpl(j));
                }
                if (Constraints.m2531getMinHeightimpl(j) != 0) {
                    this.$this_run.getChildAt(0).setMinimumHeight(Constraints.m2531getMinHeightimpl(j));
                }
                AndroidViewHolder androidViewHolder = this.$this_run;
                int iM2532getMinWidthimpl = Constraints.m2532getMinWidthimpl(j);
                int iM2530getMaxWidthimpl = Constraints.m2530getMaxWidthimpl(j);
                ViewGroup.LayoutParams layoutParams = this.$this_run.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                int iObtainMeasureSpec = androidViewHolder.obtainMeasureSpec(iM2532getMinWidthimpl, iM2530getMaxWidthimpl, layoutParams.width);
                AndroidViewHolder androidViewHolder2 = this.$this_run;
                int iM2531getMinHeightimpl = Constraints.m2531getMinHeightimpl(j);
                int iM2529getMaxHeightimpl = Constraints.m2529getMaxHeightimpl(j);
                ViewGroup.LayoutParams layoutParams2 = this.$this_run.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2);
                androidViewHolder.measure(iObtainMeasureSpec, androidViewHolder2.obtainMeasureSpec(iM2531getMinHeightimpl, iM2529getMaxHeightimpl, layoutParams2.height));
                int measuredWidth = this.$this_run.getMeasuredWidth();
                int measuredHeight = this.$this_run.getMeasuredHeight();
                final AndroidViewHolder androidViewHolder3 = this.$this_run;
                final LayoutNode layoutNode2 = layoutNode;
                return MeasureScope.layout$default(measureScope, measuredWidth, measuredHeight, null, new Function1() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5$measure$2
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
                        AndroidViewHolder_androidKt.layoutAccordingTo(androidViewHolder3, layoutNode2);
                    }
                }, 4, null);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                return intrinsicWidth(i2);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                return intrinsicWidth(i2);
            }

            private final int intrinsicWidth(int i2) {
                AndroidViewHolder androidViewHolder = this.$this_run;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                AndroidViewHolder androidViewHolder2 = this.$this_run;
                ViewGroup.LayoutParams layoutParams = androidViewHolder2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                androidViewHolder.measure(iMakeMeasureSpec, androidViewHolder2.obtainMeasureSpec(0, i2, layoutParams.height));
                return this.$this_run.getMeasuredWidth();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                return intrinsicHeight(i2);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                return intrinsicHeight(i2);
            }

            private final int intrinsicHeight(int i2) {
                AndroidViewHolder androidViewHolder = this.$this_run;
                ViewGroup.LayoutParams layoutParams = androidViewHolder.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                androidViewHolder.measure(androidViewHolder.obtainMeasureSpec(0, i2, layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
                return this.$this_run.getMeasuredHeight();
            }
        });
        this.layoutNode = layoutNode;
    }

    public final View getInteropView() {
        return this.view;
    }

    public final Function0 getUpdate() {
        return this.update;
    }

    protected final void setUpdate(Function0 function0) {
        this.update = function0;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    public final Function0 getReset() {
        return this.reset;
    }

    protected final void setReset(Function0 function0) {
        this.reset = function0;
    }

    public final Function0 getRelease() {
        return this.release;
    }

    protected final void setRelease(Function0 function0) {
        this.release = function0;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final void setModifier(Modifier modifier) {
        if (modifier != this.modifier) {
            this.modifier = modifier;
            Function1 function1 = this.onModifierChanged;
            if (function1 != null) {
                function1.invoke(modifier);
            }
        }
    }

    public final Function1 getOnModifierChanged$ui_release() {
        return this.onModifierChanged;
    }

    public final void setOnModifierChanged$ui_release(Function1 function1) {
        this.onModifierChanged = function1;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity(Density density) {
        if (density != this.density) {
            this.density = density;
            Function1 function1 = this.onDensityChanged;
            if (function1 != null) {
                function1.invoke(density);
            }
        }
    }

    public final Function1 getOnDensityChanged$ui_release() {
        return this.onDensityChanged;
    }

    public final void setOnDensityChanged$ui_release(Function1 function1) {
        this.onDensityChanged = function1;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != this.lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner;
            ViewTreeLifecycleOwner.set(this, lifecycleOwner);
        }
    }

    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    public final void setSavedStateRegistryOwner(SavedStateRegistryOwner savedStateRegistryOwner) {
        if (savedStateRegistryOwner != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = savedStateRegistryOwner;
            ViewTreeSavedStateRegistryOwner.set(this, savedStateRegistryOwner);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OwnerSnapshotObserver getSnapshotObserver() {
        if (!isAttachedToWindow()) {
            InlineClassHelperKt.throwIllegalStateException("Expected AndroidViewHolder to be attached when observing reads.");
        }
        return this.owner.getSnapshotObserver();
    }

    public final Function1 getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(Function1 function1) {
        this.onRequestDisallowInterceptTouchEvent = function1;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return isAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return getClass().getName();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        if (this.view.getParent() != this) {
            addView(this.view);
        } else {
            this.reset.invoke();
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        this.reset.invoke();
        removeAllViewsInLayout();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        this.release.invoke();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.view.getParent() != this) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
            return;
        }
        if (this.view.getVisibility() == 8) {
            setMeasuredDimension(0, 0);
            return;
        }
        this.view.measure(i, i2);
        setMeasuredDimension(this.view.getMeasuredWidth(), this.view.getMeasuredHeight());
        this.lastWidthMeasureSpec = i;
        this.lastHeightMeasureSpec = i2;
    }

    public final void remeasure() {
        int i;
        int i2 = this.lastWidthMeasureSpec;
        if (i2 == Integer.MIN_VALUE || (i = this.lastHeightMeasureSpec) == Integer.MIN_VALUE) {
            return;
        }
        measure(i2, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.view.layout(0, 0, i3 - i, i4 - i2);
    }

    @Override // android.view.View
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Function1 function1 = this.onRequestDisallowInterceptTouchEvent;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.runUpdate.invoke();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getSnapshotObserver().clear$ui_release(this);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        super.invalidateChildInParent(iArr, rect);
        invalidateOrDefer();
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidateOrDefer();
    }

    public final void invalidateOrDefer() {
        if (this.isDrawing) {
            View view = this.view;
            final Function0 function0 = this.runInvalidate;
            view.postOnAnimation(new Runnable() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    function0.invoke();
                }
            });
            return;
        }
        this.layoutNode.invalidateLayer$ui_release();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (region == null) {
            return true;
        }
        getLocationInWindow(this.location);
        int[] iArr = this.location;
        int i = iArr[0];
        region.op(i, iArr[1], i + getWidth(), this.location[1] + getHeight(), Region.Op.DIFFERENCE);
        return true;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int obtainMeasureSpec(int i, int i2, int i3) {
        if (i3 >= 0 || i == i2) {
            return View.MeasureSpec.makeMeasureSpec(RangesKt.coerceIn(i3, i, i2), 1073741824);
        }
        if (i3 == -2 && i2 != Integer.MAX_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(i2, LinearLayoutManager.INVALID_OFFSET);
        }
        if (i3 == -1 && i2 != Integer.MAX_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.nestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i, i2);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        this.nestedScrollingParentHelper.onStopNestedScroll(view, i);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (isNestedScrollingEnabled()) {
            long jM1733dispatchPostScrollDzOQY0M = this.dispatcher.m1733dispatchPostScrollDzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i), AndroidViewHolder_androidKt.toComposeOffset(i2)), OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i3), AndroidViewHolder_androidKt.toComposeOffset(i4)), AndroidViewHolder_androidKt.toNestedScrollSource(i5));
            iArr[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1223getXimpl(jM1733dispatchPostScrollDzOQY0M));
            iArr[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1224getYimpl(jM1733dispatchPostScrollDzOQY0M));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        if (isNestedScrollingEnabled()) {
            this.dispatcher.m1733dispatchPostScrollDzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i), AndroidViewHolder_androidKt.toComposeOffset(i2)), OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i3), AndroidViewHolder_androidKt.toComposeOffset(i4)), AndroidViewHolder_androidKt.toNestedScrollSource(i5));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        if (isNestedScrollingEnabled()) {
            long jM1735dispatchPreScrollOzD1aCk = this.dispatcher.m1735dispatchPreScrollOzD1aCk(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i), AndroidViewHolder_androidKt.toComposeOffset(i2)), AndroidViewHolder_androidKt.toNestedScrollSource(i3));
            iArr[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1223getXimpl(jM1735dispatchPreScrollOzD1aCk));
            iArr[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1224getYimpl(jM1735dispatchPreScrollOzD1aCk));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(this.dispatcher.getCoroutineScope(), null, null, new AnonymousClass1(z, this, VelocityKt.Velocity(AndroidViewHolder_androidKt.toComposeVelocity(f), AndroidViewHolder_androidKt.toComposeVelocity(f2)), null), 3, null);
        return false;
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ boolean $consumed;
        final /* synthetic */ long $viewVelocity;
        int label;
        final /* synthetic */ AndroidViewHolder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, AndroidViewHolder androidViewHolder, long j, Continuation continuation) {
            super(2, continuation);
            this.$consumed = z;
            this.this$0 = androidViewHolder;
            this.$viewVelocity = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$consumed, this.this$0, this.$viewVelocity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        
            if (r4.m1732dispatchPostFlingRZ2iAVY(r5, r7, r10) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
        
            if (r1.m1732dispatchPostFlingRZ2iAVY(r2, r4, r10) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1f
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r11)
                goto L58
            L12:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1a:
                kotlin.ResultKt.throwOnFailure(r11)
                r6 = r10
                goto L58
            L1f:
                kotlin.ResultKt.throwOnFailure(r11)
                boolean r11 = r10.$consumed
                if (r11 != 0) goto L3f
                androidx.compose.ui.viewinterop.AndroidViewHolder r11 = r10.this$0
                androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r4 = androidx.compose.ui.viewinterop.AndroidViewHolder.access$getDispatcher$p(r11)
                androidx.compose.ui.unit.Velocity$Companion r11 = androidx.compose.ui.unit.Velocity.Companion
                long r5 = r11.m2656getZero9UxMQ8M()
                long r7 = r10.$viewVelocity
                r10.label = r3
                r9 = r10
                java.lang.Object r11 = r4.m1732dispatchPostFlingRZ2iAVY(r5, r7, r9)
                r6 = r9
                if (r11 != r0) goto L58
                goto L57
            L3f:
                r6 = r10
                androidx.compose.ui.viewinterop.AndroidViewHolder r11 = r6.this$0
                androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r1 = androidx.compose.ui.viewinterop.AndroidViewHolder.access$getDispatcher$p(r11)
                r11 = r2
                long r2 = r6.$viewVelocity
                androidx.compose.ui.unit.Velocity$Companion r4 = androidx.compose.ui.unit.Velocity.Companion
                long r4 = r4.m2656getZero9UxMQ8M()
                r6.label = r11
                java.lang.Object r11 = r1.m1732dispatchPostFlingRZ2iAVY(r2, r4, r6)
                if (r11 != r0) goto L58
            L57:
                return r0
            L58:
                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidViewHolder.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(this.dispatcher.getCoroutineScope(), null, null, new C02601(VelocityKt.Velocity(AndroidViewHolder_androidKt.toComposeVelocity(f), AndroidViewHolder_androidKt.toComposeVelocity(f2)), null), 3, null);
        return false;
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1, reason: invalid class name and case insensitive filesystem */
    static final class C02601 extends SuspendLambda implements Function2 {
        final /* synthetic */ long $toBeConsumed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02601(long j, Continuation continuation) {
            super(2, continuation);
            this.$toBeConsumed = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AndroidViewHolder.this.new C02601(this.$toBeConsumed, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C02601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                NestedScrollDispatcher nestedScrollDispatcher = AndroidViewHolder.this.dispatcher;
                long j = this.$toBeConsumed;
                this.label = 1;
                if (nestedScrollDispatcher.m1734dispatchPreFlingQWom1Mo(j, this) == coroutine_suspended) {
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

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.view.isNestedScrollingEnabled();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
