
package com.butterfill.opb.jsedemo;

import com.butterfill.opb.plsql.translation.PlsqlTranslator;
import java.io.File;

/**
 * Demonstrates the translation of PL/SQL code into Opb compatible Java classes.
 * <br/>
 * PL/SQL package specifications in src/main/sql/ are tranaslated into Java files.
 * The generated Java code is created in the package com.butterfill.opb.jsedemo.data.
 * <br/>
 * <b>To run this demo;</b>
 * <ul>
 * <li>Run the main method of this class.</li>
 * </ul>
 *
 */
public class SimpleTranslationDemoMain {

    /**
     * Translates the PL/SQL package specifications in src/main/sql/
     * writing Java files to the com.butterfill.opb.jsedemo.data.
     *
     * then
     *
     * Translates the PL/SQL package specifications in src/main/sql/object-graph
     * writing Java files to the com.butterfill.opb.jsedemo.objectgraph.data.
     *
     * @param args not used.
     */
    public static void main(String[] args) throws Exception {

        PlsqlTranslator translator = new PlsqlTranslator();

        File[] sourceFiles =
                new File[] {
                new File("src/main/sql/array_demo_spc.sql"),
                new File("src/main/sql/boolean_demo.sql"),
                new File("src/main/sql/user_defined_collection_demo.sql"),
                new File("src/main/sql/dbms_output.spc")};

        File outputDir = new File(
                "src/main/java/com/butterfill/opb/jsedemo/data");

        translator.toJava(sourceFiles, outputDir, "com.butterfill.opb.jsedemo.data");

        sourceFiles =
                new File[] {
                new File("src/main/sql/object-graph/address.spc"),
                new File("src/main/sql/object-graph/addresses.spc"),
                new File("src/main/sql/object-graph/city.spc"),
                new File("src/main/sql/object-graph/cities.spc"),
                new File("src/main/sql/object-graph/person.spc"),
                new File("src/main/sql/object-graph/people.spc")};

        outputDir = new File(
                "src/main/java/com/butterfill/opb/jsedemo/objectgraph/data");

        translator.toJava(sourceFiles, outputDir, "com.butterfill.opb.jsedemo.objectgraph.data");

    }

}
