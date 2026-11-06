package com.revenuecat.purchases.google;

import com.google.android.play.core.review.model.ReviewErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00042\u00020\u0001:\u000e\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\r\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/google/BillingResponse;", "", "()V", "BillingUnavailable", "Companion", "DeveloperError", "Error", "FeatureNotSupported", "ItemAlreadyOwned", "ItemNotOwned", "ItemUnavailable", "NetworkError", "OK", "ServiceDisconnected", "ServiceUnavailable", "Unknown", "UserCanceled", "Lcom/revenuecat/purchases/google/BillingResponse$BillingUnavailable;", "Lcom/revenuecat/purchases/google/BillingResponse$DeveloperError;", "Lcom/revenuecat/purchases/google/BillingResponse$Error;", "Lcom/revenuecat/purchases/google/BillingResponse$FeatureNotSupported;", "Lcom/revenuecat/purchases/google/BillingResponse$ItemAlreadyOwned;", "Lcom/revenuecat/purchases/google/BillingResponse$ItemNotOwned;", "Lcom/revenuecat/purchases/google/BillingResponse$ItemUnavailable;", "Lcom/revenuecat/purchases/google/BillingResponse$NetworkError;", "Lcom/revenuecat/purchases/google/BillingResponse$OK;", "Lcom/revenuecat/purchases/google/BillingResponse$ServiceDisconnected;", "Lcom/revenuecat/purchases/google/BillingResponse$ServiceUnavailable;", "Lcom/revenuecat/purchases/google/BillingResponse$Unknown;", "Lcom/revenuecat/purchases/google/BillingResponse$UserCanceled;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BillingResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ BillingResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BillingResponse() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/google/BillingResponse$FeatureNotSupported;", "Lcom/revenuecat/purchases/google/BillingResponse;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FeatureNotSupported extends BillingResponse {
        public static final FeatureNotSupported INSTANCE = new FeatureNotSupported();

        private FeatureNotSupported() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/google/BillingResponse$ServiceDisconnected;", "Lcom/revenuecat/purchases/google/BillingResponse;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ServiceDisconnected extends BillingResponse {
        public static final ServiceDisconnected INSTANCE = new ServiceDisconnected();

        private ServiceDisconnected() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/google/BillingResponse$OK;", "Lcom/revenuecat/purchases/google/BillingResponse;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OK extends BillingResponse {
        public static final OK INSTANCE = new OK();

        private OK() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/google/BillingResponse$UserCanceled;", "Lcom/revenuecat/purchases/google/BillingResponse;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class UserCanceled extends BillingResponse {
        public static final UserCanceled INSTANCE = new UserCanceled();

        private UserCanceled() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/google/BillingResponse$ServiceUnavailable;", "Lcom/revenuecat/purchases/google/BillingResponse;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ServiceUnavailable extends BillingResponse {
        public static final ServiceUnavailable INSTANCE = new ServiceUnavailable();

        private ServiceUnavailable() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/google/BillingResponse$BillingUnavailable;", "Lcom/revenuecat/purchases/google/BillingResponse;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class BillingUnavailable extends BillingResponse {
        public static final BillingUnavailable INSTANCE = new BillingUnavailable();

        private BillingUnavailable() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/google/BillingResponse$ItemUnavailable;", "Lcom/revenuecat/purchases/google/BillingResponse;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ItemUnavailable extends BillingResponse {
        public static final ItemUnavailable INSTANCE = new ItemUnavailable();

        private ItemUnavailable() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/google/BillingResponse$DeveloperError;", "Lcom/revenuecat/purchases/google/BillingResponse;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DeveloperError extends BillingResponse {
        public static final DeveloperError INSTANCE = new DeveloperError();

        private DeveloperError() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/google/BillingResponse$Error;", "Lcom/revenuecat/purchases/google/BillingResponse;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Error extends BillingResponse {
        public static final Error INSTANCE = new Error();

        private Error() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/google/BillingResponse$ItemAlreadyOwned;", "Lcom/revenuecat/purchases/google/BillingResponse;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ItemAlreadyOwned extends BillingResponse {
        public static final ItemAlreadyOwned INSTANCE = new ItemAlreadyOwned();

        private ItemAlreadyOwned() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/google/BillingResponse$ItemNotOwned;", "Lcom/revenuecat/purchases/google/BillingResponse;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ItemNotOwned extends BillingResponse {
        public static final ItemNotOwned INSTANCE = new ItemNotOwned();

        private ItemNotOwned() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/google/BillingResponse$NetworkError;", "Lcom/revenuecat/purchases/google/BillingResponse;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class NetworkError extends BillingResponse {
        public static final NetworkError INSTANCE = new NetworkError();

        private NetworkError() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/google/BillingResponse$Unknown;", "Lcom/revenuecat/purchases/google/BillingResponse;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Unknown extends BillingResponse {
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/google/BillingResponse$Companion;", "", "()V", "fromCode", "Lcom/revenuecat/purchases/google/BillingResponse;", ResponseTypeValues.CODE, "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BillingResponse fromCode(int code) {
            if (code != 12) {
                switch (code) {
                    case -3:
                        return ServiceUnavailable.INSTANCE;
                    case ReviewErrorCode.INVALID_REQUEST /* -2 */:
                        return FeatureNotSupported.INSTANCE;
                    case -1:
                        return ServiceDisconnected.INSTANCE;
                    case 0:
                        return OK.INSTANCE;
                    case 1:
                        return UserCanceled.INSTANCE;
                    case 2:
                        return ServiceUnavailable.INSTANCE;
                    case 3:
                        return BillingUnavailable.INSTANCE;
                    case 4:
                        return ItemUnavailable.INSTANCE;
                    case 5:
                        return DeveloperError.INSTANCE;
                    case 6:
                        return Error.INSTANCE;
                    case 7:
                        return ItemAlreadyOwned.INSTANCE;
                    case 8:
                        return ItemNotOwned.INSTANCE;
                    default:
                        return Unknown.INSTANCE;
                }
            }
            return NetworkError.INSTANCE;
        }
    }
}
