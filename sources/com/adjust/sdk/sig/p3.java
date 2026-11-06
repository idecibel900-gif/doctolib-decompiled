package com.adjust.sdk.sig;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.adjust.sdk.sig.p3[], still in use, count: 1, list:
  (r0v1 com.adjust.sdk.sig.p3[]) from 0x0036: CONSTRUCTOR (r0v1 com.adjust.sdk.sig.p3[]) A[MD:(java.lang.Enum[]):void (m), WRAPPED] (LINE:7) call: com.adjust.sdk.sig.f0.<init>(java.lang.Enum[]):void type: CONSTRUCTOR
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
public final class p3 {
    OBJ('{', '}'),
    LIST('[', ']'),
    MAP('{', '}'),
    /* JADX INFO: Fake field, exist only in values array */
    POLY_OBJ('[', ']');

    public static final /* synthetic */ f0 g;
    public final char a;
    public final char b;

    static {
        g = new f0(p3VarArr);
    }

    public p3(char c, char c2) {
        super(str, i);
        this.a = c;
        this.b = c2;
    }

    public static p3 valueOf(String str) {
        return (p3) Enum.valueOf(p3.class, str);
    }

    public static p3[] values() {
        return (p3[]) f.clone();
    }
}
