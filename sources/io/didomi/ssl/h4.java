package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.didomi.ssl.view.ctv.DidomiTVSwitch;

/* JADX INFO: loaded from: classes5.dex */
public final class h4 implements ViewBinding {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final DidomiTVSwitch c;
    public final TextView d;
    public final TextView e;

    private h4(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, DidomiTVSwitch didomiTVSwitch, TextView textView, TextView textView2) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = didomiTVSwitch;
        this.d = textView;
        this.e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static h4 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_tv_purpose_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static h4 a(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.switch_ctv_purpose_item;
        DidomiTVSwitch didomiTVSwitch = (DidomiTVSwitch) ViewBindings.findChildViewById(view, i);
        if (didomiTVSwitch != null) {
            i = R.id.text_ctv_purpose_item_subtitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.text_ctv_purpose_item_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new h4(constraintLayout, constraintLayout, didomiTVSwitch, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
