package net.time4j;

import net.time4j.engine.TimePoint;

/* JADX INFO: loaded from: classes5.dex */
public enum ClockUnit implements IsoTimeUnit {
    HOURS { // from class: net.time4j.ClockUnit.1
        @Override // net.time4j.engine.ChronoUnit
        public double getLength() {
            return 3600.0d;
        }

        @Override // net.time4j.IsoUnit
        public char getSymbol() {
            return 'H';
        }
    },
    MINUTES { // from class: net.time4j.ClockUnit.2
        @Override // net.time4j.engine.ChronoUnit
        public double getLength() {
            return 60.0d;
        }

        @Override // net.time4j.IsoUnit
        public char getSymbol() {
            return 'M';
        }
    },
    SECONDS { // from class: net.time4j.ClockUnit.3
        @Override // net.time4j.engine.ChronoUnit
        public double getLength() {
            return 1.0d;
        }

        @Override // net.time4j.IsoUnit
        public char getSymbol() {
            return 'S';
        }
    },
    MILLIS { // from class: net.time4j.ClockUnit.4
        @Override // net.time4j.engine.ChronoUnit
        public double getLength() {
            return 0.001d;
        }

        @Override // net.time4j.IsoUnit
        public char getSymbol() {
            return '3';
        }
    },
    MICROS { // from class: net.time4j.ClockUnit.5
        @Override // net.time4j.engine.ChronoUnit
        public double getLength() {
            return 1.0E-6d;
        }

        @Override // net.time4j.IsoUnit
        public char getSymbol() {
            return '6';
        }
    },
    NANOS { // from class: net.time4j.ClockUnit.6
        @Override // net.time4j.engine.ChronoUnit
        public double getLength() {
            return 1.0E-9d;
        }

        @Override // net.time4j.IsoUnit
        public char getSymbol() {
            return '9';
        }
    };

    private static final long[] FACTORS = {1, 60, 3600, 3600000, 3600000000L, 3600000000000L};

    @Override // net.time4j.engine.ChronoUnit
    public boolean isCalendrical() {
        return false;
    }

    public long between(TimePoint timePoint, TimePoint timePoint2) {
        return timePoint.until(timePoint2, this);
    }
}
