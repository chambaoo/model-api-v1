package com.example.api.v1.application.base;

public interface UseCase<I extends Input, O extends Output> {
  O handle(I input);
}
