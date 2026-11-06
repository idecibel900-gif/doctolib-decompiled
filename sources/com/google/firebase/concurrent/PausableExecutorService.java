package com.google.firebase.concurrent;

import androidx.core.content.res.FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public interface PausableExecutorService extends ExecutorService, PausableExecutor, AutoCloseable {
    @Override // java.lang.AutoCloseable
    /* synthetic */ default void close() {
        FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1.m(this);
    }
}
