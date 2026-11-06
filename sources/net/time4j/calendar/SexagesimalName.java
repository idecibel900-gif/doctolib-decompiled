package net.time4j.calendar;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.text.ParsePosition;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.base.MathUtils;

/* JADX INFO: loaded from: classes5.dex */
public class SexagesimalName implements Comparable, Serializable {
    private static final SexagesimalName[] INSTANCES;
    private static final Set LANGS_WITHOUT_SEP;
    private static final Map LANG_2_BRANCH;
    private static final Map LANG_2_STEM;
    private static final long serialVersionUID = -4556668597489844917L;
    private final int number;
    private static final String[] STEMS_SIMPLE = {"jia", "yi", "bing", "ding", "wu", "ji", "geng", "xin", "ren", "gui"};
    private static final String[] STEMS_PINYIN = {"jiǎ", "yǐ", "bǐng", "dīng", "wù", "jǐ", "gēng", "xīn", "rén", "guǐ"};
    private static final String[] STEMS_CHINESE = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    private static final String[] STEMS_KOREAN = {"갑", "을", "병", "정", "무", "기", "경", "신", "임", "계"};
    private static final String[] STEMS_VIETNAMESE = {"giáp", "ất", "bính", "đinh", "mậu", "kỷ", "canh", "tân", "nhâm", "quý"};
    private static final String[] STEMS_RUSSIAN = {"Цзя", "И", "Бин", "Дин", "У", "Цзи", "Гэн", "Синь", "Жэнь", "Гуй"};
    private static final String[] BRANCHES_SIMPLE = {"zi", "chou", "yin", "mao", "chen", "si", "wu", "wei", "shen", "you", "xu", "hai"};
    private static final String[] BRANCHES_PINYIN = {"zǐ", "chǒu", "yín", "mǎo", "chén", "sì", "wǔ", "wèi", "shēn", "yǒu", "xū", "hài"};
    private static final String[] BRANCHES_CHINESE = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
    private static final String[] BRANCHES_KOREAN = {"자", "축", "인", "묘", "진", "사", "오", "미", "신", "유", "술", "해"};
    private static final String[] BRANCHES_VIETNAMESE = {"tí", "sửu", "dần", "mão", "thìn", "tị", "ngọ", "mùi", "thân", "dậu", "tuất", "hợi"};
    private static final String[] BRANCHES_RUSSIAN = {"Цзы", "Чоу", "Инь", "Мао", "Чэнь", "Сы", "У", "Вэй", "Шэнь", "Ю", "Сюй", "Хай"};

    private static char toASCII(char c) {
        if (c == 224) {
            return 'a';
        }
        if (c == 249) {
            return 'u';
        }
        if (c == 275) {
            return 'e';
        }
        if (c == 299) {
            return 'i';
        }
        if (c == 363) {
            return 'u';
        }
        if (c == 462) {
            return 'a';
        }
        if (c == 464) {
            return 'i';
        }
        if (c == 466) {
            return 'o';
        }
        if (c == 232 || c == 233) {
            return 'e';
        }
        if (c == 236 || c == 237) {
            return 'i';
        }
        return c;
    }

    static {
        SexagesimalName[] sexagesimalNameArr = new SexagesimalName[60];
        int i = 0;
        while (i < 60) {
            int i2 = i + 1;
            sexagesimalNameArr[i] = new SexagesimalName(i2);
            i = i2;
        }
        INSTANCES = sexagesimalNameArr;
        HashMap map = new HashMap();
        map.put("root", STEMS_SIMPLE);
        String[] strArr = STEMS_CHINESE;
        map.put("zh", strArr);
        map.put("ja", strArr);
        map.put("ko", STEMS_KOREAN);
        map.put("vi", STEMS_VIETNAMESE);
        map.put("ru", STEMS_RUSSIAN);
        LANG_2_STEM = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("root", BRANCHES_SIMPLE);
        String[] strArr2 = BRANCHES_CHINESE;
        map2.put("zh", strArr2);
        map2.put("ja", strArr2);
        map2.put("ko", BRANCHES_KOREAN);
        map2.put("vi", BRANCHES_VIETNAMESE);
        map2.put("ru", BRANCHES_RUSSIAN);
        LANG_2_BRANCH = Collections.unmodifiableMap(map2);
        HashSet hashSet = new HashSet();
        hashSet.add("zh");
        hashSet.add("ja");
        hashSet.add("ko");
        LANGS_WITHOUT_SEP = Collections.unmodifiableSet(hashSet);
    }

    SexagesimalName(int i) {
        this.number = i;
    }

    public static SexagesimalName of(int i) {
        if (i < 1 || i > 60) {
            throw new IllegalArgumentException("Out of range: " + i);
        }
        return INSTANCES[i - 1];
    }

    public static SexagesimalName of(Stem stem, Branch branch) {
        int iOrdinal = stem.ordinal();
        SexagesimalName sexagesimalNameOf = of(iOrdinal + 1 + MathUtils.floorModulo((branch.ordinal() - iOrdinal) * 25, 60));
        if (sexagesimalNameOf.getStem() == stem && sexagesimalNameOf.getBranch() == branch) {
            return sexagesimalNameOf;
        }
        throw new IllegalArgumentException("Invalid combination of stem and branch.");
    }

    public int getNumber() {
        return this.number;
    }

    public Stem getStem() {
        int i = this.number % 10;
        return Stem.values()[(i != 0 ? i : 10) - 1];
    }

    public Branch getBranch() {
        int i = this.number % 12;
        return Branch.values()[(i != 0 ? i : 12) - 1];
    }

    public String getDisplayName(Locale locale) {
        Stem stem = getStem();
        Branch branch = getBranch();
        return stem.getDisplayName(locale) + (LANGS_WITHOUT_SEP.contains(locale.getLanguage()) ? "" : "-") + branch.getDisplayName(locale);
    }

    @Override // java.lang.Comparable
    public int compareTo(SexagesimalName sexagesimalName) {
        if (getClass().equals(sexagesimalName.getClass())) {
            return this.number - ((SexagesimalName) SexagesimalName.class.cast(sexagesimalName)).number;
        }
        throw new ClassCastException("Cannot compare different types.");
    }

    public boolean equals(Object obj) {
        return getClass().equals(obj.getClass()) && this.number == ((SexagesimalName) obj).number;
    }

    public int hashCode() {
        return this.number;
    }

    public String toString() {
        return getDisplayName(Locale.ROOT) + "(" + String.valueOf(this.number) + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    static SexagesimalName parse(CharSequence charSequence, ParsePosition parsePosition, Locale locale, boolean z) {
        Stem stem;
        boolean z2;
        SexagesimalName sexagesimalName;
        int i;
        boolean z3;
        Branch branch;
        Branch branch2;
        Locale locale2 = locale;
        int index = parsePosition.getIndex();
        int length = charSequence.length();
        boolean zIsEmpty = locale2.getLanguage().isEmpty();
        int i2 = index + 1;
        SexagesimalName sexagesimalName2 = null;
        if (i2 >= length || index < 0) {
            parsePosition.setErrorIndex(index);
            return null;
        }
        if (LANGS_WITHOUT_SEP.contains(locale2.getLanguage())) {
            Stem[] stemArrValues = Stem.values();
            int length2 = stemArrValues.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    stem = null;
                    break;
                }
                stem = stemArrValues[i3];
                if (stem.getDisplayName(locale2).charAt(0) == charSequence.charAt(index)) {
                    break;
                }
                i3++;
            }
            if (stem != null) {
                Branch[] branchArrValues = Branch.values();
                int length3 = branchArrValues.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length3) {
                        branch2 = null;
                        break;
                    }
                    Branch branch3 = branchArrValues[i4];
                    if (branch3.getDisplayName(locale2).charAt(0) == charSequence.charAt(i2)) {
                        index += 2;
                        branch2 = branch3;
                        break;
                    }
                    i4++;
                }
                z2 = zIsEmpty;
                sexagesimalName = null;
                branch = branch2;
            } else {
                z2 = zIsEmpty;
                branch = 0;
                sexagesimalName = null;
            }
        } else {
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                }
                if (charSequence.charAt(i2) == '-') {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                parsePosition.setErrorIndex(index);
                return null;
            }
            Stem[] stemArrValues2 = Stem.values();
            int length4 = stemArrValues2.length;
            stem = null;
            int i5 = 0;
            while (i5 < length4) {
                Stem stem2 = stemArrValues2[i5];
                String displayName = stem2.getDisplayName(locale2);
                SexagesimalName sexagesimalName3 = sexagesimalName2;
                int i6 = index;
                while (true) {
                    if (i6 >= i2) {
                        z3 = zIsEmpty;
                        break;
                    }
                    int i7 = i6 - index;
                    char cCharAt = charSequence.charAt(i6);
                    if (zIsEmpty) {
                        cCharAt = toASCII(cCharAt);
                    }
                    char c = cCharAt;
                    z3 = zIsEmpty;
                    if (i7 >= displayName.length() || displayName.charAt(i7) != c) {
                        break;
                    }
                    if (i7 + 1 == displayName.length()) {
                        stem = stem2;
                        break;
                    }
                    i6++;
                    zIsEmpty = z3;
                }
                i5++;
                sexagesimalName2 = sexagesimalName3;
                zIsEmpty = z3;
            }
            z2 = zIsEmpty;
            sexagesimalName = sexagesimalName2;
            if (stem == null) {
                if (z && !z2 && i2 + 1 < length) {
                    return parse(charSequence, parsePosition, Locale.ROOT, true);
                }
                parsePosition.setErrorIndex(index);
                return sexagesimalName;
            }
            Branch[] branchArrValues2 = Branch.values();
            int length5 = branchArrValues2.length;
            Object obj = sexagesimalName;
            int i8 = 0;
            while (i8 < length5) {
                Branch branch4 = branchArrValues2[i8];
                String displayName2 = branch4.getDisplayName(locale2);
                int i9 = i2 + 1;
                while (true) {
                    if (i9 < length) {
                        int i10 = i9 - i2;
                        int i11 = i10 - 1;
                        char cCharAt2 = charSequence.charAt(i9);
                        if (z2) {
                            cCharAt2 = toASCII(cCharAt2);
                        }
                        char c2 = cCharAt2;
                        i = index;
                        if (i11 < displayName2.length() && displayName2.charAt(i11) == c2) {
                            if (i10 == displayName2.length()) {
                                obj = branch4;
                                index = i9 + 1;
                                break;
                            }
                            i9++;
                            index = i;
                        }
                    } else {
                        i = index;
                    }
                    index = i;
                    break;
                }
                i8++;
                locale2 = locale;
                obj = obj;
            }
            branch = obj;
        }
        if (stem != null && branch != 0) {
            parsePosition.setIndex(index);
            return of(stem, branch);
        }
        if (z && !z2) {
            return parse(charSequence, parsePosition, Locale.ROOT, true);
        }
        parsePosition.setErrorIndex(index);
        return sexagesimalName;
    }

    Object readResolve() throws ObjectStreamException {
        return of(this.number);
    }

    public enum Stem {
        JIA_1_WOOD_YANG,
        YI_2_WOOD_YIN,
        BING_3_FIRE_YANG,
        DING_4_FIRE_YIN,
        WU_5_EARTH_YANG,
        JI_6_EARTH_YIN,
        GENG_7_METAL_YANG,
        XIN_8_METAL_YIN,
        REN_9_WATER_YANG,
        GUI_10_WATER_YIN;

        public String getDisplayName(Locale locale) {
            String language = locale.getLanguage();
            Map map = SexagesimalName.LANG_2_STEM;
            if (language.isEmpty()) {
                language = "root";
            }
            String[] strArr = (String[]) map.get(language);
            if (strArr == null) {
                strArr = SexagesimalName.STEMS_PINYIN;
            }
            return strArr[ordinal()];
        }
    }

    public enum Branch {
        ZI_1_RAT,
        CHOU_2_OX,
        YIN_3_TIGER,
        MAO_4_HARE,
        CHEN_5_DRAGON,
        SI_6_SNAKE,
        WU_7_HORSE,
        WEI_8_SHEEP,
        SHEN_9_MONKEY,
        YOU_10_FOWL,
        XU_11_DOG,
        HAI_12_PIG;

        public String getDisplayName(Locale locale) {
            String language = locale.getLanguage();
            Map map = SexagesimalName.LANG_2_BRANCH;
            if (language.isEmpty()) {
                language = "root";
            }
            String[] strArr = (String[]) map.get(language);
            if (strArr == null) {
                strArr = SexagesimalName.BRANCHES_PINYIN;
            }
            return strArr[ordinal()];
        }
    }
}
