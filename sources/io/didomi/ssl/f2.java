package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class f2 implements ViewBinding {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final v5 c;
    public final View d;

    private f2(ConstraintLayout constraintLayout, FrameLayout frameLayout, v5 v5Var, View view) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = v5Var;
        this.d = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static f2 a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static f2 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_activity_tv_preferences_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static f2 a(View view) {
        View viewFindChildViewById;
        int i = R.id.container_ctv_preferences_secondary;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.include_ctv_preferences_menu))) != null) {
            v5 v5VarA = v5.a(viewFindChildViewById);
            int i2 = R.id.view_ctv_preferences_background;
            View viewFindChildViewById2 = ViewBindings.findChildViewById(view, i2);
            if (viewFindChildViewById2 != null) {
                return new f2((ConstraintLayout) view, frameLayout, v5VarA, viewFindChildViewById2);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
