/*
 *  Copyright 2001-2009 Stephen Colebourne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.joda.primitives;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 * Generates the entire suite of classes.
 * 
 * @author Stephen Colebourne
 * @since 1.0
 */
public class CodeGenerator {

    /**
     * Main entry point to the code generator.
     * 
     * @param args
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            if (args[0].endsWith(".vm") == false) {
                args = TEMPLATE_FILENAMES;
            }
        }
        if (args.length == 0) {
            args = TEMPLATE_FILENAMES;
        }
        try {
            System.out.println("Started");
            process(args);
            System.out.println("Finished");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
    
    //-----------------------------------------------------------------------
    /**
     * Process all the templates.
     */
    private static void process(final String[] templateNames) throws Exception {
        Velocity.init();
        init();
        for (int i = 0; i < templateNames.length; i++) {
            int pos = templateNames[i].indexOf("codegen");
            if (pos >= 0) {
                templateNames[i] = templateNames[i].substring(pos + 8);
            }
            if (templateNames[i].endsWith(".vm")) {
                templateNames[i] = templateNames[i].substring(0, templateNames[i].length() - 3);
            }
            System.out.println(templateNames[i]);
            process(templateNames[i]);
//            System.out.print('.');
        }
        System.out.println();
    }
    
    //-----------------------------------------------------------------------
    /**
     * Initialize by reading the license.
     */
    private static void init() throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("src/codegen/java/LICENSE-HEADER.txt"));
        StringBuffer buf = new StringBuffer();
        String line = null;
        while ((line = in.readLine()) != null) {
            buf.append(line);
            buf.append(((char) 13));
            buf.append(((char) 10));
        }
        LICENSE = buf.substring(0, buf.length() - 2);
        in.close();
    }
    
    //-----------------------------------------------------------------------
    /**
     * Process a single template.
     */
    private static void process(final String templateName) throws Exception {
        final Template template = Velocity.getTemplate("src/codegen/java/" + templateName + ".vm");
        
        // init data
        for (int i = 0; i < TYPES.length; i++) {
            VelocityContext context = new VelocityContext(TYPES[i]);
            context.put("license", LICENSE);
        
            // merge
            StringWriter sw = new StringWriter();
            template.merge(context, sw);
        
            // create output filename
            String fileName = templateName + ".java";
            int pos = fileName.indexOf("XXX");
            if (pos >= 0) {
                fileName = fileName.substring(0, pos) + context.get("Type") + fileName.substring(pos + 3);
            }
        
            // output
            int lastSlash = templateName.lastIndexOf('/') == -1 ?
                    templateName.lastIndexOf('\\') : templateName.lastIndexOf('/');
            String dirName = templateName.substring(0, lastSlash);
            if (fileName.indexOf("Test") >= 0) {
                dirName = "src/test/java/" + dirName;
                new File(dirName).mkdir();
                FileWriter writer = new FileWriter("src/test/java/" + fileName);
                writer.write(sw.toString());
                writer.close();
            } else {
                dirName = "src/main/java/" + dirName;
                new File(dirName).mkdir();
                FileWriter writer = new FileWriter("src/main/java/" + fileName);
                writer.write(sw.toString());
                writer.close();
            }
        }
    }

    //-----------------------------------------------------------------------
    private static String LICENSE = "";
    
    @SuppressWarnings("unchecked")
    private static final Map<String,String>[] TYPES = new Map[] {
        new HashMap<String,String>(), new HashMap<String,String>(), new HashMap<String,String>(), new HashMap<String,String>(),
        new HashMap<String,String>(), new HashMap<String,String>(), new HashMap<String,String>(), new HashMap<String,String>()
    };
    
    static {
        TYPES[0].put("type", "long");
        TYPES[0].put("Type", "Long");
        TYPES[0].put("object", "Long");
        TYPES[0].put("emptyArray", "EMPTY_LONG_ARRAY");
        TYPES[0].put("toObjectPre", "new Long(");
        TYPES[0].put("toObjectPost", ")");
        TYPES[0].put("assertExtra", "");
        TYPES[0].put("testValue0", "0L");
        TYPES[0].put("testValue1", "6L");
        TYPES[0].put("testValue2", "2L");
        TYPES[0].put("testValues", "new Long(2),new Long(-2),new Long(38)," +
            "new Long(0),new Long(10000),new Long(202)," +
            "new Long(Long.MIN_VALUE),new Long(Long.MAX_VALUE)");
        TYPES[0].put("otherValues", "new Long(-33),new Long(66),new Long(-99)");
        
        TYPES[1].put("type", "int");
        TYPES[1].put("Type", "Int");
        TYPES[1].put("object", "Integer");
        TYPES[1].put("emptyArray", "EMPTY_INT_ARRAY");
        TYPES[1].put("toObjectPre", "new Integer(");
        TYPES[1].put("toObjectPost", ")");
        TYPES[1].put("assertExtra", "");
        TYPES[1].put("testValue0", "0");
        TYPES[1].put("testValue1", "6");
        TYPES[1].put("testValue2", "2");
        TYPES[1].put("testValues", "new Integer(2),new Integer(-2),new Integer(38)," +
            "new Integer(0),new Integer(10000),new Integer(202)," +
            "new Integer(Integer.MIN_VALUE),new Integer(Integer.MAX_VALUE)");
        TYPES[1].put("otherValues", "new Integer(-33),new Integer(66),new Integer(-99)");
        
        TYPES[2].put("type", "short");
        TYPES[2].put("Type", "Short");
        TYPES[2].put("object", "Short");
        TYPES[2].put("emptyArray", "EMPTY_SHORT_ARRAY");
        TYPES[2].put("toObjectPre", "new Short(");
        TYPES[2].put("toObjectPost", ")");
        TYPES[2].put("assertExtra", "");
        TYPES[2].put("testValue0", "(short) 0");
        TYPES[2].put("testValue1", "(short) 6");
        TYPES[2].put("testValue2", "(short) 2");
        TYPES[2].put("testValues", "new Short((short)2),new Short((short)-2),new Short((short)38),"+
            "new Short((short)0),new Short((short)1000),new Short((short)202)," +
            "new Short(Short.MIN_VALUE),new Short(Short.MAX_VALUE)");
        TYPES[2].put("otherValues", "new Short((short)-33),new Short((short)66),new Short((short)-99)");
        
        TYPES[3].put("type", "byte");
        TYPES[3].put("Type", "Byte");
        TYPES[3].put("object", "Byte");
        TYPES[3].put("emptyArray", "EMPTY_BYTE_ARRAY");
        TYPES[3].put("toObjectPre", "new Byte(");
        TYPES[3].put("toObjectPost", ")");
        TYPES[3].put("assertExtra", "");
        TYPES[3].put("testValue0", "(byte) 0");
        TYPES[3].put("testValue1", "(byte) 6");
        TYPES[3].put("testValue2", "(byte) 2");
        TYPES[3].put("testValues", "new Byte((byte)2),new Byte((byte)-2),new Byte((byte)38)," +
            "new Byte((byte)0),new Byte((byte)126),new Byte((byte)202)," +
            "new Byte(Byte.MIN_VALUE),new Byte(Byte.MAX_VALUE)");
        TYPES[3].put("otherValues", "new Byte((byte)-33),new Byte((byte)66),new Byte((byte)-99)");
        
        TYPES[4].put("type", "double");
        TYPES[4].put("Type", "Double");
        TYPES[4].put("object", "Double");
        TYPES[4].put("emptyArray", "EMPTY_DOUBLE_ARRAY");
        TYPES[4].put("toObjectPre", "new Double(");
        TYPES[4].put("toObjectPost", ")");
        TYPES[4].put("assertExtra", ", 0.00001d");
        TYPES[4].put("testValue0", "0d");
        TYPES[4].put("testValue1", "-0.9d");
        TYPES[4].put("testValue2", "3.5d");
        TYPES[4].put("testValues", "new Double(2d),new Double(-2d),new Double(38.765d)," +
            "new Double(0d),new Double(10000d),new Double(202d)," +
            "new Double(Double.MIN_VALUE),new Double(Double.MAX_VALUE)");
        TYPES[4].put("otherValues", "new Double(-33d),new Double(66d),new Double(-99d)");
        
        TYPES[5].put("type", "float");
        TYPES[5].put("Type", "Float");
        TYPES[5].put("object", "Float");
        TYPES[5].put("emptyArray", "EMPTY_FLOAT_ARRAY");
        TYPES[5].put("toObjectPre", "new Float(");
        TYPES[5].put("toObjectPost", ")");
        TYPES[5].put("assertExtra", ", 0.00001f");
        TYPES[5].put("testValue0", "0f");
        TYPES[5].put("testValue1", "0.1f");
        TYPES[5].put("testValue2", "12.6f");
        TYPES[5].put("testValues", "new Float(2f),new Float(-2f),new Float(38.874f)," +
            "new Float(0f),new Float(10000f),new Float(202f)," +
            "new Float(Float.MIN_VALUE),new Float(Float.MAX_VALUE)");
        TYPES[5].put("otherValues", "new Float(-33f),new Float(66f),new Float(-99f)");
        
        TYPES[6].put("type", "char");
        TYPES[6].put("Type", "Char");
        TYPES[6].put("object", "Character");
        TYPES[6].put("emptyArray", "EMPTY_CHAR_ARRAY");
        TYPES[6].put("toObjectPre", "new Character(");
        TYPES[6].put("toObjectPost", ")");
        TYPES[6].put("assertExtra", "");
        TYPES[6].put("testValue0", "(char) 0");
        TYPES[6].put("testValue1", "'A'");
        TYPES[6].put("testValue2", "'Z'");
        TYPES[6].put("testValues", "new Character((char)2),new Character('a'),new Character('@')," +
            "new Character('Z'),new Character((char)5000),new Character((char)202)," +
            "new Character(Character.MIN_VALUE),new Character(Character.MAX_VALUE)");
        TYPES[6].put("otherValues", "new Character('S'),new Character('J'),new Character('C')");
        
        TYPES[7].put("type", "boolean");
        TYPES[7].put("Type", "Boolean");
        TYPES[7].put("object", "Boolean");
        TYPES[7].put("emptyArray", "EMPTY_BOOLEAN_ARRAY");
        TYPES[7].put("toObjectPre", "(");
        TYPES[7].put("toObjectPost", " ? Boolean.TRUE : Boolean.FALSE)");
        TYPES[7].put("assertExtra", "");
        TYPES[7].put("testValue0", "false");
        TYPES[7].put("testValue1", "true");
        TYPES[7].put("testValue2", "false");
        TYPES[7].put("testValues", "Boolean.TRUE");
        TYPES[7].put("otherValues", "Boolean.FALSE");
    }

    private static final String[] TEMPLATE_FILENAMES = new String[] {
        "org/joda/primitives/XXXUtils",
        
        "org/joda/primitives/collection/XXXCollection",
        "org/joda/primitives/iterator/XXXIterator",
        "org/joda/primitives/list/XXXList",
        "org/joda/primitives/listiterator/XXXListIterator",
        
        "org/joda/primitives/iterator/impl/ArrayXXXIterator",
        "org/joda/primitives/collection/impl/AbstractXXXCollection",
        "org/joda/primitives/collection/impl/ArrayXXXCollection",
        "org/joda/primitives/listiterator/impl/ArrayXXXListIterator",
        "org/joda/primitives/list/impl/AbstractXXXList",
        "org/joda/primitives/list/impl/ArrayXXXList",
        "org/joda/primitives/list/impl/ImmutableArrayXXXList",
        
        "org/joda/primitives/collection/impl/AbstractTestXXXCollection",
        "org/joda/primitives/collection/impl/TestArrayXXXCollection",
        "org/joda/primitives/iterator/impl/TestArrayXXXIterator",
        "org/joda/primitives/list/impl/AbstractTestXXXList",
        "org/joda/primitives/list/impl/TestArrayXXXList",
        "org/joda/primitives/list/impl/TestImmutableArrayXXXList",
    };

}
