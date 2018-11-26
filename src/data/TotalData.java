package data;




public class TotalData {
	
	//Input : 연월일, 회차   ||  Output : 당첨번호
	//TotalData.Data	[전체갯수]		[0 : 입력, 1 : 출력]		[값]
	public static double[][][] Data = {
		//{{2,0,1,8,1,1,1,0,0,8,3,2},{13,14,19,26,40,43,30}},
		{{2,0,1,8,1,1,2,4,0,8,3,4},{0.06,0.08,0.18,0.35,0.42,0.43,0.03}}
	};
	
	/*				System.out.println("--------------------------first---------------------------");
	System.out.println("totaldata.Data[0][0][0] " +TotalData.Data[0][0][0]);
	System.out.println("totaldata.Data[0][0][1] " +TotalData.Data[0][0][1]);
	System.out.println("totaldata.Data[0][0][2] " +TotalData.Data[0][0][2]);
	System.out.println("totaldata.Data[0][0][3] " +TotalData.Data[0][0][3]);
	System.out.println("totaldata.Data[0][0][4] " +TotalData.Data[0][0][4]);
	System.out.println("totaldata.Data[0][0][5] " +TotalData.Data[0][0][5]);
	System.out.println("totaldata.Data[0][0][6] " +TotalData.Data[0][0][6]);
	System.out.println("totaldata.Data[0][0][7] " +TotalData.Data[0][0][7]);
	System.out.println("totaldata.Data[0][0][8] " +TotalData.Data[0][0][8]);
	System.out.println("totaldata.Data[0][0][9] " +TotalData.Data[0][0][9]);
	System.out.println("totaldata.Data[0][0][10] " +TotalData.Data[0][0][10]);
	System.out.println("totaldata.Data[0][0][11] " +TotalData.Data[0][0][11]);
	System.out.println("---------------------------------------------------------");
	
	System.out.println("totaldata.Data[0][1][0] " +TotalData.Data[0][1][0]);
	System.out.println("totaldata.Data[0][1][1] " +TotalData.Data[0][1][1]);
	System.out.println("totaldata.Data[0][1][2] " +TotalData.Data[0][1][2]);
	System.out.println("totaldata.Data[0][1][3] " +TotalData.Data[0][1][3]);
	System.out.println("totaldata.Data[0][1][4] " +TotalData.Data[0][1][4]);
	System.out.println("totaldata.Data[0][1][5] " +TotalData.Data[0][1][5]);
	System.out.println("totaldata.Data[0][1][6] " +TotalData.Data[0][1][6]);
	System.out.println("------------------------first end-------------------------");
	System.out.println("------------------------second--------------------------");
	System.out.println("totaldata.Data[1][0][0] " +TotalData.Data[1][0][0]);
	System.out.println("totaldata.Data[1][0][1] " +TotalData.Data[1][0][1]);
	System.out.println("totaldata.Data[1][0][2] " +TotalData.Data[1][0][2]);
	System.out.println("totaldata.Data[1][0][3] " +TotalData.Data[1][0][3]);
	System.out.println("totaldata.Data[1][0][4] " +TotalData.Data[1][0][4]);
	System.out.println("totaldata.Data[1][0][5] " +TotalData.Data[1][0][5]);
	System.out.println("totaldata.Data[1][0][6] " +TotalData.Data[1][0][6]);
	System.out.println("totaldata.Data[1][0][7] " +TotalData.Data[1][0][7]);
	System.out.println("totaldata.Data[1][0][8] " +TotalData.Data[1][0][8]);
	System.out.println("totaldata.Data[1][0][9] " +TotalData.Data[1][0][9]);
	System.out.println("totaldata.Data[1][0][10] " +TotalData.Data[1][0][10]);
	System.out.println("totaldata.Data[1][0][11] " +TotalData.Data[1][0][11]);
	System.out.println("---------------------------------------------------------");
	
	System.out.println("totaldata.Data[1][1][0] " +TotalData.Data[1][1][0]);
	System.out.println("totaldata.Data[1][1][1] " +TotalData.Data[1][1][1]);
	System.out.println("totaldata.Data[1][1][2] " +TotalData.Data[1][1][2]);
	System.out.println("totaldata.Data[1][1][3] " +TotalData.Data[1][1][3]);
	System.out.println("totaldata.Data[1][1][4] " +TotalData.Data[1][1][4]);
	System.out.println("totaldata.Data[1][1][5] " +TotalData.Data[1][1][5]);
	System.out.println("totaldata.Data[1][1][6] " +TotalData.Data[1][1][6]);
	System.out.println("----------------------second end-----------------------");*/
	
	public static double TRAINING_DATA[][][] = new double [][][] {
		{{10,0,2},{0.220,0.450}},
		{{0,5,3},{0.300,0.020}},
		{{1,10,4},{0.340, 0.030}},
		{{1,1,5},{0.150, 0.320}}
		};
	
	/*
	 *train 
[epoch 9999]
[(I: 10.00), (I: 0.00), (H, 0.63, 7.91, -10.89, 0.96477), (H, -1.07, 2.83, 1.89, 0.00255), (O, 12.67, -8.30, 0.56, 0.98890)]
[(I: 0.00), (I: 5.00), (H, 0.63, 7.92, -10.89, 0.88384), (H, -1.07, 2.83, 1.89, 0.99994), (O, 12.67, -8.30, 0.56, 0.98859)]
[(I: 1.00), (I: 10.00), (H, 0.63, 7.92, -10.89, 0.99953), (H, -1.07, 2.83, 1.89, 1.00000), (O, 12.67, -8.30, 0.56, 0.99734)]
[(I: 1.00), (I: 1.00), (H, 0.63, 7.91, -10.89, 0.20728), (H, -1.07, 2.83, 1.89, 0.99053), (O, 12.67, -8.30, 0.56, 0.01603)]

	 * run
    Input 1     |     Input 2     |     Target Result     |     Result     
-----------------------------------------------------------------
    10.0     |          0.0     |          1.0     |     0.98890     
    0.0     |          5.0     |          1.0     |     0.98859     
    1.0     |          10.0     |          1.0     |     0.99734     
    1.0     |          1.0     |          0.0     |     0.01598     
    
    */
	
	public static double TRAININGTEST_DATA[][][] = new double [][][] {
		{{2,0,1,8, 1,1,2,4, 0,8,3,4},{0.06,0.08,0.18,0.35,0.42,0.43}},
		{{2,0,1,8, 1,1,1,7, 0,8,3,3},{0.12,0.18,0.30,0.39,0.41,0.42}},
		{{2,0,1,8, 1,1,1,0, 0,8,3,2},{0.13,0.14,0.19,0.26,0.40,0.43}},
		{{2,0,1,8, 1,1,0,3, 0,8,3,1},{0.03,0.10,0.16,0.19,0.31,0.39}},
		{{2,0,1,8, 1,0,2,7, 0,8,3,0},{0.05,0.06,0.16,0.18,0.37,0.38}},
		{{2,0,1,8, 1,0,2,0, 0,8,2,9},{0.04,0.05,0.31,0.35,0.43,0.45}},
		{{2,0,1,8, 1,0,1,3, 0,8,2,8},{0.04,0.07,0.13,0.29,0.31,0.39}},
		{{2,0,1,8, 1,0,0,6, 0,8,2,7},{0.05,0.11,0.12,0.29,0.33,0.44}},
		{{2,0,1,8, 0,9,2,9, 0,8,2,6},{0.13,0.16,0.24,0.25,0.33,0.36}},
		{{2,0,1,8, 0,9,2,2, 0,8,2,5},{0.08,0.15,0.21,0.31,0.33,0.38}}

		};
	/*
	{{2,0,1,8, 1,1,2,4, 0,8,3,4},{0.06,0.08,0.18,0.35,0.42,0.43}},
	{{2,0,1,8, 1,1,1,7, 0,8,3,3},{0.12,0.18,0.30,0.39,0.41,0.42}},
	{{2,0,1,8, 1,1,1,0, 0,8,3,2},{0.13,0.14,0.19,0.26,0.40,0.43}},
	{{2,0,1,8, 1,1,0,3, 0,8,3,1},{0.03,0.10,0.16,0.19,0.31,0.39}},
	{{2,0,1,8, 1,0,2,7, 0,8,3,0},{0.05,0.06,0.16,0.18,0.37,0.38}},
	{{2,0,1,8, 1,0,2,0, 0,8,2,9},{0.04,0.05,0.31,0.35,0.43,0.45}},
	{{2,0,1,8, 1,0,1,3, 0,8,2,8},{0.04,0.07,0.13,0.29,0.31,0.39}},
	{{2,0,1,8, 1,0,0,6, 0,8,2,7},{0.05,0.11,0.12,0.29,0.33,0.44}},
	{{2,0,1,8, 0,9,2,9, 0,8,2,6},{0.13,0.16,0.24,0.25,0.33,0.36}},
	{{2,0,1,8, 0,9,2,2, 0,8,2,5},{0.08,0.15,0.21,0.31,0.33,0.38}}*/
}
