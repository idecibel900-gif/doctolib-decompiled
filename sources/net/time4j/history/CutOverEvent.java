package net.time4j.history;

import net.time4j.PlainDate;
import net.time4j.engine.EpochDays;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes5.dex */
final class CutOverEvent {
    final CalendarAlgorithm algorithm;
    final HistoricDate dateAtCutOver;
    final HistoricDate dateBeforeCutOver;
    final long start;

    CutOverEvent(long j, CalendarAlgorithm calendarAlgorithm, CalendarAlgorithm calendarAlgorithm2) {
        this.start = j;
        this.algorithm = calendarAlgorithm2;
        if (j == Long.MIN_VALUE) {
            HistoricDate historicDate = new HistoricDate(HistoricEra.BC, Http2Connection.DEGRADED_PONG_TIMEOUT_NS, 1, 1);
            this.dateAtCutOver = historicDate;
            this.dateBeforeCutOver = historicDate;
        } else {
            this.dateAtCutOver = calendarAlgorithm2.fromMJD(j);
            this.dateBeforeCutOver = calendarAlgorithm.fromMJD(j - 1);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CutOverEvent) {
            CutOverEvent cutOverEvent = (CutOverEvent) obj;
            if (this.start == cutOverEvent.start && this.algorithm == cutOverEvent.algorithm && this.dateBeforeCutOver.equals(cutOverEvent.dateBeforeCutOver)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.start;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return CutOverEvent.class.getName() + "[start=" + this.start + " (" + PlainDate.of(this.start, EpochDays.MODIFIED_JULIAN_DATE) + "),algorithm=" + this.algorithm + ",date-before-cutover=" + this.dateBeforeCutOver + ",date-at-cutover=" + this.dateAtCutOver + ']';
    }
}
