package expo.modules.updates;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/updates/UpdatesJSEvent;", "Lexpo/modules/kotlin/types/Enumerable;", "", "eventName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "StateChange", "expo-updates_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum UpdatesJSEvent implements Enumerable {
    StateChange("Expo.nativeUpdatesStateChangeEvent");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String eventName;

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    UpdatesJSEvent(String str) {
        this.eventName = str;
    }

    public final String getEventName() {
        return this.eventName;
    }
}
