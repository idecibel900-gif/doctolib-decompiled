package com.facebook.react.views.view;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.TypedValue;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactDrawableHelper {
    public static final ReactDrawableHelper INSTANCE = new ReactDrawableHelper();
    private static final TypedValue resolveOutValue = new TypedValue();

    private ReactDrawableHelper() {
    }

    public static final Drawable createDrawableFromJSDescription(Context context, ReadableMap drawableDescriptionDict) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(drawableDescriptionDict, "drawableDescriptionDict");
        String string = drawableDescriptionDict.getString("type");
        if (Intrinsics.areEqual("ThemeAttrAndroid", string)) {
            String string2 = drawableDescriptionDict.getString("attribute");
            if (string2 == null) {
                throw new JSApplicationIllegalArgumentException("JS description missing 'attribute' field");
            }
            ReactDrawableHelper reactDrawableHelper = INSTANCE;
            int attrId = reactDrawableHelper.getAttrId(context, string2);
            if (!context.getTheme().resolveAttribute(attrId, resolveOutValue, true)) {
                throw new JSApplicationIllegalArgumentException("Attribute " + string2 + " with id " + attrId + " couldn't be resolved into a drawable");
            }
            return reactDrawableHelper.setRadius(drawableDescriptionDict, reactDrawableHelper.getDefaultThemeDrawable(context));
        }
        if (Intrinsics.areEqual("RippleAndroid", string)) {
            ReactDrawableHelper reactDrawableHelper2 = INSTANCE;
            return reactDrawableHelper2.setRadius(drawableDescriptionDict, reactDrawableHelper2.getRippleDrawable(context, drawableDescriptionDict));
        }
        throw new JSApplicationIllegalArgumentException("Invalid type for android drawable: " + string);
    }

    private final int getAttrId(Context context, String str) {
        if (Intrinsics.areEqual("selectableItemBackground", str)) {
            return R.attr.selectableItemBackground;
        }
        return Intrinsics.areEqual("selectableItemBackgroundBorderless", str) ? R.attr.selectableItemBackgroundBorderless : context.getResources().getIdentifier(str, "attr", "android");
    }

    private final Drawable getDefaultThemeDrawable(Context context) {
        return context.getResources().getDrawable(resolveOutValue.resourceId, context.getTheme());
    }

    private final RippleDrawable getRippleDrawable(Context context, ReadableMap readableMap) {
        int color = getColor(context, readableMap);
        return new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{color}), null, getMask(readableMap));
    }

    private final Drawable setRadius(ReadableMap readableMap, Drawable drawable) {
        if (readableMap.hasKey("rippleRadius") && (drawable instanceof RippleDrawable)) {
            ((RippleDrawable) drawable).setRadius((int) PixelUtil.toPixelFromDIP(readableMap.getDouble("rippleRadius")));
        }
        return drawable;
    }

    private final int getColor(Context context, ReadableMap readableMap) {
        if (readableMap.hasKey("color") && !readableMap.isNull("color")) {
            return readableMap.getInt("color");
        }
        Resources.Theme theme = context.getTheme();
        TypedValue typedValue = resolveOutValue;
        if (theme.resolveAttribute(R.attr.colorControlHighlight, typedValue, true)) {
            return context.getResources().getColor(typedValue.resourceId, context.getTheme());
        }
        throw new JSApplicationIllegalArgumentException("Attribute colorControlHighlight couldn't be resolved into a drawable");
    }

    private final Drawable getMask(ReadableMap readableMap) {
        if (readableMap.hasKey("borderless") && !readableMap.isNull("borderless") && readableMap.getBoolean("borderless")) {
            return null;
        }
        return new ColorDrawable(-1);
    }
}
