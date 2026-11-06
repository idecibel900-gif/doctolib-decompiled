package com.reactnativekeyboardcontroller.listeners;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.views.view.ReactViewGroup;
import com.reactnativekeyboardcontroller.constants.UIThread;
import com.reactnativekeyboardcontroller.events.KeyboardTransitionEvent;
import com.reactnativekeyboardcontroller.extensions.EditTextKt;
import com.reactnativekeyboardcontroller.extensions.FloatKt;
import com.reactnativekeyboardcontroller.extensions.ThemedReactContextKt;
import com.reactnativekeyboardcontroller.extensions.WindowInsetsAnimationCompatKt;
import com.reactnativekeyboardcontroller.interactive.InteractiveKeyboardProvider;
import com.reactnativekeyboardcontroller.log.Logger;
import com.reactnativekeyboardcontroller.traversal.FocusedInputHolder;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class KeyboardAnimationCallback extends WindowInsetsAnimationCompat.Callback implements OnApplyWindowInsetsListener, Suspendable {
    private HashSet animationsToSkip;
    private final KeyboardAnimationCallbackConfig config;
    private final ThemedReactContext context;
    private int duration;
    private final ReactViewGroup eventPropagationView;
    private final ViewTreeObserver.OnGlobalFocusChangeListener focusListener;
    private boolean isKeyboardVisible;
    private boolean isSuspended;
    private boolean isTransitioning;
    private FocusedInputObserver layoutObserver;
    private double persistentKeyboardHeight;
    private double prevKeyboardHeight;
    private final int surfaceId;
    private final View view;
    private int viewTagFocused;

    public void suspend(boolean z) {
        Suspendable.DefaultImpls.suspend(this, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyboardAnimationCallback(ReactViewGroup eventPropagationView, View view, ThemedReactContext themedReactContext, KeyboardAnimationCallbackConfig config) {
        super(config.getDispatchMode());
        Intrinsics.checkNotNullParameter(eventPropagationView, "eventPropagationView");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(config, "config");
        this.eventPropagationView = eventPropagationView;
        this.view = view;
        this.context = themedReactContext;
        this.config = config;
        this.surfaceId = UIManagerHelper.getSurfaceId(eventPropagationView);
        this.viewTagFocused = -1;
        this.animationsToSkip = new HashSet();
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener = new ViewTreeObserver.OnGlobalFocusChangeListener() { // from class: com.reactnativekeyboardcontroller.listeners.KeyboardAnimationCallback$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
            public final void onGlobalFocusChanged(View view2, View view3) {
                KeyboardAnimationCallback.focusListener$lambda$0(this.f$0, view2, view3);
            }
        };
        this.focusListener = onGlobalFocusChangeListener;
        if ((config.getDeferredInsetTypes() & config.getPersistentInsetTypes()) != 0) {
            throw new IllegalArgumentException("persistentInsetTypes and deferredInsetTypes can not contain any of  same WindowInsetsCompat.Type values");
        }
        this.layoutObserver = new FocusedInputObserver(view, eventPropagationView, themedReactContext);
        view.getViewTreeObserver().addOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    private final boolean isKeyboardInteractive() {
        return this.duration == -1;
    }

    public boolean isSuspended() {
        return this.isSuspended;
    }

    @Override // com.reactnativekeyboardcontroller.listeners.Suspendable
    public void setSuspended(boolean z) {
        this.isSuspended = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void focusListener$lambda$0(KeyboardAnimationCallback keyboardAnimationCallback, View view, View view2) {
        if (view2 instanceof EditText) {
            keyboardAnimationCallback.viewTagFocused = ((EditText) view2).getId();
            if (!keyboardAnimationCallback.isKeyboardVisible || view == null) {
                return;
            }
            ThemedReactContext themedReactContext = keyboardAnimationCallback.context;
            int id = keyboardAnimationCallback.eventPropagationView.getId();
            int i = keyboardAnimationCallback.surfaceId;
            int id2 = keyboardAnimationCallback.eventPropagationView.getId();
            KeyboardTransitionEvent.Companion companion = KeyboardTransitionEvent.Companion;
            ThemedReactContextKt.dispatchEvent(themedReactContext, id, new KeyboardTransitionEvent(i, id2, companion.getStart(), keyboardAnimationCallback.persistentKeyboardHeight, 1.0d, 0, keyboardAnimationCallback.viewTagFocused));
            ThemedReactContextKt.dispatchEvent(keyboardAnimationCallback.context, keyboardAnimationCallback.eventPropagationView.getId(), new KeyboardTransitionEvent(keyboardAnimationCallback.surfaceId, keyboardAnimationCallback.eventPropagationView.getId(), companion.getEnd(), keyboardAnimationCallback.persistentKeyboardHeight, 1.0d, 0, keyboardAnimationCallback.viewTagFocused));
            ThemedReactContextKt.emitEvent(keyboardAnimationCallback.context, "KeyboardController::keyboardWillShow", keyboardAnimationCallback.getEventParams(keyboardAnimationCallback.persistentKeyboardHeight));
            ThemedReactContextKt.emitEvent(keyboardAnimationCallback.context, "KeyboardController::keyboardDidShow", keyboardAnimationCallback.getEventParams(keyboardAnimationCallback.persistentKeyboardHeight));
        }
    }

    public final FocusedInputObserver getLayoutObserver$react_native_keyboard_controller_release() {
        return this.layoutObserver;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        double currentKeyboardHeight = getCurrentKeyboardHeight();
        boolean z = (this.isKeyboardVisible && isKeyboardVisible()) && !(this.isTransitioning || InteractiveKeyboardProvider.INSTANCE.isInteractive());
        boolean z2 = this.persistentKeyboardHeight == currentKeyboardHeight;
        if (z && !z2 && !KeyboardAnimationCallbackKt.isResizeHandledInCallbackMethods) {
            Logger.i$default(Logger.INSTANCE, KeyboardAnimationCallbackKt.TAG, "onApplyWindowInsets: " + this.persistentKeyboardHeight + " -> " + currentKeyboardHeight, null, 4, null);
            FocusedInputObserver focusedInputObserver = this.layoutObserver;
            if (focusedInputObserver != null) {
                focusedInputObserver.syncUpLayout();
            }
            onKeyboardResized(currentKeyboardHeight);
        }
        return insets;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat animation, WindowInsetsAnimationCompat.BoundsCompat bounds) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (!WindowInsetsAnimationCompatKt.isKeyboardAnimation(animation) || isSuspended()) {
            return bounds;
        }
        this.isTransitioning = true;
        this.isKeyboardVisible = isKeyboardVisible();
        this.duration = (int) animation.getDurationMillis();
        double currentKeyboardHeight = getCurrentKeyboardHeight();
        if (this.isKeyboardVisible) {
            this.persistentKeyboardHeight = currentKeyboardHeight;
        }
        FocusedInputObserver focusedInputObserver = this.layoutObserver;
        if (focusedInputObserver != null) {
            focusedInputObserver.syncUpLayout();
        }
        boolean z = (currentKeyboardHeight == 0.0d || this.prevKeyboardHeight == currentKeyboardHeight) ? false : true;
        boolean z2 = this.isKeyboardVisible && this.prevKeyboardHeight != 0.0d;
        if (z && z2 && KeyboardAnimationCallbackKt.isResizeHandledInCallbackMethods) {
            onKeyboardResized(currentKeyboardHeight);
            this.animationsToSkip.add(animation);
            return bounds;
        }
        ThemedReactContextKt.emitEvent(this.context, "KeyboardController::" + (!this.isKeyboardVisible ? "keyboardWillHide" : "keyboardWillShow"), getEventParams(currentKeyboardHeight));
        Logger.i$default(Logger.INSTANCE, KeyboardAnimationCallbackKt.TAG, "HEIGHT:: " + currentKeyboardHeight + " TAG:: " + this.viewTagFocused, null, 4, null);
        ThemedReactContext themedReactContext = this.context;
        int id = this.eventPropagationView.getId();
        double d = 0.0d;
        int i = this.surfaceId;
        int id2 = this.eventPropagationView.getId();
        KeyboardTransitionEvent.Companion.EventName start = KeyboardTransitionEvent.Companion.getStart();
        if (this.isKeyboardVisible) {
            d = 1.0d;
        }
        ThemedReactContextKt.dispatchEvent(themedReactContext, id, new KeyboardTransitionEvent(i, id2, start, currentKeyboardHeight, d, this.duration, this.viewTagFocused));
        WindowInsetsAnimationCompat.BoundsCompat boundsCompatOnStart = super.onStart(animation, bounds);
        Intrinsics.checkNotNullExpressionValue(boundsCompatOnStart, "onStart(...)");
        return boundsCompatOnStart;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List runningAnimations) {
        Object next;
        KeyboardTransitionEvent.Companion.EventName move;
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
        Iterator it = runningAnimations.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) next;
            if (WindowInsetsAnimationCompatKt.isKeyboardAnimation(windowInsetsAnimationCompat) && !this.animationsToSkip.contains(windowInsetsAnimationCompat)) {
                break;
            }
        }
        boolean z = next == null;
        if (!isSuspended() && !z) {
            Insets insets2 = insets.getInsets(this.config.getDeferredInsetTypes());
            Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
            Insets NONE = insets.getInsets(this.config.getPersistentInsetTypes());
            Intrinsics.checkNotNullExpressionValue(NONE, "getInsets(...)");
            if (this.config.getHasTranslucentNavigationBar()) {
                NONE = Insets.NONE;
                Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
            }
            Insets insetsMax = Insets.max(Insets.subtract(insets2, NONE), Insets.NONE);
            Intrinsics.checkNotNullExpressionValue(insetsMax, "let(...)");
            float f = insetsMax.bottom - insetsMax.top;
            double dp = FloatKt.getDp(f);
            double d = 0.0d;
            try {
                double dAbs = Math.abs(dp / this.persistentKeyboardHeight);
                if (!Double.isNaN(dAbs) && !Double.isInfinite(dAbs)) {
                    d = dAbs;
                }
            } catch (ArithmeticException e) {
                Logger.w$default(Logger.INSTANCE, KeyboardAnimationCallbackKt.TAG, "Caught arithmetic exception during `progress` calculation: " + e, null, 4, null);
            }
            double d2 = d;
            Logger logger = Logger.INSTANCE;
            String str = KeyboardAnimationCallbackKt.TAG;
            InteractiveKeyboardProvider interactiveKeyboardProvider = InteractiveKeyboardProvider.INSTANCE;
            Logger.i$default(logger, str, "DiffY: " + f + " " + dp + " " + d2 + " " + interactiveKeyboardProvider.isInteractive() + " " + this.viewTagFocused, null, 4, null);
            if (interactiveKeyboardProvider.isInteractive()) {
                move = KeyboardTransitionEvent.Companion.getInteractive();
            } else {
                move = KeyboardTransitionEvent.Companion.getMove();
            }
            ThemedReactContextKt.dispatchEvent(this.context, this.eventPropagationView.getId(), new KeyboardTransitionEvent(this.surfaceId, this.eventPropagationView.getId(), move, dp, d2, this.duration, this.viewTagFocused));
        }
        return insets;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(final WindowInsetsAnimationCompat animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onEnd(animation);
        if (!WindowInsetsAnimationCompatKt.isKeyboardAnimation(animation) || isSuspended()) {
            return;
        }
        this.isTransitioning = false;
        this.duration = (int) animation.getDurationMillis();
        Runnable runnable = new Runnable() { // from class: com.reactnativekeyboardcontroller.listeners.KeyboardAnimationCallback$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardAnimationCallback.onEnd$lambda$5(this.f$0, animation);
            }
        };
        if (isKeyboardInteractive()) {
            this.view.postDelayed(runnable, UIThread.INSTANCE.getNEXT_FRAME());
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onEnd$lambda$5(KeyboardAnimationCallback keyboardAnimationCallback, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        double currentKeyboardHeight = keyboardAnimationCallback.getCurrentKeyboardHeight();
        keyboardAnimationCallback.isKeyboardVisible = keyboardAnimationCallback.isKeyboardVisible();
        keyboardAnimationCallback.prevKeyboardHeight = currentKeyboardHeight;
        if (keyboardAnimationCallback.animationsToSkip.contains(windowInsetsAnimationCompat)) {
            keyboardAnimationCallback.duration = 0;
            keyboardAnimationCallback.animationsToSkip.remove(windowInsetsAnimationCompat);
            return;
        }
        ThemedReactContextKt.emitEvent(keyboardAnimationCallback.context, "KeyboardController::" + (!keyboardAnimationCallback.isKeyboardVisible ? "keyboardDidHide" : "keyboardDidShow"), keyboardAnimationCallback.getEventParams(currentKeyboardHeight));
        ThemedReactContextKt.dispatchEvent(keyboardAnimationCallback.context, keyboardAnimationCallback.eventPropagationView.getId(), new KeyboardTransitionEvent(keyboardAnimationCallback.surfaceId, keyboardAnimationCallback.eventPropagationView.getId(), KeyboardTransitionEvent.Companion.getEnd(), currentKeyboardHeight, !keyboardAnimationCallback.isKeyboardVisible ? 0.0d : 1.0d, keyboardAnimationCallback.duration, keyboardAnimationCallback.viewTagFocused));
        keyboardAnimationCallback.duration = 0;
        ThemedReactContextKt.keepShadowNodesInSync(keyboardAnimationCallback.context, keyboardAnimationCallback.eventPropagationView.getId());
    }

    public static /* synthetic */ void syncKeyboardPosition$default(KeyboardAnimationCallback keyboardAnimationCallback, Double d, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            d = null;
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        keyboardAnimationCallback.syncKeyboardPosition(d, bool);
    }

    public final void syncKeyboardPosition(Double d, Boolean bool) {
        double dDoubleValue = d != null ? d.doubleValue() : getCurrentKeyboardHeight();
        boolean zBooleanValue = bool != null ? bool.booleanValue() : isKeyboardVisible();
        this.isKeyboardVisible = zBooleanValue;
        this.prevKeyboardHeight = dDoubleValue;
        this.isTransitioning = false;
        this.duration = 0;
        ThemedReactContextKt.emitEvent(this.context, "KeyboardController::" + (!zBooleanValue ? "keyboardDidHide" : "keyboardDidShow"), getEventParams(dDoubleValue));
        KeyboardTransitionEvent.Companion companion = KeyboardTransitionEvent.Companion;
        Iterator it = CollectionsKt.listOf((Object[]) new KeyboardTransitionEvent.Companion.EventName[]{companion.getMove(), companion.getEnd()}).iterator();
        while (it.hasNext()) {
            ThemedReactContextKt.dispatchEvent(this.context, this.eventPropagationView.getId(), new KeyboardTransitionEvent(this.surfaceId, this.eventPropagationView.getId(), (KeyboardTransitionEvent.Companion.EventName) it.next(), dDoubleValue, !this.isKeyboardVisible ? 0.0d : 1.0d, this.duration, this.viewTagFocused));
        }
    }

    public final void destroy() {
        this.view.getViewTreeObserver().removeOnGlobalFocusChangeListener(this.focusListener);
        FocusedInputObserver focusedInputObserver = this.layoutObserver;
        if (focusedInputObserver != null) {
            focusedInputObserver.destroy();
        }
    }

    private final void onKeyboardResized(double d) {
        this.duration = 0;
        ThemedReactContextKt.emitEvent(this.context, "KeyboardController::keyboardWillShow", getEventParams(d));
        KeyboardTransitionEvent.Companion companion = KeyboardTransitionEvent.Companion;
        Iterator it = CollectionsKt.listOf((Object[]) new KeyboardTransitionEvent.Companion.EventName[]{companion.getStart(), companion.getMove(), companion.getEnd()}).iterator();
        while (it.hasNext()) {
            ThemedReactContextKt.dispatchEvent(this.context, this.eventPropagationView.getId(), new KeyboardTransitionEvent(this.surfaceId, this.eventPropagationView.getId(), (KeyboardTransitionEvent.Companion.EventName) it.next(), d, 1.0d, 0, this.viewTagFocused));
        }
        ThemedReactContextKt.emitEvent(this.context, "KeyboardController::keyboardDidShow", getEventParams(d));
        ThemedReactContextKt.keepShadowNodesInSync(this.context, this.eventPropagationView.getId());
        this.persistentKeyboardHeight = d;
    }

    private final boolean isKeyboardVisible() {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.view);
        if (rootWindowInsets != null) {
            return rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime());
        }
        return false;
    }

    private final double getCurrentKeyboardHeight() {
        Insets insets;
        Insets insets2;
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.view);
        int i = 0;
        int i2 = (rootWindowInsets == null || (insets2 = rootWindowInsets.getInsets(WindowInsetsCompat.Type.ime())) == null) ? 0 : insets2.bottom;
        if (!this.config.getHasTranslucentNavigationBar() && rootWindowInsets != null && (insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.navigationBars())) != null) {
            i = insets.bottom;
        }
        return RangesKt.coerceAtLeast(FloatKt.getDp(i2 - i), 0.0d);
    }

    private final WritableMap getEventParams(double d) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("height", d);
        writableMapCreateMap.putInt("duration", this.duration);
        writableMapCreateMap.putDouble(DiagnosticsEntry.TIMESTAMP_KEY, System.currentTimeMillis());
        writableMapCreateMap.putInt("target", this.viewTagFocused);
        EditText editText = FocusedInputHolder.INSTANCE.get();
        writableMapCreateMap.putString("type", editText != null ? EditTextKt.getKeyboardType(editText) : null);
        writableMapCreateMap.putString("appearance", ThemedReactContextKt.getAppearance(this.context));
        return writableMapCreateMap;
    }
}
