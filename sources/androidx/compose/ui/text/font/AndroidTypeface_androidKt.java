package androidx.compose.ui.text.font;

import androidx.compose.ui.text.platform.AndroidTypefaceWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidTypeface_androidKt {
    public static final Typeface Typeface(android.graphics.Typeface typeface) {
        return new AndroidTypefaceWrapper(typeface);
    }

    public static final FontFamily FontFamily(android.graphics.Typeface typeface) {
        return FontFamilyKt.FontFamily(Typeface(typeface));
    }
}
