package androidx.compose.ui.text.font;

import androidx.compose.ui.text.platform.AndroidTypeface;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class PlatformFontFamilyTypefaceAdapter {
    private final PlatformTypefaces platformTypefaceResolver = PlatformTypefaces_androidKt.PlatformTypefaces();

    public TypefaceResult resolve(TypefaceRequest typefaceRequest, PlatformFontLoader platformFontLoader, Function1 function1, Function1 function2) {
        android.graphics.Typeface typefaceMo2394getNativeTypefacePYhJU0U;
        FontFamily fontFamily = typefaceRequest.getFontFamily();
        if (fontFamily == null ? true : fontFamily instanceof DefaultFontFamily) {
            typefaceMo2394getNativeTypefacePYhJU0U = this.platformTypefaceResolver.mo2307createDefaultFO1MlWM(typefaceRequest.getFontWeight(), typefaceRequest.m2316getFontStyle_LCdwA());
        } else if (fontFamily instanceof GenericFontFamily) {
            typefaceMo2394getNativeTypefacePYhJU0U = this.platformTypefaceResolver.mo2308createNamedRetOiIg((GenericFontFamily) typefaceRequest.getFontFamily(), typefaceRequest.getFontWeight(), typefaceRequest.m2316getFontStyle_LCdwA());
        } else {
            if (!(fontFamily instanceof LoadedFontFamily)) {
                return null;
            }
            Typeface typeface = ((LoadedFontFamily) typefaceRequest.getFontFamily()).getTypeface();
            Intrinsics.checkNotNull(typeface, "null cannot be cast to non-null type androidx.compose.ui.text.platform.AndroidTypeface");
            typefaceMo2394getNativeTypefacePYhJU0U = ((AndroidTypeface) typeface).mo2394getNativeTypefacePYhJU0U(typefaceRequest.getFontWeight(), typefaceRequest.m2316getFontStyle_LCdwA(), typefaceRequest.m2317getFontSynthesisGVVA2EU());
        }
        return new TypefaceResult.Immutable(typefaceMo2394getNativeTypefacePYhJU0U, false, 2, null);
    }
}
