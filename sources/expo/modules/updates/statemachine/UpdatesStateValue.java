package expo.modules.updates.statemachine;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
public enum UpdatesStateValue {
    Idle("idle"),
    Checking("checking"),
    Downloading("downloading"),
    Restarting("restarting");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    UpdatesStateValue(String str) {
        this.value = str;
    }
}
