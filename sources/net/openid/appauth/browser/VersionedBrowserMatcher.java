package net.openid.appauth.browser;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class VersionedBrowserMatcher implements BrowserMatcher {
    public static final VersionedBrowserMatcher CHROME_BROWSER;
    public static final VersionedBrowserMatcher CHROME_CUSTOM_TAB;
    public static final VersionedBrowserMatcher FIREFOX_BROWSER;
    public static final VersionedBrowserMatcher FIREFOX_CUSTOM_TAB;
    public static final VersionedBrowserMatcher SAMSUNG_BROWSER;
    public static final VersionedBrowserMatcher SAMSUNG_CUSTOM_TAB;
    private String mPackageName;
    private Set<String> mSignatureHashes;
    private boolean mUsingCustomTab;
    private VersionRange mVersionRange;

    static {
        Set<String> set = Browsers.Chrome.SIGNATURE_SET;
        CHROME_CUSTOM_TAB = new VersionedBrowserMatcher(Browsers.Chrome.PACKAGE_NAME, set, true, VersionRange.atLeast(Browsers.Chrome.MINIMUM_VERSION_FOR_CUSTOM_TAB));
        VersionRange versionRange = VersionRange.ANY_VERSION;
        CHROME_BROWSER = new VersionedBrowserMatcher(Browsers.Chrome.PACKAGE_NAME, set, false, versionRange);
        Set<String> set2 = Browsers.Firefox.SIGNATURE_SET;
        FIREFOX_CUSTOM_TAB = new VersionedBrowserMatcher(Browsers.Firefox.PACKAGE_NAME, set2, true, VersionRange.atLeast(Browsers.Firefox.MINIMUM_VERSION_FOR_CUSTOM_TAB));
        FIREFOX_BROWSER = new VersionedBrowserMatcher(Browsers.Firefox.PACKAGE_NAME, set2, false, versionRange);
        Set<String> set3 = Browsers.SBrowser.SIGNATURE_SET;
        SAMSUNG_BROWSER = new VersionedBrowserMatcher(Browsers.SBrowser.PACKAGE_NAME, set3, false, versionRange);
        SAMSUNG_CUSTOM_TAB = new VersionedBrowserMatcher(Browsers.SBrowser.PACKAGE_NAME, set3, true, VersionRange.atLeast(Browsers.SBrowser.MINIMUM_VERSION_FOR_CUSTOM_TAB));
    }

    public VersionedBrowserMatcher(String str, String str2, boolean z, VersionRange versionRange) {
        this(str, (Set<String>) Collections.singleton(str2), z, versionRange);
    }

    public VersionedBrowserMatcher(String str, Set<String> set, boolean z, VersionRange versionRange) {
        this.mPackageName = str;
        this.mSignatureHashes = set;
        this.mUsingCustomTab = z;
        this.mVersionRange = versionRange;
    }

    @Override // net.openid.appauth.browser.BrowserMatcher
    public boolean matches(BrowserDescriptor browserDescriptor) {
        return this.mPackageName.equals(browserDescriptor.packageName) && this.mUsingCustomTab == browserDescriptor.useCustomTab.booleanValue() && this.mVersionRange.matches(browserDescriptor.version) && this.mSignatureHashes.equals(browserDescriptor.signatureHashes);
    }
}
