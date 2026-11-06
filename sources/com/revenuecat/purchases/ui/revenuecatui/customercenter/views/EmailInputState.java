package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003JS\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/EmailInputState;", "", AuthorizationRequest.Scope.EMAIL, "", "onEmailChange", "Lkotlin/Function1;", "", "onFocusChanged", "", "showError", "enabled", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZZ)V", "getEmail", "()Ljava/lang/String;", "getEnabled", "()Z", "getOnEmailChange", "()Lkotlin/jvm/functions/Function1;", "getOnFocusChanged", "getShowError", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EmailInputState {
    private final String email;
    private final boolean enabled;
    private final Function1 onEmailChange;
    private final Function1 onFocusChanged;
    private final boolean showError;

    public static /* synthetic */ EmailInputState copy$default(EmailInputState emailInputState, String str, Function1 function1, Function1 function2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emailInputState.email;
        }
        if ((i & 2) != 0) {
            function1 = emailInputState.onEmailChange;
        }
        if ((i & 4) != 0) {
            function2 = emailInputState.onFocusChanged;
        }
        if ((i & 8) != 0) {
            z = emailInputState.showError;
        }
        if ((i & 16) != 0) {
            z2 = emailInputState.enabled;
        }
        boolean z3 = z2;
        Function1 function3 = function2;
        return emailInputState.copy(str, function1, function3, z, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Function1 getOnEmailChange() {
        return this.onEmailChange;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Function1 getOnFocusChanged() {
        return this.onFocusChanged;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowError() {
        return this.showError;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final EmailInputState copy(String email, Function1 onEmailChange, Function1 onFocusChanged, boolean showError, boolean enabled) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(onEmailChange, "onEmailChange");
        Intrinsics.checkNotNullParameter(onFocusChanged, "onFocusChanged");
        return new EmailInputState(email, onEmailChange, onFocusChanged, showError, enabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmailInputState)) {
            return false;
        }
        EmailInputState emailInputState = (EmailInputState) other;
        return Intrinsics.areEqual(this.email, emailInputState.email) && Intrinsics.areEqual(this.onEmailChange, emailInputState.onEmailChange) && Intrinsics.areEqual(this.onFocusChanged, emailInputState.onFocusChanged) && this.showError == emailInputState.showError && this.enabled == emailInputState.enabled;
    }

    public int hashCode() {
        return (((((((this.email.hashCode() * 31) + this.onEmailChange.hashCode()) * 31) + this.onFocusChanged.hashCode()) * 31) + Boolean.hashCode(this.showError)) * 31) + Boolean.hashCode(this.enabled);
    }

    public String toString() {
        return "EmailInputState(email=" + this.email + ", onEmailChange=" + this.onEmailChange + ", onFocusChanged=" + this.onFocusChanged + ", showError=" + this.showError + ", enabled=" + this.enabled + ')';
    }

    public EmailInputState(String email, Function1 onEmailChange, Function1 onFocusChanged, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(onEmailChange, "onEmailChange");
        Intrinsics.checkNotNullParameter(onFocusChanged, "onFocusChanged");
        this.email = email;
        this.onEmailChange = onEmailChange;
        this.onFocusChanged = onFocusChanged;
        this.showError = z;
        this.enabled = z2;
    }

    public final String getEmail() {
        return this.email;
    }

    public final Function1 getOnEmailChange() {
        return this.onEmailChange;
    }

    public final Function1 getOnFocusChanged() {
        return this.onFocusChanged;
    }

    public final boolean getShowError() {
        return this.showError;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }
}
