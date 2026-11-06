package expo.modules.updates.logging;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
public enum UpdatesErrorCode {
    None("None"),
    NoUpdatesAvailable("NoUpdatesAvailable"),
    UpdateAssetsNotAvailable("UpdateAssetsNotAvailable"),
    UpdateServerUnreachable("UpdateServerUnreachable"),
    UpdateHasInvalidSignature("UpdateHasInvalidSignature"),
    UpdateCodeSigningError("UpdateCodeSigningError"),
    UpdateFailedToLoad("UpdateFailedToLoad"),
    AssetsFailedToLoad("AssetsFailedToLoad"),
    JSRuntimeError("JSRuntimeError"),
    InitializationError("InitializationError"),
    Unknown("Unknown");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String code;

    UpdatesErrorCode(String str) {
        this.code = str;
    }

    public final String getCode() {
        return this.code;
    }
}
