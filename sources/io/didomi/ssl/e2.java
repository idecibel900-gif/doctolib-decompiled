package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class e2 implements ViewBinding {
    private final FrameLayout a;
    public final FrameLayout b;
    public final FrameLayout c;
    public final View d;

    private e2(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, View view) {
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = frameLayout3;
        this.d = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }

    public static e2 a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static e2 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_activity_tv_notice_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static e2 a(View view) {
        View viewFindChildViewById;
        int i = R.id.container_ctv_notice_primary;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.container_ctv_notice_secondary;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view_ctv_notice_background))) != null) {
                return new e2((FrameLayout) view, frameLayout, frameLayout2, viewFindChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
