package io.didomi.ssl;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import io.didomi.ssl.vendors.ctv.model.TVDataProcessingLegalType;
import io.didomi.ssl.view.ctv.CenterLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u001d¨\u0006\""}, d2 = {"Lio/didomi/sdk/ye;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "context", "", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onDestroyView", "Lio/didomi/sdk/c3;", "a", "Lio/didomi/sdk/c3;", "binding", "Lio/didomi/sdk/ug;", "b", "Lio/didomi/sdk/ug;", "()Lio/didomi/sdk/ug;", "setModel", "(Lio/didomi/sdk/ug;)V", "model", "Lio/didomi/sdk/vendors/ctv/model/TVDataProcessingLegalType;", "()Lio/didomi/sdk/vendors/ctv/model/TVDataProcessingLegalType;", "vendorLegalType", "<init>", "()V", "c", "android_release"}, k = 1, mv = {1, 8, 0})
public final class ye extends Fragment {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private c3 binding;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public ug model;

    /* JADX INFO: renamed from: io.didomi.sdk.ye$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lio/didomi/sdk/ye$a;", "", "Lio/didomi/sdk/vendors/ctv/model/TVDataProcessingLegalType;", "vendorLegalType", "Lio/didomi/sdk/ye;", "a", "", "DATA_PROCESSING_TYPE", "Ljava/lang/String;", "TAG", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ye a(TVDataProcessingLegalType vendorLegalType) {
            Intrinsics.checkNotNullParameter(vendorLegalType, "vendorLegalType");
            ye yeVar = new ye();
            Bundle bundle = new Bundle();
            bundle.putString("DATA_PROCESSING_TYPE", vendorLegalType.toString());
            yeVar.setArguments(bundle);
            return yeVar;
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

    private final TVDataProcessingLegalType b() {
        String string;
        TVDataProcessingLegalType tVDataProcessingLegalTypeValueOf;
        Bundle arguments = getArguments();
        return (arguments == null || (string = arguments.getString("DATA_PROCESSING_TYPE")) == null || (tVDataProcessingLegalTypeValueOf = TVDataProcessingLegalType.valueOf(string)) == null) ? TVDataProcessingLegalType.CONSENT : tVDataProcessingLegalTypeValueOf;
    }

    public final ug a() {
        ug ugVar = this.model;
        if (ugVar != null) {
            return ugVar;
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
        c3 c3VarA = c3.a(getLayoutInflater(), parent, false);
        this.binding = c3VarA;
        FrameLayout root = c3VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(layoutInflater, …g = it\n            }.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView;
        super.onDestroyView();
        c3 c3Var = this.binding;
        if (c3Var != null && (recyclerView = c3Var.b) != null) {
            recyclerView.setAdapter(null);
            recyclerView.setLayoutManager(null);
            recyclerView.setOnKeyListener(null);
        }
        this.binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        final RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        c3 c3Var = this.binding;
        if (c3Var == null || (recyclerView = c3Var.b) == null) {
            return;
        }
        recyclerView.setAdapter(new ve(a().a(b())));
        recyclerView.setItemAnimator(null);
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        recyclerView.setLayoutManager(new CenterLayoutManager(context, 1, false));
        recyclerView.addItemDecoration(new g6(recyclerView, false, new b(recyclerView), 2, null));
        recyclerView.setHasFixedSize(true);
        recyclerView.setOnKeyListener(new View.OnKeyListener() { // from class: io.didomi.sdk.ye$$ExternalSyntheticLambda0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i, KeyEvent keyEvent) {
                return ye.a(view, recyclerView, view2, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(View view, RecyclerView this_apply, View view2, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.didomi_tv_preferences_delta_scroll);
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
