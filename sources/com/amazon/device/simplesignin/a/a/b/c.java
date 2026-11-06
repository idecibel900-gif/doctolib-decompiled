package com.amazon.device.simplesignin.a.a.b;

import com.amazon.device.simplesignin.a.a.d;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.LinkUserAccountResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends com.amazon.device.simplesignin.a.a.c {
    protected c(d dVar, String str, String str2) {
        super(dVar, str, str2);
    }

    @Override // com.amazon.device.simplesignin.a.a.c
    protected void a(RequestStatus requestStatus) {
        a(requestStatus, null, null);
    }

    protected void a(RequestStatus requestStatus, String str, LinkUserAccountResponse.SuccessCode successCode) {
        d dVar = (d) j();
        LinkUserAccountResponse linkUserAccountResponse = new LinkUserAccountResponse();
        linkUserAccountResponse.setRequestId(dVar.e());
        linkUserAccountResponse.setRequestStatus(requestStatus);
        linkUserAccountResponse.setLinkId(str);
        linkUserAccountResponse.setSuccessCode(successCode);
        super.a(linkUserAccountResponse);
    }

    protected boolean a(Map map) {
        if (!map.containsKey(com.amazon.device.simplesignin.a.a.a.m)) {
            a(RequestStatus.FAILURE);
            return false;
        }
        String str = (String) map.get(com.amazon.device.simplesignin.a.a.a.m);
        if (str == null) {
            a(RequestStatus.FAILURE);
            return false;
        }
        String strA = (!map.containsKey(com.amazon.device.simplesignin.a.a.a.k) || map.get(com.amazon.device.simplesignin.a.a.a.k) == null) ? null : (String) map.get(com.amazon.device.simplesignin.a.a.a.k);
        if (map.containsKey(com.amazon.device.simplesignin.a.a.a.l) && map.get(com.amazon.device.simplesignin.a.a.a.l) != null) {
            strA = com.amazon.device.simplesignin.a.d.b.a((String) map.get(com.amazon.device.simplesignin.a.a.a.l));
        }
        a(RequestStatus.SUCCESSFUL, strA, LinkUserAccountResponse.SuccessCode.valueOf(str));
        return true;
    }
}
