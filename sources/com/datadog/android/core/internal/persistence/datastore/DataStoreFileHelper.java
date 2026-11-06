package com.datadog.android.core.internal.persistence.datastore;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.persistence.file.FileExtKt;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DataStoreFileHelper {
    public static final Companion Companion = new Companion(null);
    private final InternalLogger internalLogger;

    public DataStoreFileHelper(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    public final File getDataStoreFile$dd_sdk_android_core_release(File storageDir, String featureName, String key) {
        Intrinsics.checkNotNullParameter(storageDir, "storageDir");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(key, "key");
        return new File(getDataStoreDirectory$dd_sdk_android_core_release(storageDir, featureName), key);
    }

    public final File getDataStoreDirectory$dd_sdk_android_core_release(File storageDir, String featureName) {
        Intrinsics.checkNotNullParameter(storageDir, "storageDir");
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        String str = String.format(Locale.US, "datastore_v%s", Arrays.copyOf(new Object[]{0}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        File file = new File(new File(storageDir, str), featureName);
        if (!FileExtKt.existsSafe(file, this.internalLogger)) {
            FileExtKt.mkdirsSafe(file, this.internalLogger);
        }
        return file;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
