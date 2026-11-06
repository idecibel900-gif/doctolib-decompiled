package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class p3 implements ViewBinding {
    private final LinearLayout a;
    public final TextView b;
    public final AppCompatButton c;

    private p3(LinearLayout linearLayout, TextView textView, AppCompatButton appCompatButton) {
        this.a = linearLayout;
        this.b = textView;
        this.c = appCompatButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static p3 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_purpose_header, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static p3 a(View view) {
        int i = R.id.purpose_list_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.purpose_privacy_policy_link;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton != null) {
                return new p3((LinearLayout) view, textView, appCompatButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
