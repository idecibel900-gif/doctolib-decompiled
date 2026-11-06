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
public final class q3 implements ViewBinding {
    private final LinearLayout a;
    public final AppCompatImageView b;
    public final DidomiToggle c;
    public final TextView d;
    public final TextView e;

    private q3(LinearLayout linearLayout, AppCompatImageView appCompatImageView, DidomiToggle didomiToggle, TextView textView, TextView textView2) {
        this.a = linearLayout;
        this.b = appCompatImageView;
        this.c = didomiToggle;
        this.d = textView;
        this.e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static q3 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_purpose_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static q3 a(View view) {
        int i = R.id.image_holder_purpose_item_arrow;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.switch_holder_purpose_item;
            DidomiToggle didomiToggle = (DidomiToggle) ViewBindings.findChildViewById(view, i);
            if (didomiToggle != null) {
                i = R.id.text_holder_purpose_item_essential_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.text_holder_purpose_item_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new q3((LinearLayout) view, appCompatImageView, didomiToggle, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
