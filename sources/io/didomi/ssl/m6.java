package io.didomi.ssl;

import android.content.Context;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes5.dex */
public final class m6 implements Provider {
    private final i6 a;
    private final Provider b;
    private final Provider c;
    private final Provider d;
    private final Provider e;

    public m6(i6 i6Var, Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        this.a = i6Var;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public bb get() {
        return a(this.a, (Context) this.b.get(), (g0) this.c.get(), (o6) this.d.get(), (CoroutineDispatcher) this.e.get());
    }

    public static m6 a(i6 i6Var, Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        return new m6(i6Var, provider, provider2, provider3, provider4);
    }

    public static bb a(i6 i6Var, Context context, g0 g0Var, o6 o6Var, CoroutineDispatcher coroutineDispatcher) {
        return (bb) Preconditions.checkNotNullFromProvides(i6Var.a(context, g0Var, o6Var, coroutineDispatcher));
    }
}
