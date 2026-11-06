package io.didomi.ssl;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.widget.Button;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u0014\u0010\b\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0001¨\u0006\t"}, d2 = {"Landroid/widget/Button;", "", "color", "", "a", "Lio/didomi/sdk/xg;", "theme", "olderThanApi", "b", "android_release"}, k = 2, mv = {1, 8, 0})
public final class s {
    public static final void a(Button button, int i) {
        Intrinsics.checkNotNullParameter(button, "<this>");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(button.getResources().getDisplayMetrics().density * 5.0f);
        gradientDrawable.setColor(0);
        gradientDrawable.setStroke((int) (button.getResources().getDisplayMetrics().density * 1.0f), i);
        button.setBackground(gradientDrawable);
    }

    public static final void b(Button button, int i) {
        Intrinsics.checkNotNullParameter(button, "<this>");
        if (Build.VERSION.SDK_INT < i) {
            button.setPaintFlags(button.getPaintFlags() | 8);
        }
    }

    public static final void a(Button button, TextTheme theme) {
        Intrinsics.checkNotNullParameter(button, "<this>");
        Intrinsics.checkNotNullParameter(theme, "theme");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(button.getResources().getDisplayMetrics().density * 5.0f);
        gradientDrawable.setColor(0);
        gradientDrawable.setStroke((int) (button.getResources().getDisplayMetrics().density * 1.0f), theme.getTextColor());
        button.setBackground(gradientDrawable);
        Drawable[] compoundDrawablesRelative = button.getCompoundDrawablesRelative();
        Intrinsics.checkNotNullExpressionValue(compoundDrawablesRelative, "if (Build.VERSION.SDK_IN…ndDrawablesRelative\n    }");
        for (Drawable drawable : compoundDrawablesRelative) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(theme.getTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
        zg.a(button, theme);
    }

    public static /* synthetic */ void a(Button button, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 26;
        }
        b(button, i);
    }
}
