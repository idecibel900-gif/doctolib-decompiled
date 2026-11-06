package io.legere.pdfiumandroid.suspend;

import io.legere.pdfiumandroid.FindResult;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ\u000e\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/legere/pdfiumandroid/suspend/FindResultKt;", "Ljava/io/Closeable;", "findResult", "Lio/legere/pdfiumandroid/FindResult;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lio/legere/pdfiumandroid/FindResult;Lkotlinx/coroutines/CoroutineDispatcher;)V", "findNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findPrev", "getSchResultIndex", "", "getSchCount", "closeFind", "", "close", "pdfiumandroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FindResultKt implements Closeable {
    private final CoroutineDispatcher dispatcher;
    private final FindResult findResult;

    public FindResultKt(FindResult findResult, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(findResult, "findResult");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.findResult = findResult;
        this.dispatcher = dispatcher;
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.FindResultKt$findNext$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.FindResultKt$findNext$2", f = "FindResultKt.kt", l = {}, m = "invokeSuspend")
    static final class C11162 extends SuspendLambda implements Function2 {
        int label;

        C11162(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FindResultKt.this.new C11162(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11162) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(FindResultKt.this.findResult.findNext());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object findNext(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11162(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.FindResultKt$findPrev$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.FindResultKt$findPrev$2", f = "FindResultKt.kt", l = {}, m = "invokeSuspend")
    static final class C11172 extends SuspendLambda implements Function2 {
        int label;

        C11172(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FindResultKt.this.new C11172(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11172) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(FindResultKt.this.findResult.findPrev());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object findPrev(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11172(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.FindResultKt$getSchResultIndex$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.FindResultKt$getSchResultIndex$2", f = "FindResultKt.kt", l = {}, m = "invokeSuspend")
    static final class C11192 extends SuspendLambda implements Function2 {
        int label;

        C11192(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FindResultKt.this.new C11192(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11192) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxInt(FindResultKt.this.findResult.getSchResultIndex());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object getSchResultIndex(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11192(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.FindResultKt$getSchCount$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.FindResultKt$getSchCount$2", f = "FindResultKt.kt", l = {}, m = "invokeSuspend")
    static final class C11182 extends SuspendLambda implements Function2 {
        int label;

        C11182(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FindResultKt.this.new C11182(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11182) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxInt(FindResultKt.this.findResult.getSchCount());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object getSchCount(Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11182(null), continuation);
    }

    /* JADX INFO: renamed from: io.legere.pdfiumandroid.suspend.FindResultKt$closeFind$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.legere.pdfiumandroid.suspend.FindResultKt$closeFind$2", f = "FindResultKt.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return FindResultKt.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FindResultKt.this.findResult.closeFind();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object closeFind(Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new AnonymousClass2(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.findResult.closeFind();
    }
}
