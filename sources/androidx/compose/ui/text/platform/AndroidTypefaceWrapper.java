package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.ui.text.font.FontWeight;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidTypefaceWrapper implements AndroidTypeface {
    private final Typeface typeface;

    public AndroidTypefaceWrapper(Typeface typeface) {
        this.typeface = typeface;
    }

    @Override // androidx.compose.ui.text.platform.AndroidTypeface
    /* JADX INFO: renamed from: getNativeTypeface-PYhJU0U */
    public Typeface mo2394getNativeTypefacePYhJU0U(FontWeight fontWeight, int i, int i2) {
        return this.typeface;
    }
}
