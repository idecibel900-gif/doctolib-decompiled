package com.amazon.device.iap.internal.a.c;

import com.amazon.a.a.n.a.h;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataRequest;
import com.amazon.device.iap.model.UserDataResponse;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.amazon.device.iap.internal.a.c {
    public a(RequestId requestId, UserDataRequest userDataRequest) {
        super(requestId);
        d dVar = new d(this, userDataRequest);
        dVar.b(new c(this));
        a((h) dVar);
    }

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void b() {
        a((UserDataResponse) a().b());
    }

    @Override // com.amazon.device.iap.internal.a.c, com.amazon.a.a.j.a
    public void c() {
        UserDataResponse userDataResponseBuild = (UserDataResponse) a().b();
        if (userDataResponseBuild == null) {
            userDataResponseBuild = new UserDataResponseBuilder().setRequestId(d()).setRequestStatus(UserDataResponse.RequestStatus.FAILED).build();
        }
        a(userDataResponseBuild);
    }
}
