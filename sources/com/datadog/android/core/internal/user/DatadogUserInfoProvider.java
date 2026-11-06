package com.datadog.android.core.internal.user;

import com.datadog.android.api.context.UserInfo;
import com.datadog.android.core.internal.persistence.DataWriter;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DatadogUserInfoProvider implements MutableUserInfoProvider {
    private final DataWriter dataWriter;
    private UserInfo internalUserInfo;

    public DatadogUserInfoProvider(DataWriter dataWriter) {
        Intrinsics.checkNotNullParameter(dataWriter, "dataWriter");
        this.dataWriter = dataWriter;
        this.internalUserInfo = new UserInfo(null, null, null, null, null, 31, null);
    }

    private final void setInternalUserInfo(UserInfo userInfo) {
        this.internalUserInfo = userInfo;
        this.dataWriter.write(userInfo);
    }

    @Override // com.datadog.android.core.internal.user.MutableUserInfoProvider
    public void setUserInfo(String str, String str2, String str3, Map extraInfo) {
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        setInternalUserInfo(UserInfo.copy$default(this.internalUserInfo, null, str, str2, str3, MapsKt.toMap(extraInfo), 1, null));
    }

    @Override // com.datadog.android.core.internal.user.MutableUserInfoProvider
    public void setAnonymousId(String str) {
        setInternalUserInfo(UserInfo.copy$default(this.internalUserInfo, str, null, null, null, null, 30, null));
    }

    @Override // com.datadog.android.core.internal.user.MutableUserInfoProvider
    public void addUserProperties(Map properties) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        UserInfo userInfo = this.internalUserInfo;
        setInternalUserInfo(UserInfo.copy$default(userInfo, null, null, null, null, MapsKt.plus(userInfo.getAdditionalProperties(), properties), 15, null));
    }

    @Override // com.datadog.android.core.internal.user.UserInfoProvider
    public UserInfo getUserInfo() {
        return this.internalUserInfo;
    }
}
