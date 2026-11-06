package com.facebook.datasource;

import com.facebook.common.internal.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleDataSource extends AbstractDataSource {
    private SimpleDataSource() {
    }

    public static SimpleDataSource create() {
        return new SimpleDataSource();
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean setFailure(Throwable th) {
        return super.setFailure((Throwable) Preconditions.checkNotNull(th));
    }
}
