package com.lyft.kronos.internal.ntp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes4.dex */
public interface DatagramFactory {
    DatagramPacket createPacket(byte[] bArr);

    DatagramPacket createPacket(byte[] bArr, InetAddress inetAddress, int i);

    DatagramSocket createSocket();
}
