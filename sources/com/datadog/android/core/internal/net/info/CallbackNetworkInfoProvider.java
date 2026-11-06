package com.datadog.android.core.internal.net.info;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.NetworkInfo;
import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.system.BuildSdkVersionProvider;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public final class CallbackNetworkInfoProvider extends ConnectivityManager.NetworkCallback implements NetworkInfoProvider {
    public static final Companion Companion = new Companion(null);
    private final BuildSdkVersionProvider buildSdkVersionProvider;
    private final DataWriter dataWriter;
    private final InternalLogger internalLogger;
    private NetworkInfo lastNetworkInfo;

    public /* synthetic */ CallbackNetworkInfoProvider(DataWriter dataWriter, BuildSdkVersionProvider buildSdkVersionProvider, InternalLogger internalLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dataWriter, (i & 2) != 0 ? BuildSdkVersionProvider.Companion.getDEFAULT() : buildSdkVersionProvider, internalLogger);
    }

    public CallbackNetworkInfoProvider(DataWriter dataWriter, BuildSdkVersionProvider buildSdkVersionProvider, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(dataWriter, "dataWriter");
        Intrinsics.checkNotNullParameter(buildSdkVersionProvider, "buildSdkVersionProvider");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.dataWriter = dataWriter;
        this.buildSdkVersionProvider = buildSdkVersionProvider;
        this.internalLogger = internalLogger;
        this.lastNetworkInfo = new NetworkInfo(null, null, null, null, null, null, null, 127, null);
    }

    private final void setLastNetworkInfo(NetworkInfo networkInfo) {
        this.lastNetworkInfo = networkInfo;
        this.dataWriter.write(networkInfo);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        super.onCapabilitiesChanged(network, networkCapabilities);
        setLastNetworkInfo(new NetworkInfo(getNetworkType(networkCapabilities), null, null, resolveUpBandwidth(networkCapabilities), resolveDownBandwidth(networkCapabilities), resolveStrength(networkCapabilities), null, 70, null));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onLost(network);
        setLastNetworkInfo(new NetworkInfo(NetworkInfo.Connectivity.NETWORK_NOT_CONNECTED, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null));
    }

    @Override // com.datadog.android.core.internal.net.info.NetworkInfoProvider
    public void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.net.info.CallbackNetworkInfoProvider.register.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "We couldn't register a Network Callback, the network information reported will be less accurate.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        try {
            connectivityManager.registerDefaultNetworkCallback(this);
            Network activeNetwork = connectivityManager.getActiveNetwork();
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (activeNetwork == null || networkCapabilities == null) {
                return;
            }
            onCapabilitiesChanged(activeNetwork, networkCapabilities);
        } catch (SecurityException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.net.info.CallbackNetworkInfoProvider.register.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "We couldn't register a Network Callback, the network information reported will be less accurate.";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            setLastNetworkInfo(new NetworkInfo(NetworkInfo.Connectivity.NETWORK_OTHER, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null));
        } catch (Exception e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.net.info.CallbackNetworkInfoProvider.register.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "We couldn't register a Network Callback, the network information reported will be less accurate.";
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            setLastNetworkInfo(new NetworkInfo(NetworkInfo.Connectivity.NETWORK_OTHER, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null));
        }
    }

    @Override // com.datadog.android.core.internal.net.info.NetworkInfoProvider
    public void unregister(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.net.info.CallbackNetworkInfoProvider.unregister.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "We couldn't unregister the Network Callback";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(this);
        } catch (SecurityException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.net.info.CallbackNetworkInfoProvider.unregister.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "We couldn't unregister the Network Callback";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
        } catch (RuntimeException e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.USER, (Function0) new Function0() { // from class: com.datadog.android.core.internal.net.info.CallbackNetworkInfoProvider.unregister.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "We couldn't unregister the Network Callback";
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
        }
    }

    @Override // com.datadog.android.core.internal.net.info.NetworkInfoProvider
    public NetworkInfo getLatestNetworkInfo() {
        return this.lastNetworkInfo;
    }

    private final Long resolveUpBandwidth(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities.getLinkUpstreamBandwidthKbps() > 0) {
            return Long.valueOf(networkCapabilities.getLinkUpstreamBandwidthKbps());
        }
        return null;
    }

    private final Long resolveDownBandwidth(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities.getLinkDownstreamBandwidthKbps() > 0) {
            return Long.valueOf(networkCapabilities.getLinkDownstreamBandwidthKbps());
        }
        return null;
    }

    private final Long resolveStrength(NetworkCapabilities networkCapabilities) {
        if (this.buildSdkVersionProvider.getVersion() < 29 || networkCapabilities.getSignalStrength() == Integer.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(networkCapabilities.getSignalStrength());
    }

    private final NetworkInfo.Connectivity getNetworkType(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities.hasTransport(1)) {
            return NetworkInfo.Connectivity.NETWORK_WIFI;
        }
        if (networkCapabilities.hasTransport(3)) {
            return NetworkInfo.Connectivity.NETWORK_ETHERNET;
        }
        if (networkCapabilities.hasTransport(0)) {
            return NetworkInfo.Connectivity.NETWORK_CELLULAR;
        }
        if (networkCapabilities.hasTransport(2)) {
            return NetworkInfo.Connectivity.NETWORK_BLUETOOTH;
        }
        return NetworkInfo.Connectivity.NETWORK_OTHER;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
