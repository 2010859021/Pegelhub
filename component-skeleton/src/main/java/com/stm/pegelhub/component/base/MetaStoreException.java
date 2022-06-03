package com.stm.pegelhub.component.base;

public class MetaStoreException extends RuntimeException {
    public MetaStoreException() {
    }

    public MetaStoreException(String message) {
        super(message);
    }

    public MetaStoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public MetaStoreException(Throwable cause) {
        super(cause);
    }
}
