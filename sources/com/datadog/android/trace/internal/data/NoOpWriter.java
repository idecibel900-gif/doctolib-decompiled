package com.datadog.android.trace.internal.data;

import com.datadog.legacy.trace.common.writer.Writer;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpWriter implements Writer {
    @Override // com.datadog.legacy.trace.common.writer.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.datadog.legacy.trace.common.writer.Writer
    public void incrementTraceCount() {
    }

    @Override // com.datadog.legacy.trace.common.writer.Writer
    public void start() {
    }

    @Override // com.datadog.legacy.trace.common.writer.Writer
    public void write(List list) {
    }
}
