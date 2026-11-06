package io.opentracing;

import java.io.Closeable;

/* JADX INFO: loaded from: classes5.dex */
public interface Scope extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
