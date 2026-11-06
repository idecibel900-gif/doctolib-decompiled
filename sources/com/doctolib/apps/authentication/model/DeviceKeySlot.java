package com.doctolib.apps.authentication.model;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum DeviceKeySlot {
    DEVICE_BOUND("device_bound");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String stringValue;

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    DeviceKeySlot(String str) {
        this.stringValue = str;
    }

    public final String getStringValue() {
        return this.stringValue;
    }
}
