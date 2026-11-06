package expo.modules.interfaces.taskManager;

import android.content.Context;
import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import expo.modules.ExpoModulesPackageList;
import expo.modules.core.ModulePriorities;
import expo.modules.core.interfaces.Package;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/interfaces/taskManager/TaskServiceProviderHelper;", "", "<init>", "()V", "getTaskServiceImpl", "Lexpo/modules/interfaces/taskManager/TaskServiceInterface;", "context", "Landroid/content/Context;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskServiceProviderHelper {
    public static final TaskServiceProviderHelper INSTANCE = new TaskServiceProviderHelper();

    private TaskServiceProviderHelper() {
    }

    public final TaskServiceInterface getTaskServiceImpl(Context context) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ExpoModulesPackageList.Companion companion = ExpoModulesPackageList.Companion;
            Method method = ExpoModulesPackageList.class.getMethod("getPackageList", null);
            if (method == null) {
                return null;
            }
            Object objInvoke = method.invoke(null, null);
            List list = objInvoke instanceof List ? (List) objInvoke : null;
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (obj instanceof Package) {
                    arrayList.add(obj);
                }
            }
            List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: expo.modules.interfaces.taskManager.TaskServiceProviderHelper$getTaskServiceImpl$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    ModulePriorities modulePriorities = ModulePriorities.INSTANCE;
                    return ComparisonsKt.compareValues(Integer.valueOf(modulePriorities.get(Reflection.getOrCreateKotlinClass(((Package) obj3).getClass()).getQualifiedName())), Integer.valueOf(modulePriorities.get(Reflection.getOrCreateKotlinClass(((Package) obj2).getClass()).getQualifiedName())));
                }
            });
            ArrayList arrayList2 = new ArrayList();
            Iterator it = listSortedWith.iterator();
            while (it.hasNext()) {
                it.next();
            }
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(CollectionsKt.firstOrNull((List) arrayList2));
            return null;
        } catch (ClassNotFoundException unused) {
        }
    }
}
