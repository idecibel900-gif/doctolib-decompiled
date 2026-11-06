package io.didomi.ssl;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class t5 implements ViewBinding {
    private final ConstraintLayout a;
    public final AppCompatCheckBox b;
    public final TextView c;
    public final TextView d;

    private t5(ConstraintLayout constraintLayout, AppCompatCheckBox appCompatCheckBox, TextView textView, TextView textView2) {
        this.a = constraintLayout;
        this.b = appCompatCheckBox;
        this.c = textView;
        this.d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static t5 a(View view) {
        int i = R.id.checkbox_tv_item;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(view, i);
        if (appCompatCheckBox != null) {
            i = R.id.text_checkbox_tv_item_subtitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.text_checkbox_tv_item_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new t5((ConstraintLayout) view, appCompatCheckBox, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
