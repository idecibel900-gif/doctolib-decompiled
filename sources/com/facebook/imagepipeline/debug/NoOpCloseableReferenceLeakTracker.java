package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpCloseableReferenceLeakTracker implements CloseableReferenceLeakTracker {
    @Override // com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker
    public boolean isSet() {
        return false;
    }

    @Override // com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker
    public void trackCloseableReferenceLeak(SharedReference reference, Throwable th) {
        Intrinsics.checkNotNullParameter(reference, "reference");
    }
}
