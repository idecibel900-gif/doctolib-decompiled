package net.time4j.engine;

import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public interface ChronoExtension {
    boolean accept(Class cls);

    boolean canResolve(ChronoElement chronoElement);

    Set getElements(Locale locale, AttributeQuery attributeQuery);

    ChronoEntity resolve(ChronoEntity chronoEntity, Locale locale, AttributeQuery attributeQuery);
}
