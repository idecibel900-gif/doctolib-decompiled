package j$.time;

import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.verification.SigningManager;
import io.didomi.ssl.config.app.SyncConfiguration;
import j$.time.temporal.TemporalAccessor;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements j$.time.temporal.m, j$.time.temporal.n, Comparable, Serializable {
    public static final k e;
    public static final k f;
    public static final k g;
    public static final k[] h = new k[24];
    private static final long serialVersionUID = 6414437269572265201L;
    public final byte a;
    public final byte b;
    public final byte c;
    public final int d;

    static {
        int i = 0;
        while (true) {
            k[] kVarArr = h;
            if (i < kVarArr.length) {
                kVarArr[i] = new k(i, 0, 0, 0);
                i++;
            } else {
                k kVar = kVarArr[0];
                g = kVar;
                k kVar2 = kVarArr[12];
                e = kVar;
                f = new k(23, 59, 59, 999999999);
                return;
            }
        }
    }

    public static k Q(int i, int i2, int i3, int i4) {
        j$.time.temporal.a.HOUR_OF_DAY.a0(i);
        j$.time.temporal.a.MINUTE_OF_HOUR.a0(i2);
        j$.time.temporal.a.SECOND_OF_MINUTE.a0(i3);
        j$.time.temporal.a.NANO_OF_SECOND.a0(i4);
        return B(i, i2, i3, i4);
    }

    public static k X(long j) {
        j$.time.temporal.a.NANO_OF_DAY.a0(j);
        int i = (int) (j / 3600000000000L);
        long j2 = j - (((long) i) * 3600000000000L);
        int i2 = (int) (j2 / 60000000000L);
        long j3 = j2 - (((long) i2) * 60000000000L);
        int i3 = (int) (j3 / 1000000000);
        return B(i, i2, i3, (int) (j3 - (((long) i3) * 1000000000)));
    }

    public static k G(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        k kVar = (k) temporalAccessor.b(j$.time.temporal.r.g);
        if (kVar != null) {
            return kVar;
        }
        throw new c("Unable to obtain LocalTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    public static k B(int i, int i2, int i3, int i4) {
        if ((i2 | i3 | i4) == 0) {
            return h[i];
        }
        return new k(i, i2, i3, i4);
    }

    public k(int i, int i2, int i3, int i4) {
        this.a = (byte) i;
        this.b = (byte) i2;
        this.c = (byte) i3;
        this.d = i4;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean f(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).b0();
        }
        return qVar != null && qVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int e(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return J(qVar);
        }
        return super.e(qVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.NANO_OF_DAY) {
                return g0();
            }
            if (qVar == j$.time.temporal.a.MICRO_OF_DAY) {
                return g0() / 1000;
            }
            return J(qVar);
        }
        return qVar.Q(this);
    }

    public final int J(j$.time.temporal.q qVar) {
        switch (j.a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.d;
            case 2:
                throw new j$.time.temporal.t("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.d / 1000;
            case 4:
                throw new j$.time.temporal.t("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.d / 1000000;
            case 6:
                return (int) (g0() / 1000000);
            case 7:
                return this.c;
            case 8:
                return h0();
            case 9:
                return this.b;
            case 10:
                return (this.a * 60) + this.b;
            case BaseVideoCapturer.RGBA /* 11 */:
                return this.a % 12;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                int i = this.a % 12;
                if (i % 12 == 0) {
                    return 12;
                }
                return i;
            case 13:
                return this.a;
            case 14:
                byte b = this.a;
                if (b == 0) {
                    return 24;
                }
                return b;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                return this.a / 12;
            default:
                throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: j */
    public final j$.time.temporal.m m(LocalDate localDate) {
        return (k) localDate.c(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public final k i(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (k) qVar.X(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.a0(j);
        switch (j.a[aVar.ordinal()]) {
            case 1:
                return j0((int) j);
            case 2:
                return X(j);
            case 3:
                return j0(((int) j) * 1000);
            case 4:
                return X(j * 1000);
            case 5:
                return j0(((int) j) * 1000000);
            case 6:
                return X(j * 1000000);
            case 7:
                int i = (int) j;
                if (this.c != i) {
                    j$.time.temporal.a.SECOND_OF_MINUTE.a0(i);
                    return B(this.a, this.b, i, this.d);
                }
                return this;
            case 8:
                return e0(j - ((long) h0()));
            case 9:
                int i2 = (int) j;
                if (this.b != i2) {
                    j$.time.temporal.a.MINUTE_OF_HOUR.a0(i2);
                    return B(this.a, i2, this.c, this.d);
                }
                return this;
            case 10:
                return c0(j - ((long) ((this.a * 60) + this.b)));
            case BaseVideoCapturer.RGBA /* 11 */:
                return b0(j - ((long) (this.a % 12)));
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                if (j == 12) {
                    j = 0;
                }
                return b0(j - ((long) (this.a % 12)));
            case 13:
                int i3 = (int) j;
                if (this.a != i3) {
                    j$.time.temporal.a.HOUR_OF_DAY.a0(i3);
                    return B(i3, this.b, this.c, this.d);
                }
                return this;
            case 14:
                if (j == 24) {
                    j = 0;
                }
                int i4 = (int) j;
                if (this.a != i4) {
                    j$.time.temporal.a.HOUR_OF_DAY.a0(i4);
                    return B(i4, this.b, this.c, this.d);
                }
                return this;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                return b0((j - ((long) (this.a / 12))) * 12);
            default:
                throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
    }

    public final k j0(int i) {
        if (this.d == i) {
            return this;
        }
        j$.time.temporal.a.NANO_OF_SECOND.a0(i);
        return B(this.a, this.b, this.c, i);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public final k l(long j, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            switch (j.b[((j$.time.temporal.b) sVar).ordinal()]) {
                case 1:
                    return d0(j);
                case 2:
                    return d0((j % 86400000000L) * 1000);
                case 3:
                    return d0((j % 86400000) * 1000000);
                case 4:
                    return e0(j);
                case 5:
                    return c0(j);
                case 6:
                    return b0(j);
                case 7:
                    return b0((j % 2) * 12);
                default:
                    throw new j$.time.temporal.t("Unsupported unit: " + sVar);
            }
        }
        return (k) sVar.s(this, j);
    }

    public final k b0(long j) {
        return j == 0 ? this : B(((((int) (j % 24)) + this.a) + 24) % 24, this.b, this.c, this.d);
    }

    public final k c0(long j) {
        if (j != 0) {
            int i = (this.a * 60) + this.b;
            int i2 = ((((int) (j % 1440)) + i) + 1440) % 1440;
            if (i != i2) {
                return B(i2 / 60, i2 % 60, this.c, this.d);
            }
        }
        return this;
    }

    public final k e0(long j) {
        if (j != 0) {
            int i = (this.b * 60) + (this.a * 3600) + this.c;
            int i2 = ((((int) (j % 86400)) + i) + SyncConfiguration.DEFAULT_FREQUENCY) % SyncConfiguration.DEFAULT_FREQUENCY;
            if (i != i2) {
                return B(i2 / 3600, (i2 / 60) % 60, i2 % 60, this.d);
            }
        }
        return this;
    }

    public final k d0(long j) {
        if (j != 0) {
            long jG0 = g0();
            long j2 = (((j % 86400000000000L) + jG0) + 86400000000000L) % 86400000000000L;
            if (jG0 != j2) {
                return B((int) (j2 / 3600000000000L), (int) ((j2 / 60000000000L) % 60), (int) ((j2 / 1000000000) % 60), (int) (j2 % 1000000000));
            }
        }
        return this;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j, j$.time.temporal.s sVar) {
        return j == Long.MIN_VALUE ? l(Long.MAX_VALUE, sVar).l(1L, sVar) : l(-j, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(g gVar) {
        if (gVar == j$.time.temporal.r.b || gVar == j$.time.temporal.r.a || gVar == j$.time.temporal.r.e || gVar == j$.time.temporal.r.d) {
            return null;
        }
        if (gVar == j$.time.temporal.r.g) {
            return this;
        }
        if (gVar == j$.time.temporal.r.f) {
            return null;
        }
        if (gVar == j$.time.temporal.r.c) {
            return j$.time.temporal.b.NANOS;
        }
        return gVar.j(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.m c(j$.time.temporal.m mVar) {
        return mVar.i(g0(), j$.time.temporal.a.NANO_OF_DAY);
    }

    public final int h0() {
        return (this.b * 60) + (this.a * 3600) + this.c;
    }

    public final long g0() {
        return (((long) this.c) * 1000000000) + (((long) this.b) * 60000000000L) + (((long) this.a) * 3600000000000L) + ((long) this.d);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final int compareTo(k kVar) {
        int iCompare = Integer.compare(this.a, kVar.a);
        return (iCompare == 0 && (iCompare = Integer.compare(this.b, kVar.b)) == 0 && (iCompare = Integer.compare(this.c, kVar.c)) == 0) ? Integer.compare(this.d, kVar.d) : iCompare;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.a == kVar.a && this.b == kVar.b && this.c == kVar.c && this.d == kVar.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long jG0 = g0();
        return (int) (jG0 ^ (jG0 >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b = this.a;
        byte b2 = this.b;
        byte b3 = this.c;
        int i = this.d;
        sb.append(b < 10 ? "0" : "");
        sb.append((int) b);
        String str = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        sb.append(b2 < 10 ? ":0" : Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append((int) b2);
        if (b3 > 0 || i > 0) {
            if (b3 < 10) {
                str = ":0";
            }
            sb.append(str);
            sb.append((int) b3);
            if (i > 0) {
                sb.append(com.amazon.a.a.o.c.a.b.a);
                if (i % 1000000 == 0) {
                    sb.append(Integer.toString((i / 1000000) + 1000).substring(1));
                } else if (i % 1000 == 0) {
                    sb.append(Integer.toString((i / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i + Http2Connection.DEGRADED_PONG_TIMEOUT_NS).substring(1));
                }
            }
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 4, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final void k0(DataOutput dataOutput) throws IOException {
        if (this.d == 0) {
            if (this.c == 0) {
                if (this.b == 0) {
                    dataOutput.writeByte(~this.a);
                    return;
                } else {
                    dataOutput.writeByte(this.a);
                    dataOutput.writeByte(~this.b);
                    return;
                }
            }
            dataOutput.writeByte(this.a);
            dataOutput.writeByte(this.b);
            dataOutput.writeByte(~this.c);
            return;
        }
        dataOutput.writeByte(this.a);
        dataOutput.writeByte(this.b);
        dataOutput.writeByte(this.c);
        dataOutput.writeInt(this.d);
    }

    public static k f0(DataInput dataInput) throws IOException {
        int i;
        int i2;
        int i3 = dataInput.readByte();
        int i4 = 0;
        if (i3 < 0) {
            i3 = ~i3;
            i2 = 0;
            i = 0;
        } else {
            byte b = dataInput.readByte();
            if (b < 0) {
                int i5 = ~b;
                i = 0;
                i4 = i5;
                i2 = 0;
            } else {
                byte b2 = dataInput.readByte();
                if (b2 < 0) {
                    i2 = ~b2;
                    i = 0;
                    i4 = b;
                } else {
                    i = dataInput.readInt();
                    i4 = b;
                    i2 = b2;
                }
            }
        }
        return Q(i3, i4, i2, i);
    }
}
