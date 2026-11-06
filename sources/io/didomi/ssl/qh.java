package io.didomi.ssl;

import android.content.SharedPreferences;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class qh implements Provider {
    private final Provider a;

    public qh(Provider provider) {
        this.a = provider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ph get() {
        return a((SharedPreferences) this.a.get());
    }

    public static qh a(Provider provider) {
        return new qh(provider);
    }

    public static ph a(SharedPreferences sharedPreferences) {
        return new ph(sharedPreferences);
    }
}
