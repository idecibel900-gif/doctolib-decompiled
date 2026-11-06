package expo.modules.updates.db.entity;

import android.net.Uri;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.updates.db.enums.UpdateStatus;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdateEntity {
    private Date commitTime;
    private int failedLaunchCount;
    private UUID id;
    private boolean keep;
    private Date lastAccessed;
    private Long launchAssetId;
    private JSONObject manifest;
    private Map requestHeaders;
    private String runtimeVersion;
    private String scopeKey;
    private UpdateStatus status;
    private int successfulLaunchCount;
    private Uri url;

    public UpdateEntity(UUID id, Date commitTime, String runtimeVersion, String scopeKey, JSONObject manifest, Uri uri, Map map) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(commitTime, "commitTime");
        Intrinsics.checkNotNullParameter(runtimeVersion, "runtimeVersion");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        this.id = id;
        this.commitTime = commitTime;
        this.runtimeVersion = runtimeVersion;
        this.scopeKey = scopeKey;
        this.manifest = manifest;
        this.url = uri;
        this.requestHeaders = map;
        this.status = UpdateStatus.PENDING;
        this.lastAccessed = new Date();
    }

    public final UUID getId() {
        return this.id;
    }

    public final Date getCommitTime() {
        return this.commitTime;
    }

    public final void setCommitTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.commitTime = date;
    }

    public final String getRuntimeVersion() {
        return this.runtimeVersion;
    }

    public final String getScopeKey() {
        return this.scopeKey;
    }

    public final void setScopeKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scopeKey = str;
    }

    public final JSONObject getManifest() {
        return this.manifest;
    }

    public final Uri getUrl() {
        return this.url;
    }

    public final Map getRequestHeaders() {
        return this.requestHeaders;
    }

    public final Long getLaunchAssetId() {
        return this.launchAssetId;
    }

    public final void setLaunchAssetId(Long l) {
        this.launchAssetId = l;
    }

    public final UpdateStatus getStatus() {
        return this.status;
    }

    public final void setStatus(UpdateStatus updateStatus) {
        Intrinsics.checkNotNullParameter(updateStatus, "<set-?>");
        this.status = updateStatus;
    }

    public final boolean getKeep() {
        return this.keep;
    }

    public final void setKeep(boolean z) {
        this.keep = z;
    }

    public final String getLoggingId() {
        String string = this.id.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String lowerCase = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final Date getLastAccessed() {
        return this.lastAccessed;
    }

    public final void setLastAccessed(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.lastAccessed = date;
    }

    public final int getSuccessfulLaunchCount() {
        return this.successfulLaunchCount;
    }

    public final void setSuccessfulLaunchCount(int i) {
        this.successfulLaunchCount = i;
    }

    public final int getFailedLaunchCount() {
        return this.failedLaunchCount;
    }

    public final void setFailedLaunchCount(int i) {
        this.failedLaunchCount = i;
    }

    public final String debugInfo() {
        String string = new JSONObject(MapsKt.mapOf(TuplesKt.to(DiagnosticsEntry.ID_KEY, this.id.toString()), TuplesKt.to("status", this.status.name()))).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
