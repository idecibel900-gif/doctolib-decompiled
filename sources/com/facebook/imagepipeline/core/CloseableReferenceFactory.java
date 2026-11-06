package com.facebook.imagepipeline.core;

import android.util.Log;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.references.SharedReference;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public class CloseableReferenceFactory {
    private final CloseableReference.LeakHandler mLeakHandler;

    public CloseableReferenceFactory(final CloseableReferenceLeakTracker closeableReferenceLeakTracker) {
        this.mLeakHandler = new CloseableReference.LeakHandler() { // from class: com.facebook.imagepipeline.core.CloseableReferenceFactory.1
            @Override // com.facebook.common.references.CloseableReference.LeakHandler
            public void reportLeak(SharedReference sharedReference, Throwable th) {
                closeableReferenceLeakTracker.trackCloseableReferenceLeak(sharedReference, th);
                Object obj = sharedReference.get();
                FLog.w("Fresco", "Finalized without closing: %x %x (type = %s).\nStack:\n%s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(sharedReference)), obj != null ? obj.getClass().getName() : "<value is null>", CloseableReferenceFactory.getStackTraceString(th));
            }

            @Override // com.facebook.common.references.CloseableReference.LeakHandler
            public boolean requiresStacktrace() {
                return closeableReferenceLeakTracker.isSet();
            }
        };
    }

    public CloseableReference create(Closeable closeable) {
        return CloseableReference.of(closeable, this.mLeakHandler);
    }

    public CloseableReference create(Object obj, ResourceReleaser resourceReleaser) {
        return CloseableReference.of(obj, resourceReleaser, this.mLeakHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        return Log.getStackTraceString(th);
    }
}
