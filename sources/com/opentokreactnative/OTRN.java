package com.opentokreactnative;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class OTRN {
    public static OTRN sharedState;
    private ConcurrentHashMap subscriberStreams = new ConcurrentHashMap();
    private ConcurrentHashMap sessions = new ConcurrentHashMap();
    private ConcurrentHashMap subscribers = new ConcurrentHashMap();
    private ConcurrentHashMap publishers = new ConcurrentHashMap();
    private ConcurrentHashMap androidOnTopMap = new ConcurrentHashMap();
    private ConcurrentHashMap androidZOrderMap = new ConcurrentHashMap();
    private ConcurrentHashMap connections = new ConcurrentHashMap();

    public static synchronized OTRN getSharedState() {
        try {
            if (sharedState == null) {
                sharedState = new OTRN();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sharedState;
    }

    public ConcurrentHashMap getAndroidOnTopMap() {
        return this.androidOnTopMap;
    }

    public ConcurrentHashMap getAndroidZOrderMap() {
        return this.androidZOrderMap;
    }

    public ConcurrentHashMap getSubscriberStreams() {
        return this.subscriberStreams;
    }

    public ConcurrentHashMap getSessions() {
        return this.sessions;
    }

    public ConcurrentHashMap getSubscribers() {
        return this.subscribers;
    }

    public ConcurrentHashMap getPublishers() {
        return this.publishers;
    }

    public ConcurrentHashMap getConnections() {
        return this.connections;
    }

    private OTRN() {
    }
}
