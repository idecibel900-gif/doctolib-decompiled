package com.datadog.android.core.internal.account;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.AccountInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DatadogAccountInfoProvider implements MutableAccountInfoProvider {
    public static final Companion Companion = new Companion(null);
    private final InternalLogger internalLogger;

    @Override // com.datadog.android.core.internal.account.AccountInfoProvider
    public AccountInfo getAccountInfo() {
        return null;
    }

    public DatadogAccountInfoProvider(InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.internalLogger = internalLogger;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
