package com.adjust.sdk;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityState implements Serializable, Cloneable {
    private static final int EVENT_DEDUPLICATION_IDS_MAX_SIZE = 10;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 9039439291143138148L;
    private transient ILogger logger = AdjustFactory.getLogger();
    protected String uuid = Util.createUuid();
    protected boolean enabled = true;
    protected boolean isGdprForgotten = false;
    protected boolean isThirdPartySharingDisabledForCoppa = false;
    protected boolean askingAttribution = false;
    protected int eventCount = 0;
    protected int sessionCount = 0;
    protected int subsessionCount = -1;
    protected long sessionLength = -1;
    protected long timeSpent = -1;
    protected long lastActivity = -1;
    protected long lastInterval = -1;
    protected LinkedList<String> orderIds = null;
    protected String pushToken = null;
    protected String adid = null;
    protected long clickTime = 0;
    protected long installBegin = 0;
    protected String installReferrer = null;
    protected Boolean googlePlayInstant = null;
    protected long clickTimeServer = 0;
    protected long installBeginServer = 0;
    protected String installVersion = null;
    protected long clickTimeHuawei = 0;
    protected long installBeginHuawei = 0;
    protected String installReferrerHuawei = null;
    protected String installReferrerHuaweiAppGallery = null;
    protected long clickTimeXiaomi = 0;
    protected long installBeginXiaomi = 0;
    protected String installReferrerXiaomi = null;
    protected long clickTimeServerXiaomi = 0;
    protected long installBeginServerXiaomi = 0;
    protected String installVersionXiaomi = null;
    protected long clickTimeSamsung = 0;
    protected long installBeginSamsung = 0;
    protected String installReferrerSamsung = null;
    protected long clickTimeVivo = 0;
    protected long installBeginVivo = 0;
    protected String installReferrerVivo = null;
    protected String installVersionVivo = null;
    protected String installReferrerMeta = null;
    protected long clickTimeMeta = 0;
    protected Boolean isClickMeta = null;
    protected int eventDeduplicationIdsMaxSize = 10;

    static {
        ObjectStreamField objectStreamField = new ObjectStreamField("uuid", String.class);
        Class cls = Boolean.TYPE;
        ObjectStreamField objectStreamField2 = new ObjectStreamField("enabled", cls);
        ObjectStreamField objectStreamField3 = new ObjectStreamField("isGdprForgotten", cls);
        ObjectStreamField objectStreamField4 = new ObjectStreamField("askingAttribution", cls);
        Class cls2 = Integer.TYPE;
        ObjectStreamField objectStreamField5 = new ObjectStreamField("eventCount", cls2);
        ObjectStreamField objectStreamField6 = new ObjectStreamField("sessionCount", cls2);
        ObjectStreamField objectStreamField7 = new ObjectStreamField("subsessionCount", cls2);
        Class cls3 = Long.TYPE;
        serialPersistentFields = new ObjectStreamField[]{objectStreamField, objectStreamField2, objectStreamField3, objectStreamField4, objectStreamField5, objectStreamField6, objectStreamField7, new ObjectStreamField("sessionLength", cls3), new ObjectStreamField("timeSpent", cls3), new ObjectStreamField("lastActivity", cls3), new ObjectStreamField("lastInterval", cls3), new ObjectStreamField("orderIds", LinkedList.class), new ObjectStreamField("pushToken", String.class), new ObjectStreamField("adid", String.class), new ObjectStreamField("clickTime", cls3), new ObjectStreamField("installBegin", cls3), new ObjectStreamField("installReferrer", String.class), new ObjectStreamField("googlePlayInstant", Boolean.class), new ObjectStreamField("clickTimeServer", cls3), new ObjectStreamField("installBeginServer", cls3), new ObjectStreamField("installVersion", String.class), new ObjectStreamField("clickTimeHuawei", cls3), new ObjectStreamField("installBeginHuawei", cls3), new ObjectStreamField("installReferrerHuawei", String.class), new ObjectStreamField("installReferrerHuaweiAppGallery", String.class), new ObjectStreamField("isThirdPartySharingDisabledForCoppa", cls), new ObjectStreamField("clickTimeXiaomi", cls3), new ObjectStreamField("installBeginXiaomi", cls3), new ObjectStreamField("installReferrerXiaomi", String.class), new ObjectStreamField("clickTimeServerXiaomi", cls3), new ObjectStreamField("installBeginServerXiaomi", cls3), new ObjectStreamField("installVersionXiaomi", String.class), new ObjectStreamField("clickTimeSamsung", cls3), new ObjectStreamField("installBeginSamsung", cls3), new ObjectStreamField("installReferrerSamsung", String.class), new ObjectStreamField("clickTimeVivo", cls3), new ObjectStreamField("installBeginVivo", cls3), new ObjectStreamField("installReferrerVivo", String.class), new ObjectStreamField("installVersionVivo", String.class), new ObjectStreamField("installReferrerMeta", String.class), new ObjectStreamField("clickTimeMeta", cls3), new ObjectStreamField("isClickMeta", Boolean.class)};
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        ObjectInputStream.GetField fields = objectInputStream.readFields();
        this.eventCount = Util.readIntField(fields, "eventCount", 0);
        this.sessionCount = Util.readIntField(fields, "sessionCount", 0);
        this.subsessionCount = Util.readIntField(fields, "subsessionCount", -1);
        this.sessionLength = Util.readLongField(fields, "sessionLength", -1L);
        this.timeSpent = Util.readLongField(fields, "timeSpent", -1L);
        this.lastActivity = Util.readLongField(fields, "lastActivity", -1L);
        this.lastInterval = Util.readLongField(fields, "lastInterval", -1L);
        this.uuid = Util.readStringField(fields, "uuid", null);
        this.enabled = Util.readBooleanField(fields, "enabled", true);
        this.isGdprForgotten = Util.readBooleanField(fields, "isGdprForgotten", false);
        this.isThirdPartySharingDisabledForCoppa = Util.readBooleanField(fields, "isThirdPartySharingDisabledForCoppa", false);
        this.askingAttribution = Util.readBooleanField(fields, "askingAttribution", false);
        this.orderIds = (LinkedList) Util.readObjectField(fields, "orderIds", null);
        this.pushToken = Util.readStringField(fields, "pushToken", null);
        this.adid = Util.readStringField(fields, "adid", null);
        this.clickTime = Util.readLongField(fields, "clickTime", -1L);
        this.installBegin = Util.readLongField(fields, "installBegin", -1L);
        this.installReferrer = Util.readStringField(fields, "installReferrer", null);
        this.googlePlayInstant = (Boolean) Util.readObjectField(fields, "googlePlayInstant", null);
        this.clickTimeServer = Util.readLongField(fields, "clickTimeServer", -1L);
        this.installBeginServer = Util.readLongField(fields, "installBeginServer", -1L);
        this.installVersion = Util.readStringField(fields, "installVersion", null);
        this.clickTimeHuawei = Util.readLongField(fields, "clickTimeHuawei", -1L);
        this.installBeginHuawei = Util.readLongField(fields, "installBeginHuawei", -1L);
        this.installReferrerHuawei = Util.readStringField(fields, "installReferrerHuawei", null);
        this.installReferrerHuaweiAppGallery = Util.readStringField(fields, "installReferrerHuaweiAppGallery", null);
        this.clickTimeXiaomi = Util.readLongField(fields, "clickTimeXiaomi", -1L);
        this.installBeginXiaomi = Util.readLongField(fields, "installBeginXiaomi", -1L);
        this.installReferrerXiaomi = Util.readStringField(fields, "installReferrerXiaomi", null);
        this.clickTimeServerXiaomi = Util.readLongField(fields, "clickTimeServerXiaomi", -1L);
        this.installBeginServerXiaomi = Util.readLongField(fields, "installBeginServerXiaomi", -1L);
        this.installVersionXiaomi = Util.readStringField(fields, "installVersionXiaomi", null);
        this.clickTimeSamsung = Util.readLongField(fields, "clickTimeSamsung", -1L);
        this.installBeginSamsung = Util.readLongField(fields, "installBeginSamsung", -1L);
        this.installReferrerSamsung = Util.readStringField(fields, "installReferrerSamsung", null);
        this.clickTimeVivo = Util.readLongField(fields, "clickTimeVivo", -1L);
        this.installBeginVivo = Util.readLongField(fields, "installBeginVivo", -1L);
        this.installReferrerVivo = Util.readStringField(fields, "installReferrerVivo", null);
        this.installVersionVivo = Util.readStringField(fields, "installVersionVivo", null);
        this.installReferrerMeta = Util.readStringField(fields, "installReferrerMeta", null);
        this.clickTimeMeta = Util.readLongField(fields, "clickTimeMeta", -1L);
        this.isClickMeta = (Boolean) Util.readObjectField(fields, "isClickMeta", null);
        if (this.uuid == null) {
            this.uuid = Util.createUuid();
        }
        this.eventDeduplicationIdsMaxSize = 10;
    }

    private static String stamp(long j) {
        Calendar.getInstance().setTimeInMillis(j);
        return Util.formatString("%02d:%02d:%02d", 11, 12, 13);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public void addDeduplicationId(String str) {
        if (this.eventDeduplicationIdsMaxSize == 0) {
            return;
        }
        if (this.orderIds == null) {
            this.orderIds = new LinkedList<>();
        } else {
            while (this.orderIds.size() >= this.eventDeduplicationIdsMaxSize) {
                this.orderIds.removeLast();
            }
        }
        this.orderIds.addFirst(str);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityState activityState = (ActivityState) obj;
        return Util.equalString(this.uuid, activityState.uuid) && Util.equalBoolean(Boolean.valueOf(this.enabled), Boolean.valueOf(activityState.enabled)) && Util.equalBoolean(Boolean.valueOf(this.isGdprForgotten), Boolean.valueOf(activityState.isGdprForgotten)) && Util.equalBoolean(Boolean.valueOf(this.isThirdPartySharingDisabledForCoppa), Boolean.valueOf(activityState.isThirdPartySharingDisabledForCoppa)) && Util.equalBoolean(Boolean.valueOf(this.askingAttribution), Boolean.valueOf(activityState.askingAttribution)) && Util.equalInt(Integer.valueOf(this.eventCount), Integer.valueOf(activityState.eventCount)) && Util.equalInt(Integer.valueOf(this.sessionCount), Integer.valueOf(activityState.sessionCount)) && Util.equalInt(Integer.valueOf(this.subsessionCount), Integer.valueOf(activityState.subsessionCount)) && Util.equalLong(Long.valueOf(this.sessionLength), Long.valueOf(activityState.sessionLength)) && Util.equalLong(Long.valueOf(this.timeSpent), Long.valueOf(activityState.timeSpent)) && Util.equalLong(Long.valueOf(this.lastInterval), Long.valueOf(activityState.lastInterval)) && Util.equalObject(this.orderIds, activityState.orderIds) && Util.equalString(this.pushToken, activityState.pushToken) && Util.equalString(this.adid, activityState.adid) && Util.equalLong(Long.valueOf(this.clickTime), Long.valueOf(activityState.clickTime)) && Util.equalLong(Long.valueOf(this.installBegin), Long.valueOf(activityState.installBegin)) && Util.equalString(this.installReferrer, activityState.installReferrer) && Util.equalBoolean(this.googlePlayInstant, activityState.googlePlayInstant) && Util.equalLong(Long.valueOf(this.clickTimeServer), Long.valueOf(activityState.clickTimeServer)) && Util.equalLong(Long.valueOf(this.installBeginServer), Long.valueOf(activityState.installBeginServer)) && Util.equalString(this.installVersion, activityState.installVersion) && Util.equalLong(Long.valueOf(this.clickTimeHuawei), Long.valueOf(activityState.clickTimeHuawei)) && Util.equalLong(Long.valueOf(this.installBeginHuawei), Long.valueOf(activityState.installBeginHuawei)) && Util.equalString(this.installReferrerHuawei, activityState.installReferrerHuawei) && Util.equalString(this.installReferrerHuaweiAppGallery, activityState.installReferrerHuaweiAppGallery) && Util.equalLong(Long.valueOf(this.clickTimeXiaomi), Long.valueOf(activityState.clickTimeXiaomi)) && Util.equalLong(Long.valueOf(this.installBeginXiaomi), Long.valueOf(activityState.installBeginXiaomi)) && Util.equalString(this.installReferrerXiaomi, activityState.installReferrerXiaomi) && Util.equalLong(Long.valueOf(this.clickTimeServerXiaomi), Long.valueOf(activityState.clickTimeServerXiaomi)) && Util.equalLong(Long.valueOf(this.installBeginServerXiaomi), Long.valueOf(activityState.installBeginServerXiaomi)) && Util.equalString(this.installVersionXiaomi, activityState.installVersionXiaomi) && Util.equalLong(Long.valueOf(this.clickTimeSamsung), Long.valueOf(activityState.clickTimeSamsung)) && Util.equalLong(Long.valueOf(this.installBeginSamsung), Long.valueOf(activityState.installBeginSamsung)) && Util.equalString(this.installReferrerSamsung, activityState.installReferrerSamsung) && Util.equalLong(Long.valueOf(this.clickTimeVivo), Long.valueOf(activityState.clickTimeVivo)) && Util.equalLong(Long.valueOf(this.installBeginVivo), Long.valueOf(activityState.installBeginVivo)) && Util.equalString(this.installReferrerVivo, activityState.installReferrerVivo) && Util.equalString(this.installVersionVivo, activityState.installVersionVivo) && Util.equalString(this.installReferrerMeta, activityState.installReferrerMeta) && Util.equalLong(Long.valueOf(this.clickTimeMeta), Long.valueOf(activityState.clickTimeMeta)) && Util.equalBoolean(this.isClickMeta, activityState.isClickMeta);
    }

    public boolean eventDeduplicationIdExists(String str) {
        LinkedList<String> linkedList = this.orderIds;
        if (linkedList == null) {
            return false;
        }
        return linkedList.contains(str);
    }

    public int hashCode() {
        return Util.hashBoolean(this.isClickMeta, Util.hashLong(Long.valueOf(this.clickTimeMeta), Util.hashString(this.installReferrerMeta, Util.hashString(this.installVersionVivo, Util.hashString(this.installReferrerVivo, Util.hashLong(Long.valueOf(this.installBeginVivo), Util.hashLong(Long.valueOf(this.clickTimeVivo), Util.hashString(this.installReferrerSamsung, Util.hashLong(Long.valueOf(this.installBeginSamsung), Util.hashLong(Long.valueOf(this.clickTimeSamsung), Util.hashString(this.installVersionXiaomi, Util.hashLong(Long.valueOf(this.installBeginServerXiaomi), Util.hashLong(Long.valueOf(this.clickTimeServerXiaomi), Util.hashString(this.installReferrerXiaomi, Util.hashLong(Long.valueOf(this.installBeginXiaomi), Util.hashLong(Long.valueOf(this.clickTimeXiaomi), Util.hashString(this.installReferrerHuaweiAppGallery, Util.hashString(this.installReferrerHuawei, Util.hashLong(Long.valueOf(this.installBeginHuawei), Util.hashLong(Long.valueOf(this.clickTimeHuawei), Util.hashString(this.installVersion, Util.hashLong(Long.valueOf(this.installBeginServer), Util.hashLong(Long.valueOf(this.clickTimeServer), Util.hashBoolean(this.googlePlayInstant, Util.hashString(this.installReferrer, Util.hashLong(Long.valueOf(this.installBegin), Util.hashLong(Long.valueOf(this.clickTime), Util.hashString(this.adid, Util.hashString(this.pushToken, Util.hashObject(this.orderIds, Util.hashLong(Long.valueOf(this.lastInterval), Util.hashLong(Long.valueOf(this.timeSpent), Util.hashLong(Long.valueOf(this.sessionLength), (((((Util.hashBoolean(Boolean.valueOf(this.askingAttribution), Util.hashBoolean(Boolean.valueOf(this.isThirdPartySharingDisabledForCoppa), Util.hashBoolean(Boolean.valueOf(this.isGdprForgotten), Util.hashBoolean(Boolean.valueOf(this.enabled), Util.hashString(this.uuid, 17))))) * 37) + this.eventCount) * 37) + this.sessionCount) * 37) + this.subsessionCount)))))))))))))))))))))))))))))))));
    }

    public void resetSessionAttributes(long j) {
        this.subsessionCount = 1;
        this.sessionLength = 0L;
        this.timeSpent = 0L;
        this.lastActivity = j;
        this.lastInterval = -1L;
    }

    public void setEventDeduplicationIdsMaxSize(Integer num) {
        if (num == null || num.intValue() < 0) {
            return;
        }
        this.eventDeduplicationIdsMaxSize = num.intValue();
    }

    public String toString() {
        return Util.formatString("ec:%d sc:%d ssc:%d sl:%.1f ts:%.1f la:%s uuid:%s", Integer.valueOf(this.eventCount), Integer.valueOf(this.sessionCount), Integer.valueOf(this.subsessionCount), Double.valueOf(this.sessionLength / 1000.0d), Double.valueOf(this.timeSpent / 1000.0d), stamp(this.lastActivity), this.uuid);
    }
}
