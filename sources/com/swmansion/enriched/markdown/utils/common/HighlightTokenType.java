package com.swmansion.enriched.markdown.utils.common;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
public enum HighlightTokenType {
    Keyword,
    Operator,
    Punctuation,
    String,
    Number,
    Constant,
    Comment,
    Function,
    Type,
    Variable,
    Property,
    Tag,
    Attribute,
    Embedded;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }
}
