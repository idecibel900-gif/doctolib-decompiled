package com.swmansion.rnscreens;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class InsetsObserverProxy implements OnApplyWindowInsetsListener, LifecycleEventListener {
    private static boolean hasBeenRegistered;
    private static boolean isObservingContextLifetime;
    public static final InsetsObserverProxy INSTANCE = new InsetsObserverProxy();
    private static final HashSet listeners = new HashSet();
    private static WeakReference eventSourceView = new WeakReference(null);
    private static boolean shouldForwardInsetsToView = true;

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    private InsetsObserverProxy() {
    }

    private final boolean getAllowRegistration() {
        return !hasBeenRegistered || eventSourceView.get() == null;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = shouldForwardInsetsToView ? ViewCompat.onApplyWindowInsets(v, insets) : insets;
        Intrinsics.checkNotNull(windowInsetsCompatOnApplyWindowInsets);
        Iterator it = listeners.iterator();
        while (it.hasNext()) {
            windowInsetsCompatOnApplyWindowInsets = ((OnApplyWindowInsetsListener) it.next()).onApplyWindowInsets(v, insets);
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompatOnApplyWindowInsets, "onApplyWindowInsets(...)");
        }
        return windowInsetsCompatOnApplyWindowInsets;
    }

    public final void registerWithContext(ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        isObservingContextLifetime = true;
        context.addLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        View observedView = getObservedView();
        if (hasBeenRegistered && observedView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(observedView, null);
            hasBeenRegistered = false;
            eventSourceView.clear();
        }
        isObservingContextLifetime = false;
    }

    public final void addOnApplyWindowInsetsListener(OnApplyWindowInsetsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.add(listener);
    }

    public final void removeOnApplyWindowInsetsListener(OnApplyWindowInsetsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    public final boolean registerOnView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!getAllowRegistration()) {
            return false;
        }
        ViewCompat.setOnApplyWindowInsetsListener(view, this);
        eventSourceView = new WeakReference(view);
        hasBeenRegistered = true;
        return true;
    }

    private final View getObservedView() {
        return (View) eventSourceView.get();
    }
}
