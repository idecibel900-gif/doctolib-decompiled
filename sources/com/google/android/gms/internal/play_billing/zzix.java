package com.google.android.gms.internal.play_billing;

import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.BluetoothManager;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.composables.BackgroundUIConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
final class zzix implements zzfx {
    static final zzfx zza = new zzix();

    private zzix() {
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
            case 14:
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                return true;
            default:
                switch (i) {
                    case 22:
                    case 23:
                    case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                    case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                        return true;
                    default:
                        return false;
                }
        }
    }
}
