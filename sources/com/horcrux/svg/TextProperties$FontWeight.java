package com.horcrux.svg;

import com.adjust.sdk.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
enum TextProperties$FontWeight {
    Normal(Constants.NORMAL),
    Bold("bold"),
    w100("100"),
    w200("200"),
    w300("300"),
    w400("400"),
    w500("500"),
    w600("600"),
    w700("700"),
    w800("800"),
    w900("900"),
    Bolder("bolder"),
    Lighter("lighter");

    private static final Map weightToEnum = new HashMap();
    private final String weight;

    static {
        for (TextProperties$FontWeight textProperties$FontWeight : values()) {
            weightToEnum.put(textProperties$FontWeight.weight, textProperties$FontWeight);
        }
    }

    TextProperties$FontWeight(String str) {
        this.weight = str;
    }

    static boolean hasEnum(String str) {
        return weightToEnum.containsKey(str);
    }

    static TextProperties$FontWeight get(String str) {
        return (TextProperties$FontWeight) weightToEnum.get(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.weight;
    }
}
