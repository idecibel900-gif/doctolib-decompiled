package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.didomi.ssl.view.mobile.HeaderView;

/* JADX INFO: loaded from: classes5.dex */
public final class j3 implements ViewBinding {
    private final ConstraintLayout a;
    public final AppCompatImageButton b;
    public final w5 c;
    public final HeaderView d;
    public final RecyclerView e;
    public final View f;

    private j3(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, w5 w5Var, HeaderView headerView, RecyclerView recyclerView, View view) {
        this.a = constraintLayout;
        this.b = appCompatImageButton;
        this.c = w5Var;
        this.d = headerView;
        this.e = recyclerView;
        this.f = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static j3 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_fragment_vendors, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static j3 a(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.button_vendors_header_close;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.vendors_footer))) != null) {
            w5 w5VarA = w5.a(viewFindChildViewById);
            i = R.id.vendors_header;
            HeaderView headerView = (HeaderView) ViewBindings.findChildViewById(view, i);
            if (headerView != null) {
                i = R.id.vendors_recycler_view;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view_vendors_bottom_divider))) != null) {
                    return new j3((ConstraintLayout) view, appCompatImageButton, w5VarA, headerView, recyclerView, viewFindChildViewById2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
