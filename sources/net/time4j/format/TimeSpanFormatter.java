package net.time4j.format;

import com.amazon.a.a.o.b.f;
import com.amazon.a.a.o.c.a.b;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TimeSpanFormatter {
    private static final Object SIGN_KEY = new Object();
    private final List items;
    private final String pattern;
    private final Class type;

    private static boolean isSymbol(char c) {
        if (c < 'A' || c > 'Z') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    protected abstract Object getUnit(char c);

    protected TimeSpanFormatter(Class cls, String str) {
        int i;
        if (cls == null) {
            throw new NullPointerException("Missing unit type.");
        }
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ArrayList());
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 < length) {
                char cCharAt = str.charAt(i2);
                if (cCharAt == '#') {
                    i3++;
                } else if (isSymbol(cCharAt)) {
                    int i4 = i2 + 1;
                    while (i4 < length && str.charAt(i4) == cCharAt) {
                        i4++;
                    }
                    addSymbol(cCharAt, i4 - i2, i3, arrayList);
                    i2 = i4 - 1;
                    i3 = 0;
                } else {
                    if (i3 > 0) {
                        throw new IllegalArgumentException("Char # must be followed by unit symbol.");
                    }
                    if (cCharAt == '\'') {
                        int i5 = i2 + 1;
                        i = i5;
                        while (i < length) {
                            if (str.charAt(i) == '\'') {
                                int i6 = i + 1;
                                if (i6 >= length || str.charAt(i6) != '\'') {
                                    break;
                                } else {
                                    i = i6;
                                }
                            }
                            i++;
                        }
                        if (i >= length) {
                            throw new IllegalArgumentException("String literal in pattern not closed: " + str);
                        }
                        if (i5 == i) {
                            addLiteral('\'', (List) arrayList);
                        } else {
                            addLiteral(str.substring(i5, i).replace("''", "'"), arrayList);
                        }
                    } else if (cCharAt == '[') {
                        startOptionalSection(arrayList);
                    } else if (cCharAt == ']') {
                        endOptionalSection(arrayList);
                    } else {
                        char c = ',';
                        char c2 = b.a;
                        if (cCharAt == '.') {
                            lastOn(arrayList).add(new SeparatorItem(c2, c));
                        } else if (cCharAt == ',') {
                            lastOn(arrayList).add(new SeparatorItem(c, c2));
                        } else if (cCharAt == '-') {
                            lastOn(arrayList).add(new SignItem(z));
                        } else if (cCharAt == '+') {
                            lastOn(arrayList).add(new SignItem(z2));
                        } else if (cCharAt == '{') {
                            int i7 = i2 + 1;
                            i = i7;
                            while (i < length && str.charAt(i) != '}') {
                                i++;
                            }
                            addPluralItem(str.substring(i7, i), arrayList);
                        } else if (cCharAt == '|') {
                            lastOn(arrayList).add(OrItem.getInstance());
                        } else {
                            addLiteral(cCharAt, arrayList);
                        }
                    }
                    i2 = i;
                }
                i2++;
            } else {
                if (arrayList.size() > 1) {
                    throw new IllegalArgumentException("Open square bracket without closing one.");
                }
                if (arrayList.isEmpty()) {
                    throw new IllegalArgumentException("Empty or invalid pattern.");
                }
                List list = (List) arrayList.get(0);
                if (list.isEmpty()) {
                    throw new IllegalArgumentException("Missing format pattern.");
                }
                Object obj = list.get(0);
                OrItem orItem = OrItem.INSTANCE;
                if (obj == orItem || list.get(list.size() - 1) == orItem) {
                    throw new IllegalArgumentException("Pattern must not start or end with an or-operator.");
                }
                int size = list.size();
                int minWidth = ((FormatItem) list.get(size - 1)).getMinWidth();
                for (int i8 = size - 2; i8 >= 0; i8--) {
                    FormatItem formatItem = (FormatItem) list.get(i8);
                    if (formatItem == OrItem.INSTANCE) {
                        minWidth = 0;
                    } else {
                        list.set(i8, formatItem.update(minWidth));
                        minWidth += formatItem.getMinWidth();
                    }
                }
                this.type = cls;
                this.items = Collections.unmodifiableList(list);
                this.pattern = str;
                return;
            }
        }
    }

    private void addSymbol(char c, int i, int i2, List list) {
        Object unit = getUnit(c);
        List list2 = (List) list.get(list.size() - 1);
        if (c != 'f') {
            list2.add(new NumberItem(0, i, i + i2, unit));
        } else {
            if (i2 > 0) {
                throw new IllegalArgumentException("Combination of # and f-symbol not allowed.");
            }
            list2.add(new FractionItem(0, i, getUnit(c)));
        }
    }

    private void addLiteral(char c, List list) {
        addLiteral(String.valueOf(c), list);
    }

    private void addLiteral(String str, List list) {
        lastOn(list).add(new LiteralItem(str));
    }

    private void addPluralItem(String str, List list) {
        Locale locale;
        String[] strArrSplit = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        if (strArrSplit.length > 9 || strArrSplit.length < 4) {
            throw new IllegalArgumentException("Plural information has wrong format: " + str);
        }
        if (strArrSplit[0].length() == 1) {
            Object unit = getUnit(strArrSplit[0].charAt(0));
            String[] strArrSplit2 = strArrSplit[2].split("-|_");
            String str2 = strArrSplit2[0];
            if (strArrSplit2.length > 1) {
                String str3 = strArrSplit2[1];
                if (strArrSplit2.length > 2) {
                    String str4 = strArrSplit2[2];
                    if (strArrSplit2.length > 3) {
                        throw new IllegalArgumentException("Plural information has wrong locale: " + str);
                    }
                    locale = new Locale(str2, str3, str4);
                } else {
                    locale = new Locale(str2, str3);
                }
            } else {
                locale = new Locale(str2);
            }
            EnumMap enumMap = new EnumMap(PluralCategory.class);
            PluralRules pluralRulesOf = PluralRules.of(locale, NumberType.CARDINALS);
            for (int i = 3; i < strArrSplit.length; i++) {
                String[] strArrSplit3 = strArrSplit[i].split(f.b);
                if (strArrSplit3.length == 2) {
                    enumMap.put(PluralCategory.valueOf(strArrSplit3[0]), strArrSplit3[1]);
                } else {
                    throw new IllegalArgumentException("Plural information has wrong format: " + str);
                }
            }
            if (enumMap.isEmpty()) {
                throw new IllegalArgumentException("Missing plural forms: " + str);
            }
            if (!enumMap.containsKey(PluralCategory.OTHER)) {
                throw new IllegalArgumentException("Missing plural category OTHER: " + str);
            }
            lastOn(list).add(new PluralItem(unit, strArrSplit[1], pluralRulesOf, enumMap));
            return;
        }
        throw new IllegalArgumentException("Plural information has wrong symbol: " + str);
    }

    private static void startOptionalSection(List list) {
        list.add(new ArrayList());
    }

    private static void endOptionalSection(List list) {
        int size = list.size();
        int i = size - 1;
        if (i < 1) {
            throw new IllegalArgumentException("Closing square bracket without open one.");
        }
        ((List) list.get(size - 2)).add(new OptionalSectionItem((List) list.remove(i)));
    }

    private static List lastOn(List list) {
        return (List) list.get(list.size() - 1);
    }

    private static abstract class FormatItem {
        private final int reserved;

        abstract int getMinWidth();

        abstract FormatItem update(int i);

        FormatItem(int i) {
            this.reserved = i;
        }
    }

    private static class NumberItem extends FormatItem {
        private final int maxWidth;
        private final int minWidth;
        private final Object unit;

        private NumberItem(int i, int i2, int i3, Object obj) {
            super(i);
            if (i2 < 1 || i2 > 18) {
                throw new IllegalArgumentException("Min width out of bounds: " + i2);
            }
            if (i3 < i2) {
                throw new IllegalArgumentException("Max width smaller than min width.");
            }
            if (i3 > 18) {
                throw new IllegalArgumentException("Max width out of bounds: " + i3);
            }
            if (obj == null) {
                throw new NullPointerException("Missing unit.");
            }
            this.minWidth = i2;
            this.maxWidth = i3;
            this.unit = obj;
        }

        @Override // net.time4j.format.TimeSpanFormatter.FormatItem
        int getMinWidth() {
            return this.minWidth;
        }

        @Override // net.time4j.format.TimeSpanFormatter.FormatItem
        FormatItem update(int i) {
            return new NumberItem(i, this.minWidth, this.maxWidth, this.unit);
        }
    }

    private static class FractionItem extends FormatItem {
        private final Object nanosecond;
        private final int width;

        private FractionItem(int i, int i2, Object obj) {
            super(i);
            if (i2 < 1 || i2 > 9) {
                throw new IllegalArgumentException("Fraction width out of bounds: " + i2);
            }
            this.width = i2;
            this.nanosecond = obj;
        }

        @Override // net.time4j.format.TimeSpanFormatter.FormatItem
        int getMinWidth() {
            return this.width;
        }

        @Override // net.time4j.format.TimeSpanFormatter.FormatItem
        FormatItem update(int i) {
            return new FractionItem(i, this.width, this.nanosecond);
        }
    }

    private static class PluralItem extends FormatItem {
        private final int minWidth;
        private final NumberItem numItem;
        private final Map pluralForms;
        private final PluralRules rules;
        private final FormatItem sepItem;

        private PluralItem(Object obj, String str, PluralRules pluralRules, Map map) {
            super(0);
            this.numItem = new NumberItem(0, 1, 18, obj);
            this.sepItem = new LiteralItem(str, true);
            this.rules = pluralRules;
            this.pluralForms = map;
            int length = Integer.MAX_VALUE;
            for (String str2 : map.values()) {
                if (str2.length() < length) {
                    length = str2.length();
                }
            }
            this.minWidth = length;
        }

        private PluralItem(int i, NumberItem numberItem, FormatItem formatItem, PluralRules pluralRules, Map map, int i2) {
            super(i);
            this.numItem = numberItem;
            this.sepItem = formatItem;
            this.rules = pluralRules;
            this.pluralForms = map;
            this.minWidth = i2;
        }

        @Override // net.time4j.format.TimeSpanFormatter.FormatItem
        int getMinWidth() {
            return this.minWidth;
        }

        @Override // net.time4j.format.TimeSpanFormatter.FormatItem
        FormatItem update(int i) {
            return new PluralItem(i, this.numItem, this.sepItem, this.rules, this.pluralForms, this.minWidth);
        }
    }

    private static class SeparatorItem extends FormatItem {
        private final char alt;
        private final char separator;

        @Override // net.time4j.format.TimeSpanFormatter.FormatItem
        int getMinWidth() {
            return 1;
        }

        private SeparatorItem(char c, char c2) {
            this(0, c, c2);
        }

        private SeparatorItem(int i, char c, char c2) {
            super(i);
            this.separator = c;
            this.alt = c2;
        }

        @Override // net.time4j.format.TimeSpanFormatter.FormatItem
        FormatItem update(int i) {
            return new SeparatorItem(i, this.separator, this.alt);
        }
    }

    private static class OrItem extends FormatItem {
        static final OrItem INSTANCE = new OrItem();

        @Override // net.time4j.format.TimeSpanFormatter.FormatItem
        int getMinWidth() {
            return 0;
        }

        @Override // net.time4j.format.TimeSpanFormatter.FormatItem
        FormatItem update(int i) {
            return this;
        }

        private OrItem() {
            super(0);
        }

        static FormatItem getInstance() {
            return INSTANCE;
        }
    }

    private static class LiteralItem extends FormatItem {
        private final String literal;

        private LiteralItem(String str) {
            this(str, false);
        }

        private LiteralItem(String str, boolean z) {
            super(0);
            if (!z && str.isEmpty()) {
                throw new IllegalArgumentException("Literal is empty.");
            }
            this.literal = str;
        }

        private LiteralItem(int i, String str) {
            super(i);
            this.literal = str;
        }

        @Override // net.time4j.format.TimeSpanFormatter.FormatItem
        int getMinWidth() {
            return this.literal.length();
        }

        @Override // net.time4j.format.TimeSpanFormatter.FormatItem
        FormatItem update(int i) {
            return new LiteralItem(i, this.literal);
        }
    }

    private static class SignItem extends FormatItem {
        private final boolean always;

        private SignItem(boolean z) {
            super(0);
            this.always = z;
        }

        private SignItem(int i, boolean z) {
            super(i);
            this.always = z;
        }

        @Override // net.time4j.format.TimeSpanFormatter.FormatItem
        int getMinWidth() {
            return this.always ? 1 : 0;
        }

        @Override // net.time4j.format.TimeSpanFormatter.FormatItem
        FormatItem update(int i) {
            return new SignItem(i, this.always);
        }
    }

    private static class OptionalSectionItem extends FormatItem {
        private final List items;

        @Override // net.time4j.format.TimeSpanFormatter.FormatItem
        int getMinWidth() {
            return 0;
        }

        private OptionalSectionItem(List list) {
            super(0);
            if (list.isEmpty()) {
                throw new IllegalArgumentException("Optional section is empty.");
            }
            Object obj = list.get(0);
            OrItem orItem = OrItem.INSTANCE;
            if (obj == orItem || list.get(list.size() - 1) == orItem) {
                throw new IllegalArgumentException("Optional section must not start or end with an or-operator.");
            }
            this.items = Collections.unmodifiableList(list);
        }

        @Override // net.time4j.format.TimeSpanFormatter.FormatItem
        FormatItem update(int i) {
            ArrayList arrayList = new ArrayList(this.items);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                FormatItem formatItem = (FormatItem) arrayList.get(size);
                arrayList.set(size, formatItem.update(i));
                i += formatItem.getMinWidth();
            }
            return new OptionalSectionItem(arrayList);
        }
    }
}
