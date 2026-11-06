package io.didomi.ssl.user.sync.model;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lio/didomi/sdk/user/sync/model/SyncError;", "", ResponseTypeValues.CODE, "", "message", "", "name", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SyncError {

    @SerializedName(ResponseTypeValues.CODE)
    private final int code;

    @SerializedName("message")
    private final String message;

    @SerializedName("name")
    private final String name;

    public SyncError(int i, String message, String name) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(name, "name");
        this.code = i;
        this.message = message;
        this.name = name;
    }

    public static /* synthetic */ SyncError copy$default(SyncError syncError, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = syncError.code;
        }
        if ((i2 & 2) != 0) {
            str = syncError.message;
        }
        if ((i2 & 4) != 0) {
            str2 = syncError.name;
        }
        return syncError.copy(i, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final SyncError copy(int code, String message, String name) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(name, "name");
        return new SyncError(code, message, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncError)) {
            return false;
        }
        SyncError syncError = (SyncError) other;
        return this.code == syncError.code && Intrinsics.areEqual(this.message, syncError.message) && Intrinsics.areEqual(this.name, syncError.name);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.code) * 31) + this.message.hashCode()) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "SyncError(code=" + this.code + ", message=" + this.message + ", name=" + this.name + ')';
    }
}
