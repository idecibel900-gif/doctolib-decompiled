package expo.modules.updates.manifest;

import expo.modules.manifests.core.EmbeddedManifest;
import expo.modules.manifests.core.ExpoUpdatesManifest;
import expo.modules.updates.UpdatesConfiguration;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class UpdateFactory {
    public static final UpdateFactory INSTANCE = new UpdateFactory();

    private UpdateFactory() {
    }

    public final Update getUpdate(JSONObject manifestJson, ResponseHeaderData responseHeaderData, JSONObject jSONObject, UpdatesConfiguration configuration) throws Exception {
        Intrinsics.checkNotNullParameter(manifestJson, "manifestJson");
        Intrinsics.checkNotNullParameter(responseHeaderData, "responseHeaderData");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Integer protocolVersion = responseHeaderData.getProtocolVersion();
        if (protocolVersion == null) {
            throw new Exception("Legacy manifests are no longer supported");
        }
        if (protocolVersion.intValue() == 0 || protocolVersion.intValue() == 1) {
            return ExpoUpdatesUpdate.Companion.fromExpoUpdatesManifest(new ExpoUpdatesManifest(manifestJson), jSONObject, configuration);
        }
        throw new Exception("Unsupported expo-protocol-version: " + protocolVersion);
    }

    public final EmbeddedUpdate getEmbeddedUpdate(JSONObject manifestJson, UpdatesConfiguration configuration) {
        Intrinsics.checkNotNullParameter(manifestJson, "manifestJson");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return EmbeddedUpdate.Companion.fromEmbeddedManifest(new EmbeddedManifest(manifestJson), configuration);
    }
}
