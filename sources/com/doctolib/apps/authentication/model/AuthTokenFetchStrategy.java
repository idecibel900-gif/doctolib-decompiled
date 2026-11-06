package com.doctolib.apps.authentication.model;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum AuthTokenFetchStrategy {
    DEFAULT,
    CACHE_ONLY,
    FORCE_REFRESH;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
}
