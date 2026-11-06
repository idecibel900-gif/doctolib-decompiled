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
public final class e5 implements ViewBinding {
    private final LinearLayout a;
    public final AppCompatButton b;
    public final TextView c;
    public final TextView d;

    private e5(LinearLayout linearLayout, AppCompatButton appCompatButton, TextView textView, TextView textView2) {
        this.a = linearLayout;
        this.b = appCompatButton;
        this.c = textView;
        this.d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static e5 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_vendors_header, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static e5 a(View view) {
        int i = R.id.image_button_vendors_header_user_info;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R.id.text_vendors_header_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.text_vendors_header_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new e5((LinearLayout) view, appCompatButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
