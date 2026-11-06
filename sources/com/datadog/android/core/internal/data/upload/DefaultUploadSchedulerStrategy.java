package com.datadog.android.core.internal.data.upload;

import com.datadog.android.core.configuration.UploadSchedulerStrategy;
import com.datadog.android.core.internal.configuration.DataUploadConfiguration;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultUploadSchedulerStrategy implements UploadSchedulerStrategy {
    public static final Companion Companion = new Companion(null);
    private static final long NETWORK_ERROR_DELAY_MS = TimeUnit.MINUTES.toMillis(1);
    private final ConcurrentHashMap currentDelays;
    private final DataUploadConfiguration uploadConfiguration;

    public DefaultUploadSchedulerStrategy(DataUploadConfiguration uploadConfiguration) {
        Intrinsics.checkNotNullParameter(uploadConfiguration, "uploadConfiguration");
        this.uploadConfiguration = uploadConfiguration;
        this.currentDelays = new ConcurrentHashMap();
    }

    @Override // com.datadog.android.core.configuration.UploadSchedulerStrategy
    public long getMsDelayUntilNextUpload(String featureName, int i, Integer num, Throwable th) {
        long jIncreaseInterval;
        Object objPutIfAbsent;
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        ConcurrentHashMap concurrentHashMap = this.currentDelays;
        Object objValueOf = concurrentHashMap.get(featureName);
        if (objValueOf == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(featureName, (objValueOf = Long.valueOf(this.uploadConfiguration.getDefaultDelayMs$dd_sdk_android_core_release())))) != null) {
            objValueOf = objPutIfAbsent;
        }
        Long previousDelay = (Long) objValueOf;
        if (i > 0 && th == null && num != null && num.intValue() == 202) {
            jIncreaseInterval = this.uploadConfiguration.getMinDelayMs$dd_sdk_android_core_release();
        } else {
            Intrinsics.checkNotNullExpressionValue(previousDelay, "previousDelay");
            jIncreaseInterval = increaseInterval(previousDelay.longValue(), th);
        }
        this.currentDelays.put(featureName, Long.valueOf(jIncreaseInterval));
        return jIncreaseInterval;
    }

    private final long increaseInterval(long j, Throwable th) {
        long jRoundToLong = MathKt.roundToLong(j * 1.1d);
        if (th instanceof IOException) {
            return NETWORK_ERROR_DELAY_MS;
        }
        return Math.min(this.uploadConfiguration.getMaxDelayMs$dd_sdk_android_core_release(), jRoundToLong);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
