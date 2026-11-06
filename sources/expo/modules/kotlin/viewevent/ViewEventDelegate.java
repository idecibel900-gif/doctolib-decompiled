package expo.modules.kotlin.viewevent;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewEventDelegate {
    private final Function1 coalescingKey;
    private final WeakReference viewHolder;

    public ViewEventDelegate(View view, Function1 function1) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.coalescingKey = function1;
        this.viewHolder = new WeakReference(view);
    }

    public final ViewEventCallback getValue(KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        View view = (View) this.viewHolder.get();
        if (view == null) {
            throw new IllegalStateException("Can't send the '" + property.getName() + "' event from the view that is deallocated");
        }
        return new ViewEvent(property.getName(), view, this.coalescingKey);
    }

    public final ViewEventCallback getValue(View thisRef, KProperty property) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        return getValue(property);
    }
}
