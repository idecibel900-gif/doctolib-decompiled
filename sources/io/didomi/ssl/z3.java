package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes5.dex */
public final class z3 implements ViewBinding {
    private final TextView a;
    public final TextView b;

    private z3(TextView textView, TextView textView2) {
        this.a = textView;
        this.b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public TextView getRoot() {
        return this.a;
    }

    public static z3 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_tv_purpose_additional_info_subtitle, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static z3 a(View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new z3(textView, textView);
        }
        throw new NullPointerException("rootView");
    }
}
