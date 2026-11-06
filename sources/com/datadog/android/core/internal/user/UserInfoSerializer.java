package com.datadog.android.core.internal.user;

import com.datadog.android.api.context.UserInfo;
import com.datadog.android.core.persistence.Serializer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class UserInfoSerializer implements Serializer {
    @Override // com.datadog.android.core.persistence.Serializer
    public String serialize(UserInfo model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String string = model.toJson$dd_sdk_android_core_release().getAsJsonObject().toString();
        Intrinsics.checkNotNullExpressionValue(string, "model.toJson().asJsonObject.toString()");
        return string;
    }
}
