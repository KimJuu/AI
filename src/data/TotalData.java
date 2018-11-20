package data;



public class TotalData {
	
	//Input : 연월일, 회차   ||  Output : 당첨번호
	public static double[][][] Data = {
		{{2,0,1,8,1,1,1,0,0,8,3,2},{13,14,19,26,40,43}},
		{{2,0,1,8,1,1,0,3,0,8,3,1},{3,10,16,19,31,39}}
	};
	public static double TRAINING_DATA[][][] = new double [][][] {{{10,0},{1}},
		{{0,5},{1}},
		{{1,10},{1}},
		{{1,1},{0}}
		};
}
