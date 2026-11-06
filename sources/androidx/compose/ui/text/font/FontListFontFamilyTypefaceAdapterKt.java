package androidx.compose.ui.text.font;

import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class FontListFontFamilyTypefaceAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair firstImmediatelyAvailable(List list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, Function1 function1) {
        Object objM2262unboximpl;
        Object objM5243constructorimpl;
        Object objM2262unboximpl2;
        int size = list.size();
        List listMutableListOf = null;
        for (int i = 0; i < size; i++) {
            Font font = (Font) list.get(i);
            int iMo2248getLoadingStrategyPKNRLFQ = font.mo2248getLoadingStrategyPKNRLFQ();
            FontLoadingStrategy.Companion companion = FontLoadingStrategy.Companion;
            if (FontLoadingStrategy.m2274equalsimpl0(iMo2248getLoadingStrategyPKNRLFQ, companion.m2278getBlockingPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    try {
                        AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key);
                        if (asyncTypefaceResult == null) {
                            asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key);
                        }
                        if (asyncTypefaceResult != null) {
                            objM2262unboximpl = asyncTypefaceResult.m2262unboximpl();
                        } else {
                            Unit unit = Unit.INSTANCE;
                            try {
                                Object objLoadBlocking = platformFontLoader.loadBlocking(font);
                                AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, objLoadBlocking, false, 8, null);
                                objM2262unboximpl = objLoadBlocking;
                            } catch (Exception e) {
                                throw new IllegalStateException("Unable to load font " + font, e);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (objM2262unboximpl != null) {
                    return TuplesKt.to(listMutableListOf, FontSynthesis_androidKt.m2303synthesizeTypefaceFxwP2eA(typefaceRequest.m2317getFontSynthesisGVVA2EU(), objM2262unboximpl, font, typefaceRequest.getFontWeight(), typefaceRequest.m2316getFontStyle_LCdwA()));
                }
                throw new IllegalStateException("Unable to load font " + font);
            }
            if (FontLoadingStrategy.m2274equalsimpl0(iMo2248getLoadingStrategyPKNRLFQ, companion.m2279getOptionalLocalPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    try {
                        AsyncTypefaceCache.Key key2 = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key2);
                        if (asyncTypefaceResult2 == null) {
                            asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key2);
                        }
                        if (asyncTypefaceResult2 != null) {
                            objM2262unboximpl2 = asyncTypefaceResult2.m2262unboximpl();
                        } else {
                            Unit unit2 = Unit.INSTANCE;
                            try {
                                Result.Companion companion2 = Result.Companion;
                                objM5243constructorimpl = Result.m5243constructorimpl(platformFontLoader.loadBlocking(font));
                            } catch (Throwable th2) {
                                Result.Companion companion3 = Result.Companion;
                                objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th2));
                            }
                            Object obj = Result.m5248isFailureimpl(objM5243constructorimpl) ? null : objM5243constructorimpl;
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, obj, false, 8, null);
                            objM2262unboximpl2 = obj;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                if (objM2262unboximpl2 != null) {
                    return TuplesKt.to(listMutableListOf, FontSynthesis_androidKt.m2303synthesizeTypefaceFxwP2eA(typefaceRequest.m2317getFontSynthesisGVVA2EU(), objM2262unboximpl2, font, typefaceRequest.getFontWeight(), typefaceRequest.m2316getFontStyle_LCdwA()));
                }
            } else {
                if (!FontLoadingStrategy.m2274equalsimpl0(iMo2248getLoadingStrategyPKNRLFQ, companion.m2277getAsyncPKNRLFQ())) {
                    throw new IllegalStateException("Unknown font type " + font);
                }
                AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResultM2255get1ASDuI8 = asyncTypefaceCache.m2255get1ASDuI8(font, platformFontLoader);
                if (asyncTypefaceResultM2255get1ASDuI8 != null) {
                    if (!AsyncTypefaceCache.AsyncTypefaceResult.m2260isPermanentFailureimpl(asyncTypefaceResultM2255get1ASDuI8.m2262unboximpl()) && asyncTypefaceResultM2255get1ASDuI8.m2262unboximpl() != null) {
                        return TuplesKt.to(listMutableListOf, FontSynthesis_androidKt.m2303synthesizeTypefaceFxwP2eA(typefaceRequest.m2317getFontSynthesisGVVA2EU(), asyncTypefaceResultM2255get1ASDuI8.m2262unboximpl(), font, typefaceRequest.getFontWeight(), typefaceRequest.m2316getFontStyle_LCdwA()));
                    }
                } else if (listMutableListOf == null) {
                    listMutableListOf = CollectionsKt.mutableListOf(font);
                } else {
                    listMutableListOf.add(font);
                }
            }
        }
        return TuplesKt.to(listMutableListOf, function1.invoke(typefaceRequest));
    }
}
