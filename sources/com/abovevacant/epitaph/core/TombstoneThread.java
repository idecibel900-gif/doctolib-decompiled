package com.abovevacant.epitaph.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class TombstoneThread {
    public final List backtrace;
    public final List backtraceNote;
    public final int id;
    public final List memoryDump;
    public final String name;
    public final long pacEnabledKeys;
    public final List registers;
    public final long taggedAddrCtrl;
    public final List unreadableElfFiles;

    public TombstoneThread(int i, String str, List list, List list2, List list3, List list4, List list5, long j, long j2) {
        this.id = i;
        this.name = str;
        this.registers = Collections.unmodifiableList(list);
        this.backtraceNote = Collections.unmodifiableList(list2);
        this.unreadableElfFiles = Collections.unmodifiableList(list3);
        this.backtrace = Collections.unmodifiableList(list4);
        this.memoryDump = Collections.unmodifiableList(list5);
        this.taggedAddrCtrl = j;
        this.pacEnabledKeys = j2;
    }
}
