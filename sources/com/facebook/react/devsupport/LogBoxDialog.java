package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.R$style;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class LogBoxDialog extends Dialog {
    private final View reactRootView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogBoxDialog(Activity context, View view) {
        super(context, R$style.Theme_Catalyst_LogBox);
        Intrinsics.checkNotNullParameter(context, "context");
        this.reactRootView = view;
        requestWindowFeature(1);
        if (view != null) {
            setContentView(view);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(-16777216));
        }
        View view = this.reactRootView;
        if (view != null) {
            final int iSystemBars = WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout();
            final Function2 function2 = new Function2() { // from class: com.facebook.react.devsupport.LogBoxDialog$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LogBoxDialog.onCreate$lambda$3$lambda$1(iSystemBars, (View) obj, (WindowInsetsCompat) obj2);
                }
            };
            ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.facebook.react.devsupport.LogBoxDialog$$ExternalSyntheticLambda1
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                    return LogBoxDialog.onCreate$lambda$3$lambda$2(function2, view2, windowInsetsCompat);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$3$lambda$1(int i, View view, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insets = windowInsets.getInsets(i);
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).setMargins(insets.left, insets.top, insets.right, insets.bottom);
        return WindowInsetsCompat.CONSUMED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$3$lambda$2(Function2 function2, View p0, WindowInsetsCompat p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return (WindowInsetsCompat) function2.invoke(p0, p1);
    }
}
