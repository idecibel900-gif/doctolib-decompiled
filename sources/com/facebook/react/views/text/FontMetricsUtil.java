package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMapBuilder;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class FontMetricsUtil {
    public static final FontMetricsUtil INSTANCE = new FontMetricsUtil();

    private FontMetricsUtil() {
    }

    public static final WritableArray getFontMetrics(CharSequence text, Layout layout, Context context) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(context, "context");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        TextPaint textPaint = new TextPaint(layout.getPaint());
        textPaint.setTextSize(textPaint.getTextSize() * 100.0f);
        Rect rect = new Rect();
        int i = 0;
        int i2 = 1;
        textPaint.getTextBounds("T", 0, 1, rect);
        float fHeight = (rect.height() / 100.0f) / displayMetrics.density;
        Rect rect2 = new Rect();
        String str = "x";
        textPaint.getTextBounds("x", 0, 1, rect2);
        float fHeight2 = (rect2.height() / 100.0f) / displayMetrics.density;
        int lineCount = layout.getLineCount();
        while (i < lineCount) {
            float lineWidth = (text.length() <= 0 || text.charAt(layout.getLineEnd(i) - i2) != '\n') ? layout.getLineWidth(i) : layout.getLineMax(i);
            Rect rect3 = new Rect();
            layout.getLineBounds(i, rect3);
            WritableMap writableMapCreateMap = Arguments.createMap();
            ReadableMapBuilder readableMapBuilder = new ReadableMapBuilder(writableMapCreateMap);
            readableMapBuilder.put(str, layout.getLineLeft(i) / displayMetrics.density);
            readableMapBuilder.put("y", rect3.top / displayMetrics.density);
            readableMapBuilder.put("width", lineWidth / displayMetrics.density);
            readableMapBuilder.put("height", rect3.height() / displayMetrics.density);
            readableMapBuilder.put("descender", layout.getLineDescent(i) / displayMetrics.density);
            readableMapBuilder.put("ascender", (-layout.getLineAscent(i)) / displayMetrics.density);
            readableMapBuilder.put("baseline", layout.getLineBaseline(i) / displayMetrics.density);
            readableMapBuilder.put("capHeight", fHeight);
            readableMapBuilder.put("xHeight", fHeight2);
            readableMapBuilder.put("text", text.subSequence(layout.getLineStart(i), layout.getLineEnd(i)).toString());
            writableArrayCreateArray.pushMap(writableMapCreateMap);
            i++;
            str = str;
            lineCount = lineCount;
            i2 = 1;
        }
        return writableArrayCreateArray;
    }
}
