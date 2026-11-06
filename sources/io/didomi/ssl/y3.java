package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes5.dex */
public final class y3 implements ViewBinding {
    private final View a;

    private y3(View view) {
        this.a = view;
    }

    public static y3 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_tv_purpose_additional_info_header, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.a;
    }

    public static y3 a(View view) {
        if (view != null) {
            return new y3(view);
        }
        throw new NullPointerException("rootView");
    }
}
