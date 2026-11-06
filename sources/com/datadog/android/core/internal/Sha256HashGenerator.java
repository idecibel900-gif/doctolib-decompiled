package com.datadog.android.core.internal;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class Sha256HashGenerator implements HashGenerator {
    public static final Companion Companion = new Companion(null);

    @Override // com.datadog.android.core.internal.HashGenerator
    public String generate(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = input.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            messageDigest.update(bytes);
            byte[] hashBytes = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(hashBytes, "hashBytes");
            return ArraysKt.joinToString$default(hashBytes, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1() { // from class: com.datadog.android.core.internal.Sha256HashGenerator.generate.1
                public final CharSequence invoke(byte b) {
                    String str = String.format(Locale.US, "%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).byteValue());
                }
            }, 30, (Object) null);
        } catch (NoSuchAlgorithmException e) {
            InternalLogger.DefaultImpls.log$default(RuntimeUtilsKt.getUnboundInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.Sha256HashGenerator.generate.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Cannot generate SHA-256 hash.";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
