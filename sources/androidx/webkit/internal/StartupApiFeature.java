package androidx.webkit.internal;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class StartupApiFeature {
    private static final Set sValues = new HashSet();
    private final String mInternalFeatureValue;
    private final String mPublicFeatureValue;

    StartupApiFeature(String str, String str2) {
        this.mPublicFeatureValue = str;
        this.mInternalFeatureValue = str2;
        sValues.add(this);
    }

    public static class P extends StartupApiFeature {
        P(String str, String str2) {
            super(str, str2);
        }
    }

    public static class NoFramework extends StartupApiFeature {
        NoFramework(String str, String str2) {
            super(str, str2);
        }
    }
}
