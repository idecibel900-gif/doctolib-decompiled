package com.revenuecat.purchases.amazon;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.networking.Endpoint;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JE\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R²\u0001\u0010\u0019\u001aF\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00060\u0013j\u0002`\u0014\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\t0\u0016j\u0002`\u00170\u00150\u00122J\u0010\u0018\u001aF\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00060\u0013j\u0002`\u0014\u00122\u00120\u0012,\u0012*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\t0\u0016j\u0002`\u00170\u00150\u00128F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/amazon/AmazonBackend;", "", "Lcom/revenuecat/purchases/common/BackendHelper;", "backendHelper", "<init>", "(Lcom/revenuecat/purchases/common/BackendHelper;)V", "", b.E, "storeUserID", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "", "onSuccess", "Lcom/revenuecat/purchases/PurchasesError;", "onError", "getAmazonReceiptData", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/revenuecat/purchases/common/BackendHelper;", "", "", "Lcom/revenuecat/purchases/amazon/CallbackCacheKey;", "", "Lkotlin/Pair;", "Lcom/revenuecat/purchases/amazon/PostAmazonReceiptCallback;", "<set-?>", "postAmazonReceiptCallbacks", "Ljava/util/Map;", "getPostAmazonReceiptCallbacks", "()Ljava/util/Map;", "setPostAmazonReceiptCallbacks", "(Ljava/util/Map;)V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AmazonBackend {
    private final BackendHelper backendHelper;
    private volatile Map<List<String>, List<Pair<Function1, Function1>>> postAmazonReceiptCallbacks;

    public AmazonBackend(BackendHelper backendHelper) {
        Intrinsics.checkNotNullParameter(backendHelper, "backendHelper");
        this.backendHelper = backendHelper;
        this.postAmazonReceiptCallbacks = new LinkedHashMap();
    }

    public final synchronized Map<List<String>, List<Pair<Function1, Function1>>> getPostAmazonReceiptCallbacks() {
        return this.postAmazonReceiptCallbacks;
    }

    public final synchronized void setPostAmazonReceiptCallbacks(Map<List<String>, List<Pair<Function1, Function1>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.postAmazonReceiptCallbacks = map;
    }

    public final void getAmazonReceiptData(final String receiptId, final String storeUserID, Function1 onSuccess, Function1 onError) {
        Intrinsics.checkNotNullParameter(receiptId, "receiptId");
        Intrinsics.checkNotNullParameter(storeUserID, "storeUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final List<String> listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{receiptId, storeUserID});
        Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.amazon.AmazonBackend$getAmazonReceiptData$call$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m3847invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m3847invoke() {
                BackendHelper backendHelper = this.this$0.backendHelper;
                Endpoint.GetAmazonReceipt getAmazonReceipt = new Endpoint.GetAmazonReceipt(storeUserID, receiptId);
                Delay delay = Delay.NONE;
                final AmazonBackend amazonBackend = this.this$0;
                final List<String> list = listListOfNotNull;
                Function1 function1 = new Function1() { // from class: com.revenuecat.purchases.amazon.AmazonBackend$getAmazonReceiptData$call$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((PurchasesError) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PurchasesError error) {
                        List<Pair<Function1, Function1>> listRemove;
                        Intrinsics.checkNotNullParameter(error, "error");
                        AmazonBackend amazonBackend2 = amazonBackend;
                        List<String> list2 = list;
                        synchronized (amazonBackend2) {
                            listRemove = amazonBackend2.getPostAmazonReceiptCallbacks().remove(list2);
                        }
                        if (listRemove != null) {
                            Iterator<T> it = listRemove.iterator();
                            while (it.hasNext()) {
                                ((Function1) ((Pair) it.next()).getSecond()).invoke(error);
                            }
                        }
                    }
                };
                final AmazonBackend amazonBackend2 = this.this$0;
                final List<String> list2 = listListOfNotNull;
                backendHelper.performRequest(getAmazonReceipt, null, null, delay, function1, new Function3() { // from class: com.revenuecat.purchases.amazon.AmazonBackend$getAmazonReceiptData$call$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((PurchasesError) obj, ((Number) obj2).intValue(), (JSONObject) obj3);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PurchasesError purchasesError, int i, JSONObject body) {
                        List<Pair<Function1, Function1>> listRemove;
                        Intrinsics.checkNotNullParameter(body, "body");
                        AmazonBackend amazonBackend3 = amazonBackend2;
                        List<String> list3 = list2;
                        synchronized (amazonBackend3) {
                            listRemove = amazonBackend3.getPostAmazonReceiptCallbacks().remove(list3);
                        }
                        if (listRemove != null) {
                            Iterator<T> it = listRemove.iterator();
                            while (it.hasNext()) {
                                Pair pair = (Pair) it.next();
                                Function1 function2 = (Function1) pair.getFirst();
                                Function1 function3 = (Function1) pair.getSecond();
                                if (purchasesError != null) {
                                    function3.invoke(purchasesError);
                                } else {
                                    function2.invoke(body);
                                }
                            }
                        }
                    }
                });
            }
        };
        Pair<Function1, Function1> pair = TuplesKt.to(onSuccess, onError);
        synchronized (this) {
            try {
                if (!this.postAmazonReceiptCallbacks.containsKey(listListOfNotNull)) {
                    this.postAmazonReceiptCallbacks.put(listListOfNotNull, CollectionsKt.mutableListOf(pair));
                    function0.invoke();
                    Unit unit = Unit.INSTANCE;
                } else {
                    List<Pair<Function1, Function1>> list = this.postAmazonReceiptCallbacks.get(listListOfNotNull);
                    Intrinsics.checkNotNull(list);
                    list.add(pair);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
