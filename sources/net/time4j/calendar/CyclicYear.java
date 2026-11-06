package net.time4j.calendar;

import java.io.ObjectStreamException;
import java.text.ParsePosition;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class CyclicYear extends SexagesimalName {
    private static final CyclicYear[] INSTANCES;
    private static final long serialVersionUID = 4908662352833192131L;

    static {
        CyclicYear[] cyclicYearArr = new CyclicYear[60];
        int i = 0;
        while (i < 60) {
            int i2 = i + 1;
            cyclicYearArr[i] = new CyclicYear(i2);
            i = i2;
        }
        INSTANCES = cyclicYearArr;
    }

    private CyclicYear(int i) {
        super(i);
    }

    public static CyclicYear of(int i) {
        if (i < 1 || i > 60) {
            throw new IllegalArgumentException("Out of range: " + i);
        }
        return INSTANCES[i - 1];
    }

    public EastAsianYear inCycle(final int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Cycle number must not be smaller than 1: " + i);
        }
        return new EastAsianYear() { // from class: net.time4j.calendar.CyclicYear.2
            @Override // net.time4j.calendar.EastAsianYear
            public int getElapsedCyclicYears() {
                return (((i - 1) * 60) + CyclicYear.this.getNumber()) - 1;
            }
        };
    }

    static CyclicYear parse(CharSequence charSequence, ParsePosition parsePosition, Locale locale, boolean z) {
        SexagesimalName sexagesimalName = SexagesimalName.parse(charSequence, parsePosition, locale, z);
        if (sexagesimalName == null) {
            return null;
        }
        return of(sexagesimalName.getNumber());
    }

    @Override // net.time4j.calendar.SexagesimalName
    Object readResolve() throws ObjectStreamException {
        return of(super.getNumber());
    }
}
