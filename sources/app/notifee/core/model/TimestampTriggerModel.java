package app.notifee.core.model;

import android.os.Bundle;
import app.notifee.core.utility.BundleValueReader;
import app.notifee.core.utility.ObjectUtils;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class TimestampTriggerModel {
    private AlarmType mAlarmType;
    private int mInterval;
    private String mRepeatFrequency;
    private int mRepeatInterval;
    private Bundle mTimeTriggerBundle;
    private TimeUnit mTimeUnit;
    private Long mTimestamp;
    private Boolean mWithAlarmManager;

    public enum AlarmType {
        SET,
        SET_AND_ALLOW_WHILE_IDLE,
        SET_EXACT,
        SET_EXACT_AND_ALLOW_WHILE_IDLE,
        SET_ALARM_CLOCK
    }

    private TimestampTriggerModel(Bundle bundle) {
        this.mInterval = -1;
        this.mTimeUnit = null;
        this.mWithAlarmManager = Boolean.FALSE;
        AlarmType alarmType = AlarmType.SET_EXACT;
        this.mAlarmType = alarmType;
        this.mRepeatFrequency = null;
        this.mRepeatInterval = 1;
        this.mTimestamp = null;
        this.mTimeTriggerBundle = bundle;
        if (bundle.containsKey("repeatFrequency")) {
            int intPreserving = BundleValueReader.getIntPreserving(this.mTimeTriggerBundle, "repeatFrequency");
            this.mRepeatInterval = getRepeatInterval(BundleValueReader.getValue(this.mTimeTriggerBundle, "repeatInterval"));
            this.mTimestamp = Long.valueOf(BundleValueReader.getLongPreserving(this.mTimeTriggerBundle, DiagnosticsEntry.TIMESTAMP_KEY));
            if (intPreserving == 0) {
                this.mInterval = this.mRepeatInterval;
                this.mTimeUnit = TimeUnit.HOURS;
                this.mRepeatFrequency = "HOURLY";
            } else if (intPreserving == 1) {
                this.mInterval = this.mRepeatInterval;
                this.mTimeUnit = TimeUnit.DAYS;
                this.mRepeatFrequency = "DAILY";
            } else if (intPreserving == 2) {
                this.mInterval = this.mRepeatInterval * 7;
                this.mTimeUnit = TimeUnit.DAYS;
                this.mRepeatFrequency = "WEEKLY";
            } else if (intPreserving == 3) {
                this.mRepeatFrequency = "MONTHLY";
            }
        }
        if (this.mTimeTriggerBundle.containsKey("alarmManager")) {
            this.mWithAlarmManager = Boolean.TRUE;
            Bundle bundle2 = this.mTimeTriggerBundle.getBundle("alarmManager");
            Object value = BundleValueReader.getValue(bundle2, "type");
            int i = value != null ? ObjectUtils.getInt(value) : 3;
            if (bundle2.containsKey("allowWhileIdle") && bundle2.getBoolean("allowWhileIdle")) {
                i = 3;
            }
            if (i == 0) {
                this.mAlarmType = AlarmType.SET;
                return;
            }
            if (i == 1) {
                this.mAlarmType = AlarmType.SET_AND_ALLOW_WHILE_IDLE;
                return;
            }
            if (i == 3) {
                this.mAlarmType = AlarmType.SET_EXACT_AND_ALLOW_WHILE_IDLE;
                return;
            } else if (i != 4) {
                this.mAlarmType = alarmType;
                return;
            } else {
                this.mAlarmType = AlarmType.SET_ALARM_CLOCK;
                return;
            }
        }
        if (this.mTimeTriggerBundle.containsKey("allowWhileIdle")) {
            this.mWithAlarmManager = Boolean.TRUE;
            this.mAlarmType = AlarmType.SET_EXACT_AND_ALLOW_WHILE_IDLE;
        }
    }

    public static TimestampTriggerModel fromBundle(Bundle bundle) {
        return new TimestampTriggerModel(bundle);
    }

    public long getTimestamp() {
        return this.mTimestamp.longValue();
    }

    public long getDelay() {
        Long l = this.mTimestamp;
        if (l == null || l.longValue() <= 0) {
            return 0L;
        }
        return Math.round((this.mTimestamp.longValue() - System.currentTimeMillis()) / 1000.0d);
    }

    public void setNextTimestamp() {
        int i;
        if (this.mRepeatFrequency == null) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(getTimestamp());
        if ("HOURLY".equals(this.mRepeatFrequency)) {
            i = 11;
        } else if ("DAILY".equals(this.mRepeatFrequency)) {
            i = 5;
        } else if ("WEEKLY".equals(this.mRepeatFrequency)) {
            i = 3;
        } else if (!"MONTHLY".equals(this.mRepeatFrequency)) {
            return;
        } else {
            i = 2;
        }
        while (calendar.getTimeInMillis() < System.currentTimeMillis()) {
            calendar.add(i, this.mRepeatInterval);
        }
        this.mTimestamp = Long.valueOf(calendar.getTimeInMillis());
    }

    public int getInterval() {
        return this.mInterval;
    }

    public TimeUnit getTimeUnit() {
        return this.mTimeUnit;
    }

    public Boolean getWithAlarmManager() {
        return this.mWithAlarmManager;
    }

    public AlarmType getAlarmType() {
        return this.mAlarmType;
    }

    public String getRepeatFrequency() {
        return this.mRepeatFrequency;
    }

    private int getRepeatInterval(Object obj) {
        if (!(obj instanceof Number)) {
            return 1;
        }
        double dDoubleValue = ((Number) obj).doubleValue();
        if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue) || dDoubleValue <= 0.0d || dDoubleValue % 1.0d != 0.0d || dDoubleValue > 2.147483647E9d) {
            return 1;
        }
        return (int) dDoubleValue;
    }

    public Bundle toBundle() {
        Bundle bundle = (Bundle) this.mTimeTriggerBundle.clone();
        Long l = this.mTimestamp;
        if (l != null) {
            bundle.putLong(DiagnosticsEntry.TIMESTAMP_KEY, l.longValue());
        }
        return bundle;
    }
}
