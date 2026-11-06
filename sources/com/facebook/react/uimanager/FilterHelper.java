package com.facebook.react.uimanager;

import android.graphics.BlendMode;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline1;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class FilterHelper {
    public static final FilterHelper INSTANCE = new FilterHelper();

    private FilterHelper() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final RenderEffect parseFilters(ReadableArray readableArray) {
        RenderEffect renderEffectCreateSaturateEffect = null;
        if (readableArray == null) {
            return null;
        }
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            ReadableMap map = readableArray.getMap(i);
            if (map == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Map.Entry<String, Object> next = map.getEntryIterator().next();
            String key = next.getKey();
            switch (key.hashCode()) {
                case -2114203985:
                    if (!key.equals("saturate")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper = INSTANCE;
                    Object value = next.getValue();
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper.createSaturateEffect((float) ((Double) value).doubleValue(), renderEffectCreateSaturateEffect);
                    break;
                    break;
                case -1267206133:
                    if (!key.equals("opacity")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper2 = INSTANCE;
                    Object value2 = next.getValue();
                    Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper2.createOpacityEffect((float) ((Double) value2).doubleValue(), renderEffectCreateSaturateEffect);
                    break;
                    break;
                case -1183703082:
                    if (!key.equals("invert")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper3 = INSTANCE;
                    Object value3 = next.getValue();
                    Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper3.createInvertEffect((float) ((Double) value3).doubleValue(), renderEffectCreateSaturateEffect);
                    break;
                    break;
                case -905411385:
                    if (!key.equals("grayscale")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper4 = INSTANCE;
                    Object value4 = next.getValue();
                    Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper4.createGrayscaleEffect((float) ((Double) value4).doubleValue(), renderEffectCreateSaturateEffect);
                    break;
                    break;
                case -566947070:
                    if (!key.equals("contrast")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper5 = INSTANCE;
                    Object value5 = next.getValue();
                    Intrinsics.checkNotNull(value5, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper5.createContrastEffect((float) ((Double) value5).doubleValue(), renderEffectCreateSaturateEffect);
                    break;
                    break;
                case 3027047:
                    if (!key.equals("blur")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper6 = INSTANCE;
                    Object value6 = next.getValue();
                    Intrinsics.checkNotNull(value6, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper6.createBlurEffect((float) ((Double) value6).doubleValue(), renderEffectCreateSaturateEffect);
                    break;
                    break;
                case 109324790:
                    if (!key.equals("sepia")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper7 = INSTANCE;
                    Object value7 = next.getValue();
                    Intrinsics.checkNotNull(value7, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper7.createSepiaEffect((float) ((Double) value7).doubleValue(), renderEffectCreateSaturateEffect);
                    break;
                    break;
                case 648162385:
                    if (!key.equals("brightness")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper8 = INSTANCE;
                    Object value8 = next.getValue();
                    Intrinsics.checkNotNull(value8, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper8.createBrightnessEffect((float) ((Double) value8).doubleValue(), renderEffectCreateSaturateEffect);
                    break;
                    break;
                case 650888307:
                    if (!key.equals("hueRotate")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper9 = INSTANCE;
                    Object value9 = next.getValue();
                    Intrinsics.checkNotNull(value9, "null cannot be cast to non-null type kotlin.Double");
                    renderEffectCreateSaturateEffect = filterHelper9.createHueRotateEffect((float) ((Double) value9).doubleValue(), renderEffectCreateSaturateEffect);
                    break;
                    break;
                case 906978543:
                    if (!key.equals("dropShadow")) {
                        throw new IllegalArgumentException("Invalid filter name: " + key);
                    }
                    FilterHelper filterHelper10 = INSTANCE;
                    Object value10 = next.getValue();
                    Intrinsics.checkNotNull(value10, "null cannot be cast to non-null type com.facebook.react.bridge.ReadableMap");
                    renderEffectCreateSaturateEffect = filterHelper10.parseAndCreateDropShadowEffect((ReadableMap) value10, renderEffectCreateSaturateEffect);
                    break;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid filter name: " + key);
            }
        }
        return renderEffectCreateSaturateEffect;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final ColorMatrixColorFilter parseColorMatrixFilters(ReadableArray readableArray) {
        ColorMatrix colorMatrixCreateSaturateColorMatrix;
        if (readableArray == null) {
            return null;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            ReadableMap map = readableArray.getMap(i);
            if (map == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Map.Entry<String, Object> next = map.getEntryIterator().next();
            String key = next.getKey();
            Object value = next.getValue();
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Double");
            float fDoubleValue = (float) ((Double) value).doubleValue();
            switch (key.hashCode()) {
                case -2114203985:
                    if (!key.equals("saturate")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: " + key);
                    }
                    colorMatrixCreateSaturateColorMatrix = INSTANCE.createSaturateColorMatrix(fDoubleValue);
                    colorMatrix.preConcat(colorMatrixCreateSaturateColorMatrix);
                    break;
                    break;
                case -1267206133:
                    if (!key.equals("opacity")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: " + key);
                    }
                    colorMatrixCreateSaturateColorMatrix = INSTANCE.createOpacityColorMatrix(fDoubleValue);
                    colorMatrix.preConcat(colorMatrixCreateSaturateColorMatrix);
                    break;
                    break;
                case -1183703082:
                    if (!key.equals("invert")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: " + key);
                    }
                    colorMatrixCreateSaturateColorMatrix = INSTANCE.createInvertColorMatrix(fDoubleValue);
                    colorMatrix.preConcat(colorMatrixCreateSaturateColorMatrix);
                    break;
                    break;
                case -905411385:
                    if (!key.equals("grayscale")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: " + key);
                    }
                    colorMatrixCreateSaturateColorMatrix = INSTANCE.createGrayscaleColorMatrix(fDoubleValue);
                    colorMatrix.preConcat(colorMatrixCreateSaturateColorMatrix);
                    break;
                    break;
                case -566947070:
                    if (!key.equals("contrast")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: " + key);
                    }
                    colorMatrixCreateSaturateColorMatrix = INSTANCE.createContrastColorMatrix(fDoubleValue);
                    colorMatrix.preConcat(colorMatrixCreateSaturateColorMatrix);
                    break;
                    break;
                case 109324790:
                    if (!key.equals("sepia")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: " + key);
                    }
                    colorMatrixCreateSaturateColorMatrix = INSTANCE.createSepiaColorMatrix(fDoubleValue);
                    colorMatrix.preConcat(colorMatrixCreateSaturateColorMatrix);
                    break;
                    break;
                case 648162385:
                    if (!key.equals("brightness")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: " + key);
                    }
                    colorMatrixCreateSaturateColorMatrix = INSTANCE.createBrightnessColorMatrix(fDoubleValue);
                    colorMatrix.preConcat(colorMatrixCreateSaturateColorMatrix);
                    break;
                    break;
                case 650888307:
                    if (!key.equals("hueRotate")) {
                        throw new IllegalArgumentException("Invalid color matrix filter: " + key);
                    }
                    colorMatrixCreateSaturateColorMatrix = INSTANCE.createHueRotateColorMatrix(fDoubleValue);
                    colorMatrix.preConcat(colorMatrixCreateSaturateColorMatrix);
                    break;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid color matrix filter: " + key);
            }
        }
        return new ColorMatrixColorFilter(colorMatrix);
    }

    public static final boolean isOnlyColorMatrixFilters(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            return false;
        }
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            ReadableMap map = readableArray.getMap(i);
            Intrinsics.checkNotNull(map);
            String key = map.getEntryIterator().next().getKey();
            if (Intrinsics.areEqual(key, "blur") || Intrinsics.areEqual(key, "dropShadow")) {
                return false;
            }
        }
        return true;
    }

    public final RenderEffect createBlurEffect(float f, RenderEffect renderEffect) {
        if (f <= 0.5d) {
            return null;
        }
        float fSigmaToRadius$ReactAndroid_release = sigmaToRadius$ReactAndroid_release(f);
        if (renderEffect == null) {
            return RenderEffect.createBlurEffect(fSigmaToRadius$ReactAndroid_release, fSigmaToRadius$ReactAndroid_release, Shader.TileMode.DECAL);
        }
        return RenderEffect.createBlurEffect(fSigmaToRadius$ReactAndroid_release, fSigmaToRadius$ReactAndroid_release, renderEffect, Shader.TileMode.DECAL);
    }

    public final RenderEffect createBrightnessEffect(float f, RenderEffect renderEffect) {
        return createColorMatrixEffect(createBrightnessColorMatrix(f), renderEffect);
    }

    private final ColorMatrix createBrightnessColorMatrix(float f) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(f, f, f, 1.0f);
        return colorMatrix;
    }

    public final RenderEffect createOpacityEffect(float f, RenderEffect renderEffect) {
        return createColorMatrixEffect(createOpacityColorMatrix(f), renderEffect);
    }

    public final RenderEffect createDropShadowEffect(float f, float f2, float f3, int i, RenderEffect renderEffect) {
        RenderEffect renderEffectCreateOffsetEffect;
        RenderEffect renderEffectCreateOffsetEffect2;
        if (renderEffect == null) {
            renderEffectCreateOffsetEffect2 = RenderEffect.createOffsetEffect(0.0f, 0.0f);
            Intrinsics.checkNotNullExpressionValue(renderEffectCreateOffsetEffect2, "createOffsetEffect(...)");
            renderEffectCreateOffsetEffect = RenderEffect.createOffsetEffect(f, f2);
            Intrinsics.checkNotNullExpressionValue(renderEffectCreateOffsetEffect, "createOffsetEffect(...)");
        } else {
            RenderEffect renderEffectCreateOffsetEffect3 = RenderEffect.createOffsetEffect(0.0f, 0.0f, renderEffect);
            Intrinsics.checkNotNullExpressionValue(renderEffectCreateOffsetEffect3, "createOffsetEffect(...)");
            renderEffectCreateOffsetEffect = RenderEffect.createOffsetEffect(f, f2, renderEffect);
            Intrinsics.checkNotNullExpressionValue(renderEffectCreateOffsetEffect, "createOffsetEffect(...)");
            renderEffectCreateOffsetEffect2 = renderEffectCreateOffsetEffect3;
        }
        BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline1.m();
        RenderEffect renderEffectCreateColorFilterEffect = RenderEffect.createColorFilterEffect(BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline0.m(i, BlendMode.SRC_IN), renderEffectCreateOffsetEffect);
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateColorFilterEffect, "createColorFilterEffect(...)");
        RenderEffect renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(f3, f3, renderEffectCreateColorFilterEffect, Shader.TileMode.DECAL);
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateBlurEffect, "createBlurEffect(...)");
        RenderEffect renderEffectCreateBlendModeEffect = RenderEffect.createBlendModeEffect(renderEffectCreateBlurEffect, renderEffectCreateOffsetEffect2, BlendMode.SRC_OVER);
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateBlendModeEffect, "createBlendModeEffect(...)");
        return renderEffectCreateBlendModeEffect;
    }

    public final RenderEffect parseAndCreateDropShadowEffect(ReadableMap filterValues, RenderEffect renderEffect) {
        Intrinsics.checkNotNullParameter(filterValues, "filterValues");
        PixelUtil pixelUtil = PixelUtil.INSTANCE;
        return createDropShadowEffect(pixelUtil.dpToPx(filterValues.getDouble("offsetX")), pixelUtil.dpToPx(filterValues.getDouble("offsetY")), filterValues.hasKey("standardDeviation") ? sigmaToRadius$ReactAndroid_release((float) filterValues.getDouble("standardDeviation")) : 0.0f, filterValues.hasKey("color") ? filterValues.getInt("color") : -16777216, renderEffect);
    }

    public final ColorMatrix createOpacityColorMatrix(float f) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1.0f, 1.0f, 1.0f, f);
        return colorMatrix;
    }

    public final RenderEffect createContrastEffect(float f, RenderEffect renderEffect) {
        return createColorMatrixEffect(createContrastColorMatrix(f), renderEffect);
    }

    private final ColorMatrix createContrastColorMatrix(float f) {
        float f2 = 255 * ((-(f / 2.0f)) + 0.5f);
        return new ColorMatrix(new float[]{f, 0.0f, 0.0f, 0.0f, f2, 0.0f, f, 0.0f, 0.0f, f2, 0.0f, 0.0f, f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public final RenderEffect createGrayscaleEffect(float f, RenderEffect renderEffect) {
        return createColorMatrixEffect(createGrayscaleColorMatrix(f), renderEffect);
    }

    private final ColorMatrix createGrayscaleColorMatrix(float f) {
        float f2 = 1 - f;
        float f3 = 0.7152f - (f2 * 0.7152f);
        float f4 = 0.0722f - (f2 * 0.0722f);
        float f5 = 0.2126f - (f2 * 0.2126f);
        return new ColorMatrix(new float[]{(0.7874f * f2) + 0.2126f, f3, f4, 0.0f, 0.0f, f5, (0.2848f * f2) + 0.7152f, f4, 0.0f, 0.0f, f5, f3, (f2 * 0.9278f) + 0.0722f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public final RenderEffect createSepiaEffect(float f, RenderEffect renderEffect) {
        return createColorMatrixEffect(createSepiaColorMatrix(f), renderEffect);
    }

    private final ColorMatrix createSepiaColorMatrix(float f) {
        float f2 = 1 - f;
        return new ColorMatrix(new float[]{(0.607f * f2) + 0.393f, 0.769f - (f2 * 0.769f), 0.189f - (f2 * 0.189f), 0.0f, 0.0f, 0.349f - (f2 * 0.349f), (0.314f * f2) + 0.686f, 0.168f - (f2 * 0.168f), 0.0f, 0.0f, 0.272f - (f2 * 0.272f), 0.534f - (f2 * 0.534f), (f2 * 0.869f) + 0.131f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public final RenderEffect createSaturateEffect(float f, RenderEffect renderEffect) {
        return createColorMatrixEffect(createSaturateColorMatrix(f), renderEffect);
    }

    private final ColorMatrix createSaturateColorMatrix(float f) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(f);
        return colorMatrix;
    }

    public final RenderEffect createHueRotateEffect(float f, RenderEffect renderEffect) {
        return createColorMatrixEffect(createHueRotateColorMatrix(f), renderEffect);
    }

    private final ColorMatrix createHueRotateColorMatrix(float f) {
        double radians = Math.toRadians(f);
        float fCos = (float) Math.cos(radians);
        float fSin = (float) Math.sin(radians);
        float f2 = 0.715f - (fCos * 0.715f);
        float f3 = fSin * 0.715f;
        float f4 = 0.072f - (fCos * 0.072f);
        float f5 = 0.213f - (fCos * 0.213f);
        return new ColorMatrix(new float[]{((fCos * 0.787f) + 0.213f) - (fSin * 0.213f), f2 - f3, (fSin * 0.928f) + f4, 0.0f, 0.0f, (0.143f * fSin) + f5, (0.285f * fCos) + 0.715f + (0.14f * fSin), f4 - (0.283f * fSin), 0.0f, 0.0f, f5 - (0.787f * fSin), f2 + f3, (fCos * 0.928f) + 0.072f + (fSin * 0.072f), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public final RenderEffect createInvertEffect(float f, RenderEffect renderEffect) {
        return createColorMatrixEffect(createInvertColorMatrix(f), renderEffect);
    }

    private final ColorMatrix createInvertColorMatrix(float f) {
        float f2 = 1 - (2 * f);
        float f3 = f * 255;
        return new ColorMatrix(new float[]{f2, 0.0f, 0.0f, 0.0f, f3, 0.0f, f2, 0.0f, 0.0f, f3, 0.0f, 0.0f, f2, 0.0f, f3, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    private final RenderEffect createColorMatrixEffect(ColorMatrix colorMatrix, RenderEffect renderEffect) {
        if (renderEffect == null) {
            RenderEffect renderEffectCreateColorFilterEffect = RenderEffect.createColorFilterEffect(new ColorMatrixColorFilter(colorMatrix));
            Intrinsics.checkNotNull(renderEffectCreateColorFilterEffect);
            return renderEffectCreateColorFilterEffect;
        }
        RenderEffect renderEffectCreateColorFilterEffect2 = RenderEffect.createColorFilterEffect(new ColorMatrixColorFilter(colorMatrix), renderEffect);
        Intrinsics.checkNotNull(renderEffectCreateColorFilterEffect2);
        return renderEffectCreateColorFilterEffect2;
    }

    public final float sigmaToRadius$ReactAndroid_release(float f) {
        float pixelFromDIP = PixelUtil.toPixelFromDIP(f);
        if (pixelFromDIP > 0.5f) {
            return (pixelFromDIP - 0.5f) / 0.57735f;
        }
        return 0.0f;
    }
}
