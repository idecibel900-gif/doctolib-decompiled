package app.notifee.core.model;

import android.os.Bundle;
import app.notifee.core.KeepForSdk;
import com.amazon.a.a.o.b;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class NotificationModel {
    private Bundle mNotificationBundle;

    public NotificationModel(Bundle bundle) {
        this.mNotificationBundle = bundle;
    }

    public static NotificationModel fromBundle(Bundle bundle) {
        return new NotificationModel(bundle);
    }

    public Integer getHashCode() {
        return Integer.valueOf(getId().hashCode());
    }

    public String getId() {
        String string = this.mNotificationBundle.getString(DiagnosticsEntry.ID_KEY);
        Objects.requireNonNull(string);
        return string;
    }

    public String getTitle() {
        return this.mNotificationBundle.getString(b.S);
    }

    public String getSubTitle() {
        return this.mNotificationBundle.getString("subtitle");
    }

    public String getBody() {
        return this.mNotificationBundle.getString("body");
    }

    public NotificationAndroidModel getAndroid() {
        return NotificationAndroidModel.fromBundle(this.mNotificationBundle.getBundle("android"));
    }

    public Bundle getData() {
        Bundle bundle = this.mNotificationBundle.getBundle(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        if (bundle != null) {
            return (Bundle) bundle.clone();
        }
        return new Bundle();
    }

    @KeepForSdk
    public Bundle toBundle() {
        return (Bundle) this.mNotificationBundle.clone();
    }
}
