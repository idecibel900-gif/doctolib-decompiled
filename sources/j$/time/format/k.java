package j$.time.format;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements InterfaceC1182e {
    public final InterfaceC1182e a;
    public final int b;
    public final char c;

    @Override // j$.time.format.InterfaceC1182e
    public final int B(v vVar, CharSequence charSequence, int i) {
        boolean z = vVar.c;
        if (i > charSequence.length()) {
            throw new IndexOutOfBoundsException();
        }
        if (i == charSequence.length()) {
            return ~i;
        }
        int length = this.b + i;
        if (length > charSequence.length()) {
            if (z) {
                return ~i;
            }
            length = charSequence.length();
        }
        int i2 = i;
        while (i2 < length && vVar.a(charSequence.charAt(i2), this.c)) {
            i2++;
        }
        int iB = this.a.B(vVar, charSequence.subSequence(0, length), i2);
        return (iB == length || !z) ? iB : ~(i + i2);
    }

    public k(InterfaceC1182e interfaceC1182e, int i, char c) {
        this.a = interfaceC1182e;
        this.b = i;
        this.c = c;
    }

    @Override // j$.time.format.InterfaceC1182e
    public final boolean s(y yVar, StringBuilder sb) {
        int length = sb.length();
        if (!this.a.s(yVar, sb)) {
            return false;
        }
        int length2 = sb.length() - length;
        int i = this.b;
        if (length2 <= i) {
            for (int i2 = 0; i2 < i - length2; i2++) {
                sb.insert(length, this.c);
            }
            return true;
        }
        throw new j$.time.c("Cannot print as output of " + length2 + " characters exceeds pad width of " + i);
    }

    public final String toString() {
        String str;
        char c = this.c;
        if (c == ' ') {
            str = ")";
        } else {
            str = ",'" + c + "')";
        }
        return "Pad(" + this.a + com.amazon.a.a.o.b.f.a + this.b + str;
    }
}
