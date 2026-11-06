package androidx.compose.ui.text.font;

import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* JADX INFO: loaded from: classes.dex */
public final class FontVariation {
    public static final FontVariation INSTANCE = new FontVariation();

    public interface Setting {
        String getAxisName();

        boolean getNeedsDensity();

        float toVariationValue(Density density);
    }

    private FontVariation() {
    }

    public static final class Settings {
        private final boolean needsDensity;
        private final List settings;

        public Settings(Setting... settingArr) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            boolean z = false;
            for (Setting setting : settingArr) {
                String axisName = setting.getAxisName();
                Object arrayList = linkedHashMap.get(axisName);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(axisName, arrayList);
                }
                ((List) arrayList).add(setting);
            }
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                String str = (String) entry.getKey();
                List list = (List) entry.getValue();
                if (list.size() != 1) {
                    throw new IllegalArgumentException(('\'' + str + "' must be unique. Actual [ [" + CollectionsKt.joinToString$default(list, null, null, null, 0, null, null, 63, null) + ']').toString());
                }
                CollectionsKt.addAll(arrayList2, list);
            }
            ArrayList arrayList3 = new ArrayList(arrayList2);
            this.settings = arrayList3;
            int size = arrayList3.size();
            for (int i = 0; i < size; i++) {
                if (((Setting) arrayList3.get(i)).getNeedsDensity()) {
                    z = true;
                    break;
                }
            }
            this.needsDensity = z;
        }

        public final List getSettings() {
            return this.settings;
        }

        public final boolean getNeedsDensity$ui_text_release() {
            return this.needsDensity;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Settings) && Intrinsics.areEqual(this.settings, ((Settings) obj).settings);
        }

        public int hashCode() {
            return this.settings.hashCode();
        }
    }

    private static final class SettingFloat implements Setting {
        private final String axisName;
        private final boolean needsDensity;
        private final float value;

        public SettingFloat(String str, float f) {
            this.axisName = str;
            this.value = f;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public String getAxisName() {
            return this.axisName;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(Density density) {
            return this.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SettingFloat)) {
                return false;
            }
            SettingFloat settingFloat = (SettingFloat) obj;
            return Intrinsics.areEqual(getAxisName(), settingFloat.getAxisName()) && this.value == settingFloat.value;
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + Float.hashCode(this.value);
        }

        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + this.value + ')';
        }
    }

    private static final class SettingInt implements Setting {
        private final String axisName;
        private final boolean needsDensity;
        private final int value;

        public SettingInt(String str, int i) {
            this.axisName = str;
            this.value = i;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public String getAxisName() {
            return this.axisName;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public float toVariationValue(Density density) {
            return this.value;
        }

        @Override // androidx.compose.ui.text.font.FontVariation.Setting
        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SettingInt)) {
                return false;
            }
            SettingInt settingInt = (SettingInt) obj;
            return Intrinsics.areEqual(getAxisName(), settingInt.getAxisName()) && this.value == settingInt.value;
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + this.value;
        }

        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + this.value + ')';
        }
    }

    public final Setting italic(float f) {
        if (0.0f > f || f > 1.0f) {
            throw new IllegalArgumentException(("'ital' must be in 0.0f..1.0f. Actual: " + f).toString());
        }
        return new SettingFloat("ital", f);
    }

    public final Setting weight(int i) {
        if (1 > i || i >= 1001) {
            throw new IllegalArgumentException(("'wght' value must be in [1, 1000]. Actual: " + i).toString());
        }
        return new SettingInt("wght", i);
    }

    /* JADX INFO: renamed from: Settings-6EWAqTQ, reason: not valid java name */
    public final Settings m2304Settings6EWAqTQ(FontWeight fontWeight, int i, Setting... settingArr) {
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        spreadBuilder.add(weight(fontWeight.getWeight()));
        spreadBuilder.add(italic(i));
        spreadBuilder.addSpread(settingArr);
        return new Settings((Setting[]) spreadBuilder.toArray(new Setting[spreadBuilder.size()]));
    }
}
