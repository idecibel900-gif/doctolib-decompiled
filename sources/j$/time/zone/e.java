package j$.time.zone;

import io.didomi.ssl.config.app.SyncConfiguration;
import j$.time.ZoneOffset;
import j$.time.k;
import j$.time.m;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;
    public final m a;
    public final byte b;
    public final j$.time.e c;
    public final k d;
    public final boolean e;
    public final d f;
    public final ZoneOffset g;
    public final ZoneOffset h;
    public final ZoneOffset i;

    public e(m mVar, int i, j$.time.e eVar, k kVar, boolean z, d dVar, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.a = mVar;
        this.b = (byte) i;
        this.c = eVar;
        this.d = kVar;
        this.e = z;
        this.f = dVar;
        this.g = zoneOffset;
        this.h = zoneOffset2;
        this.i = zoneOffset3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public final void b(DataOutput dataOutput) {
        byte b;
        int iH0 = this.e ? SyncConfiguration.DEFAULT_FREQUENCY : this.d.h0();
        int i = this.g.b;
        int i2 = this.h.b - i;
        int i3 = this.i.b - i;
        if (iH0 % 3600 == 0) {
            b = this.e ? (byte) 24 : this.d.a;
        } else {
            b = 31;
        }
        int i4 = i % 900 == 0 ? (i / 900) + 128 : 255;
        int i5 = (i2 == 0 || i2 == 1800 || i2 == 3600) ? i2 / 1800 : 3;
        int i6 = (i3 == 0 || i3 == 1800 || i3 == 3600) ? i3 / 1800 : 3;
        j$.time.e eVar = this.c;
        dataOutput.writeInt((this.a.getValue() << 28) + ((this.b + 32) << 22) + ((eVar == null ? 0 : eVar.getValue()) << 19) + (b << 14) + (this.f.ordinal() << 12) + (i4 << 4) + (i5 << 2) + i6);
        if (b == 31) {
            dataOutput.writeInt(iH0);
        }
        if (i4 == 255) {
            dataOutput.writeInt(i);
        }
        if (i5 == 3) {
            dataOutput.writeInt(this.h.b);
        }
        if (i6 == 3) {
            dataOutput.writeInt(this.i.b);
        }
    }

    public static e a(DataInput dataInput) {
        k kVarB;
        int i;
        int i2;
        int i3 = dataInput.readInt();
        m mVarJ = m.J(i3 >>> 28);
        int i4 = ((264241152 & i3) >>> 22) - 32;
        int i5 = (3670016 & i3) >>> 19;
        j$.time.e eVarS = i5 == 0 ? null : j$.time.e.s(i5);
        int i6 = (507904 & i3) >>> 14;
        d dVar = d.values()[(i3 & 12288) >>> 12];
        int i7 = (i3 & 4080) >>> 4;
        int i8 = (i3 & 12) >>> 2;
        int i9 = i3 & 3;
        if (i6 == 31) {
            long j = dataInput.readInt();
            k kVar = k.e;
            j$.time.temporal.a.SECOND_OF_DAY.a0(j);
            int i10 = (int) (j / 3600);
            long j2 = j - ((long) (i10 * 3600));
            int i11 = (int) (j2 / 60);
            kVarB = k.B(i10, i11, (int) (j2 - ((long) (i11 * 60))), 0);
        } else {
            int i12 = i6 % 24;
            k kVar2 = k.e;
            j$.time.temporal.a.HOUR_OF_DAY.a0(i12);
            kVarB = k.h[i12];
        }
        ZoneOffset zoneOffsetB0 = ZoneOffset.b0(i7 == 255 ? dataInput.readInt() : (i7 - 128) * 900);
        if (i8 == 3) {
            i = dataInput.readInt();
        } else {
            i = (i8 * 1800) + zoneOffsetB0.b;
        }
        ZoneOffset zoneOffsetB1 = ZoneOffset.b0(i);
        if (i9 == 3) {
            i2 = dataInput.readInt();
        } else {
            i2 = (i9 * 1800) + zoneOffsetB0.b;
        }
        ZoneOffset zoneOffsetB2 = ZoneOffset.b0(i2);
        boolean z = i6 == 24;
        Objects.requireNonNull(mVarJ, "month");
        Objects.requireNonNull(kVarB, com.amazon.a.a.h.a.b);
        Objects.requireNonNull(dVar, "timeDefnition");
        if (i4 < -28 || i4 > 31 || i4 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        if (z && !kVarB.equals(k.g)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        }
        if (kVarB.d != 0) {
            throw new IllegalArgumentException("Time's nano-of-second must be zero");
        }
        return new e(mVarJ, i4, eVarS, kVarB, z, dVar, zoneOffsetB0, zoneOffsetB1, zoneOffsetB2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.a == eVar.a && this.b == eVar.b && this.c == eVar.c && this.f == eVar.f && this.d.equals(eVar.d) && this.e == eVar.e && this.g.equals(eVar.g) && this.h.equals(eVar.h) && this.i.equals(eVar.i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iH0 = ((this.d.h0() + (this.e ? 1 : 0)) << 15) + (this.a.ordinal() << 11) + ((this.b + 32) << 5);
        j$.time.e eVar = this.c;
        return ((this.g.b ^ (this.f.ordinal() + (iH0 + ((eVar == null ? 7 : eVar.ordinal()) << 2)))) ^ this.h.b) ^ this.i.b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TransitionRule[");
        sb.append(this.i.b - this.h.b > 0 ? "Gap " : "Overlap ");
        sb.append(this.h);
        sb.append(" to ");
        sb.append(this.i);
        sb.append(", ");
        j$.time.e eVar = this.c;
        if (eVar != null) {
            byte b = this.b;
            if (b == -1) {
                sb.append(eVar.name());
                sb.append(" on or before last day of ");
                sb.append(this.a.name());
            } else if (b < 0) {
                sb.append(eVar.name());
                sb.append(" on or before last day minus ");
                sb.append((-this.b) - 1);
                sb.append(" of ");
                sb.append(this.a.name());
            } else {
                sb.append(eVar.name());
                sb.append(" on or after ");
                sb.append(this.a.name());
                sb.append(' ');
                sb.append((int) this.b);
            }
        } else {
            sb.append(this.a.name());
            sb.append(' ');
            sb.append((int) this.b);
        }
        sb.append(" at ");
        sb.append(this.e ? "24:00" : this.d.toString());
        sb.append(" ");
        sb.append(this.f);
        sb.append(", standard offset ");
        sb.append(this.g);
        sb.append(']');
        return sb.toString();
    }
}
