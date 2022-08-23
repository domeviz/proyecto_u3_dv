package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IPersonaFunctionUnaryOperator<T> {

	T apply(T arg1);
}
