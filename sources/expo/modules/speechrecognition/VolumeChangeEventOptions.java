package expo.modules.speechrecognition;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lexpo/modules/speechrecognition/VolumeChangeEventOptions;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "enabled", "", "getEnabled$annotations", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "intervalMillis", "", "getIntervalMillis$annotations", "getIntervalMillis", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "expo-speech-recognition_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VolumeChangeEventOptions implements Record {
    private final Boolean enabled = Boolean.FALSE;
    private final Integer intervalMillis;

    @Field
    public static /* synthetic */ void getEnabled$annotations() {
    }

    @Field
    public static /* synthetic */ void getIntervalMillis$annotations() {
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final Integer getIntervalMillis() {
        return this.intervalMillis;
    }
}
