package io.didomi.ssl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class y2 implements ViewBinding {
    private final ConstraintLayout a;
    public final Button b;
    public final u5 c;
    public final t5 d;
    public final ConstraintLayout e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final View i;

    private y2(ConstraintLayout constraintLayout, Button button, u5 u5Var, t5 t5Var, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, View view) {
        this.a = constraintLayout;
        this.b = button;
        this.c = u5Var;
        this.d = t5Var;
        this.e = constraintLayout2;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static y2 a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.didomi_fragment_tv_purpose_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public static y2 a(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.button_ctv_purpose_detail_read_more;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.include_ctv_purpose_detail_consent))) != null) {
            u5 u5VarA = u5.a(viewFindChildViewById);
            i = R.id.include_ctv_purpose_detail_legitimate_interest;
            View viewFindChildViewById3 = ViewBindings.findChildViewById(view, i);
            if (viewFindChildViewById3 != null) {
                t5 t5VarA = t5.a(viewFindChildViewById3);
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.text_ctv_purpose_detail_description;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.text_ctv_purpose_detail_settings_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.text_ctv_purpose_detail_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view_ctv_purpose_detail_divider))) != null) {
                            return new y2(constraintLayout, button, u5VarA, t5VarA, constraintLayout, textView, textView2, textView3, viewFindChildViewById2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
