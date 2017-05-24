package sql.generate;
import java.io.*;
import java.util.*;

/**
 * usage: java -jar SQLGenerator.jar | grade | subject | input csv | output sql
 * eg... java -jar SQLGenerator.jar 4,5,6 101,101,101 level/junior_eng.csv
 * junior_eng.sql java -jar SQLGenerator.jar 7,8,8,9,9,9 102,102,105,102,105,106
 * level/science.csv science.sql java -jar SQLGenerator.jar 7,8,9,4,5,6,7,8,9
 * 101,101,101,103,103,103,103,103,103 level/middle_math.csv middle_math.sql
 */
public class SQLGenerator {

	private String[] grade;//年级
	private String[] subject;//科目
	private String csvFile;//读取目标文件，必须是.csv格式
	private String output;//输出.sql格式文件

	public SQLGenerator(String[] grade, String[] subject, String csvFile,
			String output) {
		this.grade = grade;
		this.subject = subject;
		this.csvFile = csvFile;
		this.output = output;

	}

	public SQLGenerator() {

	}

	/**
	 * get runnable SQL
	 * @param levelOrder
	 * @param grade
	 * @param subject
	 * @param tgScore
	 * @param questionCounts
	 * @param judgeExpression
	 * @param nextTgScore
	 * @param topScore
	 * @return
	 */
	private String getSingleSQL(int levelOrder, String grade, String subject,
			String tgScore, String questionCounts, String judgeExpression,
			String nextTgScore, String topScore) {
		return String
				.format("INSERT INTO level_states(level_order,grade,subject,tg_score,question_counts,judge_expression,next_tg_score, top_score) "
						+ "VALUES(%d,%s,%s,%s,%s,%s,%s,%s);", levelOrder,
						grade, subject, tgScore, "\'" + questionCounts + "\'",
						"\'" + judgeExpression + "\'", nextTgScore, topScore);
	}

	private int getLevelName(String s) {
		// System.out.println(s);
		switch (s) {
		case "初次测评":
			return 0;
		case "待提高":
			return 50;
		case "65(A)":
			return 65;
		case "75(B)":
			return 75;
		case "85(C)":
			return 85;
		case "95(D)":
			return 95;
		case "A":
			return 65;
		case "B":
			return 75;
		case "C":
			return 85;
		case "D":
			return 95;
		case "通关":
			return 100;
		default:
			return 0;
		}
	}

	/**
	 * get question_counts and judge_expression
	 * @param str  like "AABBXXXX"
	 * @param taken
	 * @return
	 */
	private String convertQuesSeq(String str, boolean taken) {
		Map<Character, Integer> m = new TreeMap<>();
		for (int i = 0; i < str.length(); i++) {
			char q = str.charAt(i);
			if (q == 'X') {
				continue;
			}
			if (m.containsKey(q)) {
				m.replace(q, m.get(q) + 1);
			} else {
				m.put(q, 1);
			}
		}
		String result = "";
		Iterator itr = m.entrySet().iterator();
		boolean first = true;
		if (taken) {
			while (itr.hasNext()) {
				if (first) {
					first = false;
				} else {
					result += " and ";
				}
				Map.Entry entry = (Map.Entry) itr.next();
				result = result + "#" + entry.getKey() + ">=" + entry.getValue();
			}
		} else {
			while (itr.hasNext()) {
				Map.Entry entry = (Map.Entry) itr.next();
				result = result + entry.getKey() + entry.getValue();
			}
		}
		if ("".equals(result)) {
			result = "true";
		}
		return result;
	}

	public void getSQL() throws IOException {
		String line;
		PrintWriter writer = new PrintWriter(output);

		for (int i = 0; i < grade.length; i++) {
			String g = grade[i];
			String s = subject[i];
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
			int levelOrder = 1;
			String previousTgScore = "";
			while ((line = br.readLine()) != null) {
				String[] components = line.split(",");
				String tgScore = components[0];
				String questionCounts = components[1];
				String judge = components[2];
				String nextTgScore = components[4];
				String topScore = components[5];

				if (tgScore.equals(previousTgScore)) {
					levelOrder++;
				} else {
					levelOrder = 1;
				}

				previousTgScore = tgScore;
				tgScore = getLevelName(tgScore) + "";
				questionCounts = convertQuesSeq(questionCounts, false);
				judge = convertQuesSeq(judge, true);
				nextTgScore = getLevelName(nextTgScore) + "";

				writer.println(getSingleSQL(levelOrder, g, s, tgScore,
						questionCounts, judge, nextTgScore, topScore));

				// System.out.println(getSingleSQL(levelOrder, g, s,
				// tgScore,questionCounts,judge,nextTgScore,topScore));
			}
			br.close();
		}
		System.out.println("get sql Success!");
		writer.close();

	}

	public static void main(String[] args) throws Exception {
		/*
		 * if (args.length != 4) 
		 * { throw new Exception("Wrong parameter number!"); } 
		 * String[] grade = args[0].split(","); String[] subject = args[1].split(","); 
		 * String csvFile = args[2]; 
		 * String output = args[3];
		 * if(grade.length!=subject.length)
		 * { throw new Exception("number of subject and grade not match!"); }
		 * System.out.println("Hello World!");
		 */
		System.out.println("====== get sql begin ======");
		/**
		 * 英语上/下 ：1/101  	String[] subject = { "101", "101", "101" };
		 * 科学上/下 ：2/102	String[] subject = { "102", "102", "102" };
		 * 数学上/下 ：3/103	String[] subject = { "103", "103", "103" };
		 * 物理上/下 ：5/105	String[] subject = { "105", "105", "105" };
		 * 化学上/下 ：6/106	String[] subject = { "106", "106", "106" };
		 */
		String[] grade = { "7", "8", "9" };
		String[] subject = { "102", "102", "102" };
		String csvFile = "F:/WorkSpace/Test/test/科学、物理、化学.csv";
		String output = "F:/WorkSpace/Test/test/初中科学.sql";
		SQLGenerator sg = new SQLGenerator(grade, subject, csvFile, output);

		sg.getSQL();

	}
}
