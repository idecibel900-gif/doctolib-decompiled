package app.screeb.sdk.internal;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 app.screeb.sdk.internal.p[], still in use, count: 1, list:
  (r0v1 app.screeb.sdk.internal.p[]) from 0x001a: INVOKE (r0v1 app.screeb.sdk.internal.p[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:(java.lang.Enum[]):kotlin.enums.EnumEntries (m)]
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: app.screeb.sdk.internal.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumC0317p {
    STRUCTURAL,
    VISUAL;

    static {
        EnumEntriesKt.enumEntries(enumC0317pArr);
    }

    public EnumC0317p() {
        super(str, i);
    }

    public static EnumC0317p valueOf(String str) {
        return (EnumC0317p) Enum.valueOf(EnumC0317p.class, str);
    }

    public static EnumC0317p[] values() {
        return (EnumC0317p[]) c.clone();
    }
}
