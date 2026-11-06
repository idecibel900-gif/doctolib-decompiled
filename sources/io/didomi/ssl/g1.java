package io.didomi.ssl;

import android.content.Context;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class g1 implements Provider {
    private final Provider a;
    private final Provider b;

    public g1(Provider provider, Provider provider2) {
        this.a = provider;
        this.b = provider2;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public f1 get() {
        return a((Context) this.a.get(), (j7) this.b.get());
    }

    public static g1 a(Provider provider, Provider provider2) {
        return new g1(provider, provider2);
    }

    public static f1 a(Context context, j7 j7Var) {
        return new f1(context, j7Var);
    }
}
