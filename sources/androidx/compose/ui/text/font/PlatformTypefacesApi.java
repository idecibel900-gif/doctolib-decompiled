package androidx.compose.ui.text.font;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class PlatformTypefacesApi implements PlatformTypefaces {
    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createDefault-FO1MlWM */
    public android.graphics.Typeface mo2307createDefaultFO1MlWM(FontWeight fontWeight, int i) {
        return m2310createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, i);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createNamed-RetOiIg */
    public android.graphics.Typeface mo2308createNamedRetOiIg(GenericFontFamily genericFontFamily, FontWeight fontWeight, int i) {
        android.graphics.Typeface typefaceM2311loadNamedFromTypefaceCacheOrNullRetOiIg = m2311loadNamedFromTypefaceCacheOrNullRetOiIg(PlatformTypefaces_androidKt.getWeightSuffixForFallbackFamilyName(genericFontFamily.getName(), fontWeight), fontWeight, i);
        return typefaceM2311loadNamedFromTypefaceCacheOrNullRetOiIg == null ? m2310createAndroidTypefaceUsingTypefaceStyleRetOiIg(genericFontFamily.getName(), fontWeight, i) : typefaceM2311loadNamedFromTypefaceCacheOrNullRetOiIg;
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: optionalOnDeviceFontFamilyByName-78DK7lM */
    public android.graphics.Typeface mo2309optionalOnDeviceFontFamilyByName78DK7lM(String str, FontWeight fontWeight, int i, FontVariation.Settings settings, Context context) {
        android.graphics.Typeface typefaceMo2308createNamedRetOiIg;
        FontFamily.Companion companion = FontFamily.Companion;
        if (Intrinsics.areEqual(str, companion.getSansSerif().getName())) {
            typefaceMo2308createNamedRetOiIg = mo2308createNamedRetOiIg(companion.getSansSerif(), fontWeight, i);
        } else if (Intrinsics.areEqual(str, companion.getSerif().getName())) {
            typefaceMo2308createNamedRetOiIg = mo2308createNamedRetOiIg(companion.getSerif(), fontWeight, i);
        } else if (Intrinsics.areEqual(str, companion.getMonospace().getName())) {
            typefaceMo2308createNamedRetOiIg = mo2308createNamedRetOiIg(companion.getMonospace(), fontWeight, i);
        } else {
            typefaceMo2308createNamedRetOiIg = Intrinsics.areEqual(str, companion.getCursive().getName()) ? mo2308createNamedRetOiIg(companion.getCursive(), fontWeight, i) : m2311loadNamedFromTypefaceCacheOrNullRetOiIg(str, fontWeight, i);
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(typefaceMo2308createNamedRetOiIg, settings, context);
    }

    /* JADX INFO: renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m2311loadNamedFromTypefaceCacheOrNullRetOiIg(String str, FontWeight fontWeight, int i) {
        if (str.length() == 0) {
            return null;
        }
        android.graphics.Typeface typefaceM2310createAndroidTypefaceUsingTypefaceStyleRetOiIg = m2310createAndroidTypefaceUsingTypefaceStyleRetOiIg(str, fontWeight, i);
        if (Intrinsics.areEqual(typefaceM2310createAndroidTypefaceUsingTypefaceStyleRetOiIg, android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, AndroidFontUtils_androidKt.m2253getAndroidTypefaceStyleFO1MlWM(fontWeight, i))) || Intrinsics.areEqual(typefaceM2310createAndroidTypefaceUsingTypefaceStyleRetOiIg, m2310createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, i))) {
            return null;
        }
        return typefaceM2310createAndroidTypefaceUsingTypefaceStyleRetOiIg;
    }

    /* JADX INFO: renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m2310createAndroidTypefaceUsingTypefaceStyleRetOiIg(String str, FontWeight fontWeight, int i) {
        if (FontStyle.m2284equalsimpl0(i, FontStyle.Companion.m2289getNormal_LCdwA()) && Intrinsics.areEqual(fontWeight, FontWeight.Companion.getNormal()) && (str == null || str.length() == 0)) {
            return android.graphics.Typeface.DEFAULT;
        }
        int iM2253getAndroidTypefaceStyleFO1MlWM = AndroidFontUtils_androidKt.m2253getAndroidTypefaceStyleFO1MlWM(fontWeight, i);
        if (str == null || str.length() == 0) {
            return android.graphics.Typeface.defaultFromStyle(iM2253getAndroidTypefaceStyleFO1MlWM);
        }
        return android.graphics.Typeface.create(str, iM2253getAndroidTypefaceStyleFO1MlWM);
    }
}
