package expo.modules.speechrecognition;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lexpo/modules/speechrecognition/GetSupportedLocaleOptions;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "androidRecognitionServicePackage", "", "getAndroidRecognitionServicePackage$annotations", "getAndroidRecognitionServicePackage", "()Ljava/lang/String;", "expo-speech-recognition_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetSupportedLocaleOptions implements Record {
    private final String androidRecognitionServicePackage;

    @Field
    public static /* synthetic */ void getAndroidRecognitionServicePackage$annotations() {
    }

    public final String getAndroidRecognitionServicePackage() {
        return this.androidRecognitionServicePackage;
    }
}
