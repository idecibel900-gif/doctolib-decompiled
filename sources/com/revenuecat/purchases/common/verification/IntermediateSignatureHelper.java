package com.revenuecat.purchases.common.verification;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.IntExtensionsKt;
import com.revenuecat.purchases.utils.Result;
import java.util.Date;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/common/verification/IntermediateSignatureHelper;", "", "rootSignatureVerifier", "Lcom/revenuecat/purchases/common/verification/SignatureVerifier;", "(Lcom/revenuecat/purchases/common/verification/SignatureVerifier;)V", "createIntermediateKeyVerifierIfVerified", "Lcom/revenuecat/purchases/utils/Result;", "Lcom/revenuecat/purchases/PurchasesError;", "signature", "Lcom/revenuecat/purchases/common/verification/Signature;", "getIntermediateKeyExpirationDate", "Ljava/util/Date;", "intermediateKeyExpirationBytes", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntermediateSignatureHelper {
    private final SignatureVerifier rootSignatureVerifier;

    public IntermediateSignatureHelper(SignatureVerifier rootSignatureVerifier) {
        Intrinsics.checkNotNullParameter(rootSignatureVerifier, "rootSignatureVerifier");
        this.rootSignatureVerifier = rootSignatureVerifier;
    }

    public final Result<SignatureVerifier, PurchasesError> createIntermediateKeyVerifierIfVerified(Signature signature) {
        Intrinsics.checkNotNullParameter(signature, "signature");
        if (!this.rootSignatureVerifier.verify(signature.getIntermediateKeySignature(), ArraysKt.plus(signature.getIntermediateKeyExpiration(), signature.getIntermediateKey()))) {
            return new Result.Error(new PurchasesError(PurchasesErrorCode.SignatureVerificationError, "Error verifying intermediate key."));
        }
        Date intermediateKeyExpirationDate = getIntermediateKeyExpirationDate(signature.getIntermediateKeyExpiration());
        if (intermediateKeyExpirationDate.before(new Date())) {
            return new Result.Error(new PurchasesError(PurchasesErrorCode.SignatureVerificationError, "Intermediate key expired at " + intermediateKeyExpirationDate));
        }
        return new Result.Success(new DefaultSignatureVerifier(signature.getIntermediateKey()));
    }

    private final Date getIntermediateKeyExpirationDate(byte[] intermediateKeyExpirationBytes) {
        Duration.Companion companion = Duration.Companion;
        return new Date(Duration.m5408getInWholeMillisecondsimpl(DurationKt.toDuration(IntExtensionsKt.fromLittleEndianBytes(IntCompanionObject.INSTANCE, intermediateKeyExpirationBytes), DurationUnit.DAYS)));
    }
}
