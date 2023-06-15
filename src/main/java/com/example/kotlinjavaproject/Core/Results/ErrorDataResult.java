package com.example.kotlinjavaproject.Core.Results;

public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult() {
        super(false);
    }

    public ErrorDataResult(String message) {
        super(false, message);
    }

    public ErrorDataResult(T data) {
        super(false, data);
    }

    public ErrorDataResult(T data, String message) {
        super(false, data, message);
    }
}
