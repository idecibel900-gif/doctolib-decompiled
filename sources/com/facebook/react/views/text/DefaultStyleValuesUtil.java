package com.facebook.react.views.text;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultStyleValuesUtil {
    public static final DefaultStyleValuesUtil INSTANCE = new DefaultStyleValuesUtil();

    private DefaultStyleValuesUtil() {
    }

    public static final ColorStateList getDefaultTextColorHint(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.getDefaultTextAttribute(context, R.attr.textColorHint);
    }

    public static final ColorStateList getDefaultTextColor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.getDefaultTextAttribute(context, R.attr.textColor);
    }

    public static final ColorStateList getTextColorSecondary(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.getDefaultTextAttribute(context, R.attr.textColorSecondary);
    }

    public static final int getDefaultTextColorHighlight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ColorStateList defaultTextAttribute = INSTANCE.getDefaultTextAttribute(context, R.attr.textColorHighlight);
        if (defaultTextAttribute != null) {
            return defaultTextAttribute.getDefaultColor();
        }
        return 0;
    }

    private final ColorStateList getDefaultTextAttribute(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        return typedArrayObtainStyledAttributes.getColorStateList(0);
    }
}
