package com.facebook.common.references;

import com.facebook.common.logging.FLog;

/* JADX INFO: loaded from: classes3.dex */
public class FinalizerCloseableReference extends CloseableReference {
    @Override // com.facebook.common.references.CloseableReference
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CloseableReference m3214clone() {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    FinalizerCloseableReference(Object obj, ResourceReleaser resourceReleaser, CloseableReference.LeakHandler leakHandler, Throwable th) {
        super(obj, resourceReleaser, leakHandler, th, true);
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.mIsClosed) {
                    Object obj = this.mSharedReference.get();
                    FLog.w("FinalizerCloseableReference", "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mSharedReference)), obj == null ? null : obj.getClass().getName());
                    this.mSharedReference.deleteReference();
                    super.finalize();
                    return;
                }
                super.finalize();
            }
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }
}
