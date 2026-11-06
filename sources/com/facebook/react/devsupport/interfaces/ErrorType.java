package com.facebook.react.devsupport.interfaces;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum ErrorType {
    JS("JS"),
    NATIVE("Native");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String displayName;

    ErrorType(String str) {
        this.displayName = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.displayName;
    }
}
