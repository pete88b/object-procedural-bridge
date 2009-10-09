/**
 * Copyright (C) 2008 Peter Butterfill.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.butterfill.opb.util;

/**
 *
 * @author Peter Butterfill
 */
public class TestObjectForToString extends TestObjectForToStringSuperClass {
    
    private String logger = "not really a logger";
    
    PrivateClass pri = new PrivateClass();
    PublicClass pub = new PublicClass();
    PrivateStaticClass priStatic = new PrivateStaticClass();
    PublicStaticClass pubStatic = new PublicStaticClass();
    
    String f = "TestObjectForToStringFieldValue";
    
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }
    
    public void testMethod() {
        PrivateClass pri2 = new PrivateClass();
        PublicClass pub2 = new PublicClass();
        PrivateStaticClass priStatic2 = new PrivateStaticClass();
        PublicStaticClass pubStatic2 = new PublicStaticClass();
        System.out.println("");
        System.out.println(pri2);
        System.out.println("");
        System.out.println(pub2);
        System.out.println("");
        System.out.println(priStatic2);
        System.out.println("");
        System.out.println(pubStatic2);
    }
    
    private class PrivateClass {
        String f = "privateClassFieldValue";
        @Override
        public String toString() {
            return OpbToStringHelper.toString(this);
        }
    }
    
    public class PublicClass {
        String f = "publicClassFieldValue";
        @Override
        public String toString() {
            return OpbToStringHelper.toString(this);
        }
    }
    
    private static class PrivateStaticClass {
        String f = "privateStaticClassFieldValue";
        @Override
        public String toString() {
            return OpbToStringHelper.toString(this);
        }
    }
    
    public static class PublicStaticClass {
        String f = "publicStaticClassFieldValue";
        @Override
        public String toString() {
            return OpbToStringHelper.toString(this);
        }
    }
}
