package io.didomi.ssl;

import android.util.Base64;
import androidx.lifecycle.ViewModel;
import com.amazon.a.a.o.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0017\u0010\u001a\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0007\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u001c\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0016R\u0011\u0010!\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010\"\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u0003\u0010 ¨\u0006+"}, d2 = {"Lio/didomi/sdk/nh;", "Landroidx/lifecycle/ViewModel;", "Lio/didomi/sdk/e0;", "a", "Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/n7;", "b", "Lio/didomi/sdk/n7;", "languagesHelper", "Lio/didomi/sdk/u7;", "c", "Lio/didomi/sdk/u7;", "e", "()Lio/didomi/sdk/u7;", "logoProvider", "", "d", "Ljava/lang/String;", b.I, "Lkotlin/Lazy;", "g", "()Ljava/lang/String;", "token", "f", "userId", "contentText", b.S, "contentTitle", "copiedLabel", "Lio/didomi/sdk/a;", "h", "()Lio/didomi/sdk/a;", "userInfoPanelAccessibility", "closeButtonAccessibility", "Lio/didomi/sdk/r0;", "consentRepository", "Lio/didomi/sdk/v0;", "contextHelper", "Lio/didomi/sdk/ph;", "userRepository", "<init>", "(Lio/didomi/sdk/e0;Lio/didomi/sdk/r0;Lio/didomi/sdk/v0;Lio/didomi/sdk/n7;Lio/didomi/sdk/ph;Lio/didomi/sdk/u7;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class nh extends ViewModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final e0 configurationRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final n7 languagesHelper;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final u7 logoProvider;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String sdkVersion;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final Lazy token;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final String userId;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final String contentText;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0 {
        final /* synthetic */ r0 a;
        final /* synthetic */ nh b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(r0 r0Var, nh nhVar) {
            super(0);
            this.a = r0Var;
            this.b = nhVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            String string = t0.a(this.a.b()).toString();
            Intrinsics.checkNotNullExpressionValue(string, "consentRepository.consentToken.toJSON().toString()");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return n7.a(this.b.languagesHelper, "user_information_token", null, null, null, 14, null) + ":\n" + Base64.encodeToString(bytes, 2);
        }
    }

    public nh(e0 configurationRepository, r0 consentRepository, v0 contextHelper, n7 languagesHelper, ph userRepository, u7 logoProvider) {
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(consentRepository, "consentRepository");
        Intrinsics.checkNotNullParameter(contextHelper, "contextHelper");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        Intrinsics.checkNotNullParameter(userRepository, "userRepository");
        Intrinsics.checkNotNullParameter(logoProvider, "logoProvider");
        this.configurationRepository = configurationRepository;
        this.languagesHelper = languagesHelper;
        this.logoProvider = logoProvider;
        String str = n7.a(languagesHelper, "user_information_sdk_version", null, null, null, 14, null) + ' ' + contextHelper.getSdkVersionName();
        this.sdkVersion = str;
        this.token = LazyKt.lazy(new a(consentRepository, this));
        String str2 = n7.a(languagesHelper, "user_information_user_id", null, null, null, 14, null) + ":\n" + userRepository.getUserId();
        this.userId = str2;
        this.contentText = g() + "\n\n" + str2 + "\n\n" + str;
    }

    private final String g() {
        return (String) this.token.getValue();
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getContentText() {
        return this.contentText;
    }

    public final String c() {
        return n7.a(this.languagesHelper, "user_information_title", null, null, null, 14, null);
    }

    public final String d() {
        return n7.a(this.languagesHelper, "user_information_copied", null, null, null, 14, null);
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final u7 getLogoProvider() {
        return this.logoProvider;
    }

    public final String f() {
        return x8.a.a(this.configurationRepository, this.languagesHelper);
    }

    public final Accessibility h() {
        return new Accessibility(n7.a(this.languagesHelper, "user_information_description", null, null, null, 14, null), n7.a(this.languagesHelper, "copy_to_clipboard_action", null, null, null, 14, null), null, false, 0, null, 60, null);
    }

    public final Accessibility a() {
        return new Accessibility(n7.a(this.languagesHelper, "close", null, null, null, 14, null), n7.a(this.languagesHelper, "go_back_to_partners_list", null, null, null, 14, null), null, false, 0, null, 60, null);
    }
}
