package androidx.compose.ui.text.font;

import android.content.Context;
import android.os.Build;
import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidFileFont extends AndroidPreloadedFont {
    private final File file;

    public /* synthetic */ AndroidFileFont(File file, FontWeight fontWeight, int i, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, fontWeight, i, settings);
    }

    private AndroidFileFont(File file, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        super(fontWeight, i, settings, null);
        this.file = file;
        setTypeface$ui_text_release(doLoad$ui_text_release(null));
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public android.graphics.Typeface doLoad$ui_text_release(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return TypefaceBuilderCompat.INSTANCE.createFromFile(this.file, context, getVariationSettings());
        }
        return android.graphics.Typeface.createFromFile(this.file);
    }

    public String toString() {
        return "Font(file=" + this.file + ", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m2286toStringimpl(mo2254getStyle_LCdwA())) + ')';
    }
}
