package androidx.compose.ui.text.font;

import android.content.res.AssetManager;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidFontKt {
    /* JADX INFO: renamed from: Font-MuC2MFs$default, reason: not valid java name */
    public static /* synthetic */ Font m2252FontMuC2MFs$default(String str, AssetManager assetManager, FontWeight fontWeight, int i, FontVariation.Settings settings, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 8) != 0) {
            i = FontStyle.Companion.m2289getNormal_LCdwA();
        }
        if ((i2 & 16) != 0) {
            settings = FontVariation.INSTANCE.m2304Settings6EWAqTQ(fontWeight, i, new FontVariation.Setting[0]);
        }
        return m2251FontMuC2MFs(str, assetManager, fontWeight, i, settings);
    }

    /* JADX INFO: renamed from: Font-MuC2MFs, reason: not valid java name */
    public static final Font m2251FontMuC2MFs(String str, AssetManager assetManager, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        return new AndroidAssetFont(assetManager, str, fontWeight, i, settings, null);
    }

    /* JADX INFO: renamed from: Font-Ej4NQ78$default, reason: not valid java name */
    public static /* synthetic */ Font m2250FontEj4NQ78$default(File file, FontWeight fontWeight, int i, FontVariation.Settings settings, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.Companion.m2289getNormal_LCdwA();
        }
        if ((i2 & 8) != 0) {
            settings = FontVariation.INSTANCE.m2304Settings6EWAqTQ(fontWeight, i, new FontVariation.Setting[0]);
        }
        return m2249FontEj4NQ78(file, fontWeight, i, settings);
    }

    /* JADX INFO: renamed from: Font-Ej4NQ78, reason: not valid java name */
    public static final Font m2249FontEj4NQ78(File file, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        return new AndroidFileFont(file, fontWeight, i, settings, null);
    }
}
