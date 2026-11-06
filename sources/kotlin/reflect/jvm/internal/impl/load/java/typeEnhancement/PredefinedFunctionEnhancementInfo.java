package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class PredefinedFunctionEnhancementInfo {
    private final String errorsSinceLanguageVersion;
    private final List parametersInfo;
    private final TypeEnhancementInfo returnTypeInfo;
    private final PredefinedFunctionEnhancementInfo warningModeClone;

    public PredefinedFunctionEnhancementInfo(TypeEnhancementInfo typeEnhancementInfo, List parametersInfo, String str) {
        Intrinsics.checkNotNullParameter(parametersInfo, "parametersInfo");
        this.returnTypeInfo = typeEnhancementInfo;
        this.parametersInfo = parametersInfo;
        this.errorsSinceLanguageVersion = str;
        PredefinedFunctionEnhancementInfo predefinedFunctionEnhancementInfo = null;
        if (str != null) {
            TypeEnhancementInfo typeEnhancementInfoCopyForWarnings = typeEnhancementInfo != null ? typeEnhancementInfo.copyForWarnings() : null;
            List<TypeEnhancementInfo> list = parametersInfo;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (TypeEnhancementInfo typeEnhancementInfo2 : list) {
                arrayList.add(typeEnhancementInfo2 != null ? typeEnhancementInfo2.copyForWarnings() : null);
            }
            predefinedFunctionEnhancementInfo = new PredefinedFunctionEnhancementInfo(typeEnhancementInfoCopyForWarnings, arrayList, null);
        }
        this.warningModeClone = predefinedFunctionEnhancementInfo;
    }

    public final TypeEnhancementInfo getReturnTypeInfo() {
        return this.returnTypeInfo;
    }

    public final List getParametersInfo() {
        return this.parametersInfo;
    }

    public final String getErrorsSinceLanguageVersion() {
        return this.errorsSinceLanguageVersion;
    }

    public final PredefinedFunctionEnhancementInfo getWarningModeClone() {
        return this.warningModeClone;
    }
}
