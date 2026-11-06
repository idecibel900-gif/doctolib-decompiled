package net.openid.appauth.browser;

/* JADX INFO: loaded from: classes5.dex */
public final class AnyBrowserMatcher implements BrowserMatcher {
    public static final AnyBrowserMatcher INSTANCE = new AnyBrowserMatcher();

    @Override // net.openid.appauth.browser.BrowserMatcher
    public boolean matches(BrowserDescriptor browserDescriptor) {
        return true;
    }

    private AnyBrowserMatcher() {
    }
}
