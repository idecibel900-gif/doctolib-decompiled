package net.time4j.format;

import java.text.ParsePosition;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;

/* JADX INFO: loaded from: classes5.dex */
public interface TextElement extends ChronoElement {
    Object parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery);

    void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery);
}
