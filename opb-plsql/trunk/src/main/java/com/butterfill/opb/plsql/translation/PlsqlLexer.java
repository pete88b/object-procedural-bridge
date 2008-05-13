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

// $ANTLR 3.0.1 src/com/butterfill/opb/plsql/translation/Plsql.g 2008-03-25 12:32:55

package com.butterfill.opb.plsql.translation;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings(value="unchecked")
class PlsqlLexer extends Lexer {
    public static final int COMMA=35;
    public static final int TYPE=24;
    public static final int PRAGMA=23;
    public static final int AS=12;
    public static final int PERCENT=39;
    public static final int END=13;
    public static final int NUMBER=17;
    public static final int QUOTED_LITERAL=18;
    public static final int PROCEDURE=22;
    public static final int OUT=31;
    public static final int T_PARAM_MODE=6;
    public static final int T45=45;
    public static final int PACKAGE=8;
    public static final int PIPE=40;
    public static final int NEWLINE=34;
    public static final int QUESTION_MARK=37;
    public static final int FUNCTION=20;
    public static final int CONSTANT=15;
    public static final int T46=46;
    public static final int AUTHID=10;
    public static final int ML_COMMENT=28;
    public static final int SL_COMMENT=29;
    public static final int ID=9;
    public static final int T44=44;
    public static final int NOCOPY=32;
    public static final int SUBTYPE=25;
    public static final int WS=42;
    public static final int IS=11;
    public static final int T_PARAMS=5;
    public static final int T_PARAM=4;
    public static final int T43=43;
    public static final int T_IGNORE=7;
    public static final int IN=30;
    public static final int FORWARD_SLASH=38;
    public static final int SEMI=14;
    public static final int EQUALS=36;
    public static final int RETURN=21;
    public static final int EOF=-1;
    public static final int NULL=19;
    public static final int Tokens=47;
    public static final int DEFAULT=16;
    public static final int CURSOR=26;
    public static final int STAR=41;
    public static final int QUOTED_ID=33;
    public static final int EXCEPTION=27;
    public PlsqlLexer() {;} 
    public PlsqlLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "src/com/butterfill/opb/plsql/translation/Plsql.g"; }

    // $ANTLR start T43
    public final void mT43() throws RecognitionException {
        try {
            int _type = T43;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:6:5: ( '.' )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:6:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T43

    // $ANTLR start T44
    public final void mT44() throws RecognitionException {
        try {
            int _type = T44;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:7:5: ( ':=' )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:7:7: ':='
            {
            match(":="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T44

    // $ANTLR start T45
    public final void mT45() throws RecognitionException {
        try {
            int _type = T45;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:8:5: ( '(' )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:8:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T45

    // $ANTLR start T46
    public final void mT46() throws RecognitionException {
        try {
            int _type = T46;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:9:5: ( ')' )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:9:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T46

    // $ANTLR start CURSOR
    public final void mCURSOR() throws RecognitionException {
        try {
            int _type = CURSOR;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:195:3: ( ( 'c' | 'C' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 's' | 'S' ) ( 'o' | 'O' ) ( 'r' | 'R' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:195:6: ( 'c' | 'C' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 's' | 'S' ) ( 'o' | 'O' ) ( 'r' | 'R' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CURSOR

    // $ANTLR start AS
    public final void mAS() throws RecognitionException {
        try {
            int _type = AS;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:199:3: ( ( 'a' | 'A' ) ( 's' | 'S' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:199:6: ( 'a' | 'A' ) ( 's' | 'S' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AS

    // $ANTLR start IS
    public final void mIS() throws RecognitionException {
        try {
            int _type = IS;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:203:3: ( ( 'i' | 'I' ) ( 's' | 'S' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:203:6: ( 'i' | 'I' ) ( 's' | 'S' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IS

    // $ANTLR start RETURN
    public final void mRETURN() throws RecognitionException {
        try {
            int _type = RETURN;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:207:3: ( ( 'r' | 'R' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 'n' | 'N' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:207:6: ( 'r' | 'R' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RETURN

    // $ANTLR start PACKAGE
    public final void mPACKAGE() throws RecognitionException {
        try {
            int _type = PACKAGE;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:211:3: ( ( 'p' | 'P' ) ( 'a' | 'A' ) ( 'c' | 'C' ) ( 'k' | 'K' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'e' | 'E' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:211:6: ( 'p' | 'P' ) ( 'a' | 'A' ) ( 'c' | 'C' ) ( 'k' | 'K' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PACKAGE

    // $ANTLR start END
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:215:3: ( ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:215:6: ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end END

    // $ANTLR start AUTHID
    public final void mAUTHID() throws RecognitionException {
        try {
            int _type = AUTHID;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:219:3: ( ( 'a' | 'A' ) ( 'u' | 'U' ) ( 't' | 'T' ) ( 'h' | 'H' ) ( 'i' | 'I' ) ( 'd' | 'D' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:219:6: ( 'a' | 'A' ) ( 'u' | 'U' ) ( 't' | 'T' ) ( 'h' | 'H' ) ( 'i' | 'I' ) ( 'd' | 'D' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AUTHID

    // $ANTLR start FUNCTION
    public final void mFUNCTION() throws RecognitionException {
        try {
            int _type = FUNCTION;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:223:3: ( ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 'c' | 'C' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:223:6: ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 'c' | 'C' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FUNCTION

    // $ANTLR start PROCEDURE
    public final void mPROCEDURE() throws RecognitionException {
        try {
            int _type = PROCEDURE;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:227:3: ( ( 'p' | 'P' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'e' | 'E' ) ( 'd' | 'D' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 'e' | 'E' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:227:6: ( 'p' | 'P' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'e' | 'E' ) ( 'd' | 'D' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PROCEDURE

    // $ANTLR start IN
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:231:3: ( ( 'i' | 'I' ) ( 'n' | 'N' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:231:6: ( 'i' | 'I' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IN

    // $ANTLR start OUT
    public final void mOUT() throws RecognitionException {
        try {
            int _type = OUT;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:235:3: ( ( 'o' | 'O' ) ( 'u' | 'U' ) ( 't' | 'T' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:235:6: ( 'o' | 'O' ) ( 'u' | 'U' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OUT

    // $ANTLR start NOCOPY
    public final void mNOCOPY() throws RecognitionException {
        try {
            int _type = NOCOPY;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:239:3: ( ( 'n' | 'N' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'p' | 'P' ) ( 'y' | 'Y' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:239:6: ( 'n' | 'N' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'p' | 'P' ) ( 'y' | 'Y' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NOCOPY

    // $ANTLR start DEFAULT
    public final void mDEFAULT() throws RecognitionException {
        try {
            int _type = DEFAULT;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:243:3: ( ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 't' | 'T' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:243:6: ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DEFAULT

    // $ANTLR start EXCEPTION
    public final void mEXCEPTION() throws RecognitionException {
        try {
            int _type = EXCEPTION;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:247:3: ( ( 'e' | 'E' ) ( 'x' | 'X' ) ( 'c' | 'C' ) ( 'e' | 'E' ) ( 'p' | 'P' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:247:6: ( 'e' | 'E' ) ( 'x' | 'X' ) ( 'c' | 'C' ) ( 'e' | 'E' ) ( 'p' | 'P' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EXCEPTION

    // $ANTLR start CONSTANT
    public final void mCONSTANT() throws RecognitionException {
        try {
            int _type = CONSTANT;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:251:3: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 't' | 'T' ) ( 'a' | 'A' ) ( 'n' | 'N' ) ( 't' | 'T' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:251:6: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 't' | 'T' ) ( 'a' | 'A' ) ( 'n' | 'N' ) ( 't' | 'T' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CONSTANT

    // $ANTLR start PRAGMA
    public final void mPRAGMA() throws RecognitionException {
        try {
            int _type = PRAGMA;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:255:3: ( ( 'p' | 'P' ) ( 'r' | 'R' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'm' | 'M' ) ( 'a' | 'A' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:255:6: ( 'p' | 'P' ) ( 'r' | 'R' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'm' | 'M' ) ( 'a' | 'A' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PRAGMA

    // $ANTLR start TYPE
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:259:3: ( ( 't' | 'T' ) ( 'y' | 'Y' ) ( 'p' | 'P' ) ( 'e' | 'E' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:259:6: ( 't' | 'T' ) ( 'y' | 'Y' ) ( 'p' | 'P' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TYPE

    // $ANTLR start SUBTYPE
    public final void mSUBTYPE() throws RecognitionException {
        try {
            int _type = SUBTYPE;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:263:3: ( ( 's' | 'S' ) ( 'u' | 'U' ) ( 'b' | 'B' ) ( 't' | 'T' ) ( 'y' | 'Y' ) ( 'p' | 'P' ) ( 'e' | 'E' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:263:6: ( 's' | 'S' ) ( 'u' | 'U' ) ( 'b' | 'B' ) ( 't' | 'T' ) ( 'y' | 'Y' ) ( 'p' | 'P' ) ( 'e' | 'E' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SUBTYPE

    // $ANTLR start NULL
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:267:3: ( ( 'n' | 'N' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'l' | 'L' ) )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:267:6: ( 'n' | 'N' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'l' | 'L' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NULL

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:275:3: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' | '#' | '0' .. '9' | '%' | '[' | ']' | '?' )* )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:275:6: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' | '#' | '0' .. '9' | '%' | '[' | ']' | '?' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // src/com/butterfill/opb/plsql/translation/Plsql.g:275:28: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' | '#' | '0' .. '9' | '%' | '[' | ']' | '?' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='#' && LA1_0<='%')||(LA1_0>='0' && LA1_0<='9')||LA1_0=='?'||(LA1_0>='A' && LA1_0<='[')||LA1_0==']'||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/com/butterfill/opb/plsql/translation/Plsql.g:
            	    {
            	    if ( (input.LA(1)>='#' && input.LA(1)<='%')||(input.LA(1)>='0' && input.LA(1)<='9')||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='[')||input.LA(1)==']'||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ID

    // $ANTLR start QUOTED_ID
    public final void mQUOTED_ID() throws RecognitionException {
        try {
            int _type = QUOTED_ID;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:279:3: ( '\"' ( options {greedy=false; } : . )+ '\"' )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:279:6: '\"' ( options {greedy=false; } : . )+ '\"'
            {
            match('\"'); 
            // src/com/butterfill/opb/plsql/translation/Plsql.g:279:10: ( options {greedy=false; } : . )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\"') ) {
                    alt2=2;
                }
                else if ( ((LA2_0>='\u0000' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='\uFFFE')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // src/com/butterfill/opb/plsql/translation/Plsql.g:279:38: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            match('\"'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QUOTED_ID

    // $ANTLR start NUMBER
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:283:3: ( ( '-' )? ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:283:6: ( '-' )? ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
            {
            // src/com/butterfill/opb/plsql/translation/Plsql.g:283:6: ( '-' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // src/com/butterfill/opb/plsql/translation/Plsql.g:283:6: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // src/com/butterfill/opb/plsql/translation/Plsql.g:283:11: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/com/butterfill/opb/plsql/translation/Plsql.g:283:11: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            // src/com/butterfill/opb/plsql/translation/Plsql.g:283:21: ( '.' ( '0' .. '9' )+ )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='.') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // src/com/butterfill/opb/plsql/translation/Plsql.g:283:22: '.' ( '0' .. '9' )+
                    {
                    match('.'); 
                    // src/com/butterfill/opb/plsql/translation/Plsql.g:283:26: ( '0' .. '9' )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // src/com/butterfill/opb/plsql/translation/Plsql.g:283:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NUMBER

    // $ANTLR start QUOTED_LITERAL
    public final void mQUOTED_LITERAL() throws RecognitionException {
        try {
            int _type = QUOTED_LITERAL;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:287:3: ( '\\'' ( options {greedy=false; } : . )* '\\'' )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:287:6: '\\'' ( options {greedy=false; } : . )* '\\''
            {
            match('\''); 
            // src/com/butterfill/opb/plsql/translation/Plsql.g:287:11: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\'') ) {
                    alt7=2;
                }
                else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='\uFFFE')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // src/com/butterfill/opb/plsql/translation/Plsql.g:287:39: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match('\''); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QUOTED_LITERAL

    // $ANTLR start NEWLINE
    public final void mNEWLINE() throws RecognitionException {
        try {
            // src/com/butterfill/opb/plsql/translation/Plsql.g:292:3: ( ( '\\r' )? '\\n' )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:292:6: ( '\\r' )? '\\n'
            {
            // src/com/butterfill/opb/plsql/translation/Plsql.g:292:6: ( '\\r' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\r') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // src/com/butterfill/opb/plsql/translation/Plsql.g:292:6: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end NEWLINE

    // $ANTLR start SL_COMMENT
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:296:3: ( '--' ( . )* NEWLINE )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:296:7: '--' ( . )* NEWLINE
            {
            match("--"); 

            // src/com/butterfill/opb/plsql/translation/Plsql.g:296:12: ( . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\r') ) {
                    alt9=2;
                }
                else if ( (LA9_0=='\n') ) {
                    alt9=2;
                }
                else if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFE')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // src/com/butterfill/opb/plsql/translation/Plsql.g:296:12: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            mNEWLINE(); 
             channel=HIDDEN; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SL_COMMENT

    // $ANTLR start ML_COMMENT
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:300:3: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:300:6: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // src/com/butterfill/opb/plsql/translation/Plsql.g:300:11: ( options {greedy=false; } : . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='*') ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1=='/') ) {
                        alt10=2;
                    }
                    else if ( ((LA10_1>='\u0000' && LA10_1<='.')||(LA10_1>='0' && LA10_1<='\uFFFE')) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>='\u0000' && LA10_0<=')')||(LA10_0>='+' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // src/com/butterfill/opb/plsql/translation/Plsql.g:300:39: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match("*/"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ML_COMMENT

    // $ANTLR start COMMA
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:304:3: ( ',' )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:304:6: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMA

    // $ANTLR start EQUALS
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:308:3: ( '=' )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:308:6: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EQUALS

    // $ANTLR start SEMI
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:312:3: ( ';' )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:312:6: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SEMI

    // $ANTLR start QUESTION_MARK
    public final void mQUESTION_MARK() throws RecognitionException {
        try {
            int _type = QUESTION_MARK;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:316:3: ( '?' )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:316:6: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QUESTION_MARK

    // $ANTLR start FORWARD_SLASH
    public final void mFORWARD_SLASH() throws RecognitionException {
        try {
            int _type = FORWARD_SLASH;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:320:3: ( '/' )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:320:6: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FORWARD_SLASH

    // $ANTLR start PERCENT
    public final void mPERCENT() throws RecognitionException {
        try {
            int _type = PERCENT;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:324:3: ( '%' )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:324:6: '%'
            {
            match('%'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PERCENT

    // $ANTLR start PIPE
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:328:3: ( '|' )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:328:6: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PIPE

    // $ANTLR start STAR
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:332:3: ( '*' )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:332:6: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STAR

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // src/com/butterfill/opb/plsql/translation/Plsql.g:336:3: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // src/com/butterfill/opb/plsql/translation/Plsql.g:336:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // src/com/butterfill/opb/plsql/translation/Plsql.g:336:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // src/com/butterfill/opb/plsql/translation/Plsql.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

             channel=HIDDEN; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    public void mTokens() throws RecognitionException {
        // src/com/butterfill/opb/plsql/translation/Plsql.g:1:8: ( T43 | T44 | T45 | T46 | CURSOR | AS | IS | RETURN | PACKAGE | END | AUTHID | FUNCTION | PROCEDURE | IN | OUT | NOCOPY | DEFAULT | EXCEPTION | CONSTANT | PRAGMA | TYPE | SUBTYPE | NULL | ID | QUOTED_ID | NUMBER | QUOTED_LITERAL | SL_COMMENT | ML_COMMENT | COMMA | EQUALS | SEMI | QUESTION_MARK | FORWARD_SLASH | PERCENT | PIPE | STAR | WS )
        int alt12=38;
        switch ( input.LA(1) ) {
        case '.':
            {
            alt12=1;
            }
            break;
        case ':':
            {
            alt12=2;
            }
            break;
        case '(':
            {
            alt12=3;
            }
            break;
        case ')':
            {
            alt12=4;
            }
            break;
        case 'C':
        case 'c':
            {
            switch ( input.LA(2) ) {
            case 'U':
            case 'u':
                {
                int LA12_31 = input.LA(3);

                if ( (LA12_31=='R'||LA12_31=='r') ) {
                    int LA12_52 = input.LA(4);

                    if ( (LA12_52=='S'||LA12_52=='s') ) {
                        int LA12_71 = input.LA(5);

                        if ( (LA12_71=='O'||LA12_71=='o') ) {
                            int LA12_87 = input.LA(6);

                            if ( (LA12_87=='R'||LA12_87=='r') ) {
                                int LA12_101 = input.LA(7);

                                if ( ((LA12_101>='#' && LA12_101<='%')||(LA12_101>='0' && LA12_101<='9')||LA12_101=='?'||(LA12_101>='A' && LA12_101<='[')||LA12_101==']'||LA12_101=='_'||(LA12_101>='a' && LA12_101<='z')) ) {
                                    alt12=24;
                                }
                                else {
                                    alt12=5;}
                            }
                            else {
                                alt12=24;}
                        }
                        else {
                            alt12=24;}
                    }
                    else {
                        alt12=24;}
                }
                else {
                    alt12=24;}
                }
                break;
            case 'O':
            case 'o':
                {
                int LA12_32 = input.LA(3);

                if ( (LA12_32=='N'||LA12_32=='n') ) {
                    int LA12_53 = input.LA(4);

                    if ( (LA12_53=='S'||LA12_53=='s') ) {
                        int LA12_72 = input.LA(5);

                        if ( (LA12_72=='T'||LA12_72=='t') ) {
                            int LA12_88 = input.LA(6);

                            if ( (LA12_88=='A'||LA12_88=='a') ) {
                                int LA12_102 = input.LA(7);

                                if ( (LA12_102=='N'||LA12_102=='n') ) {
                                    int LA12_114 = input.LA(8);

                                    if ( (LA12_114=='T'||LA12_114=='t') ) {
                                        int LA12_125 = input.LA(9);

                                        if ( ((LA12_125>='#' && LA12_125<='%')||(LA12_125>='0' && LA12_125<='9')||LA12_125=='?'||(LA12_125>='A' && LA12_125<='[')||LA12_125==']'||LA12_125=='_'||(LA12_125>='a' && LA12_125<='z')) ) {
                                            alt12=24;
                                        }
                                        else {
                                            alt12=19;}
                                    }
                                    else {
                                        alt12=24;}
                                }
                                else {
                                    alt12=24;}
                            }
                            else {
                                alt12=24;}
                        }
                        else {
                            alt12=24;}
                    }
                    else {
                        alt12=24;}
                }
                else {
                    alt12=24;}
                }
                break;
            default:
                alt12=24;}

            }
            break;
        case 'A':
        case 'a':
            {
            switch ( input.LA(2) ) {
            case 'U':
            case 'u':
                {
                int LA12_33 = input.LA(3);

                if ( (LA12_33=='T'||LA12_33=='t') ) {
                    int LA12_54 = input.LA(4);

                    if ( (LA12_54=='H'||LA12_54=='h') ) {
                        int LA12_73 = input.LA(5);

                        if ( (LA12_73=='I'||LA12_73=='i') ) {
                            int LA12_89 = input.LA(6);

                            if ( (LA12_89=='D'||LA12_89=='d') ) {
                                int LA12_103 = input.LA(7);

                                if ( ((LA12_103>='#' && LA12_103<='%')||(LA12_103>='0' && LA12_103<='9')||LA12_103=='?'||(LA12_103>='A' && LA12_103<='[')||LA12_103==']'||LA12_103=='_'||(LA12_103>='a' && LA12_103<='z')) ) {
                                    alt12=24;
                                }
                                else {
                                    alt12=11;}
                            }
                            else {
                                alt12=24;}
                        }
                        else {
                            alt12=24;}
                    }
                    else {
                        alt12=24;}
                }
                else {
                    alt12=24;}
                }
                break;
            case 'S':
            case 's':
                {
                int LA12_34 = input.LA(3);

                if ( ((LA12_34>='#' && LA12_34<='%')||(LA12_34>='0' && LA12_34<='9')||LA12_34=='?'||(LA12_34>='A' && LA12_34<='[')||LA12_34==']'||LA12_34=='_'||(LA12_34>='a' && LA12_34<='z')) ) {
                    alt12=24;
                }
                else {
                    alt12=6;}
                }
                break;
            default:
                alt12=24;}

            }
            break;
        case 'I':
        case 'i':
            {
            switch ( input.LA(2) ) {
            case 'N':
            case 'n':
                {
                int LA12_35 = input.LA(3);

                if ( ((LA12_35>='#' && LA12_35<='%')||(LA12_35>='0' && LA12_35<='9')||LA12_35=='?'||(LA12_35>='A' && LA12_35<='[')||LA12_35==']'||LA12_35=='_'||(LA12_35>='a' && LA12_35<='z')) ) {
                    alt12=24;
                }
                else {
                    alt12=14;}
                }
                break;
            case 'S':
            case 's':
                {
                int LA12_36 = input.LA(3);

                if ( ((LA12_36>='#' && LA12_36<='%')||(LA12_36>='0' && LA12_36<='9')||LA12_36=='?'||(LA12_36>='A' && LA12_36<='[')||LA12_36==']'||LA12_36=='_'||(LA12_36>='a' && LA12_36<='z')) ) {
                    alt12=24;
                }
                else {
                    alt12=7;}
                }
                break;
            default:
                alt12=24;}

            }
            break;
        case 'R':
        case 'r':
            {
            int LA12_8 = input.LA(2);

            if ( (LA12_8=='E'||LA12_8=='e') ) {
                int LA12_37 = input.LA(3);

                if ( (LA12_37=='T'||LA12_37=='t') ) {
                    int LA12_58 = input.LA(4);

                    if ( (LA12_58=='U'||LA12_58=='u') ) {
                        int LA12_74 = input.LA(5);

                        if ( (LA12_74=='R'||LA12_74=='r') ) {
                            int LA12_90 = input.LA(6);

                            if ( (LA12_90=='N'||LA12_90=='n') ) {
                                int LA12_104 = input.LA(7);

                                if ( ((LA12_104>='#' && LA12_104<='%')||(LA12_104>='0' && LA12_104<='9')||LA12_104=='?'||(LA12_104>='A' && LA12_104<='[')||LA12_104==']'||LA12_104=='_'||(LA12_104>='a' && LA12_104<='z')) ) {
                                    alt12=24;
                                }
                                else {
                                    alt12=8;}
                            }
                            else {
                                alt12=24;}
                        }
                        else {
                            alt12=24;}
                    }
                    else {
                        alt12=24;}
                }
                else {
                    alt12=24;}
            }
            else {
                alt12=24;}
            }
            break;
        case 'P':
        case 'p':
            {
            switch ( input.LA(2) ) {
            case 'R':
            case 'r':
                {
                switch ( input.LA(3) ) {
                case 'A':
                case 'a':
                    {
                    int LA12_59 = input.LA(4);

                    if ( (LA12_59=='G'||LA12_59=='g') ) {
                        int LA12_75 = input.LA(5);

                        if ( (LA12_75=='M'||LA12_75=='m') ) {
                            int LA12_91 = input.LA(6);

                            if ( (LA12_91=='A'||LA12_91=='a') ) {
                                int LA12_105 = input.LA(7);

                                if ( ((LA12_105>='#' && LA12_105<='%')||(LA12_105>='0' && LA12_105<='9')||LA12_105=='?'||(LA12_105>='A' && LA12_105<='[')||LA12_105==']'||LA12_105=='_'||(LA12_105>='a' && LA12_105<='z')) ) {
                                    alt12=24;
                                }
                                else {
                                    alt12=20;}
                            }
                            else {
                                alt12=24;}
                        }
                        else {
                            alt12=24;}
                    }
                    else {
                        alt12=24;}
                    }
                    break;
                case 'O':
                case 'o':
                    {
                    int LA12_60 = input.LA(4);

                    if ( (LA12_60=='C'||LA12_60=='c') ) {
                        int LA12_76 = input.LA(5);

                        if ( (LA12_76=='E'||LA12_76=='e') ) {
                            int LA12_92 = input.LA(6);

                            if ( (LA12_92=='D'||LA12_92=='d') ) {
                                int LA12_106 = input.LA(7);

                                if ( (LA12_106=='U'||LA12_106=='u') ) {
                                    int LA12_118 = input.LA(8);

                                    if ( (LA12_118=='R'||LA12_118=='r') ) {
                                        int LA12_126 = input.LA(9);

                                        if ( (LA12_126=='E'||LA12_126=='e') ) {
                                            int LA12_133 = input.LA(10);

                                            if ( ((LA12_133>='#' && LA12_133<='%')||(LA12_133>='0' && LA12_133<='9')||LA12_133=='?'||(LA12_133>='A' && LA12_133<='[')||LA12_133==']'||LA12_133=='_'||(LA12_133>='a' && LA12_133<='z')) ) {
                                                alt12=24;
                                            }
                                            else {
                                                alt12=13;}
                                        }
                                        else {
                                            alt12=24;}
                                    }
                                    else {
                                        alt12=24;}
                                }
                                else {
                                    alt12=24;}
                            }
                            else {
                                alt12=24;}
                        }
                        else {
                            alt12=24;}
                    }
                    else {
                        alt12=24;}
                    }
                    break;
                default:
                    alt12=24;}

                }
                break;
            case 'A':
            case 'a':
                {
                int LA12_39 = input.LA(3);

                if ( (LA12_39=='C'||LA12_39=='c') ) {
                    int LA12_61 = input.LA(4);

                    if ( (LA12_61=='K'||LA12_61=='k') ) {
                        int LA12_77 = input.LA(5);

                        if ( (LA12_77=='A'||LA12_77=='a') ) {
                            int LA12_93 = input.LA(6);

                            if ( (LA12_93=='G'||LA12_93=='g') ) {
                                int LA12_107 = input.LA(7);

                                if ( (LA12_107=='E'||LA12_107=='e') ) {
                                    int LA12_119 = input.LA(8);

                                    if ( ((LA12_119>='#' && LA12_119<='%')||(LA12_119>='0' && LA12_119<='9')||LA12_119=='?'||(LA12_119>='A' && LA12_119<='[')||LA12_119==']'||LA12_119=='_'||(LA12_119>='a' && LA12_119<='z')) ) {
                                        alt12=24;
                                    }
                                    else {
                                        alt12=9;}
                                }
                                else {
                                    alt12=24;}
                            }
                            else {
                                alt12=24;}
                        }
                        else {
                            alt12=24;}
                    }
                    else {
                        alt12=24;}
                }
                else {
                    alt12=24;}
                }
                break;
            default:
                alt12=24;}

            }
            break;
        case 'E':
        case 'e':
            {
            switch ( input.LA(2) ) {
            case 'N':
            case 'n':
                {
                int LA12_40 = input.LA(3);

                if ( (LA12_40=='D'||LA12_40=='d') ) {
                    int LA12_62 = input.LA(4);

                    if ( ((LA12_62>='#' && LA12_62<='%')||(LA12_62>='0' && LA12_62<='9')||LA12_62=='?'||(LA12_62>='A' && LA12_62<='[')||LA12_62==']'||LA12_62=='_'||(LA12_62>='a' && LA12_62<='z')) ) {
                        alt12=24;
                    }
                    else {
                        alt12=10;}
                }
                else {
                    alt12=24;}
                }
                break;
            case 'X':
            case 'x':
                {
                int LA12_41 = input.LA(3);

                if ( (LA12_41=='C'||LA12_41=='c') ) {
                    int LA12_63 = input.LA(4);

                    if ( (LA12_63=='E'||LA12_63=='e') ) {
                        int LA12_79 = input.LA(5);

                        if ( (LA12_79=='P'||LA12_79=='p') ) {
                            int LA12_94 = input.LA(6);

                            if ( (LA12_94=='T'||LA12_94=='t') ) {
                                int LA12_108 = input.LA(7);

                                if ( (LA12_108=='I'||LA12_108=='i') ) {
                                    int LA12_120 = input.LA(8);

                                    if ( (LA12_120=='O'||LA12_120=='o') ) {
                                        int LA12_128 = input.LA(9);

                                        if ( (LA12_128=='N'||LA12_128=='n') ) {
                                            int LA12_134 = input.LA(10);

                                            if ( ((LA12_134>='#' && LA12_134<='%')||(LA12_134>='0' && LA12_134<='9')||LA12_134=='?'||(LA12_134>='A' && LA12_134<='[')||LA12_134==']'||LA12_134=='_'||(LA12_134>='a' && LA12_134<='z')) ) {
                                                alt12=24;
                                            }
                                            else {
                                                alt12=18;}
                                        }
                                        else {
                                            alt12=24;}
                                    }
                                    else {
                                        alt12=24;}
                                }
                                else {
                                    alt12=24;}
                            }
                            else {
                                alt12=24;}
                        }
                        else {
                            alt12=24;}
                    }
                    else {
                        alt12=24;}
                }
                else {
                    alt12=24;}
                }
                break;
            default:
                alt12=24;}

            }
            break;
        case 'F':
        case 'f':
            {
            int LA12_11 = input.LA(2);

            if ( (LA12_11=='U'||LA12_11=='u') ) {
                int LA12_42 = input.LA(3);

                if ( (LA12_42=='N'||LA12_42=='n') ) {
                    int LA12_64 = input.LA(4);

                    if ( (LA12_64=='C'||LA12_64=='c') ) {
                        int LA12_80 = input.LA(5);

                        if ( (LA12_80=='T'||LA12_80=='t') ) {
                            int LA12_95 = input.LA(6);

                            if ( (LA12_95=='I'||LA12_95=='i') ) {
                                int LA12_109 = input.LA(7);

                                if ( (LA12_109=='O'||LA12_109=='o') ) {
                                    int LA12_121 = input.LA(8);

                                    if ( (LA12_121=='N'||LA12_121=='n') ) {
                                        int LA12_129 = input.LA(9);

                                        if ( ((LA12_129>='#' && LA12_129<='%')||(LA12_129>='0' && LA12_129<='9')||LA12_129=='?'||(LA12_129>='A' && LA12_129<='[')||LA12_129==']'||LA12_129=='_'||(LA12_129>='a' && LA12_129<='z')) ) {
                                            alt12=24;
                                        }
                                        else {
                                            alt12=12;}
                                    }
                                    else {
                                        alt12=24;}
                                }
                                else {
                                    alt12=24;}
                            }
                            else {
                                alt12=24;}
                        }
                        else {
                            alt12=24;}
                    }
                    else {
                        alt12=24;}
                }
                else {
                    alt12=24;}
            }
            else {
                alt12=24;}
            }
            break;
        case 'O':
        case 'o':
            {
            int LA12_12 = input.LA(2);

            if ( (LA12_12=='U'||LA12_12=='u') ) {
                int LA12_43 = input.LA(3);

                if ( (LA12_43=='T'||LA12_43=='t') ) {
                    int LA12_65 = input.LA(4);

                    if ( ((LA12_65>='#' && LA12_65<='%')||(LA12_65>='0' && LA12_65<='9')||LA12_65=='?'||(LA12_65>='A' && LA12_65<='[')||LA12_65==']'||LA12_65=='_'||(LA12_65>='a' && LA12_65<='z')) ) {
                        alt12=24;
                    }
                    else {
                        alt12=15;}
                }
                else {
                    alt12=24;}
            }
            else {
                alt12=24;}
            }
            break;
        case 'N':
        case 'n':
            {
            switch ( input.LA(2) ) {
            case 'O':
            case 'o':
                {
                int LA12_44 = input.LA(3);

                if ( (LA12_44=='C'||LA12_44=='c') ) {
                    int LA12_66 = input.LA(4);

                    if ( (LA12_66=='O'||LA12_66=='o') ) {
                        int LA12_82 = input.LA(5);

                        if ( (LA12_82=='P'||LA12_82=='p') ) {
                            int LA12_96 = input.LA(6);

                            if ( (LA12_96=='Y'||LA12_96=='y') ) {
                                int LA12_110 = input.LA(7);

                                if ( ((LA12_110>='#' && LA12_110<='%')||(LA12_110>='0' && LA12_110<='9')||LA12_110=='?'||(LA12_110>='A' && LA12_110<='[')||LA12_110==']'||LA12_110=='_'||(LA12_110>='a' && LA12_110<='z')) ) {
                                    alt12=24;
                                }
                                else {
                                    alt12=16;}
                            }
                            else {
                                alt12=24;}
                        }
                        else {
                            alt12=24;}
                    }
                    else {
                        alt12=24;}
                }
                else {
                    alt12=24;}
                }
                break;
            case 'U':
            case 'u':
                {
                int LA12_45 = input.LA(3);

                if ( (LA12_45=='L'||LA12_45=='l') ) {
                    int LA12_67 = input.LA(4);

                    if ( (LA12_67=='L'||LA12_67=='l') ) {
                        int LA12_83 = input.LA(5);

                        if ( ((LA12_83>='#' && LA12_83<='%')||(LA12_83>='0' && LA12_83<='9')||LA12_83=='?'||(LA12_83>='A' && LA12_83<='[')||LA12_83==']'||LA12_83=='_'||(LA12_83>='a' && LA12_83<='z')) ) {
                            alt12=24;
                        }
                        else {
                            alt12=23;}
                    }
                    else {
                        alt12=24;}
                }
                else {
                    alt12=24;}
                }
                break;
            default:
                alt12=24;}

            }
            break;
        case 'D':
        case 'd':
            {
            int LA12_14 = input.LA(2);

            if ( (LA12_14=='E'||LA12_14=='e') ) {
                int LA12_46 = input.LA(3);

                if ( (LA12_46=='F'||LA12_46=='f') ) {
                    int LA12_68 = input.LA(4);

                    if ( (LA12_68=='A'||LA12_68=='a') ) {
                        int LA12_84 = input.LA(5);

                        if ( (LA12_84=='U'||LA12_84=='u') ) {
                            int LA12_98 = input.LA(6);

                            if ( (LA12_98=='L'||LA12_98=='l') ) {
                                int LA12_111 = input.LA(7);

                                if ( (LA12_111=='T'||LA12_111=='t') ) {
                                    int LA12_123 = input.LA(8);

                                    if ( ((LA12_123>='#' && LA12_123<='%')||(LA12_123>='0' && LA12_123<='9')||LA12_123=='?'||(LA12_123>='A' && LA12_123<='[')||LA12_123==']'||LA12_123=='_'||(LA12_123>='a' && LA12_123<='z')) ) {
                                        alt12=24;
                                    }
                                    else {
                                        alt12=17;}
                                }
                                else {
                                    alt12=24;}
                            }
                            else {
                                alt12=24;}
                        }
                        else {
                            alt12=24;}
                    }
                    else {
                        alt12=24;}
                }
                else {
                    alt12=24;}
            }
            else {
                alt12=24;}
            }
            break;
        case 'T':
        case 't':
            {
            int LA12_15 = input.LA(2);

            if ( (LA12_15=='Y'||LA12_15=='y') ) {
                int LA12_47 = input.LA(3);

                if ( (LA12_47=='P'||LA12_47=='p') ) {
                    int LA12_69 = input.LA(4);

                    if ( (LA12_69=='E'||LA12_69=='e') ) {
                        int LA12_85 = input.LA(5);

                        if ( ((LA12_85>='#' && LA12_85<='%')||(LA12_85>='0' && LA12_85<='9')||LA12_85=='?'||(LA12_85>='A' && LA12_85<='[')||LA12_85==']'||LA12_85=='_'||(LA12_85>='a' && LA12_85<='z')) ) {
                            alt12=24;
                        }
                        else {
                            alt12=21;}
                    }
                    else {
                        alt12=24;}
                }
                else {
                    alt12=24;}
            }
            else {
                alt12=24;}
            }
            break;
        case 'S':
        case 's':
            {
            int LA12_16 = input.LA(2);

            if ( (LA12_16=='U'||LA12_16=='u') ) {
                int LA12_48 = input.LA(3);

                if ( (LA12_48=='B'||LA12_48=='b') ) {
                    int LA12_70 = input.LA(4);

                    if ( (LA12_70=='T'||LA12_70=='t') ) {
                        int LA12_86 = input.LA(5);

                        if ( (LA12_86=='Y'||LA12_86=='y') ) {
                            int LA12_100 = input.LA(6);

                            if ( (LA12_100=='P'||LA12_100=='p') ) {
                                int LA12_112 = input.LA(7);

                                if ( (LA12_112=='E'||LA12_112=='e') ) {
                                    int LA12_124 = input.LA(8);

                                    if ( ((LA12_124>='#' && LA12_124<='%')||(LA12_124>='0' && LA12_124<='9')||LA12_124=='?'||(LA12_124>='A' && LA12_124<='[')||LA12_124==']'||LA12_124=='_'||(LA12_124>='a' && LA12_124<='z')) ) {
                                        alt12=24;
                                    }
                                    else {
                                        alt12=22;}
                                }
                                else {
                                    alt12=24;}
                            }
                            else {
                                alt12=24;}
                        }
                        else {
                            alt12=24;}
                    }
                    else {
                        alt12=24;}
                }
                else {
                    alt12=24;}
            }
            else {
                alt12=24;}
            }
            break;
        case 'B':
        case 'G':
        case 'H':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'Q':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'b':
        case 'g':
        case 'h':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'q':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt12=24;
            }
            break;
        case '\"':
            {
            alt12=25;
            }
            break;
        case '-':
            {
            int LA12_19 = input.LA(2);

            if ( (LA12_19=='-') ) {
                alt12=28;
            }
            else if ( ((LA12_19>='0' && LA12_19<='9')) ) {
                alt12=26;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T43 | T44 | T45 | T46 | CURSOR | AS | IS | RETURN | PACKAGE | END | AUTHID | FUNCTION | PROCEDURE | IN | OUT | NOCOPY | DEFAULT | EXCEPTION | CONSTANT | PRAGMA | TYPE | SUBTYPE | NULL | ID | QUOTED_ID | NUMBER | QUOTED_LITERAL | SL_COMMENT | ML_COMMENT | COMMA | EQUALS | SEMI | QUESTION_MARK | FORWARD_SLASH | PERCENT | PIPE | STAR | WS );", 12, 19, input);

                throw nvae;
            }
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt12=26;
            }
            break;
        case '\'':
            {
            alt12=27;
            }
            break;
        case '/':
            {
            int LA12_22 = input.LA(2);

            if ( (LA12_22=='*') ) {
                alt12=29;
            }
            else {
                alt12=34;}
            }
            break;
        case ',':
            {
            alt12=30;
            }
            break;
        case '=':
            {
            alt12=31;
            }
            break;
        case ';':
            {
            alt12=32;
            }
            break;
        case '?':
            {
            alt12=33;
            }
            break;
        case '%':
            {
            alt12=35;
            }
            break;
        case '|':
            {
            alt12=36;
            }
            break;
        case '*':
            {
            alt12=37;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt12=38;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T43 | T44 | T45 | T46 | CURSOR | AS | IS | RETURN | PACKAGE | END | AUTHID | FUNCTION | PROCEDURE | IN | OUT | NOCOPY | DEFAULT | EXCEPTION | CONSTANT | PRAGMA | TYPE | SUBTYPE | NULL | ID | QUOTED_ID | NUMBER | QUOTED_LITERAL | SL_COMMENT | ML_COMMENT | COMMA | EQUALS | SEMI | QUESTION_MARK | FORWARD_SLASH | PERCENT | PIPE | STAR | WS );", 12, 0, input);

            throw nvae;
        }

        switch (alt12) {
            case 1 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:10: T43
                {
                mT43(); 

                }
                break;
            case 2 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:14: T44
                {
                mT44(); 

                }
                break;
            case 3 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:18: T45
                {
                mT45(); 

                }
                break;
            case 4 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:22: T46
                {
                mT46(); 

                }
                break;
            case 5 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:26: CURSOR
                {
                mCURSOR(); 

                }
                break;
            case 6 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:33: AS
                {
                mAS(); 

                }
                break;
            case 7 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:36: IS
                {
                mIS(); 

                }
                break;
            case 8 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:39: RETURN
                {
                mRETURN(); 

                }
                break;
            case 9 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:46: PACKAGE
                {
                mPACKAGE(); 

                }
                break;
            case 10 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:54: END
                {
                mEND(); 

                }
                break;
            case 11 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:58: AUTHID
                {
                mAUTHID(); 

                }
                break;
            case 12 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:65: FUNCTION
                {
                mFUNCTION(); 

                }
                break;
            case 13 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:74: PROCEDURE
                {
                mPROCEDURE(); 

                }
                break;
            case 14 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:84: IN
                {
                mIN(); 

                }
                break;
            case 15 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:87: OUT
                {
                mOUT(); 

                }
                break;
            case 16 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:91: NOCOPY
                {
                mNOCOPY(); 

                }
                break;
            case 17 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:98: DEFAULT
                {
                mDEFAULT(); 

                }
                break;
            case 18 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:106: EXCEPTION
                {
                mEXCEPTION(); 

                }
                break;
            case 19 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:116: CONSTANT
                {
                mCONSTANT(); 

                }
                break;
            case 20 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:125: PRAGMA
                {
                mPRAGMA(); 

                }
                break;
            case 21 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:132: TYPE
                {
                mTYPE(); 

                }
                break;
            case 22 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:137: SUBTYPE
                {
                mSUBTYPE(); 

                }
                break;
            case 23 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:145: NULL
                {
                mNULL(); 

                }
                break;
            case 24 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:150: ID
                {
                mID(); 

                }
                break;
            case 25 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:153: QUOTED_ID
                {
                mQUOTED_ID(); 

                }
                break;
            case 26 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:163: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 27 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:170: QUOTED_LITERAL
                {
                mQUOTED_LITERAL(); 

                }
                break;
            case 28 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:185: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;
            case 29 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:196: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 30 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:207: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 31 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:213: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 32 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:220: SEMI
                {
                mSEMI(); 

                }
                break;
            case 33 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:225: QUESTION_MARK
                {
                mQUESTION_MARK(); 

                }
                break;
            case 34 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:239: FORWARD_SLASH
                {
                mFORWARD_SLASH(); 

                }
                break;
            case 35 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:253: PERCENT
                {
                mPERCENT(); 

                }
                break;
            case 36 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:261: PIPE
                {
                mPIPE(); 

                }
                break;
            case 37 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:266: STAR
                {
                mSTAR(); 

                }
                break;
            case 38 :
                // src/com/butterfill/opb/plsql/translation/Plsql.g:1:271: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}
