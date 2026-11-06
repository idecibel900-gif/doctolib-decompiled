package com.revenuecat.purchases.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/utils/DefaultUrlConnection;", "Lcom/revenuecat/purchases/utils/UrlConnection;", "connection", "Ljava/net/HttpURLConnection;", "(Ljava/net/HttpURLConnection;)V", "inputStream", "Ljava/io/InputStream;", "getInputStream", "()Ljava/io/InputStream;", "responseCode", "", "getResponseCode", "()I", "disconnect", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultUrlConnection implements UrlConnection {
    private final HttpURLConnection connection;

    public DefaultUrlConnection(HttpURLConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.connection = connection;
    }

    @Override // com.revenuecat.purchases.utils.UrlConnection
    public int getResponseCode() {
        return this.connection.getResponseCode();
    }

    @Override // com.revenuecat.purchases.utils.UrlConnection
    public InputStream getInputStream() throws IOException {
        InputStream inputStream = this.connection.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "connection.inputStream");
        return inputStream;
    }

    @Override // com.revenuecat.purchases.utils.UrlConnection
    public void disconnect() {
        this.connection.disconnect();
    }
}
