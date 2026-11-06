package expo.modules.updates.procedures;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.ReactHost;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.statemachine.UpdatesStateEvent;
import java.lang.ref.WeakReference;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes5.dex */
public final class RecreateReactContextProcedure extends StateMachineProcedure {
    private final Launcher.LauncherCallback callback;
    private final Context context;
    private final String loggerTimerLabel;
    private final CoroutineScope procedureScope;
    private final WeakReference weakActivity;

    public RecreateReactContextProcedure(Context context, WeakReference weakReference, Launcher.LauncherCallback callback, CoroutineScope procedureScope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(procedureScope, "procedureScope");
        this.context = context;
        this.weakActivity = weakReference;
        this.callback = callback;
        this.procedureScope = procedureScope;
        this.loggerTimerLabel = "timer-recreate-react-context";
    }

    @Override // expo.modules.updates.procedures.StateMachineProcedure
    public String getLoggerTimerLabel() {
        return this.loggerTimerLabel;
    }

    @Override // expo.modules.updates.procedures.StateMachineProcedure
    public Object run(StateMachineProcedure.ProcedureContext procedureContext, Continuation continuation) {
        ReactHost reactHostResolveReactHostForRestart = RestartReactAppExtensionsKt.resolveReactHostForRestart(this.context);
        if (reactHostResolveReactHostForRestart == null) {
            this.callback.onFailure(new Exception("Could not reload application. Ensure you have passed the correct instance of ReactApplication into UpdatesController.initialize()."));
            return Unit.INSTANCE;
        }
        procedureContext.processStateEvent(new UpdatesStateEvent.Restart());
        this.callback.onSuccess();
        BuildersKt__Builders_commonKt.launch$default(this.procedureScope, null, null, new AnonymousClass2(reactHostResolveReactHostForRestart, this, null), 3, null);
        procedureContext.resetStateAfterRestart();
        procedureContext.onComplete();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: expo.modules.updates.procedures.RecreateReactContextProcedure$run$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ ReactHost $reactHost;
        int label;
        final /* synthetic */ RecreateReactContextProcedure this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ReactHost reactHost, RecreateReactContextProcedure recreateReactContextProcedure, Continuation continuation) {
            super(2, continuation);
            this.$reactHost = reactHost;
            this.this$0 = recreateReactContextProcedure;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$reactHost, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: expo.modules.updates.procedures.RecreateReactContextProcedure$run$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2 {
            final /* synthetic */ ReactHost $reactHost;
            int label;
            final /* synthetic */ RecreateReactContextProcedure this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ReactHost reactHost, RecreateReactContextProcedure recreateReactContextProcedure, Continuation continuation) {
                super(2, continuation);
                this.$reactHost = reactHost;
                this.this$0 = recreateReactContextProcedure;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass1(this.$reactHost, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ReactHost reactHost = this.$reactHost;
                WeakReference weakReference = this.this$0.weakActivity;
                RestartReactAppExtensionsKt.restart(reactHost, weakReference != null ? (Activity) weakReference.get() : null, "Restart from RecreateReactContextProcedure");
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$reactHost, this.this$0, null);
                this.label = 1;
                if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
