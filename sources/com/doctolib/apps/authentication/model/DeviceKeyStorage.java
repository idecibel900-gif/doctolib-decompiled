package com.doctolib.apps.authentication.model;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum DeviceKeyStorage {
    HARDWARE_BACKED_ONLY("hardware_backed_only"),
    HARDWARE_BACKED_OR_SOFTWARE("hardware_backed_or_software");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String stringValue;

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    DeviceKeyStorage(String str) {
        this.stringValue = str;
    }

    public final String getStringValue() {
        return this.stringValue;
    }
}
