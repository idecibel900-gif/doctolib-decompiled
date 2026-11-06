package app.screeb.sdk.internal;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: app.screeb.sdk.internal.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0318q {
    public final ByteBuffer a;
    public final O b;
    public final long c;

    public C0318q(ByteBuffer payload, O owner, long j) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.a = payload;
        this.b = owner;
        this.c = j;
    }

    public final long a() {
        return this.c;
    }

    public final O b() {
        return this.b;
    }

    public final ByteBuffer c() {
        return this.a;
    }
}
