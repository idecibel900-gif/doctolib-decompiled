package com.datadog.reactnative;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class JSONFirstPartyHost {
    private final String match;
    private final List propagatorTypes;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JSONFirstPartyHost)) {
            return false;
        }
        JSONFirstPartyHost jSONFirstPartyHost = (JSONFirstPartyHost) obj;
        return Intrinsics.areEqual(this.match, jSONFirstPartyHost.match) && Intrinsics.areEqual(this.propagatorTypes, jSONFirstPartyHost.propagatorTypes);
    }

    public int hashCode() {
        return (this.match.hashCode() * 31) + this.propagatorTypes.hashCode();
    }

    public String toString() {
        return "JSONFirstPartyHost(match=" + this.match + ", propagatorTypes=" + this.propagatorTypes + ")";
    }

    public JSONFirstPartyHost(String match, List propagatorTypes) {
        Intrinsics.checkNotNullParameter(match, "match");
        Intrinsics.checkNotNullParameter(propagatorTypes, "propagatorTypes");
        this.match = match;
        this.propagatorTypes = propagatorTypes;
    }

    public final String getMatch() {
        return this.match;
    }

    public final List getPropagatorTypes() {
        return this.propagatorTypes;
    }
}
