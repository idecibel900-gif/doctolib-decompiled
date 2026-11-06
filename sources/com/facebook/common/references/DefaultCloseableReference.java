package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultCloseableReference extends CloseableReference {
    private DefaultCloseableReference(SharedReference sharedReference, CloseableReference.LeakHandler leakHandler, Throwable th) {
        super(sharedReference, leakHandler, th);
    }

    DefaultCloseableReference(Object obj, ResourceReleaser resourceReleaser, CloseableReference.LeakHandler leakHandler, Throwable th) {
        super(obj, resourceReleaser, leakHandler, th, true);
    }

    @Override // com.facebook.common.references.CloseableReference
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CloseableReference m3213clone() {
        Preconditions.checkState(isValid());
        return new DefaultCloseableReference(this.mSharedReference, this.mLeakHandler, this.mStacktrace != null ? new Throwable() : null);
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.mIsClosed) {
                    Object obj = this.mSharedReference.get();
                    FLog.w("DefaultCloseableReference", "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.mSharedReference)), obj == null ? null : obj.getClass().getName());
                    CloseableReference.LeakHandler leakHandler = this.mLeakHandler;
                    if (leakHandler != null) {
                        leakHandler.reportLeak(this.mSharedReference, this.mStacktrace);
                    }
                    close();
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
