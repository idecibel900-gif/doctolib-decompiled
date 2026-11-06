package com.amazon.a.b.a;

import com.amazon.a.a.d.b;
import com.amazon.a.a.o.b.f;
import com.amazon.a.a.o.d.c;

/* JADX INFO: loaded from: classes3.dex */
public class a extends b {
    private static final long a = 1;
    private final c b;

    public a(c cVar) {
        super("LICENSE_VERIFICATION_FAILURE", "VERIFICATION_ERRORS", a(cVar));
        com.amazon.a.a.o.a.a.a(cVar.a(), "Created a verification exception with a Verifier that has no errors");
        this.b = cVar;
    }

    private static String a(c cVar) {
        StringBuilder sb = new StringBuilder();
        for (com.amazon.a.a.o.d.a aVar : cVar) {
            if (sb.length() != 0) {
                sb.append(f.a);
            }
            sb.append(aVar.a().a());
        }
        return sb.toString();
    }

    public c d() {
        return this.b;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.b.toString();
    }
}
