package com.opentok.android;

import com.adjust.sdk.network.ErrorCodes;
import com.opentok.impl.a;
import io.didomi.ssl.config.app.SyncConfiguration;

/* JADX INFO: loaded from: classes4.dex */
public class OpentokError {
    protected ErrorCode errorCode;
    protected Domain errorDomain;
    protected String errorMessage;
    protected Exception exception;

    public enum Domain {
        SessionErrorDomain,
        PublisherErrorDomain,
        SubscriberErrorDomain
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'MediaTransformerInvalidType' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class ErrorCode {
        private static final /* synthetic */ ErrorCode[] $VALUES;
        public static final ErrorCode MediaTransformerCustomCallbackNotProvided;
        public static final ErrorCode MediaTransformerInternalError;
        public static final ErrorCode MediaTransformerInvalidType;
        public static final ErrorCode MediaTransformerModelNotFound;
        public static final ErrorCode MediaTransformerNameNotProvided;
        public static final ErrorCode MediaTransformerOpenTokTransformersLibraryNotLoaded;
        public static final ErrorCode MediaTransformerOpenTokTransformersSymbolNotFound;
        public static final ErrorCode MediaTransformerPropertiesNotProvided;
        public static final ErrorCode OpenTokTransformersCustomRadiusPropertyNotProvided;
        public static final ErrorCode OpenTokTransformersImageFilePathNotFound;
        public static final ErrorCode OpenTokTransformersImageFilePathPropertyNotProvided;
        public static final ErrorCode OpenTokTransformersInternalError;
        public static final ErrorCode OpenTokTransformersInvalidCustomRadiusProperty;
        public static final ErrorCode OpenTokTransformersInvalidName;
        public static final ErrorCode OpenTokTransformersInvalidParam;
        public static final ErrorCode OpenTokTransformersInvalidPropertiesFormat;
        public static final ErrorCode OpenTokTransformersInvalidRadiusProperty;
        public static final ErrorCode OpenTokTransformersMlTransformerInitError;
        public static final ErrorCode OpenTokTransformersModelFileNotFound;
        public static final ErrorCode OpenTokTransformersNameNotProvided;
        public static final ErrorCode OpenTokTransformersPropertiesNotProvided;
        public static final ErrorCode OpenTokTransformersRadiusPropertyNotProvided;
        private final int code;
        public static final ErrorCode UnknownError = new ErrorCode("UnknownError", 0, -1);
        public static final ErrorCode AuthorizationFailure = new ErrorCode("AuthorizationFailure", 1, ErrorCodes.PROTOCOL_EXCEPTION);
        public static final ErrorCode InvalidSessionId = new ErrorCode("InvalidSessionId", 2, 1005);
        public static final ErrorCode ConnectionFailed = new ErrorCode("ConnectionFailed", 3, ErrorCodes.SSL_HANDSHAKE_EXCEPTION);
        public static final ErrorCode NoMessagingServer = new ErrorCode("NoMessagingServer", 4, 1503);
        public static final ErrorCode ConnectionRefused = new ErrorCode("ConnectionRefused", 5, 1023);
        public static final ErrorCode SessionStateFailed = new ErrorCode("SessionStateFailed", 6, 1020);
        public static final ErrorCode P2PSessionMaxParticipants = new ErrorCode("P2PSessionMaxParticipants", 7, 1403);
        public static final ErrorCode SessionConnectionTimeout = new ErrorCode("SessionConnectionTimeout", 8, 1021);
        public static final ErrorCode SessionInternalError = new ErrorCode("SessionInternalError", 9, 2000);
        public static final ErrorCode SessionInvalidSignalType = new ErrorCode("SessionInvalidSignalType", 10, 1461);
        public static final ErrorCode SessionSignalDataTooLong = new ErrorCode("SessionSignalDataTooLong", 11, 1413);
        public static final ErrorCode SessionSignalTypeTooLong = new ErrorCode("SessionSignalTypeTooLong", 12, 1414);
        public static final ErrorCode SessionUnableToForceDisconnect = new ErrorCode("SessionUnableToForceDisconnect", 13, 1520);
        public static final ErrorCode SessionUnableToForceMute = new ErrorCode("SessionUnableToForceMute", 14, 1540);
        public static final ErrorCode SessionUnableToSendSignal = new ErrorCode("SessionUnableToSendSignal", 15, 1550);
        public static final ErrorCode ConnectionDropped = new ErrorCode("ConnectionDropped", 16, 1022);
        public static final ErrorCode SessionDisconnected = new ErrorCode("SessionDisconnected", 17, 1010);
        public static final ErrorCode PublisherInternalError = new ErrorCode("PublisherInternalError", 18, 2000);
        public static final ErrorCode PublisherWebRTCError = new ErrorCode("PublisherWebRTCError", 19, 1610);
        public static final ErrorCode PublisherUnableToPublish = new ErrorCode("PublisherUnableToPublish", 20, 1500);
        public static final ErrorCode PublisherUnexpectedPeerConnectionDisconnection = new ErrorCode("PublisherUnexpectedPeerConnectionDisconnection", 21, 1710);
        public static final ErrorCode PublisherCannotAccessCamera = new ErrorCode("PublisherCannotAccessCamera", 22, 1650);
        public static final ErrorCode PublisherCameraAccessDenied = new ErrorCode("PublisherCameraAccessDenied", 23, 1670);
        public static final ErrorCode ConnectionTimedOut = new ErrorCode("ConnectionTimedOut", 24, 1542);
        public static final ErrorCode SubscriberWebRTCError = new ErrorCode("SubscriberWebRTCError", 25, 1600);
        public static final ErrorCode SubscriberServerCannotFindStream = new ErrorCode("SubscriberServerCannotFindStream", 26, 1604);
        public static final ErrorCode SubscriberStreamLimitExceeded = new ErrorCode("SubscriberStreamLimitExceeded", 27, 1605);
        public static final ErrorCode SubscriberInternalError = new ErrorCode("SubscriberInternalError", 28, 2000);
        public static final ErrorCode UnknownPublisherInstance = new ErrorCode("UnknownPublisherInstance", 29, 2003);
        public static final ErrorCode UnknownSubscriberInstance = new ErrorCode("UnknownSubscriberInstance", 30, 2004);
        public static final ErrorCode SessionNullOrInvalidParameter = new ErrorCode("SessionNullOrInvalidParameter", 31, 1011);
        public static final ErrorCode VideoCaptureFailed = new ErrorCode("VideoCaptureFailed", 32, SyncConfiguration.DEFAULT_TIMEOUT);
        public static final ErrorCode CameraFailed = new ErrorCode("CameraFailed", 33, 3010);
        public static final ErrorCode VideoRenderFailed = new ErrorCode("VideoRenderFailed", 34, 4000);
        public static final ErrorCode SessionSubscriberNotFound = new ErrorCode("SessionSubscriberNotFound", 35, 1112);
        public static final ErrorCode SessionPublisherNotFound = new ErrorCode("SessionPublisherNotFound", 36, 1113);
        public static final ErrorCode PublisherTimeout = new ErrorCode("PublisherTimeout", 37, 1541);
        public static final ErrorCode SessionBlockedCountry = new ErrorCode("SessionBlockedCountry", 38, 1026);
        public static final ErrorCode SessionConnectionLimitExceeded = new ErrorCode("SessionConnectionLimitExceeded", 39, 1027);
        public static final ErrorCode SessionUnexpectedGetSessionInfoResponse = new ErrorCode("SessionUnexpectedGetSessionInfoResponse", 40, 2001);
        public static final ErrorCode SessionIllegalState = new ErrorCode("SessionIllegalState", 41, 1015);
        public static final ErrorCode EncryptionSecretMissing = new ErrorCode("EncryptionSecretMissing", 42, 6000);
        public static final ErrorCode EncryptionInternalError = new ErrorCode("EncryptionInternalError", 43, 6001);
        public static final ErrorCode DecryptionInternalError = new ErrorCode("DecryptionInternalError", 44, 6002);
        public static final ErrorCode EncryptionSecretMismatch = new ErrorCode("EncryptionSecretMismatch", 45, 6003);
        public static final ErrorCode InvalidEncryptionSecret = new ErrorCode("InvalidEncryptionSecret", 46, 6004);
        public static final ErrorCode EncryptionUnsupportedCodec = new ErrorCode("EncryptionUnsupportedCodec", 47, 6005);
        public static final ErrorCode DecryptionUnsupportedCodec = new ErrorCode("DecryptionUnsupportedCodec", 48, 6006);

        private static /* synthetic */ ErrorCode[] $values() {
            return new ErrorCode[]{UnknownError, AuthorizationFailure, InvalidSessionId, ConnectionFailed, NoMessagingServer, ConnectionRefused, SessionStateFailed, P2PSessionMaxParticipants, SessionConnectionTimeout, SessionInternalError, SessionInvalidSignalType, SessionSignalDataTooLong, SessionSignalTypeTooLong, SessionUnableToForceDisconnect, SessionUnableToForceMute, SessionUnableToSendSignal, ConnectionDropped, SessionDisconnected, PublisherInternalError, PublisherWebRTCError, PublisherUnableToPublish, PublisherUnexpectedPeerConnectionDisconnection, PublisherCannotAccessCamera, PublisherCameraAccessDenied, ConnectionTimedOut, SubscriberWebRTCError, SubscriberServerCannotFindStream, SubscriberStreamLimitExceeded, SubscriberInternalError, UnknownPublisherInstance, UnknownSubscriberInstance, SessionNullOrInvalidParameter, VideoCaptureFailed, CameraFailed, VideoRenderFailed, SessionSubscriberNotFound, SessionPublisherNotFound, PublisherTimeout, SessionBlockedCountry, SessionConnectionLimitExceeded, SessionUnexpectedGetSessionInfoResponse, SessionIllegalState, EncryptionSecretMissing, EncryptionInternalError, DecryptionInternalError, EncryptionSecretMismatch, InvalidEncryptionSecret, EncryptionUnsupportedCodec, DecryptionUnsupportedCodec, MediaTransformerInternalError, MediaTransformerInvalidType, MediaTransformerNameNotProvided, MediaTransformerCustomCallbackNotProvided, MediaTransformerPropertiesNotProvided, MediaTransformerModelNotFound, MediaTransformerOpenTokTransformersLibraryNotLoaded, MediaTransformerOpenTokTransformersSymbolNotFound, OpenTokTransformersInternalError, OpenTokTransformersInvalidParam, OpenTokTransformersNameNotProvided, OpenTokTransformersInvalidName, OpenTokTransformersPropertiesNotProvided, OpenTokTransformersInvalidPropertiesFormat, OpenTokTransformersModelFileNotFound, OpenTokTransformersRadiusPropertyNotProvided, OpenTokTransformersInvalidRadiusProperty, OpenTokTransformersCustomRadiusPropertyNotProvided, OpenTokTransformersInvalidCustomRadiusProperty, OpenTokTransformersImageFilePathPropertyNotProvided, OpenTokTransformersImageFilePathNotFound, OpenTokTransformersMlTransformerInitError};
        }

        static {
            ErrorCode errorCode = new ErrorCode("MediaTransformerInternalError", 49, 167772160);
            MediaTransformerInternalError = errorCode;
            MediaTransformerInvalidType = new ErrorCode("MediaTransformerInvalidType", 50, errorCode.code + 1);
            MediaTransformerNameNotProvided = new ErrorCode("MediaTransformerNameNotProvided", 51, errorCode.code + 2);
            MediaTransformerCustomCallbackNotProvided = new ErrorCode("MediaTransformerCustomCallbackNotProvided", 52, errorCode.code + 3);
            MediaTransformerPropertiesNotProvided = new ErrorCode("MediaTransformerPropertiesNotProvided", 53, errorCode.code + 4);
            MediaTransformerModelNotFound = new ErrorCode("MediaTransformerModelNotFound", 54, errorCode.code + 5);
            MediaTransformerOpenTokTransformersLibraryNotLoaded = new ErrorCode("MediaTransformerOpenTokTransformersLibraryNotLoaded", 55, errorCode.code + 6);
            MediaTransformerOpenTokTransformersSymbolNotFound = new ErrorCode("MediaTransformerOpenTokTransformersSymbolNotFound", 56, errorCode.code + 7);
            ErrorCode errorCode2 = new ErrorCode("OpenTokTransformersInternalError", 57, 184549376);
            OpenTokTransformersInternalError = errorCode2;
            OpenTokTransformersInvalidParam = new ErrorCode("OpenTokTransformersInvalidParam", 58, errorCode2.code + 1);
            OpenTokTransformersNameNotProvided = new ErrorCode("OpenTokTransformersNameNotProvided", 59, errorCode2.code + 2);
            OpenTokTransformersInvalidName = new ErrorCode("OpenTokTransformersInvalidName", 60, errorCode2.code + 3);
            OpenTokTransformersPropertiesNotProvided = new ErrorCode("OpenTokTransformersPropertiesNotProvided", 61, errorCode2.code + 4);
            OpenTokTransformersInvalidPropertiesFormat = new ErrorCode("OpenTokTransformersInvalidPropertiesFormat", 62, errorCode2.code + 5);
            OpenTokTransformersModelFileNotFound = new ErrorCode("OpenTokTransformersModelFileNotFound", 63, errorCode2.code + 6);
            OpenTokTransformersRadiusPropertyNotProvided = new ErrorCode("OpenTokTransformersRadiusPropertyNotProvided", 64, errorCode2.code + 7);
            OpenTokTransformersInvalidRadiusProperty = new ErrorCode("OpenTokTransformersInvalidRadiusProperty", 65, errorCode2.code + 8);
            OpenTokTransformersCustomRadiusPropertyNotProvided = new ErrorCode("OpenTokTransformersCustomRadiusPropertyNotProvided", 66, errorCode2.code + 9);
            OpenTokTransformersInvalidCustomRadiusProperty = new ErrorCode("OpenTokTransformersInvalidCustomRadiusProperty", 67, errorCode2.code + 10);
            OpenTokTransformersImageFilePathPropertyNotProvided = new ErrorCode("OpenTokTransformersImageFilePathPropertyNotProvided", 68, errorCode2.code + 11);
            OpenTokTransformersImageFilePathNotFound = new ErrorCode("OpenTokTransformersImageFilePathNotFound", 69, errorCode2.code + 12);
            OpenTokTransformersMlTransformerInitError = new ErrorCode("OpenTokTransformersMlTransformerInitError", 70, errorCode2.code + 13);
            $VALUES = $values();
        }

        private ErrorCode(String str, int i, int i2) {
            super(str, i);
            this.code = i2;
        }

        public static ErrorCode fromTypeCode(int i) {
            for (ErrorCode errorCode : values()) {
                if (errorCode.getErrorCode() == i) {
                    return errorCode;
                }
            }
            return UnknownError;
        }

        public static ErrorCode valueOf(String str) {
            return (ErrorCode) Enum.valueOf(ErrorCode.class, str);
        }

        public static ErrorCode[] values() {
            return (ErrorCode[]) $VALUES.clone();
        }

        public int getErrorCode() {
            return this.code;
        }
    }

    public OpentokError(Domain domain, int i, String str) {
        this.errorMessage = str == null ? "(null description)" : str;
        this.errorDomain = domain;
        this.errorCode = ErrorCode.fromTypeCode(i);
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public Domain getErrorDomain() {
        return this.errorDomain;
    }

    public Exception getException() {
        return this.exception;
    }

    public String getMessage() {
        return this.errorMessage;
    }

    public OpentokError(Domain domain, int i, Exception exc) {
        this.errorMessage = exc == null ? "(null description)" : exc.getMessage();
        this.errorDomain = domain;
        this.errorCode = ErrorCode.fromTypeCode(i);
        this.exception = exc;
        if (exc == null) {
            this.errorMessage = a.a(i);
        }
    }
}
