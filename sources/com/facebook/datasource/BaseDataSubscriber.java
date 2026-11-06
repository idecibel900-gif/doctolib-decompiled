package com.facebook.datasource;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDataSubscriber implements DataSubscriber {
    @Override // com.facebook.datasource.DataSubscriber
    public void onCancellation(DataSource dataSource) {
    }

    protected abstract void onFailureImpl(DataSource dataSource);

    protected abstract void onNewResultImpl(DataSource dataSource);

    @Override // com.facebook.datasource.DataSubscriber
    public void onProgressUpdate(DataSource dataSource) {
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onNewResult(DataSource dataSource) {
        boolean zIsFinished = dataSource.isFinished();
        try {
            onNewResultImpl(dataSource);
        } finally {
            if (zIsFinished) {
                dataSource.close();
            }
        }
    }

    @Override // com.facebook.datasource.DataSubscriber
    public void onFailure(DataSource dataSource) {
        try {
            onFailureImpl(dataSource);
        } finally {
            dataSource.close();
        }
    }
}
