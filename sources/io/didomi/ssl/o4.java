package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes5.dex */
public final class o4 implements ViewBinding {
    private final View a;

    private o4(View view) {
        this.a = view;
    }

    public static o4 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_tv_vendor_additional_info_footer, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.a;
    }

    public static o4 a(View view) {
        if (view != null) {
            return new o4(view);
        }
        throw new NullPointerException("rootView");
    }
}
