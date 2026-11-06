package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface c extends IInterface {
    String a() throws RemoteException;

    String b() throws RemoteException;

    Map c() throws RemoteException;

    String d() throws RemoteException;

    public static abstract class a extends Binder implements c {
        private static final String a = "com.amazon.venezia.command.Command";
        static final int b = 1;
        static final int c = 2;
        static final int d = 3;
        static final int e = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, a);
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof c)) {
                return (c) iInterfaceQueryLocalInterface;
            }
            return new C0050a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(a);
                String strB = b();
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(a);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(a);
                String strD = d();
                parcel2.writeNoException();
                parcel2.writeString(strD);
                return true;
            }
            if (i != 4) {
                if (i == 1598968902) {
                    parcel2.writeString(a);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(a);
            Map mapC = c();
            parcel2.writeNoException();
            parcel2.writeMap(mapC);
            return true;
        }

        /* JADX INFO: renamed from: com.amazon.d.a.c$a$a, reason: collision with other inner class name */
        private static class C0050a implements c {
            private IBinder a;

            C0050a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            public String e() {
                return a.a;
            }

            @Override // com.amazon.d.a.c
            public String b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.a);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.c
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.a);
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.c
            public String d() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.a);
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.c
            public Map c() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.a);
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
