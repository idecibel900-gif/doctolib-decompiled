package expo.modules.fetch;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.amazon.a.a.o.b.f;
import expo.modules.core.logging.LoggerUtilsKt;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.sharedobjects.SharedObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\f2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0016¢\u0006\u0004\b\u001f\u0010\u001aJ\r\u0010 \u001a\u00020\u0016¢\u0006\u0004\b \u0010\u001aJ/\u0010%\u001a\u00020\u00162\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0!2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160#¢\u0006\u0004\b%\u0010&J\u001f\u0010+\u001a\u00020\u00162\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020\u00162\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b-\u0010.R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010/R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R*\u00106\u001a\u00020\n2\u0006\u00105\u001a\u00020\n8B@BX\u0082\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R*\u0010>\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0#j\u0002`=0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R(\u0010@\u001a\u0004\u0018\u00010\u00112\b\u00105\u001a\u0004\u0018\u00010\u00118\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR4\u0010F\u001a\n\u0018\u00010Dj\u0004\u0018\u0001`E2\u000e\u00105\u001a\n\u0018\u00010Dj\u0004\u0018\u0001`E8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR$\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0011\u0010S\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bQ\u0010R¨\u0006U"}, d2 = {"Lexpo/modules/fetch/NativeResponse;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "Lokhttp3/Callback;", "Lexpo/modules/kotlin/AppContext;", "appContext", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "<init>", "(Lexpo/modules/kotlin/AppContext;Lkotlinx/coroutines/CoroutineScope;)V", "", "Lexpo/modules/fetch/ResponseState;", "validStates", "", "isInvalidState", "([Lexpo/modules/fetch/ResponseState;)Z", "Lokhttp3/Response;", "response", "Lexpo/modules/fetch/NativeResponseInit;", "createResponseInit", "(Lokhttp3/Response;)Lexpo/modules/fetch/NativeResponseInit;", "Lokio/BufferedSource;", "stream", "", "pumpResponseBodyStream", "(Lokio/BufferedSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deallocate", "()V", "onStarted", "", "startStreaming", "()[B", "cancelStreaming", "emitRequestCanceled", "", "states", "Lkotlin/Function1;", "callback", "waitForStates", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "onFailure", "(Lokhttp3/Call;Ljava/io/IOException;)V", "onResponse", "(Lokhttp3/Call;Lokhttp3/Response;)V", "Lkotlinx/coroutines/CoroutineScope;", "Lexpo/modules/fetch/ResponseSink;", "sink", "Lexpo/modules/fetch/ResponseSink;", "getSink", "()Lexpo/modules/fetch/ResponseSink;", "value", "state", "Lexpo/modules/fetch/ResponseState;", "getState", "()Lexpo/modules/fetch/ResponseState;", "setState", "(Lexpo/modules/fetch/ResponseState;)V", "", "Lexpo/modules/fetch/StateChangeListener;", "stateChangeOnceListeners", "Ljava/util/List;", "responseInit", "Lexpo/modules/fetch/NativeResponseInit;", "getResponseInit", "()Lexpo/modules/fetch/NativeResponseInit;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Ljava/lang/Exception;", "getError", "()Ljava/lang/Exception;", "Lexpo/modules/fetch/NativeRequestRedirect;", "redirectMode", "Lexpo/modules/fetch/NativeRequestRedirect;", "getRedirectMode", "()Lexpo/modules/fetch/NativeRequestRedirect;", "setRedirectMode", "(Lexpo/modules/fetch/NativeRequestRedirect;)V", "getBodyUsed", "()Z", "bodyUsed", "Companion", "expo_productionRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeResponse extends SharedObject implements Callback {
    private static final String TAG = NativeResponse.class.getSimpleName();
    private final CoroutineScope coroutineScope;
    private Exception error;
    private NativeRequestRedirect redirectMode;
    private NativeResponseInit responseInit;
    private final ResponseSink sink;
    private ResponseState state;
    private final List stateChangeOnceListeners;

    /* JADX INFO: renamed from: expo.modules.fetch.NativeResponse$pumpResponseBodyStream$1, reason: invalid class name and case insensitive filesystem */
    static final class C10871 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10871(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return NativeResponse.this.pumpResponseBodyStream(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeResponse(AppContext appContext, CoroutineScope coroutineScope) {
        super(appContext);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
        this.sink = new ResponseSink();
        this.state = ResponseState.INITIALIZED;
        this.stateChangeOnceListeners = new ArrayList();
    }

    public final ResponseSink getSink() {
        return this.sink;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResponseState getState() {
        ResponseState responseState;
        synchronized (this) {
            responseState = this.state;
        }
        return responseState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setState(ResponseState responseState) {
        synchronized (this) {
            this.state = responseState;
            Unit unit = Unit.INSTANCE;
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new NativeResponse$state$3(this, responseState, null), 3, null);
    }

    public final NativeResponseInit getResponseInit() {
        return this.responseInit;
    }

    public final Exception getError() {
        return this.error;
    }

    public final void setRedirectMode(NativeRequestRedirect nativeRequestRedirect) {
        this.redirectMode = nativeRequestRedirect;
    }

    public final boolean getBodyUsed() {
        return this.sink.getBodyUsed();
    }

    @Override // expo.modules.kotlin.sharedobjects.SharedObject
    public void deallocate() {
        this.sink.finalize(false);
        super.deallocate();
    }

    public final void onStarted() {
        if (isInvalidState(ResponseState.INITIALIZED)) {
            return;
        }
        setState(ResponseState.STARTED);
    }

    public final byte[] startStreaming() {
        ResponseState responseState = ResponseState.RESPONSE_RECEIVED;
        ResponseState responseState2 = ResponseState.BODY_COMPLETED;
        if (isInvalidState(responseState, responseState2)) {
            return null;
        }
        if (getState() == responseState) {
            setState(ResponseState.BODY_STREAMING_STARTED);
            emit("didReceiveResponseData", this.sink.finalize(false).array());
        } else if (getState() == responseState2) {
            return this.sink.finalize(false).array();
        }
        return null;
    }

    public final void cancelStreaming() {
        if (isInvalidState(ResponseState.BODY_STREAMING_STARTED)) {
            return;
        }
        setState(ResponseState.BODY_STREAMING_CANCELED);
    }

    public final void emitRequestCanceled() {
        FetchRequestCanceledException fetchRequestCanceledException = new FetchRequestCanceledException();
        this.error = fetchRequestCanceledException;
        if (getState() == ResponseState.BODY_STREAMING_STARTED) {
            emit("didFailWithError", LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(fetchRequestCanceledException));
        }
        setState(ResponseState.ERROR_RECEIVED);
    }

    public final void waitForStates(final List states, final Function1 callback) {
        Intrinsics.checkNotNullParameter(states, "states");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (states.contains(getState())) {
            callback.invoke(getState());
        } else {
            this.stateChangeOnceListeners.add(new Function1() { // from class: expo.modules.fetch.NativeResponse$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(NativeResponse.waitForStates$lambda$2(states, callback, (ResponseState) obj));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean waitForStates$lambda$2(List list, Function1 function1, ResponseState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        if (!list.contains(newState)) {
            return false;
        }
        function1.invoke(newState);
        return true;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        if (Intrinsics.areEqual(e.getMessage(), "Canceled")) {
            return;
        }
        ResponseState responseState = ResponseState.STARTED;
        ResponseState responseState2 = ResponseState.RESPONSE_RECEIVED;
        ResponseState responseState3 = ResponseState.BODY_STREAMING_STARTED;
        if (isInvalidState(responseState, responseState2, responseState3, ResponseState.BODY_STREAMING_CANCELED)) {
            return;
        }
        if (getState() == responseState3) {
            emit("didFailWithError", LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(e));
        }
        this.error = e;
        setState(ResponseState.ERROR_RECEIVED);
        emit("readyForJSFinalization", new Object[0]);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.isRedirect() && this.redirectMode == NativeRequestRedirect.ERROR) {
            response.close();
            FetchRedirectException fetchRedirectException = new FetchRedirectException();
            this.error = fetchRedirectException;
            if (getState() == ResponseState.BODY_STREAMING_STARTED) {
                emit("didFailWithError", LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(fetchRedirectException));
            }
            setState(ResponseState.ERROR_RECEIVED);
            emit("readyForJSFinalization", new Object[0]);
            return;
        }
        this.responseInit = createResponseInit(response);
        setState(ResponseState.RESPONSE_RECEIVED);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(response, this, null), 3, null);
    }

    /* JADX INFO: renamed from: expo.modules.fetch.NativeResponse$onResponse$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Response $response;
        Object L$0;
        int label;
        final /* synthetic */ NativeResponse this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Response response, NativeResponse nativeResponse, Continuation continuation) {
            super(2, continuation);
            this.$response = response;
            this.this$0 = nativeResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$response, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r7, r1, r6) == r0) goto L33;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v2, types: [okhttp3.Response] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2d
                if (r1 == r5) goto L27
                if (r1 == r4) goto L23
                if (r1 == r3) goto L1a
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1a:
                java.lang.Object r0 = r6.L$0
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                kotlin.ResultKt.throwOnFailure(r7)
                goto La8
            L23:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L64
            L27:
                kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L2b
                goto L4a
            L2b:
                r7 = move-exception
                goto L8b
            L2d:
                kotlin.ResultKt.throwOnFailure(r7)
                okhttp3.Response r7 = r6.$response
                okhttp3.ResponseBody r7 = r7.body()
                if (r7 == 0) goto La9
                okio.BufferedSource r7 = r7.getBodySource()
                if (r7 != 0) goto L3f
                goto La9
            L3f:
                expo.modules.fetch.NativeResponse r1 = r6.this$0     // Catch: java.lang.Throwable -> L2b
                r6.label = r5     // Catch: java.lang.Throwable -> L2b
                java.lang.Object r7 = expo.modules.fetch.NativeResponse.access$pumpResponseBodyStream(r1, r7, r6)     // Catch: java.lang.Throwable -> L2b
                if (r7 != r0) goto L4a
                goto La6
            L4a:
                kotlinx.coroutines.NonCancellable r7 = kotlinx.coroutines.NonCancellable.INSTANCE
                kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()
                kotlin.coroutines.CoroutineContext r7 = r7.plus(r1)
                expo.modules.fetch.NativeResponse$onResponse$1$1 r1 = new expo.modules.fetch.NativeResponse$onResponse$1$1
                okhttp3.Response r3 = r6.$response
                r1.<init>(r3, r2)
                r6.label = r4
                java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r1, r6)
                if (r7 != r0) goto L64
                goto La6
            L64:
                expo.modules.fetch.NativeResponse r7 = r6.this$0
                expo.modules.fetch.ResponseState r7 = expo.modules.fetch.NativeResponse.access$getState(r7)
                expo.modules.fetch.ResponseState r0 = expo.modules.fetch.ResponseState.BODY_STREAMING_STARTED
                r1 = 0
                if (r7 != r0) goto L78
                expo.modules.fetch.NativeResponse r7 = r6.this$0
                java.lang.String r0 = "didComplete"
                java.lang.Object[] r2 = new java.lang.Object[r1]
                r7.emit(r0, r2)
            L78:
                expo.modules.fetch.NativeResponse r7 = r6.this$0
                expo.modules.fetch.ResponseState r0 = expo.modules.fetch.ResponseState.BODY_COMPLETED
                expo.modules.fetch.NativeResponse.access$setState(r7, r0)
                expo.modules.fetch.NativeResponse r7 = r6.this$0
                java.lang.String r0 = "readyForJSFinalization"
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r7.emit(r0, r1)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            L8b:
                kotlinx.coroutines.NonCancellable r1 = kotlinx.coroutines.NonCancellable.INSTANCE
                kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getIO()
                kotlin.coroutines.CoroutineContext r1 = r1.plus(r4)
                expo.modules.fetch.NativeResponse$onResponse$1$1 r4 = new expo.modules.fetch.NativeResponse$onResponse$1$1
                okhttp3.Response r5 = r6.$response
                r4.<init>(r5, r2)
                r6.L$0 = r7
                r6.label = r3
                java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r6)
                if (r1 != r0) goto La7
            La6:
                return r0
            La7:
                r0 = r7
            La8:
                throw r0
            La9:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.fetch.NativeResponse.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: expo.modules.fetch.NativeResponse$onResponse$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01301 extends SuspendLambda implements Function2 {
            final /* synthetic */ Response $response;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01301(Response response, Continuation continuation) {
                super(2, continuation);
                this.$response = response;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C01301(this.$response, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C01301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$response.close();
                return Unit.INSTANCE;
            }
        }
    }

    private final boolean isInvalidState(ResponseState... validStates) {
        if (ArraysKt.contains(validStates, getState())) {
            return false;
        }
        ArraysKt.joinToString$default(validStates, f.a, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: expo.modules.fetch.NativeResponse$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NativeResponse.isInvalidState$lambda$3((ResponseState) obj);
            }
        }, 30, (Object) null);
        getState().getIntValue();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence isInvalidState$lambda$3(ResponseState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return String.valueOf(it.getIntValue());
    }

    private final NativeResponseInit createResponseInit(Response response) {
        int iCode = response.code();
        String strMessage = response.message();
        Headers headers = response.headers();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(headers, 10));
        for (Pair<? extends String, ? extends String> pair : headers) {
            arrayList.add(TuplesKt.to(pair.getFirst(), pair.getSecond()));
        }
        return new NativeResponseInit(arrayList, iCode, strMessage, response.request().url().getUrl(), response.isRedirect());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x004e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0053  */
    /* JADX WARN: Code duplicated, block: B:25:0x0054 A[Catch: IOException -> 0x002d, TryCatch #0 {IOException -> 0x002d, blocks: (B:12:0x0029, B:22:0x004f, B:25:0x0054, B:28:0x0065, B:30:0x006b, B:19:0x003a, B:31:0x0071, B:33:0x0077), top: B:41:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0065 A[Catch: IOException -> 0x002d, TryCatch #0 {IOException -> 0x002d, blocks: (B:12:0x0029, B:22:0x004f, B:25:0x0054, B:28:0x0065, B:30:0x006b, B:19:0x003a, B:31:0x0071, B:33:0x0077), top: B:41:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x006b A[Catch: IOException -> 0x002d, TryCatch #0 {IOException -> 0x002d, blocks: (B:12:0x0029, B:22:0x004f, B:25:0x0054, B:28:0x0065, B:30:0x006b, B:19:0x003a, B:31:0x0071, B:33:0x0077), top: B:41:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0071 A[Catch: IOException -> 0x002d, TryCatch #0 {IOException -> 0x002d, blocks: (B:12:0x0029, B:22:0x004f, B:25:0x0054, B:28:0x0065, B:30:0x006b, B:19:0x003a, B:31:0x0071, B:33:0x0077), top: B:41:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0077 A[Catch: IOException -> 0x002d, TRY_LEAVE, TryCatch #0 {IOException -> 0x002d, blocks: (B:12:0x0029, B:22:0x004f, B:25:0x0054, B:28:0x0065, B:30:0x006b, B:19:0x003a, B:31:0x0071, B:33:0x0077), top: B:41:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004c -> B:22:0x004f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object pumpResponseBodyStream(okio.BufferedSource r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof expo.modules.fetch.NativeResponse.C10871
            if (r0 == 0) goto L13
            r0 = r8
            expo.modules.fetch.NativeResponse$pumpResponseBodyStream$1 r0 = (expo.modules.fetch.NativeResponse.C10871) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            expo.modules.fetch.NativeResponse$pumpResponseBodyStream$1 r0 = new expo.modules.fetch.NativeResponse$pumpResponseBodyStream$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r7 = r0.L$0
            okio.BufferedSource r7 = (okio.BufferedSource) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.io.IOException -> L2d
            goto L4f
        L2d:
            r7 = move-exception
            goto L81
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
        L3a:
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.io.IOException -> L2d
            expo.modules.fetch.NativeResponse$pumpResponseBodyStream$data$1 r2 = new expo.modules.fetch.NativeResponse$pumpResponseBodyStream$data$1     // Catch: java.io.IOException -> L2d
            r4 = 0
            r2.<init>(r7, r4)     // Catch: java.io.IOException -> L2d
            r0.L$0 = r7     // Catch: java.io.IOException -> L2d
            r0.label = r3     // Catch: java.io.IOException -> L2d
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)     // Catch: java.io.IOException -> L2d
            if (r8 != r1) goto L4f
            return r1
        L4f:
            byte[] r8 = (byte[]) r8     // Catch: java.io.IOException -> L2d
            if (r8 != 0) goto L54
            goto L9d
        L54:
            expo.modules.fetch.ResponseState r2 = expo.modules.fetch.ResponseState.RESPONSE_RECEIVED     // Catch: java.io.IOException -> L2d
            expo.modules.fetch.ResponseState r4 = expo.modules.fetch.ResponseState.BODY_STREAMING_STARTED     // Catch: java.io.IOException -> L2d
            expo.modules.fetch.ResponseState r5 = expo.modules.fetch.ResponseState.BODY_STREAMING_CANCELED     // Catch: java.io.IOException -> L2d
            expo.modules.fetch.ResponseState[] r5 = new expo.modules.fetch.ResponseState[]{r2, r4, r5}     // Catch: java.io.IOException -> L2d
            boolean r5 = r6.isInvalidState(r5)     // Catch: java.io.IOException -> L2d
            if (r5 == 0) goto L65
            goto L9d
        L65:
            expo.modules.fetch.ResponseState r5 = r6.getState()     // Catch: java.io.IOException -> L2d
            if (r5 != r2) goto L71
            expo.modules.fetch.ResponseSink r2 = r6.sink     // Catch: java.io.IOException -> L2d
            r2.appendBufferBody$expo_productionRelease(r8)     // Catch: java.io.IOException -> L2d
            goto L3a
        L71:
            expo.modules.fetch.ResponseState r2 = r6.getState()     // Catch: java.io.IOException -> L2d
            if (r2 != r4) goto L9d
            java.lang.String r2 = "didReceiveResponseData"
            java.lang.Object[] r8 = new java.lang.Object[]{r8}     // Catch: java.io.IOException -> L2d
            r6.emit(r2, r8)     // Catch: java.io.IOException -> L2d
            goto L3a
        L81:
            r6.error = r7
            expo.modules.fetch.ResponseState r8 = r6.getState()
            expo.modules.fetch.ResponseState r0 = expo.modules.fetch.ResponseState.BODY_STREAMING_STARTED
            if (r8 != r0) goto L98
            java.lang.String r7 = expo.modules.core.logging.LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(r7)
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            java.lang.String r8 = "didFailWithError"
            r6.emit(r8, r7)
        L98:
            expo.modules.fetch.ResponseState r7 = expo.modules.fetch.ResponseState.ERROR_RECEIVED
            r6.setState(r7)
        L9d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.fetch.NativeResponse.pumpResponseBodyStream(okio.BufferedSource, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
