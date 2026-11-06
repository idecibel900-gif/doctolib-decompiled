package com.adjust.sdk.scheduler;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AsyncTaskExecutor<Params, Result> {
    public abstract Result doInBackground(Params[] paramsArr);

    @SafeVarargs
    public final AsyncTaskExecutor<Params, Result> execute(final Params... paramsArr) {
        onPreExecute();
        final Handler handler = new Handler(Looper.getMainLooper());
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.adjust.sdk.scheduler.AsyncTaskExecutor.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public final void run() {
                final Object objDoInBackground = AsyncTaskExecutor.this.doInBackground(paramsArr);
                handler.post(new Runnable() { // from class: com.adjust.sdk.scheduler.AsyncTaskExecutor.1.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public final void run() {
                        AsyncTaskExecutor.this.onPostExecute(objDoInBackground);
                    }
                });
            }
        });
        return this;
    }

    public void onPostExecute(Result result) {
    }

    public void onPreExecute() {
    }
}
