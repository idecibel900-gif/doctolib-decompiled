package com.oblador.keychain;

import android.content.Context;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
/* synthetic */ class DataStorePrefsStorage$prefs$2 extends FunctionReferenceImpl implements Function1 {
    DataStorePrefsStorage$prefs$2(Object obj) {
        super(1, obj, DataStorePrefsStorage.class, "sharedPreferencesMigration", "sharedPreferencesMigration(Landroid/content/Context;)Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final List invoke(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DataStorePrefsStorage) this.receiver).sharedPreferencesMigration(p0);
    }
}
