package com.facebook.react.views.text.internal.span;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ViewGroupClickEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactClickableSpan extends ClickableSpan implements ReactSpan {
    private int focusBgColor;
    private boolean isKeyboardFocused;
    private final int reactTag;

    public ReactClickableSpan(int i) {
        this.reactTag = i;
    }

    public final void setKeyboardFocused(boolean z) {
        this.isKeyboardFocused = z;
    }

    public final void setFocusBgColor(int i) {
        this.focusBgColor = i;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, this.reactTag);
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new ViewGroupClickEvent(UIManagerHelper.getSurfaceId(reactContext), this.reactTag));
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        if (this.isKeyboardFocused) {
            ds.bgColor = this.focusBgColor;
        }
    }
}
