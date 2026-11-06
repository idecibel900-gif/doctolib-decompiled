package com.datadog.android.event;

import com.datadog.android.core.persistence.Serializer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class MapperSerializer implements Serializer {
    private final EventMapper eventMapper;
    private final Serializer serializer;

    public MapperSerializer(EventMapper eventMapper, Serializer serializer) {
        Intrinsics.checkNotNullParameter(eventMapper, "eventMapper");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.eventMapper = eventMapper;
        this.serializer = serializer;
    }

    @Override // com.datadog.android.core.persistence.Serializer
    public String serialize(Object model) {
        Intrinsics.checkNotNullParameter(model, "model");
        Object map = this.eventMapper.map(model);
        if (map == null) {
            return null;
        }
        return this.serializer.serialize(map);
    }
}
