package com.google.android.gms.common.api;

import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.hybridcommon.ui.HybridPurchaseLogicBridge;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CommonStatusCodes {
    public static String getStatusCodeString(int i) {
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return HybridPurchaseLogicBridge.RESULT_SUCCESS;
            case 1:
            case 9:
            case BaseVideoCapturer.RGBA /* 11 */:
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
            default:
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
                sb.append("unknown status code: ");
                sb.append(i);
                return sb.toString();
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return HybridPurchaseLogicBridge.RESULT_ERROR;
            case 14:
                return "INTERRUPTED";
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
            case 19:
                return "REMOTE_EXCEPTION";
            case 20:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case 21:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            case 22:
                return "RECONNECTION_TIMED_OUT";
        }
    }
}
