package io.didomi.ssl;

import android.content.Context;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class y0 implements Provider {
    private final x0 a;

    public y0(x0 x0Var) {
        this.a = x0Var;
    }

    public static Context b(x0 x0Var) {
        return (Context) Preconditions.checkNotNullFromProvides(x0Var.getContext());
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Context get() {
        return b(this.a);
    }

    public static y0 a(x0 x0Var) {
        return new y0(x0Var);
    }
}
