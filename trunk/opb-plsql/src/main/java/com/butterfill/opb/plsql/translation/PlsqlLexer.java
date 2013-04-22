// $ANTLR 3.5 src/main/java/com/butterfill/opb/plsql/translation/Plsql.g 2013-04-22 20:27:33

package com.butterfill.opb.plsql.translation;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PlsqlLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public PlsqlLexer() {} 
	public PlsqlLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public PlsqlLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g"; }

	// $ANTLR start "T__46"
	public final void mT__46() throws RecognitionException {
		try {
			int _type = T__46;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:6:7: ( '(' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:6:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__46"

	// $ANTLR start "T__47"
	public final void mT__47() throws RecognitionException {
		try {
			int _type = T__47;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:7:7: ( ')' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:7:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__47"

	// $ANTLR start "T__48"
	public final void mT__48() throws RecognitionException {
		try {
			int _type = T__48;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:8:7: ( '.' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:8:9: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__48"

	// $ANTLR start "T__49"
	public final void mT__49() throws RecognitionException {
		try {
			int _type = T__49;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:9:7: ( ':=' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:9:9: ':='
			{
			match(":="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__49"

	// $ANTLR start "CURSOR"
	public final void mCURSOR() throws RecognitionException {
		try {
			int _type = CURSOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:205:3: ( ( 'c' | 'C' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 's' | 'S' ) ( 'o' | 'O' ) ( 'r' | 'R' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:205:6: ( 'c' | 'C' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 's' | 'S' ) ( 'o' | 'O' ) ( 'r' | 'R' )
			{
			if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CURSOR"

	// $ANTLR start "AS"
	public final void mAS() throws RecognitionException {
		try {
			int _type = AS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:209:3: ( ( 'a' | 'A' ) ( 's' | 'S' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:209:6: ( 'a' | 'A' ) ( 's' | 'S' )
			{
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AS"

	// $ANTLR start "IS"
	public final void mIS() throws RecognitionException {
		try {
			int _type = IS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:213:3: ( ( 'i' | 'I' ) ( 's' | 'S' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:213:6: ( 'i' | 'I' ) ( 's' | 'S' )
			{
			if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IS"

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:217:3: ( ( 'r' | 'R' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 'n' | 'N' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:217:6: ( 'r' | 'R' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 'n' | 'N' )
			{
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURN"

	// $ANTLR start "PACKAGE"
	public final void mPACKAGE() throws RecognitionException {
		try {
			int _type = PACKAGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:221:3: ( ( 'p' | 'P' ) ( 'a' | 'A' ) ( 'c' | 'C' ) ( 'k' | 'K' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'e' | 'E' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:221:6: ( 'p' | 'P' ) ( 'a' | 'A' ) ( 'c' | 'C' ) ( 'k' | 'K' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'e' | 'E' )
			{
			if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PACKAGE"

	// $ANTLR start "END"
	public final void mEND() throws RecognitionException {
		try {
			int _type = END;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:225:3: ( ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:225:6: ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' )
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "END"

	// $ANTLR start "AUTHID"
	public final void mAUTHID() throws RecognitionException {
		try {
			int _type = AUTHID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:229:3: ( ( 'a' | 'A' ) ( 'u' | 'U' ) ( 't' | 'T' ) ( 'h' | 'H' ) ( 'i' | 'I' ) ( 'd' | 'D' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:229:6: ( 'a' | 'A' ) ( 'u' | 'U' ) ( 't' | 'T' ) ( 'h' | 'H' ) ( 'i' | 'I' ) ( 'd' | 'D' )
			{
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AUTHID"

	// $ANTLR start "FUNCTION"
	public final void mFUNCTION() throws RecognitionException {
		try {
			int _type = FUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:233:3: ( ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 'c' | 'C' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:233:6: ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 'c' | 'C' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' )
			{
			if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUNCTION"

	// $ANTLR start "PROCEDURE"
	public final void mPROCEDURE() throws RecognitionException {
		try {
			int _type = PROCEDURE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:237:3: ( ( 'p' | 'P' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'e' | 'E' ) ( 'd' | 'D' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 'e' | 'E' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:237:6: ( 'p' | 'P' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'e' | 'E' ) ( 'd' | 'D' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 'e' | 'E' )
			{
			if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PROCEDURE"

	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:241:3: ( ( 'i' | 'I' ) ( 'n' | 'N' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:241:6: ( 'i' | 'I' ) ( 'n' | 'N' )
			{
			if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IN"

	// $ANTLR start "OUT"
	public final void mOUT() throws RecognitionException {
		try {
			int _type = OUT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:245:3: ( ( 'o' | 'O' ) ( 'u' | 'U' ) ( 't' | 'T' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:245:6: ( 'o' | 'O' ) ( 'u' | 'U' ) ( 't' | 'T' )
			{
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OUT"

	// $ANTLR start "NOCOPY"
	public final void mNOCOPY() throws RecognitionException {
		try {
			int _type = NOCOPY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:249:3: ( ( 'n' | 'N' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'p' | 'P' ) ( 'y' | 'Y' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:249:6: ( 'n' | 'N' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'p' | 'P' ) ( 'y' | 'Y' )
			{
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOCOPY"

	// $ANTLR start "DEFAULT"
	public final void mDEFAULT() throws RecognitionException {
		try {
			int _type = DEFAULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:253:3: ( ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 't' | 'T' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:253:6: ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 't' | 'T' )
			{
			if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFAULT"

	// $ANTLR start "EXCEPTION"
	public final void mEXCEPTION() throws RecognitionException {
		try {
			int _type = EXCEPTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:257:3: ( ( 'e' | 'E' ) ( 'x' | 'X' ) ( 'c' | 'C' ) ( 'e' | 'E' ) ( 'p' | 'P' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:257:6: ( 'e' | 'E' ) ( 'x' | 'X' ) ( 'c' | 'C' ) ( 'e' | 'E' ) ( 'p' | 'P' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' )
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXCEPTION"

	// $ANTLR start "CONSTANT"
	public final void mCONSTANT() throws RecognitionException {
		try {
			int _type = CONSTANT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:261:3: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 't' | 'T' ) ( 'a' | 'A' ) ( 'n' | 'N' ) ( 't' | 'T' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:261:6: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 't' | 'T' ) ( 'a' | 'A' ) ( 'n' | 'N' ) ( 't' | 'T' )
			{
			if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONSTANT"

	// $ANTLR start "PRAGMA"
	public final void mPRAGMA() throws RecognitionException {
		try {
			int _type = PRAGMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:265:3: ( ( 'p' | 'P' ) ( 'r' | 'R' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'm' | 'M' ) ( 'a' | 'A' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:265:6: ( 'p' | 'P' ) ( 'r' | 'R' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'm' | 'M' ) ( 'a' | 'A' )
			{
			if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRAGMA"

	// $ANTLR start "TYPE"
	public final void mTYPE() throws RecognitionException {
		try {
			int _type = TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:269:3: ( ( 't' | 'T' ) ( 'y' | 'Y' ) ( 'p' | 'P' ) ( 'e' | 'E' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:269:6: ( 't' | 'T' ) ( 'y' | 'Y' ) ( 'p' | 'P' ) ( 'e' | 'E' )
			{
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TYPE"

	// $ANTLR start "SUBTYPE"
	public final void mSUBTYPE() throws RecognitionException {
		try {
			int _type = SUBTYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:273:3: ( ( 's' | 'S' ) ( 'u' | 'U' ) ( 'b' | 'B' ) ( 't' | 'T' ) ( 'y' | 'Y' ) ( 'p' | 'P' ) ( 'e' | 'E' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:273:6: ( 's' | 'S' ) ( 'u' | 'U' ) ( 'b' | 'B' ) ( 't' | 'T' ) ( 'y' | 'Y' ) ( 'p' | 'P' ) ( 'e' | 'E' )
			{
			if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUBTYPE"

	// $ANTLR start "NULL"
	public final void mNULL() throws RecognitionException {
		try {
			int _type = NULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:277:3: ( ( 'n' | 'N' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'l' | 'L' ) )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:277:6: ( 'n' | 'N' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'l' | 'L' )
			{
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NULL"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:285:3: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' | '#' | '0' .. '9' | '%' | '[' | ']' | '?' )* )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:285:6: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' | '#' | '0' .. '9' | '%' | '[' | ']' | '?' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:285:28: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' | '#' | '0' .. '9' | '%' | '[' | ']' | '?' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '#' && LA1_0 <= '%')||(LA1_0 >= '0' && LA1_0 <= '9')||LA1_0=='?'||(LA1_0 >= 'A' && LA1_0 <= '[')||LA1_0==']'||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:
					{
					if ( (input.LA(1) >= '#' && input.LA(1) <= '%')||(input.LA(1) >= '0' && input.LA(1) <= '9')||input.LA(1)=='?'||(input.LA(1) >= 'A' && input.LA(1) <= '[')||input.LA(1)==']'||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "QUOTED_ID"
	public final void mQUOTED_ID() throws RecognitionException {
		try {
			int _type = QUOTED_ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:289:3: ( '\"' ( options {greedy=false; } : . )+ '\"' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:289:6: '\"' ( options {greedy=false; } : . )+ '\"'
			{
			match('\"'); 
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:289:10: ( options {greedy=false; } : . )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0=='\"') ) {
					alt2=2;
				}
				else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '!')||(LA2_0 >= '#' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:289:38: .
					{
					matchAny(); 
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUOTED_ID"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:293:3: ( ( '-' )? ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:293:6: ( '-' )? ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
			{
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:293:6: ( '-' )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='-') ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:293:6: '-'
					{
					match('-'); 
					}
					break;

			}

			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:293:11: ( '0' .. '9' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:293:21: ( '.' ( '0' .. '9' )+ )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='.') ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:293:22: '.' ( '0' .. '9' )+
					{
					match('.'); 
					// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:293:26: ( '0' .. '9' )+
					int cnt5=0;
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt5 >= 1 ) break loop5;
							EarlyExitException eee = new EarlyExitException(5, input);
							throw eee;
						}
						cnt5++;
					}

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "QUOTED_LITERAL"
	public final void mQUOTED_LITERAL() throws RecognitionException {
		try {
			int _type = QUOTED_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:297:3: ( '\\'' ( options {greedy=false; } : . )* '\\'' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:297:6: '\\'' ( options {greedy=false; } : . )* '\\''
			{
			match('\''); 
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:297:11: ( options {greedy=false; } : . )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0=='\'') ) {
					alt7=2;
				}
				else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '&')||(LA7_0 >= '(' && LA7_0 <= '\uFFFF')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:297:39: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop7;
				}
			}

			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUOTED_LITERAL"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:303:3: ( ( '\\r' )? '\\n' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:303:6: ( '\\r' )? '\\n'
			{
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:303:6: ( '\\r' )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='\r') ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:303:6: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "SL_COMMENT"
	public final void mSL_COMMENT() throws RecognitionException {
		try {
			int _type = SL_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:306:3: ( '--' ( . )* NEWLINE )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:306:7: '--' ( . )* NEWLINE
			{
			match("--"); 

			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:306:12: ( . )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0=='\r') ) {
					alt9=2;
				}
				else if ( (LA9_0=='\n') ) {
					alt9=2;
				}
				else if ( ((LA9_0 >= '\u0000' && LA9_0 <= '\t')||(LA9_0 >= '\u000B' && LA9_0 <= '\f')||(LA9_0 >= '\u000E' && LA9_0 <= '\uFFFF')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:306:12: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop9;
				}
			}

			mNEWLINE(); 

			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SL_COMMENT"

	// $ANTLR start "ML_COMMENT"
	public final void mML_COMMENT() throws RecognitionException {
		try {
			int _type = ML_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:310:3: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:310:6: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:310:11: ( options {greedy=false; } : . )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0=='*') ) {
					int LA10_1 = input.LA(2);
					if ( (LA10_1=='/') ) {
						alt10=2;
					}
					else if ( ((LA10_1 >= '\u0000' && LA10_1 <= '.')||(LA10_1 >= '0' && LA10_1 <= '\uFFFF')) ) {
						alt10=1;
					}

				}
				else if ( ((LA10_0 >= '\u0000' && LA10_0 <= ')')||(LA10_0 >= '+' && LA10_0 <= '\uFFFF')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:310:39: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop10;
				}
			}

			match("*/"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ML_COMMENT"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:314:3: ( ',' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:314:6: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "EQUALS"
	public final void mEQUALS() throws RecognitionException {
		try {
			int _type = EQUALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:318:3: ( '=' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:318:6: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUALS"

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:322:3: ( ';' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:322:6: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMI"

	// $ANTLR start "QUESTION_MARK"
	public final void mQUESTION_MARK() throws RecognitionException {
		try {
			int _type = QUESTION_MARK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:326:3: ( '?' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:326:6: '?'
			{
			match('?'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUESTION_MARK"

	// $ANTLR start "FORWARD_SLASH"
	public final void mFORWARD_SLASH() throws RecognitionException {
		try {
			int _type = FORWARD_SLASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:330:3: ( '/' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:330:6: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FORWARD_SLASH"

	// $ANTLR start "PERCENT"
	public final void mPERCENT() throws RecognitionException {
		try {
			int _type = PERCENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:334:3: ( '%' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:334:6: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PERCENT"

	// $ANTLR start "PIPE"
	public final void mPIPE() throws RecognitionException {
		try {
			int _type = PIPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:338:3: ( '|' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:338:6: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PIPE"

	// $ANTLR start "STAR"
	public final void mSTAR() throws RecognitionException {
		try {
			int _type = STAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:342:3: ( '*' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:342:6: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STAR"

	// $ANTLR start "EXCLAMATION"
	public final void mEXCLAMATION() throws RecognitionException {
		try {
			int _type = EXCLAMATION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:346:3: ( '!' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:346:6: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXCLAMATION"

	// $ANTLR start "GREATERTHAN"
	public final void mGREATERTHAN() throws RecognitionException {
		try {
			int _type = GREATERTHAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:350:3: ( '>' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:350:6: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GREATERTHAN"

	// $ANTLR start "LESSTHAN"
	public final void mLESSTHAN() throws RecognitionException {
		try {
			int _type = LESSTHAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:354:3: ( '<' )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:354:6: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESSTHAN"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:358:3: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:358:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
			{
			// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:358:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= '\t' && LA11_0 <= '\n')||LA11_0=='\r'||LA11_0==' ') ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:8: ( T__46 | T__47 | T__48 | T__49 | CURSOR | AS | IS | RETURN | PACKAGE | END | AUTHID | FUNCTION | PROCEDURE | IN | OUT | NOCOPY | DEFAULT | EXCEPTION | CONSTANT | PRAGMA | TYPE | SUBTYPE | NULL | ID | QUOTED_ID | NUMBER | QUOTED_LITERAL | SL_COMMENT | ML_COMMENT | COMMA | EQUALS | SEMI | QUESTION_MARK | FORWARD_SLASH | PERCENT | PIPE | STAR | EXCLAMATION | GREATERTHAN | LESSTHAN | WS )
		int alt12=41;
		alt12 = dfa12.predict(input);
		switch (alt12) {
			case 1 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:10: T__46
				{
				mT__46(); 

				}
				break;
			case 2 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:16: T__47
				{
				mT__47(); 

				}
				break;
			case 3 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:22: T__48
				{
				mT__48(); 

				}
				break;
			case 4 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:28: T__49
				{
				mT__49(); 

				}
				break;
			case 5 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:34: CURSOR
				{
				mCURSOR(); 

				}
				break;
			case 6 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:41: AS
				{
				mAS(); 

				}
				break;
			case 7 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:44: IS
				{
				mIS(); 

				}
				break;
			case 8 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:47: RETURN
				{
				mRETURN(); 

				}
				break;
			case 9 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:54: PACKAGE
				{
				mPACKAGE(); 

				}
				break;
			case 10 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:62: END
				{
				mEND(); 

				}
				break;
			case 11 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:66: AUTHID
				{
				mAUTHID(); 

				}
				break;
			case 12 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:73: FUNCTION
				{
				mFUNCTION(); 

				}
				break;
			case 13 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:82: PROCEDURE
				{
				mPROCEDURE(); 

				}
				break;
			case 14 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:92: IN
				{
				mIN(); 

				}
				break;
			case 15 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:95: OUT
				{
				mOUT(); 

				}
				break;
			case 16 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:99: NOCOPY
				{
				mNOCOPY(); 

				}
				break;
			case 17 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:106: DEFAULT
				{
				mDEFAULT(); 

				}
				break;
			case 18 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:114: EXCEPTION
				{
				mEXCEPTION(); 

				}
				break;
			case 19 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:124: CONSTANT
				{
				mCONSTANT(); 

				}
				break;
			case 20 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:133: PRAGMA
				{
				mPRAGMA(); 

				}
				break;
			case 21 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:140: TYPE
				{
				mTYPE(); 

				}
				break;
			case 22 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:145: SUBTYPE
				{
				mSUBTYPE(); 

				}
				break;
			case 23 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:153: NULL
				{
				mNULL(); 

				}
				break;
			case 24 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:158: ID
				{
				mID(); 

				}
				break;
			case 25 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:161: QUOTED_ID
				{
				mQUOTED_ID(); 

				}
				break;
			case 26 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:171: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 27 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:178: QUOTED_LITERAL
				{
				mQUOTED_LITERAL(); 

				}
				break;
			case 28 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:193: SL_COMMENT
				{
				mSL_COMMENT(); 

				}
				break;
			case 29 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:204: ML_COMMENT
				{
				mML_COMMENT(); 

				}
				break;
			case 30 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:215: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 31 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:221: EQUALS
				{
				mEQUALS(); 

				}
				break;
			case 32 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:228: SEMI
				{
				mSEMI(); 

				}
				break;
			case 33 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:233: QUESTION_MARK
				{
				mQUESTION_MARK(); 

				}
				break;
			case 34 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:247: FORWARD_SLASH
				{
				mFORWARD_SLASH(); 

				}
				break;
			case 35 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:261: PERCENT
				{
				mPERCENT(); 

				}
				break;
			case 36 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:269: PIPE
				{
				mPIPE(); 

				}
				break;
			case 37 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:274: STAR
				{
				mSTAR(); 

				}
				break;
			case 38 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:279: EXCLAMATION
				{
				mEXCLAMATION(); 

				}
				break;
			case 39 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:291: GREATERTHAN
				{
				mGREATERTHAN(); 

				}
				break;
			case 40 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:303: LESSTHAN
				{
				mLESSTHAN(); 

				}
				break;
			case 41 :
				// src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:312: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA12 dfa12 = new DFA12(this);
	static final String DFA12_eotS =
		"\5\uffff\14\21\5\uffff\1\66\13\uffff\2\21\1\71\1\21\1\73\1\74\14\21\3"+
		"\uffff\2\21\1\uffff\1\21\2\uffff\4\21\1\121\2\21\1\124\14\21\1\uffff\2"+
		"\21\1\uffff\1\21\1\144\1\21\1\146\13\21\1\uffff\1\21\1\uffff\1\21\1\164"+
		"\1\21\1\166\1\167\2\21\1\172\2\21\1\175\2\21\1\uffff\1\21\2\uffff\1\u0081"+
		"\1\21\1\uffff\2\21\1\uffff\1\u0085\1\u0086\1\u0087\1\uffff\2\21\1\u008a"+
		"\3\uffff\1\u008b\1\u008c\3\uffff";
	static final String DFA12_eofS =
		"\u008d\uffff";
	static final String DFA12_minS =
		"\1\11\4\uffff\1\117\1\123\1\116\1\105\1\101\1\116\2\125\1\117\1\105\1"+
		"\131\1\125\2\uffff\1\55\2\uffff\1\52\13\uffff\1\122\1\116\1\43\1\124\2"+
		"\43\1\124\1\103\1\101\1\104\1\103\1\116\1\124\1\103\1\114\1\106\1\120"+
		"\1\102\3\uffff\2\123\1\uffff\1\110\2\uffff\1\125\1\113\1\103\1\107\1\43"+
		"\1\105\1\103\1\43\1\117\1\114\1\101\1\105\1\124\1\117\1\124\1\111\1\122"+
		"\1\101\1\105\1\115\1\uffff\1\120\1\124\1\uffff\1\120\1\43\1\125\1\43\1"+
		"\131\1\122\1\101\1\104\1\116\1\107\1\104\1\101\1\124\1\111\1\131\1\uffff"+
		"\1\114\1\uffff\1\120\1\43\1\116\2\43\1\105\1\125\1\43\1\111\1\117\1\43"+
		"\1\124\1\105\1\uffff\1\124\2\uffff\1\43\1\122\1\uffff\1\117\1\116\1\uffff"+
		"\3\43\1\uffff\1\105\1\116\1\43\3\uffff\2\43\3\uffff";
	static final String DFA12_maxS =
		"\1\174\4\uffff\2\165\1\163\1\145\1\162\1\170\3\165\1\145\1\171\1\165\2"+
		"\uffff\1\71\2\uffff\1\52\13\uffff\1\162\1\156\1\172\1\164\2\172\1\164"+
		"\1\143\1\157\1\144\1\143\1\156\1\164\1\143\1\154\1\146\1\160\1\142\3\uffff"+
		"\2\163\1\uffff\1\150\2\uffff\1\165\1\153\1\143\1\147\1\172\1\145\1\143"+
		"\1\172\1\157\1\154\1\141\1\145\1\164\1\157\1\164\1\151\1\162\1\141\1\145"+
		"\1\155\1\uffff\1\160\1\164\1\uffff\1\160\1\172\1\165\1\172\1\171\1\162"+
		"\1\141\1\144\1\156\1\147\1\144\1\141\1\164\1\151\1\171\1\uffff\1\154\1"+
		"\uffff\1\160\1\172\1\156\2\172\1\145\1\165\1\172\1\151\1\157\1\172\1\164"+
		"\1\145\1\uffff\1\164\2\uffff\1\172\1\162\1\uffff\1\157\1\156\1\uffff\3"+
		"\172\1\uffff\1\145\1\156\1\172\3\uffff\2\172\3\uffff";
	static final String DFA12_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\14\uffff\1\30\1\31\1\uffff\1\32\1\33\1\uffff"+
		"\1\36\1\37\1\40\1\41\1\43\1\44\1\45\1\46\1\47\1\50\1\51\22\uffff\1\34"+
		"\1\35\1\42\2\uffff\1\6\1\uffff\1\7\1\16\24\uffff\1\12\2\uffff\1\17\17"+
		"\uffff\1\27\1\uffff\1\25\15\uffff\1\5\1\uffff\1\13\1\10\2\uffff\1\24\2"+
		"\uffff\1\20\3\uffff\1\11\3\uffff\1\21\1\26\1\23\2\uffff\1\14\1\15\1\22";
	static final String DFA12_specialS =
		"\u008d\uffff}>";
	static final String[] DFA12_transitionS = {
			"\2\41\2\uffff\1\41\22\uffff\1\41\1\36\1\22\2\uffff\1\33\1\uffff\1\25"+
			"\1\1\1\2\1\35\1\uffff\1\27\1\23\1\3\1\26\12\24\1\4\1\31\1\40\1\30\1\37"+
			"\1\32\1\uffff\1\6\1\21\1\5\1\16\1\12\1\13\2\21\1\7\4\21\1\15\1\14\1\11"+
			"\1\21\1\10\1\20\1\17\6\21\6\uffff\1\6\1\21\1\5\1\16\1\12\1\13\2\21\1"+
			"\7\4\21\1\15\1\14\1\11\1\21\1\10\1\20\1\17\6\21\1\uffff\1\34",
			"",
			"",
			"",
			"",
			"\1\43\5\uffff\1\42\31\uffff\1\43\5\uffff\1\42",
			"\1\44\1\uffff\1\45\35\uffff\1\44\1\uffff\1\45",
			"\1\47\4\uffff\1\46\32\uffff\1\47\4\uffff\1\46",
			"\1\50\37\uffff\1\50",
			"\1\51\20\uffff\1\52\16\uffff\1\51\20\uffff\1\52",
			"\1\53\11\uffff\1\54\25\uffff\1\53\11\uffff\1\54",
			"\1\55\37\uffff\1\55",
			"\1\56\37\uffff\1\56",
			"\1\57\5\uffff\1\60\31\uffff\1\57\5\uffff\1\60",
			"\1\61\37\uffff\1\61",
			"\1\62\37\uffff\1\62",
			"\1\63\37\uffff\1\63",
			"",
			"",
			"\1\64\2\uffff\12\24",
			"",
			"",
			"\1\65",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\67\37\uffff\1\67",
			"\1\70\37\uffff\1\70",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"\1\72\37\uffff\1\72",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"\1\75\37\uffff\1\75",
			"\1\76\37\uffff\1\76",
			"\1\100\15\uffff\1\77\21\uffff\1\100\15\uffff\1\77",
			"\1\101\37\uffff\1\101",
			"\1\102\37\uffff\1\102",
			"\1\103\37\uffff\1\103",
			"\1\104\37\uffff\1\104",
			"\1\105\37\uffff\1\105",
			"\1\106\37\uffff\1\106",
			"\1\107\37\uffff\1\107",
			"\1\110\37\uffff\1\110",
			"\1\111\37\uffff\1\111",
			"",
			"",
			"",
			"\1\112\37\uffff\1\112",
			"\1\113\37\uffff\1\113",
			"",
			"\1\114\37\uffff\1\114",
			"",
			"",
			"\1\115\37\uffff\1\115",
			"\1\116\37\uffff\1\116",
			"\1\117\37\uffff\1\117",
			"\1\120\37\uffff\1\120",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"\1\122\37\uffff\1\122",
			"\1\123\37\uffff\1\123",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"\1\125\37\uffff\1\125",
			"\1\126\37\uffff\1\126",
			"\1\127\37\uffff\1\127",
			"\1\130\37\uffff\1\130",
			"\1\131\37\uffff\1\131",
			"\1\132\37\uffff\1\132",
			"\1\133\37\uffff\1\133",
			"\1\134\37\uffff\1\134",
			"\1\135\37\uffff\1\135",
			"\1\136\37\uffff\1\136",
			"\1\137\37\uffff\1\137",
			"\1\140\37\uffff\1\140",
			"",
			"\1\141\37\uffff\1\141",
			"\1\142\37\uffff\1\142",
			"",
			"\1\143\37\uffff\1\143",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"\1\145\37\uffff\1\145",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"\1\147\37\uffff\1\147",
			"\1\150\37\uffff\1\150",
			"\1\151\37\uffff\1\151",
			"\1\152\37\uffff\1\152",
			"\1\153\37\uffff\1\153",
			"\1\154\37\uffff\1\154",
			"\1\155\37\uffff\1\155",
			"\1\156\37\uffff\1\156",
			"\1\157\37\uffff\1\157",
			"\1\160\37\uffff\1\160",
			"\1\161\37\uffff\1\161",
			"",
			"\1\162\37\uffff\1\162",
			"",
			"\1\163\37\uffff\1\163",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"\1\165\37\uffff\1\165",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"\1\170\37\uffff\1\170",
			"\1\171\37\uffff\1\171",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"\1\173\37\uffff\1\173",
			"\1\174\37\uffff\1\174",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"\1\176\37\uffff\1\176",
			"\1\177\37\uffff\1\177",
			"",
			"\1\u0080\37\uffff\1\u0080",
			"",
			"",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"\1\u0082\37\uffff\1\u0082",
			"",
			"\1\u0083\37\uffff\1\u0083",
			"\1\u0084\37\uffff\1\u0084",
			"",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"",
			"\1\u0088\37\uffff\1\u0088",
			"\1\u0089\37\uffff\1\u0089",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"",
			"",
			"",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"\3\21\12\uffff\12\21\5\uffff\1\21\1\uffff\33\21\1\uffff\1\21\1\uffff"+
			"\1\21\1\uffff\32\21",
			"",
			"",
			""
	};

	static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
	static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
	static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
	static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
	static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
	static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
	static final short[][] DFA12_transition;

	static {
		int numStates = DFA12_transitionS.length;
		DFA12_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
		}
	}

	protected class DFA12 extends DFA {

		public DFA12(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 12;
			this.eot = DFA12_eot;
			this.eof = DFA12_eof;
			this.min = DFA12_min;
			this.max = DFA12_max;
			this.accept = DFA12_accept;
			this.special = DFA12_special;
			this.transition = DFA12_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__46 | T__47 | T__48 | T__49 | CURSOR | AS | IS | RETURN | PACKAGE | END | AUTHID | FUNCTION | PROCEDURE | IN | OUT | NOCOPY | DEFAULT | EXCEPTION | CONSTANT | PRAGMA | TYPE | SUBTYPE | NULL | ID | QUOTED_ID | NUMBER | QUOTED_LITERAL | SL_COMMENT | ML_COMMENT | COMMA | EQUALS | SEMI | QUESTION_MARK | FORWARD_SLASH | PERCENT | PIPE | STAR | EXCLAMATION | GREATERTHAN | LESSTHAN | WS );";
		}
	}

}
