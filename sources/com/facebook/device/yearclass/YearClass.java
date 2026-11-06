package com.facebook.device.yearclass;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public abstract class YearClass {
    private static volatile Integer mYearCategory;

    public static int get(Context context) {
        if (mYearCategory == null) {
            synchronized (YearClass.class) {
                try {
                    if (mYearCategory == null) {
                        mYearCategory = Integer.valueOf(categorizeByYear2016Method(context));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mYearCategory.intValue();
    }

    private static void conditionallyAdd(ArrayList arrayList, int i) {
        if (i != -1) {
            arrayList.add(Integer.valueOf(i));
        }
    }

    private static int categorizeByYear2016Method(Context context) {
        long totalMemory = DeviceInfo.getTotalMemory(context);
        if (totalMemory == -1) {
            return categorizeByYear2014Method(context);
        }
        if (totalMemory <= 805306368) {
            return DeviceInfo.getNumberOfCPUCores() <= 1 ? 2009 : 2010;
        }
        if (totalMemory <= 1073741824) {
            return DeviceInfo.getCPUMaxFreqKHz() < 1300000 ? 2011 : 2012;
        }
        if (totalMemory <= 1610612736) {
            return DeviceInfo.getCPUMaxFreqKHz() < 1800000 ? 2012 : 2013;
        }
        if (totalMemory <= 2147483648L) {
            return 2013;
        }
        if (totalMemory <= 3221225472L) {
            return 2014;
        }
        return totalMemory <= 5368709120L ? 2015 : 2016;
    }

    private static int categorizeByYear2014Method(Context context) {
        ArrayList arrayList = new ArrayList();
        conditionallyAdd(arrayList, getNumCoresYear());
        conditionallyAdd(arrayList, getClockSpeedYear());
        conditionallyAdd(arrayList, getRamYear(context));
        if (arrayList.isEmpty()) {
            return -1;
        }
        Collections.sort(arrayList);
        if ((arrayList.size() & 1) == 1) {
            return ((Integer) arrayList.get(arrayList.size() / 2)).intValue();
        }
        int size = arrayList.size() / 2;
        int i = size - 1;
        return ((Integer) arrayList.get(i)).intValue() + ((((Integer) arrayList.get(size)).intValue() - ((Integer) arrayList.get(i)).intValue()) / 2);
    }

    private static int getNumCoresYear() {
        int numberOfCPUCores = DeviceInfo.getNumberOfCPUCores();
        if (numberOfCPUCores < 1) {
            return -1;
        }
        if (numberOfCPUCores == 1) {
            return 2008;
        }
        return numberOfCPUCores <= 3 ? 2011 : 2012;
    }

    private static int getClockSpeedYear() {
        long cPUMaxFreqKHz = DeviceInfo.getCPUMaxFreqKHz();
        if (cPUMaxFreqKHz == -1) {
            return -1;
        }
        if (cPUMaxFreqKHz <= 528000) {
            return 2008;
        }
        if (cPUMaxFreqKHz <= 620000) {
            return 2009;
        }
        if (cPUMaxFreqKHz <= 1020000) {
            return 2010;
        }
        if (cPUMaxFreqKHz <= 1220000) {
            return 2011;
        }
        if (cPUMaxFreqKHz <= 1520000) {
            return 2012;
        }
        return cPUMaxFreqKHz <= 2020000 ? 2013 : 2014;
    }

    private static int getRamYear(Context context) {
        long totalMemory = DeviceInfo.getTotalMemory(context);
        if (totalMemory <= 0) {
            return -1;
        }
        if (totalMemory <= 201326592) {
            return 2008;
        }
        if (totalMemory <= 304087040) {
            return 2009;
        }
        if (totalMemory <= 536870912) {
            return 2010;
        }
        if (totalMemory <= 1073741824) {
            return 2011;
        }
        if (totalMemory <= 1610612736) {
            return 2012;
        }
        return totalMemory <= 2147483648L ? 2013 : 2014;
    }
}
