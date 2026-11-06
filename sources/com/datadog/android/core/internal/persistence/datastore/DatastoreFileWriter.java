package com.datadog.android.core.internal.persistence.datastore;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.datastore.DataStoreWriteCallback;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.file.FileReaderWriter;
import com.datadog.android.core.internal.persistence.tlvformat.TLVBlock;
import com.datadog.android.core.internal.persistence.tlvformat.TLVBlockType;
import com.datadog.android.core.internal.utils.ByteArrayExtKt;
import com.datadog.android.core.internal.utils.NumberExtKt;
import com.datadog.android.core.persistence.Serializer;
import java.io.File;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class DatastoreFileWriter {
    public static final Companion Companion = new Companion(null);
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private final DataStoreFileHelper dataStoreFileHelper;
    private final String featureName;
    private final FileReaderWriter fileReaderWriter;
    private final InternalLogger internalLogger;
    private final File storageDir;

    public DatastoreFileWriter(DataStoreFileHelper dataStoreFileHelper, String featureName, File storageDir, InternalLogger internalLogger, FileReaderWriter fileReaderWriter) {
        Intrinsics.checkNotNullParameter(dataStoreFileHelper, "dataStoreFileHelper");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(storageDir, "storageDir");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(fileReaderWriter, "fileReaderWriter");
        this.dataStoreFileHelper = dataStoreFileHelper;
        this.featureName = featureName;
        this.storageDir = storageDir;
        this.internalLogger = internalLogger;
        this.fileReaderWriter = fileReaderWriter;
    }

    public final void write$dd_sdk_android_core_release(String key, Object data, Serializer serializer, DataStoreWriteCallback dataStoreWriteCallback, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        File dataStoreFile$dd_sdk_android_core_release = this.dataStoreFileHelper.getDataStoreFile$dd_sdk_android_core_release(this.storageDir, this.featureName, key);
        byte[] versionCodeBlock = getVersionCodeBlock(i);
        byte[] dataBlock = getDataBlock(data, serializer);
        if (versionCodeBlock == null || dataBlock == null) {
            if (dataStoreWriteCallback != null) {
                dataStoreWriteCallback.onFailure();
                return;
            }
            return;
        }
        if (this.fileReaderWriter.writeData(dataStoreFile$dd_sdk_android_core_release, ByteArrayExtKt.join$default(CollectionsKt.listOf((Object[]) new byte[][]{versionCodeBlock, dataBlock}), EMPTY_BYTE_ARRAY, null, null, this.internalLogger, 6, null), false)) {
            if (dataStoreWriteCallback != null) {
                dataStoreWriteCallback.onSuccess();
            }
        } else if (dataStoreWriteCallback != null) {
            dataStoreWriteCallback.onFailure();
        }
    }

    public final void delete$dd_sdk_android_core_release(String key, DataStoreWriteCallback dataStoreWriteCallback) {
        Intrinsics.checkNotNullParameter(key, "key");
        File dataStoreFile$dd_sdk_android_core_release = this.dataStoreFileHelper.getDataStoreFile$dd_sdk_android_core_release(this.storageDir, this.featureName, key);
        if (FileExtKt.existsSafe(dataStoreFile$dd_sdk_android_core_release, this.internalLogger)) {
            if (FileExtKt.deleteSafe(dataStoreFile$dd_sdk_android_core_release, this.internalLogger)) {
                if (dataStoreWriteCallback != null) {
                    dataStoreWriteCallback.onSuccess();
                }
            } else if (dataStoreWriteCallback != null) {
                dataStoreWriteCallback.onFailure();
            }
        }
    }

    public final void clearAllData$dd_sdk_android_core_release() {
        File dataStoreDirectory$dd_sdk_android_core_release = this.dataStoreFileHelper.getDataStoreDirectory$dd_sdk_android_core_release(this.storageDir, this.featureName);
        if (FileExtKt.existsSafe(dataStoreDirectory$dd_sdk_android_core_release, this.internalLogger)) {
            FileExtKt.deleteDirectoryContentsSafe(dataStoreDirectory$dd_sdk_android_core_release, this.internalLogger);
        }
    }

    private final byte[] getDataBlock(Object obj, Serializer serializer) {
        byte[] bytes;
        String strSerialize = serializer.serialize(obj);
        if (strSerialize != null) {
            bytes = strSerialize.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        } else {
            bytes = null;
        }
        if (bytes == null) {
            logFailedToSerializeDataError();
            return null;
        }
        return TLVBlock.serialize$dd_sdk_android_core_release$default(new TLVBlock(TLVBlockType.DATA, bytes, this.internalLogger), 0, 1, null);
    }

    private final byte[] getVersionCodeBlock(int i) {
        return TLVBlock.serialize$dd_sdk_android_core_release$default(new TLVBlock(TLVBlockType.VERSION_CODE, NumberExtKt.toByteArray(i), this.internalLogger), 0, 1, null);
    }

    private final void logFailedToSerializeDataError() {
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.persistence.datastore.DatastoreFileWriter.logFailedToSerializeDataError.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Write error - Failed to serialize data for the datastore";
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
