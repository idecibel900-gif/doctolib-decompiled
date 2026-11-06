package com.revenuecat.purchases;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.a.a.o.b;
import com.google.firebase.messaging.Constants;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.ads.events.AdTracker;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.deeplinks.DeepLinkParser;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback;
import com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback;
import com.revenuecat.purchases.interfaces.GetStoreProductsCallback;
import com.revenuecat.purchases.interfaces.GetStorefrontCallback;
import com.revenuecat.purchases.interfaces.GetStorefrontLocaleCallback;
import com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import com.revenuecat.purchases.models.BillingFeature;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.DownloadedFontFamily;
import com.revenuecat.purchases.paywalls.events.CustomPaywallEvent;
import com.revenuecat.purchases.paywalls.events.CustomPaywallImpressionParams;
import com.revenuecat.purchases.storage.FileRepository;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.ConfigureStrings;
import com.revenuecat.purchases.utils.DefaultIsDebugBuildProvider;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000à\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ø\u00012\u00020\u0001:\u0002ø\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u0014H\u0087@¢\u0006\u0002\u0010`J\u0006\u0010a\u001a\u00020bJ\u0006\u0010c\u001a\u00020bJ@\u0010d\u001a\u00020b2\u0006\u0010e\u001a\u00020\u00142\u0006\u0010f\u001a\u00020\u00142\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020b0h2\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020b0hH\u0007J\u000e\u0010k\u001a\u00020b2\u0006\u0010l\u001a\u00020mJ\u0012\u0010n\u001a\u0004\u0018\u00010o2\u0006\u0010p\u001a\u00020qH\u0007J\u0015\u0010r\u001a\u00020b2\u0006\u0010l\u001a\u00020sH\u0000¢\u0006\u0002\btJ\u0016\u0010u\u001a\u00020b2\u0006\u0010v\u001a\u00020w2\u0006\u0010l\u001a\u00020xJ\u000e\u0010u\u001a\u00020b2\u0006\u0010l\u001a\u00020xJ\u001e\u0010y\u001a\u00020b2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00140{2\u0006\u0010l\u001a\u00020|H\u0007J\u000e\u0010}\u001a\u00020b2\u0006\u0010~\u001a\u00020\u007fJ+\u0010\u0080\u0001\u001a\u00020b2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00140{2\f\b\u0002\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u00012\u0006\u0010l\u001a\u00020|J\u001d\u0010\u0080\u0001\u001a\u00020b2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00140{2\u0006\u0010l\u001a\u00020|J\u000f\u0010I\u001a\u00020b2\u0007\u0010l\u001a\u00030\u0083\u0001J\u0011\u0010M\u001a\u00020b2\u0007\u0010l\u001a\u00030\u0084\u0001H\u0007J\u001f\u0010\u0085\u0001\u001a\u00020b2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00140{2\u0006\u0010l\u001a\u00020|H\u0007J\u0010\u0010\u0086\u0001\u001a\u00020b2\u0007\u0010l\u001a\u00030\u0087\u0001J\u0007\u0010\u0088\u0001\u001a\u00020bJ\u0007\u0010\u0089\u0001\u001a\u00020bJ\u001f\u0010\u008a\u0001\u001a\u00020b2\u0007\u0010\u008b\u0001\u001a\u00020\u00142\u000b\b\u0002\u0010l\u001a\u0005\u0018\u00010\u008c\u0001H\u0007J\u0015\u0010\u008d\u0001\u001a\u00020b2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010xH\u0007J\t\u0010\u008e\u0001\u001a\u00020bH\u0017J\t\u0010\u008f\u0001\u001a\u00020bH\u0017J\u0012\u0010\u0090\u0001\u001a\u00020\f2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0014J\u001a\u0010\u0092\u0001\u001a\u00020b2\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0007\u0010l\u001a\u00030\u0095\u0001J&\u0010\u0096\u0001\u001a\u00020b2\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010~\u001a\u00030\u0095\u0001H\u0007J&\u0010\u009b\u0001\u001a\u00020b2\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0007\u0010l\u001a\u00030\u0095\u0001H\u0007J\u001a\u0010\u009e\u0001\u001a\u00020b2\b\u0010\u009f\u0001\u001a\u00030 \u00012\u0007\u0010~\u001a\u00030¡\u0001J\u0007\u0010¢\u0001\u001a\u00020bJ\u000f\u0010£\u0001\u001a\u00020b2\u0006\u0010l\u001a\u00020xJ\u0012\u0010¤\u0001\u001a\u00020b2\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010¦\u0001\u001a\u00020b2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010¨\u0001\u001a\u00020b2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010ª\u0001\u001a\u00020b2\t\u0010«\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010¬\u0001\u001a\u00020b2\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0014J\u001b\u0010®\u0001\u001a\u00020b2\u0012\u0010¯\u0001\u001a\r\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010°\u0001J\u0012\u0010±\u0001\u001a\u00020b2\t\u0010²\u0001\u001a\u0004\u0018\u00010\u0014J&\u0010³\u0001\u001a\u00020b2\u0014\u0010¯\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140°\u00012\u0007\u0010l\u001a\u00030´\u0001J\u001f\u0010µ\u0001\u001a\u00020b2\u0016\u0010¶\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00140°\u0001J\u0012\u0010·\u0001\u001a\u00020b2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010¹\u0001\u001a\u00020b2\t\u0010º\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010»\u0001\u001a\u00020b2\t\u0010¼\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010½\u0001\u001a\u00020b2\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u0014J\u0011\u0010¿\u0001\u001a\u00020b2\b\u0010e\u001a\u0004\u0018\u00010\u0014J\u0012\u0010À\u0001\u001a\u00020b2\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010Â\u0001\u001a\u00020b2\t\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010Ä\u0001\u001a\u00020b2\t\u0010Å\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010Æ\u0001\u001a\u00020b2\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010È\u0001\u001a\u00020b2\t\u0010É\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010Ê\u0001\u001a\u00020b2\t\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010Ì\u0001\u001a\u00020b2\t\u0010Í\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010Î\u0001\u001a\u00020b2\t\u0010Ï\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010Ð\u0001\u001a\u00020b2\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010Ò\u0001\u001a\u00020b2\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010Ô\u0001\u001a\u00020b2\t\u0010Õ\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010Ö\u0001\u001a\u00020b2\t\u0010×\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010Ø\u0001\u001a\u00020b2\t\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010Ú\u0001\u001a\u00020b2\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010Ü\u0001\u001a\u00020b2\t\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010Þ\u0001\u001a\u00020b2\t\u0010ß\u0001\u001a\u0004\u0018\u00010\u0014J%\u0010à\u0001\u001a\u00020b2\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\u0010\b\u0002\u0010á\u0001\u001a\t\u0012\u0005\u0012\u00030â\u00010{H\u0007JA\u0010ã\u0001\u001a\u00020b2\u0007\u0010ä\u0001\u001a\u00020\u00142\u0007\u0010å\u0001\u001a\u00020\u00142\u0007\u0010æ\u0001\u001a\u00020\u00142\t\u0010ç\u0001\u001a\u0004\u0018\u00010\u00142\n\u0010è\u0001\u001a\u0005\u0018\u00010é\u0001H\u0007¢\u0006\u0003\u0010ê\u0001JI\u0010ã\u0001\u001a\u00020b2\u0007\u0010ä\u0001\u001a\u00020\u00142\u0007\u0010å\u0001\u001a\u00020\u00142\u0007\u0010æ\u0001\u001a\u00020\u00142\t\u0010ç\u0001\u001a\u0004\u0018\u00010\u00142\n\u0010è\u0001\u001a\u0005\u0018\u00010é\u00012\b\u0010ë\u0001\u001a\u00030ì\u0001¢\u0006\u0003\u0010í\u0001J\u0010\u0010î\u0001\u001a\u00020b2\u0007\u0010l\u001a\u00030´\u0001JA\u0010ï\u0001\u001a\u00020b2\u0007\u0010ä\u0001\u001a\u00020\u00142\u0007\u0010å\u0001\u001a\u00020\u00142\u0007\u0010æ\u0001\u001a\u00020\u00142\t\u0010ç\u0001\u001a\u0004\u0018\u00010\u00142\n\u0010è\u0001\u001a\u0005\u0018\u00010é\u0001H\u0007¢\u0006\u0003\u0010ê\u0001J\u0016\u0010ð\u0001\u001a\u00020b2\u000b\b\u0002\u0010~\u001a\u0005\u0018\u00010ñ\u0001H\u0007J\u0013\u0010ò\u0001\u001a\u00020b2\b\u0010ó\u0001\u001a\u00030ô\u0001H\u0007J\u0015\u0010õ\u0001\u001a\u00020b2\n\b\u0002\u0010ö\u0001\u001a\u00030÷\u0001H\u0007R\u001a\u0010\u0005\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR*\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR/\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001f\u001a\u0004\u0018\u00010 8F@FX\u0086\u008e\u0002¢\u0006\u0012\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'*\u0004\b\"\u0010#R5\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u001f\u001a\u0004\u0018\u00010(8F@FX\u0087\u008e\u0002¢\u0006\u0018\u0012\u0004\b*\u0010\b\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/*\u0004\b+\u0010#R\u001a\u00100\u001a\u0002018FX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010\b\u001a\u0004\b3\u00104R*\u00105\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b6\u0010\b\u001a\u0004\b7\u0010\u0010\"\u0004\b8\u0010\u0012R\u0011\u00109\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b9\u0010\u0010R\u0013\u0010:\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b;\u0010\u0016R$\u0010=\u001a\u00020<2\u0006\u0010\u000b\u001a\u00020<8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010D\u001a\u00020E8F¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0013\u0010H\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\bI\u0010\u0016R\u001c\u0010J\u001a\u0004\u0018\u00010K8FX\u0087\u0004¢\u0006\f\u0012\u0004\bL\u0010\b\u001a\u0004\bM\u0010NR5\u0010P\u001a\u0004\u0018\u00010O2\b\u0010\u001f\u001a\u0004\u0018\u00010O8F@FX\u0087\u008e\u0002¢\u0006\u0018\u0012\u0004\bQ\u0010\b\u001a\u0004\bS\u0010T\"\u0004\bU\u0010V*\u0004\bR\u0010#R(\u0010X\u001a\u0004\u0018\u00010W2\b\u0010\u000b\u001a\u0004\u0018\u00010W8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\¨\u0006ù\u0001"}, d2 = {"Lcom/revenuecat/purchases/Purchases;", "Lcom/revenuecat/purchases/LifecycleDelegate;", "purchasesOrchestrator", "Lcom/revenuecat/purchases/PurchasesOrchestrator;", "(Lcom/revenuecat/purchases/PurchasesOrchestrator;)V", "adTracker", "Lcom/revenuecat/purchases/ads/events/AdTracker;", "getAdTracker$annotations", "()V", "getAdTracker", "()Lcom/revenuecat/purchases/ads/events/AdTracker;", "value", "", "allowSharingPlayStoreAccount", "getAllowSharingPlayStoreAccount$annotations", "getAllowSharingPlayStoreAccount", "()Z", "setAllowSharingPlayStoreAccount", "(Z)V", "appUserID", "", "getAppUserID", "()Ljava/lang/String;", "cachedVirtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "getCachedVirtualCurrencies", "()Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "currentConfiguration", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "getCurrentConfiguration", "()Lcom/revenuecat/purchases/PurchasesConfiguration;", "<set-?>", "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "customerCenterListener", "getCustomerCenterListener$delegate", "(Lcom/revenuecat/purchases/Purchases;)Ljava/lang/Object;", "getCustomerCenterListener", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "setCustomerCenterListener", "(Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;)V", "Lcom/revenuecat/purchases/DebugEventListener;", "debugEventListener", "getDebugEventListener$annotations", "getDebugEventListener$delegate", "getDebugEventListener", "()Lcom/revenuecat/purchases/DebugEventListener;", "setDebugEventListener", "(Lcom/revenuecat/purchases/DebugEventListener;)V", "fileRepository", "Lcom/revenuecat/purchases/storage/FileRepository;", "getFileRepository$annotations", "getFileRepository", "()Lcom/revenuecat/purchases/storage/FileRepository;", "finishTransactions", "getFinishTransactions$annotations", "getFinishTransactions", "setFinishTransactions", "isAnonymous", "preferredUILocaleOverride", "getPreferredUILocaleOverride", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "purchasesAreCompletedBy", "getPurchasesAreCompletedBy", "()Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "setPurchasesAreCompletedBy", "(Lcom/revenuecat/purchases/PurchasesAreCompletedBy;)V", "getPurchasesOrchestrator$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/PurchasesOrchestrator;", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "getStore", "()Lcom/revenuecat/purchases/Store;", "storefrontCountryCode", "getStorefrontCountryCode", "storefrontLocale", "Ljava/util/Locale;", "getStorefrontLocale$annotations", "getStorefrontLocale", "()Ljava/util/Locale;", "Lcom/revenuecat/purchases/TrackedEventListener;", "trackedEventListener", "getTrackedEventListener$annotations", "getTrackedEventListener$delegate", "getTrackedEventListener", "()Lcom/revenuecat/purchases/TrackedEventListener;", "setTrackedEventListener", "(Lcom/revenuecat/purchases/TrackedEventListener;)V", "Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "updatedCustomerInfoListener", "getUpdatedCustomerInfoListener", "()Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;", "setUpdatedCustomerInfoListener", "(Lcom/revenuecat/purchases/interfaces/UpdatedCustomerInfoListener;)V", "awaitGetWorkflow", "Lcom/revenuecat/purchases/common/workflows/WorkflowDataResult;", "workflowId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "", "collectDeviceIdentifiers", "createSupportTicket", AuthorizationRequest.Scope.EMAIL, b.c, "onSuccess", "Lkotlin/Function1;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "getAmazonLWAConsentStatus", "callback", "Lcom/revenuecat/purchases/interfaces/GetAmazonLWAConsentStatusCallback;", "getCachedFontFamilyOrStartDownload", "Lcom/revenuecat/purchases/paywalls/DownloadedFontFamily;", "fontInfo", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "getCustomerCenterConfigData", "Lcom/revenuecat/purchases/interfaces/GetCustomerCenterConfigCallback;", "getCustomerCenterConfigData$purchases_defaultsBc8Release", "getCustomerInfo", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "Lcom/revenuecat/purchases/interfaces/ReceiveCustomerInfoCallback;", "getNonSubscriptionSkus", "productIds", "", "Lcom/revenuecat/purchases/interfaces/GetStoreProductsCallback;", "getOfferings", "listener", "Lcom/revenuecat/purchases/interfaces/ReceiveOfferingsCallback;", "getProducts", "type", "Lcom/revenuecat/purchases/ProductType;", "Lcom/revenuecat/purchases/interfaces/GetStorefrontCallback;", "Lcom/revenuecat/purchases/interfaces/GetStorefrontLocaleCallback;", "getSubscriptionSkus", "getVirtualCurrencies", "Lcom/revenuecat/purchases/interfaces/GetVirtualCurrenciesCallback;", "invalidateCustomerInfoCache", "invalidateVirtualCurrenciesCache", "logIn", "newAppUserID", "Lcom/revenuecat/purchases/interfaces/LogInCallback;", "logOut", "onAppBackgrounded", "onAppForegrounded", "overridePreferredUILocale", "localeString", "purchase", "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams;", "Lcom/revenuecat/purchases/interfaces/PurchaseCallback;", "purchasePackage", "activity", "Landroid/app/Activity;", "packageToPurchase", "Lcom/revenuecat/purchases/Package;", "purchaseProduct", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "redeemWebPurchase", "webPurchaseRedemption", "Lcom/revenuecat/purchases/WebPurchaseRedemption;", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener;", "removeUpdatedCustomerInfoListener", "restorePurchases", "setAd", "ad", "setAdGroup", "adGroup", "setAdjustID", "adjustID", "setAirbridgeDeviceID", "airbridgeDeviceID", "setAirshipChannelID", "airshipChannelID", "setAppsFlyerConversionData", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "setAppsflyerID", "appsflyerID", "setAppstackAttributionParams", "Lcom/revenuecat/purchases/interfaces/SyncAttributesAndOfferingsCallback;", "setAttributes", "attributes", "setCampaign", Constants.ScionAnalytics.PARAM_CAMPAIGN, "setCleverTapID", "cleverTapID", "setCreative", "creative", "setDisplayName", "displayName", "setEmail", "setFBAnonymousID", "fbAnonymousID", "setFirebaseAppInstanceID", "firebaseAppInstanceID", "setKeyword", "keyword", "setKochavaDeviceID", "kochavaDeviceID", "setMediaSource", "mediaSource", "setMixpanelDistinctID", "mixpanelDistinctID", "setMparticleID", "mparticleID", "setOnesignalID", "onesignalID", "setOnesignalUserID", "onesignalUserID", "setPhoneNumber", "phoneNumber", "setPostHogUserId", "postHogUserId", "setPushToken", "fcmToken", "setSolarEngineAccountId", "solarEngineAccountId", "setSolarEngineDistinctId", "solarEngineDistinctId", "setSolarEngineVisitorId", "solarEngineVisitorId", "setTenjinAnalyticsInstallationID", "tenjinAnalyticsInstallationID", "showInAppMessagesIfNeeded", "inAppMessageTypes", "Lcom/revenuecat/purchases/models/InAppMessageType;", "syncAmazonPurchase", "productID", "receiptID", "amazonUserID", "isoCurrencyCode", b.x, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "purchaseTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;J)V", "syncAttributesAndOfferingsIfNeeded", "syncObserverModeAmazonPurchase", "syncPurchases", "Lcom/revenuecat/purchases/interfaces/SyncPurchasesCallback;", "track", "event", "Lcom/revenuecat/purchases/common/events/FeatureEvent;", "trackCustomPaywallImpression", "params", "Lcom/revenuecat/purchases/paywalls/events/CustomPaywallImpressionParams;", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Purchases implements LifecycleDelegate {
    private static /* synthetic */ Purchases backingFieldSharedInstance;
    private final PurchasesOrchestrator purchasesOrchestrator;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String frameworkVersion = "10.3.1";

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchasesAreCompletedBy.values().length];
            try {
                iArr[PurchasesAreCompletedBy.REVENUECAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchasesAreCompletedBy.MY_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void canMakePayments(Context context, Callback<Boolean> callback) {
        INSTANCE.canMakePayments(context, callback);
    }

    public static final void canMakePayments(Context context, List<? extends BillingFeature> list, Callback<Boolean> callback) {
        INSTANCE.canMakePayments(context, list, callback);
    }

    public static final Purchases configure(PurchasesConfiguration purchasesConfiguration) {
        return INSTANCE.configure(purchasesConfiguration);
    }

    @ExperimentalPreviewRevenueCatPurchasesAPI
    public static /* synthetic */ void getAdTracker$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getAllowSharingPlayStoreAccount$annotations() {
    }

    @InternalRevenueCatAPI
    public static /* synthetic */ void getDebugEventListener$annotations() {
    }

    public static final boolean getDebugLogsEnabled() {
        return INSTANCE.getDebugLogsEnabled();
    }

    @InternalRevenueCatAPI
    public static /* synthetic */ void getFileRepository$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getFinishTransactions$annotations() {
    }

    public static final String getFrameworkVersion() {
        return INSTANCE.getFrameworkVersion();
    }

    public static final LogLevel getLogLevel() {
        return INSTANCE.getLogLevel();
    }

    public static final PlatformInfo getPlatformInfo() {
        return INSTANCE.getPlatformInfo();
    }

    public static final URL getProxyURL() {
        return INSTANCE.getProxyURL();
    }

    public static final Purchases getSharedInstance() {
        return INSTANCE.getSharedInstance();
    }

    @ExperimentalPreviewRevenueCatPurchasesAPI
    public static /* synthetic */ void getStorefrontLocale$annotations() {
    }

    @InternalRevenueCatAPI
    public static /* synthetic */ void getTrackedEventListener$annotations() {
    }

    public static final boolean isConfigured() {
        return INSTANCE.isConfigured();
    }

    public static final WebPurchaseRedemption parseAsWebPurchaseRedemption(Intent intent) {
        return INSTANCE.parseAsWebPurchaseRedemption(intent);
    }

    public static final WebPurchaseRedemption parseAsWebPurchaseRedemption(String str) {
        return INSTANCE.parseAsWebPurchaseRedemption(str);
    }

    public static final void setDebugLogsEnabled(boolean z) {
        INSTANCE.setDebugLogsEnabled(z);
    }

    public static final void setLogLevel(LogLevel logLevel) {
        INSTANCE.setLogLevel(logLevel);
    }

    public static final void setPlatformInfo(PlatformInfo platformInfo) {
        INSTANCE.setPlatformInfo(platformInfo);
    }

    public static final void setProxyURL(URL url) {
        INSTANCE.setProxyURL(url);
    }

    public final void logIn(String newAppUserID) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        logIn$default(this, newAppUserID, null, 2, null);
    }

    public final void logOut() {
        logOut$default(this, null, 1, null);
    }

    public final void showInAppMessagesIfNeeded(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        showInAppMessagesIfNeeded$default(this, activity, null, 2, null);
    }

    public final void syncPurchases() {
        syncPurchases$default(this, null, 1, null);
    }

    public final void trackCustomPaywallImpression() {
        trackCustomPaywallImpression$default(this, null, 1, null);
    }

    public Purchases(PurchasesOrchestrator purchasesOrchestrator) {
        Intrinsics.checkNotNullParameter(purchasesOrchestrator, "purchasesOrchestrator");
        this.purchasesOrchestrator = purchasesOrchestrator;
    }

    /* JADX INFO: renamed from: getPurchasesOrchestrator$purchases_defaultsBc8Release, reason: from getter */
    public final /* synthetic */ PurchasesOrchestrator getPurchasesOrchestrator() {
        return this.purchasesOrchestrator;
    }

    public final PurchasesConfiguration getCurrentConfiguration() {
        return this.purchasesOrchestrator.getCurrentConfiguration();
    }

    public final synchronized boolean getFinishTransactions() {
        return this.purchasesOrchestrator.getFinishTransactions();
    }

    public final synchronized void setFinishTransactions(boolean z) {
        this.purchasesOrchestrator.setFinishTransactions(z);
    }

    public final synchronized PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        PurchasesAreCompletedBy purchasesAreCompletedBy;
        try {
            if (this.purchasesOrchestrator.getFinishTransactions()) {
                purchasesAreCompletedBy = PurchasesAreCompletedBy.REVENUECAT;
            } else {
                purchasesAreCompletedBy = PurchasesAreCompletedBy.MY_APP;
            }
        } catch (Throwable th) {
            throw th;
        }
        return purchasesAreCompletedBy;
    }

    public final synchronized void setPurchasesAreCompletedBy(PurchasesAreCompletedBy value) {
        try {
            Intrinsics.checkNotNullParameter(value, "value");
            PurchasesOrchestrator purchasesOrchestrator = this.purchasesOrchestrator;
            int i = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
            boolean z = true;
            if (i != 1) {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                z = false;
            }
            purchasesOrchestrator.setFinishTransactions(z);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized String getAppUserID() {
        return this.purchasesOrchestrator.getAppUserID();
    }

    public final synchronized String getStorefrontCountryCode() {
        return this.purchasesOrchestrator.getStorefrontCountryCode();
    }

    public final Locale getStorefrontLocale() {
        return this.purchasesOrchestrator.getStorefrontLocale();
    }

    public final synchronized UpdatedCustomerInfoListener getUpdatedCustomerInfoListener() {
        return this.purchasesOrchestrator.getUpdatedCustomerInfoListener();
    }

    public final synchronized void setUpdatedCustomerInfoListener(UpdatedCustomerInfoListener updatedCustomerInfoListener) {
        this.purchasesOrchestrator.setUpdatedCustomerInfoListener(updatedCustomerInfoListener);
    }

    public final CustomerCenterListener getCustomerCenterListener() {
        return this.purchasesOrchestrator.getCustomerCenterListener();
    }

    public final void setCustomerCenterListener(CustomerCenterListener customerCenterListener) {
        this.purchasesOrchestrator.setCustomerCenterListener(customerCenterListener);
    }

    public final /* synthetic */ TrackedEventListener getTrackedEventListener() {
        return this.purchasesOrchestrator.getTrackedEventListener();
    }

    public final /* synthetic */ void setTrackedEventListener(TrackedEventListener trackedEventListener) {
        this.purchasesOrchestrator.setTrackedEventListener(trackedEventListener);
    }

    public final /* synthetic */ DebugEventListener getDebugEventListener() {
        return this.purchasesOrchestrator.getDebugEventListener();
    }

    public final /* synthetic */ void setDebugEventListener(DebugEventListener debugEventListener) {
        this.purchasesOrchestrator.setDebugEventListener(debugEventListener);
    }

    public final boolean isAnonymous() {
        return this.purchasesOrchestrator.isAnonymous();
    }

    public final Store getStore() {
        return this.purchasesOrchestrator.getStore();
    }

    public final /* synthetic */ FileRepository getFileRepository() {
        return this.purchasesOrchestrator.getFileRepository();
    }

    public final /* synthetic */ AdTracker getAdTracker() {
        return this.purchasesOrchestrator.getAdTracker();
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    @Deprecated
    public void onAppBackgrounded() {
        this.purchasesOrchestrator.onAppBackgrounded();
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    @Deprecated
    public void onAppForegrounded() {
        this.purchasesOrchestrator.onAppForegrounded();
    }

    public final void getStorefrontCountryCode(GetStorefrontCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getStorefrontCountryCode(callback);
    }

    @ExperimentalPreviewRevenueCatPurchasesAPI
    public final void getStorefrontLocale(GetStorefrontLocaleCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getStorefrontLocale(callback);
    }

    public static /* synthetic */ void syncPurchases$default(Purchases purchases, SyncPurchasesCallback syncPurchasesCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            syncPurchasesCallback = null;
        }
        purchases.syncPurchases(syncPurchasesCallback);
    }

    public final void syncPurchases(SyncPurchasesCallback listener) {
        this.purchasesOrchestrator.syncPurchases(listener);
    }

    @Deprecated
    public final void syncObserverModeAmazonPurchase(String productID, String receiptID, String amazonUserID, String isoCurrencyCode, Double price) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(receiptID, "receiptID");
        Intrinsics.checkNotNullParameter(amazonUserID, "amazonUserID");
        syncAmazonPurchase(productID, receiptID, amazonUserID, isoCurrencyCode, price);
    }

    @Deprecated
    public final void syncAmazonPurchase(String productID, String receiptID, String amazonUserID, String isoCurrencyCode, Double price) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(receiptID, "receiptID");
        Intrinsics.checkNotNullParameter(amazonUserID, "amazonUserID");
        this.purchasesOrchestrator.syncAmazonPurchase(productID, receiptID, amazonUserID, isoCurrencyCode, price, null);
    }

    public final void syncAmazonPurchase(String productID, String receiptID, String amazonUserID, String isoCurrencyCode, Double price, long purchaseTime) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(receiptID, "receiptID");
        Intrinsics.checkNotNullParameter(amazonUserID, "amazonUserID");
        this.purchasesOrchestrator.syncAmazonPurchase(productID, receiptID, amazonUserID, isoCurrencyCode, price, Long.valueOf(purchaseTime));
    }

    public final void syncAttributesAndOfferingsIfNeeded(SyncAttributesAndOfferingsCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.syncAttributesAndOfferingsIfNeeded(callback);
    }

    public final void getOfferings(ReceiveOfferingsCallback listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        PurchasesOrchestrator.getOfferings$default(this.purchasesOrchestrator, listener, false, 2, null);
    }

    @InternalRevenueCatAPI
    public final /* synthetic */ Object awaitGetWorkflow(String str, Continuation continuation) throws PurchasesException {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        this.purchasesOrchestrator.getWorkflow(str, new Purchases$awaitGetWorkflow$2$1(safeContinuation), new Function1() { // from class: com.revenuecat.purchases.Purchases$awaitGetWorkflow$2$2
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
                Continuation continuation2 = safeContinuation;
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.m5243constructorimpl(ResultKt.createFailure(new PurchasesException(it))));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void getProducts(List<String> productIds, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getProducts(productIds, null, callback);
    }

    public static /* synthetic */ void getProducts$default(Purchases purchases, List list, ProductType productType, GetStoreProductsCallback getStoreProductsCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            productType = null;
        }
        purchases.getProducts(list, productType, getStoreProductsCallback);
    }

    public final void getProducts(List<String> productIds, ProductType type, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getProducts(productIds, type, callback);
    }

    public final void purchase(PurchaseParams purchaseParams, PurchaseCallback callback) throws PurchasesException {
        Intrinsics.checkNotNullParameter(purchaseParams, "purchaseParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.purchase(purchaseParams, callback);
    }

    @Deprecated
    public final void purchaseProduct(Activity activity, StoreProduct storeProduct, PurchaseCallback callback) throws PurchasesException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(callback, "callback");
        purchase(new PurchaseParams.Builder(activity, storeProduct).build(), callback);
    }

    @Deprecated
    public final void purchasePackage(Activity activity, Package packageToPurchase, PurchaseCallback listener) throws PurchasesException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(packageToPurchase, "packageToPurchase");
        Intrinsics.checkNotNullParameter(listener, "listener");
        purchase(new PurchaseParams.Builder(activity, packageToPurchase).build(), listener);
    }

    public final void restorePurchases(ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.restorePurchases(callback);
    }

    public static /* synthetic */ void logIn$default(Purchases purchases, String str, LogInCallback logInCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            logInCallback = null;
        }
        purchases.logIn(str, logInCallback);
    }

    public final void logIn(String newAppUserID, LogInCallback callback) {
        Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
        this.purchasesOrchestrator.logIn(newAppUserID, callback);
    }

    public static /* synthetic */ void logOut$default(Purchases purchases, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            receiveCustomerInfoCallback = null;
        }
        purchases.logOut(receiveCustomerInfoCallback);
    }

    public final void logOut(ReceiveCustomerInfoCallback callback) {
        this.purchasesOrchestrator.logOut(callback);
    }

    public final void close() {
        this.purchasesOrchestrator.close();
        backingFieldSharedInstance = null;
    }

    public final void getCustomerInfo(ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getCustomerInfo(CacheFetchPolicy.INSTANCE.m3736default(), true, callback);
    }

    public final void getCustomerInfo(CacheFetchPolicy fetchPolicy, ReceiveCustomerInfoCallback callback) {
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getCustomerInfo(fetchPolicy, true, callback);
    }

    public final void getVirtualCurrencies(GetVirtualCurrenciesCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getVirtualCurrencies(callback);
    }

    public final void invalidateVirtualCurrenciesCache() {
        this.purchasesOrchestrator.invalidateVirtualCurrenciesCache();
    }

    public final VirtualCurrencies getCachedVirtualCurrencies() {
        return this.purchasesOrchestrator.getCachedVirtualCurrencies();
    }

    public final void removeUpdatedCustomerInfoListener() {
        this.purchasesOrchestrator.removeUpdatedCustomerInfoListener();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showInAppMessagesIfNeeded$default(Purchases purchases, Activity activity, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.listOf(InAppMessageType.BILLING_ISSUES);
        }
        purchases.showInAppMessagesIfNeeded(activity, list);
    }

    public final void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(inAppMessageTypes, "inAppMessageTypes");
        this.purchasesOrchestrator.showInAppMessagesIfNeeded(activity, inAppMessageTypes);
    }

    public final void invalidateCustomerInfoCache() {
        this.purchasesOrchestrator.invalidateCustomerInfoCache();
    }

    @InternalRevenueCatAPI
    public final /* synthetic */ void track(FeatureEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.purchasesOrchestrator.track(event);
    }

    public static /* synthetic */ void trackCustomPaywallImpression$default(Purchases purchases, CustomPaywallImpressionParams customPaywallImpressionParams, int i, Object obj) {
        if ((i & 1) != 0) {
            customPaywallImpressionParams = new CustomPaywallImpressionParams(null, null, 3, null);
        }
        purchases.trackCustomPaywallImpression(customPaywallImpressionParams);
    }

    public final void trackCustomPaywallImpression(CustomPaywallImpressionParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        PurchasesOrchestrator purchasesOrchestrator = this.purchasesOrchestrator;
        String paywallId = params.getPaywallId();
        String offeringId = params.getOfferingId();
        if (offeringId == null) {
            offeringId = this.purchasesOrchestrator.getCachedCurrentOfferingIdentifier();
        }
        purchasesOrchestrator.track(new CustomPaywallEvent.Impression(null, new CustomPaywallEvent.Impression.Data(paywallId, offeringId), 1, null));
    }

    public final void getCustomerCenterConfigData$purchases_defaultsBc8Release(GetCustomerCenterConfigCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getCustomerCenterConfig(callback);
    }

    @InternalRevenueCatAPI
    public final void createSupportTicket(String email, String description, Function1 onSuccess, Function1 onError) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.purchasesOrchestrator.createSupportTicket(email, description, onSuccess, onError);
    }

    public final void setAttributes(Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.purchasesOrchestrator.setAttributes(attributes);
    }

    public final void setEmail(String email) {
        this.purchasesOrchestrator.setEmail(email);
    }

    public final void setPhoneNumber(String phoneNumber) {
        this.purchasesOrchestrator.setPhoneNumber(phoneNumber);
    }

    public final void setDisplayName(String displayName) {
        this.purchasesOrchestrator.setDisplayName(displayName);
    }

    public final void setPushToken(String fcmToken) {
        this.purchasesOrchestrator.setPushToken(fcmToken);
    }

    public final void setMixpanelDistinctID(String mixpanelDistinctID) {
        this.purchasesOrchestrator.setMixpanelDistinctID(mixpanelDistinctID);
    }

    public final void setOnesignalID(String onesignalID) {
        this.purchasesOrchestrator.setOnesignalID(onesignalID);
    }

    public final void setOnesignalUserID(String onesignalUserID) {
        this.purchasesOrchestrator.setOnesignalUserID(onesignalUserID);
    }

    public final void setAirshipChannelID(String airshipChannelID) {
        this.purchasesOrchestrator.setAirshipChannelID(airshipChannelID);
    }

    public final void setFirebaseAppInstanceID(String firebaseAppInstanceID) {
        this.purchasesOrchestrator.setFirebaseAppInstanceID(firebaseAppInstanceID);
    }

    public final void setTenjinAnalyticsInstallationID(String tenjinAnalyticsInstallationID) {
        this.purchasesOrchestrator.setTenjinAnalyticsInstallationID(tenjinAnalyticsInstallationID);
    }

    public final void setPostHogUserId(String postHogUserId) {
        this.purchasesOrchestrator.setPostHogUserId(postHogUserId);
    }

    public final void collectDeviceIdentifiers() {
        this.purchasesOrchestrator.collectDeviceIdentifiers();
    }

    public final void setAdjustID(String adjustID) {
        this.purchasesOrchestrator.setAdjustID(adjustID);
    }

    public final void setAppsflyerID(String appsflyerID) {
        this.purchasesOrchestrator.setAppsflyerID(appsflyerID);
    }

    public final void setFBAnonymousID(String fbAnonymousID) {
        this.purchasesOrchestrator.setFBAnonymousID(fbAnonymousID);
    }

    public final void setMparticleID(String mparticleID) {
        this.purchasesOrchestrator.setMparticleID(mparticleID);
    }

    public final void setCleverTapID(String cleverTapID) {
        this.purchasesOrchestrator.setCleverTapID(cleverTapID);
    }

    public final void setKochavaDeviceID(String kochavaDeviceID) {
        this.purchasesOrchestrator.setKochavaDeviceID(kochavaDeviceID);
    }

    public final void setAirbridgeDeviceID(String airbridgeDeviceID) {
        this.purchasesOrchestrator.setAirbridgeDeviceID(airbridgeDeviceID);
    }

    public final void setSolarEngineDistinctId(String solarEngineDistinctId) {
        this.purchasesOrchestrator.setSolarEngineDistinctId(solarEngineDistinctId);
    }

    public final void setSolarEngineAccountId(String solarEngineAccountId) {
        this.purchasesOrchestrator.setSolarEngineAccountId(solarEngineAccountId);
    }

    public final void setSolarEngineVisitorId(String solarEngineVisitorId) {
        this.purchasesOrchestrator.setSolarEngineVisitorId(solarEngineVisitorId);
    }

    public final void setAppsFlyerConversionData(Map<?, ?> data) {
        this.purchasesOrchestrator.setAppsFlyerConversionData(data);
    }

    public final void setAppstackAttributionParams(Map<String, String> data, SyncAttributesAndOfferingsCallback callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.setAppstackAttributionParams(data, callback);
    }

    public final void setMediaSource(String mediaSource) {
        this.purchasesOrchestrator.setMediaSource(mediaSource);
    }

    public final void setCampaign(String campaign) {
        this.purchasesOrchestrator.setCampaign(campaign);
    }

    public final void setAdGroup(String adGroup) {
        this.purchasesOrchestrator.setAdGroup(adGroup);
    }

    public final void setAd(String ad) {
        this.purchasesOrchestrator.setAd(ad);
    }

    public final void setKeyword(String keyword) {
        this.purchasesOrchestrator.setKeyword(keyword);
    }

    public final void setCreative(String creative) {
        this.purchasesOrchestrator.setCreative(creative);
    }

    @InternalRevenueCatAPI
    public final DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo) {
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        return this.purchasesOrchestrator.getCachedFontFamilyOrStartDownload(fontInfo);
    }

    public final synchronized boolean getAllowSharingPlayStoreAccount() {
        return this.purchasesOrchestrator.getAllowSharingPlayStoreAccount();
    }

    public final synchronized void setAllowSharingPlayStoreAccount(boolean z) {
        this.purchasesOrchestrator.setAllowSharingPlayStoreAccount(z);
    }

    public final synchronized String getPreferredUILocaleOverride() {
        return this.purchasesOrchestrator.get_preferredUILocaleOverride();
    }

    public final boolean overridePreferredUILocale(String localeString) {
        return this.purchasesOrchestrator.overridePreferredUILocale(localeString);
    }

    @Deprecated
    public final void getSubscriptionSkus(List<String> productIds, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getProductsOfTypes(CollectionsKt.toSet(productIds), SetsKt.setOf(ProductType.SUBS), callback);
    }

    @Deprecated
    public final void getNonSubscriptionSkus(List<String> productIds, GetStoreProductsCallback callback) {
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getProductsOfTypes(CollectionsKt.toSet(productIds), SetsKt.setOf(ProductType.INAPP), callback);
    }

    public final void getAmazonLWAConsentStatus(GetAmazonLWAConsentStatusCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.purchasesOrchestrator.getAmazonLWAConsentStatus(callback);
    }

    public final void redeemWebPurchase(WebPurchaseRedemption webPurchaseRedemption, RedeemWebPurchaseListener listener) {
        Intrinsics.checkNotNullParameter(webPurchaseRedemption, "webPurchaseRedemption");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.purchasesOrchestrator.redeemWebPurchase(webPurchaseRedemption, listener);
    }

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\n0@H\u0007J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020CH\u0007J\u0010\u0010D\u001a\u00020\u00012\u0006\u0010:\u001a\u00020;H\u0007J\u0012\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020HH\u0007J\u0012\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010I\u001a\u00020\u0012H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00128\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0016\u0010\u000eR*\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00188F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010 \u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u001f8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010'\u001a\u00020&2\u0006\u0010\t\u001a\u00020&8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b(\u0010\u0002\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R.\u0010.\u001a\u0004\u0018\u00010-2\b\u0010\t\u001a\u0004\u0018\u00010-8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\u0002\u001a\u0004\b0\u00101\"\u0004\b2\u00103R*\u00104\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@AX\u0087\u000e¢\u0006\u0012\u0012\u0004\b5\u0010\u0002\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\b¨\u0006J"}, d2 = {"Lcom/revenuecat/purchases/Purchases$Companion;", "", "()V", "backingFieldSharedInstance", "Lcom/revenuecat/purchases/Purchases;", "getBackingFieldSharedInstance$purchases_defaultsBc8Release", "()Lcom/revenuecat/purchases/Purchases;", "setBackingFieldSharedInstance$purchases_defaultsBc8Release", "(Lcom/revenuecat/purchases/Purchases;)V", "value", "", "debugLogsEnabled", "getDebugLogsEnabled$annotations", "getDebugLogsEnabled", "()Z", "setDebugLogsEnabled", "(Z)V", "frameworkVersion", "", "getFrameworkVersion$annotations", "getFrameworkVersion", "()Ljava/lang/String;", "isConfigured", "isConfigured$annotations", "Lcom/revenuecat/purchases/LogHandler;", "logHandler", "getLogHandler$annotations", "getLogHandler", "()Lcom/revenuecat/purchases/LogHandler;", "setLogHandler", "(Lcom/revenuecat/purchases/LogHandler;)V", "Lcom/revenuecat/purchases/LogLevel;", "logLevel", "getLogLevel$annotations", "getLogLevel", "()Lcom/revenuecat/purchases/LogLevel;", "setLogLevel", "(Lcom/revenuecat/purchases/LogLevel;)V", "Lcom/revenuecat/purchases/common/PlatformInfo;", "platformInfo", "getPlatformInfo$annotations", "getPlatformInfo", "()Lcom/revenuecat/purchases/common/PlatformInfo;", "setPlatformInfo", "(Lcom/revenuecat/purchases/common/PlatformInfo;)V", "Ljava/net/URL;", "proxyURL", "getProxyURL$annotations", "getProxyURL", "()Ljava/net/URL;", "setProxyURL", "(Ljava/net/URL;)V", "sharedInstance", "getSharedInstance$annotations", "getSharedInstance", "setSharedInstance$purchases_defaultsBc8Release", "canMakePayments", "", "context", "Landroid/content/Context;", "features", "", "Lcom/revenuecat/purchases/models/BillingFeature;", "callback", "Lcom/revenuecat/purchases/interfaces/Callback;", "configure", "configuration", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "getImageLoader", "parseAsWebPurchaseRedemption", "Lcom/revenuecat/purchases/WebPurchaseRedemption;", "intent", "Landroid/content/Intent;", "string", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated
        public static /* synthetic */ void getDebugLogsEnabled$annotations() {
        }

        public static /* synthetic */ void getFrameworkVersion$annotations() {
        }

        public static /* synthetic */ void getLogHandler$annotations() {
        }

        public static /* synthetic */ void getLogLevel$annotations() {
        }

        public static /* synthetic */ void getPlatformInfo$annotations() {
        }

        public static /* synthetic */ void getProxyURL$annotations() {
        }

        public static /* synthetic */ void getSharedInstance$annotations() {
        }

        public static /* synthetic */ void isConfigured$annotations() {
        }

        public final void canMakePayments(Context context, Callback<Boolean> callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callback, "callback");
            canMakePayments$default(this, context, null, callback, 2, null);
        }

        private Companion() {
        }

        @InternalRevenueCatAPI
        public final Object getImageLoader(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return PurchasesOrchestrator.INSTANCE.getImageLoader(context);
        }

        public final WebPurchaseRedemption parseAsWebPurchaseRedemption(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Uri data = intent.getData();
            if (data == null) {
                return null;
            }
            return DeepLinkParser.INSTANCE.parseWebPurchaseRedemption(data);
        }

        public final WebPurchaseRedemption parseAsWebPurchaseRedemption(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            try {
                Uri uri = Uri.parse(string);
                DeepLinkParser deepLinkParser = DeepLinkParser.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(uri, "uri");
                return deepLinkParser.parseWebPurchaseRedemption(uri);
            } catch (Throwable th) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error parsing URL: " + string, th);
                return null;
            }
        }

        public final PlatformInfo getPlatformInfo() {
            return PurchasesOrchestrator.INSTANCE.getPlatformInfo();
        }

        public final void setPlatformInfo(PlatformInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            PurchasesOrchestrator.INSTANCE.setPlatformInfo(value);
        }

        public final boolean getDebugLogsEnabled() {
            return PurchasesOrchestrator.INSTANCE.getDebugLogsEnabled();
        }

        public final void setDebugLogsEnabled(boolean z) {
            PurchasesOrchestrator.INSTANCE.setDebugLogsEnabled(z);
        }

        public final LogLevel getLogLevel() {
            return PurchasesOrchestrator.INSTANCE.getLogLevel();
        }

        public final void setLogLevel(LogLevel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            PurchasesOrchestrator.INSTANCE.setLogLevel(value);
        }

        public final synchronized LogHandler getLogHandler() {
            return PurchasesOrchestrator.INSTANCE.getLogHandler();
        }

        public final synchronized void setLogHandler(LogHandler value) {
            Intrinsics.checkNotNullParameter(value, "value");
            PurchasesOrchestrator.INSTANCE.setLogHandler(value);
        }

        public final Purchases getBackingFieldSharedInstance$purchases_defaultsBc8Release() {
            return Purchases.backingFieldSharedInstance;
        }

        public final void setBackingFieldSharedInstance$purchases_defaultsBc8Release(Purchases purchases) {
            Purchases.backingFieldSharedInstance = purchases;
        }

        public final Purchases getSharedInstance() {
            Purchases backingFieldSharedInstance$purchases_defaultsBc8Release = getBackingFieldSharedInstance$purchases_defaultsBc8Release();
            if (backingFieldSharedInstance$purchases_defaultsBc8Release != null) {
                return backingFieldSharedInstance$purchases_defaultsBc8Release;
            }
            throw new UninitializedPropertyAccessException(ConfigureStrings.NO_SINGLETON_INSTANCE);
        }

        public final void setSharedInstance$purchases_defaultsBc8Release(Purchases value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Purchases backingFieldSharedInstance$purchases_defaultsBc8Release = getBackingFieldSharedInstance$purchases_defaultsBc8Release();
            if (backingFieldSharedInstance$purchases_defaultsBc8Release != null) {
                backingFieldSharedInstance$purchases_defaultsBc8Release.close();
            }
            setBackingFieldSharedInstance$purchases_defaultsBc8Release(value);
        }

        public final String getFrameworkVersion() {
            return Purchases.frameworkVersion;
        }

        public final URL getProxyURL() {
            return PurchasesOrchestrator.INSTANCE.getProxyURL();
        }

        public final void setProxyURL(URL url) {
            PurchasesOrchestrator.INSTANCE.setProxyURL(url);
        }

        public final boolean isConfigured() {
            return getBackingFieldSharedInstance$purchases_defaultsBc8Release() != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Purchases configure(PurchasesConfiguration configuration) {
            PurchasesOrchestrator purchasesOrchestrator;
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            APIKeyValidator aPIKeyValidator = null;
            Object[] objArr = 0;
            if (isConfigured()) {
                Purchases backingFieldSharedInstance$purchases_defaultsBc8Release = getBackingFieldSharedInstance$purchases_defaultsBc8Release();
                if (Intrinsics.areEqual((backingFieldSharedInstance$purchases_defaultsBc8Release == null || (purchasesOrchestrator = backingFieldSharedInstance$purchases_defaultsBc8Release.getPurchasesOrchestrator()) == null) ? null : purchasesOrchestrator.getCurrentConfiguration(), configuration)) {
                    LogLevel logLevel = LogLevel.INFO;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.i("[Purchases] - " + logLevel.name(), ConfigureStrings.INSTANCE_ALREADY_EXISTS_WITH_SAME_CONFIG);
                    }
                    return getSharedInstance();
                }
                LogLevel logLevel2 = LogLevel.INFO;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.i("[Purchases] - " + logLevel2.name(), ConfigureStrings.INSTANCE_ALREADY_EXISTS);
                }
            }
            Purchases purchasesCreatePurchases$default = PurchasesFactory.createPurchases$default(new PurchasesFactory(new DefaultIsDebugBuildProvider(configuration.getContext()), aPIKeyValidator, 2, objArr == true ? 1 : 0), configuration, getPlatformInfo(), getProxyURL(), null, null, false, false, null, 248, null);
            Purchases.INSTANCE.setSharedInstance$purchases_defaultsBc8Release(purchasesCreatePurchases$default);
            return purchasesCreatePurchases$default;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void canMakePayments$default(Companion companion, Context context, List list, Callback callback, int i, Object obj) {
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            companion.canMakePayments(context, list, callback);
        }

        public final void canMakePayments(Context context, List<? extends BillingFeature> features, Callback<Boolean> callback) {
            LogHandler currentLogHandler;
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(features, "features");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (getSharedInstance().getPurchasesOrchestrator().getAppConfig().getStore() == Store.PLAY_STORE) {
                PurchasesOrchestrator.INSTANCE.canMakePayments(context, features, callback);
                return;
            }
            final LogIntent logIntent = LogIntent.RC_ERROR;
            Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.Purchases$Companion$canMakePayments$$inlined$log$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + BillingStrings.CANNOT_CALL_CAN_MAKE_PAYMENTS;
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) function0.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                    }
                    break;
                case BaseVideoCapturer.RGBA /* 11 */:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                    }
                    break;
                case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                    break;
            }
            callback.onReceived(Boolean.TRUE);
        }
    }

    public static final synchronized LogHandler getLogHandler() {
        return INSTANCE.getLogHandler();
    }

    public static final synchronized void setLogHandler(LogHandler logHandler) {
        INSTANCE.setLogHandler(logHandler);
    }
}
