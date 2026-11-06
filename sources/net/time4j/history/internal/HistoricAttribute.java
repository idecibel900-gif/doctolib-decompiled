package net.time4j.history.internal;

import net.time4j.engine.AttributeKey;
import net.time4j.format.Attributes;
import net.time4j.history.ChronoHistory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HistoricAttribute {
    public static final AttributeKey CALENDAR_HISTORY = Attributes.createKey("CALENDAR_HISTORY", ChronoHistory.class);
    public static final AttributeKey COMMON_ERA = Attributes.createKey("COMMON_ERA", Boolean.class);
    public static final AttributeKey LATIN_ERA = Attributes.createKey("LATIN_ERA", Boolean.class);
}
