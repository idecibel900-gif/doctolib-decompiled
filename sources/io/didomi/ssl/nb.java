package io.didomi.ssl;

import android.graphics.Rect;
import android.view.View;
import android.widget.ScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"Landroid/widget/ScrollView;", "Landroid/view/View;", "children", "", "a", "android_release"}, k = 2, mv = {1, 8, 0})
public final class nb {
    public static final boolean a(ScrollView scrollView, View children) {
        Intrinsics.checkNotNullParameter(scrollView, "<this>");
        Intrinsics.checkNotNullParameter(children, "children");
        Rect rect = new Rect();
        scrollView.getDrawingRect(rect);
        return rect.bottom >= ((int) (children.getY() + ((float) children.getHeight())));
    }
}
