package com.datadog.android.rum.internal.domain.display;

import android.content.Context;
import android.provider.Settings;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.datadog.android.api.InternalLogger;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SystemSettingsWrapper {
    private final Context applicationContext;
    private final InternalLogger internalLogger;

    public SystemSettingsWrapper(Context applicationContext, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.applicationContext = applicationContext;
        this.internalLogger = internalLogger;
    }

    public final int getInt(final String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            return Settings.System.getInt(this.applicationContext.getContentResolver(), name);
        } catch (Settings.SettingNotFoundException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.MAINTAINER, new Function0() { // from class: com.datadog.android.rum.internal.domain.display.SystemSettingsWrapper.getInt.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Problem retrieving system value for " + name;
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return LinearLayoutManager.INVALID_OFFSET;
        }
    }
}
