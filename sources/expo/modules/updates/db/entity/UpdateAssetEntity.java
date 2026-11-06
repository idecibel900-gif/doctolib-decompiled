package expo.modules.updates.db.entity;

import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdateAssetEntity {
    private long assetId;
    private UUID updateId;

    public UpdateAssetEntity(UUID updateId, long j) {
        Intrinsics.checkNotNullParameter(updateId, "updateId");
        this.updateId = updateId;
        this.assetId = j;
    }

    public final UUID getUpdateId() {
        return this.updateId;
    }

    public final long getAssetId() {
        return this.assetId;
    }
}
