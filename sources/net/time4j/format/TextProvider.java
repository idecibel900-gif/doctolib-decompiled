package net.time4j.format;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public interface TextProvider {
    String[] eras(String str, Locale locale, TextWidth textWidth);

    String[] meridiems(String str, Locale locale, TextWidth textWidth, OutputContext outputContext);

    String[] months(String str, Locale locale, TextWidth textWidth, OutputContext outputContext, boolean z);

    String[] quarters(String str, Locale locale, TextWidth textWidth, OutputContext outputContext);

    boolean supportsCalendarType(String str);

    boolean supportsLanguage(Locale locale);

    String[] weekdays(String str, Locale locale, TextWidth textWidth, OutputContext outputContext);
}
