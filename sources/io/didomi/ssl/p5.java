package io.didomi.ssl;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class p5 implements ViewBinding {
    private final LinearLayout a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final View e;

    private p5(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, View view) {
        this.a = linearLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static p5 a(View view) {
        View viewFindChildViewById;
        int i = R.id.text_purpose_illustration_1;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.text_purpose_illustration_2;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.text_purpose_illustrations_header;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view_purpose_illustrations_divider))) != null) {
                    return new p5((LinearLayout) view, textView, textView2, textView3, viewFindChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
