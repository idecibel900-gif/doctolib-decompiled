package j$.time.format;

/* JADX INFO: renamed from: j$.time.format.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1180c implements InterfaceC1182e {
    public final char a;

    public C1180c(char c) {
        this.a = c;
    }

    @Override // j$.time.format.InterfaceC1182e
    public final boolean s(y yVar, StringBuilder sb) {
        sb.append(this.a);
        return true;
    }

    @Override // j$.time.format.InterfaceC1182e
    public final int B(v vVar, CharSequence charSequence, int i) {
        if (i == charSequence.length()) {
            return ~i;
        }
        char cCharAt = charSequence.charAt(i);
        char c = this.a;
        return (cCharAt == c || (!vVar.b && (Character.toUpperCase(cCharAt) == Character.toUpperCase(c) || Character.toLowerCase(cCharAt) == Character.toLowerCase(c)))) ? i + 1 : ~i;
    }

    public final String toString() {
        char c = this.a;
        if (c == '\'') {
            return "''";
        }
        return "'" + c + "'";
    }
}
