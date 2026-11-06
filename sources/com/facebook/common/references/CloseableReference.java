package com.facebook.common.references;

import android.graphics.Bitmap;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CloseableReference implements Cloneable, Closeable {
    private static int sBitmapCloseableRefType;
    protected boolean mIsClosed = false;
    protected final LeakHandler mLeakHandler;
    protected final SharedReference mSharedReference;
    protected final Throwable mStacktrace;
    private static Class TAG = CloseableReference.class;
    private static final ResourceReleaser DEFAULT_CLOSEABLE_RELEASER = new ResourceReleaser() { // from class: com.facebook.common.references.CloseableReference.1
        @Override // com.facebook.common.references.ResourceReleaser
        public void release(Closeable closeable) {
            try {
                Closeables.close(closeable, true);
            } catch (IOException unused) {
            }
        }
    };
    private static final LeakHandler DEFAULT_LEAK_HANDLER = new LeakHandler() { // from class: com.facebook.common.references.CloseableReference.2
        @Override // com.facebook.common.references.CloseableReference.LeakHandler
        public boolean requiresStacktrace() {
            return false;
        }

        @Override // com.facebook.common.references.CloseableReference.LeakHandler
        public void reportLeak(SharedReference sharedReference, Throwable th) {
            Object obj = sharedReference.get();
            FLog.w(CloseableReference.TAG, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(sharedReference)), obj == null ? null : obj.getClass().getName());
        }
    };

    public interface LeakHandler {
        void reportLeak(SharedReference sharedReference, Throwable th);

        boolean requiresStacktrace();
    }

    /* JADX INFO: renamed from: clone */
    public abstract CloseableReference m3216clone();

    protected CloseableReference(SharedReference sharedReference, LeakHandler leakHandler, Throwable th) {
        this.mSharedReference = (SharedReference) Preconditions.checkNotNull(sharedReference);
        sharedReference.addReference();
        this.mLeakHandler = leakHandler;
        this.mStacktrace = th;
    }

    protected CloseableReference(Object obj, ResourceReleaser resourceReleaser, LeakHandler leakHandler, Throwable th, boolean z) {
        this.mSharedReference = new SharedReference(obj, resourceReleaser, z);
        this.mLeakHandler = leakHandler;
        this.mStacktrace = th;
    }

    public static CloseableReference of(Closeable closeable) {
        return of(closeable, DEFAULT_CLOSEABLE_RELEASER);
    }

    public static CloseableReference of(Object obj, ResourceReleaser resourceReleaser) {
        return of(obj, resourceReleaser, DEFAULT_LEAK_HANDLER);
    }

    public static CloseableReference of(Closeable closeable, LeakHandler leakHandler) {
        if (closeable == null) {
            return null;
        }
        return of(closeable, DEFAULT_CLOSEABLE_RELEASER, leakHandler, leakHandler.requiresStacktrace() ? new Throwable() : null);
    }

    public static CloseableReference of(Object obj, ResourceReleaser resourceReleaser, LeakHandler leakHandler) {
        if (obj == null) {
            return null;
        }
        return of(obj, resourceReleaser, leakHandler, leakHandler.requiresStacktrace() ? new Throwable() : null);
    }

    public static CloseableReference of(Object obj, ResourceReleaser resourceReleaser, LeakHandler leakHandler, Throwable th) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Bitmap) || (obj instanceof HasBitmap)) {
            int i = sBitmapCloseableRefType;
            if (i == 1) {
                return new FinalizerCloseableReference(obj, resourceReleaser, leakHandler, th);
            }
            if (i == 2) {
                return new RefCountCloseableReference(obj, resourceReleaser, leakHandler, th);
            }
            if (i == 3) {
                return new NoOpCloseableReference(obj);
            }
        }
        return new DefaultCloseableReference(obj, resourceReleaser, leakHandler, th);
    }

    public synchronized Object get() {
        Preconditions.checkState(!this.mIsClosed);
        return Preconditions.checkNotNull(this.mSharedReference.get());
    }

    public synchronized CloseableReference cloneOrNull() {
        if (!isValid()) {
            return null;
        }
        return m3216clone();
    }

    public synchronized boolean isValid() {
        return !this.mIsClosed;
    }

    public int getValueHash() {
        if (isValid()) {
            return System.identityHashCode(this.mSharedReference.get());
        }
        return 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            try {
                if (this.mIsClosed) {
                    return;
                }
                this.mIsClosed = true;
                this.mSharedReference.deleteReference();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean isValid(CloseableReference closeableReference) {
        return closeableReference != null && closeableReference.isValid();
    }

    public static CloseableReference cloneOrNull(CloseableReference closeableReference) {
        if (closeableReference != null) {
            return closeableReference.cloneOrNull();
        }
        return null;
    }

    public static void closeSafely(CloseableReference closeableReference) {
        if (closeableReference != null) {
            closeableReference.close();
        }
    }
}
