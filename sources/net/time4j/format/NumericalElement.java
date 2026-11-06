package net.time4j.format;

import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;

/* JADX INFO: loaded from: classes5.dex */
public interface NumericalElement extends ChronoElement {
    boolean parseFromInt(ChronoEntity chronoEntity, int i);

    int printToInt(Object obj, ChronoDisplay chronoDisplay, AttributeQuery attributeQuery);
}
