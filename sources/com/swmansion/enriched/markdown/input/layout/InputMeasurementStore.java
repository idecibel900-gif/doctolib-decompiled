package com.swmansion.enriched.markdown.input.layout;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.appcompat.widget.AppCompatEditText;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.swmansion.enriched.markdown.input.formatting.InputParser;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class InputMeasurementStore {
    public static final InputMeasurementStore INSTANCE = new InputMeasurementStore();
    private static final ConcurrentHashMap data = new ConcurrentHashMap();

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
            Typeface typeface = this.typeface;
            return ((typeface == null ? 0 : typeface.hashCode()) * 31) + Float.hashCode(this.fontSize);
        }

        public String toString() {
            return "PaintParams(typeface=" + this.typeface + ", fontSize=" + this.fontSize + ")";
        }

        public PaintParams(Typeface typeface, float f) {
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

    private InputMeasurementStore() {
    }

    private static final class MeasurementParams {
        private final long cachedSize;
        private final float cachedWidth;
        private final PaintParams paintParams;
        private final CharSequence text;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MeasurementParams)) {
                return false;
            }
            MeasurementParams measurementParams = (MeasurementParams) obj;
            return Float.compare(this.cachedWidth, measurementParams.cachedWidth) == 0 && this.cachedSize == measurementParams.cachedSize && Intrinsics.areEqual(this.text, measurementParams.text) && Intrinsics.areEqual(this.paintParams, measurementParams.paintParams);
        }

        public int hashCode() {
            int iHashCode = ((Float.hashCode(this.cachedWidth) * 31) + Long.hashCode(this.cachedSize)) * 31;
            CharSequence charSequence = this.text;
            return ((iHashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31) + this.paintParams.hashCode();
        }

        public String toString() {
            float f = this.cachedWidth;
            long j = this.cachedSize;
            CharSequence charSequence = this.text;
            return "MeasurementParams(cachedWidth=" + f + ", cachedSize=" + j + ", text=" + ((Object) charSequence) + ", paintParams=" + this.paintParams + ")";
        }

        public MeasurementParams(float f, long j, CharSequence charSequence, PaintParams paintParams) {
            Intrinsics.checkNotNullParameter(paintParams, "paintParams");
            this.cachedWidth = f;
            this.cachedSize = j;
            this.text = charSequence;
            this.paintParams = paintParams;
        }

        public final float getCachedWidth() {
            return this.cachedWidth;
        }

        public final long getCachedSize() {
            return this.cachedSize;
        }

        public final CharSequence getText() {
            return this.text;
        }

        public final PaintParams getPaintParams() {
            return this.paintParams;
        }
    }

    public final boolean store(int i, CharSequence charSequence, TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        ConcurrentHashMap concurrentHashMap = data;
        MeasurementParams measurementParams = (MeasurementParams) concurrentHashMap.get(Integer.valueOf(i));
        float cachedWidth = measurementParams != null ? measurementParams.getCachedWidth() : 0.0f;
        MeasurementParams measurementParams2 = (MeasurementParams) concurrentHashMap.get(Integer.valueOf(i));
        long cachedSize = measurementParams2 != null ? measurementParams2.getCachedSize() : 0L;
        long jMeasure = measure(cachedWidth, charSequence, paint);
        concurrentHashMap.put(Integer.valueOf(i), new MeasurementParams(cachedWidth, jMeasure, charSequence, new PaintParams(paint.getTypeface(), paint.getTextSize())));
        return jMeasure != cachedSize;
    }

    public final void release(int i) {
        data.remove(Integer.valueOf(i));
    }

    public final long getMeasureById(Context context, Integer num, float f, float f2, YogaMeasureMode yogaMeasureMode, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(context, "context");
        long measureByIdInternal = getMeasureByIdInternal(context, num, f, readableMap);
        if (yogaMeasureMode != YogaMeasureMode.AT_MOST) {
            return measureByIdInternal;
        }
        return YogaMeasureOutput.make(YogaMeasureOutput.getWidth(measureByIdInternal), RangesKt.coerceAtMost(YogaMeasureOutput.getHeight(measureByIdInternal), PixelUtil.toDIPFromPixel(f2)));
    }

    private final long getMeasureByIdInternal(Context context, Integer num, float f, ReadableMap readableMap) {
        if (num == null) {
            return initialMeasure(context, f, readableMap);
        }
        ConcurrentHashMap concurrentHashMap = data;
        MeasurementParams measurementParams = (MeasurementParams) concurrentHashMap.get(num);
        if (measurementParams == null) {
            return initialMeasure(context, f, readableMap);
        }
        if (f == measurementParams.getCachedWidth()) {
            return measurementParams.getCachedSize();
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setTypeface(measurementParams.getPaintParams().getTypeface());
        textPaint.setTextSize(measurementParams.getPaintParams().getFontSize());
        long jMeasure = measure(f, measurementParams.getText(), textPaint);
        concurrentHashMap.put(num, new MeasurementParams(f, jMeasure, measurementParams.getText(), measurementParams.getPaintParams()));
        return jMeasure;
    }

    private final long initialMeasure(Context context, float f, ReadableMap readableMap) {
        String string;
        if (readableMap == null || (string = readableMap.getString("defaultValue")) == null) {
            string = readableMap != null ? readableMap.getString("placeholder") : null;
            if (string == null) {
                string = "I";
            }
        }
        String plainText = InputParser.INSTANCE.parseToPlainTextAndRanges(string).getPlainText();
        float fCeil = (float) Math.ceil(PixelUtil.toPixelFromSP$default(readableMap != null ? (float) readableMap.getDouble("fontSize") : 16.0f, 0.0f, 2, null));
        TextPaint textPaint = new TextPaint(new AppCompatEditText(context).getPaint());
        textPaint.setTextSize(fCeil);
        textPaint.setAntiAlias(true);
        return measure(f, plainText, textPaint);
    }

    private final long measure(float f, CharSequence charSequence, TextPaint textPaint) {
        if (charSequence == null) {
            charSequence = "";
        }
        StaticLayout.Builder lineSpacing = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, RangesKt.coerceAtLeast((int) f, 0)).setIncludePad(true).setLineSpacing(0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(lineSpacing, "setLineSpacing(...)");
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            lineSpacing.setBreakStrategy(1);
        }
        if (i >= 28) {
            lineSpacing.setUseLineSpacingFromFallbacks(true);
        }
        StaticLayout staticLayoutBuild = lineSpacing.build();
        Intrinsics.checkNotNullExpressionValue(staticLayoutBuild, "build(...)");
        return YogaMeasureOutput.make(PixelUtil.toDIPFromPixel(f), PixelUtil.toDIPFromPixel(staticLayoutBuild.getHeight()));
    }
}
