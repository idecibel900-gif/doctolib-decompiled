package androidx.work;

import android.content.Context;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ListenableWorker {
    private Context mAppContext;
    private final AtomicInteger mStopReason = new AtomicInteger(-256);
    private boolean mUsed;
    private WorkerParameters mWorkerParams;

    public void onStopped() {
    }

    public abstract ListenableFuture startWork();

    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.mAppContext = context;
        this.mWorkerParams = workerParameters;
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public final UUID getId() {
        return this.mWorkerParams.getId();
    }

    public final Data getInputData() {
        return this.mWorkerParams.getInputData();
    }

    public ListenableFuture getForegroundInfoAsync() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.work.ListenableWorker$$ExternalSyntheticLambda0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return ListenableWorker.m2933$r8$lambda$NKEXWBreYpgEsaASRDGrP595lA(completer);
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$NKEXWBreYpgEsaASR-DGrP595lA, reason: not valid java name */
    public static /* synthetic */ Object m2933$r8$lambda$NKEXWBreYpgEsaASRDGrP595lA(CallbackToFutureAdapter.Completer completer) {
        completer.setException(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for`getForegroundInfoAsync()`"));
        return "default failing getForegroundInfoAsync";
    }

    public final boolean isStopped() {
        return this.mStopReason.get() != -256;
    }

    public final int getStopReason() {
        return this.mStopReason.get();
    }

    public final void stop(int i) {
        if (this.mStopReason.compareAndSet(-256, i)) {
            onStopped();
        }
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.getBackgroundExecutor();
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerParams.getWorkerFactory();
    }

    public static abstract class Result {
        public static Result success() {
            return new Success();
        }

        public static Result retry() {
            return new Retry();
        }

        public static Result failure() {
            return new Failure();
        }

        Result() {
        }

        public static final class Success extends Result {
            private final Data mOutputData;

            public Success() {
                this(Data.EMPTY);
            }

            public Success(Data data) {
                this.mOutputData = data;
            }

            public Data getOutputData() {
                return this.mOutputData;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Success.class != obj.getClass()) {
                    return false;
                }
                return this.mOutputData.equals(((Success) obj).mOutputData);
            }

            public int hashCode() {
                return (Success.class.getName().hashCode() * 31) + this.mOutputData.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.mOutputData + '}';
            }
        }

        public static final class Failure extends Result {
            private final Data mOutputData;

            public Failure() {
                this(Data.EMPTY);
            }

            public Failure(Data data) {
                this.mOutputData = data;
            }

            public Data getOutputData() {
                return this.mOutputData;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Failure.class != obj.getClass()) {
                    return false;
                }
                return this.mOutputData.equals(((Failure) obj).mOutputData);
            }

            public int hashCode() {
                return (Failure.class.getName().hashCode() * 31) + this.mOutputData.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.mOutputData + '}';
            }
        }

        public static final class Retry extends Result {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && Retry.class == obj.getClass();
            }

            public int hashCode() {
                return Retry.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }
    }
}
