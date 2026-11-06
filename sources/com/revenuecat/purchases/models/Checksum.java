package com.revenuecat.purchases.models;

import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.common.verification.SigningManager;
import java.lang.annotation.Annotation;
import java.security.MessageDigest;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0004#$%&B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J&\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÁ\u0001¢\u0006\u0002\b\"R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lcom/revenuecat/purchases/models/Checksum;", "", "seen1", "", "algorithm", "Lcom/revenuecat/purchases/models/Checksum$Algorithm;", "value", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/models/Checksum$Algorithm;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/models/Checksum$Algorithm;Ljava/lang/String;)V", "getAlgorithm$annotations", "()V", "getAlgorithm", "()Lcom/revenuecat/purchases/models/Checksum$Algorithm;", "getValue$annotations", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Algorithm", "ChecksumValidationException", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Checksum {
    private final Algorithm algorithm;
    private final String value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer[] $childSerializers = {Algorithm.INSTANCE.serializer(), null};

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/models/Checksum$ChecksumValidationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ChecksumValidationException extends Exception {
    }

    public static /* synthetic */ Checksum copy$default(Checksum checksum, Algorithm algorithm, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            algorithm = checksum.algorithm;
        }
        if ((i & 2) != 0) {
            str = checksum.value;
        }
        return checksum.copy(algorithm, str);
    }

    public static /* synthetic */ void getAlgorithm$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Algorithm getAlgorithm() {
        return this.algorithm;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final Checksum copy(Algorithm algorithm, String value) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(value, "value");
        return new Checksum(algorithm, value);
    }

    public int hashCode() {
        return (this.algorithm.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "Checksum(algorithm=" + this.algorithm + ", value=" + this.value + ')';
    }

    @Deprecated
    public /* synthetic */ Checksum(int i, Algorithm algorithm, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, Checksum$$serializer.INSTANCE.getDescriptor());
        }
        this.algorithm = algorithm;
        this.value = str;
    }

    public Checksum(Algorithm algorithm, String value) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(value, "value");
        this.algorithm = algorithm;
        this.value = value;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Checksum self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.algorithm);
        output.encodeStringElement(serialDesc, 1, self.value);
    }

    public final Algorithm getAlgorithm() {
        return this.algorithm;
    }

    public final String getValue() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/models/Checksum$Algorithm;", "", "algorithmName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getAlgorithmName", "()Ljava/lang/String;", "SHA256", "SHA384", "SHA512", "MD5", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Algorithm {
        SHA256("SHA-256"),
        SHA384("SHA-384"),
        SHA512("SHA-512"),
        MD5("MD5");

        private final String algorithmName;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.models.Checksum.Algorithm.Companion.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer invoke() {
                return EnumsKt.createAnnotatedEnumSerializer("com.revenuecat.purchases.models.Checksum.Algorithm", Algorithm.values(), new String[]{SigningManager.POST_PARAMS_ALGORITHM, "sha384", "sha512", "md5"}, new Annotation[][]{null, null, null, null}, null);
            }
        });

        Algorithm(String str) {
            this.algorithmName = str;
        }

        public final String getAlgorithmName() {
            return this.algorithmName;
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0001¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/models/Checksum$Algorithm$Companion;", "", "()V", "fromString", "Lcom/revenuecat/purchases/models/Checksum$Algorithm;", "value", "", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) Algorithm.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer serializer() {
                return get$cachedSerializer();
            }

            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            public final Algorithm fromString(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                String lowerCase = value.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                switch (lowerCase.hashCode()) {
                    case -903629273:
                        if (lowerCase.equals(SigningManager.POST_PARAMS_ALGORITHM)) {
                            return Algorithm.SHA256;
                        }
                        return null;
                    case -903628221:
                        if (lowerCase.equals("sha384")) {
                            return Algorithm.SHA384;
                        }
                        return null;
                    case -903626518:
                        if (lowerCase.equals("sha512")) {
                            return Algorithm.SHA512;
                        }
                        return null;
                    case 107902:
                        if (lowerCase.equals("md5")) {
                            return Algorithm.MD5;
                        }
                        return null;
                    default:
                        return null;
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0001¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/models/Checksum$Companion;", "", "()V", "generate", "Lcom/revenuecat/purchases/models/Checksum;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "algorithm", "Lcom/revenuecat/purchases/models/Checksum$Algorithm;", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return Checksum$$serializer.INSTANCE;
        }

        public final Checksum generate(byte[] data, Algorithm algorithm) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(algorithm, "algorithm");
            byte[] hash = MessageDigest.getInstance(algorithm.getAlgorithmName()).digest(data);
            Intrinsics.checkNotNullExpressionValue(hash, "hash");
            return new Checksum(algorithm, ChecksumKt.toHexString(hash));
        }
    }

    public boolean equals(Object other) {
        if (!(other instanceof Checksum)) {
            return false;
        }
        String str = this.value;
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Checksum checksum = (Checksum) other;
        String lowerCase2 = checksum.value.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return Intrinsics.areEqual(lowerCase, lowerCase2) && this.algorithm == checksum.algorithm;
    }
}
