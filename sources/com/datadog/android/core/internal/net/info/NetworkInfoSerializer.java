package com.datadog.android.core.internal.net.info;

import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.core.persistence.Serializer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NetworkInfoSerializer implements Serializer {
    @Override // com.datadog.android.core.persistence.Serializer
    public String serialize(NetworkInfo model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String string = model.toJson$dd_sdk_android_core_release().getAsJsonObject().toString();
        Intrinsics.checkNotNullExpressionValue(string, "model.toJson().asJsonObject.toString()");
        return string;
    }
}
