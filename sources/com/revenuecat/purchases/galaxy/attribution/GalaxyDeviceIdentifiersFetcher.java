package com.revenuecat.purchases.galaxy.attribution;

import android.app.Application;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/galaxy/attribution/GalaxyDeviceIdentifiersFetcher;", "Lcom/revenuecat/purchases/common/subscriberattributes/DeviceIdentifiersFetcher;", "<init>", "()V", "Landroid/app/Application;", "applicationContext", "Lkotlin/Function1;", "", "", "", "completion", "getDeviceIdentifiers", "(Landroid/app/Application;Lkotlin/jvm/functions/Function1;)V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GalaxyDeviceIdentifiersFetcher implements DeviceIdentifiersFetcher {
    @Override // com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher
    public void getDeviceIdentifiers(Application applicationContext, Function1 completion) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(completion, "completion");
        completion.invoke(MapsKt.emptyMap());
    }
}
