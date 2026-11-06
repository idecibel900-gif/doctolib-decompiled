package com.horcrux.svg;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
enum FilterProperties$Units {
    OBJECT_BOUNDING_BOX("objectBoundingBox"),
    USER_SPACE_ON_USE("userSpaceOnUse");

    private static final Map unitsToEnum = new HashMap();
    private final String units;

    static {
        for (FilterProperties$Units filterProperties$Units : values()) {
            unitsToEnum.put(filterProperties$Units.units, filterProperties$Units);
        }
    }

    FilterProperties$Units(String str) {
        this.units = str;
    }

    static FilterProperties$Units getEnum(String str) {
        Map map = unitsToEnum;
        if (!map.containsKey(str)) {
            throw new IllegalArgumentException("Unknown 'Unit' Value: " + str);
        }
        return (FilterProperties$Units) map.get(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.units;
    }
}
