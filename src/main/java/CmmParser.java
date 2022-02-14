// Generated from CmmParser.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmParser extends Parser {
    static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            SPACE=1, SL_COMMENT=2, ML_COMMENT=3, DOT=4, TYPE=5, SEMI=6, COMMA=7, ASSIGNOP=8,
            RELOP=9, PLUS=10, MINUS=11, STAR=12, DIV=13, AND=14, OR=15, NOT=16, LP=17,
            RP=18, LB=19, RB=20, LC=21, RC=22, STRUCT=23, RETURN=24, IF=25, ELSE=26,
            WHILE=27, INT=28, FLOAT=29, ID=30;
    public static final int
            RULE_program = 0, RULE_extDef = 1, RULE_extDecList = 2, RULE_specifier = 3,
            RULE_structSpecifier = 4, RULE_optTag = 5, RULE_tag = 6, RULE_varDec = 7,
            RULE_funDec = 8, RULE_varList = 9, RULE_paramDec = 10, RULE_compSt = 11,
            RULE_stmtList = 12, RULE_stmt = 13, RULE_defList = 14, RULE_def = 15,
            RULE_decList = 16, RULE_dec = 17, RULE_exp = 18, RULE_args = 19;
    private static String[] makeRuleNames() {
        return new String[] {
                "program", "extDef", "extDecList", "specifier", "structSpecifier", "optTag",
                "tag", "varDec", "funDec", "varList", "paramDec", "compSt", "stmtList",
                "stmt", "defList", "def", "decList", "dec", "exp", "args"
        };
    }
    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[] {
                null, null, null, null, "'.'", null, null, null, null, null, null, null,
                null, null, "'&&'", "'||'", "'!'", "'('", "')'", "'['", "']'", "'{'",
                "'}'", "'struct'", "'return'", "'if'", "'else'", "'while'"
        };
    }
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static String[] makeSymbolicNames() {
        return new String[] {
                null, "SPACE", "SL_COMMENT", "ML_COMMENT", "DOT", "TYPE", "SEMI", "COMMA",
                "ASSIGNOP", "RELOP", "PLUS", "MINUS", "STAR", "DIV", "AND", "OR", "NOT",
                "LP", "RP", "LB", "RB", "LC", "RC", "STRUCT", "RETURN", "IF", "ELSE",
                "WHILE", "INT", "FLOAT", "ID"
        };
    }
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() { return "CmmParser.g4"; }

    @Override
    public String[] getRuleNames() { return ruleNames; }

    @Override
    public String getSerializedATN() { return _serializedATN; }

    @Override
    public ATN getATN() { return _ATN; }

    public CmmParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
    }

    public static class ProgramContext extends ParserRuleContext {
        public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
        public List<ExtDefContext> extDef() {
            return getRuleContexts(ExtDefContext.class);
        }
        public ExtDefContext extDef(int i) {
            return getRuleContext(ExtDefContext.class,i);
        }
        public ProgramContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_program; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterProgram(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitProgram(this);
        }
    }

    public final ProgramContext program() throws RecognitionException {
        ProgramContext _localctx = new ProgramContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_program);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(43);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la==TYPE || _la==STRUCT) {
                    {
                        {
                            setState(40);
                            extDef();
                        }
                    }
                    setState(45);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(46);
                match(EOF);
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExtDefContext extends ParserRuleContext {
        public SpecifierContext specifier() {
            return getRuleContext(SpecifierContext.class,0);
        }
        public ExtDecListContext extDecList() {
            return getRuleContext(ExtDecListContext.class,0);
        }
        public TerminalNode SEMI() { return getToken(CmmParser.SEMI, 0); }
        public FunDecContext funDec() {
            return getRuleContext(FunDecContext.class,0);
        }
        public CompStContext compSt() {
            return getRuleContext(CompStContext.class,0);
        }
        public ExtDefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_extDef; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExtDef(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExtDef(this);
        }
    }

    public final ExtDefContext extDef() throws RecognitionException {
        ExtDefContext _localctx = new ExtDefContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_extDef);
        try {
            setState(59);
            _errHandler.sync(this);
            switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(48);
                    specifier();
                    setState(49);
                    extDecList();
                    setState(50);
                    match(SEMI);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(52);
                    specifier();
                    setState(53);
                    match(SEMI);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(55);
                    specifier();
                    setState(56);
                    funDec();
                    setState(57);
                    compSt();
                }
                break;
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExtDecListContext extends ParserRuleContext {
        public List<VarDecContext> varDec() {
            return getRuleContexts(VarDecContext.class);
        }
        public VarDecContext varDec(int i) {
            return getRuleContext(VarDecContext.class,i);
        }
        public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
        public TerminalNode COMMA(int i) {
            return getToken(CmmParser.COMMA, i);
        }
        public ExtDecListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_extDecList; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExtDecList(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExtDecList(this);
        }
    }

    public final ExtDecListContext extDecList() throws RecognitionException {
        ExtDecListContext _localctx = new ExtDecListContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_extDecList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(61);
                varDec();
                setState(66);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la==COMMA) {
                    {
                        {
                            setState(62);
                            match(COMMA);
                            setState(63);
                            varDec();
                        }
                    }
                    setState(68);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SpecifierContext extends ParserRuleContext {
        public TerminalNode TYPE() { return getToken(CmmParser.TYPE, 0); }
        public StructSpecifierContext structSpecifier() {
            return getRuleContext(StructSpecifierContext.class,0);
        }
        public SpecifierContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_specifier; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterSpecifier(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitSpecifier(this);
        }
    }

    public final SpecifierContext specifier() throws RecognitionException {
        SpecifierContext _localctx = new SpecifierContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_specifier);
        try {
            setState(71);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case TYPE:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(69);
                    match(TYPE);
                }
                break;
                case STRUCT:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(70);
                    structSpecifier();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StructSpecifierContext extends ParserRuleContext {
        public TerminalNode STRUCT() { return getToken(CmmParser.STRUCT, 0); }
        public OptTagContext optTag() {
            return getRuleContext(OptTagContext.class,0);
        }
        public TerminalNode LC() { return getToken(CmmParser.LC, 0); }
        public DefListContext defList() {
            return getRuleContext(DefListContext.class,0);
        }
        public TerminalNode RC() { return getToken(CmmParser.RC, 0); }
        public TagContext tag() {
            return getRuleContext(TagContext.class,0);
        }
        public StructSpecifierContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_structSpecifier; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterStructSpecifier(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitStructSpecifier(this);
        }
    }

    public final StructSpecifierContext structSpecifier() throws RecognitionException {
        StructSpecifierContext _localctx = new StructSpecifierContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_structSpecifier);
        try {
            setState(81);
            _errHandler.sync(this);
            switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(73);
                    match(STRUCT);
                    setState(74);
                    optTag();
                    setState(75);
                    match(LC);
                    setState(76);
                    defList();
                    setState(77);
                    match(RC);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(79);
                    match(STRUCT);
                    setState(80);
                    tag();
                }
                break;
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class OptTagContext extends ParserRuleContext {
        public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
        public OptTagContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_optTag; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterOptTag(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitOptTag(this);
        }
    }

    public final OptTagContext optTag() throws RecognitionException {
        OptTagContext _localctx = new OptTagContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_optTag);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(84);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la==ID) {
                    {
                        setState(83);
                        match(ID);
                    }
                }

            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TagContext extends ParserRuleContext {
        public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
        public TagContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_tag; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterTag(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitTag(this);
        }
    }

    public final TagContext tag() throws RecognitionException {
        TagContext _localctx = new TagContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_tag);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(86);
                match(ID);
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class VarDecContext extends ParserRuleContext {
        public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
        public TerminalNode ID(int i) {
            return getToken(CmmParser.ID, i);
        }
        public List<TerminalNode> LB() { return getTokens(CmmParser.LB); }
        public TerminalNode LB(int i) {
            return getToken(CmmParser.LB, i);
        }
        public List<TerminalNode> INT() { return getTokens(CmmParser.INT); }
        public TerminalNode INT(int i) {
            return getToken(CmmParser.INT, i);
        }
        public List<TerminalNode> RB() { return getTokens(CmmParser.RB); }
        public TerminalNode RB(int i) {
            return getToken(CmmParser.RB, i);
        }
        public List<TerminalNode> FLOAT() { return getTokens(CmmParser.FLOAT); }
        public TerminalNode FLOAT(int i) {
            return getToken(CmmParser.FLOAT, i);
        }
        public VarDecContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_varDec; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterVarDec(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitVarDec(this);
        }
    }

    public final VarDecContext varDec() throws RecognitionException {
        VarDecContext _localctx = new VarDecContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_varDec);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(88);
                match(ID);
                setState(102);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la==LB) {
                    {
                        setState(100);
                        _errHandler.sync(this);
                        switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
                            case 1:
                            {
                                {
                                    setState(89);
                                    match(LB);
                                    setState(90);
                                    match(INT);
                                    setState(91);
                                    match(RB);
                                }
                            }
                            break;
                            case 2:
                            {
                                {
                                    setState(92);
                                    match(LB);
                                    notifyErrorListeners("array size must be an integer constant, not FLOAT");
                                    setState(94);
                                    match(FLOAT);
                                    setState(95);
                                    match(RB);
                                }
                            }
                            break;
                            case 3:
                            {
                                {
                                    setState(96);
                                    match(LB);
                                    notifyErrorListeners("array size must be an integer constant, not ID");
                                    setState(98);
                                    match(ID);
                                    setState(99);
                                    match(RB);
                                }
                            }
                            break;
                        }
                    }
                    setState(104);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FunDecContext extends ParserRuleContext {
        public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
        public TerminalNode LP() { return getToken(CmmParser.LP, 0); }
        public VarListContext varList() {
            return getRuleContext(VarListContext.class,0);
        }
        public TerminalNode RP() { return getToken(CmmParser.RP, 0); }
        public FunDecContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_funDec; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterFunDec(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitFunDec(this);
        }
    }

    public final FunDecContext funDec() throws RecognitionException {
        FunDecContext _localctx = new FunDecContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_funDec);
        try {
            setState(113);
            _errHandler.sync(this);
            switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(105);
                    match(ID);
                    setState(106);
                    match(LP);
                    setState(107);
                    varList();
                    setState(108);
                    match(RP);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(110);
                    match(ID);
                    setState(111);
                    match(LP);
                    setState(112);
                    match(RP);
                }
                break;
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class VarListContext extends ParserRuleContext {
        public List<ParamDecContext> paramDec() {
            return getRuleContexts(ParamDecContext.class);
        }
        public ParamDecContext paramDec(int i) {
            return getRuleContext(ParamDecContext.class,i);
        }
        public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
        public TerminalNode COMMA(int i) {
            return getToken(CmmParser.COMMA, i);
        }
        public VarListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_varList; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterVarList(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitVarList(this);
        }
    }

    public final VarListContext varList() throws RecognitionException {
        VarListContext _localctx = new VarListContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_varList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(115);
                paramDec();
                setState(120);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la==COMMA) {
                    {
                        {
                            setState(116);
                            match(COMMA);
                            setState(117);
                            paramDec();
                        }
                    }
                    setState(122);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ParamDecContext extends ParserRuleContext {
        public SpecifierContext specifier() {
            return getRuleContext(SpecifierContext.class,0);
        }
        public VarDecContext varDec() {
            return getRuleContext(VarDecContext.class,0);
        }
        public ParamDecContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_paramDec; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterParamDec(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitParamDec(this);
        }
    }

    public final ParamDecContext paramDec() throws RecognitionException {
        ParamDecContext _localctx = new ParamDecContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_paramDec);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(123);
                specifier();
                setState(124);
                varDec();
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CompStContext extends ParserRuleContext {
        public TerminalNode LC() { return getToken(CmmParser.LC, 0); }
        public DefListContext defList() {
            return getRuleContext(DefListContext.class,0);
        }
        public StmtListContext stmtList() {
            return getRuleContext(StmtListContext.class,0);
        }
        public TerminalNode RC() { return getToken(CmmParser.RC, 0); }
        public CompStContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_compSt; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterCompSt(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitCompSt(this);
        }
    }

    public final CompStContext compSt() throws RecognitionException {
        CompStContext _localctx = new CompStContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_compSt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(126);
                match(LC);
                setState(127);
                defList();
                setState(128);
                stmtList();
                setState(129);
                match(RC);
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StmtListContext extends ParserRuleContext {
        public List<StmtContext> stmt() {
            return getRuleContexts(StmtContext.class);
        }
        public StmtContext stmt(int i) {
            return getRuleContext(StmtContext.class,i);
        }
        public StmtListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_stmtList; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterStmtList(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitStmtList(this);
        }
    }

    public final StmtListContext stmtList() throws RecognitionException {
        StmtListContext _localctx = new StmtListContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_stmtList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(134);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LP) | (1L << LC) | (1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << INT) | (1L << FLOAT) | (1L << ID))) != 0)) {
                    {
                        {
                            setState(131);
                            stmt();
                        }
                    }
                    setState(136);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StmtContext extends ParserRuleContext {
        public ExpContext exp() {
            return getRuleContext(ExpContext.class,0);
        }
        public TerminalNode SEMI() { return getToken(CmmParser.SEMI, 0); }
        public CompStContext compSt() {
            return getRuleContext(CompStContext.class,0);
        }
        public TerminalNode RETURN() { return getToken(CmmParser.RETURN, 0); }
        public TerminalNode IF() { return getToken(CmmParser.IF, 0); }
        public TerminalNode LP() { return getToken(CmmParser.LP, 0); }
        public TerminalNode RP() { return getToken(CmmParser.RP, 0); }
        public List<StmtContext> stmt() {
            return getRuleContexts(StmtContext.class);
        }
        public StmtContext stmt(int i) {
            return getRuleContext(StmtContext.class,i);
        }
        public TerminalNode ELSE() { return getToken(CmmParser.ELSE, 0); }
        public TerminalNode WHILE() { return getToken(CmmParser.WHILE, 0); }
        public StmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_stmt; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterStmt(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitStmt(this);
        }
    }

    public final StmtContext stmt() throws RecognitionException {
        StmtContext _localctx = new StmtContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_stmt);
        try {
            setState(165);
            _errHandler.sync(this);
            switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(137);
                    exp(0);
                    setState(138);
                    match(SEMI);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(140);
                    compSt();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(141);
                    match(RETURN);
                    setState(142);
                    exp(0);
                    setState(143);
                    match(SEMI);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(145);
                    match(IF);
                    setState(146);
                    match(LP);
                    setState(147);
                    exp(0);
                    setState(148);
                    match(RP);
                    setState(149);
                    stmt();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(151);
                    match(IF);
                    setState(152);
                    match(LP);
                    setState(153);
                    exp(0);
                    setState(154);
                    match(RP);
                    setState(155);
                    stmt();
                    setState(156);
                    match(ELSE);
                    setState(157);
                    stmt();
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(159);
                    match(WHILE);
                    setState(160);
                    match(LP);
                    setState(161);
                    exp(0);
                    setState(162);
                    match(RP);
                    setState(163);
                    stmt();
                }
                break;
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DefListContext extends ParserRuleContext {
        public List<DefContext> def() {
            return getRuleContexts(DefContext.class);
        }
        public DefContext def(int i) {
            return getRuleContext(DefContext.class,i);
        }
        public DefListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_defList; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterDefList(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitDefList(this);
        }
    }

    public final DefListContext defList() throws RecognitionException {
        DefListContext _localctx = new DefListContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_defList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(170);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la==TYPE || _la==STRUCT) {
                    {
                        {
                            setState(167);
                            def();
                        }
                    }
                    setState(172);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DefContext extends ParserRuleContext {
        public SpecifierContext specifier() {
            return getRuleContext(SpecifierContext.class,0);
        }
        public DecListContext decList() {
            return getRuleContext(DecListContext.class,0);
        }
        public TerminalNode SEMI() { return getToken(CmmParser.SEMI, 0); }
        public DefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_def; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterDef(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitDef(this);
        }
    }

    public final DefContext def() throws RecognitionException {
        DefContext _localctx = new DefContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_def);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(173);
                specifier();
                setState(174);
                decList();
                setState(175);
                match(SEMI);
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DecListContext extends ParserRuleContext {
        public List<DecContext> dec() {
            return getRuleContexts(DecContext.class);
        }
        public DecContext dec(int i) {
            return getRuleContext(DecContext.class,i);
        }
        public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
        public TerminalNode COMMA(int i) {
            return getToken(CmmParser.COMMA, i);
        }
        public DecListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_decList; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterDecList(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitDecList(this);
        }
    }

    public final DecListContext decList() throws RecognitionException {
        DecListContext _localctx = new DecListContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_decList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(177);
                dec();
                setState(182);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la==COMMA) {
                    {
                        {
                            setState(178);
                            match(COMMA);
                            setState(179);
                            dec();
                        }
                    }
                    setState(184);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DecContext extends ParserRuleContext {
        public VarDecContext varDec() {
            return getRuleContext(VarDecContext.class,0);
        }
        public TerminalNode ASSIGNOP() { return getToken(CmmParser.ASSIGNOP, 0); }
        public ExpContext exp() {
            return getRuleContext(ExpContext.class,0);
        }
        public DecContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_dec; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterDec(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitDec(this);
        }
    }

    public final DecContext dec() throws RecognitionException {
        DecContext _localctx = new DecContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_dec);
        try {
            setState(190);
            _errHandler.sync(this);
            switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(185);
                    varDec();
                    setState(186);
                    match(ASSIGNOP);
                    setState(187);
                    exp(0);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(189);
                    varDec();
                }
                break;
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExpContext extends ParserRuleContext {
        public TerminalNode LP() { return getToken(CmmParser.LP, 0); }
        public List<ExpContext> exp() {
            return getRuleContexts(ExpContext.class);
        }
        public ExpContext exp(int i) {
            return getRuleContext(ExpContext.class,i);
        }
        public TerminalNode RP() { return getToken(CmmParser.RP, 0); }
        public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
        public ArgsContext args() {
            return getRuleContext(ArgsContext.class,0);
        }
        public TerminalNode MINUS() { return getToken(CmmParser.MINUS, 0); }
        public TerminalNode NOT() { return getToken(CmmParser.NOT, 0); }
        public TerminalNode INT() { return getToken(CmmParser.INT, 0); }
        public TerminalNode FLOAT() { return getToken(CmmParser.FLOAT, 0); }
        public TerminalNode STAR() { return getToken(CmmParser.STAR, 0); }
        public TerminalNode DIV() { return getToken(CmmParser.DIV, 0); }
        public TerminalNode PLUS() { return getToken(CmmParser.PLUS, 0); }
        public TerminalNode RELOP() { return getToken(CmmParser.RELOP, 0); }
        public TerminalNode AND() { return getToken(CmmParser.AND, 0); }
        public TerminalNode OR() { return getToken(CmmParser.OR, 0); }
        public TerminalNode ASSIGNOP() { return getToken(CmmParser.ASSIGNOP, 0); }
        public TerminalNode LB() { return getToken(CmmParser.LB, 0); }
        public TerminalNode RB() { return getToken(CmmParser.RB, 0); }
        public TerminalNode DOT() { return getToken(CmmParser.DOT, 0); }
        public ExpContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_exp; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterExp(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitExp(this);
        }
    }

    public final ExpContext exp() throws RecognitionException {
        return exp(0);
    }

    private ExpContext exp(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExpContext _localctx = new ExpContext(_ctx, _parentState);
        ExpContext _prevctx = _localctx;
        int _startState = 36;
        enterRecursionRule(_localctx, 36, RULE_exp, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(208);
                _errHandler.sync(this);
                switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
                    case 1:
                    {
                        setState(193);
                        match(LP);
                        setState(194);
                        exp(0);
                        setState(195);
                        match(RP);
                    }
                    break;
                    case 2:
                    {
                        setState(197);
                        match(ID);
                        setState(198);
                        match(LP);
                        setState(200);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LP) | (1L << INT) | (1L << FLOAT) | (1L << ID))) != 0)) {
                            {
                                setState(199);
                                args();
                            }
                        }

                        setState(202);
                        match(RP);
                    }
                    break;
                    case 3:
                    {
                        setState(203);
                        _la = _input.LA(1);
                        if ( !(_la==MINUS || _la==NOT) ) {
                            _errHandler.recoverInline(this);
                        }
                        else {
                            if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                        setState(204);
                        exp(10);
                    }
                    break;
                    case 4:
                    {
                        setState(205);
                        match(ID);
                    }
                    break;
                    case 5:
                    {
                        setState(206);
                        match(INT);
                    }
                    break;
                    case 6:
                    {
                        setState(207);
                        match(FLOAT);
                    }
                    break;
                }
                _ctx.stop = _input.LT(-1);
                setState(238);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input,18,_ctx);
                while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
                    if ( _alt==1 ) {
                        if ( _parseListeners!=null ) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(236);
                            _errHandler.sync(this);
                            switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
                                case 1:
                                {
                                    _localctx = new ExpContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_exp);
                                    setState(210);
                                    if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
                                    setState(211);
                                    _la = _input.LA(1);
                                    if ( !(_la==STAR || _la==DIV) ) {
                                        _errHandler.recoverInline(this);
                                    }
                                    else {
                                        if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(212);
                                    exp(10);
                                }
                                break;
                                case 2:
                                {
                                    _localctx = new ExpContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_exp);
                                    setState(213);
                                    if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
                                    setState(214);
                                    _la = _input.LA(1);
                                    if ( !(_la==PLUS || _la==MINUS) ) {
                                        _errHandler.recoverInline(this);
                                    }
                                    else {
                                        if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(215);
                                    exp(9);
                                }
                                break;
                                case 3:
                                {
                                    _localctx = new ExpContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_exp);
                                    setState(216);
                                    if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
                                    setState(217);
                                    match(RELOP);
                                    setState(218);
                                    exp(8);
                                }
                                break;
                                case 4:
                                {
                                    _localctx = new ExpContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_exp);
                                    setState(219);
                                    if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                                    setState(220);
                                    match(AND);
                                    setState(221);
                                    exp(7);
                                }
                                break;
                                case 5:
                                {
                                    _localctx = new ExpContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_exp);
                                    setState(222);
                                    if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                                    setState(223);
                                    match(OR);
                                    setState(224);
                                    exp(6);
                                }
                                break;
                                case 6:
                                {
                                    _localctx = new ExpContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_exp);
                                    setState(225);
                                    if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                                    setState(226);
                                    match(ASSIGNOP);
                                    setState(227);
                                    exp(4);
                                }
                                break;
                                case 7:
                                {
                                    _localctx = new ExpContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_exp);
                                    setState(228);
                                    if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
                                    setState(229);
                                    match(LB);
                                    setState(230);
                                    exp(0);
                                    setState(231);
                                    match(RB);
                                }
                                break;
                                case 8:
                                {
                                    _localctx = new ExpContext(_parentctx, _parentState);
                                    pushNewRecursionContext(_localctx, _startState, RULE_exp);
                                    setState(233);
                                    if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
                                    setState(234);
                                    match(DOT);
                                    setState(235);
                                    match(ID);
                                }
                                break;
                            }
                        }
                    }
                    setState(240);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input,18,_ctx);
                }
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class ArgsContext extends ParserRuleContext {
        public List<ExpContext> exp() {
            return getRuleContexts(ExpContext.class);
        }
        public ExpContext exp(int i) {
            return getRuleContext(ExpContext.class,i);
        }
        public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
        public TerminalNode COMMA(int i) {
            return getToken(CmmParser.COMMA, i);
        }
        public ArgsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_args; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).enterArgs(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof CmmParserListener ) ((CmmParserListener)listener).exitArgs(this);
        }
    }

    public final ArgsContext args() throws RecognitionException {
        ArgsContext _localctx = new ArgsContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_args);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(241);
                exp(0);
                setState(246);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la==COMMA) {
                    {
                        {
                            setState(242);
                            match(COMMA);
                            setState(243);
                            exp(0);
                        }
                    }
                    setState(248);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 18:
                return exp_sempred((ExpContext)_localctx, predIndex);
        }
        return true;
    }
    private boolean exp_sempred(ExpContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 9);
            case 1:
                return precpred(_ctx, 8);
            case 2:
                return precpred(_ctx, 7);
            case 3:
                return precpred(_ctx, 6);
            case 4:
                return precpred(_ctx, 5);
            case 5:
                return precpred(_ctx, 4);
            case 6:
                return precpred(_ctx, 12);
            case 7:
                return precpred(_ctx, 11);
        }
        return true;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u00fc\4\2\t\2\4"+
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
                    "\4\23\t\23\4\24\t\24\4\25\t\25\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\3"+
                    "\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3>\n\3\3\4\3\4\3\4\7\4C\n\4"+
                    "\f\4\16\4F\13\4\3\5\3\5\5\5J\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6T"+
                    "\n\6\3\7\5\7W\n\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
                    "\3\t\7\tg\n\t\f\t\16\tj\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nt\n\n"+
                    "\3\13\3\13\3\13\7\13y\n\13\f\13\16\13|\13\13\3\f\3\f\3\f\3\r\3\r\3\r\3"+
                    "\r\3\r\3\16\7\16\u0087\n\16\f\16\16\16\u008a\13\16\3\17\3\17\3\17\3\17"+
                    "\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
                    "\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00a8\n\17\3\20"+
                    "\7\20\u00ab\n\20\f\20\16\20\u00ae\13\20\3\21\3\21\3\21\3\21\3\22\3\22"+
                    "\3\22\7\22\u00b7\n\22\f\22\16\22\u00ba\13\22\3\23\3\23\3\23\3\23\3\23"+
                    "\5\23\u00c1\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00cb\n"+
                    "\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00d3\n\24\3\24\3\24\3\24\3\24"+
                    "\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
                    "\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00ef\n\24\f\24\16\24\u00f2"+
                    "\13\24\3\25\3\25\3\25\7\25\u00f7\n\25\f\25\16\25\u00fa\13\25\3\25\2\3"+
                    "&\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\5\4\2\r\r\22\22\3"+
                    "\2\16\17\3\2\f\r\2\u010b\2-\3\2\2\2\4=\3\2\2\2\6?\3\2\2\2\bI\3\2\2\2\n"+
                    "S\3\2\2\2\fV\3\2\2\2\16X\3\2\2\2\20Z\3\2\2\2\22s\3\2\2\2\24u\3\2\2\2\26"+
                    "}\3\2\2\2\30\u0080\3\2\2\2\32\u0088\3\2\2\2\34\u00a7\3\2\2\2\36\u00ac"+
                    "\3\2\2\2 \u00af\3\2\2\2\"\u00b3\3\2\2\2$\u00c0\3\2\2\2&\u00d2\3\2\2\2"+
                    "(\u00f3\3\2\2\2*,\5\4\3\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60"+
                    "\3\2\2\2/-\3\2\2\2\60\61\7\2\2\3\61\3\3\2\2\2\62\63\5\b\5\2\63\64\5\6"+
                    "\4\2\64\65\7\b\2\2\65>\3\2\2\2\66\67\5\b\5\2\678\7\b\2\28>\3\2\2\29:\5"+
                    "\b\5\2:;\5\22\n\2;<\5\30\r\2<>\3\2\2\2=\62\3\2\2\2=\66\3\2\2\2=9\3\2\2"+
                    "\2>\5\3\2\2\2?D\5\20\t\2@A\7\t\2\2AC\5\20\t\2B@\3\2\2\2CF\3\2\2\2DB\3"+
                    "\2\2\2DE\3\2\2\2E\7\3\2\2\2FD\3\2\2\2GJ\7\7\2\2HJ\5\n\6\2IG\3\2\2\2IH"+
                    "\3\2\2\2J\t\3\2\2\2KL\7\31\2\2LM\5\f\7\2MN\7\27\2\2NO\5\36\20\2OP\7\30"+
                    "\2\2PT\3\2\2\2QR\7\31\2\2RT\5\16\b\2SK\3\2\2\2SQ\3\2\2\2T\13\3\2\2\2U"+
                    "W\7 \2\2VU\3\2\2\2VW\3\2\2\2W\r\3\2\2\2XY\7 \2\2Y\17\3\2\2\2Zh\7 \2\2"+
                    "[\\\7\25\2\2\\]\7\36\2\2]g\7\26\2\2^_\7\25\2\2_`\b\t\1\2`a\7\37\2\2ag"+
                    "\7\26\2\2bc\7\25\2\2cd\b\t\1\2de\7 \2\2eg\7\26\2\2f[\3\2\2\2f^\3\2\2\2"+
                    "fb\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\21\3\2\2\2jh\3\2\2\2kl\7 \2"+
                    "\2lm\7\23\2\2mn\5\24\13\2no\7\24\2\2ot\3\2\2\2pq\7 \2\2qr\7\23\2\2rt\7"+
                    "\24\2\2sk\3\2\2\2sp\3\2\2\2t\23\3\2\2\2uz\5\26\f\2vw\7\t\2\2wy\5\26\f"+
                    "\2xv\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\25\3\2\2\2|z\3\2\2\2}~\5\b"+
                    "\5\2~\177\5\20\t\2\177\27\3\2\2\2\u0080\u0081\7\27\2\2\u0081\u0082\5\36"+
                    "\20\2\u0082\u0083\5\32\16\2\u0083\u0084\7\30\2\2\u0084\31\3\2\2\2\u0085"+
                    "\u0087\5\34\17\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3"+
                    "\2\2\2\u0088\u0089\3\2\2\2\u0089\33\3\2\2\2\u008a\u0088\3\2\2\2\u008b"+
                    "\u008c\5&\24\2\u008c\u008d\7\b\2\2\u008d\u00a8\3\2\2\2\u008e\u00a8\5\30"+
                    "\r\2\u008f\u0090\7\32\2\2\u0090\u0091\5&\24\2\u0091\u0092\7\b\2\2\u0092"+
                    "\u00a8\3\2\2\2\u0093\u0094\7\33\2\2\u0094\u0095\7\23\2\2\u0095\u0096\5"+
                    "&\24\2\u0096\u0097\7\24\2\2\u0097\u0098\5\34\17\2\u0098\u00a8\3\2\2\2"+
                    "\u0099\u009a\7\33\2\2\u009a\u009b\7\23\2\2\u009b\u009c\5&\24\2\u009c\u009d"+
                    "\7\24\2\2\u009d\u009e\5\34\17\2\u009e\u009f\7\34\2\2\u009f\u00a0\5\34"+
                    "\17\2\u00a0\u00a8\3\2\2\2\u00a1\u00a2\7\35\2\2\u00a2\u00a3\7\23\2\2\u00a3"+
                    "\u00a4\5&\24\2\u00a4\u00a5\7\24\2\2\u00a5\u00a6\5\34\17\2\u00a6\u00a8"+
                    "\3\2\2\2\u00a7\u008b\3\2\2\2\u00a7\u008e\3\2\2\2\u00a7\u008f\3\2\2\2\u00a7"+
                    "\u0093\3\2\2\2\u00a7\u0099\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a8\35\3\2\2"+
                    "\2\u00a9\u00ab\5 \21\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa"+
                    "\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\37\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af"+
                    "\u00b0\5\b\5\2\u00b0\u00b1\5\"\22\2\u00b1\u00b2\7\b\2\2\u00b2!\3\2\2\2"+
                    "\u00b3\u00b8\5$\23\2\u00b4\u00b5\7\t\2\2\u00b5\u00b7\5$\23\2\u00b6\u00b4"+
                    "\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
                    "#\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\5\20\t\2\u00bc\u00bd\7\n\2\2"+
                    "\u00bd\u00be\5&\24\2\u00be\u00c1\3\2\2\2\u00bf\u00c1\5\20\t\2\u00c0\u00bb"+
                    "\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1%\3\2\2\2\u00c2\u00c3\b\24\1\2\u00c3"+
                    "\u00c4\7\23\2\2\u00c4\u00c5\5&\24\2\u00c5\u00c6\7\24\2\2\u00c6\u00d3\3"+
                    "\2\2\2\u00c7\u00c8\7 \2\2\u00c8\u00ca\7\23\2\2\u00c9\u00cb\5(\25\2\u00ca"+
                    "\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00d3\7\24"+
                    "\2\2\u00cd\u00ce\t\2\2\2\u00ce\u00d3\5&\24\f\u00cf\u00d3\7 \2\2\u00d0"+
                    "\u00d3\7\36\2\2\u00d1\u00d3\7\37\2\2\u00d2\u00c2\3\2\2\2\u00d2\u00c7\3"+
                    "\2\2\2\u00d2\u00cd\3\2\2\2\u00d2\u00cf\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
                    "\u00d1\3\2\2\2\u00d3\u00f0\3\2\2\2\u00d4\u00d5\f\13\2\2\u00d5\u00d6\t"+
                    "\3\2\2\u00d6\u00ef\5&\24\f\u00d7\u00d8\f\n\2\2\u00d8\u00d9\t\4\2\2\u00d9"+
                    "\u00ef\5&\24\13\u00da\u00db\f\t\2\2\u00db\u00dc\7\13\2\2\u00dc\u00ef\5"+
                    "&\24\n\u00dd\u00de\f\b\2\2\u00de\u00df\7\20\2\2\u00df\u00ef\5&\24\t\u00e0"+
                    "\u00e1\f\7\2\2\u00e1\u00e2\7\21\2\2\u00e2\u00ef\5&\24\b\u00e3\u00e4\f"+
                    "\6\2\2\u00e4\u00e5\7\n\2\2\u00e5\u00ef\5&\24\6\u00e6\u00e7\f\16\2\2\u00e7"+
                    "\u00e8\7\25\2\2\u00e8\u00e9\5&\24\2\u00e9\u00ea\7\26\2\2\u00ea\u00ef\3"+
                    "\2\2\2\u00eb\u00ec\f\r\2\2\u00ec\u00ed\7\6\2\2\u00ed\u00ef\7 \2\2\u00ee"+
                    "\u00d4\3\2\2\2\u00ee\u00d7\3\2\2\2\u00ee\u00da\3\2\2\2\u00ee\u00dd\3\2"+
                    "\2\2\u00ee\u00e0\3\2\2\2\u00ee\u00e3\3\2\2\2\u00ee\u00e6\3\2\2\2\u00ee"+
                    "\u00eb\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2"+
                    "\2\2\u00f1\'\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f8\5&\24\2\u00f4\u00f5"+
                    "\7\t\2\2\u00f5\u00f7\5&\24\2\u00f6\u00f4\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8"+
                    "\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9)\3\2\2\2\u00fa\u00f8\3\2\2\2"+
                    "\26-=DISVfhsz\u0088\u00a7\u00ac\u00b8\u00c0\u00ca\u00d2\u00ee\u00f0\u00f8";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}