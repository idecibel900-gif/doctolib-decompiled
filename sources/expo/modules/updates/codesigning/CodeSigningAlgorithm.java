package expo.modules.updates.codesigning;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public enum CodeSigningAlgorithm {
    RSA_SHA256("rsa-v1_5-sha256");

    private final String algorithmName;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    CodeSigningAlgorithm(String str) {
        this.algorithmName = str;
    }

    public final String getAlgorithmName() {
        return this.algorithmName;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CodeSigningAlgorithm parseFromString(String str) throws Exception {
            CodeSigningAlgorithm codeSigningAlgorithm = CodeSigningAlgorithm.RSA_SHA256;
            if (Intrinsics.areEqual(str, codeSigningAlgorithm.getAlgorithmName()) || str == null) {
                return codeSigningAlgorithm;
            }
            throw new Exception("Invalid code signing algorithm name: " + str);
        }
    }
}
