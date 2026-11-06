package com.adjust.sdk.sig;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class j2 implements Serializable {
    public final Throwable a;

    public j2(Throwable th) {
        this.a = th;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof j2) && this.a.equals(((j2) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.a + ')';
    }
}
