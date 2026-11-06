package io.didomi.ssl;

import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class j5 implements ViewBinding {
    private final ConstraintLayout a;
    public final AppCompatButton b;
    public final AppCompatButton c;
    public final AppCompatButton d;
    public final AppCompatButton e;
    public final Flow f;

    private j5(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, AppCompatButton appCompatButton3, AppCompatButton appCompatButton4, Flow flow) {
        this.a = constraintLayout;
        this.b = appCompatButton;
        this.c = appCompatButton2;
        this.d = appCompatButton3;
        this.e = appCompatButton4;
        this.f = flow;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static j5 a(View view) {
        int i = R.id.button_notice_footer_agree;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R.id.button_notice_footer_disagree;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton2 != null) {
                i = R.id.button_notice_footer_learn_more;
                AppCompatButton appCompatButton3 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
                if (appCompatButton3 != null) {
                    i = R.id.button_notice_footer_manage_spi_choices;
                    AppCompatButton appCompatButton4 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
                    if (appCompatButton4 != null) {
                        i = R.id.flow_notice_footer;
                        Flow flow = (Flow) ViewBindings.findChildViewById(view, i);
                        if (flow != null) {
                            return new j5((ConstraintLayout) view, appCompatButton, appCompatButton2, appCompatButton3, appCompatButton4, flow);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
