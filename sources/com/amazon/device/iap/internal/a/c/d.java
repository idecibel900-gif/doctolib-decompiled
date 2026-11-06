package com.amazon.device.iap.internal.a.c;

import android.os.RemoteException;
import com.amazon.a.a.o.f;
import com.amazon.d.a.j;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataRequest;
import com.amazon.device.iap.model.UserDataResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends b {
    private static final String d = "d";

    public d(com.amazon.device.iap.internal.a.c cVar, UserDataRequest userDataRequest) {
        super(cVar, com.amazon.a.a.o.b.ah);
        if (userDataRequest != null) {
            a("UserDataRequest.fetchLWAConsentStatus", Boolean.valueOf(userDataRequest.getFetchLWAConsentStatus()));
        }
    }

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws com.amazon.a.a.d.b, RemoteException {
        String str = d;
        com.amazon.device.iap.internal.util.b.a(str, "onResult: result = " + jVar);
        Map mapB = jVar.b();
        com.amazon.device.iap.internal.util.b.a(str, "data: " + mapB);
        String str2 = (String) mapB.get("userId");
        String str3 = (String) mapB.get(com.amazon.a.a.o.b.m);
        String str4 = (String) mapB.get("UserDataResponse.LWAConsentStatus");
        com.amazon.device.iap.internal.a.c cVar = (com.amazon.device.iap.internal.a.c) j();
        if (f.a(str2) || f.a(str3)) {
            cVar.a().a(new UserDataResponseBuilder().setRequestId(cVar.d()).setRequestStatus(UserDataResponse.RequestStatus.FAILED).build());
            return false;
        }
        UserData userDataBuild = new UserDataBuilder().setUserId(str2).setMarketplace(str3).setLWAConsentStatus(str4).build();
        UserDataResponse userDataResponseBuild = new UserDataResponseBuilder().setRequestId(cVar.d()).setRequestStatus(UserDataResponse.RequestStatus.SUCCESSFUL).setUserData(userDataBuild).build();
        cVar.a().a("userId", userDataBuild.getUserId());
        cVar.a().a(userDataResponseBuild);
        return true;
    }
}
