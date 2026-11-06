package com.zoontek.rnlocalize;

import android.app.Activity;
import android.content.Intent;
import android.icu.number.NumberFormatter;
import android.icu.util.MeasureUnit;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.DateFormat;
import androidx.core.os.LocaleListCompat;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class RNLocalizeModuleImpl {
    public static final RNLocalizeModuleImpl INSTANCE = new RNLocalizeModuleImpl();
    private static final List USES_FAHRENHEIT = CollectionsKt.listOf((Object[]) new String[]{"BS", "BZ", "KY", "PR", "PW", "US"});
    private static final List USES_IMPERIAL = CollectionsKt.listOf((Object[]) new String[]{"LR", "MM", "US"});

    private RNLocalizeModuleImpl() {
    }

    private final String createLanguageTag(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str2.length() > 0) {
            sb.append("-" + str2);
        }
        sb.append("-" + str3);
        return sb.toString();
    }

    private final String getCountryCodeForLocale(Locale locale) {
        try {
            String country = locale.getCountry();
            if (Intrinsics.areEqual(country, "419")) {
                return "UN";
            }
            Intrinsics.checkNotNull(country);
            if (country.length() > 0) {
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
                String upperCase = country.toUpperCase(locale2);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                return upperCase;
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private final String getCurrencyCodeForLocale(Locale locale) {
        String currencyCode;
        try {
            Currency currency = Currency.getInstance(locale);
            return (currency == null || (currencyCode = currency.getCurrencyCode()) == null) ? "" : currencyCode;
        } catch (Exception unused) {
        }
    }

    private final String getLanguageCodeForLocale(Locale locale) {
        String language = locale.getLanguage();
        if (language == null) {
            return language;
        }
        int iHashCode = language.hashCode();
        if (iHashCode == 3365) {
            return !language.equals("in") ? language : DiagnosticsEntry.ID_KEY;
        }
        if (iHashCode != 3374) {
            return (iHashCode == 3391 && language.equals("ji")) ? "yi" : language;
        }
        return !language.equals("iw") ? language : "he";
    }

    private final String getScriptCodeForLocale(Locale locale) {
        String script = locale.getScript();
        return script.length() == 0 ? "" : script;
    }

    private final Locale getSystemLocale(ReactApplicationContext reactApplicationContext) {
        Locale locale = reactApplicationContext.getResources().getConfiguration().getLocales().get(0);
        Intrinsics.checkNotNullExpressionValue(locale, "get(...)");
        return locale;
    }

    private final List getSystemLocales(ReactApplicationContext reactApplicationContext) {
        reactApplicationContext.getResources().getConfiguration();
        LocaleListCompat localeListCompat = LocaleListCompat.getDefault();
        Intrinsics.checkNotNullExpressionValue(localeListCompat, "getDefault(...)");
        int size = localeListCompat.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Locale locale = localeListCompat.get(i);
            Intrinsics.checkNotNull(locale);
            arrayList.add(locale);
        }
        return arrayList;
    }

    private final String getMiuiRegionCode() {
        try {
            Class<?> cls = Class.forName(b.at);
            Object objInvoke = cls.getMethod(b.au, String.class).invoke(cls, "ro.miui.region");
            Objects.requireNonNull(objInvoke);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
            return (String) objInvoke;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String getCalendar() {
        return "gregorian";
    }

    public final String getCountry(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        String miuiRegionCode = getMiuiRegionCode();
        String countryCodeForLocale = getCountryCodeForLocale(getSystemLocale(reactContext));
        if (miuiRegionCode.length() > 0) {
            return miuiRegionCode;
        }
        return countryCodeForLocale.length() == 0 ? "US" : countryCodeForLocale;
    }

    public final WritableArray getCurrencies(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        List systemLocales = getSystemLocales(reactContext);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator it = systemLocales.iterator();
        while (it.hasNext()) {
            String currencyCodeForLocale = INSTANCE.getCurrencyCodeForLocale((Locale) it.next());
            if (currencyCodeForLocale.length() > 0 && linkedHashSet.add(currencyCodeForLocale)) {
                writableArrayCreateArray.pushString(currencyCodeForLocale);
            }
        }
        if (writableArrayCreateArray.size() == 0) {
            writableArrayCreateArray.pushString("USD");
        }
        return writableArrayCreateArray;
    }

    public final WritableArray getLocales(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        List<Locale> systemLocales = getSystemLocales(reactContext);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        String country = getCountry(reactContext);
        for (Locale locale : systemLocales) {
            String languageCodeForLocale = getLanguageCodeForLocale(locale);
            String scriptCodeForLocale = getScriptCodeForLocale(locale);
            String countryCodeForLocale = getCountryCodeForLocale(locale);
            if (countryCodeForLocale.length() == 0) {
                countryCodeForLocale = country;
            }
            Intrinsics.checkNotNull(languageCodeForLocale);
            Intrinsics.checkNotNull(scriptCodeForLocale);
            String strCreateLanguageTag = createLanguageTag(languageCodeForLocale, scriptCodeForLocale, countryCodeForLocale);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("languageCode", languageCodeForLocale);
            writableMapCreateMap.putString("countryCode", countryCodeForLocale);
            writableMapCreateMap.putString("languageTag", strCreateLanguageTag);
            writableMapCreateMap.putBoolean("isRTL", TextUtils.getLayoutDirectionFromLocale(locale) == 1);
            if (scriptCodeForLocale.length() > 0) {
                writableMapCreateMap.putString("scriptCode", scriptCodeForLocale);
            }
            if (linkedHashSet.add(strCreateLanguageTag)) {
                writableArrayCreateArray.pushMap(writableMapCreateMap);
            }
        }
        return writableArrayCreateArray;
    }

    public final WritableMap getNumberFormatSettings(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(getSystemLocale(reactContext));
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("decimalSeparator", String.valueOf(decimalFormatSymbols.getDecimalSeparator()));
        writableMapCreateMap.putString("groupingSeparator", String.valueOf(decimalFormatSymbols.getGroupingSeparator()));
        return writableMapCreateMap;
    }

    public final String getTemperatureUnit(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        if (Build.VERSION.SDK_INT < 33) {
            return USES_FAHRENHEIT.contains(getCountry(reactContext)) ? "fahrenheit" : "celsius";
        }
        String identifier = RNLocalizeModuleImpl$$ExternalSyntheticApiModelOutline0.m(RNLocalizeModuleImpl$$ExternalSyntheticApiModelOutline0.m(NumberFormatter.with().usage("weather")).unit(MeasureUnit.CELSIUS)).locale(getSystemLocale(reactContext)).format(1L).getOutputUnit().getIdentifier();
        Intrinsics.checkNotNull(identifier);
        return StringsKt.startsWith$default(identifier, "fahrenhe", false, 2, (Object) null) ? "fahrenheit" : "celsius";
    }

    public final String getTimeZone() {
        String id = TimeZone.getDefault().getID();
        Intrinsics.checkNotNullExpressionValue(id, "getID(...)");
        return id;
    }

    public final boolean uses24HourClock(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return DateFormat.is24HourFormat(reactContext);
    }

    public final boolean usesMetricSystem(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return !USES_IMPERIAL.contains(getCountry(reactContext));
    }

    public final boolean usesAutoDateAndTime(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return Settings.Global.getInt(reactContext.getContentResolver(), "auto_time", 0) != 0;
    }

    public final boolean usesAutoTimeZone(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return Settings.Global.getInt(reactContext.getContentResolver(), "auto_time_zone", 0) != 0;
    }

    public final void openAppLanguageSettings(ReactApplicationContext reactContext, Promise promise) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (Build.VERSION.SDK_INT < 33) {
            promise.reject("unsupported", "openAppLanguageSettings is supported only on Android 13+");
            return;
        }
        try {
            String packageName = reactContext.getPackageName();
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_LOCALE_SETTINGS");
            intent.setData(Uri.fromParts("package", packageName, null));
            Activity currentActivity = reactContext.getCurrentActivity();
            if (currentActivity != null) {
                currentActivity.startActivity(intent);
            }
            promise.resolve(Boolean.TRUE);
        } catch (Exception e) {
            promise.reject("E_INVALID_ACTIVITY", e);
        }
    }
}
