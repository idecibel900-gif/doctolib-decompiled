package com.reactnativekeyboardcontroller.views.background;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import com.facebook.react.uimanager.ThemedReactContext;
import com.reactnativekeyboardcontroller.R$style;
import com.reactnativekeyboardcontroller.R$styleable;
import com.reactnativekeyboardcontroller.extensions.ContextKt;
import com.reactnativekeyboardcontroller.log.Logger;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SkinsKt {
    private static final Map imeColorMap = MapsKt.mapOf(TuplesKt.to("com.android.inputmethod.latin", TuplesKt.to(Integer.valueOf(R$style.aosp_light), Integer.valueOf(R$style.aosp_light))), TuplesKt.to("com.google.android.inputmethod.latin", TuplesKt.to(Integer.valueOf(R$style.gboard_light), Integer.valueOf(R$style.gboard_dark))), TuplesKt.to("com.touchtype.swiftkey", TuplesKt.to(Integer.valueOf(R$style.swiftkey_light), Integer.valueOf(R$style.swiftkey_dark))), TuplesKt.to("com.google.android.googlequicksearchbox", TuplesKt.to(Integer.valueOf(R$style.gboard_tts_light), Integer.valueOf(R$style.gboard_tts_dark))), TuplesKt.to("com.google.android.tts", TuplesKt.to(Integer.valueOf(R$style.gboard_tts_light), Integer.valueOf(R$style.gboard_tts_dark))), TuplesKt.to("ru.yandex.androidkeyboard", TuplesKt.to(Integer.valueOf(R$style.yandex_light), Integer.valueOf(R$style.yandex_dark))), TuplesKt.to("com.samsung.android.honeyboard", TuplesKt.to(Integer.valueOf(R$style.samsung_light), Integer.valueOf(R$style.samsung_dark))));

    public static final ColorProperties getColorProperties(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.ColorProperties);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            return new ColorProperties(typedArrayObtainStyledAttributes.getColor(R$styleable.ColorProperties_color, -16777216), typedArrayObtainStyledAttributes.getInt(R$styleable.ColorProperties_tone, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static final int shiftRgbChannels(int i, int i2) {
        return Color.argb(Color.alpha(i), RangesKt.coerceIn(Color.red(i) + i2, 0, 255), RangesKt.coerceIn(Color.green(i) + i2, 0, 255), RangesKt.coerceIn(Color.blue(i) + i2, 0, 255));
    }

    public static final int getInputMethodColor(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "<this>");
        String strCurrentImePackage = ContextKt.currentImePackage(themedReactContext);
        boolean zIsSystemDarkMode = ContextKt.isSystemDarkMode(themedReactContext);
        Logger.i$default(Logger.INSTANCE, "Skins", "Current IME: " + strCurrentImePackage, null, 4, null);
        Pair pair = (Pair) imeColorMap.get(strCurrentImePackage);
        if (pair == null) {
            pair = TuplesKt.to(Integer.valueOf(R$style.gboard_light), Integer.valueOf(R$style.gboard_dark));
        }
        int iIntValue = ((Number) pair.getFirst()).intValue();
        int iIntValue2 = ((Number) pair.getSecond()).intValue();
        if (zIsSystemDarkMode && Build.VERSION.SDK_INT > 29) {
            iIntValue = iIntValue2;
        }
        return getColorProperties(themedReactContext, iIntValue).getBlend();
    }
}
