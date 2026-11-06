package com.swmansion.enriched.markdown.utils.text.extensions;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.amazon.a.a.o.b.f;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.swmansion.enriched.markdown.renderer.BlockStyle;
import com.swmansion.enriched.markdown.styles.CodeBlockStyle;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TextPaintExtensionsKt {
    private static final Map typefaceCache = new LinkedHashMap();
    private static final Map fontWeightCache = new LinkedHashMap();

    public static final void applyColorPreserving(TextPaint textPaint, int i, int... preserveColors) {
        Intrinsics.checkNotNullParameter(textPaint, "<this>");
        Intrinsics.checkNotNullParameter(preserveColors, "preserveColors");
        if (ArraysKt.contains(preserveColors, textPaint.getColor())) {
            return;
        }
        textPaint.setColor(i);
    }

    public static final void applyBlockStyleFont(TextPaint textPaint, BlockStyle blockStyle, Context context) {
        Intrinsics.checkNotNullParameter(textPaint, "<this>");
        Intrinsics.checkNotNullParameter(blockStyle, "blockStyle");
        Intrinsics.checkNotNullParameter(context, "context");
        String str = blockStyle.getFontFamily() + f.c + blockStyle.getFontWeight();
        Map map = typefaceCache;
        Typeface typeface = (Typeface) map.get(str);
        if (typeface != null) {
            textPaint.setTypeface(typeface);
            return;
        }
        Map map2 = fontWeightCache;
        String fontWeight = blockStyle.getFontWeight();
        Object objValueOf = map2.get(fontWeight);
        if (objValueOf == null) {
            objValueOf = Integer.valueOf(ReactTypefaceUtils.parseFontWeight(blockStyle.getFontWeight()));
            map2.put(fontWeight, objValueOf);
        }
        int iIntValue = ((Number) objValueOf).intValue();
        String fontFamily = blockStyle.getFontFamily();
        if (fontFamily.length() <= 0) {
            fontFamily = null;
        }
        AssetManager assets = context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
        Typeface typefaceApplyStyles = ReactTypefaceUtils.applyStyles(null, -1, iIntValue, fontFamily, assets);
        map.put(str, typefaceApplyStyles);
        textPaint.setTypeface(typefaceApplyStyles);
    }

    public static final void applyCodeBlockTextStyle(TextPaint textPaint, CodeBlockStyle style, Context context) {
        Intrinsics.checkNotNullParameter(textPaint, "<this>");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(context, "context");
        textPaint.setTextSize(style.getFontSize());
        applyBlockStyleFont(textPaint, new BlockStyle(style.getFontSize(), style.getFontFamily(), style.getFontWeight(), style.getColor()), context);
    }
}
