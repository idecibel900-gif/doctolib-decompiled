package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/ConditionContext;", "", "selectedPackageId", "", "customVariables", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "(Ljava/lang/String;Ljava/util/Map;)V", "getCustomVariables", "()Ljava/util/Map;", "getSelectedPackageId", "()Ljava/lang/String;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConditionContext {
    public static final int $stable = 8;
    private final Map<String, CustomVariableValue> customVariables;
    private final String selectedPackageId;

    /* JADX WARN: Multi-variable type inference failed */
    public ConditionContext(String str, Map<String, ? extends CustomVariableValue> customVariables) {
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        this.selectedPackageId = str;
        this.customVariables = customVariables;
    }

    public final String getSelectedPackageId() {
        return this.selectedPackageId;
    }

    public final Map<String, CustomVariableValue> getCustomVariables() {
        return this.customVariables;
    }
}
