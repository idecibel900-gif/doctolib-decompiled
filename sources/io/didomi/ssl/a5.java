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
public final class a5 implements ViewBinding {
    private final ConstraintLayout a;
    public final ImageView b;
    public final ConstraintLayout c;
    public final DidomiTVSwitch d;
    public final TextView e;
    public final TextView f;
    public final TextView g;

    private a5(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, DidomiTVSwitch didomiTVSwitch, TextView textView, TextView textView2, TextView textView3) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = constraintLayout2;
        this.d = didomiTVSwitch;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static a5 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_tv_vendor_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static a5 a(View view) {
        int i = R.id.image_ctv_vendor_item;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.switch_ctv_vendor_item;
            DidomiTVSwitch didomiTVSwitch = (DidomiTVSwitch) ViewBindings.findChildViewById(view, i);
            if (didomiTVSwitch != null) {
                i = R.id.text_ctv_vendor_item_iabtcf_tag;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.text_ctv_vendor_item_status;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.text_ctv_vendor_item_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new a5(constraintLayout, imageView, constraintLayout, didomiTVSwitch, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
