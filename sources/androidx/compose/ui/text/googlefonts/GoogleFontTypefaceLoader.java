package androidx.compose.ui.text.googlefonts;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.ui.text.font.AndroidFont;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleFontTypefaceLoader implements AndroidFont.TypefaceLoader {
    public static final GoogleFontTypefaceLoader INSTANCE = new GoogleFontTypefaceLoader();

    private GoogleFontTypefaceLoader() {
    }

    @Override // androidx.compose.ui.text.font.AndroidFont.TypefaceLoader
    public Typeface loadBlocking(Context context, AndroidFont androidFont) {
        throw new IllegalStateException(("GoogleFont only support async loading: " + androidFont).toString());
    }

    @Override // androidx.compose.ui.text.font.AndroidFont.TypefaceLoader
    public Object awaitLoad(Context context, AndroidFont androidFont, Continuation continuation) {
        return awaitLoad$ui_text_google_fonts_release(context, androidFont, DefaultFontsContractCompatLoader.INSTANCE, continuation);
    }

    public final Object awaitLoad$ui_text_google_fonts_release(Context context, final AndroidFont androidFont, FontsContractCompatLoader fontsContractCompatLoader, Continuation continuation) {
        if (!(androidFont instanceof GoogleFontImpl)) {
            throw new IllegalArgumentException(("Only GoogleFontImpl supported (actual " + androidFont + ')').toString());
        }
        GoogleFontImpl googleFontImpl = (GoogleFontImpl) androidFont;
        FontRequest fontRequest = googleFontImpl.toFontRequest();
        int typefaceStyle = googleFontImpl.toTypefaceStyle();
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        fontsContractCompatLoader.requestFont(context, fontRequest, typefaceStyle, INSTANCE.asyncHandlerForCurrentThreadOrMainIfNoLooper(), new FontsContractCompat.FontRequestCallback() { // from class: androidx.compose.ui.text.googlefonts.GoogleFontTypefaceLoader$awaitLoad$4$callback$1
            @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
            public void onTypefaceRetrieved(Typeface typeface) {
                cancellableContinuationImpl.resumeWith(Result.m5243constructorimpl(typeface));
            }

            @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
            public void onTypefaceRequestFailed(int i) {
                cancellableContinuationImpl.cancel(new IllegalStateException("Failed to load " + androidFont + " (reason=" + i + ", " + GoogleFontKt.reasonToString(i) + ')'));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler asyncHandlerForCurrentThreadOrMainIfNoLooper() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        return HandlerHelper.INSTANCE.createAsync(looperMyLooper);
    }
}
