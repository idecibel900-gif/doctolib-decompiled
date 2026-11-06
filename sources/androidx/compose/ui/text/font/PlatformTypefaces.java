package androidx.compose.ui.text.font;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface PlatformTypefaces {
    /* JADX INFO: renamed from: createDefault-FO1MlWM, reason: not valid java name */
    android.graphics.Typeface mo2307createDefaultFO1MlWM(FontWeight fontWeight, int i);

    /* JADX INFO: renamed from: createNamed-RetOiIg, reason: not valid java name */
    android.graphics.Typeface mo2308createNamedRetOiIg(GenericFontFamily genericFontFamily, FontWeight fontWeight, int i);

    /* JADX INFO: renamed from: optionalOnDeviceFontFamilyByName-78DK7lM, reason: not valid java name */
    android.graphics.Typeface mo2309optionalOnDeviceFontFamilyByName78DK7lM(String str, FontWeight fontWeight, int i, FontVariation.Settings settings, Context context);
}
