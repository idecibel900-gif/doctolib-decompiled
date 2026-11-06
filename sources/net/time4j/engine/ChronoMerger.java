package net.time4j.engine;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public interface ChronoMerger {
    Object createFrom(ChronoEntity chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2);

    int getDefaultPivotYear();

    StartOfDay getDefaultStartOfDay();

    String getFormatPattern(DisplayStyle displayStyle, Locale locale);

    ChronoDisplay preformat(Object obj, AttributeQuery attributeQuery);

    Chronology preparser();
}
