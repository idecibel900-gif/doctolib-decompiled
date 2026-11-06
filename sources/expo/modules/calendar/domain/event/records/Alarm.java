package expo.modules.calendar.domain.event.records;

import com.opentok.android.PublisherKit;
import expo.modules.calendar.domain.event.enums.AlarmMethod;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lexpo/modules/calendar/domain/event/records/Alarm;", "Lexpo/modules/kotlin/records/Record;", "relativeOffset", "", "method", "Lexpo/modules/calendar/domain/event/enums/AlarmMethod;", "<init>", "(Ljava/lang/Integer;Lexpo/modules/calendar/domain/event/enums/AlarmMethod;)V", "getRelativeOffset$annotations", "()V", "getRelativeOffset", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMethod$annotations", "getMethod", "()Lexpo/modules/calendar/domain/event/enums/AlarmMethod;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lexpo/modules/calendar/domain/event/enums/AlarmMethod;)Lexpo/modules/calendar/domain/event/records/Alarm;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Alarm implements Record {
    private final AlarmMethod method;
    private final Integer relativeOffset;

    public static /* synthetic */ Alarm copy$default(Alarm alarm, Integer num, AlarmMethod alarmMethod, int i, Object obj) {
        if ((i & 1) != 0) {
            num = alarm.relativeOffset;
        }
        if ((i & 2) != 0) {
            alarmMethod = alarm.method;
        }
        return alarm.copy(num, alarmMethod);
    }

    @Field
    public static /* synthetic */ void getMethod$annotations() {
    }

    @Field
    public static /* synthetic */ void getRelativeOffset$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getRelativeOffset() {
        return this.relativeOffset;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AlarmMethod getMethod() {
        return this.method;
    }

    public final Alarm copy(Integer relativeOffset, AlarmMethod method) {
        return new Alarm(relativeOffset, method);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Alarm)) {
            return false;
        }
        Alarm alarm = (Alarm) other;
        return Intrinsics.areEqual(this.relativeOffset, alarm.relativeOffset) && this.method == alarm.method;
    }

    public int hashCode() {
        Integer num = this.relativeOffset;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        AlarmMethod alarmMethod = this.method;
        return iHashCode + (alarmMethod != null ? alarmMethod.hashCode() : 0);
    }

    public String toString() {
        return "Alarm(relativeOffset=" + this.relativeOffset + ", method=" + this.method + ")";
    }

    public Alarm(Integer num, AlarmMethod alarmMethod) {
        this.relativeOffset = num;
        this.method = alarmMethod;
    }

    public final Integer getRelativeOffset() {
        return this.relativeOffset;
    }

    public final AlarmMethod getMethod() {
        return this.method;
    }
}
