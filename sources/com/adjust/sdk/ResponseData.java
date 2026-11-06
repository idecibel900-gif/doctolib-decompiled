package com.adjust.sdk;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ResponseData {
    public ActivityKind activityKind;
    public ActivityPackage activityPackage;
    public String adid;
    public Long askIn;
    public AdjustAttribution attribution;
    public Long continueIn;
    public JSONObject controlParams;
    public JSONObject jsonResponse;
    public String message;
    public String resolvedDeeplink;
    public Long retryIn;
    public Map<String, String> sendingParameters;
    public Map<String, String> signedParameters;
    public String timestamp;
    public TrackingState trackingState;
    public boolean success = false;
    public boolean willRetry = false;

    /* JADX INFO: renamed from: com.adjust.sdk.ResponseData$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ActivityKind.values().length];
            a = iArr;
            try {
                iArr[ActivityKind.SESSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ActivityKind.CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ActivityKind.ATTRIBUTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ActivityKind.EVENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ActivityKind.PURCHASE_VERIFICATION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ActivityKind.THIRD_PARTY_SHARING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static ResponseData buildResponseData(ActivityPackage activityPackage, Map<String, String> map, Map<String, String> map2) {
        ResponseData sessionResponseData;
        ActivityKind activityKind = activityPackage.getActivityKind();
        switch (AnonymousClass1.a[activityKind.ordinal()]) {
            case 1:
                sessionResponseData = new SessionResponseData(activityPackage);
                break;
            case 2:
                sessionResponseData = new SdkClickResponseData();
                break;
            case 3:
                sessionResponseData = new AttributionResponseData();
                break;
            case 4:
                sessionResponseData = new EventResponseData(activityPackage);
                break;
            case 5:
                sessionResponseData = new PurchaseVerificationResponseData();
                break;
            case 6:
                sessionResponseData = new ThirdPartySharingResponseData();
                break;
            default:
                sessionResponseData = new ResponseData();
                break;
        }
        sessionResponseData.activityKind = activityKind;
        sessionResponseData.activityPackage = activityPackage;
        sessionResponseData.sendingParameters = map;
        sessionResponseData.signedParameters = map2;
        return sessionResponseData;
    }

    public String toString() {
        return Util.formatString("message:%s timestamp:%s json:%s", this.message, this.timestamp, this.jsonResponse);
    }
}
