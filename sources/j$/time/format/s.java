package j$.time.format;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.text.ParsePosition;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class s implements InterfaceC1182e {
    public static volatile Map.Entry c;
    public static volatile Map.Entry d;
    public final j$.time.g a;
    public final String b;

    public m a(v vVar) {
        Set<String> set = j$.time.zone.i.d;
        int size = set.size();
        Map.Entry simpleImmutableEntry = vVar.b ? c : d;
        if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
            synchronized (this) {
                try {
                    simpleImmutableEntry = vVar.b ? c : d;
                    if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                        Integer numValueOf = Integer.valueOf(size);
                        m mVar = vVar.b ? new m("", null, null) : new l("", null, null);
                        for (String str : set) {
                            mVar.a(str, str);
                        }
                        simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(numValueOf, mVar);
                        if (vVar.b) {
                            c = simpleImmutableEntry;
                        } else {
                            d = simpleImmutableEntry;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return (m) simpleImmutableEntry.getValue();
    }

    public s(j$.time.g gVar, String str) {
        this.a = gVar;
        this.b = str;
    }

    @Override // j$.time.format.InterfaceC1182e
    public boolean s(y yVar, StringBuilder sb) {
        ZoneId zoneId = (ZoneId) yVar.b(this.a);
        if (zoneId == null) {
            return false;
        }
        sb.append(zoneId.q());
        return true;
    }

    @Override // j$.time.format.InterfaceC1182e
    public final int B(v vVar, CharSequence charSequence, int i) {
        int i2;
        int length = charSequence.length();
        if (i > length) {
            throw new IndexOutOfBoundsException();
        }
        if (i == length) {
            return ~i;
        }
        char cCharAt = charSequence.charAt(i);
        if (cCharAt == '+' || cCharAt == '-') {
            return b(vVar, charSequence, i, i, j.e);
        }
        int i3 = i + 2;
        if (length >= i3) {
            char cCharAt2 = charSequence.charAt(i + 1);
            if (vVar.a(cCharAt, 'U') && vVar.a(cCharAt2, 'T')) {
                int i4 = i + 3;
                if (length >= i4 && vVar.a(charSequence.charAt(i3), 'C')) {
                    return b(vVar, charSequence, i, i4, j.f);
                }
                return b(vVar, charSequence, i, i3, j.f);
            }
            if (vVar.a(cCharAt, 'G') && length >= (i2 = i + 3) && vVar.a(cCharAt2, 'M') && vVar.a(charSequence.charAt(i3), 'T')) {
                int i5 = i + 4;
                if (length >= i5 && vVar.a(charSequence.charAt(i2), '0')) {
                    vVar.e(ZoneId.B("GMT0", true));
                    return i5;
                }
                return b(vVar, charSequence, i, i2, j.f);
            }
        }
        m mVarA = a(vVar);
        ParsePosition parsePosition = new ParsePosition(i);
        String strC = mVarA.c(charSequence, parsePosition);
        if (strC == null) {
            if (!vVar.a(cCharAt, 'Z')) {
                return ~i;
            }
            vVar.e(ZoneOffset.UTC);
            return i + 1;
        }
        vVar.e(ZoneId.B(strC, true));
        return parsePosition.getIndex();
    }

    public static int b(v vVar, CharSequence charSequence, int i, int i2, j jVar) {
        String upperCase = charSequence.subSequence(i, i2).toString().toUpperCase();
        if (i2 >= charSequence.length()) {
            vVar.e(ZoneId.B(upperCase, true));
            return i2;
        }
        if (charSequence.charAt(i2) != '0' && !vVar.a(charSequence.charAt(i2), 'Z')) {
            v vVar2 = new v(vVar.a);
            vVar2.b = vVar.b;
            vVar2.c = vVar.c;
            int iB = jVar.B(vVar2, charSequence, i2);
            try {
                if (iB < 0) {
                    if (jVar == j.e) {
                        return ~i;
                    }
                    vVar.e(ZoneId.B(upperCase, true));
                    return i2;
                }
                vVar.e(ZoneId.G(upperCase, ZoneOffset.b0((int) vVar2.d(j$.time.temporal.a.OFFSET_SECONDS).longValue())));
                return iB;
            } catch (j$.time.c unused) {
                return ~i;
            }
        }
        vVar.e(ZoneId.B(upperCase, true));
        return i2;
    }

    public final String toString() {
        return this.b;
    }
}
