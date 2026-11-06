package expo.modules.filesystem;

import android.net.Uri;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class FileSystemModule$definition$lambda$62$$inlined$Coroutine$9 extends SuspendLambda implements Function3 {
    final /* synthetic */ Ref$ObjectRef $filePickerLauncher$inlined;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemModule$definition$lambda$62$$inlined$Coroutine$9(Continuation continuation, Ref$ObjectRef ref$ObjectRef) {
        super(3, continuation);
        this.$filePickerLauncher$inlined = ref$ObjectRef;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation continuation) {
        FileSystemModule$definition$lambda$62$$inlined$Coroutine$9 fileSystemModule$definition$lambda$62$$inlined$Coroutine$9 = new FileSystemModule$definition$lambda$62$$inlined$Coroutine$9(continuation, this.$filePickerLauncher$inlined);
        fileSystemModule$definition$lambda$62$$inlined$Coroutine$9.L$0 = objArr;
        return fileSystemModule$definition$lambda$62$$inlined$Coroutine$9.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws PickerCancelledException {
        AppContextActivityResultLauncher appContextActivityResultLauncher;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object[] objArr = (Object[]) this.L$0;
            Object obj2 = objArr[0];
            String str = (String) objArr[1];
            Uri uri = (Uri) obj2;
            Object obj3 = this.$filePickerLauncher$inlined.element;
            if (obj3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filePickerLauncher");
                appContextActivityResultLauncher = null;
            } else {
                appContextActivityResultLauncher = (AppContextActivityResultLauncher) obj3;
            }
            FilePickerContractOptions filePickerContractOptions = new FilePickerContractOptions(uri, str, PickerType.FILE);
            this.label = 1;
            obj = appContextActivityResultLauncher.launch(filePickerContractOptions, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        FilePickerContractResult filePickerContractResult = (FilePickerContractResult) obj;
        if (filePickerContractResult instanceof FilePickerContractResult.Success) {
            FileSystemPath path = ((FilePickerContractResult.Success) filePickerContractResult).getPath();
            Intrinsics.checkNotNull(path, "null cannot be cast to non-null type expo.modules.filesystem.FileSystemFile");
            return (FileSystemFile) path;
        }
        if (filePickerContractResult instanceof FilePickerContractResult.Cancelled) {
            throw new PickerCancelledException();
        }
        throw new NoWhenBranchMatchedException();
    }
}
