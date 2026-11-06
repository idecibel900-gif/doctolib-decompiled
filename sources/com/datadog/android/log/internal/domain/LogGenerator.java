package com.datadog.android.log.internal.domain;

import com.datadog.android.api.context.AccountInfo;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.api.context.UserInfo;
import com.datadog.android.log.model.LogEvent;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes3.dex */
public interface LogGenerator {
    LogEvent generateLog(int i, String str, String str2, String str3, String str4, Map map, Set set, long j, String str5, DatadogContext datadogContext, boolean z, String str6, boolean z2, boolean z3, UserInfo userInfo, AccountInfo accountInfo, NetworkInfo networkInfo);

    LogEvent generateLog(int i, String str, Throwable th, Map map, Set set, long j, String str2, DatadogContext datadogContext, boolean z, String str3, boolean z2, boolean z3, UserInfo userInfo, AccountInfo accountInfo, NetworkInfo networkInfo, List list);

    public static final class DefaultImpls {
        public static /* synthetic */ LogEvent generateLog$default(LogGenerator logGenerator, int i, String str, Throwable th, Map map, Set set, long j, String str2, DatadogContext datadogContext, boolean z, String str3, boolean z2, boolean z3, UserInfo userInfo, AccountInfo accountInfo, NetworkInfo networkInfo, List list, int i2, Object obj) {
            if (obj == null) {
                return logGenerator.generateLog(i, str, th, map, set, j, str2, datadogContext, z, str3, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? true : z2, (i2 & 2048) != 0 ? true : z3, (i2 & 4096) != 0 ? null : userInfo, (i2 & 8192) != 0 ? null : accountInfo, (i2 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : networkInfo, (i2 & 32768) != 0 ? CollectionsKt.emptyList() : list);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateLog");
        }

        public static /* synthetic */ LogEvent generateLog$default(LogGenerator logGenerator, int i, String str, String str2, String str3, String str4, Map map, Set set, long j, String str5, DatadogContext datadogContext, boolean z, String str6, boolean z2, boolean z3, UserInfo userInfo, AccountInfo accountInfo, NetworkInfo networkInfo, int i2, Object obj) {
            if (obj == null) {
                return logGenerator.generateLog(i, str, str2, str3, str4, map, set, j, str5, datadogContext, z, str6, (i2 & 4096) != 0 ? true : z2, (i2 & 8192) != 0 ? true : z3, (i2 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : userInfo, (32768 & i2) != 0 ? null : accountInfo, (i2 & 65536) != 0 ? null : networkInfo);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateLog");
        }
    }
}
