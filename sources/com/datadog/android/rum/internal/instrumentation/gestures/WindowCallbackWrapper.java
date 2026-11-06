package com.datadog.android.rum.internal.instrumentation.gestures;

import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import com.datadog.android.rum.GlobalRumMonitor;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.internal.tracking.NoOpInteractionPredicate;
import com.datadog.android.rum.tracking.InteractionPredicate;
import com.datadog.android.rum.tracking.ViewAttributesProvider;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class WindowCallbackWrapper extends FixedWindowCallback {
    public static final Companion Companion = new Companion(null);
    private final Function1 copyEvent;
    private final GesturesDetectorWrapper gesturesDetector;
    private final InteractionPredicate interactionPredicate;
    private final InternalLogger internalLogger;
    private final SdkCore sdkCore;
    private final ViewAttributesProvider[] targetAttributesProviders;
    private final WeakReference windowReference;
    private final Window.Callback wrappedCallback;

    public final Window.Callback getWrappedCallback() {
        return this.wrappedCallback;
    }

    public /* synthetic */ WindowCallbackWrapper(Window window, SdkCore sdkCore, Window.Callback callback, GesturesDetectorWrapper gesturesDetectorWrapper, InteractionPredicate interactionPredicate, Function1 function1, ViewAttributesProvider[] viewAttributesProviderArr, InternalLogger internalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(window, sdkCore, callback, gesturesDetectorWrapper, (i & 16) != 0 ? new NoOpInteractionPredicate() : interactionPredicate, (i & 32) != 0 ? new Function1() { // from class: com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper.1
            @Override // kotlin.jvm.functions.Function1
            public final MotionEvent invoke(MotionEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                MotionEvent motionEventObtain = MotionEvent.obtain(it);
                Intrinsics.checkNotNullExpressionValue(motionEventObtain, "obtain(it)");
                return motionEventObtain;
            }
        } : function1, (i & 64) != 0 ? new ViewAttributesProvider[0] : viewAttributesProviderArr, internalLogger);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowCallbackWrapper(Window window, SdkCore sdkCore, Window.Callback wrappedCallback, GesturesDetectorWrapper gesturesDetector, InteractionPredicate interactionPredicate, Function1 copyEvent, ViewAttributesProvider[] targetAttributesProviders, InternalLogger internalLogger) {
        super(wrappedCallback);
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(wrappedCallback, "wrappedCallback");
        Intrinsics.checkNotNullParameter(gesturesDetector, "gesturesDetector");
        Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
        Intrinsics.checkNotNullParameter(copyEvent, "copyEvent");
        Intrinsics.checkNotNullParameter(targetAttributesProviders, "targetAttributesProviders");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.sdkCore = sdkCore;
        this.wrappedCallback = wrappedCallback;
        this.gesturesDetector = gesturesDetector;
        this.interactionPredicate = interactionPredicate;
        this.copyEvent = copyEvent;
        this.targetAttributesProviders = targetAttributesProviders;
        this.internalLogger = internalLogger;
        this.windowReference = new WeakReference(window);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            MotionEvent motionEvent2 = (MotionEvent) this.copyEvent.invoke(motionEvent);
            try {
                try {
                    this.gesturesDetector.onTouchEvent(motionEvent2);
                } catch (Exception e) {
                    InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper.dispatchTouchEvent.1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Error processing MotionEvent";
                        }
                    }, (Throwable) e, false, (Map) null, 48, (Object) null);
                }
                motionEvent2.recycle();
            } catch (Throwable th) {
                motionEvent2.recycle();
                throw th;
            }
        } else {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper.dispatchTouchEvent.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Received null MotionEvent";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        }
        try {
            return this.wrappedCallback.dispatchTouchEvent(motionEvent);
        } catch (NullPointerException e2) {
            logOrRethrowWrappedCallbackException(e2);
            return true;
        }
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Window window = (Window) this.windowReference.get();
        GlobalRumMonitor.get(this.sdkCore).addAction(RumActionType.TAP, GesturesUtilsKt.resolveTargetName(this.interactionPredicate, item), MapsKt.mutableMapOf(TuplesKt.to("action.target.classname", item.getClass().getCanonicalName()), TuplesKt.to("action.target.resource_id", GesturesUtilsKt.resourceIdName(window != null ? window.getContext() : null, item.getItemId())), TuplesKt.to("action.target.title", item.getTitle())));
        try {
            return this.wrappedCallback.onMenuItemSelected(i, item);
        } catch (NullPointerException e) {
            logOrRethrowWrappedCallbackException(e);
            return true;
        }
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.MAINTAINER, InternalLogger.Target.TELEMETRY}), (Function0) new Function0() { // from class: com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper.dispatchKeyEvent.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Received null KeyEvent";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            handleBackEvent(keyEvent);
        } else if (keyEvent.getKeyCode() == 23 && keyEvent.getAction() == 1) {
            handleRemoteControlActionEvent();
        }
        try {
            return this.wrappedCallback.dispatchKeyEvent(keyEvent);
        } catch (NullPointerException e) {
            logOrRethrowWrappedCallbackException(e);
            return true;
        }
    }

    private final void handleRemoteControlActionEvent() {
        View currentFocus;
        Window window = (Window) this.windowReference.get();
        if (window == null || (currentFocus = window.getCurrentFocus()) == null) {
            return;
        }
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("action.target.classname", GesturesUtilsKt.targetClassName(currentFocus)), TuplesKt.to("action.target.resource_id", GesturesUtilsKt.resourceIdName(window.getContext(), currentFocus.getId())));
        for (ViewAttributesProvider viewAttributesProvider : this.targetAttributesProviders) {
            viewAttributesProvider.extractAttributes(currentFocus, mapMutableMapOf);
        }
        GlobalRumMonitor.get(this.sdkCore).addAction(RumActionType.CLICK, GesturesUtilsKt.resolveTargetName(this.interactionPredicate, currentFocus), mapMutableMapOf);
    }

    private final void handleBackEvent(KeyEvent keyEvent) {
        String targetName = this.interactionPredicate.getTargetName(keyEvent);
        if (targetName == null || targetName.length() == 0) {
            targetName = "back";
        }
        GlobalRumMonitor.get(this.sdkCore).addAction(RumActionType.BACK, targetName, MapsKt.emptyMap());
    }

    private final void logOrRethrowWrappedCallbackException(NullPointerException nullPointerException) {
        String message = nullPointerException.getMessage();
        if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "Parameter specified as non-null is null", false, 2, (Object) null)) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper.logOrRethrowWrappedCallbackException.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Wrapped Window.Callback failed processing event";
                }
            }, (Throwable) nullPointerException, false, (Map) null, 48, (Object) null);
            return;
        }
        throw nullPointerException;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
