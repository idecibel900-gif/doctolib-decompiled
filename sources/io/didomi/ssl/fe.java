package io.didomi.ssl;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class fe implements Provider {
    private final Provider a;
    private final Provider b;

    public fe(Provider provider, Provider provider2) {
        this.a = provider;
        this.b = provider2;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ee get() {
        return a((zh) this.a.get(), (n7) this.b.get());
    }

    public static fe a(Provider provider, Provider provider2) {
        return new fe(provider, provider2);
    }

    public static ee a(zh zhVar, n7 n7Var) {
        return new ee(zhVar, n7Var);
    }
}
