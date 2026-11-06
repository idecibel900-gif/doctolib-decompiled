package expo.modules.imagepicker.exporters;

import android.content.ContentResolver;
import android.net.Uri;
import androidx.recyclerview.widget.LinearLayoutManager;
import expo.modules.imagepicker.ImagePickerUtilsKt;
import java.io.File;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes4.dex */
public final class RawImageExporter implements ImageExporter {

    /* JADX INFO: renamed from: expo.modules.imagepicker.exporters.RawImageExporter$exportAsync$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return RawImageExporter.this.exportAsync(null, null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // expo.modules.imagepicker.exporters.ImageExporter
    public Object exportAsync(Uri uri, File file, ContentResolver contentResolver, Continuation continuation) {
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            anonymousClass1.L$0 = file;
            anonymousClass1.label = 1;
            if (ImagePickerUtilsKt.copyFile(uri, file, contentResolver, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            file = (File) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        DimensionsExporter dimensionsExporter = new DimensionsExporter(file);
        return new ImageExportResult(dimensionsExporter.getWidth(), dimensionsExporter.getHeight(), file);
    }
}
