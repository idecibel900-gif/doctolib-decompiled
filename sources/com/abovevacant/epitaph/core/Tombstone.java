package com.abovevacant.epitaph.core;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Tombstone {
    public final String abortMessage;
    public final Architecture arch;
    public final String buildFingerprint;
    public final List causes;
    public final List commandLine;
    public final List crashDetails;
    public final Architecture guestArch;
    public final Map guestThreads;
    public final boolean hasBeen16kbMode;
    public final List logBuffers;
    public final List memoryMappings;
    public final List openFds;
    public final int pageSize;
    public final int pid;
    public final int processUptime;
    public final String revision;
    public final String selinuxLabel;
    public final Signal signal;
    public final StackHistoryBuffer stackHistoryBuffer;
    public final Map threads;
    public final int tid;
    public final String timestamp;
    public final int uid;

    public Tombstone(Architecture architecture, Architecture architecture2, String str, String str2, String str3, int i, int i2, int i3, String str4, List list, int i4, Signal signal, String str5, List list2, List list3, Map map, Map map2, List list4, List list5, List list6, int i5, boolean z, StackHistoryBuffer stackHistoryBuffer) {
        this.arch = architecture;
        this.guestArch = architecture2;
        this.buildFingerprint = str;
        this.revision = str2;
        this.timestamp = str3;
        this.pid = i;
        this.tid = i2;
        this.uid = i3;
        this.selinuxLabel = str4;
        this.commandLine = Collections.unmodifiableList(list);
        this.processUptime = i4;
        this.signal = signal;
        this.abortMessage = str5;
        this.crashDetails = Collections.unmodifiableList(list2);
        this.causes = Collections.unmodifiableList(list3);
        this.threads = Collections.unmodifiableMap(map);
        this.guestThreads = Collections.unmodifiableMap(map2);
        this.memoryMappings = Collections.unmodifiableList(list4);
        this.logBuffers = Collections.unmodifiableList(list5);
        this.openFds = Collections.unmodifiableList(list6);
        this.pageSize = i5;
        this.hasBeen16kbMode = z;
        this.stackHistoryBuffer = stackHistoryBuffer;
    }

    public boolean hasSignal() {
        return this.signal != null;
    }
}
