package com.datadog.android.core.internal.user;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface MutableUserInfoProvider extends UserInfoProvider {
    void addUserProperties(Map map);

    void setAnonymousId(String str);

    void setUserInfo(String str, String str2, String str3, Map map);
}
