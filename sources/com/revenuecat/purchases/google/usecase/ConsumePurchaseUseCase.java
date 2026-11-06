package com.revenuecat.purchases.google.usecase;

import com.amazon.a.a.o.b;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.google.BillingResultExtensionsBillingIndependentKt;
import com.revenuecat.purchases.google.ErrorsKt;
import com.revenuecat.purchases.strings.PurchaseStrings;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\t\u0012\u001e\u0010\f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0005\u0012*\u0010\u0010\u001a&\u0012\u0004\u0012\u00020\u000e\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\rj\u0002`\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0018R#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR'\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR/\u0010\f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u0014\u0010!\u001a\u00020\u001e8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/revenuecat/purchases/google/usecase/ConsumePurchaseUseCase;", "Lcom/revenuecat/purchases/google/usecase/BillingClientUseCase;", "", "Lcom/revenuecat/purchases/google/usecase/ConsumePurchaseUseCaseParams;", "useCaseParams", "Lkotlin/Function1;", "", "onReceive", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/PurchasesErrorCallback;", "onError", "Lcom/android/billingclient/api/BillingClient;", "withConnectedClient", "Lkotlin/Function2;", "", "Lcom/revenuecat/purchases/google/usecase/ExecuteRequestOnUIThreadFunction;", "executeRequestOnUIThread", "<init>", "(Lcom/revenuecat/purchases/google/usecase/ConsumePurchaseUseCaseParams;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "executeAsync", "()V", "received", "onOk", "(Ljava/lang/String;)V", "Lcom/revenuecat/purchases/google/usecase/ConsumePurchaseUseCaseParams;", "Lkotlin/jvm/functions/Function1;", "getOnReceive", "()Lkotlin/jvm/functions/Function1;", "getOnError", "getWithConnectedClient", "", "getBackoffForNetworkErrors", "()Z", "backoffForNetworkErrors", "getErrorMessage", "()Ljava/lang/String;", b.f, "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConsumePurchaseUseCase extends BillingClientUseCase<String> {
    private final Function1 onError;
    private final Function1 onReceive;
    private final ConsumePurchaseUseCaseParams useCaseParams;
    private final Function1 withConnectedClient;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PostReceiptInitiationSource.values().length];
            try {
                iArr[PostReceiptInitiationSource.RESTORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PostReceiptInitiationSource.PURCHASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PostReceiptInitiationSource.UNSYNCED_ACTIVE_PURCHASES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final Function1 getOnReceive() {
        return this.onReceive;
    }

    public final Function1 getOnError() {
        return this.onError;
    }

    public final Function1 getWithConnectedClient() {
        return this.withConnectedClient;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumePurchaseUseCase(ConsumePurchaseUseCaseParams useCaseParams, Function1 onReceive, Function1 onError, Function1 withConnectedClient, Function2 executeRequestOnUIThread) {
        super(useCaseParams, onError, executeRequestOnUIThread);
        Intrinsics.checkNotNullParameter(useCaseParams, "useCaseParams");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(withConnectedClient, "withConnectedClient");
        Intrinsics.checkNotNullParameter(executeRequestOnUIThread, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams;
        this.onReceive = onReceive;
        this.onError = onError;
        this.withConnectedClient = withConnectedClient;
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    protected boolean getBackoffForNetworkErrors() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.useCaseParams.getInitiationSource().ordinal()];
        if (i == 1 || i == 2) {
            return false;
        }
        if (i == 3) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public String getErrorMessage() {
        return "Error consuming purchase";
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCase$executeAsync$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function1 {
        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((BillingClient) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(BillingClient invoke) {
            Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
            ConsumeParams consumeParamsBuild = ConsumeParams.newBuilder().setPurchaseToken(ConsumePurchaseUseCase.this.useCaseParams.getPurchaseToken()).build();
            Intrinsics.checkNotNullExpressionValue(consumeParamsBuild, "newBuilder()\n           …\n                .build()");
            final ConsumePurchaseUseCase consumePurchaseUseCase = ConsumePurchaseUseCase.this;
            invoke.consumeAsync(consumeParamsBuild, new ConsumeResponseListener() { // from class: com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCase$executeAsync$1$$ExternalSyntheticLambda0
                @Override // com.android.billingclient.api.ConsumeResponseListener
                public final void onConsumeResponse(BillingResult billingResult, String str) {
                    ConsumePurchaseUseCase.AnonymousClass1.invoke$lambda$0(consumePurchaseUseCase, billingResult, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(final ConsumePurchaseUseCase consumePurchaseUseCase, BillingResult billingResult, String purchaseToken) {
            Intrinsics.checkNotNullParameter(billingResult, "billingResult");
            Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
            BillingClientUseCase.processResult$default(consumePurchaseUseCase, billingResult, purchaseToken, null, new Function1() { // from class: com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCase$executeAsync$1$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((BillingResult) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(BillingResult errorBillingResult) {
                    final String str;
                    LogHandler currentLogHandler;
                    String str2;
                    String str3;
                    Intrinsics.checkNotNullParameter(errorBillingResult, "errorBillingResult");
                    if (errorBillingResult.getResponseCode() != 8 || consumePurchaseUseCase.useCaseParams.getInitiationSource() != PostReceiptInitiationSource.RESTORE) {
                        str = consumePurchaseUseCase.getErrorMessage() + " - " + BillingResultExtensionsBillingIndependentKt.toHumanReadableDescription(errorBillingResult);
                        final LogIntent logIntent = LogIntent.GOOGLE_ERROR;
                        Function0 function0 = new Function0() { // from class: com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + str;
                            }
                        };
                        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                            case 1:
                                LogLevel logLevel = LogLevel.DEBUG;
                                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                    currentLogHandler2.d("[Purchases] - " + logLevel.name(), (String) function0.invoke());
                                }
                                break;
                            case 2:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                                break;
                            case 3:
                                LogLevel logLevel2 = LogLevel.WARN;
                                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                                    currentLogHandler3.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                                }
                                break;
                            case 4:
                                LogLevel logLevel3 = LogLevel.INFO;
                                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                    currentLogHandler4.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                                }
                                break;
                            case 5:
                                LogLevel logLevel4 = LogLevel.DEBUG;
                                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                    currentLogHandler5.d("[Purchases] - " + logLevel4.name(), (String) function0.invoke());
                                }
                                break;
                            case 6:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                                break;
                            case 7:
                                LogLevel logLevel5 = LogLevel.INFO;
                                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                    currentLogHandler6.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                                }
                                break;
                            case 8:
                                LogLevel logLevel6 = LogLevel.DEBUG;
                                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                    currentLogHandler7.d("[Purchases] - " + logLevel6.name(), (String) function0.invoke());
                                }
                                break;
                            case 9:
                                LogLevel logLevel7 = LogLevel.DEBUG;
                                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                    currentLogHandler8.d("[Purchases] - " + logLevel7.name(), (String) function0.invoke());
                                }
                                break;
                            case 10:
                                LogLevel logLevel8 = LogLevel.WARN;
                                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                    currentLogHandler9.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                                }
                                break;
                            case BaseVideoCapturer.RGBA /* 11 */:
                                LogLevel logLevel9 = LogLevel.WARN;
                                LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                    currentLogHandler10.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                                }
                                break;
                            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                                break;
                            case 13:
                                LogLevel logLevel10 = LogLevel.WARN;
                                LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                    currentLogHandler11.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                                }
                                break;
                            case 14:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                                break;
                        }
                    } else {
                        final LogIntent logIntent2 = LogIntent.GOOGLE_WARNING;
                        str = PurchaseStrings.CONSUMING_PURCHASE_ERROR_RESTORE;
                        Function0 function1 = new Function0() { // from class: com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCase$executeAsync$1$1$1$invoke$$inlined$log$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + str;
                            }
                        };
                        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                            case 1:
                                LogLevel logLevel11 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                    str2 = "[Purchases] - " + logLevel11.name();
                                    str3 = (String) function1.invoke();
                                    currentLogHandler.d(str2, str3);
                                }
                                break;
                            case 2:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function1.invoke(), null);
                                break;
                            case 3:
                                LogLevel logLevel12 = LogLevel.WARN;
                                LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                    currentLogHandler12.w("[Purchases] - " + logLevel12.name(), (String) function1.invoke());
                                }
                                break;
                            case 4:
                                LogLevel logLevel13 = LogLevel.INFO;
                                LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                    currentLogHandler13.i("[Purchases] - " + logLevel13.name(), (String) function1.invoke());
                                }
                                break;
                            case 5:
                                LogLevel logLevel14 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                    str2 = "[Purchases] - " + logLevel14.name();
                                    str3 = (String) function1.invoke();
                                    currentLogHandler.d(str2, str3);
                                }
                                break;
                            case 6:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function1.invoke(), null);
                                break;
                            case 7:
                                LogLevel logLevel15 = LogLevel.INFO;
                                LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                    currentLogHandler14.i("[Purchases] - " + logLevel15.name(), (String) function1.invoke());
                                }
                                break;
                            case 8:
                                LogLevel logLevel16 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                    str2 = "[Purchases] - " + logLevel16.name();
                                    str3 = (String) function1.invoke();
                                    currentLogHandler.d(str2, str3);
                                }
                                break;
                            case 9:
                                LogLevel logLevel17 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                    str2 = "[Purchases] - " + logLevel17.name();
                                    str3 = (String) function1.invoke();
                                    currentLogHandler.d(str2, str3);
                                }
                                break;
                            case 10:
                                LogLevel logLevel18 = LogLevel.WARN;
                                LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                    currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) function1.invoke());
                                }
                                break;
                            case BaseVideoCapturer.RGBA /* 11 */:
                                LogLevel logLevel19 = LogLevel.WARN;
                                LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                                    currentLogHandler16.w("[Purchases] - " + logLevel19.name(), (String) function1.invoke());
                                }
                                break;
                            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function1.invoke(), null);
                                break;
                            case 13:
                                LogLevel logLevel20 = LogLevel.WARN;
                                LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                                    currentLogHandler17.w("[Purchases] - " + logLevel20.name(), (String) function1.invoke());
                                }
                                break;
                            case 14:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function1.invoke(), null);
                                break;
                        }
                    }
                    consumePurchaseUseCase.getOnError().invoke(ErrorsKt.billingResponseToPurchasesError(errorBillingResult.getResponseCode(), str));
                }
            }, 4, null);
        }
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void executeAsync() {
        this.withConnectedClient.invoke(new AnonymousClass1());
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void onOk(String received) {
        Intrinsics.checkNotNullParameter(received, "received");
        this.onReceive.invoke(received);
    }
}
