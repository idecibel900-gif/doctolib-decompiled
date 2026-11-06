package net.time4j.scale;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.base.ResourceLoader;

/* JADX INFO: loaded from: classes5.dex */
public final class LeapSeconds implements Iterable, Comparator {
    private final List list;
    private final LeapSecondProvider provider;
    private final ExtendedLSE[] reverseFinal;
    private volatile ExtendedLSE[] reverseVolatile;
    private final boolean supportsNegativeLS;
    public static final boolean SUPPRESS_UTC_LEAPSECONDS = Boolean.getBoolean("net.time4j.scale.leapseconds.suppressed");
    public static final boolean FINAL_UTC_LEAPSECONDS = Boolean.getBoolean("net.time4j.scale.leapseconds.final");
    public static final String PATH_TO_LEAPSECONDS = System.getProperty("net.time4j.scale.leapseconds.path", "data/leapseconds.data");
    private static final ExtendedLSE[] EMPTY_ARRAY = new ExtendedLSE[0];
    private static final LeapSeconds INSTANCE = new LeapSeconds();

    private LeapSeconds() {
        LeapSecondProvider leapSecondProvider;
        int i;
        boolean z = false;
        if (SUPPRESS_UTC_LEAPSECONDS) {
            leapSecondProvider = null;
            i = 0;
        } else {
            leapSecondProvider = null;
            i = 0;
            for (LeapSecondProvider leapSecondProvider2 : ResourceLoader.getInstance().services(LeapSecondProvider.class)) {
                int size = leapSecondProvider2.getLeapSecondTable().size();
                if (size > i) {
                    leapSecondProvider = leapSecondProvider2;
                    i = size;
                }
            }
        }
        if (leapSecondProvider == null || i == 0) {
            this.provider = null;
            this.list = Collections.EMPTY_LIST;
            ExtendedLSE[] extendedLSEArr = EMPTY_ARRAY;
            this.reverseFinal = extendedLSEArr;
            this.reverseVolatile = extendedLSEArr;
            this.supportsNegativeLS = false;
            return;
        }
        TreeSet treeSet = new TreeSet(this);
        for (Map.Entry entry : leapSecondProvider.getLeapSecondTable().entrySet()) {
            GregorianDate gregorianDate = (GregorianDate) entry.getKey();
            treeSet.add(new SimpleLeapSecondEvent(gregorianDate, Long.MIN_VALUE, (-62985601) + toPosix(gregorianDate), ((Integer) entry.getValue()).intValue()));
        }
        extend(treeSet);
        boolean z2 = FINAL_UTC_LEAPSECONDS;
        if (z2) {
            this.list = Collections.unmodifiableList(new ArrayList(treeSet));
        } else {
            this.list = new CopyOnWriteArrayList(treeSet);
        }
        ExtendedLSE[] extendedLSEArrInitReverse = initReverse();
        this.reverseFinal = extendedLSEArrInitReverse;
        this.reverseVolatile = extendedLSEArrInitReverse;
        this.provider = leapSecondProvider;
        if (z2) {
            boolean zSupportsNegativeLS = leapSecondProvider.supportsNegativeLS();
            if (zSupportsNegativeLS) {
                Iterator it = this.list.iterator();
                while (it.hasNext()) {
                    if (((ExtendedLSE) it.next()).getShift() < 0) {
                        z = true;
                        break;
                    }
                }
                zSupportsNegativeLS = z;
            }
            this.supportsNegativeLS = zSupportsNegativeLS;
            return;
        }
        this.supportsNegativeLS = true;
    }

    public static LeapSeconds getInstance() {
        return INSTANCE;
    }

    public boolean isEnabled() {
        return !this.list.isEmpty();
    }

    public boolean supportsNegativeLS() {
        return this.supportsNegativeLS;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return Collections.unmodifiableList(Arrays.asList(getEventsInDescendingOrder())).iterator();
    }

    public int getShift(long j) {
        if (j <= 0) {
            return 0;
        }
        for (ExtendedLSE extendedLSE : getEventsInDescendingOrder()) {
            if (j > extendedLSE.utc()) {
                return 0;
            }
            long jUtc = extendedLSE.utc() - ((long) extendedLSE.getShift());
            if (j > jUtc) {
                return (int) (j - jUtc);
            }
        }
        return 0;
    }

    public LeapSecondEvent getNextEvent(long j) {
        ExtendedLSE[] eventsInDescendingOrder = getEventsInDescendingOrder();
        ExtendedLSE extendedLSE = null;
        int i = 0;
        while (i < eventsInDescendingOrder.length) {
            ExtendedLSE extendedLSE2 = eventsInDescendingOrder[i];
            if (j >= extendedLSE2.utc()) {
                break;
            }
            i++;
            extendedLSE = extendedLSE2;
        }
        return extendedLSE;
    }

    public long enhance(long j) {
        long j2 = j - 63072000;
        if (j > 0) {
            for (ExtendedLSE extendedLSE : getEventsInDescendingOrder()) {
                if (extendedLSE.raw() < j2) {
                    return MathUtils.safeAdd(j2, extendedLSE.utc() - extendedLSE.raw());
                }
            }
        }
        return j2;
    }

    public long strip(long j) {
        if (j <= 0) {
            return j + 63072000;
        }
        ExtendedLSE[] eventsInDescendingOrder = getEventsInDescendingOrder();
        boolean z = this.supportsNegativeLS;
        for (ExtendedLSE extendedLSE : eventsInDescendingOrder) {
            if (extendedLSE.utc() - ((long) extendedLSE.getShift()) < j || (z && extendedLSE.getShift() < 0 && extendedLSE.utc() < j)) {
                j = MathUtils.safeAdd(j, extendedLSE.raw() - extendedLSE.utc());
                break;
            }
        }
        return j + 63072000;
    }

    public boolean isPositiveLS(long j) {
        if (j <= 0) {
            return false;
        }
        ExtendedLSE[] eventsInDescendingOrder = getEventsInDescendingOrder();
        for (int i = 0; i < eventsInDescendingOrder.length; i++) {
            long jUtc = eventsInDescendingOrder[i].utc();
            if (jUtc == j) {
                return eventsInDescendingOrder[i].getShift() == 1;
            }
            if (jUtc < j) {
                break;
            }
        }
        return false;
    }

    public GregorianDate getDateOfExpiration() {
        if (!isEnabled()) {
            throw new IllegalStateException("Leap seconds not activated.");
        }
        return this.provider.getDateOfExpiration();
    }

    @Override // java.util.Comparator
    public int compare(LeapSecondEvent leapSecondEvent, LeapSecondEvent leapSecondEvent2) {
        GregorianDate date = leapSecondEvent.getDate();
        GregorianDate date2 = leapSecondEvent2.getDate();
        int year = date.getYear();
        int year2 = date2.getYear();
        if (year < year2) {
            return -1;
        }
        if (year > year2) {
            return 1;
        }
        int month = date.getMonth();
        int month2 = date2.getMonth();
        if (month < month2) {
            return -1;
        }
        if (month > month2) {
            return 1;
        }
        int dayOfMonth = date.getDayOfMonth();
        int dayOfMonth2 = date2.getDayOfMonth();
        if (dayOfMonth < dayOfMonth2) {
            return -1;
        }
        return dayOfMonth == dayOfMonth2 ? 0 : 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(2048);
        sb.append("[PROVIDER=");
        sb.append(this.provider);
        if (this.provider != null) {
            sb.append(",EXPIRES=");
            sb.append(format(getDateOfExpiration()));
        }
        sb.append(",EVENTS=[");
        if (isEnabled()) {
            boolean z = true;
            for (Object obj : this.list) {
                if (z) {
                    z = false;
                } else {
                    sb.append('|');
                }
                sb.append(obj);
            }
        } else {
            sb.append("NOT SUPPORTED");
        }
        sb.append("]]");
        return sb.toString();
    }

    private ExtendedLSE[] getEventsInDescendingOrder() {
        if (SUPPRESS_UTC_LEAPSECONDS || FINAL_UTC_LEAPSECONDS) {
            return this.reverseFinal;
        }
        return this.reverseVolatile;
    }

    private static void extend(SortedSet sortedSet) {
        ArrayList arrayList = new ArrayList(sortedSet.size());
        Iterator it = sortedSet.iterator();
        int shift = 0;
        while (it.hasNext()) {
            ExtendedLSE extendedLSE = (ExtendedLSE) it.next();
            if (extendedLSE.utc() == Long.MIN_VALUE) {
                shift += extendedLSE.getShift();
                arrayList.add(new SimpleLeapSecondEvent(extendedLSE, shift));
            } else {
                arrayList.add(extendedLSE);
            }
        }
        sortedSet.clear();
        sortedSet.addAll(arrayList);
    }

    private static long toPosix(GregorianDate gregorianDate) {
        return MathUtils.safeMultiply(MathUtils.safeSubtract(GregorianMath.toMJD(gregorianDate), 40587L), 86400L);
    }

    private ExtendedLSE[] initReverse() {
        ArrayList arrayList = new ArrayList(this.list.size());
        arrayList.addAll(this.list);
        Collections.reverse(arrayList);
        return (ExtendedLSE[]) arrayList.toArray(new ExtendedLSE[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String format(GregorianDate gregorianDate) {
        return String.format("%1$04d-%2$02d-%3$02d", Integer.valueOf(gregorianDate.getYear()), Integer.valueOf(gregorianDate.getMonth()), Integer.valueOf(gregorianDate.getDayOfMonth()));
    }

    private static class SimpleLeapSecondEvent implements ExtendedLSE, Serializable {
        private static final long serialVersionUID = 5986185471610524587L;
        private final long _raw;
        private final long _utc;
        private final GregorianDate date;
        private final int shift;

        SimpleLeapSecondEvent(GregorianDate gregorianDate, long j, long j2, int i) {
            this.date = gregorianDate;
            this.shift = i;
            this._utc = j;
            this._raw = j2;
        }

        SimpleLeapSecondEvent(ExtendedLSE extendedLSE, int i) {
            this.date = extendedLSE.getDate();
            this.shift = extendedLSE.getShift();
            this._utc = extendedLSE.raw() + ((long) i);
            this._raw = extendedLSE.raw();
        }

        @Override // net.time4j.scale.LeapSecondEvent
        public GregorianDate getDate() {
            return this.date;
        }

        @Override // net.time4j.scale.LeapSecondEvent
        public int getShift() {
            return this.shift;
        }

        @Override // net.time4j.scale.ExtendedLSE
        public long utc() {
            return this._utc;
        }

        @Override // net.time4j.scale.ExtendedLSE
        public long raw() {
            return this._raw;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append(LeapSecondEvent.class.getName());
            sb.append('[');
            sb.append(LeapSeconds.format(this.date));
            sb.append(": utc=");
            sb.append(this._utc);
            sb.append(", raw=");
            sb.append(this._raw);
            sb.append(" (shift=");
            sb.append(this.shift);
            sb.append(")]");
            return sb.toString();
        }
    }
}
