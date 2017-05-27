package com.luoding.frame.aop;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-12-6 下午11:20
 */
public class TargetImpl implements Target {

    @Override
    public long getTime() {
        return System.currentTimeMillis();
    }
}
