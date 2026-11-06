package com.revenuecat.purchases.common.verification;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.EntitlementVerificationMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u000b2\u00020\u0001:\u0004\u000b\f\r\u000eB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "", "()V", "intermediateSignatureHelper", "Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;", "getIntermediateSignatureHelper", "()Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;", "shouldVerify", "", "getShouldVerify", "()Z", "Companion", "Disabled", "Enforced", "Informational", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode$Disabled;", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode$Enforced;", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode$Informational;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class SignatureVerificationMode {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ SignatureVerificationMode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode$Companion;", "", "()V", "createIntermediateSignatureHelper", "Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;", "fromEntitlementVerificationMode", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "verificationMode", "Lcom/revenuecat/purchases/EntitlementVerificationMode;", "rootVerifier", "Lcom/revenuecat/purchases/common/verification/SignatureVerifier;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[EntitlementVerificationMode.values().length];
                try {
                    iArr[EntitlementVerificationMode.DISABLED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EntitlementVerificationMode.INFORMATIONAL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ SignatureVerificationMode fromEntitlementVerificationMode$default(Companion companion, EntitlementVerificationMode entitlementVerificationMode, SignatureVerifier signatureVerifier, int i, Object obj) {
            if ((i & 2) != 0) {
                signatureVerifier = null;
            }
            return companion.fromEntitlementVerificationMode(entitlementVerificationMode, signatureVerifier);
        }

        public final SignatureVerificationMode fromEntitlementVerificationMode(EntitlementVerificationMode verificationMode, SignatureVerifier rootVerifier) {
            Intrinsics.checkNotNullParameter(verificationMode, "verificationMode");
            int i = WhenMappings.$EnumSwitchMapping$0[verificationMode.ordinal()];
            if (i == 1) {
                return Disabled.INSTANCE;
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            if (rootVerifier == null) {
                rootVerifier = new DefaultSignatureVerifier(null, 1, null);
            }
            return new Informational(new IntermediateSignatureHelper(rootVerifier));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final IntermediateSignatureHelper createIntermediateSignatureHelper() {
            return new IntermediateSignatureHelper(new DefaultSignatureVerifier(null, 1, null));
        }
    }

    private SignatureVerificationMode() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode$Disabled;", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Disabled extends SignatureVerificationMode {
        public static final Disabled INSTANCE = new Disabled();

        private Disabled() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode$Informational;", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "intermediateSignatureHelper", "Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;", "(Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;)V", "getIntermediateSignatureHelper", "()Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Informational extends SignatureVerificationMode {
        private final IntermediateSignatureHelper intermediateSignatureHelper;

        /* JADX WARN: Multi-variable type inference failed */
        public Informational() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Informational copy$default(Informational informational, IntermediateSignatureHelper intermediateSignatureHelper, int i, Object obj) {
            if ((i & 1) != 0) {
                intermediateSignatureHelper = informational.intermediateSignatureHelper;
            }
            return informational.copy(intermediateSignatureHelper);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final IntermediateSignatureHelper getIntermediateSignatureHelper() {
            return this.intermediateSignatureHelper;
        }

        public final Informational copy(IntermediateSignatureHelper intermediateSignatureHelper) {
            Intrinsics.checkNotNullParameter(intermediateSignatureHelper, "intermediateSignatureHelper");
            return new Informational(intermediateSignatureHelper);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Informational) && Intrinsics.areEqual(this.intermediateSignatureHelper, ((Informational) other).intermediateSignatureHelper);
        }

        public int hashCode() {
            return this.intermediateSignatureHelper.hashCode();
        }

        public String toString() {
            return "Informational(intermediateSignatureHelper=" + this.intermediateSignatureHelper + ')';
        }

        public /* synthetic */ Informational(IntermediateSignatureHelper intermediateSignatureHelper, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SignatureVerificationMode.INSTANCE.createIntermediateSignatureHelper() : intermediateSignatureHelper);
        }

        @Override // com.revenuecat.purchases.common.verification.SignatureVerificationMode
        public IntermediateSignatureHelper getIntermediateSignatureHelper() {
            return this.intermediateSignatureHelper;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Informational(IntermediateSignatureHelper intermediateSignatureHelper) {
            super(null);
            Intrinsics.checkNotNullParameter(intermediateSignatureHelper, "intermediateSignatureHelper");
            this.intermediateSignatureHelper = intermediateSignatureHelper;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode$Enforced;", "Lcom/revenuecat/purchases/common/verification/SignatureVerificationMode;", "intermediateSignatureHelper", "Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;", "(Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;)V", "getIntermediateSignatureHelper", "()Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Enforced extends SignatureVerificationMode {
        private final IntermediateSignatureHelper intermediateSignatureHelper;

        /* JADX WARN: Multi-variable type inference failed */
        public Enforced() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Enforced copy$default(Enforced enforced, IntermediateSignatureHelper intermediateSignatureHelper, int i, Object obj) {
            if ((i & 1) != 0) {
                intermediateSignatureHelper = enforced.intermediateSignatureHelper;
            }
            return enforced.copy(intermediateSignatureHelper);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final IntermediateSignatureHelper getIntermediateSignatureHelper() {
            return this.intermediateSignatureHelper;
        }

        public final Enforced copy(IntermediateSignatureHelper intermediateSignatureHelper) {
            Intrinsics.checkNotNullParameter(intermediateSignatureHelper, "intermediateSignatureHelper");
            return new Enforced(intermediateSignatureHelper);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Enforced) && Intrinsics.areEqual(this.intermediateSignatureHelper, ((Enforced) other).intermediateSignatureHelper);
        }

        public int hashCode() {
            return this.intermediateSignatureHelper.hashCode();
        }

        public String toString() {
            return "Enforced(intermediateSignatureHelper=" + this.intermediateSignatureHelper + ')';
        }

        public /* synthetic */ Enforced(IntermediateSignatureHelper intermediateSignatureHelper, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SignatureVerificationMode.INSTANCE.createIntermediateSignatureHelper() : intermediateSignatureHelper);
        }

        @Override // com.revenuecat.purchases.common.verification.SignatureVerificationMode
        public IntermediateSignatureHelper getIntermediateSignatureHelper() {
            return this.intermediateSignatureHelper;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Enforced(IntermediateSignatureHelper intermediateSignatureHelper) {
            super(null);
            Intrinsics.checkNotNullParameter(intermediateSignatureHelper, "intermediateSignatureHelper");
            this.intermediateSignatureHelper = intermediateSignatureHelper;
        }
    }

    public final boolean getShouldVerify() {
        if (Intrinsics.areEqual(this, Disabled.INSTANCE)) {
            return false;
        }
        if (this instanceof Informational ? true : this instanceof Enforced) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    public IntermediateSignatureHelper getIntermediateSignatureHelper() {
        if (this instanceof Disabled) {
            return null;
        }
        if (this instanceof Informational) {
            return ((Informational) this).getIntermediateSignatureHelper();
        }
        if (this instanceof Enforced) {
            return ((Enforced) this).getIntermediateSignatureHelper();
        }
        throw new NoWhenBranchMatchedException();
    }
}
