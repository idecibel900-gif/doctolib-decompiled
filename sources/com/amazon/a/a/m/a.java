package com.amazon.a.a.m;

import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends com.amazon.a.a.e.a<a> {
    private final Object b;
    private final Date c;

    public a(Object obj, Date date) {
        this.b = obj;
        this.c = date;
    }

    public final Object h() {
        return this.b;
    }

    @Override // com.amazon.a.a.e.a
    public final Date a() {
        return this.c;
    }
}
