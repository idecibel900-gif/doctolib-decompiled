package com.facebook.react.devsupport;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.common.logging.FLog;
import com.facebook.react.R$id;
import com.facebook.react.R$layout;
import com.facebook.react.devsupport.inspector.DevSupportHttpClient;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.StackFrame;
import java.util.concurrent.Executor;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class RedBoxContentView extends LinearLayout implements AdapterView.OnItemClickListener {
    private final DevSupportManager devSupportManager;
    private final View.OnClickListener reportButtonOnClickListener;
    private final RedBoxHandler.ReportCompletedListener reportCompletedListener;
    private ListView stackView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RedBoxContentView(Context context, DevSupportManager devSupportManager, RedBoxHandler redBoxHandler) {
        super(context);
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.devSupportManager = devSupportManager;
        this.reportCompletedListener = new RedBoxHandler.ReportCompletedListener() { // from class: com.facebook.react.devsupport.RedBoxContentView$reportCompletedListener$1
        };
        this.reportButtonOnClickListener = new View.OnClickListener() { // from class: com.facebook.react.devsupport.RedBoxContentView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.getClass();
            }
        };
    }

    private static final class StackAdapter extends BaseAdapter {
        public static final Companion Companion = new Companion(null);
        private final StackFrame[] stack;
        private final String title;

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return i == 0 ? 0 : 1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            return i > 0;
        }

        private static final class FrameViewHolder {
            private final TextView fileView;
            private final TextView methodView;

            public FrameViewHolder(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                View viewFindViewById = v.findViewById(R$id.rn_frame_method);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                this.methodView = (TextView) viewFindViewById;
                View viewFindViewById2 = v.findViewById(R$id.rn_frame_file);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.fileView = (TextView) viewFindViewById2;
            }

            public final TextView getMethodView() {
                return this.methodView;
            }

            public final TextView getFileView() {
                return this.fileView;
            }
        }

        public StackAdapter(String title, StackFrame[] stack) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(stack, "stack");
            this.title = title;
            this.stack = stack;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.stack.length + 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return i == 0 ? this.title : this.stack[i - 1];
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup parent) {
            TextView textView;
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i == 0) {
                if (view != null) {
                    textView = (TextView) view;
                } else {
                    View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.redbox_item_title, parent, false);
                    Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
                    textView = (TextView) viewInflate;
                }
                textView.setText(new Regex("\\x1b\\[[0-9;]*m").replace(this.title, ""));
                return textView;
            }
            if (view == null) {
                view = LayoutInflater.from(parent.getContext()).inflate(R$layout.redbox_item_frame, parent, false);
                Intrinsics.checkNotNull(view);
                view.setTag(new FrameViewHolder(view));
            }
            StackFrame stackFrame = this.stack[i - 1];
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.facebook.react.devsupport.RedBoxContentView.StackAdapter.FrameViewHolder");
            FrameViewHolder frameViewHolder = (FrameViewHolder) tag;
            frameViewHolder.getMethodView().setText(stackFrame.getMethod());
            frameViewHolder.getFileView().setText(StackTraceHelper.INSTANCE.formatFrameSource(stackFrame));
            frameViewHolder.getMethodView().setTextColor(stackFrame.isCollapsed() ? -5592406 : -1);
            frameViewHolder.getFileView().setTextColor(stackFrame.isCollapsed() ? -8355712 : -5000269);
            return view;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    private static final class OpenStackFrameTask extends AsyncTask {
        public static final Companion Companion = new Companion(null);
        private static final MediaType JSON = MediaType.INSTANCE.m5590deprecated_parse("application/json; charset=utf-8");
        private final DevSupportManager devSupportManager;

        public OpenStackFrameTask(DevSupportManager devSupportManager) {
            Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
            this.devSupportManager = devSupportManager;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(StackFrame... stackFrames) {
            Intrinsics.checkNotNullParameter(stackFrames, "stackFrames");
            try {
                String string = Uri.parse(this.devSupportManager.getSourceUrl()).buildUpon().path("/open-stack-frame").query(null).build().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                OkHttpClient httpClient$ReactAndroid_release = DevSupportHttpClient.INSTANCE.getHttpClient$ReactAndroid_release();
                for (StackFrame stackFrame : stackFrames) {
                    Companion companion = Companion;
                    if (stackFrame == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    String string2 = companion.stackFrameToJson(stackFrame).toString();
                    Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                    httpClient$ReactAndroid_release.newCall(new Request.Builder().url(string).post(RequestBody.INSTANCE.create(JSON, string2)).build()).execute();
                }
            } catch (Exception e) {
                FLog.e("ReactNative", "Could not open stack frame", e);
            }
            return null;
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final JSONObject stackFrameToJson(StackFrame stackFrame) {
                return new JSONObject(MapsKt.mapOf(TuplesKt.to("file", stackFrame.getFile()), TuplesKt.to("methodName", stackFrame.getMethod()), TuplesKt.to("lineNumber", Integer.valueOf(stackFrame.getLine())), TuplesKt.to("column", Integer.valueOf(stackFrame.getColumn()))));
            }
        }
    }

    public final void init() {
        LayoutInflater.from(getContext()).inflate(R$layout.redbox_view, this);
        ListView listView = (ListView) findViewById(R$id.rn_redbox_stack);
        listView.setOnItemClickListener(this);
        this.stackView = listView;
        ((Button) findViewById(R$id.rn_redbox_reload_button)).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.react.devsupport.RedBoxContentView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RedBoxContentView.init$lambda$2(this.f$0, view);
            }
        });
        ((Button) findViewById(R$id.rn_redbox_dismiss_button)).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.react.devsupport.RedBoxContentView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RedBoxContentView.init$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2(RedBoxContentView redBoxContentView, View view) {
        redBoxContentView.devSupportManager.handleReloadJS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$3(RedBoxContentView redBoxContentView, View view) {
        redBoxContentView.devSupportManager.hideRedboxDialog();
    }

    public final void setExceptionDetails(String title, StackFrame[] stack) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(stack, "stack");
        ListView listView = this.stackView;
        if (listView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stackView");
            listView = null;
        }
        listView.setAdapter((ListAdapter) new StackAdapter(title, stack));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(view, "view");
        OpenStackFrameTask openStackFrameTask = new OpenStackFrameTask(this.devSupportManager);
        Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        StackFrame[] stackFrameArr = new StackFrame[1];
        ListView listView = this.stackView;
        if (listView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stackView");
            listView = null;
        }
        Object item = listView.getAdapter().getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.facebook.react.devsupport.interfaces.StackFrame");
        stackFrameArr[0] = item;
        openStackFrameTask.executeOnExecutor(executor, stackFrameArr);
    }

    public final void refreshContentView() {
        String lastErrorTitle = this.devSupportManager.getLastErrorTitle();
        StackFrame[] lastErrorStack = this.devSupportManager.getLastErrorStack();
        if (lastErrorStack == null) {
            lastErrorStack = new StackFrame[0];
        }
        if (this.devSupportManager.getLastErrorType() == null) {
            throw new IllegalStateException("Required value was null.");
        }
        DevSupportManager devSupportManager = this.devSupportManager;
        Pair pairCreate = Pair.create(lastErrorTitle, lastErrorStack);
        Intrinsics.checkNotNullExpressionValue(pairCreate, "create(...)");
        Pair pairProcessErrorCustomizers = devSupportManager.processErrorCustomizers(pairCreate);
        if (pairProcessErrorCustomizers == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Object first = pairProcessErrorCustomizers.first;
        Intrinsics.checkNotNullExpressionValue(first, "first");
        Object second = pairProcessErrorCustomizers.second;
        Intrinsics.checkNotNullExpressionValue(second, "second");
        setExceptionDetails((String) first, (StackFrame[]) second);
        this.devSupportManager.getRedBoxHandler();
    }
}
