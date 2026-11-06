package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.didomi.ssl.purpose.mobile.PurposeSaveView;
import io.didomi.ssl.view.mobile.HeaderView;

/* JADX INFO: loaded from: classes5.dex */
public final class p2 implements ViewBinding {
    private final ConstraintLayout a;
    public final AppCompatImageButton b;
    public final HeaderView c;
    public final o5 d;
    public final FrameLayout e;
    public final RecyclerView f;
    public final PurposeSaveView g;
    public final TextView h;
    public final View i;

    private p2(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, HeaderView headerView, o5 o5Var, FrameLayout frameLayout, RecyclerView recyclerView, PurposeSaveView purposeSaveView, TextView textView, View view) {
        this.a = constraintLayout;
        this.b = appCompatImageButton;
        this.c = headerView;
        this.d = o5Var;
        this.e = frameLayout;
        this.f = recyclerView;
        this.g = purposeSaveView;
        this.h = textView;
        this.i = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static p2 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_fragment_purposes, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static p2 a(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.button_purposes_close;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.header_purposes;
            HeaderView headerView = (HeaderView) ViewBindings.findChildViewById(view, i);
            if (headerView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.layout_purposes_agree_disagree))) != null) {
                o5 o5VarA = o5.a(viewFindChildViewById);
                i = R.id.layout_purposes_bottom_bars;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = R.id.list_purposes;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R.id.save_purposes;
                        PurposeSaveView purposeSaveView = (PurposeSaveView) ViewBindings.findChildViewById(view, i);
                        if (purposeSaveView != null) {
                            i = R.id.text_purposes_scroll_indicator;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view_purposes_bottom_divider))) != null) {
                                return new p2((ConstraintLayout) view, appCompatImageButton, headerView, o5VarA, frameLayout, recyclerView, purposeSaveView, textView, viewFindChildViewById2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
