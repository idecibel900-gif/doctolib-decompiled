package io.didomi.ssl;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lio/didomi/sdk/b1;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class b1 {
    public static final b1 a = new b1();

    private b1() {
    }

    public final CoroutineDispatcher a() {
        return Dispatchers.getIO();
    }
}
