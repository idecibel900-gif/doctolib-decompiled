package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidFontLoader implements PlatformFontLoader {
    private final Object cacheKey;
    private final Context context;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return AndroidFontLoader.this.awaitLoad(null, this);
        }
    }

    public AndroidFontLoader(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public android.graphics.Typeface loadBlocking(Font font) {
        Object objM5243constructorimpl;
        android.graphics.Typeface typefaceLoad;
        if (font instanceof AndroidFont) {
            AndroidFont androidFont = (AndroidFont) font;
            return androidFont.getTypefaceLoader().loadBlocking(this.context, androidFont);
        }
        if (!(font instanceof ResourceFont)) {
            return null;
        }
        int iMo2248getLoadingStrategyPKNRLFQ = font.mo2248getLoadingStrategyPKNRLFQ();
        FontLoadingStrategy.Companion companion = FontLoadingStrategy.Companion;
        if (FontLoadingStrategy.m2274equalsimpl0(iMo2248getLoadingStrategyPKNRLFQ, companion.m2278getBlockingPKNRLFQ())) {
            typefaceLoad = AndroidFontLoader_androidKt.load((ResourceFont) font, this.context);
        } else if (FontLoadingStrategy.m2274equalsimpl0(iMo2248getLoadingStrategyPKNRLFQ, companion.m2279getOptionalLocalPKNRLFQ())) {
            try {
                Result.Companion companion2 = Result.Companion;
                objM5243constructorimpl = Result.m5243constructorimpl(AndroidFontLoader_androidKt.load((ResourceFont) font, this.context));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
            }
            typefaceLoad = (android.graphics.Typeface) (Result.m5248isFailureimpl(objM5243constructorimpl) ? null : objM5243constructorimpl);
        } else {
            if (FontLoadingStrategy.m2274equalsimpl0(iMo2248getLoadingStrategyPKNRLFQ, companion.m2277getAsyncPKNRLFQ())) {
                throw new UnsupportedOperationException("Unsupported Async font load path");
            }
            throw new IllegalArgumentException("Unknown loading type " + ((Object) FontLoadingStrategy.m2276toStringimpl(font.mo2248getLoadingStrategyPKNRLFQ())));
        }
        return PlatformTypefaces_androidKt.setFontVariationSettings(typefaceLoad, ((ResourceFont) font).getVariationSettings(), this.context);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object awaitLoad(Font font, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        AndroidFontLoader androidFontLoader;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objLoadAsync = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objLoadAsync);
            if (font instanceof AndroidFont) {
                AndroidFont androidFont = (AndroidFont) font;
                AndroidFont.TypefaceLoader typefaceLoader = androidFont.getTypefaceLoader();
                Context context = this.context;
                anonymousClass1.label = 1;
                Object objAwaitLoad = typefaceLoader.awaitLoad(context, androidFont, anonymousClass1);
                if (objAwaitLoad != coroutine_suspended) {
                    return objAwaitLoad;
                }
            } else if (font instanceof ResourceFont) {
                Context context2 = this.context;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = font;
                anonymousClass1.label = 2;
                objLoadAsync = AndroidFontLoader_androidKt.loadAsync((ResourceFont) font, context2, anonymousClass1);
                if (objLoadAsync != coroutine_suspended) {
                    androidFontLoader = this;
                }
            } else {
                throw new IllegalArgumentException("Unknown font type: " + font);
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(objLoadAsync);
            return objLoadAsync;
        }
        if (i2 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        font = (Font) anonymousClass1.L$1;
        androidFontLoader = (AndroidFontLoader) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objLoadAsync);
        return PlatformTypefaces_androidKt.setFontVariationSettings((android.graphics.Typeface) objLoadAsync, ((ResourceFont) font).getVariationSettings(), androidFontLoader.context);
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object getCacheKey() {
        return this.cacheKey;
    }
}
