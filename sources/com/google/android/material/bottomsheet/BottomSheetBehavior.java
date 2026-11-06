package com.google.android.material.bottomsheet;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBottomContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior implements MaterialBackHandler {
    private static final int DEF_STYLE_RES = R$style.Widget_Design_BottomSheet_Modal;
    WeakReference accessibilityDelegateViewRef;
    int activePointerId;
    private ColorStateList backgroundTint;
    MaterialBottomContainerBackHelper bottomContainerBackHelper;
    private final ArrayList callbacks;
    private int childHeight;
    final SparseIntArray collapseActionIds;
    int collapsedOffset;
    private WeakReference currentTouchedScrollChildRef;
    private final ViewDragHelper.Callback dragCallback;
    WeakReference dragHandleViewRef;
    private boolean draggable;
    private boolean draggableOnNestedScroll;
    private boolean draggableOnNestedScrollLastDragIgnored;
    float elevation;
    final SparseIntArray expandActionIds;
    final SparseIntArray expandHalfwayActionIds;
    private boolean expandedCornersRemoved;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    private float hideFriction;
    boolean hideable;
    private boolean ignoreEvents;
    private Map importantForAccessibilityMap;
    private int initialY;
    private int insetBottom;
    private int insetTop;
    private ValueAnimator interpolatorAnimator;
    private int lastNestedScrollDy;
    int lastStableState;
    private boolean marginLeftSystemWindowInsets;
    private boolean marginRightSystemWindowInsets;
    private boolean marginTopSystemWindowInsets;
    private MaterialShapeDrawable materialShapeDrawable;
    private int maxHeight;
    private int maxWidth;
    private float maximumVelocity;
    private boolean multipleScrollingChildrenSupported;
    private boolean nestedScrolled;
    final List nestedScrollingChildrenRef;
    private boolean paddingBottomSystemWindowInsets;
    private boolean paddingLeftSystemWindowInsets;
    private boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shouldRemoveExpandedCorners;
    private int significantVelocityThreshold;
    private boolean skipCollapsed;
    int state;
    private final StateSettlingTracker stateSettlingTracker;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    private VelocityTracker velocityTracker;
    ViewDragHelper viewDragHelper;
    WeakReference viewRef;

    public static abstract class BottomSheetCallback {
        void onLayout(View view) {
        }

        public abstract void onSlide(View view, float f);

        public abstract void onStateChanged(View view, int i);
    }

    public boolean isHideableWhenDragging() {
        return true;
    }

    public boolean isNestedScrollingCheckEnabled() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    public boolean shouldExpandOnUpwardDrag(long j, float f) {
        return false;
    }

    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return false;
    }

    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new StateSettlingTracker();
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.draggableOnNestedScroll = true;
        this.state = 4;
        this.lastStableState = 4;
        this.hideFriction = 0.1f;
        this.nestedScrollingChildrenRef = new ArrayList();
        this.callbacks = new ArrayList();
        this.initialY = -1;
        this.expandHalfwayActionIds = new SparseIntArray();
        this.expandActionIds = new SparseIntArray();
        this.collapseActionIds = new SparseIntArray();
        this.dragCallback = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
            private long viewCapturedMillis;

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                View singleScrollingChildOrNull;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i2 = bottomSheetBehavior.state;
                if (i2 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                    return false;
                }
                if (i2 == 3 && bottomSheetBehavior.activePointerId == i) {
                    if (bottomSheetBehavior.multipleScrollingChildrenSupported) {
                        singleScrollingChildOrNull = BottomSheetBehavior.this.currentTouchedScrollChildRef != null ? (View) BottomSheetBehavior.this.currentTouchedScrollChildRef.get() : null;
                    } else {
                        singleScrollingChildOrNull = BottomSheetBehavior.this.getSingleScrollingChildOrNull();
                    }
                    if (singleScrollingChildOrNull != null && singleScrollingChildOrNull.canScrollVertically(-1)) {
                        return false;
                    }
                }
                this.viewCapturedMillis = SystemClock.uptimeMillis();
                WeakReference weakReference = BottomSheetBehavior.this.viewRef;
                return weakReference != null && weakReference.get() == view;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                BottomSheetBehavior.this.dispatchOnSlide(i2);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i) {
                if (i == 1 && BottomSheetBehavior.this.draggable) {
                    BottomSheetBehavior.this.setStateInternal(1);
                }
            }

            private boolean releasedLow(View view) {
                int top = view.getTop();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return top > (bottomSheetBehavior.parentHeight + bottomSheetBehavior.getExpandedOffset()) / 2;
            }

            /* JADX WARN: Code duplicated, block: B:39:0x00ad  */
            /* JADX WARN: Code duplicated, block: B:6:0x0010  */
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                int i = 6;
                if (f2 < 0.0f) {
                    if (BottomSheetBehavior.this.fitToContents) {
                        i = 3;
                    } else {
                        int top = view.getTop();
                        long jUptimeMillis = SystemClock.uptimeMillis() - this.viewCapturedMillis;
                        if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                            if (!bottomSheetBehavior.shouldExpandOnUpwardDrag(jUptimeMillis, (top * 100.0f) / bottomSheetBehavior.parentHeight)) {
                                i = 4;
                            }
                        } else if (top <= BottomSheetBehavior.this.halfExpandedOffset) {
                        }
                        i = 3;
                    }
                } else {
                    BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior2.hideable && bottomSheetBehavior2.shouldHide(view, f2)) {
                        if ((Math.abs(f) < Math.abs(f2) && f2 > BottomSheetBehavior.this.significantVelocityThreshold) || releasedLow(view)) {
                            i = 5;
                        } else if (BottomSheetBehavior.this.fitToContents || Math.abs(view.getTop() - BottomSheetBehavior.this.getExpandedOffset()) < Math.abs(view.getTop() - BottomSheetBehavior.this.halfExpandedOffset)) {
                            i = 3;
                        }
                    } else if (f2 != 0.0f && Math.abs(f) <= Math.abs(f2)) {
                        if (BottomSheetBehavior.this.fitToContents) {
                            i = 4;
                        } else {
                            int top2 = view.getTop();
                            if (Math.abs(top2 - BottomSheetBehavior.this.halfExpandedOffset) >= Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset) || BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                                i = 4;
                            }
                        }
                    } else {
                        int top3 = view.getTop();
                        if (BottomSheetBehavior.this.fitToContents) {
                            if (Math.abs(top3 - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top3 - BottomSheetBehavior.this.collapsedOffset)) {
                                i = 3;
                            } else {
                                i = 4;
                            }
                        } else {
                            BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                            int i2 = bottomSheetBehavior3.halfExpandedOffset;
                            if (top3 < i2) {
                                if (top3 < Math.abs(top3 - bottomSheetBehavior3.collapsedOffset)) {
                                    i = 3;
                                } else if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                                    i = 4;
                                }
                            } else if (Math.abs(top3 - i2) >= Math.abs(top3 - BottomSheetBehavior.this.collapsedOffset) || BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                                i = 4;
                            }
                        }
                    }
                }
                BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                bottomSheetBehavior4.startSettling(view, i, bottomSheetBehavior4.shouldSkipSmoothAnimation());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return MathUtils.clamp(i, BottomSheetBehavior.this.getExpandedOffset(), getViewVerticalDragRange(view));
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                if (BottomSheetBehavior.this.canBeHiddenByDragging()) {
                    return BottomSheetBehavior.this.parentHeight;
                }
                return BottomSheetBehavior.this.collapsedOffset;
            }
        };
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new StateSettlingTracker();
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.draggableOnNestedScroll = true;
        this.state = 4;
        this.lastStableState = 4;
        this.hideFriction = 0.1f;
        this.nestedScrollingChildrenRef = new ArrayList();
        this.callbacks = new ArrayList();
        this.initialY = -1;
        this.expandHalfwayActionIds = new SparseIntArray();
        this.expandActionIds = new SparseIntArray();
        this.collapseActionIds = new SparseIntArray();
        this.dragCallback = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
            private long viewCapturedMillis;

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i2) {
                View singleScrollingChildOrNull;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i3 = bottomSheetBehavior.state;
                if (i3 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                    return false;
                }
                if (i3 == 3 && bottomSheetBehavior.activePointerId == i2) {
                    if (bottomSheetBehavior.multipleScrollingChildrenSupported) {
                        singleScrollingChildOrNull = BottomSheetBehavior.this.currentTouchedScrollChildRef != null ? (View) BottomSheetBehavior.this.currentTouchedScrollChildRef.get() : null;
                    } else {
                        singleScrollingChildOrNull = BottomSheetBehavior.this.getSingleScrollingChildOrNull();
                    }
                    if (singleScrollingChildOrNull != null && singleScrollingChildOrNull.canScrollVertically(-1)) {
                        return false;
                    }
                }
                this.viewCapturedMillis = SystemClock.uptimeMillis();
                WeakReference weakReference = BottomSheetBehavior.this.viewRef;
                return weakReference != null && weakReference.get() == view;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
                BottomSheetBehavior.this.dispatchOnSlide(i3);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i2) {
                if (i2 == 1 && BottomSheetBehavior.this.draggable) {
                    BottomSheetBehavior.this.setStateInternal(1);
                }
            }

            private boolean releasedLow(View view) {
                int top = view.getTop();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return top > (bottomSheetBehavior.parentHeight + bottomSheetBehavior.getExpandedOffset()) / 2;
            }

            /* JADX WARN: Code duplicated, block: B:39:0x00ad  */
            /* JADX WARN: Code duplicated, block: B:6:0x0010  */
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                int i2 = 6;
                if (f2 < 0.0f) {
                    if (BottomSheetBehavior.this.fitToContents) {
                        i2 = 3;
                    } else {
                        int top = view.getTop();
                        long jUptimeMillis = SystemClock.uptimeMillis() - this.viewCapturedMillis;
                        if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                            if (!bottomSheetBehavior.shouldExpandOnUpwardDrag(jUptimeMillis, (top * 100.0f) / bottomSheetBehavior.parentHeight)) {
                                i2 = 4;
                            }
                        } else if (top <= BottomSheetBehavior.this.halfExpandedOffset) {
                        }
                        i2 = 3;
                    }
                } else {
                    BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior2.hideable && bottomSheetBehavior2.shouldHide(view, f2)) {
                        if ((Math.abs(f) < Math.abs(f2) && f2 > BottomSheetBehavior.this.significantVelocityThreshold) || releasedLow(view)) {
                            i2 = 5;
                        } else if (BottomSheetBehavior.this.fitToContents || Math.abs(view.getTop() - BottomSheetBehavior.this.getExpandedOffset()) < Math.abs(view.getTop() - BottomSheetBehavior.this.halfExpandedOffset)) {
                            i2 = 3;
                        }
                    } else if (f2 != 0.0f && Math.abs(f) <= Math.abs(f2)) {
                        if (BottomSheetBehavior.this.fitToContents) {
                            i2 = 4;
                        } else {
                            int top2 = view.getTop();
                            if (Math.abs(top2 - BottomSheetBehavior.this.halfExpandedOffset) >= Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset) || BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                                i2 = 4;
                            }
                        }
                    } else {
                        int top3 = view.getTop();
                        if (BottomSheetBehavior.this.fitToContents) {
                            if (Math.abs(top3 - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top3 - BottomSheetBehavior.this.collapsedOffset)) {
                                i2 = 3;
                            } else {
                                i2 = 4;
                            }
                        } else {
                            BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                            int i3 = bottomSheetBehavior3.halfExpandedOffset;
                            if (top3 < i3) {
                                if (top3 < Math.abs(top3 - bottomSheetBehavior3.collapsedOffset)) {
                                    i2 = 3;
                                } else if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                                    i2 = 4;
                                }
                            } else if (Math.abs(top3 - i3) >= Math.abs(top3 - BottomSheetBehavior.this.collapsedOffset) || BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                                i2 = 4;
                            }
                        }
                    }
                }
                BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                bottomSheetBehavior4.startSettling(view, i2, bottomSheetBehavior4.shouldSkipSmoothAnimation());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i2, int i3) {
                return MathUtils.clamp(i2, BottomSheetBehavior.this.getExpandedOffset(), getViewVerticalDragRange(view));
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view, int i2, int i3) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                if (BottomSheetBehavior.this.canBeHiddenByDragging()) {
                    return BottomSheetBehavior.this.parentHeight;
                }
                return BottomSheetBehavior.this.collapsedOffset;
            }
        };
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_backgroundTint)) {
            this.backgroundTint = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, R$styleable.BottomSheetBehavior_Layout_backgroundTint);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(context, attributeSet, R$attr.bottomSheetStyle, DEF_STYLE_RES).build();
        }
        createMaterialShapeDrawableIfNeeded(context);
        createShapeValueAnimator();
        this.elevation = typedArrayObtainStyledAttributes.getDimension(R$styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_android_maxWidth)) {
            setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_android_maxWidth, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_android_maxHeight)) {
            setMaxHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_android_maxHeight, -1));
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue != null && (i = typedValuePeekValue.data) == -1) {
            setPeekHeight(i);
        } else {
            setPeekHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        setHideable(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setDraggableOnNestedScroll(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_draggableOnNestedScroll, true));
        setSaveFlags(typedArrayObtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(typedArrayObtainStyledAttributes.getFloat(R$styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            setExpandedOffset(typedValuePeekValue2.data);
        } else {
            setExpandedOffset(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        }
        setSignificantVelocityThreshold(typedArrayObtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500));
        this.multipleScrollingChildrenSupported = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_multipleScrollingChildrenSupported, false);
        this.paddingBottomSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.paddingTopSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.marginLeftSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.marginRightSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.marginTopSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        this.shouldRemoveExpandedCorners = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
        typedArrayObtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, view), this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, view, savedState.getSuperState());
        restoreOptionalState(savedState);
        int i = savedState.state;
        if (i == 1 || i == 2) {
            this.state = 4;
            this.lastStableState = 4;
        } else {
            this.state = i;
            this.lastStableState = i;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.viewRef = null;
        this.viewDragHelper = null;
        this.bottomContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
        this.bottomContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, this.maxWidth, marginLayoutParams.width), getChildMeasureSpec(i3, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, this.maxHeight, marginLayoutParams.height));
        return true;
    }

    private int getChildMeasureSpec(int i, int i2, int i3, int i4) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i2, i4);
        if (i3 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), 1073741824);
        }
        if (size != 0) {
            i3 = Math.min(size, i3);
        }
        return View.MeasureSpec.makeMeasureSpec(i3, LinearLayoutManager.INVALID_OFFSET);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            setWindowInsetsListener(view);
            ViewCompat.setWindowInsetsAnimationCallback(view, new InsetsAnimationCallback(view));
            this.viewRef = new WeakReference(view);
            this.bottomContainerBackHelper = new MaterialBottomContainerBackHelper(view);
            MaterialShapeDrawable materialShapeDrawable = this.materialShapeDrawable;
            if (materialShapeDrawable != null) {
                view.setBackground(materialShapeDrawable);
                MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
                float elevation = this.elevation;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                materialShapeDrawable2.setElevation(elevation);
            } else {
                ColorStateList colorStateList = this.backgroundTint;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(view, colorStateList);
                }
            }
            updateAccessibilityActions();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.dragCallback);
        }
        int top = view.getTop();
        coordinatorLayout.onLayoutChild(view, i);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.childHeight = height;
        int iMin = this.parentHeight;
        int i2 = iMin - height;
        int i3 = this.insetTop;
        if (i2 < i3) {
            if (this.paddingTopSystemWindowInsets) {
                int i4 = this.maxHeight;
                if (i4 != -1) {
                    iMin = Math.min(iMin, i4);
                }
                this.childHeight = iMin;
            } else {
                int iMin2 = iMin - i3;
                int i5 = this.maxHeight;
                if (i5 != -1) {
                    iMin2 = Math.min(iMin2, i5);
                }
                this.childHeight = iMin2;
            }
        }
        this.fitToContentsOffset = Math.max(0, this.parentHeight - this.childHeight);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i6 = this.state;
        if (i6 == 3) {
            ViewCompat.offsetTopAndBottom(view, getExpandedOffset());
        } else if (i6 == 6) {
            ViewCompat.offsetTopAndBottom(view, this.halfExpandedOffset);
        } else if (this.hideable && i6 == 5) {
            ViewCompat.offsetTopAndBottom(view, this.parentHeight);
        } else if (i6 == 4) {
            ViewCompat.offsetTopAndBottom(view, this.collapsedOffset);
        } else if (i6 == 1 || i6 == 2) {
            ViewCompat.offsetTopAndBottom(view, top - view.getTop());
        }
        updateDrawableForTargetState(this.state, false);
        this.nestedScrollingChildrenRef.clear();
        if (this.multipleScrollingChildrenSupported) {
            populateScrollingChildren(view);
        } else {
            this.nestedScrollingChildrenRef.add(new WeakReference(findScrollingChild(view)));
        }
        for (int i7 = 0; i7 < this.callbacks.size(); i7++) {
            ((BottomSheetCallback) this.callbacks.get(i7)).onLayout(view);
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i;
        ViewDragHelper viewDragHelper;
        if (!view.isShown() || !this.draggable) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            WeakReference weakReference = new WeakReference(findScrollingChildContainingCoordinates(coordinatorLayout, (int) motionEvent.getX(), (int) motionEvent.getY()));
            this.currentTouchedScrollChildRef = weakReference;
            if (this.state != 2 && weakReference.get() != null) {
                this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                if (!isTouchingDragHandle(coordinatorLayout, x, this.initialY)) {
                    this.touchingScrollingChild = true;
                }
            }
            this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(view, x, this.initialY);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.touchingScrollingChild = false;
            this.currentTouchedScrollChildRef = null;
            this.activePointerId = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        }
        if (this.ignoreEvents || (viewDragHelper = this.viewDragHelper) == null || !viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return (actionMasked != 2 || !hasScrollingChild() || this.ignoreEvents || this.state == 1 || isTouchingScrollingChild(coordinatorLayout, motionEvent) || this.viewDragHelper == null || (i = this.initialY) == -1 || Math.abs(((float) i) - motionEvent.getY()) <= ((float) this.viewDragHelper.getTouchSlop())) ? false : true;
        }
        return true;
    }

    private boolean hasScrollingChild() {
        Iterator it = this.nestedScrollingChildrenRef.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getSingleScrollingChildOrNull() {
        if (this.nestedScrollingChildrenRef.isEmpty()) {
            return null;
        }
        return (View) ((WeakReference) this.nestedScrollingChildrenRef.get(0)).get();
    }

    private boolean isTouchingScrollingChild(CoordinatorLayout coordinatorLayout, MotionEvent motionEvent) {
        if (this.multipleScrollingChildrenSupported) {
            WeakReference weakReference = this.currentTouchedScrollChildRef;
            return (weakReference == null || weakReference.get() == null) ? false : true;
        }
        View singleScrollingChildOrNull = getSingleScrollingChildOrNull();
        return singleScrollingChildOrNull != null && coordinatorLayout.isPointInChildBounds(singleScrollingChildOrNull, (int) motionEvent.getX(), (int) motionEvent.getY());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        if (shouldHandleDraggingWithHelper()) {
            this.viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (shouldHandleDraggingWithHelper() && actionMasked == 2 && !this.ignoreEvents && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.getTouchSlop()) {
            this.viewDragHelper.captureChildView(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        return (i & 2) != 0;
    }

    private boolean isViewScrollingChild(View view) {
        Iterator it = this.nestedScrollingChildrenRef.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == view) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        boolean zIsViewScrollingChild = isViewScrollingChild(view2);
        if (!isNestedScrollingCheckEnabled() || zIsViewScrollingChild) {
            int top = view.getTop();
            int i4 = top - i2;
            if (i2 > 0) {
                if (!this.nestedScrolled && !this.draggableOnNestedScroll && zIsViewScrollingChild && view2.canScrollVertically(1)) {
                    this.draggableOnNestedScrollLastDragIgnored = true;
                    return;
                }
                if (i4 < getExpandedOffset()) {
                    int expandedOffset = top - getExpandedOffset();
                    iArr[1] = expandedOffset;
                    ViewCompat.offsetTopAndBottom(view, -expandedOffset);
                    setStateInternal(3);
                } else {
                    if (!this.draggable) {
                        return;
                    }
                    iArr[1] = i2;
                    ViewCompat.offsetTopAndBottom(view, -i2);
                    setStateInternal(1);
                }
            } else if (i2 < 0) {
                boolean zCanScrollVertically = view2.canScrollVertically(-1);
                if (!this.nestedScrolled && !this.draggableOnNestedScroll && zIsViewScrollingChild && zCanScrollVertically) {
                    this.draggableOnNestedScrollLastDragIgnored = true;
                    return;
                }
                if (!zCanScrollVertically) {
                    if (i4 <= this.collapsedOffset || canBeHiddenByDragging()) {
                        if (!this.draggable) {
                            return;
                        }
                        iArr[1] = i2;
                        ViewCompat.offsetTopAndBottom(view, -i2);
                        setStateInternal(1);
                    } else {
                        int i5 = top - this.collapsedOffset;
                        iArr[1] = i5;
                        ViewCompat.offsetTopAndBottom(view, -i5);
                        setStateInternal(4);
                    }
                }
            }
            dispatchOnSlide(view.getTop());
            this.lastNestedScrollDy = i2;
            this.nestedScrolled = true;
            this.draggableOnNestedScrollLastDragIgnored = false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x008e  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a5  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
        int i2 = 3;
        if (view.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        if (!isNestedScrollingCheckEnabled() || (isViewScrollingChild(view2) && this.nestedScrolled)) {
            if (this.lastNestedScrollDy > 0) {
                if (!this.fitToContents && view.getTop() > this.halfExpandedOffset) {
                    i2 = 6;
                }
            } else if (this.hideable && shouldHide(view, getYVelocity())) {
                i2 = 5;
            } else if (this.lastNestedScrollDy == 0) {
                int top = view.getTop();
                if (this.fitToContents) {
                    if (Math.abs(top - this.fitToContentsOffset) >= Math.abs(top - this.collapsedOffset)) {
                        i2 = 4;
                    }
                } else {
                    int i3 = this.halfExpandedOffset;
                    if (top < i3) {
                        if (top >= Math.abs(top - this.collapsedOffset)) {
                            if (shouldSkipHalfExpandedStateWhenDragging()) {
                                i2 = 4;
                            } else {
                                i2 = 6;
                            }
                        }
                    } else if (Math.abs(top - i3) < Math.abs(top - this.collapsedOffset)) {
                        i2 = 6;
                    } else {
                        i2 = 4;
                    }
                }
            } else {
                if (!this.fitToContents) {
                    int top2 = view.getTop();
                    if (Math.abs(top2 - this.halfExpandedOffset) < Math.abs(top2 - this.collapsedOffset)) {
                        i2 = 6;
                    }
                }
                i2 = 4;
            }
            startSettling(view, i2, false);
            this.nestedScrolled = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View view, View view2, float f, float f2) {
        return isNestedScrollingCheckEnabled() && hasScrollingChild() && isViewScrollingChild(view2) && (!(this.state == 3 || this.draggableOnNestedScrollLastDragIgnored) || super.onNestedPreFling(coordinatorLayout, view, view2, f, f2));
    }

    public void setFitToContents(boolean z) {
        if (this.fitToContents == z) {
            return;
        }
        this.fitToContents = z;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
        }
        setStateInternal((this.fitToContents && this.state == 6) ? 3 : this.state);
        updateDrawableForTargetState(this.state, true);
        updateAccessibilityActions();
    }

    public void setMaxWidth(int i) {
        this.maxWidth = i;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public void setPeekHeight(int i) {
        setPeekHeight(i, false);
    }

    public final void setPeekHeight(int i, boolean z) {
        if (i == -1) {
            if (this.peekHeightAuto) {
                return;
            } else {
                this.peekHeightAuto = true;
            }
        } else {
            if (!this.peekHeightAuto && this.peekHeight == i) {
                return;
            }
            this.peekHeightAuto = false;
            this.peekHeight = Math.max(0, i);
        }
        updatePeekHeight(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePeekHeight(boolean z) {
        View view;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state != 4 || (view = (View) this.viewRef.get()) == null) {
                return;
            }
            if (z) {
                setState(4);
            } else {
                view.requestLayout();
            }
        }
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    public void setHalfExpandedRatio(float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f;
        if (this.viewRef != null) {
            calculateHalfExpandedOffset();
        }
    }

    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public void setExpandedOffset(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.expandedOffset = i;
        updateDrawableForTargetState(this.state, true);
    }

    public int getExpandedOffset() {
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        return Math.max(this.expandedOffset, this.paddingTopSystemWindowInsets ? 0 : this.insetTop);
    }

    public void setHideable(boolean z) {
        if (this.hideable != z) {
            this.hideable = z;
            if (!z && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public void setSkipCollapsed(boolean z) {
        this.skipCollapsed = z;
    }

    public void setDraggable(boolean z) {
        this.draggable = z;
    }

    public void setDraggableOnNestedScroll(boolean z) {
        this.draggableOnNestedScroll = z;
    }

    public void setSignificantVelocityThreshold(int i) {
        this.significantVelocityThreshold = i;
    }

    public void setSaveFlags(int i) {
        this.saveFlags = i;
    }

    public void addBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        if (this.callbacks.contains(bottomSheetCallback)) {
            return;
        }
        this.callbacks.add(bottomSheetCallback);
    }

    public void removeBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.callbacks.remove(bottomSheetCallback);
    }

    public void setState(int i) {
        if (i == 1 || i == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(i == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.hideable || i != 5) {
            final int i2 = (i == 6 && this.fitToContents && getTopOffsetForState(i) <= this.fitToContentsOffset) ? 3 : i;
            WeakReference weakReference = this.viewRef;
            if (weakReference == null || weakReference.get() == null) {
                setStateInternal(i);
            } else {
                final View view = (View) this.viewRef.get();
                runAfterLayout(view, new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BottomSheetBehavior.this.startSettling(view, i2, false);
                    }
                });
            }
        }
    }

    private void runAfterLayout(View view, Runnable runnable) {
        if (isLayouting(view)) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    private boolean isLayouting(View view) {
        ViewParent parent = view.getParent();
        return parent != null && parent.isLayoutRequested() && view.isAttachedToWindow();
    }

    public void setGestureInsetBottomIgnored(boolean z) {
        this.gestureInsetBottomIgnored = z;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public int getState() {
        return this.state;
    }

    void setStateInternal(int i) {
        View view;
        if (this.state == i) {
            return;
        }
        this.state = i;
        if (i == 4 || i == 3 || i == 6 || (this.hideable && i == 5)) {
            this.lastStableState = i;
        }
        WeakReference weakReference = this.viewRef;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            updateImportantForAccessibility(true);
        } else if (i == 6 || i == 5 || i == 4) {
            updateImportantForAccessibility(false);
        }
        updateDrawableForTargetState(i, true);
        for (int i2 = 0; i2 < this.callbacks.size(); i2++) {
            ((BottomSheetCallback) this.callbacks.get(i2)).onStateChanged(view, i);
        }
        updateAccessibilityActions();
    }

    private void updateDrawableForTargetState(int i, boolean z) {
        boolean zIsExpandedAndShouldRemoveCorners;
        ValueAnimator valueAnimator;
        if (i == 2 || this.expandedCornersRemoved == (zIsExpandedAndShouldRemoveCorners = isExpandedAndShouldRemoveCorners()) || this.materialShapeDrawable == null) {
            return;
        }
        this.expandedCornersRemoved = zIsExpandedAndShouldRemoveCorners;
        if (z && (valueAnimator = this.interpolatorAnimator) != null) {
            if (valueAnimator.isRunning()) {
                this.interpolatorAnimator.reverse();
                return;
            } else {
                this.interpolatorAnimator.setFloatValues(this.materialShapeDrawable.getInterpolation(), zIsExpandedAndShouldRemoveCorners ? calculateInterpolationWithCornersRemoved() : 1.0f);
                this.interpolatorAnimator.start();
                return;
            }
        }
        ValueAnimator valueAnimator2 = this.interpolatorAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.interpolatorAnimator.cancel();
        }
        this.materialShapeDrawable.setInterpolation(this.expandedCornersRemoved ? calculateInterpolationWithCornersRemoved() : 1.0f);
    }

    private float calculateInterpolationWithCornersRemoved() {
        WeakReference weakReference;
        WindowInsets rootWindowInsets;
        if (this.materialShapeDrawable == null || (weakReference = this.viewRef) == null || weakReference.get() == null || Build.VERSION.SDK_INT < 31) {
            return 0.0f;
        }
        View view = (View) this.viewRef.get();
        if (!isAtTopOfScreen() || (rootWindowInsets = view.getRootWindowInsets()) == null) {
            return 0.0f;
        }
        return Math.max(calculateCornerInterpolation(this.materialShapeDrawable.getTopLeftCornerResolvedSize(), rootWindowInsets.getRoundedCorner(0)), calculateCornerInterpolation(this.materialShapeDrawable.getTopRightCornerResolvedSize(), rootWindowInsets.getRoundedCorner(1)));
    }

    private float calculateCornerInterpolation(float f, RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            float radius = roundedCorner.getRadius();
            if (radius > 0.0f && f > 0.0f) {
                return radius / f;
            }
        }
        return 0.0f;
    }

    private View findScrollingChildContainingCoordinates(CoordinatorLayout coordinatorLayout, int i, int i2) {
        if (this.nestedScrollingChildrenRef.isEmpty()) {
            return null;
        }
        Iterator it = this.nestedScrollingChildrenRef.iterator();
        while (it.hasNext()) {
            View view = (View) ((WeakReference) it.next()).get();
            if (view != null && coordinatorLayout.isPointInChildBounds(view, i, i2)) {
                return view;
            }
        }
        return null;
    }

    private boolean isTouchingDragHandle(CoordinatorLayout coordinatorLayout, int i, int i2) {
        WeakReference weakReference = this.dragHandleViewRef;
        View view = weakReference != null ? (View) weakReference.get() : null;
        return view != null && coordinatorLayout.isPointInChildBounds(view, i, i2);
    }

    private boolean isAtTopOfScreen() {
        WeakReference weakReference = this.viewRef;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((View) this.viewRef.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isExpandedAndShouldRemoveCorners() {
        if (this.state == 3) {
            return this.shouldRemoveExpandedCorners || isAtTopOfScreen();
        }
        return false;
    }

    private int calculatePeekHeight() {
        int i;
        if (this.peekHeightAuto) {
            return Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight) + this.insetBottom;
        }
        if (!this.gestureInsetBottomIgnored && !this.paddingBottomSystemWindowInsets && (i = this.gestureInsetBottom) > 0) {
            return Math.max(this.peekHeight, i + this.peekHeightGestureInsetBuffer);
        }
        return this.peekHeight + this.insetBottom;
    }

    private void calculateCollapsedOffset() {
        int iCalculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - iCalculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - iCalculatePeekHeight;
        }
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    private float calculateSlideOffsetWithTop(int i) {
        float f;
        float expandedOffset;
        int i2 = this.collapsedOffset;
        if (i > i2 || i2 == getExpandedOffset()) {
            int i3 = this.collapsedOffset;
            f = i3 - i;
            expandedOffset = this.parentHeight - i3;
        } else {
            int i4 = this.collapsedOffset;
            f = i4 - i;
            expandedOffset = i4 - getExpandedOffset();
        }
        return f / expandedOffset;
    }

    private void reset() {
        this.activePointerId = -1;
        this.initialY = -1;
        this.currentTouchedScrollChildRef = null;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(SavedState savedState) {
        int i = this.saveFlags;
        if (i == 0) {
            return;
        }
        if (i == -1 || (i & 1) == 1) {
            this.peekHeight = savedState.peekHeight;
        }
        if (i == -1 || (i & 2) == 2) {
            this.fitToContents = savedState.fitToContents;
        }
        if (i == -1 || (i & 4) == 4) {
            this.hideable = savedState.hideable;
        }
        if (i == -1 || (i & 8) == 8) {
            this.skipCollapsed = savedState.skipCollapsed;
        }
    }

    boolean shouldHide(View view, float f) {
        if (this.skipCollapsed) {
            return true;
        }
        if (isHideableWhenDragging() && view.getTop() >= this.collapsedOffset) {
            return Math.abs((((float) view.getTop()) + (f * this.hideFriction)) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) > 0.5f;
        }
        return false;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void startBackProgress(BackEventCompat backEventCompat) {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.bottomContainerBackHelper;
        if (materialBottomContainerBackHelper == null) {
            return;
        }
        materialBottomContainerBackHelper.startBackProgress(backEventCompat);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void updateBackProgress(BackEventCompat backEventCompat) {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.bottomContainerBackHelper;
        if (materialBottomContainerBackHelper == null) {
            return;
        }
        materialBottomContainerBackHelper.updateBackProgress(backEventCompat);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void handleBackInvoked() {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.bottomContainerBackHelper;
        if (materialBottomContainerBackHelper == null) {
            return;
        }
        BackEventCompat backEventCompatOnHandleBackInvoked = materialBottomContainerBackHelper.onHandleBackInvoked();
        if (backEventCompatOnHandleBackInvoked == null || Build.VERSION.SDK_INT < 34) {
            setState(this.hideable ? 5 : 4);
        } else if (this.hideable) {
            this.bottomContainerBackHelper.finishBackProgressNotPersistent(backEventCompatOnHandleBackInvoked, new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BottomSheetBehavior.this.setStateInternal(5);
                    WeakReference weakReference = BottomSheetBehavior.this.viewRef;
                    if (weakReference == null || weakReference.get() == null) {
                        return;
                    }
                    ((View) BottomSheetBehavior.this.viewRef.get()).requestLayout();
                }
            });
        } else {
            this.bottomContainerBackHelper.finishBackProgressPersistent(backEventCompatOnHandleBackInvoked, null);
            setState(4);
        }
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void cancelBackProgress() {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.bottomContainerBackHelper;
        if (materialBottomContainerBackHelper == null) {
            return;
        }
        materialBottomContainerBackHelper.cancelBackProgress();
    }

    View findScrollingChild(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View viewFindScrollingChild = findScrollingChild(viewGroup.getChildAt(i));
                if (viewFindScrollingChild != null) {
                    return viewFindScrollingChild;
                }
            }
        }
        return null;
    }

    void populateScrollingChildren(View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view.isNestedScrollingEnabled()) {
            this.nestedScrollingChildrenRef.add(new WeakReference(view));
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                populateScrollingChildren(viewGroup.getChildAt(i));
            }
        }
    }

    private boolean shouldHandleDraggingWithHelper() {
        if (this.viewDragHelper != null) {
            return this.draggable || this.state == 1;
        }
        return false;
    }

    private void createMaterialShapeDrawableIfNeeded(Context context) {
        if (this.shapeAppearanceModelDefault == null) {
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
        this.materialShapeDrawable = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(context);
        ColorStateList colorStateList = this.backgroundTint;
        if (colorStateList != null) {
            this.materialShapeDrawable.setFillColor(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.materialShapeDrawable.setTint(typedValue.data);
    }

    MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    private void createShapeValueAnimator() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(calculateInterpolationWithCornersRemoved(), 1.0f);
        this.interpolatorAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.materialShapeDrawable != null) {
                    BottomSheetBehavior.this.materialShapeDrawable.setInterpolation(fFloatValue);
                }
            }
        });
    }

    private void setWindowInsetsListener(View view) {
        final boolean z = (Build.VERSION.SDK_INT < 29 || isGestureInsetBottomIgnored() || this.peekHeightAuto) ? false : true;
        if (this.paddingBottomSystemWindowInsets || this.paddingLeftSystemWindowInsets || this.paddingRightSystemWindowInsets || this.marginLeftSystemWindowInsets || this.marginRightSystemWindowInsets || this.marginTopSystemWindowInsets || z) {
            ViewUtils.doOnApplyWindowInsets(view, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4
                /* JADX WARN: Code duplicated, block: B:22:0x0080  */
                /* JADX WARN: Code duplicated, block: B:33:0x00a3  */
                @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
                public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
                    boolean z2;
                    Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                    Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.mandatorySystemGestures());
                    BottomSheetBehavior.this.insetTop = insets.top;
                    boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(view2);
                    int paddingBottom = view2.getPaddingBottom();
                    int paddingLeft = view2.getPaddingLeft();
                    int paddingRight = view2.getPaddingRight();
                    if (BottomSheetBehavior.this.paddingBottomSystemWindowInsets) {
                        BottomSheetBehavior.this.insetBottom = windowInsetsCompat.getSystemWindowInsetBottom();
                        paddingBottom = relativePadding.bottom + BottomSheetBehavior.this.insetBottom;
                    }
                    if (BottomSheetBehavior.this.paddingLeftSystemWindowInsets) {
                        paddingLeft = (zIsLayoutRtl ? relativePadding.end : relativePadding.start) + insets.left;
                    }
                    if (BottomSheetBehavior.this.paddingRightSystemWindowInsets) {
                        paddingRight = (zIsLayoutRtl ? relativePadding.start : relativePadding.end) + insets.right;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                    boolean z3 = true;
                    if (BottomSheetBehavior.this.marginLeftSystemWindowInsets) {
                        int i = marginLayoutParams.leftMargin;
                        int i2 = insets.left;
                        if (i != i2) {
                            marginLayoutParams.leftMargin = i2;
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    if (BottomSheetBehavior.this.marginRightSystemWindowInsets) {
                        int i3 = marginLayoutParams.rightMargin;
                        int i4 = insets.right;
                        if (i3 != i4) {
                            marginLayoutParams.rightMargin = i4;
                            z2 = true;
                        }
                    }
                    if (BottomSheetBehavior.this.marginTopSystemWindowInsets) {
                        int i5 = marginLayoutParams.topMargin;
                        int i6 = insets.top;
                        if (i5 != i6) {
                            marginLayoutParams.topMargin = i6;
                        } else {
                            z3 = z2;
                        }
                    } else {
                        z3 = z2;
                    }
                    if (z3) {
                        view2.setLayoutParams(marginLayoutParams);
                    }
                    view2.setPadding(paddingLeft, view2.getPaddingTop(), paddingRight, paddingBottom);
                    if (z) {
                        BottomSheetBehavior.this.gestureInsetBottom = insets2.bottom;
                    }
                    if (!BottomSheetBehavior.this.paddingBottomSystemWindowInsets && !z) {
                        return windowInsetsCompat;
                    }
                    BottomSheetBehavior.this.updatePeekHeight(false);
                    return windowInsetsCompat;
                }
            });
        }
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSettling(View view, int i, boolean z) {
        int topOffsetForState = getTopOffsetForState(i);
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper != null && (!z ? viewDragHelper.smoothSlideViewTo(view, view.getLeft(), topOffsetForState) : viewDragHelper.settleCapturedViewAt(view.getLeft(), topOffsetForState))) {
            setStateInternal(2);
            updateDrawableForTargetState(i, true);
            this.stateSettlingTracker.continueSettlingToState(i);
            return;
        }
        setStateInternal(i);
    }

    private int getTopOffsetForState(int i) {
        if (i == 3) {
            return getExpandedOffset();
        }
        if (i == 4) {
            return this.collapsedOffset;
        }
        if (i == 5) {
            return this.parentHeight;
        }
        if (i == 6) {
            return this.halfExpandedOffset;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i);
    }

    void dispatchOnSlide(int i) {
        View view = (View) this.viewRef.get();
        if (view == null || this.callbacks.isEmpty()) {
            return;
        }
        float fCalculateSlideOffsetWithTop = calculateSlideOffsetWithTop(i);
        for (int i2 = 0; i2 < this.callbacks.size(); i2++) {
            ((BottomSheetCallback) this.callbacks.get(i2)).onSlide(view, fCalculateSlideOffsetWithTop);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canBeHiddenByDragging() {
        return isHideable() && isHideableWhenDragging();
    }

    private class StateSettlingTracker {
        private final Runnable continueSettlingRunnable;
        private boolean isContinueSettlingRunnablePosted;
        private int targetState;

        private StateSettlingTracker() {
            this.continueSettlingRunnable = new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.StateSettlingTracker.1
                @Override // java.lang.Runnable
                public void run() {
                    StateSettlingTracker.this.isContinueSettlingRunnablePosted = false;
                    ViewDragHelper viewDragHelper = BottomSheetBehavior.this.viewDragHelper;
                    if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                        StateSettlingTracker stateSettlingTracker = StateSettlingTracker.this;
                        stateSettlingTracker.continueSettlingToState(stateSettlingTracker.targetState);
                        return;
                    }
                    StateSettlingTracker stateSettlingTracker2 = StateSettlingTracker.this;
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    if (bottomSheetBehavior.state == 2) {
                        bottomSheetBehavior.setStateInternal(stateSettlingTracker2.targetState);
                    }
                }
            };
        }

        void continueSettlingToState(int i) {
            WeakReference weakReference = BottomSheetBehavior.this.viewRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.targetState = i;
            if (this.isContinueSettlingRunnablePosted) {
                return;
            }
            ((View) BottomSheetBehavior.this.viewRef.get()).postOnAnimation(this.continueSettlingRunnable);
            this.isContinueSettlingRunnablePosted = true;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = bottomSheetBehavior.peekHeight;
            this.fitToContents = bottomSheetBehavior.fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = bottomSheetBehavior.skipCollapsed;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }
    }

    public static BottomSheetBehavior from(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (!(behavior instanceof BottomSheetBehavior)) {
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        return (BottomSheetBehavior) behavior;
    }

    private void updateImportantForAccessibility(boolean z) {
        Map map;
        WeakReference weakReference = this.viewRef;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.importantForAccessibilityMap != null) {
                    return;
                } else {
                    this.importantForAccessibilityMap = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.viewRef.get()) {
                    if (z) {
                        this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.updateImportantForAccessibilityOnSiblings) {
                            childAt.setImportantForAccessibility(4);
                        }
                    } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                        childAt.setImportantForAccessibility(((Integer) this.importantForAccessibilityMap.get(childAt)).intValue());
                    }
                }
            }
            if (!z) {
                this.importantForAccessibilityMap = null;
            } else if (this.updateImportantForAccessibilityOnSiblings) {
                ((View) this.viewRef.get()).sendAccessibilityEvent(8);
            }
        }
    }

    private void updateAccessibilityActions() {
        WeakReference weakReference = this.viewRef;
        if (weakReference != null) {
            updateAccessibilityActions((View) weakReference.get(), 0);
        }
        WeakReference weakReference2 = this.accessibilityDelegateViewRef;
        if (weakReference2 != null) {
            updateAccessibilityActions((View) weakReference2.get(), 1);
        }
    }

    private void updateAccessibilityActions(View view, int i) {
        if (view == null) {
            return;
        }
        clearAccessibilityAction(view, i);
        if (!this.fitToContents && this.state != 6) {
            this.expandHalfwayActionIds.put(i, addAccessibilityActionForState(view, R$string.bottomsheet_action_expand_halfway, 6));
        }
        if (this.hideable && isHideableWhenDragging() && this.state != 5) {
            replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i2 = this.state;
        if (i2 == 3) {
            this.collapseActionIds.put(i, addAccessibilityActionForState(view, R$string.bottomsheet_action_collapse, 4));
            return;
        }
        if (i2 == 4) {
            this.expandActionIds.put(i, addAccessibilityActionForState(view, R$string.bottomsheet_action_expand, 3));
        } else {
            if (i2 != 6) {
                return;
            }
            this.collapseActionIds.put(i, addAccessibilityActionForState(view, R$string.bottomsheet_action_collapse, 4));
            this.expandActionIds.put(i, addAccessibilityActionForState(view, R$string.bottomsheet_action_expand, 3));
        }
    }

    private void clearAccessibilityAction(View view, int i) {
        if (view == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(view, 1048576);
        ViewCompat.removeAccessibilityAction(view, 524288);
        ViewCompat.removeAccessibilityAction(view, 262144);
        int i2 = this.expandActionIds.get(i, -1);
        if (i2 != -1) {
            ViewCompat.removeAccessibilityAction(view, i2);
            this.expandActionIds.delete(i);
        }
        int i3 = this.expandHalfwayActionIds.get(i, -1);
        if (i3 != -1) {
            ViewCompat.removeAccessibilityAction(view, i3);
            this.expandHalfwayActionIds.delete(i);
        }
        int i4 = this.collapseActionIds.get(i, -1);
        if (i4 != -1) {
            ViewCompat.removeAccessibilityAction(view, i4);
            this.collapseActionIds.delete(i);
        }
    }

    private void replaceAccessibilityActionForState(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i) {
        ViewCompat.replaceAccessibilityAction(view, accessibilityActionCompat, null, createAccessibilityViewCommandForState(i));
    }

    private int addAccessibilityActionForState(View view, int i, int i2) {
        return ViewCompat.addAccessibilityAction(view, view.getResources().getString(i), createAccessibilityViewCommandForState(i2));
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(final int i) {
        return new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.6
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                BottomSheetBehavior.this.setState(i);
                return true;
            }
        };
    }
}
