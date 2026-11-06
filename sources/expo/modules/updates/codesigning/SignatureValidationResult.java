package expo.modules.updates.codesigning;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SignatureValidationResult {
    private final ExpoProjectInformation expoProjectInformation;
    private final ValidationResult validationResult;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignatureValidationResult)) {
            return false;
        }
        SignatureValidationResult signatureValidationResult = (SignatureValidationResult) obj;
        return this.validationResult == signatureValidationResult.validationResult && Intrinsics.areEqual(this.expoProjectInformation, signatureValidationResult.expoProjectInformation);
    }

    public int hashCode() {
        int iHashCode = this.validationResult.hashCode() * 31;
        ExpoProjectInformation expoProjectInformation = this.expoProjectInformation;
        return iHashCode + (expoProjectInformation == null ? 0 : expoProjectInformation.hashCode());
    }

    public String toString() {
        return "SignatureValidationResult(validationResult=" + this.validationResult + ", expoProjectInformation=" + this.expoProjectInformation + ")";
    }

    public SignatureValidationResult(ValidationResult validationResult, ExpoProjectInformation expoProjectInformation) {
        Intrinsics.checkNotNullParameter(validationResult, "validationResult");
        this.validationResult = validationResult;
        this.expoProjectInformation = expoProjectInformation;
    }

    public final ExpoProjectInformation getExpoProjectInformation() {
        return this.expoProjectInformation;
    }

    public final ValidationResult getValidationResult() {
        return this.validationResult;
    }
}
