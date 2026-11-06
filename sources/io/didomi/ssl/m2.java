package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.didomi.ssl.view.mobile.HeaderView;

/* JADX INFO: loaded from: classes5.dex */
public final class m2 implements ViewBinding {
    private final ConstraintLayout a;
    public final AppCompatImageButton b;
    public final HeaderView c;
    public final Button d;
    public final Button e;
    public final FrameLayout f;
    public final View g;

    private m2(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, HeaderView headerView, Button button, Button button2, FrameLayout frameLayout, View view) {
        this.a = constraintLayout;
        this.b = appCompatImageButton;
        this.c = headerView;
        this.d = button;
        this.e = button2;
        this.f = frameLayout;
        this.g = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static m2 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_fragment_device_storage_disclosure, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static m2 a(View view) {
        View viewFindChildViewById;
        int i = R.id.button_disclosure_header_close;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.disclosure_header;
            HeaderView headerView = (HeaderView) ViewBindings.findChildViewById(view, i);
            if (headerView != null) {
                i = R.id.disclosure_next;
                Button button = (Button) ViewBindings.findChildViewById(view, i);
                if (button != null) {
                    i = R.id.disclosure_previous;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                    if (button2 != null) {
                        i = R.id.selected_disclosure_container;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view_disclosures_bottom_divider))) != null) {
                            return new m2((ConstraintLayout) view, appCompatImageButton, headerView, button, button2, frameLayout, viewFindChildViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
