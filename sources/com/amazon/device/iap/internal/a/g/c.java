package com.amazon.device.iap.internal.a.g;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {
    public c(com.amazon.device.iap.internal.a.c cVar, boolean z) {
        super(cVar, com.amazon.a.a.o.b.ah);
        a(com.amazon.a.a.o.b.aa, Boolean.valueOf(z));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    @Override // com.amazon.a.a.n.a.h
    public void l() {
        Object objA = j().a().a(com.amazon.a.a.o.b.ao);
        if (objA != null) {
            Boolean bool = Boolean.TRUE;
            if (!bool.equals(objA)) {
                a(com.amazon.a.a.o.b.ab, Boolean.FALSE);
            } else {
                a(com.amazon.a.a.o.b.ab, bool);
            }
        } else {
            a(com.amazon.a.a.o.b.ab, Boolean.FALSE);
        }
        super.l();
    }
}
