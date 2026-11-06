package androidx.compose.ui.text.font;

import android.content.Context;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes.dex */
final class AndroidPreloadedFontTypefaceLoader implements AndroidFont.TypefaceLoader {
    public static final AndroidPreloadedFontTypefaceLoader INSTANCE = new AndroidPreloadedFontTypefaceLoader();

    private AndroidPreloadedFontTypefaceLoader() {
    }

    @Override // androidx.compose.ui.text.font.AndroidFont.TypefaceLoader
    public android.graphics.Typeface loadBlocking(Context context, AndroidFont androidFont) {
        AndroidPreloadedFont androidPreloadedFont = androidFont instanceof AndroidPreloadedFont ? (AndroidPreloadedFont) androidFont : null;
        if (androidPreloadedFont != null) {
            return androidPreloadedFont.loadCached$ui_text_release(context);
        }
        return null;
    }

    @Override // androidx.compose.ui.text.font.AndroidFont.TypefaceLoader
    public Object awaitLoad(Context context, AndroidFont androidFont, Continuation continuation) {
        throw new UnsupportedOperationException("All preloaded fonts are blocking.");
    }
}
