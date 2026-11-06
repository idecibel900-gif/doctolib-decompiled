package com.doctolib.apps.authentication.model;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum DeviceKeyRegistrarKind {
    KEYCLOAK("keycloak");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String stringValue;

    DeviceKeyRegistrarKind(String str) {
        this.stringValue = str;
    }
}
