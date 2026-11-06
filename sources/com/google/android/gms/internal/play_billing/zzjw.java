package com.google.android.gms.internal.play_billing;

import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
final class zzjw implements zzfx {
    static final zzfx zza = new zzjw();

    private zzjw() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final boolean zza(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case BaseVideoCapturer.RGBA /* 11 */:
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
            case 13:
            case 17:
            case 18:
            case 19:
            case 20:
                return true;
            case 14:
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
            case 16:
            default:
                return false;
        }
    }
}
