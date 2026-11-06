package expo.modules.kotlin.modules;

import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.TypeConverterProviderKt;
import expo.modules.kotlin.views.ViewManagerDefinition;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class InternalModuleDefinitionBuilder extends ObjectDefinitionBuilder {
    private List classData;
    private final Map eventListeners;
    private final Module module;
    private String name;
    private Function2 registerContracts;
    private Map viewManagerDefinitions;

    public final Module getModule() {
        return this.module;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ InternalModuleDefinitionBuilder(Module module, TypeConverterProvider typeConverterProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TypeConverterProvider typeConverterProviderConverters;
        module = (i & 1) != 0 ? null : module;
        this(module, (i & 2) != 0 ? (module == null || (typeConverterProviderConverters = module.converters()) == null) ? null : TypeConverterProviderKt.mergeWithDefault(typeConverterProviderConverters) : typeConverterProvider);
    }

    public InternalModuleDefinitionBuilder(Module module, TypeConverterProvider typeConverterProvider) {
        super(typeConverterProvider);
        this.module = module;
        this.viewManagerDefinitions = new LinkedHashMap();
        this.eventListeners = new LinkedHashMap();
        this.classData = new ArrayList();
    }

    public final Map getEventListeners() {
        return this.eventListeners;
    }

    public final List getClassData() {
        return this.classData;
    }

    public final ModuleDefinitionData buildModule() {
        String simpleName = this.name;
        if (simpleName == null) {
            Module module = this.module;
            simpleName = module != null ? module.getClass().getSimpleName() : null;
        }
        String str = simpleName;
        if (str != null) {
            return new ModuleDefinitionData(str, buildObject(), this.viewManagerDefinitions, this.eventListeners, this.registerContracts, this.classData);
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public final void Name(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    public final void registerViewDefinition(ViewManagerDefinition definition) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        if (this.viewManagerDefinitions.containsKey(definition.getName$expo_modules_core_release())) {
            throw new IllegalArgumentException(("The module definition defines more than one view with name " + definition.getName$expo_modules_core_release() + ".").toString());
        }
        this.viewManagerDefinitions.put(definition.getName$expo_modules_core_release(), definition);
        if (this.viewManagerDefinitions.containsKey("DEFAULT_MODULE_VIEW")) {
            return;
        }
        this.viewManagerDefinitions.put("DEFAULT_MODULE_VIEW", definition);
    }

    public final void RegisterActivityContracts(Function2 body) {
        Intrinsics.checkNotNullParameter(body, "body");
        this.registerContracts = body;
    }
}
