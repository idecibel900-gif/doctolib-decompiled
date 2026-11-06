package app.notifee.core.model;

import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import com.amazon.a.a.o.b;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class NotificationAndroidActionModel {
    private Bundle mNotificationAndroidActionBundle;

    private NotificationAndroidActionModel(Bundle bundle) {
        this.mNotificationAndroidActionBundle = bundle;
    }

    public static NotificationAndroidActionModel fromBundle(Bundle bundle) {
        return new NotificationAndroidActionModel(bundle);
    }

    public Bundle toBundle() {
        return (Bundle) this.mNotificationAndroidActionBundle.clone();
    }

    public String getTitle() {
        String string = this.mNotificationAndroidActionBundle.getString(b.S);
        Objects.requireNonNull(string);
        return string;
    }

    public String getIcon() {
        return this.mNotificationAndroidActionBundle.getString("icon");
    }

    public NotificationAndroidPressActionModel getPressAction() {
        return NotificationAndroidPressActionModel.fromBundle(this.mNotificationAndroidActionBundle.getBundle("pressAction"));
    }

    public RemoteInput getRemoteInput(NotificationCompat.Action.Builder builder) {
        if (!this.mNotificationAndroidActionBundle.containsKey("input")) {
            return null;
        }
        Bundle bundle = this.mNotificationAndroidActionBundle.getBundle("input");
        Objects.requireNonNull(bundle);
        RemoteInput.Builder builder2 = new RemoteInput.Builder("app.notifee.core.ReceiverService.REMOTE_INPUT_RECEIVER_KEY");
        if (bundle.containsKey("allowFreeFormInput")) {
            builder2.setAllowFreeFormInput(bundle.getBoolean("allowFreeFormInput"));
        }
        if (bundle.containsKey("allowGeneratedReplies")) {
            builder.setAllowGeneratedReplies(bundle.getBoolean("allowGeneratedReplies"));
        }
        if (bundle.containsKey("placeholder")) {
            builder2.setLabel(bundle.getCharSequence("placeholder"));
        }
        if (bundle.containsKey("choices")) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("choices");
            Objects.requireNonNull(stringArrayList);
            builder2.setChoices((CharSequence[]) stringArrayList.toArray(new CharSequence[stringArrayList.size()]));
        }
        if (bundle.containsKey("editableChoices")) {
            if (bundle.getBoolean("editableChoices")) {
                builder2.setEditChoicesBeforeSending(2);
            } else {
                builder2.setEditChoicesBeforeSending(1);
            }
        } else {
            builder2.setEditChoicesBeforeSending(0);
        }
        return builder2.build();
    }
}
