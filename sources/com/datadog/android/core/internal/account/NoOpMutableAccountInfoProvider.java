package com.datadog.android.core.internal.account;

import com.datadog.android.api.context.AccountInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpMutableAccountInfoProvider implements MutableAccountInfoProvider {
    @Override // com.datadog.android.core.internal.account.AccountInfoProvider
    public AccountInfo getAccountInfo() {
        return null;
    }
}
