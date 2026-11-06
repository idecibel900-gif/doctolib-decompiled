package io.didomi.ssl;

import android.content.SharedPreferences;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes5.dex */
public final class i1 implements Provider {
    private final Provider a;
    private final Provider b;
    private final Provider c;
    private final Provider d;
    private final Provider e;

    public i1(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public h1 get() {
        return a((e0) this.a.get(), (SharedPreferences) this.b.get(), (ph) this.c.get(), (f1) this.d.get(), (CoroutineDispatcher) this.e.get());
    }

    public static i1 a(Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5) {
        return new i1(provider, provider2, provider3, provider4, provider5);
    }

    public static h1 a(e0 e0Var, SharedPreferences sharedPreferences, ph phVar, f1 f1Var, CoroutineDispatcher coroutineDispatcher) {
        return new h1(e0Var, sharedPreferences, phVar, f1Var, coroutineDispatcher);
    }
}
