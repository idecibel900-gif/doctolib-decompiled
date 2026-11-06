package com.facebook.datasource;

/* JADX INFO: loaded from: classes3.dex */
public interface DataSubscriber {
    void onCancellation(DataSource dataSource);

    void onFailure(DataSource dataSource);

    void onNewResult(DataSource dataSource);

    void onProgressUpdate(DataSource dataSource);
}
