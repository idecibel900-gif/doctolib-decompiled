package net.time4j;

import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoExtension;

/* JADX INFO: loaded from: classes5.dex */
class WeekExtension implements ChronoExtension {
    WeekExtension() {
    }

    @Override // net.time4j.engine.ChronoExtension
    public boolean accept(Class cls) {
        return false;
    }

    @Override // net.time4j.engine.ChronoExtension
    public boolean canResolve(ChronoElement chronoElement) {
        return false;
    }

    @Override // net.time4j.engine.ChronoExtension
    public ChronoEntity resolve(ChronoEntity chronoEntity, Locale locale, AttributeQuery attributeQuery) {
        return chronoEntity;
    }

    @Override // net.time4j.engine.ChronoExtension
    public Set getElements(Locale locale, AttributeQuery attributeQuery) {
        if (locale.getCountry().isEmpty()) {
            return Collections.EMPTY_SET;
        }
        return Weekmodel.of(locale).getElements();
    }
}
