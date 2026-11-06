package com.datadog.android.rum.internal.domain.accessibility;

import android.content.Context;
import android.provider.Settings;
import com.datadog.android.api.InternalLogger;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SecureWrapper {
    public final Integer getInt$dd_sdk_android_rum_release(InternalLogger internalLogger, Context applicationContext, final String key) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return Integer.valueOf(Settings.Secure.getInt(applicationContext.getContentResolver(), key, -1));
        } catch (Settings.SettingNotFoundException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf(InternalLogger.Target.MAINTAINER), new Function0() { // from class: com.datadog.android.rum.internal.domain.accessibility.SecureWrapper$getInt$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Setting cannot be found " + key;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return -1;
        } catch (SecurityException e2) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf(InternalLogger.Target.MAINTAINER), new Function0() { // from class: com.datadog.android.rum.internal.domain.accessibility.SecureWrapper$getInt$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Security exception accessing " + key;
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return -1;
        }
    }
}
