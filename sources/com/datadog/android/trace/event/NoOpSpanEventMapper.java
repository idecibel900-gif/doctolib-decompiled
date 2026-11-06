package com.datadog.android.trace.event;

import com.datadog.android.trace.model.SpanEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpSpanEventMapper implements SpanEventMapper {
    @Override // com.datadog.android.event.EventMapper
    public SpanEvent map(SpanEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return event;
    }
}
