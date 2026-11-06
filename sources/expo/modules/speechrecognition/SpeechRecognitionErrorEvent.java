package expo.modules.speechrecognition;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SpeechRecognitionErrorEvent {
    private final String error;
    private final String message;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpeechRecognitionErrorEvent)) {
            return false;
        }
        SpeechRecognitionErrorEvent speechRecognitionErrorEvent = (SpeechRecognitionErrorEvent) obj;
        return Intrinsics.areEqual(this.error, speechRecognitionErrorEvent.error) && Intrinsics.areEqual(this.message, speechRecognitionErrorEvent.message);
    }

    public int hashCode() {
        return (this.error.hashCode() * 31) + this.message.hashCode();
    }

    public String toString() {
        return "SpeechRecognitionErrorEvent(error=" + this.error + ", message=" + this.message + ")";
    }

    public SpeechRecognitionErrorEvent(String error, String message) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(message, "message");
        this.error = error;
        this.message = message;
    }

    public final String getError() {
        return this.error;
    }

    public final String getMessage() {
        return this.message;
    }
}
