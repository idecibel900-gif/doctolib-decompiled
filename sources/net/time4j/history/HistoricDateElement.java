package net.time4j.history;

import java.io.ObjectStreamException;
import net.time4j.PlainDate;
import net.time4j.engine.BasicElement;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.Chronology;
import net.time4j.engine.ElementRule;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes5.dex */
final class HistoricDateElement extends BasicElement {
    private static final long serialVersionUID = -5386613740709845550L;
    private final ChronoHistory history;

    @Override // net.time4j.engine.ChronoElement
    public boolean isDateElement() {
        return true;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isTimeElement() {
        return false;
    }

    HistoricDateElement(ChronoHistory chronoHistory) {
        super("HISTORIC_DATE");
        this.history = chronoHistory;
    }

    @Override // net.time4j.engine.ChronoElement
    public Class getType() {
        return HistoricDate.class;
    }

    @Override // net.time4j.engine.ChronoElement
    public HistoricDate getDefaultMinimum() {
        return HistoricDate.of(HistoricEra.BC, 45, 1, 1);
    }

    @Override // net.time4j.engine.ChronoElement
    public HistoricDate getDefaultMaximum() {
        return HistoricDate.of(HistoricEra.AD, 9999, 12, 31);
    }

    @Override // net.time4j.engine.BasicElement
    protected ElementRule derive(Chronology chronology) {
        if (chronology.isRegistered(PlainDate.COMPONENT)) {
            return new Rule(this.history);
        }
        return null;
    }

    @Override // net.time4j.engine.BasicElement
    protected boolean doEquals(BasicElement basicElement) {
        return this.history.equals(((HistoricDateElement) basicElement).history);
    }

    private Object readResolve() throws ObjectStreamException {
        return this.history.date();
    }

    private static class Rule implements ElementRule {
        private final ChronoHistory history;

        Rule(ChronoHistory chronoHistory) {
            this.history = chronoHistory;
        }

        @Override // net.time4j.engine.ElementRule
        public HistoricDate getValue(ChronoEntity chronoEntity) {
            try {
                return this.history.convert((PlainDate) chronoEntity.get(PlainDate.COMPONENT));
            } catch (IllegalArgumentException e) {
                throw new ChronoException(e.getMessage(), e);
            }
        }

        @Override // net.time4j.engine.ElementRule
        public HistoricDate getMinimum(ChronoEntity chronoEntity) {
            ChronoHistory chronoHistory = this.history;
            if (chronoHistory == ChronoHistory.PROLEPTIC_BYZANTINE) {
                return HistoricDate.of(HistoricEra.BYZANTINE, 0, 9, 1);
            }
            if (chronoHistory == ChronoHistory.PROLEPTIC_JULIAN) {
                return HistoricDate.of(HistoricEra.BC, 999979466, 1, 1);
            }
            if (chronoHistory == ChronoHistory.PROLEPTIC_GREGORIAN) {
                return HistoricDate.of(HistoricEra.BC, Http2Connection.DEGRADED_PONG_TIMEOUT_NS, 1, 1);
            }
            return HistoricDate.of(HistoricEra.BC, 45, 1, 1);
        }

        @Override // net.time4j.engine.ElementRule
        public HistoricDate getMaximum(ChronoEntity chronoEntity) {
            ChronoHistory chronoHistory = this.history;
            if (chronoHistory == ChronoHistory.PROLEPTIC_BYZANTINE) {
                return HistoricDate.of(HistoricEra.BYZANTINE, 999984973, 8, 31);
            }
            if (chronoHistory == ChronoHistory.PROLEPTIC_JULIAN) {
                return HistoricDate.of(HistoricEra.AD, 999979465, 12, 31);
            }
            if (chronoHistory == ChronoHistory.PROLEPTIC_GREGORIAN) {
                return HistoricDate.of(HistoricEra.AD, 999999999, 12, 31);
            }
            return HistoricDate.of(HistoricEra.AD, 9999, 12, 31);
        }

        @Override // net.time4j.engine.ElementRule
        public boolean isValid(ChronoEntity chronoEntity, HistoricDate historicDate) {
            return this.history.isValid(historicDate);
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoEntity withValue(ChronoEntity chronoEntity, HistoricDate historicDate, boolean z) {
            if (historicDate != null) {
                return chronoEntity.with(PlainDate.COMPONENT, this.history.convert(historicDate));
            }
            throw new IllegalArgumentException("Missing historic date.");
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtFloor(ChronoEntity chronoEntity) {
            throw new UnsupportedOperationException("Never called.");
        }

        @Override // net.time4j.engine.ElementRule
        public ChronoElement getChildAtCeiling(ChronoEntity chronoEntity) {
            throw new UnsupportedOperationException("Never called.");
        }
    }
}
