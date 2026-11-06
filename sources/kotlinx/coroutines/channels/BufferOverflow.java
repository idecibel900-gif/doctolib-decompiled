package kotlinx.coroutines.channels;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
public enum BufferOverflow {
    SUSPEND,
    DROP_OLDEST,
    DROP_LATEST;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
}
