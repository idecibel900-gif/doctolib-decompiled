package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.didomi.ssl.view.ctv.DidomiTVSwitch;

/* JADX INFO: loaded from: classes5.dex */
public final class r4 implements ViewBinding {
    private final ConstraintLayout a;
    public final DidomiTVSwitch b;
    public final TextView c;
    public final TextView d;

    private r4(ConstraintLayout constraintLayout, DidomiTVSwitch didomiTVSwitch, TextView textView, TextView textView2) {
        this.a = constraintLayout;
        this.b = didomiTVSwitch;
        this.c = textView;
        this.d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static r4 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_holder_tv_vendor_bulk, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static r4 a(View view) {
        int i = R.id.switch_ctv_vendor_bulk;
        DidomiTVSwitch didomiTVSwitch = (DidomiTVSwitch) ViewBindings.findChildViewById(view, i);
        if (didomiTVSwitch != null) {
            i = R.id.text_ctv_vendor_bulk_status;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.text_ctv_vendor_bulk_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new r4((ConstraintLayout) view, didomiTVSwitch, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
