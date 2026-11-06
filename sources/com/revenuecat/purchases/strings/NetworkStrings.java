package com.revenuecat.purchases.strings;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/strings/NetworkStrings;", "", "()V", "API_REQUEST_COMPLETED", "", "API_REQUEST_STARTED", "ETAG_CALL_ALREADY_RETRIED", "ETAG_RETRYING_CALL", "HTTP_RESPONSE_PAYLOAD_NULL", "PROBLEM_CONNECTING", "RETRYING_CALL_WITH_FALLBACK_URL", "SAME_CALL_ALREADY_IN_PROGRESS", "SAME_CALL_SCHEDULED_WITHOUT_JITTER", "SAME_CALL_SCHEDULED_WITH_JITTER", "VERIFICATION_ERROR", "VERIFICATION_INTERMEDIATE_KEY_FAILED", "VERIFICATION_INVALID_SIZE", "VERIFICATION_MISSING_BODY_OR_ETAG", "VERIFICATION_MISSING_REQUEST_TIME", "VERIFICATION_MISSING_SIGNATURE", "VERIFICATION_SUCCESS", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NetworkStrings {
    public static final String API_REQUEST_COMPLETED = "API request completed with status: %s %s %s";
    public static final String API_REQUEST_STARTED = "API request started: %s %s";
    public static final String ETAG_CALL_ALREADY_RETRIED = "We can't find the cached response, but call has already been retried. Returning result from backend: %s";
    public static final String ETAG_RETRYING_CALL = "We were expecting to be able to return a cached response, but we can't find it. Retrying call with a new ETag";
    public static final String HTTP_RESPONSE_PAYLOAD_NULL = "HTTP Response payload is null";
    public static final NetworkStrings INSTANCE = new NetworkStrings();
    public static final String PROBLEM_CONNECTING = "Unable to start a network connection due to a network configuration issue: %s";
    public static final String RETRYING_CALL_WITH_FALLBACK_URL = "Retrying request %s using fallback URL %s";
    public static final String SAME_CALL_ALREADY_IN_PROGRESS = "Same call already in progress, adding to callbacks map with key: %s";
    public static final String SAME_CALL_SCHEDULED_WITHOUT_JITTER = "Request already scheduled without jitter delay, adding callbacks to unjittered request with key: %s";
    public static final String SAME_CALL_SCHEDULED_WITH_JITTER = "Request already scheduled with jitter delay, adding existing callbacks to unjittered request with key: %s";
    public static final String VERIFICATION_ERROR = "Verification: Request to '%s' failed verification.";
    public static final String VERIFICATION_INTERMEDIATE_KEY_FAILED = "Verification: Request to '%s' provided an intermediate key that did not verify correctly. Reason %s";
    public static final String VERIFICATION_INVALID_SIZE = "Verification: Request to '%s' has signature with wrong size. '%s'";
    public static final String VERIFICATION_MISSING_BODY_OR_ETAG = "Verification: Request to '%s' requires a body or etag but none provided.";
    public static final String VERIFICATION_MISSING_REQUEST_TIME = "Verification: Request to '%s' requires a request time but none provided.";
    public static final String VERIFICATION_MISSING_SIGNATURE = "Verification: Request to '%s' requires a signature but none provided.";
    public static final String VERIFICATION_SUCCESS = "Verification: Request to '%s' verified successfully.";

    private NetworkStrings() {
    }
}
