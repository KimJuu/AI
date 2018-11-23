package data;




public class TotalData {
	
	//Input : 연월일, 회차   ||  Output : 당첨번호
	//TotalData.Data	[전체갯수]		[0 : 입력, 1 : 출력]		[값]
	public static double[][][] Data = {
		//{{2,0,1,8,1,1,1,0,0,8,3,2},{13,14,19,26,40,43,30}},
		{{2,0,1,8,1,1,0,3,0,8,3,1},{0.3,0.10,0.16,0.19,0.31,0.39,0.9}}
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
		{	{4,0,2,7}	,	{0.27,0.42,0.32}},
		{	{0,6,3,8}	,	{0.08,0.11,0.24}},
		{	{1,5,4,2}	,	{0.09, 0.38,0.45}},
		{	{1,1,5,0}	,	{0.1, 0.32, 0.37}}
		};
}
