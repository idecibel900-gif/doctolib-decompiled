package j$.time.format;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;

/* JADX INFO: renamed from: j$.time.format.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1183f extends i {
    public final boolean g;

    @Override // j$.time.format.i, j$.time.format.InterfaceC1182e
    public final int B(v vVar, CharSequence charSequence, int i) {
        boolean z = vVar.c;
        DateTimeFormatter dateTimeFormatter = vVar.a;
        int i2 = (z || b(vVar)) ? this.b : 0;
        int i3 = (vVar.c || b(vVar)) ? this.c : 9;
        int length = charSequence.length();
        if (i != length) {
            if (this.g) {
                char cCharAt = charSequence.charAt(i);
                dateTimeFormatter.c.getClass();
                if (cCharAt == '.') {
                    i++;
                } else if (i2 > 0) {
                    return ~i;
                }
            }
            int i4 = i;
            int i5 = i2 + i4;
            if (i5 > length) {
                return ~i4;
            }
            int iMin = Math.min(i3 + i4, length);
            int i6 = 0;
            int i7 = i4;
            while (i7 < iMin) {
                int i8 = i7 + 1;
                char cCharAt2 = charSequence.charAt(i7);
                dateTimeFormatter.c.getClass();
                int i9 = cCharAt2 - '0';
                if (i9 < 0 || i9 > 9) {
                    i9 = -1;
                }
                if (i9 < 0) {
                    if (i8 >= i5) {
                        break;
                    }
                    return ~i4;
                }
                i6 = (i6 * 10) + i9;
                i7 = i8;
            }
            BigDecimal bigDecimalMovePointLeft = new BigDecimal(i6).movePointLeft(i7 - i4);
            j$.time.temporal.u uVarJ = this.a.J();
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(uVarJ.a);
            return vVar.f(this.a, bigDecimalMovePointLeft.multiply(BigDecimal.valueOf(uVarJ.d).subtract(bigDecimalValueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(bigDecimalValueOf).longValueExact(), i4, i7);
        }
        if (i2 > 0) {
            return ~i;
        }
        return i;
    }

    @Override // j$.time.format.i
    public final boolean b(v vVar) {
        return vVar.c && this.b == this.c && !this.g;
    }

    public C1183f(j$.time.temporal.q qVar, int i, int i2, boolean z) {
        this(qVar, i, i2, z, 0);
        Objects.requireNonNull(qVar, "field");
        j$.time.temporal.u uVarJ = qVar.J();
        if (uVarJ.a != uVarJ.b || uVarJ.c != uVarJ.d) {
            throw new IllegalArgumentException(j$.time.d.a("Field must have a fixed set of values: ", qVar));
        }
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + i);
        }
        if (i2 < 1 || i2 > 9) {
            throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + i2);
        }
        if (i2 >= i) {
            return;
        }
        throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i2 + " < " + i);
    }

    public C1183f(j$.time.temporal.q qVar, int i, int i2, boolean z, int i3) {
        super(qVar, i, i2, F.NOT_NEGATIVE, i3);
        this.g = z;
    }

    @Override // j$.time.format.i
    public final i d() {
        if (this.e == -1) {
            return this;
        }
        return new C1183f(this.a, this.b, this.c, this.g, -1);
    }

    @Override // j$.time.format.i
    public final i e(int i) {
        return new C1183f(this.a, this.b, this.c, this.g, this.e + i);
    }

    @Override // j$.time.format.i, j$.time.format.InterfaceC1182e
    public final boolean s(y yVar, StringBuilder sb) {
        j$.time.temporal.q qVar = this.a;
        Long lA = yVar.a(qVar);
        if (lA == null) {
            return false;
        }
        C c = yVar.b.c;
        long jLongValue = lA.longValue();
        j$.time.temporal.u uVarJ = qVar.J();
        uVarJ.b(jLongValue, qVar);
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(uVarJ.a);
        BigDecimal bigDecimalAdd = BigDecimal.valueOf(uVarJ.d).subtract(bigDecimalValueOf).add(BigDecimal.ONE);
        BigDecimal bigDecimalSubtract = BigDecimal.valueOf(jLongValue).subtract(bigDecimalValueOf);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal bigDecimalDivide = bigDecimalSubtract.divide(bigDecimalAdd, 9, roundingMode);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (bigDecimalDivide.compareTo(bigDecimal) != 0) {
            bigDecimal = bigDecimalDivide.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimalDivide.stripTrailingZeros();
        }
        int iScale = bigDecimal.scale();
        boolean z = this.g;
        int i = this.b;
        if (iScale != 0) {
            String strSubstring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i), this.c), roundingMode).toPlainString().substring(2);
            c.getClass();
            if (z) {
                sb.append(com.amazon.a.a.o.c.a.b.a);
            }
            sb.append(strSubstring);
            return true;
        }
        if (i > 0) {
            if (z) {
                c.getClass();
                sb.append(com.amazon.a.a.o.c.a.b.a);
            }
            for (int i2 = 0; i2 < i; i2++) {
                c.getClass();
                sb.append('0');
            }
        }
        return true;
    }

    @Override // j$.time.format.i
    public final String toString() {
        return "Fraction(" + this.a + com.amazon.a.a.o.b.f.a + this.b + com.amazon.a.a.o.b.f.a + this.c + (this.g ? ",DecimalPoint" : "") + ")";
    }
}
