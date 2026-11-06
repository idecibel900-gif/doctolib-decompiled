package com.google.firebase.concurrent;

import androidx.core.content.res.FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public interface PausableScheduledExecutorService extends ScheduledExecutorService, PausableExecutorService, AutoCloseable {
    @Override // com.google.firebase.concurrent.PausableExecutorService, java.lang.AutoCloseable
    /* synthetic */ default void close() {
        FontResourcesParserCompat$$ExternalSyntheticAutoCloseableForwarder1.m(this);
    }
}
