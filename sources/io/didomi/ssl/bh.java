package io.didomi.ssl;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class bh implements Provider {
    private final Provider a;
    private final Provider b;

    public bh(Provider provider, Provider provider2) {
        this.a = provider;
        this.b = provider2;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ah get() {
        return a((e0) this.a.get(), (ib) this.b.get());
    }

    public static bh a(Provider provider, Provider provider2) {
        return new bh(provider, provider2);
    }

    public static ah a(e0 e0Var, ib ibVar) {
        return new ah(e0Var, ibVar);
    }
}
