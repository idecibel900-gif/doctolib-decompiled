package io.didomi.ssl;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class w5 implements ViewBinding {
    private final ConstraintLayout a;
    public final Button b;
    public final AppCompatImageView c;
    public final TextView d;

    private w5(ConstraintLayout constraintLayout, Button button, AppCompatImageView appCompatImageView, TextView textView) {
        this.a = constraintLayout;
        this.b = button;
        this.c = appCompatImageView;
        this.d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static w5 a(View view) {
        int i = R.id.button_save;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.vendor_logo_bottom_bar;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.vendors_subtext;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new w5((ConstraintLayout) view, button, appCompatImageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
