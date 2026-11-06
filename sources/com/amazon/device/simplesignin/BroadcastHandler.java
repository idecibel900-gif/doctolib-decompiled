package com.amazon.device.simplesignin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.device.simplesignin.a.c;

/* JADX INFO: loaded from: classes3.dex */
public class BroadcastHandler extends BroadcastReceiver {
    private static final String TAG = "BroadcastHandler";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            c.a().a(context, intent);
        } catch (Exception e) {
            e.toString();
        }
    }
}
