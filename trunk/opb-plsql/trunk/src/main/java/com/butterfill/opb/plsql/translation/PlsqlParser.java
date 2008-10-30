// $ANTLR 3.0.1 src/main/java/com/butterfill/opb/plsql/translation/Plsql.g 2008-10-30 14:49:18

package com.butterfill.opb.plsql.translation;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

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
public class PlsqlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "T_PARAM", "T_PARAMS", "T_PARAM_MODE", "T_IGNORE", "PACKAGE", "ID", "AUTHID", "IS", "AS", "END", "SEMI", "CONSTANT", "DEFAULT", "NUMBER", "QUOTED_LITERAL", "NULL", "FUNCTION", "RETURN", "PROCEDURE", "PRAGMA", "TYPE", "SUBTYPE", "CURSOR", "EXCEPTION", "ML_COMMENT", "SL_COMMENT", "IN", "OUT", "NOCOPY", "QUOTED_ID", "NEWLINE", "COMMA", "EQUALS", "QUESTION_MARK", "FORWARD_SLASH", "PERCENT", "PIPE", "STAR", "EXCLAMATION", "GREATERTHAN", "LESSTHAN", "WS", "'.'", "':='", "'('", "')'"
    };
    public static final int PACKAGE=8;
    public static final int FUNCTION=20;
    public static final int STAR=41;
    public static final int PRAGMA=23;
    public static final int EQUALS=36;
    public static final int T_IGNORE=7;
    public static final int ID=9;
    public static final int SUBTYPE=25;
    public static final int EOF=-1;
    public static final int QUOTED_ID=33;
    public static final int TYPE=24;
    public static final int AS=12;
    public static final int ML_COMMENT=28;
    public static final int IN=30;
    public static final int EXCLAMATION=42;
    public static final int COMMA=35;
    public static final int IS=11;
    public static final int RETURN=21;
    public static final int QUESTION_MARK=37;
    public static final int T_PARAMS=5;
    public static final int PIPE=40;
    public static final int EXCEPTION=27;
    public static final int GREATERTHAN=43;
    public static final int LESSTHAN=44;
    public static final int PERCENT=39;
    public static final int QUOTED_LITERAL=18;
    public static final int NULL=19;
    public static final int DEFAULT=16;
    public static final int NUMBER=17;
    public static final int T_PARAM_MODE=6;
    public static final int SEMI=14;
    public static final int PROCEDURE=22;
    public static final int AUTHID=10;
    public static final int NOCOPY=32;
    public static final int WS=45;
    public static final int NEWLINE=34;
    public static final int OUT=31;
    public static final int SL_COMMENT=29;
    public static final int T_PARAM=4;
    public static final int CONSTANT=15;
    public static final int END=13;
    public static final int CURSOR=26;
    public static final int FORWARD_SLASH=38;

        public PlsqlParser(TokenStream input) {
            super(input);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g"; }


    public static class startRule_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start startRule
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:46:1: startRule : createOrReplacePackage ( invokerRights )? isOrAS ( element )* endOfPackage ;
    public final startRule_return startRule() throws RecognitionException {
        startRule_return retval = new startRule_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        createOrReplacePackage_return createOrReplacePackage1 = null;

        invokerRights_return invokerRights2 = null;

        isOrAS_return isOrAS3 = null;

        element_return element4 = null;

        endOfPackage_return endOfPackage5 = null;



        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:47:3: ( createOrReplacePackage ( invokerRights )? isOrAS ( element )* endOfPackage )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:47:6: createOrReplacePackage ( invokerRights )? isOrAS ( element )* endOfPackage
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_createOrReplacePackage_in_startRule72);
            createOrReplacePackage1=createOrReplacePackage();
            _fsp--;

            adaptor.addChild(root_0, createOrReplacePackage1.getTree());
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:48:6: ( invokerRights )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==AUTHID) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:48:6: invokerRights
                    {
                    pushFollow(FOLLOW_invokerRights_in_startRule79);
                    invokerRights2=invokerRights();
                    _fsp--;

                    adaptor.addChild(root_0, invokerRights2.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_isOrAS_in_startRule87);
            isOrAS3=isOrAS();
            _fsp--;

            adaptor.addChild(root_0, isOrAS3.getTree());
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:50:6: ( element )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ID||LA2_0==FUNCTION||(LA2_0>=PROCEDURE && LA2_0<=CURSOR)||(LA2_0>=ML_COMMENT && LA2_0<=SL_COMMENT)||LA2_0==QUOTED_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:50:6: element
            	    {
            	    pushFollow(FOLLOW_element_in_startRule94);
            	    element4=element();
            	    _fsp--;

            	    adaptor.addChild(root_0, element4.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            pushFollow(FOLLOW_endOfPackage_in_startRule102);
            endOfPackage5=endOfPackage();
            _fsp--;

            adaptor.addChild(root_0, endOfPackage5.getTree());

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end startRule

    public static class createOrReplacePackage_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start createOrReplacePackage
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:54:1: createOrReplacePackage : dotStar PACKAGE ( ID '.' )? packageName= ID -> ^( PACKAGE $packageName) ;
    public final createOrReplacePackage_return createOrReplacePackage() throws RecognitionException {
        createOrReplacePackage_return retval = new createOrReplacePackage_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token packageName=null;
        Token PACKAGE7=null;
        Token ID8=null;
        Token char_literal9=null;
        dotStar_return dotStar6 = null;


        Object packageName_tree=null;
        Object PACKAGE7_tree=null;
        Object ID8_tree=null;
        Object char_literal9_tree=null;
        RewriteRuleTokenStream stream_PACKAGE=new RewriteRuleTokenStream(adaptor,"token PACKAGE");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_dotStar=new RewriteRuleSubtreeStream(adaptor,"rule dotStar");
        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:55:3: ( dotStar PACKAGE ( ID '.' )? packageName= ID -> ^( PACKAGE $packageName) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:55:6: dotStar PACKAGE ( ID '.' )? packageName= ID
            {
            pushFollow(FOLLOW_dotStar_in_createOrReplacePackage120);
            dotStar6=dotStar();
            _fsp--;

            stream_dotStar.add(dotStar6.getTree());
            PACKAGE7=(Token)input.LT(1);
            match(input,PACKAGE,FOLLOW_PACKAGE_in_createOrReplacePackage122); 
            stream_PACKAGE.add(PACKAGE7);

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:55:22: ( ID '.' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ID) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==46) ) {
                    alt3=1;
                }
            }
            switch (alt3) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:55:23: ID '.'
                    {
                    ID8=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_createOrReplacePackage125); 
                    stream_ID.add(ID8);

                    char_literal9=(Token)input.LT(1);
                    match(input,46,FOLLOW_46_in_createOrReplacePackage127); 
                    stream_46.add(char_literal9);


                    }
                    break;

            }

            packageName=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_createOrReplacePackage133); 
            stream_ID.add(packageName);


            // AST REWRITE
            // elements: PACKAGE, packageName
            // token labels: packageName
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_packageName=new RewriteRuleTokenStream(adaptor,"token packageName",packageName);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 55:47: -> ^( PACKAGE $packageName)
            {
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:55:50: ^( PACKAGE $packageName)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_PACKAGE.next(), root_1);

                adaptor.addChild(root_1, stream_packageName.next());

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end createOrReplacePackage

    public static class invokerRights_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start invokerRights
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:59:1: invokerRights : AUTHID ID ->;
    public final invokerRights_return invokerRights() throws RecognitionException {
        invokerRights_return retval = new invokerRights_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AUTHID10=null;
        Token ID11=null;

        Object AUTHID10_tree=null;
        Object ID11_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_AUTHID=new RewriteRuleTokenStream(adaptor,"token AUTHID");

        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:60:3: ( AUTHID ID ->)
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:60:6: AUTHID ID
            {
            AUTHID10=(Token)input.LT(1);
            match(input,AUTHID,FOLLOW_AUTHID_in_invokerRights160); 
            stream_AUTHID.add(AUTHID10);

            ID11=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_invokerRights162); 
            stream_ID.add(ID11);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 60:16: ->
            {
                root_0 = null;
            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end invokerRights

    public static class isOrAS_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start isOrAS
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:64:1: isOrAS : ( IS -> | AS ->);
    public final isOrAS_return isOrAS() throws RecognitionException {
        isOrAS_return retval = new isOrAS_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IS12=null;
        Token AS13=null;

        Object IS12_tree=null;
        Object AS13_tree=null;
        RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
        RewriteRuleTokenStream stream_IS=new RewriteRuleTokenStream(adaptor,"token IS");

        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:65:3: ( IS -> | AS ->)
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IS) ) {
                alt4=1;
            }
            else if ( (LA4_0==AS) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("64:1: isOrAS : ( IS -> | AS ->);", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:65:6: IS
                    {
                    IS12=(Token)input.LT(1);
                    match(input,IS,FOLLOW_IS_in_isOrAS184); 
                    stream_IS.add(IS12);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 65:9: ->
                    {
                        root_0 = null;
                    }



                    }
                    break;
                case 2 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:66:6: AS
                    {
                    AS13=(Token)input.LT(1);
                    match(input,AS,FOLLOW_AS_in_isOrAS193); 
                    stream_AS.add(AS13);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 66:9: ->
                    {
                        root_0 = null;
                    }



                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end isOrAS

    public static class endOfPackage_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start endOfPackage
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:69:1: endOfPackage : END ( ID )? SEMI ( . )* ;
    public final endOfPackage_return endOfPackage() throws RecognitionException {
        endOfPackage_return retval = new endOfPackage_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token END14=null;
        Token ID15=null;
        Token SEMI16=null;
        Token wildcard17=null;

        Object END14_tree=null;
        Object ID15_tree=null;
        Object SEMI16_tree=null;
        Object wildcard17_tree=null;

        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:70:3: ( END ( ID )? SEMI ( . )* )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:70:6: END ( ID )? SEMI ( . )*
            {
            root_0 = (Object)adaptor.nil();

            END14=(Token)input.LT(1);
            match(input,END,FOLLOW_END_in_endOfPackage211); 
            END14_tree = (Object)adaptor.create(END14);
            adaptor.addChild(root_0, END14_tree);

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:70:10: ( ID )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:70:10: ID
                    {
                    ID15=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_endOfPackage213); 
                    ID15_tree = (Object)adaptor.create(ID15);
                    adaptor.addChild(root_0, ID15_tree);


                    }
                    break;

            }

            SEMI16=(Token)input.LT(1);
            match(input,SEMI,FOLLOW_SEMI_in_endOfPackage216); 
            SEMI16_tree = (Object)adaptor.create(SEMI16);
            adaptor.addChild(root_0, SEMI16_tree);

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:70:19: ( . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==EOF) ) {
                    alt6=2;
                }
                else if ( ((LA6_0>=T_PARAM && LA6_0<=49)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:70:19: .
            	    {
            	    wildcard17=(Token)input.LT(1);
            	    matchAny(input); 
            	    wildcard17_tree = (Object)adaptor.create(wildcard17);
            	    adaptor.addChild(root_0, wildcard17_tree);


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end endOfPackage

    public static class element_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start element
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:73:1: element : ( constantDeclaration | function | procedure | mlComment | slComment | pragma | typeDefinition | subtypeDefinition | cursorDeclaration | variableDeclaration | exceptionDeclaration );
    public final element_return element() throws RecognitionException {
        element_return retval = new element_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        constantDeclaration_return constantDeclaration18 = null;

        function_return function19 = null;

        procedure_return procedure20 = null;

        mlComment_return mlComment21 = null;

        slComment_return slComment22 = null;

        pragma_return pragma23 = null;

        typeDefinition_return typeDefinition24 = null;

        subtypeDefinition_return subtypeDefinition25 = null;

        cursorDeclaration_return cursorDeclaration26 = null;

        variableDeclaration_return variableDeclaration27 = null;

        exceptionDeclaration_return exceptionDeclaration28 = null;



        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:74:3: ( constantDeclaration | function | procedure | mlComment | slComment | pragma | typeDefinition | subtypeDefinition | cursorDeclaration | variableDeclaration | exceptionDeclaration )
            int alt7=11;
            switch ( input.LA(1) ) {
            case ID:
                {
                switch ( input.LA(2) ) {
                case CONSTANT:
                    {
                    alt7=1;
                    }
                    break;
                case ID:
                case QUOTED_ID:
                    {
                    alt7=10;
                    }
                    break;
                case EXCEPTION:
                    {
                    alt7=11;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("73:1: element : ( constantDeclaration | function | procedure | mlComment | slComment | pragma | typeDefinition | subtypeDefinition | cursorDeclaration | variableDeclaration | exceptionDeclaration );", 7, 1, input);

                    throw nvae;
                }

                }
                break;
            case FUNCTION:
                {
                alt7=2;
                }
                break;
            case PROCEDURE:
                {
                alt7=3;
                }
                break;
            case ML_COMMENT:
                {
                alt7=4;
                }
                break;
            case SL_COMMENT:
                {
                alt7=5;
                }
                break;
            case PRAGMA:
                {
                alt7=6;
                }
                break;
            case TYPE:
                {
                alt7=7;
                }
                break;
            case SUBTYPE:
                {
                alt7=8;
                }
                break;
            case CURSOR:
                {
                alt7=9;
                }
                break;
            case QUOTED_ID:
                {
                int LA7_10 = input.LA(2);

                if ( (LA7_10==ID||LA7_10==QUOTED_ID) ) {
                    alt7=10;
                }
                else if ( (LA7_10==EXCEPTION) ) {
                    alt7=11;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("73:1: element : ( constantDeclaration | function | procedure | mlComment | slComment | pragma | typeDefinition | subtypeDefinition | cursorDeclaration | variableDeclaration | exceptionDeclaration );", 7, 10, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("73:1: element : ( constantDeclaration | function | procedure | mlComment | slComment | pragma | typeDefinition | subtypeDefinition | cursorDeclaration | variableDeclaration | exceptionDeclaration );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:74:6: constantDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constantDeclaration_in_element235);
                    constantDeclaration18=constantDeclaration();
                    _fsp--;

                    adaptor.addChild(root_0, constantDeclaration18.getTree());

                    }
                    break;
                case 2 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:75:6: function
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_function_in_element242);
                    function19=function();
                    _fsp--;

                    adaptor.addChild(root_0, function19.getTree());

                    }
                    break;
                case 3 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:76:6: procedure
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_procedure_in_element249);
                    procedure20=procedure();
                    _fsp--;

                    adaptor.addChild(root_0, procedure20.getTree());

                    }
                    break;
                case 4 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:77:6: mlComment
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_mlComment_in_element256);
                    mlComment21=mlComment();
                    _fsp--;

                    adaptor.addChild(root_0, mlComment21.getTree());

                    }
                    break;
                case 5 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:78:6: slComment
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_slComment_in_element263);
                    slComment22=slComment();
                    _fsp--;

                    adaptor.addChild(root_0, slComment22.getTree());

                    }
                    break;
                case 6 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:79:6: pragma
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_pragma_in_element270);
                    pragma23=pragma();
                    _fsp--;

                    adaptor.addChild(root_0, pragma23.getTree());

                    }
                    break;
                case 7 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:80:6: typeDefinition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_typeDefinition_in_element278);
                    typeDefinition24=typeDefinition();
                    _fsp--;

                    adaptor.addChild(root_0, typeDefinition24.getTree());

                    }
                    break;
                case 8 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:81:6: subtypeDefinition
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_subtypeDefinition_in_element286);
                    subtypeDefinition25=subtypeDefinition();
                    _fsp--;

                    adaptor.addChild(root_0, subtypeDefinition25.getTree());

                    }
                    break;
                case 9 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:82:6: cursorDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_cursorDeclaration_in_element293);
                    cursorDeclaration26=cursorDeclaration();
                    _fsp--;

                    adaptor.addChild(root_0, cursorDeclaration26.getTree());

                    }
                    break;
                case 10 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:83:6: variableDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_variableDeclaration_in_element301);
                    variableDeclaration27=variableDeclaration();
                    _fsp--;

                    adaptor.addChild(root_0, variableDeclaration27.getTree());

                    }
                    break;
                case 11 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:84:6: exceptionDeclaration
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_exceptionDeclaration_in_element309);
                    exceptionDeclaration28=exceptionDeclaration();
                    _fsp--;

                    adaptor.addChild(root_0, exceptionDeclaration28.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end element

    public static class constantDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start constantDeclaration
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:87:1: constantDeclaration : l_id= ID CONSTANT l_dataType= dataType ( ( ':=' | DEFAULT ) l_literal= literal )? SEMI -> ^( CONSTANT $l_id $l_dataType ( $l_literal)? ) ;
    public final constantDeclaration_return constantDeclaration() throws RecognitionException {
        constantDeclaration_return retval = new constantDeclaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token l_id=null;
        Token CONSTANT29=null;
        Token string_literal30=null;
        Token DEFAULT31=null;
        Token SEMI32=null;
        dataType_return l_dataType = null;

        literal_return l_literal = null;


        Object l_id_tree=null;
        Object CONSTANT29_tree=null;
        Object string_literal30_tree=null;
        Object DEFAULT31_tree=null;
        Object SEMI32_tree=null;
        RewriteRuleTokenStream stream_CONSTANT=new RewriteRuleTokenStream(adaptor,"token CONSTANT");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_DEFAULT=new RewriteRuleTokenStream(adaptor,"token DEFAULT");
        RewriteRuleSubtreeStream stream_dataType=new RewriteRuleSubtreeStream(adaptor,"rule dataType");
        RewriteRuleSubtreeStream stream_literal=new RewriteRuleSubtreeStream(adaptor,"rule literal");
        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:88:3: (l_id= ID CONSTANT l_dataType= dataType ( ( ':=' | DEFAULT ) l_literal= literal )? SEMI -> ^( CONSTANT $l_id $l_dataType ( $l_literal)? ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:88:6: l_id= ID CONSTANT l_dataType= dataType ( ( ':=' | DEFAULT ) l_literal= literal )? SEMI
            {
            l_id=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_constantDeclaration326); 
            stream_ID.add(l_id);

            CONSTANT29=(Token)input.LT(1);
            match(input,CONSTANT,FOLLOW_CONSTANT_in_constantDeclaration328); 
            stream_CONSTANT.add(CONSTANT29);

            pushFollow(FOLLOW_dataType_in_constantDeclaration332);
            l_dataType=dataType();
            _fsp--;

            stream_dataType.add(l_dataType.getTree());
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:88:43: ( ( ':=' | DEFAULT ) l_literal= literal )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==DEFAULT||LA9_0==47) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:88:44: ( ':=' | DEFAULT ) l_literal= literal
                    {
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:88:44: ( ':=' | DEFAULT )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==47) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==DEFAULT) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("88:44: ( ':=' | DEFAULT )", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:88:45: ':='
                            {
                            string_literal30=(Token)input.LT(1);
                            match(input,47,FOLLOW_47_in_constantDeclaration336); 
                            stream_47.add(string_literal30);


                            }
                            break;
                        case 2 :
                            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:88:52: DEFAULT
                            {
                            DEFAULT31=(Token)input.LT(1);
                            match(input,DEFAULT,FOLLOW_DEFAULT_in_constantDeclaration340); 
                            stream_DEFAULT.add(DEFAULT31);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_literal_in_constantDeclaration345);
                    l_literal=literal();
                    _fsp--;

                    stream_literal.add(l_literal.getTree());

                    }
                    break;

            }

            SEMI32=(Token)input.LT(1);
            match(input,SEMI,FOLLOW_SEMI_in_constantDeclaration349); 
            stream_SEMI.add(SEMI32);


            // AST REWRITE
            // elements: l_id, CONSTANT, l_literal, l_dataType
            // token labels: l_id
            // rule labels: retval, l_dataType, l_literal
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_l_id=new RewriteRuleTokenStream(adaptor,"token l_id",l_id);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_l_dataType=new RewriteRuleSubtreeStream(adaptor,"token l_dataType",l_dataType!=null?l_dataType.tree:null);
            RewriteRuleSubtreeStream stream_l_literal=new RewriteRuleSubtreeStream(adaptor,"token l_literal",l_literal!=null?l_literal.tree:null);

            root_0 = (Object)adaptor.nil();
            // 89:6: -> ^( CONSTANT $l_id $l_dataType ( $l_literal)? )
            {
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:89:9: ^( CONSTANT $l_id $l_dataType ( $l_literal)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_CONSTANT.next(), root_1);

                adaptor.addChild(root_1, stream_l_id.next());
                adaptor.addChild(root_1, stream_l_dataType.next());
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:89:38: ( $l_literal)?
                if ( stream_l_literal.hasNext() ) {
                    adaptor.addChild(root_1, stream_l_literal.next());

                }
                stream_l_literal.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end constantDeclaration

    public static class literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start literal
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:92:1: literal : ( NUMBER | QUOTED_LITERAL | NULL );
    public final literal_return literal() throws RecognitionException {
        literal_return retval = new literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set33=null;

        Object set33_tree=null;

        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:93:3: ( NUMBER | QUOTED_LITERAL | NULL )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:
            {
            root_0 = (Object)adaptor.nil();

            set33=(Token)input.LT(1);
            if ( (input.LA(1)>=NUMBER && input.LA(1)<=NULL) ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set33));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_literal0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class function_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start function
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:98:1: function : FUNCTION l_id= ID ( '(' l_params+= param ( ',' l_params+= param )* ')' )? RETURN l_dataType= dataType ( isOrAS )? ( ID )* ( QUOTED_LITERAL )? SEMI -> ^( FUNCTION $l_id ^( T_PARAMS ( $l_params)* ) ^( RETURN $l_dataType) ) ;
    public final function_return function() throws RecognitionException {
        function_return retval = new function_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token l_id=null;
        Token FUNCTION34=null;
        Token char_literal35=null;
        Token char_literal36=null;
        Token char_literal37=null;
        Token RETURN38=null;
        Token ID40=null;
        Token QUOTED_LITERAL41=null;
        Token SEMI42=null;
        List list_l_params=null;
        dataType_return l_dataType = null;

        isOrAS_return isOrAS39 = null;

        RuleReturnScope l_params = null;
        Object l_id_tree=null;
        Object FUNCTION34_tree=null;
        Object char_literal35_tree=null;
        Object char_literal36_tree=null;
        Object char_literal37_tree=null;
        Object RETURN38_tree=null;
        Object ID40_tree=null;
        Object QUOTED_LITERAL41_tree=null;
        Object SEMI42_tree=null;
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_FUNCTION=new RewriteRuleTokenStream(adaptor,"token FUNCTION");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_QUOTED_LITERAL=new RewriteRuleTokenStream(adaptor,"token QUOTED_LITERAL");
        RewriteRuleTokenStream stream_RETURN=new RewriteRuleTokenStream(adaptor,"token RETURN");
        RewriteRuleSubtreeStream stream_dataType=new RewriteRuleSubtreeStream(adaptor,"rule dataType");
        RewriteRuleSubtreeStream stream_param=new RewriteRuleSubtreeStream(adaptor,"rule param");
        RewriteRuleSubtreeStream stream_isOrAS=new RewriteRuleSubtreeStream(adaptor,"rule isOrAS");
        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:99:3: ( FUNCTION l_id= ID ( '(' l_params+= param ( ',' l_params+= param )* ')' )? RETURN l_dataType= dataType ( isOrAS )? ( ID )* ( QUOTED_LITERAL )? SEMI -> ^( FUNCTION $l_id ^( T_PARAMS ( $l_params)* ) ^( RETURN $l_dataType) ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:99:6: FUNCTION l_id= ID ( '(' l_params+= param ( ',' l_params+= param )* ')' )? RETURN l_dataType= dataType ( isOrAS )? ( ID )* ( QUOTED_LITERAL )? SEMI
            {
            FUNCTION34=(Token)input.LT(1);
            match(input,FUNCTION,FOLLOW_FUNCTION_in_function426); 
            stream_FUNCTION.add(FUNCTION34);

            l_id=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_function430); 
            stream_ID.add(l_id);

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:100:5: ( '(' l_params+= param ( ',' l_params+= param )* ')' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==48) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:101:5: '(' l_params+= param ( ',' l_params+= param )* ')'
                    {
                    char_literal35=(Token)input.LT(1);
                    match(input,48,FOLLOW_48_in_function442); 
                    stream_48.add(char_literal35);

                    pushFollow(FOLLOW_param_in_function446);
                    l_params=param();
                    _fsp--;

                    stream_param.add(l_params.getTree());
                    if (list_l_params==null) list_l_params=new ArrayList();
                    list_l_params.add(l_params);

                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:102:7: ( ',' l_params+= param )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==COMMA) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:102:8: ',' l_params+= param
                    	    {
                    	    char_literal36=(Token)input.LT(1);
                    	    match(input,COMMA,FOLLOW_COMMA_in_function455); 
                    	    stream_COMMA.add(char_literal36);

                    	    pushFollow(FOLLOW_param_in_function459);
                    	    l_params=param();
                    	    _fsp--;

                    	    stream_param.add(l_params.getTree());
                    	    if (list_l_params==null) list_l_params=new ArrayList();
                    	    list_l_params.add(l_params);


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    char_literal37=(Token)input.LT(1);
                    match(input,49,FOLLOW_49_in_function474); 
                    stream_49.add(char_literal37);


                    }
                    break;

            }

            RETURN38=(Token)input.LT(1);
            match(input,RETURN,FOLLOW_RETURN_in_function487); 
            stream_RETURN.add(RETURN38);

            pushFollow(FOLLOW_dataType_in_function491);
            l_dataType=dataType();
            _fsp--;

            stream_dataType.add(l_dataType.getTree());
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:107:5: ( isOrAS )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=IS && LA12_0<=AS)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:107:5: isOrAS
                    {
                    pushFollow(FOLLOW_isOrAS_in_function497);
                    isOrAS39=isOrAS();
                    _fsp--;

                    stream_isOrAS.add(isOrAS39.getTree());

                    }
                    break;

            }

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:107:13: ( ID )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:107:13: ID
            	    {
            	    ID40=(Token)input.LT(1);
            	    match(input,ID,FOLLOW_ID_in_function500); 
            	    stream_ID.add(ID40);


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:107:17: ( QUOTED_LITERAL )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==QUOTED_LITERAL) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:107:17: QUOTED_LITERAL
                    {
                    QUOTED_LITERAL41=(Token)input.LT(1);
                    match(input,QUOTED_LITERAL,FOLLOW_QUOTED_LITERAL_in_function503); 
                    stream_QUOTED_LITERAL.add(QUOTED_LITERAL41);


                    }
                    break;

            }

            SEMI42=(Token)input.LT(1);
            match(input,SEMI,FOLLOW_SEMI_in_function514); 
            stream_SEMI.add(SEMI42);


            // AST REWRITE
            // elements: l_id, FUNCTION, l_dataType, RETURN, l_params
            // token labels: l_id
            // rule labels: retval, l_dataType
            // token list labels: 
            // rule list labels: l_params
            retval.tree = root_0;
            RewriteRuleTokenStream stream_l_id=new RewriteRuleTokenStream(adaptor,"token l_id",l_id);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_l_dataType=new RewriteRuleSubtreeStream(adaptor,"token l_dataType",l_dataType!=null?l_dataType.tree:null);
            RewriteRuleSubtreeStream stream_l_params=new RewriteRuleSubtreeStream(adaptor,"token l_params",list_l_params);
            root_0 = (Object)adaptor.nil();
            // 109:5: -> ^( FUNCTION $l_id ^( T_PARAMS ( $l_params)* ) ^( RETURN $l_dataType) )
            {
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:110:5: ^( FUNCTION $l_id ^( T_PARAMS ( $l_params)* ) ^( RETURN $l_dataType) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_FUNCTION.next(), root_1);

                adaptor.addChild(root_1, stream_l_id.next());
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:110:22: ^( T_PARAMS ( $l_params)* )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(adaptor.create(T_PARAMS, "T_PARAMS"), root_2);

                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:110:33: ( $l_params)*
                while ( stream_l_params.hasNext() ) {
                    adaptor.addChild(root_2, ((ParserRuleReturnScope)stream_l_params.next()).getTree());

                }
                stream_l_params.reset();

                adaptor.addChild(root_1, root_2);
                }
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:110:45: ^( RETURN $l_dataType)
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(stream_RETURN.next(), root_2);

                adaptor.addChild(root_2, stream_l_dataType.next());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end function

    public static class procedure_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start procedure
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:113:1: procedure : PROCEDURE l_id= ID ( '(' l_params+= param ( ',' l_params+= param )* ')' )? ( isOrAS )? ( ID )* ( QUOTED_LITERAL )? SEMI -> ^( PROCEDURE $l_id ^( T_PARAMS ( $l_params)* ) ) ;
    public final procedure_return procedure() throws RecognitionException {
        procedure_return retval = new procedure_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token l_id=null;
        Token PROCEDURE43=null;
        Token char_literal44=null;
        Token char_literal45=null;
        Token char_literal46=null;
        Token ID48=null;
        Token QUOTED_LITERAL49=null;
        Token SEMI50=null;
        List list_l_params=null;
        isOrAS_return isOrAS47 = null;

        RuleReturnScope l_params = null;
        Object l_id_tree=null;
        Object PROCEDURE43_tree=null;
        Object char_literal44_tree=null;
        Object char_literal45_tree=null;
        Object char_literal46_tree=null;
        Object ID48_tree=null;
        Object QUOTED_LITERAL49_tree=null;
        Object SEMI50_tree=null;
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_PROCEDURE=new RewriteRuleTokenStream(adaptor,"token PROCEDURE");
        RewriteRuleTokenStream stream_QUOTED_LITERAL=new RewriteRuleTokenStream(adaptor,"token QUOTED_LITERAL");
        RewriteRuleSubtreeStream stream_param=new RewriteRuleSubtreeStream(adaptor,"rule param");
        RewriteRuleSubtreeStream stream_isOrAS=new RewriteRuleSubtreeStream(adaptor,"rule isOrAS");
        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:114:3: ( PROCEDURE l_id= ID ( '(' l_params+= param ( ',' l_params+= param )* ')' )? ( isOrAS )? ( ID )* ( QUOTED_LITERAL )? SEMI -> ^( PROCEDURE $l_id ^( T_PARAMS ( $l_params)* ) ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:114:6: PROCEDURE l_id= ID ( '(' l_params+= param ( ',' l_params+= param )* ')' )? ( isOrAS )? ( ID )* ( QUOTED_LITERAL )? SEMI
            {
            PROCEDURE43=(Token)input.LT(1);
            match(input,PROCEDURE,FOLLOW_PROCEDURE_in_procedure560); 
            stream_PROCEDURE.add(PROCEDURE43);

            l_id=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_procedure564); 
            stream_ID.add(l_id);

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:115:6: ( '(' l_params+= param ( ',' l_params+= param )* ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==48) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:116:6: '(' l_params+= param ( ',' l_params+= param )* ')'
                    {
                    char_literal44=(Token)input.LT(1);
                    match(input,48,FOLLOW_48_in_procedure578); 
                    stream_48.add(char_literal44);

                    pushFollow(FOLLOW_param_in_procedure582);
                    l_params=param();
                    _fsp--;

                    stream_param.add(l_params.getTree());
                    if (list_l_params==null) list_l_params=new ArrayList();
                    list_l_params.add(l_params);

                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:117:8: ( ',' l_params+= param )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==COMMA) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:117:9: ',' l_params+= param
                    	    {
                    	    char_literal45=(Token)input.LT(1);
                    	    match(input,COMMA,FOLLOW_COMMA_in_procedure592); 
                    	    stream_COMMA.add(char_literal45);

                    	    pushFollow(FOLLOW_param_in_procedure596);
                    	    l_params=param();
                    	    _fsp--;

                    	    stream_param.add(l_params.getTree());
                    	    if (list_l_params==null) list_l_params=new ArrayList();
                    	    list_l_params.add(l_params);


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    char_literal46=(Token)input.LT(1);
                    match(input,49,FOLLOW_49_in_procedure613); 
                    stream_49.add(char_literal46);


                    }
                    break;

            }

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:121:6: ( isOrAS )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=IS && LA17_0<=AS)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:121:6: isOrAS
                    {
                    pushFollow(FOLLOW_isOrAS_in_procedure628);
                    isOrAS47=isOrAS();
                    _fsp--;

                    stream_isOrAS.add(isOrAS47.getTree());

                    }
                    break;

            }

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:121:14: ( ID )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:121:14: ID
            	    {
            	    ID48=(Token)input.LT(1);
            	    match(input,ID,FOLLOW_ID_in_procedure631); 
            	    stream_ID.add(ID48);


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:121:18: ( QUOTED_LITERAL )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==QUOTED_LITERAL) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:121:18: QUOTED_LITERAL
                    {
                    QUOTED_LITERAL49=(Token)input.LT(1);
                    match(input,QUOTED_LITERAL,FOLLOW_QUOTED_LITERAL_in_procedure634); 
                    stream_QUOTED_LITERAL.add(QUOTED_LITERAL49);


                    }
                    break;

            }

            SEMI50=(Token)input.LT(1);
            match(input,SEMI,FOLLOW_SEMI_in_procedure646); 
            stream_SEMI.add(SEMI50);


            // AST REWRITE
            // elements: l_params, l_id, PROCEDURE
            // token labels: l_id
            // rule labels: retval
            // token list labels: 
            // rule list labels: l_params
            retval.tree = root_0;
            RewriteRuleTokenStream stream_l_id=new RewriteRuleTokenStream(adaptor,"token l_id",l_id);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_l_params=new RewriteRuleSubtreeStream(adaptor,"token l_params",list_l_params);
            root_0 = (Object)adaptor.nil();
            // 123:6: -> ^( PROCEDURE $l_id ^( T_PARAMS ( $l_params)* ) )
            {
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:124:6: ^( PROCEDURE $l_id ^( T_PARAMS ( $l_params)* ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_PROCEDURE.next(), root_1);

                adaptor.addChild(root_1, stream_l_id.next());
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:124:24: ^( T_PARAMS ( $l_params)* )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(adaptor.create(T_PARAMS, "T_PARAMS"), root_2);

                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:124:35: ( $l_params)*
                while ( stream_l_params.hasNext() ) {
                    adaptor.addChild(root_2, ((ParserRuleReturnScope)stream_l_params.next()).getTree());

                }
                stream_l_params.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end procedure

    public static class pragmaDummy_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start pragmaDummy
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:127:1: pragmaDummy : PRAGMA ( . )* SEMI ;
    public final pragmaDummy_return pragmaDummy() throws RecognitionException {
        pragmaDummy_return retval = new pragmaDummy_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PRAGMA51=null;
        Token wildcard52=null;
        Token SEMI53=null;

        Object PRAGMA51_tree=null;
        Object wildcard52_tree=null;
        Object SEMI53_tree=null;

        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:128:3: ( PRAGMA ( . )* SEMI )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:128:6: PRAGMA ( . )* SEMI
            {
            root_0 = (Object)adaptor.nil();

            PRAGMA51=(Token)input.LT(1);
            match(input,PRAGMA,FOLLOW_PRAGMA_in_pragmaDummy687); 
            PRAGMA51_tree = (Object)adaptor.create(PRAGMA51);
            adaptor.addChild(root_0, PRAGMA51_tree);

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:128:13: ( . )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==SEMI) ) {
                    alt20=2;
                }
                else if ( ((LA20_0>=T_PARAM && LA20_0<=END)||(LA20_0>=CONSTANT && LA20_0<=49)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:128:13: .
            	    {
            	    wildcard52=(Token)input.LT(1);
            	    matchAny(input); 
            	    wildcard52_tree = (Object)adaptor.create(wildcard52);
            	    adaptor.addChild(root_0, wildcard52_tree);


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            SEMI53=(Token)input.LT(1);
            match(input,SEMI,FOLLOW_SEMI_in_pragmaDummy692); 
            SEMI53_tree = (Object)adaptor.create(SEMI53);
            adaptor.addChild(root_0, SEMI53_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end pragmaDummy

    public static class pragma_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start pragma
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:131:1: pragma : pragmaDummy -> ^( T_IGNORE ) ;
    public final pragma_return pragma() throws RecognitionException {
        pragma_return retval = new pragma_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        pragmaDummy_return pragmaDummy54 = null;


        RewriteRuleSubtreeStream stream_pragmaDummy=new RewriteRuleSubtreeStream(adaptor,"rule pragmaDummy");
        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:132:3: ( pragmaDummy -> ^( T_IGNORE ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:132:6: pragmaDummy
            {
            pushFollow(FOLLOW_pragmaDummy_in_pragma707);
            pragmaDummy54=pragmaDummy();
            _fsp--;

            stream_pragmaDummy.add(pragmaDummy54.getTree());

            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 132:18: -> ^( T_IGNORE )
            {
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:132:21: ^( T_IGNORE )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(T_IGNORE, "T_IGNORE"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end pragma

    public static class typeDefinitionDummy_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start typeDefinitionDummy
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:135:1: typeDefinitionDummy : TYPE ( . )* SEMI ;
    public final typeDefinitionDummy_return typeDefinitionDummy() throws RecognitionException {
        typeDefinitionDummy_return retval = new typeDefinitionDummy_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TYPE55=null;
        Token wildcard56=null;
        Token SEMI57=null;

        Object TYPE55_tree=null;
        Object wildcard56_tree=null;
        Object SEMI57_tree=null;

        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:136:3: ( TYPE ( . )* SEMI )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:136:6: TYPE ( . )* SEMI
            {
            root_0 = (Object)adaptor.nil();

            TYPE55=(Token)input.LT(1);
            match(input,TYPE,FOLLOW_TYPE_in_typeDefinitionDummy727); 
            TYPE55_tree = (Object)adaptor.create(TYPE55);
            adaptor.addChild(root_0, TYPE55_tree);

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:136:11: ( . )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==SEMI) ) {
                    alt21=2;
                }
                else if ( ((LA21_0>=T_PARAM && LA21_0<=END)||(LA21_0>=CONSTANT && LA21_0<=49)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:136:11: .
            	    {
            	    wildcard56=(Token)input.LT(1);
            	    matchAny(input); 
            	    wildcard56_tree = (Object)adaptor.create(wildcard56);
            	    adaptor.addChild(root_0, wildcard56_tree);


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            SEMI57=(Token)input.LT(1);
            match(input,SEMI,FOLLOW_SEMI_in_typeDefinitionDummy732); 
            SEMI57_tree = (Object)adaptor.create(SEMI57);
            adaptor.addChild(root_0, SEMI57_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end typeDefinitionDummy

    public static class typeDefinition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start typeDefinition
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:139:1: typeDefinition : typeDefinitionDummy -> ^( T_IGNORE ) ;
    public final typeDefinition_return typeDefinition() throws RecognitionException {
        typeDefinition_return retval = new typeDefinition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        typeDefinitionDummy_return typeDefinitionDummy58 = null;


        RewriteRuleSubtreeStream stream_typeDefinitionDummy=new RewriteRuleSubtreeStream(adaptor,"rule typeDefinitionDummy");
        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:140:3: ( typeDefinitionDummy -> ^( T_IGNORE ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:140:6: typeDefinitionDummy
            {
            pushFollow(FOLLOW_typeDefinitionDummy_in_typeDefinition747);
            typeDefinitionDummy58=typeDefinitionDummy();
            _fsp--;

            stream_typeDefinitionDummy.add(typeDefinitionDummy58.getTree());

            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 140:26: -> ^( T_IGNORE )
            {
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:140:29: ^( T_IGNORE )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(T_IGNORE, "T_IGNORE"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end typeDefinition

    public static class subtypeDefinitionDummy_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start subtypeDefinitionDummy
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:143:1: subtypeDefinitionDummy : SUBTYPE ( . )* SEMI ;
    public final subtypeDefinitionDummy_return subtypeDefinitionDummy() throws RecognitionException {
        subtypeDefinitionDummy_return retval = new subtypeDefinitionDummy_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SUBTYPE59=null;
        Token wildcard60=null;
        Token SEMI61=null;

        Object SUBTYPE59_tree=null;
        Object wildcard60_tree=null;
        Object SEMI61_tree=null;

        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:144:3: ( SUBTYPE ( . )* SEMI )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:144:6: SUBTYPE ( . )* SEMI
            {
            root_0 = (Object)adaptor.nil();

            SUBTYPE59=(Token)input.LT(1);
            match(input,SUBTYPE,FOLLOW_SUBTYPE_in_subtypeDefinitionDummy769); 
            SUBTYPE59_tree = (Object)adaptor.create(SUBTYPE59);
            adaptor.addChild(root_0, SUBTYPE59_tree);

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:144:14: ( . )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==SEMI) ) {
                    alt22=2;
                }
                else if ( ((LA22_0>=T_PARAM && LA22_0<=END)||(LA22_0>=CONSTANT && LA22_0<=49)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:144:14: .
            	    {
            	    wildcard60=(Token)input.LT(1);
            	    matchAny(input); 
            	    wildcard60_tree = (Object)adaptor.create(wildcard60);
            	    adaptor.addChild(root_0, wildcard60_tree);


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            SEMI61=(Token)input.LT(1);
            match(input,SEMI,FOLLOW_SEMI_in_subtypeDefinitionDummy774); 
            SEMI61_tree = (Object)adaptor.create(SEMI61);
            adaptor.addChild(root_0, SEMI61_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end subtypeDefinitionDummy

    public static class subtypeDefinition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start subtypeDefinition
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:147:1: subtypeDefinition : subtypeDefinitionDummy -> ^( T_IGNORE ) ;
    public final subtypeDefinition_return subtypeDefinition() throws RecognitionException {
        subtypeDefinition_return retval = new subtypeDefinition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        subtypeDefinitionDummy_return subtypeDefinitionDummy62 = null;


        RewriteRuleSubtreeStream stream_subtypeDefinitionDummy=new RewriteRuleSubtreeStream(adaptor,"rule subtypeDefinitionDummy");
        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:148:3: ( subtypeDefinitionDummy -> ^( T_IGNORE ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:148:6: subtypeDefinitionDummy
            {
            pushFollow(FOLLOW_subtypeDefinitionDummy_in_subtypeDefinition791);
            subtypeDefinitionDummy62=subtypeDefinitionDummy();
            _fsp--;

            stream_subtypeDefinitionDummy.add(subtypeDefinitionDummy62.getTree());

            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 148:29: -> ^( T_IGNORE )
            {
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:148:32: ^( T_IGNORE )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(T_IGNORE, "T_IGNORE"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end subtypeDefinition

    public static class cursorDeclarationDummy_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cursorDeclarationDummy
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:151:1: cursorDeclarationDummy : CURSOR ( . )* SEMI ;
    public final cursorDeclarationDummy_return cursorDeclarationDummy() throws RecognitionException {
        cursorDeclarationDummy_return retval = new cursorDeclarationDummy_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CURSOR63=null;
        Token wildcard64=null;
        Token SEMI65=null;

        Object CURSOR63_tree=null;
        Object wildcard64_tree=null;
        Object SEMI65_tree=null;

        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:152:3: ( CURSOR ( . )* SEMI )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:152:6: CURSOR ( . )* SEMI
            {
            root_0 = (Object)adaptor.nil();

            CURSOR63=(Token)input.LT(1);
            match(input,CURSOR,FOLLOW_CURSOR_in_cursorDeclarationDummy811); 
            CURSOR63_tree = (Object)adaptor.create(CURSOR63);
            adaptor.addChild(root_0, CURSOR63_tree);

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:152:13: ( . )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==SEMI) ) {
                    alt23=2;
                }
                else if ( ((LA23_0>=T_PARAM && LA23_0<=END)||(LA23_0>=CONSTANT && LA23_0<=49)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:152:13: .
            	    {
            	    wildcard64=(Token)input.LT(1);
            	    matchAny(input); 
            	    wildcard64_tree = (Object)adaptor.create(wildcard64);
            	    adaptor.addChild(root_0, wildcard64_tree);


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            SEMI65=(Token)input.LT(1);
            match(input,SEMI,FOLLOW_SEMI_in_cursorDeclarationDummy816); 
            SEMI65_tree = (Object)adaptor.create(SEMI65);
            adaptor.addChild(root_0, SEMI65_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end cursorDeclarationDummy

    public static class cursorDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start cursorDeclaration
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:155:1: cursorDeclaration : cursorDeclarationDummy -> ^( T_IGNORE ) ;
    public final cursorDeclaration_return cursorDeclaration() throws RecognitionException {
        cursorDeclaration_return retval = new cursorDeclaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        cursorDeclarationDummy_return cursorDeclarationDummy66 = null;


        RewriteRuleSubtreeStream stream_cursorDeclarationDummy=new RewriteRuleSubtreeStream(adaptor,"rule cursorDeclarationDummy");
        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:156:3: ( cursorDeclarationDummy -> ^( T_IGNORE ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:156:6: cursorDeclarationDummy
            {
            pushFollow(FOLLOW_cursorDeclarationDummy_in_cursorDeclaration831);
            cursorDeclarationDummy66=cursorDeclarationDummy();
            _fsp--;

            stream_cursorDeclarationDummy.add(cursorDeclarationDummy66.getTree());

            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 156:29: -> ^( T_IGNORE )
            {
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:156:32: ^( T_IGNORE )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(T_IGNORE, "T_IGNORE"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end cursorDeclaration

    public static class variableDeclarationDummy_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start variableDeclarationDummy
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:159:1: variableDeclarationDummy : id dataType ( ':=' | DEFAULT ) ( . )* SEMI ;
    public final variableDeclarationDummy_return variableDeclarationDummy() throws RecognitionException {
        variableDeclarationDummy_return retval = new variableDeclarationDummy_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set69=null;
        Token wildcard70=null;
        Token SEMI71=null;
        id_return id67 = null;

        dataType_return dataType68 = null;


        Object set69_tree=null;
        Object wildcard70_tree=null;
        Object SEMI71_tree=null;

        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:160:3: ( id dataType ( ':=' | DEFAULT ) ( . )* SEMI )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:160:6: id dataType ( ':=' | DEFAULT ) ( . )* SEMI
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_id_in_variableDeclarationDummy851);
            id67=id();
            _fsp--;

            adaptor.addChild(root_0, id67.getTree());
            pushFollow(FOLLOW_dataType_in_variableDeclarationDummy853);
            dataType68=dataType();
            _fsp--;

            adaptor.addChild(root_0, dataType68.getTree());
            set69=(Token)input.LT(1);
            if ( input.LA(1)==DEFAULT||input.LA(1)==47 ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set69));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_variableDeclarationDummy855);    throw mse;
            }

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:160:35: ( . )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==SEMI) ) {
                    alt24=2;
                }
                else if ( ((LA24_0>=T_PARAM && LA24_0<=END)||(LA24_0>=CONSTANT && LA24_0<=49)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:160:35: .
            	    {
            	    wildcard70=(Token)input.LT(1);
            	    matchAny(input); 
            	    wildcard70_tree = (Object)adaptor.create(wildcard70);
            	    adaptor.addChild(root_0, wildcard70_tree);


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            SEMI71=(Token)input.LT(1);
            match(input,SEMI,FOLLOW_SEMI_in_variableDeclarationDummy866); 
            SEMI71_tree = (Object)adaptor.create(SEMI71);
            adaptor.addChild(root_0, SEMI71_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end variableDeclarationDummy

    public static class variableDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start variableDeclaration
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:163:1: variableDeclaration : variableDeclarationDummy -> ^( T_IGNORE ) ;
    public final variableDeclaration_return variableDeclaration() throws RecognitionException {
        variableDeclaration_return retval = new variableDeclaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        variableDeclarationDummy_return variableDeclarationDummy72 = null;


        RewriteRuleSubtreeStream stream_variableDeclarationDummy=new RewriteRuleSubtreeStream(adaptor,"rule variableDeclarationDummy");
        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:164:3: ( variableDeclarationDummy -> ^( T_IGNORE ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:164:6: variableDeclarationDummy
            {
            pushFollow(FOLLOW_variableDeclarationDummy_in_variableDeclaration880);
            variableDeclarationDummy72=variableDeclarationDummy();
            _fsp--;

            stream_variableDeclarationDummy.add(variableDeclarationDummy72.getTree());

            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 164:31: -> ^( T_IGNORE )
            {
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:164:34: ^( T_IGNORE )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(T_IGNORE, "T_IGNORE"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end variableDeclaration

    public static class exceptionDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start exceptionDeclaration
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:167:1: exceptionDeclaration : id EXCEPTION SEMI -> ^( T_IGNORE ) ;
    public final exceptionDeclaration_return exceptionDeclaration() throws RecognitionException {
        exceptionDeclaration_return retval = new exceptionDeclaration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EXCEPTION74=null;
        Token SEMI75=null;
        id_return id73 = null;


        Object EXCEPTION74_tree=null;
        Object SEMI75_tree=null;
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_EXCEPTION=new RewriteRuleTokenStream(adaptor,"token EXCEPTION");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:168:3: ( id EXCEPTION SEMI -> ^( T_IGNORE ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:168:6: id EXCEPTION SEMI
            {
            pushFollow(FOLLOW_id_in_exceptionDeclaration900);
            id73=id();
            _fsp--;

            stream_id.add(id73.getTree());
            EXCEPTION74=(Token)input.LT(1);
            match(input,EXCEPTION,FOLLOW_EXCEPTION_in_exceptionDeclaration902); 
            stream_EXCEPTION.add(EXCEPTION74);

            SEMI75=(Token)input.LT(1);
            match(input,SEMI,FOLLOW_SEMI_in_exceptionDeclaration904); 
            stream_SEMI.add(SEMI75);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 169:6: -> ^( T_IGNORE )
            {
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:169:9: ^( T_IGNORE )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(T_IGNORE, "T_IGNORE"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end exceptionDeclaration

    public static class mlComment_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start mlComment
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:172:1: mlComment : l_comment= ML_COMMENT -> ^( $l_comment) ;
    public final mlComment_return mlComment() throws RecognitionException {
        mlComment_return retval = new mlComment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token l_comment=null;

        Object l_comment_tree=null;
        RewriteRuleTokenStream stream_ML_COMMENT=new RewriteRuleTokenStream(adaptor,"token ML_COMMENT");

        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:173:3: (l_comment= ML_COMMENT -> ^( $l_comment) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:173:6: l_comment= ML_COMMENT
            {
            l_comment=(Token)input.LT(1);
            match(input,ML_COMMENT,FOLLOW_ML_COMMENT_in_mlComment933); 
            stream_ML_COMMENT.add(l_comment);


            // AST REWRITE
            // elements: l_comment
            // token labels: l_comment
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_l_comment=new RewriteRuleTokenStream(adaptor,"token l_comment",l_comment);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 174:6: -> ^( $l_comment)
            {
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:174:9: ^( $l_comment)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_l_comment.next(), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class slComment_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start slComment
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:177:1: slComment : SL_COMMENT -> ^( T_IGNORE ) ;
    public final slComment_return slComment() throws RecognitionException {
        slComment_return retval = new slComment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SL_COMMENT76=null;

        Object SL_COMMENT76_tree=null;
        RewriteRuleTokenStream stream_SL_COMMENT=new RewriteRuleTokenStream(adaptor,"token SL_COMMENT");

        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:178:3: ( SL_COMMENT -> ^( T_IGNORE ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:178:6: SL_COMMENT
            {
            SL_COMMENT76=(Token)input.LT(1);
            match(input,SL_COMMENT,FOLLOW_SL_COMMENT_in_slComment959); 
            stream_SL_COMMENT.add(SL_COMMENT76);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 179:5: -> ^( T_IGNORE )
            {
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:179:8: ^( T_IGNORE )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(T_IGNORE, "T_IGNORE"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end slComment

    public static class param_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start param
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:182:1: param : l_id= ID ( IN )? ( OUT )? ( NOCOPY )? l_dataType= dataType ( ( ':=' | DEFAULT ) dotStar )? -> ^( T_PARAM $l_id $l_dataType ^( T_PARAM_MODE ( IN )? ( OUT )? ) ) ;
    public final param_return param() throws RecognitionException {
        param_return retval = new param_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token l_id=null;
        Token IN77=null;
        Token OUT78=null;
        Token NOCOPY79=null;
        Token string_literal80=null;
        Token DEFAULT81=null;
        dataType_return l_dataType = null;

        dotStar_return dotStar82 = null;


        Object l_id_tree=null;
        Object IN77_tree=null;
        Object OUT78_tree=null;
        Object NOCOPY79_tree=null;
        Object string_literal80_tree=null;
        Object DEFAULT81_tree=null;
        RewriteRuleTokenStream stream_NOCOPY=new RewriteRuleTokenStream(adaptor,"token NOCOPY");
        RewriteRuleTokenStream stream_IN=new RewriteRuleTokenStream(adaptor,"token IN");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_OUT=new RewriteRuleTokenStream(adaptor,"token OUT");
        RewriteRuleTokenStream stream_DEFAULT=new RewriteRuleTokenStream(adaptor,"token DEFAULT");
        RewriteRuleSubtreeStream stream_dataType=new RewriteRuleSubtreeStream(adaptor,"rule dataType");
        RewriteRuleSubtreeStream stream_dotStar=new RewriteRuleSubtreeStream(adaptor,"rule dotStar");
        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:183:3: (l_id= ID ( IN )? ( OUT )? ( NOCOPY )? l_dataType= dataType ( ( ':=' | DEFAULT ) dotStar )? -> ^( T_PARAM $l_id $l_dataType ^( T_PARAM_MODE ( IN )? ( OUT )? ) ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:183:6: l_id= ID ( IN )? ( OUT )? ( NOCOPY )? l_dataType= dataType ( ( ':=' | DEFAULT ) dotStar )?
            {
            l_id=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_param987); 
            stream_ID.add(l_id);

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:183:14: ( IN )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==IN) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:183:14: IN
                    {
                    IN77=(Token)input.LT(1);
                    match(input,IN,FOLLOW_IN_in_param989); 
                    stream_IN.add(IN77);


                    }
                    break;

            }

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:183:18: ( OUT )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==OUT) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:183:18: OUT
                    {
                    OUT78=(Token)input.LT(1);
                    match(input,OUT,FOLLOW_OUT_in_param992); 
                    stream_OUT.add(OUT78);


                    }
                    break;

            }

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:183:23: ( NOCOPY )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==NOCOPY) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:183:23: NOCOPY
                    {
                    NOCOPY79=(Token)input.LT(1);
                    match(input,NOCOPY,FOLLOW_NOCOPY_in_param995); 
                    stream_NOCOPY.add(NOCOPY79);


                    }
                    break;

            }

            pushFollow(FOLLOW_dataType_in_param1000);
            l_dataType=dataType();
            _fsp--;

            stream_dataType.add(l_dataType.getTree());
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:183:51: ( ( ':=' | DEFAULT ) dotStar )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==DEFAULT||LA29_0==47) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:183:52: ( ':=' | DEFAULT ) dotStar
                    {
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:183:52: ( ':=' | DEFAULT )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==47) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==DEFAULT) ) {
                        alt28=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("183:52: ( ':=' | DEFAULT )", 28, 0, input);

                        throw nvae;
                    }
                    switch (alt28) {
                        case 1 :
                            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:183:53: ':='
                            {
                            string_literal80=(Token)input.LT(1);
                            match(input,47,FOLLOW_47_in_param1004); 
                            stream_47.add(string_literal80);


                            }
                            break;
                        case 2 :
                            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:183:60: DEFAULT
                            {
                            DEFAULT81=(Token)input.LT(1);
                            match(input,DEFAULT,FOLLOW_DEFAULT_in_param1008); 
                            stream_DEFAULT.add(DEFAULT81);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_dotStar_in_param1011);
                    dotStar82=dotStar();
                    _fsp--;

                    stream_dotStar.add(dotStar82.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: OUT, l_id, l_dataType, IN
            // token labels: l_id
            // rule labels: retval, l_dataType
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_l_id=new RewriteRuleTokenStream(adaptor,"token l_id",l_id);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_l_dataType=new RewriteRuleSubtreeStream(adaptor,"token l_dataType",l_dataType!=null?l_dataType.tree:null);

            root_0 = (Object)adaptor.nil();
            // 184:6: -> ^( T_PARAM $l_id $l_dataType ^( T_PARAM_MODE ( IN )? ( OUT )? ) )
            {
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:184:9: ^( T_PARAM $l_id $l_dataType ^( T_PARAM_MODE ( IN )? ( OUT )? ) )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(T_PARAM, "T_PARAM"), root_1);

                adaptor.addChild(root_1, stream_l_id.next());
                adaptor.addChild(root_1, stream_l_dataType.next());
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:184:37: ^( T_PARAM_MODE ( IN )? ( OUT )? )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot(adaptor.create(T_PARAM_MODE, "T_PARAM_MODE"), root_2);

                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:184:52: ( IN )?
                if ( stream_IN.hasNext() ) {
                    adaptor.addChild(root_2, stream_IN.next());

                }
                stream_IN.reset();
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:184:56: ( OUT )?
                if ( stream_OUT.hasNext() ) {
                    adaptor.addChild(root_2, stream_OUT.next());

                }
                stream_OUT.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end param

    public static class dataType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start dataType
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:187:1: dataType : ( id '.' )? id ( '(' NUMBER ( ',' NUMBER )? ')' )? ;
    public final dataType_return dataType() throws RecognitionException {
        dataType_return retval = new dataType_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal84=null;
        Token char_literal86=null;
        Token NUMBER87=null;
        Token char_literal88=null;
        Token NUMBER89=null;
        Token char_literal90=null;
        id_return id83 = null;

        id_return id85 = null;


        Object char_literal84_tree=null;
        Object char_literal86_tree=null;
        Object NUMBER87_tree=null;
        Object char_literal88_tree=null;
        Object NUMBER89_tree=null;
        Object char_literal90_tree=null;

        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:188:3: ( ( id '.' )? id ( '(' NUMBER ( ',' NUMBER )? ')' )? )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:188:6: ( id '.' )? id ( '(' NUMBER ( ',' NUMBER )? ')' )?
            {
            root_0 = (Object)adaptor.nil();

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:188:6: ( id '.' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==ID||LA30_0==QUOTED_ID) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==46) ) {
                    alt30=1;
                }
            }
            switch (alt30) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:188:7: id '.'
                    {
                    pushFollow(FOLLOW_id_in_dataType1056);
                    id83=id();
                    _fsp--;

                    adaptor.addChild(root_0, id83.getTree());
                    char_literal84=(Token)input.LT(1);
                    match(input,46,FOLLOW_46_in_dataType1058); 
                    char_literal84_tree = (Object)adaptor.create(char_literal84);
                    adaptor.addChild(root_0, char_literal84_tree);


                    }
                    break;

            }

            pushFollow(FOLLOW_id_in_dataType1062);
            id85=id();
            _fsp--;

            adaptor.addChild(root_0, id85.getTree());
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:188:19: ( '(' NUMBER ( ',' NUMBER )? ')' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==48) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:188:20: '(' NUMBER ( ',' NUMBER )? ')'
                    {
                    char_literal86=(Token)input.LT(1);
                    match(input,48,FOLLOW_48_in_dataType1065); 
                    char_literal86_tree = (Object)adaptor.create(char_literal86);
                    adaptor.addChild(root_0, char_literal86_tree);

                    NUMBER87=(Token)input.LT(1);
                    match(input,NUMBER,FOLLOW_NUMBER_in_dataType1067); 
                    NUMBER87_tree = (Object)adaptor.create(NUMBER87);
                    adaptor.addChild(root_0, NUMBER87_tree);

                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:188:31: ( ',' NUMBER )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==COMMA) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:188:32: ',' NUMBER
                            {
                            char_literal88=(Token)input.LT(1);
                            match(input,COMMA,FOLLOW_COMMA_in_dataType1070); 
                            char_literal88_tree = (Object)adaptor.create(char_literal88);
                            adaptor.addChild(root_0, char_literal88_tree);

                            NUMBER89=(Token)input.LT(1);
                            match(input,NUMBER,FOLLOW_NUMBER_in_dataType1072); 
                            NUMBER89_tree = (Object)adaptor.create(NUMBER89);
                            adaptor.addChild(root_0, NUMBER89_tree);


                            }
                            break;

                    }

                    char_literal90=(Token)input.LT(1);
                    match(input,49,FOLLOW_49_in_dataType1076); 
                    char_literal90_tree = (Object)adaptor.create(char_literal90);
                    adaptor.addChild(root_0, char_literal90_tree);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class id_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start id
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:191:1: id : ( ID | QUOTED_ID );
    public final id_return id() throws RecognitionException {
        id_return retval = new id_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set91=null;

        Object set91_tree=null;

        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:192:3: ( ID | QUOTED_ID )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:
            {
            root_0 = (Object)adaptor.nil();

            set91=(Token)input.LT(1);
            if ( input.LA(1)==ID||input.LA(1)==QUOTED_ID ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set91));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_id0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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

    public static class dotStar_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start dotStar
    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:197:1: dotStar : ( . )* ;
    public final dotStar_return dotStar() throws RecognitionException {
        dotStar_return retval = new dotStar_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token wildcard92=null;

        Object wildcard92_tree=null;

        try {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:198:3: ( ( . )* )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:198:6: ( . )*
            {
            root_0 = (Object)adaptor.nil();

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:198:6: ( . )*
            loop33:
            do {
                int alt33=2;
                switch ( input.LA(1) ) {
                case PACKAGE:
                    {
                    alt33=2;
                    }
                    break;
                case COMMA:
                    {
                    alt33=2;
                    }
                    break;
                case 49:
                    {
                    alt33=2;
                    }
                    break;
                case T_PARAM:
                case T_PARAMS:
                case T_PARAM_MODE:
                case T_IGNORE:
                case ID:
                case AUTHID:
                case IS:
                case AS:
                case END:
                case SEMI:
                case CONSTANT:
                case DEFAULT:
                case NUMBER:
                case QUOTED_LITERAL:
                case NULL:
                case FUNCTION:
                case RETURN:
                case PROCEDURE:
                case PRAGMA:
                case TYPE:
                case SUBTYPE:
                case CURSOR:
                case EXCEPTION:
                case ML_COMMENT:
                case SL_COMMENT:
                case IN:
                case OUT:
                case NOCOPY:
                case QUOTED_ID:
                case NEWLINE:
                case EQUALS:
                case QUESTION_MARK:
                case FORWARD_SLASH:
                case PERCENT:
                case PIPE:
                case STAR:
                case EXCLAMATION:
                case GREATERTHAN:
                case LESSTHAN:
                case WS:
                case 46:
                case 47:
                case 48:
                    {
                    alt33=1;
                    }
                    break;

                }

                switch (alt33) {
            	case 1 :
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:198:6: .
            	    {
            	    wildcard92=(Token)input.LT(1);
            	    matchAny(input); 
            	    wildcard92_tree = (Object)adaptor.create(wildcard92);
            	    adaptor.addChild(root_0, wildcard92_tree);


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             if (false) throw new RecognitionException(); 

            }

            retval.stop = input.LT(-1);

                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end dotStar


 

    public static final BitSet FOLLOW_createOrReplacePackage_in_startRule72 = new BitSet(new long[]{0x0000000000001C00L});
    public static final BitSet FOLLOW_invokerRights_in_startRule79 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_isOrAS_in_startRule87 = new BitSet(new long[]{0x0000000237D02200L});
    public static final BitSet FOLLOW_element_in_startRule94 = new BitSet(new long[]{0x0000000237D02200L});
    public static final BitSet FOLLOW_endOfPackage_in_startRule102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dotStar_in_createOrReplacePackage120 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_PACKAGE_in_createOrReplacePackage122 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_createOrReplacePackage125 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_createOrReplacePackage127 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_createOrReplacePackage133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AUTHID_in_invokerRights160 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_invokerRights162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_isOrAS184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_isOrAS193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_END_in_endOfPackage211 = new BitSet(new long[]{0x0000000000004200L});
    public static final BitSet FOLLOW_ID_in_endOfPackage213 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_endOfPackage216 = new BitSet(new long[]{0x0003FFFFFFFFFFF2L});
    public static final BitSet FOLLOW_constantDeclaration_in_element235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_element242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procedure_in_element249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mlComment_in_element256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_slComment_in_element263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pragma_in_element270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeDefinition_in_element278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subtypeDefinition_in_element286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cursorDeclaration_in_element293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclaration_in_element301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exceptionDeclaration_in_element309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_constantDeclaration326 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CONSTANT_in_constantDeclaration328 = new BitSet(new long[]{0x0000000200000200L});
    public static final BitSet FOLLOW_dataType_in_constantDeclaration332 = new BitSet(new long[]{0x0000800000014000L});
    public static final BitSet FOLLOW_47_in_constantDeclaration336 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_DEFAULT_in_constantDeclaration340 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_literal_in_constantDeclaration345 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_constantDeclaration349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_literal0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_function426 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_function430 = new BitSet(new long[]{0x0001000000200000L});
    public static final BitSet FOLLOW_48_in_function442 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_param_in_function446 = new BitSet(new long[]{0x0002000800000000L});
    public static final BitSet FOLLOW_COMMA_in_function455 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_param_in_function459 = new BitSet(new long[]{0x0002000800000000L});
    public static final BitSet FOLLOW_49_in_function474 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_RETURN_in_function487 = new BitSet(new long[]{0x0000000200000200L});
    public static final BitSet FOLLOW_dataType_in_function491 = new BitSet(new long[]{0x0000000000045A00L});
    public static final BitSet FOLLOW_isOrAS_in_function497 = new BitSet(new long[]{0x0000000000044200L});
    public static final BitSet FOLLOW_ID_in_function500 = new BitSet(new long[]{0x0000000000044200L});
    public static final BitSet FOLLOW_QUOTED_LITERAL_in_function503 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_function514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROCEDURE_in_procedure560 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ID_in_procedure564 = new BitSet(new long[]{0x0001000000045A00L});
    public static final BitSet FOLLOW_48_in_procedure578 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_param_in_procedure582 = new BitSet(new long[]{0x0002000800000000L});
    public static final BitSet FOLLOW_COMMA_in_procedure592 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_param_in_procedure596 = new BitSet(new long[]{0x0002000800000000L});
    public static final BitSet FOLLOW_49_in_procedure613 = new BitSet(new long[]{0x0000000000045A00L});
    public static final BitSet FOLLOW_isOrAS_in_procedure628 = new BitSet(new long[]{0x0000000000044200L});
    public static final BitSet FOLLOW_ID_in_procedure631 = new BitSet(new long[]{0x0000000000044200L});
    public static final BitSet FOLLOW_QUOTED_LITERAL_in_procedure634 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_procedure646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRAGMA_in_pragmaDummy687 = new BitSet(new long[]{0x0003FFFFFFFFFFF0L});
    public static final BitSet FOLLOW_SEMI_in_pragmaDummy692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pragmaDummy_in_pragma707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_typeDefinitionDummy727 = new BitSet(new long[]{0x0003FFFFFFFFFFF0L});
    public static final BitSet FOLLOW_SEMI_in_typeDefinitionDummy732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeDefinitionDummy_in_typeDefinition747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBTYPE_in_subtypeDefinitionDummy769 = new BitSet(new long[]{0x0003FFFFFFFFFFF0L});
    public static final BitSet FOLLOW_SEMI_in_subtypeDefinitionDummy774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subtypeDefinitionDummy_in_subtypeDefinition791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CURSOR_in_cursorDeclarationDummy811 = new BitSet(new long[]{0x0003FFFFFFFFFFF0L});
    public static final BitSet FOLLOW_SEMI_in_cursorDeclarationDummy816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cursorDeclarationDummy_in_cursorDeclaration831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_variableDeclarationDummy851 = new BitSet(new long[]{0x0000000200000200L});
    public static final BitSet FOLLOW_dataType_in_variableDeclarationDummy853 = new BitSet(new long[]{0x0000800000010000L});
    public static final BitSet FOLLOW_set_in_variableDeclarationDummy855 = new BitSet(new long[]{0x0003FFFFFFFFFFF0L});
    public static final BitSet FOLLOW_SEMI_in_variableDeclarationDummy866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableDeclarationDummy_in_variableDeclaration880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_exceptionDeclaration900 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_EXCEPTION_in_exceptionDeclaration902 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_exceptionDeclaration904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ML_COMMENT_in_mlComment933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SL_COMMENT_in_slComment959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_param987 = new BitSet(new long[]{0x00000003C0000200L});
    public static final BitSet FOLLOW_IN_in_param989 = new BitSet(new long[]{0x0000000380000200L});
    public static final BitSet FOLLOW_OUT_in_param992 = new BitSet(new long[]{0x0000000300000200L});
    public static final BitSet FOLLOW_NOCOPY_in_param995 = new BitSet(new long[]{0x0000000200000200L});
    public static final BitSet FOLLOW_dataType_in_param1000 = new BitSet(new long[]{0x0000800000010002L});
    public static final BitSet FOLLOW_47_in_param1004 = new BitSet(new long[]{0x0003FFFFFFFFFFF2L});
    public static final BitSet FOLLOW_DEFAULT_in_param1008 = new BitSet(new long[]{0x0003FFFFFFFFFFF2L});
    public static final BitSet FOLLOW_dotStar_in_param1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_dataType1056 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_dataType1058 = new BitSet(new long[]{0x0000000200000200L});
    public static final BitSet FOLLOW_id_in_dataType1062 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_dataType1065 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NUMBER_in_dataType1067 = new BitSet(new long[]{0x0002000800000000L});
    public static final BitSet FOLLOW_COMMA_in_dataType1070 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NUMBER_in_dataType1072 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_dataType1076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_id0 = new BitSet(new long[]{0x0000000000000002L});

}