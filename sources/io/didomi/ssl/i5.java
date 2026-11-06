package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes5.dex */
public final class i5 implements ViewBinding {
    private final AppCompatButton a;

    private i5(AppCompatButton appCompatButton) {
        this.a = appCompatButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AppCompatButton getRoot() {
        return this.a;
    }

    public static i5 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_view_additional_data_processing_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static i5 a(View view) {
        if (view != null) {
            return new i5((AppCompatButton) view);
        }
        throw new NullPointerException("rootView");
    }
}
