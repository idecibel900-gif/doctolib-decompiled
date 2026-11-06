package androidx.compose.ui.text.font;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class LoadedFontFamily extends FontFamily {
    private final Typeface typeface;

    public LoadedFontFamily(Typeface typeface) {
        super(true, null);
        this.typeface = typeface;
    }

    public final Typeface getTypeface() {
        return this.typeface;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LoadedFontFamily) && Intrinsics.areEqual(this.typeface, ((LoadedFontFamily) obj).typeface);
    }

    public int hashCode() {
        return this.typeface.hashCode();
    }

    public String toString() {
        return "LoadedFontFamily(typeface=" + this.typeface + ')';
    }
}
