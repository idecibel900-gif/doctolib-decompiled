package expo.modules.imagepicker;

import expo.modules.imagepicker.contracts.ImageLibraryContractOptions;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
final class ImagePickerModule$definition$1$6$1 extends SuspendLambda implements Function1 {
    final /* synthetic */ ImageLibraryContractOptions $contractOptions;
    int label;
    final /* synthetic */ ImagePickerModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ImagePickerModule$definition$1$6$1(ImagePickerModule imagePickerModule, ImageLibraryContractOptions imageLibraryContractOptions, Continuation continuation) {
        super(1, continuation);
        this.this$0 = imagePickerModule;
        this.$contractOptions = imageLibraryContractOptions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ImagePickerModule$definition$1$6$1(this.this$0, this.$contractOptions, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((ImagePickerModule$definition$1$6$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
        AppContextActivityResultLauncher appContextActivityResultLauncher = this.this$0.imageLibraryLauncher;
        if (appContextActivityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageLibraryLauncher");
            appContextActivityResultLauncher = null;
        }
        ImageLibraryContractOptions imageLibraryContractOptions = this.$contractOptions;
        this.label = 1;
        Object objLaunch = appContextActivityResultLauncher.launch(imageLibraryContractOptions, this);
        return objLaunch == coroutine_suspended ? coroutine_suspended : objLaunch;
    }
}
