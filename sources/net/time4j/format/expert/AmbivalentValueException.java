package net.time4j.format.expert;

import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoException;

/* JADX INFO: loaded from: classes5.dex */
class AmbivalentValueException extends ChronoException {
    private static final long serialVersionUID = -4315329288187364457L;

    AmbivalentValueException(ChronoElement chronoElement) {
        super("Duplicate element parsed with different values: " + chronoElement.name());
    }
}
