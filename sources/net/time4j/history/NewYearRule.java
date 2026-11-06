package net.time4j.history;

/* JADX INFO: loaded from: classes5.dex */
public enum NewYearRule {
    BEGIN_OF_JANUARY { // from class: net.time4j.history.NewYearRule.1
        @Override // net.time4j.history.NewYearRule
        HistoricDate newYear(HistoricEra historicEra, int i) {
            return HistoricDate.of(historicEra, i, 1, 1);
        }

        @Override // net.time4j.history.NewYearRule
        int displayedYear(NewYearStrategy newYearStrategy, HistoricDate historicDate) {
            return historicDate.getYearOfEra();
        }
    },
    BEGIN_OF_MARCH { // from class: net.time4j.history.NewYearRule.2
        @Override // net.time4j.history.NewYearRule
        HistoricDate newYear(HistoricEra historicEra, int i) {
            return HistoricDate.of(historicEra, i, 3, 1);
        }
    },
    BEGIN_OF_SEPTEMBER { // from class: net.time4j.history.NewYearRule.3
        @Override // net.time4j.history.NewYearRule
        HistoricDate newYear(HistoricEra historicEra, int i) {
            return HistoricDate.of(historicEra, i - 1, 9, 1);
        }

        @Override // net.time4j.history.NewYearRule
        int displayedYear(NewYearStrategy newYearStrategy, HistoricDate historicDate) {
            HistoricEra era = historicDate.getEra();
            int yearOfEra = historicDate.getYearOfEra();
            int i = yearOfEra + 1;
            return historicDate.compareTo(newYearStrategy.newYear(era, i)) >= 0 ? i : yearOfEra;
        }
    },
    CHRISTMAS_STYLE { // from class: net.time4j.history.NewYearRule.4
        @Override // net.time4j.history.NewYearRule
        HistoricDate newYear(HistoricEra historicEra, int i) {
            return HistoricDate.of(historicEra, i - 1, 12, 25);
        }

        @Override // net.time4j.history.NewYearRule
        int displayedYear(NewYearStrategy newYearStrategy, HistoricDate historicDate) {
            int yearOfEra = historicDate.getYearOfEra();
            int i = yearOfEra + 1;
            return historicDate.compareTo(newYearStrategy.newYear(historicDate.getEra(), i)) >= 0 ? i : yearOfEra;
        }
    },
    EASTER_STYLE { // from class: net.time4j.history.NewYearRule.5
        @Override // net.time4j.history.NewYearRule
        HistoricDate newYear(HistoricEra historicEra, int i) {
            int i2;
            int iMarchDay = Computus.EASTERN.marchDay(historicEra.annoDomini(i));
            int i3 = iMarchDay - 1;
            if (i3 > 31) {
                i3 = iMarchDay - 32;
                i2 = 4;
            } else {
                i2 = 3;
            }
            return HistoricDate.of(historicEra, i, i2, i3);
        }
    },
    GOOD_FRIDAY { // from class: net.time4j.history.NewYearRule.6
        @Override // net.time4j.history.NewYearRule
        HistoricDate newYear(HistoricEra historicEra, int i) {
            int i2;
            int iMarchDay = Computus.EASTERN.marchDay(historicEra.annoDomini(i));
            int i3 = iMarchDay - 2;
            if (i3 > 31) {
                i3 = iMarchDay - 33;
                i2 = 4;
            } else {
                i2 = 3;
            }
            return HistoricDate.of(historicEra, i, i2, i3);
        }
    },
    MARIA_ANUNCIATA { // from class: net.time4j.history.NewYearRule.7
        @Override // net.time4j.history.NewYearRule
        HistoricDate newYear(HistoricEra historicEra, int i) {
            return HistoricDate.of(historicEra, i, 3, 25);
        }
    },
    CALCULUS_PISANUS { // from class: net.time4j.history.NewYearRule.8
        @Override // net.time4j.history.NewYearRule
        HistoricDate newYear(HistoricEra historicEra, int i) {
            return NewYearRule.MARIA_ANUNCIATA.newYear(historicEra, i + 1);
        }

        @Override // net.time4j.history.NewYearRule
        int displayedYear(NewYearStrategy newYearStrategy, HistoricDate historicDate) {
            int yearOfEra = historicDate.getYearOfEra();
            int i = yearOfEra - 1;
            return historicDate.compareTo(newYear(historicDate.getEra(), i)) < 0 ? yearOfEra - 2 : i;
        }

        @Override // net.time4j.history.NewYearRule
        int standardYear(boolean z, NewYearStrategy newYearStrategy, HistoricEra historicEra, int i, int i2, int i3) {
            return NewYearRule.MARIA_ANUNCIATA.standardYear(z, newYearStrategy, historicEra, i + 1, i2, i3);
        }
    },
    EPIPHANY { // from class: net.time4j.history.NewYearRule.9
        @Override // net.time4j.history.NewYearRule
        HistoricDate newYear(HistoricEra historicEra, int i) {
            return HistoricDate.of(historicEra, i, 1, 6);
        }
    };

    abstract HistoricDate newYear(HistoricEra historicEra, int i);

    public NewYearStrategy until(int i) {
        if (i <= 567) {
            throw new IllegalArgumentException("Defining New-Year-strategy is not supported before Council of Tours in AD 567.");
        }
        NewYearStrategy newYearStrategy = new NewYearStrategy(this, i);
        NewYearRule newYearRule = BEGIN_OF_JANUARY;
        return this != newYearRule ? new NewYearStrategy(newYearRule, 567).and(newYearStrategy) : newYearStrategy;
    }

    int displayedYear(NewYearStrategy newYearStrategy, HistoricDate historicDate) {
        int yearOfEra = historicDate.getYearOfEra();
        return historicDate.compareTo(newYear(historicDate.getEra(), yearOfEra)) < 0 ? yearOfEra - 1 : yearOfEra;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002d A[PHI: r1 r9
      0x002d: PHI (r1v2 int) = (r1v1 int), (r1v0 int) binds: [B:22:0x0042, B:14:0x002a] A[DONT_GENERATE, DONT_INLINE]
      0x002d: PHI (r9v5 int) = (r9v2 int), (r9v8 int) binds: [B:22:0x0042, B:14:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    int standardYear(boolean z, NewYearStrategy newYearStrategy, HistoricEra historicEra, int i, int i2, int i3) {
        int i4;
        if (i2 >= 5 && i2 <= 8) {
            return i;
        }
        HistoricDate historicDateNewYear = newYear(historicEra, i);
        int i5 = i + 1;
        HistoricDate historicDateNewYear2 = newYearStrategy.newYear(historicEra, i5);
        HistoricDate historicDateOf = HistoricDate.of(historicEra, i, i2, i3);
        if (i2 <= 4) {
            HistoricDate historicDateOf2 = HistoricDate.of(historicEra, i5, i2, i3);
            i4 = historicDateOf.compareTo(historicDateNewYear) >= 0 ? i : i5;
            if (historicDateOf2.compareTo(historicDateNewYear2) < 0) {
                i = i5;
            }
        } else {
            i5 = i - 1;
            i4 = HistoricDate.of(historicEra, i5, i2, i3).compareTo(historicDateNewYear) >= 0 ? i5 : i;
            if (historicDateOf.compareTo(historicDateNewYear2) >= 0) {
                i = i5;
            }
        }
        if (i4 <= i) {
            return z ? i4 : i;
        }
        throw new IllegalArgumentException("Invalid date due to changing new year rule (year too short to cover month and day-of-month): " + historicDateOf);
    }
}
