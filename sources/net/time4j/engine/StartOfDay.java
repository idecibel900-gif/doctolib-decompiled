package net.time4j.engine;

import net.time4j.tz.TZID;

/* JADX INFO: loaded from: classes5.dex */
public abstract class StartOfDay {
    public static final StartOfDay MIDNIGHT = fixed(0);
    public static final StartOfDay EVENING = fixed(-21600);
    public static final StartOfDay MORNING = fixed(21600);

    public abstract int getDeviation(CalendarDate calendarDate, TZID tzid);

    protected StartOfDay() {
    }

    private static StartOfDay fixed(int i) {
        return new FixedStartOfDay(i);
    }

    private static class FixedStartOfDay extends StartOfDay {
        private final int deviation;

        private FixedStartOfDay(int i) {
            this.deviation = i;
        }

        @Override // net.time4j.engine.StartOfDay
        public int getDeviation(CalendarDate calendarDate, TZID tzid) {
            return this.deviation;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FixedStartOfDay) && this.deviation == ((FixedStartOfDay) obj).deviation;
        }

        public int hashCode() {
            return this.deviation;
        }

        public String toString() {
            return "FixedStartOfDay[" + this.deviation + "]";
        }
    }
}
