package net.time4j.calendar.service;

import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import net.time4j.PlainDate;
import net.time4j.calendar.KoreanCalendar;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoExtension;

/* JADX INFO: loaded from: classes5.dex */
public class KoreanExtension implements ChronoExtension {
    @Override // net.time4j.engine.ChronoExtension
    public boolean accept(Class cls) {
        return cls == PlainDate.class;
    }

    @Override // net.time4j.engine.ChronoExtension
    public Set getElements(Locale locale, AttributeQuery attributeQuery) {
        return Collections.EMPTY_SET;
    }

    @Override // net.time4j.engine.ChronoExtension
    public ChronoEntity resolve(ChronoEntity chronoEntity, Locale locale, AttributeQuery attributeQuery) {
        ChronoElement chronoElement = KoreanCalendar.YEAR_OF_ERA;
        if (!chronoEntity.contains(chronoElement)) {
            return chronoEntity;
        }
        return chronoEntity.with((ChronoElement) PlainDate.YEAR, chronoEntity.getInt(chronoElement) - 2333);
    }

    @Override // net.time4j.engine.ChronoExtension
    public boolean canResolve(ChronoElement chronoElement) {
        return chronoElement == KoreanCalendar.YEAR_OF_ERA;
    }
}
