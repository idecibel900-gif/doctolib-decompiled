package com.swmansion.enriched.markdown;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import com.swmansion.enriched.markdown.parser.Md4cFlags;
import com.swmansion.enriched.markdown.parser.Parser;
import com.swmansion.enriched.markdown.renderer.Renderer;
import com.swmansion.enriched.markdown.spans.ImageSpan;
import com.swmansion.enriched.markdown.spans.MathMeasureRequest;
import com.swmansion.enriched.markdown.spans.MathMetrics;
import com.swmansion.enriched.markdown.spans.MathRenderMode;
import com.swmansion.enriched.markdown.styles.StyleConfig;
import com.swmansion.enriched.markdown.utils.common.BreakStrategyUtils;
import com.swmansion.enriched.markdown.utils.common.CodeBlockStreamingMode;
import com.swmansion.enriched.markdown.utils.common.MarkdownSegmentKt;
import com.swmansion.enriched.markdown.utils.common.MarkdownSegmentRenderer;
import com.swmansion.enriched.markdown.utils.common.MarkdownViewManagerUtilsKt;
import com.swmansion.enriched.markdown.utils.common.ReadableMapExtensionsKt;
import com.swmansion.enriched.markdown.utils.common.RenderedSegment;
import com.swmansion.enriched.markdown.utils.common.StreamingMarkdownFilter;
import com.swmansion.enriched.markdown.utils.common.TableStreamingMode;
import com.swmansion.enriched.markdown.utils.text.extensions.SpannableExtensionsKt;
import com.swmansion.enriched.markdown.views.CodeBlockContainerView;
import com.swmansion.enriched.markdown.views.TableContainerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class MeasurementStore {
    public static final MeasurementStore INSTANCE = new MeasurementStore();
    private static final ConcurrentHashMap data = new ConcurrentHashMap();
    private static final ConcurrentHashMap fontScalingSettings = new ConcurrentHashMap();
    private static final ConcurrentHashMap breakStrategies = new ConcurrentHashMap();
    private static final ConcurrentHashMap streamingTableModes = new ConcurrentHashMap();
    private static final ConcurrentHashMap streamingCodeBlockModes = new ConcurrentHashMap();
    private static final TextPaint measurePaint = new TextPaint();
    private static final Renderer measureRenderer = new Renderer();
    private static volatile float lastKnownFontScale = 1.0f;

    private MeasurementStore() {
    }

    private static final class PaintParams {
        private final float fontSize;
        private final Typeface typeface;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaintParams)) {
                return false;
            }
            PaintParams paintParams = (PaintParams) obj;
            return Intrinsics.areEqual(this.typeface, paintParams.typeface) && Float.compare(this.fontSize, paintParams.fontSize) == 0;
        }

        public int hashCode() {
            return (this.typeface.hashCode() * 31) + Float.hashCode(this.fontSize);
        }

        public String toString() {
            return "PaintParams(typeface=" + this.typeface + ", fontSize=" + this.fontSize + ")";
        }

        public PaintParams(Typeface typeface, float f) {
            Intrinsics.checkNotNullParameter(typeface, "typeface");
            this.typeface = typeface;
            this.fontSize = f;
        }

        public final Typeface getTypeface() {
            return this.typeface;
        }

        public final float getFontSize() {
            return this.fontSize;
        }
    }

    private static final class MeasurementParams {
        private final long cachedSize;
        private final float cachedWidth;
        private final int markdownHash;
        private final PaintParams paintParams;
        private final CharSequence spannable;

        public static /* synthetic */ MeasurementParams copy$default(MeasurementParams measurementParams, float f, long j, CharSequence charSequence, PaintParams paintParams, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                f = measurementParams.cachedWidth;
            }
            if ((i2 & 2) != 0) {
                j = measurementParams.cachedSize;
            }
            if ((i2 & 4) != 0) {
                charSequence = measurementParams.spannable;
            }
            if ((i2 & 8) != 0) {
                paintParams = measurementParams.paintParams;
            }
            if ((i2 & 16) != 0) {
                i = measurementParams.markdownHash;
            }
            int i3 = i;
            CharSequence charSequence2 = charSequence;
            return measurementParams.copy(f, j, charSequence2, paintParams, i3);
        }

        public final MeasurementParams copy(float f, long j, CharSequence charSequence, PaintParams paintParams, int i) {
            Intrinsics.checkNotNullParameter(paintParams, "paintParams");
            return new MeasurementParams(f, j, charSequence, paintParams, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MeasurementParams)) {
                return false;
            }
            MeasurementParams measurementParams = (MeasurementParams) obj;
            return Float.compare(this.cachedWidth, measurementParams.cachedWidth) == 0 && this.cachedSize == measurementParams.cachedSize && Intrinsics.areEqual(this.spannable, measurementParams.spannable) && Intrinsics.areEqual(this.paintParams, measurementParams.paintParams) && this.markdownHash == measurementParams.markdownHash;
        }

        public int hashCode() {
            int iHashCode = ((Float.hashCode(this.cachedWidth) * 31) + Long.hashCode(this.cachedSize)) * 31;
            CharSequence charSequence = this.spannable;
            return ((((iHashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31) + this.paintParams.hashCode()) * 31) + Integer.hashCode(this.markdownHash);
        }

        public String toString() {
            float f = this.cachedWidth;
            long j = this.cachedSize;
            CharSequence charSequence = this.spannable;
            return "MeasurementParams(cachedWidth=" + f + ", cachedSize=" + j + ", spannable=" + ((Object) charSequence) + ", paintParams=" + this.paintParams + ", markdownHash=" + this.markdownHash + ")";
        }

        public MeasurementParams(float f, long j, CharSequence charSequence, PaintParams paintParams, int i) {
            Intrinsics.checkNotNullParameter(paintParams, "paintParams");
            this.cachedWidth = f;
            this.cachedSize = j;
            this.spannable = charSequence;
            this.paintParams = paintParams;
            this.markdownHash = i;
        }

        public final float getCachedWidth() {
            return this.cachedWidth;
        }

        public final long getCachedSize() {
            return this.cachedSize;
        }

        public final CharSequence getSpannable() {
            return this.spannable;
        }

        public final PaintParams getPaintParams() {
            return this.paintParams;
        }

        public final int getMarkdownHash() {
            return this.markdownHash;
        }
    }

    private static final class FontScalingSettings {
        private final boolean allowFontScaling;
        private final float maxFontSizeMultiplier;

        public final boolean component1() {
            return this.allowFontScaling;
        }

        public final float component2() {
            return this.maxFontSizeMultiplier;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FontScalingSettings)) {
                return false;
            }
            FontScalingSettings fontScalingSettings = (FontScalingSettings) obj;
            return this.allowFontScaling == fontScalingSettings.allowFontScaling && Float.compare(this.maxFontSizeMultiplier, fontScalingSettings.maxFontSizeMultiplier) == 0;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.allowFontScaling) * 31) + Float.hashCode(this.maxFontSizeMultiplier);
        }

        public String toString() {
            return "FontScalingSettings(allowFontScaling=" + this.allowFontScaling + ", maxFontSizeMultiplier=" + this.maxFontSizeMultiplier + ")";
        }

        public FontScalingSettings(boolean z, float f) {
            this.allowFontScaling = z;
            this.maxFontSizeMultiplier = f;
        }

        public final boolean getAllowFontScaling() {
            return this.allowFontScaling;
        }

        public final float getMaxFontSizeMultiplier() {
            return this.maxFontSizeMultiplier;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:14:0x002b  */
    /* JADX WARN: Code duplicated, block: B:15:0x0030  */
    /* JADX WARN: Code duplicated, block: B:23:0x0045 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    private final FontScalingSettings resolveFontScalingSettings(Integer num, ReadableMap readableMap) {
        FontScalingSettings fontScalingSettings2;
        boolean allowFontScaling;
        float maxFontSizeMultiplier;
        if (num != null) {
            fontScalingSettings2 = (FontScalingSettings) fontScalingSettings.get(Integer.valueOf(num.intValue()));
        } else {
            fontScalingSettings2 = null;
        }
        if (readableMap != null) {
            ReadableMap readableMap2 = readableMap.hasKey("allowFontScaling") ? readableMap : null;
            if (readableMap2 != null) {
                allowFontScaling = readableMap2.getBoolean("allowFontScaling");
            } else if (fontScalingSettings2 != null) {
                allowFontScaling = fontScalingSettings2.getAllowFontScaling();
            } else {
                allowFontScaling = true;
            }
        } else if (fontScalingSettings2 != null) {
            allowFontScaling = fontScalingSettings2.getAllowFontScaling();
        } else {
            allowFontScaling = true;
        }
        if (readableMap != null) {
            if (!readableMap.hasKey("maxFontSizeMultiplier")) {
                readableMap = null;
            }
            if (readableMap != null) {
                maxFontSizeMultiplier = (float) readableMap.getDouble("maxFontSizeMultiplier");
            } else if (fontScalingSettings2 != null) {
                maxFontSizeMultiplier = fontScalingSettings2.getMaxFontSizeMultiplier();
            } else {
                maxFontSizeMultiplier = 0.0f;
            }
        } else if (fontScalingSettings2 != null) {
            maxFontSizeMultiplier = fontScalingSettings2.getMaxFontSizeMultiplier();
        } else {
            maxFontSizeMultiplier = 0.0f;
        }
        return new FontScalingSettings(allowFontScaling, maxFontSizeMultiplier);
    }

    public final boolean store(int i, CharSequence charSequence, TextPaint paint, float f) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        ConcurrentHashMap concurrentHashMap = data;
        MeasurementParams measurementParams = (MeasurementParams) concurrentHashMap.get(Integer.valueOf(i));
        float cachedWidth = measurementParams != null ? measurementParams.getCachedWidth() : 0.0f;
        long cachedSize = measurementParams != null ? measurementParams.getCachedSize() : 0L;
        int markdownHash = measurementParams != null ? measurementParams.getMarkdownHash() : 0;
        Typeface typeface = paint.getTypeface();
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        Intrinsics.checkNotNull(typeface);
        PaintParams paintParams = new PaintParams(typeface, paint.getTextSize());
        long jMeasure = measure(cachedWidth, charSequence, paint, Integer.valueOf(i));
        if (f > 0.0f) {
            jMeasure = YogaMeasureOutput.make(YogaMeasureOutput.getWidth(jMeasure), YogaMeasureOutput.getHeight(jMeasure) + PixelUtil.toDIPFromPixel(f));
        }
        concurrentHashMap.put(Integer.valueOf(i), new MeasurementParams(cachedWidth, jMeasure, charSequence, paintParams, markdownHash));
        return cachedSize != jMeasure;
    }

    public final void release(int i) {
        data.remove(Integer.valueOf(i));
    }

    public final void invalidate(int i) {
        data.remove(Integer.valueOf(i));
    }

    public final long getMeasureById(Context context, Integer num, float f, float f2, YogaMeasureMode yogaMeasureMode, ReadableMap readableMap, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (ReadableMapExtensionsKt.getStringOrDefault(readableMap, "markdown", "").length() == 0) {
            return YogaMeasureOutput.make(PixelUtil.toDIPFromPixel(f), 0.0f);
        }
        long measureByIdInternal = getMeasureByIdInternal(context, num, f, readableMap, z);
        float height = YogaMeasureOutput.getHeight(measureByIdInternal);
        if (yogaMeasureMode != YogaMeasureMode.AT_MOST) {
            return measureByIdInternal;
        }
        return YogaMeasureOutput.make(YogaMeasureOutput.getWidth(measureByIdInternal), RangesKt.coerceAtMost(height, PixelUtil.toDIPFromPixel(f2)));
    }

    public final void updateFontScalingSettings(int i, boolean z, float f) {
        ConcurrentHashMap concurrentHashMap = fontScalingSettings;
        FontScalingSettings fontScalingSettings2 = (FontScalingSettings) concurrentHashMap.get(Integer.valueOf(i));
        concurrentHashMap.put(Integer.valueOf(i), new FontScalingSettings(z, f));
        if (fontScalingSettings2 != null) {
            if (fontScalingSettings2.getAllowFontScaling() == z && fontScalingSettings2.getMaxFontSizeMultiplier() == f) {
                return;
            }
            data.remove(Integer.valueOf(i));
        }
    }

    public final void clearFontScalingSettings(int i) {
        fontScalingSettings.remove(Integer.valueOf(i));
    }

    public final void updateBreakStrategy(int i, String strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        breakStrategies.put(Integer.valueOf(i), strategy);
    }

    public final void clearBreakStrategy(int i) {
        breakStrategies.remove(Integer.valueOf(i));
    }

    private final int resolveBreakStrategy(Integer num) {
        String str;
        BreakStrategyUtils breakStrategyUtils = BreakStrategyUtils.INSTANCE;
        if (num != null) {
            str = (String) breakStrategies.get(Integer.valueOf(num.intValue()));
        } else {
            str = null;
        }
        return breakStrategyUtils.resolveBreakStrategy(str);
    }

    public final void updateStreamingTableMode(int i, TableStreamingMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        streamingTableModes.put(Integer.valueOf(i), mode);
    }

    public final void clearStreamingTableMode(int i) {
        streamingTableModes.remove(Integer.valueOf(i));
    }

    public final void updateStreamingCodeBlockMode(int i, CodeBlockStreamingMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        streamingCodeBlockModes.put(Integer.valueOf(i), mode);
    }

    public final void clearStreamingCodeBlockMode(int i) {
        streamingCodeBlockModes.remove(Integer.valueOf(i));
    }

    private final long getMeasureByIdInternal(Context context, Integer num, float f, ReadableMap readableMap, boolean z) {
        FontScalingSettings fontScalingSettingsResolveFontScalingSettings = resolveFontScalingSettings(num, readableMap);
        boolean zComponent1 = fontScalingSettingsResolveFontScalingSettings.component1();
        float fComponent2 = fontScalingSettingsResolveFontScalingSettings.component2();
        float fCheckAndUpdateFontScale = checkAndUpdateFontScale(context, zComponent1, fComponent2);
        if (z) {
            return measureAndCacheSplit(context, num, f, readableMap, zComponent1, fCheckAndUpdateFontScale, fComponent2);
        }
        if (num == null) {
            return measureAndCache(context, null, f, readableMap, zComponent1, fCheckAndUpdateFontScale, fComponent2);
        }
        ConcurrentHashMap concurrentHashMap = data;
        MeasurementParams measurementParams = (MeasurementParams) concurrentHashMap.get(num);
        if (measurementParams == null) {
            return measureAndCache(context, num, f, readableMap, zComponent1, fCheckAndUpdateFontScale, fComponent2);
        }
        if (measurementParams.getMarkdownHash() != computePropsHash(readableMap, zComponent1, fCheckAndUpdateFontScale, fComponent2)) {
            return measureAndCache(context, num, f, readableMap, zComponent1, fCheckAndUpdateFontScale, fComponent2);
        }
        if (measurementParams.getCachedWidth() != f) {
            long jMeasure = measure(f, measurementParams.getSpannable(), measurementParams.getPaintParams(), num);
            concurrentHashMap.put(num, MeasurementParams.copy$default(measurementParams, f, jMeasure, null, null, 0, 28, null));
            return jMeasure;
        }
        return measurementParams.getCachedSize();
    }

    private final int computePropsHash(ReadableMap readableMap, boolean z, float f, float f2) {
        return computePropsHashForMarkdown(ReadableMapExtensionsKt.getStringOrDefault(readableMap, "markdown", ""), readableMap, z, f, f2);
    }

    private final int computePropsHashForMarkdown(String str, ReadableMap readableMap, boolean z, float f, float f2) {
        ReadableMap mapOrNull = ReadableMapExtensionsKt.getMapOrNull(readableMap, "markdownStyle");
        ReadableMap mapOrNull2 = ReadableMapExtensionsKt.getMapOrNull(readableMap, "md4cFlags");
        return (((((((((((((str.hashCode() * 31) + (mapOrNull != null ? mapOrNull.hashCode() : 0)) * 31) + (mapOrNull2 != null ? mapOrNull2.hashCode() : 0)) * 31) + Float.floatToIntBits(f)) * 31) + Boolean.hashCode(z)) * 31) + Float.floatToIntBits(f2)) * 31) + Boolean.hashCode(ReadableMapExtensionsKt.getBooleanOrDefault(readableMap, "allowTrailingMargin", false))) * 31) + MarkdownViewManagerUtilsKt.parseImageRequestHeaders(ReadableMapExtensionsKt.getArrayOrNull(readableMap, "imageRequestHeaders")).hashCode();
    }

    private final float checkAndUpdateFontScale(Context context, boolean z, float f) {
        if (!z) {
            if (lastKnownFontScale != 1.0f) {
                lastKnownFontScale = 1.0f;
                data.clear();
            }
            return 1.0f;
        }
        float f2 = context.getResources().getConfiguration().fontScale;
        if (f < 1.0f || f2 <= f) {
            f = f2;
        }
        if (f == lastKnownFontScale) {
            return f;
        }
        lastKnownFontScale = f;
        data.clear();
        return f;
    }

    private final long measureAndCache(Context context, Integer num, float f, ReadableMap readableMap, boolean z, float f2, float f3) {
        String stringOrDefault = ReadableMapExtensionsKt.getStringOrDefault(readableMap, "markdown", "");
        ReadableMap mapOrNull = ReadableMapExtensionsKt.getMapOrNull(readableMap, "markdownStyle");
        Md4cFlags md4cFlags = new Md4cFlags(ReadableMapExtensionsKt.getBooleanOrDefault(ReadableMapExtensionsKt.getMapOrNull(readableMap, "md4cFlags"), "underline", false), false, ReadableMapExtensionsKt.getBooleanOrDefault(ReadableMapExtensionsKt.getMapOrNull(readableMap, "md4cFlags"), "superscript", false), ReadableMapExtensionsKt.getBooleanOrDefault(ReadableMapExtensionsKt.getMapOrNull(readableMap, "md4cFlags"), "subscript", false), ReadableMapExtensionsKt.getBooleanOrDefault(ReadableMapExtensionsKt.getMapOrNull(readableMap, "md4cFlags"), "highlight", false), false, ReadableMapExtensionsKt.getBooleanOrDefault(ReadableMapExtensionsKt.getMapOrNull(readableMap, "md4cFlags"), "hardSoftBreaks", false), 32, null);
        float initialFontSize = getInitialFontSize(mapOrNull, context, z, f2, f3);
        int iComputePropsHash = computePropsHash(readableMap, z, f2, f3);
        TextPaint textPaint = measurePaint;
        textPaint.setTextSize(initialFontSize);
        String str = stringOrDefault;
        SpannableString spannableStringTryRenderMarkdown = tryRenderMarkdown(str, mapOrNull, context, md4cFlags, z, f3, MarkdownViewManagerUtilsKt.parseImageRequestHeaders(ReadableMapExtensionsKt.getArrayOrNull(readableMap, "imageRequestHeaders")));
        if (spannableStringTryRenderMarkdown != null) {
            SpannableExtensionsKt.replaceMathSpansWithPlaceholders(spannableStringTryRenderMarkdown, context);
        }
        if (spannableStringTryRenderMarkdown != null) {
            str = spannableStringTryRenderMarkdown;
        }
        long jLongValue = ((Number) measureWithLayout(f, str, textPaint, num).getFirst()).longValue();
        long jMake = YogaMeasureOutput.make(YogaMeasureOutput.getWidth(jLongValue), YogaMeasureOutput.getHeight(jLongValue) + ((!ReadableMapExtensionsKt.getBooleanOrDefault(readableMap, "allowTrailingMargin", false) || spannableStringTryRenderMarkdown == null) ? 0.0f : PixelUtil.toDIPFromPixel(measureRenderer.getLastElementMarginBottom())));
        if (num != null) {
            ConcurrentHashMap concurrentHashMap = data;
            Typeface DEFAULT = Typeface.DEFAULT;
            Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
            concurrentHashMap.put(num, new MeasurementParams(f, jMake, str, new PaintParams(DEFAULT, initialFontSize), iComputePropsHash));
        }
        return jMake;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0046  */
    /* JADX WARN: Code duplicated, block: B:7:0x002b  */
    private final long measureAndCacheSplit(Context context, Integer num, float f, ReadableMap readableMap, boolean z, float f2, float f3) {
        TableStreamingMode tableStreamingMode;
        CodeBlockStreamingMode codeBlockStreamingMode;
        int i;
        float marginBottom;
        float f4;
        Float fValueOf;
        MeasurementParams measurementParams;
        boolean booleanOrDefault = ReadableMapExtensionsKt.getBooleanOrDefault(readableMap, "streamingAnimation", false);
        String stringOrDefault = ReadableMapExtensionsKt.getStringOrDefault(readableMap, "markdown", "");
        if (booleanOrDefault && num != null) {
            tableStreamingMode = (TableStreamingMode) streamingTableModes.get(Integer.valueOf(num.intValue()));
            if (tableStreamingMode == null) {
                tableStreamingMode = TableStreamingMode.PROGRESSIVE;
            }
        } else {
            tableStreamingMode = TableStreamingMode.PROGRESSIVE;
        }
        if (booleanOrDefault && num != null) {
            codeBlockStreamingMode = (CodeBlockStreamingMode) streamingCodeBlockModes.get(Integer.valueOf(num.intValue()));
            if (codeBlockStreamingMode == null) {
                codeBlockStreamingMode = CodeBlockStreamingMode.PROGRESSIVE;
            }
        } else {
            codeBlockStreamingMode = CodeBlockStreamingMode.PROGRESSIVE;
        }
        if (booleanOrDefault) {
            stringOrDefault = StreamingMarkdownFilter.INSTANCE.renderableMarkdownForStreaming(stringOrDefault, tableStreamingMode, codeBlockStreamingMode).getMarkdown();
        }
        String str = stringOrDefault;
        int iComputePropsHashForMarkdown = computePropsHashForMarkdown(str, readableMap, z, f2, f3);
        if (booleanOrDefault && num != null && (measurementParams = (MeasurementParams) data.get(num)) != null && measurementParams.getCachedWidth() == f && measurementParams.getMarkdownHash() == iComputePropsHashForMarkdown) {
            return measurementParams.getCachedSize();
        }
        ReadableMap mapOrNull = ReadableMapExtensionsKt.getMapOrNull(readableMap, "markdownStyle");
        if (mapOrNull == null) {
            return YogaMeasureOutput.make(PixelUtil.toDIPFromPixel(f), 0.0f);
        }
        Md4cFlags md4cFlags = new Md4cFlags(ReadableMapExtensionsKt.getBooleanOrDefault(ReadableMapExtensionsKt.getMapOrNull(readableMap, "md4cFlags"), "underline", false), false, ReadableMapExtensionsKt.getBooleanOrDefault(ReadableMapExtensionsKt.getMapOrNull(readableMap, "md4cFlags"), "superscript", false), ReadableMapExtensionsKt.getBooleanOrDefault(ReadableMapExtensionsKt.getMapOrNull(readableMap, "md4cFlags"), "subscript", false), ReadableMapExtensionsKt.getBooleanOrDefault(ReadableMapExtensionsKt.getMapOrNull(readableMap, "md4cFlags"), "highlight", false), false, ReadableMapExtensionsKt.getBooleanOrDefault(ReadableMapExtensionsKt.getMapOrNull(readableMap, "md4cFlags"), "hardSoftBreaks", false), 32, null);
        boolean booleanOrDefault2 = ReadableMapExtensionsKt.getBooleanOrDefault(readableMap, "allowTrailingMargin", false);
        float initialFontSize = getInitialFontSize(mapOrNull, context, z, f2, f3);
        try {
            MarkdownASTNode markdown = Parser.INSTANCE.getShared().parseMarkdown(str, md4cFlags);
            if (markdown == null) {
                return YogaMeasureOutput.make(PixelUtil.toDIPFromPixel(f), 0.0f);
            }
            try {
                StyleConfig styleConfig = new StyleConfig(mapOrNull, context, z, f3);
                styleConfig.setImageRequestHeaders(MarkdownViewManagerUtilsKt.parseImageRequestHeaders(ReadableMapExtensionsKt.getArrayOrNull(readableMap, "imageRequestHeaders")));
                try {
                    List<RenderedSegment> listRender = MarkdownSegmentRenderer.INSTANCE.render(MarkdownSegmentKt.splitASTIntoSegments(markdown), styleConfig, context, null, null);
                    HashMap map = new HashMap();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i2 = 0;
                    for (RenderedSegment renderedSegment : listRender) {
                        int i3 = i2 + 1;
                        if (renderedSegment instanceof RenderedSegment.Math) {
                            arrayList.add(Integer.valueOf(i2));
                            arrayList2.add(new MathMeasureRequest(styleConfig.getMathStyle().getFontSize(), ((RenderedSegment.Math) renderedSegment).getLatex(), MathRenderMode.Display));
                        }
                        i2 = i3;
                        listRender = listRender;
                    }
                    List list = listRender;
                    if (!arrayList2.isEmpty()) {
                        List listMeasureMathOnMainThread = measureMathOnMainThread(context, arrayList2);
                        int i4 = 0;
                        for (int size = arrayList.size(); i4 < size; size = size) {
                            MathMetrics mathMetrics = (MathMetrics) listMeasureMathOnMainThread.get(i4);
                            map.put(arrayList.get(i4), Float.valueOf(((int) Math.ceil(mathMetrics.getAscent() + mathMetrics.getDescent())) + (styleConfig.getMathStyle().getPadding() * 2)));
                            i4++;
                            arrayList = arrayList;
                        }
                    }
                    int iCoerceAtLeast = RangesKt.coerceAtLeast((int) Math.ceil(f), 1);
                    int lastIndex = CollectionsKt.getLastIndex(list);
                    Iterator it = list.iterator();
                    float fMax = 0.0f;
                    float marginTop = 0.0f;
                    int i5 = 0;
                    while (it.hasNext()) {
                        i5++;
                        it = it;
                        RenderedSegment renderedSegment2 = (RenderedSegment) it.next();
                        boolean z2 = i5 == lastIndex ? booleanOrDefault2 : true;
                        lastIndex = lastIndex;
                        if (renderedSegment2 instanceof RenderedSegment.Text) {
                            SpannableExtensionsKt.replaceMathSpansWithPlaceholders(((RenderedSegment.Text) renderedSegment2).getStyledText(), context);
                            StaticLayout staticLayoutCreateStaticLayout = createStaticLayout(((RenderedSegment.Text) renderedSegment2).getStyledText(), initialFontSize, iCoerceAtLeast, num);
                            float height = marginTop + staticLayoutCreateStaticLayout.getHeight();
                            i = iCoerceAtLeast;
                            Iterator it2 = RangesKt.until(0, staticLayoutCreateStaticLayout.getLineCount()).iterator();
                            if (it2.hasNext()) {
                                float lineWidth = staticLayoutCreateStaticLayout.getLineWidth(((IntIterator) it2).nextInt());
                                while (it2.hasNext()) {
                                    lineWidth = Math.max(lineWidth, staticLayoutCreateStaticLayout.getLineWidth(((IntIterator) it2).nextInt()));
                                    height = height;
                                }
                                f4 = height;
                                fValueOf = Float.valueOf(lineWidth);
                            } else {
                                fValueOf = null;
                                f4 = height;
                            }
                            fMax = Math.max(fMax, (float) Math.ceil(fValueOf != null ? fValueOf.floatValue() : 0.0f));
                            if (z2) {
                                marginTop = f4 + ((RenderedSegment.Text) renderedSegment2).getLastElementMarginBottom();
                            } else {
                                iCoerceAtLeast = i;
                                marginTop = f4;
                            }
                        } else {
                            i = iCoerceAtLeast;
                            if (renderedSegment2 instanceof RenderedSegment.Table) {
                                marginTop = marginTop + styleConfig.getTableStyle().getMarginTop() + TableContainerView.Companion.measureTableNodeHeight(((RenderedSegment.Table) renderedSegment2).getNode(), styleConfig, context);
                                if (z2) {
                                    marginBottom = styleConfig.getTableStyle().getMarginBottom();
                                    marginTop += marginBottom;
                                }
                            } else if (renderedSegment2 instanceof RenderedSegment.Math) {
                                float marginTop2 = marginTop + styleConfig.getMathStyle().getMarginTop();
                                Float f5 = (Float) map.get(Integer.valueOf(i5));
                                marginTop = marginTop2 + (f5 != null ? f5.floatValue() : 0.0f);
                                if (z2) {
                                    marginBottom = styleConfig.getMathStyle().getMarginBottom();
                                    marginTop += marginBottom;
                                }
                            } else {
                                if (!(renderedSegment2 instanceof RenderedSegment.CodeBlock)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                marginTop = marginTop + styleConfig.getCodeBlockStyle().getMarginTop() + CodeBlockContainerView.Companion.measureCodeBlockNodeHeight(((RenderedSegment.CodeBlock) renderedSegment2).getNode(), styleConfig, context, f);
                                if (z2) {
                                    marginBottom = styleConfig.getCodeBlockStyle().getMarginBottom();
                                    marginTop += marginBottom;
                                }
                            }
                            fMax = f;
                        }
                        iCoerceAtLeast = i;
                    }
                    long jMake = YogaMeasureOutput.make(RangesKt.coerceAtMost(PixelUtil.toDIPFromPixel(fMax), PixelUtil.toDIPFromPixel(f)), PixelUtil.toDIPFromPixel(marginTop));
                    if (num != null) {
                        ConcurrentHashMap concurrentHashMap = data;
                        Typeface DEFAULT = Typeface.DEFAULT;
                        Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
                        concurrentHashMap.put(num, new MeasurementParams(f, jMake, null, new PaintParams(DEFAULT, initialFontSize), iComputePropsHashForMarkdown));
                    }
                    return jMake;
                } catch (Exception unused) {
                    return measureAndCache(context, num, f, readableMap, z, f2, f3);
                }
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
        }
    }

    private final void prepareImageSpansForMeasurement(CharSequence charSequence, int i) {
        if (i <= 1) {
            return;
        }
        Spanned spanned = charSequence instanceof Spanned ? (Spanned) charSequence : null;
        if (spanned == null) {
            return;
        }
        Object[] spans = spanned.getSpans(0, spanned.length(), ImageSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        for (Object obj : spans) {
            ((ImageSpan) obj).prepareForMeasurement(spanned, i);
        }
    }

    private final StaticLayout createStaticLayout(CharSequence charSequence, float f, int i, Integer num) {
        TextPaint textPaint = measurePaint;
        textPaint.setTextSize(f);
        prepareImageSpansForMeasurement(charSequence, i);
        StaticLayout.Builder lineSpacing = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i).setIncludePad(false).setLineSpacing(0.0f, 1.0f);
        int i2 = Build.VERSION.SDK_INT;
        lineSpacing.setBreakStrategy(INSTANCE.resolveBreakStrategy(num));
        if (i2 >= 28) {
            lineSpacing.setUseLineSpacingFromFallbacks(true);
        }
        StaticLayout staticLayoutBuild = lineSpacing.build();
        Intrinsics.checkNotNullExpressionValue(staticLayoutBuild, "build(...)");
        return staticLayoutBuild;
    }

    private final SpannableString tryRenderMarkdown(String str, ReadableMap readableMap, Context context, Md4cFlags md4cFlags, boolean z, float f, Map map) {
        if (readableMap == null) {
            return null;
        }
        try {
            MarkdownASTNode markdown = Parser.INSTANCE.getShared().parseMarkdown(str, md4cFlags);
            if (markdown == null) {
                return null;
            }
            StyleConfig styleConfig = new StyleConfig(readableMap, context, z, f);
            styleConfig.setImageRequestHeaders(map);
            Renderer renderer = measureRenderer;
            renderer.configure(styleConfig, context);
            return Renderer.renderDocument$default(renderer, markdown, null, null, 4, null);
        } catch (Exception unused) {
            return null;
        }
    }

    private final float getInitialFontSize(ReadableMap readableMap, Context context, boolean z, float f, float f2) {
        double dCeil;
        ReadableMap map;
        float f3 = (readableMap == null || (map = readableMap.getMap("paragraph")) == null) ? 16.0f : (float) map.getDouble("fontSize");
        float f4 = context.getResources().getDisplayMetrics().density;
        if (!z) {
            dCeil = Math.ceil(f3 * f4);
        } else {
            if (f2 >= 1.0f && f > f2) {
                f = f2;
            }
            dCeil = Math.ceil(f3 * f * f4);
        }
        return (float) dCeil;
    }

    private final long measure(float f, CharSequence charSequence, PaintParams paintParams, Integer num) {
        TextPaint textPaint = measurePaint;
        textPaint.reset();
        textPaint.setTypeface(paintParams.getTypeface());
        textPaint.setTextSize(paintParams.getFontSize());
        return measure(f, charSequence, textPaint, num);
    }

    private final long measure(float f, CharSequence charSequence, TextPaint textPaint, Integer num) {
        Float fValueOf;
        if (charSequence == null) {
            charSequence = "";
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast((int) Math.ceil(f), 1);
        prepareImageSpansForMeasurement(charSequence, iCoerceAtLeast);
        StaticLayout.Builder lineSpacing = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, iCoerceAtLeast).setIncludePad(false).setLineSpacing(0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(lineSpacing, "setLineSpacing(...)");
        int i = Build.VERSION.SDK_INT;
        lineSpacing.setBreakStrategy(resolveBreakStrategy(num));
        if (i >= 28) {
            lineSpacing.setUseLineSpacingFromFallbacks(true);
        }
        StaticLayout staticLayoutBuild = lineSpacing.build();
        Intrinsics.checkNotNullExpressionValue(staticLayoutBuild, "build(...)");
        float height = staticLayoutBuild.getHeight();
        Iterator it = RangesKt.until(0, staticLayoutBuild.getLineCount()).iterator();
        if (it.hasNext()) {
            IntIterator intIterator = (IntIterator) it;
            float lineWidth = staticLayoutBuild.getLineWidth(intIterator.nextInt());
            while (it.hasNext()) {
                lineWidth = Math.max(lineWidth, staticLayoutBuild.getLineWidth(intIterator.nextInt()));
            }
            fValueOf = Float.valueOf(lineWidth);
        } else {
            fValueOf = null;
        }
        return YogaMeasureOutput.make(PixelUtil.toDIPFromPixel((float) Math.ceil(fValueOf != null ? fValueOf.floatValue() : 0.0f)), PixelUtil.toDIPFromPixel(height));
    }

    private final Pair measureWithLayout(float f, CharSequence charSequence, TextPaint textPaint, Integer num) {
        Float fValueOf;
        if (charSequence == null) {
            charSequence = "";
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast((int) Math.ceil(f), 1);
        prepareImageSpansForMeasurement(charSequence, iCoerceAtLeast);
        StaticLayout.Builder lineSpacing = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, iCoerceAtLeast).setIncludePad(false).setLineSpacing(0.0f, 1.0f);
        int i = Build.VERSION.SDK_INT;
        lineSpacing.setBreakStrategy(INSTANCE.resolveBreakStrategy(num));
        if (i >= 28) {
            lineSpacing.setUseLineSpacingFromFallbacks(true);
        }
        StaticLayout staticLayoutBuild = lineSpacing.build();
        Intrinsics.checkNotNullExpressionValue(staticLayoutBuild, "build(...)");
        Iterator it = RangesKt.until(0, staticLayoutBuild.getLineCount()).iterator();
        if (it.hasNext()) {
            IntIterator intIterator = (IntIterator) it;
            float lineWidth = staticLayoutBuild.getLineWidth(intIterator.nextInt());
            while (it.hasNext()) {
                lineWidth = Math.max(lineWidth, staticLayoutBuild.getLineWidth(intIterator.nextInt()));
            }
            fValueOf = Float.valueOf(lineWidth);
        } else {
            fValueOf = null;
        }
        return TuplesKt.to(Long.valueOf(YogaMeasureOutput.make(PixelUtil.toDIPFromPixel((float) Math.ceil(fValueOf != null ? fValueOf.floatValue() : 0.0f)), PixelUtil.toDIPFromPixel(staticLayoutBuild.getHeight()))), staticLayoutBuild);
    }

    private final List measureMathOnMainThread(Context context, List list) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.estimateMathFallback((MathMeasureRequest) it.next()));
        }
        return arrayList;
    }

    private final MathMetrics estimateMathFallback(MathMeasureRequest mathMeasureRequest) {
        float fontSize = mathMeasureRequest.getFontSize() * 1.4f;
        return new MathMetrics((int) RangesKt.coerceIn(mathMeasureRequest.getFontSize() * mathMeasureRequest.getLatex().length() * 0.5f, mathMeasureRequest.getFontSize(), mathMeasureRequest.getFontSize() * 20.0f), 0.7f * fontSize, fontSize * 0.3f);
    }
}
