package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.didomi.ssl.view.mobile.DidomiToggle;
import io.didomi.ssl.view.mobile.HeaderView;

/* JADX INFO: loaded from: classes5.dex */
public final class i3 implements ViewBinding {
    public final DidomiToggle A;
    public final TextView B;
    public final View C;
    public final AppCompatButton D;
    public final TextView E;
    public final NestedScrollView F;
    public final TextView G;
    public final w5 H;
    public final View I;
    private final ConstraintLayout a;
    public final AppCompatImageButton b;
    public final LinearLayout c;
    public final View d;
    public final TextView e;
    public final Group f;
    public final LinearLayout g;
    public final DidomiToggle h;
    public final TextView i;
    public final View j;
    public final TextView k;
    public final TextView l;
    public final LinearLayout m;
    public final View n;
    public final TextView o;
    public final HeaderView p;
    public final TextView q;
    public final RecyclerView r;
    public final ProgressBar s;
    public final LinearLayout t;
    public final View u;
    public final TextView v;
    public final AppCompatButton w;
    public final AppCompatButton x;
    public final Group y;
    public final LinearLayout z;

    private i3(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, LinearLayout linearLayout, View view, TextView textView, Group group, LinearLayout linearLayout2, DidomiToggle didomiToggle, TextView textView2, View view2, TextView textView3, TextView textView4, LinearLayout linearLayout3, View view3, TextView textView5, HeaderView headerView, TextView textView6, RecyclerView recyclerView, ProgressBar progressBar, LinearLayout linearLayout4, View view4, TextView textView7, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, Group group2, LinearLayout linearLayout5, DidomiToggle didomiToggle2, TextView textView8, View view5, AppCompatButton appCompatButton3, TextView textView9, NestedScrollView nestedScrollView, TextView textView10, w5 w5Var, View view6) {
        this.a = constraintLayout;
        this.b = appCompatImageButton;
        this.c = linearLayout;
        this.d = view;
        this.e = textView;
        this.f = group;
        this.g = linearLayout2;
        this.h = didomiToggle;
        this.i = textView2;
        this.j = view2;
        this.k = textView3;
        this.l = textView4;
        this.m = linearLayout3;
        this.n = view3;
        this.o = textView5;
        this.p = headerView;
        this.q = textView6;
        this.r = recyclerView;
        this.s = progressBar;
        this.t = linearLayout4;
        this.u = view4;
        this.v = textView7;
        this.w = appCompatButton;
        this.x = appCompatButton2;
        this.y = group2;
        this.z = linearLayout5;
        this.A = didomiToggle2;
        this.B = textView8;
        this.C = view5;
        this.D = appCompatButton3;
        this.E = textView9;
        this.F = nestedScrollView;
        this.G = textView10;
        this.H = w5Var;
        this.I = view6;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static i3 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_fragment_vendor_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static i3 a(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        View viewFindChildViewById5;
        View viewFindChildViewById6;
        int i = R.id.button_vendor_detail_header_close;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.vendor_additional_dataprocessing_list;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.vendor_additional_dataprocessing_separator))) != null) {
                i = R.id.vendor_additional_dataprocessing_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.vendor_consent_dataprocessing_header;
                    Group group = (Group) ViewBindings.findChildViewById(view, i);
                    if (group != null) {
                        i = R.id.vendor_consent_dataprocessing_list;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = R.id.vendor_consent_dataprocessing_switch;
                            DidomiToggle didomiToggle = (DidomiToggle) ViewBindings.findChildViewById(view, i);
                            if (didomiToggle != null) {
                                i = R.id.vendor_consent_dataprocessing_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.vendor_consent_separator))) != null) {
                                    i = R.id.vendor_cookies_section_disclaimer;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.vendor_cookies_section_title;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.vendor_data_categories_list;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout3 != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.vendor_data_categories_separator))) != null) {
                                                i = R.id.vendor_data_categories_title;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.vendor_detail_header;
                                                    HeaderView headerView = (HeaderView) ViewBindings.findChildViewById(view, i);
                                                    if (headerView != null) {
                                                        i = R.id.vendor_device_storage_disclosures_link;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            i = R.id.vendor_device_storage_disclosures_list;
                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                            if (recyclerView != null) {
                                                                i = R.id.vendor_device_storage_disclosures_loader;
                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                if (progressBar != null) {
                                                                    i = R.id.vendor_essential_purposes_list;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout4 != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.vendor_essential_purposes_separator))) != null) {
                                                                        i = R.id.vendor_essential_purposes_title;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView7 != null) {
                                                                            i = R.id.vendor_iab_tcf_link;
                                                                            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
                                                                            if (appCompatButton != null) {
                                                                                i = R.id.vendor_leg_int_claim_link;
                                                                                AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
                                                                                if (appCompatButton2 != null) {
                                                                                    i = R.id.vendor_li_dataprocessing_header;
                                                                                    Group group2 = (Group) ViewBindings.findChildViewById(view, i);
                                                                                    if (group2 != null) {
                                                                                        i = R.id.vendor_li_dataprocessing_list;
                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout5 != null) {
                                                                                            i = R.id.vendor_li_dataprocessing_switch;
                                                                                            DidomiToggle didomiToggle2 = (DidomiToggle) ViewBindings.findChildViewById(view, i);
                                                                                            if (didomiToggle2 != null) {
                                                                                                i = R.id.vendor_li_dataprocessing_title;
                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView8 != null && (viewFindChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.vendor_li_separator))) != null) {
                                                                                                    i = R.id.vendor_privacy_link;
                                                                                                    AppCompatButton appCompatButton3 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
                                                                                                    if (appCompatButton3 != null) {
                                                                                                        i = R.id.vendor_privacy_policy_disclaimer;
                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView9 != null) {
                                                                                                            i = R.id.vendor_scroll_view;
                                                                                                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (nestedScrollView != null) {
                                                                                                                i = R.id.vendor_title;
                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView10 != null && (viewFindChildViewById6 = ViewBindings.findChildViewById(view, (i = R.id.vendors_footer))) != null) {
                                                                                                                    w5 w5VarA = w5.a(viewFindChildViewById6);
                                                                                                                    i = R.id.view_vendors_bottom_divider;
                                                                                                                    View viewFindChildViewById7 = ViewBindings.findChildViewById(view, i);
                                                                                                                    if (viewFindChildViewById7 != null) {
                                                                                                                        return new i3((ConstraintLayout) view, appCompatImageButton, linearLayout, viewFindChildViewById, textView, group, linearLayout2, didomiToggle, textView2, viewFindChildViewById2, textView3, textView4, linearLayout3, viewFindChildViewById3, textView5, headerView, textView6, recyclerView, progressBar, linearLayout4, viewFindChildViewById4, textView7, appCompatButton, appCompatButton2, group2, linearLayout5, didomiToggle2, textView8, viewFindChildViewById5, appCompatButton3, textView9, nestedScrollView, textView10, w5VarA, viewFindChildViewById7);
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
