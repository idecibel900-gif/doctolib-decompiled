package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes5.dex */
public final class g4 implements ViewBinding {
    private final View a;

    private g4(View view) {
        this.a = view;
    }

    public static g4 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_tv_purpose_header, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.a;
    }

    public static g4 a(View view) {
        if (view != null) {
            return new g4(view);
        }
        throw new NullPointerException("rootView");
    }
}
