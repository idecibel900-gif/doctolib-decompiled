package com.datadog.android.core.internal;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.SdkCore;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SdkCoreRegistry {
    public static final Companion Companion = new Companion(null);
    private final Map instances;
    private final InternalLogger internalLogger;

    public SdkCoreRegistry(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
        this.instances = new LinkedHashMap();
    }

    public final void register(final String str, SdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        if (str == null) {
            str = "_dd.sdk_core.default";
        }
        if (this.instances.containsKey(str)) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.core.internal.SdkCoreRegistry.register.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "An SdkCode with name " + str + " has already been registered.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            this.instances.put(str, sdkCore);
        }
    }

    public final SdkCore getInstance(String str) {
        if (str == null) {
            str = "_dd.sdk_core.default";
        }
        return (SdkCore) this.instances.get(str);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
