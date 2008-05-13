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

// $ANTLR 3.0.1 src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g 2008-03-25 12:32:56

package com.butterfill.opb.plsql.translation;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings(value="unchecked")
class PlsqlTreeParser extends PlsqlTreeParserSuperClass {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "T_PARAM", "T_PARAMS", "T_PARAM_MODE", "T_IGNORE", "PACKAGE", "ID", "AUTHID", "IS", "AS", "END", "SEMI", "CONSTANT", "DEFAULT", "NUMBER", "QUOTED_LITERAL", "NULL", "FUNCTION", "RETURN", "PROCEDURE", "PRAGMA", "TYPE", "SUBTYPE", "CURSOR", "EXCEPTION", "ML_COMMENT", "SL_COMMENT", "IN", "OUT", "NOCOPY", "QUOTED_ID", "NEWLINE", "COMMA", "EQUALS", "QUESTION_MARK", "FORWARD_SLASH", "PERCENT", "PIPE", "STAR", "WS", "'.'", "':='", "'('", "')'"
    };
    public static final int COMMA=35;
    public static final int TYPE=24;
    public static final int PRAGMA=23;
    public static final int NOCOPY=32;
    public static final int AS=12;
    public static final int PERCENT=39;
    public static final int END=13;
    public static final int SUBTYPE=25;
    public static final int WS=42;
    public static final int NUMBER=17;
    public static final int T_PARAMS=5;
    public static final int IS=11;
    public static final int T_PARAM=4;
    public static final int QUOTED_LITERAL=18;
    public static final int PROCEDURE=22;
    public static final int OUT=31;
    public static final int T_IGNORE=7;
    public static final int T_PARAM_MODE=6;
    public static final int PACKAGE=8;
    public static final int PIPE=40;
    public static final int IN=30;
    public static final int NEWLINE=34;
    public static final int SEMI=14;
    public static final int FORWARD_SLASH=38;
    public static final int EQUALS=36;
    public static final int QUESTION_MARK=37;
    public static final int CONSTANT=15;
    public static final int FUNCTION=20;
    public static final int RETURN=21;
    public static final int EOF=-1;
    public static final int NULL=19;
    public static final int DEFAULT=16;
    public static final int CURSOR=26;
    public static final int AUTHID=10;
    public static final int ML_COMMENT=28;
    public static final int STAR=41;
    public static final int SL_COMMENT=29;
    public static final int QUOTED_ID=33;
    public static final int ID=9;
    public static final int EXCEPTION=27;

        public PlsqlTreeParser(TreeNodeStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g"; }



    // $ANTLR start startRule
    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:25:1: startRule : createOrReplacePackage ( element )* ;
    public final void startRule() throws RecognitionException {
        try {
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:26:3: ( createOrReplacePackage ( element )* )
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:26:6: createOrReplacePackage ( element )*
            {
            pushFollow(FOLLOW_createOrReplacePackage_in_startRule50);
            createOrReplacePackage();
            _fsp--;

            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:27:6: ( element )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==T_IGNORE||LA1_0==CONSTANT||LA1_0==FUNCTION||LA1_0==PROCEDURE||LA1_0==ML_COMMENT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:27:6: element
            	    {
            	    pushFollow(FOLLOW_element_in_startRule57);
            	    element();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end startRule


    // $ANTLR start createOrReplacePackage
    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:30:1: createOrReplacePackage : ^( PACKAGE ID ) ;
    public final void createOrReplacePackage() throws RecognitionException {
        CommonTree ID1=null;

        try {
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:31:3: ( ^( PACKAGE ID ) )
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:31:6: ^( PACKAGE ID )
            {
            match(input,PACKAGE,FOLLOW_PACKAGE_in_createOrReplacePackage73); 

            match(input, Token.DOWN, null); 
            ID1=(CommonTree)input.LT(1);
            match(input,ID,FOLLOW_ID_in_createOrReplacePackage75); 

            match(input, Token.UP, null); 
            setPlsqlPackageName(ID1.getText());

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end createOrReplacePackage


    // $ANTLR start element
    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:34:1: element : ( mlComment | constantDeclaration | function | procedure | ignore );
    public final void element() throws RecognitionException {
        try {
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:35:3: ( mlComment | constantDeclaration | function | procedure | ignore )
            int alt2=5;
            switch ( input.LA(1) ) {
            case ML_COMMENT:
                {
                alt2=1;
                }
                break;
            case CONSTANT:
                {
                alt2=2;
                }
                break;
            case FUNCTION:
                {
                alt2=3;
                }
                break;
            case PROCEDURE:
                {
                alt2=4;
                }
                break;
            case T_IGNORE:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("34:1: element : ( mlComment | constantDeclaration | function | procedure | ignore );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:35:6: mlComment
                    {
                    pushFollow(FOLLOW_mlComment_in_element94);
                    mlComment();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:36:6: constantDeclaration
                    {
                    pushFollow(FOLLOW_constantDeclaration_in_element101);
                    constantDeclaration();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:37:6: function
                    {
                    pushFollow(FOLLOW_function_in_element108);
                    function();
                    _fsp--;


                    }
                    break;
                case 4 :
                    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:38:6: procedure
                    {
                    pushFollow(FOLLOW_procedure_in_element115);
                    procedure();
                    _fsp--;


                    }
                    break;
                case 5 :
                    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:39:6: ignore
                    {
                    pushFollow(FOLLOW_ignore_in_element122);
                    ignore();
                    _fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end element

    public static class mlComment_return extends TreeRuleReturnScope {
    };

    // $ANTLR start mlComment
    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:42:1: mlComment : ML_COMMENT ;
    public final mlComment_return mlComment() throws RecognitionException {
        mlComment_return retval = new mlComment_return();
        retval.start = input.LT(1);

        try {
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:43:3: ( ML_COMMENT )
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:43:6: ML_COMMENT
            {
            match(input,ML_COMMENT,FOLLOW_ML_COMMENT_in_mlComment136); 
            setMlComment(input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(retval.start),
              input.getTreeAdaptor().getTokenStopIndex(retval.start)));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end mlComment


    // $ANTLR start constantDeclaration
    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:46:1: constantDeclaration : ^( CONSTANT l_id= ID l_datatype= dataType (l_value= literal )? ) ;
    public final void constantDeclaration() throws RecognitionException {
        CommonTree l_id=null;
        dataType_return l_datatype = null;

        literal_return l_value = null;


        try {
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:48:3: ( ^( CONSTANT l_id= ID l_datatype= dataType (l_value= literal )? ) )
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:48:6: ^( CONSTANT l_id= ID l_datatype= dataType (l_value= literal )? )
            {
            match(input,CONSTANT,FOLLOW_CONSTANT_in_constantDeclaration160); 

            match(input, Token.DOWN, null); 
            l_id=(CommonTree)input.LT(1);
            match(input,ID,FOLLOW_ID_in_constantDeclaration164); 
            pushFollow(FOLLOW_dataType_in_constantDeclaration168);
            l_datatype=dataType();
            _fsp--;

            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:48:52: (l_value= literal )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=NUMBER && LA3_0<=NULL)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:48:52: l_value= literal
                    {
                    pushFollow(FOLLOW_literal_in_constantDeclaration172);
                    l_value=literal();
                    _fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 
            addConstant(l_id.getText(), input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(l_datatype.start),
              input.getTreeAdaptor().getTokenStopIndex(l_datatype.start)), (l_value == null) ? null : input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(l_value.start),
              input.getTreeAdaptor().getTokenStopIndex(l_value.start)));

            }

            clearTempData();
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end constantDeclaration

    public static class literal_return extends TreeRuleReturnScope {
    };

    // $ANTLR start literal
    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:52:1: literal : ( NUMBER | QUOTED_LITERAL | NULL );
    public final literal_return literal() throws RecognitionException {
        literal_return retval = new literal_return();
        retval.start = input.LT(1);

        try {
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:53:3: ( NUMBER | QUOTED_LITERAL | NULL )
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:
            {
            if ( (input.LA(1)>=NUMBER && input.LA(1)<=NULL) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_literal0);    throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end literal


    // $ANTLR start function
    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:58:1: function : ^( FUNCTION l_id= ID ^( T_PARAMS ( param )* ) ^( RETURN l_returnType= dataType ) ) ;
    public final void function() throws RecognitionException {
        CommonTree l_id=null;
        dataType_return l_returnType = null;


        initFunction();
        try {
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:61:3: ( ^( FUNCTION l_id= ID ^( T_PARAMS ( param )* ) ^( RETURN l_returnType= dataType ) ) )
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:61:6: ^( FUNCTION l_id= ID ^( T_PARAMS ( param )* ) ^( RETURN l_returnType= dataType ) )
            {
            match(input,FUNCTION,FOLLOW_FUNCTION_in_function240); 

            match(input, Token.DOWN, null); 
            l_id=(CommonTree)input.LT(1);
            match(input,ID,FOLLOW_ID_in_function244); 
            match(input,T_PARAMS,FOLLOW_T_PARAMS_in_function247); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:61:36: ( param )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==T_PARAM) ) {
                        alt4=1;
                    }


                    switch (alt4) {
                	case 1 :
                	    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:61:36: param
                	    {
                	    pushFollow(FOLLOW_param_in_function249);
                	    param();
                	    _fsp--;


                	    }
                	    break;

                	default :
                	    break loop4;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }
            match(input,RETURN,FOLLOW_RETURN_in_function254); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_dataType_in_function258);
            l_returnType=dataType();
            _fsp--;


            match(input, Token.UP, null); 

            match(input, Token.UP, null); 
            setFunctionInfo(l_id.getText(), l_returnType.a, l_returnType.b);

            }

            clearTempData();
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end function


    // $ANTLR start procedure
    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:65:1: procedure : ^( PROCEDURE l_id= ID ^( T_PARAMS ( param )* ) ) ;
    public final void procedure() throws RecognitionException {
        CommonTree l_id=null;

        initProcedure();
        try {
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:68:3: ( ^( PROCEDURE l_id= ID ^( T_PARAMS ( param )* ) ) )
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:68:6: ^( PROCEDURE l_id= ID ^( T_PARAMS ( param )* ) )
            {
            match(input,PROCEDURE,FOLLOW_PROCEDURE_in_procedure296); 

            match(input, Token.DOWN, null); 
            l_id=(CommonTree)input.LT(1);
            match(input,ID,FOLLOW_ID_in_procedure300); 
            match(input,T_PARAMS,FOLLOW_T_PARAMS_in_procedure303); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:68:37: ( param )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==T_PARAM) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:68:37: param
                	    {
                	    pushFollow(FOLLOW_param_in_procedure305);
                	    param();
                	    _fsp--;


                	    }
                	    break;

                	default :
                	    break loop5;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            match(input, Token.UP, null); 
            setProcedureInfo(l_id.getText());

            }

            clearTempData();
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end procedure


    // $ANTLR start ignore
    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:72:1: ignore : T_IGNORE ;
    public final void ignore() throws RecognitionException {
        try {
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:73:3: ( T_IGNORE )
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:73:6: T_IGNORE
            {
            match(input,T_IGNORE,FOLLOW_T_IGNORE_in_ignore329); 
            clearTempData();

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end ignore


    // $ANTLR start param
    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:76:1: param : ^( T_PARAM l_id= ID l_dataType= dataType ^( T_PARAM_MODE (l_in= IN )? (l_out= OUT )? ) ) ;
    public final void param() throws RecognitionException {
        CommonTree l_id=null;
        CommonTree l_in=null;
        CommonTree l_out=null;
        dataType_return l_dataType = null;


        try {
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:77:3: ( ^( T_PARAM l_id= ID l_dataType= dataType ^( T_PARAM_MODE (l_in= IN )? (l_out= OUT )? ) ) )
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:77:6: ^( T_PARAM l_id= ID l_dataType= dataType ^( T_PARAM_MODE (l_in= IN )? (l_out= OUT )? ) )
            {
            match(input,T_PARAM,FOLLOW_T_PARAM_in_param350); 

            match(input, Token.DOWN, null); 
            l_id=(CommonTree)input.LT(1);
            match(input,ID,FOLLOW_ID_in_param354); 
            pushFollow(FOLLOW_dataType_in_param358);
            l_dataType=dataType();
            _fsp--;

            match(input,T_PARAM_MODE,FOLLOW_T_PARAM_MODE_in_param361); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:77:63: (l_in= IN )?
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==IN) ) {
                    alt6=1;
                }
                switch (alt6) {
                    case 1 :
                        // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:77:63: l_in= IN
                        {
                        l_in=(CommonTree)input.LT(1);
                        match(input,IN,FOLLOW_IN_in_param365); 

                        }
                        break;

                }

                // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:77:73: (l_out= OUT )?
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==OUT) ) {
                    alt7=1;
                }
                switch (alt7) {
                    case 1 :
                        // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:77:73: l_out= OUT
                        {
                        l_out=(CommonTree)input.LT(1);
                        match(input,OUT,FOLLOW_OUT_in_param370); 

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }

            match(input, Token.UP, null); 
            addParam(l_id.getText(), l_dataType.a, l_dataType.b, l_in, l_out);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end param

    public static class dataType_return extends TreeRuleReturnScope {
        public String a;
        public String b;
    };

    // $ANTLR start dataType
    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:81:1: dataType returns [String a, String b] : (l_a= id '.' )? l_b= id ( '(' NUMBER ( ',' NUMBER )? ')' )? ;
    public final dataType_return dataType() throws RecognitionException {
        dataType_return retval = new dataType_return();
        retval.start = input.LT(1);

        id_return l_a = null;

        id_return l_b = null;


        try {
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:82:3: ( (l_a= id '.' )? l_b= id ( '(' NUMBER ( ',' NUMBER )? ')' )? )
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:82:6: (l_a= id '.' )? l_b= id ( '(' NUMBER ( ',' NUMBER )? ')' )?
            {
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:82:6: (l_a= id '.' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ID||LA8_0==QUOTED_ID) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==43) ) {
                    alt8=1;
                }
            }
            switch (alt8) {
                case 1 :
                    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:82:7: l_a= id '.'
                    {
                    pushFollow(FOLLOW_id_in_dataType400);
                    l_a=id();
                    _fsp--;

                    match(input,43,FOLLOW_43_in_dataType402); 

                    }
                    break;

            }

            pushFollow(FOLLOW_id_in_dataType408);
            l_b=id();
            _fsp--;

            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:82:27: ( '(' NUMBER ( ',' NUMBER )? ')' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==45) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:82:28: '(' NUMBER ( ',' NUMBER )? ')'
                    {
                    match(input,45,FOLLOW_45_in_dataType411); 
                    match(input,NUMBER,FOLLOW_NUMBER_in_dataType413); 
                    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:82:39: ( ',' NUMBER )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==COMMA) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:82:40: ',' NUMBER
                            {
                            match(input,COMMA,FOLLOW_COMMA_in_dataType416); 
                            match(input,NUMBER,FOLLOW_NUMBER_in_dataType418); 

                            }
                            break;

                    }

                    match(input,46,FOLLOW_46_in_dataType422); 

                    }
                    break;

            }

            retval.a =(l_a == null) ? null : input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(l_a.start),
              input.getTreeAdaptor().getTokenStopIndex(l_a.start)); retval.b =input.getTokenStream().toString(
              input.getTreeAdaptor().getTokenStartIndex(l_b.start),
              input.getTreeAdaptor().getTokenStopIndex(l_b.start));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end dataType

    public static class id_return extends TreeRuleReturnScope {
    };

    // $ANTLR start id
    // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:86:1: id : ( ID | QUOTED_ID );
    public final id_return id() throws RecognitionException {
        id_return retval = new id_return();
        retval.start = input.LT(1);

        try {
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:87:3: ( ID | QUOTED_ID )
            // src/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:
            {
            if ( input.LA(1)==ID||input.LA(1)==QUOTED_ID ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_id0);    throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end id


 

    public static final BitSet FOLLOW_createOrReplacePackage_in_startRule50 = new BitSet(new long[]{0x0000000010508082L});
    public static final BitSet FOLLOW_element_in_startRule57 = new BitSet(new long[]{0x0000000010508082L});
    public static final BitSet FOLLOW_PACKAGE_in_createOrReplacePackage73 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_createOrReplacePackage75 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_mlComment_in_element94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constantDeclaration_in_element101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_element108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procedure_in_element115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ignore_in_element122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ML_COMMENT_in_mlComment136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANT_in_constantDeclaration160 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_constantDeclaration164 = new BitSet(new long[]{0x0000000200000200L});
    public static final BitSet FOLLOW_dataType_in_constantDeclaration168 = new BitSet(new long[]{0x00000000000E0008L});
    public static final BitSet FOLLOW_literal_in_constantDeclaration172 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function240 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_function244 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_T_PARAMS_in_function247 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_param_in_function249 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_RETURN_in_function254 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_dataType_in_function258 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PROCEDURE_in_procedure296 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_procedure300 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_T_PARAMS_in_procedure303 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_param_in_procedure305 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_T_IGNORE_in_ignore329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_PARAM_in_param350 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_param354 = new BitSet(new long[]{0x0000000200000200L});
    public static final BitSet FOLLOW_dataType_in_param358 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_T_PARAM_MODE_in_param361 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_in_param365 = new BitSet(new long[]{0x0000000080000008L});
    public static final BitSet FOLLOW_OUT_in_param370 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_id_in_dataType400 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_dataType402 = new BitSet(new long[]{0x0000000200000200L});
    public static final BitSet FOLLOW_id_in_dataType408 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_dataType411 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NUMBER_in_dataType413 = new BitSet(new long[]{0x0000400800000000L});
    public static final BitSet FOLLOW_COMMA_in_dataType416 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NUMBER_in_dataType418 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_dataType422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_id0 = new BitSet(new long[]{0x0000000000000002L});

}
