package com.google.firebase.messaging;

import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
class RequestDeduplicator {
    private final Executor executor;
    private final Map<String, Task<String>> getTokenRequests = new ArrayMap();

    interface GetTokenRequest {
        Task<String> start();
    }

    RequestDeduplicator(Executor executor) {
        this.executor = executor;
    }

    synchronized Task<String> getOrStartGetTokenRequest(final String str, GetTokenRequest getTokenRequest) {
        Task<String> task = this.getTokenRequests.get(str);
        if (task != null) {
            return task;
        }
        Task<String> taskContinueWithTask = getTokenRequest.start().continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.messaging.RequestDeduplicator$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return RequestDeduplicator.$r8$lambda$7vbEhMqRR2Cih64GBiItUUcAhYE(this.f$0, str, task2);
            }
        });
        this.getTokenRequests.put(str, taskContinueWithTask);
        return taskContinueWithTask;
    }

    public static /* synthetic */ Task $r8$lambda$7vbEhMqRR2Cih64GBiItUUcAhYE(RequestDeduplicator requestDeduplicator, String str, Task task) {
        synchronized (requestDeduplicator) {
            requestDeduplicator.getTokenRequests.remove(str);
        }
        return task;
    }
}
