package com.facebook.react.views.scroll;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.views.view.ReactViewGroup;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class MaintainVisibleScrollPositionHelper implements UIManagerListener {
    private Config config;
    private WeakReference firstVisibleViewRef;
    private final boolean horizontal;
    private boolean isListening;
    private Rect prevFirstVisibleFrame;
    private final ViewGroup scrollView;

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didDispatchMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didScheduleMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
    }

    public MaintainVisibleScrollPositionHelper(ViewGroup viewGroup, boolean z) {
        this.scrollView = viewGroup;
        this.horizontal = z;
    }

    public final void setConfig(Config config) {
        this.config = config;
    }

    private final ReactViewGroup getContentView() {
        ViewGroup viewGroup = this.scrollView;
        return (ReactViewGroup) (viewGroup != null ? viewGroup.getChildAt(0) : null);
    }

    private final UIManager getUIManager() {
        ViewGroup viewGroup = this.scrollView;
        ReactContext reactContext = (ReactContext) (viewGroup != null ? viewGroup.getContext() : null);
        if (reactContext == null) {
            throw new IllegalStateException("Required value was null.");
        }
        ViewGroup viewGroup2 = this.scrollView;
        UIManager uIManager = UIManagerHelper.getUIManager(reactContext, ViewUtil.getUIManagerType(viewGroup2 != null ? viewGroup2.getId() : 0));
        if (uIManager != null) {
            return uIManager;
        }
        throw new IllegalStateException("Required value was null.");
    }

    public static final class Config {
        public static final Companion Companion = new Companion(null);
        private final Integer autoScrollToTopThreshold;
        private final int minIndexForVisible;

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Config fromReadableMap(ReadableMap value) {
                Intrinsics.checkNotNullParameter(value, "value");
                return new Config(value.getInt("minIndexForVisible"), value.hasKey("autoscrollToTopThreshold") ? Integer.valueOf(value.getInt("autoscrollToTopThreshold")) : null);
            }
        }

        public Config(int i, Integer num) {
            this.minIndexForVisible = i;
            this.autoScrollToTopThreshold = num;
        }

        public final Integer getAutoScrollToTopThreshold() {
            return this.autoScrollToTopThreshold;
        }

        public final int getMinIndexForVisible() {
            return this.minIndexForVisible;
        }
    }

    public final void start() {
        if (this.isListening) {
            return;
        }
        this.isListening = true;
        getUIManager().addUIManagerEventListener(this);
    }

    public final void stop() {
        if (this.isListening) {
            this.isListening = false;
            getUIManager().removeUIManagerEventListener(this);
        }
    }

    public final void updateScrollPosition() {
        ViewGroup viewGroup = this.scrollView;
        if (viewGroup == null || ViewUtil.getUIManagerType(viewGroup.getId()) == 2) {
            return;
        }
        updateScrollPositionInternal();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateScrollPositionInternal() {
        WeakReference weakReference;
        Rect rect;
        View view;
        ViewGroup viewGroup;
        Config config = this.config;
        if (config == null || (weakReference = this.firstVisibleViewRef) == null || (rect = this.prevFirstVisibleFrame) == null || (view = (View) weakReference.get()) == null || (viewGroup = this.scrollView) == 0) {
            return;
        }
        Rect rect2 = new Rect();
        view.getHitRect(rect2);
        if (this.horizontal) {
            int i = rect2.left - rect.left;
            if (i != 0) {
                int scrollX = viewGroup.getScrollX();
                ReactScrollViewHelper.HasSmoothScroll hasSmoothScroll = (ReactScrollViewHelper.HasSmoothScroll) viewGroup;
                hasSmoothScroll.scrollToPreservingMomentum(i + scrollX, viewGroup.getScrollY());
                this.prevFirstVisibleFrame = rect2;
                if (config.getAutoScrollToTopThreshold() == null || scrollX > config.getAutoScrollToTopThreshold().intValue()) {
                    return;
                }
                hasSmoothScroll.reactSmoothScrollTo(0, viewGroup.getScrollY());
                return;
            }
            return;
        }
        int i2 = rect2.top - rect.top;
        if (i2 != 0) {
            int scrollY = viewGroup.getScrollY();
            ReactScrollViewHelper.HasSmoothScroll hasSmoothScroll2 = (ReactScrollViewHelper.HasSmoothScroll) viewGroup;
            hasSmoothScroll2.scrollToPreservingMomentum(viewGroup.getScrollX(), i2 + scrollY);
            this.prevFirstVisibleFrame = rect2;
            if (config.getAutoScrollToTopThreshold() == null || scrollY > config.getAutoScrollToTopThreshold().intValue()) {
                return;
            }
            hasSmoothScroll2.reactSmoothScrollTo(viewGroup.getScrollX(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void computeTargetView() {
        ViewGroup viewGroup;
        ReactViewGroup contentView;
        float y;
        int height;
        Config config = this.config;
        if (config == null || (viewGroup = this.scrollView) == null || (contentView = getContentView()) == null) {
            return;
        }
        int scrollX = this.horizontal ? viewGroup.getScrollX() : viewGroup.getScrollY();
        int childCount = contentView.getChildCount();
        for (int minIndexForVisible = config.getMinIndexForVisible(); minIndexForVisible < childCount; minIndexForVisible++) {
            View childAt = contentView.getChildAt(minIndexForVisible);
            if (this.horizontal) {
                y = childAt.getX();
                height = childAt.getWidth();
            } else {
                y = childAt.getY();
                height = childAt.getHeight();
            }
            if (y + height > scrollX || minIndexForVisible == contentView.getChildCount() - 1) {
                this.firstVisibleViewRef = new WeakReference(childAt);
                Rect rect = new Rect();
                childAt.getHitRect(rect);
                this.prevFirstVisibleFrame = rect;
                return;
            }
        }
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willDispatchViewUpdates(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.views.scroll.MaintainVisibleScrollPositionHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.computeTargetView();
            }
        });
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void willMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        computeTargetView();
    }

    @Override // com.facebook.react.bridge.UIManagerListener
    public void didMountItems(UIManager uiManager) {
        Intrinsics.checkNotNullParameter(uiManager, "uiManager");
        updateScrollPositionInternal();
    }
}
