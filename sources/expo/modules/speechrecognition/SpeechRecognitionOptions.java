package expo.modules.speechrecognition;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0016R,\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\t\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010#R(\u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\t\u0012\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010\b\"\u0004\b'\u0010#R2\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020*\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b+\u0010\u0003\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u0003\u001a\u0004\b2\u0010\u000eR\u001e\u00103\u001a\u0004\u0018\u0001048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u0003\u001a\u0004\b6\u00107R\u001e\u00108\u001a\u0004\u0018\u0001098\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u0003\u001a\u0004\b;\u0010<R\u001e\u0010=\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010\u0003\u001a\u0004\b?\u0010\u000eR\u001e\u0010@\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010\u0003\u001a\u0004\bB\u0010\u000eR*\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020*\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010\u0003\u001a\u0004\bE\u0010-R\u001e\u0010F\u001a\u0004\u0018\u00010G8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bH\u0010\u0003\u001a\u0004\bI\u0010JR \u0010K\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\bL\u0010\u0003\u001a\u0004\bM\u0010\b¨\u0006N"}, d2 = {"Lexpo/modules/speechrecognition/SpeechRecognitionOptions;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "interimResults", "", "getInterimResults$annotations", "getInterimResults", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "lang", "", "getLang$annotations", "getLang", "()Ljava/lang/String;", "continuous", "getContinuous$annotations", "getContinuous", "maxAlternatives", "", "getMaxAlternatives$annotations", "getMaxAlternatives", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "contextualStrings", "", "getContextualStrings$annotations", "getContextualStrings", "()Ljava/util/List;", "setContextualStrings", "(Ljava/util/List;)V", "requiresOnDeviceRecognition", "getRequiresOnDeviceRecognition$annotations", "getRequiresOnDeviceRecognition", "setRequiresOnDeviceRecognition", "(Ljava/lang/Boolean;)V", "addsPunctuation", "getAddsPunctuation$annotations", "getAddsPunctuation", "setAddsPunctuation", "androidIntentOptions", "", "", "getAndroidIntentOptions$annotations", "getAndroidIntentOptions", "()Ljava/util/Map;", "setAndroidIntentOptions", "(Ljava/util/Map;)V", "androidRecognitionServicePackage", "getAndroidRecognitionServicePackage$annotations", "getAndroidRecognitionServicePackage", "audioSource", "Lexpo/modules/speechrecognition/AudioSourceOptions;", "getAudioSource$annotations", "getAudioSource", "()Lexpo/modules/speechrecognition/AudioSourceOptions;", "recordingOptions", "Lexpo/modules/speechrecognition/RecordingOptions;", "getRecordingOptions$annotations", "getRecordingOptions", "()Lexpo/modules/speechrecognition/RecordingOptions;", "androidIntent", "getAndroidIntent$annotations", "getAndroidIntent", "iosTaskHint", "getIosTaskHint$annotations", "getIosTaskHint", "iosCategory", "getIosCategory$annotations", "getIosCategory", "volumeChangeEventOptions", "Lexpo/modules/speechrecognition/VolumeChangeEventOptions;", "getVolumeChangeEventOptions$annotations", "getVolumeChangeEventOptions", "()Lexpo/modules/speechrecognition/VolumeChangeEventOptions;", "iosVoiceProcessingEnabled", "getIosVoiceProcessingEnabled$annotations", "getIosVoiceProcessingEnabled", "expo-speech-recognition_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechRecognitionOptions implements Record {
    private Boolean addsPunctuation;
    private final String androidIntent;
    private Map<String, ? extends Object> androidIntentOptions;
    private final String androidRecognitionServicePackage;
    private final AudioSourceOptions audioSource;
    private List<String> contextualStrings;
    private final Boolean continuous;
    private final Boolean interimResults;
    private final Map<String, Object> iosCategory;
    private final String iosTaskHint;
    private final Boolean iosVoiceProcessingEnabled;
    private final String lang;
    private final Integer maxAlternatives;
    private final RecordingOptions recordingOptions;
    private Boolean requiresOnDeviceRecognition;
    private final VolumeChangeEventOptions volumeChangeEventOptions;

    @Field
    public static /* synthetic */ void getAddsPunctuation$annotations() {
    }

    @Field
    public static /* synthetic */ void getAndroidIntent$annotations() {
    }

    @Field
    public static /* synthetic */ void getAndroidIntentOptions$annotations() {
    }

    @Field
    public static /* synthetic */ void getAndroidRecognitionServicePackage$annotations() {
    }

    @Field
    public static /* synthetic */ void getAudioSource$annotations() {
    }

    @Field
    public static /* synthetic */ void getContextualStrings$annotations() {
    }

    @Field
    public static /* synthetic */ void getContinuous$annotations() {
    }

    @Field
    public static /* synthetic */ void getInterimResults$annotations() {
    }

    @Field
    public static /* synthetic */ void getIosCategory$annotations() {
    }

    @Field
    public static /* synthetic */ void getIosTaskHint$annotations() {
    }

    @Field
    public static /* synthetic */ void getIosVoiceProcessingEnabled$annotations() {
    }

    @Field
    public static /* synthetic */ void getLang$annotations() {
    }

    @Field
    public static /* synthetic */ void getMaxAlternatives$annotations() {
    }

    @Field
    public static /* synthetic */ void getRecordingOptions$annotations() {
    }

    @Field
    public static /* synthetic */ void getRequiresOnDeviceRecognition$annotations() {
    }

    @Field
    public static /* synthetic */ void getVolumeChangeEventOptions$annotations() {
    }

    public SpeechRecognitionOptions() {
        Boolean bool = Boolean.FALSE;
        this.interimResults = bool;
        this.lang = "en-US";
        this.continuous = bool;
        this.maxAlternatives = 5;
        this.requiresOnDeviceRecognition = bool;
        this.addsPunctuation = bool;
        this.androidIntent = "android.speech.action.RECOGNIZE_SPEECH";
        this.iosVoiceProcessingEnabled = bool;
    }

    public final Boolean getInterimResults() {
        return this.interimResults;
    }

    public final String getLang() {
        return this.lang;
    }

    public final Boolean getContinuous() {
        return this.continuous;
    }

    public final Integer getMaxAlternatives() {
        return this.maxAlternatives;
    }

    public final List<String> getContextualStrings() {
        return this.contextualStrings;
    }

    public final void setContextualStrings(List<String> list) {
        this.contextualStrings = list;
    }

    public final Boolean getRequiresOnDeviceRecognition() {
        return this.requiresOnDeviceRecognition;
    }

    public final void setRequiresOnDeviceRecognition(Boolean bool) {
        this.requiresOnDeviceRecognition = bool;
    }

    public final Boolean getAddsPunctuation() {
        return this.addsPunctuation;
    }

    public final void setAddsPunctuation(Boolean bool) {
        this.addsPunctuation = bool;
    }

    public final Map<String, Object> getAndroidIntentOptions() {
        return this.androidIntentOptions;
    }

    public final void setAndroidIntentOptions(Map<String, ? extends Object> map) {
        this.androidIntentOptions = map;
    }

    public final String getAndroidRecognitionServicePackage() {
        return this.androidRecognitionServicePackage;
    }

    public final AudioSourceOptions getAudioSource() {
        return this.audioSource;
    }

    public final RecordingOptions getRecordingOptions() {
        return this.recordingOptions;
    }

    public final String getAndroidIntent() {
        return this.androidIntent;
    }

    public final String getIosTaskHint() {
        return this.iosTaskHint;
    }

    public final Map<String, Object> getIosCategory() {
        return this.iosCategory;
    }

    public final VolumeChangeEventOptions getVolumeChangeEventOptions() {
        return this.volumeChangeEventOptions;
    }

    public final Boolean getIosVoiceProcessingEnabled() {
        return this.iosVoiceProcessingEnabled;
    }
}
