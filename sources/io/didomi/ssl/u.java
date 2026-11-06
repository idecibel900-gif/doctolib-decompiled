package io.didomi.ssl;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lio/didomi/sdk/u;", "Landroid/text/method/LinkMovementMethod;", "Landroid/widget/TextView;", "widget", "Landroid/text/Spannable;", "buffer", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "Lkotlin/Function1;", "", "a", "Lkotlin/jvm/functions/Function1;", "listener", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class u extends LinkMovementMethod {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Function1 listener;

    public u(Function1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() != 1) {
            return super.onTouchEvent(widget, buffer, event);
        }
        int x = (((int) event.getX()) - widget.getTotalPaddingLeft()) + widget.getScrollX();
        int y = (((int) event.getY()) - widget.getTotalPaddingTop()) + widget.getScrollY();
        Layout layout = widget.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(y), x);
        URLSpan[] link = (URLSpan[]) buffer.getSpans(offsetForHorizontal, offsetForHorizontal, URLSpan.class);
        Intrinsics.checkNotNullExpressionValue(link, "link");
        if (link.length == 0) {
            return super.onTouchEvent(widget, buffer, event);
        }
        String url = link[0].getURL();
        Function1 function1 = this.listener;
        Intrinsics.checkNotNullExpressionValue(url, "url");
        if (((Boolean) function1.invoke(url)).booleanValue()) {
            return true;
        }
        return super.onTouchEvent(widget, buffer, event);
    }
}
