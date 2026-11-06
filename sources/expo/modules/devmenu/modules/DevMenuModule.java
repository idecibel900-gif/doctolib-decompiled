package expo.modules.devmenu.modules;

import androidx.tracing.Trace;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lexpo/modules/devmenu/modules/DevMenuModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-dev-menu_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DevMenuModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        Trace.beginSection("[ExpoModulesCore] " + (getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(this);
            moduleDefinitionBuilder.Name("DevMenuModule");
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
