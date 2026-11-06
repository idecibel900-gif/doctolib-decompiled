package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class b4 implements ViewBinding {
    private final LinearLayout a;
    public final Button b;
    public final TextView c;
    public final View d;

    private b4(LinearLayout linearLayout, Button button, TextView textView, View view) {
        this.a = linearLayout;
        this.b = button;
        this.c = textView;
        this.d = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static b4 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_tv_purpose_additional_info_vendors_count, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static b4 a(View view) {
        View viewFindChildViewById;
        int i = R.id.button_ctv_purpose_additional_info_vendors_count;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.text_ctv_purpose_additional_info_vendors_count_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view_ctv_purpose_detail_divider))) != null) {
                return new b4((LinearLayout) view, button, textView, viewFindChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
