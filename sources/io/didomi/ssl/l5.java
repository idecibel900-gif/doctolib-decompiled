package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class l5 implements ViewBinding {
    private final LinearLayout a;
    public final TextView b;
    public final TextView c;

    private l5(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.a = linearLayout;
        this.b = textView;
        this.c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static l5 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_view_data_category, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static l5 a(View view) {
        int i = R.id.text_data_category_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.text_data_category_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                return new l5((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
