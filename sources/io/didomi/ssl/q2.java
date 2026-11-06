package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.didomi.ssl.purpose.mobile.PurposeSaveView;
import io.didomi.ssl.view.mobile.HeaderView;

/* JADX INFO: loaded from: classes5.dex */
public final class q2 implements ViewBinding {
    private final ConstraintLayout a;
    public final AppCompatImageButton b;
    public final HeaderView c;
    public final RecyclerView d;
    public final PurposeSaveView e;
    public final View f;

    private q2(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, HeaderView headerView, RecyclerView recyclerView, PurposeSaveView purposeSaveView, View view) {
        this.a = constraintLayout;
        this.b = appCompatImageButton;
        this.c = headerView;
        this.d = recyclerView;
        this.e = purposeSaveView;
        this.f = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static q2 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_fragment_purposes_category, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static q2 a(View view) {
        View viewFindChildViewById;
        int i = R.id.button_purposes_category_close;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.header_purposes_category;
            HeaderView headerView = (HeaderView) ViewBindings.findChildViewById(view, i);
            if (headerView != null) {
                i = R.id.list_purposes_category;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    i = R.id.save_purposes_category;
                    PurposeSaveView purposeSaveView = (PurposeSaveView) ViewBindings.findChildViewById(view, i);
                    if (purposeSaveView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view_purpose_category_bottom_divider))) != null) {
                        return new q2((ConstraintLayout) view, appCompatImageButton, headerView, recyclerView, purposeSaveView, viewFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
