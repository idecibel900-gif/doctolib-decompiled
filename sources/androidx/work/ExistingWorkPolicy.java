package androidx.work;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum ExistingWorkPolicy {
    REPLACE,
    KEEP,
    APPEND,
    APPEND_OR_REPLACE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
}
