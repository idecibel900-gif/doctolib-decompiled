package com.revenuecat.purchases.hybridcommon.mappers;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.amazon.AmazonStoreProduct;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.models.InstallmentsInfo;
import com.revenuecat.purchases.models.OfferPaymentMode;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$*\u00020&H\u0002\u001a\u0018\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$*\u00020\u0005\u001a&\u0010#\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$0'*\b\u0012\u0004\u0012\u00020\u00050'H\u0002\u001a8\u0010(\u001a\u00020)*\b\u0012\u0004\u0012\u00020\u00050'2&\u0010*\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$0'\u0012\u0004\u0012\u00020)0+\u001a\u001c\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$*\u00020\u0005H\u0001\u001a\u001c\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$*\u00020\tH\u0002\u001a\u001a\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$*\u00020\tH\u0002\u001a\u001a\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$*\u000200H\u0002\u001a\u001a\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$*\u00020\rH\u0002\u001a\f\u00102\u001a\u000203*\u00020\u0005H\u0001\u001a\f\u00104\u001a\u00020\u0011*\u00020\u0005H\u0001\u001a\"\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$*\u0002062\u0006\u00107\u001a\u00020\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0017\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u001a\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0017\u0010\u001b\u001a\u0004\u0018\u00010\t*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000b\"\u0015\u0010\u001d\u001a\u00020\u0015*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0017\"\u0015\u0010\u001f\u001a\u00020\u0011*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b \u0010\u0013\"\u0015\u0010!\u001a\u00020\u0011*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0013¨\u00068"}, d2 = {"DAYS_PER_WEEK", "", "MICROS_CONVERSION_METRIC", "", "googleFreeTrialCycles", "Lcom/revenuecat/purchases/models/StoreProduct;", "getGoogleFreeTrialCycles", "(Lcom/revenuecat/purchases/models/StoreProduct;)Ljava/lang/Integer;", "googleFreeTrialPeriod", "Lcom/revenuecat/purchases/models/Period;", "getGoogleFreeTrialPeriod", "(Lcom/revenuecat/purchases/models/StoreProduct;)Lcom/revenuecat/purchases/models/Period;", "googleIntroductoryPhase", "Lcom/revenuecat/purchases/models/PricingPhase;", "getGoogleIntroductoryPhase", "(Lcom/revenuecat/purchases/models/StoreProduct;)Lcom/revenuecat/purchases/models/PricingPhase;", "googleIntroductoryPrice", "", "getGoogleIntroductoryPrice", "(Lcom/revenuecat/purchases/models/StoreProduct;)Ljava/lang/String;", "googleIntroductoryPriceAmountMicros", "", "getGoogleIntroductoryPriceAmountMicros", "(Lcom/revenuecat/purchases/models/StoreProduct;)J", "googleIntroductoryPriceCycles", "getGoogleIntroductoryPriceCycles", "(Lcom/revenuecat/purchases/models/StoreProduct;)I", "googleIntroductoryPricePeriod", "getGoogleIntroductoryPricePeriod", "priceAmountMicros", "getPriceAmountMicros", "priceCurrencyCode", "getPriceCurrencyCode", "priceString", "getPriceString", "map", "", "", "Lcom/revenuecat/purchases/models/InstallmentsInfo;", "", "mapAsync", "", "callback", "Lkotlin/Function1;", "mapIntroPrice", "mapPeriod", "mapPeriodForStoreProduct", "mapPrice", "Lcom/revenuecat/purchases/models/Price;", "mapPricingPhase", "mapProductCategory", "Lcom/revenuecat/purchases/hybridcommon/mappers/MappedProductCategory;", "mapProductType", "mapSubscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "storeProduct", "hybridcommon_bc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StoreProductMapperKt {
    private static final int DAYS_PER_WEEK = 7;
    private static final double MICROS_CONVERSION_METRIC = 1000000.0d;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ProductType.values().length];
            try {
                iArr[ProductType.INAPP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProductType.SUBS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProductType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Period.Unit.values().length];
            try {
                iArr2[Period.Unit.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Period.Unit.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Period.Unit.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Period.Unit.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[Period.Unit.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final long getPriceAmountMicros(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        return storeProduct.getPrice().getAmountMicros();
    }

    public static final String getPriceString(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        return storeProduct.getPrice().getFormatted();
    }

    public static final String getPriceCurrencyCode(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        return storeProduct.getPrice().getCurrencyCode();
    }

    public static final Period getGoogleFreeTrialPeriod(StoreProduct storeProduct) {
        PricingPhase freePhase;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption == null || (freePhase = defaultOption.getFreePhase()) == null) {
            return null;
        }
        return freePhase.getBillingPeriod();
    }

    public static final Integer getGoogleFreeTrialCycles(StoreProduct storeProduct) {
        PricingPhase freePhase;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption == null || (freePhase = defaultOption.getFreePhase()) == null) {
            return null;
        }
        return freePhase.getBillingCycleCount();
    }

    private static final PricingPhase getGoogleIntroductoryPhase(StoreProduct storeProduct) {
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption != null) {
            return defaultOption.getIntroPhase();
        }
        return null;
    }

    public static final String getGoogleIntroductoryPrice(StoreProduct storeProduct) {
        Price price;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        PricingPhase googleIntroductoryPhase = getGoogleIntroductoryPhase(storeProduct);
        if (googleIntroductoryPhase == null || (price = googleIntroductoryPhase.getPrice()) == null) {
            return null;
        }
        return price.getFormatted();
    }

    public static final Period getGoogleIntroductoryPricePeriod(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        PricingPhase googleIntroductoryPhase = getGoogleIntroductoryPhase(storeProduct);
        if (googleIntroductoryPhase != null) {
            return googleIntroductoryPhase.getBillingPeriod();
        }
        return null;
    }

    public static final long getGoogleIntroductoryPriceAmountMicros(StoreProduct storeProduct) {
        Price price;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        PricingPhase googleIntroductoryPhase = getGoogleIntroductoryPhase(storeProduct);
        if (googleIntroductoryPhase == null || (price = googleIntroductoryPhase.getPrice()) == null) {
            return 0L;
        }
        return price.getAmountMicros();
    }

    public static final int getGoogleIntroductoryPriceCycles(StoreProduct storeProduct) {
        Integer billingCycleCount;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        PricingPhase googleIntroductoryPhase = getGoogleIntroductoryPhase(storeProduct);
        if (googleIntroductoryPhase == null || (billingCycleCount = googleIntroductoryPhase.getBillingCycleCount()) == null) {
            return 0;
        }
        return billingCycleCount.intValue();
    }

    public static final Map<String, Object> map(StoreProduct storeProduct) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        Pair pair = TuplesKt.to("identifier", storeProduct.getId());
        Pair pair2 = TuplesKt.to(b.c, storeProduct.getDescription());
        Pair pair3 = TuplesKt.to(b.S, storeProduct.getTitle());
        Pair pair4 = TuplesKt.to(b.x, Double.valueOf(getPriceAmountMicros(storeProduct) / 1000000.0d));
        Pair pair5 = TuplesKt.to("priceString", getPriceString(storeProduct));
        Pair pair6 = TuplesKt.to("currencyCode", getPriceCurrencyCode(storeProduct));
        Pair pair7 = TuplesKt.to("introPrice", mapIntroPrice(storeProduct));
        Pair pair8 = TuplesKt.to("discounts", null);
        Price pricePricePerWeek$default = StoreProduct.pricePerWeek$default(storeProduct, null, 1, null);
        Pair pair9 = TuplesKt.to("pricePerWeek", pricePricePerWeek$default != null ? Double.valueOf(pricePricePerWeek$default.getAmountMicros() / 1000000.0d) : null);
        Price pricePricePerMonth$default = StoreProduct.pricePerMonth$default(storeProduct, null, 1, null);
        Pair pair10 = TuplesKt.to("pricePerMonth", pricePricePerMonth$default != null ? Double.valueOf(pricePricePerMonth$default.getAmountMicros() / 1000000.0d) : null);
        Price pricePricePerYear$default = StoreProduct.pricePerYear$default(storeProduct, null, 1, null);
        Pair pair11 = TuplesKt.to("pricePerYear", pricePricePerYear$default != null ? Double.valueOf(pricePricePerYear$default.getAmountMicros() / 1000000.0d) : null);
        Price pricePricePerWeek$default2 = StoreProduct.pricePerWeek$default(storeProduct, null, 1, null);
        Pair pair12 = TuplesKt.to("pricePerWeekString", pricePricePerWeek$default2 != null ? pricePricePerWeek$default2.getFormatted() : null);
        Price pricePricePerMonth$default2 = StoreProduct.pricePerMonth$default(storeProduct, null, 1, null);
        Pair pair13 = TuplesKt.to("pricePerMonthString", pricePricePerMonth$default2 != null ? pricePricePerMonth$default2.getFormatted() : null);
        Price pricePricePerYear$default2 = StoreProduct.pricePerYear$default(storeProduct, null, 1, null);
        Pair pair14 = TuplesKt.to("pricePerYearString", pricePricePerYear$default2 != null ? pricePricePerYear$default2.getFormatted() : null);
        Pair pair15 = TuplesKt.to("productCategory", mapProductCategory(storeProduct).getValue());
        Pair pair16 = TuplesKt.to("productType", mapProductType(storeProduct));
        Period period = storeProduct.getPeriod();
        Pair pair17 = TuplesKt.to(b.o, period != null ? period.getIso8601() : null);
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        Pair pair18 = TuplesKt.to("defaultOption", defaultOption != null ? mapSubscriptionOption(defaultOption, storeProduct) : null);
        SubscriptionOptions subscriptionOptions = storeProduct.getSubscriptionOptions();
        if (subscriptionOptions != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subscriptionOptions, 10));
            Iterator<SubscriptionOption> it = subscriptionOptions.iterator();
            while (it.hasNext()) {
                arrayList.add(mapSubscriptionOption(it.next(), storeProduct));
            }
        } else {
            arrayList = null;
        }
        Pair pair19 = TuplesKt.to("subscriptionOptions", arrayList);
        PresentedOfferingContext presentedOfferingContext = storeProduct.getPresentedOfferingContext();
        Pair pair20 = TuplesKt.to("presentedOfferingIdentifier", presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext2 = storeProduct.getPresentedOfferingContext();
        return MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, pair12, pair13, pair14, pair15, pair16, pair17, pair18, pair19, pair20, TuplesKt.to("presentedOfferingContext", presentedOfferingContext2 != null ? OfferingsMapperKt.map(presentedOfferingContext2) : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Map<String, Object>> map(List<? extends StoreProduct> list) {
        List<? extends StoreProduct> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(map((StoreProduct) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.mappers.StoreProductMapperKt$mapAsync$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.hybridcommon.mappers.StoreProductMapperKt$mapAsync$1", f = "StoreProductMapper.kt", l = {72}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function1 $callback;
        final /* synthetic */ List<StoreProduct> $this_mapAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1 function1, List<? extends StoreProduct> list, Continuation continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$this_mapAsync = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$callback, this.$this_mapAsync, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher mapperDispatcher = MappersHelpersKt.getMapperDispatcher();
                StoreProductMapperKt$mapAsync$1$map$1 storeProductMapperKt$mapAsync$1$map$1 = new StoreProductMapperKt$mapAsync$1$map$1(this.$this_mapAsync, null);
                this.label = 1;
                obj = BuildersKt.withContext(mapperDispatcher, storeProductMapperKt$mapAsync$1$map$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$callback.invoke((List) obj);
            return Unit.INSTANCE;
        }
    }

    public static final void mapAsync(List<? extends StoreProduct> list, Function1 callback) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(MappersHelpersKt.getMainScope(), null, null, new AnonymousClass1(callback, list, null), 3, null);
    }

    public static final MappedProductCategory mapProductCategory(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[storeProduct.getType().ordinal()];
        if (i == 1) {
            return MappedProductCategory.NON_SUBSCRIPTION;
        }
        if (i == 2) {
            return MappedProductCategory.SUBSCRIPTION;
        }
        if (i == 3) {
            return MappedProductCategory.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String mapProductType(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[storeProduct.getType().ordinal()];
        if (i == 1) {
            return "CONSUMABLE";
        }
        if (i != 2) {
            if (i == 3) {
                return "UNKNOWN";
            }
            throw new NoWhenBranchMatchedException();
        }
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption != null && defaultOption.isPrepaid()) {
            return "PREPAID_SUBSCRIPTION";
        }
        return "AUTO_RENEWABLE_SUBSCRIPTION";
    }

    public static final Map<String, Object> mapIntroPrice(StoreProduct storeProduct) {
        Period googleIntroductoryPricePeriod;
        Map<String, Object> mapMapPeriodForStoreProduct;
        Map<String, Object> mapMapPeriodForStoreProduct2;
        Map<String, Object> mapMapPeriodForStoreProduct3;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        if (storeProduct instanceof AmazonStoreProduct) {
            AmazonStoreProduct amazonStoreProduct = (AmazonStoreProduct) storeProduct;
            Period freeTrialPeriod = amazonStoreProduct.getFreeTrialPeriod();
            if (freeTrialPeriod == null || (mapMapPeriodForStoreProduct3 = mapPeriodForStoreProduct(freeTrialPeriod)) == null) {
                return null;
            }
            Pair pair = TuplesKt.to(b.x, 0);
            Pair pair2 = TuplesKt.to("priceString", MappersHelpersKt.formatUsingDeviceLocale(getPriceCurrencyCode(storeProduct), 0L));
            Period freeTrialPeriod2 = amazonStoreProduct.getFreeTrialPeriod();
            return MapsKt.plus(MapsKt.mapOf(pair, pair2, TuplesKt.to("period", freeTrialPeriod2 != null ? freeTrialPeriod2.getIso8601() : null), TuplesKt.to("cycles", 1)), mapMapPeriodForStoreProduct3);
        }
        if (getGoogleFreeTrialPeriod(storeProduct) == null) {
            if (getGoogleIntroductoryPrice(storeProduct) == null || (googleIntroductoryPricePeriod = getGoogleIntroductoryPricePeriod(storeProduct)) == null || (mapMapPeriodForStoreProduct = mapPeriodForStoreProduct(googleIntroductoryPricePeriod)) == null) {
                return null;
            }
            Pair pair3 = TuplesKt.to(b.x, Double.valueOf(getGoogleIntroductoryPriceAmountMicros(storeProduct) / 1000000.0d));
            Pair pair4 = TuplesKt.to("priceString", getGoogleIntroductoryPrice(storeProduct));
            Period googleIntroductoryPricePeriod2 = getGoogleIntroductoryPricePeriod(storeProduct);
            return MapsKt.plus(MapsKt.mapOf(pair3, pair4, TuplesKt.to("period", googleIntroductoryPricePeriod2 != null ? googleIntroductoryPricePeriod2.getIso8601() : null), TuplesKt.to("cycles", Integer.valueOf(getGoogleIntroductoryPriceCycles(storeProduct)))), mapMapPeriodForStoreProduct);
        }
        Period googleFreeTrialPeriod = getGoogleFreeTrialPeriod(storeProduct);
        if (googleFreeTrialPeriod == null || (mapMapPeriodForStoreProduct2 = mapPeriodForStoreProduct(googleFreeTrialPeriod)) == null) {
            return null;
        }
        Pair pair5 = TuplesKt.to(b.x, 0);
        Pair pair6 = TuplesKt.to("priceString", MappersHelpersKt.formatUsingDeviceLocale(getPriceCurrencyCode(storeProduct), 0L));
        Period googleFreeTrialPeriod2 = getGoogleFreeTrialPeriod(storeProduct);
        Pair pair7 = TuplesKt.to("period", googleFreeTrialPeriod2 != null ? googleFreeTrialPeriod2.getIso8601() : null);
        Integer googleFreeTrialCycles = getGoogleFreeTrialCycles(storeProduct);
        return MapsKt.plus(MapsKt.mapOf(pair5, pair6, pair7, TuplesKt.to("cycles", Integer.valueOf(googleFreeTrialCycles != null ? googleFreeTrialCycles.intValue() : 1))), mapMapPeriodForStoreProduct2);
    }

    private static final Map<String, Object> mapPeriodForStoreProduct(Period period) {
        int i = WhenMappings.$EnumSwitchMapping$1[period.getUnit().ordinal()];
        if (i == 1) {
            return MapsKt.mapOf(TuplesKt.to("periodUnit", "DAY"), TuplesKt.to("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        }
        if (i == 2) {
            return MapsKt.mapOf(TuplesKt.to("periodUnit", "DAY"), TuplesKt.to("periodNumberOfUnits", Integer.valueOf(period.getValue() * 7)));
        }
        if (i == 3) {
            return MapsKt.mapOf(TuplesKt.to("periodUnit", "MONTH"), TuplesKt.to("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        }
        if (i == 4) {
            return MapsKt.mapOf(TuplesKt.to("periodUnit", "YEAR"), TuplesKt.to("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        }
        if (i == 5) {
            return MapsKt.mapOf(TuplesKt.to("periodUnit", "DAY"), TuplesKt.to("periodNumberOfUnits", 0));
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final Map<String, Object> mapPeriod(Period period) {
        Map mapMapOf;
        int i = WhenMappings.$EnumSwitchMapping$1[period.getUnit().ordinal()];
        if (i == 1) {
            mapMapOf = MapsKt.mapOf(TuplesKt.to("unit", "DAY"), TuplesKt.to("value", Integer.valueOf(period.getValue())));
        } else if (i == 2) {
            mapMapOf = MapsKt.mapOf(TuplesKt.to("unit", "DAY"), TuplesKt.to("value", Integer.valueOf(period.getValue() * 7)));
        } else if (i == 3) {
            mapMapOf = MapsKt.mapOf(TuplesKt.to("unit", "MONTH"), TuplesKt.to("value", Integer.valueOf(period.getValue())));
        } else if (i == 4) {
            mapMapOf = MapsKt.mapOf(TuplesKt.to("unit", "YEAR"), TuplesKt.to("value", Integer.valueOf(period.getValue())));
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            mapMapOf = MapsKt.mapOf(TuplesKt.to("unit", "DAY"), TuplesKt.to("value", 0));
        }
        return MapsKt.plus(mapMapOf, MapsKt.mapOf(TuplesKt.to("iso8601", period.getIso8601())));
    }

    private static final Map<String, Object> mapSubscriptionOption(SubscriptionOption subscriptionOption, StoreProduct storeProduct) {
        Pair pair = TuplesKt.to(DiagnosticsEntry.ID_KEY, subscriptionOption.get$id());
        Pair pair2 = TuplesKt.to("storeProductId", storeProduct.getId());
        Pair pair3 = TuplesKt.to("productId", storeProduct.getPurchasingData().getProductId());
        List<PricingPhase> pricingPhases = subscriptionOption.getPricingPhases();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pricingPhases, 10));
        Iterator<T> it = pricingPhases.iterator();
        while (it.hasNext()) {
            arrayList.add(mapPricingPhase((PricingPhase) it.next()));
        }
        Pair pair4 = TuplesKt.to("pricingPhases", arrayList);
        Pair pair5 = TuplesKt.to("tags", subscriptionOption.getTags());
        Pair pair6 = TuplesKt.to("isBasePlan", Boolean.valueOf(subscriptionOption.isBasePlan()));
        Period billingPeriod = subscriptionOption.getBillingPeriod();
        Pair pair7 = TuplesKt.to("billingPeriod", billingPeriod != null ? mapPeriod(billingPeriod) : null);
        Pair pair8 = TuplesKt.to("isPrepaid", Boolean.valueOf(subscriptionOption.isPrepaid()));
        PricingPhase fullPricePhase = subscriptionOption.getFullPricePhase();
        Pair pair9 = TuplesKt.to("fullPricePhase", fullPricePhase != null ? mapPricingPhase(fullPricePhase) : null);
        PricingPhase freePhase = subscriptionOption.getFreePhase();
        Pair pair10 = TuplesKt.to("freePhase", freePhase != null ? mapPricingPhase(freePhase) : null);
        PricingPhase introPhase = subscriptionOption.getIntroPhase();
        Pair pair11 = TuplesKt.to("introPhase", introPhase != null ? mapPricingPhase(introPhase) : null);
        PresentedOfferingContext presentedOfferingContext = subscriptionOption.getPresentedOfferingContext();
        Pair pair12 = TuplesKt.to("presentedOfferingIdentifier", presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext2 = subscriptionOption.getPresentedOfferingContext();
        Pair pair13 = TuplesKt.to("presentedOfferingContext", presentedOfferingContext2 != null ? OfferingsMapperKt.map(presentedOfferingContext2) : null);
        InstallmentsInfo installmentsInfo = subscriptionOption.getInstallmentsInfo();
        return MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, pair12, pair13, TuplesKt.to("installmentsInfo", installmentsInfo != null ? map(installmentsInfo) : null));
    }

    private static final Map<String, Object> mapPricingPhase(PricingPhase pricingPhase) {
        Period billingPeriod = pricingPhase.getBillingPeriod();
        Pair pair = TuplesKt.to("billingPeriod", billingPeriod != null ? mapPeriod(billingPeriod) : null);
        Pair pair2 = TuplesKt.to("recurrenceMode", pricingPhase.getRecurrenceMode().getIdentifier());
        Pair pair3 = TuplesKt.to("billingCycleCount", pricingPhase.getBillingCycleCount());
        Pair pair4 = TuplesKt.to(b.x, mapPrice(pricingPhase.getPrice()));
        OfferPaymentMode offerPaymentMode = pricingPhase.getOfferPaymentMode();
        return MapsKt.mapOf(pair, pair2, pair3, pair4, TuplesKt.to("offerPaymentMode", offerPaymentMode != null ? offerPaymentMode.toString() : null));
    }

    private static final Map<String, Object> mapPrice(Price price) {
        return MapsKt.mapOf(TuplesKt.to("formatted", price.getFormatted()), TuplesKt.to("amountMicros", Long.valueOf(price.getAmountMicros())), TuplesKt.to("currencyCode", price.getCurrencyCode()));
    }

    private static final Map<String, Object> map(InstallmentsInfo installmentsInfo) {
        return MapsKt.mapOf(TuplesKt.to("commitmentPaymentsCount", Integer.valueOf(installmentsInfo.getCommitmentPaymentsCount())), TuplesKt.to("renewalCommitmentPaymentsCount", Integer.valueOf(installmentsInfo.getRenewalCommitmentPaymentsCount())));
    }
}
