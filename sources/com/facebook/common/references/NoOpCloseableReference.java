package com.facebook.common.references;

/* JADX INFO: loaded from: classes3.dex */
public class NoOpCloseableReference extends CloseableReference {
    @Override // com.facebook.common.references.CloseableReference
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CloseableReference m3215clone() {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference
    public CloseableReference cloneOrNull() {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.facebook.common.references.CloseableReference
    public boolean isValid() {
        return true;
    }

    NoOpCloseableReference(Object obj) {
        super(obj, null, null, null, false);
    }
}
