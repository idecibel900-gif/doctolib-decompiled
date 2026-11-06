package com.facebook.imagepipeline.cache;

import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class BoundedLinkedHashSet {
    private final LinkedHashSet linkedHashSet;
    private final int maxSize;

    public BoundedLinkedHashSet(int i) {
        this.maxSize = i;
        this.linkedHashSet = new LinkedHashSet(i);
    }

    public final synchronized boolean contains(Object obj) {
        return this.linkedHashSet.contains(obj);
    }

    public final synchronized boolean add(Object obj) {
        try {
            if (this.linkedHashSet.size() == this.maxSize) {
                LinkedHashSet linkedHashSet = this.linkedHashSet;
                linkedHashSet.remove(linkedHashSet.iterator().next());
            }
            this.linkedHashSet.remove(obj);
        } catch (Throwable th) {
            throw th;
        }
        return this.linkedHashSet.add(obj);
    }
}
