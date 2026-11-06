package com.facebook.imagepipeline.systrace;

import android.os.Trace;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultFrescoSystrace implements FrescoSystrace.Systrace {
    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public boolean isTracing() {
        return false;
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public void beginSection(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (isTracing()) {
            Trace.beginSection(name);
        }
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public void endSection() {
        if (isTracing()) {
            Trace.endSection();
        }
    }
}
