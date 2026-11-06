package expo.modules.fetch;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
public enum ResponseState {
    INITIALIZED(0),
    STARTED(1),
    RESPONSE_RECEIVED(2),
    BODY_COMPLETED(3),
    BODY_STREAMING_STARTED(4),
    BODY_STREAMING_CANCELED(5),
    ERROR_RECEIVED(6);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int intValue;

    ResponseState(int i) {
        this.intValue = i;
    }

    public final int getIntValue() {
        return this.intValue;
    }
}
