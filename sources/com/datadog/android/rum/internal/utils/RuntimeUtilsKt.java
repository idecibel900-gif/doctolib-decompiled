package com.datadog.android.rum.internal.utils;

import com.datadog.android.api.context.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RuntimeUtilsKt {
    public static final boolean hasUserData(UserInfo userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "<this>");
        return (userInfo.getId() == null && userInfo.getName() == null && userInfo.getEmail() == null && userInfo.getAdditionalProperties().isEmpty()) ? false : true;
    }
}
