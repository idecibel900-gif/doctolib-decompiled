package com.datadog.opentracing.jfr;

/* JADX INFO: loaded from: classes3.dex */
public final class DDNoopScopeEvent implements DDScopeEvent {
    public static final DDNoopScopeEvent INSTANCE = new DDNoopScopeEvent();

    @Override // com.datadog.opentracing.jfr.DDScopeEvent
    public void finish() {
    }

    @Override // com.datadog.opentracing.jfr.DDScopeEvent
    public void start() {
    }
}
