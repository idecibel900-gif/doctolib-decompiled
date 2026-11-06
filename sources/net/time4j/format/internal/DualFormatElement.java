package net.time4j.format.internal;

import java.text.ParsePosition;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoEntity;
import net.time4j.format.Attributes;
import net.time4j.format.NumberSystem;
import net.time4j.format.TextElement;

/* JADX INFO: loaded from: classes5.dex */
public interface DualFormatElement extends TextElement {
    public static final AttributeKey COUNT_OF_PATTERN_SYMBOLS = Attributes.createKey("COUNT_OF_PATTERN_SYMBOLS", Integer.class);

    Integer parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery, ChronoEntity chronoEntity);

    void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, NumberSystem numberSystem, char c, int i, int i2);
}
