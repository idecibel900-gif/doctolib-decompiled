package com.facebook.imagepipeline.memory;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LruBucketsPoolBackend implements PoolBackend {
    private final Set mCurrentItems = new HashSet();
    private final BucketMap mMap = new BucketMap();

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    public Object get(int i) {
        return maybeRemoveFromCurrentItems(this.mMap.acquire(i));
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    public void put(Object obj) {
        boolean zAdd;
        synchronized (this) {
            zAdd = this.mCurrentItems.add(obj);
        }
        if (zAdd) {
            this.mMap.release(getSize(obj), obj);
        }
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    public Object pop() {
        return maybeRemoveFromCurrentItems(this.mMap.removeFromEnd());
    }

    private Object maybeRemoveFromCurrentItems(Object obj) {
        if (obj == null) {
            return obj;
        }
        synchronized (this) {
            this.mCurrentItems.remove(obj);
        }
        return obj;
    }
}
