package com.horcrux.svg;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
enum FilterProperties$EdgeMode {
    UNKNOWN("unknown"),
    DUPLICATE("duplicate"),
    WRAP("wrap"),
    NONE("none");

    private static final Map edgeModeToEnum = new HashMap();
    private final String edgeMode;

    static {
        for (FilterProperties$EdgeMode filterProperties$EdgeMode : values()) {
            edgeModeToEnum.put(filterProperties$EdgeMode.edgeMode, filterProperties$EdgeMode);
        }
    }

    FilterProperties$EdgeMode(String str) {
        this.edgeMode = str;
    }

    static FilterProperties$EdgeMode getEnum(String str) {
        Map map = edgeModeToEnum;
        if (!map.containsKey(str)) {
            throw new IllegalArgumentException("Unknown 'edgeMode' Value: " + str);
        }
        return (FilterProperties$EdgeMode) map.get(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.edgeMode;
    }
}
