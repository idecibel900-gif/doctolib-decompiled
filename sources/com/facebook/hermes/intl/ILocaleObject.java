package com.facebook.hermes.intl;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public interface ILocaleObject {
    ILocaleObject cloneObject();

    Object getLocale();

    Object getLocaleWithoutExtensions();

    ArrayList getUnicodeExtensions(String str);

    HashMap getUnicodeExtensions();

    void setUnicodeExtensions(String str, ArrayList arrayList);

    String toCanonicalTag();

    String toCanonicalTagWithoutExtensions();
}
