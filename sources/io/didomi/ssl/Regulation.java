package io.didomi.ssl;

import androidx.annotation.Keep;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lio/didomi/sdk/Regulation;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "", "mixed", "Z", "getMixed", "()Z", "tokenKey", "getTokenKey", "dcsKey", "getDcsKey", "<init>", "(Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "Companion", "a", "GDPR", "CCPA", "CPA", "CPRA", "CTDPA", "UCPA", "VCDPA", "NONE", "android_release"}, k = 1, mv = {1, 8, 0})
public enum Regulation {
    GDPR("gdpr", false, "Didomi_Token", "Didomi_DCS_GDPR"),
    CCPA("ccpa", false, "Didomi_Token_CCPA", "Didomi_DCS_CCPA"),
    CPA("cpa", true, "Didomi_Token_CPA", "Didomi_DCS_CPA"),
    CPRA("cpra", true, "Didomi_Token_CPRA", "Didomi_DCS_CPRA"),
    CTDPA("ctdpa", true, "Didomi_Token_CTDPA", "Didomi_DCS_CTDPA"),
    UCPA("ucpa", true, "Didomi_Token_UCPA", "Didomi_DCS_UCPA"),
    VCDPA("vcdpa", true, "Didomi_Token_VCDPA", "Didomi_DCS_VCDPA"),
    NONE("none", false, "Didomi_Token_NONE", "Didomi_DCS_NONE");


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String dcsKey;
    private final boolean mixed;
    private final String tokenKey;
    private final String value;

    /* JADX INFO: renamed from: io.didomi.sdk.Regulation$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lio/didomi/sdk/Regulation$a;", "", "", "value", "Lio/didomi/sdk/Regulation;", "a", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Regulation a(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String lowerCase = value.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Regulation regulation = Regulation.CCPA;
            if (Intrinsics.areEqual(lowerCase, regulation.getValue())) {
                return regulation;
            }
            Regulation regulation2 = Regulation.CPA;
            if (Intrinsics.areEqual(lowerCase, regulation2.getValue())) {
                return regulation2;
            }
            Regulation regulation3 = Regulation.CPRA;
            if (Intrinsics.areEqual(lowerCase, regulation3.getValue())) {
                return regulation3;
            }
            Regulation regulation4 = Regulation.CTDPA;
            if (Intrinsics.areEqual(lowerCase, regulation4.getValue())) {
                return regulation4;
            }
            Regulation regulation5 = Regulation.GDPR;
            if (Intrinsics.areEqual(lowerCase, regulation5.getValue())) {
                return regulation5;
            }
            Regulation regulation6 = Regulation.NONE;
            if (Intrinsics.areEqual(lowerCase, regulation6.getValue())) {
                return regulation6;
            }
            Regulation regulation7 = Regulation.UCPA;
            if (Intrinsics.areEqual(lowerCase, regulation7.getValue())) {
                return regulation7;
            }
            Regulation regulation8 = Regulation.VCDPA;
            if (Intrinsics.areEqual(lowerCase, regulation8.getValue())) {
                return regulation8;
            }
            return null;
        }

        private Companion() {
        }
    }

    Regulation(String str, boolean z, String str2, String str3) {
        this.value = str;
        this.mixed = z;
        this.tokenKey = str2;
        this.dcsKey = str3;
    }

    public final String getDcsKey() {
        return this.dcsKey;
    }

    public final boolean getMixed() {
        return this.mixed;
    }

    public final String getTokenKey() {
        return this.tokenKey;
    }

    public final String getValue() {
        return this.value;
    }
}
