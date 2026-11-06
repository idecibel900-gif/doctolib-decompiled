package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.didomi.ssl.purpose.mobile.PurposeSaveView;
import io.didomi.ssl.view.mobile.DidomiToggle;
import io.didomi.ssl.view.mobile.HeaderView;

/* JADX INFO: loaded from: classes5.dex */
public final class n2 implements ViewBinding {
    private final ConstraintLayout a;
    public final AppCompatImageButton b;
    public final AppCompatButton c;
    public final AppCompatButton d;
    public final Group e;
    public final Group f;
    public final HeaderView g;
    public final PurposeSaveView h;
    public final ScrollView i;
    public final DidomiToggle j;
    public final DidomiToggle k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final View q;
    public final View r;
    public final p5 s;
    public final View t;

    private n2(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, Group group, Group group2, HeaderView headerView, PurposeSaveView purposeSaveView, ScrollView scrollView, DidomiToggle didomiToggle, DidomiToggle didomiToggle2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view, View view2, p5 p5Var, View view3) {
        this.a = constraintLayout;
        this.b = appCompatImageButton;
        this.c = appCompatButton;
        this.d = appCompatButton2;
        this.e = group;
        this.f = group2;
        this.g = headerView;
        this.h = purposeSaveView;
        this.i = scrollView;
        this.j = didomiToggle;
        this.k = didomiToggle2;
        this.l = textView;
        this.m = textView2;
        this.n = textView3;
        this.o = textView4;
        this.p = textView5;
        this.q = view;
        this.r = view2;
        this.s = p5Var;
        this.t = view3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static n2 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_fragment_purpose_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static n2 a(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        int i = R.id.button_purpose_detail_close;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.button_purpose_detail_consent_vendors_count;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton != null) {
                i = R.id.button_purpose_detail_legitimate_interest_vendors_count;
                AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
                if (appCompatButton2 != null) {
                    i = R.id.group_purpose_detail_consent;
                    Group group = (Group) ViewBindings.findChildViewById(view, i);
                    if (group != null) {
                        i = R.id.group_purpose_detail_legitimate_interest;
                        Group group2 = (Group) ViewBindings.findChildViewById(view, i);
                        if (group2 != null) {
                            i = R.id.header_purpose_detail;
                            HeaderView headerView = (HeaderView) ViewBindings.findChildViewById(view, i);
                            if (headerView != null) {
                                i = R.id.save_purpose_detail;
                                PurposeSaveView purposeSaveView = (PurposeSaveView) ViewBindings.findChildViewById(view, i);
                                if (purposeSaveView != null) {
                                    i = R.id.scroll_purpose_detail;
                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                    if (scrollView != null) {
                                        i = R.id.switch_purpose_detail_consent;
                                        DidomiToggle didomiToggle = (DidomiToggle) ViewBindings.findChildViewById(view, i);
                                        if (didomiToggle != null) {
                                            i = R.id.switch_purpose_detail_legitimate_interest;
                                            DidomiToggle didomiToggle2 = (DidomiToggle) ViewBindings.findChildViewById(view, i);
                                            if (didomiToggle2 != null) {
                                                i = R.id.text_purpose_detail_consent_title;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null) {
                                                    i = R.id.text_purpose_detail_description;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = R.id.text_purpose_detail_description_legal;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R.id.text_purpose_detail_legitimate_interest_title;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.text_purpose_detail_title;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view_purpose_detail_bottom_divider))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view_purpose_detail_consent_divider))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.view_purpose_detail_illustrations))) != null) {
                                                                    p5 p5VarA = p5.a(viewFindChildViewById3);
                                                                    i = R.id.view_purpose_detail_legitimate_interest_divider;
                                                                    View viewFindChildViewById4 = ViewBindings.findChildViewById(view, i);
                                                                    if (viewFindChildViewById4 != null) {
                                                                        return new n2((ConstraintLayout) view, appCompatImageButton, appCompatButton, appCompatButton2, group, group2, headerView, purposeSaveView, scrollView, didomiToggle, didomiToggle2, textView, textView2, textView3, textView4, textView5, viewFindChildViewById, viewFindChildViewById2, p5VarA, viewFindChildViewById4);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
