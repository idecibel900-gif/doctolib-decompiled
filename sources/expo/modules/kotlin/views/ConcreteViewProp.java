package expo.modules.kotlin.views;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.PropSetException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.types.AnyType;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
public class ConcreteViewProp extends AnyViewProp {
    private final boolean isNullable;
    private final Function2 setter;

    protected final Function2 getSetter() {
        return this.setter;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcreteViewProp(String name, AnyType propType, Function2 setter) {
        super(name, propType);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(propType, "propType");
        Intrinsics.checkNotNullParameter(setter, "setter");
        this.setter = setter;
        this.isNullable = propType.getKType().isMarkedNullable();
    }

    @Override // expo.modules.kotlin.views.AnyViewProp
    public void set(Dynamic prop, View onView, AppContext appContext) throws PropSetException {
        CodedException unexpectedException;
        Intrinsics.checkNotNullParameter(prop, "prop");
        Intrinsics.checkNotNullParameter(onView, "onView");
        try {
            getSetter().invoke(onView, AnyType.convert$default(getType$expo_modules_core_release(), prop, appContext, false, 4, null));
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            if (th instanceof CodedException) {
                unexpectedException = (CodedException) th;
            } else if (th instanceof expo.modules.core.errors.CodedException) {
                expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                String code = codedException.getCode();
                Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                unexpectedException = new CodedException(code, codedException.getMessage(), codedException.getCause());
            } else {
                unexpectedException = new UnexpectedException(th);
            }
            throw new PropSetException(getName(), Reflection.getOrCreateKotlinClass(onView.getClass()), unexpectedException);
        }
    }
}
