package net.time4j.history;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.time4j.PlainDate;
import net.time4j.engine.EpochDays;

/* JADX INFO: loaded from: classes5.dex */
public final class EraPreference {
    private final PlainDate end;
    private final HistoricEra era;
    private final PlainDate start;
    static final EraPreference DEFAULT = new EraPreference();
    private static final HistoricDate AD1 = HistoricDate.of(HistoricEra.AD, 1, 1, 1);
    private static final HistoricDate BC38 = HistoricDate.of(HistoricEra.BC, 38, 1, 1);
    private static final PlainDate PROTOTYPE = PlainDate.of(2000, 1);

    private EraPreference() {
        this.era = null;
        this.start = (PlainDate) PlainDate.axis().getMinimum();
        this.end = (PlainDate) PlainDate.axis().getMaximum();
    }

    private EraPreference(HistoricEra historicEra, PlainDate plainDate, PlainDate plainDate2) {
        if (historicEra.compareTo(HistoricEra.AD) <= 0) {
            throw new UnsupportedOperationException(historicEra.name());
        }
        if (plainDate2.isBefore(plainDate)) {
            throw new IllegalArgumentException("End before start: " + plainDate + "/" + plainDate2);
        }
        this.era = historicEra;
        this.start = plainDate;
        this.end = plainDate2;
    }

    public static EraPreference hispanicUntil(PlainDate plainDate) {
        return hispanicBetween((PlainDate) PlainDate.axis().getMinimum(), plainDate);
    }

    public static EraPreference hispanicBetween(PlainDate plainDate, PlainDate plainDate2) {
        return new EraPreference(HistoricEra.HISPANIC, plainDate, plainDate2);
    }

    public static EraPreference byzantineUntil(PlainDate plainDate) {
        return byzantineBetween((PlainDate) PlainDate.axis().getMinimum(), plainDate);
    }

    public static EraPreference byzantineBetween(PlainDate plainDate, PlainDate plainDate2) {
        return new EraPreference(HistoricEra.BYZANTINE, plainDate, plainDate2);
    }

    public static EraPreference abUrbeConditaBetween(PlainDate plainDate, PlainDate plainDate2) {
        return new EraPreference(HistoricEra.AB_URBE_CONDITA, plainDate, plainDate2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EraPreference) {
            EraPreference eraPreference = (EraPreference) obj;
            EraPreference eraPreference2 = DEFAULT;
            if (this == eraPreference2) {
                return eraPreference == eraPreference2;
            }
            if (this.era == eraPreference.era && this.start.equals(eraPreference.start) && this.end.equals(eraPreference.end)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.era.hashCode() * 17) + (this.start.hashCode() * 31) + (this.end.hashCode() * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (this == DEFAULT) {
            sb.append("default");
        } else {
            sb.append("era->");
            sb.append(this.era);
            sb.append(",start->");
            sb.append(this.start);
            sb.append(",end->");
            sb.append(this.end);
        }
        sb.append(']');
        return sb.toString();
    }

    HistoricEra getPreferredEra(HistoricDate historicDate, PlainDate plainDate) {
        if (this.era == null || plainDate.isBefore(this.start) || plainDate.isAfter(this.end)) {
            return historicDate.compareTo(AD1) < 0 ? HistoricEra.BC : HistoricEra.AD;
        }
        if (this.era == HistoricEra.HISPANIC && historicDate.compareTo(BC38) < 0) {
            return HistoricEra.BC;
        }
        return this.era;
    }

    void writeToStream(DataOutput dataOutput) throws IOException {
        if (this == DEFAULT) {
            dataOutput.writeByte(0);
            return;
        }
        dataOutput.writeByte(127);
        dataOutput.writeUTF(this.era.name());
        PlainDate plainDate = this.start;
        EpochDays epochDays = EpochDays.MODIFIED_JULIAN_DATE;
        dataOutput.writeLong(((Long) plainDate.get(epochDays)).longValue());
        dataOutput.writeLong(((Long) this.end.get(epochDays)).longValue());
    }

    static EraPreference readFromStream(DataInput dataInput) throws IOException {
        if (dataInput.readByte() == 127) {
            HistoricEra historicEraValueOf = HistoricEra.valueOf(dataInput.readUTF());
            long j = dataInput.readLong();
            long j2 = dataInput.readLong();
            PlainDate plainDate = PROTOTYPE;
            EpochDays epochDays = EpochDays.MODIFIED_JULIAN_DATE;
            return new EraPreference(historicEraValueOf, (PlainDate) plainDate.with(epochDays, j), (PlainDate) plainDate.with(epochDays, j2));
        }
        return DEFAULT;
    }
}
