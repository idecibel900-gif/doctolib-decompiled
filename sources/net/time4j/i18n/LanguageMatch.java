package net.time4j.i18n;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public enum LanguageMatch {
    tl("fil"),
    no("nb"),
    in(DiagnosticsEntry.ID_KEY),
    iw("he");

    static final LanguageMatch[] ALIASES = values();
    private final String alias;

    LanguageMatch(String str) {
        this.alias = str;
    }

    public static String getAlias(Locale locale) {
        String language = locale.getLanguage();
        if (language.equals("no") && locale.getVariant().equals("NY") && locale.getCountry().equals("NO")) {
            return "nn";
        }
        for (LanguageMatch languageMatch : ALIASES) {
            if (language.equals(languageMatch.name())) {
                return languageMatch.alias;
            }
        }
        return language;
    }
}
