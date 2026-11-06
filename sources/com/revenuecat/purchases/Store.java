package com.revenuecat.purchases;

import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.verification.SigningManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0087\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/Store;", "", "(Ljava/lang/String;I)V", "managementUrl", "", "getManagementUrl$purchases_defaultsBc8Release", "()Ljava/lang/String;", "stringValue", "getStringValue$purchases_defaultsBc8Release", "APP_STORE", "MAC_APP_STORE", "PLAY_STORE", "STRIPE", "PROMOTIONAL", "UNKNOWN_STORE", "AMAZON", "RC_BILLING", "EXTERNAL", "PADDLE", "TEST_STORE", "GALAXY", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum Store {
    APP_STORE,
    MAC_APP_STORE,
    PLAY_STORE,
    STRIPE,
    PROMOTIONAL,
    UNKNOWN_STORE,
    AMAZON,
    RC_BILLING,
    EXTERNAL,
    PADDLE,
    TEST_STORE,
    GALAXY;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.APP_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Store.MAC_APP_STORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Store.PLAY_STORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Store.STRIPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Store.PROMOTIONAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Store.UNKNOWN_STORE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Store.AMAZON.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Store.RC_BILLING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[Store.EXTERNAL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[Store.PADDLE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[Store.TEST_STORE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[Store.GALAXY.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final String getStringValue$purchases_defaultsBc8Release() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "app_store";
            case 2:
                return "mac_app_store";
            case 3:
                return "play_store";
            case 4:
                return "stripe";
            case 5:
                return "promotional";
            case 6:
                return "unknown";
            case 7:
                return "amazon";
            case 8:
                return "rc_billing";
            case 9:
                return "external";
            case 10:
                return "paddle";
            case BaseVideoCapturer.RGBA /* 11 */:
                return "test_store";
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                return "galaxy";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final /* synthetic */ String getManagementUrl$purchases_defaultsBc8Release() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 3) {
            return "https://play.google.com/store/account/subscriptions";
        }
        if (i == 7) {
            return "amzn://apps/library/subscriptions";
        }
        if (i != 12) {
            return null;
        }
        return Constants.GALAXY_STORE_MANAGEMENT_URL;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0001¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/Store$Companion;", "", "()V", "fromString", "Lcom/revenuecat/purchases/Store;", "text", "", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return StoreSerializer.INSTANCE;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final /* synthetic */ Store fromString(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            switch (text.hashCode()) {
                case -1820761141:
                    if (text.equals("external")) {
                        return Store.EXTERNAL;
                    }
                    break;
                case -1523640723:
                    if (text.equals("rc_billing")) {
                        return Store.RC_BILLING;
                    }
                    break;
                case -1414265340:
                    if (text.equals("amazon")) {
                        return Store.AMAZON;
                    }
                    break;
                case -1253268720:
                    if (text.equals("galaxy")) {
                        return Store.GALAXY;
                    }
                    break;
                case -995842198:
                    if (text.equals("paddle")) {
                        return Store.PADDLE;
                    }
                    break;
                case -891985843:
                    if (text.equals("stripe")) {
                        return Store.STRIPE;
                    }
                    break;
                case 564036179:
                    if (text.equals("mac_app_store")) {
                        return Store.MAC_APP_STORE;
                    }
                    break;
                case 756050958:
                    if (text.equals("promotional")) {
                        return Store.PROMOTIONAL;
                    }
                    break;
                case 1842542915:
                    if (text.equals("app_store")) {
                        return Store.APP_STORE;
                    }
                    break;
                case 1925951510:
                    if (text.equals("play_store")) {
                        return Store.PLAY_STORE;
                    }
                    break;
                case 2070440692:
                    if (text.equals("test_store")) {
                        return Store.TEST_STORE;
                    }
                    break;
            }
            return Store.UNKNOWN_STORE;
        }
    }
}
