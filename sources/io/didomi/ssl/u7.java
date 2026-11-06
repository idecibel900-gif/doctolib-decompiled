package io.didomi.ssl;

import android.graphics.Bitmap;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b+\u0010,J\u0013\u0010\u0003\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J2\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0002JD\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0003\u0010\u001cR\u001b\u0010!\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u0013\u0010 R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020&0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lio/didomi/sdk/u7;", "", "", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "onBitmap", "Lkotlin/Function0;", "onNoLogo", "", "onResource", "(Landroidx/lifecycle/LifecycleOwner;)V", "Lio/didomi/sdk/e0;", "Lio/didomi/sdk/e0;", "configurationRepository", "Lio/didomi/sdk/x6;", "b", "Lio/didomi/sdk/x6;", "imageUrlLoader", "Lkotlinx/coroutines/CoroutineDispatcher;", "c", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "d", "Lkotlin/Lazy;", "()I", "logoResourceId", "", "e", "()Ljava/lang/String;", "logoUrl", "Landroidx/lifecycle/MutableLiveData;", "f", "Landroidx/lifecycle/MutableLiveData;", "logoBitmapLiveData", "", "g", "noLogoLiveData", "Lio/didomi/sdk/v0;", "contextHelper", "<init>", "(Lio/didomi/sdk/e0;Lio/didomi/sdk/v0;Lio/didomi/sdk/x6;Lkotlinx/coroutines/CoroutineDispatcher;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class u7 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final e0 configurationRepository;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final x6 imageUrlLoader;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final CoroutineDispatcher coroutineDispatcher;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Lazy logoResourceId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final Lazy logoUrl;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final MutableLiveData logoBitmapLiveData;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final MutableLiveData noLogoLiveData;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.didomi.sdk.resources.LogoProvider", f = "LogoProvider.kt", l = {65}, m = "loadLogoFromUrl")
    static final class a extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        int d;

        a(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= LinearLayoutManager.INVALID_OFFSET;
            return u7.this.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0 {
        final /* synthetic */ v0 a;
        final /* synthetic */ u7 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(v0 v0Var, u7 u7Var) {
            super(0);
            this.a = v0Var;
            this.b = u7Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(this.a.a(this.b.configurationRepository.b().getApp().getLogoUrl()));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0 {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return u7.this.configurationRepository.b().getApp().getLogoUrl();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "noLogo", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 8, 0})
    static final class d extends Lambda implements Function1 {
        final /* synthetic */ Function0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Function0 function0) {
            super(1);
            this.a = function0;
        }

        public final void a(Boolean bool) {
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                this.a.invoke();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Boolean) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "io.didomi.sdk.resources.LogoProvider$updateLogo$2", f = "LogoProvider.kt", l = {56}, m = "invokeSuspend")
    static final class e extends SuspendLambda implements Function2 {
        int a;

        e(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return u7.this.new e(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                u7 u7Var = u7.this;
                this.a = 1;
                if (u7Var.a(this) == coroutine_suspended) {
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

    public u7(e0 configurationRepository, v0 contextHelper, x6 imageUrlLoader, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(configurationRepository, "configurationRepository");
        Intrinsics.checkNotNullParameter(contextHelper, "contextHelper");
        Intrinsics.checkNotNullParameter(imageUrlLoader, "imageUrlLoader");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.configurationRepository = configurationRepository;
        this.imageUrlLoader = imageUrlLoader;
        this.coroutineDispatcher = coroutineDispatcher;
        this.logoResourceId = LazyKt.lazy(new b(contextHelper, this));
        this.logoUrl = LazyKt.lazy(new c());
        this.logoBitmapLiveData = new MutableLiveData();
        this.noLogoLiveData = new MutableLiveData();
    }

    private final String b() {
        return (String) this.logoUrl.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final int a() {
        return ((Number) this.logoResourceId.getValue()).intValue();
    }

    public final Object a(LifecycleOwner lifecycleOwner, Function1 onBitmap, Function1 onResource, Function0 onNoLogo) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(onBitmap, "onBitmap");
        Intrinsics.checkNotNullParameter(onResource, "onResource");
        Intrinsics.checkNotNullParameter(onNoLogo, "onNoLogo");
        if (a() != 0) {
            onResource.invoke(Integer.valueOf(a()));
            return Unit.INSTANCE;
        }
        Bitmap bitmap = (Bitmap) this.logoBitmapLiveData.getValue();
        if (bitmap != null) {
            onBitmap.invoke(bitmap);
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(this.noLogoLiveData.getValue(), Boolean.TRUE)) {
            onNoLogo.invoke();
            return Unit.INSTANCE;
        }
        if (fc.b(b())) {
            a(lifecycleOwner, onBitmap, onNoLogo);
            return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.coroutineDispatcher), null, null, new e(null), 3, null);
        }
        onNoLogo.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Continuation continuation) {
        a aVar;
        u7 u7Var;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.d;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                aVar.d = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objB = aVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objB);
            x6 x6Var = this.imageUrlLoader;
            x6.Param param = new x6.Param(b());
            aVar.a = this;
            aVar.d = 1;
            objB = x6Var.b(param, aVar);
            if (objB == coroutine_suspended) {
                return coroutine_suspended;
            }
            u7Var = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u7Var = (u7) aVar.a;
            ResultKt.throwOnFailure(objB);
        }
        a0 a0Var = (a0) objB;
        if (a0Var.c()) {
            Log.e$default("Error loading logo from " + u7Var.b(), null, 2, null);
            u7Var.noLogoLiveData.postValue(Boxing.boxBoolean(true));
        } else {
            u7Var.logoBitmapLiveData.postValue(a0Var.b());
        }
        return Unit.INSTANCE;
    }

    private final void a(LifecycleOwner lifecycleOwner, final Function1 onBitmap, Function0 onNoLogo) {
        this.logoBitmapLiveData.observe(lifecycleOwner, new Observer() { // from class: io.didomi.sdk.u7$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u7.a(onBitmap, obj);
            }
        });
        MutableLiveData mutableLiveData = this.noLogoLiveData;
        final d dVar = new d(onNoLogo);
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: io.didomi.sdk.u7$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                u7.b(dVar, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void a(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.logoBitmapLiveData.removeObservers(lifecycleOwner);
        this.noLogoLiveData.removeObservers(lifecycleOwner);
    }
}
