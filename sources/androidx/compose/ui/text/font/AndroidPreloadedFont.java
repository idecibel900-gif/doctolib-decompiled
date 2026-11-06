package androidx.compose.ui.text.font;

import android.content.Context;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidPreloadedFont extends AndroidFont {
    private boolean didInitWithContext;
    private final int style;
    private android.graphics.Typeface typeface;
    private final FontWeight weight;

    public /* synthetic */ AndroidPreloadedFont(FontWeight fontWeight, int i, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(fontWeight, i, settings);
    }

    public abstract android.graphics.Typeface doLoad$ui_text_release(Context context);

    @Override // androidx.compose.ui.text.font.Font
    public final FontWeight getWeight() {
        return this.weight;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getStyle-_-LCdwA, reason: not valid java name */
    public final int mo2254getStyle_LCdwA() {
        return this.style;
    }

    private AndroidPreloadedFont(FontWeight fontWeight, int i, FontVariation.Settings settings) {
        super(FontLoadingStrategy.Companion.m2278getBlockingPKNRLFQ(), AndroidPreloadedFontTypefaceLoader.INSTANCE, settings, null);
        this.weight = fontWeight;
        this.style = i;
    }

    public final void setTypeface$ui_text_release(android.graphics.Typeface typeface) {
        this.typeface = typeface;
    }

    public final android.graphics.Typeface loadCached$ui_text_release(Context context) {
        if (!this.didInitWithContext && this.typeface == null) {
            this.typeface = doLoad$ui_text_release(context);
        }
        this.didInitWithContext = true;
        return this.typeface;
    }
}
