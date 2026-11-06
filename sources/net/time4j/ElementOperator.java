package net.time4j;

import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoOperator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ElementOperator implements ChronoOperator {
    private final ChronoElement element;
    private final int type;

    ElementOperator(ChronoElement chronoElement, int i) {
        this.element = chronoElement;
        this.type = i;
    }

    int getType() {
        return this.type;
    }
}
