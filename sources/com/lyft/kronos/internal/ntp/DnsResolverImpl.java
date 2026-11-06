package com.lyft.kronos.internal.ntp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class DnsResolverImpl implements DnsResolver {
    @Override // com.lyft.kronos.internal.ntp.DnsResolver
    public InetAddress resolve(String host) throws UnknownHostException {
        Intrinsics.checkNotNullParameter(host, "host");
        InetAddress byName = InetAddress.getByName(host);
        Intrinsics.checkNotNullExpressionValue(byName, "InetAddress.getByName(host)");
        return byName;
    }
}
