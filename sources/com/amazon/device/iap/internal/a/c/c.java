package com.amazon.device.iap.internal.a.c;

import android.os.RemoteException;
import com.amazon.a.a.o.f;
import com.amazon.d.a.j;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends b {
    private static final String d = "c";

    public c(com.amazon.device.iap.internal.a.c cVar) {
        super(cVar, "1.0");
    }

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws com.amazon.a.a.d.b, RemoteException {
        String str = d;
        com.amazon.device.iap.internal.util.b.a(str, "onSuccessInternal: result = " + jVar);
        Map mapB = jVar.b();
        com.amazon.device.iap.internal.util.b.a(str, "data: " + mapB);
        String str2 = (String) mapB.get("userId");
        com.amazon.device.iap.internal.a.c cVar = (com.amazon.device.iap.internal.a.c) j();
        if (f.a(str2)) {
            cVar.a().a(new UserDataResponseBuilder().setRequestId(cVar.d()).setRequestStatus(UserDataResponse.RequestStatus.FAILED).build());
            return false;
        }
        UserData userDataBuild = new UserDataBuilder().setUserId(str2).setMarketplace(b.c).build();
        UserDataResponse userDataResponseBuild = new UserDataResponseBuilder().setRequestId(cVar.d()).setRequestStatus(UserDataResponse.RequestStatus.SUCCESSFUL).setUserData(userDataBuild).build();
        cVar.a().a("userId", userDataBuild.getUserId());
        cVar.a().a(userDataResponseBuild);
        return true;
    }
}
