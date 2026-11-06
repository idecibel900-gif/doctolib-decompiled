package expo.modules.kotlin.activityresult;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import expo.modules.kotlin.activityaware.AppCompatActivityAware;
import expo.modules.kotlin.activityaware.AppCompatActivityAwareHelper;
import expo.modules.kotlin.activityaware.OnActivityAvailableListener;
import expo.modules.kotlin.providers.CurrentActivityProvider;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityResultsManager implements AppContextActivityResultCaller, AppCompatActivityAware {
    private final AppCompatActivityAwareHelper activityAwareHelper;
    private final AtomicInteger nextLocalRequestCode;
    private final AppContextActivityResultRegistry registry;

    public ActivityResultsManager(CurrentActivityProvider currentActivityProvider) {
        Intrinsics.checkNotNullParameter(currentActivityProvider, "currentActivityProvider");
        this.registry = new AppContextActivityResultRegistry(currentActivityProvider);
        this.nextLocalRequestCode = new AtomicInteger();
        this.activityAwareHelper = new AppCompatActivityAwareHelper();
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.activityresult.ActivityResultsManager$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ActivityResultsManager.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [expo.modules.kotlin.activityaware.OnActivityAvailableListener, expo.modules.kotlin.activityresult.ActivityResultsManager$1$invokeSuspend$$inlined$withActivityAvailable$1] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ActivityResultsManager activityResultsManager = ActivityResultsManager.this;
                this.L$0 = activityResultsManager;
                this.L$1 = activityResultsManager;
                this.label = 1;
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                cancellableContinuationImpl.initCancellability();
                final ?? r2 = new OnActivityAvailableListener() { // from class: expo.modules.kotlin.activityresult.ActivityResultsManager$1$invokeSuspend$$inlined$withActivityAvailable$1
                    @Override // expo.modules.kotlin.activityaware.OnActivityAvailableListener
                    public void onActivityAvailable(AppCompatActivity activity) {
                        Object objM5243constructorimpl;
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        if (cancellableContinuationImpl.isActive()) {
                            activityResultsManager.removeOnActivityAvailableListener(this);
                            CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                            try {
                                Result.Companion companion = Result.Companion;
                                activityResultsManager.registry.restoreInstanceState(activity);
                                objM5243constructorimpl = Result.m5243constructorimpl(Unit.INSTANCE);
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
                            }
                            cancellableContinuation.resumeWith(objM5243constructorimpl);
                        }
                    }
                };
                activityResultsManager.addOnActivityAvailableListener(r2);
                cancellableContinuationImpl.invokeOnCancellation(new Function1() { // from class: expo.modules.kotlin.activityresult.ActivityResultsManager$1$invokeSuspend$$inlined$withActivityAvailable$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((Throwable) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Throwable th) {
                        activityResultsManager.removeOnActivityAvailableListener(r2);
                    }
                });
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (result == coroutine_suspended) {
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

    public final void onActivityResult(int i, int i2, Intent intent) {
        this.registry.dispatchResult(i, i2, intent);
    }

    public final void onHostResume(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityAwareHelper.dispatchOnActivityAvailable(activity);
    }

    public final void onHostDestroy(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.registry.persistInstanceState(activity);
    }

    @Override // expo.modules.kotlin.activityaware.AppCompatActivityAware
    public void addOnActivityAvailableListener(OnActivityAvailableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.activityAwareHelper.addOnActivityAvailableListener(listener);
    }

    @Override // expo.modules.kotlin.activityaware.AppCompatActivityAware
    public void removeOnActivityAvailableListener(OnActivityAvailableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.activityAwareHelper.removeOnActivityAvailableListener(listener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [expo.modules.kotlin.activityaware.OnActivityAvailableListener, expo.modules.kotlin.activityresult.ActivityResultsManager$registerForActivityResult$$inlined$withActivityAvailable$1] */
    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultCaller
    public Object registerForActivityResult(final AppContextActivityResultContract appContextActivityResultContract, final AppContextActivityResultFallbackCallback appContextActivityResultFallbackCallback, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final ?? r0 = new OnActivityAvailableListener() { // from class: expo.modules.kotlin.activityresult.ActivityResultsManager$registerForActivityResult$$inlined$withActivityAvailable$1
            @Override // expo.modules.kotlin.activityaware.OnActivityAvailableListener
            public void onActivityAvailable(AppCompatActivity activity) {
                Object objM5243constructorimpl;
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (cancellableContinuationImpl.isActive()) {
                    this.removeOnActivityAvailableListener(this);
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                    try {
                        Result.Companion companion = Result.Companion;
                        objM5243constructorimpl = Result.m5243constructorimpl(this.registry.register("AppContext_rq#" + this.nextLocalRequestCode.getAndIncrement(), activity, appContextActivityResultContract, appContextActivityResultFallbackCallback));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
                    }
                    cancellableContinuation.resumeWith(objM5243constructorimpl);
                }
            }
        };
        addOnActivityAvailableListener(r0);
        cancellableContinuationImpl.invokeOnCancellation(new Function1() { // from class: expo.modules.kotlin.activityresult.ActivityResultsManager$registerForActivityResult$$inlined$withActivityAvailable$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                this.removeOnActivityAvailableListener(r0);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
