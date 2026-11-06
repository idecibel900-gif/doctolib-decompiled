package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class r2 implements ViewBinding {
    private final ScrollView a;
    public final ConstraintLayout b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;

    private r2(ScrollView scrollView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.a = scrollView;
        this.b = constraintLayout;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
        this.h = textView6;
        this.i = textView7;
        this.j = textView8;
        this.k = textView9;
        this.l = textView10;
        this.m = textView11;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.a;
    }

    public static r2 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_fragment_selected_disclosure_content, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static r2 a(View view) {
        int i = R.id.disclosure_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.disclosure_domain;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.disclosure_domain_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.disclosure_expiration;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.disclosure_expiration_title;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.disclosure_name;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = R.id.disclosure_name_title;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    i = R.id.disclosure_purposes;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView7 != null) {
                                        i = R.id.disclosure_purposes_title;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView8 != null) {
                                            i = R.id.disclosure_title;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView9 != null) {
                                                i = R.id.disclosure_type;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView10 != null) {
                                                    i = R.id.disclosure_type_title;
                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView11 != null) {
                                                        return new r2((ScrollView) view, constraintLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
