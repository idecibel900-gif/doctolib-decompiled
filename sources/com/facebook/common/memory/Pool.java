package com.facebook.common.memory;

import com.facebook.common.references.ResourceReleaser;

/* JADX INFO: loaded from: classes3.dex */
public interface Pool extends ResourceReleaser, MemoryTrimmable {
    Object get(int i);

    @Override // com.facebook.common.references.ResourceReleaser
    void release(Object obj);
}
