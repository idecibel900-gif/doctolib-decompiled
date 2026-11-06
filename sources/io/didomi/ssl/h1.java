package io.didomi.ssl;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import io.didomi.ssl.consent.model.ConsentToken;
import io.didomi.ssl.consent.model.DidomiConsentToken;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b'\u0010(J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0005\u0010\u001cR\u001b\u0010!\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b\n\u0010 R\u001b\u0010%\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001b\u001a\u0004\b\u000e\u0010$R\u0013\u0010&\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u001c¨\u0006)"}, d2 = {"Lio/didomi/sdk/h1;", "", "Lio/didomi/sdk/consent/model/ConsentToken;", "token", "", "a", "Lio/didomi/sdk/e0;", "Lio/didomi/sdk/e0;", "configurationRepository", "Landroid/content/SharedPreferences;", "b", "Landroid/content/SharedPreferences;", "sharedPreferences", "Lio/didomi/sdk/ph;", "c", "Lio/didomi/sdk/ph;", "userRepository", "Lio/didomi/sdk/f1;", "d", "Lio/didomi/sdk/f1;", "dcsEncoder", "Lkotlinx/coroutines/CoroutineDispatcher;", "e", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "", "f", "Lkotlin/Lazy;", "()Ljava/lang/String;", "dcsKey", "", "g", "()I", "dcsSchemaVersion", "", "h", "()Z", "enableDCS", "value", "<init>", "(Lio/didomi/sdk/e0;Landroid/content/SharedPreferences;Lio/didomi/sdk/ph;Lio/didomi/sdk/f1;Lkotlinx/coroutines/CoroutineDispatcher;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class h1 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final e0 configurationRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final SharedPreferences sharedPreferences;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final ph userRepository;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final f1 dcsEncoder;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final CoroutineDispatcher coroutineDispatcher;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final Lazy dcsKey;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final Lazy dcsSchemaVersion;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Lazy enableDCS;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0 {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return h1.this.configurationRepository.e().getDcsKey();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0 {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            AppConfiguration.App.DCSConfig c0140aD = h1.this.configurationRepository.b().getApp().getDcsConfig();
            return Integer.valueOf(c0140aD != null ? c0140aD.getSchemaVersion() : 0);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0 {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(h1.this.configurationRepository.b().getFeatureFlags().getEnableDCS());
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "io.didomi.sdk.consent.DCSRepository$save$1", f = "DCSRepository.kt", l = {57}, m = "invokeSuspend")
    static final class d extends SuspendLambda implements Function2 {
        int a;
        final /* synthetic */ ConsentToken b;
        final /* synthetic */ h1 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ConsentToken consentToken, h1 h1Var, Continuation continuation) {
            super(2, continuation);
            this.b = consentToken;
            this.c = h1Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new d(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DidomiConsentToken didomiConsentTokenA = t0.a(this.b, this.c.userRepository.getUserId());
                f1 f1Var = this.c.dcsEncoder;
                String json = new Gson().toJson(didomiConsentTokenA);
                Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(didomiConsentToken)");
                int iB = this.c.b();
                this.a = 1;
                obj = f1Var.a(json, iB, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            a0 a0Var = (a0) obj;
            if (a0Var.c()) {
                String message = a0Var.a().getMessage();
                if (message == null) {
                    message = "Unknown error from DCS encoder";
                }
                Log.e(message, a0Var.a());
                return Unit.INSTANCE;
            }
            try {
                this.c.sharedPreferences.edit().putString(this.c.a(), (String) a0Var.b()).apply();
            } catch (Exception e) {
                String message2 = e.getMessage();
                if (message2 == null) {
                    message2 = "Unknown error while saving DCS";
                }
                Log.e(message2, e);
            }
            return Unit.INSTANCE;
        }
    }

    public h1(e0 configurationRepository, SharedPreferences sharedPreferences, ph userRepository, f1 dcsEncoder, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(userRepository, "userRepository");
        Intrinsics.checkNotNullParameter(dcsEncoder, "dcsEncoder");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.configurationRepository = configurationRepository;
        this.sharedPreferences = sharedPreferences;
        this.userRepository = userRepository;
        this.dcsEncoder = dcsEncoder;
        this.coroutineDispatcher = coroutineDispatcher;
        this.dcsKey = LazyKt.lazy(new a());
        this.dcsSchemaVersion = LazyKt.lazy(new b());
        this.enableDCS = LazyKt.lazy(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a() {
        return (String) this.dcsKey.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b() {
        return ((Number) this.dcsSchemaVersion.getValue()).intValue();
    }

    private final boolean c() {
        return ((Boolean) this.enableDCS.getValue()).booleanValue();
    }

    public final String d() {
        return this.sharedPreferences.getString(a(), null);
    }

    public final void a(ConsentToken token) {
        Intrinsics.checkNotNullParameter(token, "token");
        if (b() == 0) {
            Log.d$default("DCS won't be saved because the functionality is not enabled.", null, 2, null);
        } else if (c()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.coroutineDispatcher), null, null, new d(token, this, null), 3, null);
        } else {
            Log.d$default("DCS won't be saved because the feature flag is not enabled.", null, 2, null);
        }
    }
}
