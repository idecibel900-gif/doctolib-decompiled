package com.revenuecat.purchases.google.attribution;

import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.revenuecat.purchases.common.LogIntent;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/revenuecat/purchases/common/LogWrapperKt$log$fullMessageBuilder$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3 extends Lambda implements Function0 {
    final /* synthetic */ GooglePlayServicesRepairableException $e$inlined;
    final /* synthetic */ LogIntent $intent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3(LogIntent logIntent, GooglePlayServicesRepairableException googlePlayServicesRepairableException) {
        super(0);
        this.$intent = logIntent;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append(CollectionsKt.joinToString$default(this.$intent.getEmojiList(), "", null, null, 0, null, null, 62, null));
        sb.append(' ');
        throw null;
    }
}
