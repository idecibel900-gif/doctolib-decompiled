package com.revenuecat.purchases.amazon;

import com.amazon.a.a.o.b;
import com.amazon.a.a.o.b.f;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductType;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0000\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u0004H\u0000\u001a\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"pattern", "Ljava/util/regex/Pattern;", "createPeriod", "Lcom/revenuecat/purchases/models/Period;", "", "createPrice", "Lcom/revenuecat/purchases/models/Price;", b.m, "parsePriceUsingRegex", "Ljava/math/BigDecimal;", "toStoreProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "Lcom/amazon/device/iap/model/Product;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StoreProductConversionsKt {
    private static final Pattern pattern;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final StoreProduct toStoreProduct(final Product product, String marketplace) throws JSONException {
        LogHandler currentLogHandler;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(product, "<this>");
        Intrinsics.checkNotNullParameter(marketplace, "marketplace");
        if (product.getPrice() != null) {
            String price = product.getPrice();
            Intrinsics.checkNotNullExpressionValue(price, "price");
            Price priceCreatePrice = createPrice(price, marketplace);
            String sku = product.getSku();
            Intrinsics.checkNotNullExpressionValue(sku, "sku");
            ProductType productType = product.getProductType();
            Intrinsics.checkNotNullExpressionValue(productType, "productType");
            com.revenuecat.purchases.ProductType revenueCatProductType = ProductTypeConversionsKt.toRevenueCatProductType(productType);
            String title = product.getTitle();
            Intrinsics.checkNotNullExpressionValue(title, "title");
            String title2 = product.getTitle();
            Intrinsics.checkNotNullExpressionValue(title2, "title");
            String description = product.getDescription();
            Intrinsics.checkNotNullExpressionValue(description, "description");
            String subscriptionPeriod = product.getSubscriptionPeriod();
            Period periodCreatePeriod = subscriptionPeriod != null ? createPeriod(subscriptionPeriod) : null;
            String smallIconUrl = product.getSmallIconUrl();
            Intrinsics.checkNotNullExpressionValue(smallIconUrl, "smallIconUrl");
            String freeTrialPeriod = product.getFreeTrialPeriod();
            Period periodCreatePeriod2 = freeTrialPeriod != null ? createPeriod(freeTrialPeriod) : null;
            JSONObject json = product.toJSON();
            Intrinsics.checkNotNullExpressionValue(json, "this.toJSON()");
            return new AmazonStoreProduct(sku, revenueCatProductType, title, title2, description, periodCreatePeriod, priceCreatePrice, (SubscriptionOptions) null, (SubscriptionOption) null, smallIconUrl, periodCreatePeriod2, json, (PresentedOfferingContext) null);
        }
        final LogIntent logIntent = LogIntent.AMAZON_ERROR;
        Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.amazon.StoreProductConversionsKt$toStoreProduct$$inlined$log$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                StringBuilder sb = new StringBuilder();
                sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                sb.append(' ');
                String str3 = String.format(AmazonStrings.PRODUCT_PRICE_MISSING, Arrays.copyOf(new Object[]{product.getSku()}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                sb.append(str3);
                return sb.toString();
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
                return null;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                return null;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                }
                return null;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                }
                return null;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) function0.invoke();
                    currentLogHandler.d(str, str2);
                }
                return null;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                return null;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                }
                return null;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) function0.invoke();
                    currentLogHandler.d(str, str2);
                }
                return null;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) function0.invoke();
                    currentLogHandler.d(str, str2);
                }
                return null;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                }
                return null;
            case BaseVideoCapturer.RGBA /* 11 */:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                }
                return null;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                return null;
            case 13:
                LogLevel logLevel10 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                }
                return null;
            case 14:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                return null;
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:46:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ba  */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        if (r9.equals("SemiAnnual") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        if (r9.equals("SemiAnnually") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        return new com.revenuecat.purchases.models.Period(6, com.revenuecat.purchases.models.Period.Unit.MONTH, "P6M");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
    
        if (r9.equals("Annually") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:
    
        return new com.revenuecat.purchases.models.Period(1, com.revenuecat.purchases.models.Period.Unit.YEAR, "P1Y");
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r9.equals("Annual") == false) goto L43;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.revenuecat.purchases.models.Period createPeriod(java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.StoreProductConversionsKt.createPeriod(java.lang.String):com.revenuecat.purchases.models.Period");
    }

    public static final Price createPrice(String str, String marketplace) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(marketplace, "marketplace");
        BigDecimal priceNumeric = parsePriceUsingRegex(str);
        if (priceNumeric == null) {
            priceNumeric = BigDecimal.ZERO;
        }
        Intrinsics.checkNotNullExpressionValue(priceNumeric, "priceNumeric");
        BigDecimal bigDecimalMultiply = priceNumeric.multiply(new BigDecimal(1000000.0d));
        Intrinsics.checkNotNullExpressionValue(bigDecimalMultiply, "multiply(...)");
        return new Price(str, bigDecimalMultiply.longValue(), ISO3166Alpha2ToISO42170Converter.INSTANCE.convertOrEmpty(marketplace));
    }

    static {
        Pattern patternCompile = Pattern.compile("(\\d+[[\\.,\\s]\\d+]*)");
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(\"(\\\\d+[[\\\\.,\\\\s]\\\\d+]*)\")");
        pattern = patternCompile;
    }

    public static final BigDecimal parsePriceUsingRegex(String str) {
        String strReplace$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Matcher matcher = pattern.matcher(str);
        if ((matcher.find() ? matcher : null) == null) {
            return null;
        }
        String dirtyPrice = matcher.group();
        Intrinsics.checkNotNullExpressionValue(dirtyPrice, "dirtyPrice");
        String string = StringsKt.trim(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(dirtyPrice, " ", "", false, 4, (Object) null), " ", "", false, 4, (Object) null), " ", "", false, 4, (Object) null)).toString();
        List listSplit$default = StringsKt.split$default((CharSequence) string, new String[]{".", f.a}, false, 0, 6, (Object) null);
        if (listSplit$default.size() != 1) {
            if (((String) CollectionsKt.last(listSplit$default)).length() == 3) {
                strReplace$default = StringsKt.replace$default(StringsKt.replace$default(string, ".", "", false, 4, (Object) null), f.a, "", false, 4, (Object) null);
            } else {
                strReplace$default = CollectionsKt.joinToString$default(CollectionsKt.dropLast(listSplit$default, 1), "", null, null, 0, null, null, 62, null) + com.amazon.a.a.o.c.a.b.a + ((String) CollectionsKt.last(listSplit$default));
            }
            string = strReplace$default;
        }
        return new BigDecimal(StringsKt.trim(string).toString());
    }
}
