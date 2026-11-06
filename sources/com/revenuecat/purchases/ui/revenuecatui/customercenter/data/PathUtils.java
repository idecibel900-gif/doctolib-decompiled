package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonStyle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PathUtils;", "", "()V", "filterGeneralPaths", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;", "paths", "filterSubscriptionSpecificPaths", "getButtonStyleForPath", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/composables/SettingsButtonStyle;", "path", "isGeneralPath", "", "isSubscriptionSpecificPath", "sortPathsByButtonPriority", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PathUtils {
    public static final int $stable = 0;
    public static final PathUtils INSTANCE = new PathUtils();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SettingsButtonStyle.values().length];
            try {
                iArr[SettingsButtonStyle.FILLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SettingsButtonStyle.OUTLINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CustomerCenterConfigData.HelpPath.PathType.values().length];
            try {
                iArr2[CustomerCenterConfigData.HelpPath.PathType.MISSING_PURCHASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[CustomerCenterConfigData.HelpPath.PathType.CUSTOM_URL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[CustomerCenterConfigData.HelpPath.PathType.CUSTOM_ACTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[CustomerCenterConfigData.HelpPath.PathType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[CustomerCenterConfigData.HelpPath.PathType.CANCEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[CustomerCenterConfigData.HelpPath.PathType.REFUND_REQUEST.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[CustomerCenterConfigData.HelpPath.PathType.CHANGE_PLANS.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private PathUtils() {
    }

    public final List<CustomerCenterConfigData.HelpPath> filterGeneralPaths(List<CustomerCenterConfigData.HelpPath> paths) {
        Intrinsics.checkNotNullParameter(paths, "paths");
        ArrayList arrayList = new ArrayList();
        for (Object obj : paths) {
            if (INSTANCE.isGeneralPath((CustomerCenterConfigData.HelpPath) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List<CustomerCenterConfigData.HelpPath> filterSubscriptionSpecificPaths(List<CustomerCenterConfigData.HelpPath> paths) {
        Intrinsics.checkNotNullParameter(paths, "paths");
        ArrayList arrayList = new ArrayList();
        for (Object obj : paths) {
            if (INSTANCE.isSubscriptionSpecificPath((CustomerCenterConfigData.HelpPath) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final SettingsButtonStyle getButtonStyleForPath(CustomerCenterConfigData.HelpPath path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (isSubscriptionSpecificPath(path)) {
            return SettingsButtonStyle.FILLED;
        }
        return SettingsButtonStyle.OUTLINED;
    }

    public final List<CustomerCenterConfigData.HelpPath> sortPathsByButtonPriority(List<CustomerCenterConfigData.HelpPath> paths) {
        Intrinsics.checkNotNullParameter(paths, "paths");
        return CollectionsKt.sortedWith(paths, new Comparator() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PathUtils$sortPathsByButtonPriority$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int i;
                PathUtils pathUtils = PathUtils.INSTANCE;
                SettingsButtonStyle buttonStyleForPath = pathUtils.getButtonStyleForPath((CustomerCenterConfigData.HelpPath) t);
                int[] iArr = PathUtils.WhenMappings.$EnumSwitchMapping$0;
                int i2 = iArr[buttonStyleForPath.ordinal()];
                int i3 = 0;
                if (i2 == 1) {
                    i = 0;
                } else {
                    if (i2 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i = 1;
                }
                Integer numValueOf = Integer.valueOf(i);
                int i4 = iArr[pathUtils.getButtonStyleForPath((CustomerCenterConfigData.HelpPath) t2).ordinal()];
                if (i4 != 1) {
                    if (i4 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i3 = 1;
                }
                return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i3));
            }
        });
    }

    private final boolean isGeneralPath(CustomerCenterConfigData.HelpPath path) {
        switch (WhenMappings.$EnumSwitchMapping$1[path.getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            case 5:
            case 6:
            case 7:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final boolean isSubscriptionSpecificPath(CustomerCenterConfigData.HelpPath path) {
        switch (WhenMappings.$EnumSwitchMapping$1[path.getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return false;
            case 5:
            case 6:
            case 7:
                return true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
