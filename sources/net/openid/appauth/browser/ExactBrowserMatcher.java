package net.openid.appauth.browser;

/* JADX INFO: loaded from: classes5.dex */
public class ExactBrowserMatcher implements BrowserMatcher {
    private BrowserDescriptor mBrowser;

    public ExactBrowserMatcher(BrowserDescriptor browserDescriptor) {
        this.mBrowser = browserDescriptor;
    }

    @Override // net.openid.appauth.browser.BrowserMatcher
    public boolean matches(BrowserDescriptor browserDescriptor) {
        return this.mBrowser.equals(browserDescriptor);
    }
}
