package expo.modules.clipboard;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.core.os.BundleKt;
import androidx.tracing.Trace;
import expo.modules.clipboard.ClipboardModule.ClipboardEventEmitter;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u00060\u0015R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lexpo/modules/clipboard/ClipboardModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "clipboardManager", "Landroid/content/ClipboardManager;", "getClipboardManager", "()Landroid/content/ClipboardManager;", "clipboardCacheDir", "Ljava/io/File;", "getClipboardCacheDir", "()Ljava/io/File;", "clipboardCacheDir$delegate", "Lkotlin/Lazy;", "clipboardEventEmitter", "Lexpo/modules/clipboard/ClipboardModule$ClipboardEventEmitter;", "clipboardHasItemWithType", "", "mimeType", "", "firstItem", "Landroid/content/ClipData$Item;", "getFirstItem", "(Landroid/content/ClipboardManager;)Landroid/content/ClipData$Item;", "ClipboardEventEmitter", "expo-clipboard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClipboardModule extends Module {

    /* JADX INFO: renamed from: clipboardCacheDir$delegate, reason: from kotlin metadata */
    private final Lazy clipboardCacheDir = LazyKt.lazy(new Function0() { // from class: expo.modules.clipboard.ClipboardModule$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ClipboardModule.clipboardCacheDir_delegate$lambda$15(this.f$0);
        }
    });
    private ClipboardEventEmitter clipboardEventEmitter;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StringFormat.values().length];
            try {
                iArr[StringFormat.PLAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StringFormat.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent stringAsyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionWithPromiseComponent;
        AsyncFunctionComponent stringAsyncFunctionComponent2;
        AsyncFunctionComponent stringAsyncFunctionComponent3;
        AsyncFunctionComponent stringAsyncFunctionComponent4;
        Trace.beginSection("[ExpoModulesCore] " + (getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(this);
            moduleDefinitionBuilder.Name("ExpoClipboard");
            boolean zAreEqual = Intrinsics.areEqual(GetStringOptions.class, Promise.class);
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Class cls3 = Double.TYPE;
            Class cls4 = Boolean.TYPE;
            if (zAreEqual) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getStringAsync", new AnyType[0], new Function2() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    public final void invoke(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ClipboardModule clipboardModule = this.this$0;
                        ClipData.Item firstItem = clipboardModule.getFirstItem(clipboardModule.getClipboardManager());
                        int i = ClipboardModule.WhenMappings.$EnumSwitchMapping$0[((GetStringOptions) promise).getPreferredFormat().ordinal()];
                        if (i == 1) {
                            if (firstItem != null) {
                                ClipboardModuleKt.coerceToPlainText(firstItem, this.this$0.getContext());
                            }
                        } else {
                            if (i != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            if (firstItem != null) {
                                firstItem.coerceToHtmlText(this.this$0.getContext());
                            }
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Object[]) obj, (Promise) obj2);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters = moduleDefinitionBuilder.getConverters();
                AnyType anyType = (AnyType) AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(GetStringOptions.class), Boolean.FALSE));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(GetStringOptions.class), false, new Function0() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(GetStringOptions.class);
                        }
                    }), converters);
                }
                AnyType[] anyTypeArr = {anyType};
                Function1 function1 = new Function1() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        GetStringOptions getStringOptions = (GetStringOptions) objArr[0];
                        ClipboardModule clipboardModule = this.this$0;
                        ClipData.Item firstItem = clipboardModule.getFirstItem(clipboardModule.getClipboardManager());
                        int i = ClipboardModule.WhenMappings.$EnumSwitchMapping$0[getStringOptions.getPreferredFormat().ordinal()];
                        String strCoerceToPlainText = null;
                        if (i != 1) {
                            if (i != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            if (firstItem != null) {
                                strCoerceToPlainText = firstItem.coerceToHtmlText(this.this$0.getContext());
                            }
                        } else if (firstItem != null) {
                            strCoerceToPlainText = ClipboardModuleKt.coerceToPlainText(firstItem, this.this$0.getContext());
                        }
                        return strCoerceToPlainText == null ? "" : strCoerceToPlainText;
                    }
                };
                if (Intrinsics.areEqual(String.class, cls)) {
                    stringAsyncFunctionComponent = new IntAsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                } else if (Intrinsics.areEqual(String.class, cls4)) {
                    stringAsyncFunctionComponent = new BoolAsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                } else if (Intrinsics.areEqual(String.class, cls3)) {
                    stringAsyncFunctionComponent = new DoubleAsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                } else if (Intrinsics.areEqual(String.class, cls2)) {
                    stringAsyncFunctionComponent = new FloatAsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                } else {
                    stringAsyncFunctionComponent = Intrinsics.areEqual(String.class, String.class) ? new StringAsyncFunctionComponent("getStringAsync", anyTypeArr, function1) : new UntypedAsyncFunctionComponent("getStringAsync", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = stringAsyncFunctionComponent;
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("getStringAsync", asyncFunctionWithPromiseComponent);
            TypeConverterProvider converters2 = moduleDefinitionBuilder.getConverters();
            AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            Boolean bool = Boolean.FALSE;
            AnyType anyType2 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, bool));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters2);
            }
            AnyType anyType3 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(r2), bool));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SetStringOptions.class), false, new Function0() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(SetStringOptions.class);
                    }
                }), converters2);
            }
            AnyType[] anyTypeArr2 = {anyType2, anyType3};
            Function1 function2 = new Function1() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] objArr) {
                    ClipData clipDataNewPlainText;
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    String str = (String) objArr[0];
                    int i = ClipboardModule.WhenMappings.$EnumSwitchMapping$0[((SetStringOptions) objArr[1]).getInputFormat().ordinal()];
                    if (i == 1) {
                        clipDataNewPlainText = ClipData.newPlainText(null, str);
                    } else {
                        if (i != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        clipDataNewPlainText = ClipData.newHtmlText(null, ClipboardModuleKt.plainTextFromHtml(str), str);
                    }
                    this.this$0.getClipboardManager().setPrimaryClip(clipDataNewPlainText);
                    return Boolean.TRUE;
                }
            };
            if (Intrinsics.areEqual(Boolean.class, cls)) {
                stringAsyncFunctionComponent2 = new IntAsyncFunctionComponent("setStringAsync", anyTypeArr2, function2);
            } else if (Intrinsics.areEqual(Boolean.class, cls4)) {
                stringAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("setStringAsync", anyTypeArr2, function2);
            } else if (Intrinsics.areEqual(Boolean.class, cls3)) {
                stringAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("setStringAsync", anyTypeArr2, function2);
            } else if (Intrinsics.areEqual(Boolean.class, cls2)) {
                stringAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("setStringAsync", anyTypeArr2, function2);
            } else {
                stringAsyncFunctionComponent2 = Intrinsics.areEqual(Boolean.class, String.class) ? new StringAsyncFunctionComponent("setStringAsync", anyTypeArr2, function2) : new UntypedAsyncFunctionComponent("setStringAsync", anyTypeArr2, function2);
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("setStringAsync", stringAsyncFunctionComponent2);
            AnyType[] anyTypeArr3 = new AnyType[0];
            Function1 function3 = new Function1() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ClipDescription primaryClipDescription = this.this$0.getClipboardManager().getPrimaryClipDescription();
                    return Boolean.valueOf(primaryClipDescription != null ? ClipboardModuleKt.getHasTextContent(primaryClipDescription) : false);
                }
            };
            if (Intrinsics.areEqual(Boolean.class, cls)) {
                stringAsyncFunctionComponent3 = new IntAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function3);
            } else if (Intrinsics.areEqual(Boolean.class, cls4)) {
                stringAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function3);
            } else if (Intrinsics.areEqual(Boolean.class, cls3)) {
                stringAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function3);
            } else if (Intrinsics.areEqual(Boolean.class, cls2)) {
                stringAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function3);
            } else {
                stringAsyncFunctionComponent3 = Intrinsics.areEqual(Boolean.class, String.class) ? new StringAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function3) : new UntypedAsyncFunctionComponent("hasStringAsync", anyTypeArr3, function3);
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("hasStringAsync", stringAsyncFunctionComponent3);
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction = moduleDefinitionBuilder.AsyncFunction("getImageAsync");
            String name = asyncFunctionBuilderAsyncFunction.getName();
            TypeConverterProvider converters3 = asyncFunctionBuilderAsyncFunction.getConverters();
            AnyType anyType4 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(r0), bool));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(GetImageOptions.class), false, new Function0() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$Coroutine$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(GetImageOptions.class);
                    }
                }), converters3);
            }
            asyncFunctionBuilderAsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(name, new AnyType[]{anyType4}, new ClipboardModule$definition$lambda$12$$inlined$Coroutine$2(null, this)));
            AsyncFunctionBuilder asyncFunctionBuilderAsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("setImageAsync");
            String name2 = asyncFunctionBuilderAsyncFunction2.getName();
            TypeConverterProvider converters4 = asyncFunctionBuilderAsyncFunction2.getConverters();
            AnyType anyType5 = (AnyType) anyTypeProvider.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(r13), bool));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(r13), false, new Function0() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$Coroutine$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters4);
            }
            asyncFunctionBuilderAsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(name2, new AnyType[]{anyType5}, new ClipboardModule$definition$lambda$12$$inlined$Coroutine$4(null, this)));
            AnyType[] anyTypeArr4 = new AnyType[0];
            Function1 function4 = new Function1() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ClipDescription primaryClipDescription = this.this$0.getClipboardManager().getPrimaryClipDescription();
                    boolean z = false;
                    if (primaryClipDescription != null && primaryClipDescription.hasMimeType("image/*")) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            };
            if (Intrinsics.areEqual(Boolean.class, cls)) {
                stringAsyncFunctionComponent4 = new IntAsyncFunctionComponent("hasImageAsync", anyTypeArr4, function4);
            } else if (Intrinsics.areEqual(Boolean.class, cls4)) {
                stringAsyncFunctionComponent4 = new BoolAsyncFunctionComponent("hasImageAsync", anyTypeArr4, function4);
            } else if (Intrinsics.areEqual(Boolean.class, cls3)) {
                stringAsyncFunctionComponent4 = new DoubleAsyncFunctionComponent("hasImageAsync", anyTypeArr4, function4);
            } else if (Intrinsics.areEqual(Boolean.class, cls2)) {
                stringAsyncFunctionComponent4 = new FloatAsyncFunctionComponent("hasImageAsync", anyTypeArr4, function4);
            } else {
                stringAsyncFunctionComponent4 = Intrinsics.areEqual(Boolean.class, String.class) ? new StringAsyncFunctionComponent("hasImageAsync", anyTypeArr4, function4) : new UntypedAsyncFunctionComponent("hasImageAsync", anyTypeArr4, function4);
            }
            moduleDefinitionBuilder.getAsyncFunctions().put("hasImageAsync", stringAsyncFunctionComponent4);
            moduleDefinitionBuilder.Events("onClipboardChanged");
            Map eventListeners = moduleDefinitionBuilder.getEventListeners();
            EventName eventName = EventName.MODULE_CREATE;
            eventListeners.put(eventName, new BasicEventListener(eventName, new Function0() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m4874invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m4874invoke() {
                    ClipboardModule clipboardModule = this.this$0;
                    clipboardModule.clipboardEventEmitter = clipboardModule.new ClipboardEventEmitter();
                    ClipboardModule.ClipboardEventEmitter clipboardEventEmitter = this.this$0.clipboardEventEmitter;
                    if (clipboardEventEmitter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipboardEventEmitter");
                        clipboardEventEmitter = null;
                    }
                    clipboardEventEmitter.attachListener();
                }
            }));
            Map eventListeners2 = moduleDefinitionBuilder.getEventListeners();
            EventName eventName2 = EventName.MODULE_DESTROY;
            eventListeners2.put(eventName2, new BasicEventListener(eventName2, new Function0() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m4875invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m4875invoke() {
                    ClipboardModule.ClipboardEventEmitter clipboardEventEmitter = this.this$0.clipboardEventEmitter;
                    if (clipboardEventEmitter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipboardEventEmitter");
                        clipboardEventEmitter = null;
                    }
                    clipboardEventEmitter.detachListener();
                }
            }));
            Map eventListeners3 = moduleDefinitionBuilder.getEventListeners();
            EventName eventName3 = EventName.ACTIVITY_ENTERS_BACKGROUND;
            eventListeners3.put(eventName3, new BasicEventListener(eventName3, new Function0() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$OnActivityEntersBackground$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m4872invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m4872invoke() {
                    ClipboardModule.ClipboardEventEmitter clipboardEventEmitter = this.this$0.clipboardEventEmitter;
                    if (clipboardEventEmitter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipboardEventEmitter");
                        clipboardEventEmitter = null;
                    }
                    clipboardEventEmitter.pauseListening();
                }
            }));
            Map eventListeners4 = moduleDefinitionBuilder.getEventListeners();
            EventName eventName4 = EventName.ACTIVITY_ENTERS_FOREGROUND;
            eventListeners4.put(eventName4, new BasicEventListener(eventName4, new Function0() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$OnActivityEntersForeground$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m4873invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m4873invoke() {
                    ClipboardModule.ClipboardEventEmitter clipboardEventEmitter = this.this$0.clipboardEventEmitter;
                    if (clipboardEventEmitter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipboardEventEmitter");
                        clipboardEventEmitter = null;
                    }
                    clipboardEventEmitter.resumeListening();
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new IllegalArgumentException("React Application Context is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClipboardManager getClipboardManager() throws ClipboardUnavailableException {
        Object systemService = getContext().getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager != null) {
            return clipboardManager;
        }
        throw new ClipboardUnavailableException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getClipboardCacheDir() {
        return (File) this.clipboardCacheDir.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File clipboardCacheDir_delegate$lambda$15(ClipboardModule clipboardModule) {
        File file = new File(clipboardModule.getContext().getCacheDir(), ".clipboard");
        file.mkdirs();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class ClipboardEventEmitter {
        private final ClipboardManager.OnPrimaryClipChangedListener listener;
        private final ClipboardManager maybeClipboardManager;
        private boolean isListening = true;
        private long timestamp = -1;

        public ClipboardEventEmitter() {
            Object objM5243constructorimpl;
            this.listener = new ClipboardManager.OnPrimaryClipChangedListener() { // from class: expo.modules.clipboard.ClipboardModule$ClipboardEventEmitter$$ExternalSyntheticLambda0
                @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
                public final void onPrimaryClipChanged() {
                    ClipboardModule.ClipboardEventEmitter.listener$lambda$7(clipboardModule, this);
                }
            };
            try {
                Result.Companion companion = Result.Companion;
                objM5243constructorimpl = Result.m5243constructorimpl(ClipboardModule.this.getClipboardManager());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
            }
            this.maybeClipboardManager = (ClipboardManager) (Result.m5248isFailureimpl(objM5243constructorimpl) ? null : objM5243constructorimpl);
        }

        public final void resumeListening() {
            this.isListening = true;
        }

        public final void pauseListening() {
            this.isListening = false;
        }

        public final Object attachListener() {
            Unit unit;
            ClipboardManager clipboardManager = this.maybeClipboardManager;
            if (clipboardManager != null) {
                clipboardManager.addPrimaryClipChangedListener(this.listener);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            return unit == null ? Integer.valueOf(Log.e(ClipboardModuleKt.TAG, "'CLIPBOARD_SERVICE' unavailable. Events won't be received")) : unit;
        }

        public final Unit detachListener() {
            ClipboardManager clipboardManager = this.maybeClipboardManager;
            if (clipboardManager == null) {
                return null;
            }
            clipboardManager.removePrimaryClipChangedListener(this.listener);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void listener$lambda$7(ClipboardModule clipboardModule, ClipboardEventEmitter clipboardEventEmitter) {
            ClipDescription primaryClipDescription;
            if (clipboardModule.getAppContext().getHasActiveReactInstance()) {
                ClipboardManager clipboardManager = clipboardEventEmitter.maybeClipboardManager;
                if (!clipboardEventEmitter.isListening) {
                    clipboardManager = null;
                }
                if (clipboardManager == null || (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    if (clipboardEventEmitter.timestamp == primaryClipDescription.getTimestamp()) {
                        return;
                    } else {
                        clipboardEventEmitter.timestamp = primaryClipDescription.getTimestamp();
                    }
                }
                ContentType contentType = ContentType.PLAIN_TEXT;
                if (!ClipboardModuleKt.getHasTextContent(primaryClipDescription)) {
                    contentType = null;
                }
                ContentType contentType2 = ContentType.HTML;
                if (!primaryClipDescription.hasMimeType("text/html")) {
                    contentType2 = null;
                }
                List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new ContentType[]{contentType, contentType2, primaryClipDescription.hasMimeType("image/*") ? ContentType.IMAGE : null});
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOfNotNull, 10));
                Iterator it = listListOfNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add(((ContentType) it.next()).getJsName());
                }
                clipboardModule.sendEvent("onClipboardChanged", BundleKt.bundleOf(TuplesKt.to("contentTypes", arrayList)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean clipboardHasItemWithType(String mimeType) {
        ClipDescription primaryClipDescription = getClipboardManager().getPrimaryClipDescription();
        if (primaryClipDescription != null) {
            return primaryClipDescription.hasMimeType(mimeType);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClipData.Item getFirstItem(ClipboardManager clipboardManager) {
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        if (primaryClip != null) {
            if (primaryClip.getItemCount() <= 0) {
                primaryClip = null;
            }
            if (primaryClip != null) {
                return primaryClip.getItemAt(0);
            }
        }
        return null;
    }
}
