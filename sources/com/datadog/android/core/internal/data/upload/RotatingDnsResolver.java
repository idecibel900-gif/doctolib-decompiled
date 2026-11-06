package com.datadog.android.core.internal.data.upload;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import okhttp3.Dns;

/* JADX INFO: loaded from: classes3.dex */
public final class RotatingDnsResolver implements Dns {
    public static final Companion Companion = new Companion(null);
    private static final long TTL_30_MIN;
    private final Dns delegate;
    private final Map knownHosts;
    private final long ttl;

    public /* synthetic */ RotatingDnsResolver(Dns dns, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(dns, j);
    }

    private RotatingDnsResolver(Dns delegate, long j) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.ttl = j;
        this.knownHosts = new LinkedHashMap();
    }

    public /* synthetic */ RotatingDnsResolver(Dns dns, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dns.SYSTEM : dns, (i & 2) != 0 ? TTL_30_MIN : j, null);
    }

    public static final class ResolvedHost {
        private final List addresses;
        private final String hostname;
        private final long resolutionTimestamp;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResolvedHost)) {
                return false;
            }
            ResolvedHost resolvedHost = (ResolvedHost) obj;
            return Intrinsics.areEqual(this.hostname, resolvedHost.hostname) && Intrinsics.areEqual(this.addresses, resolvedHost.addresses);
        }

        public int hashCode() {
            return (this.hostname.hashCode() * 31) + this.addresses.hashCode();
        }

        public String toString() {
            return "ResolvedHost(hostname=" + this.hostname + ", addresses=" + this.addresses + ")";
        }

        public ResolvedHost(String hostname, List addresses) {
            Intrinsics.checkNotNullParameter(hostname, "hostname");
            Intrinsics.checkNotNullParameter(addresses, "addresses");
            this.hostname = hostname;
            this.addresses = addresses;
            this.resolutionTimestamp = System.nanoTime();
        }

        public final List getAddresses() {
            return this.addresses;
        }

        /* JADX INFO: renamed from: getAge-UwyO8pc, reason: not valid java name */
        public final long m3147getAgeUwyO8pc() {
            Duration.Companion companion = Duration.Companion;
            return DurationKt.toDuration(System.nanoTime() - this.resolutionTimestamp, DurationUnit.NANOSECONDS);
        }

        public final void rotate() {
            synchronized (this.addresses) {
                try {
                    InetAddress inetAddress = (InetAddress) CollectionsKt.removeFirstOrNull(this.addresses);
                    if (inetAddress != null) {
                        this.addresses.add(inetAddress);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // okhttp3.Dns
    public List lookup(String hostname) throws UnknownHostException {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        ResolvedHost resolvedHost = (ResolvedHost) this.knownHosts.get(hostname);
        if (resolvedHost != null && isValid(resolvedHost)) {
            resolvedHost.rotate();
            return safeCopy(resolvedHost.getAddresses());
        }
        List<InetAddress> listLookup = this.delegate.lookup(hostname);
        this.knownHosts.put(hostname, new ResolvedHost(hostname, CollectionsKt.toMutableList((Collection) listLookup)));
        return safeCopy(listLookup);
    }

    private final List safeCopy(List list) {
        List list2;
        synchronized (list) {
            list2 = CollectionsKt.toList(list);
        }
        return list2;
    }

    private final boolean isValid(ResolvedHost resolvedHost) {
        return Duration.m5400compareToLRDsOJo(resolvedHost.m3147getAgeUwyO8pc(), this.ttl) < 0 && !resolvedHost.getAddresses().isEmpty();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Duration.Companion companion = Duration.Companion;
        TTL_30_MIN = DurationKt.toDuration(30, DurationUnit.MINUTES);
    }
}
