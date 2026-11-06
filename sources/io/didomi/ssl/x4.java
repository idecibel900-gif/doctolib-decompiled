package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class x4 implements ViewBinding {
    private final ConstraintLayout a;
    public final AppCompatCheckBox b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;

    private x4(ConstraintLayout constraintLayout, AppCompatCheckBox appCompatCheckBox, ImageView imageView, TextView textView, TextView textView2) {
        this.a = constraintLayout;
        this.b = appCompatCheckBox;
        this.c = imageView;
        this.d = textView;
        this.e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static x4 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_tv_vendor_detail_legitimate_interest, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static x4 a(View view) {
        int i = R.id.checkbox_ctv_vendor_detail_legitimate_interest;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(view, i);
        if (appCompatCheckBox != null) {
            i = R.id.image_ctv_vendor_detail_legitimate_interest;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.text_ctv_vendor_detail_legitimate_interest_status;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.text_ctv_vendor_detail_legitimate_interest_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new x4((ConstraintLayout) view, appCompatCheckBox, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
