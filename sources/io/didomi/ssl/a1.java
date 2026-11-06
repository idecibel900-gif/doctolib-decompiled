package io.didomi.ssl;

import android.content.SharedPreferences;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class a1 implements Provider {
    private final x0 a;

    public a1(x0 x0Var) {
        this.a = x0Var;
    }

    public static SharedPreferences b(x0 x0Var) {
        return (SharedPreferences) Preconditions.checkNotNullFromProvides(x0Var.c());
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SharedPreferences get() {
        return b(this.a);
    }

    public static a1 a(x0 x0Var) {
        return new a1(x0Var);
    }
}
