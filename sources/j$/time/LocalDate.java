package j$.time;

import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import io.didomi.ssl.config.app.SyncConfiguration;
import j$.time.chrono.InterfaceC1168b;
import j$.time.chrono.InterfaceC1171e;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalDate implements j$.time.temporal.m, j$.time.temporal.n, InterfaceC1168b, Serializable {
    public static final LocalDate d = e0(-999999999, 1, 1);
    public static final LocalDate e = e0(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;
    public final int a;
    public final short b;
    public final short c;

    static {
        e0(1970, 1, 1);
    }

    public static LocalDate e0(int i, int i2, int i3) {
        j$.time.temporal.a.YEAR.a0(i);
        j$.time.temporal.a.MONTH_OF_YEAR.a0(i2);
        j$.time.temporal.a.DAY_OF_MONTH.a0(i3);
        return B(i, i2, i3);
    }

    public static LocalDate g0(int i, int i2) {
        long j = i;
        j$.time.temporal.a.YEAR.a0(j);
        j$.time.temporal.a.DAY_OF_YEAR.a0(i2);
        boolean zY = j$.time.chrono.t.c.Y(j);
        if (i2 == 366 && !zY) {
            throw new c("Invalid date 'DayOfYear 366' as '" + i + "' is not a leap year");
        }
        m mVarJ = m.J(((i2 - 1) / 31) + 1);
        if (i2 > (mVarJ.B(zY) + mVarJ.s(zY)) - 1) {
            mVarJ = m.a[((((int) 1) + 12) + mVarJ.ordinal()) % 12];
        }
        return new LocalDate(i, mVarJ.getValue(), (i2 - mVarJ.s(zY)) + 1);
    }

    public static LocalDate f0(long j) {
        long j2;
        j$.time.temporal.a.EPOCH_DAY.a0(j);
        long j3 = 719468 + j;
        if (j3 < 0) {
            long j4 = ((j + 719469) / 146097) - 1;
            j2 = j4 * 400;
            j3 += (-j4) * 146097;
        } else {
            j2 = 0;
        }
        long j5 = ((j3 * 400) + 591) / 146097;
        long j6 = j3 - ((j5 / 400) + (((j5 / 4) + (j5 * 365)) - (j5 / 100)));
        if (j6 < 0) {
            j5--;
            j6 = j3 - ((j5 / 400) + (((j5 / 4) + (365 * j5)) - (j5 / 100)));
        }
        int i = (int) j6;
        int i2 = ((i * 5) + 2) / 153;
        int i3 = ((i2 + 2) % 12) + 1;
        int i4 = (i - (((i2 * 306) + 5) / 10)) + 1;
        long j7 = j5 + j2 + ((long) (i2 / 10));
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return new LocalDate(aVar.b.a(j7, aVar), i3, i4);
    }

    public static LocalDate G(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        LocalDate localDate = (LocalDate) temporalAccessor.b(j$.time.temporal.r.f);
        if (localDate != null) {
            return localDate;
        }
        throw new c("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    public static LocalDate parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        String string;
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        g gVar = new g(0);
        Objects.requireNonNull(charSequence, "text");
        try {
            return (LocalDate) dateTimeFormatter.a(charSequence).b(gVar);
        } catch (j$.time.format.w e2) {
            throw e2;
        } catch (RuntimeException e3) {
            if (charSequence.length() > 64) {
                string = charSequence.subSequence(0, 64).toString() + "...";
            } else {
                string = charSequence.toString();
            }
            j$.time.format.w wVar = new j$.time.format.w("Text '" + string + "' could not be parsed: " + e3.getMessage(), e3);
            charSequence.toString();
            throw wVar;
        }
    }

    public static LocalDate B(int i, int i2, int i3) {
        int i4 = 28;
        if (i3 > 28) {
            if (i2 != 2) {
                i4 = (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? 30 : 31;
            } else if (j$.time.chrono.t.c.Y(i)) {
                i4 = 29;
            }
            if (i3 > i4) {
                if (i3 == 29) {
                    throw new c("Invalid date 'February 29' as '" + i + "' is not a leap year");
                }
                throw new c("Invalid date '" + m.J(i2).name() + " " + i3 + "'");
            }
        }
        return new LocalDate(i, i2, i3);
    }

    public static LocalDate m0(int i, int i2, int i3) {
        if (i2 == 2) {
            i3 = Math.min(i3, j$.time.chrono.t.c.Y((long) i) ? 29 : 28);
        } else if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
            i3 = Math.min(i3, 30);
        }
        return new LocalDate(i, i2, i3);
    }

    public LocalDate(int i, int i2, int i3) {
        this.a = i;
        this.b = (short) i2;
        this.c = (short) i3;
    }

    public static LocalDate d0(a aVar) {
        Instant instantOfEpochMilli = Instant.ofEpochMilli(System.currentTimeMillis());
        ZoneId zoneId = aVar.a;
        Objects.requireNonNull(instantOfEpochMilli, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return f0(Math.floorDiv(instantOfEpochMilli.getEpochSecond() + ((long) zoneId.s().d(instantOfEpochMilli).b), SyncConfiguration.DEFAULT_FREQUENCY));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.u k(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.B(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        if (!aVar.isDateBased()) {
            throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
        int i = h.a[aVar.ordinal()];
        if (i == 1) {
            return j$.time.temporal.u.f(1L, b0());
        }
        if (i == 2) {
            return j$.time.temporal.u.f(1L, V());
        }
        if (i == 3) {
            return j$.time.temporal.u.f(1L, (m.J(this.b) != m.FEBRUARY || y()) ? 5L : 4L);
        }
        if (i != 4) {
            return aVar.b;
        }
        return this.a <= 0 ? j$.time.temporal.u.f(1L, 1000000000L) : j$.time.temporal.u.f(1L, 999999999L);
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
            if (qVar == j$.time.temporal.a.EPOCH_DAY) {
                return L();
            }
            if (qVar != j$.time.temporal.a.PROLEPTIC_MONTH) {
                return J(qVar);
            }
            return ((((long) this.a) * 12) + ((long) this.b)) - 1;
        }
        return qVar.Q(this);
    }

    public final int J(j$.time.temporal.q qVar) {
        switch (h.a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.c;
            case 2:
                return X();
            case 3:
                return ((this.c - 1) / 7) + 1;
            case 4:
                int i = this.a;
                return i >= 1 ? i : 1 - i;
            case 5:
                return Q().getValue();
            case 6:
                return ((this.c - 1) % 7) + 1;
            case 7:
                return ((X() - 1) % 7) + 1;
            case 8:
                throw new j$.time.temporal.t("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((X() - 1) / 7) + 1;
            case 10:
                return this.b;
            case BaseVideoCapturer.RGBA /* 11 */:
                throw new j$.time.temporal.t("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                return this.a;
            case 13:
                return this.a >= 1 ? 1 : 0;
            default:
                throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.chrono.InterfaceC1168b
    public final j$.time.chrono.m d() {
        return j$.time.chrono.t.c;
    }

    @Override // j$.time.chrono.InterfaceC1168b
    public final j$.time.chrono.n O() {
        return this.a >= 1 ? j$.time.chrono.u.CE : j$.time.chrono.u.BCE;
    }

    public final int X() {
        return (m.J(this.b).s(y()) + this.c) - 1;
    }

    public final e Q() {
        return e.s(((int) Math.floorMod(L() + 3, 7)) + 1);
    }

    @Override // j$.time.chrono.InterfaceC1168b
    public final boolean y() {
        return j$.time.chrono.t.c.Y(this.a);
    }

    public final int b0() {
        short s = this.b;
        if (s != 2) {
            return (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31;
        }
        return y() ? 29 : 28;
    }

    @Override // j$.time.chrono.InterfaceC1168b
    public final int V() {
        return y() ? 366 : 365;
    }

    @Override // j$.time.chrono.InterfaceC1168b
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final LocalDate m(j$.time.temporal.n nVar) {
        if (nVar instanceof LocalDate) {
            return (LocalDate) nVar;
        }
        return (LocalDate) nVar.c(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public final LocalDate i(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (LocalDate) qVar.X(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.a0(j);
        switch (h.a[aVar.ordinal()]) {
            case 1:
                int i = (int) j;
                if (this.c != i) {
                    return e0(this.a, this.b, i);
                }
                return this;
            case 2:
                int i2 = (int) j;
                if (X() != i2) {
                    return g0(this.a, i2);
                }
                return this;
            case 3:
                return k0(j - g(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH));
            case 4:
                if (this.a < 1) {
                    j = 1 - j;
                }
                return p0((int) j);
            case 5:
                return i0(j - ((long) Q().getValue()));
            case 6:
                return i0(j - g(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return i0(j - g(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return f0(j);
            case 9:
                return k0(j - g(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR));
            case 10:
                int i3 = (int) j;
                if (this.b != i3) {
                    j$.time.temporal.a.MONTH_OF_YEAR.a0(i3);
                    return m0(this.a, i3, this.c);
                }
                return this;
            case BaseVideoCapturer.RGBA /* 11 */:
                return j0(j - (((((long) this.a) * 12) + ((long) this.b)) - 1));
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                return p0((int) j);
            case 13:
                if (g(j$.time.temporal.a.ERA) != j) {
                    return p0(1 - this.a);
                }
                return this;
            default:
                throw new j$.time.temporal.t(d.a("Unsupported field: ", qVar));
        }
    }

    public final LocalDate p0(int i) {
        if (this.a == i) {
            return this;
        }
        j$.time.temporal.a.YEAR.a0(i);
        return m0(i, this.b, this.c);
    }

    @Override // j$.time.chrono.InterfaceC1168b
    public final InterfaceC1168b S(j$.time.temporal.p pVar) {
        if (pVar != null) {
            r rVar = (r) pVar;
            return j0((((long) rVar.a) * 12) + ((long) rVar.b)).i0(rVar.c);
        }
        Objects.requireNonNull(pVar, "amountToAdd");
        return (LocalDate) ((r) pVar).s(this);
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public final LocalDate l(long j, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (LocalDate) sVar.s(this, j);
        }
        switch (h.b[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return i0(j);
            case 2:
                return k0(j);
            case 3:
                return j0(j);
            case 4:
                return l0(j);
            case 5:
                return l0(Math.multiplyExact(j, 10));
            case 6:
                return l0(Math.multiplyExact(j, 100));
            case 7:
                return l0(Math.multiplyExact(j, 1000));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return i(Math.addExact(g(aVar), j), aVar);
            default:
                throw new j$.time.temporal.t("Unsupported unit: " + sVar);
        }
    }

    public final LocalDate l0(long j) {
        if (j == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return m0(aVar.b.a(((long) this.a) + j, aVar), this.b, this.c);
    }

    public final LocalDate j0(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (((long) this.a) * 12) + ((long) (this.b - 1)) + j;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        long j3 = 12;
        return m0(aVar.b.a(Math.floorDiv(j2, j3), aVar), ((int) Math.floorMod(j2, j3)) + 1, this.c);
    }

    public final LocalDate k0(long j) {
        return i0(Math.multiplyExact(j, 7));
    }

    public final LocalDate i0(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = ((long) this.c) + j;
        if (j2 > 0) {
            if (j2 <= 28) {
                return new LocalDate(this.a, this.b, (int) j2);
            }
            if (j2 <= 59) {
                long jB0 = b0();
                if (j2 <= jB0) {
                    return new LocalDate(this.a, this.b, (int) j2);
                }
                short s = this.b;
                if (s < 12) {
                    return new LocalDate(this.a, s + 1, (int) (j2 - jB0));
                }
                j$.time.temporal.a.YEAR.a0(this.a + 1);
                return new LocalDate(this.a + 1, 1, (int) (j2 - jB0));
            }
        }
        return f0(Math.addExact(L(), j));
    }

    @Override // j$.time.temporal.m
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public final LocalDate a(long j, j$.time.temporal.s sVar) {
        return j == Long.MIN_VALUE ? l(Long.MAX_VALUE, sVar).l(1L, sVar) : l(-j, sVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object b(g gVar) {
        return gVar == j$.time.temporal.r.f ? this : super.b(gVar);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // j$.time.chrono.InterfaceC1168b
    public final InterfaceC1171e M(k kVar) {
        return LocalDateTime.J(this, kVar);
    }

    @Override // j$.time.chrono.InterfaceC1168b
    public final long L() {
        long j;
        long j2 = this.a;
        long j3 = this.b;
        long j4 = 365 * j2;
        if (j2 >= 0) {
            j = ((j2 + 399) / 400) + (((3 + j2) / 4) - ((99 + j2) / 100)) + j4;
        } else {
            j = j4 - ((j2 / (-400)) + ((j2 / (-4)) - (j2 / (-100))));
        }
        long j5 = (((367 * j3) - 362) / 12) + j + ((long) (this.c - 1));
        if (j3 > 2) {
            j5 = !y() ? j5 - 2 : j5 - 1;
        }
        return j5 - 719528;
    }

    @Override // j$.time.chrono.InterfaceC1168b, java.lang.Comparable
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final int compareTo(InterfaceC1168b interfaceC1168b) {
        if (interfaceC1168b instanceof LocalDate) {
            return s((LocalDate) interfaceC1168b);
        }
        return super.compareTo(interfaceC1168b);
    }

    public final int s(LocalDate localDate) {
        int i = this.a - localDate.a;
        if (i != 0) {
            return i;
        }
        int i2 = this.b - localDate.b;
        return i2 == 0 ? this.c - localDate.c : i2;
    }

    public final boolean a0(InterfaceC1168b interfaceC1168b) {
        if (interfaceC1168b instanceof LocalDate) {
            return s((LocalDate) interfaceC1168b) < 0;
        }
        return L() < interfaceC1168b.L();
    }

    @Override // j$.time.chrono.InterfaceC1168b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalDate) && s((LocalDate) obj) == 0;
    }

    @Override // j$.time.chrono.InterfaceC1168b
    public final int hashCode() {
        int i = this.a;
        return (((i << 11) + (this.b << 6)) + this.c) ^ (i & (-2048));
    }

    @Override // j$.time.chrono.InterfaceC1168b
    public final String toString() {
        int i = this.a;
        short s = this.b;
        short s2 = this.c;
        int iAbs = Math.abs(i);
        StringBuilder sb = new StringBuilder(10);
        if (iAbs >= 1000) {
            if (i > 9999) {
                sb.append('+');
            }
            sb.append(i);
        } else if (i < 0) {
            sb.append(i - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i + ColorExtractionConstants.MAX_PIXEL_SAMPLES);
            sb.deleteCharAt(0);
        }
        sb.append(s < 10 ? "-0" : "-");
        sb.append((int) s);
        sb.append(s2 < 10 ? "-0" : "-");
        sb.append((int) s2);
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
