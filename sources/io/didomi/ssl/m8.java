package io.didomi.ssl;

import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class m8 implements Provider {
    private final i8 a;

    public m8(i8 i8Var) {
        this.a = i8Var;
    }

    public static gh b(i8 i8Var) {
        return (gh) Preconditions.checkNotNullFromProvides(i8Var.getUserAgentRepository());
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public gh get() {
        return b(this.a);
    }

    public static m8 a(i8 i8Var) {
        return new m8(i8Var);
    }
}
