package com.datadog.android.core.internal.system;

import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public interface BuildSdkVersionProvider {
    public static final Companion Companion = Companion.$$INSTANCE;

    int getVersion();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final BuildSdkVersionProvider DEFAULT = new BuildSdkVersionProvider() { // from class: com.datadog.android.core.internal.system.BuildSdkVersionProvider$Companion$DEFAULT$1
            private final int version = Build.VERSION.SDK_INT;

            @Override // com.datadog.android.core.internal.system.BuildSdkVersionProvider
            public int getVersion() {
                return this.version;
            }
        };

        private Companion() {
        }

        public final BuildSdkVersionProvider getDEFAULT() {
            return DEFAULT;
        }
    }
}
