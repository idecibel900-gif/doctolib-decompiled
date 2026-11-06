package com.facebook.react.devsupport.interfaces;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum DebuggerFrontendPanelName {
    CONSOLE("console"),
    MEMORY("heap-profiler"),
    NETWORK("network"),
    PERFORMANCE("timeline"),
    REACT_COMPONENTS("react-devtools-components"),
    REACT_PROFILER("react-devtools-profiler"),
    SOURCES("sources"),
    WELCOME("rn-welcome");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String internalName;

    DebuggerFrontendPanelName(String str) {
        this.internalName = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.internalName;
    }
}
