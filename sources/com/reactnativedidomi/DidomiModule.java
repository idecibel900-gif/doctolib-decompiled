package com.reactnativedidomi;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import com.amazon.device.iap.internal.c.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import io.didomi.ssl.Didomi;
import io.didomi.ssl.DidomiInitializeParameters;
import io.didomi.ssl.events.ConsentChangedEvent;
import io.didomi.ssl.events.ErrorEvent;
import io.didomi.ssl.events.EventListener;
import io.didomi.ssl.events.HideNoticeEvent;
import io.didomi.ssl.events.HidePreferencesEvent;
import io.didomi.ssl.events.LanguageUpdateFailedEvent;
import io.didomi.ssl.events.LanguageUpdatedEvent;
import io.didomi.ssl.events.NoticeClickAgreeEvent;
import io.didomi.ssl.events.NoticeClickDisagreeEvent;
import io.didomi.ssl.events.NoticeClickMoreInfoEvent;
import io.didomi.ssl.events.NoticeClickPrivacyPolicyEvent;
import io.didomi.ssl.events.NoticeClickViewSPIPurposesEvent;
import io.didomi.ssl.events.NoticeClickViewVendorsEvent;
import io.didomi.ssl.events.PreferencesClickAgreeToAllEvent;
import io.didomi.ssl.events.PreferencesClickAgreeToAllPurposesEvent;
import io.didomi.ssl.events.PreferencesClickAgreeToAllVendorsEvent;
import io.didomi.ssl.events.PreferencesClickCategoryAgreeEvent;
import io.didomi.ssl.events.PreferencesClickCategoryDisagreeEvent;
import io.didomi.ssl.events.PreferencesClickDisagreeToAllEvent;
import io.didomi.ssl.events.PreferencesClickDisagreeToAllPurposesEvent;
import io.didomi.ssl.events.PreferencesClickDisagreeToAllVendorsEvent;
import io.didomi.ssl.events.PreferencesClickPurposeAgreeEvent;
import io.didomi.ssl.events.PreferencesClickPurposeDisagreeEvent;
import io.didomi.ssl.events.PreferencesClickResetAllPurposesEvent;
import io.didomi.ssl.events.PreferencesClickSPICategoryAgreeEvent;
import io.didomi.ssl.events.PreferencesClickSPICategoryDisagreeEvent;
import io.didomi.ssl.events.PreferencesClickSPIPurposeAgreeEvent;
import io.didomi.ssl.events.PreferencesClickSPIPurposeDisagreeEvent;
import io.didomi.ssl.events.PreferencesClickSPIPurposeSaveChoicesEvent;
import io.didomi.ssl.events.PreferencesClickSaveChoicesEvent;
import io.didomi.ssl.events.PreferencesClickVendorAgreeEvent;
import io.didomi.ssl.events.PreferencesClickVendorDisagreeEvent;
import io.didomi.ssl.events.PreferencesClickVendorSaveChoicesEvent;
import io.didomi.ssl.events.PreferencesClickViewPurposesEvent;
import io.didomi.ssl.events.PreferencesClickViewSPIPurposesEvent;
import io.didomi.ssl.events.PreferencesClickViewVendorsEvent;
import io.didomi.ssl.events.ReadyEvent;
import io.didomi.ssl.events.ShowNoticeEvent;
import io.didomi.ssl.events.ShowPreferencesEvent;
import io.didomi.ssl.events.SyncDoneEvent;
import io.didomi.ssl.events.SyncErrorEvent;
import io.didomi.ssl.exceptions.DidomiNotReadyException;
import io.didomi.ssl.functionalinterfaces.DidomiCallable;
import io.didomi.ssl.user.UserAuthWithEncryptionParams;
import io.didomi.ssl.user.UserAuthWithHashParams;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\bc*\u0001\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u0011\"\u0004\b\u0000\u0010\u0014*\u0002H\u0014H\u0002¢\u0006\u0002\u0010\u0015J&\u0010\u0016\u001a\u0002H\u0014\"\u0006\b\u0000\u0010\u0014\u0018\u0001*\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u0011H\u0086\b¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0019*\u00020\u001aH\u0002J \u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001d\"\u0006\b\u0001\u0010\u001c\u0018\u0001*\u0002H\u001dH\u0086\b¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020 2\u0010\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0019H\u0002J\u001a\u0010\"\u001a\u00020 2\u0010\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0019H\u0002J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0012H\u0002Jt\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u000f2\b\u0010-\u001a\u0004\u0018\u00010\u000f2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u000f2\b\u00101\u001a\u0004\u0018\u00010\u000f2\b\u00102\u001a\u0004\u0018\u00010\u000f2\u0006\u00103\u001a\u00020/2\u0006\u00104\u001a\u000205H\u0007J\u0010\u00106\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u00107\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u00108\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0018\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020;2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010<\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010=\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010>\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010?\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010@\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010A\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010B\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010C\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u001a\u0010D\u001a\u00020'2\b\u0010E\u001a\u0004\u0018\u00010\u000f2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010F\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0018\u0010G\u001a\u00020'2\u0006\u0010H\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010I\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010J\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010K\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010L\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0018\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0007J\u0018\u0010O\u001a\u00020'2\u0006\u0010P\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0007J\u0018\u0010Q\u001a\u00020'2\u0006\u0010H\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0007J\u0018\u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0007J\u0018\u0010T\u001a\u00020'2\u0006\u0010S\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0007J\u0018\u0010U\u001a\u00020'2\u0006\u0010H\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0007J\u0018\u0010V\u001a\u00020'2\u0006\u0010S\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0007J\u0018\u0010W\u001a\u00020'2\u0006\u0010S\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010X\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0018\u0010Y\u001a\u00020'2\u0006\u0010S\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0007J\u0018\u0010Z\u001a\u00020'2\u0006\u0010S\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010[\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010\\\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010]\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010^\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010_\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010`\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010a\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010b\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010c\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J@\u0010d\u001a\u00020'2\u0006\u0010e\u001a\u00020\u000f2\b\u0010f\u001a\u0004\u0018\u00010\u000f2\b\u0010g\u001a\u0004\u0018\u00010\u000f2\b\u0010h\u001a\u0004\u0018\u00010\u000f2\b\u0010i\u001a\u0004\u0018\u00010\u000f2\u0006\u00104\u001a\u000205H\u0007J\u0018\u0010j\u001a\u00020'2\u0006\u0010e\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0007J:\u0010k\u001a\u00020'2\u0006\u0010e\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020\u000f2\b\u0010o\u001a\u0004\u0018\u00010\u000f2\u0006\u00104\u001a\u000205H\u0007J:\u0010p\u001a\u00020'2\u0006\u0010e\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020\u000f2\b\u0010o\u001a\u0004\u0018\u00010\u000f2\u0006\u00104\u001a\u000205H\u0007JB\u0010q\u001a\u00020'2\u0006\u0010e\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020\u000f2\b\u0010o\u001a\u0004\u0018\u00010\u000f2\u0006\u0010r\u001a\u00020;2\u0006\u00104\u001a\u000205H\u0007JB\u0010s\u001a\u00020'2\u0006\u0010e\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020\u000f2\b\u0010o\u001a\u0004\u0018\u00010\u000f2\u0006\u0010r\u001a\u00020;2\u0006\u00104\u001a\u000205H\u0007J0\u0010t\u001a\u00020'2\u0006\u0010e\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020\u000f2\u0006\u0010u\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0007J0\u0010v\u001a\u00020'2\u0006\u0010e\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020\u000f2\u0006\u0010u\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0007J8\u0010w\u001a\u00020'2\u0006\u0010e\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020\u000f2\u0006\u0010u\u001a\u00020\u000f2\u0006\u0010r\u001a\u00020;2\u0006\u00104\u001a\u000205H\u0007J8\u0010x\u001a\u00020'2\u0006\u0010e\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020\u000f2\u0006\u0010u\u001a\u00020\u000f2\u0006\u0010r\u001a\u00020;2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010y\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u001a\u0010z\u001a\u00020'2\b\u0010{\u001a\u0004\u0018\u00010\u000f2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010|\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0010\u0010}\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007JW\u0010~\u001a\u00020'2\u0006\u0010\u007f\u001a\u00020\u001a2\u0007\u0010\u0080\u0001\u001a\u00020\u001a2\u0007\u0010\u0081\u0001\u001a\u00020\u001a2\u0007\u0010\u0082\u0001\u001a\u00020\u001a2\u0007\u0010\u0083\u0001\u001a\u00020\u001a2\u0007\u0010\u0084\u0001\u001a\u00020\u001a2\u0007\u0010\u0085\u0001\u001a\u00020\u001a2\u0007\u0010\u0086\u0001\u001a\u00020\u001a2\u0006\u00104\u001a\u000205H\u0007J\u0011\u0010\u0087\u0001\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J5\u0010\u0088\u0001\u001a\u00020'2\u0007\u0010\u0089\u0001\u001a\u00020/2\u0007\u0010\u008a\u0001\u001a\u00020/2\u0007\u0010\u008b\u0001\u001a\u00020/2\u0007\u0010\u008c\u0001\u001a\u00020/2\u0006\u00104\u001a\u000205H\u0007JY\u0010\u008d\u0001\u001a\u00020'2\u0007\u0010\u008e\u0001\u001a\u00020\u001a2\u0007\u0010\u008f\u0001\u001a\u00020\u001a2\u0007\u0010\u0090\u0001\u001a\u00020\u001a2\u0007\u0010\u0091\u0001\u001a\u00020\u001a2\u0007\u0010\u0092\u0001\u001a\u00020\u001a2\u0007\u0010\u0093\u0001\u001a\u00020\u001a2\u0007\u0010\u0094\u0001\u001a\u00020\u001a2\u0007\u0010\u0095\u0001\u001a\u00020\u001a2\u0006\u00104\u001a\u000205H\u0007J\u0011\u0010\u0096\u0001\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0007J\u0019\u0010\u0097\u0001\u001a\u00020'2\u0006\u00100\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0007J\u0012\u0010\u0098\u0001\u001a\u00020'2\u0007\u0010\u0099\u0001\u001a\u00020\u000fH\u0007J\u0012\u0010\u009a\u0001\u001a\u00020'2\u0007\u0010\u009b\u0001\u001a\u00020;H\u0007J\u001d\u0010\u009c\u0001\u001a\u00020'2\u0007\u0010\u0099\u0001\u001a\u00020\u000f2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u000fH\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u009e\u0001"}, d2 = {"Lcom/reactnativedidomi/DidomiModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "Lcom/facebook/react/bridge/ReactContext;", "eventListener", "com/reactnativedidomi/DidomiModule$eventListener$1", "Lcom/reactnativedidomi/DidomiModule$eventListener$1;", "getName", "", "getConstants", "", "", "serializeToMap", "T", "(Ljava/lang/Object;)Ljava/util/Map;", "toDataClass", "(Ljava/util/Map;)Ljava/lang/Object;", "toSet", "", "Lcom/facebook/react/bridge/ReadableArray;", "convert", "O", "I", "(Ljava/lang/Object;)Ljava/lang/Object;", "setOfStringToWritableArray", "Lcom/facebook/react/bridge/WritableArray;", "set", "setToWritableArray", "objectToWritableMap", "Lcom/facebook/react/bridge/WritableMap;", "obj", "initialize", "", "userAgentName", "userAgentVersion", "apiKey", "localConfigurationPath", "remoteConfigurationUrl", "providerId", "disableDidomiRemoteConfig", "", "languageCode", "noticeId", "androidTvNoticeId", "androidTvEnabled", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "onReady", "onError", "setupUI", "setLogLevel", "level", "", "getDisabledPurposes", "getDisabledPurposeIds", "getDisabledVendors", "getDisabledVendorIds", "getEnabledPurposes", "getEnabledPurposeIds", "getEnabledVendors", "getEnabledVendorIds", "getJavaScriptForWebView", "extra", "getQueryStringForWebView", "getPurpose", "purposeId", "getRequiredPurposes", "getRequiredPurposeIds", "getRequiredVendors", "getRequiredVendorIds", "getText", "textKey", "getTranslatedText", SubscriberAttributeKt.JSON_NAME_KEY, "getUserConsentStatusForPurpose", "getUserConsentStatusForVendor", "vendorId", "getUserConsentStatusForVendorAndRequiredPurposes", "getUserLegitimateInterestStatusForPurpose", "getUserLegitimateInterestForVendor", "getUserLegitimateInterestStatusForVendorAndRequiredPurposes", "getUserStatus", "getUserStatusForVendor", "getVendor", "hideNotice", "hidePreferences", "isConsentRequired", "isUserConsentStatusPartial", "isNoticeVisible", "isPreferencesVisible", "isError", "isReady", "clearUser", "setUser", "organizationUserId", "organizationUserIdAuthAlgorithm", "organizationUserIdAuthSid", "organizationUserIdAuthSalt", "organizationUserIdAuthDigest", "setUserAndSetupUI", "setUserWithHashAuth", "algorithm", "secretId", "digest", "salt", "setUserWithHashAuthAndSetupUI", "setUserWithHashAuthWithExpiration", "expiration", "setUserWithHashAuthWithExpirationAndSetupUI", "setUserWithEncryptionAuth", "initializationVector", "setUserWithEncryptionAuthAndSetupUI", "setUserWithEncryptionAuthWithExpiration", "setUserWithEncryptionAuthWithExpirationAndSetupUI", "showNotice", "showPreferences", "view", b.au, "setUserAgreeToAll", "setUserConsentStatus", "enabledPurposeIds", "disabledPurposeIds", "enabledLegitimatePurposeIds", "disabledLegitimatePurposeIds", "enabledVendorIds", "disabledVendorIds", "enabledLegIntVendorIds", "disabledLegIntVendorIds", "setUserDisagreeToAll", "setUserStatus", "purposesConsentStatus", "purposesLIStatus", "vendorsConsentStatus", "vendorsLIStatus", "setUserStatusSets", "enabledConsentPurposeIds", "disabledConsentPurposeIds", "enabledLIPurposeIds", "disabledLIPurposeIds", "enabledConsentVendorIds", "disabledConsentVendorIds", "enabledLIVendorIds", "disabledLIVendorIds", "shouldConsentBeCollected", "updateSelectedLanguage", "addListener", "eventName", "removeListeners", "count", "prepareEvent", "params", "didomi_react-native_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DidomiModule extends ReactContextBaseJavaModule {
    private final DidomiModule$eventListener$1 eventListener;
    private final Gson gson;
    private final ReactContext reactContext;

    @ReactMethod
    public final void addListener(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @ReactMethod
    public final void removeListeners(int count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.reactnativedidomi.DidomiModule$eventListener$1] */
    public DidomiModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.gson = new Gson();
        this.reactContext = reactContext;
        this.eventListener = new EventListener() { // from class: com.reactnativedidomi.DidomiModule$eventListener$1
            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void consentChanged(ConsentChangedEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.CONSENT_CHANGED.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void ready(ReadyEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.READY.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void error(ErrorEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.ERROR.getEvent(), event.getErrorMessage());
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void hideNotice(HideNoticeEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.HIDE_NOTICE.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void showNotice(ShowNoticeEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.SHOW_NOTICE.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void noticeClickAgree(NoticeClickAgreeEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.NOTICE_CLICK_AGREE.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void noticeClickDisagree(NoticeClickDisagreeEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.NOTICE_CLICK_DISAGREE.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void noticeClickViewVendors(NoticeClickViewVendorsEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.NOTICE_CLICK_VIEW_VENDORS.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void noticeClickViewSPIPurposes(NoticeClickViewSPIPurposesEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.NOTICE_CLICK_VIEW_SPI_PURPOSES.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void noticeClickMoreInfo(NoticeClickMoreInfoEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.NOTICE_CLICK_MORE_INFO.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void noticeClickPrivacyPolicy(NoticeClickPrivacyPolicyEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.NOTICE_CLICK_PRIVACY_POLICY.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void hidePreferences(HidePreferencesEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.HIDE_PREFERENCES.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void showPreferences(ShowPreferencesEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.SHOW_PREFERENCES.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickViewPurposes(PreferencesClickViewPurposesEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_VIEW_PURPOSES.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickViewVendors(PreferencesClickViewVendorsEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_VIEW_VENDORS.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickViewSPIPurposes(PreferencesClickViewSPIPurposesEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_VIEW_SPI_PURPOSES.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickAgreeToAll(PreferencesClickAgreeToAllEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_AGREE_TO_ALL.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickDisagreeToAll(PreferencesClickDisagreeToAllEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_DISAGREE_TO_ALL.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickAgreeToAllPurposes(PreferencesClickAgreeToAllPurposesEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_AGREE_TO_ALL_PURPOSES.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickDisagreeToAllPurposes(PreferencesClickDisagreeToAllPurposesEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_DISAGREE_TO_ALL_PURPOSES.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickResetAllPurposes(PreferencesClickResetAllPurposesEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_RESET_ALL_PURPOSES.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickPurposeAgree(PreferencesClickPurposeAgreeEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_PURPOSE_AGREE.getEvent(), event.getPurposeId());
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickPurposeDisagree(PreferencesClickPurposeDisagreeEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_PURPOSE_DISAGREE.getEvent(), event.getPurposeId());
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickCategoryAgree(PreferencesClickCategoryAgreeEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_CATEGORY_AGREE.getEvent(), event.getCategoryId());
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickCategoryDisagree(PreferencesClickCategoryDisagreeEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_CATEGORY_DISAGREE.getEvent(), event.getCategoryId());
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickSaveChoices(PreferencesClickSaveChoicesEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_SAVE_CHOICES.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickAgreeToAllVendors(PreferencesClickAgreeToAllVendorsEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_AGREE_TO_ALL_VENDORS.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickDisagreeToAllVendors(PreferencesClickDisagreeToAllVendorsEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_DISAGREE_TO_ALL_VENDORS.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickVendorAgree(PreferencesClickVendorAgreeEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_VENDOR_AGREE.getEvent(), event.getVendorId());
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickVendorDisagree(PreferencesClickVendorDisagreeEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_VENDOR_DISAGREE.getEvent(), event.getVendorId());
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickVendorSaveChoices(PreferencesClickVendorSaveChoicesEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_VENDOR_SAVE_CHOICES.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickSPIPurposeAgree(PreferencesClickSPIPurposeAgreeEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_SPI_PURPOSE_AGREE.getEvent(), event.getPurposeId());
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickSPIPurposeDisagree(PreferencesClickSPIPurposeDisagreeEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_SPI_PURPOSE_DISAGREE.getEvent(), event.getPurposeId());
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickSPICategoryAgree(PreferencesClickSPICategoryAgreeEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_SPI_CATEGORY_AGREE.getEvent(), event.getCategoryId());
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickSPICategoryDisagree(PreferencesClickSPICategoryDisagreeEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_SPI_CATEGORY_DISAGREE.getEvent(), event.getCategoryId());
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void preferencesClickSPIPurposeSaveChoices(PreferencesClickSPIPurposeSaveChoicesEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.PREFERENCES_CLICK_SPI_PURPOSE_SAVE_CHOICES.getEvent(), null);
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void syncDone(SyncDoneEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.SYNC_DONE.getEvent(), event.getOrganizationUserId());
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void syncError(SyncErrorEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.SYNC_ERROR.getEvent(), event.getError());
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void languageUpdated(LanguageUpdatedEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.LANGUAGE_UPDATED.getEvent(), event.getLanguageCode());
            }

            @Override // io.didomi.ssl.events.EventListener, io.didomi.ssl.functionalinterfaces.DidomiEventListener
            public void languageUpdateFailed(LanguageUpdateFailedEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.prepareEvent(EventTypes.LANGUAGE_UPDATE_FAILED.getEvent(), event.getReason());
            }
        };
    }

    public final Gson getGson() {
        return this.gson;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "Didomi";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (EventTypes eventTypes : EventTypes.values()) {
            linkedHashMap.put(eventTypes.getEvent(), MapBuilder.of("registrationName", eventTypes.getEvent()));
        }
        return linkedHashMap;
    }

    private final Set<String> toSet(ReadableArray readableArray) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            String string = readableArray.getString(i);
            if (string == null) {
                string = "";
            }
            linkedHashSet.add(string);
        }
        return linkedHashSet;
    }

    private final <T> Map<String, Object> serializeToMap(T t) {
        return (Map) getGson().fromJson(getGson().toJson(t), new TypeToken<Map<String, ? extends Object>>() { // from class: com.reactnativedidomi.DidomiModule$serializeToMap$$inlined$convert$1
        }.getType());
    }

    public final /* synthetic */ <I, O> O convert(I i) {
        String json = getGson().toJson(i);
        Gson gson = getGson();
        Intrinsics.needClassReification();
        return (O) gson.fromJson(json, new TypeToken<O>() { // from class: com.reactnativedidomi.DidomiModule.convert.1
        }.getType());
    }

    public final /* synthetic */ <T> T toDataClass(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        String json = getGson().toJson(map);
        Gson gson = getGson();
        Intrinsics.needClassReification();
        return (T) gson.fromJson(json, new TypeToken<T>() { // from class: com.reactnativedidomi.DidomiModule$toDataClass$$inlined$convert$1
        }.getType());
    }

    private final WritableArray setOfStringToWritableArray(Set<String> set) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        if (set != null) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                writableNativeArray.pushString((String) it.next());
            }
        }
        return writableNativeArray;
    }

    private final WritableArray setToWritableArray(Set<? extends Object> set) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        if (set != null) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                writableNativeArray.pushMap(objectToWritableMap(it.next()));
            }
        }
        return writableNativeArray;
    }

    private final WritableMap objectToWritableMap(Object obj) {
        Map<String, Object> mapSerializeToMap;
        Set<Map.Entry<String, Object>> setEntrySet;
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (obj != null && (mapSerializeToMap = serializeToMap(obj)) != null && (setEntrySet = mapSerializeToMap.entrySet()) != null) {
            Iterator<T> it = setEntrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object value = entry.getValue();
                if (value instanceof Map) {
                    writableNativeMap.putMap((String) entry.getKey(), objectToWritableMap(value));
                } else if (value instanceof List) {
                    writableNativeMap.putArray((String) entry.getKey(), Arguments.fromList((List) value));
                } else {
                    writableNativeMap.putString((String) entry.getKey(), value.toString());
                }
            }
        }
        return writableNativeMap;
    }

    @ReactMethod
    public final void initialize(String userAgentName, String userAgentVersion, String apiKey, String localConfigurationPath, String remoteConfigurationUrl, String providerId, boolean disableDidomiRemoteConfig, String languageCode, String noticeId, String androidTvNoticeId, boolean androidTvEnabled, Promise promise) {
        Application application;
        Intrinsics.checkNotNullParameter(userAgentName, "userAgentName");
        Intrinsics.checkNotNullParameter(userAgentVersion, "userAgentVersion");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Didomi.Companion companion = Didomi.INSTANCE;
            companion.getInstance().addEventListener((EventListener) this.eventListener);
            companion.getInstance().setUserAgent(userAgentName, userAgentVersion);
            DidomiInitializeParameters didomiInitializeParameters = new DidomiInitializeParameters(apiKey, localConfigurationPath, remoteConfigurationUrl, providerId, disableDidomiRemoteConfig, languageCode, noticeId, androidTvNoticeId, androidTvEnabled);
            Activity currentActivity = getCurrentActivity();
            if (currentActivity == null || (application = currentActivity.getApplication()) == null) {
                throw new IllegalStateException("No activity present");
            }
            companion.getInstance().initialize(application, didomiInitializeParameters);
            promise.resolve(0);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReady$lambda$4(DidomiModule didomiModule) {
        didomiModule.prepareEvent(EventTypes.READY_CALLBACK.getEvent(), null);
    }

    @ReactMethod
    public final void onReady(Promise promise) throws Exception {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Didomi.INSTANCE.getInstance().onReady(new DidomiCallable() { // from class: com.reactnativedidomi.DidomiModule$$ExternalSyntheticLambda3
            @Override // io.didomi.ssl.functionalinterfaces.DidomiCallable
            public final void call() {
                DidomiModule.onReady$lambda$4(this.f$0);
            }
        });
        promise.resolve(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onError$lambda$5(DidomiModule didomiModule) {
        didomiModule.prepareEvent(EventTypes.ERROR_CALLBACK.getEvent(), null);
    }

    @ReactMethod
    public final void onError(Promise promise) throws Exception {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Didomi.INSTANCE.getInstance().onError(new DidomiCallable() { // from class: com.reactnativedidomi.DidomiModule$$ExternalSyntheticLambda1
            @Override // io.didomi.ssl.functionalinterfaces.DidomiCallable
            public final void call() {
                DidomiModule.onError$lambda$5(this.f$0);
            }
        });
        promise.resolve(0);
    }

    @ReactMethod
    public final void setupUI(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativedidomi.DidomiModule$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    DidomiModule.setupUI$lambda$6(this.f$0);
                }
            });
            promise.resolve(0);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$6(DidomiModule didomiModule) {
        Didomi companion = Didomi.INSTANCE.getInstance();
        Activity currentActivity = didomiModule.getCurrentActivity();
        companion.setupUI(currentActivity instanceof FragmentActivity ? (FragmentActivity) currentActivity : null);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001a  */
    @ReactMethod
    public final void setLogLevel(int level, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Didomi companion = Didomi.INSTANCE.getInstance();
        int i = 4;
        if (level != 0) {
            if (level == 1) {
                i = 3;
            } else if (level == 2) {
                i = 5;
            } else if (level == 3) {
                i = 6;
            } else if (level != 4) {
                i = 5;
            } else {
                i = 2;
            }
        }
        companion.setLogLevel(i);
        promise.resolve(0);
    }

    @ReactMethod
    public final void getDisabledPurposes(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(setToWritableArray(Didomi.INSTANCE.getInstance().getDisabledPurposes()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getDisabledPurposeIds(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(setOfStringToWritableArray(Didomi.INSTANCE.getInstance().getDisabledPurposeIds()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getDisabledVendors(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(setToWritableArray(Didomi.INSTANCE.getInstance().getDisabledVendors()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getDisabledVendorIds(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(setOfStringToWritableArray(Didomi.INSTANCE.getInstance().getDisabledVendorIds()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getEnabledPurposes(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(setToWritableArray(Didomi.INSTANCE.getInstance().getEnabledPurposes()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getEnabledPurposeIds(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(setOfStringToWritableArray(Didomi.INSTANCE.getInstance().getEnabledPurposeIds()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getEnabledVendors(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(setToWritableArray(Didomi.INSTANCE.getInstance().getEnabledVendors()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getEnabledVendorIds(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(setOfStringToWritableArray(Didomi.INSTANCE.getInstance().getEnabledVendorIds()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getJavaScriptForWebView(String extra, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            if (extra != null) {
                promise.resolve(Didomi.INSTANCE.getInstance().getJavaScriptForWebView(extra));
            } else {
                promise.resolve(Didomi.getJavaScriptForWebView$default(Didomi.INSTANCE.getInstance(), null, 1, null));
            }
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getQueryStringForWebView(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Didomi.INSTANCE.getInstance().getQueryStringForWebView());
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getPurpose(String purposeId, Promise promise) {
        Intrinsics.checkNotNullParameter(purposeId, "purposeId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(objectToWritableMap(Didomi.INSTANCE.getInstance().getPurpose(purposeId)));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getRequiredPurposes(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(setToWritableArray(Didomi.INSTANCE.getInstance().getRequiredPurposes()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getRequiredPurposeIds(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(setOfStringToWritableArray(Didomi.INSTANCE.getInstance().getRequiredPurposeIds()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getRequiredVendors(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(setToWritableArray(Didomi.INSTANCE.getInstance().getRequiredVendors()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getRequiredVendorIds(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(setOfStringToWritableArray(Didomi.INSTANCE.getInstance().getRequiredVendorIds()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getText(String textKey, Promise promise) {
        Intrinsics.checkNotNullParameter(textKey, "textKey");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Map<String, String> text = Didomi.INSTANCE.getInstance().getText(textKey);
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            if (text != null) {
                for (Map.Entry<String, String> entry : text.entrySet()) {
                    writableNativeMap.putString(entry.getKey(), entry.getValue());
                }
            }
            promise.resolve(writableNativeMap);
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getTranslatedText(String key, Promise promise) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Didomi.INSTANCE.getInstance().getTranslatedText(key));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getUserConsentStatusForPurpose(String purposeId, Promise promise) {
        Intrinsics.checkNotNullParameter(purposeId, "purposeId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Didomi.INSTANCE.getInstance().getUserConsentStatusForPurpose(purposeId));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getUserConsentStatusForVendor(String vendorId, Promise promise) {
        Intrinsics.checkNotNullParameter(vendorId, "vendorId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Didomi.INSTANCE.getInstance().getUserConsentStatusForVendor(vendorId));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getUserConsentStatusForVendorAndRequiredPurposes(String vendorId, Promise promise) {
        Intrinsics.checkNotNullParameter(vendorId, "vendorId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Didomi.INSTANCE.getInstance().getUserConsentStatusForVendorAndRequiredPurposes(vendorId));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getUserLegitimateInterestStatusForPurpose(String purposeId, Promise promise) {
        Intrinsics.checkNotNullParameter(purposeId, "purposeId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Didomi.INSTANCE.getInstance().getUserLegitimateInterestStatusForPurpose(purposeId));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getUserLegitimateInterestForVendor(String vendorId, Promise promise) {
        Intrinsics.checkNotNullParameter(vendorId, "vendorId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Didomi.INSTANCE.getInstance().getUserLegitimateInterestStatusForVendor(vendorId));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getUserLegitimateInterestStatusForVendorAndRequiredPurposes(String vendorId, Promise promise) {
        Intrinsics.checkNotNullParameter(vendorId, "vendorId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Boolean.valueOf(Didomi.INSTANCE.getInstance().getUserLegitimateInterestStatusForVendorAndRequiredPurposes(vendorId)));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getUserStatus(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(objectToWritableMap(Didomi.INSTANCE.getInstance().getUserStatus()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getUserStatusForVendor(String vendorId, Promise promise) {
        Intrinsics.checkNotNullParameter(vendorId, "vendorId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Boolean.valueOf(Didomi.INSTANCE.getInstance().getUserStatusForVendor(vendorId)));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void getVendor(String vendorId, Promise promise) {
        Intrinsics.checkNotNullParameter(vendorId, "vendorId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(objectToWritableMap(Didomi.INSTANCE.getInstance().getVendor(vendorId)));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void hideNotice(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Didomi.INSTANCE.getInstance().hideNotice();
            promise.resolve(0);
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void hidePreferences(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Didomi.INSTANCE.getInstance().hidePreferences();
            promise.resolve(0);
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void isConsentRequired(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Boolean.valueOf(Didomi.INSTANCE.getInstance().isConsentRequired()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void isUserConsentStatusPartial(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Boolean.valueOf(Didomi.INSTANCE.getInstance().isUserConsentStatusPartial()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void isNoticeVisible(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Boolean.valueOf(Didomi.INSTANCE.getInstance().isNoticeVisible()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void isPreferencesVisible(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Boolean.valueOf(Didomi.INSTANCE.getInstance().isPreferencesVisible()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void isError(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Boolean.valueOf(Didomi.INSTANCE.getInstance().getIsError()));
    }

    @ReactMethod
    public final void isReady(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Boolean.valueOf(Didomi.INSTANCE.getInstance().getIsReady()));
    }

    @ReactMethod
    public final void clearUser(Promise promise) throws DidomiNotReadyException {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Didomi.INSTANCE.getInstance().clearUser();
        promise.resolve(0);
    }

    @ReactMethod
    public final void setUser(String organizationUserId, String organizationUserIdAuthAlgorithm, String organizationUserIdAuthSid, String organizationUserIdAuthSalt, String organizationUserIdAuthDigest, Promise promise) {
        Intrinsics.checkNotNullParameter(organizationUserId, "organizationUserId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (organizationUserIdAuthAlgorithm != null && organizationUserIdAuthSid != null && organizationUserIdAuthSalt != null && organizationUserIdAuthDigest != null) {
            Didomi.INSTANCE.getInstance().setUser(organizationUserId, organizationUserIdAuthAlgorithm, organizationUserIdAuthSid, organizationUserIdAuthSalt, organizationUserIdAuthDigest);
        } else {
            Didomi.setUser$default(Didomi.INSTANCE.getInstance(), organizationUserId, (FragmentActivity) null, 2, (Object) null);
        }
        promise.resolve(0);
    }

    @ReactMethod
    public final void setUserAndSetupUI(String organizationUserId, Promise promise) {
        Intrinsics.checkNotNullParameter(organizationUserId, "organizationUserId");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Didomi companion = Didomi.INSTANCE.getInstance();
        Activity currentActivity = getCurrentActivity();
        companion.setUser(organizationUserId, currentActivity instanceof FragmentActivity ? (FragmentActivity) currentActivity : null);
        promise.resolve(0);
    }

    @ReactMethod
    public final void setUserWithHashAuth(String organizationUserId, String algorithm, String secretId, String digest, String salt, Promise promise) {
        Intrinsics.checkNotNullParameter(organizationUserId, "organizationUserId");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(secretId, "secretId");
        Intrinsics.checkNotNullParameter(digest, "digest");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Didomi.setUser$default(Didomi.INSTANCE.getInstance(), new UserAuthWithHashParams(organizationUserId, algorithm, secretId, digest, salt, null, 32, null), (FragmentActivity) null, 2, (Object) null);
        promise.resolve(0);
    }

    @ReactMethod
    public final void setUserWithHashAuthAndSetupUI(String organizationUserId, String algorithm, String secretId, String digest, String salt, Promise promise) {
        Intrinsics.checkNotNullParameter(organizationUserId, "organizationUserId");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(secretId, "secretId");
        Intrinsics.checkNotNullParameter(digest, "digest");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Didomi companion = Didomi.INSTANCE.getInstance();
        UserAuthWithHashParams userAuthWithHashParams = new UserAuthWithHashParams(organizationUserId, algorithm, secretId, digest, salt, null, 32, null);
        Activity currentActivity = getCurrentActivity();
        companion.setUser(userAuthWithHashParams, currentActivity instanceof FragmentActivity ? (FragmentActivity) currentActivity : null);
        promise.resolve(0);
    }

    @ReactMethod
    public final void setUserWithHashAuthWithExpiration(String organizationUserId, String algorithm, String secretId, String digest, String salt, int expiration, Promise promise) {
        Intrinsics.checkNotNullParameter(organizationUserId, "organizationUserId");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(secretId, "secretId");
        Intrinsics.checkNotNullParameter(digest, "digest");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Didomi.setUser$default(Didomi.INSTANCE.getInstance(), new UserAuthWithHashParams(organizationUserId, algorithm, secretId, digest, salt, Long.valueOf(expiration)), (FragmentActivity) null, 2, (Object) null);
        promise.resolve(0);
    }

    @ReactMethod
    public final void setUserWithHashAuthWithExpirationAndSetupUI(String organizationUserId, String algorithm, String secretId, String digest, String salt, int expiration, Promise promise) {
        Intrinsics.checkNotNullParameter(organizationUserId, "organizationUserId");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(secretId, "secretId");
        Intrinsics.checkNotNullParameter(digest, "digest");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Didomi companion = Didomi.INSTANCE.getInstance();
        UserAuthWithHashParams userAuthWithHashParams = new UserAuthWithHashParams(organizationUserId, algorithm, secretId, digest, salt, Long.valueOf(expiration));
        Activity currentActivity = getCurrentActivity();
        companion.setUser(userAuthWithHashParams, currentActivity instanceof FragmentActivity ? (FragmentActivity) currentActivity : null);
        promise.resolve(0);
    }

    @ReactMethod
    public final void setUserWithEncryptionAuth(String organizationUserId, String algorithm, String secretId, String initializationVector, Promise promise) {
        Intrinsics.checkNotNullParameter(organizationUserId, "organizationUserId");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(secretId, "secretId");
        Intrinsics.checkNotNullParameter(initializationVector, "initializationVector");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Didomi.setUser$default(Didomi.INSTANCE.getInstance(), new UserAuthWithEncryptionParams(organizationUserId, algorithm, secretId, initializationVector, null, 16, null), (FragmentActivity) null, 2, (Object) null);
        promise.resolve(0);
    }

    @ReactMethod
    public final void setUserWithEncryptionAuthAndSetupUI(String organizationUserId, String algorithm, String secretId, String initializationVector, Promise promise) {
        Intrinsics.checkNotNullParameter(organizationUserId, "organizationUserId");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(secretId, "secretId");
        Intrinsics.checkNotNullParameter(initializationVector, "initializationVector");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Didomi companion = Didomi.INSTANCE.getInstance();
        UserAuthWithEncryptionParams userAuthWithEncryptionParams = new UserAuthWithEncryptionParams(organizationUserId, algorithm, secretId, initializationVector, null, 16, null);
        Activity currentActivity = getCurrentActivity();
        companion.setUser(userAuthWithEncryptionParams, currentActivity instanceof FragmentActivity ? (FragmentActivity) currentActivity : null);
        promise.resolve(0);
    }

    @ReactMethod
    public final void setUserWithEncryptionAuthWithExpiration(String organizationUserId, String algorithm, String secretId, String initializationVector, int expiration, Promise promise) {
        Intrinsics.checkNotNullParameter(organizationUserId, "organizationUserId");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(secretId, "secretId");
        Intrinsics.checkNotNullParameter(initializationVector, "initializationVector");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Didomi.setUser$default(Didomi.INSTANCE.getInstance(), new UserAuthWithEncryptionParams(organizationUserId, algorithm, secretId, initializationVector, Long.valueOf(expiration)), (FragmentActivity) null, 2, (Object) null);
        promise.resolve(0);
    }

    @ReactMethod
    public final void setUserWithEncryptionAuthWithExpirationAndSetupUI(String organizationUserId, String algorithm, String secretId, String initializationVector, int expiration, Promise promise) {
        Intrinsics.checkNotNullParameter(organizationUserId, "organizationUserId");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(secretId, "secretId");
        Intrinsics.checkNotNullParameter(initializationVector, "initializationVector");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Didomi companion = Didomi.INSTANCE.getInstance();
        UserAuthWithEncryptionParams userAuthWithEncryptionParams = new UserAuthWithEncryptionParams(organizationUserId, algorithm, secretId, initializationVector, Long.valueOf(expiration));
        Activity currentActivity = getCurrentActivity();
        companion.setUser(userAuthWithEncryptionParams, currentActivity instanceof FragmentActivity ? (FragmentActivity) currentActivity : null);
        promise.resolve(0);
    }

    @ReactMethod
    public final void showNotice(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativedidomi.DidomiModule$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws DidomiNotReadyException {
                    DidomiModule.showNotice$lambda$10(this.f$0);
                }
            });
            promise.resolve(0);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNotice$lambda$10(DidomiModule didomiModule) throws DidomiNotReadyException {
        Didomi companion = Didomi.INSTANCE.getInstance();
        Activity currentActivity = didomiModule.getCurrentActivity();
        companion.showNotice(currentActivity instanceof FragmentActivity ? (FragmentActivity) currentActivity : null);
    }

    @ReactMethod
    public final void showPreferences(final String view, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativedidomi.DidomiModule$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() throws DidomiNotReadyException {
                    DidomiModule.showPreferences$lambda$12(view, this);
                }
            });
            promise.resolve(0);
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPreferences$lambda$12(String str, DidomiModule didomiModule) throws DidomiNotReadyException {
        if (str != null) {
            Didomi companion = Didomi.INSTANCE.getInstance();
            Activity currentActivity = didomiModule.getCurrentActivity();
            companion.showPreferences(currentActivity instanceof FragmentActivity ? (FragmentActivity) currentActivity : null, str);
        } else {
            Didomi companion2 = Didomi.INSTANCE.getInstance();
            Activity currentActivity2 = didomiModule.getCurrentActivity();
            Didomi.showPreferences$default(companion2, currentActivity2 instanceof FragmentActivity ? (FragmentActivity) currentActivity2 : null, null, 2, null);
        }
    }

    @ReactMethod
    public final void reset(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Didomi.INSTANCE.getInstance().reset();
            promise.resolve(0);
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void setUserAgreeToAll(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Boolean.valueOf(Didomi.INSTANCE.getInstance().setUserAgreeToAll()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @Deprecated
    @ReactMethod
    public final void setUserConsentStatus(ReadableArray enabledPurposeIds, ReadableArray disabledPurposeIds, ReadableArray enabledLegitimatePurposeIds, ReadableArray disabledLegitimatePurposeIds, ReadableArray enabledVendorIds, ReadableArray disabledVendorIds, ReadableArray enabledLegIntVendorIds, ReadableArray disabledLegIntVendorIds, Promise promise) {
        Intrinsics.checkNotNullParameter(enabledPurposeIds, "enabledPurposeIds");
        Intrinsics.checkNotNullParameter(disabledPurposeIds, "disabledPurposeIds");
        Intrinsics.checkNotNullParameter(enabledLegitimatePurposeIds, "enabledLegitimatePurposeIds");
        Intrinsics.checkNotNullParameter(disabledLegitimatePurposeIds, "disabledLegitimatePurposeIds");
        Intrinsics.checkNotNullParameter(enabledVendorIds, "enabledVendorIds");
        Intrinsics.checkNotNullParameter(disabledVendorIds, "disabledVendorIds");
        Intrinsics.checkNotNullParameter(enabledLegIntVendorIds, "enabledLegIntVendorIds");
        Intrinsics.checkNotNullParameter(disabledLegIntVendorIds, "disabledLegIntVendorIds");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Boolean.valueOf(Didomi.INSTANCE.getInstance().setUserStatus(toSet(enabledPurposeIds), toSet(disabledPurposeIds), toSet(enabledLegitimatePurposeIds), toSet(disabledLegitimatePurposeIds), toSet(enabledVendorIds), toSet(disabledVendorIds), toSet(enabledLegIntVendorIds), toSet(disabledLegIntVendorIds))));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void setUserDisagreeToAll(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Boolean.valueOf(Didomi.INSTANCE.getInstance().setUserDisagreeToAll()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void setUserStatus(boolean purposesConsentStatus, boolean purposesLIStatus, boolean vendorsConsentStatus, boolean vendorsLIStatus, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Boolean.valueOf(Didomi.INSTANCE.getInstance().setUserStatus(purposesConsentStatus, purposesLIStatus, vendorsConsentStatus, vendorsLIStatus)));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void setUserStatusSets(ReadableArray enabledConsentPurposeIds, ReadableArray disabledConsentPurposeIds, ReadableArray enabledLIPurposeIds, ReadableArray disabledLIPurposeIds, ReadableArray enabledConsentVendorIds, ReadableArray disabledConsentVendorIds, ReadableArray enabledLIVendorIds, ReadableArray disabledLIVendorIds, Promise promise) {
        Intrinsics.checkNotNullParameter(enabledConsentPurposeIds, "enabledConsentPurposeIds");
        Intrinsics.checkNotNullParameter(disabledConsentPurposeIds, "disabledConsentPurposeIds");
        Intrinsics.checkNotNullParameter(enabledLIPurposeIds, "enabledLIPurposeIds");
        Intrinsics.checkNotNullParameter(disabledLIPurposeIds, "disabledLIPurposeIds");
        Intrinsics.checkNotNullParameter(enabledConsentVendorIds, "enabledConsentVendorIds");
        Intrinsics.checkNotNullParameter(disabledConsentVendorIds, "disabledConsentVendorIds");
        Intrinsics.checkNotNullParameter(enabledLIVendorIds, "enabledLIVendorIds");
        Intrinsics.checkNotNullParameter(disabledLIVendorIds, "disabledLIVendorIds");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Boolean.valueOf(Didomi.INSTANCE.getInstance().setUserStatus(toSet(enabledConsentPurposeIds), toSet(disabledConsentPurposeIds), toSet(enabledLIPurposeIds), toSet(disabledLIPurposeIds), toSet(enabledConsentVendorIds), toSet(disabledConsentVendorIds), toSet(enabledLIVendorIds), toSet(disabledLIVendorIds))));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void shouldConsentBeCollected(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            promise.resolve(Boolean.valueOf(Didomi.INSTANCE.getInstance().shouldConsentBeCollected()));
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public final void updateSelectedLanguage(String languageCode, Promise promise) {
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Didomi.INSTANCE.getInstance().updateSelectedLanguage(languageCode);
            promise.resolve(0);
        } catch (DidomiNotReadyException e) {
            promise.reject(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareEvent(String eventName, String params) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(eventName, params);
    }
}
