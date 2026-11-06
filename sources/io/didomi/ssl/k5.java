package io.didomi.ssl;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class k5 implements ViewBinding {
    private final FrameLayout a;
    public final AppCompatImageButton b;
    public final AppCompatButton c;

    private k5(FrameLayout frameLayout, AppCompatImageButton appCompatImageButton, AppCompatButton appCompatButton) {
        this.a = frameLayout;
        this.b = appCompatImageButton;
        this.c = appCompatButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }

    public static k5 a(View view) {
        int i = R.id.button_notice_header_disagree_cross;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.button_notice_header_disagree_link;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton != null) {
                return new k5((FrameLayout) view, appCompatImageButton, appCompatButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
