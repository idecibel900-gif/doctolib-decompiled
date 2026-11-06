package com.facebook.react.packagerconnection;

import com.facebook.common.logging.FLog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RequestOnlyHandler implements RequestHandler {
    @Override // com.facebook.react.packagerconnection.RequestHandler
    public final void onNotification(Object obj) {
        FLog.e(JSPackagerClient.class.getSimpleName(), "Notification is not supported");
    }
}
