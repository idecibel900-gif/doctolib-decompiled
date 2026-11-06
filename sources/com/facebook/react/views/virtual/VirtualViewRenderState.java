package com.facebook.react.views.virtual;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum VirtualViewRenderState {
    Unknown(0),
    Rendered(1),
    None(2);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int value;

    VirtualViewRenderState(int i) {
        this.value = i;
    }
}
