package com.datadog.android.rum.internal.domain.event;

import com.datadog.android.core.persistence.Serializer;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RumEventMetaSerializer implements Serializer {
    @Override // com.datadog.android.core.persistence.Serializer
    public String serialize(RumEventMeta model) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (!(model instanceof RumEventMeta.View)) {
            throw new NoWhenBranchMatchedException();
        }
        String string = model.toJson().toString();
        Intrinsics.checkNotNullExpressionValue(string, "model.toJson().toString()");
        return string;
    }
}
