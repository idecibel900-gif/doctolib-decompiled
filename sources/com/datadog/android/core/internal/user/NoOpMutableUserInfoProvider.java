package com.datadog.android.core.internal.user;

import com.datadog.android.api.context.UserInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpMutableUserInfoProvider implements MutableUserInfoProvider {
    @Override // com.datadog.android.core.internal.user.MutableUserInfoProvider
    public void addUserProperties(Map properties) {
        Intrinsics.checkNotNullParameter(properties, "properties");
    }

    @Override // com.datadog.android.core.internal.user.MutableUserInfoProvider
    public void setAnonymousId(String str) {
    }

    @Override // com.datadog.android.core.internal.user.MutableUserInfoProvider
    public void setUserInfo(String str, String str2, String str3, Map extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
    }

    @Override // com.datadog.android.core.internal.user.UserInfoProvider
    public UserInfo getUserInfo() {
        return new UserInfo(null, null, null, null, null, 31, null);
    }
}
