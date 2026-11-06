package com.datadog.android.core.internal.persistence.datastore;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.storage.datastore.DataStoreReadCallback;
import com.datadog.android.core.internal.persistence.Deserializer;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import com.datadog.android.core.internal.persistence.tlvformat.TLVBlock;
import com.datadog.android.core.internal.persistence.tlvformat.TLVBlockFileReader;
import com.datadog.android.core.internal.persistence.tlvformat.TLVBlockType;
import com.datadog.android.core.internal.utils.ByteArrayExtKt;
import com.datadog.android.core.persistence.datastore.DataStoreContent;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class DatastoreFileReader {
    public static final Companion Companion = new Companion(null);
    private final DataStoreFileHelper dataStoreFileHelper;
    private final String featureName;
    private final InternalLogger internalLogger;
    private final File storageDir;
    private final TLVBlockFileReader tlvBlockFileReader;

    public DatastoreFileReader(DataStoreFileHelper dataStoreFileHelper, String featureName, File storageDir, InternalLogger internalLogger, TLVBlockFileReader tlvBlockFileReader) {
        Intrinsics.checkNotNullParameter(dataStoreFileHelper, "dataStoreFileHelper");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(storageDir, "storageDir");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(tlvBlockFileReader, "tlvBlockFileReader");
        this.dataStoreFileHelper = dataStoreFileHelper;
        this.featureName = featureName;
        this.storageDir = storageDir;
        this.internalLogger = internalLogger;
        this.tlvBlockFileReader = tlvBlockFileReader;
    }

    public final void read$dd_sdk_android_core_release(String key, Deserializer deserializer, Integer num, DataStoreReadCallback callback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(callback, "callback");
        File dataStoreFile$dd_sdk_android_core_release = this.dataStoreFileHelper.getDataStoreFile$dd_sdk_android_core_release(this.storageDir, this.featureName, key);
        if (!FileExtKt.existsSafe(dataStoreFile$dd_sdk_android_core_release, this.internalLogger)) {
            callback.onSuccess(null);
        } else {
            readFromDataStoreFile(dataStoreFile$dd_sdk_android_core_release, deserializer, this.tlvBlockFileReader, num, callback);
        }
    }

    private final void readFromDataStoreFile(File file, Deserializer deserializer, TLVBlockFileReader tLVBlockFileReader, Integer num, DataStoreReadCallback dataStoreReadCallback) {
        List list = tLVBlockFileReader.read$dd_sdk_android_core_release(file);
        int size = list.size();
        int length = TLVBlockType.values().length;
        if (size != length) {
            logInvalidNumberOfBlocksError(size, length);
            dataStoreReadCallback.onFailure();
            return;
        }
        DataStoreContent dataStoreContentMapToDataStoreContents = mapToDataStoreContents(deserializer, list);
        if (dataStoreContentMapToDataStoreContents == null) {
            dataStoreReadCallback.onFailure();
            return;
        }
        if (num != null) {
            if (num.intValue() != dataStoreContentMapToDataStoreContents.getVersionCode()) {
                dataStoreReadCallback.onSuccess(null);
                return;
            }
        }
        dataStoreReadCallback.onSuccess(dataStoreContentMapToDataStoreContents);
    }

    private final DataStoreContent mapToDataStoreContents(Deserializer deserializer, List list) {
        if (((TLVBlock) list.get(0)).getType() != TLVBlockType.VERSION_CODE && ((TLVBlock) list.get(1)).getType() != TLVBlockType.DATA) {
            logBlocksInUnexpectedBlocksOrderError();
            return null;
        }
        return new DataStoreContent(ByteArrayExtKt.toInt(((TLVBlock) list.get(0)).getData()), deserializer.deserialize(new String(((TLVBlock) list.get(1)).getData(), Charsets.UTF_8)));
    }

    private final void logInvalidNumberOfBlocksError(final int i, final int i2) {
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.core.internal.persistence.datastore.DatastoreFileReader.logInvalidNumberOfBlocksError.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str = String.format(Locale.US, "Read error - datastore entry has invalid number of blocks. Was: %d, expected: %d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    private final void logBlocksInUnexpectedBlocksOrderError() {
        InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.persistence.datastore.DatastoreFileReader.logBlocksInUnexpectedBlocksOrderError.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Read error - blocks are in an unexpected order";
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
