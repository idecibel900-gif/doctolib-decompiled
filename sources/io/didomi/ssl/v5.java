package io.didomi.ssl;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: classes5.dex */
public final class v5 implements ViewBinding {
    private final ConstraintLayout a;
    public final Button b;
    public final Button c;
    public final Button d;
    public final Button e;
    public final Button f;
    public final FrameLayout g;
    public final ImageView h;
    public final View i;
    public final View j;

    private v5(ConstraintLayout constraintLayout, Button button, Button button2, Button button3, Button button4, Button button5, FrameLayout frameLayout, ImageView imageView, View view, View view2) {
        this.a = constraintLayout;
        this.b = button;
        this.c = button2;
        this.d = button3;
        this.e = button4;
        this.f = button5;
        this.g = frameLayout;
        this.h = imageView;
        this.i = view;
        this.j = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }

    public static v5 a(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.button_ctv_preferences_agree;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.button_ctv_preferences_disagree;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.button_ctv_preferences_save;
                Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                if (button3 != null) {
                    i = R.id.button_ctv_preferences_tab_purpose;
                    Button button4 = (Button) ViewBindings.findChildViewById(view, i);
                    if (button4 != null) {
                        i = R.id.button_ctv_preferences_tab_vendor;
                        Button button5 = (Button) ViewBindings.findChildViewById(view, i);
                        if (button5 != null) {
                            i = R.id.container_ctv_preferences_primary;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout != null) {
                                i = R.id.image_ctv_preferences_logo;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view_ctv_preferences_divider))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view_ctv_preferences_menu_background))) != null) {
                                    return new v5((ConstraintLayout) view, button, button2, button3, button4, button5, frameLayout, imageView, viewFindChildViewById, viewFindChildViewById2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
