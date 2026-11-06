package androidx.work.impl.utils;

import androidx.work.Configuration;
import androidx.work.Operation;
import androidx.work.OperationKt;
import androidx.work.Tracer;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PruneWorkRunnableKt {
    public static final Operation pruneWork(final WorkDatabase workDatabase, Configuration configuration, TaskExecutor executor) {
        Intrinsics.checkNotNullParameter(workDatabase, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Tracer tracer = configuration.getTracer();
        SerialExecutor serialTaskExecutor = executor.getSerialTaskExecutor();
        Intrinsics.checkNotNullExpressionValue(serialTaskExecutor, "getSerialTaskExecutor(...)");
        return OperationKt.launchOperation(tracer, "PruneWork", serialTaskExecutor, new Function0() { // from class: androidx.work.impl.utils.PruneWorkRunnableKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PruneWorkRunnableKt.pruneWork$lambda$0(workDatabase);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pruneWork$lambda$0(WorkDatabase workDatabase) {
        workDatabase.workSpecDao().pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();
        return Unit.INSTANCE;
    }
}
