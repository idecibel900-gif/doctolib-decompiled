package j$.time.format;

import okhttp3.internal.connection.RealConnection;

/* JADX INFO: loaded from: classes2.dex */
public class i implements InterfaceC1182e {
    public static final long[] f = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, RealConnection.IDLE_CONNECTION_HEALTHY_NS};
    public final j$.time.temporal.q a;
    public final int b;
    public final int c;
    public final F d;
    public final int e;

    public long a(y yVar, long j) {
        return j;
    }

    public i(j$.time.temporal.q qVar, int i, int i2, F f2) {
        this.a = qVar;
        this.b = i;
        this.c = i2;
        this.d = f2;
        this.e = 0;
    }

    public i(j$.time.temporal.q qVar, int i, int i2, F f2, int i3) {
        this.a = qVar;
        this.b = i;
        this.c = i2;
        this.d = f2;
        this.e = i3;
    }

    public i d() {
        if (this.e == -1) {
            return this;
        }
        return new i(this.a, this.b, this.c, this.d, -1);
    }

    public i e(int i) {
        return new i(this.a, this.b, this.c, this.d, this.e + i);
    }

    @Override // j$.time.format.InterfaceC1182e
    public boolean s(y yVar, StringBuilder sb) {
        j$.time.temporal.q qVar = this.a;
        Long lA = yVar.a(qVar);
        if (lA == null) {
            return false;
        }
        long jA = a(yVar, lA.longValue());
        C c = yVar.b.c;
        String string = jA == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(jA));
        int length = string.length();
        int i = this.c;
        if (length > i) {
            throw new j$.time.c("Field " + qVar + " cannot be printed as the value " + jA + " exceeds the maximum print width of " + i);
        }
        c.getClass();
        int i2 = this.b;
        F f2 = this.d;
        if (jA >= 0) {
            int i3 = AbstractC1179b.a[f2.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    sb.append('+');
                }
            } else if (i2 < 19 && jA >= f[i2]) {
                sb.append('+');
            }
        } else {
            int i4 = AbstractC1179b.a[f2.ordinal()];
            if (i4 == 1 || i4 == 2 || i4 == 3) {
                sb.append('-');
            } else if (i4 == 4) {
                throw new j$.time.c("Field " + qVar + " cannot be printed as the value " + jA + " cannot be negative according to the SignStyle");
            }
        }
        for (int i5 = 0; i5 < i2 - string.length(); i5++) {
            sb.append('0');
        }
        sb.append(string);
        return true;
    }

    public boolean b(v vVar) {
        int i = this.e;
        if (i != -1) {
            return i > 0 && this.b == this.c && this.d == F.NOT_NEGATIVE;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:119:0x017d  */
    /* JADX WARN: Code duplicated, block: B:121:0x0185  */
    /* JADX WARN: Code duplicated, block: B:124:0x0198  */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0174, code lost:
    
        if (r6 <= r10) goto L98;
     */
    @Override // j$.time.format.InterfaceC1182e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int B(j$.time.format.v r27, java.lang.CharSequence r28, int r29) {
        /*
            Method dump skipped, instruction units count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.i.B(j$.time.format.v, java.lang.CharSequence, int):int");
    }

    public int c(v vVar, long j, int i, int i2) {
        return vVar.f(this.a, j, i, i2);
    }

    public String toString() {
        int i = this.c;
        j$.time.temporal.q qVar = this.a;
        F f2 = this.d;
        int i2 = this.b;
        if (i2 == 1 && i == 19 && f2 == F.NORMAL) {
            return "Value(" + qVar + ")";
        }
        if (i2 == i && f2 == F.NOT_NEGATIVE) {
            return "Value(" + qVar + com.amazon.a.a.o.b.f.a + i2 + ")";
        }
        return "Value(" + qVar + com.amazon.a.a.o.b.f.a + i2 + com.amazon.a.a.o.b.f.a + i + com.amazon.a.a.o.b.f.a + f2 + ")";
    }
}
