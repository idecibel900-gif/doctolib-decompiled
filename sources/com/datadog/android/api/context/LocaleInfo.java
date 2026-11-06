package com.datadog.android.api.context;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class LocaleInfo {
    private final String currentLocale;
    private final List locales;
    private final String timeZone;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocaleInfo)) {
            return false;
        }
        LocaleInfo localeInfo = (LocaleInfo) obj;
        return Intrinsics.areEqual(this.locales, localeInfo.locales) && Intrinsics.areEqual(this.currentLocale, localeInfo.currentLocale) && Intrinsics.areEqual(this.timeZone, localeInfo.timeZone);
    }

    public int hashCode() {
        return (((this.locales.hashCode() * 31) + this.currentLocale.hashCode()) * 31) + this.timeZone.hashCode();
    }

    public String toString() {
        return "LocaleInfo(locales=" + this.locales + ", currentLocale=" + this.currentLocale + ", timeZone=" + this.timeZone + ")";
    }

    public LocaleInfo(List locales, String currentLocale, String timeZone) {
        Intrinsics.checkNotNullParameter(locales, "locales");
        Intrinsics.checkNotNullParameter(currentLocale, "currentLocale");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        this.locales = locales;
        this.currentLocale = currentLocale;
        this.timeZone = timeZone;
    }

    public final List getLocales() {
        return this.locales;
    }

    public final String getCurrentLocale() {
        return this.currentLocale;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }
}
