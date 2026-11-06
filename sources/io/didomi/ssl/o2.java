package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class o2 implements ViewBinding {
    private final ConstraintLayout a;
    public final AppCompatImageButton b;
    public final TextView c;
    public final TextView d;
    public final RecyclerView e;
    public final TextView f;

    private o2(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, TextView textView, TextView textView2, RecyclerView recyclerView, TextView textView3) {
        this.a = constraintLayout;
        this.b = appCompatImageButton;
        this.c = textView;
        this.d = textView2;
        this.e = recyclerView;
        this.f = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static o2 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_fragment_purpose_vendors, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static o2 a(View view) {
        int i = R.id.button_purpose_vendors_close;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
        if (appCompatImageButton != null) {
            i = R.id.button_purpose_vendors_iab_count;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.button_purpose_vendors_non_iab_count;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.list_purpose_vendors;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R.id.text_purpose_vendors_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new o2((ConstraintLayout) view, appCompatImageButton, textView, textView2, recyclerView, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
