package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.didomi.ssl.view.ctv.DidomiTVSwitch;

/* JADX INFO: loaded from: classes5.dex */
public final class u4 implements ViewBinding {
    private final ConstraintLayout a;
    public final ImageView b;
    public final DidomiTVSwitch c;
    public final TextView d;
    public final TextView e;

    private u4(ConstraintLayout constraintLayout, ImageView imageView, DidomiTVSwitch didomiTVSwitch, TextView textView, TextView textView2) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = didomiTVSwitch;
        this.d = textView;
        this.e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static u4 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_tv_vendor_detail_consent, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static u4 a(View view) {
        int i = R.id.image_ctv_vendor_detail_consent;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.switch_ctv_vendor_detail_consent;
            DidomiTVSwitch didomiTVSwitch = (DidomiTVSwitch) ViewBindings.findChildViewById(view, i);
            if (didomiTVSwitch != null) {
                i = R.id.text_ctv_vendor_detail_consent_status;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.text_ctv_vendor_detail_consent_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new u4((ConstraintLayout) view, imageView, didomiTVSwitch, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
