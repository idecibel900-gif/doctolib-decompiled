package androidx.compose.ui.text.font;

import java.util.List;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class FontFamilyKt {
    public static final FontFamily FontFamily(List list) {
        return new FontListFontFamily(list);
    }

    public static final FontFamily FontFamily(Font... fontArr) {
        return new FontListFontFamily(ArraysKt.asList(fontArr));
    }

    public static final FontFamily FontFamily(Typeface typeface) {
        return new LoadedFontFamily(typeface);
    }
}
