package io.didomi.ssl;

import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes5.dex */
public final class y6 implements Provider {
    private final Provider a;

    public y6(Provider provider) {
        this.a = provider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public x6 get() {
        return a((CoroutineDispatcher) this.a.get());
    }

    public static y6 a(Provider provider) {
        return new y6(provider);
    }

    public static x6 a(CoroutineDispatcher coroutineDispatcher) {
        return new x6(coroutineDispatcher);
    }
}
