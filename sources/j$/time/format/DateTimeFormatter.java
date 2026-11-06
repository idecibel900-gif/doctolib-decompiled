package j$.time.format;

import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.InterfaceC1168b;
import j$.time.chrono.InterfaceC1171e;
import j$.time.chrono.InterfaceC1176j;
import j$.time.temporal.TemporalAccessor;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class DateTimeFormatter {
    public static final DateTimeFormatter ISO_DATE_TIME;
    public static final DateTimeFormatter ISO_INSTANT;
    public static final DateTimeFormatter ISO_LOCAL_DATE;
    public final C1181d a;
    public final Locale b;
    public final C c;
    public final E d;
    public final j$.time.chrono.m e;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:108:0x01b9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:110:0x01c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:148:0x0265  */
    /* JADX WARN: Code duplicated, block: B:249:0x045b  */
    /* JADX WARN: Code duplicated, block: B:251:0x0465  */
    /* JADX WARN: Code duplicated, block: B:252:0x0469  */
    /* JADX WARN: Code duplicated, block: B:285:0x01c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:298:0x0474 A[SYNTHETIC] */
    public static DateTimeFormatter ofPattern(String str, Locale locale) {
        String strSubstring;
        boolean z;
        int i;
        int i2;
        u uVar = new u();
        Objects.requireNonNull(str, "pattern");
        int i3 = 0;
        while (i3 < str.length()) {
            char cCharAt = str.charAt(i3);
            if ((cCharAt >= 'A' && cCharAt <= 'Z') || (cCharAt >= 'a' && cCharAt <= 'z')) {
                int i4 = i3 + 1;
                while (i4 < str.length() && str.charAt(i4) == cCharAt) {
                    i4++;
                }
                int i5 = i4 - i3;
                if (cCharAt == 'p') {
                    if (i4 >= str.length() || (((cCharAt = str.charAt(i4)) < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z'))) {
                        i = i4;
                        i2 = i5;
                        i5 = 0;
                    } else {
                        i = i4 + 1;
                        while (i < str.length() && str.charAt(i) == cCharAt) {
                            i++;
                        }
                        i2 = i - i4;
                    }
                    if (i5 == 0) {
                        throw new IllegalArgumentException("Pad letter 'p' must be followed by valid pad pattern: ".concat(str));
                    }
                    if (i5 < 1) {
                        throw new IllegalArgumentException("The pad width must be at least one but was " + i5);
                    }
                    u uVar2 = uVar.a;
                    uVar2.e = i5;
                    uVar2.f = ' ';
                    uVar2.g = -1;
                    i5 = i2;
                    i4 = i;
                }
                j$.time.temporal.q qVar = (j$.time.temporal.q) ((HashMap) u.i).get(Character.valueOf(cCharAt));
                if (qVar != null) {
                    if (cCharAt == 'A') {
                        uVar.m(qVar, i5, 19, F.NOT_NEGATIVE);
                    } else {
                        if (cCharAt == 'Q') {
                            z = false;
                        } else if (cCharAt == 'S') {
                            uVar.b(j$.time.temporal.a.NANO_OF_SECOND, i5, i5, false);
                        } else if (cCharAt == 'a') {
                            if (i5 != 1) {
                                throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                            }
                            uVar.i(qVar, G.SHORT);
                        } else if (cCharAt == 'k') {
                            if (i5 == 1) {
                                uVar.k(qVar);
                            } else {
                                if (i5 == 2) {
                                    throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                                }
                                uVar.l(qVar, i5);
                            }
                        } else if (cCharAt == 'q') {
                            z = true;
                        } else if (cCharAt == 's') {
                            if (i5 == 1) {
                                uVar.k(qVar);
                            } else {
                                if (i5 == 2) {
                                    throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                                }
                                uVar.l(qVar, i5);
                            }
                        } else if (cCharAt == 'u' || cCharAt == 'y') {
                            if (i5 == 2) {
                                LocalDate localDate = o.h;
                                Objects.requireNonNull(localDate, "baseDate");
                                uVar.j(new o(qVar, 2, 2, localDate, 0));
                            } else if (i5 < 4) {
                                uVar.m(qVar, i5, 19, F.NORMAL);
                            } else {
                                uVar.m(qVar, i5, 19, F.EXCEEDS_PAD);
                            }
                        } else if (cCharAt == 'g') {
                            uVar.m(qVar, i5, 19, F.NORMAL);
                        } else if (cCharAt == 'h' || cCharAt == 'm') {
                            if (i5 == 1) {
                                uVar.k(qVar);
                            } else {
                                if (i5 == 2) {
                                    throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                                }
                                uVar.l(qVar, i5);
                            }
                        } else if (cCharAt != 'n') {
                            switch (cCharAt) {
                                case 'D':
                                    if (i5 == 1) {
                                        uVar.k(qVar);
                                    } else {
                                        if (i5 != 2 && i5 != 3) {
                                            throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                                        }
                                        uVar.m(qVar, i5, 3, F.NOT_NEGATIVE);
                                    }
                                    break;
                                case 'E':
                                    z = false;
                                    break;
                                case 'F':
                                    if (i5 != 1) {
                                        throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                                    }
                                    uVar.k(qVar);
                                    break;
                                    break;
                                case 'G':
                                    if (i5 == 1 || i5 == 2 || i5 == 3) {
                                        uVar.i(qVar, G.SHORT);
                                    } else if (i5 == 4) {
                                        uVar.i(qVar, G.FULL);
                                    } else {
                                        if (i5 != 5) {
                                            throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                                        }
                                        uVar.i(qVar, G.NARROW);
                                    }
                                    break;
                                default:
                                    switch (cCharAt) {
                                        case 'K':
                                            break;
                                        case 'L':
                                            z = true;
                                            break;
                                        case 'M':
                                            z = false;
                                            break;
                                        case 'N':
                                            uVar.m(qVar, i5, 19, F.NOT_NEGATIVE);
                                            break;
                                        default:
                                            switch (cCharAt) {
                                                case 'c':
                                                    if (i5 == 1) {
                                                        int i6 = i5;
                                                        uVar.j(new r(cCharAt, i6, i6, i6, 0));
                                                    } else {
                                                        if (i5 == 2) {
                                                            throw new IllegalArgumentException("Invalid pattern \"cc\"");
                                                        }
                                                        z = true;
                                                    }
                                                    break;
                                                case 'd':
                                                    break;
                                                case 'e':
                                                    z = false;
                                                    break;
                                                default:
                                                    if (i5 != 1) {
                                                        uVar.l(qVar, i5);
                                                    } else {
                                                        uVar.k(qVar);
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                case 'H':
                                    if (i5 == 1) {
                                        uVar.k(qVar);
                                    } else {
                                        if (i5 == 2) {
                                            throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                                        }
                                        uVar.l(qVar, i5);
                                    }
                                    break;
                            }
                        } else {
                            uVar.m(qVar, i5, 19, F.NOT_NEGATIVE);
                        }
                        if (i5 == 1 || i5 == 2) {
                            if (cCharAt == 'e') {
                                int i7 = i5;
                                uVar.j(new r(cCharAt, i7, i7, i7, 0));
                            } else if (cCharAt == 'E') {
                                uVar.i(qVar, G.SHORT);
                            } else if (i5 == 1) {
                                uVar.k(qVar);
                            } else {
                                uVar.l(qVar, 2);
                            }
                        } else if (i5 == 3) {
                            uVar.i(qVar, z ? G.SHORT_STANDALONE : G.SHORT);
                        } else if (i5 == 4) {
                            uVar.i(qVar, z ? G.FULL_STANDALONE : G.FULL);
                        } else {
                            if (i5 != 5) {
                                throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                            }
                            uVar.i(qVar, z ? G.NARROW_STANDALONE : G.NARROW);
                        }
                    }
                } else if (cCharAt == 'z') {
                    if (i5 > 4) {
                        throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                    }
                    if (i5 == 4) {
                        uVar.c(new t(G.FULL, false));
                    } else {
                        uVar.c(new t(G.SHORT, false));
                    }
                } else if (cCharAt == 'V') {
                    if (i5 != 2) {
                        throw new IllegalArgumentException("Pattern letter count must be 2: " + cCharAt);
                    }
                    uVar.c(new s(j$.time.temporal.r.a, "ZoneId()"));
                } else if (cCharAt != 'v') {
                    String str2 = "+0000";
                    if (cCharAt == 'Z') {
                        if (i5 < 4) {
                            uVar.g("+HHMM", "+0000");
                        } else if (i5 == 4) {
                            uVar.f(G.FULL);
                        } else {
                            if (i5 != 5) {
                                throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                            }
                            uVar.g("+HH:MM:ss", "Z");
                        }
                    } else if (cCharAt == 'O') {
                        if (i5 == 1) {
                            uVar.f(G.SHORT);
                        } else {
                            if (i5 != 4) {
                                throw new IllegalArgumentException("Pattern letter count must be 1 or 4: " + cCharAt);
                            }
                            uVar.f(G.FULL);
                        }
                    } else if (cCharAt == 'X') {
                        if (i5 > 5) {
                            throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                        }
                        uVar.g(j.d[i5 + (i5 == 1 ? 0 : 1)], "Z");
                    } else if (cCharAt == 'x') {
                        if (i5 > 5) {
                            throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                        }
                        if (i5 == 1) {
                            str2 = "+00";
                        } else if (i5 % 2 != 0) {
                            str2 = "+00:00";
                        }
                        uVar.g(j.d[i5 + (i5 == 1 ? 0 : 1)], str2);
                    } else if (cCharAt != 'W') {
                        int i8 = i5;
                        if (cCharAt == 'w') {
                            if (i8 > 2) {
                                throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                            }
                            uVar.j(new r(cCharAt, i8, i8, 2, 0));
                        } else {
                            if (cCharAt != 'Y') {
                                throw new IllegalArgumentException("Unknown pattern letter: " + cCharAt);
                            }
                            if (i8 == 2) {
                                uVar.j(new r(cCharAt, i8, i8, 2, 0));
                            } else {
                                uVar.j(new r(cCharAt, i8, i8, 19, 0));
                            }
                        }
                    } else {
                        if (i5 > 1) {
                            throw new IllegalArgumentException("Too many pattern letters: " + cCharAt);
                        }
                        int i9 = i5;
                        uVar.j(new r(cCharAt, i9, i9, i9, 0));
                    }
                } else if (i5 == 1) {
                    uVar.c(new t(G.SHORT, true));
                } else {
                    if (i5 != 4) {
                        throw new IllegalArgumentException("Wrong number of  pattern letters: " + cCharAt);
                    }
                    uVar.c(new t(G.FULL, true));
                }
                i3 = i4 - 1;
            } else if (cCharAt == '\'') {
                int i10 = i3 + 1;
                int i11 = i10;
                while (i11 < str.length()) {
                    if (str.charAt(i11) == '\'') {
                        int i12 = i11 + 1;
                        if (i12 < str.length() && str.charAt(i12) == '\'') {
                            i11 = i12;
                        } else {
                            if (i11 < str.length()) {
                                throw new IllegalArgumentException("Pattern ends with an incomplete string literal: ".concat(str));
                            }
                            strSubstring = str.substring(i10, i11);
                            if (strSubstring.isEmpty()) {
                                uVar.d('\'');
                            } else {
                                uVar.e(strSubstring.replace("''", "'"));
                            }
                            i3 = i11;
                        }
                    }
                    i11++;
                }
                if (i11 < str.length()) {
                    throw new IllegalArgumentException("Pattern ends with an incomplete string literal: ".concat(str));
                }
                strSubstring = str.substring(i10, i11);
                if (strSubstring.isEmpty()) {
                    uVar.d('\'');
                } else {
                    uVar.e(strSubstring.replace("''", "'"));
                }
                i3 = i11;
            } else if (cCharAt == '[') {
                uVar.o();
            } else if (cCharAt == ']') {
                if (uVar.a.b == null) {
                    throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
                }
                uVar.n();
            } else {
                if (cCharAt == '{' || cCharAt == '}' || cCharAt == '#') {
                    throw new IllegalArgumentException("Pattern includes reserved character: '" + cCharAt + "'");
                }
                uVar.d(cCharAt);
            }
            i3++;
        }
        return uVar.q(locale, E.SMART, null);
    }

    static {
        u uVar = new u();
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        F f = F.EXCEEDS_PAD;
        uVar.m(aVar, 4, 10, f);
        uVar.d('-');
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        uVar.l(aVar2, 2);
        uVar.d('-');
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        uVar.l(aVar3, 2);
        E e = E.STRICT;
        j$.time.chrono.t tVar = j$.time.chrono.t.c;
        DateTimeFormatter dateTimeFormatterP = uVar.p(e, tVar);
        ISO_LOCAL_DATE = dateTimeFormatterP;
        u uVar2 = new u();
        p pVar = p.INSENSITIVE;
        uVar2.c(pVar);
        uVar2.a(dateTimeFormatterP);
        j jVar = j.e;
        uVar2.c(jVar);
        uVar2.p(e, tVar);
        u uVar3 = new u();
        uVar3.c(pVar);
        uVar3.a(dateTimeFormatterP);
        uVar3.o();
        uVar3.c(jVar);
        uVar3.p(e, tVar);
        u uVar4 = new u();
        j$.time.temporal.a aVar4 = j$.time.temporal.a.HOUR_OF_DAY;
        uVar4.l(aVar4, 2);
        uVar4.d(':');
        j$.time.temporal.a aVar5 = j$.time.temporal.a.MINUTE_OF_HOUR;
        uVar4.l(aVar5, 2);
        uVar4.o();
        uVar4.d(':');
        j$.time.temporal.a aVar6 = j$.time.temporal.a.SECOND_OF_MINUTE;
        uVar4.l(aVar6, 2);
        uVar4.o();
        uVar4.b(j$.time.temporal.a.NANO_OF_SECOND, 0, 9, true);
        DateTimeFormatter dateTimeFormatterP2 = uVar4.p(e, null);
        u uVar5 = new u();
        uVar5.c(pVar);
        uVar5.a(dateTimeFormatterP2);
        uVar5.c(jVar);
        uVar5.p(e, null);
        u uVar6 = new u();
        uVar6.c(pVar);
        uVar6.a(dateTimeFormatterP2);
        uVar6.o();
        uVar6.c(jVar);
        uVar6.p(e, null);
        u uVar7 = new u();
        uVar7.c(pVar);
        uVar7.a(dateTimeFormatterP);
        uVar7.d('T');
        uVar7.a(dateTimeFormatterP2);
        DateTimeFormatter dateTimeFormatterP3 = uVar7.p(e, tVar);
        u uVar8 = new u();
        uVar8.c(pVar);
        uVar8.a(dateTimeFormatterP3);
        p pVar2 = p.LENIENT;
        uVar8.c(pVar2);
        uVar8.c(jVar);
        p pVar3 = p.STRICT;
        uVar8.c(pVar3);
        DateTimeFormatter dateTimeFormatterP4 = uVar8.p(e, tVar);
        u uVar9 = new u();
        uVar9.a(dateTimeFormatterP4);
        uVar9.o();
        uVar9.d('[');
        p pVar4 = p.SENSITIVE;
        uVar9.c(pVar4);
        j$.time.g gVar = u.h;
        uVar9.c(new s(gVar, "ZoneRegionId()"));
        uVar9.d(']');
        uVar9.p(e, tVar);
        u uVar10 = new u();
        uVar10.a(dateTimeFormatterP3);
        uVar10.o();
        uVar10.c(jVar);
        uVar10.o();
        uVar10.d('[');
        uVar10.c(pVar4);
        uVar10.c(new s(gVar, "ZoneRegionId()"));
        uVar10.d(']');
        ISO_DATE_TIME = uVar10.p(e, tVar);
        u uVar11 = new u();
        uVar11.c(pVar);
        uVar11.m(aVar, 4, 10, f);
        uVar11.d('-');
        uVar11.l(j$.time.temporal.a.DAY_OF_YEAR, 3);
        uVar11.o();
        uVar11.c(jVar);
        uVar11.p(e, tVar);
        u uVar12 = new u();
        uVar12.c(pVar);
        uVar12.m(j$.time.temporal.j.c, 4, 10, f);
        uVar12.e("-W");
        uVar12.l(j$.time.temporal.j.b, 2);
        uVar12.d('-');
        j$.time.temporal.a aVar7 = j$.time.temporal.a.DAY_OF_WEEK;
        uVar12.l(aVar7, 1);
        uVar12.o();
        uVar12.c(jVar);
        uVar12.p(e, tVar);
        u uVar13 = new u();
        uVar13.c(pVar);
        uVar13.c(new C1184g());
        ISO_INSTANT = uVar13.p(e, null);
        u uVar14 = new u();
        uVar14.c(pVar);
        uVar14.l(aVar, 4);
        uVar14.l(aVar2, 2);
        uVar14.l(aVar3, 2);
        uVar14.o();
        uVar14.c(pVar2);
        uVar14.g("+HHMMss", "Z");
        uVar14.c(pVar3);
        uVar14.p(e, tVar);
        HashMap map = new HashMap();
        map.put(1L, "Mon");
        map.put(2L, "Tue");
        map.put(3L, "Wed");
        map.put(4L, "Thu");
        map.put(5L, "Fri");
        map.put(6L, "Sat");
        map.put(7L, "Sun");
        HashMap map2 = new HashMap();
        map2.put(1L, "Jan");
        map2.put(2L, "Feb");
        map2.put(3L, "Mar");
        map2.put(4L, "Apr");
        map2.put(5L, "May");
        map2.put(6L, "Jun");
        map2.put(7L, "Jul");
        map2.put(8L, "Aug");
        map2.put(9L, "Sep");
        map2.put(10L, "Oct");
        map2.put(11L, "Nov");
        map2.put(12L, "Dec");
        u uVar15 = new u();
        uVar15.c(pVar);
        uVar15.c(pVar2);
        uVar15.o();
        uVar15.h(aVar7, map);
        uVar15.e(", ");
        uVar15.n();
        uVar15.m(aVar3, 1, 2, F.NOT_NEGATIVE);
        uVar15.d(' ');
        uVar15.h(aVar2, map2);
        uVar15.d(' ');
        uVar15.l(aVar, 4);
        uVar15.d(' ');
        uVar15.l(aVar4, 2);
        uVar15.d(':');
        uVar15.l(aVar5, 2);
        uVar15.o();
        uVar15.d(':');
        uVar15.l(aVar6, 2);
        uVar15.n();
        uVar15.d(' ');
        uVar15.g("+HHMM", "GMT");
        uVar15.p(E.SMART, tVar);
    }

    public DateTimeFormatter(C1181d c1181d, Locale locale, E e, j$.time.chrono.m mVar) {
        C c = C.a;
        this.a = c1181d;
        Objects.requireNonNull(locale, "locale");
        this.b = locale;
        this.c = c;
        Objects.requireNonNull(e, "resolverStyle");
        this.d = e;
        this.e = mVar;
    }

    public String format(TemporalAccessor temporalAccessor) {
        StringBuilder sb = new StringBuilder(32);
        C1181d c1181d = this.a;
        Objects.requireNonNull(temporalAccessor, "temporal");
        try {
            c1181d.s(new y(temporalAccessor, this), sb);
            return sb.toString();
        } catch (IOException e) {
            throw new j$.time.c(e.getMessage(), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x028b  */
    /* JADX WARN: Code duplicated, block: B:132:0x0322  */
    /* JADX WARN: Code duplicated, block: B:134:0x032e  */
    /* JADX WARN: Code duplicated, block: B:135:0x035b  */
    /* JADX WARN: Code duplicated, block: B:169:0x029b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x02a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x0285 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x0285 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x0267  */
    public final D a(CharSequence charSequence) {
        String string;
        long j;
        j$.time.temporal.q qVar;
        j$.time.temporal.a aVar;
        Map map;
        j$.time.temporal.a aVar2;
        j$.time.temporal.q qVar2;
        int i = 0;
        ParsePosition parsePosition = new ParsePosition(0);
        v vVar = new v(this);
        int iB = this.a.B(vVar, charSequence, parsePosition.getIndex());
        ZoneId zoneId = null;
        if (iB < 0) {
            parsePosition.setErrorIndex(~iB);
            vVar = null;
        } else {
            parsePosition.setIndex(iB);
        }
        if (vVar != null) {
            DateTimeFormatter dateTimeFormatter = vVar.a;
            if (parsePosition.getErrorIndex() < 0 && parsePosition.getIndex() >= charSequence.length()) {
                D dC = vVar.c();
                j$.time.chrono.m mVar = vVar.c().c;
                if (mVar == null && (mVar = dateTimeFormatter.e) == null) {
                    mVar = j$.time.chrono.t.c;
                }
                dC.c = mVar;
                ZoneId zoneId2 = dC.b;
                if (zoneId2 != null) {
                    zoneId = zoneId2;
                } else {
                    dateTimeFormatter.getClass();
                }
                dC.b = zoneId;
                dC.e = this.d;
                dC.q();
                dC.z(dC.c.T(dC.a, dC.e));
                dC.u();
                if (((HashMap) dC.a).size() > 0) {
                    loop0: while (i < 50) {
                        Iterator it = ((HashMap) dC.a).entrySet().iterator();
                        do {
                            if (!it.hasNext()) {
                                break loop0;
                            }
                            qVar2 = (j$.time.temporal.q) ((Map.Entry) it.next()).getKey();
                            TemporalAccessor temporalAccessorG = qVar2.G(dC.a, dC, dC.e);
                            if (temporalAccessorG != null) {
                                if (temporalAccessorG instanceof InterfaceC1176j) {
                                    InterfaceC1176j interfaceC1176j = (InterfaceC1176j) temporalAccessorG;
                                    ZoneId zoneId3 = dC.b;
                                    if (zoneId3 == null) {
                                        dC.b = interfaceC1176j.K();
                                    } else if (!zoneId3.equals(interfaceC1176j.K())) {
                                        throw new j$.time.c("ChronoZonedDateTime must use the effective parsed zone: " + dC.b);
                                    }
                                    temporalAccessorG = interfaceC1176j.x();
                                }
                                if (temporalAccessorG instanceof InterfaceC1171e) {
                                    InterfaceC1171e interfaceC1171e = (InterfaceC1171e) temporalAccessorG;
                                    dC.v(interfaceC1171e.h(), j$.time.r.d);
                                    dC.z(interfaceC1171e.n());
                                    break;
                                }
                                if (temporalAccessorG instanceof InterfaceC1168b) {
                                    dC.z((InterfaceC1168b) temporalAccessorG);
                                    break;
                                }
                                if (temporalAccessorG instanceof j$.time.k) {
                                    dC.v((j$.time.k) temporalAccessorG, j$.time.r.d);
                                    break;
                                }
                                throw new j$.time.c("Method resolve() can only return ChronoZonedDateTime, ChronoLocalDateTime, ChronoLocalDate or LocalTime");
                            }
                        } while (((HashMap) dC.a).containsKey(qVar2));
                        i++;
                    }
                    if (i == 50) {
                        throw new j$.time.c("One of the parsed fields has an incorrectly implemented resolve method");
                    }
                    if (i > 0) {
                        dC.q();
                        dC.z(dC.c.T(dC.a, dC.e));
                        dC.u();
                    }
                }
                if (dC.g == null) {
                    Map map2 = dC.a;
                    j$.time.temporal.a aVar3 = j$.time.temporal.a.MILLI_OF_SECOND;
                    if (((HashMap) map2).containsKey(aVar3)) {
                        long jLongValue = ((Long) ((HashMap) dC.a).remove(aVar3)).longValue();
                        Map map3 = dC.a;
                        j$.time.temporal.a aVar4 = j$.time.temporal.a.MICRO_OF_SECOND;
                        if (((HashMap) map3).containsKey(aVar4)) {
                            long jLongValue2 = (((Long) ((HashMap) dC.a).get(aVar4)).longValue() % 1000) + (jLongValue * 1000);
                            dC.A(aVar3, aVar4, Long.valueOf(jLongValue2));
                            ((HashMap) dC.a).remove(aVar4);
                            ((HashMap) dC.a).put(j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(jLongValue2 * 1000));
                        } else {
                            ((HashMap) dC.a).put(j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(jLongValue * 1000000));
                        }
                    } else {
                        Map map4 = dC.a;
                        j$.time.temporal.a aVar5 = j$.time.temporal.a.MICRO_OF_SECOND;
                        if (((HashMap) map4).containsKey(aVar5)) {
                            ((HashMap) dC.a).put(j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(((Long) ((HashMap) dC.a).remove(aVar5)).longValue() * 1000));
                        }
                    }
                    Map map5 = dC.a;
                    j$.time.temporal.a aVar6 = j$.time.temporal.a.HOUR_OF_DAY;
                    Long l = (Long) ((HashMap) map5).get(aVar6);
                    if (l != null) {
                        Map map6 = dC.a;
                        j$.time.temporal.a aVar7 = j$.time.temporal.a.MINUTE_OF_HOUR;
                        Long l2 = (Long) ((HashMap) map6).get(aVar7);
                        Map map7 = dC.a;
                        j$.time.temporal.a aVar8 = j$.time.temporal.a.SECOND_OF_MINUTE;
                        Long l3 = (Long) ((HashMap) map7).get(aVar8);
                        Map map8 = dC.a;
                        j$.time.temporal.a aVar9 = j$.time.temporal.a.NANO_OF_SECOND;
                        Long l4 = (Long) ((HashMap) map8).get(aVar9);
                        if ((l2 != null || (l3 == null && l4 == null)) && (l2 == null || l3 != null || l4 == null)) {
                            long jLongValue3 = l2 != null ? l2.longValue() : 0L;
                            long jLongValue4 = l3 != null ? l3.longValue() : 0L;
                            long jLongValue5 = l4 != null ? l4.longValue() : 0L;
                            long j2 = jLongValue4;
                            j = 1000000;
                            dC.s(l.longValue(), jLongValue3, j2, jLongValue5);
                            ((HashMap) dC.a).remove(aVar6);
                            ((HashMap) dC.a).remove(aVar7);
                            ((HashMap) dC.a).remove(aVar8);
                            ((HashMap) dC.a).remove(aVar9);
                        } else {
                            j = 1000000;
                        }
                    } else {
                        j = 1000000;
                    }
                    if (dC.e != E.LENIENT && ((HashMap) dC.a).size() > 0) {
                        for (Map.Entry entry : ((HashMap) dC.a).entrySet()) {
                            qVar = (j$.time.temporal.q) entry.getKey();
                            if (qVar instanceof j$.time.temporal.a) {
                                aVar = (j$.time.temporal.a) qVar;
                                if (aVar.b0()) {
                                    aVar.a0(((Long) entry.getValue()).longValue());
                                }
                            }
                        }
                    }
                } else {
                    j = 1000000;
                    if (dC.e != E.LENIENT) {
                        while (r1.hasNext()) {
                            qVar = (j$.time.temporal.q) entry.getKey();
                            if (qVar instanceof j$.time.temporal.a) {
                                aVar = (j$.time.temporal.a) qVar;
                                if (aVar.b0()) {
                                    aVar.a0(((Long) entry.getValue()).longValue());
                                }
                            }
                        }
                    }
                }
                InterfaceC1168b interfaceC1168b = dC.f;
                if (interfaceC1168b != null) {
                    dC.p(interfaceC1168b);
                }
                j$.time.k kVar = dC.g;
                if (kVar != null) {
                    dC.p(kVar);
                    if (dC.f != null && ((HashMap) dC.a).size() > 0) {
                        dC.p(dC.f.M(dC.g));
                    }
                }
                if (dC.f != null && dC.g != null) {
                    j$.time.r rVar = dC.h;
                    rVar.getClass();
                    j$.time.r rVar2 = j$.time.r.d;
                    if (rVar != rVar2) {
                        dC.f = dC.f.S(dC.h);
                        dC.h = rVar2;
                    }
                }
                if (dC.g == null) {
                    if (((HashMap) dC.a).containsKey(j$.time.temporal.a.INSTANT_SECONDS)) {
                        map = dC.a;
                        aVar2 = j$.time.temporal.a.NANO_OF_SECOND;
                        if (((HashMap) map).containsKey(aVar2)) {
                            long jLongValue6 = ((Long) ((HashMap) dC.a).get(aVar2)).longValue();
                            ((HashMap) dC.a).put(j$.time.temporal.a.MICRO_OF_SECOND, Long.valueOf(jLongValue6 / 1000));
                            ((HashMap) dC.a).put(j$.time.temporal.a.MILLI_OF_SECOND, Long.valueOf(jLongValue6 / j));
                        } else {
                            ((HashMap) dC.a).put(aVar2, 0L);
                            ((HashMap) dC.a).put(j$.time.temporal.a.MICRO_OF_SECOND, 0L);
                            ((HashMap) dC.a).put(j$.time.temporal.a.MILLI_OF_SECOND, 0L);
                        }
                    } else if (((HashMap) dC.a).containsKey(j$.time.temporal.a.SECOND_OF_DAY)) {
                        map = dC.a;
                        aVar2 = j$.time.temporal.a.NANO_OF_SECOND;
                        if (((HashMap) map).containsKey(aVar2)) {
                            long jLongValue7 = ((Long) ((HashMap) dC.a).get(aVar2)).longValue();
                            ((HashMap) dC.a).put(j$.time.temporal.a.MICRO_OF_SECOND, Long.valueOf(jLongValue7 / 1000));
                            ((HashMap) dC.a).put(j$.time.temporal.a.MILLI_OF_SECOND, Long.valueOf(jLongValue7 / j));
                        } else {
                            ((HashMap) dC.a).put(aVar2, 0L);
                            ((HashMap) dC.a).put(j$.time.temporal.a.MICRO_OF_SECOND, 0L);
                            ((HashMap) dC.a).put(j$.time.temporal.a.MILLI_OF_SECOND, 0L);
                        }
                    } else if (((HashMap) dC.a).containsKey(j$.time.temporal.a.SECOND_OF_MINUTE)) {
                        map = dC.a;
                        aVar2 = j$.time.temporal.a.NANO_OF_SECOND;
                        if (((HashMap) map).containsKey(aVar2)) {
                            long jLongValue8 = ((Long) ((HashMap) dC.a).get(aVar2)).longValue();
                            ((HashMap) dC.a).put(j$.time.temporal.a.MICRO_OF_SECOND, Long.valueOf(jLongValue8 / 1000));
                            ((HashMap) dC.a).put(j$.time.temporal.a.MILLI_OF_SECOND, Long.valueOf(jLongValue8 / j));
                        } else {
                            ((HashMap) dC.a).put(aVar2, 0L);
                            ((HashMap) dC.a).put(j$.time.temporal.a.MICRO_OF_SECOND, 0L);
                            ((HashMap) dC.a).put(j$.time.temporal.a.MILLI_OF_SECOND, 0L);
                        }
                    }
                }
                if (dC.f != null && dC.g != null) {
                    Long l5 = (Long) ((HashMap) dC.a).get(j$.time.temporal.a.OFFSET_SECONDS);
                    if (l5 != null) {
                        ((HashMap) dC.a).put(j$.time.temporal.a.INSTANT_SECONDS, Long.valueOf(dC.f.M(dC.g).F(ZoneOffset.b0(l5.intValue())).Z()));
                        return dC;
                    }
                    if (dC.b != null) {
                        ((HashMap) dC.a).put(j$.time.temporal.a.INSTANT_SECONDS, Long.valueOf(dC.f.M(dC.g).F(dC.b).Z()));
                    }
                }
                return dC;
            }
        }
        if (charSequence.length() > 64) {
            string = charSequence.subSequence(0, 64).toString() + "...";
        } else {
            string = charSequence.toString();
        }
        if (parsePosition.getErrorIndex() >= 0) {
            String str = "Text '" + string + "' could not be parsed at index " + parsePosition.getErrorIndex();
            parsePosition.getErrorIndex();
            throw new w(str, charSequence);
        }
        String str2 = "Text '" + string + "' could not be parsed, unparsed text found at index " + parsePosition.getIndex();
        parsePosition.getIndex();
        throw new w(str2, charSequence);
    }

    public final String toString() {
        String string = this.a.toString();
        return string.startsWith("[") ? string : string.substring(1, string.length() - 1);
    }
}
