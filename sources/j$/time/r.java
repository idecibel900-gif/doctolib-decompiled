package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements j$.time.temporal.p, Serializable {
    public static final r d = new r(0, 0, 0);
    private static final long serialVersionUID = -3587258372562876L;
    public final int a;
    public final int b;
    public final int c;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        b.c(new Object[]{j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS});
    }

    public static r a(int i, int i2, int i3) {
        if ((i | i2 | i3) == 0) {
            return d;
        }
        return new r(i, i2, i3);
    }

    public r(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // j$.time.temporal.p
    public final j$.time.temporal.m s(j$.time.temporal.m mVar) {
        j$.time.chrono.m mVar2 = (j$.time.chrono.m) mVar.b(j$.time.temporal.r.b);
        if (mVar2 == null || j$.time.chrono.t.c.equals(mVar2)) {
            int i = this.b;
            if (i != 0) {
                long j = (((long) this.a) * 12) + ((long) i);
                if (j != 0) {
                    mVar = mVar.l(j, j$.time.temporal.b.MONTHS);
                }
            } else {
                int i2 = this.a;
                if (i2 != 0) {
                    mVar = mVar.l(i2, j$.time.temporal.b.YEARS);
                }
            }
            int i3 = this.c;
            return i3 != 0 ? mVar.l(i3, j$.time.temporal.b.DAYS) : mVar;
        }
        throw new c("Chronology mismatch, expected: ISO, actual: " + mVar2.q());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.a == rVar.a && this.b == rVar.b && this.c == rVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.c, 16) + Integer.rotateLeft(this.b, 8) + this.a;
    }

    public final String toString() {
        if (this == d) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder("P");
        int i = this.a;
        if (i != 0) {
            sb.append(i);
            sb.append('Y');
        }
        int i2 = this.b;
        if (i2 != 0) {
            sb.append(i2);
            sb.append('M');
        }
        int i3 = this.c;
        if (i3 != 0) {
            sb.append(i3);
            sb.append('D');
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 14, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
