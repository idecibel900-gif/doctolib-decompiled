package com.facebook.react.views.text.internal.span;

import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.views.text.ReactTypefaceUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CustomStyleSpan extends MetricAffectingSpan implements ReactSpan {
    public static final Companion Companion = new Companion(null);
    private final AssetManager assetManager;
    private final String fontFamily;
    private final String fontFeatureSettings;
    private final int privateStyle;
    private final int privateWeight;

    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public CustomStyleSpan(int i, int i2, String str, String str2, AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        this.privateStyle = i;
        this.privateWeight = i2;
        this.fontFeatureSettings = str;
        this.fontFamily = str2;
        this.assetManager = assetManager;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        Companion.apply(ds, this.privateStyle, this.privateWeight, this.fontFeatureSettings, this.fontFamily, this.assetManager);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Companion.apply(paint, this.privateStyle, this.privateWeight, this.fontFeatureSettings, this.fontFamily, this.assetManager);
    }

    public final int getStyle() {
        int i = this.privateStyle;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    public final int getWeight() {
        int i = this.privateWeight;
        if (i == -1) {
            return 400;
        }
        return i;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void apply(Paint paint, int i, int i2, String str, String str2, AssetManager assetManager) {
            Typeface typefaceApplyStyles = ReactTypefaceUtils.applyStyles(paint.getTypeface(), i, i2, str2, assetManager);
            paint.setFontFeatureSettings(str);
            paint.setTypeface(typefaceApplyStyles);
            paint.setSubpixelText(true);
            if (ReactNativeFeatureFlags.enableAndroidLinearText()) {
                paint.setLinearText(true);
            }
        }
    }
}
