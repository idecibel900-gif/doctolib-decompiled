package io.sentry;

import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public final class FilterString {
    private final String filterString;
    private final Pattern pattern;

    public FilterString(String str) {
        Pattern patternCompile;
        this.filterString = str;
        try {
            patternCompile = Pattern.compile(str);
        } catch (Throwable unused) {
            Sentry.getCurrentScopes().getOptions().getLogger().log(SentryLevel.DEBUG, "Only using filter string for String comparison as it could not be parsed as regex: %s", str);
            patternCompile = null;
        }
        this.pattern = patternCompile;
    }

    public String getFilterString() {
        return this.filterString;
    }

    public boolean matches(String str) {
        Pattern pattern = this.pattern;
        if (pattern == null) {
            return false;
        }
        return pattern.matcher(str).matches();
    }

    public boolean equals(Object obj) {
        if (obj == null || FilterString.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.filterString, ((FilterString) obj).filterString);
    }

    public int hashCode() {
        return Objects.hash(this.filterString);
    }
}
