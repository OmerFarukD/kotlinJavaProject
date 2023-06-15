package com.example.kotlinjavaproject.Core.Results;

public class DataResult<T> extends Result {

    private T data;
    public DataResult(boolean success) {
        super(success);
    }

    public DataResult(boolean success, String message) {
        super(success, message);
    }
    public DataResult(boolean success, T data) {
        this(success);
        this.data=data;
    }

    public DataResult(boolean success,T data, String message) {
        this(success,message);
        this.data=data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
