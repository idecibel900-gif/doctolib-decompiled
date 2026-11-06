package com.swmansion.rnscreens.safearea;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
public enum InsetType {
    ALL,
    SYSTEM,
    INTERFACE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public final boolean containsSystem() {
        return this == ALL || this == SYSTEM;
    }

    public final boolean containsInterface() {
        return this == ALL || this == INTERFACE;
    }
}
