package com.revenuecat.purchases.strings;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/strings/OfflineEntitlementsStrings;", "", "()V", "ALREADY_CALCULATING_OFFLINE_CUSTOMER_INFO", "", "ERROR_PARSING_PRODUCT_ENTITLEMENT_MAPPING", "ERROR_UPDATING_PRODUCT_ENTITLEMENTS", "OFFLINE_ENTITLEMENTS_NOT_ENABLED", "OFFLINE_ENTITLEMENTS_UNSUPPORTED_INAPP_PURCHASES", "PRODUCT_ENTITLEMENT_MAPPING_REQUIRED", "RESETTING_OFFLINE_CUSTOMER_INFO_CACHE", "SUCCESSFULLY_UPDATED_PRODUCT_ENTITLEMENTS", "UPDATING_PRODUCT_ENTITLEMENT_MAPPING", "USING_OFFLINE_ENTITLEMENTS_CUSTOMER_INFO", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OfflineEntitlementsStrings {
    public static final String ALREADY_CALCULATING_OFFLINE_CUSTOMER_INFO = "Already calculating offline customer info for %s.";
    public static final String ERROR_PARSING_PRODUCT_ENTITLEMENT_MAPPING = "Error parsing cached product entitlement mapping: %s";
    public static final String ERROR_UPDATING_PRODUCT_ENTITLEMENTS = "Error updating product entitlement mappings. Error: %s.";
    public static final OfflineEntitlementsStrings INSTANCE = new OfflineEntitlementsStrings();
    public static final String OFFLINE_ENTITLEMENTS_NOT_ENABLED = "Offline entitlements not enabled in this version.";
    public static final String OFFLINE_ENTITLEMENTS_UNSUPPORTED_INAPP_PURCHASES = "Offline entitlements are not supported for one time purchases. Found one time purchases. See for more info: https://rev.cat/offline-entitlements";
    public static final String PRODUCT_ENTITLEMENT_MAPPING_REQUIRED = "Product entitlement mapping is required for offline entitlements. Skipping offline customer info calculation.";
    public static final String RESETTING_OFFLINE_CUSTOMER_INFO_CACHE = "Resetting offline customer info cache.";
    public static final String SUCCESSFULLY_UPDATED_PRODUCT_ENTITLEMENTS = "Successfully updated product entitlement mappings.";
    public static final String UPDATING_PRODUCT_ENTITLEMENT_MAPPING = "Product entitlement mappings are stale. Updating.";
    public static final String USING_OFFLINE_ENTITLEMENTS_CUSTOMER_INFO = "Using offline computed customer info. In this state EntitlementInfo's isSandbox will always be false. Additionally, the expiration date may be inaccurate. Once the transactions are synced with our backend, these values will be automatically corrected.";

    private OfflineEntitlementsStrings() {
    }
}
