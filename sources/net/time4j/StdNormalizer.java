package net.time4j;

import java.util.Comparator;
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.Normalizer;
import net.time4j.engine.TimeSpan;

/* JADX INFO: loaded from: classes5.dex */
class StdNormalizer implements Normalizer, Comparator {
    private final boolean mixed;

    private StdNormalizer(boolean z) {
        this.mixed = z;
    }

    static StdNormalizer ofMixedUnits() {
        return new StdNormalizer(true);
    }

    static StdNormalizer ofCalendarUnits() {
        return new StdNormalizer(false);
    }

    static StdNormalizer ofClockUnits() {
        return new StdNormalizer(false);
    }

    static Comparator comparator() {
        return new StdNormalizer(false);
    }

    @Override // java.util.Comparator
    public int compare(TimeSpan.Item item, TimeSpan.Item item2) {
        return compare((ChronoUnit) item.getUnit(), (ChronoUnit) item2.getUnit());
    }

    static int compare(ChronoUnit chronoUnit, ChronoUnit chronoUnit2) {
        int iCompare = Double.compare(chronoUnit2.getLength(), chronoUnit.getLength());
        if (iCompare != 0 || chronoUnit.equals(chronoUnit2)) {
            return iCompare;
        }
        throw new IllegalArgumentException("Mixing different units of same length not allowed.");
    }
}
