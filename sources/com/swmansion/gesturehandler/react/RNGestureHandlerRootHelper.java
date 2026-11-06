package com.swmansion.gesturehandler.react;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.ThemedReactContext;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerOrchestrator;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class RNGestureHandlerRootHelper {
    public static final Companion Companion = new Companion(null);
    private final ReactContext context;
    private final GestureHandler jsGestureHandler;
    private final GestureHandlerOrchestrator orchestrator;
    private boolean passingTouch;
    private final ViewGroup rootView;
    private boolean shouldIntercept;

    public RNGestureHandlerRootHelper(ReactContext context, ViewGroup wrappedView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(wrappedView, "wrappedView");
        this.context = context;
        UiThreadUtil.assertOnUiThread();
        int id = wrappedView.getId();
        NativeModule nativeModule = context.getNativeModule((Class<NativeModule>) RNGestureHandlerModule.class);
        Intrinsics.checkNotNull(nativeModule);
        RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) nativeModule;
        RNGestureHandlerRegistry registry = rNGestureHandlerModule.getRegistry();
        ViewGroup viewGroupFindRootViewTag = Companion.findRootViewTag(wrappedView);
        this.rootView = viewGroupFindRootViewTag;
        Objects.toString(viewGroupFindRootViewTag);
        GestureHandlerOrchestrator gestureHandlerOrchestrator = new GestureHandlerOrchestrator(wrappedView, registry, new RNViewConfigurationHelper(), viewGroupFindRootViewTag);
        gestureHandlerOrchestrator.setMinimumAlphaForTraversal(0.1f);
        this.orchestrator = gestureHandlerOrchestrator;
        RootViewGestureHandler rootViewGestureHandler = new RootViewGestureHandler(-id);
        this.jsGestureHandler = rootViewGestureHandler;
        registry.registerHandler(rootViewGestureHandler);
        registry.attachHandlerToView(rootViewGestureHandler.getTag(), id, 3);
        rNGestureHandlerModule.registerRootHelper(this);
    }

    public final ViewGroup getRootView() {
        return this.rootView;
    }

    public final void tearDown() {
        Objects.toString(this.rootView);
        ReactContext reactContext = this.context;
        Intrinsics.checkNotNull(reactContext, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        NativeModule nativeModule = ((ThemedReactContext) reactContext).getReactApplicationContext().getNativeModule((Class<NativeModule>) RNGestureHandlerModule.class);
        Intrinsics.checkNotNull(nativeModule);
        RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) nativeModule;
        RNGestureHandlerRegistry registry = rNGestureHandlerModule.getRegistry();
        GestureHandler gestureHandler = this.jsGestureHandler;
        Intrinsics.checkNotNull(gestureHandler);
        registry.dropHandler(gestureHandler.getTag());
        rNGestureHandlerModule.unregisterRootHelper(this);
    }

    public final class RootViewGestureHandler extends GestureHandler {
        public RootViewGestureHandler(int i) {
            setTag(i);
        }

        private final void handleEvent(MotionEvent motionEvent) {
            GestureHandlerOrchestrator orchestrator;
            if (getState() == 0 && (!RNGestureHandlerRootHelper.this.shouldIntercept || (orchestrator = getOrchestrator()) == null || !orchestrator.isAnyHandlerActive())) {
                begin();
                RNGestureHandlerRootHelper.this.shouldIntercept = false;
            }
            if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 10) {
                end();
            }
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler
        protected void onHandle(MotionEvent event, MotionEvent sourceEvent) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
            handleEvent(event);
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler
        protected void onHandleHover(MotionEvent event, MotionEvent sourceEvent) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
            handleEvent(event);
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler
        protected void onCancel() {
            RNGestureHandlerRootHelper.this.shouldIntercept = true;
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            motionEventObtain.setAction(3);
            if (RNGestureHandlerRootHelper.this.getRootView() instanceof RootView) {
                RootView rootView = (RootView) RNGestureHandlerRootHelper.this.getRootView();
                ViewGroup rootView2 = RNGestureHandlerRootHelper.this.getRootView();
                Intrinsics.checkNotNull(motionEventObtain);
                rootView.onChildStartedNativeGesture(rootView2, motionEventObtain);
            }
            motionEventObtain.recycle();
        }
    }

    public final void requestDisallowInterceptTouchEvent() {
        if (this.orchestrator == null || this.passingTouch) {
            return;
        }
        tryCancelAllHandlers();
    }

    public final boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.passingTouch = true;
        GestureHandlerOrchestrator gestureHandlerOrchestrator = this.orchestrator;
        Intrinsics.checkNotNull(gestureHandlerOrchestrator);
        gestureHandlerOrchestrator.onTouchEvent(event);
        this.passingTouch = false;
        return this.shouldIntercept;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryCancelAllHandlers() {
        GestureHandler gestureHandler = this.jsGestureHandler;
        if (gestureHandler == null || gestureHandler.getState() != 2) {
            return;
        }
        gestureHandler.activate();
        gestureHandler.end();
    }

    public final void handleSetJSResponder(int i, boolean z) {
        if (z) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.tryCancelAllHandlers();
                }
            });
        }
    }

    public final void activateNativeHandlers(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        GestureHandlerOrchestrator gestureHandlerOrchestrator = this.orchestrator;
        if (gestureHandlerOrchestrator != null) {
            gestureHandlerOrchestrator.activateNativeHandlersForView(view);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ViewGroup findRootViewTag(ViewGroup viewGroup) {
            UiThreadUtil.assertOnUiThread();
            ViewParent parent = viewGroup;
            while (parent != null && !(parent instanceof RootView)) {
                parent = parent.getParent();
            }
            if (parent == null) {
                throw new IllegalStateException(("View " + viewGroup + " has not been mounted under ReactRootView").toString());
            }
            return (ViewGroup) parent;
        }
    }
}
