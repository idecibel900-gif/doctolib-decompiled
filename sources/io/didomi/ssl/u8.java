package io.didomi.ssl;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005¨\u0006\t"}, d2 = {"Lio/didomi/sdk/u8;", "", "Lio/didomi/sdk/t8;", "a", "", "Z", "isAndroidTV", "<init>", "(Z)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class u8 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final boolean isAndroidTV;

    public u8(boolean z) {
        this.isAndroidTV = z;
    }

    public final t8 a() {
        return this.isAndroidTV ? new cd() : new x7();
    }
}
