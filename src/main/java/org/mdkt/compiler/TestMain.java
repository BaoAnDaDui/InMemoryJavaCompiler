package org.mdkt.compiler;

import java.lang.reflect.Method;

/**
 * @author wang xiao
 * date 2022/12/20
 */
public class TestMain {


    public static void main(String[] args) throws Exception {
        StringBuilder sourceCode = new StringBuilder();
        sourceCode.append("package org.mdkt;\n");
        sourceCode.append("public class HelloClass {\n");
        sourceCode.append("   public String hello() { return \"hello\"; }");
        sourceCode.append("}");

        Class<?> helloClass = InMemoryJavaCompiler.newInstance().compile("org.mdkt.HelloClass", sourceCode.toString());
        Method helloClassMethod = helloClass.getMethod("hello");
        Object invoke = helloClassMethod.invoke(helloClass.getDeclaredConstructor().newInstance());
        System.out.println(invoke);

    }
}
