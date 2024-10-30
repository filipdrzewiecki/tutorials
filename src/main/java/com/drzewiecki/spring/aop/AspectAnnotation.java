package com.drzewiecki.spring.aop;

public class AspectAnnotation {

//    @Around(value = "@annotation(anno)", argNames = "jp, anno") // aspect method who have the annotation @Delegate
//    public Object handle(ProceedingJoinPoint joinPoint, Delegate delegate) throws Exception {
//        Object obj = joinPoint.getThis(); // get the object
//        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod(); // get the origin method
//        Method target = obj.getClass().getMethod(delegate.value(), method.getParameterTypes()); // get the delegate method
//        return target.invoke(obj, joinPoint.getArgs()); // invoke the delegate method
//    }

}
