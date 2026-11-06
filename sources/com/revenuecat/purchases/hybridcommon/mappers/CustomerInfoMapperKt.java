package com.revenuecat.purchases.hybridcommon.mappers;

import android.net.Uri;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.SubscriptionInfo;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.models.Transaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\u0007\u001a,\u0010\u0005\u001a\u00020\u0006*\u00020\u00042 \u0010\u0007\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001\u0012\u0004\u0012\u00020\u00060\b¨\u0006\t"}, d2 = {"map", "", "", "", "Lcom/revenuecat/purchases/CustomerInfo;", "mapAsync", "", "callback", "Lkotlin/Function1;", "hybridcommon_bc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CustomerInfoMapperKt {
    @InternalRevenueCatAPI
    public static final Map<String, Object> map(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "<this>");
        Pair pair = TuplesKt.to(CustomerInfoResponseJsonKeys.ENTITLEMENTS, EntitlementInfosMapperKt.map(customerInfo.getEntitlements()));
        Pair pair2 = TuplesKt.to("activeSubscriptions", CollectionsKt.toList(customerInfo.getActiveSubscriptions()));
        Pair pair3 = TuplesKt.to("allPurchasedProductIdentifiers", CollectionsKt.toList(customerInfo.getAllPurchasedProductIds()));
        Date latestExpirationDate = customerInfo.getLatestExpirationDate();
        Pair pair4 = TuplesKt.to("latestExpirationDate", latestExpirationDate != null ? MappersHelpersKt.toIso8601(latestExpirationDate) : null);
        Date latestExpirationDate2 = customerInfo.getLatestExpirationDate();
        Pair pair5 = TuplesKt.to("latestExpirationDateMillis", latestExpirationDate2 != null ? Long.valueOf(MappersHelpersKt.toMillis(latestExpirationDate2)) : null);
        Pair pair6 = TuplesKt.to("firstSeen", MappersHelpersKt.toIso8601(customerInfo.getFirstSeen()));
        Pair pair7 = TuplesKt.to("firstSeenMillis", Long.valueOf(MappersHelpersKt.toMillis(customerInfo.getFirstSeen())));
        Pair pair8 = TuplesKt.to("originalAppUserId", customerInfo.getOriginalAppUserId());
        Pair pair9 = TuplesKt.to("requestDate", MappersHelpersKt.toIso8601(customerInfo.getRequestDate()));
        Pair pair10 = TuplesKt.to("requestDateMillis", Long.valueOf(MappersHelpersKt.toMillis(customerInfo.getRequestDate())));
        Map<String, Date> allExpirationDatesByProduct = customerInfo.getAllExpirationDatesByProduct();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(allExpirationDatesByProduct.size()));
        Iterator<T> it = allExpirationDatesByProduct.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Date date = (Date) entry.getValue();
            linkedHashMap.put(key, date != null ? MappersHelpersKt.toIso8601(date) : null);
        }
        Pair pair11 = TuplesKt.to("allExpirationDates", linkedHashMap);
        Map<String, Date> allExpirationDatesByProduct2 = customerInfo.getAllExpirationDatesByProduct();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(allExpirationDatesByProduct2.size()));
        Iterator<T> it2 = allExpirationDatesByProduct2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            Object key2 = entry2.getKey();
            Date date2 = (Date) entry2.getValue();
            linkedHashMap2.put(key2, date2 != null ? Long.valueOf(MappersHelpersKt.toMillis(date2)) : null);
        }
        Pair pair12 = TuplesKt.to("allExpirationDatesMillis", linkedHashMap2);
        Map<String, Date> allPurchaseDatesByProduct = customerInfo.getAllPurchaseDatesByProduct();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(allPurchaseDatesByProduct.size()));
        Iterator it3 = allPurchaseDatesByProduct.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it3.next();
            Iterator it4 = it3;
            Object key3 = entry3.getKey();
            Date date3 = (Date) entry3.getValue();
            linkedHashMap3.put(key3, date3 != null ? MappersHelpersKt.toIso8601(date3) : null);
            it3 = it4;
        }
        Pair pair13 = TuplesKt.to("allPurchaseDates", linkedHashMap3);
        Map<String, Date> allPurchaseDatesByProduct2 = customerInfo.getAllPurchaseDatesByProduct();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(allPurchaseDatesByProduct2.size()));
        Iterator it5 = allPurchaseDatesByProduct2.entrySet().iterator();
        while (it5.hasNext()) {
            Map.Entry entry4 = (Map.Entry) it5.next();
            Iterator it6 = it5;
            Object key4 = entry4.getKey();
            Date date4 = (Date) entry4.getValue();
            linkedHashMap4.put(key4, date4 != null ? Long.valueOf(MappersHelpersKt.toMillis(date4)) : null);
            it5 = it6;
        }
        Pair pair14 = TuplesKt.to("allPurchaseDatesMillis", linkedHashMap4);
        Pair pair15 = TuplesKt.to("originalApplicationVersion", null);
        Uri managementURL = customerInfo.getManagementURL();
        Pair pair16 = TuplesKt.to("managementURL", managementURL != null ? managementURL.toString() : null);
        Date originalPurchaseDate = customerInfo.getOriginalPurchaseDate();
        Pair pair17 = TuplesKt.to("originalPurchaseDate", originalPurchaseDate != null ? MappersHelpersKt.toIso8601(originalPurchaseDate) : null);
        Date originalPurchaseDate2 = customerInfo.getOriginalPurchaseDate();
        Pair pair18 = TuplesKt.to("originalPurchaseDateMillis", originalPurchaseDate2 != null ? Long.valueOf(MappersHelpersKt.toMillis(originalPurchaseDate2)) : null);
        List<Transaction> nonSubscriptionTransactions = customerInfo.getNonSubscriptionTransactions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(nonSubscriptionTransactions, 10));
        Iterator<T> it7 = nonSubscriptionTransactions.iterator();
        while (it7.hasNext()) {
            arrayList.add(TransactionMapperKt.map((Transaction) it7.next()));
        }
        Pair pair19 = TuplesKt.to("nonSubscriptionTransactions", arrayList);
        Map<String, SubscriptionInfo> subscriptionsByProductIdentifier = customerInfo.getSubscriptionsByProductIdentifier();
        LinkedHashMap linkedHashMap5 = new LinkedHashMap(MapsKt.mapCapacity(subscriptionsByProductIdentifier.size()));
        for (Iterator it8 = subscriptionsByProductIdentifier.entrySet().iterator(); it8.hasNext(); it8 = it8) {
            Map.Entry entry5 = (Map.Entry) it8.next();
            linkedHashMap5.put(entry5.getKey(), SubscriptionInfoMapperKt.map((SubscriptionInfo) entry5.getValue()));
        }
        return MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, pair12, pair13, pair14, pair15, pair16, pair17, pair18, pair19, TuplesKt.to("subscriptionsByProductIdentifier", linkedHashMap5));
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.mappers.CustomerInfoMapperKt$mapAsync$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.hybridcommon.mappers.CustomerInfoMapperKt$mapAsync$1", f = "CustomerInfoMapper.kt", l = {38}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function1 $callback;
        final /* synthetic */ CustomerInfo $this_mapAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1, CustomerInfo customerInfo, Continuation continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$this_mapAsync = customerInfo;
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
                CustomerInfoMapperKt$mapAsync$1$map$1 customerInfoMapperKt$mapAsync$1$map$1 = new CustomerInfoMapperKt$mapAsync$1$map$1(this.$this_mapAsync, null);
                this.label = 1;
                obj = BuildersKt.withContext(mapperDispatcher, customerInfoMapperKt$mapAsync$1$map$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$callback.invoke((Map) obj);
            return Unit.INSTANCE;
        }
    }

    public static final void mapAsync(CustomerInfo customerInfo, Function1 callback) {
        Intrinsics.checkNotNullParameter(customerInfo, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(MappersHelpersKt.getMainScope(), null, null, new AnonymousClass1(callback, customerInfo, null), 3, null);
    }
}
