package com.facebook.react.views.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import com.facebook.common.logging.FLog;
import com.facebook.react.R$id;
import com.facebook.react.ReactRootView$$ExternalSyntheticApiModelOutline0;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.touch.OnInterceptTouchEventListener;
import com.facebook.react.touch.ReactHitSlopView;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.BlendModeHelper;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactAxOrderHelper;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactOverflowViewWithInset;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ReactZIndexedViewGroup;
import com.facebook.react.uimanager.ViewGroupDrawingOrderHelper;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.uimanager.style.Overflow;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class ReactViewGroup extends ViewGroup implements ReactInterceptingViewGroup, ReactClippingViewGroup, ReactPointerEventsView, ReactHitSlopView, ReactZIndexedViewGroup, ReactOverflowViewWithInset {
    private static final int ARRAY_CAPACITY_INCREMENT = 12;
    private static final Companion Companion = new Companion(null);
    private static final ViewGroup.LayoutParams defaultLayoutParam = new ViewGroup.LayoutParams(0, 0);
    private ViewGroupDrawingOrderHelper _drawingOrderHelper;
    private Overflow _overflow;
    private boolean _removeClippedSubviews;
    private AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener;
    private View[] allChildren;
    private int allChildrenCount;
    private List<String> axOrderList;
    private float backfaceOpacity;
    private boolean backfaceVisible;
    private ChildrenLayoutChangeListener childrenLayoutChangeListener;
    private Set<Integer> childrenRemovedWhileTransitioning;
    private Rect clippingRect;
    private boolean focusOnAttach;
    private Rect hitSlopRect;
    private volatile boolean inSubviewClippingLoop;
    private boolean needsOffscreenAlphaCompositing;
    private OnInterceptTouchEventListener onInterceptTouchEventListener;
    private final Rect overflowInset;
    private PointerEvents pointerEvents;
    private int recycleCount;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Overflow.values().length];
            try {
                iArr[Overflow.HIDDEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Overflow.SCROLL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Overflow.VISIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View, android.view.ViewParent
    @SuppressLint({"MissingSuperCall"})
    public void requestLayout() {
    }

    public ReactViewGroup(Context context) {
        super(context);
        this.overflowInset = new Rect();
        this.pointerEvents = PointerEvents.AUTO;
        initView();
    }

    @Override // com.facebook.react.uimanager.ReactOverflowViewWithInset
    public Rect getOverflowInset() {
        return this.overflowInset;
    }

    private static final class ChildrenLayoutChangeListener implements View.OnLayoutChangeListener {
        private ReactViewGroup parent;

        public ChildrenLayoutChangeListener(ReactViewGroup reactViewGroup) {
            this.parent = reactViewGroup;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View v, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            ReactViewGroup reactViewGroup;
            Intrinsics.checkNotNullParameter(v, "v");
            ReactViewGroup reactViewGroup2 = this.parent;
            if (reactViewGroup2 == null || !reactViewGroup2.getRemoveClippedSubviews() || (reactViewGroup = this.parent) == null) {
                return;
            }
            reactViewGroup.updateSubviewClipStatus(v);
        }

        public final void shutdown() {
            this.parent = null;
        }
    }

    public final boolean get_removeClippedSubviews$ReactAndroid_release() {
        return this._removeClippedSubviews;
    }

    public final void set_removeClippedSubviews$ReactAndroid_release(boolean z) {
        this._removeClippedSubviews = z;
    }

    public final int getAllChildrenCount$ReactAndroid_release() {
        return this.allChildrenCount;
    }

    public final Rect getClippingRect$ReactAndroid_release() {
        return this.clippingRect;
    }

    public final void setClippingRect$ReactAndroid_release(Rect rect) {
        this.clippingRect = rect;
    }

    @Override // com.facebook.react.touch.ReactHitSlopView
    public Rect getHitSlopRect() {
        return this.hitSlopRect;
    }

    public void setHitSlopRect(Rect rect) {
        this.hitSlopRect = rect;
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    public PointerEvents getPointerEvents() {
        return this.pointerEvents;
    }

    public void setPointerEvents(PointerEvents pointerEvents) {
        Intrinsics.checkNotNullParameter(pointerEvents, "<set-?>");
        this.pointerEvents = pointerEvents;
    }

    public final List<String> getAxOrderList() {
        return this.axOrderList;
    }

    public final void setAxOrderList(List<String> list) {
        this.axOrderList = list;
    }

    private final void initView() {
        setClipChildren(false);
        this._removeClippedSubviews = false;
        this.inSubviewClippingLoop = false;
        this.allChildren = null;
        this.allChildrenCount = 0;
        this.clippingRect = null;
        setHitSlopRect(null);
        this._overflow = Overflow.VISIBLE;
        setPointerEvents(PointerEvents.AUTO);
        this.childrenLayoutChangeListener = null;
        this.onInterceptTouchEventListener = null;
        this.needsOffscreenAlphaCompositing = false;
        this._drawingOrderHelper = null;
        this.backfaceOpacity = 1.0f;
        this.backfaceVisible = true;
        this.childrenRemovedWhileTransitioning = null;
    }

    public void recycleView$ReactAndroid_release() {
        ChildrenLayoutChangeListener childrenLayoutChangeListener;
        this.recycleCount++;
        View[] viewArr = this.allChildren;
        if (viewArr != null && (childrenLayoutChangeListener = this.childrenLayoutChangeListener) != null) {
            if (childrenLayoutChangeListener != null) {
                childrenLayoutChangeListener.shutdown();
            }
            int i = this.allChildrenCount;
            for (int i2 = 0; i2 < i; i2++) {
                View view = viewArr[i2];
                if (view != null) {
                    view.removeOnLayoutChangeListener(this.childrenLayoutChangeListener);
                }
            }
        }
        initView();
        getOverflowInset().setEmpty();
        removeAllViews();
        if (getParent() != null) {
            ViewParent parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this);
        }
        updateBackgroundDrawable(null);
        resetPointerEvents();
        this.focusOnAttach = false;
    }

    private final ViewGroupDrawingOrderHelper getDrawingOrderHelper() {
        if (this._drawingOrderHelper == null) {
            this._drawingOrderHelper = new ViewGroupDrawingOrderHelper(this);
        }
        ViewGroupDrawingOrderHelper viewGroupDrawingOrderHelper = this._drawingOrderHelper;
        if (viewGroupDrawingOrderHelper != null) {
            return viewGroupDrawingOrderHelper;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        MeasureSpecAssertions.assertExplicitMeasureSpec(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(23)
    public void dispatchProvideStructure(ViewStructure structure) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        try {
            super.dispatchProvideStructure(structure);
        } catch (NullPointerException e) {
            FLog.e("ReactNative", "NullPointerException when executing dispatchProvideStructure", e);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        BackgroundStyleApplicator.setBackgroundColor(this, Integer.valueOf(i));
    }

    @Deprecated
    public final void setTranslucentBackgroundDrawable(Drawable drawable) {
        BackgroundStyleApplicator.setFeedbackUnderlay(this, drawable);
    }

    @Override // com.facebook.react.touch.ReactInterceptingViewGroup
    public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onInterceptTouchEventListener = listener;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        OnInterceptTouchEventListener onInterceptTouchEventListener = this.onInterceptTouchEventListener;
        if ((onInterceptTouchEventListener == null || !onInterceptTouchEventListener.onInterceptTouchEvent(this, event)) && PointerEvents.Companion.canChildrenBeTouchTarget(getPointerEvents())) {
            return super.onInterceptTouchEvent(event);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return PointerEvents.Companion.canBeTouchTarget(getPointerEvents());
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (ReactFeatureFlags.dispatchPointerEvents) {
            return PointerEvents.Companion.canBeTouchTarget(getPointerEvents());
        }
        return super.onHoverEvent(event);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (PointerEvents.Companion.canChildrenBeTouchTarget(getPointerEvents())) {
            return super.dispatchGenericMotionEvent(ev);
        }
        return false;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.needsOffscreenAlphaCompositing;
    }

    public final void setNeedsOffscreenAlphaCompositing(boolean z) {
        this.needsOffscreenAlphaCompositing = z;
    }

    public final void setBorderWidth(int i, float f) {
        BackgroundStyleApplicator.setBorderWidth(this, (LogicalEdge) LogicalEdge.getEntries().get(i), Float.valueOf(PixelUtil.toDIPFromPixel(f)));
    }

    public final void setBorderColor(int i, Integer num) {
        BackgroundStyleApplicator.setBorderColor(this, (LogicalEdge) LogicalEdge.getEntries().get(i), num);
    }

    @Deprecated
    public final void setBorderRadius(float f) {
        BackgroundStyleApplicator.setBorderRadius(this, BorderRadiusProp.BORDER_RADIUS, Float.isNaN(f) ? null : new LengthPercentage(f, LengthPercentageType.POINT));
    }

    @Deprecated
    public final void setBorderRadius(float f, int i) {
        BackgroundStyleApplicator.setBorderRadius(this, (BorderRadiusProp) BorderRadiusProp.getEntries().get(i), Float.isNaN(f) ? null : new LengthPercentage(f, LengthPercentageType.POINT));
    }

    public final void setBorderRadius(BorderRadiusProp property, LengthPercentage lengthPercentage) {
        Intrinsics.checkNotNullParameter(property, "property");
        BackgroundStyleApplicator.setBorderRadius(this, property, lengthPercentage);
    }

    public final void setBorderStyle(String str) {
        BackgroundStyleApplicator.setBorderStyle(this, str != null ? BorderStyle.Companion.fromString(str) : null);
    }

    public boolean getRemoveClippedSubviews() {
        return this._removeClippedSubviews;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z == this._removeClippedSubviews) {
            return;
        }
        this._removeClippedSubviews = z;
        this.childrenRemovedWhileTransitioning = null;
        if (z) {
            Rect rect = new Rect();
            ReactClippingViewGroupHelper.calculateClippingRect(this, rect);
            this.clippingRect = rect;
            int childCount = getChildCount();
            this.allChildrenCount = childCount;
            View[] viewArr = new View[Math.max(12, childCount)];
            this.childrenLayoutChangeListener = new ChildrenLayoutChangeListener(this);
            int i = this.allChildrenCount;
            for (int i2 = 0; i2 < i; i2++) {
                View childAt = getChildAt(i2);
                viewArr[i2] = childAt;
                childAt.addOnLayoutChangeListener(this.childrenLayoutChangeListener);
                Companion companion = Companion;
                Intrinsics.checkNotNull(childAt);
                companion.setViewClipped(childAt, false);
            }
            this.allChildren = viewArr;
            updateClippingRect();
            return;
        }
        View[] viewArr2 = this.allChildren;
        if (viewArr2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        if (this.childrenLayoutChangeListener == null) {
            throw new IllegalStateException("Required value was null.");
        }
        int i3 = this.allChildrenCount;
        for (int i4 = 0; i4 < i3; i4++) {
            View view = viewArr2[i4];
            if (view != null) {
                view.removeOnLayoutChangeListener(this.childrenLayoutChangeListener);
            }
        }
        Rect rect2 = this.clippingRect;
        if (rect2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        getDrawingRect(rect2);
        updateClippingToRect$ReactAndroid_release$default(this, rect2, null, 2, null);
        this.allChildren = null;
        this.clippingRect = null;
        this.allChildrenCount = 0;
        this.childrenLayoutChangeListener = null;
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void getClippingRect(Rect outClippingRect) {
        Intrinsics.checkNotNullParameter(outClippingRect, "outClippingRect");
        Rect rect = this.clippingRect;
        if (rect == null) {
            throw new IllegalStateException("Required value was null.");
        }
        outClippingRect.set(rect);
    }

    public void updateClippingRect() {
        updateClippingRect(null);
    }

    @Override // com.facebook.react.uimanager.ReactClippingViewGroup
    public void updateClippingRect(Set<Integer> set) {
        if (this._removeClippedSubviews) {
            Rect rect = this.clippingRect;
            if (rect == null) {
                throw new IllegalStateException("Required value was null.");
            }
            ReactClippingViewGroupHelper.calculateClippingRect(this, rect);
            updateClippingToRect$ReactAndroid_release(rect, set);
        }
    }

    public final void requestFocusFromJS$ReactAndroid_release() {
        if (isAttachedToWindow()) {
            super.requestFocus(130, null);
        } else {
            this.focusOnAttach = true;
        }
    }

    public final void clearFocusFromJS$ReactAndroid_release() {
        this.focusOnAttach = false;
        super.clearFocus();
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.endViewTransition(view);
        Set<Integer> set = this.childrenRemovedWhileTransitioning;
        if (set != null) {
            set.remove(Integer.valueOf(view.getId()));
        }
    }

    private final void trackChildViewTransition(int i) {
        if (this.childrenRemovedWhileTransitioning == null) {
            this.childrenRemovedWhileTransitioning = new LinkedHashSet();
        }
        Set<Integer> set = this.childrenRemovedWhileTransitioning;
        if (set != null) {
            set.add(Integer.valueOf(i));
        }
    }

    private final boolean isChildRemovedWhileTransitioning(View view) {
        Set<Integer> set = this.childrenRemovedWhileTransitioning;
        return set != null && set.contains(Integer.valueOf(view.getId()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateClippingToRect$ReactAndroid_release$default(ReactViewGroup reactViewGroup, Rect rect, Set set, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateClippingToRect");
        }
        if ((i & 2) != 0) {
            set = null;
        }
        reactViewGroup.updateClippingToRect$ReactAndroid_release(rect, set);
    }

    public final void updateClippingToRect$ReactAndroid_release(Rect clippingRect, Set<Integer> set) {
        Intrinsics.checkNotNullParameter(clippingRect, "clippingRect");
        View[] viewArr = this.allChildren;
        if (viewArr == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.inSubviewClippingLoop = true;
        int i = this.allChildrenCount;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            try {
                updateSubviewClipStatus(clippingRect, i3, i2, set);
                if (isViewClipped(viewArr[i3], Integer.valueOf(i3))) {
                    i2++;
                }
                if (i3 - i2 > getChildCount()) {
                    throw new IllegalStateException("Invalid clipping state. i=" + i3 + " clippedSoFar=" + i2 + " count=" + getChildCount() + " allChildrenCount=" + this.allChildrenCount + " recycleCount=" + this.recycleCount + "  excludedViews=" + (set != null ? set.size() : 0));
                }
            } catch (IndexOutOfBoundsException e) {
                HashSet hashSet = new HashSet();
                int i4 = 0;
                for (int i5 = 0; i5 < i3; i5++) {
                    i4 += isViewClipped(viewArr[i5], Integer.valueOf(i5)) ? 1 : 0;
                    hashSet.add(viewArr[i5]);
                }
                throw new IllegalStateException("Invalid clipping state. i=" + i3 + " clippedSoFar=" + i2 + " count=" + getChildCount() + " allChildrenCount=" + this.allChildrenCount + " recycleCount=" + this.recycleCount + " realClippedSoFar=" + i4 + " uniqueViewsCount=" + hashSet.size() + " excludedViews=" + (set != null ? set.size() : 0), e);
            }
        }
        this.inSubviewClippingLoop = false;
    }

    static /* synthetic */ void updateSubviewClipStatus$default(ReactViewGroup reactViewGroup, Rect rect, int i, int i2, Set set, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSubviewClipStatus");
        }
        if ((i3 & 8) != 0) {
            set = null;
        }
        reactViewGroup.updateSubviewClipStatus(rect, i, i2, set);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x006b  */
    /* JADX WARN: Code duplicated, block: B:36:0x007c  */
    /* JADX WARN: Code duplicated, block: B:37:0x008a  */
    /* JADX WARN: Multi-variable type inference failed */
    private final void updateSubviewClipStatus(Rect rect, int i, int i2, Set set) {
        View view;
        boolean z;
        boolean z2;
        int i3;
        View view2;
        UiThreadUtil.assertOnUiThread();
        View[] viewArr = this.allChildren;
        if (viewArr != null) {
            view2 = viewArr[i];
        } else {
            view = 0;
        }
        if (view == 0) {
            view = view2;
            throw new IllegalStateException("Required value was null.");
        }
        boolean zIntersects = rect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        Animation animation = view.getAnimation();
        boolean z3 = false;
        if (animation == null || animation.hasEnded()) {
            view = view2;
            view = view2;
            z = false;
        } else {
            z = true;
        }
        if (set == null || !set.contains(Integer.valueOf(view.getId()))) {
            view = view2;
            view = view2;
            z2 = false;
        } else {
            z2 = true;
        }
        boolean z4 = set != null;
        if (zIntersects) {
            if (z2) {
                i3 = i - i2;
                if (i3 < 0) {
                    throw new IllegalStateException("Check failed.");
                }
                Companion.setViewClipped(view, false);
                addViewInLayout(view, i3, defaultLayoutParam, true);
                invalidate();
            } else {
                i3 = i - i2;
                if (i3 < 0) {
                    throw new IllegalStateException("Check failed.");
                }
                Companion.setViewClipped(view, false);
                addViewInLayout(view, i3, defaultLayoutParam, true);
                invalidate();
            }
            z4 = true;
        } else {
            view = view2;
            if (isViewClipped(view, Integer.valueOf(i)) || z || view == getFocusedChild() || z2) {
                if ((z2 || zIntersects) && isViewClipped(view, Integer.valueOf(i))) {
                    i3 = i - i2;
                    if (i3 < 0) {
                        throw new IllegalStateException("Check failed.");
                    }
                    Companion.setViewClipped(view, false);
                    addViewInLayout(view, i3, defaultLayoutParam, true);
                    invalidate();
                } else if (zIntersects) {
                }
            } else {
                Companion.setViewClipped(view, true);
                removeViewInLayout(view);
            }
            z4 = true;
        }
        if (z4) {
            ReactClippingViewGroup reactClippingViewGroup = view instanceof ReactClippingViewGroup ? (ReactClippingViewGroup) view : null;
            if (reactClippingViewGroup != null && reactClippingViewGroup.getRemoveClippedSubviews()) {
                z3 = true;
            }
            if (z3) {
                ((ReactClippingViewGroup) view).updateClippingRect(set);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSubviewClipStatus(View view) {
        ReactViewGroup reactViewGroup;
        if (this._removeClippedSubviews && getParent() != null) {
            Rect rect = this.clippingRect;
            if (rect == null) {
                throw new IllegalStateException("Required value was null.");
            }
            View[] viewArr = this.allChildren;
            if (viewArr == null) {
                throw new IllegalStateException("Required value was null.");
            }
            if (rect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) != (!isViewClipped(view, null))) {
                this.inSubviewClippingLoop = true;
                int i = this.allChildrenCount;
                int i2 = 0;
                int i3 = 0;
                while (i2 < i) {
                    View view2 = viewArr[i2];
                    if (view2 == view) {
                        updateSubviewClipStatus$default(this, rect, i2, i3, null, 8, null);
                        reactViewGroup = this;
                        reactViewGroup.inSubviewClippingLoop = false;
                    } else {
                        int i4 = i2;
                        Rect rect2 = rect;
                        if (isViewClipped(view2, Integer.valueOf(i4))) {
                            i3++;
                        }
                        rect = rect2;
                        i2 = i4 + 1;
                    }
                }
                reactViewGroup = this;
                reactViewGroup.inSubviewClippingLoop = false;
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this._removeClippedSubviews) {
            updateClippingRect();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this._removeClippedSubviews) {
            updateClippingRect();
        }
        if (this.focusOnAttach) {
            requestFocusFromJS$ReactAndroid_release();
            this.focusOnAttach = false;
        }
    }

    private final boolean customDrawOrderDisabled() {
        return getId() != -1 && ViewUtil.getUIManagerType(getId()) == 2;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        UiThreadUtil.assertOnUiThread();
        checkViewClippingTag(child, false);
        if (!customDrawOrderDisabled()) {
            getDrawingOrderHelper().handleAddView(child);
            setChildrenDrawingOrderEnabled(getDrawingOrderHelper().shouldEnableCustomDrawingOrder());
        } else {
            setChildrenDrawingOrderEnabled(false);
        }
        super.onViewAdded(child);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        UiThreadUtil.assertOnUiThread();
        checkViewClippingTag(child, true);
        if (!customDrawOrderDisabled()) {
            getDrawingOrderHelper().handleRemoveView(child);
            setChildrenDrawingOrderEnabled(getDrawingOrderHelper().shouldEnableCustomDrawingOrder());
        } else {
            setChildrenDrawingOrderEnabled(false);
        }
        if (child.getParent() != null) {
            trackChildViewTransition(child.getId());
        }
        super.onViewRemoved(child);
    }

    private final void checkViewClippingTag(View view, boolean z) {
        if (this.inSubviewClippingLoop) {
            Object tag = view.getTag(R$id.view_clipped);
            if (!Intrinsics.areEqual(Boolean.valueOf(z), tag)) {
                ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.RVG_ON_VIEW_REMOVED, new ReactNoCrashSoftException("View clipping tag mismatch: tag=" + tag + " expected=" + z));
            }
        }
        if (this._removeClippedSubviews) {
            view.setTag(R$id.view_clipped, Boolean.valueOf(z));
        } else {
            view.setTag(R$id.view_clipped, null);
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        UiThreadUtil.assertOnUiThread();
        return !customDrawOrderDisabled() ? getDrawingOrderHelper().getChildDrawingOrder(i, i2) : i2;
    }

    @Override // com.facebook.react.uimanager.ReactZIndexedViewGroup
    public int getZIndexMappedChildIndex(int i) {
        UiThreadUtil.assertOnUiThread();
        return (customDrawOrderDisabled() || !getDrawingOrderHelper().shouldEnableCustomDrawingOrder()) ? i : getDrawingOrderHelper().getChildDrawingOrder(getChildCount(), i);
    }

    @Override // com.facebook.react.uimanager.ReactZIndexedViewGroup
    public void updateDrawingOrder() {
        if (customDrawOrderDisabled()) {
            return;
        }
        getDrawingOrderHelper().update();
        setChildrenDrawingOrderEnabled(getDrawingOrderHelper().shouldEnableCustomDrawingOrder());
        invalidate();
    }

    private final void resetPointerEvents() {
        setPointerEvents(PointerEvents.AUTO);
    }

    public final View getChildAtWithSubviewClippingEnabled$ReactAndroid_release(int i) {
        if (i < 0 || i >= this.allChildrenCount) {
            return null;
        }
        View[] viewArr = this.allChildren;
        if (viewArr != null) {
            return viewArr[i];
        }
        throw new IllegalStateException("Required value was null.");
    }

    public final void addViewWithSubviewClippingEnabled$ReactAndroid_release(View child, int i) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (!this._removeClippedSubviews) {
            throw new IllegalStateException("Check failed.");
        }
        Companion.setViewClipped(child, true);
        addInArray(child, i);
        Rect rect = this.clippingRect;
        if (rect == null) {
            throw new IllegalStateException("Required value was null.");
        }
        View[] viewArr = this.allChildren;
        if (viewArr == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.inSubviewClippingLoop = true;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (isViewClipped(viewArr[i3], Integer.valueOf(i3))) {
                i2++;
            }
        }
        updateSubviewClipStatus$default(this, rect, i, i2, null, 8, null);
        this.inSubviewClippingLoop = false;
        child.addOnLayoutChangeListener(this.childrenLayoutChangeListener);
    }

    public final void removeViewWithSubviewClippingEnabled$ReactAndroid_release(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        UiThreadUtil.assertOnUiThread();
        if (!this._removeClippedSubviews) {
            throw new IllegalStateException("Check failed.");
        }
        View[] viewArr = this.allChildren;
        if (viewArr == null) {
            throw new IllegalStateException("Required value was null.");
        }
        view.removeOnLayoutChangeListener(this.childrenLayoutChangeListener);
        int iIndexOfChildInAllChildren = indexOfChildInAllChildren(view);
        if (!isViewClipped(viewArr[iIndexOfChildInAllChildren], Integer.valueOf(iIndexOfChildInAllChildren))) {
            int i = 0;
            for (int i2 = 0; i2 < iIndexOfChildInAllChildren; i2++) {
                if (isViewClipped(viewArr[i2], Integer.valueOf(i2))) {
                    i++;
                }
            }
            removeViewsInLayout(iIndexOfChildInAllChildren - i, 1);
            invalidate();
        }
        removeFromArray(iIndexOfChildInAllChildren);
    }

    public final void removeAllViewsWithSubviewClippingEnabled$ReactAndroid_release() {
        if (!this._removeClippedSubviews) {
            throw new IllegalStateException("Check failed.");
        }
        View[] viewArr = this.allChildren;
        if (viewArr == null) {
            throw new IllegalStateException("Required value was null.");
        }
        int i = this.allChildrenCount;
        for (int i2 = 0; i2 < i; i2++) {
            View view = viewArr[i2];
            if (view != null) {
                view.removeOnLayoutChangeListener(this.childrenLayoutChangeListener);
            }
        }
        removeAllViewsInLayout();
        this.allChildrenCount = 0;
    }

    private final boolean isViewClipped(View view, Integer num) {
        if (view == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Object tag = view.getTag(R$id.view_clipped);
        if (tag != null) {
            return ((Boolean) tag).booleanValue();
        }
        ViewParent parent = view.getParent();
        boolean zIsChildRemovedWhileTransitioning = isChildRemovedWhileTransitioning(view);
        if (num != null) {
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.RVG_IS_VIEW_CLIPPED, new ReactNoCrashSoftException("View missing clipping tag: index=" + num + " parentNull=" + (parent == null) + " parentThis=" + (parent == this) + " transitioning=" + zIsChildRemovedWhileTransitioning));
        }
        if (parent == null || zIsChildRemovedWhileTransitioning) {
            return true;
        }
        if (parent == this) {
            return false;
        }
        throw new IllegalStateException("Check failed.");
    }

    private final int indexOfChildInAllChildren(View view) {
        int i = this.allChildrenCount;
        View[] viewArr = this.allChildren;
        if (viewArr == null) {
            throw new IllegalStateException("Required value was null.");
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (viewArr[i2] == view) {
                return i2;
            }
        }
        return -1;
    }

    private final void addInArray(View view, int i) {
        View[] viewArr = this.allChildren;
        if (viewArr == null) {
            throw new IllegalStateException("Required value was null.");
        }
        int i2 = this.allChildrenCount;
        int length = viewArr.length;
        if (i == i2) {
            if (length == i2) {
                View[] viewArr2 = new View[length + 12];
                System.arraycopy(viewArr, 0, viewArr2, 0, length);
                this.allChildren = viewArr2;
                viewArr = viewArr2;
            }
            int i3 = this.allChildrenCount;
            this.allChildrenCount = i3 + 1;
            viewArr[i3] = view;
            return;
        }
        if (i < i2) {
            if (length == i2) {
                View[] viewArr3 = new View[length + 12];
                System.arraycopy(viewArr, 0, viewArr3, 0, i);
                System.arraycopy(viewArr, i, viewArr3, i + 1, i2 - i);
                this.allChildren = viewArr3;
                viewArr = viewArr3;
            } else {
                System.arraycopy(viewArr, i, viewArr, i + 1, i2 - i);
            }
            viewArr[i] = view;
            this.allChildrenCount++;
            return;
        }
        throw new IndexOutOfBoundsException("index=" + i + " count=" + i2);
    }

    private final void removeFromArray(int i) {
        View[] viewArr = this.allChildren;
        if (viewArr == null) {
            throw new IllegalStateException("Required value was null.");
        }
        int i2 = this.allChildrenCount;
        if (i == i2 - 1) {
            int i3 = i2 - 1;
            this.allChildrenCount = i3;
            viewArr[i3] = null;
        } else {
            if (i >= 0 && i < i2) {
                System.arraycopy(viewArr, i + 1, viewArr, i, (i2 - i) - 1);
                int i4 = this.allChildrenCount - 1;
                this.allChildrenCount = i4;
                viewArr[i4] = null;
                return;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // com.facebook.react.uimanager.ReactOverflowView
    public String getOverflow() {
        Overflow overflow = this._overflow;
        int i = overflow == null ? -1 : WhenMappings.$EnumSwitchMapping$0[overflow.ordinal()];
        if (i == 1) {
            return "hidden";
        }
        if (i == 2) {
            return "scroll";
        }
        if (i != 3) {
            return null;
        }
        return "visible";
    }

    public void setOverflow(String str) {
        Overflow overflowFromString;
        if (str == null) {
            overflowFromString = Overflow.VISIBLE;
        } else {
            overflowFromString = Overflow.Companion.fromString(str);
        }
        this._overflow = overflowFromString;
        invalidate();
    }

    @Override // com.facebook.react.uimanager.ReactOverflowViewWithInset
    public void setOverflowInset(int i, int i2, int i3, int i4) {
        if (BlendModeHelper.needsIsolatedLayer(this) && (getOverflowInset().left != i || getOverflowInset().top != i2 || getOverflowInset().right != i3 || getOverflowInset().bottom != i4)) {
            invalidate();
        }
        getOverflowInset().set(i, i2, i3, i4);
    }

    private final void updateBackgroundDrawable(Drawable drawable) {
        super.setBackground(drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (Build.VERSION.SDK_INT >= 29 && ViewUtil.getUIManagerType(this) == 2 && BlendModeHelper.needsIsolatedLayer(this)) {
            Rect overflowInset = getOverflowInset();
            canvas.saveLayer(overflowInset.left, overflowInset.top, getWidth() + (-overflowInset.right), getHeight() + (-overflowInset.bottom), null);
            super.draw(canvas);
            canvas.restore();
            return;
        }
        super.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this._overflow != Overflow.VISIBLE || getTag(R$id.filter) != null) {
            BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
        }
        super.dispatchDraw(canvas);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x006c A[PHI: r4
      0x006c: PHI (r4v1 android.graphics.BlendMode) = 
      (r4v0 android.graphics.BlendMode)
      (r4v0 android.graphics.BlendMode)
      (r4v0 android.graphics.BlendMode)
      (r4v3 android.graphics.BlendMode)
     binds: [B:9:0x0022, B:11:0x0029, B:13:0x002f, B:17:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long j) {
        Canvas canvas2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(child, "child");
        boolean z = child.getElevation() > 0.0f;
        if (z) {
            CanvasUtil.enableZ(canvas, true);
        }
        BlendMode blendModeM = null;
        if (Build.VERSION.SDK_INT >= 29 && ViewUtil.getUIManagerType(this) == 2 && BlendModeHelper.needsIsolatedLayer(this)) {
            Object tag = child.getTag(R$id.mix_blend_mode);
            blendModeM = ReactViewGroup$$ExternalSyntheticApiModelOutline0.m(tag) ? ReactRootView$$ExternalSyntheticApiModelOutline0.m(tag) : null;
            if (blendModeM != null) {
                Paint paint = new Paint();
                paint.setBlendMode(blendModeM);
                Rect overflowInset = getOverflowInset();
                canvas2 = canvas;
                canvas2.saveLayer(overflowInset.left, overflowInset.top, getWidth() + (-overflowInset.right), getHeight() + (-overflowInset.bottom), paint);
            } else {
                canvas2 = canvas;
            }
        } else {
            canvas2 = canvas;
        }
        boolean zDrawChild = super.drawChild(canvas2, child, j);
        if (blendModeM != null) {
            canvas2.restore();
        }
        if (z) {
            CanvasUtil.enableZ(canvas2, false);
        }
        return zDrawChild;
    }

    public final void setOpacityIfPossible(float f) {
        this.backfaceOpacity = f;
        setBackfaceVisibilityDependantOpacity();
    }

    public final void setBackfaceVisibility(String backfaceVisibility) {
        Intrinsics.checkNotNullParameter(backfaceVisibility, "backfaceVisibility");
        this.backfaceVisible = Intrinsics.areEqual("visible", backfaceVisibility);
        setBackfaceVisibilityDependantOpacity();
    }

    public final void setBackfaceVisibilityDependantOpacity() {
        if (this.backfaceVisible) {
            setAlpha(this.backfaceOpacity);
            return;
        }
        float rotationX = getRotationX();
        float rotationY = getRotationY();
        if (rotationX >= -90.0f && rotationX < 90.0f && rotationY >= -90.0f && rotationY < 90.0f) {
            setAlpha(this.backfaceOpacity);
        } else {
            setAlpha(0.0f);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addChildrenForAccessibility(ArrayList<View> outChildren) {
        Intrinsics.checkNotNullParameter(outChildren, "outChildren");
        Object tag = getTag(R$id.accessibility_order_parent);
        List<String> list = tag instanceof ReactViewGroup ? ((ReactViewGroup) tag).axOrderList : null;
        List<String> list2 = this.axOrderList;
        int i = 0;
        if (list2 == null) {
            if (list != null) {
                if (!isFocusable()) {
                    super.addChildrenForAccessibility(outChildren);
                    return;
                }
                if (isFocusable() && (getContentDescription() == null || Intrinsics.areEqual(getContentDescription(), ""))) {
                    super.addChildrenForAccessibility(outChildren);
                    int childCount = getChildCount();
                    while (i < childCount) {
                        ReactAxOrderHelper reactAxOrderHelper = ReactAxOrderHelper.INSTANCE;
                        View childAt = getChildAt(i);
                        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                        reactAxOrderHelper.disableFocusForSubtree(childAt, list);
                        i++;
                    }
                    return;
                }
                if (!isFocusable() || getContentDescription() == null) {
                    return;
                }
                Intrinsics.areEqual(getContentDescription(), "");
                return;
            }
            super.addChildrenForAccessibility(outChildren);
            return;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (this.accessibilityStateChangeListener == null && accessibilityManager != null) {
            AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: com.facebook.react.views.view.ReactViewGroup$$ExternalSyntheticLambda1
                @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
                public final void onAccessibilityStateChanged(boolean z) {
                    ReactViewGroup.addChildrenForAccessibility$lambda$1(this.f$0, z);
                }
            };
            accessibilityManager.addAccessibilityStateChangeListener(accessibilityStateChangeListener);
            this.accessibilityStateChangeListener = accessibilityStateChangeListener;
        }
        int size = list2.size();
        View[] viewArr = new View[size];
        int childCount2 = getChildCount();
        for (int i2 = 0; i2 < childCount2; i2++) {
            ReactAxOrderHelper reactAxOrderHelper2 = ReactAxOrderHelper.INSTANCE;
            View childAt2 = getChildAt(i2);
            Intrinsics.checkNotNullExpressionValue(childAt2, "getChildAt(...)");
            reactAxOrderHelper2.buildAxOrderList(childAt2, this, list2, viewArr);
        }
        while (i < size) {
            View view = viewArr[i];
            if (view != null) {
                if (view.isFocusable()) {
                    outChildren.add(view);
                } else {
                    view.addChildrenForAccessibility(outChildren);
                }
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addChildrenForAccessibility$lambda$1(ReactViewGroup reactViewGroup, boolean z) {
        if (z) {
            return;
        }
        int childCount = reactViewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = reactViewGroup.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
            ReactAxOrderHelper.restoreFocusability(childAt);
        }
    }

    public final void cleanUpAxOrderListener() {
        AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener;
        Object systemService = getContext().getSystemService("accessibility");
        AccessibilityManager accessibilityManager = systemService instanceof AccessibilityManager ? (AccessibilityManager) systemService : null;
        if (accessibilityManager != null && (accessibilityStateChangeListener = this.accessibilityStateChangeListener) != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(accessibilityStateChangeListener);
        }
        this.accessibilityStateChangeListener = null;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setViewClipped(View view, boolean z) {
            view.setTag(R$id.view_clipped, Boolean.valueOf(z));
        }
    }
}
