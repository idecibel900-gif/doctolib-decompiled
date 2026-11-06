package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class s5 implements ViewBinding {
    private final FrameLayout a;
    public final FrameLayout b;
    public final View c;
    public final ImageView d;

    private s5(FrameLayout frameLayout, FrameLayout frameLayout2, View view, ImageView imageView) {
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = view;
        this.d = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }

    public static s5 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_view_toggle, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static s5 a(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.image_toggle_background;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (viewFindChildViewById != null) {
            i = R.id.image_toggle_button;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                return new s5(frameLayout, frameLayout, viewFindChildViewById, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
