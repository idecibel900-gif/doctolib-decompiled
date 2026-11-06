package net.time4j.i18n;

import java.util.Locale;
import java.util.Set;
import net.time4j.PlainDate;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoExtension;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;
import net.time4j.history.ChronoHistory;
import net.time4j.history.HistoricDate;
import net.time4j.history.HistoricEra;
import net.time4j.history.YearDefinition;
import net.time4j.history.internal.HistoricAttribute;
import net.time4j.history.internal.StdHistoricalElement;

/* JADX INFO: loaded from: classes5.dex */
public class HistoricExtension implements ChronoExtension {
    @Override // net.time4j.engine.ChronoExtension
    public boolean accept(Class cls) {
        return cls == PlainDate.class;
    }

    @Override // net.time4j.engine.ChronoExtension
    public Set getElements(Locale locale, AttributeQuery attributeQuery) {
        return getHistory(locale, attributeQuery).getElements();
    }

    @Override // net.time4j.engine.ChronoExtension
    public ChronoEntity resolve(ChronoEntity chronoEntity, Locale locale, AttributeQuery attributeQuery) {
        return resolve(chronoEntity, getHistory(locale, attributeQuery), attributeQuery);
    }

    public ChronoEntity resolve(ChronoEntity chronoEntity, ChronoHistory chronoHistory, AttributeQuery attributeQuery) {
        HistoricEra historicEra;
        HistoricEra historicEra2;
        if (chronoEntity.contains(chronoHistory.era())) {
            historicEra2 = (HistoricEra) chronoEntity.get(chronoHistory.era());
        } else {
            if (((Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART)).isLax()) {
                historicEra2 = HistoricEra.AD;
            } else {
                historicEra = null;
            }
            if (historicEra == null && chronoEntity.contains(chronoHistory.yearOfEra())) {
                int i = chronoEntity.getInt(chronoHistory.yearOfEra());
                if (chronoEntity.contains(chronoHistory.month()) && chronoEntity.contains(chronoHistory.dayOfMonth())) {
                    PlainDate plainDateConvert = chronoHistory.convert(HistoricDate.of(historicEra, i, chronoEntity.getInt(chronoHistory.month()), chronoEntity.getInt(chronoHistory.dayOfMonth()), (YearDefinition) attributeQuery.get(ChronoHistory.YEAR_DEFINITION, YearDefinition.DUAL_DATING), chronoHistory.getNewYearStrategy()));
                    chronoEntity.with(chronoHistory.era(), (Object) null);
                    chronoEntity.with(chronoHistory.yearOfEra(), (Object) null);
                    chronoEntity.with(chronoHistory.month(), (Object) null);
                    chronoEntity.with(chronoHistory.dayOfMonth(), (Object) null);
                    return chronoEntity.with(PlainDate.COMPONENT, plainDateConvert);
                }
                if (!chronoEntity.contains(chronoHistory.dayOfYear())) {
                    return chronoEntity;
                }
                int i2 = chronoEntity.getInt(chronoHistory.dayOfYear());
                ChronoElement chronoElement = StdHistoricalElement.YEAR_OF_DISPLAY;
                if (chronoEntity.contains(chronoElement)) {
                    i = chronoEntity.getInt(chronoElement);
                }
                return chronoEntity.with(PlainDate.COMPONENT, (PlainDate) chronoHistory.convert(chronoHistory.getBeginOfYear(historicEra, i)).with(chronoHistory.dayOfYear(), i2));
            }
        }
        historicEra = historicEra2;
        return historicEra == null ? chronoEntity : chronoEntity;
    }

    @Override // net.time4j.engine.ChronoExtension
    public boolean canResolve(ChronoElement chronoElement) {
        return chronoElement instanceof StdHistoricalElement;
    }

    private static ChronoHistory getHistory(Locale locale, AttributeQuery attributeQuery) {
        AttributeKey attributeKey = Attributes.CALENDAR_TYPE;
        if (((String) attributeQuery.get(attributeKey, "iso8601")).equals("julian")) {
            return ChronoHistory.PROLEPTIC_JULIAN;
        }
        AttributeKey attributeKey2 = HistoricAttribute.CALENDAR_HISTORY;
        if (attributeQuery.contains(attributeKey2)) {
            return (ChronoHistory) attributeQuery.get(attributeKey2);
        }
        if (((String) attributeQuery.get(attributeKey, "iso8601")).equals("historic")) {
            AttributeKey attributeKey3 = Attributes.CALENDAR_VARIANT;
            if (attributeQuery.contains(attributeKey3)) {
                return ChronoHistory.from((String) attributeQuery.get(attributeKey3));
            }
        }
        return ChronoHistory.of(locale);
    }
}
