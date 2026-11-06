package com.oblador.keychain;

import android.content.Context;
import android.util.Base64;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.SharedPreferencesMigrationKt;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import com.facebook.react.bridge.ReactApplicationContext;
import com.oblador.keychain.cipherStorage.CipherStorage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public final class DataStorePrefsStorage implements PrefsStorageBase {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property2(new PropertyReference2Impl(DataStorePrefsStorage.class, "prefs", "getPrefs(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};
    private final CoroutineScope coroutineScope;
    private final DataStore prefs;
    private final ReadOnlyProperty prefs$delegate;

    public DataStorePrefsStorage(ReactApplicationContext reactContext, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
        this.prefs$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default("RN_KEYCHAIN", null, new DataStorePrefsStorage$prefs$2(this), coroutineScope, 2, null);
        this.prefs = getPrefs(reactContext);
    }

    private final DataStore getPrefs(Context context) {
        return (DataStore) this.prefs$delegate.getValue(context, $$delegatedProperties[0]);
    }

    private final Preferences getPrefsData() {
        return (Preferences) callSuspendable(new DataStorePrefsStorage$prefsData$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List sharedPreferencesMigration(Context context) {
        return CollectionsKt.listOf(SharedPreferencesMigrationKt.SharedPreferencesMigration$default(context, "RN_KEYCHAIN", null, 4, null));
    }

    @Override // com.oblador.keychain.PrefsStorageBase
    public PrefsStorageBase.ResultSet getEncryptedEntry(String service) {
        Intrinsics.checkNotNullParameter(service, "service");
        byte[] bytesForUsername = getBytesForUsername(service);
        byte[] bytesForPassword = getBytesForPassword(service);
        String cipherStorageName = getCipherStorageName(service);
        if (bytesForUsername == null || bytesForPassword == null || cipherStorageName == null) {
            return null;
        }
        return new PrefsStorageBase.ResultSet(cipherStorageName, bytesForUsername, bytesForPassword);
    }

    @Override // com.oblador.keychain.PrefsStorageBase
    public void removeEntry(String service) {
        Intrinsics.checkNotNullParameter(service, "service");
        PrefsStorageBase.Companion companion = PrefsStorageBase.Companion;
        callSuspendable(new C05331(PreferencesKeys.stringKey(companion.getKeyForUsername(service)), PreferencesKeys.stringKey(companion.getKeyForPassword(service)), PreferencesKeys.stringKey(companion.getKeyForCipherStorage(service)), null));
    }

    /* JADX INFO: renamed from: com.oblador.keychain.DataStorePrefsStorage$removeEntry$1, reason: invalid class name and case insensitive filesystem */
    static final class C05331 extends SuspendLambda implements Function1 {
        final /* synthetic */ Preferences.Key $keyForCipherStorage;
        final /* synthetic */ Preferences.Key $keyForPassword;
        final /* synthetic */ Preferences.Key $keyForUsername;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05331(Preferences.Key key, Preferences.Key key2, Preferences.Key key3, Continuation continuation) {
            super(1, continuation);
            this.$keyForUsername = key;
            this.$keyForPassword = key2;
            this.$keyForCipherStorage = key3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return DataStorePrefsStorage.this.new C05331(this.$keyForUsername, this.$keyForPassword, this.$keyForCipherStorage, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C05331) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.oblador.keychain.DataStorePrefsStorage$removeEntry$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00751 extends SuspendLambda implements Function2 {
            final /* synthetic */ Preferences.Key $keyForCipherStorage;
            final /* synthetic */ Preferences.Key $keyForPassword;
            final /* synthetic */ Preferences.Key $keyForUsername;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00751(Preferences.Key key, Preferences.Key key2, Preferences.Key key3, Continuation continuation) {
                super(2, continuation);
                this.$keyForUsername = key;
                this.$keyForPassword = key2;
                this.$keyForCipherStorage = key3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                C00751 c00751 = new C00751(this.$keyForUsername, this.$keyForPassword, this.$keyForCipherStorage, continuation);
                c00751.L$0 = obj;
                return c00751;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(MutablePreferences mutablePreferences, Continuation continuation) {
                return ((C00751) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                mutablePreferences.remove(this.$keyForUsername);
                mutablePreferences.remove(this.$keyForPassword);
                mutablePreferences.remove(this.$keyForCipherStorage);
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            DataStore dataStore = DataStorePrefsStorage.this.prefs;
            C00751 c00751 = new C00751(this.$keyForUsername, this.$keyForPassword, this.$keyForCipherStorage, null);
            this.label = 1;
            Object objEdit = PreferencesKt.edit(dataStore, c00751, this);
            return objEdit == coroutine_suspended ? coroutine_suspended : objEdit;
        }
    }

    @Override // com.oblador.keychain.PrefsStorageBase
    public void storeEncryptedEntry(String service, CipherStorage.EncryptionResult encryptionResult) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(encryptionResult, "encryptionResult");
        PrefsStorageBase.Companion companion = PrefsStorageBase.Companion;
        callSuspendable(new C05341(PreferencesKeys.stringKey(companion.getKeyForUsername(service)), encryptionResult, PreferencesKeys.stringKey(companion.getKeyForPassword(service)), PreferencesKeys.stringKey(companion.getKeyForCipherStorage(service)), null));
    }

    /* JADX INFO: renamed from: com.oblador.keychain.DataStorePrefsStorage$storeEncryptedEntry$1, reason: invalid class name and case insensitive filesystem */
    static final class C05341 extends SuspendLambda implements Function1 {
        final /* synthetic */ CipherStorage.EncryptionResult $encryptionResult;
        final /* synthetic */ Preferences.Key $keyForCipherStorage;
        final /* synthetic */ Preferences.Key $keyForPassword;
        final /* synthetic */ Preferences.Key $keyForUsername;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05341(Preferences.Key key, CipherStorage.EncryptionResult encryptionResult, Preferences.Key key2, Preferences.Key key3, Continuation continuation) {
            super(1, continuation);
            this.$keyForUsername = key;
            this.$encryptionResult = encryptionResult;
            this.$keyForPassword = key2;
            this.$keyForCipherStorage = key3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return DataStorePrefsStorage.this.new C05341(this.$keyForUsername, this.$encryptionResult, this.$keyForPassword, this.$keyForCipherStorage, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C05341) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.oblador.keychain.DataStorePrefsStorage$storeEncryptedEntry$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00761 extends SuspendLambda implements Function2 {
            final /* synthetic */ CipherStorage.EncryptionResult $encryptionResult;
            final /* synthetic */ Preferences.Key $keyForCipherStorage;
            final /* synthetic */ Preferences.Key $keyForPassword;
            final /* synthetic */ Preferences.Key $keyForUsername;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00761(Preferences.Key key, CipherStorage.EncryptionResult encryptionResult, Preferences.Key key2, Preferences.Key key3, Continuation continuation) {
                super(2, continuation);
                this.$keyForUsername = key;
                this.$encryptionResult = encryptionResult;
                this.$keyForPassword = key2;
                this.$keyForCipherStorage = key3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                C00761 c00761 = new C00761(this.$keyForUsername, this.$encryptionResult, this.$keyForPassword, this.$keyForCipherStorage, continuation);
                c00761.L$0 = obj;
                return c00761;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(MutablePreferences mutablePreferences, Continuation continuation) {
                return ((C00761) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                mutablePreferences.set(this.$keyForUsername, Base64.encodeToString((byte[]) this.$encryptionResult.getUsername(), 0));
                mutablePreferences.set(this.$keyForPassword, Base64.encodeToString((byte[]) this.$encryptionResult.getPassword(), 0));
                mutablePreferences.set(this.$keyForCipherStorage, this.$encryptionResult.getCipherName());
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            DataStore dataStore = DataStorePrefsStorage.this.prefs;
            C00761 c00761 = new C00761(this.$keyForUsername, this.$encryptionResult, this.$keyForPassword, this.$keyForCipherStorage, null);
            this.label = 1;
            Object objEdit = PreferencesKt.edit(dataStore, c00761, this);
            return objEdit == coroutine_suspended ? coroutine_suspended : objEdit;
        }
    }

    @Override // com.oblador.keychain.PrefsStorageBase
    public Set getUsedCipherNames() {
        HashSet hashSet = new HashSet();
        Set setKeySet = getPrefsData().asMap().keySet();
        ArrayList<String> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList.add(((Preferences.Key) it.next()).getName());
        }
        for (String str : arrayList) {
            if (PrefsStorageBase.Companion.isKeyForCipherStorage(str)) {
                hashSet.add((String) getPrefsData().get(PreferencesKeys.stringKey(str)));
            }
        }
        return hashSet;
    }

    /* JADX INFO: renamed from: com.oblador.keychain.DataStorePrefsStorage$callSuspendable$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function1 $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Function1 function1 = this.$block;
            this.label = 1;
            Object objInvoke = function1.invoke(this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    private final Object callSuspendable(Function1 function1) {
        return BuildersKt.runBlocking(this.coroutineScope.getCoroutineContext(), new AnonymousClass1(function1, null));
    }

    private final byte[] getBytesForUsername(String str) {
        return getBytes(PreferencesKeys.stringKey(PrefsStorageBase.Companion.getKeyForUsername(str)));
    }

    private final byte[] getBytesForPassword(String str) {
        return getBytes(PreferencesKeys.stringKey(PrefsStorageBase.Companion.getKeyForPassword(str)));
    }

    private final String getCipherStorageName(String str) {
        return (String) getPrefsData().get(PreferencesKeys.stringKey(PrefsStorageBase.Companion.getKeyForCipherStorage(str)));
    }

    private final byte[] getBytes(Preferences.Key key) {
        String str = (String) getPrefsData().get(key);
        if (str != null) {
            return Base64.decode(str, 0);
        }
        return null;
    }
}
