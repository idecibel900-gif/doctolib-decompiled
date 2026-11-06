package net.time4j.tz;

import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public interface ZoneNameProvider {
    String getDisplayName(String str, NameStyle nameStyle, Locale locale);

    Set getPreferredIDs(Locale locale, boolean z);

    String getStdFormatPattern(boolean z, Locale locale);
}
