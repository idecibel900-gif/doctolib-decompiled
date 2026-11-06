package io.didomi.ssl;

import android.annotation.SuppressLint;
import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\nR\u001b\u0010\u000f\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u0007\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lio/didomi/sdk/f1;", "", "", "token", "", "schemaVersion", "Lio/didomi/sdk/a0;", "a", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/didomi/sdk/j7;", "Lio/didomi/sdk/j7;", "javaScriptEngine", "b", "Lkotlin/Lazy;", "()Ljava/lang/String;", "encoder", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lio/didomi/sdk/j7;)V", "android_release"}, k = 1, mv = {1, 8, 0})
@SuppressLint({"SetJavaScriptEnabled"})
public final class f1 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final j7 javaScriptEngine;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Lazy encoder;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0 {
        final /* synthetic */ Context a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context) {
            super(0);
            this.a = context;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return w0.a(this.a, "js/dcs-encoder.js");
        }
    }

    public f1(Context context, j7 javaScriptEngine) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(javaScriptEngine, "javaScriptEngine");
        this.javaScriptEngine = javaScriptEngine;
        this.encoder = LazyKt.lazy(new a(context));
    }

    private final String a() {
        return (String) this.encoder.getValue();
    }

    public final Object a(String str, int i, Continuation continuation) {
        return this.javaScriptEngine.a(a() + "(new DcsEncoderModule.CedEncoder(" + str + ", " + i + ")).encode();", continuation);
    }
}
