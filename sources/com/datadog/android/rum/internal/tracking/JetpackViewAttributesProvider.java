package com.datadog.android.rum.internal.tracking;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.datadog.android.internal.utils.NumberExtKt;
import com.datadog.android.rum.tracking.ViewAttributesProvider;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class JetpackViewAttributesProvider implements ViewAttributesProvider {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.datadog.android.rum.tracking.ViewAttributesProvider
    public void extractAttributes(View view, Map attributes) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        for (ViewParent parent = view.getParent(); parent != 0; parent = parent.getParent()) {
            if ((parent instanceof RecyclerView) && view != null && isDirectChildOfRecyclerView(view)) {
                attributes.put("action.target.parent.index", Integer.valueOf(((RecyclerView) parent).getChildAdapterPosition(view)));
                attributes.put("action.target.parent.classname", parent.getClass().getCanonicalName());
                attributes.put("action.target.parent.resource_id", resolveIdOrResourceName((View) parent));
                return;
            }
            view = parent instanceof View ? (View) parent : null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return Intrinsics.areEqual(JetpackViewAttributesProvider.class, obj != null ? obj.getClass() : null);
    }

    public int hashCode() {
        return JetpackViewAttributesProvider.class.hashCode();
    }

    private final boolean isDirectChildOfRecyclerView(View view) {
        return view.getLayoutParams() instanceof RecyclerView.LayoutParams;
    }

    private final String resolveIdOrResourceName(View view) {
        try {
            String resourceEntryName = view.getResources().getResourceEntryName(view.getId());
            return resourceEntryName == null ? viewIdAsHexa(view) : resourceEntryName;
        } catch (Resources.NotFoundException unused) {
            return viewIdAsHexa(view);
        }
    }

    private final String viewIdAsHexa(View view) {
        return "0x" + NumberExtKt.toHexString(view.getId());
    }
}
