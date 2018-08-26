package csvs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.lang3.RandomStringUtils;

/* 参考ページ
 * 1. http://tech.pjin.jp/blog/2017/10/17/【java】csv出力のサンプルコード/
 * 2. http://garapon.hatenablog.com/entry/20090224/1235460950
 * 3. https://builder.japan.zdnet.com/java/sp_java-commons-lang-2008/20378454/
 * 4. http://commons.apache.org/proper/commons-lang/download_lang.cgi
 * ↑ここからライブラリダウンロード
*/

public class GenCsvs {

	public static void main(String[] args) {
		// 行列サイズ
		int numOfRows = 1000;
		int numOfCols = 1000;
		//出力先
		String preout = "/Users/koheimachida/Downloads/csvs/";
		//データ値の文字列の長さ
		int dSize = 10;
		//csvファイル名
		String fileName = "test";

		//ファイル数
		int numOfFiles = 10000;

		for(int i=0; i<numOfFiles; i++ ){
			exportCsv(preout, fileName+String.valueOf(i), numOfRows, numOfCols, dSize);
		}
	}

	public static void exportCsv(String path, String csvName, int rows, int cols, int dataSize) {

		try {

			String dirPath = path + csvName + ".csv";

			// 出力ファイルの作成
			FileWriter f = new FileWriter(dirPath, false);
			PrintWriter p = new PrintWriter(new BufferedWriter(f));

			// ヘッダー(カラム)を指定する
			for (int i = 0; i < cols; i++) {
				p.print("colmun" + i);
				if (i != cols - 1) {
					p.print(",");
				}

			}
			p.println();

			// データ値をセットする
			for (int j = 0; j < rows; j++) {
				for (int k = 0; k < cols; k++) {
					// ランダムな文字列を生成する
					p.print(RandomStringUtils.randomAlphabetic(dataSize));
					if (k != cols - 1) {
						p.print(",");
					}
				}
				p.println(); // 改行
			}

			// ファイルに書き出し閉じる
			p.close();

			System.out.println("ファイル出力完了！");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
