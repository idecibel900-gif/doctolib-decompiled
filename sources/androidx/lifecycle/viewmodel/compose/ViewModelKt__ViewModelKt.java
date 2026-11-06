package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
abstract /* synthetic */ class ViewModelKt__ViewModelKt {
    public static final ViewModel viewModel(KClass modelClass, ViewModelStoreOwner viewModelStoreOwner, String str, ViewModelProvider.Factory factory, CreationExtras creationExtras, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        composer.startReplaceableGroup(1673618944);
        if ((i2 & 2) != 0 && (viewModelStoreOwner = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 6)) == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        if ((i2 & 8) != 0) {
            factory = null;
        }
        if ((i2 & 16) != 0) {
            if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras();
            } else {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1673618944, i, -1, "androidx.lifecycle.viewmodel.compose.viewModel (ViewModel.kt:102)");
        }
        ViewModel viewModel = ViewModelKt.get(viewModelStoreOwner, modelClass, str, factory, creationExtras);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return viewModel;
    }

    public static final ViewModel get(ViewModelStoreOwner viewModelStoreOwner, KClass modelClass, String str, ViewModelProvider.Factory factory, CreationExtras extras) {
        ViewModelProvider viewModelProviderCreate$default;
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "<this>");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (factory != null) {
            viewModelProviderCreate$default = ViewModelProvider.Companion.create(viewModelStoreOwner.getViewModelStore(), factory, extras);
        } else if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
            viewModelProviderCreate$default = ViewModelProvider.Companion.create(viewModelStoreOwner.getViewModelStore(), ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory(), extras);
        } else {
            viewModelProviderCreate$default = ViewModelProvider.Companion.create$default(ViewModelProvider.Companion, viewModelStoreOwner, null, null, 6, null);
        }
        if (str != null) {
            return viewModelProviderCreate$default.get(str, modelClass);
        }
        return viewModelProviderCreate$default.get(modelClass);
    }
}
