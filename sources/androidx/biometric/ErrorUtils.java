package androidx.biometric;

import android.content.Context;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
abstract class ErrorUtils {
    static boolean isKnownError(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
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
            case 6:
            default:
                return false;
        }
    }

    static boolean isLockoutError(int i) {
        return i == 7 || i == 9;
    }

    static String getFingerprintErrorString(Context context, int i) {
        if (context == null) {
            return "";
        }
        if (i == 1) {
            return context.getString(R$string.fingerprint_error_hw_not_available);
        }
        if (i != 7) {
            switch (i) {
                case 9:
                    break;
                case 10:
                    return context.getString(R$string.fingerprint_error_user_canceled);
                case BaseVideoCapturer.RGBA /* 11 */:
                    return context.getString(R$string.fingerprint_error_no_fingerprints);
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    return context.getString(R$string.fingerprint_error_hw_not_present);
                default:
                    return context.getString(R$string.default_error_msg);
            }
        }
        return context.getString(R$string.fingerprint_error_lockout);
    }
}
