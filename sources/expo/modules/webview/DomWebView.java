package expo.modules.webview;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.firebase.messaging.Constants;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.JavaScriptValue;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001;\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010*\u001a\u00020(2\b\u0010+\u001a\u0004\u0018\u00010\u0015J\u000e\u0010,\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0015J\u000e\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\u0015J\u000e\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u0015J\u000e\u00101\u001a\u00020(2\u0006\u00102\u001a\u000203J\u001c\u00104\u001a\u00020\u00172\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020\nH\u0003J\r\u0010:\u001a\u00020;H\u0002¢\u0006\u0002\u0010<J\u001e\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010?R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\r\u001a\u00060\u000ej\u0002`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$¨\u0006@"}, d2 = {"Lexpo/modules/webview/DomWebView;", "Lexpo/modules/kotlin/views/ExpoView;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "webViewId", "", "Lexpo/modules/webview/WebViewId;", "getWebViewId", "()I", Constants.ScionAnalytics.PARAM_SOURCE, "Lexpo/modules/webview/DomWebViewSource;", "injectedJSBeforeContentLoaded", "", "webviewDebuggingEnabled", "", "getWebviewDebuggingEnabled", "()Z", "setWebviewDebuggingEnabled", "(Z)V", "nestedScrollEnabled", "getNestedScrollEnabled", "setNestedScrollEnabled", "needsResetupScripts", "onMessage", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "Lexpo/modules/webview/OnMessageEvent;", "getOnMessage", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onMessage$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "reload", "", "setSource", "setInjectedJSBeforeContentLoaded", "script", "injectJavaScript", "dispatchMessageEvent", "message", "evalSync", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "scrollTo", "param", "Lexpo/modules/webview/ScrollToParam;", "onTouch", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "createWebView", "createWebViewClient", "expo/modules/webview/DomWebView$createWebViewClient$1", "()Lexpo/modules/webview/DomWebView$createWebViewClient$1;", "nativeJsiEvalSync", "deferredId", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-dom-webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
public final class DomWebView extends ExpoView implements View.OnTouchListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DomWebView.class, "onMessage", "getOnMessage()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    private String injectedJSBeforeContentLoaded;
    private boolean needsResetupScripts;
    private boolean nestedScrollEnabled;

    /* JADX INFO: renamed from: onMessage$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onMessage;
    private DomWebViewSource source;
    private final WebView webView;
    private final int webViewId;
    private boolean webviewDebuggingEnabled;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DomWebView(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.webViewId = DomWebViewRegistry.INSTANCE.add(this);
        this.nestedScrollEnabled = true;
        this.onMessage = new ViewEventDelegate(this, null);
        WebView webViewCreateWebView = createWebView();
        this.webView = webViewCreateWebView;
        addView(webViewCreateWebView, new ViewGroup.LayoutParams(-1, -1));
    }

    public final WebView getWebView() {
        return this.webView;
    }

    public final int getWebViewId() {
        return this.webViewId;
    }

    public final boolean getWebviewDebuggingEnabled() {
        return this.webviewDebuggingEnabled;
    }

    public final void setWebviewDebuggingEnabled(boolean z) {
        this.webviewDebuggingEnabled = z;
    }

    public final boolean getNestedScrollEnabled() {
        return this.nestedScrollEnabled;
    }

    public final void setNestedScrollEnabled(boolean z) {
        this.nestedScrollEnabled = z;
    }

    private final ViewEventCallback getOnMessage() {
        return this.onMessage.getValue(this, $$delegatedProperties[0]);
    }

    public final void reload() {
        String uri;
        WebView.setWebContentsDebuggingEnabled(this.webviewDebuggingEnabled);
        DomWebViewSource domWebViewSource = this.source;
        if (domWebViewSource != null && (uri = domWebViewSource.getUri()) != null) {
            if (Intrinsics.areEqual(uri, this.webView.getUrl())) {
                return;
            }
            this.webView.loadUrl(uri);
        } else if (this.needsResetupScripts) {
            this.needsResetupScripts = false;
            this.webView.reload();
        }
    }

    public final void setSource(DomWebViewSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    public final void setInjectedJSBeforeContentLoaded(String script) {
        String str;
        if (script == null || script.length() == 0) {
            str = null;
        } else {
            str = "(function() { " + script + "; })();true;";
        }
        this.injectedJSBeforeContentLoaded = str;
        this.needsResetupScripts = true;
    }

    public final void injectJavaScript(final String script) {
        Intrinsics.checkNotNullParameter(script, "script");
        this.webView.post(new Runnable() { // from class: expo.modules.webview.DomWebView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DomWebView.injectJavaScript$lambda$1(this.f$0, script);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void injectJavaScript$lambda$1(DomWebView domWebView, String str) {
        domWebView.webView.evaluateJavascript(str, null);
    }

    public final void dispatchMessageEvent(final String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.webView.post(new Runnable() { // from class: expo.modules.webview.DomWebView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                DomWebView.dispatchMessageEvent$lambda$2(this.f$0, message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchMessageEvent$lambda$2(DomWebView domWebView, String str) {
        String title = domWebView.webView.getTitle();
        if (title == null) {
            title = "";
        }
        String url = domWebView.webView.getUrl();
        domWebView.getOnMessage().invoke(new OnMessageEvent(title, url != null ? url : "", str));
    }

    public final String evalSync(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        JSONObject jSONObject = new JSONObject(data);
        return (String) BuildersKt__BuildersKt.runBlocking$default(null, new C11141(jSONObject.getInt("deferredId"), jSONObject.getString(Constants.ScionAnalytics.PARAM_SOURCE), null), 1, null);
    }

    /* JADX INFO: renamed from: expo.modules.webview.DomWebView$evalSync$1, reason: invalid class name and case insensitive filesystem */
    static final class C11141 extends SuspendLambda implements Function2 {
        final /* synthetic */ int $deferredId;
        final /* synthetic */ String $source;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11141(int i, String str, Continuation continuation) {
            super(2, continuation);
            this.$deferredId = i;
            this.$source = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DomWebView.this.new C11141(this.$deferredId, this.$source, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            DomWebView domWebView = DomWebView.this;
            int i2 = this.$deferredId;
            String str = this.$source;
            Intrinsics.checkNotNull(str);
            this.label = 1;
            Object objNativeJsiEvalSync = domWebView.nativeJsiEvalSync(i2, str, this);
            return objNativeJsiEvalSync == coroutine_suspended ? coroutine_suspended : objNativeJsiEvalSync;
        }
    }

    public final void scrollTo(final ScrollToParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.webView.post(new Runnable() { // from class: expo.modules.webview.DomWebView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DomWebView.scrollTo$lambda$3(param, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scrollTo$lambda$3(ScrollToParam scrollToParam, DomWebView domWebView) {
        if (!scrollToParam.getAnimated()) {
            domWebView.webView.scrollTo((int) scrollToParam.getX(), (int) scrollToParam.getY());
            return;
        }
        WebView webView = domWebView.webView;
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(webView, "scrollX", webView.getScrollX(), (int) scrollToParam.getX());
        objectAnimatorOfInt.setDuration(250L);
        WebView webView2 = domWebView.webView;
        ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(webView2, "scrollY", webView2.getScrollY(), (int) scrollToParam.getY());
        objectAnimatorOfInt2.setDuration(250L);
        objectAnimatorOfInt.start();
        objectAnimatorOfInt2.start();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        if (!this.nestedScrollEnabled) {
            return false;
        }
        requestDisallowInterceptTouchEvent(true);
        return false;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final WebView createWebView() {
        WebView webView = new WebView(getContext());
        webView.setBackgroundColor(0);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(createWebViewClient());
        webView.addJavascriptInterface(new RNCWebViewBridge(this), "ReactNativeWebView");
        webView.addJavascriptInterface(new DomWebViewBridge(this), "ExpoDomWebViewBridge");
        webView.setOnTouchListener(this);
        return webView;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [expo.modules.webview.DomWebView$createWebViewClient$1] */
    private final AnonymousClass1 createWebViewClient() {
        return new WebViewClient() { // from class: expo.modules.webview.DomWebView.createWebViewClient.1
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                DomWebView domWebView = DomWebView.this;
                domWebView.injectJavaScript(StringsKt.replace$default("\n// browserScripts/InstallGlobals/Deferred.ts\nclass Deferred {\n  promise;\n  resolveCallback;\n  rejectCallback;\n  constructor() {\n    this.promise = new Promise((resolve, reject) => {\n      this.resolveCallback = resolve;\n      this.rejectCallback = reject;\n    });\n  }\n  resolve(value) {\n    this.resolveCallback(value);\n  }\n  reject(reason) {\n    this.rejectCallback(reason);\n  }\n  getPromise() {\n    return this.promise;\n  }\n}\n\n// browserScripts/InstallGlobals/EventEmitterProxy.ts\nclass EventEmitterProxy {\n  moduleName;\n  listeners;\n  constructor(moduleName) {\n    this.moduleName = moduleName;\n  }\n  addListener = (eventName, listener) => {\n    if (!this.listeners) {\n      this.listeners = new Map;\n    }\n    if (!this.listeners.has(eventName)) {\n      this.listeners.set(eventName, new Set);\n    }\n    this.listeners.get(eventName)?.add(listener);\n    const nativeListenerId = window.ExpoDomWebView.nextEventListenerId++;\n    listener.$$nativeListenerId = nativeListenerId;\n    const source = `\n      globalThis.expo.$$DomWebViewEventListenerMap ||= {};\n      globalThis.expo.$$DomWebViewEventListenerMap['${eventName}'] ||= new Map();\n      const listener = (...args) => {\n        const serializeArgs = args.map((arg) => JSON.stringify(arg)).join(',');\n        const script = 'window.ExpoDomWebView.eventEmitterProxy.${this.moduleName}.emit(\"${eventName}\", ' + serializeArgs + ')';\n        globalThis.expo.modules.ExpoDomWebViewModule.evalJsForWebViewAsync(\"%%WEBVIEW_ID%%\", script);\n      };\n      globalThis.expo.$$DomWebViewEventListenerMap['${eventName}'].set(${nativeListenerId}, listener);\n      globalThis.expo.modules.${this.moduleName}.addListener('${eventName}', listener);\n    `;\n    window.ExpoDomWebView.eval(source);\n    return {\n      remove: () => {\n        this.removeListener(eventName, listener);\n      }\n    };\n  };\n  removeListener = (eventName, listener) => {\n    const nativeListenerId = listener.$$nativeListenerId;\n    if (nativeListenerId != null) {\n      const source = `(function() {\n        const nativeListener = globalThis.expo.$$DomWebViewEventListenerMap['${eventName}'].get(${nativeListenerId});\n        if (nativeListener != null) {\n          globalThis.expo.modules.${this.moduleName}.removeListener('${eventName}', nativeListener);\n          globalThis.expo.$$DomWebViewEventListenerMap['${eventName}'].delete(${nativeListenerId});\n        }\n      })();\n      true;\n      `;\n      window.ExpoDomWebView.eval(source);\n    }\n    this.listeners?.get(eventName)?.delete(listener);\n  };\n  removeAllListeners = (eventName) => {\n    const source = `\n      globalThis.expo.$$DomWebViewEventListenerMap['${eventName}'].clear();\n      globalThis.expo.modules.${this.moduleName}.removeAllListeners('${eventName}');\n    `;\n    window.ExpoDomWebView.eval(source);\n    this.listeners?.get(eventName)?.clear();\n  };\n  emit = (eventName, ...args) => {\n    const listeners = new Set(this.listeners?.get(eventName));\n    listeners.forEach((listener) => {\n      try {\n        listener(...args);\n      } catch (error) {\n        console.error(error);\n      }\n    });\n  };\n}\n\n// browserScripts/InstallGlobals/utils.ts\nfunction serializeArgs(args) {\n  return args.map((arg) => {\n    if (typeof arg === \"object\" && arg.sharedObjectId != null) {\n      return `globalThis.expo.sharedObjectRegistry.get(${arg.sharedObjectId})`;\n    }\n    return JSON.stringify(arg);\n  }).join(\",\");\n}\n\n// browserScripts/InstallGlobals/proxies.ts\nfunction createSharedObjectProxy(sharedObjectId) {\n  return new Proxy({}, {\n    get: (target, prop) => {\n      const name = String(prop);\n      if (name === \"sharedObjectId\") {\n        return sharedObjectId;\n      }\n      return function(...args) {\n        const serializedArgs = serializeArgs(args);\n        const source = `globalThis.expo.sharedObjectRegistry.get(${sharedObjectId})?.${name}?.call(globalThis.expo.sharedObjectRegistry.get(${sharedObjectId}),${serializedArgs})`;\n        return window.ExpoDomWebView.eval(source);\n      };\n    }\n  });\n}\nfunction createConstructorProxy(moduleName, property, propertyName) {\n  return new Proxy(function() {\n  }, {\n    construct(target, args) {\n      const serializedArgs = serializeArgs(args);\n      const sharedObjectId = window.ExpoDomWebView.nextSharedObjectId++;\n      const sharedObjectProxy = createSharedObjectProxy(sharedObjectId);\n      window.ExpoDomWebView.sharedObjectFinalizationRegistry.register(sharedObjectProxy, sharedObjectId);\n      const source = `globalThis.expo.sharedObjectRegistry ||= new Map(); globalThis.expo.sharedObjectRegistry.set(${sharedObjectId}, new ${property}(${serializedArgs}));`;\n      window.ExpoDomWebView.eval(source);\n      return sharedObjectProxy;\n    }\n  });\n}\nfunction createPropertyProxy(propertyTypeCache, moduleName, propertyName) {\n  const property = `globalThis.expo.modules.${moduleName}.${propertyName}`;\n  let propertyType = propertyTypeCache[propertyName];\n  if (!propertyType) {\n    const typeCheck = `${property}?.prototype?.__expo_shared_object_id__ != null ? 'sharedObject' : typeof ${property}`;\n    propertyType = window.ExpoDomWebView.eval(typeCheck);\n    propertyTypeCache[propertyName] = propertyType;\n  }\n  if (propertyType === \"sharedObject\") {\n    return createConstructorProxy(moduleName, property, propertyName);\n  }\n  if (propertyType === \"function\") {\n    return function(...args) {\n      const serializedArgs = serializeArgs(args);\n      const source = `${property}(${serializedArgs})`;\n      return window.ExpoDomWebView.eval(source);\n    };\n  }\n  return window.ExpoDomWebView.eval(property);\n}\nfunction createExpoModuleProxy(moduleName) {\n  const propertyTypeCache = {};\n  return new Proxy({}, {\n    get: (target, prop) => {\n      const name = String(prop);\n      if ([\"addListener\", \"removeListener\", \"removeAllListeners\"].includes(name)) {\n        return window.ExpoDomWebView.eventEmitterProxy[moduleName][name];\n      }\n      return createPropertyProxy(propertyTypeCache, moduleName, name);\n    }\n  });\n}\n\n// browserScripts/InstallGlobals/ExpoDomWebView.ts\nclass ExpoDomWebView {\n  nextDeferredId;\n  nextSharedObjectId;\n  nextEventListenerId;\n  deferredMap;\n  sharedObjectFinalizationRegistry;\n  expoModulesProxy;\n  eventEmitterProxy;\n  constructor() {\n    this.nextDeferredId = 0;\n    this.nextSharedObjectId = 0;\n    this.nextEventListenerId = 0;\n    this.deferredMap = new Map;\n    this.sharedObjectFinalizationRegistry = new FinalizationRegistry((sharedObjectId) => {\n      this.eval(`globalThis.expo.sharedObjectRegistry.delete(${sharedObjectId})`);\n    });\n    const expoModules = {};\n    const eventEmitterProxy = {};\n    this.eval(\"Object.keys(globalThis.expo.modules)\").forEach((name) => {\n      expoModules[name] = createExpoModuleProxy(name);\n      eventEmitterProxy[name] = new EventEmitterProxy(name);\n    });\n    this.expoModulesProxy = expoModules;\n    this.eventEmitterProxy = eventEmitterProxy;\n  }\n  eval(source) {\n    const { deferredId, deferred } = this.createDeferred();\n    const args = JSON.stringify({ source, deferredId });\n    const result = JSON.parse(window.ExpoDomWebViewBridge.eval(args));\n    if (result.isPromise) {\n      return deferred.getPromise();\n    }\n    this.removeDeferred(deferredId);\n    return result.value;\n  }\n  createDeferred() {\n    const deferred = new Deferred;\n    const deferredId = this.nextDeferredId;\n    this.deferredMap.set(deferredId, deferred);\n    this.nextDeferredId += 1;\n    return { deferredId, deferred };\n  }\n  resolveDeferred(deferredId, value) {\n    const deferred = this.deferredMap.get(deferredId);\n    if (deferred) {\n      deferred.resolve(value);\n      this.deferredMap.delete(deferredId);\n    }\n  }\n  rejectDeferred(deferredId, reason) {\n    const deferred = this.deferredMap.get(deferredId);\n    if (deferred) {\n      deferred.reject(reason);\n      this.deferredMap.delete(deferredId);\n    }\n  }\n  removeDeferred(deferredId) {\n    this.deferredMap.delete(deferredId);\n  }\n}\n\n// browserScripts/InstallGlobals/index.ts\nwindow.ExpoDomWebView = new ExpoDomWebView;\n\n", "\"%%WEBVIEW_ID%%\"", String.valueOf(domWebView.getWebViewId()), false, 4, (Object) null));
                String str2 = DomWebView.this.injectedJSBeforeContentLoaded;
                if (str2 != null) {
                    DomWebView.this.injectJavaScript(str2);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object nativeJsiEvalSync(final int i, final String str, Continuation continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        getAppContext().executeOnJavaScriptThread(new Runnable() { // from class: expo.modules.webview.DomWebView$nativeJsiEvalSync$2$1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JavaScriptValue javaScriptValueEval = this.getAppContext().getRuntime().eval(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default("\n// browserScripts/NativeEvalWrapper/index.ts\n(function() {\n  const result = \"%%SOURCE%%\";\n  if (result instanceof Promise) {\n    result.then((resolved) => {\n      const resolvedString = JSON.stringify(resolved);\n      const script = 'window.ExpoDomWebView.resolveDeferred(\"%%DEFERRED_ID%%\", ' + resolvedString + \")\";\n      globalThis.expo.modules.ExpoDomWebViewModule.evalJsForWebViewAsync(\"%%WEBVIEW_ID%%\", script);\n    }).catch((error) => {\n      const errorString = JSON.stringify(error);\n      const script = 'window.ExpoDomWebView.rejectDeferred(\"%%DEFERRED_ID%%\", ' + errorString + \")\";\n      globalThis.expo.modules.ExpoDomWebViewModule.evalJsForWebViewAsync(\"%%WEBVIEW_ID%%\", script);\n    });\n    return JSON.stringify({ isPromise: true, value: null });\n  } else {\n    return JSON.stringify({ isPromise: false, value: result });\n  }\n})();\n\n", "\"%%DEFERRED_ID%%\"", String.valueOf(i), false, 4, (Object) null), "\"%%WEBVIEW_ID%%\"", String.valueOf(this.getWebViewId()), false, 4, (Object) null), "\"%%SOURCE%%\"", str, false, 4, (Object) null));
                    Continuation continuation2 = safeContinuation;
                    Result.Companion companion = Result.Companion;
                    continuation2.resumeWith(Result.m5243constructorimpl(javaScriptValueEval.getString()));
                } catch (Exception e) {
                    Continuation continuation3 = safeContinuation;
                    Result.Companion companion2 = Result.Companion;
                    continuation3.resumeWith(Result.m5243constructorimpl(ResultKt.createFailure(e)));
                }
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
