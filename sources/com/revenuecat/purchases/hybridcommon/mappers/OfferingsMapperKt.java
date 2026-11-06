package com.revenuecat.purchases.hybridcommon.mappers;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.hybridcommon.CommonKt;
import java.net.URL;
import java.util.ArrayList;
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
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u001a\u001a\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003*\u00020\u0006H\u0002\u001a\u001a\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003*\u00020\u0007H\u0002\u001a\u0018\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003*\u00020\b\u001a\u0018\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003*\u00020\u0001\u001a\u0016\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\t\u001a,\u0010\n\u001a\u00020\u000b*\u00020\u00062 \u0010\f\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0004\u0012\u00020\u000b0\r\u001a,\u0010\n\u001a\u00020\u000b*\u00020\u00072 \u0010\f\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0004\u0012\u00020\u000b0\r¨\u0006\u000e"}, d2 = {"createPresentedOfferingContextFromMap", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "map", "", "", "", "Lcom/revenuecat/purchases/Offering;", "Lcom/revenuecat/purchases/Offerings;", "Lcom/revenuecat/purchases/Package;", "Lcom/revenuecat/purchases/PresentedOfferingContext$TargetingContext;", "mapAsync", "", "callback", "Lkotlin/Function1;", "hybridcommon_bc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OfferingsMapperKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, Object> map(Offerings offerings) {
        Map<String, Offering> all = offerings.getAll();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(all.size()));
        Iterator<T> it = all.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), map((Offering) entry.getValue()));
        }
        Pair pair = TuplesKt.to("all", linkedHashMap);
        Offering current = offerings.getCurrent();
        return MapsKt.mapOf(pair, TuplesKt.to("current", current != null ? map(current) : null));
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$1", f = "OfferingsMapper.kt", l = {21}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function1 $callback;
        final /* synthetic */ Offerings $this_mapAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1, Offerings offerings, Continuation continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$this_mapAsync = offerings;
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
                OfferingsMapperKt$mapAsync$1$map$1 offeringsMapperKt$mapAsync$1$map$1 = new OfferingsMapperKt$mapAsync$1$map$1(this.$this_mapAsync, null);
                this.label = 1;
                obj = BuildersKt.withContext(mapperDispatcher, offeringsMapperKt$mapAsync$1$map$1, this);
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

    public static final void mapAsync(Offerings offerings, Function1 callback) {
        Intrinsics.checkNotNullParameter(offerings, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(MappersHelpersKt.getMainScope(), null, null, new AnonymousClass1(callback, offerings, null), 3, null);
    }

    public static final PresentedOfferingContext createPresentedOfferingContextFromMap(Map<String, ? extends Object> map) {
        if (map != null) {
            return CommonKt.toPresentedOfferingContext(map);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, Object> map(Offering offering) {
        Pair pair = TuplesKt.to("identifier", offering.getIdentifier());
        Pair pair2 = TuplesKt.to("serverDescription", offering.getServerDescription());
        Pair pair3 = TuplesKt.to("metadata", offering.getMetadata());
        List<Package> availablePackages = offering.getAvailablePackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(availablePackages, 10));
        Iterator<T> it = availablePackages.iterator();
        while (it.hasNext()) {
            arrayList.add(map((Package) it.next()));
        }
        Pair pair4 = TuplesKt.to("availablePackages", arrayList);
        Package lifetime = offering.getLifetime();
        Pair pair5 = TuplesKt.to("lifetime", lifetime != null ? map(lifetime) : null);
        Package annual = offering.getAnnual();
        Pair pair6 = TuplesKt.to("annual", annual != null ? map(annual) : null);
        Package sixMonth = offering.getSixMonth();
        Pair pair7 = TuplesKt.to("sixMonth", sixMonth != null ? map(sixMonth) : null);
        Package threeMonth = offering.getThreeMonth();
        Pair pair8 = TuplesKt.to("threeMonth", threeMonth != null ? map(threeMonth) : null);
        Package twoMonth = offering.getTwoMonth();
        Pair pair9 = TuplesKt.to("twoMonth", twoMonth != null ? map(twoMonth) : null);
        Package monthly = offering.getMonthly();
        Pair pair10 = TuplesKt.to("monthly", monthly != null ? map(monthly) : null);
        Package weekly = offering.getWeekly();
        Pair pair11 = TuplesKt.to("weekly", weekly != null ? map(weekly) : null);
        URL webCheckoutURL = offering.getWebCheckoutURL();
        return MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, TuplesKt.to("webCheckoutUrl", webCheckoutURL != null ? webCheckoutURL.toString() : null));
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$2", f = "OfferingsMapper.kt", l = {50}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function1 $callback;
        final /* synthetic */ Offering $this_mapAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Function1 function1, Offering offering, Continuation continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$this_mapAsync = offering;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$callback, this.$this_mapAsync, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher mapperDispatcher = MappersHelpersKt.getMapperDispatcher();
                OfferingsMapperKt$mapAsync$2$map$1 offeringsMapperKt$mapAsync$2$map$1 = new OfferingsMapperKt$mapAsync$2$map$1(this.$this_mapAsync, null);
                this.label = 1;
                obj = BuildersKt.withContext(mapperDispatcher, offeringsMapperKt$mapAsync$2$map$1, this);
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

    public static final void mapAsync(Offering offering, Function1 callback) {
        Intrinsics.checkNotNullParameter(offering, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(MappersHelpersKt.getMainScope(), null, null, new AnonymousClass2(callback, offering, null), 3, null);
    }

    public static final Map<String, Object> map(Package r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Pair pair = TuplesKt.to("identifier", r8.getIdentifier());
        Pair pair2 = TuplesKt.to("packageType", r8.getPackageType().name());
        Pair pair3 = TuplesKt.to("product", StoreProductMapperKt.map(r8.getProduct()));
        Pair pair4 = TuplesKt.to("offeringIdentifier", r8.getPresentedOfferingContext().getOfferingIdentifier());
        Pair pair5 = TuplesKt.to("presentedOfferingContext", map(r8.getPresentedOfferingContext()));
        URL webCheckoutURL = r8.getWebCheckoutURL();
        return MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, TuplesKt.to("webCheckoutUrl", webCheckoutURL != null ? webCheckoutURL.toString() : null));
    }

    public static final Map<String, Object> map(PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "<this>");
        Pair pair = TuplesKt.to("offeringIdentifier", presentedOfferingContext.getOfferingIdentifier());
        Pair pair2 = TuplesKt.to("placementIdentifier", presentedOfferingContext.getPlacementIdentifier());
        PresentedOfferingContext.TargetingContext targetingContext = presentedOfferingContext.getTargetingContext();
        return MapsKt.mapOf(pair, pair2, TuplesKt.to("targetingContext", targetingContext != null ? map(targetingContext) : null));
    }

    public static final Map<String, Object> map(PresentedOfferingContext.TargetingContext targetingContext) {
        Intrinsics.checkNotNullParameter(targetingContext, "<this>");
        return MapsKt.mapOf(TuplesKt.to("revision", Integer.valueOf(targetingContext.getRevision())), TuplesKt.to("ruleId", targetingContext.getRuleId()));
    }
}
