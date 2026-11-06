package net.openid.appauth;

import net.openid.appauth.browser.AnyBrowserMatcher;
import net.openid.appauth.browser.BrowserMatcher;
import net.openid.appauth.connectivity.ConnectionBuilder;
import net.openid.appauth.connectivity.DefaultConnectionBuilder;

/* JADX INFO: loaded from: classes5.dex */
public class AppAuthConfiguration {
    public static final AppAuthConfiguration DEFAULT = new Builder().build();
    private final BrowserMatcher mBrowserMatcher;
    private final ConnectionBuilder mConnectionBuilder;
    private final boolean mSkipIssuerHttpsCheck;

    private AppAuthConfiguration(BrowserMatcher browserMatcher, ConnectionBuilder connectionBuilder, Boolean bool) {
        this.mBrowserMatcher = browserMatcher;
        this.mConnectionBuilder = connectionBuilder;
        this.mSkipIssuerHttpsCheck = bool.booleanValue();
    }

    public BrowserMatcher getBrowserMatcher() {
        return this.mBrowserMatcher;
    }

    public ConnectionBuilder getConnectionBuilder() {
        return this.mConnectionBuilder;
    }

    public boolean getSkipIssuerHttpsCheck() {
        return this.mSkipIssuerHttpsCheck;
    }

    public static class Builder {
        private BrowserMatcher mBrowserMatcher = AnyBrowserMatcher.INSTANCE;
        private ConnectionBuilder mConnectionBuilder = DefaultConnectionBuilder.INSTANCE;
        private boolean mSkipIssuerHttpsCheck;
        private boolean mSkipNonceVerification;

        public Builder setBrowserMatcher(BrowserMatcher browserMatcher) {
            Preconditions.checkNotNull(browserMatcher, "browserMatcher cannot be null");
            this.mBrowserMatcher = browserMatcher;
            return this;
        }

        public Builder setConnectionBuilder(ConnectionBuilder connectionBuilder) {
            Preconditions.checkNotNull(connectionBuilder, "connectionBuilder cannot be null");
            this.mConnectionBuilder = connectionBuilder;
            return this;
        }

        public Builder setSkipIssuerHttpsCheck(Boolean bool) {
            this.mSkipIssuerHttpsCheck = bool.booleanValue();
            return this;
        }

        public AppAuthConfiguration build() {
            return new AppAuthConfiguration(this.mBrowserMatcher, this.mConnectionBuilder, Boolean.valueOf(this.mSkipIssuerHttpsCheck));
        }
    }
}
