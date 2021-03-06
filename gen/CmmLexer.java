// Generated from /Users/yjp/nju/大三上/编译原理/Lab/src/main/g4/CmmLexer.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmLexer extends Lexer {
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
		ESQLCOMMENT=2, ERRORCHANNEL=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN", "ESQLCOMMENT", "ERRORCHANNEL"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SPACE", "SL_COMMENT", "ML_COMMENT", "DOT", "TYPE", "SEMI", "COMMA", 
			"ASSIGNOP", "RELOP", "PLUS", "MINUS", "STAR", "DIV", "AND", "OR", "NOT", 
			"LP", "RP", "LB", "RB", "LC", "RC", "STRUCT", "RETURN", "IF", "ELSE", 
			"WHILE", "INT", "FLOAT", "ID", "OCTINT", "DECINT", "HEXINT", "NORMALFLOAT", 
			"EXPFLOAT", "DEC_DIGIT", "ID_LETTER", "A", "B", "C", "D", "E", "F", "G", 
			"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", 
			"V", "W", "X", "Y", "Z"
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


	public CmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CmmLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2 \u0179\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\6\2\u0083\n\2\r\2\16\2\u0084\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\7\3\u008d\n\3\f\3\16\3\u0090\13\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\7\4\u009a\n\4\f\4\16\4\u009d\13\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00ae\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00bf\n\n\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\5\35\u00fc\n\35"+
		"\3\36\3\36\5\36\u0100\n\36\3\37\5\37\u0103\n\37\3\37\7\37\u0106\n\37\f"+
		"\37\16\37\u0109\13\37\3 \3 \6 \u010d\n \r \16 \u010e\3!\3!\3!\6!\u0114"+
		"\n!\r!\16!\u0115\3\"\3\"\3\"\7\"\u011b\n\"\f\"\16\"\u011e\13\"\5\"\u0120"+
		"\n\"\3#\3#\3#\6#\u0125\n#\r#\16#\u0126\3$\3$\6$\u012b\n$\r$\16$\u012c"+
		"\3$\3$\3$\3$\6$\u0133\n$\r$\16$\u0134\5$\u0137\n$\3$\3$\5$\u013b\n$\3"+
		"$\6$\u013e\n$\r$\16$\u013f\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3"+
		"+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64"+
		"\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3"+
		"=\3>\3>\3?\3?\3@\3@\4\u008e\u009b\2A\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S"+
		"\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177"+
		"\2\3\2.\5\2\13\f\17\17\"\"\3\2==\3\2..\3\2??\4\2>>@@\3\2--\3\2//\3\2,"+
		",\3\2\61\61\5\2C\\aac|\6\2\62;C\\aac|\3\2\62\62\3\2\629\4\2ZZzz\5\2\62"+
		";CHch\3\2\63;\3\2\62;\4\2GGgg\4\2--//\4\2C\\c|\4\2CCcc\4\2DDdd\4\2EEe"+
		"e\4\2FFff\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2"+
		"OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4"+
		"\2XXxx\4\2YYyy\4\2[[{{\4\2\\\\||\2\u016e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3\u0082\3\2"+
		"\2\2\5\u0088\3\2\2\2\7\u0095\3\2\2\2\t\u00a3\3\2\2\2\13\u00ad\3\2\2\2"+
		"\r\u00af\3\2\2\2\17\u00b1\3\2\2\2\21\u00b3\3\2\2\2\23\u00be\3\2\2\2\25"+
		"\u00c0\3\2\2\2\27\u00c2\3\2\2\2\31\u00c4\3\2\2\2\33\u00c6\3\2\2\2\35\u00c8"+
		"\3\2\2\2\37\u00cb\3\2\2\2!\u00ce\3\2\2\2#\u00d0\3\2\2\2%\u00d2\3\2\2\2"+
		"\'\u00d4\3\2\2\2)\u00d6\3\2\2\2+\u00d8\3\2\2\2-\u00da\3\2\2\2/\u00dc\3"+
		"\2\2\2\61\u00e3\3\2\2\2\63\u00ea\3\2\2\2\65\u00ed\3\2\2\2\67\u00f2\3\2"+
		"\2\29\u00fb\3\2\2\2;\u00ff\3\2\2\2=\u0102\3\2\2\2?\u010a\3\2\2\2A\u0110"+
		"\3\2\2\2C\u011f\3\2\2\2E\u0121\3\2\2\2G\u0136\3\2\2\2I\u0141\3\2\2\2K"+
		"\u0143\3\2\2\2M\u0145\3\2\2\2O\u0147\3\2\2\2Q\u0149\3\2\2\2S\u014b\3\2"+
		"\2\2U\u014d\3\2\2\2W\u014f\3\2\2\2Y\u0151\3\2\2\2[\u0153\3\2\2\2]\u0155"+
		"\3\2\2\2_\u0157\3\2\2\2a\u0159\3\2\2\2c\u015b\3\2\2\2e\u015d\3\2\2\2g"+
		"\u015f\3\2\2\2i\u0161\3\2\2\2k\u0163\3\2\2\2m\u0165\3\2\2\2o\u0167\3\2"+
		"\2\2q\u0169\3\2\2\2s\u016b\3\2\2\2u\u016d\3\2\2\2w\u016f\3\2\2\2y\u0171"+
		"\3\2\2\2{\u0173\3\2\2\2}\u0175\3\2\2\2\177\u0177\3\2\2\2\u0081\u0083\t"+
		"\2\2\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\b\2\2\2\u0087\4\3\2\2\2"+
		"\u0088\u0089\7\61\2\2\u0089\u008a\7\61\2\2\u008a\u008e\3\2\2\2\u008b\u008d"+
		"\13\2\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008f\3\2\2\2"+
		"\u008e\u008c\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092"+
		"\7\f\2\2\u0092\u0093\3\2\2\2\u0093\u0094\b\3\2\2\u0094\6\3\2\2\2\u0095"+
		"\u0096\7\61\2\2\u0096\u0097\7,\2\2\u0097\u009b\3\2\2\2\u0098\u009a\13"+
		"\2\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u009c\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009c\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\7,"+
		"\2\2\u009f\u00a0\7\61\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\b\4\2\2\u00a2"+
		"\b\3\2\2\2\u00a3\u00a4\7\60\2\2\u00a4\n\3\2\2\2\u00a5\u00a6\7k\2\2\u00a6"+
		"\u00a7\7p\2\2\u00a7\u00ae\7v\2\2\u00a8\u00a9\7h\2\2\u00a9\u00aa\7n\2\2"+
		"\u00aa\u00ab\7q\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ae\7v\2\2\u00ad\u00a5"+
		"\3\2\2\2\u00ad\u00a8\3\2\2\2\u00ae\f\3\2\2\2\u00af\u00b0\t\3\2\2\u00b0"+
		"\16\3\2\2\2\u00b1\u00b2\t\4\2\2\u00b2\20\3\2\2\2\u00b3\u00b4\t\5\2\2\u00b4"+
		"\22\3\2\2\2\u00b5\u00bf\t\6\2\2\u00b6\u00b7\7@\2\2\u00b7\u00bf\7?\2\2"+
		"\u00b8\u00b9\7>\2\2\u00b9\u00bf\7?\2\2\u00ba\u00bb\7?\2\2\u00bb\u00bf"+
		"\7?\2\2\u00bc\u00bd\7#\2\2\u00bd\u00bf\7?\2\2\u00be\u00b5\3\2\2\2\u00be"+
		"\u00b6\3\2\2\2\u00be\u00b8\3\2\2\2\u00be\u00ba\3\2\2\2\u00be\u00bc\3\2"+
		"\2\2\u00bf\24\3\2\2\2\u00c0\u00c1\t\7\2\2\u00c1\26\3\2\2\2\u00c2\u00c3"+
		"\t\b\2\2\u00c3\30\3\2\2\2\u00c4\u00c5\t\t\2\2\u00c5\32\3\2\2\2\u00c6\u00c7"+
		"\t\n\2\2\u00c7\34\3\2\2\2\u00c8\u00c9\7(\2\2\u00c9\u00ca\7(\2\2\u00ca"+
		"\36\3\2\2\2\u00cb\u00cc\7~\2\2\u00cc\u00cd\7~\2\2\u00cd \3\2\2\2\u00ce"+
		"\u00cf\7#\2\2\u00cf\"\3\2\2\2\u00d0\u00d1\7*\2\2\u00d1$\3\2\2\2\u00d2"+
		"\u00d3\7+\2\2\u00d3&\3\2\2\2\u00d4\u00d5\7]\2\2\u00d5(\3\2\2\2\u00d6\u00d7"+
		"\7_\2\2\u00d7*\3\2\2\2\u00d8\u00d9\7}\2\2\u00d9,\3\2\2\2\u00da\u00db\7"+
		"\177\2\2\u00db.\3\2\2\2\u00dc\u00dd\7u\2\2\u00dd\u00de\7v\2\2\u00de\u00df"+
		"\7t\2\2\u00df\u00e0\7w\2\2\u00e0\u00e1\7e\2\2\u00e1\u00e2\7v\2\2\u00e2"+
		"\60\3\2\2\2\u00e3\u00e4\7t\2\2\u00e4\u00e5\7g\2\2\u00e5\u00e6\7v\2\2\u00e6"+
		"\u00e7\7w\2\2\u00e7\u00e8\7t\2\2\u00e8\u00e9\7p\2\2\u00e9\62\3\2\2\2\u00ea"+
		"\u00eb\7k\2\2\u00eb\u00ec\7h\2\2\u00ec\64\3\2\2\2\u00ed\u00ee\7g\2\2\u00ee"+
		"\u00ef\7n\2\2\u00ef\u00f0\7u\2\2\u00f0\u00f1\7g\2\2\u00f1\66\3\2\2\2\u00f2"+
		"\u00f3\7y\2\2\u00f3\u00f4\7j\2\2\u00f4\u00f5\7k\2\2\u00f5\u00f6\7n\2\2"+
		"\u00f6\u00f7\7g\2\2\u00f78\3\2\2\2\u00f8\u00fc\5? \2\u00f9\u00fc\5C\""+
		"\2\u00fa\u00fc\5A!\2\u00fb\u00f8\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa"+
		"\3\2\2\2\u00fc:\3\2\2\2\u00fd\u0100\5E#\2\u00fe\u0100\5G$\2\u00ff\u00fd"+
		"\3\2\2\2\u00ff\u00fe\3\2\2\2\u0100<\3\2\2\2\u0101\u0103\t\13\2\2\u0102"+
		"\u0101\3\2\2\2\u0103\u0107\3\2\2\2\u0104\u0106\t\f\2\2\u0105\u0104\3\2"+
		"\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		">\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010c\t\r\2\2\u010b\u010d\t\16\2\2"+
		"\u010c\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f"+
		"\3\2\2\2\u010f@\3\2\2\2\u0110\u0111\7\62\2\2\u0111\u0113\t\17\2\2\u0112"+
		"\u0114\t\20\2\2\u0113\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0113\3"+
		"\2\2\2\u0115\u0116\3\2\2\2\u0116B\3\2\2\2\u0117\u0120\7\62\2\2\u0118\u011c"+
		"\t\21\2\2\u0119\u011b\t\22\2\2\u011a\u0119\3\2\2\2\u011b\u011e\3\2\2\2"+
		"\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c"+
		"\3\2\2\2\u011f\u0117\3\2\2\2\u011f\u0118\3\2\2\2\u0120D\3\2\2\2\u0121"+
		"\u0122\59\35\2\u0122\u0124\7\60\2\2\u0123\u0125\5I%\2\u0124\u0123\3\2"+
		"\2\2\u0125\u0126\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"F\3\2\2\2\u0128\u0137\5E#\2\u0129\u012b\5I%\2\u012a\u0129\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012e\3\2"+
		"\2\2\u012e\u012f\7\60\2\2\u012f\u0137\3\2\2\2\u0130\u0132\7\60\2\2\u0131"+
		"\u0133\5I%\2\u0132\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0132\3\2\2"+
		"\2\u0134\u0135\3\2\2\2\u0135\u0137\3\2\2\2\u0136\u0128\3\2\2\2\u0136\u012a"+
		"\3\2\2\2\u0136\u0130\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\t\23\2\2"+
		"\u0139\u013b\t\24\2\2\u013a\u0139\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d"+
		"\3\2\2\2\u013c\u013e\5I%\2\u013d\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f"+
		"\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140H\3\2\2\2\u0141\u0142\t\22\2\2"+
		"\u0142J\3\2\2\2\u0143\u0144\t\25\2\2\u0144L\3\2\2\2\u0145\u0146\t\26\2"+
		"\2\u0146N\3\2\2\2\u0147\u0148\t\27\2\2\u0148P\3\2\2\2\u0149\u014a\t\30"+
		"\2\2\u014aR\3\2\2\2\u014b\u014c\t\31\2\2\u014cT\3\2\2\2\u014d\u014e\t"+
		"\23\2\2\u014eV\3\2\2\2\u014f\u0150\t\32\2\2\u0150X\3\2\2\2\u0151\u0152"+
		"\t\33\2\2\u0152Z\3\2\2\2\u0153\u0154\t\34\2\2\u0154\\\3\2\2\2\u0155\u0156"+
		"\t\35\2\2\u0156^\3\2\2\2\u0157\u0158\t\36\2\2\u0158`\3\2\2\2\u0159\u015a"+
		"\t\37\2\2\u015ab\3\2\2\2\u015b\u015c\t \2\2\u015cd\3\2\2\2\u015d\u015e"+
		"\t!\2\2\u015ef\3\2\2\2\u015f\u0160\t\"\2\2\u0160h\3\2\2\2\u0161\u0162"+
		"\t#\2\2\u0162j\3\2\2\2\u0163\u0164\t$\2\2\u0164l\3\2\2\2\u0165\u0166\t"+
		"%\2\2\u0166n\3\2\2\2\u0167\u0168\t&\2\2\u0168p\3\2\2\2\u0169\u016a\t\'"+
		"\2\2\u016ar\3\2\2\2\u016b\u016c\t(\2\2\u016ct\3\2\2\2\u016d\u016e\t)\2"+
		"\2\u016ev\3\2\2\2\u016f\u0170\t*\2\2\u0170x\3\2\2\2\u0171\u0172\t+\2\2"+
		"\u0172z\3\2\2\2\u0173\u0174\t\17\2\2\u0174|\3\2\2\2\u0175\u0176\t,\2\2"+
		"\u0176~\3\2\2\2\u0177\u0178\t-\2\2\u0178\u0080\3\2\2\2\27\2\u0084\u008e"+
		"\u009b\u00ad\u00be\u00fb\u00ff\u0102\u0105\u0107\u010e\u0115\u011c\u011f"+
		"\u0126\u012c\u0134\u0136\u013a\u013f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}