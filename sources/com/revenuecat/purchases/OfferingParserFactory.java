package com.revenuecat.purchases;

import com.revenuecat.purchases.amazon.AmazonOfferingParser;
import com.revenuecat.purchases.common.GoogleOfferingParser;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.OfferingParser;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.galaxy.GalaxyOfferingParser;
import com.revenuecat.purchases.simulatedstore.SimulatedStoreOfferingParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/OfferingParserFactory;", "", "()V", "createOfferingParser", "Lcom/revenuecat/purchases/common/OfferingParser;", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OfferingParserFactory {
    public static final OfferingParserFactory INSTANCE = new OfferingParserFactory();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Store.values().length];
            try {
                iArr[Store.TEST_STORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Store.PLAY_STORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Store.AMAZON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Store.GALAXY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private OfferingParserFactory() {
    }

    public final OfferingParser createOfferingParser(Store store) {
        Intrinsics.checkNotNullParameter(store, "store");
        int i = WhenMappings.$EnumSwitchMapping$0[store.ordinal()];
        if (i == 1) {
            return new SimulatedStoreOfferingParser();
        }
        if (i == 2) {
            return new GoogleOfferingParser();
        }
        if (i == 3) {
            return new AmazonOfferingParser();
        }
        if (i == 4) {
            return new GalaxyOfferingParser();
        }
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Incompatible store (" + store + ") used", null);
        throw new IllegalArgumentException("Couldn't configure SDK. Incompatible store (" + store + ") used");
    }
}
