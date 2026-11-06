package io.didomi.ssl;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class ka implements Provider {
    private final Provider a;
    private final Provider b;

    public ka(Provider provider, Provider provider2) {
        this.a = provider;
        this.b = provider2;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ja get() {
        return a((zh) this.a.get(), (n7) this.b.get());
    }

    public static ka a(Provider provider, Provider provider2) {
        return new ka(provider, provider2);
    }

    public static ja a(zh zhVar, n7 n7Var) {
        return new ja(zhVar, n7Var);
    }
}
