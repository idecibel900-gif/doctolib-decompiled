package io.invertase.firebase.common;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes5.dex */
public class UniversalFirebaseModule {
    private final Context context;
    private final TaskExecutorService executorService = new TaskExecutorService(getName());
    private final String serviceName;

    public UniversalFirebaseModule(Context context, String str) {
        this.context = context;
        this.serviceName = str;
    }

    public Context getContext() {
        return this.context;
    }

    public Context getApplicationContext() {
        return getContext().getApplicationContext();
    }

    public ExecutorService getExecutor() {
        return this.executorService.getExecutor();
    }

    public String getName() {
        return "Universal" + this.serviceName + "Module";
    }

    public void onTearDown() {
        this.executorService.shutdown();
    }

    public Map<String, Object> getConstants() {
        return new HashMap();
    }
}
