package com.doctolib.apps.authentication.error;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v21 com.doctolib.apps.authentication.error.AppAuthErrorCode, still in use, count: 1, list:
  (r0v21 com.doctolib.apps.authentication.error.AppAuthErrorCode) from 0x01ce: INVOKE (r0v21 com.doctolib.apps.authentication.error.AppAuthErrorCode) STATIC call: kotlin.collections.SetsKt.setOf(java.lang.Object):java.util.Set A[MD:(java.lang.Object):java.util.Set (m), WRAPPED] (LINE:223)
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class AppAuthErrorCode implements ErrorCode {
    SERVICE_CONFIGURATION_FETCH_ERROR("service_configuration_fetch_error", "Failed to fetch service configuration from the issuer."),
    AUTHENTICATION_FAILED("authentication_failed", "Authentication failed."),
    TOKEN_REFRESH_FAILED("token_refresh_failed", "Failed to refresh the access token."),
    TOKEN_EXCHANGE_FAILED("token_exchange_failed", "Failed to exchange the authorization code for tokens."),
    REGISTRATION_FAILED("registration_failed", "Client registration failed."),
    BROWSER_NOT_FOUND("browser_not_found", "No suitable browser is available."),
    END_SESSION_FAILED("end_session_failed", "Failed to end the session."),
    USER_CANCELLED("user_cancelled", "The user cancelled the authentication."),
    TIMEOUT("timeout", "The operation timed out."),
    INVALID_CONFIGURATION("invalid_configuration", "The provided configuration is invalid."),
    RUNTIME_EXCEPTION("run_time_exception", "An unexpected error occurred."),
    NOT_INITIALIZED("not_initialized", "AuthClient has not been initialized."),
    ALREADY_INITIALIZED("already_initialized", "AuthClient has already been initialized."),
    INVALID_REQUEST("invalid_request", "The request is missing a required parameter or is otherwise malformed."),
    UNAUTHORIZED_CLIENT("unauthorized_client", "The client is not authorized to request an authorization code."),
    ACCESS_DENIED("access_denied", "The resource owner or authorization server denied the request."),
    UNSUPPORTED_RESPONSE_TYPE("unsupported_response_type", "The authorization server does not support the requested response type."),
    INVALID_SCOPE("invalid_scope", "The requested scope is invalid, unknown, or malformed."),
    SERVER_ERROR("server_error", "The authorization server encountered an unexpected error."),
    TEMPORARILY_UNAVAILABLE("temporarily_unavailable", "The authorization server is temporarily unavailable."),
    INVALID_CLIENT("invalid_client", "Client authentication failed."),
    INVALID_GRANT("invalid_grant", "The provided authorization grant or refresh token is invalid or expired."),
    UNSUPPORTED_GRANT_TYPE("unsupported_grant_type", "The authorization grant type is not supported by the authorization server."),
    INVALID_REDIRECT_URI("invalid_redirect_uri", "The redirect URI is invalid."),
    INVALID_CLIENT_METADATA("invalid_client_metadata", "The client metadata is invalid."),
    DEVICE_KEY_NOT_ENROLLED("device_key_not_enrolled", "The device-key slot holds no key, or no registered subject."),
    DEVICE_KEY_INVALIDATED("device_key_invalidated", "The device key no longer exists or has been permanently invalidated."),
    DEVICE_KEY_POLICY_UNAVAILABLE("device_key_policy_unavailable", "The device cannot honour the requested user authentication or storage level."),
    DEVICE_KEY_STEP_UP_REQUIRED("device_key_step_up_required", "Device-key registration requires a more recent authentication."),
    DEVICE_KEY_REGISTRATION_FAILED("device_key_registration_failed", "Device-key registration failed.");

    private final String defaultMessage;
    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);
    private static final Set ESCALATION_AUTHORIZING = SetsKt.setOf(new AppAuthErrorCode("invalid_grant", "The provided authorization grant or refresh token is invalid or expired."));

    private AppAuthErrorCode(String str, String str2) {
        super(str, i);
        this.value = str;
        this.defaultMessage = str2;
    }

    @Override // com.doctolib.apps.authentication.error.ErrorCode
    public String getValue() {
        return this.value;
    }

    public String getDefaultMessage() {
        return this.defaultMessage;
    }

    static {
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set getESCALATION_AUTHORIZING() {
            return AppAuthErrorCode.ESCALATION_AUTHORIZING;
        }
    }

    public static AppAuthErrorCode valueOf(String str) {
        return (AppAuthErrorCode) Enum.valueOf(AppAuthErrorCode.class, str);
    }

    public static AppAuthErrorCode[] values() {
        return (AppAuthErrorCode[]) $VALUES.clone();
    }
}
