package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class l2 implements ViewBinding {
    private final LinearLayout a;
    public final AppCompatButton b;
    public final ImageView c;
    public final ScrollView d;
    public final ViewStub e;
    public final ViewStub f;
    public final ViewStub g;
    public final ViewStub h;
    public final TextView i;
    public final TextView j;
    public final ConstraintLayout k;

    private l2(LinearLayout linearLayout, AppCompatButton appCompatButton, ImageView imageView, ScrollView scrollView, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3, ViewStub viewStub4, TextView textView, TextView textView2, ConstraintLayout constraintLayout) {
        this.a = linearLayout;
        this.b = appCompatButton;
        this.c = imageView;
        this.d = scrollView;
        this.e = viewStub;
        this.f = viewStub2;
        this.g = viewStub3;
        this.h = viewStub4;
        this.i = textView;
        this.j = textView2;
        this.k = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static l2 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_fragment_consent_notice, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static l2 a(View view) {
        int i = R.id.button_notice_vendor_link;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R.id.image_notice_logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.scroll_notice;
                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                if (scrollView != null) {
                    i = R.id.stub_notice_footer;
                    ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i);
                    if (viewStub != null) {
                        i = R.id.stub_notice_footer_sticky;
                        ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, i);
                        if (viewStub2 != null) {
                            i = R.id.stub_notice_header;
                            ViewStub viewStub3 = (ViewStub) ViewBindings.findChildViewById(view, i);
                            if (viewStub3 != null) {
                                i = R.id.stub_notice_header_sticky;
                                ViewStub viewStub4 = (ViewStub) ViewBindings.findChildViewById(view, i);
                                if (viewStub4 != null) {
                                    i = R.id.text_notice_content;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.text_notice_title;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.view_notice_content;
                                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout != null) {
                                                return new l2((LinearLayout) view, appCompatButton, imageView, scrollView, viewStub, viewStub2, viewStub3, viewStub4, textView, textView2, constraintLayout);
                                            }
                                        }
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
