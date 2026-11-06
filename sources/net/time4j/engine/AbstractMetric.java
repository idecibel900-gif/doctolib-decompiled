package net.time4j.engine;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractMetric implements TimeMetric, Comparator {
    private final boolean normalizing;
    private final List sortedUnits;

    protected AbstractMetric(boolean z, ChronoUnit... chronoUnitArr) {
        this(Arrays.asList(chronoUnitArr), z);
    }

    private AbstractMetric(List list, boolean z) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Missing units.");
        }
        Collections.sort(list, this);
        int size = list.size();
        int i = 0;
        while (i < size) {
            ChronoUnit chronoUnit = (ChronoUnit) list.get(i);
            i++;
            for (int i2 = i; i2 < size; i2++) {
                if (chronoUnit.equals(list.get(i2))) {
                    throw new IllegalArgumentException("Duplicate unit: " + chronoUnit);
                }
            }
        }
        this.sortedUnits = Collections.unmodifiableList(list);
        this.normalizing = z;
    }

    @Override // java.util.Comparator
    public int compare(ChronoUnit chronoUnit, ChronoUnit chronoUnit2) {
        return Double.compare(chronoUnit2.getLength(), chronoUnit.getLength());
    }
}
