package expo.modules.imagepicker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.OperationCanceledException;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.tracing.Trace;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.imagepicker.contracts.CropImageContractOptions;
import expo.modules.imagepicker.contracts.ImagePickerContractResult;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.interfaces.permissions.PermissionsResponseListener;
import expo.modules.interfaces.permissions.PermissionsStatus;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import expo.modules.kotlin.exception.Exceptions$ModuleNotFound;
import expo.modules.kotlin.exception.Exceptions$PermissionsModuleNotFound;
import expo.modules.kotlin.exception.Exceptions$ReactContextLost;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J4\u0010 \u001a\u00020!2\u001c\u0010\"\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0$\u0012\u0006\u0012\u0004\u0018\u00010!0#2\u0006\u0010%\u001a\u00020&H\u0082@¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&H\u0002J,\u0010+\u001a\u00020,2\u001c\u0010\"\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0$\u0012\u0006\u0012\u0004\u0018\u00010!0#H\u0082@¢\u0006\u0002\u0010-J\u001b\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u00101\u001a\u00020\u001bH\u0002¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020)2\u0006\u0010%\u001a\u00020&H\u0002J\u000e\u00104\u001a\u00020)H\u0082@¢\u0006\u0002\u00105R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f0\rX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f0\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lexpo/modules/imagepicker/ImagePickerModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "mediaHandler", "Lexpo/modules/imagepicker/MediaHandler;", "cameraLauncher", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "Lexpo/modules/imagepicker/contracts/CameraContractOptions;", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult;", "imageLibraryLauncher", "Lexpo/modules/imagepicker/contracts/ImageLibraryContractOptions;", "cropImageLauncher", "Lexpo/modules/imagepicker/contracts/CropImageContractOptions;", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "pendingMediaPickingResult", "Lexpo/modules/imagepicker/PendingMediaPickingResult;", "isPickerOpen", "", "createPermissionsDecorator", "Lexpo/modules/interfaces/permissions/PermissionsResponseListener;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "launchContract", "", "pickerLauncher", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "options", "Lexpo/modules/imagepicker/ImagePickerOptions;", "(Lkotlin/jvm/functions/Function1;Lexpo/modules/imagepicker/ImagePickerOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleResultUponActivityDestruction", "", "result", "launchPicker", "Lexpo/modules/imagepicker/contracts/ImagePickerContractResult$Success;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMediaLibraryPermissions", "", "", "writeOnly", "(Z)[Ljava/lang/String;", "ensureTargetActivityIsAvailable", "ensureCameraPermissionsAreGranted", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-image-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImagePickerModule extends Module {
    private AppContextActivityResultLauncher cameraLauncher;
    private AppContextActivityResultLauncher cropImageLauncher;
    private AppContextActivityResultLauncher imageLibraryLauncher;
    private boolean isPickerOpen;
    private final MediaHandler mediaHandler = new MediaHandler(this);
    private PendingMediaPickingResult pendingMediaPickingResult;

    /* JADX INFO: renamed from: expo.modules.imagepicker.ImagePickerModule$launchContract$1, reason: invalid class name */
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
            return ImagePickerModule.this.launchContract(null, null, this);
        }
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent stringAsyncFunctionComponent;
        AsyncFunctionComponent stringAsyncFunctionComponent2;
        AsyncFunctionComponent asyncFunctionWithPromiseComponent;
        Class<ImagePickerOptions> cls = ImagePickerOptions.class;
        Trace.beginSection("[ExpoModulesCore] " + (getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(this);
            moduleDefinitionBuilder.Name("ExponentImagePicker");
            TypeConverterProvider converters = moduleDefinitionBuilder.getConverters();
            AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
            Boolean bool = Boolean.FALSE;
            AnyType anyType = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, bool));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunctionWithPromise$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }), converters);
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("requestMediaLibraryPermissionsAsync", new AsyncFunctionWithPromiseComponent("requestMediaLibraryPermissionsAsync", new AnyType[]{anyType}, new Function2() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunctionWithPromise$2
                public final void invoke(Object[] objArr, Promise promise) throws Exceptions$PermissionsModuleNotFound {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    boolean zBooleanValue = ((Boolean) objArr[0]).booleanValue();
                    Permissions permissions = this.this$0.getAppContext().getPermissions();
                    if (permissions != null) {
                        String[] mediaLibraryPermissions = this.this$0.getMediaLibraryPermissions(zBooleanValue);
                        permissions.askForPermissions(this.this$0.createPermissionsDecorator(promise), (String[]) Arrays.copyOf(mediaLibraryPermissions, mediaLibraryPermissions.length));
                        return;
                    }
                    throw new Exceptions$PermissionsModuleNotFound();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Exceptions$PermissionsModuleNotFound {
                    invoke((Object[]) obj, (Promise) obj2);
                    return Unit.INSTANCE;
                }
            }));
            TypeConverterProvider converters2 = moduleDefinitionBuilder.getConverters();
            AnyType anyType2 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), bool));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunctionWithPromise$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }), converters2);
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("getMediaLibraryPermissionsAsync", new AsyncFunctionWithPromiseComponent("getMediaLibraryPermissionsAsync", new AnyType[]{anyType2}, new Function2() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunctionWithPromise$4
                public final void invoke(Object[] objArr, Promise promise) throws Exceptions$PermissionsModuleNotFound {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    boolean zBooleanValue = ((Boolean) objArr[0]).booleanValue();
                    Permissions permissions = this.this$0.getAppContext().getPermissions();
                    if (permissions != null) {
                        String[] mediaLibraryPermissions = this.this$0.getMediaLibraryPermissions(zBooleanValue);
                        permissions.getPermissions(this.this$0.createPermissionsDecorator(promise), (String[]) Arrays.copyOf(mediaLibraryPermissions, mediaLibraryPermissions.length));
                        return;
                    }
                    throw new Exceptions$PermissionsModuleNotFound();
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Exceptions$PermissionsModuleNotFound {
                    invoke((Object[]) obj, (Promise) obj2);
                    return Unit.INSTANCE;
                }
            }));
            boolean zAreEqual = Intrinsics.areEqual(Promise.class, Promise.class);
            Class cls2 = Float.TYPE;
            Class cls3 = Double.TYPE;
            Class cls4 = Boolean.TYPE;
            Class cls5 = Integer.TYPE;
            if (zAreEqual) {
                stringAsyncFunctionComponent = new AsyncFunctionWithPromiseComponent("requestCameraPermissionsAsync", new AnyType[0], new Function2() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Object[]) obj, (Promise) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Permissions.askForPermissionsWithPermissionsManager(this.this$0.getAppContext().getPermissions(), promise, "android.permission.CAMERA");
                    }
                });
                cls = cls;
                moduleDefinitionBuilder = moduleDefinitionBuilder;
                anyTypeProvider = anyTypeProvider;
            } else {
                TypeConverterProvider converters3 = moduleDefinitionBuilder.getConverters();
                AnyType anyType3 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), bool));
                if (anyType3 == null) {
                    anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }), converters3);
                }
                AnyType[] anyTypeArr = {anyType3};
                Function1 function1 = new Function1() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Permissions.askForPermissionsWithPermissionsManager(this.this$0.getAppContext().getPermissions(), (Promise) objArr[0], "android.permission.CAMERA");
                        return Unit.INSTANCE;
                    }
                };
                if (Intrinsics.areEqual(Unit.class, cls5)) {
                    stringAsyncFunctionComponent = new IntAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, function1);
                } else if (Intrinsics.areEqual(Unit.class, cls4)) {
                    stringAsyncFunctionComponent = new BoolAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, function1);
                } else if (Intrinsics.areEqual(Unit.class, cls3)) {
                    stringAsyncFunctionComponent = new DoubleAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, function1);
                } else if (Intrinsics.areEqual(Unit.class, cls2)) {
                    stringAsyncFunctionComponent = new FloatAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, function1);
                } else {
                    stringAsyncFunctionComponent = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, function1) : new UntypedAsyncFunctionComponent("requestCameraPermissionsAsync", anyTypeArr, function1);
                }
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("requestCameraPermissionsAsync", stringAsyncFunctionComponent);
            if (Intrinsics.areEqual(Promise.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getCameraPermissionsAsync", new AnyType[0], new Function2() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Object[]) obj, (Promise) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        Permissions.getPermissionsWithPermissionsManager(this.this$0.getAppContext().getPermissions(), promise, "android.permission.CAMERA");
                    }
                });
            } else {
                TypeConverterProvider converters4 = moduleDefinitionBuilder.getConverters();
                AnyType anyType4 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Promise.class), bool));
                if (anyType4 == null) {
                    anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(Promise.class);
                        }
                    }), converters4);
                }
                AnyType[] anyTypeArr2 = {anyType4};
                Function1 function2 = new Function1() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        Permissions.getPermissionsWithPermissionsManager(this.this$0.getAppContext().getPermissions(), (Promise) objArr[0], "android.permission.CAMERA");
                        return Unit.INSTANCE;
                    }
                };
                if (Intrinsics.areEqual(Unit.class, cls5)) {
                    stringAsyncFunctionComponent2 = new IntAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr2, function2);
                } else if (Intrinsics.areEqual(Unit.class, cls4)) {
                    stringAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr2, function2);
                } else if (Intrinsics.areEqual(Unit.class, cls3)) {
                    stringAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr2, function2);
                } else if (Intrinsics.areEqual(Unit.class, cls2)) {
                    stringAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr2, function2);
                } else {
                    stringAsyncFunctionComponent2 = Intrinsics.areEqual(Unit.class, String.class) ? new StringAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr2, function2) : new UntypedAsyncFunctionComponent("getCameraPermissionsAsync", anyTypeArr2, function2);
                }
                asyncFunctionWithPromiseComponent = stringAsyncFunctionComponent2;
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("getCameraPermissionsAsync", asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = moduleDefinitionBuilder2.AsyncFunction("launchCameraAsync");
            String name = asyncFunctionBuilderAsyncFunction.getName();
            TypeConverterProvider converters5 = asyncFunctionBuilderAsyncFunction.getConverters();
            AnyType anyType5 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(cls), bool));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(cls), false, new Function0() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$Coroutine$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ImagePickerOptions.class);
                    }
                }), converters5);
            }
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name, new AnyType[]{anyType5}, new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$2(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction2 = moduleDefinitionBuilder2.AsyncFunction("launchImageLibraryAsync");
            String name2 = asyncFunctionBuilderAsyncFunction2.getName();
            TypeConverterProvider converters6 = asyncFunctionBuilderAsyncFunction2.getConverters();
            AnyType anyType6 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(cls), bool));
            if (anyType6 == null) {
                anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(cls), false, new Function0() { // from class: expo.modules.imagepicker.ImagePickerModule$definition$lambda$7$$inlined$Coroutine$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ImagePickerOptions.class);
                    }
                }), converters6);
            }
            asyncFunctionBuilderAsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(name2, new AnyType[]{anyType6}, new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$4(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction3 = moduleDefinitionBuilder2.AsyncFunction("getPendingResultAsync");
            asyncFunctionBuilderAsyncFunction3.setAsyncFunctionComponent(new SuspendFunctionComponent(asyncFunctionBuilderAsyncFunction3.getName(), new AnyType[0], new ImagePickerModule$definition$lambda$7$$inlined$Coroutine$5(null, this)));
            moduleDefinitionBuilder2.RegisterActivityContracts(new ImagePickerModule$definition$1$8(this, null));
            return moduleDefinitionBuilder2.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new IllegalArgumentException("React Application Context is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getCacheDirectory() {
        return getAppContext().getCacheDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PermissionsResponseListener createPermissionsDecorator(final Promise promise) {
        final WeakReference weakReferenceWeak = UtilsKt.weak(getAppContext().getReactContext());
        return new PermissionsResponseListener() { // from class: expo.modules.imagepicker.ImagePickerModule$$ExternalSyntheticLambda0
            @Override // expo.modules.interfaces.permissions.PermissionsResponseListener
            public final void onResult(Map map) {
                ImagePickerModule.createPermissionsDecorator$lambda$14(promise, weakReferenceWeak, this, map);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createPermissionsDecorator$lambda$14(Promise promise, WeakReference weakReference, ImagePickerModule imagePickerModule, Map map) {
        boolean z;
        boolean z2;
        String status;
        Intrinsics.checkNotNull(map);
        boolean z3 = false;
        if (!map.isEmpty()) {
            Iterator it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((PermissionsResponse) ((Map.Entry) it.next()).getValue()).getStatus() != PermissionsStatus.GRANTED) {
                    z = false;
                    break;
                }
            }
        } else {
            z = true;
            break;
        }
        if (map.isEmpty()) {
            z2 = false;
        } else {
            if (!map.isEmpty()) {
                Iterator it2 = map.entrySet().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((PermissionsResponse) ((Map.Entry) it2.next()).getValue()).getStatus() != PermissionsStatus.DENIED) {
                            z2 = false;
                        }
                    }
                }
            }
            z2 = true;
        }
        if (!map.isEmpty()) {
            Iterator it3 = map.entrySet().iterator();
            do {
                if (!it3.hasNext()) {
                    z3 = true;
                    break;
                }
            } while (((PermissionsResponse) ((Map.Entry) it3.next()).getValue()).getCanAskAgain());
        } else {
            z3 = true;
            break;
        }
        Bundle bundle = new Bundle();
        bundle.putString("expires", "never");
        if (z) {
            status = PermissionsStatus.GRANTED.getStatus();
        } else {
            status = z2 ? PermissionsStatus.DENIED.getStatus() : PermissionsStatus.UNDETERMINED.getStatus();
        }
        bundle.putString("status", status);
        bundle.putBoolean("canAskAgain", z3);
        bundle.putBoolean("granted", z);
        if (z) {
            bundle.putString("accessPrivileges", "all");
            promise.resolve(bundle);
            return;
        }
        if (Build.VERSION.SDK_INT < 34) {
            bundle.putString("accessPrivileges", "none");
            promise.resolve(bundle);
            return;
        }
        Context context = (Context) weakReference.get();
        if (context == null) {
            promise.reject(new Exceptions$ReactContextLost());
            return;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == 0) {
            bundle.putBoolean("granted", true);
            bundle.putBoolean("canAskAgain", true);
            bundle.putString("status", PermissionsStatus.GRANTED.getStatus());
            bundle.putString("accessPrivileges", "limited");
        } else {
            bundle.putString("accessPrivileges", "none");
        }
        promise.resolve(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00fe, code lost:
    
        if (r0 == r8) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object launchContract(kotlin.jvm.functions.Function1 r15, expo.modules.imagepicker.ImagePickerOptions r16, kotlin.coroutines.Continuation r17) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.ImagePickerModule.launchContract(kotlin.jvm.functions.Function1, expo.modules.imagepicker.ImagePickerOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: expo.modules.imagepicker.ImagePickerModule$launchContract$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function1 {
        final /* synthetic */ Bitmap.CompressFormat $compressFormat;
        final /* synthetic */ ImagePickerOptions $options;
        final /* synthetic */ File $outputFile;
        final /* synthetic */ Uri $sourceUri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Uri uri, ImagePickerOptions imagePickerOptions, File file, Bitmap.CompressFormat compressFormat, Continuation continuation) {
            super(1, continuation);
            this.$sourceUri = uri;
            this.$options = imagePickerOptions;
            this.$outputFile = file;
            this.$compressFormat = compressFormat;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ImagePickerModule.this.new AnonymousClass2(this.$sourceUri, this.$options, this.$outputFile, this.$compressFormat, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
            AppContextActivityResultLauncher appContextActivityResultLauncher = ImagePickerModule.this.cropImageLauncher;
            if (appContextActivityResultLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropImageLauncher");
                appContextActivityResultLauncher = null;
            }
            String string = this.$sourceUri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            CropImageContractOptions cropImageContractOptions = new CropImageContractOptions(string, this.$options, this.$outputFile, this.$compressFormat);
            this.label = 1;
            Object objLaunch = appContextActivityResultLauncher.launch(cropImageContractOptions, this);
            return objLaunch == coroutine_suspended ? coroutine_suspended : objLaunch;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleResultUponActivityDestruction(ImagePickerContractResult result, ImagePickerOptions options) {
        if (result instanceof ImagePickerContractResult.Success) {
            this.pendingMediaPickingResult = new PendingMediaPickingResult(((ImagePickerContractResult.Success) result).getData(), options);
        }
    }

    /* JADX INFO: renamed from: expo.modules.imagepicker.ImagePickerModule$launchPicker$2, reason: invalid class name and case insensitive filesystem */
    static final class C10902 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function1 $pickerLauncher;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10902(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$pickerLauncher = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C10902(this.$pickerLauncher, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C10902) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws FailedToPickMediaException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1 function1 = this.$pickerLauncher;
                this.label = 1;
                obj = function1.invoke(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ImagePickerContractResult imagePickerContractResult = (ImagePickerContractResult) obj;
            if (imagePickerContractResult instanceof ImagePickerContractResult.Success) {
                return (ImagePickerContractResult.Success) imagePickerContractResult;
            }
            if (imagePickerContractResult instanceof ImagePickerContractResult.Cancelled) {
                throw new OperationCanceledException();
            }
            if (imagePickerContractResult instanceof ImagePickerContractResult.Error) {
                throw new FailedToPickMediaException();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    private final Object launchPicker(Function1 function1, Continuation continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C10902(function1, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String[] getMediaLibraryPermissions(boolean writeOnly) {
        if (Build.VERSION.SDK_INT < 33) {
            return (String[]) CollectionsKt.listOfNotNull((Object[]) new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", !writeOnly ? "android.permission.READ_EXTERNAL_STORAGE" : null}).toArray(new String[0]);
        }
        return new String[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureTargetActivityIsAvailable(ImagePickerOptions options) throws MissingActivityToHandleIntent {
        Intent intent = new Intent(options.getNativeMediaTypes().toCameraIntentAction());
        if (intent.resolveActivity(getAppContext().getThrowingActivity().getApplication().getPackageManager()) == null) {
            throw new MissingActivityToHandleIntent(intent.getType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object ensureCameraPermissionsAreGranted(Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Permissions permissions = getAppContext().getPermissions();
        if (permissions == null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m5243constructorimpl(ResultKt.createFailure(new Exceptions$ModuleNotFound(Reflection.getOrCreateKotlinClass(Permissions.class)))));
        } else {
            PermissionsResponseListener permissionsResponseListener = new PermissionsResponseListener() { // from class: expo.modules.imagepicker.ImagePickerModule$ensureCameraPermissionsAreGranted$2$1
                @Override // expo.modules.interfaces.permissions.PermissionsResponseListener
                public final void onResult(Map map) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        PermissionsResponse permissionsResponse = (PermissionsResponse) map.get("android.permission.CAMERA");
                        if ((permissionsResponse != null ? permissionsResponse.getStatus() : null) == PermissionsStatus.GRANTED) {
                            CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                            Result.Companion companion2 = Result.Companion;
                            cancellableContinuation.resumeWith(Result.m5243constructorimpl(Unit.INSTANCE));
                            return;
                        } else {
                            CancellableContinuation cancellableContinuation2 = cancellableContinuationImpl;
                            Result.Companion companion3 = Result.Companion;
                            cancellableContinuation2.resumeWith(Result.m5243constructorimpl(ResultKt.createFailure(new UserRejectedPermissionsException())));
                            return;
                        }
                    }
                    PermissionsResponse permissionsResponse2 = (PermissionsResponse) map.get("android.permission.WRITE_EXTERNAL_STORAGE");
                    PermissionsStatus status = permissionsResponse2 != null ? permissionsResponse2.getStatus() : null;
                    PermissionsStatus permissionsStatus = PermissionsStatus.GRANTED;
                    if (status == permissionsStatus) {
                        PermissionsResponse permissionsResponse3 = (PermissionsResponse) map.get("android.permission.CAMERA");
                        if ((permissionsResponse3 != null ? permissionsResponse3.getStatus() : null) == permissionsStatus) {
                            CancellableContinuation cancellableContinuation3 = cancellableContinuationImpl;
                            Result.Companion companion4 = Result.Companion;
                            cancellableContinuation3.resumeWith(Result.m5243constructorimpl(Unit.INSTANCE));
                            return;
                        }
                    }
                    CancellableContinuation cancellableContinuation4 = cancellableContinuationImpl;
                    Result.Companion companion5 = Result.Companion;
                    cancellableContinuation4.resumeWith(Result.m5243constructorimpl(ResultKt.createFailure(new UserRejectedPermissionsException())));
                }
            };
            String[] strArr = (String[]) CollectionsKt.listOfNotNull((Object[]) new String[]{Build.VERSION.SDK_INT < 29 ? "android.permission.WRITE_EXTERNAL_STORAGE" : null, "android.permission.CAMERA"}).toArray(new String[0]);
            permissions.askForPermissions(permissionsResponseListener, (String[]) Arrays.copyOf(strArr, strArr.length));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}
