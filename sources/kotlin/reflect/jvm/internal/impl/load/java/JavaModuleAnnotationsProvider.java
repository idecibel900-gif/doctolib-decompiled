package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes5.dex */
public interface JavaModuleAnnotationsProvider {
    List getAnnotationsForModuleOwnerOfClass(ClassId classId);
}
