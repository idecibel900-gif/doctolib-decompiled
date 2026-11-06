package com.amazon.a.a.o.c.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class c implements a {
    private final Set<String> a;

    public c(String... strArr) {
        this.a = Collections.unmodifiableSet(new HashSet(Arrays.asList(strArr)));
    }

    @Override // com.amazon.a.a.o.c.a.a
    public boolean a(String str) {
        return this.a.contains(str);
    }
}
