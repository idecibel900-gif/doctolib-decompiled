package net.time4j.format.expert;

import java.util.Set;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;

/* JADX INFO: loaded from: classes5.dex */
interface FormatProcessor {
    ChronoElement getElement();

    boolean isNumerical();

    void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity parsedEntity, boolean z);

    int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set set, boolean z);

    FormatProcessor quickPath(ChronoFormatter chronoFormatter, AttributeQuery attributeQuery, int i);

    FormatProcessor withElement(ChronoElement chronoElement);
}
