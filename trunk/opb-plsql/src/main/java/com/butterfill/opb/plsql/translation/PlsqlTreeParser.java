// $ANTLR 3.5 src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g 2013-04-22 20:27:33

package com.butterfill.opb.plsql.translation;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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
@SuppressWarnings("all")
public class PlsqlTreeParser extends PlsqlTreeParserSuperClass {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AS", "AUTHID", "COMMA", "CONSTANT", 
		"CURSOR", "DEFAULT", "END", "EQUALS", "EXCEPTION", "EXCLAMATION", "FORWARD_SLASH", 
		"FUNCTION", "GREATERTHAN", "ID", "IN", "IS", "LESSTHAN", "ML_COMMENT", 
		"NEWLINE", "NOCOPY", "NULL", "NUMBER", "OUT", "PACKAGE", "PERCENT", "PIPE", 
		"PRAGMA", "PROCEDURE", "QUESTION_MARK", "QUOTED_ID", "QUOTED_LITERAL", 
		"RETURN", "SEMI", "SL_COMMENT", "STAR", "SUBTYPE", "TYPE", "T_IGNORE", 
		"T_PARAM", "T_PARAMS", "T_PARAM_MODE", "WS", "'('", "')'", "'.'", "':='"
	};
	public static final int EOF=-1;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int AS=4;
	public static final int AUTHID=5;
	public static final int COMMA=6;
	public static final int CONSTANT=7;
	public static final int CURSOR=8;
	public static final int DEFAULT=9;
	public static final int END=10;
	public static final int EQUALS=11;
	public static final int EXCEPTION=12;
	public static final int EXCLAMATION=13;
	public static final int FORWARD_SLASH=14;
	public static final int FUNCTION=15;
	public static final int GREATERTHAN=16;
	public static final int ID=17;
	public static final int IN=18;
	public static final int IS=19;
	public static final int LESSTHAN=20;
	public static final int ML_COMMENT=21;
	public static final int NEWLINE=22;
	public static final int NOCOPY=23;
	public static final int NULL=24;
	public static final int NUMBER=25;
	public static final int OUT=26;
	public static final int PACKAGE=27;
	public static final int PERCENT=28;
	public static final int PIPE=29;
	public static final int PRAGMA=30;
	public static final int PROCEDURE=31;
	public static final int QUESTION_MARK=32;
	public static final int QUOTED_ID=33;
	public static final int QUOTED_LITERAL=34;
	public static final int RETURN=35;
	public static final int SEMI=36;
	public static final int SL_COMMENT=37;
	public static final int STAR=38;
	public static final int SUBTYPE=39;
	public static final int TYPE=40;
	public static final int T_IGNORE=41;
	public static final int T_PARAM=42;
	public static final int T_PARAMS=43;
	public static final int T_PARAM_MODE=44;
	public static final int WS=45;

	// delegates
	public PlsqlTreeParserSuperClass[] getDelegates() {
		return new PlsqlTreeParserSuperClass[] {};
	}

	// delegators


	public PlsqlTreeParser(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public PlsqlTreeParser(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return PlsqlTreeParser.tokenNames; }
	@Override public String getGrammarFileName() { return "src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g"; }



	// $ANTLR start "startRule"
	// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:35:1: startRule : createOrReplacePackage ( element )* ;
	public final void startRule() throws RecognitionException {
		try {
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:36:3: ( createOrReplacePackage ( element )* )
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:36:6: createOrReplacePackage ( element )*
			{
			pushFollow(FOLLOW_createOrReplacePackage_in_startRule53);
			createOrReplacePackage();
			state._fsp--;

			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:37:6: ( element )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==CONSTANT||LA1_0==FUNCTION||LA1_0==ML_COMMENT||LA1_0==PROCEDURE||LA1_0==T_IGNORE) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:37:6: element
					{
					pushFollow(FOLLOW_element_in_startRule60);
					element();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "startRule"



	// $ANTLR start "createOrReplacePackage"
	// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:40:1: createOrReplacePackage : ^( PACKAGE ID ) ;
	public final void createOrReplacePackage() throws RecognitionException {
		CommonTree ID1=null;

		try {
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:41:3: ( ^( PACKAGE ID ) )
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:41:6: ^( PACKAGE ID )
			{
			match(input,PACKAGE,FOLLOW_PACKAGE_in_createOrReplacePackage76); 
			match(input, Token.DOWN, null); 
			ID1=(CommonTree)match(input,ID,FOLLOW_ID_in_createOrReplacePackage78); 
			match(input, Token.UP, null); 

			setPlsqlPackageName((ID1!=null?ID1.getText():null));
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "createOrReplacePackage"



	// $ANTLR start "element"
	// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:44:1: element : ( mlComment | constantDeclaration | function | procedure | ignore );
	public final void element() throws RecognitionException {
		try {
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:45:3: ( mlComment | constantDeclaration | function | procedure | ignore )
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
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:45:6: mlComment
					{
					pushFollow(FOLLOW_mlComment_in_element97);
					mlComment();
					state._fsp--;

					}
					break;
				case 2 :
					// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:46:6: constantDeclaration
					{
					pushFollow(FOLLOW_constantDeclaration_in_element104);
					constantDeclaration();
					state._fsp--;

					}
					break;
				case 3 :
					// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:47:6: function
					{
					pushFollow(FOLLOW_function_in_element111);
					function();
					state._fsp--;

					}
					break;
				case 4 :
					// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:48:6: procedure
					{
					pushFollow(FOLLOW_procedure_in_element118);
					procedure();
					state._fsp--;

					}
					break;
				case 5 :
					// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:49:6: ignore
					{
					pushFollow(FOLLOW_ignore_in_element125);
					ignore();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "element"


	public static class mlComment_return extends TreeRuleReturnScope {
	};


	// $ANTLR start "mlComment"
	// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:52:1: mlComment : ML_COMMENT ;
	public final PlsqlTreeParser.mlComment_return mlComment() throws RecognitionException {
		PlsqlTreeParser.mlComment_return retval = new PlsqlTreeParser.mlComment_return();
		retval.start = input.LT(1);

		try {
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:53:3: ( ML_COMMENT )
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:53:6: ML_COMMENT
			{
			match(input,ML_COMMENT,FOLLOW_ML_COMMENT_in_mlComment139); 
			setMlComment(input.getTokenStream().toString(input.getTreeAdaptor().getTokenStartIndex(retval.start),input.getTreeAdaptor().getTokenStopIndex(retval.start)));
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "mlComment"



	// $ANTLR start "constantDeclaration"
	// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:56:1: constantDeclaration : ^( CONSTANT l_id= ID l_datatype= dataType (l_value= literal )? ) ;
	public final void constantDeclaration() throws RecognitionException {
		CommonTree l_id=null;
		TreeRuleReturnScope l_datatype =null;
		TreeRuleReturnScope l_value =null;

		try {
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:58:3: ( ^( CONSTANT l_id= ID l_datatype= dataType (l_value= literal )? ) )
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:58:6: ^( CONSTANT l_id= ID l_datatype= dataType (l_value= literal )? )
			{
			match(input,CONSTANT,FOLLOW_CONSTANT_in_constantDeclaration163); 
			match(input, Token.DOWN, null); 
			l_id=(CommonTree)match(input,ID,FOLLOW_ID_in_constantDeclaration167); 
			pushFollow(FOLLOW_dataType_in_constantDeclaration171);
			l_datatype=dataType();
			state._fsp--;

			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:58:52: (l_value= literal )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( ((LA3_0 >= NULL && LA3_0 <= NUMBER)||LA3_0==QUOTED_LITERAL) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:58:52: l_value= literal
					{
					pushFollow(FOLLOW_literal_in_constantDeclaration175);
					l_value=literal();
					state._fsp--;

					}
					break;

			}

			match(input, Token.UP, null); 

			addConstant((l_id!=null?l_id.getText():null), (l_datatype!=null?(input.getTokenStream().toString(input.getTreeAdaptor().getTokenStartIndex(l_datatype.start),input.getTreeAdaptor().getTokenStopIndex(l_datatype.start))):null), (l_value == null) ? null : (l_value!=null?(input.getTokenStream().toString(input.getTreeAdaptor().getTokenStartIndex(l_value.start),input.getTreeAdaptor().getTokenStopIndex(l_value.start))):null));
			}

			clearTempData();
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "constantDeclaration"


	public static class literal_return extends TreeRuleReturnScope {
	};


	// $ANTLR start "literal"
	// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:62:1: literal : ( NUMBER | QUOTED_LITERAL | NULL );
	public final PlsqlTreeParser.literal_return literal() throws RecognitionException {
		PlsqlTreeParser.literal_return retval = new PlsqlTreeParser.literal_return();
		retval.start = input.LT(1);

		try {
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:63:3: ( NUMBER | QUOTED_LITERAL | NULL )
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:
			{
			if ( (input.LA(1) >= NULL && input.LA(1) <= NUMBER)||input.LA(1)==QUOTED_LITERAL ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "literal"



	// $ANTLR start "function"
	// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:68:1: function : ^( FUNCTION l_id= ID ^( T_PARAMS ( param )* ) ^( RETURN l_returnType= dataType ) ) ;
	public final void function() throws RecognitionException {
		CommonTree l_id=null;
		TreeRuleReturnScope l_returnType =null;

		initFunction();
		try {
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:71:3: ( ^( FUNCTION l_id= ID ^( T_PARAMS ( param )* ) ^( RETURN l_returnType= dataType ) ) )
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:71:6: ^( FUNCTION l_id= ID ^( T_PARAMS ( param )* ) ^( RETURN l_returnType= dataType ) )
			{
			match(input,FUNCTION,FOLLOW_FUNCTION_in_function243); 
			match(input, Token.DOWN, null); 
			l_id=(CommonTree)match(input,ID,FOLLOW_ID_in_function247); 
			match(input,T_PARAMS,FOLLOW_T_PARAMS_in_function250); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:71:36: ( param )*
				loop4:
				while (true) {
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==T_PARAM) ) {
						alt4=1;
					}

					switch (alt4) {
					case 1 :
						// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:71:36: param
						{
						pushFollow(FOLLOW_param_in_function252);
						param();
						state._fsp--;

						}
						break;

					default :
						break loop4;
					}
				}

				match(input, Token.UP, null); 
			}

			match(input,RETURN,FOLLOW_RETURN_in_function257); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_dataType_in_function261);
			l_returnType=dataType();
			state._fsp--;

			match(input, Token.UP, null); 

			match(input, Token.UP, null); 

			setFunctionInfo((l_id!=null?l_id.getText():null), (l_returnType!=null?((PlsqlTreeParser.dataType_return)l_returnType).a:null), (l_returnType!=null?((PlsqlTreeParser.dataType_return)l_returnType).b:null));
			}

			clearTempData();
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "function"



	// $ANTLR start "procedure"
	// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:75:1: procedure : ^( PROCEDURE l_id= ID ^( T_PARAMS ( param )* ) ) ;
	public final void procedure() throws RecognitionException {
		CommonTree l_id=null;

		initProcedure();
		try {
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:78:3: ( ^( PROCEDURE l_id= ID ^( T_PARAMS ( param )* ) ) )
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:78:6: ^( PROCEDURE l_id= ID ^( T_PARAMS ( param )* ) )
			{
			match(input,PROCEDURE,FOLLOW_PROCEDURE_in_procedure299); 
			match(input, Token.DOWN, null); 
			l_id=(CommonTree)match(input,ID,FOLLOW_ID_in_procedure303); 
			match(input,T_PARAMS,FOLLOW_T_PARAMS_in_procedure306); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:78:37: ( param )*
				loop5:
				while (true) {
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==T_PARAM) ) {
						alt5=1;
					}

					switch (alt5) {
					case 1 :
						// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:78:37: param
						{
						pushFollow(FOLLOW_param_in_procedure308);
						param();
						state._fsp--;

						}
						break;

					default :
						break loop5;
					}
				}

				match(input, Token.UP, null); 
			}

			match(input, Token.UP, null); 

			setProcedureInfo((l_id!=null?l_id.getText():null));
			}

			clearTempData();
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "procedure"



	// $ANTLR start "ignore"
	// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:82:1: ignore : T_IGNORE ;
	public final void ignore() throws RecognitionException {
		try {
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:83:3: ( T_IGNORE )
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:83:6: T_IGNORE
			{
			match(input,T_IGNORE,FOLLOW_T_IGNORE_in_ignore332); 
			clearTempData();
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ignore"



	// $ANTLR start "param"
	// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:86:1: param : ^( T_PARAM l_id= ID l_dataType= dataType ^( T_PARAM_MODE (l_in= IN )? (l_out= OUT )? ) ) ;
	public final void param() throws RecognitionException {
		CommonTree l_id=null;
		CommonTree l_in=null;
		CommonTree l_out=null;
		TreeRuleReturnScope l_dataType =null;

		try {
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:87:3: ( ^( T_PARAM l_id= ID l_dataType= dataType ^( T_PARAM_MODE (l_in= IN )? (l_out= OUT )? ) ) )
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:87:6: ^( T_PARAM l_id= ID l_dataType= dataType ^( T_PARAM_MODE (l_in= IN )? (l_out= OUT )? ) )
			{
			match(input,T_PARAM,FOLLOW_T_PARAM_in_param353); 
			match(input, Token.DOWN, null); 
			l_id=(CommonTree)match(input,ID,FOLLOW_ID_in_param357); 
			pushFollow(FOLLOW_dataType_in_param361);
			l_dataType=dataType();
			state._fsp--;

			match(input,T_PARAM_MODE,FOLLOW_T_PARAM_MODE_in_param364); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:87:63: (l_in= IN )?
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==IN) ) {
					alt6=1;
				}
				switch (alt6) {
					case 1 :
						// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:87:63: l_in= IN
						{
						l_in=(CommonTree)match(input,IN,FOLLOW_IN_in_param368); 
						}
						break;

				}

				// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:87:73: (l_out= OUT )?
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==OUT) ) {
					alt7=1;
				}
				switch (alt7) {
					case 1 :
						// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:87:73: l_out= OUT
						{
						l_out=(CommonTree)match(input,OUT,FOLLOW_OUT_in_param373); 
						}
						break;

				}

				match(input, Token.UP, null); 
			}

			match(input, Token.UP, null); 

			addParam((l_id!=null?l_id.getText():null), (l_dataType!=null?((PlsqlTreeParser.dataType_return)l_dataType).a:null), (l_dataType!=null?((PlsqlTreeParser.dataType_return)l_dataType).b:null), l_in, l_out);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "param"


	public static class dataType_return extends TreeRuleReturnScope {
		public String a;
		public String b;
	};


	// $ANTLR start "dataType"
	// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:91:1: dataType returns [String a, String b] : (l_a= id '.' )? l_b= id ( '(' NUMBER ( ',' NUMBER )? ')' )? ;
	public final PlsqlTreeParser.dataType_return dataType() throws RecognitionException {
		PlsqlTreeParser.dataType_return retval = new PlsqlTreeParser.dataType_return();
		retval.start = input.LT(1);

		TreeRuleReturnScope l_a =null;
		TreeRuleReturnScope l_b =null;

		try {
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:92:3: ( (l_a= id '.' )? l_b= id ( '(' NUMBER ( ',' NUMBER )? ')' )? )
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:92:6: (l_a= id '.' )? l_b= id ( '(' NUMBER ( ',' NUMBER )? ')' )?
			{
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:92:6: (l_a= id '.' )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==ID||LA8_0==QUOTED_ID) ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1==48) ) {
					alt8=1;
				}
			}
			switch (alt8) {
				case 1 :
					// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:92:7: l_a= id '.'
					{
					pushFollow(FOLLOW_id_in_dataType403);
					l_a=id();
					state._fsp--;

					match(input,48,FOLLOW_48_in_dataType405); 
					}
					break;

			}

			pushFollow(FOLLOW_id_in_dataType411);
			l_b=id();
			state._fsp--;

			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:92:27: ( '(' NUMBER ( ',' NUMBER )? ')' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==46) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:92:28: '(' NUMBER ( ',' NUMBER )? ')'
					{
					match(input,46,FOLLOW_46_in_dataType414); 
					match(input,NUMBER,FOLLOW_NUMBER_in_dataType416); 
					// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:92:39: ( ',' NUMBER )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==COMMA) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:92:40: ',' NUMBER
							{
							match(input,COMMA,FOLLOW_COMMA_in_dataType419); 
							match(input,NUMBER,FOLLOW_NUMBER_in_dataType421); 
							}
							break;

					}

					match(input,47,FOLLOW_47_in_dataType425); 
					}
					break;

			}

			retval.a =(l_a == null) ? null : (l_a!=null?(input.getTokenStream().toString(input.getTreeAdaptor().getTokenStartIndex(l_a.start),input.getTreeAdaptor().getTokenStopIndex(l_a.start))):null); retval.b =(l_b!=null?(input.getTokenStream().toString(input.getTreeAdaptor().getTokenStartIndex(l_b.start),input.getTreeAdaptor().getTokenStopIndex(l_b.start))):null);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dataType"


	public static class id_return extends TreeRuleReturnScope {
	};


	// $ANTLR start "id"
	// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:96:1: id : ( ID | QUOTED_ID );
	public final PlsqlTreeParser.id_return id() throws RecognitionException {
		PlsqlTreeParser.id_return retval = new PlsqlTreeParser.id_return();
		retval.start = input.LT(1);

		try {
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:97:3: ( ID | QUOTED_ID )
			// src/main/java/com/butterfill/opb/plsql/translation/PlsqlTreeParser.g:
			{
			if ( input.LA(1)==ID||input.LA(1)==QUOTED_ID ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "id"

	// Delegated rules



	public static final BitSet FOLLOW_createOrReplacePackage_in_startRule53 = new BitSet(new long[]{0x0000020080208082L});
	public static final BitSet FOLLOW_element_in_startRule60 = new BitSet(new long[]{0x0000020080208082L});
	public static final BitSet FOLLOW_PACKAGE_in_createOrReplacePackage76 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_createOrReplacePackage78 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_mlComment_in_element97 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constantDeclaration_in_element104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_element111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_procedure_in_element118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ignore_in_element125 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ML_COMMENT_in_mlComment139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONSTANT_in_constantDeclaration163 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_constantDeclaration167 = new BitSet(new long[]{0x0000000200020000L});
	public static final BitSet FOLLOW_dataType_in_constantDeclaration171 = new BitSet(new long[]{0x0000000403000008L});
	public static final BitSet FOLLOW_literal_in_constantDeclaration175 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_FUNCTION_in_function243 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_function247 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_T_PARAMS_in_function250 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_function252 = new BitSet(new long[]{0x0000040000000008L});
	public static final BitSet FOLLOW_RETURN_in_function257 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_dataType_in_function261 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PROCEDURE_in_procedure299 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_procedure303 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_T_PARAMS_in_procedure306 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_param_in_procedure308 = new BitSet(new long[]{0x0000040000000008L});
	public static final BitSet FOLLOW_T_IGNORE_in_ignore332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_T_PARAM_in_param353 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_param357 = new BitSet(new long[]{0x0000000200020000L});
	public static final BitSet FOLLOW_dataType_in_param361 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_T_PARAM_MODE_in_param364 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IN_in_param368 = new BitSet(new long[]{0x0000000004000008L});
	public static final BitSet FOLLOW_OUT_in_param373 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_id_in_dataType403 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_48_in_dataType405 = new BitSet(new long[]{0x0000000200020000L});
	public static final BitSet FOLLOW_id_in_dataType411 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_46_in_dataType414 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_NUMBER_in_dataType416 = new BitSet(new long[]{0x0000800000000040L});
	public static final BitSet FOLLOW_COMMA_in_dataType419 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_NUMBER_in_dataType421 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_dataType425 = new BitSet(new long[]{0x0000000000000002L});
}
