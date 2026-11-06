package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: classes3.dex */
public interface MemoryCache extends MemoryTrimmable {

    public interface CacheTrimStrategy {
    }

    CloseableReference cache(Object obj, CloseableReference closeableReference);

    boolean contains(Predicate predicate);

    CloseableReference get(Object obj);

    void probe(Object obj);

    int removeAll(Predicate predicate);
}
