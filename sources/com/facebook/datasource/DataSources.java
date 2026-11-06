package com.facebook.datasource;

import com.facebook.common.internal.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DataSources {
    public static DataSource immediateFailedDataSource(Throwable th) {
        SimpleDataSource simpleDataSourceCreate = SimpleDataSource.create();
        simpleDataSourceCreate.setFailure(th);
        return simpleDataSourceCreate;
    }

    public static Supplier getFailedDataSourceSupplier(final Throwable th) {
        return new Supplier() { // from class: com.facebook.datasource.DataSources.1
            @Override // com.facebook.common.internal.Supplier
            public DataSource get() {
                return DataSources.immediateFailedDataSource(th);
            }
        };
    }
}
