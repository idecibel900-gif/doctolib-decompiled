package io.didomi.ssl;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u0000 \u0004*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\bB\u001d\b\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00018\u0000\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0012\u0010\u0005\u001a\u0004\b\u00028\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\n\u001a\u0004\u0018\u00018\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b\u0082\u0002\u0004\n\u0002\b9¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/a0;", "T", "", "", "c", "b", "()Ljava/lang/Object;", "", "a", "Ljava/lang/Object;", "result", "Ljava/lang/Throwable;", "error", "<init>", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class a0<T> {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final T result;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Throwable error;

    /* JADX INFO: renamed from: io.didomi.sdk.a0$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007J&\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00010\u0004\"\u0004\b\u0001\u0010\t2\u0006\u0010\n\u001a\u00028\u0001ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u000b\u0082\u0002\u0004\n\u0002\b9¨\u0006\u000e"}, d2 = {"Lio/didomi/sdk/a0$a;", "", "", "error", "Lio/didomi/sdk/a0;", "", "a", "", "message", "T", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "(Ljava/lang/Object;)Lio/didomi/sdk/a0;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a0 a(Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            DefaultConstructorMarker defaultConstructorMarker = null;
            return new a0(defaultConstructorMarker, error, defaultConstructorMarker);
        }

        private Companion() {
        }

        public final a0 a(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return a(new Throwable(message));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <T> a0<T> a(T data) {
            return new a0<>(data, null, 0 == true ? 1 : 0);
        }
    }

    public /* synthetic */ a0(Object obj, Throwable th, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, th);
    }

    public final Throwable a() throws b0 {
        Throwable th = this.error;
        if (th != null) {
            return th;
        }
        throw new b0("No error, result is " + this.result);
    }

    public final T b() throws b0 {
        T t = this.result;
        if (t != null) {
            return t;
        }
        throw new b0("No result, error is " + this.error);
    }

    public final boolean c() {
        return this.result == null;
    }

    private a0(T t, Throwable th) {
        this.result = t;
        this.error = th;
    }
}
