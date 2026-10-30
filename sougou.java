import static java.lang.System.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//①メニュー画面
public class sougou{
	public static void main(String[] args){
		out.print("----メニュー----\n１．夕食の候補一覧\n２．献立決定機能\n３．検索機能\n４．終了\n");
		String[] dinner = {"うどん","カレー","オムライス","ステーキ","ハンバーグ","とうふステーキ","とんかつ","親子丼","からあげ","鮭の塩焼き"};
		String [] dinnerRecipe ={"うどんのレシピ\n①冷凍うどんをレンジで温める。\n②うどんにめんつゆをかける\n③ねぎ、かつお節、丸天をのせてできあがり。"
		 ,"カレーのレシピ\n①野菜を切る。\n②ルーを作る\n③煮る。\n④混ぜてできあがり。"
		 ,"オムライスのレシピ\n①玉ねぎと鶏肉を小さく切る。\n②フライパンで炒めてご飯を加える\n③ケチャップで味付けして皿に盛る。\n④卵を焼いてご飯にのせてできあがり。"
		 ,"ステーキのレシピ\n①牛肉を室温に戻す。\n②塩とこしょうで下味をつける。\n③フライパンで両面を焼く。\n④ソースをかけてできあがり。"
		 ,"ハンバーグのレシピ\n①玉ねぎを炒めて冷ます。\n②ひき肉、パン粉、卵を混ぜて形を作る。\n③フライパンで焼く。\n④ソースをかけてできあがり。"
		 ,"とうふステーキのレシピ\n①木綿豆腐を水切りする。\n②豆腐に片栗粉をまぶす。\n③フライパンで焼いてたれをかける。\n④醤油やポン酢をかけてできあがり。"
		 ,"とんかつのレシピ\n①豚肉に塩こしょうをふる。\n②小麦粉、卵、パン粉を順につける。\n③油で揚げる。\n④ソースをかけてできあがり。"
		 ,"親子丼のレシピ\n①鶏肉と玉ねぎを切る。\n②だし、しょうゆ、みりんで煮る。\n③溶き卵を流し入れて火を止める。\n④ご飯にかけてできあがり。"
		 ,"からあげのレシピ\n①鶏肉を一口大に切る。\n②しょうゆ、にんにく、しょうがで下味をつける。\n③片栗粉をまぶして油で揚げる。\n④盛りつけてできあがり。"
		 ,"鮭の塩焼きのレシピ\n①鮭の身に塩を振り５分おく。\n②フライパンにサラダ油をひき、中火で身の両面を焼く。\n③大さじ１の酒を振り、ふたをして１分間蒸し焼きにして完成。"};

		while(true){
			out.print("数値を入力してください＞");
			int x = new java.util.Scanner(System.in).nextInt();
			switch(x){
				case 1:
					dinner(dinner,dinnerRecipe);
					break;
				case 2:
					menuDecision(dinner,dinnerRecipe);
					break;
				case 3:
					Kensaku(dinner,dinnerRecipe);
					break;
			}
			if(x == 4){
				out.println("プログラムを終了します。");
				break;
			}
			out.print("適切な数値を入力してください\n");
		}
	}
	
	
	
	//②夕食の候補一覧
	public static void dinner(String[]dinner,String [] dinnerRecipe){
	   int i;
	   out.println("----夕食の候補----");
	   for(i=0;i<dinner.length;i++){
		   out.println((i+1)+":"+dinner[i]);
	   }
	   out.print("メニューのレシピが知りたい場合は、それに該当するメニューの番号を入力してください。\n番号を選択(終了する場合は11を入力)>");
	   int a=new java.util.Scanner(System.in).nextInt();
	   boolean s = true;
	   while(s){
		   if(a==i ||a!=11){
			   String Menu = dinner[a-1];
			   a(dinner[a-1],dinnerRecipe[a-1]);
			   break;
		   }else if(a == 11){
		   	   out.println("プログラムを終了します。");
			   break;
		   }else{
		      out.println("適切な数値を入力してください。");
		      break;
		   }
	   }
   }
   
   
   
	//③献立決定機能
    public static void menuDecision(String[] dinner,String [] dinnerRecipe){
		out.println("----献立決定機能----");
	    char[] week = {'日','月','火','水','木','金','土'};
		String[] menuMemory = new String[week.length];
		boolean overlap = false;
		do{                                         //1週間の献立が重複しなくなるまでランダム抽選
			overlap = false;
	        for(int i = 0;i<week.length;i++){
		        int r = new java.util.Random().nextInt(dinner.length);
			    menuMemory[i] = dinner[r];
	        }
		    for(int i = 0;i<menuMemory.length;i++){
			    for(int j = i+1;j<menuMemory.length;j++){
			    	if(menuMemory[i] == menuMemory[j]){
			    		overlap = true;
				    }
		    	}
    		}
		}while(overlap);
		for(int i = 0;i<week.length;i++){
		    out.println(i+1+":"+week[i]+"曜日は"+menuMemory[i]);
	    }
		out.println("\n知りたいメニューのレシピがある場合は、それに該当するレシピの番号を\n入力してください。");
		int number = 0;
		do{
		    out.print("番号を選択（終了する場合は8を入力）＞");
		    number = new java.util.Scanner(System.in).nextInt();
			if(number > 8){
				out.println("適切な数値を入力してください。");
			}
		}while(number > 8);
		if(number != 8){
			for(int i = 0;i<dinner.length;i++){
				if(menuMemory[number-1].equals(dinner[i])){
					a(dinner[i],dinnerRecipe[i]);
					break;
				}
			}
		}
	}
	
	
	
	//④検索機能
	public static void Kensaku(String[] dinner,String [] dinnerRecipe){
		out.println("----検索機能----");
		int i=0;
		String kekka=" ";
		String x="y";
		boolean flug=true;
		boolean flug2=true;
		while(flug==true){
			flug=true;
			i=0;
			if(x.equals("y")){
			    out.print("キーワードを入力してください。＞");
		        String kekka2=new java.util.Scanner(System.in).nextLine();
				kekka=kekka2;
		        while(i<dinner.length && flug==true){
			        if(kekka.equals(dinner[i])){
		                System.out.println("＜検索結果＞\n"+kekka);
			            flug=false;	
				        flug2=false;
			        }i=i+1;
		        }
			}else if(x.equals("n")){
				    flug=false;
		    }if(flug==true){
				    out.print("＜検索結果＞\n検索結果はありませんでした\n検索を続行しますか？(y/n)＞");
				    String z=new java.util.Scanner(System.in).nextLine();
				    x=z;
					while (!(x.equals("y") || x.equals("n"))){
				 	 out.print("yかnを入力してください\n検索を続行しますか？(y/n)＞");
					 String y=new java.util.Scanner(System.in).nextLine();
					 x=y;
					}
		    }
		}
		if(flug2==false){
		 out.print("レシピが知りたい場合は１を入力してください。\n番号を選択（終了する場合は２を入力）＞");
		  int sentaku=new java.util.Scanner(System.in).nextInt();
		  while(sentaku<1 || sentaku>2){
				System.out.print("適切な数値を入力してください\n番号を選択（終了する場合は２を入力）＞");
				int sentaku2=new java.util.Scanner(System.in).nextInt();
				sentaku=sentaku2;
		  }if(sentaku==1){	
	           a(dinner[i-1],dinnerRecipe[i-1]);
		  }else if(sentaku==2){
			   out.println("プログラムを終了します。");
		  }
		}
	}

	//⑤レシピ表示 & テキストファイル出力
	public static void a(String Menu,String Recipe2){
	    out.print("----レシピ----\n"+Menu+"のレシピを表示します\n"
		          +Recipe2+
				  "\nレシピをテキストファイルとして出力しますか？（ｙ/ｎ）＞");
		String text = new java.util.Scanner(System.in).nextLine();
		boolean a = true;
		while(a){
		  if(text.equals("y")){
			  try {
                  // FileWriterクラスのオブジェクトを生成する
                  FileWriter file = new FileWriter("Recipe.txt");
                  // PrintWriterクラスのオブジェクトを生成する
                  PrintWriter pw = new PrintWriter(new BufferedWriter(file));
                  //ファイルに書き込む
			      pw.println(Recipe2);
                  //ファイルを閉じる
                  pw.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
			   out.print("レシピをRecipe.txtに出力しました。\nプログラムを終了します。");
			   break;
		 	}else if(text.equals("n")){
				out.print("プログラムを終了します。");
				break;
			}else{
		 	   out.println("ｙかｎを入力してください");
			   out.print("レシピをテキストファイルとして出力しますか？（ｙ/ｎ）＞");
		       String text2 = new java.util.Scanner(System.in).nextLine();
			   text = text2;
		    }
		 }
	}
}