package com.google.crypto.tink.subtle;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class EngineFactory {
    private final Policy policy;
    public static final EngineFactory CIPHER = new EngineFactory(new EngineWrapper.TCipher());
    public static final EngineFactory MAC = new EngineFactory(new EngineWrapper.TMac());
    public static final EngineFactory SIGNATURE = new EngineFactory(new EngineWrapper.TSignature());
    public static final EngineFactory MESSAGE_DIGEST = new EngineFactory(new EngineWrapper.TMessageDigest());
    public static final EngineFactory KEY_AGREEMENT = new EngineFactory(new EngineWrapper.TKeyAgreement());
    public static final EngineFactory KEY_PAIR_GENERATOR = new EngineFactory(new EngineWrapper.TKeyPairGenerator());
    public static final EngineFactory KEY_FACTORY = new EngineFactory(new EngineWrapper.TKeyFactory());

    private interface Policy {
        Object getInstance(String str);
    }

    private static class DefaultPolicy implements Policy {
        private final EngineWrapper jceFactory;

        private DefaultPolicy(EngineWrapper engineWrapper) {
            this.jceFactory = engineWrapper;
        }

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public Object getInstance(String str) {
            return this.jceFactory.getInstance(str, null);
        }
    }

    private static class FipsPolicy implements Policy {
        private final EngineWrapper jceFactory;

        private FipsPolicy(EngineWrapper engineWrapper) {
            this.jceFactory = engineWrapper;
        }

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public Object getInstance(String str) throws GeneralSecurityException {
            Iterator it = EngineFactory.toProviderList("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.jceFactory.getInstance(str, (Provider) it.next());
                } catch (Exception e) {
                    if (exc == null) {
                        exc = e;
                    }
                }
            }
            throw new GeneralSecurityException("No good Provider found.", exc);
        }
    }

    private static class AndroidPolicy implements Policy {
        private final EngineWrapper jceFactory;

        private AndroidPolicy(EngineWrapper engineWrapper) {
            this.jceFactory = engineWrapper;
        }

        @Override // com.google.crypto.tink.subtle.EngineFactory.Policy
        public Object getInstance(String str) {
            Iterator it = EngineFactory.toProviderList("GmsCore_OpenSSL", "AndroidOpenSSL").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.jceFactory.getInstance(str, (Provider) it.next());
                } catch (Exception e) {
                    if (exc == null) {
                        exc = e;
                    }
                }
            }
            return this.jceFactory.getInstance(str, null);
        }
    }

    public static List toProviderList(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public EngineFactory(EngineWrapper engineWrapper) {
        if (TinkFipsUtil.useOnlyFips()) {
            this.policy = new FipsPolicy(engineWrapper);
        } else if (SubtleUtil.isAndroid()) {
            this.policy = new AndroidPolicy(engineWrapper);
        } else {
            this.policy = new DefaultPolicy(engineWrapper);
        }
    }

    public Object getInstance(String str) {
        return this.policy.getInstance(str);
    }
}
