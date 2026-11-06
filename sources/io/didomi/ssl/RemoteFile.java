package io.didomi.ssl;

import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: io.didomi.sdk.ab, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BU\b\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020 \u0012\b\b\u0002\u0010)\u001a\u00020\u0002¢\u0006\u0004\b-\u0010.J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u0017\u0010\u001b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0011\u0010\u001aR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u0017\u0010\u001f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014R\"\u0010&\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b'\u0010\u0014\"\u0004\b\f\u0010(R$\u0010+\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\f\u0010*R\u0017\u0010,\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\f\u0010\u000f¨\u0006/"}, d2 = {"Lio/didomi/sdk/ab;", "", "", "m", "j", "k", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "remoteFileURL", "b", "Z", "h", "()Z", "validateRemoteFileAsJSON", "c", "cacheFileName", "d", "I", "()I", "cacheFileExpirationInSeconds", "e", "fallbackFilePathInAssets", "l", "isUpdateCacheImmediately", "", "g", "J", "()J", "setUpdateTimeout", "(J)V", "updateTimeout", "i", "(Z)V", "isBlockUntilUpdated", "(Ljava/lang/String;)V", "remoteFileContent", "cacheFileDateKey", "<init>", "(Ljava/lang/String;ZLjava/lang/String;ILjava/lang/String;ZJZ)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class RemoteFile {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final String remoteFileURL;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final boolean validateRemoteFileAsJSON;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final String cacheFileName;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    private final int cacheFileExpirationInSeconds;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    private final String fallbackFilePathInAssets;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    private final boolean isUpdateCacheImmediately;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
    private long updateTimeout;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
    private boolean isBlockUntilUpdated;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private String remoteFileContent;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final String cacheFileDateKey;

    public RemoteFile(String str, boolean z, String str2, int i, String str3, boolean z2, long j, boolean z3) {
        this.remoteFileURL = str;
        this.validateRemoteFileAsJSON = z;
        this.cacheFileName = str2;
        this.cacheFileExpirationInSeconds = i;
        this.fallbackFilePathInAssets = str3;
        this.isUpdateCacheImmediately = z2;
        this.updateTimeout = j;
        this.isBlockUntilUpdated = z3;
        this.cacheFileDateKey = "Didomi_CacheDate_" + str2;
    }

    public final void a(boolean z) {
        this.isBlockUntilUpdated = z;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getCacheFileExpirationInSeconds() {
        return this.cacheFileExpirationInSeconds;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getCacheFileName() {
        return this.cacheFileName;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getFallbackFilePathInAssets() {
        return this.fallbackFilePathInAssets;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getRemoteFileContent() {
        return this.remoteFileContent;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteFile)) {
            return false;
        }
        RemoteFile remoteFile = (RemoteFile) other;
        return Intrinsics.areEqual(this.remoteFileURL, remoteFile.remoteFileURL) && this.validateRemoteFileAsJSON == remoteFile.validateRemoteFileAsJSON && Intrinsics.areEqual(this.cacheFileName, remoteFile.cacheFileName) && this.cacheFileExpirationInSeconds == remoteFile.cacheFileExpirationInSeconds && Intrinsics.areEqual(this.fallbackFilePathInAssets, remoteFile.fallbackFilePathInAssets) && this.isUpdateCacheImmediately == remoteFile.isUpdateCacheImmediately && this.updateTimeout == remoteFile.updateTimeout && this.isBlockUntilUpdated == remoteFile.isBlockUntilUpdated;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getRemoteFileURL() {
        return this.remoteFileURL;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final long getUpdateTimeout() {
        return this.updateTimeout;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final boolean getValidateRemoteFileAsJSON() {
        return this.validateRemoteFileAsJSON;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String str = this.remoteFileURL;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.validateRemoteFileAsJSON;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        String str2 = this.cacheFileName;
        int iHashCode2 = (((i + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.cacheFileExpirationInSeconds)) * 31;
        String str3 = this.fallbackFilePathInAssets;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z2 = this.isUpdateCacheImmediately;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int iHashCode4 = (((iHashCode3 + r1) * 31) + Long.hashCode(this.updateTimeout)) * 31;
        boolean z3 = this.isBlockUntilUpdated;
        return iHashCode4 + (z3 ? 1 : z3);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final boolean getIsBlockUntilUpdated() {
        return this.isBlockUntilUpdated;
    }

    public final boolean j() {
        String str = this.cacheFileName;
        return !(str == null || StringsKt.isBlank(str));
    }

    public final boolean k() {
        String str = this.remoteFileURL;
        return !(str == null || StringsKt.isBlank(str));
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final boolean getIsUpdateCacheImmediately() {
        return this.isUpdateCacheImmediately;
    }

    public final boolean m() {
        return this.isBlockUntilUpdated || this.updateTimeout > 0;
    }

    public String toString() {
        return "RemoteFile(remoteFileURL=" + this.remoteFileURL + ", validateRemoteFileAsJSON=" + this.validateRemoteFileAsJSON + ", cacheFileName=" + this.cacheFileName + ", cacheFileExpirationInSeconds=" + this.cacheFileExpirationInSeconds + ", fallbackFilePathInAssets=" + this.fallbackFilePathInAssets + ", isUpdateCacheImmediately=" + this.isUpdateCacheImmediately + ", updateTimeout=" + this.updateTimeout + ", isBlockUntilUpdated=" + this.isBlockUntilUpdated + ')';
    }

    public final void a(String str) {
        this.remoteFileContent = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getCacheFileDateKey() {
        return this.cacheFileDateKey;
    }

    public /* synthetic */ RemoteFile(String str, boolean z, String str2, int i, String str3, boolean z2, long j, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, str2, i, str3, (i2 & 32) != 0 ? true : z2, (i2 & 64) != 0 ? 0L : j, (i2 & 128) != 0 ? false : z3);
    }
}
