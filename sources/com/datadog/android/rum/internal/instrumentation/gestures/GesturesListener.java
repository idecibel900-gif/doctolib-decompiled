package com.datadog.android.rum.internal.instrumentation.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.tracking.NoOpInteractionPredicate;
import com.datadog.android.rum.tracking.ActionTrackingStrategy;
import com.datadog.android.rum.tracking.InteractionPredicate;
import com.datadog.android.rum.tracking.NoOpActionTrackingStrategy;
import com.datadog.android.rum.tracking.ViewAttributesProvider;
import com.datadog.android.rum.tracking.ViewTarget;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class GesturesListener extends GestureListenerCompat {
    public static final Companion Companion = new Companion(null);
    private final ActionTrackingStrategy androidActionTrackingStrategy;
    private final ViewAttributesProvider[] attributesProviders;
    private final ActionTrackingStrategy composeActionTrackingStrategy;
    private final Reference contextRef;
    private String gestureDirection;
    private final InteractionPredicate interactionPredicate;
    private final InternalLogger internalLogger;
    private float onTouchDownXPos;
    private float onTouchDownYPos;
    private RumActionType scrollEventType;
    private ViewTarget scrollTargetReference;
    private final SdkCore sdkCore;
    private final WeakReference windowReference;

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
    }

    public GesturesListener(SdkCore sdkCore, WeakReference windowReference, ViewAttributesProvider[] attributesProviders, InteractionPredicate interactionPredicate, Reference contextRef, InternalLogger internalLogger, ActionTrackingStrategy composeActionTrackingStrategy, ActionTrackingStrategy androidActionTrackingStrategy) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(windowReference, "windowReference");
        Intrinsics.checkNotNullParameter(attributesProviders, "attributesProviders");
        Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
        Intrinsics.checkNotNullParameter(contextRef, "contextRef");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(composeActionTrackingStrategy, "composeActionTrackingStrategy");
        Intrinsics.checkNotNullParameter(androidActionTrackingStrategy, "androidActionTrackingStrategy");
        this.sdkCore = sdkCore;
        this.windowReference = windowReference;
        this.attributesProviders = attributesProviders;
        this.interactionPredicate = interactionPredicate;
        this.contextRef = contextRef;
        this.internalLogger = internalLogger;
        this.composeActionTrackingStrategy = composeActionTrackingStrategy;
        this.androidActionTrackingStrategy = androidActionTrackingStrategy;
        this.gestureDirection = "";
        Context context = (Context) contextRef.get();
        if (context != null) {
            composeActionTrackingStrategy.register(sdkCore, context);
            androidActionTrackingStrategy.register(sdkCore, context);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        Window window = (Window) this.windowReference.get();
        handleTapUp(window != null ? window.getDecorView() : null, e);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        resetScrollEventParameters();
        this.onTouchDownXPos = e.getX();
        this.onTouchDownYPos = e.getY();
        return false;
    }

    public final void onUp(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Window window = (Window) this.windowReference.get();
        closeScrollOrSwipeEventIfAny(window != null ? window.getDecorView() : null, event);
        resetScrollEventParameters();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent endUpEvent, float f, float f2) {
        Intrinsics.checkNotNullParameter(endUpEvent, "endUpEvent");
        this.scrollEventType = RumActionType.SWIPE;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent currentMoveEvent, float f, float f2) {
        View decorView;
        Intrinsics.checkNotNullParameter(currentMoveEvent, "currentMoveEvent");
        RumMonitor rumMonitor = GlobalRumMonitor.get(this.sdkCore);
        Window window = (Window) this.windowReference.get();
        if (window != null && (decorView = window.getDecorView()) != null && this.scrollEventType == null) {
            ViewTarget viewTargetFindTarget = motionEvent != null ? findTarget(decorView, motionEvent.getX(), motionEvent.getY(), true) : null;
            if (viewTargetFindTarget != null) {
                this.scrollTargetReference = viewTargetFindTarget;
                Map mapResolveAttributes = resolveAttributes(viewTargetFindTarget, null);
                RumActionType rumActionType = RumActionType.SCROLL;
                rumMonitor.startAction(rumActionType, GesturesUtilsKt.resolveViewTargetName(this.interactionPredicate, viewTargetFindTarget), mapResolveAttributes);
                this.scrollEventType = rumActionType;
                Unit unit = Unit.INSTANCE;
            }
        }
        return false;
    }

    static /* synthetic */ ViewTarget findTarget$default(GesturesListener gesturesListener, View view, float f, float f2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return gesturesListener.findTarget(view, f, f2, z);
    }

    private final ViewTarget findTarget(View view, float f, float f2, boolean z) {
        final String str;
        ViewTarget viewTargetFindTargetForTap;
        LinkedList linkedList = new LinkedList();
        linkedList.add(0, view);
        ViewTarget viewTarget = null;
        boolean z2 = false;
        while (!linkedList.isEmpty()) {
            Object objRemove = linkedList.remove(0);
            Intrinsics.checkNotNullExpressionValue(objRemove, "queue.removeAt(0)");
            View view2 = (View) objRemove;
            z2 = z2 || isJetpackComposeView(view2);
            if (z) {
                viewTargetFindTargetForTap = findTargetForScroll(view2, f, f2);
            } else {
                viewTargetFindTargetForTap = findTargetForTap(view2, f, f2);
            }
            if (viewTargetFindTargetForTap != null) {
                viewTarget = viewTargetFindTargetForTap;
            }
            if (view2.getVisibility() == 0 && (view2 instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    linkedList.add(viewGroup.getChildAt(i));
                }
            }
        }
        if (viewTarget == null) {
            if (z2) {
                str = "We could not find a valid target for the gesture event. Compose actions tracking not enabled, or the compose view is not tagged.";
            } else {
                str = "We could not find a valid target for the gesture event. The DecorView was empty and either transparent or not clickable for this Activity.";
            }
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.INFO, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.rum.internal.instrumentation.gestures.GesturesListener.findTarget.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return str;
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        return viewTarget;
    }

    private final ViewTarget findTargetForScroll(View view, float f, float f2) {
        ViewTarget viewTargetFindTargetForScroll = this.androidActionTrackingStrategy.findTargetForScroll(view, f, f2);
        if (viewTargetFindTargetForScroll == null) {
            viewTargetFindTargetForScroll = null;
        }
        ViewTarget viewTargetFindTargetForScroll2 = this.composeActionTrackingStrategy.findTargetForScroll(view, f, f2);
        return viewTargetFindTargetForScroll2 != null ? viewTargetFindTargetForScroll2 : viewTargetFindTargetForScroll;
    }

    private final ViewTarget findTargetForTap(View view, float f, float f2) {
        ViewTarget viewTargetFindTargetForTap = this.androidActionTrackingStrategy.findTargetForTap(view, f, f2);
        if (viewTargetFindTargetForTap == null) {
            viewTargetFindTargetForTap = null;
        }
        ViewTarget viewTargetFindTargetForTap2 = this.composeActionTrackingStrategy.findTargetForTap(view, f, f2);
        return viewTargetFindTargetForTap2 != null ? viewTargetFindTargetForTap2 : viewTargetFindTargetForTap;
    }

    private final void closeScrollOrSwipeEventIfAny(View view, MotionEvent motionEvent) {
        RumActionType rumActionType = this.scrollEventType;
        if (rumActionType == null) {
            closeScrollAsTap(view, motionEvent);
        } else {
            closeScrollOrSwipeEvent(rumActionType, view, motionEvent);
        }
    }

    private final void closeScrollAsTap(View view, MotionEvent motionEvent) {
        if (view != null) {
            ViewTarget viewTargetFindTarget$default = findTarget$default(this, view, this.onTouchDownXPos, this.onTouchDownYPos, false, 8, null);
            ViewTarget viewTargetFindTarget$default2 = findTarget$default(this, view, motionEvent.getX(), motionEvent.getY(), false, 8, null);
            if (viewTargetFindTarget$default != null) {
                if (!Intrinsics.areEqual(viewTargetFindTarget$default, viewTargetFindTarget$default2)) {
                    viewTargetFindTarget$default = null;
                }
                if (viewTargetFindTarget$default != null) {
                    sendTapEventWithTarget(viewTargetFindTarget$default);
                }
            }
        }
    }

    private final void closeScrollOrSwipeEvent(RumActionType rumActionType, View view, MotionEvent motionEvent) {
        RumMonitor rumMonitor = GlobalRumMonitor.get(this.sdkCore);
        ViewTarget viewTarget = this.scrollTargetReference;
        if (view == null || viewTarget == null) {
            return;
        }
        rumMonitor.stopAction(rumActionType, GesturesUtilsKt.resolveViewTargetName(this.interactionPredicate, viewTarget), resolveAttributes(viewTarget, motionEvent));
    }

    private final void resetScrollEventParameters() {
        this.scrollTargetReference = null;
        this.scrollEventType = null;
        this.gestureDirection = "";
        this.onTouchDownYPos = 0.0f;
        this.onTouchDownXPos = 0.0f;
    }

    private final void handleTapUp(View view, MotionEvent motionEvent) {
        ViewTarget viewTargetFindTarget$default;
        if (view == null || (viewTargetFindTarget$default = findTarget$default(this, view, motionEvent.getX(), motionEvent.getY(), false, 8, null)) == null) {
            return;
        }
        sendTapEventWithTarget(viewTargetFindTarget$default);
    }

    private final void sendTapEventWithTarget(ViewTarget viewTarget) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        View view = (View) viewTarget.getViewRef().get();
        if (view != null) {
            String strResourceIdName = GesturesUtilsKt.resourceIdName((Context) this.contextRef.get(), view.getId());
            linkedHashMap.put("action.target.classname", GesturesUtilsKt.targetClassName(view));
            linkedHashMap.put("action.target.resource_id", strResourceIdName);
            for (ViewAttributesProvider viewAttributesProvider : this.attributesProviders) {
                viewAttributesProvider.extractAttributes(view, linkedHashMap);
            }
        }
        viewTarget.getNode();
        GlobalRumMonitor.get(this.sdkCore).addAction(RumActionType.TAP, GesturesUtilsKt.resolveViewTargetName(this.interactionPredicate, viewTarget), linkedHashMap);
    }

    private final Map resolveAttributes(ViewTarget viewTarget, MotionEvent motionEvent) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        View view = (View) viewTarget.getViewRef().get();
        if (view != null) {
            String strResourceIdName = GesturesUtilsKt.resourceIdName((Context) this.contextRef.get(), view.getId());
            linkedHashMap.put("action.target.classname", GesturesUtilsKt.targetClassName(view));
            linkedHashMap.put("action.target.resource_id", strResourceIdName);
            for (ViewAttributesProvider viewAttributesProvider : this.attributesProviders) {
                viewAttributesProvider.extractAttributes(view, linkedHashMap);
            }
        }
        viewTarget.getNode();
        if (motionEvent != null) {
            String strResolveGestureDirection = resolveGestureDirection(motionEvent);
            this.gestureDirection = strResolveGestureDirection;
            linkedHashMap.put("action.gesture.direction", strResolveGestureDirection);
        }
        return linkedHashMap;
    }

    private final String resolveGestureDirection(MotionEvent motionEvent) {
        float x = motionEvent.getX() - this.onTouchDownXPos;
        float y = motionEvent.getY() - this.onTouchDownYPos;
        if (Math.abs(x) > Math.abs(y)) {
            if (x > 0.0f) {
                return "right";
            }
            return "left";
        }
        if (y > 0.0f) {
            return "down";
        }
        return "up";
    }

    private final boolean isJetpackComposeView(View view) {
        String name = view.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "view::class.java.name");
        return StringsKt.startsWith$default(name, "androidx.compose.ui.platform.ComposeView", false, 2, (Object) null);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ GesturesListener(SdkCore sdkCore, WeakReference weakReference, ViewAttributesProvider[] viewAttributesProviderArr, InteractionPredicate interactionPredicate, Reference reference, InternalLogger internalLogger, ActionTrackingStrategy actionTrackingStrategy, ActionTrackingStrategy actionTrackingStrategy2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sdkCore, weakReference, (i & 4) != 0 ? new ViewAttributesProvider[0] : viewAttributesProviderArr, (i & 8) != 0 ? new NoOpInteractionPredicate() : interactionPredicate, reference, internalLogger, (i & 64) != 0 ? new NoOpActionTrackingStrategy() : actionTrackingStrategy, (i & 128) != 0 ? new AndroidActionTrackingStrategy() : actionTrackingStrategy2);
    }
}
