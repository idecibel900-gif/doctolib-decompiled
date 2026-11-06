package net.time4j.calendar;

import java.util.Locale;
import net.time4j.calendar.service.GenericDatePatterns;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.StartOfDay;

/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractMergerEA implements ChronoMerger {
    private final Class chronoType;

    @Override // net.time4j.engine.ChronoMerger
    public int getDefaultPivotYear() {
        return 100;
    }

    @Override // net.time4j.engine.ChronoMerger
    public ChronoDisplay preformat(EastAsianCalendar eastAsianCalendar, AttributeQuery attributeQuery) {
        return eastAsianCalendar;
    }

    @Override // net.time4j.engine.ChronoMerger
    public Chronology preparser() {
        return null;
    }

    AbstractMergerEA(Class cls) {
        this.chronoType = cls;
    }

    @Override // net.time4j.engine.ChronoMerger
    public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
        return GenericDatePatterns.get("chinese", displayStyle, locale);
    }

    @Override // net.time4j.engine.ChronoMerger
    public StartOfDay getDefaultStartOfDay() {
        return StartOfDay.MIDNIGHT;
    }
}
