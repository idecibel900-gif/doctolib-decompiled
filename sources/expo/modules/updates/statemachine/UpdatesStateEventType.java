package expo.modules.updates.statemachine;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
public enum UpdatesStateEventType {
    StartStartup("startStartup"),
    EndStartup("endStartup"),
    Check("check"),
    CheckCompleteUnavailable("checkCompleteUnavailable"),
    CheckCompleteAvailable("checkCompleteAvailable"),
    CheckError("checkError"),
    Download("download"),
    DownloadProgress("downloadProgress"),
    DownloadComplete("downloadComplete"),
    DownloadError("downloadError"),
    Restart("restart");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String type;

    UpdatesStateEventType(String str) {
        this.type = str;
    }
}
