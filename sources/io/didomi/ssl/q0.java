package io.didomi.ssl;

import androidx.lifecycle.ViewModel;
import com.opentok.android.PublisherKit;
import io.didomi.ssl.apiEvents.a;
import io.didomi.ssl.events.Event;
import io.didomi.ssl.events.NoticeClickAgreeEvent;
import io.didomi.ssl.events.NoticeClickDisagreeEvent;
import io.didomi.ssl.events.NoticeClickMoreInfoEvent;
import io.didomi.ssl.events.NoticeClickViewSPIPurposesEvent;
import io.didomi.ssl.events.NoticeClickViewVendorsEvent;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 >2\u00020\u0001:\u0002\u0007\tBI\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u001e\u0012\u0006\u0010i\u001a\u00020h\u0012\u0006\u0010&\u001a\u00020!\u0012\u0006\u0010,\u001a\u00020'\u0012\u0006\u00102\u001a\u00020-¢\u0006\u0004\bj\u0010kJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\rR\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\u00168\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001fR\u001a\u0010&\u001a\u00020!8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010,\u001a\u00020'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u00102\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u00104\u001a\u0004\b:\u0010;R\u001b\u0010@\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u00104\u001a\u0004\b>\u0010?R\u001b\u0010D\u001a\u00020A8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bB\u00104\u001a\u0004\b\"\u0010CR\u001b\u0010F\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u00104\u001a\u0004\b(\u00106R\u001b\u0010H\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u00104\u001a\u0004\b.\u00106R\u001b\u0010I\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u00104\u001a\u0004\b3\u00106R!\u0010N\u001a\u00020\u00028TX\u0094\u0084\u0002¢\u0006\u0012\n\u0004\bJ\u00104\u0012\u0004\bL\u0010M\u001a\u0004\bK\u00106R\u001b\u0010Q\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bO\u00104\u001a\u0004\bP\u00106R\u0014\u0010S\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010RR\u0011\u0010U\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010TR\u0011\u0010V\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bO\u0010RR\u0011\u0010W\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010RR\u0011\u0010X\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010TR\u0011\u0010Z\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bY\u0010RR\u0011\u0010\\\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b[\u0010RR\u0011\u0010^\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b]\u0010RR\u0014\u0010b\u001a\u00020_8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0011\u0010c\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bJ\u0010RR\u0011\u0010d\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bB\u0010TR\u0011\u0010f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bE\u0010eR\u0014\u0010g\u001a\u00020\u00028DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b9\u00106¨\u0006l"}, d2 = {"Lio/didomi/sdk/q0;", "Landroidx/lifecycle/ViewModel;", "", "asLink", "", "c", "Lio/didomi/sdk/a;", "a", "", "b", "contentText", "Lio/didomi/sdk/events/Event;", "event", "", "B", "D", "C", "z", "A", "Lio/didomi/sdk/apiEvents/a;", "Lio/didomi/sdk/apiEvents/a;", "apiEventsRepository", "Lio/didomi/sdk/e0;", "Lio/didomi/sdk/e0;", "d", "()Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/r0;", "Lio/didomi/sdk/r0;", "consentRepository", "Lio/didomi/sdk/b6;", "Lio/didomi/sdk/b6;", "eventsRepository", "Lio/didomi/sdk/n7;", "e", "Lio/didomi/sdk/n7;", "j", "()Lio/didomi/sdk/n7;", "languagesHelper", "Lio/didomi/sdk/u7;", "f", "Lio/didomi/sdk/u7;", "n", "()Lio/didomi/sdk/u7;", "logoProvider", "Lio/didomi/sdk/a8;", "g", "Lio/didomi/sdk/a8;", "getNavigationManager", "()Lio/didomi/sdk/a8;", "navigationManager", "h", "Lkotlin/Lazy;", "w", "()Z", "useCcpa", "Lio/didomi/sdk/d8;", "i", "v", "()Lio/didomi/sdk/d8;", "regulationResources", "Lio/didomi/sdk/l$e;", "q", "()Lio/didomi/sdk/l$e;", "notice", "Lio/didomi/sdk/l$h$a;", "k", "()Lio/didomi/sdk/l$h$a;", "denyButtonType", "l", "denyCross", "m", "denyLink", "hasManageSpiChoicesButton", "o", "y", "isTcf2_2$annotations", "()V", "isTcf2_2", "p", "x", "isTablet", "()Ljava/lang/String;", "learnMoreLabel", "()Lio/didomi/sdk/a;", "closeButtonAccessibility", "manageSpiChoicesButtonLabel", "agreeButtonLabel", "agreeButtonAccessibility", "u", "privacyButtonLabel", "s", "noticeContentText", "t", "noticeTitle", "Lio/didomi/sdk/q0$b;", "r", "()Lio/didomi/sdk/q0$b;", "noticeAndPartnersProperties", "manageOurPartnersLabel", "learnMoreButtonAccessibility", "()Ljava/lang/CharSequence;", "learnMoreButtonLabel", "hasVendorsCountMacro", "Lio/didomi/sdk/ib;", "resourcesHelper", "<init>", "(Lio/didomi/sdk/apiEvents/a;Lio/didomi/sdk/e0;Lio/didomi/sdk/r0;Lio/didomi/sdk/b6;Lio/didomi/sdk/ib;Lio/didomi/sdk/n7;Lio/didomi/sdk/u7;Lio/didomi/sdk/a8;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class q0 extends ViewModel {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final a apiEventsRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final e0 configurationRepository;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final r0 consentRepository;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final b6 eventsRepository;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final n7 languagesHelper;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final u7 logoProvider;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final a8 navigationManager;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Lazy useCcpa;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final Lazy regulationResources;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final Lazy notice;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final Lazy denyButtonType;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final Lazy denyCross;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final Lazy denyLink;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final Lazy hasManageSpiChoicesButton;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final Lazy isTcf2_2;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final Lazy isTablet;

    /* JADX INFO: renamed from: io.didomi.sdk.q0$b, reason: from toString */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/didomi/sdk/q0$b;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "noticeText", "b", "Z", "c", "()Z", "partnersLinkInText", "partnersButtonText", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class NoticeAndPartnersProperties {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        private final String noticeText;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        private final boolean partnersLinkInText;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        private final String partnersButtonText;

        public NoticeAndPartnersProperties(String noticeText, boolean z, String str) {
            Intrinsics.checkNotNullParameter(noticeText, "noticeText");
            this.noticeText = noticeText;
            this.partnersLinkInText = z;
            this.partnersButtonText = str;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final String getNoticeText() {
            return this.noticeText;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getPartnersButtonText() {
            return this.partnersButtonText;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final boolean getPartnersLinkInText() {
            return this.partnersLinkInText;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NoticeAndPartnersProperties)) {
                return false;
            }
            NoticeAndPartnersProperties noticeAndPartnersProperties = (NoticeAndPartnersProperties) other;
            return Intrinsics.areEqual(this.noticeText, noticeAndPartnersProperties.noticeText) && this.partnersLinkInText == noticeAndPartnersProperties.partnersLinkInText && Intrinsics.areEqual(this.partnersButtonText, noticeAndPartnersProperties.partnersButtonText);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public int hashCode() {
            int iHashCode = this.noticeText.hashCode() * 31;
            boolean z = this.partnersLinkInText;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            int i = (iHashCode + r1) * 31;
            String str = this.partnersButtonText;
            return i + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "NoticeAndPartnersProperties(noticeText=" + this.noticeText + ", partnersLinkInText=" + this.partnersLinkInText + ", partnersButtonText=" + this.partnersButtonText + ')';
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/l$h$a;", "a", "()Lio/didomi/sdk/l$h$a;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0 {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AppConfiguration.Theme.a invoke() {
            return q0.this.w() ? AppConfiguration.Theme.a.NONE : m.a(q0.this.q());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class d extends Lambda implements Function0 {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(!q0.this.w() && m.b(q0.this.q()));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class e extends Lambda implements Function0 {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(!q0.this.w() && m.c(q0.this.q()));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class f extends Lambda implements Function0 {
        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(f0.e(q0.this.getConfigurationRepository()));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class g extends Lambda implements Function0 {
        final /* synthetic */ ib a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(ib ibVar) {
            super(0);
            this.a = ibVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(this.a.b());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class h extends Lambda implements Function0 {
        h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(Intrinsics.areEqual(m.d(q0.this.getConfigurationRepository().b()), "2.2"));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/l$e;", "a", "()Lio/didomi/sdk/l$e;"}, k = 3, mv = {1, 8, 0})
    static final class i extends Lambda implements Function0 {
        i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AppConfiguration.Notice invoke() {
            return q0.this.getConfigurationRepository().b().getNotice();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/d8;", "a", "()Lio/didomi/sdk/d8;"}, k = 3, mv = {1, 8, 0})
    static final class j extends Lambda implements Function0 {
        j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d8 invoke() {
            return q0.this.w() ? v.a : d6.a;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class k extends Lambda implements Function0 {
        k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(f0.g(q0.this.getConfigurationRepository()));
        }
    }

    public q0(a apiEventsRepository, e0 configurationRepository, r0 consentRepository, b6 eventsRepository, ib resourcesHelper, n7 languagesHelper, u7 logoProvider, a8 navigationManager) {
        Intrinsics.checkNotNullParameter(apiEventsRepository, "apiEventsRepository");
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(consentRepository, "consentRepository");
        Intrinsics.checkNotNullParameter(eventsRepository, "eventsRepository");
        Intrinsics.checkNotNullParameter(resourcesHelper, "resourcesHelper");
        Intrinsics.checkNotNullParameter(languagesHelper, "languagesHelper");
        Intrinsics.checkNotNullParameter(logoProvider, "logoProvider");
        Intrinsics.checkNotNullParameter(navigationManager, "navigationManager");
        this.apiEventsRepository = apiEventsRepository;
        this.configurationRepository = configurationRepository;
        this.consentRepository = consentRepository;
        this.eventsRepository = eventsRepository;
        this.languagesHelper = languagesHelper;
        this.logoProvider = logoProvider;
        this.navigationManager = navigationManager;
        this.useCcpa = LazyKt.lazy(new k());
        this.regulationResources = LazyKt.lazy(new j());
        this.notice = LazyKt.lazy(new i());
        this.denyButtonType = LazyKt.lazy(new c());
        this.denyCross = LazyKt.lazy(new d());
        this.denyLink = LazyKt.lazy(new e());
        this.hasManageSpiChoicesButton = LazyKt.lazy(new f());
        this.isTcf2_2 = LazyKt.lazy(new h());
        this.isTablet = LazyKt.lazy(new g(resourcesHelper));
    }

    private final String m() {
        return n7.a(this.languagesHelper, q().getContent().c(), v().b(), (gc) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppConfiguration.Notice q() {
        return (AppConfiguration.Notice) this.notice.getValue();
    }

    private final d8 v() {
        return (d8) this.regulationResources.getValue();
    }

    public final void A() {
        boolean z = !q().getDenyAppliesToLI();
        this.consentRepository.a(false, z, false, z, "click", this.apiEventsRepository, this.eventsRepository);
        a(new NoticeClickDisagreeEvent());
        this.navigationManager.a();
    }

    public final void B() {
        a(new NoticeClickMoreInfoEvent());
    }

    public final void C() {
        a(new NoticeClickViewSPIPurposesEvent());
    }

    public final void D() {
        a(new NoticeClickViewVendorsEvent());
    }

    public final String b() {
        return n7.a(this.languagesHelper, q().getContent().a(), v().a(), (gc) null, 4, (Object) null);
    }

    public final Accessibility c() {
        return new Accessibility(n7.a(this.languagesHelper, "close", null, null, null, 14, null), n7.a(this.languagesHelper, "close_consent_notice", null, null, null, 14, null), null, false, 0, null, 60, null);
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    protected final e0 getConfigurationRepository() {
        return this.configurationRepository;
    }

    public final AppConfiguration.Theme.a e() {
        return (AppConfiguration.Theme.a) this.denyButtonType.getValue();
    }

    public final boolean f() {
        return ((Boolean) this.denyCross.getValue()).booleanValue();
    }

    public final boolean g() {
        return ((Boolean) this.denyLink.getValue()).booleanValue();
    }

    public final boolean h() {
        return ((Boolean) this.hasManageSpiChoicesButton.getValue()).booleanValue();
    }

    protected final boolean i() {
        String strA = this.languagesHelper.a(q().getContent().e(), v().c());
        return StringsKt.contains$default((CharSequence) strA, (CharSequence) "{numberOfPartners}", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) strA, (CharSequence) "{numberOfIABPartners}", false, 2, (Object) null);
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    protected final n7 getLanguagesHelper() {
        return this.languagesHelper;
    }

    public final Accessibility k() {
        return new Accessibility(hc.a(m()), n7.a(this.languagesHelper, "go_to_purpose_configuration_view", (gc) null, (Map) null, 6, (Object) null), null, false, 0, null, 60, null);
    }

    public final CharSequence l() {
        return hc.a(m(), 0, 1, (Object) null);
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final u7 getLogoProvider() {
        return this.logoProvider;
    }

    public final String o() {
        return n7.a(this.languagesHelper, "manage_our_partners", null, null, null, 14, null);
    }

    public final String p() {
        return n7.a(this.languagesHelper, this.configurationRepository.b().getNotice().getContent().d(), null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0034  */
    public NoticeAndPartnersProperties r() {
        String strO;
        String strS = s();
        boolean zA = a(strS);
        boolean zY = y();
        if (zY && zA && i()) {
            strO = null;
        } else if (zY) {
            strO = n7.a(this.languagesHelper, "manage_our_partners_with_counts", (gc) null, (Map) null, 6, (Object) null);
        } else if (w() || zA) {
            strO = null;
        } else {
            strO = o();
        }
        return new NoticeAndPartnersProperties(strS, zA, strO);
    }

    public final String s() {
        return n7.a(this.languagesHelper, q().getContent().e(), v().c(), (gc) null, 4, (Object) null);
    }

    public final String t() {
        return n7.a(this.languagesHelper, q().getContent().g(), v().d(), (gc) null, 4, (Object) null);
    }

    public final String u() {
        return n7.a(this.languagesHelper, q().getContent().f(), "our_privacy_policy", (gc) null, 4, (Object) null);
    }

    public final boolean w() {
        return ((Boolean) this.useCcpa.getValue()).booleanValue();
    }

    public final boolean x() {
        return ((Boolean) this.isTablet.getValue()).booleanValue();
    }

    protected boolean y() {
        return ((Boolean) this.isTcf2_2.getValue()).booleanValue();
    }

    public final void z() {
        this.consentRepository.a(true, true, true, true, "click", this.apiEventsRepository, this.eventsRepository);
        a(new NoticeClickAgreeEvent());
        this.navigationManager.a();
    }

    public final Accessibility a() {
        return new Accessibility(b(), n7.a(this.languagesHelper, "accept_our_data_processing_and_close_notice", (gc) null, (Map) null, 6, (Object) null), null, false, 0, null, 60, null);
    }

    private final String c(boolean asLink) {
        return n7.a(this.languagesHelper, q().getContent().b(), asLink ? "continue_without_agreeing" : "decline_7eeb5ff4", (gc) null, 4, (Object) null);
    }

    public final CharSequence b(boolean asLink) {
        if (asLink) {
            String upperCase = c(true).toUpperCase(this.languagesHelper.getSelectedLocale());
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            return hc.a(hc.b(upperCase), 0, 1, (Object) null);
        }
        return c(false);
    }

    public final Accessibility a(boolean asLink) {
        return new Accessibility(c(asLink), n7.a(this.languagesHelper, "refuse_our_data_processing_and_close_notice", (gc) null, (Map) null, 6, (Object) null), null, false, 0, null, 60, null);
    }

    public final boolean a(String contentText) {
        Intrinsics.checkNotNullParameter(contentText, "contentText");
        return StringsKt.contains$default((CharSequence) new Regex("[`'\"]").replace(contentText, ""), (CharSequence) "javascript:Didomi.preferences.show(vendors)", false, 2, (Object) null);
    }

    public final void a(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.eventsRepository.c(event);
    }
}
