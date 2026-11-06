package io.didomi.ssl;

import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class db implements Provider {
    private final cb a;
    private final Provider b;

    public db(cb cbVar, Provider provider) {
        this.a = cbVar;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public w6 get() {
        return a(this.a, (e0) this.b.get());
    }

    public static db a(cb cbVar, Provider provider) {
        return new db(cbVar, provider);
    }

    public static w6 a(cb cbVar, e0 e0Var) {
        return (w6) Preconditions.checkNotNullFromProvides(cbVar.a(e0Var));
    }
}
