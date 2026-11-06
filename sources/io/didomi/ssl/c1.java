package io.didomi.ssl;

import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes5.dex */
public final class c1 implements Provider {

    private static final class a {
        private static final c1 a = new c1();
    }

    public static c1 a() {
        return a.a;
    }

    public static CoroutineDispatcher c() {
        return (CoroutineDispatcher) Preconditions.checkNotNullFromProvides(b1.a.a());
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoroutineDispatcher get() {
        return c();
    }
}
