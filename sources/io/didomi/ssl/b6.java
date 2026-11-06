package io.didomi.ssl;

import android.os.Handler;
import android.os.Looper;
import io.didomi.ssl.events.ConsentChangedEvent;
import io.didomi.ssl.events.ErrorEvent;
import io.didomi.ssl.events.Event;
import io.didomi.ssl.events.HideNoticeEvent;
import io.didomi.ssl.events.HidePreferencesEvent;
import io.didomi.ssl.events.InitializationEventListener;
import io.didomi.ssl.events.LanguageUpdateFailedEvent;
import io.didomi.ssl.events.LanguageUpdatedEvent;
import io.didomi.ssl.events.NoticeClickAgreeEvent;
import io.didomi.ssl.events.NoticeClickDisagreeEvent;
import io.didomi.ssl.events.NoticeClickMoreInfoEvent;
import io.didomi.ssl.events.NoticeClickPrivacyPolicyEvent;
import io.didomi.ssl.events.NoticeClickViewSPIPurposesEvent;
import io.didomi.ssl.events.NoticeClickViewVendorsEvent;
import io.didomi.ssl.events.PreferencesClickAgreeToAllEvent;
import io.didomi.ssl.events.PreferencesClickAgreeToAllPurposesEvent;
import io.didomi.ssl.events.PreferencesClickAgreeToAllVendorsEvent;
import io.didomi.ssl.events.PreferencesClickCategoryAgreeEvent;
import io.didomi.ssl.events.PreferencesClickCategoryDisagreeEvent;
import io.didomi.ssl.events.PreferencesClickDisagreeToAllEvent;
import io.didomi.ssl.events.PreferencesClickDisagreeToAllPurposesEvent;
import io.didomi.ssl.events.PreferencesClickDisagreeToAllVendorsEvent;
import io.didomi.ssl.events.PreferencesClickPurposeAgreeEvent;
import io.didomi.ssl.events.PreferencesClickPurposeDisagreeEvent;
import io.didomi.ssl.events.PreferencesClickResetAllPurposesEvent;
import io.didomi.ssl.events.PreferencesClickSPICategoryAgreeEvent;
import io.didomi.ssl.events.PreferencesClickSPICategoryDisagreeEvent;
import io.didomi.ssl.events.PreferencesClickSPIPurposeAgreeEvent;
import io.didomi.ssl.events.PreferencesClickSPIPurposeDisagreeEvent;
import io.didomi.ssl.events.PreferencesClickSPIPurposeSaveChoicesEvent;
import io.didomi.ssl.events.PreferencesClickSaveChoicesEvent;
import io.didomi.ssl.events.PreferencesClickVendorAgreeEvent;
import io.didomi.ssl.events.PreferencesClickVendorDisagreeEvent;
import io.didomi.ssl.events.PreferencesClickVendorSaveChoicesEvent;
import io.didomi.ssl.events.PreferencesClickViewPurposesEvent;
import io.didomi.ssl.events.PreferencesClickViewSPIPurposesEvent;
import io.didomi.ssl.events.PreferencesClickViewVendorsEvent;
import io.didomi.ssl.events.ReadyEvent;
import io.didomi.ssl.events.ShowNoticeEvent;
import io.didomi.ssl.events.ShowPreferencesEvent;
import io.didomi.ssl.events.SyncDoneEvent;
import io.didomi.ssl.events.SyncErrorEvent;
import io.didomi.ssl.functionalinterfaces.DidomiEventListener;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0012J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u0014\u0010\r\u001a\u00020\u000b8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\b\u0010\fR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\b\u0010\u0010¨\u0006\u0014"}, d2 = {"Lio/didomi/sdk/b6;", "", "Lio/didomi/sdk/events/Event;", "event", "", "b", "Lio/didomi/sdk/functionalinterfaces/DidomiEventListener;", "listener", "a", "", "c", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "", "Ljava/util/Set;", "()Ljava/util/Set;", "listeners", "<init>", "(Landroid/os/Handler;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class b6 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Handler handler;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Set<DidomiEventListener> listeners;

    /* JADX WARN: Multi-variable type inference failed */
    public b6() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public Set<DidomiEventListener> a() {
        return this.listeners;
    }

    public boolean b(DidomiEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return a().remove(listener);
    }

    public void c(final Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!b(event)) {
            this.handler.post(new Runnable() { // from class: io.didomi.sdk.b6$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    b6.a(this.f$0, event);
                }
            });
            return;
        }
        Log.e$default("Unable to trigger event of unknown type " + event.getClass().getName(), null, 2, null);
    }

    public b6(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handler = handler;
        this.listeners = new CopyOnWriteArraySet();
    }

    private boolean b(Event event) {
        return !(event instanceof ConsentChangedEvent ? true : event instanceof ErrorEvent ? true : event instanceof ReadyEvent ? true : event instanceof HideNoticeEvent ? true : event instanceof ShowNoticeEvent ? true : event instanceof NoticeClickAgreeEvent ? true : event instanceof NoticeClickDisagreeEvent ? true : event instanceof NoticeClickViewVendorsEvent ? true : event instanceof NoticeClickViewSPIPurposesEvent ? true : event instanceof NoticeClickMoreInfoEvent ? true : event instanceof NoticeClickPrivacyPolicyEvent ? true : event instanceof HidePreferencesEvent ? true : event instanceof ShowPreferencesEvent ? true : event instanceof PreferencesClickViewPurposesEvent ? true : event instanceof PreferencesClickViewVendorsEvent ? true : event instanceof PreferencesClickViewSPIPurposesEvent ? true : event instanceof PreferencesClickAgreeToAllEvent ? true : event instanceof PreferencesClickDisagreeToAllEvent ? true : event instanceof PreferencesClickAgreeToAllPurposesEvent ? true : event instanceof PreferencesClickDisagreeToAllPurposesEvent ? true : event instanceof PreferencesClickResetAllPurposesEvent ? true : event instanceof PreferencesClickPurposeAgreeEvent ? true : event instanceof PreferencesClickPurposeDisagreeEvent ? true : event instanceof PreferencesClickCategoryAgreeEvent ? true : event instanceof PreferencesClickCategoryDisagreeEvent ? true : event instanceof PreferencesClickSaveChoicesEvent ? true : event instanceof PreferencesClickAgreeToAllVendorsEvent ? true : event instanceof PreferencesClickDisagreeToAllVendorsEvent ? true : event instanceof PreferencesClickVendorAgreeEvent ? true : event instanceof PreferencesClickVendorDisagreeEvent ? true : event instanceof PreferencesClickVendorSaveChoicesEvent ? true : event instanceof PreferencesClickSPIPurposeAgreeEvent ? true : event instanceof PreferencesClickSPIPurposeDisagreeEvent ? true : event instanceof PreferencesClickSPICategoryAgreeEvent ? true : event instanceof PreferencesClickSPICategoryDisagreeEvent ? true : event instanceof PreferencesClickSPIPurposeSaveChoicesEvent ? true : event instanceof SyncDoneEvent ? true : event instanceof SyncErrorEvent ? true : event instanceof LanguageUpdatedEvent ? true : event instanceof LanguageUpdateFailedEvent);
    }

    public boolean a(DidomiEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return a().add(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(b6 this$0, Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "$event");
        for (DidomiEventListener didomiEventListener : this$0.a()) {
            if (event instanceof ConsentChangedEvent) {
                didomiEventListener.consentChanged((ConsentChangedEvent) event);
            } else if (event instanceof ErrorEvent) {
                didomiEventListener.error((ErrorEvent) event);
            } else if (event instanceof ReadyEvent) {
                didomiEventListener.ready((ReadyEvent) event);
            } else if (event instanceof HideNoticeEvent) {
                didomiEventListener.hideNotice((HideNoticeEvent) event);
            } else if (event instanceof ShowNoticeEvent) {
                didomiEventListener.showNotice((ShowNoticeEvent) event);
            } else if (event instanceof NoticeClickAgreeEvent) {
                didomiEventListener.noticeClickAgree((NoticeClickAgreeEvent) event);
            } else if (event instanceof NoticeClickDisagreeEvent) {
                didomiEventListener.noticeClickDisagree((NoticeClickDisagreeEvent) event);
            } else if (event instanceof NoticeClickMoreInfoEvent) {
                didomiEventListener.noticeClickMoreInfo((NoticeClickMoreInfoEvent) event);
            } else if (event instanceof NoticeClickPrivacyPolicyEvent) {
                didomiEventListener.noticeClickPrivacyPolicy((NoticeClickPrivacyPolicyEvent) event);
            } else if (event instanceof NoticeClickViewVendorsEvent) {
                didomiEventListener.noticeClickViewVendors((NoticeClickViewVendorsEvent) event);
            } else if (event instanceof NoticeClickViewSPIPurposesEvent) {
                didomiEventListener.noticeClickViewSPIPurposes((NoticeClickViewSPIPurposesEvent) event);
            } else if (event instanceof HidePreferencesEvent) {
                didomiEventListener.hidePreferences((HidePreferencesEvent) event);
            } else if (event instanceof ShowPreferencesEvent) {
                didomiEventListener.showPreferences((ShowPreferencesEvent) event);
            } else if (event instanceof PreferencesClickViewPurposesEvent) {
                didomiEventListener.preferencesClickViewPurposes((PreferencesClickViewPurposesEvent) event);
            } else if (event instanceof PreferencesClickViewVendorsEvent) {
                didomiEventListener.preferencesClickViewVendors((PreferencesClickViewVendorsEvent) event);
            } else if (event instanceof PreferencesClickViewSPIPurposesEvent) {
                didomiEventListener.preferencesClickViewSPIPurposes((PreferencesClickViewSPIPurposesEvent) event);
            } else if (event instanceof PreferencesClickAgreeToAllEvent) {
                didomiEventListener.preferencesClickAgreeToAll((PreferencesClickAgreeToAllEvent) event);
            } else if (event instanceof PreferencesClickDisagreeToAllEvent) {
                didomiEventListener.preferencesClickDisagreeToAll((PreferencesClickDisagreeToAllEvent) event);
            } else if (event instanceof PreferencesClickAgreeToAllPurposesEvent) {
                didomiEventListener.preferencesClickAgreeToAllPurposes((PreferencesClickAgreeToAllPurposesEvent) event);
            } else if (event instanceof PreferencesClickDisagreeToAllPurposesEvent) {
                didomiEventListener.preferencesClickDisagreeToAllPurposes((PreferencesClickDisagreeToAllPurposesEvent) event);
            } else if (event instanceof PreferencesClickResetAllPurposesEvent) {
                didomiEventListener.preferencesClickResetAllPurposes((PreferencesClickResetAllPurposesEvent) event);
            } else if (event instanceof PreferencesClickPurposeAgreeEvent) {
                didomiEventListener.preferencesClickPurposeAgree((PreferencesClickPurposeAgreeEvent) event);
            } else if (event instanceof PreferencesClickPurposeDisagreeEvent) {
                didomiEventListener.preferencesClickPurposeDisagree((PreferencesClickPurposeDisagreeEvent) event);
            } else if (event instanceof PreferencesClickCategoryAgreeEvent) {
                didomiEventListener.preferencesClickCategoryAgree((PreferencesClickCategoryAgreeEvent) event);
            } else if (event instanceof PreferencesClickCategoryDisagreeEvent) {
                didomiEventListener.preferencesClickCategoryDisagree((PreferencesClickCategoryDisagreeEvent) event);
            } else if (event instanceof PreferencesClickSaveChoicesEvent) {
                didomiEventListener.preferencesClickSaveChoices((PreferencesClickSaveChoicesEvent) event);
            } else if (event instanceof PreferencesClickAgreeToAllVendorsEvent) {
                didomiEventListener.preferencesClickAgreeToAllVendors((PreferencesClickAgreeToAllVendorsEvent) event);
            } else if (event instanceof PreferencesClickDisagreeToAllVendorsEvent) {
                didomiEventListener.preferencesClickDisagreeToAllVendors((PreferencesClickDisagreeToAllVendorsEvent) event);
            } else if (event instanceof PreferencesClickVendorAgreeEvent) {
                didomiEventListener.preferencesClickVendorAgree((PreferencesClickVendorAgreeEvent) event);
            } else if (event instanceof PreferencesClickVendorDisagreeEvent) {
                didomiEventListener.preferencesClickVendorDisagree((PreferencesClickVendorDisagreeEvent) event);
            } else if (event instanceof PreferencesClickVendorSaveChoicesEvent) {
                didomiEventListener.preferencesClickVendorSaveChoices((PreferencesClickVendorSaveChoicesEvent) event);
            } else if (event instanceof PreferencesClickSPIPurposeAgreeEvent) {
                didomiEventListener.preferencesClickSPIPurposeAgree((PreferencesClickSPIPurposeAgreeEvent) event);
            } else if (event instanceof PreferencesClickSPIPurposeDisagreeEvent) {
                didomiEventListener.preferencesClickSPIPurposeDisagree((PreferencesClickSPIPurposeDisagreeEvent) event);
            } else if (event instanceof PreferencesClickSPICategoryAgreeEvent) {
                didomiEventListener.preferencesClickSPICategoryAgree((PreferencesClickSPICategoryAgreeEvent) event);
            } else if (event instanceof PreferencesClickSPICategoryDisagreeEvent) {
                didomiEventListener.preferencesClickSPICategoryDisagree((PreferencesClickSPICategoryDisagreeEvent) event);
            } else if (event instanceof PreferencesClickSPIPurposeSaveChoicesEvent) {
                didomiEventListener.preferencesClickSPIPurposeSaveChoices((PreferencesClickSPIPurposeSaveChoicesEvent) event);
            } else if (event instanceof SyncDoneEvent) {
                didomiEventListener.syncDone((SyncDoneEvent) event);
            } else if (event instanceof SyncErrorEvent) {
                didomiEventListener.syncError((SyncErrorEvent) event);
            } else if (event instanceof LanguageUpdatedEvent) {
                didomiEventListener.languageUpdated((LanguageUpdatedEvent) event);
            } else if (event instanceof LanguageUpdateFailedEvent) {
                didomiEventListener.languageUpdateFailed((LanguageUpdateFailedEvent) event);
            }
            if (this$0.a(event) && (didomiEventListener instanceof InitializationEventListener)) {
                this$0.b(didomiEventListener);
            }
        }
    }

    public /* synthetic */ b6(Handler handler, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }

    protected boolean a(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return (event instanceof ReadyEvent) || (event instanceof ErrorEvent);
    }
}
