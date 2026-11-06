package com.revenuecat.purchases.ui.revenuecatui;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableKeyValidator;", "", "()V", "isValidKey", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "validateAndFilter", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "variables", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomVariableKeyValidator {
    public static final int $stable = 0;
    public static final CustomVariableKeyValidator INSTANCE = new CustomVariableKeyValidator();

    private CustomVariableKeyValidator() {
    }

    public final Map<String, CustomVariableValue> validateAndFilter(Map<String, ? extends CustomVariableValue> variables) {
        Intrinsics.checkNotNullParameter(variables, "variables");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends CustomVariableValue> entry : variables.entrySet()) {
            String key = entry.getKey();
            CustomVariableValue value = entry.getValue();
            if (isValidKey(key)) {
                linkedHashMap.put(key, value);
            } else {
                Logger.INSTANCE.w("Custom variable key '" + key + "' is invalid and will be ignored. Keys must start with a letter and contain only letters, numbers, and underscores.");
            }
        }
        return linkedHashMap;
    }

    private final boolean isValidKey(String key) {
        if (key.length() > 0 && Character.isLetter(StringsKt.first(key))) {
            for (int i = 0; i < key.length(); i++) {
                char cCharAt = key.charAt(i);
                if (Character.isLetter(cCharAt) || Character.isDigit(cCharAt) || cCharAt == '_') {
                }
            }
            return true;
        }
        return false;
    }
}
