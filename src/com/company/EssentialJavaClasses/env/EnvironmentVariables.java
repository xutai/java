package com.company.EssentialJavaClasses.env;

import java.util.Map;


public class EnvironmentVariables {

    public static void main(String[] args) {
        try {
//            EnvMap.main(args);
            String[] strArr = {
                    "CLASSPATH"
            };
            Env.main(strArr);
        } catch (Exception e) {
            System.err.println("main, caught error:" + e);
        }
    }
}

class EnvMap {
    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                    envName,
                    env.get(envName));
        }
    }
}

class Env {
    public static void main(String[] args) {
        for (String env : args) {
            String value = System.getenv(env);
            if (value != null) {
                System.out.format("%s=%s%n",
                        env, value);
            } else {
                System.out.format("%s is"
                        + " not assigned.%n", env);
            }
        }
    }
}

