package com.lyft.kronos.internal.ntp;

import java.net.InetAddress;

/* JADX INFO: loaded from: classes4.dex */
public interface DnsResolver {
    InetAddress resolve(String str);
}
