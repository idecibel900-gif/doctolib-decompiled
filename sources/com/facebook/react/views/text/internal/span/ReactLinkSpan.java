package com.facebook.react.views.text.internal.span;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.text.PreparedLayout;
import com.facebook.react.views.text.PreparedLayoutTextView;
import com.facebook.react.views.view.ViewGroupClickEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactLinkSpan extends ClickableSpan implements ReactSpan {
    private final int fragmentIndex;

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
    }

    public ReactLinkSpan(int i) {
        this.fragmentIndex = i;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        PreparedLayout preparedLayout;
        int i;
        EventDispatcher eventDispatcherForReactTag;
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        PreparedLayoutTextView preparedLayoutTextView = view instanceof PreparedLayoutTextView ? (PreparedLayoutTextView) view : null;
        if (preparedLayoutTextView == null || (preparedLayout = preparedLayoutTextView.getPreparedLayout()) == null || (eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, (i = preparedLayout.getReactTags()[this.fragmentIndex]))) == null) {
            return;
        }
        eventDispatcherForReactTag.dispatchEvent(new ViewGroupClickEvent(UIManagerHelper.getSurfaceId(reactContext), i));
    }
}
