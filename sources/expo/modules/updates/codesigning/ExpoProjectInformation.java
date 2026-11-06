package expo.modules.updates.codesigning;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ExpoProjectInformation {
    private final String projectId;
    private final String scopeKey;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExpoProjectInformation)) {
            return false;
        }
        ExpoProjectInformation expoProjectInformation = (ExpoProjectInformation) obj;
        return Intrinsics.areEqual(this.projectId, expoProjectInformation.projectId) && Intrinsics.areEqual(this.scopeKey, expoProjectInformation.scopeKey);
    }

    public int hashCode() {
        return (this.projectId.hashCode() * 31) + this.scopeKey.hashCode();
    }

    public String toString() {
        return "ExpoProjectInformation(projectId=" + this.projectId + ", scopeKey=" + this.scopeKey + ")";
    }

    public ExpoProjectInformation(String projectId, String scopeKey) {
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        this.projectId = projectId;
        this.scopeKey = scopeKey;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final String getScopeKey() {
        return this.scopeKey;
    }
}
