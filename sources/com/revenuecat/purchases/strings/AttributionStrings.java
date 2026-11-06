package com.revenuecat.purchases.strings;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/strings/AttributionStrings;", "", "()V", "AMAZON_COULD_NOT_GET_ADID", "", "ATTRIBUTES_SYNC_ERROR", "ATTRIBUTES_SYNC_SUCCESS", "COPYING_ATTRIBUTES_FROM_TO_USER", "DELETING_ATTRIBUTES", "DELETING_ATTRIBUTES_OTHER_USERS", "GOOGLE_PLAY_ADVERTISING_ID_NOT_AVAILABLE", "GOOGLE_PLAY_SERVICES_NOT_INSTALLED_FETCHING_ADVERTISING_IDENTIFIER", "GOOGLE_PLAY_SERVICES_REPAIRABLE_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER", "IO_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER", "MARKING_ATTRIBUTES_SYNCED", "METHOD_CALLED", "NO_SUBSCRIBER_ATTRIBUTES_TO_SYNCHRONIZE", "NO_SUCH_METHOD_WHEN_FETCHING_ADVERTISING_IDENTIFIER", "NULL_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER", "SUBSCRIBER_ATTRIBUTES_ERROR", "TIMEOUT_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER", "UNSYNCED_ATTRIBUTES_COUNT", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AttributionStrings {
    public static final String AMAZON_COULD_NOT_GET_ADID = "Couldn't get Amazon advertising identifier. Message: %s";
    public static final String ATTRIBUTES_SYNC_ERROR = "Error when syncing subscriber attributes. App User ID: %s, Error: %s";
    public static final String ATTRIBUTES_SYNC_SUCCESS = "Subscriber attributes synced successfully for App User ID: %s";
    public static final String COPYING_ATTRIBUTES_FROM_TO_USER = "Copying unsynced subscriber attributes from user %s to user %s";
    public static final String DELETING_ATTRIBUTES = "Deleting subscriber attributes for %s from cache";
    public static final String DELETING_ATTRIBUTES_OTHER_USERS = "Deleting old synced subscriber attributes that don't belong to %s";
    public static final String GOOGLE_PLAY_ADVERTISING_ID_NOT_AVAILABLE = "Google Advertising ID is all zeros, ignoring. Make sure you've added the 'com.google.android.gms.permission.AD_ID' permission in your AndroidManifest file.";
    public static final String GOOGLE_PLAY_SERVICES_NOT_INSTALLED_FETCHING_ADVERTISING_IDENTIFIER = "GooglePlayServices is not installed. Couldn't get advertising identifier. Message: %s";
    public static final String GOOGLE_PLAY_SERVICES_REPAIRABLE_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER = "GooglePlayServicesRepairableException when getting advertising identifier. Message: %s";
    public static final AttributionStrings INSTANCE = new AttributionStrings();
    public static final String IO_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER = "IOException when getting advertising identifier. Message: %s";
    public static final String MARKING_ATTRIBUTES_SYNCED = "Marking the following attributes as synced for App User ID: %s";
    public static final String METHOD_CALLED = "%s called";
    public static final String NO_SUBSCRIBER_ATTRIBUTES_TO_SYNCHRONIZE = "No subscriber attributes to synchronize.";
    public static final String NO_SUCH_METHOD_WHEN_FETCHING_ADVERTISING_IDENTIFIER = "NoSuchMethodError when getting advertising identifier. com.google.android.gms.ads library is not available.";
    public static final String NULL_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER = "NullPointerException when getting advertising identifier. Message: %s";
    public static final String SUBSCRIBER_ATTRIBUTES_ERROR = "There were some subscriber attributes errors: %s";
    public static final String TIMEOUT_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER = "TimeoutException when getting advertising identifier. Message: %s";
    public static final String UNSYNCED_ATTRIBUTES_COUNT = "Found %d unsynced attributes for App User ID: %s";

    private AttributionStrings() {
    }
}
