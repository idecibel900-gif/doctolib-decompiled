package com.revenuecat.purchases.common.verification;

import android.util.Base64;
import com.google.crypto.tink.subtle.Ed25519Verify;
import java.security.GeneralSecurityException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/common/verification/DefaultSignatureVerifier;", "Lcom/revenuecat/purchases/common/verification/SignatureVerifier;", "publicKey", "", "(Ljava/lang/String;)V", "publicKeyBytes", "", "([B)V", "verifier", "Lcom/google/crypto/tink/subtle/Ed25519Verify;", "verify", "", "signatureToVerify", "messageToVerify", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultSignatureVerifier implements SignatureVerifier {
    private static final String DEFAULT_PUBLIC_KEY = "UC1upXWg5QVmyOSwozp755xLqquBKjjU+di6U8QhMlM=";
    private final Ed25519Verify verifier;

    public DefaultSignatureVerifier(byte[] publicKeyBytes) {
        Intrinsics.checkNotNullParameter(publicKeyBytes, "publicKeyBytes");
        this.verifier = new Ed25519Verify(publicKeyBytes);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DefaultSignatureVerifier(String publicKey) {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        byte[] bArrDecode = Base64.decode(publicKey, 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(publicKey, Base64.DEFAULT)");
        this(bArrDecode);
    }

    public /* synthetic */ DefaultSignatureVerifier(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DEFAULT_PUBLIC_KEY : str);
    }

    @Override // com.revenuecat.purchases.common.verification.SignatureVerifier
    public boolean verify(byte[] signatureToVerify, byte[] messageToVerify) {
        Intrinsics.checkNotNullParameter(signatureToVerify, "signatureToVerify");
        Intrinsics.checkNotNullParameter(messageToVerify, "messageToVerify");
        try {
            this.verifier.verify(signatureToVerify, messageToVerify);
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
