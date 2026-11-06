package com.doctolib.apps.authentication.model;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum DeviceKeyUserAuthentication {
    NOT_REQUIRED("not_required"),
    USER_PRESENCE("user_presence");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String stringValue;

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    DeviceKeyUserAuthentication(String str) {
        this.stringValue = str;
    }

    public final String getStringValue() {
        return this.stringValue;
    }
}
