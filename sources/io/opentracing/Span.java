package io.opentracing;

/* JADX INFO: loaded from: classes5.dex */
public interface Span {
    SpanContext context();

    void finish();

    void finish(long j);

    Span setTag(String str, Number number);

    Span setTag(String str, String str2);

    Span setTag(String str, boolean z);
}
