package androidx.compose.ui.text.font;

/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidFontUtils_androidKt {
    public static final int getAndroidTypefaceStyle(boolean z, boolean z2) {
        if (z2 && z) {
            return 3;
        }
        if (z) {
            return 1;
        }
        return z2 ? 2 : 0;
    }

    public static final FontWeight getAndroidBold(FontWeight.Companion companion) {
        return companion.getW600();
    }

    /* JADX INFO: renamed from: getAndroidTypefaceStyle-FO1MlWM, reason: not valid java name */
    public static final int m2253getAndroidTypefaceStyleFO1MlWM(FontWeight fontWeight, int i) {
        return getAndroidTypefaceStyle(fontWeight.compareTo(getAndroidBold(FontWeight.Companion)) >= 0, FontStyle.m2284equalsimpl0(i, FontStyle.Companion.m2288getItalic_LCdwA()));
    }
}
