package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.didomi.ssl.view.mobile.DidomiToggle;

/* JADX INFO: loaded from: classes5.dex */
public final class d5 implements ViewBinding {
    private final LinearLayout a;
    public final TextView b;
    public final DidomiToggle c;

    private d5(LinearLayout linearLayout, TextView textView, DidomiToggle didomiToggle) {
        this.a = linearLayout;
        this.b = textView;
        this.c = didomiToggle;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static d5 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_vendors_bulk_action, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static d5 a(View view) {
        int i = R.id.text_vendors_bulk_action;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.toggle_vendors_bulk_action;
            DidomiToggle didomiToggle = (DidomiToggle) ViewBindings.findChildViewById(view, i);
            if (didomiToggle != null) {
                return new d5((LinearLayout) view, textView, didomiToggle);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
