package com.datadog.android.core.internal.persistence.datastore;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.datastore.DataStoreHandler;
import com.datadog.android.api.storage.datastore.DataStoreReadCallback;
import com.datadog.android.api.storage.datastore.DataStoreWriteCallback;
import com.datadog.android.core.internal.persistence.Deserializer;
import com.datadog.android.core.internal.utils.ConcurrencyExtKt;
import com.datadog.android.core.persistence.Serializer;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DataStoreFileHandler implements DataStoreHandler {
    private final DatastoreFileReader dataStoreFileReader;
    private final DatastoreFileWriter datastoreFileWriter;
    private final ExecutorService executorService;
    private final InternalLogger internalLogger;

    public DataStoreFileHandler(ExecutorService executorService, InternalLogger internalLogger, DatastoreFileReader dataStoreFileReader, DatastoreFileWriter datastoreFileWriter) {
        Intrinsics.checkNotNullParameter(executorService, "executorService");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(dataStoreFileReader, "dataStoreFileReader");
        Intrinsics.checkNotNullParameter(datastoreFileWriter, "datastoreFileWriter");
        this.executorService = executorService;
        this.internalLogger = internalLogger;
        this.dataStoreFileReader = dataStoreFileReader;
        this.datastoreFileWriter = datastoreFileWriter;
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreHandler
    public void setValue(final String key, final Object data, final int i, final DataStoreWriteCallback dataStoreWriteCallback, final Serializer serializer) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        ConcurrencyExtKt.executeSafe(this.executorService, "dataStoreWrite", this.internalLogger, new Runnable(key, data, serializer, dataStoreWriteCallback, i) { // from class: com.datadog.android.core.internal.persistence.datastore.DataStoreFileHandler$$ExternalSyntheticLambda0
            public final /* synthetic */ String f$1;
            public final /* synthetic */ Object f$2;
            public final /* synthetic */ Serializer f$3;
            public final /* synthetic */ int f$5;

            {
                this.f$5 = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DataStoreFileHandler.setValue$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, null, this.f$5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setValue$lambda$0(DataStoreFileHandler this$0, String key, Object data, Serializer serializer, DataStoreWriteCallback dataStoreWriteCallback, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(serializer, "$serializer");
        this$0.datastoreFileWriter.write$dd_sdk_android_core_release(key, data, serializer, dataStoreWriteCallback, i);
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreHandler
    public void removeValue(final String key, final DataStoreWriteCallback dataStoreWriteCallback) {
        Intrinsics.checkNotNullParameter(key, "key");
        ConcurrencyExtKt.executeSafe(this.executorService, "dataStoreRemove", this.internalLogger, new Runnable(key, dataStoreWriteCallback) { // from class: com.datadog.android.core.internal.persistence.datastore.DataStoreFileHandler$$ExternalSyntheticLambda2
            public final /* synthetic */ String f$1;

            @Override // java.lang.Runnable
            public final void run() {
                DataStoreFileHandler.removeValue$lambda$1(this.f$0, this.f$1, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeValue$lambda$1(DataStoreFileHandler this$0, String key, DataStoreWriteCallback dataStoreWriteCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "$key");
        this$0.datastoreFileWriter.delete$dd_sdk_android_core_release(key, dataStoreWriteCallback);
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreHandler
    public void clearAllData() {
        ConcurrencyExtKt.executeSafe(this.executorService, "dataStoreClearAllData", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.datastore.DataStoreFileHandler$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                DataStoreFileHandler.clearAllData$lambda$2(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearAllData$lambda$2(DataStoreFileHandler this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.datastoreFileWriter.clearAllData$dd_sdk_android_core_release();
    }

    @Override // com.datadog.android.api.storage.datastore.DataStoreHandler
    public void value(final String key, final Integer num, final DataStoreReadCallback callback, final Deserializer deserializer) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        ConcurrencyExtKt.executeSafe(this.executorService, "dataStoreRead", this.internalLogger, new Runnable() { // from class: com.datadog.android.core.internal.persistence.datastore.DataStoreFileHandler$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DataStoreFileHandler.value$lambda$3(this.f$0, key, deserializer, num, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void value$lambda$3(DataStoreFileHandler this$0, String key, Deserializer deserializer, Integer num, DataStoreReadCallback callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(deserializer, "$deserializer");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.dataStoreFileReader.read$dd_sdk_android_core_release(key, deserializer, num, callback);
    }
}
