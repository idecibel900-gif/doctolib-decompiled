package com.reactnativekeyboardcontroller.listeners;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativekeyboardcontroller.extensions.FloatKt;
import com.reactnativekeyboardcontroller.extensions.ReactContextKt;
import com.reactnativekeyboardcontroller.extensions.ThemedReactContextKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class WindowDimensionListener {
    public static final Companion Companion = new Companion(null);
    private static int listenerID = -1;
    private final ThemedReactContext context;
    private Dimensions lastDispatchedDimensions = new Dimensions(0.0d, 0.0d);
    private ViewTreeObserver.OnGlobalLayoutListener layoutListener;

    public WindowDimensionListener(ThemedReactContext themedReactContext) {
        this.context = themedReactContext;
    }

    public final void attachListener() {
        ViewTreeObserver viewTreeObserver;
        ThemedReactContext themedReactContext = this.context;
        if (themedReactContext == null || listenerID == themedReactContext.hashCode()) {
            return;
        }
        listenerID = this.context.hashCode();
        final ViewGroup content = ReactContextKt.getContent(this.context);
        updateWindowDimensions(content);
        this.layoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.reactnativekeyboardcontroller.listeners.WindowDimensionListener$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f$0.updateWindowDimensions(content);
            }
        };
        if (content == null || (viewTreeObserver = content.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this.layoutListener);
    }

    public final void detachListener() {
        ViewGroup content;
        ViewTreeObserver viewTreeObserver;
        ThemedReactContext themedReactContext = this.context;
        if (themedReactContext == null || (content = ReactContextKt.getContent(themedReactContext)) == null || (viewTreeObserver = content.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this.layoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateWindowDimensions(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        Dimensions dimensions = new Dimensions(FloatKt.getDp(viewGroup.getWidth()), FloatKt.getDp(viewGroup.getHeight()));
        if (Intrinsics.areEqual(dimensions, this.lastDispatchedDimensions)) {
            return;
        }
        this.lastDispatchedDimensions = dimensions;
        ThemedReactContext themedReactContext = this.context;
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("height", dimensions.getHeight());
        writableMapCreateMap.putDouble("width", dimensions.getWidth());
        Unit unit = Unit.INSTANCE;
        ThemedReactContextKt.emitEvent(themedReactContext, "KeyboardController::windowDidResize", writableMapCreateMap);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
