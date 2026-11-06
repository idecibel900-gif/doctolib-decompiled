package io.didomi.ssl;

import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class o5 implements ViewBinding {
    private final ConstraintLayout a;
    public final AppCompatButton b;
    public final AppCompatButton c;
    public final Flow d;
    public final AppCompatImageView e;

    private o5(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, Flow flow, AppCompatImageView appCompatImageView) {
        this.a = constraintLayout;
        this.b = appCompatButton;
        this.c = appCompatButton2;
        this.d = flow;
        this.e = appCompatImageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static o5 a(View view) {
        int i = R.id.button_purpose_bottom_bar_agree;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R.id.button_purpose_bottom_bar_disagree;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton2 != null) {
                i = R.id.flow_purpose_bottom_bar;
                Flow flow = (Flow) ViewBindings.findChildViewById(view, i);
                if (flow != null) {
                    i = R.id.image_purpose_bottom_bar_logo;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageView != null) {
                        return new o5((ConstraintLayout) view, appCompatButton, appCompatButton2, flow, appCompatImageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
