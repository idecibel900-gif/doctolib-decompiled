package net.time4j.format.internal;

import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.ChronoDisplay;
import net.time4j.format.Leniency;
import net.time4j.format.OutputContext;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;

/* JADX INFO: loaded from: classes5.dex */
public interface GregorianTextElement extends TextElement {
    Object parse(CharSequence charSequence, ParsePosition parsePosition, Locale locale, TextWidth textWidth, OutputContext outputContext, Leniency leniency);

    void print(ChronoDisplay chronoDisplay, Appendable appendable, Locale locale, TextWidth textWidth, OutputContext outputContext);
}
