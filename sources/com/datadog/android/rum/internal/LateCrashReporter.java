package com.datadog.android.rum.internal;

import android.app.ApplicationExitInfo;
import com.datadog.android.api.storage.DataWriter;
import com.google.gson.JsonObject;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface LateCrashReporter {
    void handleAnrCrash(ApplicationExitInfo applicationExitInfo, JsonObject jsonObject, DataWriter dataWriter);

    void handleNdkCrashEvent(Map map, DataWriter dataWriter);
}
