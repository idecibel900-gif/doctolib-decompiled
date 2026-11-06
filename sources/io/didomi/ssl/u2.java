package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class u2 implements ViewBinding {
    private final ConstraintLayout a;
    public final Button b;
    public final Button c;
    public final Button d;
    public final Button e;
    public final Button f;
    public final Button g;
    public final ImageView h;
    public final TextView i;
    public final View j;
    public final View k;
    public final View l;
    public final View m;

    private u2(ConstraintLayout constraintLayout, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, ImageView imageView, TextView textView, View view, View view2, View view3, View view4) {
        this.a = constraintLayout;
        this.b = button;
        this.c = button2;
        this.d = button3;
        this.e = button4;
        this.f = button5;
        this.g = button6;
        this.h = imageView;
        this.i = textView;
        this.j = view;
        this.k = view2;
        this.l = view3;
        this.m = view4;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static u2 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_fragment_tv_consent_notice, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static u2 a(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        int i = R.id.button_ctv_notice_agree;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.button_ctv_notice_disagree;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.button_ctv_notice_learn_more;
                Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                if (button3 != null) {
                    i = R.id.button_ctv_notice_partners;
                    Button button4 = (Button) ViewBindings.findChildViewById(view, i);
                    if (button4 != null) {
                        i = R.id.button_ctv_notice_privacy;
                        Button button5 = (Button) ViewBindings.findChildViewById(view, i);
                        if (button5 != null) {
                            i = R.id.button_ctv_notice_select;
                            Button button6 = (Button) ViewBindings.findChildViewById(view, i);
                            if (button6 != null) {
                                i = R.id.image_ctv_notice_logo;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null) {
                                    i = R.id.text_ctv_notice_content;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view_ctv_notice_divider))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view_ctv_notice_side_end))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.view_ctv_notice_side_main))) != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.view_ctv_notice_side_main_shadow))) != null) {
                                        return new u2((ConstraintLayout) view, button, button2, button3, button4, button5, button6, imageView, textView, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4);
                                    }
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
