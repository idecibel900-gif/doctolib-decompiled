package com.google.common.base;

/* JADX INFO: loaded from: classes3.dex */
abstract class Platform {
    private static final PatternCompiler patternCompiler = loadPatternCompiler();

    static boolean stringIsNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    static String nullToEmpty(String str) {
        return str == null ? "" : str;
    }

    static String emptyToNull(String str) {
        if (stringIsNullOrEmpty(str)) {
            return null;
        }
        return str;
    }

    static String lenientFormat(String str, Object... objArr) {
        return Strings.lenientFormat(str, objArr);
    }

    static String stringValueOf(Object obj) {
        return String.valueOf(obj);
    }

    private static PatternCompiler loadPatternCompiler() {
        return new JdkPatternCompiler();
    }

    private static final class JdkPatternCompiler implements PatternCompiler {
        private JdkPatternCompiler() {
        }
    }
}
