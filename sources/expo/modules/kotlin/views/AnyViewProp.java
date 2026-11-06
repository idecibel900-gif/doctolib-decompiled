package expo.modules.kotlin.views;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.types.AnyType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AnyViewProp {
    private final String name;
    private final AnyType type;

    public abstract void set(Dynamic dynamic, View view, AppContext appContext);

    public AnyViewProp(String name, AnyType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.name = name;
        this.type = type;
    }

    public final String getName() {
        return this.name;
    }

    public final AnyType getType$expo_modules_core_release() {
        return this.type;
    }
}
