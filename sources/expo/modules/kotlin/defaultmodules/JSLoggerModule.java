package expo.modules.kotlin.defaultmodules;

import android.os.Bundle;
import androidx.tracing.Trace;
import expo.modules.core.logging.LogHandler;
import expo.modules.core.logging.LogType;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014R(\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lexpo/modules/kotlin/defaultmodules/JSLoggerModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "", "message", "Landroid/os/Bundle;", "createMessageBundle", "(Ljava/lang/String;)Landroid/os/Bundle;", "Lexpo/modules/core/logging/LogType;", "type", "", "reportToLogBox", "(Lexpo/modules/core/logging/LogType;Ljava/lang/String;)V", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "definition", "()Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "Lexpo/modules/kotlin/exception/CodedException;", "codedException", "reportExceptionToLogBox", "(Lexpo/modules/kotlin/exception/CodedException;)V", "Lexpo/modules/core/logging/Logger;", "value", "logger", "Lexpo/modules/core/logging/Logger;", "getLogger", "()Lexpo/modules/core/logging/Logger;", "JSLogHandler", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSLoggerModule extends Module {
    private Logger logger;

    /* JADX INFO: Access modifiers changed from: private */
    static final class JSLogHandler extends LogHandler {
        private final WeakReference moduleReference;

        public JSLogHandler(JSLoggerModule module) {
            Intrinsics.checkNotNullParameter(module, "module");
            this.moduleReference = new WeakReference(module);
        }

        @Override // expo.modules.core.logging.LogHandler
        public void log$expo_modules_core_release(LogType type, String message, Throwable th) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(message, "message");
            if (th != null) {
                message = message + ". " + th.getMessage();
            }
            JSLoggerModule jSLoggerModule = (JSLoggerModule) this.moduleReference.get();
            if (jSLoggerModule != null) {
                jSLoggerModule.reportToLogBox(type, message);
            }
        }
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final void reportExceptionToLogBox(CodedException codedException) {
        Intrinsics.checkNotNullParameter(codedException, "codedException");
        String message = codedException.getMessage();
        if (message == null) {
            message = codedException.toString();
        }
        sendEvent("ExpoModulesCoreJSLogger.onNewError", createMessageBundle(message));
    }

    private final Bundle createMessageBundle(String message) {
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        return bundle;
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Trace.beginSection("[ExpoModulesCore] " + (getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(this);
            moduleDefinitionBuilder.Name("ExpoModulesCoreJSLogger");
            moduleDefinitionBuilder.Events("ExpoModulesCoreJSLogger.onNewError", "ExpoModulesCoreJSLogger.onNewWarning", "ExpoModulesCoreJSLogger.onNewDebug", "ExpoModulesCoreJSLogger.onNewInfo", "ExpoModulesCoreJSLogger.onNewTrace");
            Map eventListeners = moduleDefinitionBuilder.getEventListeners();
            EventName eventName = EventName.MODULE_CREATE;
            eventListeners.put(eventName, new BasicEventListener(eventName, new Function0() { // from class: expo.modules.kotlin.defaultmodules.JSLoggerModule$definition$lambda$1$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m4906invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m4906invoke() {
                    JSLoggerModule.JSLogHandler jSLogHandler = new JSLoggerModule.JSLogHandler(this.this$0);
                    this.this$0.logger = new Logger(CollectionsKt.listOf(jSLogHandler));
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportToLogBox(LogType type, String message) {
        String eventName = JSLoggerModuleKt.getEventName(type);
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        Unit unit = Unit.INSTANCE;
        sendEvent(eventName, bundle);
    }
}
