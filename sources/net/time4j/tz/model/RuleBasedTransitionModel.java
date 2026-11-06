package net.time4j.tz.model;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import io.didomi.ssl.config.app.SyncConfiguration;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.Moment;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;
import net.time4j.engine.EpochDays;
import net.time4j.tz.ZonalOffset;
import net.time4j.tz.ZonalTransition;

/* JADX INFO: loaded from: classes5.dex */
final class RuleBasedTransitionModel extends TransitionModel {
    private static final int LAST_CACHED_YEAR = GregorianMath.readYear(GregorianMath.toPackedDate(EpochDays.MODIFIED_JULIAN_DATE.transform(TransitionModel.getFutureMoment(100), EpochDays.UNIX)));
    private static final long serialVersionUID = 2456700806862862287L;
    private final transient boolean gregorian;
    private final transient ZonalTransition initial;
    private final transient List rules;
    private final transient List stdTransitions;
    private final transient ConcurrentMap tCache;

    RuleBasedTransitionModel(ZonalOffset zonalOffset, List list, boolean z) {
        this(new ZonalTransition(Long.MIN_VALUE, zonalOffset.getIntegralAmount(), zonalOffset.getIntegralAmount(), 0), list, z);
    }

    RuleBasedTransitionModel(ZonalTransition zonalTransition, List list, boolean z) {
        ZonalTransition zonalTransition2;
        this.tCache = new ConcurrentHashMap();
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Missing daylight saving rules.");
        }
        if (list.size() >= 128) {
            throw new IllegalArgumentException("Too many daylight saving rules: " + list);
        }
        list = z ? new ArrayList(list) : list;
        Collections.sort(list, RuleComparator.INSTANCE);
        String calendarType = null;
        if (list.size() > 1) {
            for (DaylightSavingRule daylightSavingRule : list) {
                if (calendarType == null) {
                    calendarType = daylightSavingRule.getCalendarType();
                } else if (!calendarType.equals(daylightSavingRule.getCalendarType())) {
                    throw new IllegalArgumentException("Rules with different calendar systems not permitted.");
                }
            }
        }
        this.gregorian = "iso8601".equals(calendarType);
        if (zonalTransition.getPosixTime() == Long.MIN_VALUE) {
            if (zonalTransition.getDaylightSavingOffset() != 0) {
                throw new IllegalArgumentException("Initial transition must not have any dst-offset: " + zonalTransition);
            }
            zonalTransition2 = new ZonalTransition(((Moment) Moment.axis().getMinimum()).getPosixTime(), zonalTransition.getStandardOffset(), zonalTransition.getStandardOffset(), 0);
        } else {
            if (zonalTransition.getTotalOffset() != getNextTransition(zonalTransition.getPosixTime(), zonalTransition, list).getPreviousOffset()) {
                throw new IllegalArgumentException("Inconsistent model: " + zonalTransition + " / " + list);
            }
            zonalTransition2 = zonalTransition;
        }
        this.initial = zonalTransition2;
        List listUnmodifiableList = Collections.unmodifiableList(list);
        this.rules = listUnmodifiableList;
        this.stdTransitions = getTransitions(zonalTransition2, listUnmodifiableList, 0L, TransitionModel.getFutureMoment(1));
    }

    @Override // net.time4j.tz.TransitionHistory
    public ZonalOffset getInitialOffset() {
        return ZonalOffset.ofTotalSeconds(this.initial.getTotalOffset());
    }

    @Override // net.time4j.tz.TransitionHistory
    public ZonalTransition getStartTransition(UnixTime unixTime) {
        ZonalTransition zonalTransition;
        long posixTime = this.initial.getPosixTime();
        ZonalTransition zonalTransition2 = null;
        if (unixTime.getPosixTime() <= posixTime) {
            return null;
        }
        int standardOffset = this.initial.getStandardOffset();
        int size = this.rules.size();
        DaylightSavingRule daylightSavingRule = (DaylightSavingRule) this.rules.get(0);
        int i = size - 1;
        int year = getYear(daylightSavingRule, unixTime.getPosixTime() + ((long) getShift(daylightSavingRule, standardOffset, ((DaylightSavingRule) this.rules.get(i)).getSavings())));
        List transitions = getTransitions(year);
        for (int i2 = 0; i2 < size; i2++) {
            ZonalTransition zonalTransition3 = (ZonalTransition) transitions.get(i2);
            long posixTime2 = zonalTransition3.getPosixTime();
            if (unixTime.getPosixTime() >= posixTime2) {
                if (posixTime2 > posixTime) {
                    zonalTransition2 = zonalTransition3;
                }
            } else {
                if (zonalTransition2 != null) {
                    break;
                }
                if (i2 == 0) {
                    zonalTransition = (ZonalTransition) getTransitions(year - 1).get(i);
                } else {
                    zonalTransition = (ZonalTransition) transitions.get(i2 - 1);
                }
                if (zonalTransition.getPosixTime() > posixTime) {
                    return zonalTransition;
                }
            }
        }
        return zonalTransition2;
    }

    @Override // net.time4j.tz.TransitionHistory
    public ZonalTransition getConflictTransition(GregorianDate gregorianDate, WallTime wallTime) {
        return getConflictTransition(gregorianDate, TransitionModel.toLocalSecs(gregorianDate, wallTime));
    }

    @Override // net.time4j.tz.TransitionHistory
    public List getValidOffsets(GregorianDate gregorianDate, WallTime wallTime) {
        return getValidOffsets(gregorianDate, TransitionModel.toLocalSecs(gregorianDate, wallTime));
    }

    @Override // net.time4j.tz.TransitionHistory
    public boolean hasNegativeDST() {
        Iterator it = this.rules.iterator();
        while (it.hasNext()) {
            if (((DaylightSavingRule) it.next()).getSavings() < 0) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RuleBasedTransitionModel) {
            RuleBasedTransitionModel ruleBasedTransitionModel = (RuleBasedTransitionModel) obj;
            if (this.initial.equals(ruleBasedTransitionModel.initial) && this.rules.equals(ruleBasedTransitionModel.rules)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.initial.hashCode() * 17) + (this.rules.hashCode() * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
        sb.append(RuleBasedTransitionModel.class.getName());
        sb.append("[initial=");
        sb.append(this.initial);
        sb.append(",rules=");
        sb.append(this.rules);
        sb.append(']');
        return sb.toString();
    }

    ZonalTransition getInitialTransition() {
        return this.initial;
    }

    List getRules() {
        return this.rules;
    }

    ZonalTransition getConflictTransition(GregorianDate gregorianDate, long j) {
        if (j <= this.initial.getPosixTime() + ((long) Math.max(this.initial.getPreviousOffset(), this.initial.getTotalOffset()))) {
            return null;
        }
        for (ZonalTransition zonalTransition : getTransitions(gregorianDate)) {
            long posixTime = zonalTransition.getPosixTime();
            if (zonalTransition.isGap()) {
                if (j < ((long) zonalTransition.getPreviousOffset()) + posixTime) {
                    return null;
                }
                if (j < posixTime + ((long) zonalTransition.getTotalOffset())) {
                    return zonalTransition;
                }
            } else if (!zonalTransition.isOverlap()) {
                continue;
            } else {
                if (j < ((long) zonalTransition.getTotalOffset()) + posixTime) {
                    return null;
                }
                if (j < posixTime + ((long) zonalTransition.getPreviousOffset())) {
                    return zonalTransition;
                }
            }
        }
        return null;
    }

    List getValidOffsets(GregorianDate gregorianDate, long j) {
        long posixTime = this.initial.getPosixTime();
        int totalOffset = this.initial.getTotalOffset();
        if (j <= posixTime + ((long) Math.max(this.initial.getPreviousOffset(), totalOffset))) {
            return TransitionModel.toList(totalOffset);
        }
        for (ZonalTransition zonalTransition : getTransitions(gregorianDate)) {
            long posixTime2 = zonalTransition.getPosixTime();
            int totalOffset2 = zonalTransition.getTotalOffset();
            if (zonalTransition.isGap()) {
                if (j < ((long) zonalTransition.getPreviousOffset()) + posixTime2) {
                    return TransitionModel.toList(zonalTransition.getPreviousOffset());
                }
                if (j < posixTime2 + ((long) totalOffset2)) {
                    return Collections.EMPTY_LIST;
                }
            } else if (!zonalTransition.isOverlap()) {
                continue;
            } else {
                if (j < ((long) totalOffset2) + posixTime2) {
                    return TransitionModel.toList(zonalTransition.getPreviousOffset());
                }
                if (j < posixTime2 + ((long) zonalTransition.getPreviousOffset())) {
                    return TransitionModel.toList(totalOffset2, zonalTransition.getPreviousOffset());
                }
            }
            totalOffset = totalOffset2;
        }
        return TransitionModel.toList(totalOffset);
    }

    static List getTransitions(ZonalTransition zonalTransition, List list, long j, long j2) {
        List list2 = list;
        long j3 = j;
        long posixTime = zonalTransition.getPosixTime();
        if (j3 > j2) {
            throw new IllegalArgumentException("Start after end.");
        }
        if (j2 <= posixTime || j3 == j2) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int size = list2.size();
        int standardOffset = zonalTransition.getStandardOffset();
        int year = LinearLayoutManager.INVALID_OFFSET;
        int i = 0;
        while (true) {
            int i2 = i % size;
            DaylightSavingRule daylightSavingRule = (DaylightSavingRule) list2.get(i2);
            DaylightSavingRule daylightSavingRule2 = (DaylightSavingRule) list2.get(((i - 1) + size) % size);
            int shift = getShift(daylightSavingRule, standardOffset, daylightSavingRule2.getSavings());
            if (i == 0) {
                year = getYear(daylightSavingRule, Math.max(j3, posixTime) + ((long) shift));
            } else if (i2 == 0) {
                year++;
            }
            long transitionTime = getTransitionTime(daylightSavingRule, year, shift);
            i++;
            if (transitionTime >= j2) {
                return Collections.unmodifiableList(arrayList);
            }
            if (transitionTime >= j && transitionTime > posixTime) {
                arrayList.add(new ZonalTransition(transitionTime, standardOffset + daylightSavingRule2.getSavings(), standardOffset + daylightSavingRule.getSavings(), daylightSavingRule.getSavings()));
            }
            list2 = list;
            j3 = j;
        }
    }

    private static ZonalTransition getNextTransition(long j, ZonalTransition zonalTransition, List list) {
        long jMax = Math.max(j, zonalTransition.getPosixTime());
        int standardOffset = zonalTransition.getStandardOffset();
        int size = list.size();
        int year = LinearLayoutManager.INVALID_OFFSET;
        ZonalTransition zonalTransition2 = null;
        int i = 0;
        while (zonalTransition2 == null) {
            int i2 = i % size;
            DaylightSavingRule daylightSavingRule = (DaylightSavingRule) list.get(i2);
            DaylightSavingRule daylightSavingRule2 = (DaylightSavingRule) list.get(((i - 1) + size) % size);
            int shift = getShift(daylightSavingRule, standardOffset, daylightSavingRule2.getSavings());
            if (i == 0) {
                year = getYear(daylightSavingRule, ((long) shift) + jMax);
            } else if (i2 == 0) {
                year++;
            }
            long transitionTime = getTransitionTime(daylightSavingRule, year, shift);
            if (transitionTime > jMax) {
                zonalTransition2 = new ZonalTransition(transitionTime, standardOffset + daylightSavingRule2.getSavings(), standardOffset + daylightSavingRule.getSavings(), daylightSavingRule.getSavings());
            }
            i++;
        }
        return zonalTransition2;
    }

    private static int getShift(DaylightSavingRule daylightSavingRule, int i, int i2) {
        OffsetIndicator indicator = daylightSavingRule.getIndicator();
        int i3 = AnonymousClass1.$SwitchMap$net$time4j$tz$model$OffsetIndicator[indicator.ordinal()];
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return i;
        }
        if (i3 == 3) {
            return i + i2;
        }
        throw new UnsupportedOperationException(indicator.name());
    }

    /* JADX INFO: renamed from: net.time4j.tz.model.RuleBasedTransitionModel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$tz$model$OffsetIndicator;

        static {
            int[] iArr = new int[OffsetIndicator.values().length];
            $SwitchMap$net$time4j$tz$model$OffsetIndicator = iArr;
            try {
                iArr[OffsetIndicator.UTC_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$tz$model$OffsetIndicator[OffsetIndicator.STANDARD_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$time4j$tz$model$OffsetIndicator[OffsetIndicator.WALL_TIME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static long getTransitionTime(DaylightSavingRule daylightSavingRule, int i, int i2) {
        return daylightSavingRule.getDate(i).at(daylightSavingRule.getTimeOfDay()).at(ZonalOffset.ofTotalSeconds(i2)).getPosixTime();
    }

    private List getTransitions(GregorianDate gregorianDate) {
        return getTransitions(((DaylightSavingRule) this.rules.get(0)).toCalendarYear(gregorianDate));
    }

    private List getTransitions(int i) {
        List list;
        Integer numValueOf = Integer.valueOf(i);
        List listUnmodifiableList = (List) this.tCache.get(numValueOf);
        if (listUnmodifiableList == null) {
            ArrayList arrayList = new ArrayList();
            int standardOffset = this.initial.getStandardOffset();
            int size = this.rules.size();
            for (int i2 = 0; i2 < size; i2++) {
                DaylightSavingRule daylightSavingRule = (DaylightSavingRule) this.rules.get(i2);
                DaylightSavingRule daylightSavingRule2 = (DaylightSavingRule) this.rules.get(((i2 - 1) + size) % size);
                arrayList.add(new ZonalTransition(getTransitionTime(daylightSavingRule, i, getShift(daylightSavingRule, standardOffset, daylightSavingRule2.getSavings())), standardOffset + daylightSavingRule2.getSavings(), standardOffset + daylightSavingRule.getSavings(), daylightSavingRule.getSavings()));
            }
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
            if (i <= LAST_CACHED_YEAR && this.gregorian && (list = (List) this.tCache.putIfAbsent(numValueOf, listUnmodifiableList)) != null) {
                return list;
            }
        }
        return listUnmodifiableList;
    }

    private static int getYear(DaylightSavingRule daylightSavingRule, long j) {
        return daylightSavingRule.toCalendarYear(EpochDays.MODIFIED_JULIAN_DATE.transform(MathUtils.floorDivide(j, SyncConfiguration.DEFAULT_FREQUENCY), EpochDays.UNIX));
    }

    private Object writeReplace() {
        return new SPX(this, 125);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }
}
