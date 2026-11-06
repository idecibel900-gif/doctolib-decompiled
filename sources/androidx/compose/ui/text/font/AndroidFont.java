package androidx.compose.ui.text.font;

import android.content.Context;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidFont implements Font {
    private final int loadingStrategy;
    private final TypefaceLoader typefaceLoader;
    private final FontVariation.Settings variationSettings;

    public interface TypefaceLoader {
        Object awaitLoad(Context context, AndroidFont androidFont, Continuation continuation);

        android.graphics.Typeface loadBlocking(Context context, AndroidFont androidFont);
    }

    public /* synthetic */ AndroidFont(int i, TypefaceLoader typefaceLoader, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, typefaceLoader, settings);
    }

    private AndroidFont(int i, TypefaceLoader typefaceLoader, FontVariation.Settings settings) {
        this.loadingStrategy = i;
        this.typefaceLoader = typefaceLoader;
        this.variationSettings = settings;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getLoadingStrategy-PKNRLFQ, reason: not valid java name */
    public final int mo2248getLoadingStrategyPKNRLFQ() {
        return this.loadingStrategy;
    }

    public final TypefaceLoader getTypefaceLoader() {
        return this.typefaceLoader;
    }

    public final FontVariation.Settings getVariationSettings() {
        return this.variationSettings;
    }
}
