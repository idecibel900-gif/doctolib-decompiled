package io.didomi.ssl;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import io.didomi.ssl.apiEvents.a;
import io.didomi.ssl.events.HideNoticeEvent;
import io.didomi.ssl.events.HidePreferencesEvent;
import io.didomi.ssl.events.ShowNoticeEvent;
import io.didomi.ssl.events.ShowPreferencesEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lio/didomi/sdk/a8;", "", "Landroidx/fragment/app/FragmentActivity;", "activity", "", "b", "a", "Lio/didomi/sdk/ic;", "subScreenType", "Landroidx/fragment/app/FragmentManager;", "parentFragmentManager", "Lio/didomi/sdk/e0;", "Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/b6;", "Lio/didomi/sdk/b6;", "eventsRepository", "Lio/didomi/sdk/apiEvents/a;", "c", "Lio/didomi/sdk/apiEvents/a;", "apiEventsRepository", "Lio/didomi/sdk/r0;", "d", "Lio/didomi/sdk/r0;", "consentRepository", "Lio/didomi/sdk/eh;", "e", "Lio/didomi/sdk/eh;", "uiProvider", "Lio/didomi/sdk/jh;", "f", "Lio/didomi/sdk/jh;", "userChoicesInfoProvider", "<init>", "(Lio/didomi/sdk/e0;Lio/didomi/sdk/b6;Lio/didomi/sdk/apiEvents/a;Lio/didomi/sdk/r0;Lio/didomi/sdk/eh;Lio/didomi/sdk/jh;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class a8 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final e0 configurationRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final b6 eventsRepository;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final a apiEventsRepository;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final r0 consentRepository;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final eh uiProvider;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final jh userChoicesInfoProvider;

    public a8(e0 configurationRepository, b6 eventsRepository, a apiEventsRepository, r0 consentRepository, eh uiProvider, jh userChoicesInfoProvider) {
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(eventsRepository, "eventsRepository");
        Intrinsics.checkNotNullParameter(apiEventsRepository, "apiEventsRepository");
        Intrinsics.checkNotNullParameter(consentRepository, "consentRepository");
        Intrinsics.checkNotNullParameter(uiProvider, "uiProvider");
        Intrinsics.checkNotNullParameter(userChoicesInfoProvider, "userChoicesInfoProvider");
        this.configurationRepository = configurationRepository;
        this.eventsRepository = eventsRepository;
        this.apiEventsRepository = apiEventsRepository;
        this.consentRepository = consentRepository;
        this.uiProvider = uiProvider;
        this.userChoicesInfoProvider = userChoicesInfoProvider;
    }

    public final void a(FragmentActivity activity) {
        this.consentRepository.s();
        if (activity == null) {
            Log.w$default("Activity passed to forceShowNotice is null", null, 2, null);
            return;
        }
        this.eventsRepository.c(new ShowNoticeEvent());
        if (this.configurationRepository.b().getNotice().getEnabled()) {
            this.uiProvider.a(activity);
        }
        if (this.configurationRepository.b().getPreferences().getShowWhenConsentIsMissing()) {
            a(this, activity, null, 2, null);
        }
        this.apiEventsRepository.e();
    }

    public final void b(FragmentActivity activity) {
        if (activity == null) {
            Log.w$default("Activity passed to showNotice is null", null, 2, null);
        } else if (this.consentRepository.t()) {
            a(activity);
        }
    }

    public final void b() {
        this.eventsRepository.c(new HidePreferencesEvent());
        this.uiProvider.h();
        this.userChoicesInfoProvider.j();
    }

    public final void b(FragmentManager parentFragmentManager) {
        Intrinsics.checkNotNullParameter(parentFragmentManager, "parentFragmentManager");
        di.INSTANCE.a(parentFragmentManager);
    }

    public final void a() {
        this.eventsRepository.c(new HideNoticeEvent());
        this.uiProvider.d();
    }

    public static /* synthetic */ void a(a8 a8Var, FragmentActivity fragmentActivity, ic icVar, int i, Object obj) {
        if ((i & 2) != 0) {
            icVar = ic.None;
        }
        a8Var.a(fragmentActivity, icVar);
    }

    public final void a(FragmentActivity activity, ic subScreenType) {
        Intrinsics.checkNotNullParameter(subScreenType, "subScreenType");
        if (activity == null) {
            Log.w$default("Activity passed to showPreferences is null", null, 2, null);
        } else {
            this.eventsRepository.c(new ShowPreferencesEvent());
            this.uiProvider.a(activity, subScreenType);
        }
    }

    public final void a(FragmentManager parentFragmentManager) {
        Intrinsics.checkNotNullParameter(parentFragmentManager, "parentFragmentManager");
        vb.INSTANCE.a(parentFragmentManager);
    }
}
