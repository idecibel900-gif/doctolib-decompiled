package com.revenuecat.purchases.hybridcommon.ui;

import com.revenuecat.purchases.customercenter.CustomerCenterManagementOption;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"optionName", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterManagementOption;", "getOptionName", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterManagementOption;)Ljava/lang/String;", "hybridcommon-ui_bc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterListenerWrapperKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String getOptionName(CustomerCenterManagementOption customerCenterManagementOption) {
        if (customerCenterManagementOption instanceof CustomerCenterManagementOption.Cancel) {
            return "cancel";
        }
        if (customerCenterManagementOption instanceof CustomerCenterManagementOption.MissingPurchase) {
            return "missing_purchase";
        }
        if (customerCenterManagementOption instanceof CustomerCenterManagementOption.CustomUrl) {
            return "custom_url";
        }
        return customerCenterManagementOption instanceof CustomerCenterManagementOption.CustomAction ? "custom_action" : "unknown";
    }
}
