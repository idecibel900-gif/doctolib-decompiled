package expo.modules.speechrecognition;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\rR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\rR \u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\rR \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001a\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lexpo/modules/speechrecognition/AudioSourceOptions;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "uri", "", "getUri$annotations", "getUri", "()Ljava/lang/String;", "audioEncoding", "", "getAudioEncoding$annotations", "getAudioEncoding", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "sampleRate", "getSampleRate$annotations", "getSampleRate", "audioChannels", "getAudioChannels$annotations", "getAudioChannels", "chunkDelayMillis", "", "getChunkDelayMillis$annotations", "getChunkDelayMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "expo-speech-recognition_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioSourceOptions implements Record {
    private final Long chunkDelayMillis;
    private final String uri = "";
    private final Integer audioEncoding = 2;
    private final Integer sampleRate = 16000;
    private final Integer audioChannels = 1;

    @Field
    public static /* synthetic */ void getAudioChannels$annotations() {
    }

    @Field
    public static /* synthetic */ void getAudioEncoding$annotations() {
    }

    @Field
    public static /* synthetic */ void getChunkDelayMillis$annotations() {
    }

    @Field
    public static /* synthetic */ void getSampleRate$annotations() {
    }

    @Field
    public static /* synthetic */ void getUri$annotations() {
    }

    public final String getUri() {
        return this.uri;
    }

    public final Integer getAudioEncoding() {
        return this.audioEncoding;
    }

    public final Integer getSampleRate() {
        return this.sampleRate;
    }

    public final Integer getAudioChannels() {
        return this.audioChannels;
    }

    public final Long getChunkDelayMillis() {
        return this.chunkDelayMillis;
    }
}
