package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.didomi.ssl.view.mobile.DidomiToggle;

/* JADX INFO: loaded from: classes5.dex */
public final class f5 implements ViewBinding {
    private final LinearLayout a;
    public final AppCompatImageView b;
    public final TextView c;
    public final DidomiToggle d;

    private f5(LinearLayout linearLayout, AppCompatImageView appCompatImageView, TextView textView, DidomiToggle didomiToggle) {
        this.a = linearLayout;
        this.b = appCompatImageView;
        this.c = textView;
        this.d = didomiToggle;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static f5 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_vendors_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static f5 a(View view) {
        int i = R.id.image_vendor_item;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.text_vendor_item;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.toggle_vendor_item;
                DidomiToggle didomiToggle = (DidomiToggle) ViewBindings.findChildViewById(view, i);
                if (didomiToggle != null) {
                    return new f5((LinearLayout) view, appCompatImageView, textView, didomiToggle);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
