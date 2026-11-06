package io.didomi.ssl;

import io.didomi.ssl.consent.model.ConsentToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\u0007"}, d2 = {"Lio/didomi/sdk/jh;", "Lio/didomi/sdk/consent/model/ConsentToken;", "consentToken", "Lio/didomi/sdk/zh;", "vendorRepository", "", "a", "android_release"}, k = 2, mv = {1, 8, 0})
public final class kh {
    public static final void a(jh jhVar, ConsentToken consentToken, zh vendorRepository) {
        Intrinsics.checkNotNullParameter(jhVar, "<this>");
        Intrinsics.checkNotNullParameter(consentToken, "consentToken");
        Intrinsics.checkNotNullParameter(vendorRepository, "vendorRepository");
        jhVar.a(consentToken, vendorRepository.l(), vendorRepository.n());
    }
}
