package net.openid.appauth.browser;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class BrowserDenyList implements BrowserMatcher {
    private List<BrowserMatcher> mBrowserMatchers;

    public BrowserDenyList(BrowserMatcher... browserMatcherArr) {
        this.mBrowserMatchers = Arrays.asList(browserMatcherArr);
    }

    @Override // net.openid.appauth.browser.BrowserMatcher
    public boolean matches(BrowserDescriptor browserDescriptor) {
        Iterator<BrowserMatcher> it = this.mBrowserMatchers.iterator();
        while (it.hasNext()) {
            if (it.next().matches(browserDescriptor)) {
                return false;
            }
        }
        return true;
    }
}
