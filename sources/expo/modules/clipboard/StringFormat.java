package expo.modules.clipboard;

import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lexpo/modules/clipboard/StringFormat;", "Lexpo/modules/kotlin/types/Enumerable;", "", "jsValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsValue", "()Ljava/lang/String;", "PLAIN", "HTML", "expo-clipboard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum StringFormat implements Enumerable {
    PLAIN("plainText"),
    HTML("html");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String jsValue;

    public static EnumEntries getEntries() {
        return $ENTRIES;
    }

    StringFormat(String str) {
        this.jsValue = str;
    }

    public final String getJsValue() {
        return this.jsValue;
    }
}
