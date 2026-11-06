package app.notifee.core.model;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Keep;
import app.notifee.core.Logger;
import app.notifee.core.utility.BundleValueReader;
import app.notifee.core.utility.ObjectUtils;
import app.notifee.core.utility.ParcelableCompatReader;
import app.notifee.core.utility.ResourceUtils;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class NotificationAndroidModel {
    private static final String TAG = "NotificationAndroidModel";
    private Bundle mNotificationAndroidBundle;

    private NotificationAndroidModel(Bundle bundle) {
        this.mNotificationAndroidBundle = bundle;
    }

    public static NotificationAndroidModel fromBundle(Bundle bundle) {
        return new NotificationAndroidModel(bundle);
    }

    public ArrayList<NotificationAndroidActionModel> getActions() {
        if (!this.mNotificationAndroidBundle.containsKey("actions")) {
            return null;
        }
        ArrayList parcelableArrayList = ParcelableCompatReader.getParcelableArrayList(this.mNotificationAndroidBundle, "actions", Bundle.class);
        Objects.requireNonNull(parcelableArrayList);
        ArrayList<NotificationAndroidActionModel> arrayList = new ArrayList<>(parcelableArrayList.size());
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(NotificationAndroidActionModel.fromBundle((Bundle) it.next()));
        }
        return arrayList;
    }

    public int getForegroundServiceType() {
        if (!this.mNotificationAndroidBundle.containsKey("foregroundServiceTypes")) {
            return -1;
        }
        ArrayList arrayListValue = BundleValueReader.getArrayListValue(this.mNotificationAndroidBundle, "foregroundServiceTypes");
        Objects.requireNonNull(arrayListValue);
        if (arrayListValue.isEmpty()) {
            Logger.w(TAG, "foregroundServiceTypes is empty; treating as absent");
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < arrayListValue.size(); i2++) {
            i |= ObjectUtils.getInt(arrayListValue.get(i2));
        }
        if (Build.VERSION.SDK_INT < 34 || i != 0) {
            return i;
        }
        return -1;
    }

    public Boolean getAsForegroundService() {
        return Boolean.valueOf(this.mNotificationAndroidBundle.getBoolean("asForegroundService", false));
    }

    public int getForegroundServiceBehavior() {
        return this.mNotificationAndroidBundle.getInt("foregroundServiceBehavior", 0);
    }

    public Boolean getLightUpScreen() {
        return Boolean.valueOf(this.mNotificationAndroidBundle.getBoolean("lightUpScreen", false));
    }

    public Boolean getAutoCancel() {
        return Boolean.valueOf(this.mNotificationAndroidBundle.getBoolean("autoCancel", false));
    }

    public Integer getBadgeIconType() {
        return Integer.valueOf(BundleValueReader.getIntPreserving(this.mNotificationAndroidBundle, "badgeIconType", 2));
    }

    public String getChannelId() {
        if (this.mNotificationAndroidBundle.containsKey("channelId")) {
            String string = this.mNotificationAndroidBundle.getString("channelId");
            Objects.requireNonNull(string);
            return string;
        }
        return "";
    }

    public String getCategory() {
        return this.mNotificationAndroidBundle.getString("category");
    }

    public Integer getColor() {
        if (this.mNotificationAndroidBundle.containsKey("color")) {
            return Integer.valueOf(Color.parseColor(this.mNotificationAndroidBundle.getString("color")));
        }
        return null;
    }

    public Boolean getColorized() {
        return Boolean.valueOf(this.mNotificationAndroidBundle.getBoolean("colorized", false));
    }

    public Boolean getChronometerCountDown() {
        if (this.mNotificationAndroidBundle.containsKey("chronometerDirection")) {
            String string = this.mNotificationAndroidBundle.getString("chronometerDirection");
            return Boolean.valueOf(string != null && string.equals("down"));
        }
        return Boolean.FALSE;
    }

    public Integer getDefaults(Boolean bool) {
        Integer numValueOf = 0;
        if (this.mNotificationAndroidBundle.containsKey("defaults")) {
            ArrayList<Integer> integerArrayList = this.mNotificationAndroidBundle.getIntegerArrayList("defaults");
            Objects.requireNonNull(integerArrayList);
            Iterator<Integer> it = integerArrayList.iterator();
            while (it.hasNext()) {
                numValueOf = Integer.valueOf(numValueOf.intValue() | it.next().intValue());
            }
        } else {
            numValueOf = -1;
        }
        if (bool.booleanValue()) {
            numValueOf = Integer.valueOf(numValueOf.intValue() & (-2));
        }
        if (!this.mNotificationAndroidBundle.containsKey("vibrationPattern")) {
            numValueOf = Integer.valueOf(numValueOf.intValue() & (-3));
        }
        return this.mNotificationAndroidBundle.containsKey("lights") ? Integer.valueOf(numValueOf.intValue() & (-5)) : numValueOf;
    }

    public String getTag() {
        return this.mNotificationAndroidBundle.getString("tag");
    }

    public String getGroup() {
        return this.mNotificationAndroidBundle.getString("groupId");
    }

    public int getGroupAlertBehaviour() {
        return BundleValueReader.getIntPreserving(this.mNotificationAndroidBundle, "groupAlertBehavior", 0);
    }

    public Boolean getGroupSummary() {
        return Boolean.valueOf(this.mNotificationAndroidBundle.getBoolean("groupSummary", false));
    }

    public CharSequence[] getInputHistory() {
        if (!this.mNotificationAndroidBundle.containsKey("inputHistory")) {
            return null;
        }
        ArrayList<String> stringArrayList = this.mNotificationAndroidBundle.getStringArrayList("inputHistory");
        Objects.requireNonNull(stringArrayList);
        return (CharSequence[]) stringArrayList.toArray(new CharSequence[stringArrayList.size()]);
    }

    public Boolean hasLargeIcon() {
        return Boolean.valueOf(this.mNotificationAndroidBundle.containsKey("largeIcon"));
    }

    public String getLargeIcon() {
        if (!hasLargeIcon().booleanValue()) {
            return null;
        }
        String string = this.mNotificationAndroidBundle.getString("largeIcon");
        Objects.requireNonNull(string);
        return string;
    }

    public Boolean getCircularLargeIcon() {
        return Boolean.valueOf(this.mNotificationAndroidBundle.getBoolean("circularLargeIcon", false));
    }

    public ArrayList<Integer> getLights() {
        if (this.mNotificationAndroidBundle.containsKey("lights")) {
            try {
                ArrayList arrayListValue = BundleValueReader.getArrayListValue(this.mNotificationAndroidBundle, "lights");
                Objects.requireNonNull(arrayListValue);
                String str = (String) arrayListValue.get(0);
                ArrayList<Integer> arrayList = new ArrayList<>(3);
                arrayList.add(Integer.valueOf(Color.parseColor(str)));
                arrayList.add((Integer) arrayListValue.get(1));
                arrayList.add((Integer) arrayListValue.get(2));
                return arrayList;
            } catch (Exception e) {
                Logger.e(TAG, "getLights -> Failed to parse lights", e);
            }
        }
        return null;
    }

    public Boolean getLocalOnly() {
        return Boolean.valueOf(this.mNotificationAndroidBundle.getBoolean("localOnly", false));
    }

    public Integer getNumber() {
        if (this.mNotificationAndroidBundle.containsKey("badgeCount")) {
            return Integer.valueOf(BundleValueReader.getIntPreserving(this.mNotificationAndroidBundle, "badgeCount"));
        }
        return null;
    }

    public Boolean getOngoing() {
        return Boolean.valueOf(this.mNotificationAndroidBundle.getBoolean("ongoing", false));
    }

    public Boolean getLoopSound() {
        return Boolean.valueOf(this.mNotificationAndroidBundle.getBoolean("loopSound", false));
    }

    public int[] getFlags() {
        if (!this.mNotificationAndroidBundle.containsKey("flags")) {
            return null;
        }
        ArrayList arrayListValue = BundleValueReader.getArrayListValue(this.mNotificationAndroidBundle, "flags");
        Objects.requireNonNull(arrayListValue);
        int[] iArr = new int[arrayListValue.size()];
        for (int i = 0; i < arrayListValue.size(); i++) {
            iArr[i] = ObjectUtils.getInt(arrayListValue.get(i));
        }
        return iArr;
    }

    public Boolean getOnlyAlertOnce() {
        return Boolean.valueOf(this.mNotificationAndroidBundle.getBoolean("onlyAlertOnce", false));
    }

    public Boolean hasFullScreenAction() {
        return Boolean.valueOf(this.mNotificationAndroidBundle.containsKey("fullScreenAction"));
    }

    public Bundle getPressAction() {
        return this.mNotificationAndroidBundle.getBundle("pressAction");
    }

    public NotificationAndroidPressActionModel getFullScreenAction() {
        if (hasFullScreenAction().booleanValue()) {
            return NotificationAndroidPressActionModel.fromBundle(this.mNotificationAndroidBundle.getBundle("fullScreenAction"));
        }
        return null;
    }

    public int getPriority() {
        if (!this.mNotificationAndroidBundle.containsKey("importance")) {
            return 0;
        }
        int intPreserving = BundleValueReader.getIntPreserving(this.mNotificationAndroidBundle, "importance", 3);
        if (intPreserving == 0) {
            return -2;
        }
        if (intPreserving != 1) {
            return intPreserving != 4 ? 0 : 1;
        }
        return -1;
    }

    public AndroidProgress getProgress() {
        if (!this.mNotificationAndroidBundle.containsKey(ReactProgressBarViewManager.PROP_PROGRESS)) {
            return null;
        }
        Bundle bundle = this.mNotificationAndroidBundle.getBundle(ReactProgressBarViewManager.PROP_PROGRESS);
        Objects.requireNonNull(bundle);
        return new AndroidProgress(BundleValueReader.getIntPreserving(bundle, "max"), BundleValueReader.getIntPreserving(bundle, "current"), bundle.getBoolean(ReactProgressBarViewManager.PROP_INDETERMINATE, false));
    }

    public String getShortcutId() {
        return this.mNotificationAndroidBundle.getString("shortcutId");
    }

    public Boolean getShowTimestamp() {
        return Boolean.valueOf(this.mNotificationAndroidBundle.getBoolean("showTimestamp", false));
    }

    public Integer getSmallIcon() {
        if (!this.mNotificationAndroidBundle.containsKey("smallIcon")) {
            return null;
        }
        String string = this.mNotificationAndroidBundle.getString("smallIcon");
        int imageResourceId = ResourceUtils.getImageResourceId(string);
        if (imageResourceId == 0) {
            Logger.w(TAG, String.format("Notification small icon '%s' could not be resolved; falling back to the app launcher icon. Common causes: asset only in src/debug/res, R8 resource shrinking, or name mismatch (names must be lowercase with underscores). See README Troubleshooting.", string));
            return null;
        }
        return Integer.valueOf(imageResourceId);
    }

    public Integer getSmallIconLevel() {
        if (this.mNotificationAndroidBundle.containsKey("smallIconLevel")) {
            return Integer.valueOf(this.mNotificationAndroidBundle.getInt("smallIconLevel"));
        }
        return null;
    }

    public String getSortKey() {
        return this.mNotificationAndroidBundle.getString("sortKey");
    }

    public Boolean hasStyle() {
        return Boolean.valueOf(this.mNotificationAndroidBundle.containsKey("style"));
    }

    public NotificationAndroidStyleModel getStyle() {
        if (hasStyle().booleanValue()) {
            return NotificationAndroidStyleModel.fromBundle(this.mNotificationAndroidBundle.getBundle("style"));
        }
        return null;
    }

    public String getTicker() {
        return this.mNotificationAndroidBundle.getString("ticker");
    }

    public Long getTimeoutAfter() {
        if (this.mNotificationAndroidBundle.containsKey("timeoutAfter")) {
            return Long.valueOf(BundleValueReader.getLongPreserving(this.mNotificationAndroidBundle, "timeoutAfter"));
        }
        return null;
    }

    public Boolean getShowChronometer() {
        return Boolean.valueOf(this.mNotificationAndroidBundle.getBoolean("showChronometer", false));
    }

    public String getSound() {
        if (this.mNotificationAndroidBundle.containsKey("sound")) {
            return this.mNotificationAndroidBundle.getString("sound");
        }
        return null;
    }

    public long[] getVibrationPattern() {
        if (!this.mNotificationAndroidBundle.containsKey("vibrationPattern")) {
            return new long[0];
        }
        ArrayList arrayListValue = BundleValueReader.getArrayListValue(this.mNotificationAndroidBundle, "vibrationPattern");
        Objects.requireNonNull(arrayListValue);
        long[] jArr = new long[arrayListValue.size()];
        for (int i = 0; i < arrayListValue.size(); i++) {
            jArr[i] = ((Integer) arrayListValue.get(i)).longValue();
        }
        return jArr;
    }

    public int getVisibility() {
        return BundleValueReader.getIntPreserving(this.mNotificationAndroidBundle, "visibility", 0);
    }

    public long getTimestamp() {
        return BundleValueReader.getLongPreserving(this.mNotificationAndroidBundle, DiagnosticsEntry.TIMESTAMP_KEY, -1L);
    }

    public static class AndroidProgress {
        int current;
        boolean indeterminate;
        int max;

        AndroidProgress(int i, int i2, boolean z) {
            this.max = i;
            this.current = i2;
            this.indeterminate = z;
        }

        public int getMax() {
            return this.max;
        }

        public int getCurrent() {
            return this.current;
        }

        public boolean getIndeterminate() {
            return this.indeterminate;
        }
    }
}
