package com.google.crypto.tink.config.internal;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TinkFipsUtil {
    private static final Logger logger = Logger.getLogger(TinkFipsUtil.class.getName());
    private static final AtomicBoolean isRestrictedToFips = new AtomicBoolean(false);

    public enum AlgorithmFipsCompatibility {
        ALGORITHM_NOT_FIPS { // from class: com.google.crypto.tink.config.internal.TinkFipsUtil.AlgorithmFipsCompatibility.1
            @Override // com.google.crypto.tink.config.internal.TinkFipsUtil.AlgorithmFipsCompatibility
            public boolean isCompatible() {
                return !TinkFipsUtil.useOnlyFips();
            }
        },
        ALGORITHM_REQUIRES_BORINGCRYPTO { // from class: com.google.crypto.tink.config.internal.TinkFipsUtil.AlgorithmFipsCompatibility.2
            @Override // com.google.crypto.tink.config.internal.TinkFipsUtil.AlgorithmFipsCompatibility
            public boolean isCompatible() {
                return !TinkFipsUtil.useOnlyFips() || TinkFipsUtil.fipsModuleAvailable();
            }
        };

        public abstract boolean isCompatible();
    }

    public static boolean useOnlyFips() {
        return TinkFipsStatus.useOnlyFips() || isRestrictedToFips.get();
    }

    public static boolean fipsModuleAvailable() {
        return checkConscryptIsAvailableAndUsesFipsBoringSsl().booleanValue();
    }

    static Boolean checkConscryptIsAvailableAndUsesFipsBoringSsl() {
        try {
            return (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", null).invoke(null, null);
        } catch (Exception unused) {
            logger.info("Conscrypt is not available or does not support checking for FIPS build.");
            return Boolean.FALSE;
        }
    }
}
