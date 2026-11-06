package net.time4j.format;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public interface PluralProvider {
    PluralRules load(Locale locale, NumberType numberType);
}
