package io.didomi.ssl;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\t\u0010\bJ\n\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\rH\u0016J.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\rH\u0016R\u001b\u0010\u0018\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0004\u0010\u0017¨\u0006\u001b"}, d2 = {"Lio/didomi/sdk/qc;", "Ljavax/net/ssl/SSLSocketFactory;", "Ljava/net/Socket;", "socket", "a", "", "", "getDefaultCipherSuites", "()[Ljava/lang/String;", "getSupportedCipherSuites", "createSocket", "s", DiagnosticsTracker.HOST_KEY, "", "port", "", "autoClose", "Ljava/net/InetAddress;", "localHost", "localPort", AuthorizationRequest.Scope.ADDRESS, "localAddress", "Lkotlin/Lazy;", "()Ljavax/net/ssl/SSLSocketFactory;", "internalSSLSocketFactory", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class qc extends javax.net.ssl.SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Lazy internalSSLSocketFactory = LazyKt.lazy(SSLSocketFactory.a);

    /* JADX INFO: renamed from: io.didomi.sdk.qc$a, reason: from Kotlin metadata */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ljavax/net/ssl/SSLSocketFactory;", "kotlin.jvm.PlatformType", "a", "()Ljavax/net/ssl/SSLSocketFactory;"}, k = 3, mv = {1, 8, 0})
    static final class SSLSocketFactory extends Lambda implements Function0 {
        public static final SSLSocketFactory a = new SSLSocketFactory();

        SSLSocketFactory() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final javax.net.ssl.SSLSocketFactory invoke() throws NoSuchAlgorithmException, KeyManagementException {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            return sSLContext.getSocketFactory();
        }
    }

    private final javax.net.ssl.SSLSocketFactory a() {
        Object value = this.internalSSLSocketFactory.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-internalSSLSocketFactory>(...)");
        return (javax.net.ssl.SSLSocketFactory) value;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return a(a().createSocket());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        String[] defaultCipherSuites = a().getDefaultCipherSuites();
        Intrinsics.checkNotNullExpressionValue(defaultCipherSuites, "internalSSLSocketFactory.defaultCipherSuites");
        return defaultCipherSuites;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] supportedCipherSuites = a().getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, "internalSSLSocketFactory.supportedCipherSuites");
        return supportedCipherSuites;
    }

    private final Socket a(Socket socket) {
        SSLSocket sSLSocket = socket instanceof SSLSocket ? (SSLSocket) socket : null;
        if (sSLSocket == null) {
            return socket;
        }
        sSLSocket.setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        return a(a().createSocket(s, host, port, autoClose));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String host, int port) throws IOException {
        return a(a().createSocket(host, port));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
        return a(a().createSocket(host, port, localHost, localPort));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress host, int port) throws IOException {
        return a(a().createSocket(host, port));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        return a(a().createSocket(address, port, localAddress, localPort));
    }
}
