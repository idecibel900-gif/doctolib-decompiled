package com.facebook.react.views.virtual;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum VirtualViewMode {
    Visible(0),
    Prerender(1),
    Hidden(2);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int value;

    VirtualViewMode(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
