package com.jalitha.rentcloud.rentservice.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.function.Supplier;

public class CommonHystrixCommand<T> extends HystrixCommand<T> {

    Supplier<T> execute;
    Supplier<T> fallback;

    public CommonHystrixCommand(String group, Supplier<T> execute) {
        super(HystrixCommandGroupKey.Factory.asKey(group));
        this.execute = execute;
        this.fallback = fallback;
    }

    public CommonHystrixCommand(String group, Supplier<T> execute, Supplier<T> fallback) {
        super(HystrixCommandGroupKey.Factory.asKey(group));
        this.execute = execute;
        this.fallback = fallback;
    }

    public CommonHystrixCommand(Setter setter, Supplier<T> execute) {
        super(setter);
        this.execute = execute;
    }

    public CommonHystrixCommand(Setter setter, Supplier<T> execute, Supplier<T> fallback) {
        super(setter);
        this.execute = execute;
        this.fallback = fallback;
    }



    @Override
    protected T run() throws Exception {
        return execute.get();
    }

    @Override
    protected T getFallback() {
        if(fallback != null)
            return fallback.get();
        return super.getFallback();
    }
}
