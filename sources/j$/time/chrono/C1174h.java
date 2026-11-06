package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: renamed from: j$.time.chrono.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1174h implements j$.time.temporal.p, Serializable {
    public static final /* synthetic */ int e = 0;
    private static final long serialVersionUID = 57387258289L;
    public final m a;
    public final int b;
    public final int c;
    public final int d;

    static {
        j$.time.b.c(new Object[]{j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS});
    }

    public C1174h(m mVar, int i, int i2, int i3) {
        this.a = mVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public final String toString() {
        if (this.b == 0 && this.c == 0 && this.d == 0) {
            return this.a.toString() + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.toString());
        sb.append(" P");
        int i = this.b;
        if (i != 0) {
            sb.append(i);
            sb.append('Y');
        }
        int i2 = this.c;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        int i3 = this.d;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('D');
        }
        return sb.toString();
    }

    @Override // j$.time.temporal.p
    public final j$.time.temporal.m s(j$.time.temporal.m mVar) {
        m mVar2 = (m) mVar.b(j$.time.temporal.r.b);
        if (mVar2 == null || this.a.equals(mVar2)) {
            if (this.c != 0) {
                j$.time.temporal.u uVarZ = this.a.z(j$.time.temporal.a.MONTH_OF_YEAR);
                long j = (uVarZ.a == uVarZ.b && uVarZ.c == uVarZ.d && uVarZ.d()) ? (uVarZ.d - uVarZ.a) + 1 : -1L;
                if (j > 0) {
                    mVar = mVar.l((((long) this.b) * j) + ((long) this.c), j$.time.temporal.b.MONTHS);
                } else {
                    int i = this.b;
                    if (i != 0) {
                        mVar = mVar.l(i, j$.time.temporal.b.YEARS);
                    }
                    mVar = mVar.l(this.c, j$.time.temporal.b.MONTHS);
                }
            } else {
                int i2 = this.b;
                if (i2 != 0) {
                    mVar = mVar.l(i2, j$.time.temporal.b.YEARS);
                }
            }
            int i3 = this.d;
            return i3 != 0 ? mVar.l(i3, j$.time.temporal.b.DAYS) : mVar;
        }
        throw new j$.time.c("Chronology mismatch, expected: " + this.a.q() + ", actual: " + mVar2.q());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1174h) {
            C1174h c1174h = (C1174h) obj;
            if (this.b == c1174h.b && this.c == c1174h.c && this.d == c1174h.d && this.a.equals(c1174h.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Integer.rotateLeft(this.d, 16) + (Integer.rotateLeft(this.c, 8) + this.b)) ^ this.a.hashCode();
    }

    public Object writeReplace() {
        return new F((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
