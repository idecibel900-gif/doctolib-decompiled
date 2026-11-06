package net.time4j.tz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.base.WallTime;
import net.time4j.engine.EpochDays;
import net.time4j.tz.TransitionHistory;
import net.time4j.tz.ZonalOffset;
import net.time4j.tz.ZonalTransition;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TransitionModel implements TransitionHistory, Serializable {
    static final String NEW_LINE = System.getProperty("line.separator");

    @Override // net.time4j.tz.TransitionHistory
    public boolean isEmpty() {
        return false;
    }

    TransitionModel() {
    }

    static TransitionHistory of(ZonalOffset zonalOffset, List list, List list2, boolean z, boolean z2) {
        List list3;
        List list4;
        if (z) {
            ArrayList arrayList = new ArrayList(list);
            ArrayList arrayList2 = new ArrayList(list2);
            Collections.sort(arrayList);
            Collections.sort(arrayList2, RuleComparator.INSTANCE);
            list4 = arrayList2;
            list3 = arrayList;
        } else {
            list3 = list;
            list4 = list2;
        }
        int size = list3.size();
        if (size == 0) {
            if (list4.isEmpty()) {
                return new EmptyTransitionModel(zonalOffset);
            }
            return new RuleBasedTransitionModel(zonalOffset, list4, false);
        }
        ZonalOffset zonalOffsetOfTotalSeconds = ZonalOffset.ofTotalSeconds(((ZonalTransition) list3.get(0)).getPreviousOffset());
        if (z2 && !zonalOffset.equals(zonalOffsetOfTotalSeconds)) {
            throw new IllegalArgumentException("Initial offset " + zonalOffset + " not equal to previous offset of first transition: " + zonalOffsetOfTotalSeconds);
        }
        if (list4.isEmpty()) {
            return new ArrayTransitionModel(list3, false, z2);
        }
        ZonalTransition zonalTransition = (ZonalTransition) list3.get(size - 1);
        long posixTime = zonalTransition.getPosixTime() + 1;
        long futureMoment = getFutureMoment(1);
        if (posixTime < futureMoment) {
            List list5 = list4;
            list4 = list5;
            list3.addAll(RuleBasedTransitionModel.getTransitions(zonalTransition, list5, posixTime, futureMoment));
        }
        return new CompositeTransitionModel(size, list3, list4, false, z2);
    }

    static List toList(int i) {
        return Collections.singletonList(ZonalOffset.ofTotalSeconds(i));
    }

    static List toList(int i, int i2) {
        ZonalOffset zonalOffsetOfTotalSeconds = ZonalOffset.ofTotalSeconds(i);
        ZonalOffset zonalOffsetOfTotalSeconds2 = ZonalOffset.ofTotalSeconds(i2);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(zonalOffsetOfTotalSeconds);
        arrayList.add(zonalOffsetOfTotalSeconds2);
        return Collections.unmodifiableList(arrayList);
    }

    static long toLocalSecs(GregorianDate gregorianDate, WallTime wallTime) {
        return MathUtils.safeMultiply(EpochDays.UNIX.transform(GregorianMath.toMJD(gregorianDate.getYear(), gregorianDate.getMonth(), gregorianDate.getDayOfMonth()), EpochDays.MODIFIED_JULIAN_DATE), 86400L) + ((long) (wallTime.getHour() * 3600)) + ((long) (wallTime.getMinute() * 60)) + ((long) wallTime.getSecond());
    }

    static long getFutureMoment(int i) {
        return (System.currentTimeMillis() / 1000) + ((long) (((double) i) * 3.1556952E7d));
    }
}
