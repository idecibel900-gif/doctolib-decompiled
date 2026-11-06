package com.horcrux.svg;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
enum TextProperties$TextDecoration {
    None("none"),
    Underline("underline"),
    Overline("overline"),
    LineThrough("line-through"),
    Blink("blink");

    private static final Map decorationToEnum = new HashMap();
    private final String decoration;

    static {
        for (TextProperties$TextDecoration textProperties$TextDecoration : values()) {
            decorationToEnum.put(textProperties$TextDecoration.decoration, textProperties$TextDecoration);
        }
    }

    TextProperties$TextDecoration(String str) {
        this.decoration = str;
    }

    static TextProperties$TextDecoration getEnum(String str) {
        Map map = decorationToEnum;
        if (!map.containsKey(str)) {
            throw new IllegalArgumentException("Unknown String Value: " + str);
        }
        return (TextProperties$TextDecoration) map.get(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.decoration;
    }
}
