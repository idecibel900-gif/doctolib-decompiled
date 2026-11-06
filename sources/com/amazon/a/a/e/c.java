package com.amazon.a.a.e;

import com.amazon.a.a.e.a;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c<T extends a<T>> extends a<T> {
    private static final com.amazon.a.a.o.c b = new com.amazon.a.a.o.c("RelativeExpirable");
    private static final long c = 1000;
    private final Date d = new Date();

    protected abstract long h();

    @Override // com.amazon.a.a.e.a
    public final Date a() {
        com.amazon.a.a.o.c cVar = b;
        cVar.a("RelativeExpiration duration: " + h() + ", expirable: " + this);
        Date date = new Date(this.d.getTime() + (h() * 1000));
        StringBuilder sb = new StringBuilder();
        sb.append("Expiration should occur at time: ");
        sb.append(date);
        cVar.a(sb.toString());
        return date;
    }
}
