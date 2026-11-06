package com.lyft.kronos.internal.ntp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class DatagramFactoryImpl implements DatagramFactory {
    @Override // com.lyft.kronos.internal.ntp.DatagramFactory
    public DatagramSocket createSocket() {
        return new DatagramSocket();
    }

    @Override // com.lyft.kronos.internal.ntp.DatagramFactory
    public DatagramPacket createPacket(byte[] buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        return new DatagramPacket(buffer, buffer.length);
    }

    @Override // com.lyft.kronos.internal.ntp.DatagramFactory
    public DatagramPacket createPacket(byte[] buffer, InetAddress address, int i) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(address, "address");
        return new DatagramPacket(buffer, buffer.length, address, i);
    }
}
