package expo.modules.speechrecognition;

import android.os.ParcelFileDescriptor;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.io.File;
import java.io.IOException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
public final class DelayedFileStreamer {
    private File audioFile;
    private long delayMillis;
    private ParcelFileDescriptor pfd;
    private ParcelFileDescriptor.AutoCloseOutputStream sink;

    /* JADX INFO: renamed from: expo.modules.speechrecognition.DelayedFileStreamer$streamAudioContents$1, reason: invalid class name and case insensitive filesystem */
    static final class C10961 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C10961(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return DelayedFileStreamer.this.streamAudioContents(null, null, this);
        }
    }

    public DelayedFileStreamer(File file, long j) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        this.audioFile = file;
        this.delayMillis = j;
        ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptorArrCreatePipe[0]);
        this.sink = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1]);
        ParcelFileDescriptor parcelFileDescriptorDup = ParcelFileDescriptor.dup(autoCloseInputStream.getFD());
        Intrinsics.checkNotNullExpressionValue(parcelFileDescriptorDup, "dup(...)");
        this.pfd = parcelFileDescriptorDup;
    }

    public final ParcelFileDescriptor getParcel() {
        return this.pfd;
    }

    /* JADX INFO: renamed from: expo.modules.speechrecognition.DelayedFileStreamer$startStreaming$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DelayedFileStreamer.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DelayedFileStreamer delayedFileStreamer = DelayedFileStreamer.this;
                File file = delayedFileStreamer.audioFile;
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = DelayedFileStreamer.this.sink;
                this.label = 1;
                if (delayedFileStreamer.streamAudioContents(file, autoCloseOutputStream, this) == coroutine_suspended) {
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

    public final void startStreaming() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x00b7 A[Catch: all -> 0x00d1, IOException -> 0x00d4, TryCatch #0 {all -> 0x00d1, blocks: (B:61:0x0130, B:68:0x0140, B:70:0x0146, B:72:0x014c, B:35:0x00b1, B:37:0x00b7, B:39:0x00bd, B:41:0x00c6, B:48:0x00eb, B:50:0x00f1, B:52:0x00f7, B:57:0x0108, B:46:0x00d7, B:77:0x0165, B:64:0x0135), top: B:83:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:69:0x0144  */
    /* JADX WARN: Code duplicated, block: B:72:0x014c A[Catch: all -> 0x00d1, IOException -> 0x00d4, TRY_LEAVE, TryCatch #0 {all -> 0x00d1, blocks: (B:61:0x0130, B:68:0x0140, B:70:0x0146, B:72:0x014c, B:35:0x00b1, B:37:0x00b7, B:39:0x00bd, B:41:0x00c6, B:48:0x00eb, B:50:0x00f1, B:52:0x00f7, B:57:0x0108, B:46:0x00d7, B:77:0x0165, B:64:0x0135), top: B:83:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0159  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x012a -> B:86:0x0130). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0144 -> B:70:0x0146). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object streamAudioContents(java.io.File r18, java.io.OutputStream r19, kotlin.coroutines.Continuation r20) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.speechrecognition.DelayedFileStreamer.streamAudioContents(java.io.File, java.io.OutputStream, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void close() {
        try {
            this.pfd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
