package app.screeb.sdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: renamed from: app.screeb.sdk.internal.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0326z extends BroadcastReceiver {
    public final /* synthetic */ A a;

    public C0326z(A a) {
        this.a = a;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.c();
    }
}
