package com.facebook.react.packagerconnection;

import com.facebook.common.logging.FLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NotificationOnlyHandler implements RequestHandler {
    @Override // com.facebook.react.packagerconnection.RequestHandler
    public final void onRequest(Object obj, Responder responder) {
        Intrinsics.checkNotNullParameter(responder, "responder");
        responder.error("Request is not supported");
        FLog.e(JSPackagerClient.class.getSimpleName(), "Request is not supported");
    }
}
