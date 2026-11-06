package com.henninghall.date_picker;

import com.henninghall.date_picker.models.Is24HourSource;
import com.henninghall.date_picker.models.Mode;
import com.henninghall.date_picker.models.WheelType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class DerivedData {
    private final State state;

    DerivedData(State state) {
        this.state = state;
    }

    public ArrayList getVisibleWheels() {
        ArrayList arrayList = new ArrayList();
        Mode mode = this.state.getMode();
        int i = AnonymousClass1.$SwitchMap$com$henninghall$date_picker$models$Mode[mode.ordinal()];
        if (i == 1) {
            arrayList.add(WheelType.DAY);
            arrayList.add(WheelType.HOUR);
            arrayList.add(WheelType.MINUTE);
        } else if (i == 2) {
            arrayList.add(WheelType.HOUR);
            arrayList.add(WheelType.MINUTE);
        } else if (i == 3) {
            arrayList.add(WheelType.YEAR);
            arrayList.add(WheelType.MONTH);
            arrayList.add(WheelType.DATE);
        }
        if ((mode == Mode.time || mode == Mode.datetime) && this.state.derived.usesAmPm()) {
            arrayList.add(WheelType.AM_PM);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: com.henninghall.date_picker.DerivedData$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$henninghall$date_picker$models$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$henninghall$date_picker$models$Mode = iArr;
            try {
                iArr[Mode.datetime.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$henninghall$date_picker$models$Mode[Mode.time.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$henninghall$date_picker$models$Mode[Mode.date.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ArrayList getOrderedVisibleWheels() {
        ArrayList<WheelType> orderedWheels = getOrderedWheels();
        ArrayList visibleWheels = getVisibleWheels();
        ArrayList arrayList = new ArrayList();
        for (WheelType wheelType : orderedWheels) {
            if (visibleWheels.contains(wheelType)) {
                arrayList.add(wheelType);
            }
        }
        return arrayList;
    }

    private ArrayList getOrderedWheels() {
        String strReplaceAll = LocaleUtils.getDateTimePattern(this.state.getLocale()).replaceAll("\\('(.+?)'\\)", "\\${$1}").replaceAll("'.+?'", "").replaceAll("\\$\\{(.+?)\\}", "('$1')");
        ArrayList arrayList = new ArrayList(Arrays.asList(WheelType.values()));
        ArrayList arrayList2 = new ArrayList();
        WheelType wheelType = WheelType.DAY;
        arrayList.remove(wheelType);
        arrayList2.add(wheelType);
        for (char c : strReplaceAll.toCharArray()) {
            try {
                WheelType wheelTypePatternCharToWheelType = Utils.patternCharToWheelType(c);
                if (arrayList.contains(wheelTypePatternCharToWheelType)) {
                    arrayList.remove(wheelTypePatternCharToWheelType);
                    arrayList2.add(wheelTypePatternCharToWheelType);
                }
            } catch (Exception unused) {
            }
        }
        WheelType wheelType2 = WheelType.AM_PM;
        if (arrayList.contains(wheelType2)) {
            arrayList.remove(wheelType2);
            arrayList2.add(wheelType2);
        }
        if (!arrayList.isEmpty()) {
            arrayList.size();
            Objects.toString(arrayList.get(0));
        }
        return arrayList2;
    }

    public int getRootLayout() {
        return R$layout.native_picker;
    }

    public boolean usesAmPm() {
        return this.state.getIs24HourSource() == Is24HourSource.locale ? LocaleUtils.localeUsesAmPm(this.state.getLocale()) : Utils.deviceUsesAmPm();
    }

    public boolean hasOnly2Wheels() {
        return this.state.getMode() == Mode.time && !usesAmPm();
    }

    public String getLastDate() {
        Calendar lastSelectedDate = this.state.getLastSelectedDate();
        return lastSelectedDate != null ? Utils.dateToIso(lastSelectedDate) : this.state.getIsoDate();
    }
}
