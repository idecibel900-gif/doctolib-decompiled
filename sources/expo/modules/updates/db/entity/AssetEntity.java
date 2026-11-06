package expo.modules.updates.db.entity;

import android.net.Uri;
import expo.modules.updates.db.enums.HashType;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class AssetEntity {
    private Date downloadTime;
    private String embeddedAssetFilename;
    private String expectedHash;
    private JSONObject extraRequestHeaders;
    private byte[] hash;
    private HashType hashType = HashType.SHA256;
    private JSONObject headers;
    private long id;
    private boolean isLaunchAsset;
    private String key;
    private boolean markedForDeletion;
    private JSONObject metadata;
    private String relativePath;
    private String resourcesFilename;
    private String resourcesFolder;
    private Float scale;
    private Float[] scales;
    private String type;
    private Uri url;

    public AssetEntity(String str, String str2) {
        this.key = str;
        this.type = str2;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getType() {
        return this.type;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final Uri getUrl() {
        return this.url;
    }

    public final void setUrl(Uri uri) {
        this.url = uri;
    }

    public final JSONObject getHeaders() {
        return this.headers;
    }

    public final void setHeaders(JSONObject jSONObject) {
        this.headers = jSONObject;
    }

    public final JSONObject getExtraRequestHeaders() {
        return this.extraRequestHeaders;
    }

    public final void setExtraRequestHeaders(JSONObject jSONObject) {
        this.extraRequestHeaders = jSONObject;
    }

    public final JSONObject getMetadata() {
        return this.metadata;
    }

    public final void setMetadata(JSONObject jSONObject) {
        this.metadata = jSONObject;
    }

    public final Date getDownloadTime() {
        return this.downloadTime;
    }

    public final void setDownloadTime(Date date) {
        this.downloadTime = date;
    }

    public final String getRelativePath() {
        return this.relativePath;
    }

    public final void setRelativePath(String str) {
        this.relativePath = str;
    }

    public final byte[] getHash() {
        return this.hash;
    }

    public final void setHash(byte[] bArr) {
        this.hash = bArr;
    }

    public final HashType getHashType() {
        return this.hashType;
    }

    public final void setHashType(HashType hashType) {
        Intrinsics.checkNotNullParameter(hashType, "<set-?>");
        this.hashType = hashType;
    }

    public final String getExpectedHash() {
        return this.expectedHash;
    }

    public final void setExpectedHash(String str) {
        this.expectedHash = str;
    }

    public final boolean getMarkedForDeletion() {
        return this.markedForDeletion;
    }

    public final void setMarkedForDeletion(boolean z) {
        this.markedForDeletion = z;
    }

    public final boolean isLaunchAsset() {
        return this.isLaunchAsset;
    }

    public final void setLaunchAsset(boolean z) {
        this.isLaunchAsset = z;
    }

    public final String getEmbeddedAssetFilename() {
        return this.embeddedAssetFilename;
    }

    public final void setEmbeddedAssetFilename(String str) {
        this.embeddedAssetFilename = str;
    }

    public final String getResourcesFilename() {
        return this.resourcesFilename;
    }

    public final void setResourcesFilename(String str) {
        this.resourcesFilename = str;
    }

    public final String getResourcesFolder() {
        return this.resourcesFolder;
    }

    public final void setResourcesFolder(String str) {
        this.resourcesFolder = str;
    }

    public final Float getScale() {
        return this.scale;
    }

    public final void setScale(Float f) {
        this.scale = f;
    }

    public final Float[] getScales() {
        return this.scales;
    }

    public final void setScales(Float[] fArr) {
        this.scales = fArr;
    }

    public final String getFileExtension$expo_updates_release() {
        String str = this.type;
        if (str == null) {
            return "";
        }
        if (StringsKt.startsWith$default(str, ".", false, 2, (Object) null)) {
            return str;
        }
        return "." + str;
    }
}
