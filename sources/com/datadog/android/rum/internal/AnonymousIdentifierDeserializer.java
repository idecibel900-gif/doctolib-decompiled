package com.datadog.android.rum.internal;

import com.datadog.android.core.internal.persistence.Deserializer;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AnonymousIdentifierDeserializer implements Deserializer {
    @Override // com.datadog.android.core.internal.persistence.Deserializer
    public UUID deserialize(String model) {
        Intrinsics.checkNotNullParameter(model, "model");
        try {
            return UUID.fromString(model);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
