package androidx.compose.ui.text.font;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class PlatformTypefacesApi28 implements PlatformTypefaces {
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
            typefaceMo2308createNamedRetOiIg = Intrinsics.areEqual(str, companion.getCursive().getName()) ? mo2308createNamedRetOiIg(companion.getCursive(), fontWeight, i) : m2313loadNamedFromTypefaceCacheOrNullRetOiIg(str, fontWeight, i);
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(typefaceMo2308createNamedRetOiIg, settings, context);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createDefault-FO1MlWM */
    public android.graphics.Typeface mo2307createDefaultFO1MlWM(FontWeight fontWeight, int i) {
        return m2312createAndroidTypefaceApi28RetOiIg(null, fontWeight, i);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    /* JADX INFO: renamed from: createNamed-RetOiIg */
    public android.graphics.Typeface mo2308createNamedRetOiIg(GenericFontFamily genericFontFamily, FontWeight fontWeight, int i) {
        return m2312createAndroidTypefaceApi28RetOiIg(genericFontFamily.getName(), fontWeight, i);
    }

    /* JADX INFO: renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m2313loadNamedFromTypefaceCacheOrNullRetOiIg(String str, FontWeight fontWeight, int i) {
        if (str.length() == 0) {
            return null;
        }
        android.graphics.Typeface typefaceM2312createAndroidTypefaceApi28RetOiIg = m2312createAndroidTypefaceApi28RetOiIg(str, fontWeight, i);
        if (Intrinsics.areEqual(typefaceM2312createAndroidTypefaceApi28RetOiIg, TypefaceHelperMethodsApi28.INSTANCE.create(android.graphics.Typeface.DEFAULT, fontWeight.getWeight(), FontStyle.m2284equalsimpl0(i, FontStyle.Companion.m2288getItalic_LCdwA()))) || Intrinsics.areEqual(typefaceM2312createAndroidTypefaceApi28RetOiIg, m2312createAndroidTypefaceApi28RetOiIg(null, fontWeight, i))) {
            return null;
        }
        return typefaceM2312createAndroidTypefaceApi28RetOiIg;
    }

    /* JADX INFO: renamed from: createAndroidTypefaceApi28-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m2312createAndroidTypefaceApi28RetOiIg(String str, FontWeight fontWeight, int i) {
        android.graphics.Typeface typefaceCreate;
        FontStyle.Companion companion = FontStyle.Companion;
        if (FontStyle.m2284equalsimpl0(i, companion.m2289getNormal_LCdwA()) && Intrinsics.areEqual(fontWeight, FontWeight.Companion.getNormal()) && (str == null || str.length() == 0)) {
            return android.graphics.Typeface.DEFAULT;
        }
        if (str == null) {
            typefaceCreate = android.graphics.Typeface.DEFAULT;
        } else {
            typefaceCreate = android.graphics.Typeface.create(str, 0);
        }
        return android.graphics.Typeface.create(typefaceCreate, fontWeight.getWeight(), FontStyle.m2284equalsimpl0(i, companion.m2288getItalic_LCdwA()));
    }
}
