package androidx.compose.ui.text.googlefonts;

import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontWeight;

/* JADX INFO: loaded from: classes.dex */
public abstract class GoogleFontKt {
    /* JADX INFO: renamed from: Font-wCLgNak, reason: not valid java name */
    public static final Font m2319FontwCLgNak(GoogleFont googleFont, GoogleFont.Provider provider, FontWeight fontWeight, int i) {
        return new GoogleFontImpl(googleFont.getName(), provider, fontWeight, i, googleFont.getBestEffort(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String reasonToString(int i) {
        if (i == -4) {
            return "Font was not loaded due to security issues. This usually means the font was attempted to load in a restricted context";
        }
        if (i == -3) {
            return "Generic error loading font, for example variation settings were not parsable";
        }
        if (i == -2) {
            return "The given provider cannot be authenticated with the certificates given.";
        }
        if (i == -1) {
            return "The requested provider was not found on this device.";
        }
        if (i == 1) {
            return "Font not found, please check availability on GoogleFont.Provider.AllFontsList: https://fonts.gstatic.com/s/a/directory.xml";
        }
        if (i == 2) {
            return "The provider found the queried font, but it is currently unavailable.";
        }
        if (i == 3) {
            return "The given query was not supported by this provider.";
        }
        return "Unknown error code";
    }
}
