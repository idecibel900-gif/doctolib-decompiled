package androidx.compose.ui.text.font;

import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class FontSynthesis_androidKt {
    /* JADX WARN: Code duplicated, block: B:14:0x0033  */
    /* JADX INFO: renamed from: synthesizeTypeface-FxwP2eA, reason: not valid java name */
    public static final Object m2303synthesizeTypefaceFxwP2eA(int i, Object obj, Font font, FontWeight fontWeight, int i2) {
        boolean z;
        int weight;
        boolean zM2284equalsimpl0;
        if (!(obj instanceof android.graphics.Typeface)) {
            return obj;
        }
        boolean z2 = false;
        if (!FontSynthesis.m2296isWeightOnimpl$ui_text_release(i) || Intrinsics.areEqual(font.getWeight(), fontWeight)) {
            z = false;
        } else {
            FontWeight.Companion companion = FontWeight.Companion;
            if (fontWeight.compareTo(AndroidFontUtils_androidKt.getAndroidBold(companion)) < 0 || font.getWeight().compareTo(AndroidFontUtils_androidKt.getAndroidBold(companion)) >= 0) {
                z = false;
            } else {
                z = true;
            }
        }
        boolean z3 = FontSynthesis.m2295isStyleOnimpl$ui_text_release(i) && !FontStyle.m2284equalsimpl0(i2, font.mo2254getStyle_LCdwA());
        if (!z3 && !z) {
            return obj;
        }
        if (Build.VERSION.SDK_INT < 28) {
            if (z3 && FontStyle.m2284equalsimpl0(i2, FontStyle.Companion.m2288getItalic_LCdwA())) {
                z2 = true;
            }
            return android.graphics.Typeface.create((android.graphics.Typeface) obj, AndroidFontUtils_androidKt.getAndroidTypefaceStyle(z, z2));
        }
        if (z) {
            weight = fontWeight.getWeight();
        } else {
            weight = font.getWeight().getWeight();
        }
        if (z3) {
            zM2284equalsimpl0 = FontStyle.m2284equalsimpl0(i2, FontStyle.Companion.m2288getItalic_LCdwA());
        } else {
            zM2284equalsimpl0 = FontStyle.m2284equalsimpl0(font.mo2254getStyle_LCdwA(), FontStyle.Companion.m2288getItalic_LCdwA());
        }
        return TypefaceHelperMethodsApi28.INSTANCE.create((android.graphics.Typeface) obj, weight, zM2284equalsimpl0);
    }
}
