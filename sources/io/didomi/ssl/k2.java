package io.didomi.ssl;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\n\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\t¨\u0006\r"}, d2 = {"Lio/didomi/sdk/k2;", "", "Ljava/lang/Runnable;", "runnable", "", "a", "Ljava/util/concurrent/ThreadPoolExecutor;", "b", "Lkotlin/Lazy;", "()Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class k2 {
    public static final k2 a = new k2();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final Lazy executor = LazyKt.lazy(a.a);

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/util/concurrent/ThreadPoolExecutor;", "a", "()Ljava/util/concurrent/ThreadPoolExecutor;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0 {
        public static final a a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ThreadPoolExecutor invoke() {
            return new ThreadPoolExecutor(1, 2, 30L, TimeUnit.MINUTES, new LinkedBlockingQueue());
        }
    }

    private k2() {
    }

    private final ThreadPoolExecutor a() {
        return (ThreadPoolExecutor) executor.getValue();
    }

    public final void a(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        a().execute(runnable);
    }
}
