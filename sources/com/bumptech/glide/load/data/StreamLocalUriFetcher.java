package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class StreamLocalUriFetcher extends LocalUriFetcher {
    private static final UriMatcher URI_MATCHER;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        URI_MATCHER = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public StreamLocalUriFetcher(ContentResolver contentResolver, Uri uri, boolean z) {
        super(contentResolver, uri, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public InputStream loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream inputStreamLoadResourceFromUri = loadResourceFromUri(uri, contentResolver);
        if (inputStreamLoadResourceFromUri != null) {
            return inputStreamLoadResourceFromUri;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    private InputStream loadResourceFromUri(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int iMatch = URI_MATCHER.match(uri);
        if (iMatch != 1) {
            if (iMatch == 3) {
                return openContactPhotoInputStream(contentResolver, uri);
            }
            if (iMatch != 5) {
                if (this.useMediaStoreApisIfAvailable && MediaStoreUtil.isMediaStoreUri(uri) && MediaStoreUtil.isMediaStoreOpenFileApisAvailable()) {
                    return openMediaStoreFileInputStream(uri, contentResolver);
                }
                return contentResolver.openInputStream(uri);
            }
        }
        Uri uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uriLookupContact == null) {
            throw new FileNotFoundException("Contact cannot be found");
        }
        return openContactPhotoInputStream(contentResolver, uriLookupContact);
    }

    private InputStream openContactPhotoInputStream(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    private InputStream openMediaStoreFileInputStream(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = MediaStoreUtil.openAssetFileDescriptor(uri, contentResolver);
        if (assetFileDescriptorOpenAssetFileDescriptor == null) {
            throw new FileNotFoundException("FileDescriptor is null for: " + uri);
        }
        try {
            return assetFileDescriptorOpenAssetFileDescriptor.createInputStream();
        } catch (IOException e) {
            try {
                assetFileDescriptorOpenAssetFileDescriptor.close();
            } catch (Exception unused) {
            }
            throw ((FileNotFoundException) new FileNotFoundException("Unable to create stream").initCause(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public void close(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class getDataClass() {
        return InputStream.class;
    }
}
