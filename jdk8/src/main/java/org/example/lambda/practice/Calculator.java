package org.example.lambda.practice;

/**
 * 用于操作两个数值的函数借口
 *
 * @param <T> 参数类型
 * @param <R> 返回类型
 */
public interface Calculator<T, R> {
    R calc(T t1, T t2);
}
