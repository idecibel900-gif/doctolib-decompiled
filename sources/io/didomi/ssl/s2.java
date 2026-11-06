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
public final class s2 implements ViewBinding {
    private final ConstraintLayout a;
    public final AppCompatImageButton b;
    public final HeaderView c;
    public final RecyclerView d;
    public final PurposeSaveView e;
    public final View f;

    private s2(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, HeaderView headerView, RecyclerView recyclerView, PurposeSaveView purposeSaveView, View view) {
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

    public static s2 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_fragment_sensitive_personal_info, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static s2 a(View view) {
        View viewFindChildViewById;
        int i = R.id.button_spi_close;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.header_spi;
            HeaderView headerView = (HeaderView) ViewBindings.findChildViewById(view, i);
            if (headerView != null) {
                i = R.id.list_spi;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    i = R.id.save_spi;
                    PurposeSaveView purposeSaveView = (PurposeSaveView) ViewBindings.findChildViewById(view, i);
                    if (purposeSaveView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view_spi_bottom_divider))) != null) {
                        return new s2((ConstraintLayout) view, appCompatImageButton, headerView, recyclerView, purposeSaveView, viewFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
