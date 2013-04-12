package com.butterfill.opb.webdemo;

import com.butterfill.opb.plsql.translation.PlsqlTranslator;
import java.io.File;

/**
 *
 * @author butterp
 */
public class TranslationDemoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        PlsqlTranslator translator = new PlsqlTranslator();
        
        File[] sourceFiles = new File[] { 
                new File("src/main/resources/sql/plsql_base/logger/admin/logger_admin.spc"),
                new File("src/main/resources/sql/plsql_base/logger/admin/logger_flag.spc"),
                new File("src/main/resources/sql/plsql_base/permissions/permission_status.spc"),
                new File("src/main/resources/sql/plsql_base/permissions/permission.spc"),
                new File("src/main/resources/sql/plsql_base/permissions/permissions.spc"),
                new File("src/main/resources/sql/plsql_base/properties/admin/property_value.spc"),
                new File("src/main/resources/sql/plsql_base/properties/admin/property_group.spc"),
                new File("src/main/resources/sql/plsql_base/properties/admin/property_groups.spc"),
                new File("src/main/resources/sql/exception_demo.pck")
        };
        
        File outDir = new File(
                "src/main/java/com/butterfill/opb/webdemo/data");
        
        translator.toJava(sourceFiles, outDir, "com.butterfill.opb.webdemo.data");
        
    }

}
