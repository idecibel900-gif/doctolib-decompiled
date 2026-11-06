package com.amazon.device.simplesignin.a.a.d.a;

import com.amazon.d.a.j;
import com.amazon.device.simplesignin.a.a.c;
import com.amazon.device.simplesignin.a.a.d;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.ShowLoginSelectionResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class b extends c {
    private static final String b = "SSI_LoginSelectionResponse";
    private static final String c = "1.0";

    b(a aVar) {
        super(aVar, b, "1.0");
    }

    @Override // com.amazon.a.a.n.a.h
    protected boolean b(j jVar) throws Exception {
        Map mapB = jVar.b();
        if (!mapB.containsKey(com.amazon.device.simplesignin.a.a.a.q)) {
            a(RequestStatus.FAILURE);
            return false;
        }
        String str = (String) mapB.get(com.amazon.device.simplesignin.a.a.a.q);
        if (str == null) {
            a(RequestStatus.FAILURE);
            return false;
        }
        String str2 = (String) mapB.get(com.amazon.device.simplesignin.a.a.a.r);
        ShowLoginSelectionResponse.UserSelection userSelection = ShowLoginSelectionResponse.UserSelection.LoginSelected;
        if (userSelection.name().equals(str) && str2 != null) {
            a(RequestStatus.SUCCESSFUL, str2, userSelection);
            return true;
        }
        a(RequestStatus.SUCCESSFUL, null, ShowLoginSelectionResponse.UserSelection.ManualSignIn);
        return true;
    }

    @Override // com.amazon.device.simplesignin.a.a.c
    protected void a(RequestStatus requestStatus) {
        if (RequestStatus.INVALID_LINK_SIGNING_KEY_ENCRYPTION.equals(requestStatus) || RequestStatus.INVALID_LINK_SIGNING_KEY.equals(requestStatus)) {
            a(RequestStatus.FAILURE, null, null);
        } else {
            a(requestStatus, null, null);
        }
    }

    private void a(RequestStatus requestStatus, String str, ShowLoginSelectionResponse.UserSelection userSelection) {
        d dVar = (d) j();
        ShowLoginSelectionResponse showLoginSelectionResponse = new ShowLoginSelectionResponse();
        showLoginSelectionResponse.setRequestId(dVar.e());
        showLoginSelectionResponse.setRequestStatus(requestStatus);
        showLoginSelectionResponse.setUserSelection(userSelection);
        showLoginSelectionResponse.setLinkId(str);
        super.a(showLoginSelectionResponse);
    }
}
