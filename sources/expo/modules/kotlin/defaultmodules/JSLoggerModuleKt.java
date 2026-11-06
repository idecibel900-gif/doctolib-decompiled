package expo.modules.kotlin.defaultmodules;

import expo.modules.core.logging.LogType;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JSLoggerModuleKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogType.values().length];
            try {
                iArr[LogType.Trace.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogType.Timer.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogType.Stacktrace.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogType.Debug.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LogType.Info.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LogType.Warn.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LogType.Error.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[LogType.Fatal.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getEventName(LogType logType) {
        switch (WhenMappings.$EnumSwitchMapping$0[logType.ordinal()]) {
            case 1:
                return "ExpoModulesCoreJSLogger.onNewTrace";
            case 2:
                return "ExpoModulesCoreJSLogger.onNewDebug";
            case 3:
                return "ExpoModulesCoreJSLogger.onNewTrace";
            case 4:
                return "ExpoModulesCoreJSLogger.onNewDebug";
            case 5:
                return "ExpoModulesCoreJSLogger.onNewInfo";
            case 6:
                return "ExpoModulesCoreJSLogger.onNewWarning";
            case 7:
            case 8:
                return "ExpoModulesCoreJSLogger.onNewError";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
