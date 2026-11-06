package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class y4 implements ViewBinding {
    private final LinearLayout a;
    public final TextView b;
    public final View c;

    private y4(LinearLayout linearLayout, TextView textView, View view) {
        this.a = linearLayout;
        this.b = textView;
        this.c = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static y4 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_tv_vendor_detail_section_title, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static y4 a(View view) {
        View viewFindChildViewById;
        int i = R.id.text_ctv_vendor_detail_section_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view_ctv_vendor_detail_section_title_divider))) != null) {
            return new y4((LinearLayout) view, textView, viewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
