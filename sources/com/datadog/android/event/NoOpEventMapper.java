package com.datadog.android.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpEventMapper implements EventMapper {
    public int hashCode() {
        return 0;
    }

    @Override // com.datadog.android.event.EventMapper
    public Object map(Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return event;
    }

    public boolean equals(Object obj) {
        return obj instanceof NoOpEventMapper;
    }
}
