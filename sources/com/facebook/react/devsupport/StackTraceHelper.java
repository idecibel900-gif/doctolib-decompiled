package com.facebook.react.devsupport;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.File;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class StackTraceHelper {
    public static final StackTraceHelper INSTANCE = new StackTraceHelper();
    private static final Pattern STACK_FRAME_PATTERN1;
    private static final Pattern STACK_FRAME_PATTERN2;

    private StackTraceHelper() {
    }

    static {
        Pattern patternCompile = Pattern.compile("^(?:(.*?)@)?(.*?)\\:([0-9]+)\\:([0-9]+)$");
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        STACK_FRAME_PATTERN1 = patternCompile;
        Pattern patternCompile2 = Pattern.compile("\\s*(?:at)\\s*(.+?)\\s*[@(](.*):([0-9]+):([0-9]+)[)]$");
        Intrinsics.checkNotNullExpressionValue(patternCompile2, "compile(...)");
        STACK_FRAME_PATTERN2 = patternCompile2;
    }

    public static final StackFrame[] convertJavaStackTrace(Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        StackTraceElement[] stackTrace = exception.getStackTrace();
        int length = stackTrace.length;
        StackFrame[] stackFrameArr = new StackFrame[length];
        for (int i = 0; i < length; i++) {
            String className = stackTrace[i].getClassName();
            String fileName = stackTrace[i].getFileName();
            String methodName = stackTrace[i].getMethodName();
            Intrinsics.checkNotNullExpressionValue(methodName, "getMethodName(...)");
            stackFrameArr[i] = new StackFrameImpl(className, fileName, methodName, stackTrace[i].getLineNumber(), -1, false, 32, null);
        }
        return stackFrameArr;
    }

    public final String formatFrameSource(StackFrame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        StringBuilder sb = new StringBuilder();
        sb.append(frame.getFileName());
        int line = frame.getLine();
        if (line > 0) {
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append(line);
            int column = frame.getColumn();
            if (column > 0) {
                sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                sb.append(column);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final JavaOnlyMap convertProcessedError$ReactAndroid_release(ReactJsExceptionHandler.ProcessedError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        for (ReactJsExceptionHandler.ProcessedError.StackFrame stackFrame : error.getStack()) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            Integer column = stackFrame.getColumn();
            if (column != null) {
                javaOnlyMap.putDouble("column", column.intValue());
            }
            Integer lineNumber = stackFrame.getLineNumber();
            if (lineNumber != null) {
                javaOnlyMap.putDouble("lineNumber", lineNumber.intValue());
            }
            javaOnlyMap.putString("file", stackFrame.getFile());
            javaOnlyMap.putString("methodName", stackFrame.getMethodName());
            javaOnlyArray.pushMap(javaOnlyMap);
        }
        JavaOnlyMap javaOnlyMap2 = new JavaOnlyMap();
        javaOnlyMap2.putString("message", error.getMessage());
        String originalMessage = error.getOriginalMessage();
        if (originalMessage != null) {
            javaOnlyMap2.putString("originalMessage", originalMessage);
        }
        String name = error.getName();
        if (name != null) {
            javaOnlyMap2.putString("name", name);
        }
        String componentStack = error.getComponentStack();
        if (componentStack != null) {
            javaOnlyMap2.putString("componentStack", componentStack);
        }
        javaOnlyMap2.putArray("stack", javaOnlyArray);
        javaOnlyMap2.putInt(DiagnosticsEntry.ID_KEY, error.getId());
        javaOnlyMap2.putBoolean("isFatal", error.isFatal());
        javaOnlyMap2.putMap("extraData", error.getExtraData());
        return javaOnlyMap2;
    }

    public static final class StackFrameImpl implements StackFrame {
        private final int column;
        private final String file;
        private final String fileName;
        private final boolean isCollapsed;
        private final int line;
        private final String method;

        public StackFrameImpl(String str, String str2, String method, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(method, "method");
            this.file = str;
            this.fileName = str2;
            this.method = method;
            this.line = i;
            this.column = i2;
            this.isCollapsed = z;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public String getFile() {
            return this.file;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ StackFrameImpl(String str, String str2, String str3, int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i3 & 2) != 0) {
                str2 = str != null ? new File(str).getName() : null;
            }
            this(str, str2, str3, i, i2, (i3 & 32) != 0 ? false : z);
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public String getFileName() {
            return this.fileName;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public String getMethod() {
            return this.method;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public int getLine() {
            return this.line;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public int getColumn() {
            return this.column;
        }

        @Override // com.facebook.react.devsupport.interfaces.StackFrame
        public boolean isCollapsed() {
            return this.isCollapsed;
        }
    }
}
