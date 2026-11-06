package net.time4j.i18n;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.time4j.format.NumberType;
import net.time4j.format.PluralProvider;
import net.time4j.format.PluralRules;

/* JADX INFO: loaded from: classes5.dex */
public final class DefaultPluralProviderSPI implements PluralProvider {
    private static final Map CARDINAL_MAP;
    private static final Map ORDINAL_MAP;
    private static final PluralRules STD_CARDINALS;
    private static final PluralRules STD_ORDINALS;

    static {
        HashMap map = new HashMap(140);
        CARDINAL_MAP = map;
        int i = 0;
        AnonymousClass1 anonymousClass1 = null;
        STD_CARDINALS = new StdCardinalRules(i, anonymousClass1);
        HashMap map2 = new HashMap();
        fillC(map2, "bm bo dz id ig ii in ja jbo jv jw kde kea km ko lkt", -1);
        fillC(map2, "lo ms my nqo root sah ses sg th to vi wo yo zh", -1);
        fillC(map2, "pt_PT", 0);
        fillC(map2, "am as bn fa gu hi kn zu", 1);
        fillC(map2, "ff fr hy kab pt", 1);
        fillC(map2, "si", 1);
        fillC(map2, "ak bh guw ln mg nso pa ti wa", 1);
        fillC(map2, "tzm", 2);
        fillC(map2, "is", 3);
        fillC(map2, "mk", 4);
        fillC(map2, "ceb fil tl", 5);
        fillC(map2, "lv prg", 6);
        fillC(map2, "lag ksh", 7);
        fillC(map2, "iu naq se sma smi smj smn sms", 8);
        fillC(map2, "shi", 9);
        fillC(map2, "mo ro", 10);
        fillC(map2, "bs hr sh sr", 11);
        fillC(map2, "gd", 12);
        fillC(map2, "sl", 13);
        fillC(map2, "he iw", 14);
        fillC(map2, "cs sk", 15);
        fillC(map2, "pl", 16);
        fillC(map2, "be", 17);
        fillC(map2, "lt", 18);
        fillC(map2, "mt", 19);
        fillC(map2, "ru uk", 17);
        fillC(map2, "br", 20);
        fillC(map2, "ga", 21);
        fillC(map2, "gv", 22);
        fillC(map2, "ar", 23);
        fillC(map2, "cy", 24);
        fillC(map2, "dsb hsb", 25);
        fillC(map2, "kw", 26);
        map.putAll(map2);
        HashMap map3 = new HashMap(140);
        ORDINAL_MAP = map3;
        STD_ORDINALS = new StdOrdinalRules(i, anonymousClass1);
        HashMap map4 = new HashMap();
        fillO(map4, "sv", 1);
        fillO(map4, "fil fr ga hy lo mo ms ro tl vi", 2);
        fillO(map4, "hu", 3);
        fillO(map4, "ne", 4);
        fillO(map4, "kk", 5);
        fillO(map4, "it sc scn", 6);
        fillO(map4, "ka", 7);
        fillO(map4, "sq", 8);
        fillO(map4, "en", 9);
        fillO(map4, "mr", 10);
        fillO(map4, "ca", 11);
        fillO(map4, "mk", 12);
        fillO(map4, "az", 13);
        fillO(map4, "gu hi", 14);
        fillO(map4, "as bn", 15);
        fillO(map4, "cy", 16);
        fillO(map4, "be", 17);
        fillO(map4, "uk", 18);
        fillO(map4, "tk", 19);
        fillO(map4, "or", 20);
        fillO(map4, "gd", 21);
        fillO(map4, "kw", 22);
        map3.putAll(map4);
    }

    /* JADX INFO: renamed from: net.time4j.i18n.DefaultPluralProviderSPI$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$NumberType;

        static {
            int[] iArr = new int[NumberType.values().length];
            $SwitchMap$net$time4j$format$NumberType = iArr;
            try {
                iArr[NumberType.CARDINALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$format$NumberType[NumberType.ORDINALS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // net.time4j.format.PluralProvider
    public PluralRules load(Locale locale, NumberType numberType) {
        Map map;
        PluralRules pluralRules;
        PluralRules pluralRules2;
        int i = AnonymousClass1.$SwitchMap$net$time4j$format$NumberType[numberType.ordinal()];
        if (i == 1) {
            map = CARDINAL_MAP;
            pluralRules = STD_CARDINALS;
        } else if (i == 2) {
            map = ORDINAL_MAP;
            pluralRules = STD_ORDINALS;
        } else {
            throw new UnsupportedOperationException(numberType.name());
        }
        String country = locale.getCountry();
        if (country.isEmpty()) {
            pluralRules2 = null;
        } else {
            pluralRules2 = (PluralRules) map.get(locale.getLanguage() + '_' + country);
        }
        if (pluralRules2 == null) {
            pluralRules2 = (PluralRules) map.get(locale.getLanguage());
        }
        return pluralRules2 == null ? pluralRules : pluralRules2;
    }

    private static void fillC(Map map, String str, int i) {
        for (String str2 : str.split(" ")) {
            map.put(str2, new StdCardinalRules(i, null));
        }
    }

    private static void fillO(Map map, String str, int i) {
        for (String str2 : str.split(" ")) {
            map.put(str2, new StdOrdinalRules(i, null));
        }
    }

    private static class StdCardinalRules extends PluralRules {
        private final int id;

        /* synthetic */ StdCardinalRules(int i, AnonymousClass1 anonymousClass1) {
            this(i);
        }

        private StdCardinalRules(int i) {
            this.id = i;
        }
    }

    private static class StdOrdinalRules extends PluralRules {
        private final int id;

        /* synthetic */ StdOrdinalRules(int i, AnonymousClass1 anonymousClass1) {
            this(i);
        }

        private StdOrdinalRules(int i) {
            this.id = i;
        }
    }
}
