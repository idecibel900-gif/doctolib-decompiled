package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class d3 implements ViewBinding {
    private final ConstraintLayout a;
    public final Button b;
    public final View c;
    public final ConstraintLayout d;
    public final ViewStub e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final LinearLayout j;

    private d3(ConstraintLayout constraintLayout, Button button, View view, ConstraintLayout constraintLayout2, ViewStub viewStub, TextView textView, TextView textView2, TextView textView3, TextView textView4, LinearLayout linearLayout) {
        this.a = constraintLayout;
        this.b = button;
        this.c = view;
        this.d = constraintLayout2;
        this.e = viewStub;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
        this.j = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static d3 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_fragment_tv_vendor_data, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static d3 a(View view) {
        View viewFindChildViewById;
        int i = R.id.button_ctv_vendor_data_read_more;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.divider_ctv_vendor_data))) != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.stub_ctv_vendor_data;
            ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i);
            if (viewStub != null) {
                i = R.id.text_ctv_vendor_data_iabtcf_tag;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.text_ctv_vendor_data_purposes;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.text_ctv_vendor_data_subtitle;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.text_ctv_vendor_data_title;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.text_ctv_vendor_data_title_container;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    return new d3(constraintLayout, button, viewFindChildViewById, constraintLayout, viewStub, textView, textView2, textView3, textView4, linearLayout);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
