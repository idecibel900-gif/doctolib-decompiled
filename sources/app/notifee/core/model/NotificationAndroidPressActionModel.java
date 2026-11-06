package app.notifee.core.model;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.verification.SigningManager;
import java.util.ArrayList;
import java.util.Objects;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class NotificationAndroidPressActionModel {
    private Bundle mNotificationAndroidPressActionBundle;

    private NotificationAndroidPressActionModel(Bundle bundle) {
        this.mNotificationAndroidPressActionBundle = bundle;
    }

    public static NotificationAndroidPressActionModel fromBundle(Bundle bundle) {
        return new NotificationAndroidPressActionModel(bundle);
    }

    public Bundle toBundle() {
        return (Bundle) this.mNotificationAndroidPressActionBundle.clone();
    }

    public String getId() {
        String string = this.mNotificationAndroidPressActionBundle.getString(DiagnosticsEntry.ID_KEY);
        Objects.requireNonNull(string);
        return string;
    }

    public String getLaunchActivity() {
        String string = this.mNotificationAndroidPressActionBundle.getString("launchActivity");
        return (string == null && "default".equals(getId())) ? "default" : string;
    }

    public int getLaunchActivityFlags() {
        int i;
        if (!this.mNotificationAndroidPressActionBundle.containsKey("launchActivityFlags")) {
            return -1;
        }
        ArrayList<Integer> integerArrayList = this.mNotificationAndroidPressActionBundle.getIntegerArrayList("launchActivityFlags");
        Objects.requireNonNull(integerArrayList);
        int i2 = 0;
        for (int i3 = 0; i3 < integerArrayList.size(); i3++) {
            switch (integerArrayList.get(i3).intValue()) {
                case 0:
                    i = 1073741824;
                    break;
                case 1:
                    i = 536870912;
                    break;
                case 2:
                    i = 268435456;
                    break;
                case 3:
                    i = 134217728;
                    break;
                case 4:
                    i = 67108864;
                    break;
                case 5:
                    i = 33554432;
                    break;
                case 6:
                    i = Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
                    break;
                case 7:
                    i = 8388608;
                    break;
                case 8:
                    i = 4194304;
                    break;
                case 9:
                    i = 2097152;
                    break;
                case 10:
                    i = 1048576;
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    i2 |= 524288;
                    continue;
                    break;
                case 13:
                    i = 262144;
                    break;
                case 14:
                    i = 131072;
                    break;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    i = 65536;
                    break;
                case 16:
                    i = 32768;
                    break;
                case 17:
                    i2 |= Http2.INITIAL_MAX_FRAME_SIZE;
                    continue;
                    break;
                case 18:
                    i2 |= 8192;
                    continue;
                    break;
                case 19:
                    i2 |= 4096;
                    continue;
                    break;
                case 20:
                    if (Build.VERSION.SDK_INT >= 28) {
                        i2 |= 2048;
                    } else {
                        continue;
                    }
                    break;
                default:
                    continue;
                    break;
            }
            i2 |= i;
        }
        return i2;
    }

    public String getMainComponent() {
        return this.mNotificationAndroidPressActionBundle.getString("mainComponent");
    }
}
