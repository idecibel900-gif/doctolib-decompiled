package io.didomi.ssl.events;

import androidx.annotation.Keep;
import io.didomi.ssl.functionalinterfaces.DidomiEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0017J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0017J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fH\u0017J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000eH\u0017J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0010H\u0017J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0012H\u0017J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0014H\u0017J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0016H\u0017J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0018H\u0017J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001aH\u0017J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001cH\u0017J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001eH\u0017J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020 H\u0017J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\"H\u0017J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020$H\u0017J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020&H\u0017J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020(H\u0017J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020*H\u0017J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020,H\u0017J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020.H\u0017J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000200H\u0017J\u0010\u00101\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000202H\u0017J\u0010\u00103\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000204H\u0017J\u0010\u00105\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000206H\u0017J\u0010\u00107\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000208H\u0017J\u0010\u00109\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020:H\u0017J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020<H\u0017J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020>H\u0017J\u0010\u0010?\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020@H\u0017J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020BH\u0017J\u0010\u0010C\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020DH\u0017J\u0010\u0010E\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020FH\u0017J\u0010\u0010G\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020HH\u0017J\u0010\u0010I\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020JH\u0017J\u0010\u0010K\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020LH\u0017J\u0010\u0010M\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020NH\u0017J\u0010\u0010O\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020PH\u0017J\u0010\u0010Q\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020RH\u0017J\u0010\u0010S\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020TH\u0017¨\u0006U"}, d2 = {"Lio/didomi/sdk/events/EventListener;", "Lio/didomi/sdk/functionalinterfaces/DidomiEventListener;", "()V", "consentChanged", "", "event", "Lio/didomi/sdk/events/ConsentChangedEvent;", "error", "Lio/didomi/sdk/events/ErrorEvent;", "hideNotice", "Lio/didomi/sdk/events/HideNoticeEvent;", "hidePreferences", "Lio/didomi/sdk/events/HidePreferencesEvent;", "languageUpdateFailed", "Lio/didomi/sdk/events/LanguageUpdateFailedEvent;", "languageUpdated", "Lio/didomi/sdk/events/LanguageUpdatedEvent;", "noticeClickAgree", "Lio/didomi/sdk/events/NoticeClickAgreeEvent;", "noticeClickDisagree", "Lio/didomi/sdk/events/NoticeClickDisagreeEvent;", "noticeClickMoreInfo", "Lio/didomi/sdk/events/NoticeClickMoreInfoEvent;", "noticeClickPrivacyPolicy", "Lio/didomi/sdk/events/NoticeClickPrivacyPolicyEvent;", "noticeClickViewSPIPurposes", "Lio/didomi/sdk/events/NoticeClickViewSPIPurposesEvent;", "noticeClickViewVendors", "Lio/didomi/sdk/events/NoticeClickViewVendorsEvent;", "preferencesClickAgreeToAll", "Lio/didomi/sdk/events/PreferencesClickAgreeToAllEvent;", "preferencesClickAgreeToAllPurposes", "Lio/didomi/sdk/events/PreferencesClickAgreeToAllPurposesEvent;", "preferencesClickAgreeToAllVendors", "Lio/didomi/sdk/events/PreferencesClickAgreeToAllVendorsEvent;", "preferencesClickCategoryAgree", "Lio/didomi/sdk/events/PreferencesClickCategoryAgreeEvent;", "preferencesClickCategoryDisagree", "Lio/didomi/sdk/events/PreferencesClickCategoryDisagreeEvent;", "preferencesClickDisagreeToAll", "Lio/didomi/sdk/events/PreferencesClickDisagreeToAllEvent;", "preferencesClickDisagreeToAllPurposes", "Lio/didomi/sdk/events/PreferencesClickDisagreeToAllPurposesEvent;", "preferencesClickDisagreeToAllVendors", "Lio/didomi/sdk/events/PreferencesClickDisagreeToAllVendorsEvent;", "preferencesClickPurposeAgree", "Lio/didomi/sdk/events/PreferencesClickPurposeAgreeEvent;", "preferencesClickPurposeDisagree", "Lio/didomi/sdk/events/PreferencesClickPurposeDisagreeEvent;", "preferencesClickResetAllPurposes", "Lio/didomi/sdk/events/PreferencesClickResetAllPurposesEvent;", "preferencesClickSPICategoryAgree", "Lio/didomi/sdk/events/PreferencesClickSPICategoryAgreeEvent;", "preferencesClickSPICategoryDisagree", "Lio/didomi/sdk/events/PreferencesClickSPICategoryDisagreeEvent;", "preferencesClickSPIPurposeAgree", "Lio/didomi/sdk/events/PreferencesClickSPIPurposeAgreeEvent;", "preferencesClickSPIPurposeDisagree", "Lio/didomi/sdk/events/PreferencesClickSPIPurposeDisagreeEvent;", "preferencesClickSPIPurposeSaveChoices", "Lio/didomi/sdk/events/PreferencesClickSPIPurposeSaveChoicesEvent;", "preferencesClickSaveChoices", "Lio/didomi/sdk/events/PreferencesClickSaveChoicesEvent;", "preferencesClickVendorAgree", "Lio/didomi/sdk/events/PreferencesClickVendorAgreeEvent;", "preferencesClickVendorDisagree", "Lio/didomi/sdk/events/PreferencesClickVendorDisagreeEvent;", "preferencesClickVendorSaveChoices", "Lio/didomi/sdk/events/PreferencesClickVendorSaveChoicesEvent;", "preferencesClickViewPurposes", "Lio/didomi/sdk/events/PreferencesClickViewPurposesEvent;", "preferencesClickViewSPIPurposes", "Lio/didomi/sdk/events/PreferencesClickViewSPIPurposesEvent;", "preferencesClickViewVendors", "Lio/didomi/sdk/events/PreferencesClickViewVendorsEvent;", "ready", "Lio/didomi/sdk/events/ReadyEvent;", "showNotice", "Lio/didomi/sdk/events/ShowNoticeEvent;", "showPreferences", "Lio/didomi/sdk/events/ShowPreferencesEvent;", "syncDone", "Lio/didomi/sdk/events/SyncDoneEvent;", "syncError", "Lio/didomi/sdk/events/SyncErrorEvent;", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class EventListener implements DidomiEventListener {
    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void consentChanged(ConsentChangedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void error(ErrorEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void hideNotice(HideNoticeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void hidePreferences(HidePreferencesEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void languageUpdateFailed(LanguageUpdateFailedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void languageUpdated(LanguageUpdatedEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void noticeClickAgree(NoticeClickAgreeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void noticeClickDisagree(NoticeClickDisagreeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void noticeClickMoreInfo(NoticeClickMoreInfoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void noticeClickPrivacyPolicy(NoticeClickPrivacyPolicyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void noticeClickViewSPIPurposes(NoticeClickViewSPIPurposesEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void noticeClickViewVendors(NoticeClickViewVendorsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickAgreeToAll(PreferencesClickAgreeToAllEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickAgreeToAllPurposes(PreferencesClickAgreeToAllPurposesEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickAgreeToAllVendors(PreferencesClickAgreeToAllVendorsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickCategoryAgree(PreferencesClickCategoryAgreeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickCategoryDisagree(PreferencesClickCategoryDisagreeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickDisagreeToAll(PreferencesClickDisagreeToAllEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickDisagreeToAllPurposes(PreferencesClickDisagreeToAllPurposesEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickDisagreeToAllVendors(PreferencesClickDisagreeToAllVendorsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickPurposeAgree(PreferencesClickPurposeAgreeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickPurposeDisagree(PreferencesClickPurposeDisagreeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickResetAllPurposes(PreferencesClickResetAllPurposesEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickSPICategoryAgree(PreferencesClickSPICategoryAgreeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickSPICategoryDisagree(PreferencesClickSPICategoryDisagreeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickSPIPurposeAgree(PreferencesClickSPIPurposeAgreeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickSPIPurposeDisagree(PreferencesClickSPIPurposeDisagreeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickSPIPurposeSaveChoices(PreferencesClickSPIPurposeSaveChoicesEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickSaveChoices(PreferencesClickSaveChoicesEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickVendorAgree(PreferencesClickVendorAgreeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickVendorDisagree(PreferencesClickVendorDisagreeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickVendorSaveChoices(PreferencesClickVendorSaveChoicesEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickViewPurposes(PreferencesClickViewPurposesEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickViewSPIPurposes(PreferencesClickViewSPIPurposesEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void preferencesClickViewVendors(PreferencesClickViewVendorsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void ready(ReadyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void showNotice(ShowNoticeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void showPreferences(ShowPreferencesEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void syncDone(SyncDoneEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // io.didomi.ssl.functionalinterfaces.DidomiEventListener
    public void syncError(SyncErrorEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }
}
