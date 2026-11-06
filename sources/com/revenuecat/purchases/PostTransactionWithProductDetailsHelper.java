package com.revenuecat.purchases;

import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J|\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\"\b\u0002\u0010\u0013\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014j\u0004\u0018\u0001`\u00162\"\b\u0002\u0010\u0017\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014j\u0004\u0018\u0001`\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/revenuecat/purchases/PostTransactionWithProductDetailsHelper;", "", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "postReceiptHelper", "Lcom/revenuecat/purchases/PostReceiptHelper;", "(Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/PostReceiptHelper;)V", "postTransactions", "", "transactions", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "allowSharingPlayStoreAccount", "", "appUserID", "", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "sdkOriginated", "transactionPostSuccess", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/CustomerInfo;", "Lcom/revenuecat/purchases/SuccessfulPurchaseCallback;", "transactionPostError", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/ErrorPurchaseCallback;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PostTransactionWithProductDetailsHelper {
    private final BillingAbstract billing;
    private final PostReceiptHelper postReceiptHelper;

    public PostTransactionWithProductDetailsHelper(BillingAbstract billing, PostReceiptHelper postReceiptHelper) {
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(postReceiptHelper, "postReceiptHelper");
        this.billing = billing;
        this.postReceiptHelper = postReceiptHelper;
    }

    public static /* synthetic */ void postTransactions$default(PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, List list, boolean z, String str, PostReceiptInitiationSource postReceiptInitiationSource, boolean z2, Function2 function2, Function2 function3, int i, Object obj) {
        if ((i & 32) != 0) {
            function2 = null;
        }
        if ((i & 64) != 0) {
            function3 = null;
        }
        postTransactionWithProductDetailsHelper.postTransactions(list, z, str, postReceiptInitiationSource, z2, function2, function3);
    }

    public final void postTransactions(List<StoreTransaction> transactions, final boolean allowSharingPlayStoreAccount, String appUserID, PostReceiptInitiationSource initiationSource, final boolean sdkOriginated, final Function2 transactionPostSuccess, final Function2 transactionPostError) {
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        final String appUserID2 = appUserID;
        Intrinsics.checkNotNullParameter(appUserID2, "appUserID");
        final PostReceiptInitiationSource initiationSource2 = initiationSource;
        Intrinsics.checkNotNullParameter(initiationSource2, "initiationSource");
        for (final StoreTransaction storeTransaction : transactions) {
            BillingAbstract billingAbstract = this.billing;
            ProductType type = storeTransaction.getType();
            Set<String> set = CollectionsKt.toSet(storeTransaction.getProductIds());
            Function1 function1 = new Function1() { // from class: com.revenuecat.purchases.PostTransactionWithProductDetailsHelper$postTransactions$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List<? extends StoreProduct>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(List<? extends StoreProduct> storeProducts) {
                    Object next;
                    StoreProduct storeProduct;
                    Collection collectionEmptyList;
                    Object next2;
                    Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
                    Map<String, ? extends SubscriptionOption> mapBuild = null;
                    if (storeTransaction.getType() != ProductType.SUBS || storeTransaction.getMarketplace() != null) {
                        StoreTransaction storeTransaction2 = storeTransaction;
                        Iterator<T> it = storeProducts.iterator();
                        do {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                        } while (!Intrinsics.areEqual(((StoreProduct) next).getId(), CollectionsKt.firstOrNull((List) storeTransaction2.getProductIds())));
                        storeProduct = (StoreProduct) next;
                    } else {
                        StoreTransaction storeTransaction3 = storeTransaction;
                        Iterator<T> it2 = storeProducts.iterator();
                        loop0: while (true) {
                            if (!it2.hasNext()) {
                                next2 = null;
                                break;
                            }
                            next2 = it2.next();
                            SubscriptionOptions subscriptionOptions = ((StoreProduct) next2).getSubscriptionOptions();
                            if (subscriptionOptions != null && !subscriptionOptions.isEmpty()) {
                                Iterator<SubscriptionOption> it3 = subscriptionOptions.iterator();
                                while (it3.hasNext()) {
                                    if (Intrinsics.areEqual(it3.next().get$id(), storeTransaction3.getSubscriptionOptionId())) {
                                        break loop0;
                                    }
                                }
                            }
                        }
                        storeProduct = (StoreProduct) next2;
                    }
                    StoreProduct storeProduct2 = storeProduct;
                    Map subscriptionOptionIdForProductIDs = storeTransaction.getSubscriptionOptionIdForProductIDs();
                    if (subscriptionOptionIdForProductIDs != null) {
                        ArrayList<GoogleStoreProduct> arrayList = new ArrayList();
                        for (Object obj : storeProducts) {
                            if (obj instanceof GoogleStoreProduct) {
                                arrayList.add(obj);
                            }
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (GoogleStoreProduct googleStoreProduct : arrayList) {
                            SubscriptionOptions subscriptionOptions2 = googleStoreProduct.getSubscriptionOptions();
                            if (subscriptionOptions2 == null) {
                                collectionEmptyList = CollectionsKt.emptyList();
                            } else {
                                collectionEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subscriptionOptions2, 10));
                                for (SubscriptionOption subscriptionOption : subscriptionOptions2) {
                                    collectionEmptyList.add(TuplesKt.to(googleStoreProduct.getProductId() + '_' + subscriptionOption.get$id(), subscriptionOption));
                                }
                            }
                            CollectionsKt.addAll(arrayList2, collectionEmptyList);
                        }
                        Map map = MapsKt.toMap(arrayList2);
                        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                        for (Map.Entry entry : subscriptionOptionIdForProductIDs.entrySet()) {
                            String str = (String) entry.getKey();
                            SubscriptionOption subscriptionOption2 = (SubscriptionOption) map.get(str + '_' + ((String) entry.getValue()));
                            if (subscriptionOption2 != null) {
                                mapCreateMapBuilder.put(str, subscriptionOption2);
                            }
                        }
                        mapBuild = MapsKt.build(mapCreateMapBuilder);
                    }
                    Map<String, ? extends SubscriptionOption> map2 = mapBuild;
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.d("[Purchases] - " + logLevel.name(), "Store product found for transaction: " + storeProduct2);
                    }
                    this.postReceiptHelper.postTransactionAndConsumeIfNeeded(storeTransaction, storeProduct2, map2, allowSharingPlayStoreAccount, appUserID2, initiationSource2, sdkOriginated, transactionPostSuccess, transactionPostError);
                }
            };
            appUserID2 = appUserID;
            initiationSource2 = initiationSource;
            billingAbstract.queryProductDetailsAsync(type, set, function1, new Function1() { // from class: com.revenuecat.purchases.PostTransactionWithProductDetailsHelper$postTransactions$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((PurchasesError) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(PurchasesError it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.this$0.postReceiptHelper.postTransactionAndConsumeIfNeeded(storeTransaction, null, null, allowSharingPlayStoreAccount, appUserID2, initiationSource2, sdkOriginated, transactionPostSuccess, transactionPostError);
                }
            });
        }
    }
}
