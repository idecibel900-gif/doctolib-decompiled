package io.didomi.ssl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0002H\u0002J!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0097@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0007R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/qi;", "Lio/didomi/sdk/j7;", "", "a", "b", "script", "Lio/didomi/sdk/a0;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/webkit/WebView;", "Landroid/webkit/WebView;", "webView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "android_release"}, k = 1, mv = {1, 8, 0})
@SuppressLint({"SetJavaScriptEnabled"})
public final class qi implements j7 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private WebView webView;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class b implements Runnable {
        final /* synthetic */ String b;
        final /* synthetic */ Continuation c;

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"io/didomi/sdk/qi$b$a", "Landroid/webkit/WebChromeClient;", "Landroid/webkit/ConsoleMessage;", "consoleMessage", "", "onConsoleMessage", "android_release"}, k = 1, mv = {1, 8, 0})
        public static final class a extends WebChromeClient {
            final /* synthetic */ Continuation a;

            a(Continuation continuation) {
                this.a = continuation;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Continuation continuation = this.a;
                a0.Companion companion = a0.INSTANCE;
                String strMessage = consoleMessage != null ? consoleMessage.message() : null;
                if (strMessage == null) {
                    strMessage = "Unknown error";
                }
                continuation.resumeWith(Result.m5243constructorimpl(companion.a(strMessage)));
                return super.onConsoleMessage(consoleMessage);
            }
        }

        /* JADX INFO: renamed from: io.didomi.sdk.qi$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 8, 0})
        static final class C0155b<T> implements ValueCallback {
            final /* synthetic */ Continuation a;
            final /* synthetic */ qi b;

            C0155b(Continuation continuation, qi qiVar) {
                this.a = continuation;
                this.b = qiVar;
            }

            @Override // android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onReceiveValue(String it) {
                if (Intrinsics.areEqual(it, "null")) {
                    return;
                }
                Continuation continuation = this.a;
                Result.Companion companion = Result.Companion;
                a0.Companion companion2 = a0.INSTANCE;
                qi qiVar = this.b;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                continuation.resumeWith(Result.m5243constructorimpl(companion2.a(qiVar.b(it))));
            }
        }

        b(String str, Continuation continuation) {
            this.b = str;
            this.c = continuation;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WebView webView = qi.this.webView;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                webView = null;
            }
            qi qiVar = qi.this;
            String str = this.b;
            Continuation continuation = this.c;
            webView.setWebChromeClient(new a(continuation));
            webView.evaluateJavascript(qiVar.a(str), new C0155b(continuation, qiVar));
        }
    }

    public qi(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.didomi.sdk.qi$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                qi.a(this.f$0, context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b(String str) {
        return new Regex("^\"(.+)\"$").replace(str, "$1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(qi this$0, Context context) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        WebView webView = new WebView(context);
        webView.getSettings().setJavaScriptEnabled(true);
        this$0.webView = webView;
    }

    @Override // io.didomi.ssl.j7
    public Object a(String str, Continuation continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        if (StringsKt.isBlank(str)) {
            Result.Companion companion = Result.Companion;
            safeContinuation.resumeWith(Result.m5243constructorimpl(a0.INSTANCE.a("Script is invalid for evaluation")));
        } else {
            new Handler(Looper.getMainLooper()).post(new b(str, safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a(String str) {
        return "var eval = undefined;'use strict';" + str;
    }
}
