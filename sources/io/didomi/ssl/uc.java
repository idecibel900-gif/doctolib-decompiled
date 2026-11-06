package io.didomi.ssl;

import android.graphics.Bitmap;
import io.didomi.ssl.apiEvents.a;
import io.didomi.ssl.events.NoticeClickPrivacyPolicyEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0016¨\u0006*"}, d2 = {"Lio/didomi/sdk/uc;", "Lio/didomi/sdk/q0;", "", "size", "Landroid/graphics/Bitmap;", "a", "", "H", "I", "Lio/didomi/sdk/fh;", "r", "Lio/didomi/sdk/fh;", "uiStateRepository", "", "G", "()Ljava/lang/String;", "selectText", "F", "ourPrivacyPolicyText", "E", "externalLinkDescriptionText", "Lio/didomi/sdk/q0$b;", "()Lio/didomi/sdk/q0$b;", "noticeAndPartnersProperties", "Lio/didomi/sdk/apiEvents/a;", "apiEventsRepository", "Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/r0;", "consentRepository", "Lio/didomi/sdk/b6;", "eventsRepository", "Lio/didomi/sdk/ib;", "resourcesHelper", "Lio/didomi/sdk/n7;", "languagesHelper", "Lio/didomi/sdk/u7;", "logoProvider", "Lio/didomi/sdk/a8;", "navigationManager", "<init>", "(Lio/didomi/sdk/apiEvents/a;Lio/didomi/sdk/e0;Lio/didomi/sdk/r0;Lio/didomi/sdk/b6;Lio/didomi/sdk/ib;Lio/didomi/sdk/n7;Lio/didomi/sdk/u7;Lio/didomi/sdk/a8;Lio/didomi/sdk/fh;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class uc extends q0 {

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private final UIStateRepository uiStateRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uc(a apiEventsRepository, e0 configurationRepository, r0 consentRepository, b6 eventsRepository, ib resourcesHelper, n7 languagesHelper, u7 logoProvider, a8 navigationManager, UIStateRepository uiStateRepository) {
        super(apiEventsRepository, configurationRepository, consentRepository, eventsRepository, resourcesHelper, languagesHelper, logoProvider, navigationManager);
        Intrinsics.checkNotNullParameter(apiEventsRepository, "apiEventsRepository");
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(consentRepository, "consentRepository");
        Intrinsics.checkNotNullParameter(eventsRepository, "eventsRepository");
        Intrinsics.checkNotNullParameter(resourcesHelper, "resourcesHelper");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        Intrinsics.checkNotNullParameter(logoProvider, "logoProvider");
        Intrinsics.checkNotNullParameter(navigationManager, "navigationManager");
        Intrinsics.checkNotNullParameter(uiStateRepository, "uiStateRepository");
        this.uiStateRepository = uiStateRepository;
    }

    public final String E() {
        return n7.a(getLanguagesHelper(), "external_link_description", (gc) null, MapsKt.mapOf(TuplesKt.to("{url}", getConfigurationRepository().b().getApp().getPrivacyPolicyURL())), 2, (Object) null);
    }

    public final String F() {
        return getLanguagesHelper().a(getConfigurationRepository().b().getNotice().getContent().f(), "our_privacy_policy", gc.UPPER_CASE);
    }

    public final String G() {
        return n7.a(getLanguagesHelper(), "select_colon", (gc) null, (Map) null, 6, (Object) null);
    }

    public final void H() {
        this.uiStateRepository.a(true);
    }

    public final void I() {
        a(new NoticeClickPrivacyPolicyEvent());
    }

    public final Bitmap a(int size) {
        return ta.a.a(getConfigurationRepository().b().getApp().getPrivacyPolicyURL(), size);
    }

    @Override // io.didomi.ssl.q0
    public q0.NoticeAndPartnersProperties r() {
        String strO;
        String strS = s();
        if (!y() || i()) {
            strO = w() ? null : o();
        } else {
            strO = n7.a(getLanguagesHelper(), "manage_our_partners_with_counts", (gc) null, (Map) null, 6, (Object) null);
        }
        return new q0.NoticeAndPartnersProperties(strS, false, strO);
    }
}
