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
public final class m3 implements ViewBinding {
    private final LinearLayout a;
    public final DidomiToggle b;
    public final TextView c;

    private m3(LinearLayout linearLayout, DidomiToggle didomiToggle, TextView textView) {
        this.a = linearLayout;
        this.b = didomiToggle;
        this.c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static m3 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_purpose_bulk_action, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static m3 a(View view) {
        int i = R.id.switch_holder_purpose_bulk;
        DidomiToggle didomiToggle = (DidomiToggle) ViewBindings.findChildViewById(view, i);
        if (didomiToggle != null) {
            i = R.id.text_holder_purpose_bulk_label;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new m3((LinearLayout) view, didomiToggle, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
