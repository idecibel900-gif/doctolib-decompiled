package net.time4j.format;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.time4j.base.ResourceLoader;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PluralRules {
    private static final Map CARDINAL_MAP;
    private static final PluralRules FALLBACK_CARDINAL_ENGLISH;
    private static final PluralRules FALLBACK_CARDINAL_OTHER;
    private static final PluralRules FALLBACK_ORDINAL_ENGLISH;
    private static final PluralRules FALLBACK_ORDINAL_OTHER;
    private static final Map ORDINAL_MAP;

    static {
        NumberType numberType = NumberType.CARDINALS;
        boolean z = true;
        AnonymousClass1 anonymousClass1 = null;
        FALLBACK_CARDINAL_ENGLISH = new FallbackRules(numberType, z, anonymousClass1);
        boolean z2 = false;
        FALLBACK_CARDINAL_OTHER = new FallbackRules(numberType, z2, anonymousClass1);
        NumberType numberType2 = NumberType.ORDINALS;
        FALLBACK_ORDINAL_ENGLISH = new FallbackRules(numberType2, z, anonymousClass1);
        FALLBACK_ORDINAL_OTHER = new FallbackRules(numberType2, z2, anonymousClass1);
        CARDINAL_MAP = new ConcurrentHashMap();
        ORDINAL_MAP = new ConcurrentHashMap();
    }

    public static PluralRules of(Locale locale, NumberType numberType) {
        Map ruleMap = getRuleMap(numberType);
        PluralRules pluralRules = null;
        if (!ruleMap.isEmpty()) {
            pluralRules = locale.getCountry().equals("") ? null : (PluralRules) ruleMap.get(toKey(locale));
            if (pluralRules == null) {
                pluralRules = (PluralRules) ruleMap.get(locale.getLanguage());
            }
        }
        return pluralRules == null ? Holder.PROVIDER.load(locale, numberType) : pluralRules;
    }

    /* JADX INFO: renamed from: net.time4j.format.PluralRules$1, reason: invalid class name */
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

    private static Map getRuleMap(NumberType numberType) {
        int i = AnonymousClass1.$SwitchMap$net$time4j$format$NumberType[numberType.ordinal()];
        if (i == 1) {
            return CARDINAL_MAP;
        }
        if (i == 2) {
            return ORDINAL_MAP;
        }
        throw new UnsupportedOperationException(numberType.name());
    }

    private static String toKey(Locale locale) {
        return locale.getLanguage() + '_' + locale.getCountry();
    }

    private static class FallbackRules extends PluralRules {
        private final boolean english;
        private final NumberType numType;

        /* synthetic */ FallbackRules(NumberType numberType, boolean z, AnonymousClass1 anonymousClass1) {
            this(numberType, z);
        }

        private FallbackRules(NumberType numberType, boolean z) {
            this.numType = numberType;
            this.english = z;
        }
    }

    private static class FallbackProvider implements PluralProvider {
        private FallbackProvider() {
        }

        /* synthetic */ FallbackProvider(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // net.time4j.format.PluralProvider
        public PluralRules load(Locale locale, NumberType numberType) {
            boolean zEquals = locale.getLanguage().equals("en");
            int i = AnonymousClass1.$SwitchMap$net$time4j$format$NumberType[numberType.ordinal()];
            if (i == 1) {
                return zEquals ? PluralRules.FALLBACK_CARDINAL_ENGLISH : PluralRules.FALLBACK_CARDINAL_OTHER;
            }
            if (i == 2) {
                return zEquals ? PluralRules.FALLBACK_ORDINAL_ENGLISH : PluralRules.FALLBACK_ORDINAL_OTHER;
            }
            throw new UnsupportedOperationException(numberType.name());
        }
    }

    private static class Holder {
        private static final PluralProvider PROVIDER;

        static {
            Iterator it = ResourceLoader.getInstance().services(PluralProvider.class).iterator();
            AnonymousClass1 anonymousClass1 = null;
            PluralProvider fallbackProvider = it.hasNext() ? (PluralProvider) it.next() : null;
            if (fallbackProvider == null) {
                fallbackProvider = new FallbackProvider(anonymousClass1);
            }
            PROVIDER = fallbackProvider;
        }
    }
}
