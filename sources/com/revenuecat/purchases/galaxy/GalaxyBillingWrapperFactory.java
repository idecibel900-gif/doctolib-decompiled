package com.revenuecat.purchases.galaxy;

import android.content.Context;
import com.revenuecat.purchases.PurchasesStateProvider;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.caching.DeviceCache;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0014H\u0002¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/galaxy/GalaxyBillingWrapperFactory;", "", "()V", "createGalaxyBillingWrapper", "Lcom/revenuecat/purchases/common/BillingAbstract;", "stateProvider", "Lcom/revenuecat/purchases/PurchasesStateProvider;", "context", "Landroid/content/Context;", "billingMode", "Lcom/revenuecat/purchases/galaxy/GalaxyBillingMode;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "handleMissingConstructor", "", "e", "Ljava/lang/NoSuchMethodException;", "handleMissingGalaxyModule", "Ljava/lang/ClassNotFoundException;", "handleWrapperCreationFailure", "Ljava/lang/ReflectiveOperationException;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GalaxyBillingWrapperFactory {
    public static final GalaxyBillingWrapperFactory INSTANCE = new GalaxyBillingWrapperFactory();

    private GalaxyBillingWrapperFactory() {
    }

    public final BillingAbstract createGalaxyBillingWrapper(PurchasesStateProvider stateProvider, Context context, GalaxyBillingMode billingMode, DeviceCache deviceCache) {
        Intrinsics.checkNotNullParameter(stateProvider, "stateProvider");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(billingMode, "billingMode");
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        try {
            Object wrapperInstance = Class.forName("com.revenuecat.purchases.galaxy.GalaxyBillingWrapper").getDeclaredConstructor(PurchasesStateProvider.class, Context.class, GalaxyBillingMode.class, DeviceCache.class).newInstance(stateProvider, context, billingMode, deviceCache);
            if (!(wrapperInstance instanceof BillingAbstract)) {
                throw new IllegalStateException("GalaxyBillingWrapper does not implement BillingAbstract");
            }
            Intrinsics.checkNotNullExpressionValue(wrapperInstance, "wrapperInstance");
            return (BillingAbstract) wrapperInstance;
        } catch (ClassNotFoundException e) {
            handleMissingGalaxyModule(e);
            throw new KotlinNothingValueException();
        } catch (NoSuchMethodException e2) {
            handleMissingConstructor(e2);
            throw new KotlinNothingValueException();
        } catch (ReflectiveOperationException e3) {
            handleWrapperCreationFailure(e3);
            throw new KotlinNothingValueException();
        }
    }

    private final Void handleMissingGalaxyModule(ClassNotFoundException e) {
        NoClassDefFoundError noClassDefFoundError = new NoClassDefFoundError(e.getMessage());
        noClassDefFoundError.initCause(e);
        throw noClassDefFoundError;
    }

    private final Void handleMissingConstructor(NoSuchMethodException e) {
        throw new IllegalStateException("Failed to find GalaxyBillingWrapper constructor. Please ensure that you've declared a dependency on the purchases-galaxy module.", e);
    }

    private final Void handleWrapperCreationFailure(ReflectiveOperationException e) {
        throw new IllegalStateException("Failed to create GalaxyBillingWrapper", e);
    }
}
