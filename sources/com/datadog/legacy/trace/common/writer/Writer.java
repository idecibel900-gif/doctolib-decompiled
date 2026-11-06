package com.datadog.legacy.trace.common.writer;

import java.io.Closeable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface Writer extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void incrementTraceCount();

    void start();

    void write(List list);
}
