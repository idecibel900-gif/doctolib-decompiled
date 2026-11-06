package com.amazon.device.simplesignin.a.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.amazon.device.simplesignin.ISimpleSignInResponseHandler;
import com.amazon.device.simplesignin.SimpleSignInService;
import com.amazon.device.simplesignin.a.c;
import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.request.LinkUserAccountRequest;
import com.amazon.device.simplesignin.model.request.SSIEventRequest;
import com.amazon.device.simplesignin.model.response.GetUserAndLinksResponse;
import com.amazon.device.simplesignin.model.response.LinkUserAccountResponse;
import com.amazon.device.simplesignin.model.response.RecordMetricsEventResponse;
import com.amazon.device.simplesignin.model.response.ShowLoginSelectionResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b implements com.amazon.device.simplesignin.a.b {
    private static final String a = "b";
    private static final String b = "com.amazon.sdktestclient";
    private static final String c = "com.amazon.sdktestclient.command.CommandBroker";

    @Override // com.amazon.device.simplesignin.a.b
    public void a(RequestId requestId, String str) {
        Context contextC = c.a().c();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", requestId);
            jSONObject.put("packageName", contextC.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, SimpleSignInService.SDK_VERSION);
            jSONObject.put(com.amazon.device.simplesignin.a.a.a.a, str);
            Bundle bundle = new Bundle();
            bundle.putString("getUserAndLinksInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.simplesignin.getUserAndLinks");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextC.startService(intentA);
        } catch (JSONException unused) {
        }
    }

    @Override // com.amazon.device.simplesignin.a.b
    public void a(RequestId requestId, LinkUserAccountRequest linkUserAccountRequest) {
        Context contextC = c.a().c();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", requestId);
            jSONObject.put("packageName", contextC.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, SimpleSignInService.SDK_VERSION);
            jSONObject.put(com.amazon.device.simplesignin.a.a.a.d, linkUserAccountRequest.getPartnerUserId());
            jSONObject.put(com.amazon.device.simplesignin.a.a.a.a, linkUserAccountRequest.getIdentityProviderName());
            jSONObject.put(com.amazon.device.simplesignin.a.a.a.e, linkUserAccountRequest.getUserLoginName());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("token", linkUserAccountRequest.getLinkToken().getToken());
            jSONObject2.put(com.amazon.device.simplesignin.a.a.a.E, linkUserAccountRequest.getLinkToken().getSchema());
            jSONObject.put(com.amazon.device.simplesignin.a.a.a.g, jSONObject2.toString());
            jSONObject.put(com.amazon.device.simplesignin.a.a.a.f, linkUserAccountRequest.getLinkSigningKey());
            Bundle bundle = new Bundle();
            bundle.putString("linkUserAccountInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.simplesignin.linkUserAccount");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextC.startService(intentA);
        } catch (JSONException e) {
            throw new IllegalStateException("Unable to create linkToken json", e);
        }
    }

    @Override // com.amazon.device.simplesignin.a.b
    public void a(RequestId requestId, Map<String, String> map) {
        Context contextC = c.a().c();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", requestId);
            jSONObject.put("packageName", contextC.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, SimpleSignInService.SDK_VERSION);
            Intent intentA = a("com.amazon.testclient.simplesignin.showLoginSelection");
            intentA.putExtra("showLoginSelectionInput", jSONObject.toString());
            intentA.putExtra(com.amazon.device.simplesignin.a.a.a.o, new HashMap(map));
            intentA.addFlags(268435456);
            contextC.startService(intentA);
        } catch (JSONException e) {
            throw new IllegalStateException("Unable to create showLoginSelection input json", e);
        }
    }

    @Override // com.amazon.device.simplesignin.a.b
    public void a(RequestId requestId, SSIEventRequest sSIEventRequest) {
        Context contextC = c.a().c();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.device.simplesignin.a.a.a.t, sSIEventRequest.getEvent().toString());
            jSONObject.put(com.amazon.device.simplesignin.a.a.a.u, sSIEventRequest.getEpochTimestamp());
            if (sSIEventRequest.getFailureReason() != null) {
                jSONObject.put(com.amazon.device.simplesignin.a.a.a.v, sSIEventRequest.getFailureReason().toString());
            }
            Intent intentA = a("com.amazon.testclient.simplesignin.recordmetricsevent");
            intentA.addFlags(268435456);
            contextC.startService(intentA);
        } catch (JSONException unused) {
            Objects.toString(requestId);
        }
    }

    @Override // com.amazon.device.simplesignin.a.b
    public void a(Context context, Intent intent) {
        intent.setComponent(new ComponentName(b, c));
        try {
            String string = intent.getExtras().getString("responseType");
            if ("com.amazon.testclient.simplesignin.getUserAndLinks".equals(string)) {
                a(a(intent));
                return;
            }
            if ("com.amazon.testclient.simplesignin.linkUserAccount".equals(string)) {
                a(c(intent));
            } else if ("com.amazon.testclient.simplesignin.showLoginSelection".equals(string)) {
                a(d(intent));
            } else if ("com.amazon.testclient.simplesignin.recordmetricsevent".equals(string)) {
                a(b(intent));
            }
        } catch (Exception unused) {
        }
    }

    private GetUserAndLinksResponse a(Intent intent) {
        GetUserAndLinksResponse getUserAndLinksResponse = new GetUserAndLinksResponse();
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("getUserAndLinksOutput"));
            getUserAndLinksResponse.setRequestId(new RequestId(jSONObject.getString("requestId")));
            RequestStatus requestStatusValueOf = RequestStatus.valueOf(jSONObject.getString("status"));
            getUserAndLinksResponse.setRequestStatus(requestStatusValueOf);
            if (!RequestStatus.SUCCESSFUL.equals(requestStatusValueOf)) {
                return getUserAndLinksResponse;
            }
            String string = jSONObject.getString(com.amazon.device.simplesignin.a.a.a.b);
            getUserAndLinksResponse.setAmazonUserId(string);
            getUserAndLinksResponse.setLinks(com.amazon.device.simplesignin.a.d.b.a(string, jSONObject.getString(com.amazon.device.simplesignin.a.a.a.c)));
        } catch (JSONException unused) {
        }
        return getUserAndLinksResponse;
    }

    private RecordMetricsEventResponse b(Intent intent) {
        RecordMetricsEventResponse recordMetricsEventResponse = new RecordMetricsEventResponse();
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("recordMetricsEventOutput"));
            recordMetricsEventResponse.setRequestId(new RequestId(jSONObject.getString("requestId")));
            RequestStatus requestStatusValueOf = RequestStatus.valueOf(jSONObject.getString("status"));
            recordMetricsEventResponse.setRequestStatus(requestStatusValueOf);
            RequestStatus.SUCCESSFUL.equals(requestStatusValueOf);
        } catch (JSONException unused) {
        }
        return recordMetricsEventResponse;
    }

    private LinkUserAccountResponse c(Intent intent) {
        LinkUserAccountResponse linkUserAccountResponse = new LinkUserAccountResponse();
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("linkUserAccountOutput"));
            linkUserAccountResponse.setRequestId(new RequestId(jSONObject.getString("requestId")));
            RequestStatus requestStatusValueOf = RequestStatus.valueOf(jSONObject.getString("status"));
            linkUserAccountResponse.setRequestStatus(requestStatusValueOf);
            if (!RequestStatus.SUCCESSFUL.equals(requestStatusValueOf)) {
                return linkUserAccountResponse;
            }
            String string = jSONObject.getString(com.amazon.device.simplesignin.a.a.a.m);
            if (!LinkUserAccountResponse.SuccessCode.ConsentDenied.equals(LinkUserAccountResponse.SuccessCode.valueOf(string))) {
                linkUserAccountResponse.setLinkId(jSONObject.getString(com.amazon.device.simplesignin.a.a.a.k));
            }
            linkUserAccountResponse.setSuccessCode(LinkUserAccountResponse.SuccessCode.valueOf(string));
        } catch (JSONException unused) {
        }
        return linkUserAccountResponse;
    }

    private ShowLoginSelectionResponse d(Intent intent) {
        ShowLoginSelectionResponse showLoginSelectionResponse = new ShowLoginSelectionResponse();
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("showLoginSelectionOutput"));
            showLoginSelectionResponse.setRequestId(new RequestId(jSONObject.getString("requestId")));
            RequestStatus requestStatusValueOf = RequestStatus.valueOf(jSONObject.getString("status"));
            showLoginSelectionResponse.setRequestStatus(requestStatusValueOf);
            if (RequestStatus.SUCCESSFUL.equals(requestStatusValueOf)) {
                String string = jSONObject.getString(com.amazon.device.simplesignin.a.a.a.q);
                ShowLoginSelectionResponse.UserSelection userSelection = ShowLoginSelectionResponse.UserSelection.LoginSelected;
                if (!userSelection.name().equals(string)) {
                    showLoginSelectionResponse.setUserSelection(ShowLoginSelectionResponse.UserSelection.ManualSignIn);
                    return showLoginSelectionResponse;
                }
                String string2 = jSONObject.getString(com.amazon.device.simplesignin.a.a.a.r);
                if (string2 != null) {
                    showLoginSelectionResponse.setUserSelection(userSelection);
                    showLoginSelectionResponse.setLinkId(string2);
                }
            }
            return showLoginSelectionResponse;
        } catch (JSONException unused) {
            showLoginSelectionResponse.setUserSelection(ShowLoginSelectionResponse.UserSelection.ManualSignIn);
            return showLoginSelectionResponse;
        }
    }

    private Intent a(String str) {
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName(b, c));
        return intent;
    }

    private void a(final Object obj) {
        Context contextC = c.a().c();
        final ISimpleSignInResponseHandler iSimpleSignInResponseHandlerD = c.a().d();
        if (contextC == null || obj == null) {
            Objects.toString(obj);
        } else {
            new Handler(contextC.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.simplesignin.a.c.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Object obj2 = obj;
                        if (obj2 instanceof GetUserAndLinksResponse) {
                            iSimpleSignInResponseHandlerD.onGetUserAndLinksResponse((GetUserAndLinksResponse) obj2);
                            return;
                        }
                        if (obj2 instanceof LinkUserAccountResponse) {
                            iSimpleSignInResponseHandlerD.onLinkUserAccountResponse((LinkUserAccountResponse) obj2);
                            return;
                        }
                        if (obj2 instanceof ShowLoginSelectionResponse) {
                            iSimpleSignInResponseHandlerD.onShowLoginSelectionResponse((ShowLoginSelectionResponse) obj2);
                        } else if (!(obj2 instanceof RecordMetricsEventResponse)) {
                            String unused = b.a;
                            obj.getClass();
                        } else {
                            iSimpleSignInResponseHandlerD.onRecordMetricsEventResponse((RecordMetricsEventResponse) obj2);
                        }
                    } catch (Exception e) {
                        String unused2 = b.a;
                        e.toString();
                    }
                }
            });
        }
    }
}
