package com.abovevacant.epitaph.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class StackHistoryBuffer {
    public final List entries;
    public final long tid;

    public StackHistoryBuffer(long j, List list) {
        this.tid = j;
        this.entries = Collections.unmodifiableList(list);
    }
}
