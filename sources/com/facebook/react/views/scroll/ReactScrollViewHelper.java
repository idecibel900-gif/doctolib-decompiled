package com.facebook.react.views.scroll;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import com.facebook.common.logging.FLog;
import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactScrollViewHelper {
    private static final boolean DEBUG_MODE = false;
    private static boolean smoothScrollDurationInitialized;
    public static final ReactScrollViewHelper INSTANCE = new ReactScrollViewHelper();
    private static final String TAG = ReactScrollView.class.getSimpleName();
    private static final CopyOnWriteArrayList scrollListeners = new CopyOnWriteArrayList();
    private static final CopyOnWriteArrayList layoutChangeListeners = new CopyOnWriteArrayList();
    private static int SMOOTH_SCROLL_DURATION = 250;

    public interface HasFlingAnimator {
        ValueAnimator getFlingAnimator();

        void startFlingAnimator(int i, int i2);
    }

    public interface HasScrollEventThrottle {
        long getLastScrollDispatchTime();

        int getScrollEventThrottle();

        void setLastScrollDispatchTime(long j);
    }

    public interface HasScrollState {
        ReactScrollViewScrollState getReactScrollViewScrollState();

        void setReactScrollViewScrollState(ReactScrollViewScrollState reactScrollViewScrollState);
    }

    public interface HasSmoothScroll {
        void reactSmoothScrollTo(int i, int i2);

        void scrollToPreservingMomentum(int i, int i2);
    }

    public interface HasStateWrapper {
        StateWrapper getStateWrapper();
    }

    public interface LayoutChangeListener {
        void onLayoutChange(ViewGroup viewGroup);
    }

    public interface ScrollListener {
        void onLayout(ViewGroup viewGroup);

        void onScroll(ViewGroup viewGroup, ScrollEventType scrollEventType, float f, float f2);
    }

    private ReactScrollViewHelper() {
    }

    public static final void emitScrollEvent(ViewGroup viewGroup, float f, float f2) {
        INSTANCE.emitScrollEvent(viewGroup, ScrollEventType.SCROLL, f, f2);
    }

    public static final void emitScrollBeginDragEvent(ViewGroup viewGroup) {
        INSTANCE.emitScrollEvent(viewGroup, ScrollEventType.BEGIN_DRAG);
    }

    public static final void emitScrollEndDragEvent(ViewGroup viewGroup, float f, float f2) {
        INSTANCE.emitScrollEvent(viewGroup, ScrollEventType.END_DRAG, f, f2);
    }

    public static final void emitScrollMomentumBeginEvent(ViewGroup viewGroup, int i, int i2) {
        INSTANCE.emitScrollEvent(viewGroup, ScrollEventType.MOMENTUM_BEGIN, i, i2);
    }

    public static final void emitScrollMomentumEndEvent(ViewGroup viewGroup) {
        INSTANCE.emitScrollEvent(viewGroup, ScrollEventType.MOMENTUM_END);
    }

    private final void emitScrollEvent(ViewGroup viewGroup, ScrollEventType scrollEventType) {
        emitScrollEvent(viewGroup, scrollEventType, 0.0f, 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void emitScrollEvent(ViewGroup viewGroup, ScrollEventType scrollEventType, float f, float f2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (scrollEventType == ScrollEventType.SCROLL) {
            HasScrollEventThrottle hasScrollEventThrottle = (HasScrollEventThrottle) viewGroup;
            if (hasScrollEventThrottle.getScrollEventThrottle() >= Math.max(17L, jCurrentTimeMillis - hasScrollEventThrottle.getLastScrollDispatchTime())) {
                return;
            }
        }
        View childAt = viewGroup.getChildAt(0);
        if (childAt == null) {
            return;
        }
        Iterator it = CollectionsKt.toList(scrollListeners).iterator();
        while (it.hasNext()) {
            ScrollListener scrollListener = (ScrollListener) ((WeakReference) it.next()).get();
            if (scrollListener != null) {
                scrollListener.onScroll(viewGroup, scrollEventType, f, f2);
            }
        }
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        int surfaceId = UIManagerHelper.getSurfaceId(reactContext);
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, viewGroup.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(ScrollEvent.Companion.obtain(surfaceId, viewGroup.getId(), scrollEventType, viewGroup.getScrollX(), viewGroup.getScrollY(), f, f2, childAt.getWidth(), childAt.getHeight(), viewGroup.getWidth(), viewGroup.getHeight()));
            if (scrollEventType == ScrollEventType.SCROLL) {
                ((HasScrollEventThrottle) viewGroup).setLastScrollDispatchTime(jCurrentTimeMillis);
            }
        }
    }

    public static final void notifyUserDrivenScrollEnded_internal(ViewGroup scrollView) {
        NativeAnimatedModule nativeAnimatedModule;
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Context context = scrollView.getContext();
        ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
        if (reactContext == null || (nativeAnimatedModule = (NativeAnimatedModule) reactContext.getNativeModule(NativeAnimatedModule.class)) == null) {
            return;
        }
        nativeAnimatedModule.userDrivenScrollEnded(scrollView.getId());
    }

    public static final void emitLayoutEvent(ViewGroup scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Iterator it = scrollListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            ScrollListener scrollListener = (ScrollListener) ((WeakReference) it.next()).get();
            if (scrollListener != null) {
                scrollListener.onLayout(scrollView);
            }
        }
    }

    public static final void emitLayoutChangeEvent(ViewGroup scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Iterator it = layoutChangeListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            LayoutChangeListener layoutChangeListener = (LayoutChangeListener) ((WeakReference) it.next()).get();
            if (layoutChangeListener != null) {
                layoutChangeListener.onLayoutChange(scrollView);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
    
        if (r3.equals("auto") != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int parseOverScrollMode(java.lang.String r3) {
        /*
            r0 = 1
            if (r3 == 0) goto L4c
            int r1 = r3.hashCode()
            r2 = -1414557169(0xffffffffabaf920f, float:-1.2475037E-12)
            if (r1 == r2) goto L2b
            r2 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r1 == r2) goto L22
            r2 = 104712844(0x63dca8c, float:3.5695757E-35)
            if (r1 == r2) goto L17
            goto L33
        L17:
            java.lang.String r1 = "never"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L20
            goto L33
        L20:
            r3 = 2
            return r3
        L22:
            java.lang.String r1 = "auto"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L33
            goto L4c
        L2b:
            java.lang.String r1 = "always"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L4a
        L33:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "wrong overScrollMode: "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            java.lang.String r1 = "ReactNative"
            com.facebook.common.logging.FLog.w(r1, r3)
            return r0
        L4a:
            r3 = 0
            return r3
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.ReactScrollViewHelper.parseOverScrollMode(java.lang.String):int");
    }

    public static final int parseSnapToAlignment(String str) {
        if (str == null) {
            return 0;
        }
        if (StringsKt.equals("start", str, true)) {
            return 1;
        }
        if (StringsKt.equals("center", str, true)) {
            return 2;
        }
        if (Intrinsics.areEqual("end", str)) {
            return 3;
        }
        FLog.w("ReactNative", "wrong snap alignment value: " + str);
        return 0;
    }

    public static final int getDefaultScrollAnimationDuration(Context context) {
        if (!smoothScrollDurationInitialized) {
            smoothScrollDurationInitialized = true;
            try {
                SMOOTH_SCROLL_DURATION = new OverScrollerDurationGetter(context).getScrollAnimationDuration();
            } catch (Throwable unused) {
            }
        }
        return SMOOTH_SCROLL_DURATION;
    }

    public static final void addScrollListener(ScrollListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        scrollListeners.add(new WeakReference(listener));
    }

    public static final void removeScrollListener(ScrollListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList arrayList = new ArrayList();
        Iterator it = scrollListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            ScrollListener scrollListener = (ScrollListener) weakReference.get();
            if (scrollListener == null || Intrinsics.areEqual(scrollListener, listener)) {
                arrayList.add(weakReference);
            }
        }
        scrollListeners.removeAll(arrayList);
    }

    public static final void addLayoutChangeListener(LayoutChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        layoutChangeListeners.add(new WeakReference(listener));
    }

    public static final void removeLayoutChangeListener(LayoutChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList arrayList = new ArrayList();
        Iterator it = layoutChangeListeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            LayoutChangeListener layoutChangeListener = (LayoutChangeListener) weakReference.get();
            if (layoutChangeListener == null || Intrinsics.areEqual(layoutChangeListener, listener)) {
                arrayList.add(weakReference);
            }
        }
        layoutChangeListeners.removeAll(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void smoothScrollTo(ViewGroup viewGroup, int i, int i2) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "smoothScrollTo[%d] x %d y %d", Integer.valueOf(viewGroup.getId()), Integer.valueOf(i), Integer.valueOf(i2));
        }
        HasFlingAnimator hasFlingAnimator = (HasFlingAnimator) viewGroup;
        ValueAnimator flingAnimator = hasFlingAnimator.getFlingAnimator();
        if (flingAnimator.getListeners() == null || flingAnimator.getListeners().size() == 0) {
            INSTANCE.registerFlingAnimator(viewGroup);
        }
        ((HasScrollState) viewGroup).getReactScrollViewScrollState().setFinalAnimatedPositionScroll(i, i2);
        int scrollX = viewGroup.getScrollX();
        int scrollY = viewGroup.getScrollY();
        if (scrollX != i) {
            hasFlingAnimator.startFlingAnimator(scrollX, i);
        }
        if (scrollY != i2) {
            hasFlingAnimator.startFlingAnimator(scrollY, i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final int getNextFlingStartValue(ViewGroup viewGroup, int i, int i2, int i3) {
        ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) viewGroup).getReactScrollViewScrollState();
        return (!reactScrollViewScrollState.isFinished() || (reactScrollViewScrollState.isCanceled() && ((i3 != 0 ? i3 / Math.abs(i3) : 0) * (i2 - i) > 0))) ? i2 : i;
    }

    public static final void updateFabricScrollState(ViewGroup viewGroup) {
        INSTANCE.updateFabricScrollState(viewGroup, viewGroup.getScrollX(), viewGroup.getScrollY());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateFabricScrollState(ViewGroup viewGroup, int i, int i2) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "updateFabricScrollState[%d] scrollX %d scrollY %d", Integer.valueOf(viewGroup.getId()), Integer.valueOf(i), Integer.valueOf(i2));
        }
        if (ViewUtil.getUIManagerType(viewGroup.getId()) == 1 || ((HasStateWrapper) viewGroup).getStateWrapper() == null) {
            return;
        }
        ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) viewGroup).getReactScrollViewScrollState();
        reactScrollViewScrollState.setUpdatedByScroll(true);
        if (reactScrollViewScrollState.getLastStateUpdateScroll().equals(i, i2)) {
            return;
        }
        reactScrollViewScrollState.setLastStateUpdateScroll(i, i2);
        forceUpdateState(viewGroup);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void forceUpdateState(ViewGroup viewGroup) {
        ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) viewGroup).getReactScrollViewScrollState();
        int scrollAwayPaddingTop = reactScrollViewScrollState.getScrollAwayPaddingTop();
        Point lastStateUpdateScroll = reactScrollViewScrollState.getLastStateUpdateScroll();
        int i = lastStateUpdateScroll.x;
        int i2 = lastStateUpdateScroll.y;
        if (DEBUG_MODE) {
            FLog.i(TAG, "updateFabricScrollState[%d] scrollX %d scrollY %d", Integer.valueOf(viewGroup.getId()), Integer.valueOf(i), Integer.valueOf(i2));
        }
        StateWrapper stateWrapper = ((HasStateWrapper) viewGroup).getStateWrapper();
        if (stateWrapper != null) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("contentOffsetLeft", PixelUtil.toDIPFromPixel(i));
            writableNativeMap.putDouble("contentOffsetTop", PixelUtil.toDIPFromPixel(i2));
            writableNativeMap.putDouble("scrollAwayPaddingTop", PixelUtil.toDIPFromPixel(scrollAwayPaddingTop));
            stateWrapper.updateState(writableNativeMap);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void loadFabricScrollState$ReactAndroid_release(ViewGroup viewGroup, StateWrapper stateWrapper) {
        ReadableNativeMap stateData;
        Intrinsics.checkNotNullParameter(stateWrapper, "stateWrapper");
        HasScrollState hasScrollState = (HasScrollState) viewGroup;
        if (hasScrollState.getReactScrollViewScrollState().isUpdatedByScroll() || (stateData = stateWrapper.getStateData()) == null) {
            return;
        }
        int pixelFromDIP = (int) PixelUtil.toPixelFromDIP(stateData.getDouble("contentOffsetLeft"));
        int pixelFromDIP2 = (int) PixelUtil.toPixelFromDIP(stateData.getDouble("contentOffsetTop"));
        ReactScrollViewScrollState reactScrollViewScrollStateCopy$default = ReactScrollViewScrollState.copy$default(hasScrollState.getReactScrollViewScrollState(), null, (int) PixelUtil.toPixelFromDIP(stateData.getDouble("scrollAwayPaddingTop")), null, false, false, 0.0f, false, 125, null);
        reactScrollViewScrollStateCopy$default.setLastStateUpdateScroll(pixelFromDIP, pixelFromDIP2);
        hasScrollState.setReactScrollViewScrollState(reactScrollViewScrollStateCopy$default);
    }

    public static final void updateStateOnScrollChanged(ViewGroup viewGroup, float f, float f2) {
        INSTANCE.updateFabricScrollState(viewGroup, viewGroup.getScrollX(), viewGroup.getScrollY());
        emitScrollEvent(viewGroup, f, f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void registerFlingAnimator(final ViewGroup viewGroup) {
        ((HasFlingAnimator) viewGroup).getFlingAnimator().addListener(new Animator.AnimatorListener() { // from class: com.facebook.react.views.scroll.ReactScrollViewHelper.registerFlingAnimator.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) viewGroup).getReactScrollViewScrollState();
                reactScrollViewScrollState.setCanceled(false);
                reactScrollViewScrollState.setFinished(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ((HasScrollState) viewGroup).getReactScrollViewScrollState().setFinished(true);
                ReactScrollViewHelper.notifyUserDrivenScrollEnded_internal(viewGroup);
                ReactScrollViewHelper.updateFabricScrollState(viewGroup);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ((HasScrollState) viewGroup).getReactScrollViewScrollState().setCanceled(true);
                ReactScrollViewHelper.notifyUserDrivenScrollEnded_internal(viewGroup);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void dispatchMomentumEndOnAnimationEnd(final ViewGroup viewGroup) {
        ((HasFlingAnimator) viewGroup).getFlingAnimator().addListener(new Animator.AnimatorListener() { // from class: com.facebook.react.views.scroll.ReactScrollViewHelper.dispatchMomentumEndOnAnimationEnd.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ReactScrollViewHelper.emitScrollMomentumEndEvent(viewGroup);
                animator.removeListener(this);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                ReactScrollViewHelper.emitScrollMomentumEndEvent(viewGroup);
                animator.removeListener(this);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Point predictFinalScrollPosition(ViewGroup viewGroup, int i, int i2, int i3, int i4) {
        ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) viewGroup).getReactScrollViewScrollState();
        OverScroller overScroller = new OverScroller(viewGroup.getContext());
        overScroller.setFriction(1.0f - reactScrollViewScrollState.getDecelerationRate());
        int width = (viewGroup.getWidth() - viewGroup.getPaddingStart()) - viewGroup.getPaddingEnd();
        int height = (viewGroup.getHeight() - viewGroup.getPaddingBottom()) - viewGroup.getPaddingTop();
        Point finalAnimatedPositionScroll = reactScrollViewScrollState.getFinalAnimatedPositionScroll();
        overScroller.fling(getNextFlingStartValue(viewGroup, viewGroup.getScrollX(), finalAnimatedPositionScroll.x, i), getNextFlingStartValue(viewGroup, viewGroup.getScrollY(), finalAnimatedPositionScroll.y, i2), i, i2, 0, i3, 0, i4, width / 2, height / 2);
        return new Point(overScroller.getFinalX(), overScroller.getFinalY());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final View findNextFocusableView(ViewGroup host, View focused, int i) {
        FabricUIManager fabricUIManager;
        Integer numFindNextFocusableElement;
        int iIntValue;
        int[] relativeAncestorList;
        Set mutableSet;
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(focused, "focused");
        if (!(host instanceof ReactClippingViewGroup)) {
            return null;
        }
        Context context = host.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        UIManager uIManager = UIManagerHelper.getUIManager((ReactContext) context, 2);
        if (uIManager == null || (numFindNextFocusableElement = (fabricUIManager = (FabricUIManager) uIManager).findNextFocusableElement(host.getId(), focused.getId(), i)) == null || (relativeAncestorList = fabricUIManager.getRelativeAncestorList(host.getChildAt(0).getId(), (iIntValue = numFindNextFocusableElement.intValue()))) == null || (mutableSet = ArraysKt.toMutableSet(relativeAncestorList)) == null) {
            return null;
        }
        mutableSet.add(numFindNextFocusableElement);
        ((ReactClippingViewGroup) host).updateClippingRect(mutableSet);
        return host.findViewById(iIntValue);
    }

    private static final class OverScrollerDurationGetter extends OverScroller {
        private int currentScrollAnimationDuration;

        public OverScrollerDurationGetter(Context context) {
            super(context);
            this.currentScrollAnimationDuration = 250;
        }

        public final int getScrollAnimationDuration() {
            super.startScroll(0, 0, 0, 0);
            return this.currentScrollAnimationDuration;
        }

        @Override // android.widget.OverScroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            this.currentScrollAnimationDuration = i5;
        }
    }

    public static final class ReactScrollViewScrollState {
        private float decelerationRate;
        private final Point finalAnimatedPositionScroll;
        private boolean isCanceled;
        private boolean isFinished;
        private boolean isUpdatedByScroll;
        private final Point lastStateUpdateScroll;
        private int scrollAwayPaddingTop;

        public ReactScrollViewScrollState() {
            this(null, 0, null, false, false, 0.0f, false, 127, null);
        }

        public static /* synthetic */ ReactScrollViewScrollState copy$default(ReactScrollViewScrollState reactScrollViewScrollState, Point point, int i, Point point2, boolean z, boolean z2, float f, boolean z3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                point = reactScrollViewScrollState.finalAnimatedPositionScroll;
            }
            if ((i2 & 2) != 0) {
                i = reactScrollViewScrollState.scrollAwayPaddingTop;
            }
            if ((i2 & 4) != 0) {
                point2 = reactScrollViewScrollState.lastStateUpdateScroll;
            }
            if ((i2 & 8) != 0) {
                z = reactScrollViewScrollState.isCanceled;
            }
            if ((i2 & 16) != 0) {
                z2 = reactScrollViewScrollState.isFinished;
            }
            if ((i2 & 32) != 0) {
                f = reactScrollViewScrollState.decelerationRate;
            }
            if ((i2 & 64) != 0) {
                z3 = reactScrollViewScrollState.isUpdatedByScroll;
            }
            float f2 = f;
            boolean z4 = z3;
            boolean z5 = z2;
            Point point3 = point2;
            return reactScrollViewScrollState.copy(point, i, point3, z, z5, f2, z4);
        }

        public final ReactScrollViewScrollState copy(Point finalAnimatedPositionScroll, int i, Point lastStateUpdateScroll, boolean z, boolean z2, float f, boolean z3) {
            Intrinsics.checkNotNullParameter(finalAnimatedPositionScroll, "finalAnimatedPositionScroll");
            Intrinsics.checkNotNullParameter(lastStateUpdateScroll, "lastStateUpdateScroll");
            return new ReactScrollViewScrollState(finalAnimatedPositionScroll, i, lastStateUpdateScroll, z, z2, f, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReactScrollViewScrollState)) {
                return false;
            }
            ReactScrollViewScrollState reactScrollViewScrollState = (ReactScrollViewScrollState) obj;
            return Intrinsics.areEqual(this.finalAnimatedPositionScroll, reactScrollViewScrollState.finalAnimatedPositionScroll) && this.scrollAwayPaddingTop == reactScrollViewScrollState.scrollAwayPaddingTop && Intrinsics.areEqual(this.lastStateUpdateScroll, reactScrollViewScrollState.lastStateUpdateScroll) && this.isCanceled == reactScrollViewScrollState.isCanceled && this.isFinished == reactScrollViewScrollState.isFinished && Float.compare(this.decelerationRate, reactScrollViewScrollState.decelerationRate) == 0 && this.isUpdatedByScroll == reactScrollViewScrollState.isUpdatedByScroll;
        }

        public int hashCode() {
            return (((((((((((this.finalAnimatedPositionScroll.hashCode() * 31) + Integer.hashCode(this.scrollAwayPaddingTop)) * 31) + this.lastStateUpdateScroll.hashCode()) * 31) + Boolean.hashCode(this.isCanceled)) * 31) + Boolean.hashCode(this.isFinished)) * 31) + Float.hashCode(this.decelerationRate)) * 31) + Boolean.hashCode(this.isUpdatedByScroll);
        }

        public String toString() {
            return "ReactScrollViewScrollState(finalAnimatedPositionScroll=" + this.finalAnimatedPositionScroll + ", scrollAwayPaddingTop=" + this.scrollAwayPaddingTop + ", lastStateUpdateScroll=" + this.lastStateUpdateScroll + ", isCanceled=" + this.isCanceled + ", isFinished=" + this.isFinished + ", decelerationRate=" + this.decelerationRate + ", isUpdatedByScroll=" + this.isUpdatedByScroll + ")";
        }

        public ReactScrollViewScrollState(Point finalAnimatedPositionScroll, int i, Point lastStateUpdateScroll, boolean z, boolean z2, float f, boolean z3) {
            Intrinsics.checkNotNullParameter(finalAnimatedPositionScroll, "finalAnimatedPositionScroll");
            Intrinsics.checkNotNullParameter(lastStateUpdateScroll, "lastStateUpdateScroll");
            this.finalAnimatedPositionScroll = finalAnimatedPositionScroll;
            this.scrollAwayPaddingTop = i;
            this.lastStateUpdateScroll = lastStateUpdateScroll;
            this.isCanceled = z;
            this.isFinished = z2;
            this.decelerationRate = f;
            this.isUpdatedByScroll = z3;
        }

        public /* synthetic */ ReactScrollViewScrollState(Point point, int i, Point point2, boolean z, boolean z2, float f, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? new Point() : point, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? new Point(-1, -1) : point2, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? true : z2, (i2 & 32) != 0 ? 0.985f : f, (i2 & 64) != 0 ? false : z3);
        }

        public final Point getFinalAnimatedPositionScroll() {
            return this.finalAnimatedPositionScroll;
        }

        public final int getScrollAwayPaddingTop() {
            return this.scrollAwayPaddingTop;
        }

        public final void setScrollAwayPaddingTop(int i) {
            this.scrollAwayPaddingTop = i;
        }

        public final Point getLastStateUpdateScroll() {
            return this.lastStateUpdateScroll;
        }

        public final boolean isCanceled() {
            return this.isCanceled;
        }

        public final void setCanceled(boolean z) {
            this.isCanceled = z;
        }

        public final boolean isFinished() {
            return this.isFinished;
        }

        public final void setFinished(boolean z) {
            this.isFinished = z;
        }

        public final float getDecelerationRate() {
            return this.decelerationRate;
        }

        public final void setDecelerationRate(float f) {
            this.decelerationRate = f;
        }

        public final boolean isUpdatedByScroll() {
            return this.isUpdatedByScroll;
        }

        public final void setUpdatedByScroll(boolean z) {
            this.isUpdatedByScroll = z;
        }

        public final ReactScrollViewScrollState setFinalAnimatedPositionScroll(int i, int i2) {
            this.finalAnimatedPositionScroll.set(i, i2);
            return this;
        }

        public final ReactScrollViewScrollState setLastStateUpdateScroll(int i, int i2) {
            this.lastStateUpdateScroll.set(i, i2);
            return this;
        }
    }
}
