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

// $ANTLR 3.0.1 src/main/java/com/butterfill/opb/plsql/translation/Plsql.g 2008-10-30 16:34:39

package com.butterfill.opb.plsql.translation;


import org.antlr.runtime.*;

class PlsqlLexer extends Lexer {
    public static final int PACKAGE=8;
    public static final int FUNCTION=20;
    public static final int STAR=41;
    public static final int PRAGMA=23;
    public static final int EQUALS=36;
    public static final int T_IGNORE=7;
    public static final int SUBTYPE=25;
    public static final int ID=9;
    public static final int EOF=-1;
    public static final int QUOTED_ID=33;
    public static final int TYPE=24;
    public static final int ML_COMMENT=28;
    public static final int AS=12;
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
    public static final int T49=49;
    public static final int T48=48;
    public static final int T_PARAM_MODE=6;
    public static final int Tokens=50;
    public static final int SEMI=14;
    public static final int PROCEDURE=22;
    public static final int T47=47;
    public static final int T46=46;
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
    
    public PlsqlLexer() {} 
    
    public PlsqlLexer(CharStream input) {
        super(input);
    }
    
    @Override
    public String getGrammarFileName() {
        return "src/main/java/com/butterfill/opb/plsql/translation/Plsql.g"; 
    }

    // $ANTLR start T46
    public final void mT46() throws RecognitionException {
        try {
            int _type = T46;
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:6:5: ( '.' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:6:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T46

    // $ANTLR start T47
    public final void mT47() throws RecognitionException {
        try {
            int _type = T47;
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:7:5: ( ':=' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:7:7: ':='
            {
            match(":="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T47

    // $ANTLR start T48
    public final void mT48() throws RecognitionException {
        try {
            int _type = T48;
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:8:5: ( '(' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:8:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T48

    // $ANTLR start T49
    public final void mT49() throws RecognitionException {
        try {
            int _type = T49;
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:9:5: ( ')' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:9:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T49

    // $ANTLR start CURSOR
    public final void mCURSOR() throws RecognitionException {
        try {
            int _type = CURSOR;
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:205:3: ( ( 'c' | 'C' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 's' | 'S' ) ( 'o' | 'O' ) ( 'r' | 'R' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:205:6: ( 'c' | 'C' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 's' | 'S' ) ( 'o' | 'O' ) ( 'r' | 'R' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:209:3: ( ( 'a' | 'A' ) ( 's' | 'S' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:209:6: ( 'a' | 'A' ) ( 's' | 'S' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:213:3: ( ( 'i' | 'I' ) ( 's' | 'S' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:213:6: ( 'i' | 'I' ) ( 's' | 'S' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:217:3: ( ( 'r' | 'R' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 'n' | 'N' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:217:6: ( 'r' | 'R' ) ( 'e' | 'E' ) ( 't' | 'T' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 'n' | 'N' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:221:3: ( ( 'p' | 'P' ) ( 'a' | 'A' ) ( 'c' | 'C' ) ( 'k' | 'K' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'e' | 'E' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:221:6: ( 'p' | 'P' ) ( 'a' | 'A' ) ( 'c' | 'C' ) ( 'k' | 'K' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'e' | 'E' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:225:3: ( ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:225:6: ( 'e' | 'E' ) ( 'n' | 'N' ) ( 'd' | 'D' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:229:3: ( ( 'a' | 'A' ) ( 'u' | 'U' ) ( 't' | 'T' ) ( 'h' | 'H' ) ( 'i' | 'I' ) ( 'd' | 'D' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:229:6: ( 'a' | 'A' ) ( 'u' | 'U' ) ( 't' | 'T' ) ( 'h' | 'H' ) ( 'i' | 'I' ) ( 'd' | 'D' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:233:3: ( ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 'c' | 'C' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:233:6: ( 'f' | 'F' ) ( 'u' | 'U' ) ( 'n' | 'N' ) ( 'c' | 'C' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:237:3: ( ( 'p' | 'P' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'e' | 'E' ) ( 'd' | 'D' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 'e' | 'E' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:237:6: ( 'p' | 'P' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'e' | 'E' ) ( 'd' | 'D' ) ( 'u' | 'U' ) ( 'r' | 'R' ) ( 'e' | 'E' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:241:3: ( ( 'i' | 'I' ) ( 'n' | 'N' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:241:6: ( 'i' | 'I' ) ( 'n' | 'N' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:245:3: ( ( 'o' | 'O' ) ( 'u' | 'U' ) ( 't' | 'T' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:245:6: ( 'o' | 'O' ) ( 'u' | 'U' ) ( 't' | 'T' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:249:3: ( ( 'n' | 'N' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'p' | 'P' ) ( 'y' | 'Y' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:249:6: ( 'n' | 'N' ) ( 'o' | 'O' ) ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'p' | 'P' ) ( 'y' | 'Y' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:253:3: ( ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 't' | 'T' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:253:6: ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 'a' | 'A' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 't' | 'T' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:257:3: ( ( 'e' | 'E' ) ( 'x' | 'X' ) ( 'c' | 'C' ) ( 'e' | 'E' ) ( 'p' | 'P' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:257:6: ( 'e' | 'E' ) ( 'x' | 'X' ) ( 'c' | 'C' ) ( 'e' | 'E' ) ( 'p' | 'P' ) ( 't' | 'T' ) ( 'i' | 'I' ) ( 'o' | 'O' ) ( 'n' | 'N' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:261:3: ( ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 't' | 'T' ) ( 'a' | 'A' ) ( 'n' | 'N' ) ( 't' | 'T' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:261:6: ( 'c' | 'C' ) ( 'o' | 'O' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 't' | 'T' ) ( 'a' | 'A' ) ( 'n' | 'N' ) ( 't' | 'T' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:265:3: ( ( 'p' | 'P' ) ( 'r' | 'R' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'm' | 'M' ) ( 'a' | 'A' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:265:6: ( 'p' | 'P' ) ( 'r' | 'R' ) ( 'a' | 'A' ) ( 'g' | 'G' ) ( 'm' | 'M' ) ( 'a' | 'A' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:269:3: ( ( 't' | 'T' ) ( 'y' | 'Y' ) ( 'p' | 'P' ) ( 'e' | 'E' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:269:6: ( 't' | 'T' ) ( 'y' | 'Y' ) ( 'p' | 'P' ) ( 'e' | 'E' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:273:3: ( ( 's' | 'S' ) ( 'u' | 'U' ) ( 'b' | 'B' ) ( 't' | 'T' ) ( 'y' | 'Y' ) ( 'p' | 'P' ) ( 'e' | 'E' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:273:6: ( 's' | 'S' ) ( 'u' | 'U' ) ( 'b' | 'B' ) ( 't' | 'T' ) ( 'y' | 'Y' ) ( 'p' | 'P' ) ( 'e' | 'E' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:277:3: ( ( 'n' | 'N' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'l' | 'L' ) )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:277:6: ( 'n' | 'N' ) ( 'u' | 'U' ) ( 'l' | 'L' ) ( 'l' | 'L' )
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:285:3: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' | '#' | '0' .. '9' | '%' | '[' | ']' | '?' )* )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:285:6: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' | '#' | '0' .. '9' | '%' | '[' | ']' | '?' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:285:28: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' | '#' | '0' .. '9' | '%' | '[' | ']' | '?' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='#' && LA1_0<='%')||(LA1_0>='0' && LA1_0<='9')||LA1_0=='?'||(LA1_0>='A' && LA1_0<='[')||LA1_0==']'||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:289:3: ( '\"' ( options {greedy=false; } : . )+ '\"' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:289:6: '\"' ( options {greedy=false; } : . )+ '\"'
            {
            match('\"'); 
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:289:10: ( options {greedy=false; } : . )+
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
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:289:38: .
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
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:293:11: '0' .. '9'
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
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:293:26: '0' .. '9'
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:297:3: ( '\\'' ( options {greedy=false; } : . )* '\\'' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:297:6: '\\'' ( options {greedy=false; } : . )* '\\''
            {
            match('\''); 
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:297:11: ( options {greedy=false; } : . )*
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
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:297:39: .
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:302:3: ( ( '\\r' )? '\\n' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:302:6: ( '\\r' )? '\\n'
            {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:302:6: ( '\\r' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\r') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:302:6: '\\r'
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:306:3: ( '--' ( . )* NEWLINE )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:306:7: '--' ( . )* NEWLINE
            {
            match("--"); 

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:306:12: ( . )*
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
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:306:12: .
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:310:3: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:310:6: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:310:11: ( options {greedy=false; } : . )*
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
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:310:39: .
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:314:3: ( ',' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:314:6: ','
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:318:3: ( '=' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:318:6: '='
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:322:3: ( ';' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:322:6: ';'
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:326:3: ( '?' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:326:6: '?'
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:330:3: ( '/' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:330:6: '/'
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:334:3: ( '%' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:334:6: '%'
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:338:3: ( '|' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:338:6: '|'
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
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:342:3: ( '*' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:342:6: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STAR

    // $ANTLR start EXCLAMATION
    public final void mEXCLAMATION() throws RecognitionException {
        try {
            int _type = EXCLAMATION;
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:346:3: ( '!' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:346:6: '!'
            {
            match('!'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EXCLAMATION

    // $ANTLR start GREATERTHAN
    public final void mGREATERTHAN() throws RecognitionException {
        try {
            int _type = GREATERTHAN;
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:350:3: ( '>' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:350:6: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GREATERTHAN

    // $ANTLR start LESSTHAN
    public final void mLESSTHAN() throws RecognitionException {
        try {
            int _type = LESSTHAN;
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:354:3: ( '<' )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:354:6: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LESSTHAN

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:358:3: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:358:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:358:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
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
            	    // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:
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
        // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:8: ( T46 | T47 | T48 | T49 | CURSOR | AS | IS | RETURN | PACKAGE | END | AUTHID | FUNCTION | PROCEDURE | IN | OUT | NOCOPY | DEFAULT | EXCEPTION | CONSTANT | PRAGMA | TYPE | SUBTYPE | NULL | ID | QUOTED_ID | NUMBER | QUOTED_LITERAL | SL_COMMENT | ML_COMMENT | COMMA | EQUALS | SEMI | QUESTION_MARK | FORWARD_SLASH | PERCENT | PIPE | STAR | EXCLAMATION | GREATERTHAN | LESSTHAN | WS )
        int alt12=41;
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
                int LA12_34 = input.LA(3);

                if ( (LA12_34=='R'||LA12_34=='r') ) {
                    int LA12_55 = input.LA(4);

                    if ( (LA12_55=='S'||LA12_55=='s') ) {
                        int LA12_74 = input.LA(5);

                        if ( (LA12_74=='O'||LA12_74=='o') ) {
                            int LA12_90 = input.LA(6);

                            if ( (LA12_90=='R'||LA12_90=='r') ) {
                                int LA12_104 = input.LA(7);

                                if ( ((LA12_104>='#' && LA12_104<='%')||(LA12_104>='0' && LA12_104<='9')||LA12_104=='?'||(LA12_104>='A' && LA12_104<='[')||LA12_104==']'||LA12_104=='_'||(LA12_104>='a' && LA12_104<='z')) ) {
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
                int LA12_35 = input.LA(3);

                if ( (LA12_35=='N'||LA12_35=='n') ) {
                    int LA12_56 = input.LA(4);

                    if ( (LA12_56=='S'||LA12_56=='s') ) {
                        int LA12_75 = input.LA(5);

                        if ( (LA12_75=='T'||LA12_75=='t') ) {
                            int LA12_91 = input.LA(6);

                            if ( (LA12_91=='A'||LA12_91=='a') ) {
                                int LA12_105 = input.LA(7);

                                if ( (LA12_105=='N'||LA12_105=='n') ) {
                                    int LA12_117 = input.LA(8);

                                    if ( (LA12_117=='T'||LA12_117=='t') ) {
                                        int LA12_128 = input.LA(9);

                                        if ( ((LA12_128>='#' && LA12_128<='%')||(LA12_128>='0' && LA12_128<='9')||LA12_128=='?'||(LA12_128>='A' && LA12_128<='[')||LA12_128==']'||LA12_128=='_'||(LA12_128>='a' && LA12_128<='z')) ) {
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
                int LA12_36 = input.LA(3);

                if ( (LA12_36=='T'||LA12_36=='t') ) {
                    int LA12_57 = input.LA(4);

                    if ( (LA12_57=='H'||LA12_57=='h') ) {
                        int LA12_76 = input.LA(5);

                        if ( (LA12_76=='I'||LA12_76=='i') ) {
                            int LA12_92 = input.LA(6);

                            if ( (LA12_92=='D'||LA12_92=='d') ) {
                                int LA12_106 = input.LA(7);

                                if ( ((LA12_106>='#' && LA12_106<='%')||(LA12_106>='0' && LA12_106<='9')||LA12_106=='?'||(LA12_106>='A' && LA12_106<='[')||LA12_106==']'||LA12_106=='_'||(LA12_106>='a' && LA12_106<='z')) ) {
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
                int LA12_37 = input.LA(3);

                if ( ((LA12_37>='#' && LA12_37<='%')||(LA12_37>='0' && LA12_37<='9')||LA12_37=='?'||(LA12_37>='A' && LA12_37<='[')||LA12_37==']'||LA12_37=='_'||(LA12_37>='a' && LA12_37<='z')) ) {
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
            case 'S':
            case 's':
                {
                int LA12_38 = input.LA(3);

                if ( ((LA12_38>='#' && LA12_38<='%')||(LA12_38>='0' && LA12_38<='9')||LA12_38=='?'||(LA12_38>='A' && LA12_38<='[')||LA12_38==']'||LA12_38=='_'||(LA12_38>='a' && LA12_38<='z')) ) {
                    alt12=24;
                }
                else {
                    alt12=7;}
                }
                break;
            case 'N':
            case 'n':
                {
                int LA12_39 = input.LA(3);

                if ( ((LA12_39>='#' && LA12_39<='%')||(LA12_39>='0' && LA12_39<='9')||LA12_39=='?'||(LA12_39>='A' && LA12_39<='[')||LA12_39==']'||LA12_39=='_'||(LA12_39>='a' && LA12_39<='z')) ) {
                    alt12=24;
                }
                else {
                    alt12=14;}
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
                int LA12_40 = input.LA(3);

                if ( (LA12_40=='T'||LA12_40=='t') ) {
                    int LA12_61 = input.LA(4);

                    if ( (LA12_61=='U'||LA12_61=='u') ) {
                        int LA12_77 = input.LA(5);

                        if ( (LA12_77=='R'||LA12_77=='r') ) {
                            int LA12_93 = input.LA(6);

                            if ( (LA12_93=='N'||LA12_93=='n') ) {
                                int LA12_107 = input.LA(7);

                                if ( ((LA12_107>='#' && LA12_107<='%')||(LA12_107>='0' && LA12_107<='9')||LA12_107=='?'||(LA12_107>='A' && LA12_107<='[')||LA12_107==']'||LA12_107=='_'||(LA12_107>='a' && LA12_107<='z')) ) {
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
                case 'O':
                case 'o':
                    {
                    int LA12_62 = input.LA(4);

                    if ( (LA12_62=='C'||LA12_62=='c') ) {
                        int LA12_78 = input.LA(5);

                        if ( (LA12_78=='E'||LA12_78=='e') ) {
                            int LA12_94 = input.LA(6);

                            if ( (LA12_94=='D'||LA12_94=='d') ) {
                                int LA12_108 = input.LA(7);

                                if ( (LA12_108=='U'||LA12_108=='u') ) {
                                    int LA12_120 = input.LA(8);

                                    if ( (LA12_120=='R'||LA12_120=='r') ) {
                                        int LA12_129 = input.LA(9);

                                        if ( (LA12_129=='E'||LA12_129=='e') ) {
                                            int LA12_136 = input.LA(10);

                                            if ( ((LA12_136>='#' && LA12_136<='%')||(LA12_136>='0' && LA12_136<='9')||LA12_136=='?'||(LA12_136>='A' && LA12_136<='[')||LA12_136==']'||LA12_136=='_'||(LA12_136>='a' && LA12_136<='z')) ) {
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
                case 'A':
                case 'a':
                    {
                    int LA12_63 = input.LA(4);

                    if ( (LA12_63=='G'||LA12_63=='g') ) {
                        int LA12_79 = input.LA(5);

                        if ( (LA12_79=='M'||LA12_79=='m') ) {
                            int LA12_95 = input.LA(6);

                            if ( (LA12_95=='A'||LA12_95=='a') ) {
                                int LA12_109 = input.LA(7);

                                if ( ((LA12_109>='#' && LA12_109<='%')||(LA12_109>='0' && LA12_109<='9')||LA12_109=='?'||(LA12_109>='A' && LA12_109<='[')||LA12_109==']'||LA12_109=='_'||(LA12_109>='a' && LA12_109<='z')) ) {
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
                default:
                    alt12=24;}

                }
                break;
            case 'A':
            case 'a':
                {
                int LA12_42 = input.LA(3);

                if ( (LA12_42=='C'||LA12_42=='c') ) {
                    int LA12_64 = input.LA(4);

                    if ( (LA12_64=='K'||LA12_64=='k') ) {
                        int LA12_80 = input.LA(5);

                        if ( (LA12_80=='A'||LA12_80=='a') ) {
                            int LA12_96 = input.LA(6);

                            if ( (LA12_96=='G'||LA12_96=='g') ) {
                                int LA12_110 = input.LA(7);

                                if ( (LA12_110=='E'||LA12_110=='e') ) {
                                    int LA12_122 = input.LA(8);

                                    if ( ((LA12_122>='#' && LA12_122<='%')||(LA12_122>='0' && LA12_122<='9')||LA12_122=='?'||(LA12_122>='A' && LA12_122<='[')||LA12_122==']'||LA12_122=='_'||(LA12_122>='a' && LA12_122<='z')) ) {
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
                int LA12_43 = input.LA(3);

                if ( (LA12_43=='D'||LA12_43=='d') ) {
                    int LA12_65 = input.LA(4);

                    if ( ((LA12_65>='#' && LA12_65<='%')||(LA12_65>='0' && LA12_65<='9')||LA12_65=='?'||(LA12_65>='A' && LA12_65<='[')||LA12_65==']'||LA12_65=='_'||(LA12_65>='a' && LA12_65<='z')) ) {
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
                int LA12_44 = input.LA(3);

                if ( (LA12_44=='C'||LA12_44=='c') ) {
                    int LA12_66 = input.LA(4);

                    if ( (LA12_66=='E'||LA12_66=='e') ) {
                        int LA12_82 = input.LA(5);

                        if ( (LA12_82=='P'||LA12_82=='p') ) {
                            int LA12_97 = input.LA(6);

                            if ( (LA12_97=='T'||LA12_97=='t') ) {
                                int LA12_111 = input.LA(7);

                                if ( (LA12_111=='I'||LA12_111=='i') ) {
                                    int LA12_123 = input.LA(8);

                                    if ( (LA12_123=='O'||LA12_123=='o') ) {
                                        int LA12_131 = input.LA(9);

                                        if ( (LA12_131=='N'||LA12_131=='n') ) {
                                            int LA12_137 = input.LA(10);

                                            if ( ((LA12_137>='#' && LA12_137<='%')||(LA12_137>='0' && LA12_137<='9')||LA12_137=='?'||(LA12_137>='A' && LA12_137<='[')||LA12_137==']'||LA12_137=='_'||(LA12_137>='a' && LA12_137<='z')) ) {
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
                int LA12_45 = input.LA(3);

                if ( (LA12_45=='N'||LA12_45=='n') ) {
                    int LA12_67 = input.LA(4);

                    if ( (LA12_67=='C'||LA12_67=='c') ) {
                        int LA12_83 = input.LA(5);

                        if ( (LA12_83=='T'||LA12_83=='t') ) {
                            int LA12_98 = input.LA(6);

                            if ( (LA12_98=='I'||LA12_98=='i') ) {
                                int LA12_112 = input.LA(7);

                                if ( (LA12_112=='O'||LA12_112=='o') ) {
                                    int LA12_124 = input.LA(8);

                                    if ( (LA12_124=='N'||LA12_124=='n') ) {
                                        int LA12_132 = input.LA(9);

                                        if ( ((LA12_132>='#' && LA12_132<='%')||(LA12_132>='0' && LA12_132<='9')||LA12_132=='?'||(LA12_132>='A' && LA12_132<='[')||LA12_132==']'||LA12_132=='_'||(LA12_132>='a' && LA12_132<='z')) ) {
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
                int LA12_46 = input.LA(3);

                if ( (LA12_46=='T'||LA12_46=='t') ) {
                    int LA12_68 = input.LA(4);

                    if ( ((LA12_68>='#' && LA12_68<='%')||(LA12_68>='0' && LA12_68<='9')||LA12_68=='?'||(LA12_68>='A' && LA12_68<='[')||LA12_68==']'||LA12_68=='_'||(LA12_68>='a' && LA12_68<='z')) ) {
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
            case 'U':
            case 'u':
                {
                int LA12_47 = input.LA(3);

                if ( (LA12_47=='L'||LA12_47=='l') ) {
                    int LA12_69 = input.LA(4);

                    if ( (LA12_69=='L'||LA12_69=='l') ) {
                        int LA12_85 = input.LA(5);

                        if ( ((LA12_85>='#' && LA12_85<='%')||(LA12_85>='0' && LA12_85<='9')||LA12_85=='?'||(LA12_85>='A' && LA12_85<='[')||LA12_85==']'||LA12_85=='_'||(LA12_85>='a' && LA12_85<='z')) ) {
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
            case 'O':
            case 'o':
                {
                int LA12_48 = input.LA(3);

                if ( (LA12_48=='C'||LA12_48=='c') ) {
                    int LA12_70 = input.LA(4);

                    if ( (LA12_70=='O'||LA12_70=='o') ) {
                        int LA12_86 = input.LA(5);

                        if ( (LA12_86=='P'||LA12_86=='p') ) {
                            int LA12_100 = input.LA(6);

                            if ( (LA12_100=='Y'||LA12_100=='y') ) {
                                int LA12_113 = input.LA(7);

                                if ( ((LA12_113>='#' && LA12_113<='%')||(LA12_113>='0' && LA12_113<='9')||LA12_113=='?'||(LA12_113>='A' && LA12_113<='[')||LA12_113==']'||LA12_113=='_'||(LA12_113>='a' && LA12_113<='z')) ) {
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
            default:
                alt12=24;}

            }
            break;
        case 'D':
        case 'd':
            {
            int LA12_14 = input.LA(2);

            if ( (LA12_14=='E'||LA12_14=='e') ) {
                int LA12_49 = input.LA(3);

                if ( (LA12_49=='F'||LA12_49=='f') ) {
                    int LA12_71 = input.LA(4);

                    if ( (LA12_71=='A'||LA12_71=='a') ) {
                        int LA12_87 = input.LA(5);

                        if ( (LA12_87=='U'||LA12_87=='u') ) {
                            int LA12_101 = input.LA(6);

                            if ( (LA12_101=='L'||LA12_101=='l') ) {
                                int LA12_114 = input.LA(7);

                                if ( (LA12_114=='T'||LA12_114=='t') ) {
                                    int LA12_126 = input.LA(8);

                                    if ( ((LA12_126>='#' && LA12_126<='%')||(LA12_126>='0' && LA12_126<='9')||LA12_126=='?'||(LA12_126>='A' && LA12_126<='[')||LA12_126==']'||LA12_126=='_'||(LA12_126>='a' && LA12_126<='z')) ) {
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
                int LA12_50 = input.LA(3);

                if ( (LA12_50=='P'||LA12_50=='p') ) {
                    int LA12_72 = input.LA(4);

                    if ( (LA12_72=='E'||LA12_72=='e') ) {
                        int LA12_88 = input.LA(5);

                        if ( ((LA12_88>='#' && LA12_88<='%')||(LA12_88>='0' && LA12_88<='9')||LA12_88=='?'||(LA12_88>='A' && LA12_88<='[')||LA12_88==']'||LA12_88=='_'||(LA12_88>='a' && LA12_88<='z')) ) {
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
                int LA12_51 = input.LA(3);

                if ( (LA12_51=='B'||LA12_51=='b') ) {
                    int LA12_73 = input.LA(4);

                    if ( (LA12_73=='T'||LA12_73=='t') ) {
                        int LA12_89 = input.LA(5);

                        if ( (LA12_89=='Y'||LA12_89=='y') ) {
                            int LA12_103 = input.LA(6);

                            if ( (LA12_103=='P'||LA12_103=='p') ) {
                                int LA12_115 = input.LA(7);

                                if ( (LA12_115=='E'||LA12_115=='e') ) {
                                    int LA12_127 = input.LA(8);

                                    if ( ((LA12_127>='#' && LA12_127<='%')||(LA12_127>='0' && LA12_127<='9')||LA12_127=='?'||(LA12_127>='A' && LA12_127<='[')||LA12_127==']'||LA12_127=='_'||(LA12_127>='a' && LA12_127<='z')) ) {
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
                    new NoViableAltException("1:1: Tokens : ( T46 | T47 | T48 | T49 | CURSOR | AS | IS | RETURN | PACKAGE | END | AUTHID | FUNCTION | PROCEDURE | IN | OUT | NOCOPY | DEFAULT | EXCEPTION | CONSTANT | PRAGMA | TYPE | SUBTYPE | NULL | ID | QUOTED_ID | NUMBER | QUOTED_LITERAL | SL_COMMENT | ML_COMMENT | COMMA | EQUALS | SEMI | QUESTION_MARK | FORWARD_SLASH | PERCENT | PIPE | STAR | EXCLAMATION | GREATERTHAN | LESSTHAN | WS );", 12, 19, input);

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
        case '!':
            {
            alt12=38;
            }
            break;
        case '>':
            {
            alt12=39;
            }
            break;
        case '<':
            {
            alt12=40;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt12=41;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T46 | T47 | T48 | T49 | CURSOR | AS | IS | RETURN | PACKAGE | END | AUTHID | FUNCTION | PROCEDURE | IN | OUT | NOCOPY | DEFAULT | EXCEPTION | CONSTANT | PRAGMA | TYPE | SUBTYPE | NULL | ID | QUOTED_ID | NUMBER | QUOTED_LITERAL | SL_COMMENT | ML_COMMENT | COMMA | EQUALS | SEMI | QUESTION_MARK | FORWARD_SLASH | PERCENT | PIPE | STAR | EXCLAMATION | GREATERTHAN | LESSTHAN | WS );", 12, 0, input);

            throw nvae;
        }

        switch (alt12) {
            case 1 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:10: T46
                {
                mT46(); 

                }
                break;
            case 2 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:14: T47
                {
                mT47(); 

                }
                break;
            case 3 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:18: T48
                {
                mT48(); 

                }
                break;
            case 4 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:22: T49
                {
                mT49(); 

                }
                break;
            case 5 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:26: CURSOR
                {
                mCURSOR(); 

                }
                break;
            case 6 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:33: AS
                {
                mAS(); 

                }
                break;
            case 7 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:36: IS
                {
                mIS(); 

                }
                break;
            case 8 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:39: RETURN
                {
                mRETURN(); 

                }
                break;
            case 9 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:46: PACKAGE
                {
                mPACKAGE(); 

                }
                break;
            case 10 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:54: END
                {
                mEND(); 

                }
                break;
            case 11 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:58: AUTHID
                {
                mAUTHID(); 

                }
                break;
            case 12 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:65: FUNCTION
                {
                mFUNCTION(); 

                }
                break;
            case 13 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:74: PROCEDURE
                {
                mPROCEDURE(); 

                }
                break;
            case 14 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:84: IN
                {
                mIN(); 

                }
                break;
            case 15 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:87: OUT
                {
                mOUT(); 

                }
                break;
            case 16 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:91: NOCOPY
                {
                mNOCOPY(); 

                }
                break;
            case 17 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:98: DEFAULT
                {
                mDEFAULT(); 

                }
                break;
            case 18 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:106: EXCEPTION
                {
                mEXCEPTION(); 

                }
                break;
            case 19 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:116: CONSTANT
                {
                mCONSTANT(); 

                }
                break;
            case 20 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:125: PRAGMA
                {
                mPRAGMA(); 

                }
                break;
            case 21 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:132: TYPE
                {
                mTYPE(); 

                }
                break;
            case 22 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:137: SUBTYPE
                {
                mSUBTYPE(); 

                }
                break;
            case 23 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:145: NULL
                {
                mNULL(); 

                }
                break;
            case 24 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:150: ID
                {
                mID(); 

                }
                break;
            case 25 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:153: QUOTED_ID
                {
                mQUOTED_ID(); 

                }
                break;
            case 26 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:163: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 27 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:170: QUOTED_LITERAL
                {
                mQUOTED_LITERAL(); 

                }
                break;
            case 28 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:185: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;
            case 29 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:196: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 30 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:207: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 31 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:213: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 32 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:220: SEMI
                {
                mSEMI(); 

                }
                break;
            case 33 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:225: QUESTION_MARK
                {
                mQUESTION_MARK(); 

                }
                break;
            case 34 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:239: FORWARD_SLASH
                {
                mFORWARD_SLASH(); 

                }
                break;
            case 35 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:253: PERCENT
                {
                mPERCENT(); 

                }
                break;
            case 36 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:261: PIPE
                {
                mPIPE(); 

                }
                break;
            case 37 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:266: STAR
                {
                mSTAR(); 

                }
                break;
            case 38 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:271: EXCLAMATION
                {
                mEXCLAMATION(); 

                }
                break;
            case 39 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:283: GREATERTHAN
                {
                mGREATERTHAN(); 

                }
                break;
            case 40 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:295: LESSTHAN
                {
                mLESSTHAN(); 

                }
                break;
            case 41 :
                // src/main/java/com/butterfill/opb/plsql/translation/Plsql.g:1:304: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}