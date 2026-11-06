package androidx.compose.ui.text.font;

/* JADX INFO: loaded from: classes.dex */
public abstract class DeviceFontFamilyNameFontKt {
    /* JADX INFO: renamed from: Font-vxs03AY$default, reason: not valid java name */
    public static /* synthetic */ Font m2268Fontvxs03AY$default(String str, FontWeight fontWeight, int i, FontVariation.Settings settings, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.Companion.m2289getNormal_LCdwA();
        }
        if ((i2 & 8) != 0) {
            settings = new FontVariation.Settings(new FontVariation.Setting[0]);
        }
        return m2267Fontvxs03AY(str, fontWeight, i, settings);
    }

    /* JADX INFO: renamed from: Font-vxs03AY, reason: not valid java name */
    public static final Font m2267Fontvxs03AY(String str, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        return new DeviceFontFamilyNameFont(str, fontWeight, i, settings, null);
    }
}
