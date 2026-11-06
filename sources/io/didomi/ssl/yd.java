package io.didomi.ssl;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lio/didomi/sdk/yd;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "context", "", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onDestroyView", "Lio/didomi/sdk/ee;", "a", "Lio/didomi/sdk/ee;", "()Lio/didomi/sdk/ee;", "setModel", "(Lio/didomi/sdk/ee;)V", "model", "Lio/didomi/sdk/z2;", "b", "Lio/didomi/sdk/z2;", "binding", "<init>", "()V", "c", "android_release"}, k = 1, mv = {1, 8, 0})
public final class yd extends Fragment {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public ee model;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private z2 binding;

    /* JADX INFO: renamed from: io.didomi.sdk.yd$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/yd$a;", "", "Lio/didomi/sdk/Purpose;", "purpose", "Lio/didomi/sdk/gi;", "listType", "Lio/didomi/sdk/yd;", "a", "", "KEY_INFO_TYPE", "Ljava/lang/String;", "KEY_PURPOSE", "TAG", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final yd a(Purpose purpose, gi listType) {
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            Intrinsics.checkNotNullParameter(listType, "listType");
            yd ydVar = new yd();
            Bundle bundle = new Bundle();
            bundle.putParcelable("purpose", purpose);
            bundle.putInt("info_type", listType.ordinal());
            ydVar.setArguments(bundle);
            return ydVar;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(I)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function1 {
        final /* synthetic */ RecyclerView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(RecyclerView recyclerView) {
            super(1);
            this.a = recyclerView;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0010  */
        public final Boolean a(int i) {
            boolean z;
            RecyclerView.Adapter adapter = this.a.getAdapter();
            if (adapter != null) {
                z = adapter.getItemViewType(i) == 1;
            }
            return Boolean.valueOf(z);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public final ee a() {
        ee eeVar = this.model;
        if (eeVar != null) {
            return eeVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Didomi.INSTANCE.getInstance().getComponent$android_release().a(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        z2 z2VarA = z2.a(inflater, parent, false);
        this.binding = z2VarA;
        FrameLayout root = z2VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, parent…g = it\n            }.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView;
        super.onDestroyView();
        z2 z2Var = this.binding;
        if (z2Var != null && (recyclerView = z2Var.b) != null) {
            recyclerView.setAdapter(null);
            recyclerView.setLayoutManager(null);
            recyclerView.setOnKeyListener(null);
        }
        this.binding = null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002d  */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Purpose purpose;
        final RecyclerView recyclerView;
        int i;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (Build.VERSION.SDK_INT >= 33) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                purpose = (Purpose) arguments.getParcelable("purpose", Purpose.class);
            } else {
                purpose = null;
            }
        } else {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                purpose = (Purpose) arguments2.getParcelable("purpose");
            } else {
                purpose = null;
            }
        }
        Bundle arguments3 = getArguments();
        gi giVar = (arguments3 == null || (i = arguments3.getInt("info_type")) >= gi.values().length) ? null : gi.values()[i];
        if (purpose == null || giVar == null) {
            throw new IllegalArgumentException("Missing purpose or info_type parameter");
        }
        a().a(purpose, giVar);
        z2 z2Var = this.binding;
        if (z2Var == null || (recyclerView = z2Var.b) == null) {
            return;
        }
        ee eeVarA = a();
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        recyclerView.setAdapter(new vd(eeVarA.b(context)));
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.addItemDecoration(new g6(recyclerView, false, new b(recyclerView), 2, null));
        recyclerView.setHasFixedSize(true);
        recyclerView.setOnKeyListener(new View.OnKeyListener() { // from class: io.didomi.sdk.yd$$ExternalSyntheticLambda0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i2, KeyEvent keyEvent) {
                return yd.a(recyclerView, view2, i2, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(RecyclerView this_apply, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        int dimensionPixelSize = this_apply.getResources().getDimensionPixelSize(R.dimen.didomi_tv_preferences_delta_scroll);
        if (keyEvent.getAction() == 1) {
            if (i == 19) {
                this_apply.smoothScrollBy(0, -dimensionPixelSize);
                return true;
            }
            if (i == 20) {
                this_apply.smoothScrollBy(0, dimensionPixelSize);
                return true;
            }
        }
        return false;
    }
}
