package expo.modules.updates.loader;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class SigningInfo {
    private final String easProjectId;
    private final String scopeKey;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SigningInfo)) {
            return false;
        }
        SigningInfo signingInfo = (SigningInfo) obj;
        return Intrinsics.areEqual(this.easProjectId, signingInfo.easProjectId) && Intrinsics.areEqual(this.scopeKey, signingInfo.scopeKey);
    }

    public int hashCode() {
        return (this.easProjectId.hashCode() * 31) + this.scopeKey.hashCode();
    }

    public String toString() {
        return "SigningInfo(easProjectId=" + this.easProjectId + ", scopeKey=" + this.scopeKey + ")";
    }

    public SigningInfo(String easProjectId, String scopeKey) {
        Intrinsics.checkNotNullParameter(easProjectId, "easProjectId");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        this.easProjectId = easProjectId;
        this.scopeKey = scopeKey;
    }

    public final String getEasProjectId() {
        return this.easProjectId;
    }

    public final String getScopeKey() {
        return this.scopeKey;
    }
}
