package expo.modules.speechrecognition;

import android.content.Context;
import android.os.Handler;
import android.speech.RecognitionSupport;
import android.speech.RecognitionSupportCallback;
import android.speech.SpeechRecognizer;
import expo.modules.kotlin.Promise;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: loaded from: classes4.dex */
public final class ExpoSpeechRecognitionModule$getSupportedLocales$1$1 implements RecognitionSupportCallback {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ Ref$BooleanRef $didResolve;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ SpeechRecognizer $recognizer;

    ExpoSpeechRecognitionModule$getSupportedLocales$1$1(Ref$BooleanRef ref$BooleanRef, Promise promise, SpeechRecognizer speechRecognizer, Context context) {
        this.$didResolve = ref$BooleanRef;
        this.$promise = promise;
        this.$recognizer = speechRecognizer;
        this.$appContext = context;
    }

    public void onSupportResult(RecognitionSupport recognitionSupport) {
        Intrinsics.checkNotNullParameter(recognitionSupport, "recognitionSupport");
        Objects.toString(recognitionSupport);
        Ref$BooleanRef ref$BooleanRef = this.$didResolve;
        if (ref$BooleanRef.element) {
            return;
        }
        ref$BooleanRef.element = true;
        List<String> installedOnDeviceLanguages = recognitionSupport.getInstalledOnDeviceLanguages();
        Intrinsics.checkNotNullExpressionValue(installedOnDeviceLanguages, "getInstalledOnDeviceLanguages(...)");
        List<String> supportedOnDeviceLanguages = recognitionSupport.getSupportedOnDeviceLanguages();
        Intrinsics.checkNotNullExpressionValue(supportedOnDeviceLanguages, "getSupportedOnDeviceLanguages(...)");
        Set setUnion = CollectionsKt.union(supportedOnDeviceLanguages, installedOnDeviceLanguages);
        List<String> onlineLanguages = recognitionSupport.getOnlineLanguages();
        Intrinsics.checkNotNullExpressionValue(onlineLanguages, "getOnlineLanguages(...)");
        this.$promise.resolve(MapsKt.mapOf(TuplesKt.to("locales", CollectionsKt.sorted(CollectionsKt.union(setUnion, onlineLanguages))), TuplesKt.to("installedLocales", installedOnDeviceLanguages)));
        this.$recognizer.destroy();
    }

    public void onError(final int i) {
        Handler handler = new Handler(this.$appContext.getMainLooper());
        final Ref$BooleanRef ref$BooleanRef = this.$didResolve;
        final Promise promise = this.$promise;
        handler.postDelayed(new Runnable() { // from class: expo.modules.speechrecognition.ExpoSpeechRecognitionModule$getSupportedLocales$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ExpoSpeechRecognitionModule$getSupportedLocales$1$1.onError$lambda$0(ref$BooleanRef, promise, i);
            }
        }, 50L);
        this.$recognizer.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onError$lambda$0(Ref$BooleanRef ref$BooleanRef, Promise promise, int i) {
        if (ref$BooleanRef.element) {
            return;
        }
        promise.reject("error_" + i, "Failed to retrieve supported locales with error: " + i, new Throwable());
    }
}
