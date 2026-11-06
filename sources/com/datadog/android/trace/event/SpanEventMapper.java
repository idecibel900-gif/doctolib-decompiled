package com.datadog.android.trace.event;

import com.datadog.android.event.EventMapper;
import com.datadog.android.trace.model.SpanEvent;

/* JADX INFO: loaded from: classes3.dex */
public interface SpanEventMapper extends EventMapper {
    SpanEvent map(SpanEvent spanEvent);
}
