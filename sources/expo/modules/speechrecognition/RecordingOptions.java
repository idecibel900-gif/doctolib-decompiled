package expo.modules.speechrecognition;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\rR \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\r¨\u0006\u001a"}, d2 = {"Lexpo/modules/speechrecognition/RecordingOptions;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "persist", "", "getPersist$annotations", "getPersist", "()Z", "outputDirectory", "", "getOutputDirectory$annotations", "getOutputDirectory", "()Ljava/lang/String;", "outputFileName", "getOutputFileName$annotations", "getOutputFileName", "outputSampleRate", "", "getOutputSampleRate$annotations", "getOutputSampleRate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "outputEncoding", "getOutputEncoding$annotations", "getOutputEncoding", "expo-speech-recognition_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordingOptions implements Record {
    private final String outputDirectory;
    private final String outputEncoding;
    private final String outputFileName;
    private final Integer outputSampleRate;
    private final boolean persist;

    @Field
    public static /* synthetic */ void getOutputDirectory$annotations() {
    }

    @Field
    public static /* synthetic */ void getOutputEncoding$annotations() {
    }

    @Field
    public static /* synthetic */ void getOutputFileName$annotations() {
    }

    @Field
    public static /* synthetic */ void getOutputSampleRate$annotations() {
    }

    @Field
    public static /* synthetic */ void getPersist$annotations() {
    }

    public final boolean getPersist() {
        return this.persist;
    }

    public final String getOutputDirectory() {
        return this.outputDirectory;
    }

    public final String getOutputFileName() {
        return this.outputFileName;
    }

    public final Integer getOutputSampleRate() {
        return this.outputSampleRate;
    }

    public final String getOutputEncoding() {
        return this.outputEncoding;
    }
}
