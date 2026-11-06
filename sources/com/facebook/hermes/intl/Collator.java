package com.facebook.hermes.intl;

import com.amazon.a.a.o.b;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class Collator {
    private IPlatformCollator.CaseFirst mResolvedCaseFirst;
    private boolean mResolvedIgnorePunctuation;
    private ILocaleObject mResolvedLocaleObject;
    private ILocaleObject mResolvedLocaleObjectForResolvedOptions;
    private boolean mResolvedNumeric;
    private IPlatformCollator.Sensitivity mResolvedSensitivity;
    private IPlatformCollator.Usage mResolvedUsage;
    private String mResolvedCollation = "default";
    private IPlatformCollator mPlatformCollatorObject = new PlatformCollatorICU();

    private void initializeCollator(List list, Map map) throws JSRangeErrorException {
        OptionHelpers.OptionType optionType = OptionHelpers.OptionType.STRING;
        this.mResolvedUsage = (IPlatformCollator.Usage) OptionHelpers.searchEnum(IPlatformCollator.Usage.class, JSObjects.getJavaString(OptionHelpers.GetOption(map, "usage", optionType, Constants.COLLATOR_USAGE_POSSIBLE_VALUES, "sort")));
        Object objNewObject = JSObjects.newObject();
        JSObjects.Put(objNewObject, "localeMatcher", OptionHelpers.GetOption(map, "localeMatcher", optionType, Constants.LOCALEMATCHER_POSSIBLE_VALUES, "best fit"));
        Object objGetOption = OptionHelpers.GetOption(map, "numeric", OptionHelpers.OptionType.BOOLEAN, JSObjects.Undefined(), JSObjects.Undefined());
        if (!JSObjects.isUndefined(objGetOption)) {
            objGetOption = JSObjects.newString(String.valueOf(JSObjects.getJavaBoolean(objGetOption)));
        }
        JSObjects.Put(objNewObject, "kn", objGetOption);
        JSObjects.Put(objNewObject, "kf", OptionHelpers.GetOption(map, "caseFirst", optionType, Constants.CASEFIRST_POSSIBLE_VALUES, JSObjects.Undefined()));
        HashMap mapResolveLocale = LocaleResolver.resolveLocale(list, objNewObject, Arrays.asList("co", "kf", "kn"));
        ILocaleObject iLocaleObject = (ILocaleObject) JSObjects.getJavaMap(mapResolveLocale).get("locale");
        this.mResolvedLocaleObject = iLocaleObject;
        this.mResolvedLocaleObjectForResolvedOptions = iLocaleObject.cloneObject();
        Object objGet = JSObjects.Get(mapResolveLocale, "co");
        if (JSObjects.isNull(objGet)) {
            objGet = JSObjects.newString("default");
        }
        this.mResolvedCollation = JSObjects.getJavaString(objGet);
        Object objGet2 = JSObjects.Get(mapResolveLocale, "kn");
        if (JSObjects.isNull(objGet2)) {
            this.mResolvedNumeric = false;
        } else {
            this.mResolvedNumeric = Boolean.parseBoolean(JSObjects.getJavaString(objGet2));
        }
        Object objGet3 = JSObjects.Get(mapResolveLocale, "kf");
        if (JSObjects.isNull(objGet3)) {
            objGet3 = JSObjects.newString(b.ag);
        }
        this.mResolvedCaseFirst = (IPlatformCollator.CaseFirst) OptionHelpers.searchEnum(IPlatformCollator.CaseFirst.class, JSObjects.getJavaString(objGet3));
        if (this.mResolvedUsage == IPlatformCollator.Usage.SEARCH) {
            ArrayList unicodeExtensions = this.mResolvedLocaleObject.getUnicodeExtensions("collation");
            ArrayList arrayList = new ArrayList();
            Iterator it = unicodeExtensions.iterator();
            while (it.hasNext()) {
                arrayList.add(UnicodeExtensionKeys.resolveCollationAlias((String) it.next()));
            }
            arrayList.add(UnicodeExtensionKeys.resolveCollationAlias("search"));
            this.mResolvedLocaleObject.setUnicodeExtensions("co", arrayList);
        }
        Object objGetOption2 = OptionHelpers.GetOption(map, "sensitivity", OptionHelpers.OptionType.STRING, Constants.SENSITIVITY_POSSIBLE_VALUES, JSObjects.Undefined());
        if (!JSObjects.isUndefined(objGetOption2)) {
            this.mResolvedSensitivity = (IPlatformCollator.Sensitivity) OptionHelpers.searchEnum(IPlatformCollator.Sensitivity.class, JSObjects.getJavaString(objGetOption2));
        } else if (this.mResolvedUsage == IPlatformCollator.Usage.SORT) {
            this.mResolvedSensitivity = IPlatformCollator.Sensitivity.VARIANT;
        } else {
            this.mResolvedSensitivity = IPlatformCollator.Sensitivity.LOCALE;
        }
        this.mResolvedIgnorePunctuation = JSObjects.getJavaBoolean(OptionHelpers.GetOption(map, "ignorePunctuation", OptionHelpers.OptionType.BOOLEAN, JSObjects.Undefined(), Boolean.FALSE));
    }

    @DoNotStrip
    public Collator(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        initializeCollator(list, map);
        this.mPlatformCollatorObject.configure(this.mResolvedLocaleObject).setNumericAttribute(this.mResolvedNumeric).setCaseFirstAttribute(this.mResolvedCaseFirst).setSensitivity(this.mResolvedSensitivity).setIgnorePunctuation(this.mResolvedIgnorePunctuation);
    }

    @DoNotStrip
    public static List<String> supportedLocalesOf(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        if (JSObjects.getJavaString(OptionHelpers.GetOption(map, "localeMatcher", OptionHelpers.OptionType.STRING, Constants.LOCALEMATCHER_POSSIBLE_VALUES, "best fit")).equals("best fit")) {
            return Arrays.asList(LocaleMatcher.bestFitSupportedLocales((String[]) list.toArray(new String[list.size()])));
        }
        return Arrays.asList(LocaleMatcher.lookupSupportedLocales((String[]) list.toArray(new String[list.size()])));
    }

    @DoNotStrip
    public Map<String, Object> resolvedOptions() throws JSRangeErrorException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("locale", this.mResolvedLocaleObjectForResolvedOptions.toCanonicalTag().replace("-kn-true", "-kn"));
        linkedHashMap.put("usage", this.mResolvedUsage.toString());
        IPlatformCollator.Sensitivity sensitivity = this.mResolvedSensitivity;
        if (sensitivity == IPlatformCollator.Sensitivity.LOCALE) {
            linkedHashMap.put("sensitivity", this.mPlatformCollatorObject.getSensitivity().toString());
        } else {
            linkedHashMap.put("sensitivity", sensitivity.toString());
        }
        linkedHashMap.put("ignorePunctuation", Boolean.valueOf(this.mResolvedIgnorePunctuation));
        linkedHashMap.put("collation", this.mResolvedCollation);
        linkedHashMap.put("numeric", Boolean.valueOf(this.mResolvedNumeric));
        linkedHashMap.put("caseFirst", this.mResolvedCaseFirst.toString());
        return linkedHashMap;
    }

    @DoNotStrip
    public double compare(String str, String str2) {
        return this.mPlatformCollatorObject.compare(str, str2);
    }
}
