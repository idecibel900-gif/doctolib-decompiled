package expo.modules.network;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class NetworkWifiException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkWifiException(Exception e) {
        super("Wi-Fi information could not be acquired", e.getCause());
        Intrinsics.checkNotNullParameter(e, "e");
    }
}
