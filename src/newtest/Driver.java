package newtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import data.TotalData;

public class Driver {
	static int NUMB_OF_EPOCHS = 100000;
	
	public static void main(String[] args) throws IOException {
		NeuralNetwork neuralNetwork = new NeuralNetwork();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		
		while(flag){
			System.out.println("학습횟수입력 * 10000");
			int NUMB_OF_EPOCHS = Integer.parseInt(bufferedReader.readLine());
			int back_count = 1;
			
			for(int i=0;i<NUMB_OF_EPOCHS * 10000;i++){
				for(int j=0;j<TotalData.TRAININGTEST_DATA.length;j++){
					for(int k=0;k<TotalData.TRAININGTEST_DATA[0][1].length;k++){
						neuralNetwork.forwardprop(TotalData.TRAININGTEST_DATA[j][0]).backpropError(TotalData.TRAININGTEST_DATA[j][1][k],k);
					}
				}
				if(i == back_count * 50000) {
					double[][] result = new double[TotalData.TRAININGTEST_DATA.length][TotalData.TRAININGTEST_DATA[0][1].length];
					for(int a=0;a<TotalData.TRAININGTEST_DATA.length;a++){
						for(int b=0;b<TotalData.TRAININGTEST_DATA[0][1].length;b++){
							result[a][b] = neuralNetwork.forwardprop(TotalData.TRAININGTEST_DATA[a][0]).getNeurons()[b+NeuralNetwork.INPUT_NEURONS+NeuralNetwork.HIDDEN_NEURONS].getOutput();
							}
					}
					printResult(result);

					double[][] TodayResult = new double[1][6];
					double TRAININGTEST_DATA[][][] = new double [][][]{
							{{2,0,1,9, 1,1,0,9, 8,8,4},{}}
					};
					for(int j=0;j<6;j++){
						TodayResult[0][j] = neuralNetwork.forwardprop(TRAININGTEST_DATA[0][0]).getNeurons()[j+NeuralNetwork.INPUT_NEURONS+NeuralNetwork.HIDDEN_NEURONS].getOutput();
					}
					
					TodayprintResult(TodayResult, TRAININGTEST_DATA);
					
					back_count ++;
				}
			}
		}
	}

	static void printResult(double[][] result){
		System.out.println("                                     INPUT                                       |                          TARGET                          |                         RESULT                          |");
		System.out.println("-----------------------------------------------------------------");

		for(int i=0;i<TotalData.TRAININGTEST_DATA.length;i++){
			for(int j=0;j<TotalData.TRAININGTEST_DATA[0][0].length;j++){
				System.out.print(TotalData.TRAININGTEST_DATA[i][0][j]+"  ");	//�엯�젰
				if(j == (NeuralNetwork.INPUT_NEURONS -1)){
					System.out.print(" | ");	
				}
			}
			for(int k=0;k<TotalData.TRAININGTEST_DATA[0][1].length;k++){
				System.out.print(TotalData.TRAININGTEST_DATA[i][1][k] + "  ");		//��寃�
				if(k == (NeuralNetwork.OUTPUT_NEURONS -1)){
					System.out.print(" | ");
				}
			}
			for(int p=0;p<6;p++){
				System.out.print(String.format("%.2f", result[i][p])+ "  ");		//寃곌낵
			}
			System.out.println("");
		}
	}
	
	static void TodayprintResult(double[][] result, double[][][] data){
		System.out.println("                                     INPUT                                       |                         RESULT                          |");
		System.out.println("-----------------------------------------------------------------");

			for(int j=0;j<TotalData.TRAININGTEST_DATA[0][0].length;j++){
				System.out.print(data[0][0][j]+"  ");	//�엯�젰
				if(j == (NeuralNetwork.INPUT_NEURONS -1)){
					System.out.print(" | ");	
				}
			}
			for(int p=0;p<6;p++){
				System.out.print(String.format("%.2f", result[0][p])+ "  ");		//寃곌낵
			}
			System.out.println("");
	}
	
}
