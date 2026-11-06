package io.didomi.ssl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u000b\b\u0017\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00078RX\u0092\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\u0005\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0006\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0013¨\u0006\u0019"}, d2 = {"Lio/didomi/sdk/g0;", "", "Lio/didomi/sdk/h0;", "listener", "", "a", "b", "Landroid/net/ConnectivityManager;", "Lkotlin/Lazy;", "()Landroid/net/ConnectivityManager;", "connectivityManager", "io/didomi/sdk/g0$c", "Lio/didomi/sdk/g0$c;", "networkReceiver", "", "c", "Ljava/util/Set;", "()Ljava/util/Set;", "listeners", "()Z", "isConnected", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class g0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Lazy connectivityManager;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final c networkReceiver;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Set<h0> listeners;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/net/ConnectivityManager;", "a", "()Landroid/net/ConnectivityManager;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0 {
        final /* synthetic */ Context a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context) {
            super(0);
            this.a = context;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConnectivityManager invoke() {
            return (ConnectivityManager) this.a.getSystemService("connectivity");
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"io/didomi/sdk/g0$b", "Landroid/net/ConnectivityManager$NetworkCallback;", "Landroid/net/Network;", "network", "Landroid/net/NetworkCapabilities;", "networkCapabilities", "", "onCapabilitiesChanged", "", "maxMsToLive", "onLosing", "onLost", "onUnavailable", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.checkNotNullParameter(network, "network");
            Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
            if (g0.this.c()) {
                Iterator it = CollectionsKt.toList(g0.this.b()).iterator();
                while (it.hasNext()) {
                    ((h0) it.next()).a();
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int maxMsToLive) {
            Intrinsics.checkNotNullParameter(network, "network");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, d2 = {"io/didomi/sdk/g0$c", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "android.net.conn.CONNECTIVITY_CHANGE") && g0.this.c()) {
                Iterator it = CollectionsKt.toList(g0.this.b()).iterator();
                while (it.hasNext()) {
                    ((h0) it.next()).a();
                }
            }
        }
    }

    public g0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.connectivityManager = LazyKt.lazy(new a(context));
        this.networkReceiver = new c();
        this.listeners = new LinkedHashSet();
        b bVar = new b();
        ConnectivityManager connectivityManagerA = a();
        if (connectivityManagerA != null) {
            connectivityManagerA.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(1).addTransportType(0).addTransportType(3).build(), bVar);
        }
    }

    private ConnectivityManager a() {
        return (ConnectivityManager) this.connectivityManager.getValue();
    }

    protected Set<h0> b() {
        return this.listeners;
    }

    public boolean a(h0 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return b().add(listener);
    }

    public boolean b(h0 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return b().remove(listener);
    }

    public boolean c() {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManagerA = a();
        if (connectivityManagerA != null && (networkCapabilities = connectivityManagerA.getNetworkCapabilities(connectivityManagerA.getActiveNetwork())) != null) {
            Intrinsics.checkNotNullExpressionValue(networkCapabilities, "connectivityManager.getN…work) ?: return@let false");
            if (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3)) {
                return true;
            }
        }
        return false;
    }
}
