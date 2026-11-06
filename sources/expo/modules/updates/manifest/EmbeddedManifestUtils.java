package expo.modules.updates.manifest;

import android.content.Context;
import expo.modules.updates.UpdatesConfiguration;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class EmbeddedManifestUtils {
    public static final EmbeddedManifestUtils INSTANCE = new EmbeddedManifestUtils();
    private static final String TAG = EmbeddedManifestUtils.class.getSimpleName();
    private static EmbeddedUpdate sEmbeddedUpdate;

    private EmbeddedManifestUtils() {
    }

    public final EmbeddedUpdate getEmbeddedUpdate(Context context, UpdatesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (configuration.getHasEmbeddedUpdate()) {
            return getCachedEmbeddedUpdate(context, configuration);
        }
        return null;
    }

    public final EmbeddedUpdate getOriginalEmbeddedUpdate(Context context, UpdatesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (configuration.getOriginalHasEmbeddedUpdate()) {
            return getCachedEmbeddedUpdate(context, configuration);
        }
        return null;
    }

    private final EmbeddedUpdate getCachedEmbeddedUpdate(Context context, UpdatesConfiguration updatesConfiguration) {
        EmbeddedUpdate embeddedUpdate = sEmbeddedUpdate;
        if (embeddedUpdate != null) {
            return embeddedUpdate;
        }
        EmbeddedUpdate embeddedUpdateLoadEmbeddedUpdate = loadEmbeddedUpdate(context, updatesConfiguration);
        sEmbeddedUpdate = embeddedUpdateLoadEmbeddedUpdate;
        return embeddedUpdateLoadEmbeddedUpdate;
    }

    private final EmbeddedUpdate loadEmbeddedUpdate(Context context, UpdatesConfiguration updatesConfiguration) {
        try {
            InputStream inputStreamOpen = context.getAssets().open("app.manifest");
            try {
                Intrinsics.checkNotNull(inputStreamOpen);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, Charsets.UTF_8), 8192);
                try {
                    String text = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    JSONObject jSONObject = new JSONObject(text);
                    jSONObject.put("isVerified", true);
                    EmbeddedUpdate embeddedUpdate = UpdateFactory.INSTANCE.getEmbeddedUpdate(jSONObject, updatesConfiguration);
                    CloseableKt.closeFinally(inputStreamOpen, null);
                    return embeddedUpdate;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(inputStreamOpen, th3);
                    throw th4;
                }
            }
        } catch (Exception e) {
            throw new AssertionError("The embedded manifest is invalid or could not be read. Make sure you have configured expo-updates correctly in android/app/build.gradle.", e);
        }
    }
}
