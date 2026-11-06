package com.datadog.android.api.feature;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public interface FeatureSdkCore extends SdkCore {
    ScheduledExecutorService createScheduledExecutorService(String str);

    ExecutorService createSingleThreadExecutorService(String str);

    FeatureScope getFeature(String str);

    Map getFeatureContext(String str);

    InternalLogger getInternalLogger();

    void registerFeature(Feature feature);

    void removeContextUpdateReceiver(String str, FeatureContextUpdateReceiver featureContextUpdateReceiver);

    void removeEventReceiver(String str);

    void setAnonymousId(UUID uuid);

    void setContextUpdateReceiver(String str, FeatureContextUpdateReceiver featureContextUpdateReceiver);

    void setEventReceiver(String str, FeatureEventReceiver featureEventReceiver);

    void updateFeatureContext(String str, Function1 function1);
}
