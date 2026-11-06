package com.facebook.react.internal;

import com.facebook.systrace.Systrace;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class SystraceSection implements AutoCloseable {
    public SystraceSection(String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        Systrace.beginSection(0L, sectionName);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Systrace.endSection(0L);
    }
}
