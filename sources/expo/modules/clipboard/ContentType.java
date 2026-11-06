package expo.modules.clipboard;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
enum ContentType {
    PLAIN_TEXT("plain-text"),
    HTML("html"),
    IMAGE("image");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String jsName;

    ContentType(String str) {
        this.jsName = str;
    }

    public final String getJsName() {
        return this.jsName;
    }
}
