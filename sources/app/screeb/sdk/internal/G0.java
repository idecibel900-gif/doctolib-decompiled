package app.screeb.sdk.internal;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 app.screeb.sdk.internal.G0[], still in use, count: 1, list:
  (r0v1 app.screeb.sdk.internal.G0[]) from 0x002d: INVOKE (r0v1 app.screeb.sdk.internal.G0[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:(java.lang.Enum[]):kotlin.enums.EnumEntries (m)]
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
/* JADX INFO: loaded from: classes3.dex */
public final class G0 {
    KEYFRAME(1),
    DELTA(2),
    SCROLL(3),
    /* JADX INFO: Fake field, exist only in values array */
    RECT_PATCH(4);

    public final int a;

    static {
        EnumEntriesKt.enumEntries(g0Arr);
    }

    public G0(int i) {
        super(str, i);
        this.a = i;
    }

    public static G0 valueOf(String str) {
        return (G0) Enum.valueOf(G0.class, str);
    }

    public static G0[] values() {
        return (G0[]) e.clone();
    }
}
