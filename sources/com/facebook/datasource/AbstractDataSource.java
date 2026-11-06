package com.facebook.datasource;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractDataSource implements DataSource {
    private Map mExtras;
    private Object mResult = null;
    private Throwable mFailureThrowable = null;
    private float mProgress = 0.0f;
    private boolean mIsClosed = false;
    private DataSourceStatus mDataSourceStatus = DataSourceStatus.IN_PROGRESS;
    private final ConcurrentLinkedQueue mSubscribers = new ConcurrentLinkedQueue();

    public interface DataSourceInstrumenter {
    }

    private enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    public static DataSourceInstrumenter getDataSourceInstrumenter() {
        return null;
    }

    protected void closeResult(Object obj) {
    }

    @Override // com.facebook.datasource.DataSource
    public boolean hasMultipleResults() {
        return false;
    }

    protected AbstractDataSource() {
    }

    public synchronized boolean isClosed() {
        return this.mIsClosed;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean isFinished() {
        return this.mDataSourceStatus != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized boolean hasResult() {
        return this.mResult != null;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized Object getResult() {
        return this.mResult;
    }

    @Override // com.facebook.datasource.DataSource
    public Map getExtras() {
        return this.mExtras;
    }

    protected void setExtras(Map map) {
        this.mExtras = map;
    }

    public synchronized boolean hasFailed() {
        return this.mDataSourceStatus == DataSourceStatus.FAILURE;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized Throwable getFailureCause() {
        return this.mFailureThrowable;
    }

    @Override // com.facebook.datasource.DataSource
    public synchronized float getProgress() {
        return this.mProgress;
    }

    @Override // com.facebook.datasource.DataSource
    public boolean close() {
        synchronized (this) {
            try {
                if (this.mIsClosed) {
                    return false;
                }
                this.mIsClosed = true;
                Object obj = this.mResult;
                this.mResult = null;
                if (obj != null) {
                    closeResult(obj);
                }
                if (!isFinished()) {
                    notifyDataSubscribers();
                }
                synchronized (this) {
                    this.mSubscribers.clear();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.facebook.datasource.DataSource
    public void subscribe(DataSubscriber dataSubscriber, Executor executor) {
        Preconditions.checkNotNull(dataSubscriber);
        Preconditions.checkNotNull(executor);
        synchronized (this) {
            try {
                if (this.mIsClosed) {
                    return;
                }
                if (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                    this.mSubscribers.add(Pair.create(dataSubscriber, executor));
                }
                boolean z = hasResult() || isFinished() || wasCancelled();
                if (z) {
                    notifyDataSubscriber(dataSubscriber, executor, hasFailed(), wasCancelled());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void notifyDataSubscribers() {
        boolean zHasFailed = hasFailed();
        boolean zWasCancelled = wasCancelled();
        for (Pair pair : this.mSubscribers) {
            notifyDataSubscriber((DataSubscriber) pair.first, (Executor) pair.second, zHasFailed, zWasCancelled);
        }
    }

    protected void notifyDataSubscriber(final DataSubscriber dataSubscriber, Executor executor, final boolean z, final boolean z2) {
        Runnable runnable = new Runnable() { // from class: com.facebook.datasource.AbstractDataSource.1
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    dataSubscriber.onFailure(AbstractDataSource.this);
                } else if (z2) {
                    dataSubscriber.onCancellation(AbstractDataSource.this);
                } else {
                    dataSubscriber.onNewResult(AbstractDataSource.this);
                }
            }
        };
        getDataSourceInstrumenter();
        executor.execute(runnable);
    }

    private synchronized boolean wasCancelled() {
        return isClosed() && !isFinished();
    }

    protected boolean setResult(Object obj, boolean z, Map map) {
        setExtras(map);
        boolean resultInternal = setResultInternal(obj, z);
        if (resultInternal) {
            notifyDataSubscribers();
        }
        return resultInternal;
    }

    protected boolean setFailure(Throwable th) {
        return setFailure(th, null);
    }

    protected boolean setFailure(Throwable th, Map map) {
        boolean failureInternal = setFailureInternal(th, map);
        if (failureInternal) {
            notifyDataSubscribers();
        }
        return failureInternal;
    }

    protected boolean setProgress(float f) {
        boolean progressInternal = setProgressInternal(f);
        if (progressInternal) {
            notifyProgressUpdate();
        }
        return progressInternal;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0019 -> B:32:0x003a). Please report as a decompilation issue!!! */
    private boolean setResultInternal(Object obj, boolean z) {
        Object obj2;
        Object obj3 = null;
        try {
            synchronized (this) {
                try {
                    try {
                        if (!this.mIsClosed && this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                            if (z) {
                                this.mDataSourceStatus = DataSourceStatus.SUCCESS;
                                this.mProgress = 1.0f;
                            }
                            Object obj4 = this.mResult;
                            if (obj4 != obj) {
                                try {
                                    this.mResult = obj;
                                    obj2 = obj4;
                                } catch (Throwable th) {
                                    th = th;
                                    obj3 = obj4;
                                    throw th;
                                }
                            } else {
                                obj2 = null;
                            }
                            if (obj2 != null) {
                                closeResult(obj2);
                            }
                            return true;
                        }
                        if (obj != null) {
                            closeResult(obj);
                        }
                        return false;
                    } catch (Throwable th2) {
                        obj3 = obj;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable th4) {
            if (obj3 != null) {
                closeResult(obj3);
            }
            throw th4;
        }
    }

    private synchronized boolean setFailureInternal(Throwable th, Map map) {
        if (!this.mIsClosed && this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
            this.mDataSourceStatus = DataSourceStatus.FAILURE;
            this.mFailureThrowable = th;
            this.mExtras = map;
            return true;
        }
        return false;
    }

    private synchronized boolean setProgressInternal(float f) {
        if (!this.mIsClosed && this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
            if (f < this.mProgress) {
                return false;
            }
            this.mProgress = f;
            return true;
        }
        return false;
    }

    protected void notifyProgressUpdate() {
        for (Pair pair : this.mSubscribers) {
            final DataSubscriber dataSubscriber = (DataSubscriber) pair.first;
            ((Executor) pair.second).execute(new Runnable() { // from class: com.facebook.datasource.AbstractDataSource.2
                @Override // java.lang.Runnable
                public void run() {
                    dataSubscriber.onProgressUpdate(AbstractDataSource.this);
                }
            });
        }
    }
}
