package com.horcrux.svg;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
enum FilterProperties$FeColorMatrixType {
    MATRIX("matrix"),
    SATURATE("saturate"),
    HUE_ROTATE("hueRotate"),
    LUMINANCE_TO_ALPHA("luminanceToAlpha");

    private static final Map typeToEnum = new HashMap();
    private final String type;

    static {
        for (FilterProperties$FeColorMatrixType filterProperties$FeColorMatrixType : values()) {
            typeToEnum.put(filterProperties$FeColorMatrixType.type, filterProperties$FeColorMatrixType);
        }
    }

    FilterProperties$FeColorMatrixType(String str) {
        this.type = str;
    }

    static FilterProperties$FeColorMatrixType getEnum(String str) {
        Map map = typeToEnum;
        if (!map.containsKey(str)) {
            throw new IllegalArgumentException("Unknown String Value: " + str);
        }
        return (FilterProperties$FeColorMatrixType) map.get(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.type;
    }
}
