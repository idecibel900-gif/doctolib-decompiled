package androidx.media3.exoplayer.drm;

import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public interface MediaDrmCallback {
    byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest);

    byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest);
}
