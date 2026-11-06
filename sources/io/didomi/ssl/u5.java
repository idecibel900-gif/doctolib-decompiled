package io.didomi.ssl;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.didomi.ssl.view.ctv.DidomiTVSwitch;

/* JADX INFO: loaded from: classes5.dex */
public final class u5 implements ViewBinding {
    private final ConstraintLayout a;
    public final DidomiTVSwitch b;
    public final TextView c;
    public final TextView d;

    private u5(ConstraintLayout constraintLayout, DidomiTVSwitch didomiTVSwitch, TextView textView, TextView textView2) {
        this.a = constraintLayout;
        this.b = didomiTVSwitch;
        this.c = textView;
        this.d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static u5 a(View view) {
        int i = R.id.switch_tv_item;
        DidomiTVSwitch didomiTVSwitch = (DidomiTVSwitch) ViewBindings.findChildViewById(view, i);
        if (didomiTVSwitch != null) {
            i = R.id.text_switch_tv_item_subtitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.text_switch_tv_item_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new u5((ConstraintLayout) view, didomiTVSwitch, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
