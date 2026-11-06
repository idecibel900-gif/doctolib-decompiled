package expo.modules.imagepicker;

import expo.modules.imagepicker.contracts.ImageLibraryContractOptions;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class ImagePickerModule$definition$lambda$7$$inlined$Coroutine$4 extends SuspendLambda implements Function3 {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ImagePickerModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePickerModule$definition$lambda$7$$inlined$Coroutine$4(Continuation continuation, ImagePickerModule imagePickerModule) {
        super(3, continuation);
        this.this$0 = imagePickerModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation continuation) {
        ImagePickerModule$definition$lambda$7$$inlined$Coroutine$4 imagePickerModule$definition$lambda$7$$inlined$Coroutine$4 = new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$4(continuation, this.this$0);
        imagePickerModule$definition$lambda$7$$inlined$Coroutine$4.L$0 = objArr;
        return imagePickerModule$definition$lambda$7$$inlined$Coroutine$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        ImagePickerOptions imagePickerOptions = (ImagePickerOptions) ((Object[]) this.L$0)[0];
        ImageLibraryContractOptions imageLibraryContractOptions = imagePickerOptions.toImageLibraryContractOptions();
        ImagePickerModule imagePickerModule = this.this$0;
        ImagePickerModule$definition$1$6$1 imagePickerModule$definition$1$6$1 = new ImagePickerModule$definition$1$6$1(imagePickerModule, imageLibraryContractOptions, null);
        this.label = 1;
        Object objLaunchContract = imagePickerModule.launchContract(imagePickerModule$definition$1$6$1, imagePickerOptions, this);
        return objLaunchContract == coroutine_suspended ? coroutine_suspended : objLaunchContract;
    }
}
