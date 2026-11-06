package com.swmansion.enriched.markdown.accessibility;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AccessibleMarkdownTextView extends AppCompatTextView {
    private final MarkdownAccessibilityHelper accessibilityHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccessibleMarkdownTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.accessibilityHelper = new MarkdownAccessibilityHelper(this);
    }

    public final MarkdownAccessibilityHelper getAccessibilityHelper() {
        return this.accessibilityHelper;
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.accessibilityHelper.dispatchHoverEvent(event) || super.dispatchHoverEvent(event);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.accessibilityHelper.dispatchKeyEvent(event) || super.dispatchKeyEvent(event);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        this.accessibilityHelper.onFocusChanged(z, i, rect);
    }
}
