package com.facebook.imagepipeline.debug;

import com.facebook.common.references.SharedReference;

/* JADX INFO: loaded from: classes3.dex */
public interface CloseableReferenceLeakTracker {
    boolean isSet();

    void trackCloseableReferenceLeak(SharedReference sharedReference, Throwable th);
}
