package com.datadog.android.rum.internal.domain.accessibility;

import android.content.Context;
import android.provider.Settings;
import com.datadog.android.api.InternalLogger;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class GlobalWrapper {
    public final Float getFloat$dd_sdk_android_rum_release(InternalLogger internalLogger, Context applicationContext, final String key) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return Float.valueOf(Settings.Global.getFloat(applicationContext.getContentResolver(), key));
        } catch (Settings.SettingNotFoundException e) {
            InternalLogger.DefaultImpls.log$default(internalLogger, InternalLogger.Level.ERROR, CollectionsKt.listOf(InternalLogger.Target.MAINTAINER), new Function0() { // from class: com.datadog.android.rum.internal.domain.accessibility.GlobalWrapper$getFloat$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Setting not found " + key;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }
}
