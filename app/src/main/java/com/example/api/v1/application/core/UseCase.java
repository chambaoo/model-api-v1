package com.example.api.v1.application.core;

public interface UseCase<TInput extends Input, TOutput extends Output> {
  TOutput handle(TInput input);
}
