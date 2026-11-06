package com.amazon.a.a.o.c.a;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
final class e implements a {
    private final Pattern a;

    public e(String str) {
        this(Pattern.compile(str));
    }

    public e(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("Null pattern");
        }
        this.a = pattern;
    }

    @Override // com.amazon.a.a.o.c.a.a
    public boolean a(String str) {
        return this.a.matcher(str).matches();
    }
}
