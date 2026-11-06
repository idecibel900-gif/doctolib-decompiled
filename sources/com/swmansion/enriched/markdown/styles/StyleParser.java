package com.swmansion.enriched.markdown.styles;

import android.content.Context;
import android.util.DisplayMetrics;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StyleParser {
    private final boolean allowFontScaling;
    private final Context context;
    private final float maxFontSizeMultiplier;

    public StyleParser(Context context, boolean z, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.allowFontScaling = z;
        this.maxFontSizeMultiplier = f;
    }

    public final Integer parseOptionalColor(ReadableMap map, String key) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!map.hasKey(key) || map.isNull(key)) {
            return null;
        }
        return ColorPropConverter.getColor(Double.valueOf(map.getDouble(key)), this.context);
    }

    public final int parseColor(ReadableMap map, String key) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(key, "key");
        Integer optionalColor = parseOptionalColor(map, key);
        if (optionalColor != null) {
            return optionalColor.intValue();
        }
        throw new IllegalArgumentException("Color key '" + key + "' is missing, null, or invalid");
    }

    public static /* synthetic */ double parseOptionalDouble$default(StyleParser styleParser, ReadableMap readableMap, String str, double d, int i, Object obj) {
        if ((i & 4) != 0) {
            d = 0.0d;
        }
        return styleParser.parseOptionalDouble(readableMap, str, d);
    }

    public final double parseOptionalDouble(ReadableMap map, String key, double d) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(key, "key");
        return (!map.hasKey(key) || map.isNull(key)) ? d : map.getDouble(key);
    }

    public static /* synthetic */ String parseString$default(StyleParser styleParser, ReadableMap readableMap, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return styleParser.parseString(readableMap, str, str2);
    }

    public final String parseString(ReadableMap map, String key, String str) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        String string = map.getString(key);
        return string == null ? str : string;
    }

    public static /* synthetic */ boolean parseBoolean$default(StyleParser styleParser, ReadableMap readableMap, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return styleParser.parseBoolean(readableMap, str, z);
    }

    public final boolean parseBoolean(ReadableMap map, String key, boolean z) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(key, "key");
        return (!map.hasKey(key) || map.isNull(key)) ? z : map.getBoolean(key);
    }

    public final float toPixelFromSP(float f) {
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        float f2 = displayMetrics.density;
        if (!this.allowFontScaling) {
            return f * f2;
        }
        float f3 = displayMetrics.scaledDensity / f2;
        float f4 = this.maxFontSizeMultiplier;
        if (f4 >= 1.0f && f3 > f4) {
            f3 = f4;
        }
        return f * f2 * f3;
    }

    public final float toPixelFromDIP(float f) {
        return PixelUtil.toPixelFromDIP(f);
    }

    public final TextAlignment parseTextAlign(ReadableMap map, String key) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(key, "key");
        return TextAlignment.Companion.fromString(parseString(map, key, "left"));
    }
}
