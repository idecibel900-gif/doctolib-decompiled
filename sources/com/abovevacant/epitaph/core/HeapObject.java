package com.abovevacant.epitaph.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class HeapObject {
    public final long address;
    public final List allocationBacktrace;
    public final long allocationTid;
    public final List deallocationBacktrace;
    public final long deallocationTid;
    public final long size;

    public HeapObject(long j, long j2, long j3, List list, long j4, List list2) {
        this.address = j;
        this.size = j2;
        this.allocationTid = j3;
        this.allocationBacktrace = Collections.unmodifiableList(list);
        this.deallocationTid = j4;
        this.deallocationBacktrace = Collections.unmodifiableList(list2);
    }
}
