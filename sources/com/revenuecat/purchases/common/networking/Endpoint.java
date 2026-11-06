package com.revenuecat.purchases.common.networking;

import android.net.Uri;
import com.amazon.a.a.o.b;
import com.opentok.android.PublisherKit;
import java.util.Arrays;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0010\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$B#\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u000bH&R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\r\u0082\u0001\u0010%&'()*+,-./01234¨\u00065"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint;", "", "pathTemplate", "", "name", "fallbackPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFallbackPath", "()Ljava/lang/String;", "getName", "needsNonceToPerformSigning", "", "getNeedsNonceToPerformSigning", "()Z", "getPathTemplate", "supportsFallbackBaseURLs", "getSupportsFallbackBaseURLs", "supportsSignatureVerification", "getSupportsSignatureVerification", "getPath", "useFallback", "AliasUsers", "GetAmazonReceipt", "GetCustomerCenterConfig", "GetCustomerInfo", "GetOfferings", "GetProductEntitlementMapping", "GetVirtualCurrencies", "GetWorkflow", "LogIn", "PostAttributes", "PostCreateSupportTicket", "PostDiagnostics", "PostEvents", "PostReceipt", "PostRedeemWebPurchase", "WebBillingGetProducts", "Lcom/revenuecat/purchases/common/networking/Endpoint$AliasUsers;", "Lcom/revenuecat/purchases/common/networking/Endpoint$GetAmazonReceipt;", "Lcom/revenuecat/purchases/common/networking/Endpoint$GetCustomerCenterConfig;", "Lcom/revenuecat/purchases/common/networking/Endpoint$GetCustomerInfo;", "Lcom/revenuecat/purchases/common/networking/Endpoint$GetOfferings;", "Lcom/revenuecat/purchases/common/networking/Endpoint$GetProductEntitlementMapping;", "Lcom/revenuecat/purchases/common/networking/Endpoint$GetVirtualCurrencies;", "Lcom/revenuecat/purchases/common/networking/Endpoint$GetWorkflow;", "Lcom/revenuecat/purchases/common/networking/Endpoint$LogIn;", "Lcom/revenuecat/purchases/common/networking/Endpoint$PostAttributes;", "Lcom/revenuecat/purchases/common/networking/Endpoint$PostCreateSupportTicket;", "Lcom/revenuecat/purchases/common/networking/Endpoint$PostDiagnostics;", "Lcom/revenuecat/purchases/common/networking/Endpoint$PostEvents;", "Lcom/revenuecat/purchases/common/networking/Endpoint$PostReceipt;", "Lcom/revenuecat/purchases/common/networking/Endpoint$PostRedeemWebPurchase;", "Lcom/revenuecat/purchases/common/networking/Endpoint$WebBillingGetProducts;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Endpoint {
    private final String fallbackPath;
    private final String name;
    private final String pathTemplate;

    public /* synthetic */ Endpoint(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3);
    }

    public abstract String getPath(boolean useFallback);

    private Endpoint(String str, String str2, String str3) {
        this.pathTemplate = str;
        this.name = str2;
        this.fallbackPath = str3;
    }

    public /* synthetic */ Endpoint(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, null);
    }

    public final String getPathTemplate() {
        return this.pathTemplate;
    }

    public final String getName() {
        return this.name;
    }

    public final String getFallbackPath() {
        return this.fallbackPath;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$GetCustomerInfo;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "userId", "", "(Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "getPath", "useFallback", "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class GetCustomerInfo extends Endpoint {
        private final String userId;

        public static /* synthetic */ GetCustomerInfo copy$default(GetCustomerInfo getCustomerInfo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = getCustomerInfo.userId;
            }
            return getCustomerInfo.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        public final GetCustomerInfo copy(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new GetCustomerInfo(userId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GetCustomerInfo) && Intrinsics.areEqual(this.userId, ((GetCustomerInfo) other).userId);
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "GetCustomerInfo(userId=" + this.userId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetCustomerInfo(String userId) {
            super("/v1/subscribers/%s", "get_customer", null, 4, null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.userId = userId;
        }

        public final String getUserId() {
            return this.userId;
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean useFallback) {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }

    public static /* synthetic */ String getPath$default(Endpoint endpoint, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPath");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        return endpoint.getPath(z);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$PostReceipt;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "()V", "getPath", "", "useFallback", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PostReceipt extends Endpoint {
        public static final PostReceipt INSTANCE = new PostReceipt();

        private PostReceipt() {
            super("/v1/receipts", "post_receipt", null, 4, null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean useFallback) {
            return getPathTemplate();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$GetOfferings;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "userId", "", "(Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "getPath", "useFallback", "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class GetOfferings extends Endpoint {
        private final String userId;

        public static /* synthetic */ GetOfferings copy$default(GetOfferings getOfferings, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = getOfferings.userId;
            }
            return getOfferings.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        public final GetOfferings copy(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new GetOfferings(userId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GetOfferings) && Intrinsics.areEqual(this.userId, ((GetOfferings) other).userId);
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "GetOfferings(userId=" + this.userId + ')';
        }

        public final String getUserId() {
            return this.userId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetOfferings(String userId) {
            super("/v1/subscribers/%s/offerings", "get_offerings", "/v1/offerings", null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.userId = userId;
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean useFallback) {
            if (useFallback && getFallbackPath() != null) {
                return getFallbackPath();
            }
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$GetWorkflow;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "userId", "", "workflowId", "(Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getWorkflowId", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "getPath", "useFallback", "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class GetWorkflow extends Endpoint {
        private final String userId;
        private final String workflowId;

        public static /* synthetic */ GetWorkflow copy$default(GetWorkflow getWorkflow, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = getWorkflow.userId;
            }
            if ((i & 2) != 0) {
                str2 = getWorkflow.workflowId;
            }
            return getWorkflow.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getWorkflowId() {
            return this.workflowId;
        }

        public final GetWorkflow copy(String userId, String workflowId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(workflowId, "workflowId");
            return new GetWorkflow(userId, workflowId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetWorkflow)) {
                return false;
            }
            GetWorkflow getWorkflow = (GetWorkflow) other;
            return Intrinsics.areEqual(this.userId, getWorkflow.userId) && Intrinsics.areEqual(this.workflowId, getWorkflow.workflowId);
        }

        public int hashCode() {
            return (this.userId.hashCode() * 31) + this.workflowId.hashCode();
        }

        public String toString() {
            return "GetWorkflow(userId=" + this.userId + ", workflowId=" + this.workflowId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetWorkflow(String userId, String workflowId) {
            super("/v1/subscribers/%s/workflows/%s", "get_workflow", null, 4, null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(workflowId, "workflowId");
            this.userId = userId;
            this.workflowId = workflowId;
        }

        public final String getUserId() {
            return this.userId;
        }

        public final String getWorkflowId() {
            return this.workflowId;
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean useFallback) {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId), Uri.encode(this.workflowId)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$LogIn;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "()V", "getPath", "", "useFallback", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class LogIn extends Endpoint {
        public static final LogIn INSTANCE = new LogIn();

        private LogIn() {
            super("/v1/subscribers/identify", "log_in", null, 4, null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean useFallback) {
            return getPathTemplate();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$AliasUsers;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "userId", "", "(Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "getPath", "useFallback", "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AliasUsers extends Endpoint {
        private final String userId;

        public static /* synthetic */ AliasUsers copy$default(AliasUsers aliasUsers, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aliasUsers.userId;
            }
            return aliasUsers.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        public final AliasUsers copy(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new AliasUsers(userId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AliasUsers) && Intrinsics.areEqual(this.userId, ((AliasUsers) other).userId);
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "AliasUsers(userId=" + this.userId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AliasUsers(String userId) {
            super("/v1/subscribers/%s/alias", "alias_users", null, 4, null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.userId = userId;
        }

        public final String getUserId() {
            return this.userId;
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean useFallback) {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$PostDiagnostics;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "()V", "getPath", "", "useFallback", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PostDiagnostics extends Endpoint {
        public static final PostDiagnostics INSTANCE = new PostDiagnostics();

        private PostDiagnostics() {
            super("/v1/diagnostics", "post_diagnostics", null, 4, null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean useFallback) {
            return getPathTemplate();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$PostEvents;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "()V", "getPath", "", "useFallback", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PostEvents extends Endpoint {
        public static final PostEvents INSTANCE = new PostEvents();

        private PostEvents() {
            super("/v1/events", "post_paywall_events", null, 4, null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean useFallback) {
            return getPathTemplate();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$PostAttributes;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "userId", "", "(Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "getPath", "useFallback", "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PostAttributes extends Endpoint {
        private final String userId;

        public static /* synthetic */ PostAttributes copy$default(PostAttributes postAttributes, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = postAttributes.userId;
            }
            return postAttributes.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        public final PostAttributes copy(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new PostAttributes(userId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PostAttributes) && Intrinsics.areEqual(this.userId, ((PostAttributes) other).userId);
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "PostAttributes(userId=" + this.userId + ')';
        }

        public final String getUserId() {
            return this.userId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostAttributes(String userId) {
            super("/v1/subscribers/%s/attributes", "post_attributes", null, 4, null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.userId = userId;
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean useFallback) {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$GetAmazonReceipt;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "userId", "", b.E, "(Ljava/lang/String;Ljava/lang/String;)V", "getReceiptId", "()Ljava/lang/String;", "getUserId", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "getPath", "useFallback", "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class GetAmazonReceipt extends Endpoint {
        private final String receiptId;
        private final String userId;

        public static /* synthetic */ GetAmazonReceipt copy$default(GetAmazonReceipt getAmazonReceipt, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = getAmazonReceipt.userId;
            }
            if ((i & 2) != 0) {
                str2 = getAmazonReceipt.receiptId;
            }
            return getAmazonReceipt.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getReceiptId() {
            return this.receiptId;
        }

        public final GetAmazonReceipt copy(String userId, String receiptId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(receiptId, "receiptId");
            return new GetAmazonReceipt(userId, receiptId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetAmazonReceipt)) {
                return false;
            }
            GetAmazonReceipt getAmazonReceipt = (GetAmazonReceipt) other;
            return Intrinsics.areEqual(this.userId, getAmazonReceipt.userId) && Intrinsics.areEqual(this.receiptId, getAmazonReceipt.receiptId);
        }

        public int hashCode() {
            return (this.userId.hashCode() * 31) + this.receiptId.hashCode();
        }

        public String toString() {
            return "GetAmazonReceipt(userId=" + this.userId + ", receiptId=" + this.receiptId + ')';
        }

        public final String getUserId() {
            return this.userId;
        }

        public final String getReceiptId() {
            return this.receiptId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetAmazonReceipt(String userId, String receiptId) {
            super("/v1/receipts/amazon/%s/%s", "get_amazon_receipt", null, 4, null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(receiptId, "receiptId");
            this.userId = userId;
            this.receiptId = receiptId;
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean useFallback) {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId), this.receiptId}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$GetProductEntitlementMapping;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "()V", "getPath", "", "useFallback", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class GetProductEntitlementMapping extends Endpoint {
        public static final GetProductEntitlementMapping INSTANCE = new GetProductEntitlementMapping();

        /* JADX WARN: Illegal instructions before constructor call */
        private GetProductEntitlementMapping() {
            String str = "/v1/product_entitlement_mapping";
            super(str, "get_product_entitlement_mapping", str, null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean useFallback) {
            if (useFallback && getFallbackPath() != null) {
                return getFallbackPath();
            }
            return getPathTemplate();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$GetCustomerCenterConfig;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "userId", "", "(Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "getPath", "useFallback", "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class GetCustomerCenterConfig extends Endpoint {
        private final String userId;

        public static /* synthetic */ GetCustomerCenterConfig copy$default(GetCustomerCenterConfig getCustomerCenterConfig, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = getCustomerCenterConfig.userId;
            }
            return getCustomerCenterConfig.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        public final GetCustomerCenterConfig copy(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new GetCustomerCenterConfig(userId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GetCustomerCenterConfig) && Intrinsics.areEqual(this.userId, ((GetCustomerCenterConfig) other).userId);
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "GetCustomerCenterConfig(userId=" + this.userId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetCustomerCenterConfig(String userId) {
            super("/v1/customercenter/%s", "get_customer_center_config", null, 4, null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.userId = userId;
        }

        public final String getUserId() {
            return this.userId;
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean useFallback) {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$PostCreateSupportTicket;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "()V", "getPath", "", "useFallback", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PostCreateSupportTicket extends Endpoint {
        public static final PostCreateSupportTicket INSTANCE = new PostCreateSupportTicket();

        private PostCreateSupportTicket() {
            super("/v1/customercenter/support/create-ticket", "post_create_support_ticket", null, 4, null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean useFallback) {
            return getPathTemplate();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$PostRedeemWebPurchase;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "()V", "getPath", "", "useFallback", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PostRedeemWebPurchase extends Endpoint {
        public static final PostRedeemWebPurchase INSTANCE = new PostRedeemWebPurchase();

        private PostRedeemWebPurchase() {
            super("/v1/subscribers/redeem_purchase", "post_redeem_web_purchase", null, 4, null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean useFallback) {
            return getPathTemplate();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$GetVirtualCurrencies;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "userId", "", "(Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "getPath", "useFallback", "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class GetVirtualCurrencies extends Endpoint {
        private final String userId;

        public static /* synthetic */ GetVirtualCurrencies copy$default(GetVirtualCurrencies getVirtualCurrencies, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = getVirtualCurrencies.userId;
            }
            return getVirtualCurrencies.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        public final GetVirtualCurrencies copy(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new GetVirtualCurrencies(userId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GetVirtualCurrencies) && Intrinsics.areEqual(this.userId, ((GetVirtualCurrencies) other).userId);
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "GetVirtualCurrencies(userId=" + this.userId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetVirtualCurrencies(String userId) {
            super("/v1/subscribers/%s/virtual_currencies", "get_virtual_currencies", null, 4, null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.userId = userId;
        }

        public final String getUserId() {
            return this.userId;
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean useFallback) {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/common/networking/Endpoint$WebBillingGetProducts;", "Lcom/revenuecat/purchases/common/networking/Endpoint;", "userId", "", "productIds", "", "(Ljava/lang/String;Ljava/util/Set;)V", "getProductIds", "()Ljava/util/Set;", "getUserId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "getPath", "useFallback", "hashCode", "", "toString", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class WebBillingGetProducts extends Endpoint {
        private final Set<String> productIds;
        private final String userId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WebBillingGetProducts copy$default(WebBillingGetProducts webBillingGetProducts, String str, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                str = webBillingGetProducts.userId;
            }
            if ((i & 2) != 0) {
                set = webBillingGetProducts.productIds;
            }
            return webBillingGetProducts.copy(str, set);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUserId() {
            return this.userId;
        }

        public final Set<String> component2() {
            return this.productIds;
        }

        public final WebBillingGetProducts copy(String userId, Set<String> productIds) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(productIds, "productIds");
            return new WebBillingGetProducts(userId, productIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WebBillingGetProducts)) {
                return false;
            }
            WebBillingGetProducts webBillingGetProducts = (WebBillingGetProducts) other;
            return Intrinsics.areEqual(this.userId, webBillingGetProducts.userId) && Intrinsics.areEqual(this.productIds, webBillingGetProducts.productIds);
        }

        public int hashCode() {
            return (this.userId.hashCode() * 31) + this.productIds.hashCode();
        }

        public String toString() {
            return "WebBillingGetProducts(userId=" + this.userId + ", productIds=" + this.productIds + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebBillingGetProducts(String userId, Set<String> productIds) {
            super("/rcbilling/v1/subscribers/%s/products?id=%s", "web_billing_get_products", null, 4, null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(productIds, "productIds");
            this.userId = userId;
            this.productIds = productIds;
        }

        public final Set<String> getProductIds() {
            return this.productIds;
        }

        public final String getUserId() {
            return this.userId;
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean useFallback) {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId), CollectionsKt.joinToString$default(this.productIds, "&id=", null, null, 0, null, new Function1() { // from class: com.revenuecat.purchases.common.networking.Endpoint$WebBillingGetProducts$getPath$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String strEncode = Uri.encode(it);
                    Intrinsics.checkNotNullExpressionValue(strEncode, "encode(it)");
                    return strEncode;
                }
            }, 30, null)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
    }

    public final boolean getSupportsSignatureVerification() {
        if (this instanceof GetCustomerInfo ? true : Intrinsics.areEqual(this, LogIn.INSTANCE) ? true : Intrinsics.areEqual(this, PostReceipt.INSTANCE) ? true : this instanceof GetOfferings ? true : this instanceof GetWorkflow ? true : Intrinsics.areEqual(this, GetProductEntitlementMapping.INSTANCE) ? true : Intrinsics.areEqual(this, PostRedeemWebPurchase.INSTANCE) ? true : this instanceof GetVirtualCurrencies) {
            return true;
        }
        if (this instanceof GetAmazonReceipt ? true : this instanceof PostAttributes ? true : Intrinsics.areEqual(this, PostDiagnostics.INSTANCE) ? true : Intrinsics.areEqual(this, PostEvents.INSTANCE) ? true : this instanceof GetCustomerCenterConfig ? true : Intrinsics.areEqual(this, PostCreateSupportTicket.INSTANCE) ? true : this instanceof WebBillingGetProducts ? true : this instanceof AliasUsers) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getNeedsNonceToPerformSigning() {
        if (this instanceof GetCustomerInfo ? true : Intrinsics.areEqual(this, LogIn.INSTANCE) ? true : Intrinsics.areEqual(this, PostReceipt.INSTANCE) ? true : Intrinsics.areEqual(this, PostRedeemWebPurchase.INSTANCE) ? true : this instanceof GetVirtualCurrencies) {
            return true;
        }
        if (this instanceof GetAmazonReceipt ? true : this instanceof GetOfferings ? true : this instanceof GetWorkflow ? true : this instanceof PostAttributes ? true : Intrinsics.areEqual(this, PostDiagnostics.INSTANCE) ? true : Intrinsics.areEqual(this, PostEvents.INSTANCE) ? true : Intrinsics.areEqual(this, GetProductEntitlementMapping.INSTANCE) ? true : this instanceof GetCustomerCenterConfig ? true : Intrinsics.areEqual(this, PostCreateSupportTicket.INSTANCE) ? true : this instanceof WebBillingGetProducts ? true : this instanceof AliasUsers) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getSupportsFallbackBaseURLs() {
        return this.fallbackPath != null;
    }
}
