package com.datadog.reactnative;

import com.datadog.android.Datadog;
import com.datadog.android.api.SdkCore;
import com.datadog.android.core.InternalSdkCore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DatadogSDKWrapperStorage {
    private static InternalSdkCore core;
    public static final DatadogSDKWrapperStorage INSTANCE = new DatadogSDKWrapperStorage();
    private static final List onInitializedListeners = new ArrayList();

    private DatadogSDKWrapperStorage() {
    }

    public final void notifyOnInitializedListeners(InternalSdkCore ddCore) {
        Intrinsics.checkNotNullParameter(ddCore, "ddCore");
        Iterator it = onInitializedListeners.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(ddCore);
        }
    }

    public final void setSdkCore(InternalSdkCore internalSdkCore) {
        core = internalSdkCore;
    }

    public final SdkCore getSdkCore() {
        InternalSdkCore internalSdkCore = core;
        return internalSdkCore != null ? internalSdkCore : Datadog.getInstance$default(null, 1, null);
    }
}
