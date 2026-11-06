package com.swmansion.enriched.markdown.input.model;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
public enum StyleType {
    BOLD,
    ITALIC,
    UNDERLINE,
    STRIKETHROUGH,
    LINK,
    SPOILER;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }
}
