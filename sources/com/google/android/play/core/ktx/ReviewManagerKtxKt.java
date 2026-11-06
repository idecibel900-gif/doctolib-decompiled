package com.google.android.play.core.ktx;

import android.app.Activity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a%\u0010\b\u001a\u00020\u0006*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a%\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u00142\u0006\u0010\u0015\u001a\u0002H\u0013H\u0000¢\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"runTask", "T", "task", "Lcom/google/android/gms/tasks/Task;", "onCanceled", "Lkotlin/Function0;", "", "(Lcom/google/android/gms/tasks/Task;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchReview", "Lcom/google/android/play/core/review/ReviewManager;", "activity", "Landroid/app/Activity;", "reviewInfo", "Lcom/google/android/play/core/review/ReviewInfo;", "(Lcom/google/android/play/core/review/ReviewManager;Landroid/app/Activity;Lcom/google/android/play/core/review/ReviewInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestReview", "(Lcom/google/android/play/core/review/ReviewManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryOffer", "", "E", "Lkotlinx/coroutines/channels/SendChannel;", "element", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)Z", "java.com.google.android.apps.play.store.sdk.playcore.ktx_playcore_review_ktx"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ReviewManagerKtxKt {

    /* JADX INFO: renamed from: com.google.android.play.core.ktx.ReviewManagerKtxKt$requestReview$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.android.play.core.ktx.ReviewManagerKtxKt", f = "ReviewManagerKtx.kt", l = {22}, m = "requestReview")
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return ReviewManagerKtxKt.requestReview(null, this);
        }
    }

    public static final Object launchReview(ReviewManager reviewManager, Activity activity, ReviewInfo reviewInfo, Continuation continuation) {
        Task<Void> taskLaunchReviewFlow = reviewManager.launchReviewFlow(activity, reviewInfo);
        Intrinsics.checkNotNullExpressionValue(taskLaunchReviewFlow, "launchReviewFlow(activity, reviewInfo)");
        Object objRunTask$default = runTask$default(taskLaunchReviewFlow, null, continuation, 2, null);
        return objRunTask$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunTask$default : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object requestReview(ReviewManager reviewManager, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objRunTask$default = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objRunTask$default);
            Task<ReviewInfo> taskRequestReviewFlow = reviewManager.requestReviewFlow();
            Intrinsics.checkNotNullExpressionValue(taskRequestReviewFlow, "requestReviewFlow()");
            anonymousClass1.label = 1;
            objRunTask$default = runTask$default(taskRequestReviewFlow, null, anonymousClass1, 2, null);
            if (objRunTask$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(objRunTask$default);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Intrinsics.checkNotNullExpressionValue(objRunTask$default, "runTask(requestReviewFlow())");
        return objRunTask$default;
    }

    public static final <T> Object runTask(Task<T> task, final Function0 function0, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        cancellableContinuationImpl.invokeOnCancellation(new Function1() { // from class: com.google.android.play.core.ktx.ReviewManagerKtxKt$runTask$3$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th) {
                function0.invoke();
            }
        });
        if (task.isComplete()) {
            if (task.isSuccessful()) {
                cancellableContinuationImpl.resumeWith(Result.m5243constructorimpl(task.getResult()));
            } else {
                Exception exception = task.getException();
                Intrinsics.checkNotNull(exception);
                cancellableContinuationImpl.resumeWith(Result.m5243constructorimpl(ResultKt.createFailure(exception)));
            }
        } else {
            task.addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.play.core.ktx.ReviewManagerKtxKt$runTask$3$2
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(T t) {
                    cancellableContinuationImpl.resumeWith(Result.m5243constructorimpl(t));
                }
            });
            task.addOnFailureListener(new OnFailureListener() { // from class: com.google.android.play.core.ktx.ReviewManagerKtxKt$runTask$3$3
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exception2) {
                    Intrinsics.checkNotNullParameter(exception2, "exception");
                    cancellableContinuationImpl.resumeWith(Result.m5243constructorimpl(ResultKt.createFailure(exception2)));
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static /* synthetic */ Object runTask$default(Task task, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: com.google.android.play.core.ktx.ReviewManagerKtxKt.runTask.2
                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Object invoke() {
                    m3517invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m3517invoke() {
                }
            };
        }
        return runTask(task, function0, continuation);
    }

    public static final <E> boolean tryOffer(SendChannel sendChannel, E e) {
        Intrinsics.checkNotNullParameter(sendChannel, "<this>");
        return ChannelResult.m5459isSuccessimpl(sendChannel.mo5449trySendJP2dKIU(e));
    }
}
