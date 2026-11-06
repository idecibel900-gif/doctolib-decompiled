package com.facebook.hermes.intl;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LocaleIdentifier {
    static String canonicalizeLocaleId(String str) {
        return LocaleObject.createFromLocaleId(str).toCanonicalTag();
    }
}
