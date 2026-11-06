package expo.modules.video;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class VideoExceptionsKt {
    public static /* synthetic */ String getPlaybackServiceErrorMessage$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "Make sure that the expo-video config plugin is properly configured to avoid issues with displaying the now playing notification and sustaining background playback.";
        }
        return getPlaybackServiceErrorMessage(str, str2);
    }

    public static final String getPlaybackServiceErrorMessage(String str, String tip) {
        Intrinsics.checkNotNullParameter(tip, "tip");
        if (str == null) {
            str = "Expo-video playback service binder error";
        }
        return str + ". " + tip;
    }
}
