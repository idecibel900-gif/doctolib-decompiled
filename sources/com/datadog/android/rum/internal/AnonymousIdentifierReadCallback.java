package com.datadog.android.rum.internal;

import com.datadog.android.api.storage.datastore.DataStoreReadCallback;
import com.datadog.android.core.persistence.datastore.DataStoreContent;
import java.util.UUID;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AnonymousIdentifierReadCallback implements DataStoreReadCallback {
    private final Function1 onFinished;

    public AnonymousIdentifierReadCallback(Function1 onFinished) {
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        this.onFinished = onFinished;
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreReadCallback
    public void onSuccess(DataStoreContent dataStoreContent) {
        this.onFinished.invoke(dataStoreContent != null ? (UUID) dataStoreContent.getData() : null);
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreReadCallback
    public void onFailure() {
        this.onFinished.invoke(null);
    }
}
