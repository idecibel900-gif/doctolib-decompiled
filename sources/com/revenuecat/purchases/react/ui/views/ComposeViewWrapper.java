package com.revenuecat.purchases.react.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\rJ\u001f\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H$¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\b\u0010\u001e\u001a\u00020\u001cH\u0014J\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0014J0\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000bH\u0014R\u001e\u0010\u000e\u001a\u0004\u0018\u00018\u0000X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/revenuecat/purchases/react/ui/views/ComposeViewWrapper;", "T", "Landroid/view/View;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "wrappedView", "getWrappedView", "()Landroid/view/View;", "setWrappedView", "(Landroid/view/View;)V", "Landroid/view/View;", "isAttached", "", "()Z", "setAttached", "(Z)V", "createWrappedView", "(Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;", "init", "", "onAttachedToWindow", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "left", "top", "right", "bottom", "react-native-purchases-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ComposeViewWrapper<T extends View> extends FrameLayout {
    private boolean isAttached;
    private T wrappedView;

    protected abstract T createWrappedView(Context context, AttributeSet attrs);

    protected final T getWrappedView() {
        return this.wrappedView;
    }

    protected final void setWrappedView(T t) {
        this.wrappedView = t;
    }

    /* JADX INFO: renamed from: isAttached, reason: from getter */
    protected final boolean getIsAttached() {
        return this.isAttached;
    }

    protected final void setAttached(boolean z) {
        this.isAttached = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeViewWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeViewWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeViewWrapper(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, null);
    }

    private final void init(Context context, AttributeSet attrs) {
        T t = (T) createWrappedView(context, attrs);
        t.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.wrappedView = t;
        addView(t);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttached = true;
        post(new Runnable() { // from class: com.revenuecat.purchases.react.ui.views.ComposeViewWrapper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.requestLayout();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttached = false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.isAttached) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } else {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        T t;
        super.onLayout(changed, left, top, right, bottom);
        if (!this.isAttached || (t = this.wrappedView) == null) {
            return;
        }
        t.requestLayout();
    }
}
