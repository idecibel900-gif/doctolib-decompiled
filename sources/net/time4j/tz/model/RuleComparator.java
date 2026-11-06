package net.time4j.tz.model;

import java.util.Comparator;
import net.time4j.engine.Calendrical;

/* JADX INFO: loaded from: classes5.dex */
enum RuleComparator implements Comparator {
    INSTANCE;

    @Override // java.util.Comparator
    public int compare(DaylightSavingRule daylightSavingRule, DaylightSavingRule daylightSavingRule2) {
        int iCompareTo = daylightSavingRule.getDate(2000).compareTo((Calendrical) daylightSavingRule2.getDate(2000));
        return iCompareTo == 0 ? daylightSavingRule.getTimeOfDay().compareTo(daylightSavingRule2.getTimeOfDay()) : iCompareTo;
    }
}
