package io.sentry;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryFeedbackOptions {
    private CharSequence cancelButtonLabel;
    private CharSequence emailLabel;
    private CharSequence emailPlaceholder;
    private CharSequence formTitle;
    private IFormHandler iFormHandler;
    private boolean isEmailRequired;
    private boolean isNameRequired;
    private CharSequence isRequiredLabel;
    private CharSequence messageLabel;
    private CharSequence messagePlaceholder;
    private CharSequence nameLabel;
    private CharSequence namePlaceholder;
    private Runnable onFormClose;
    private Runnable onFormOpen;
    private boolean showBranding;
    private boolean showEmail;
    private boolean showName;
    private CharSequence submitButtonLabel;
    private CharSequence successMessageText;
    private boolean useSentryUser;
    private boolean useShakeGesture;

    public interface IFormHandler {
    }

    public interface OptionsConfigurator {
        void configure(SentryFeedbackOptions sentryFeedbackOptions);
    }

    public interface SentryFeedbackCallback {
    }

    public SentryFeedbackCallback getOnSubmitError() {
        return null;
    }

    public SentryFeedbackCallback getOnSubmitSuccess() {
        return null;
    }

    SentryFeedbackOptions(IFormHandler iFormHandler) {
        this.isNameRequired = false;
        this.showName = true;
        this.isEmailRequired = false;
        this.showEmail = true;
        this.useSentryUser = true;
        this.showBranding = true;
        this.useShakeGesture = false;
        this.formTitle = "Report a Bug";
        this.submitButtonLabel = "Send Bug Report";
        this.cancelButtonLabel = "Cancel";
        this.nameLabel = "Name";
        this.namePlaceholder = "Your Name";
        this.emailLabel = "Email";
        this.emailPlaceholder = "your.email@example.org";
        this.isRequiredLabel = " (Required)";
        this.messageLabel = "Description";
        this.messagePlaceholder = "What's the bug? What did you expect?";
        this.successMessageText = "Thank you for your report!";
        this.iFormHandler = iFormHandler;
    }

    public SentryFeedbackOptions(SentryFeedbackOptions sentryFeedbackOptions) {
        this.isNameRequired = false;
        this.showName = true;
        this.isEmailRequired = false;
        this.showEmail = true;
        this.useSentryUser = true;
        this.showBranding = true;
        this.useShakeGesture = false;
        this.formTitle = "Report a Bug";
        this.submitButtonLabel = "Send Bug Report";
        this.cancelButtonLabel = "Cancel";
        this.nameLabel = "Name";
        this.namePlaceholder = "Your Name";
        this.emailLabel = "Email";
        this.emailPlaceholder = "your.email@example.org";
        this.isRequiredLabel = " (Required)";
        this.messageLabel = "Description";
        this.messagePlaceholder = "What's the bug? What did you expect?";
        this.successMessageText = "Thank you for your report!";
        this.isNameRequired = sentryFeedbackOptions.isNameRequired;
        this.showName = sentryFeedbackOptions.showName;
        this.isEmailRequired = sentryFeedbackOptions.isEmailRequired;
        this.showEmail = sentryFeedbackOptions.showEmail;
        this.useSentryUser = sentryFeedbackOptions.useSentryUser;
        this.showBranding = sentryFeedbackOptions.showBranding;
        this.useShakeGesture = sentryFeedbackOptions.useShakeGesture;
        this.formTitle = sentryFeedbackOptions.formTitle;
        this.submitButtonLabel = sentryFeedbackOptions.submitButtonLabel;
        this.cancelButtonLabel = sentryFeedbackOptions.cancelButtonLabel;
        this.nameLabel = sentryFeedbackOptions.nameLabel;
        this.namePlaceholder = sentryFeedbackOptions.namePlaceholder;
        this.emailLabel = sentryFeedbackOptions.emailLabel;
        this.emailPlaceholder = sentryFeedbackOptions.emailPlaceholder;
        this.isRequiredLabel = sentryFeedbackOptions.isRequiredLabel;
        this.messageLabel = sentryFeedbackOptions.messageLabel;
        this.messagePlaceholder = sentryFeedbackOptions.messagePlaceholder;
        this.successMessageText = sentryFeedbackOptions.successMessageText;
        this.onFormOpen = sentryFeedbackOptions.onFormOpen;
        this.onFormClose = sentryFeedbackOptions.onFormClose;
        this.iFormHandler = sentryFeedbackOptions.iFormHandler;
    }

    public boolean isNameRequired() {
        return this.isNameRequired;
    }

    public void setNameRequired(boolean z) {
        this.isNameRequired = z;
    }

    public boolean isShowName() {
        return this.showName;
    }

    public void setShowName(boolean z) {
        this.showName = z;
    }

    public boolean isEmailRequired() {
        return this.isEmailRequired;
    }

    public void setEmailRequired(boolean z) {
        this.isEmailRequired = z;
    }

    public boolean isShowEmail() {
        return this.showEmail;
    }

    public void setShowEmail(boolean z) {
        this.showEmail = z;
    }

    public boolean isUseSentryUser() {
        return this.useSentryUser;
    }

    public void setUseSentryUser(boolean z) {
        this.useSentryUser = z;
    }

    public boolean isShowBranding() {
        return this.showBranding;
    }

    public void setShowBranding(boolean z) {
        this.showBranding = z;
    }

    public boolean isUseShakeGesture() {
        return this.useShakeGesture;
    }

    public void setUseShakeGesture(boolean z) {
        this.useShakeGesture = z;
    }

    public CharSequence getFormTitle() {
        return this.formTitle;
    }

    public CharSequence getSubmitButtonLabel() {
        return this.submitButtonLabel;
    }

    public CharSequence getCancelButtonLabel() {
        return this.cancelButtonLabel;
    }

    public CharSequence getNameLabel() {
        return this.nameLabel;
    }

    public CharSequence getNamePlaceholder() {
        return this.namePlaceholder;
    }

    public CharSequence getEmailLabel() {
        return this.emailLabel;
    }

    public CharSequence getEmailPlaceholder() {
        return this.emailPlaceholder;
    }

    public CharSequence getIsRequiredLabel() {
        return this.isRequiredLabel;
    }

    public CharSequence getMessageLabel() {
        return this.messageLabel;
    }

    public CharSequence getMessagePlaceholder() {
        return this.messagePlaceholder;
    }

    public CharSequence getSuccessMessageText() {
        return this.successMessageText;
    }

    public Runnable getOnFormOpen() {
        return this.onFormOpen;
    }

    public Runnable getOnFormClose() {
        return this.onFormClose;
    }

    public void setOnFormClose(Runnable runnable) {
        this.onFormClose = runnable;
    }

    public void setFormHandler(IFormHandler iFormHandler) {
        this.iFormHandler = iFormHandler;
    }

    public String toString() {
        return "SentryFeedbackOptions{isNameRequired=" + this.isNameRequired + ", showName=" + this.showName + ", isEmailRequired=" + this.isEmailRequired + ", showEmail=" + this.showEmail + ", useSentryUser=" + this.useSentryUser + ", showBranding=" + this.showBranding + ", useShakeGesture=" + this.useShakeGesture + ", formTitle='" + ((Object) this.formTitle) + "', submitButtonLabel='" + ((Object) this.submitButtonLabel) + "', cancelButtonLabel='" + ((Object) this.cancelButtonLabel) + "', nameLabel='" + ((Object) this.nameLabel) + "', namePlaceholder='" + ((Object) this.namePlaceholder) + "', emailLabel='" + ((Object) this.emailLabel) + "', emailPlaceholder='" + ((Object) this.emailPlaceholder) + "', isRequiredLabel='" + ((Object) this.isRequiredLabel) + "', messageLabel='" + ((Object) this.messageLabel) + "', messagePlaceholder='" + ((Object) this.messagePlaceholder) + "'}";
    }
}
