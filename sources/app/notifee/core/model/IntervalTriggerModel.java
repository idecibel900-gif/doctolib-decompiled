package app.notifee.core.model;

import android.os.Bundle;
import app.notifee.core.Logger;
import app.notifee.core.utility.BundleValueReader;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class IntervalTriggerModel {
    private Bundle mIntervalTriggerBundle;

    private IntervalTriggerModel(Bundle bundle) {
        this.mIntervalTriggerBundle = bundle;
    }

    public static IntervalTriggerModel fromBundle(Bundle bundle) {
        return new IntervalTriggerModel(bundle);
    }

    public TimeUnit getTimeUnit() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        if (this.mIntervalTriggerBundle.containsKey("timeUnit")) {
            String string = this.mIntervalTriggerBundle.getString("timeUnit");
            try {
                return TimeUnit.valueOf(string);
            } catch (IllegalArgumentException e) {
                Logger.e("IntervalTriggerModel", "An error occurred whilst trying to convert interval time unit: " + string, (Exception) e);
            }
        }
        return timeUnit;
    }

    public int getInterval() {
        return BundleValueReader.getIntPreserving(this.mIntervalTriggerBundle, "interval", -1);
    }
}
