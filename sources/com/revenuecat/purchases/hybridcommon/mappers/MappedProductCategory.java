package com.revenuecat.purchases.hybridcommon.mappers;

import com.revenuecat.purchases.ProductType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0081\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/mappers/MappedProductCategory;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toProductType", "Lcom/revenuecat/purchases/ProductType;", "getToProductType", "()Lcom/revenuecat/purchases/ProductType;", "getValue", "()Ljava/lang/String;", "SUBSCRIPTION", "NON_SUBSCRIPTION", "UNKNOWN", "hybridcommon_bc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum MappedProductCategory {
    SUBSCRIPTION("SUBSCRIPTION"),
    NON_SUBSCRIPTION("NON_SUBSCRIPTION"),
    UNKNOWN("UNKNOWN");

    private final String value;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MappedProductCategory.values().length];
            try {
                iArr[MappedProductCategory.NON_SUBSCRIPTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MappedProductCategory.SUBSCRIPTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MappedProductCategory.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    MappedProductCategory(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final ProductType getToProductType() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return ProductType.INAPP;
        }
        if (i == 2) {
            return ProductType.SUBS;
        }
        if (i == 3) {
            return ProductType.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }
}
