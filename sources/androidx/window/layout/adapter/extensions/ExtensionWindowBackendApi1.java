package androidx.window.layout.adapter.extensions;

import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.WindowBackend;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class ExtensionWindowBackendApi1 implements WindowBackend {
    private final WindowLayoutComponent component;
    private final ConsumerAdapter consumerAdapter;
    private final Map consumerToToken;
    private final Map contextToListeners;
    private final ReentrantLock globalLock;
    private final Map listenerToContext;

    public ExtensionWindowBackendApi1(WindowLayoutComponent component, ConsumerAdapter consumerAdapter) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(consumerAdapter, "consumerAdapter");
        this.component = component;
        this.consumerAdapter = consumerAdapter;
        this.globalLock = new ReentrantLock();
        this.contextToListeners = new LinkedHashMap();
        this.listenerToContext = new LinkedHashMap();
        this.consumerToToken = new LinkedHashMap();
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void registerLayoutChangeCallback(Context context, Executor executor, Consumer callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ReentrantLock reentrantLock = this.globalLock;
        reentrantLock.lock();
        try {
            MulticastConsumer multicastConsumer = (MulticastConsumer) this.contextToListeners.get(context);
            if (multicastConsumer != null) {
                multicastConsumer.addListener(callback);
                this.listenerToContext.put(callback, context);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                MulticastConsumer multicastConsumer2 = new MulticastConsumer(context);
                this.contextToListeners.put(context, multicastConsumer2);
                this.listenerToContext.put(callback, context);
                multicastConsumer2.addListener(callback);
                if (context instanceof Activity) {
                    this.consumerToToken.put(multicastConsumer2, this.consumerAdapter.createSubscription(this.component, Reflection.getOrCreateKotlinClass(WindowLayoutInfo.class), "addWindowLayoutInfoListener", "removeWindowLayoutInfoListener", (Activity) context, new ExtensionWindowBackendApi1$registerLayoutChangeCallback$1$2$disposableToken$1(multicastConsumer2)));
                } else {
                    multicastConsumer2.accept(new WindowLayoutInfo(CollectionsKt.emptyList()));
                    return;
                }
            }
            Unit unit2 = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void unregisterLayoutChangeCallback(Consumer callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ReentrantLock reentrantLock = this.globalLock;
        reentrantLock.lock();
        try {
            Context context = (Context) this.listenerToContext.get(callback);
            if (context == null) {
                return;
            }
            MulticastConsumer multicastConsumer = (MulticastConsumer) this.contextToListeners.get(context);
            if (multicastConsumer == null) {
                return;
            }
            multicastConsumer.removeListener(callback);
            this.listenerToContext.remove(callback);
            if (multicastConsumer.isEmpty()) {
                this.contextToListeners.remove(context);
                ConsumerAdapter.Subscription subscription = (ConsumerAdapter.Subscription) this.consumerToToken.remove(multicastConsumer);
                if (subscription != null) {
                    subscription.dispose();
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }
}
