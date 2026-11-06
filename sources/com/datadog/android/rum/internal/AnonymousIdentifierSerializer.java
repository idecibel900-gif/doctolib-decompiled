package com.datadog.android.rum.internal;

import com.datadog.android.core.persistence.Serializer;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AnonymousIdentifierSerializer implements Serializer {
    @Override // com.datadog.android.core.persistence.Serializer
    public String serialize(UUID model) {
        Intrinsics.checkNotNullParameter(model, "model");
        String string = model.toString();
        Intrinsics.checkNotNullExpressionValue(string, "model.toString()");
        return string;
    }
}
