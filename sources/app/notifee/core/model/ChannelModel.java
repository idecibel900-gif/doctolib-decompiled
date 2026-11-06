package app.notifee.core.model;

import android.graphics.Color;
import android.os.Bundle;
import app.notifee.core.utility.BundleValueReader;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ChannelModel {
    private final Bundle mChannelBundle;

    private ChannelModel(Bundle bundle) {
        this.mChannelBundle = bundle;
    }

    public static ChannelModel fromBundle(Bundle bundle) {
        return new ChannelModel(bundle);
    }

    public String getId() {
        String string = this.mChannelBundle.getString(DiagnosticsEntry.ID_KEY);
        Objects.requireNonNull(string);
        return string;
    }

    public String getName() {
        String string = this.mChannelBundle.getString("name");
        Objects.requireNonNull(string);
        return string;
    }

    public Boolean getBadge() {
        return Boolean.valueOf(this.mChannelBundle.getBoolean("badge", true));
    }

    public Boolean getBypassDnd() {
        return Boolean.valueOf(this.mChannelBundle.getBoolean("bypassDnd", false));
    }

    public String getDescription() {
        return this.mChannelBundle.getString(b.c);
    }

    public Boolean getLights() {
        return Boolean.valueOf(this.mChannelBundle.getBoolean("lights", true));
    }

    public Boolean getVibration() {
        return Boolean.valueOf(this.mChannelBundle.getBoolean("vibration", true));
    }

    public String getGroupId() {
        return this.mChannelBundle.getString("groupId");
    }

    public Integer getImportance() {
        return Integer.valueOf(BundleValueReader.getIntPreserving(this.mChannelBundle, "importance", 3));
    }

    public Integer getLightColor() {
        if (this.mChannelBundle.containsKey("lightColor")) {
            return Integer.valueOf(Color.parseColor(this.mChannelBundle.getString("lightColor")));
        }
        return null;
    }

    public int getVisibility() {
        return BundleValueReader.getIntPreserving(this.mChannelBundle, "visibility", 0);
    }

    public long[] getVibrationPattern() {
        if (!this.mChannelBundle.containsKey("vibrationPattern")) {
            return new long[0];
        }
        ArrayList arrayListValue = BundleValueReader.getArrayListValue(this.mChannelBundle, "vibrationPattern");
        Objects.requireNonNull(arrayListValue);
        long[] jArr = new long[arrayListValue.size()];
        for (int i = 0; i < arrayListValue.size(); i++) {
            jArr[i] = ((Integer) arrayListValue.get(i)).longValue();
        }
        return jArr;
    }

    public String getSound() {
        if (this.mChannelBundle.containsKey("sound")) {
            return this.mChannelBundle.getString("sound");
        }
        return null;
    }
}
