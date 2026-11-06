package app.notifee.core.database;

/* JADX INFO: loaded from: classes3.dex */
public class WorkDataEntity {
    private String id;
    private byte[] notification;
    private byte[] trigger;
    private Boolean withAlarmManager;

    public WorkDataEntity(String str, byte[] bArr, byte[] bArr2, Boolean bool) {
        this.id = str;
        this.notification = bArr;
        this.trigger = bArr2;
        this.withAlarmManager = bool;
    }

    public String getId() {
        return this.id;
    }

    public byte[] getNotification() {
        return this.notification;
    }

    public byte[] getTrigger() {
        return this.trigger;
    }

    public Boolean getWithAlarmManager() {
        return this.withAlarmManager;
    }
}
