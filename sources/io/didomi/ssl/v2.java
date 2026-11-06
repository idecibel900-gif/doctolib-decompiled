package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class v2 implements ViewBinding {
    private final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final LinearLayout d;
    public final ScrollView e;
    public final TextSwitcher f;
    public final TextSwitcher g;
    public final TextView h;

    private v2(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ScrollView scrollView, TextSwitcher textSwitcher, TextSwitcher textSwitcher2, TextView textView) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = linearLayout;
        this.e = scrollView;
        this.f = textSwitcher;
        this.g = textSwitcher2;
        this.h = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static v2 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_fragment_tv_data_processing_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static v2 a(View view) {
        int i = R.id.image_ctv_data_processing_detail_left_arrow_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.image_ctv_data_processing_detail_right_arrow_image;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.layout_ctv_data_processing_detail_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.scroll_ctv_data_processing_detail;
                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                    if (scrollView != null) {
                        i = R.id.switcher_ctv_data_processing_detail_description;
                        TextSwitcher textSwitcher = (TextSwitcher) ViewBindings.findChildViewById(view, i);
                        if (textSwitcher != null) {
                            i = R.id.switcher_ctv_data_processing_detail_subtitle;
                            TextSwitcher textSwitcher2 = (TextSwitcher) ViewBindings.findChildViewById(view, i);
                            if (textSwitcher2 != null) {
                                i = R.id.text_ctv_data_processing_detail_title;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    return new v2((ConstraintLayout) view, imageView, imageView2, linearLayout, scrollView, textSwitcher, textSwitcher2, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
