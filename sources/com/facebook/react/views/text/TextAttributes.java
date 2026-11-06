package com.facebook.react.views.text;

import com.facebook.common.logging.FLog;
import com.facebook.react.uimanager.PixelUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class TextAttributes {
    public static final Companion Companion = new Companion(null);
    private boolean allowFontScaling = true;
    private float fontSize = Float.NaN;
    private float lineHeight = Float.NaN;
    private float letterSpacing = Float.NaN;
    private float heightOfTallestInlineViewOrImage = Float.NaN;
    public TextTransform textTransform = TextTransform.UNSET;
    private float maxFontSizeMultiplier = Float.NaN;

    public final boolean getAllowFontScaling() {
        return this.allowFontScaling;
    }

    public final void setAllowFontScaling(boolean z) {
        this.allowFontScaling = z;
    }

    public final void setFontSize(float f) {
        this.fontSize = f;
    }

    public final void setLineHeight(float f) {
        this.lineHeight = f;
    }

    public final void setLetterSpacing(float f) {
        this.letterSpacing = f;
    }

    public final void setHeightOfTallestInlineViewOrImage(float f) {
        this.heightOfTallestInlineViewOrImage = f;
    }

    public final TextAttributes applyChild(TextAttributes child) {
        Intrinsics.checkNotNullParameter(child, "child");
        TextAttributes textAttributes = new TextAttributes();
        textAttributes.allowFontScaling = this.allowFontScaling;
        textAttributes.fontSize = !Float.isNaN(child.fontSize) ? child.fontSize : this.fontSize;
        textAttributes.lineHeight = !Float.isNaN(child.lineHeight) ? child.lineHeight : this.lineHeight;
        textAttributes.letterSpacing = !Float.isNaN(child.letterSpacing) ? child.letterSpacing : this.letterSpacing;
        textAttributes.setMaxFontSizeMultiplier(!Float.isNaN(child.maxFontSizeMultiplier) ? child.maxFontSizeMultiplier : this.maxFontSizeMultiplier);
        textAttributes.heightOfTallestInlineViewOrImage = !Float.isNaN(child.heightOfTallestInlineViewOrImage) ? child.heightOfTallestInlineViewOrImage : this.heightOfTallestInlineViewOrImage;
        TextTransform textTransform = child.textTransform;
        if (textTransform == TextTransform.UNSET) {
            textTransform = this.textTransform;
        }
        textAttributes.textTransform = textTransform;
        return textAttributes;
    }

    public final float getMaxFontSizeMultiplier() {
        return this.maxFontSizeMultiplier;
    }

    public final void setMaxFontSizeMultiplier(float f) {
        if (f != 0.0f && f < 1.0f && !Float.isNaN(f)) {
            FLog.w("ReactNative", "maxFontSizeMultiplier must be NaN, 0, or >= 1");
            this.maxFontSizeMultiplier = Float.NaN;
        } else {
            this.maxFontSizeMultiplier = f;
        }
    }

    public final int getEffectiveFontSize() {
        double dCeil;
        float f = !Float.isNaN(this.fontSize) ? this.fontSize : 14.0f;
        if (this.allowFontScaling) {
            dCeil = Math.ceil(PixelUtil.toPixelFromSP(f, getEffectiveMaxFontSizeMultiplier()));
        } else {
            dCeil = Math.ceil(PixelUtil.toPixelFromDIP(f));
        }
        return (int) dCeil;
    }

    public final float getEffectiveLineHeight() {
        if (Float.isNaN(this.lineHeight)) {
            return Float.NaN;
        }
        float pixelFromSP = this.allowFontScaling ? PixelUtil.toPixelFromSP(this.lineHeight, getEffectiveMaxFontSizeMultiplier()) : PixelUtil.toPixelFromDIP(this.lineHeight);
        if (!Float.isNaN(this.heightOfTallestInlineViewOrImage)) {
            float f = this.heightOfTallestInlineViewOrImage;
            if (f > pixelFromSP) {
                return f;
            }
        }
        return pixelFromSP;
    }

    public final float getEffectiveLetterSpacing() {
        float pixelFromDIP;
        if (Float.isNaN(this.letterSpacing)) {
            return Float.NaN;
        }
        if (this.allowFontScaling) {
            pixelFromDIP = PixelUtil.toPixelFromSP(this.letterSpacing, getEffectiveMaxFontSizeMultiplier());
        } else {
            pixelFromDIP = PixelUtil.toPixelFromDIP(this.letterSpacing);
        }
        return pixelFromDIP / getEffectiveFontSize();
    }

    public final float getEffectiveMaxFontSizeMultiplier() {
        if (Float.isNaN(this.maxFontSizeMultiplier)) {
            return 0.0f;
        }
        return this.maxFontSizeMultiplier;
    }

    public String toString() {
        return StringsKt.trimIndent("\n        TextAttributes {\n          getAllowFontScaling(): " + this.allowFontScaling + "\n          getFontSize(): " + this.fontSize + "\n          getEffectiveFontSize(): " + getEffectiveFontSize() + "\n          getHeightOfTallestInlineViewOrImage(): " + this.heightOfTallestInlineViewOrImage + "\n          getLetterSpacing(): " + this.letterSpacing + "\n          getEffectiveLetterSpacing(): " + getEffectiveLetterSpacing() + "\n          getLineHeight(): " + this.lineHeight + "\n          getEffectiveLineHeight(): " + getEffectiveLineHeight() + "\n          getTextTransform(): " + this.textTransform + "\n          getMaxFontSizeMultiplier(): " + this.maxFontSizeMultiplier + "\n          getEffectiveMaxFontSizeMultiplier(): " + getEffectiveMaxFontSizeMultiplier() + "\n        }\n      ");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
