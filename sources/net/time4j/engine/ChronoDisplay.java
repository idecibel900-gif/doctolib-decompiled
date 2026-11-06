package net.time4j.engine;

import net.time4j.tz.TZID;

/* JADX INFO: loaded from: classes5.dex */
public interface ChronoDisplay {
    boolean contains(ChronoElement chronoElement);

    Object get(ChronoElement chronoElement);

    int getInt(ChronoElement chronoElement);

    Object getMaximum(ChronoElement chronoElement);

    Object getMinimum(ChronoElement chronoElement);

    TZID getTimezone();

    boolean hasTimezone();
}
