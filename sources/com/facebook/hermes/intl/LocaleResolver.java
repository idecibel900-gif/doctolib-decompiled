package com.facebook.hermes.intl;

import com.amazon.a.a.o.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LocaleResolver {
    public static HashMap resolveLocale(List list, Object obj, List list2) {
        LocaleMatcher.LocaleMatchResult localeMatchResultBestFitMatch;
        Object obj2;
        Object objNewBoolean;
        Object objNewString;
        HashMap map = new HashMap();
        if (JSObjects.getJavaString(JSObjects.Get(obj, "localeMatcher")).equals("lookup")) {
            localeMatchResultBestFitMatch = LocaleMatcher.lookupMatch((String[]) list.toArray(new String[list.size()]));
        } else {
            localeMatchResultBestFitMatch = LocaleMatcher.bestFitMatch((String[]) list.toArray(new String[list.size()]));
        }
        HashSet<String> hashSet = new HashSet();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Object objNull = JSObjects.Null();
            if (!localeMatchResultBestFitMatch.extensions.isEmpty() && localeMatchResultBestFitMatch.extensions.containsKey(str)) {
                String str2 = (String) localeMatchResultBestFitMatch.extensions.get(str);
                if (str2.isEmpty()) {
                    obj2 = objNull;
                    obj2 = objNull;
                    objNewString = str2;
                    objNewString = JSObjects.newString(b.af);
                }
                obj2 = objNull;
                obj2 = objNull;
                objNewString = str2;
                hashSet.add(str);
                obj2 = objNewString;
            }
            obj2 = objNull;
            obj2 = objNull;
            obj2 = objNull;
            Object obj3 = obj2;
            if (JSObjects.getJavaMap(obj).containsKey(str)) {
                Object objGet = JSObjects.Get(obj, str);
                if (JSObjects.isString(objGet) && JSObjects.getJavaString(objGet).isEmpty()) {
                    objNewBoolean = objGet;
                    objNewBoolean = objGet;
                    objNewBoolean = JSObjects.newBoolean(true);
                }
                objNewBoolean = objGet;
                objNewBoolean = objGet;
                objNewBoolean = objGet;
                obj3 = obj2;
                if (!JSObjects.isUndefined(objNewBoolean) && !objNewBoolean.equals(obj2)) {
                    obj3 = obj2;
                    hashSet.remove(str);
                    obj3 = objNewBoolean;
                }
            }
            obj3 = obj2;
            boolean zIsNull = JSObjects.isNull(obj3);
            Object objResolveKnownAliases = obj3;
            if (!zIsNull) {
                objResolveKnownAliases = UnicodeExtensionKeys.resolveKnownAliases(str, obj3);
            }
            if (JSObjects.isString(objResolveKnownAliases) && !UnicodeExtensionKeys.isValidKeyword(str, JSObjects.getJavaString(objResolveKnownAliases), localeMatchResultBestFitMatch.matchedLocale)) {
                map.put(str, JSObjects.Null());
            } else {
                map.put(str, objResolveKnownAliases);
            }
        }
        for (String str3 : hashSet) {
            ArrayList arrayList = new ArrayList();
            String javaString = JSObjects.getJavaString(UnicodeExtensionKeys.resolveKnownAliases(str3, JSObjects.newString((String) localeMatchResultBestFitMatch.extensions.get(str3))));
            if (!JSObjects.isString(javaString) || UnicodeExtensionKeys.isValidKeyword(str3, JSObjects.getJavaString(javaString), localeMatchResultBestFitMatch.matchedLocale)) {
                arrayList.add(javaString);
                localeMatchResultBestFitMatch.matchedLocale.setUnicodeExtensions(str3, arrayList);
            }
        }
        map.put("locale", localeMatchResultBestFitMatch.matchedLocale);
        return map;
    }
}
