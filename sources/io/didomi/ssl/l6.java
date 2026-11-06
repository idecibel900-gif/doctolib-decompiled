package io.didomi.ssl;

import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class l6 implements Provider {
    private final i6 a;
    private final Provider b;

    public l6(i6 i6Var, Provider provider) {
        this.a = i6Var;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public o6 get() {
        return a(this.a, (gh) this.b.get());
    }

    public static l6 a(i6 i6Var, Provider provider) {
        return new l6(i6Var, provider);
    }

    public static o6 a(i6 i6Var, gh ghVar) {
        return (o6) Preconditions.checkNotNullFromProvides(i6Var.a(ghVar));
    }
}
