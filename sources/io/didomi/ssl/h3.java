package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.didomi.ssl.view.mobile.HeaderView;

/* JADX INFO: loaded from: classes5.dex */
public final class h3 implements ViewBinding {
    private final ConstraintLayout a;
    public final AppCompatImageButton b;
    public final AppCompatButton c;
    public final TextView d;
    public final AppCompatImageView e;
    public final TextView f;
    public final HeaderView g;
    public final ScrollView h;
    public final TextView i;

    private h3(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, AppCompatButton appCompatButton, TextView textView, AppCompatImageView appCompatImageView, TextView textView2, HeaderView headerView, ScrollView scrollView, TextView textView3) {
        this.a = constraintLayout;
        this.b = appCompatImageButton;
        this.c = appCompatButton;
        this.d = textView;
        this.e = appCompatImageView;
        this.f = textView2;
        this.g = headerView;
        this.h = scrollView;
        this.i = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static h3 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_fragment_user_info, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static h3 a(View view) {
        int i = R.id.button_user_info_header_close;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.user_info_content_button;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton != null) {
                i = R.id.user_info_content_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.user_info_copied_image;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageView != null) {
                        i = R.id.user_info_copied_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.user_info_header;
                            HeaderView headerView = (HeaderView) ViewBindings.findChildViewById(view, i);
                            if (headerView != null) {
                                i = R.id.user_info_scroll;
                                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                if (scrollView != null) {
                                    i = R.id.user_info_title;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        return new h3((ConstraintLayout) view, appCompatImageButton, appCompatButton, textView, appCompatImageView, textView2, headerView, scrollView, textView3);
                                    }
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
