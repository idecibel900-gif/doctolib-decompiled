package androidx.work;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public enum ExistingPeriodicWorkPolicy {
    REPLACE,
    KEEP,
    UPDATE,
    CANCEL_AND_REENQUEUE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
}
