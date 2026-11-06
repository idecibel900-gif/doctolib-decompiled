package com.datadog.android.webview.internal.storage;

import com.datadog.android.core.persistence.Serializer;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class WebViewEventSerializer implements Serializer {
    @Override // com.datadog.android.core.persistence.Serializer
    public String serialize(JsonObject model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String string = model.toString();
        Intrinsics.checkNotNullExpressionValue(string, "model.toString()");
        return string;
    }
}
