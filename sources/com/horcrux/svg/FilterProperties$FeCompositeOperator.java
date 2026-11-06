package com.horcrux.svg;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
enum FilterProperties$FeCompositeOperator {
    OVER("over"),
    IN("in"),
    OUT("out"),
    ATOP("atop"),
    XOR("xor"),
    ARITHMETIC("arithmetic");

    private static final Map typeToEnum = new HashMap();
    private final String type;

    static {
        for (FilterProperties$FeCompositeOperator filterProperties$FeCompositeOperator : values()) {
            typeToEnum.put(filterProperties$FeCompositeOperator.type, filterProperties$FeCompositeOperator);
        }
    }

    FilterProperties$FeCompositeOperator(String str) {
        this.type = str;
    }

    static FilterProperties$FeCompositeOperator getEnum(String str) {
        Map map = typeToEnum;
        if (!map.containsKey(str)) {
            throw new IllegalArgumentException("Unknown String Value: " + str);
        }
        return (FilterProperties$FeCompositeOperator) map.get(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.type;
    }
}
