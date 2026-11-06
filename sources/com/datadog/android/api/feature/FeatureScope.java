package com.datadog.android.api.feature;

import com.datadog.android.api.storage.datastore.DataStoreHandler;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public interface FeatureScope {
    DataStoreHandler getDataStore();

    void sendEvent(Object obj);

    Feature unwrap();

    void withWriteContext(boolean z, Function2 function2);

    public static final class DefaultImpls {
        public static /* synthetic */ void withWriteContext$default(FeatureScope featureScope, boolean z, Function2 function2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: withWriteContext");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            featureScope.withWriteContext(z, function2);
        }
    }
}
