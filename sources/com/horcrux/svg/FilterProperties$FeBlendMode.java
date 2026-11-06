package com.horcrux.svg;

import com.adjust.sdk.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
enum FilterProperties$FeBlendMode {
    UNKNOWN("unknown"),
    NORMAL(Constants.NORMAL),
    MULTIPLY("multiply"),
    SCREEN("screen"),
    DARKEN("darken"),
    LIGHTEN("lighten");

    private static final Map typeToEnum = new HashMap();
    private final String mode;

    static {
        for (FilterProperties$FeBlendMode filterProperties$FeBlendMode : values()) {
            typeToEnum.put(filterProperties$FeBlendMode.mode, filterProperties$FeBlendMode);
        }
    }

    FilterProperties$FeBlendMode(String str) {
        this.mode = str;
    }

    static FilterProperties$FeBlendMode getEnum(String str) {
        Map map = typeToEnum;
        if (!map.containsKey(str)) {
            throw new IllegalArgumentException("Unknown String Value: " + str);
        }
        return (FilterProperties$FeBlendMode) map.get(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mode;
    }
}
