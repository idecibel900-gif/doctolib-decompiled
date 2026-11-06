package net.time4j.engine;

import java.util.Comparator;

/* JADX INFO: loaded from: classes5.dex */
public interface ChronoElement extends Comparator {
    Object getDefaultMaximum();

    Object getDefaultMinimum();

    char getSymbol();

    Class getType();

    boolean isDateElement();

    boolean isLenient();

    boolean isTimeElement();

    String name();
}
