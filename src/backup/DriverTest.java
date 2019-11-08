package backup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import data.TotalData;

public class DriverTest {
	static int NUMB_OF_EPOCHS = 500;
	
	public static void main(String[] args) throws IOException {
		NeuralNetworkTest neuralNetworkTest = new NeuralNetworkTest();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		
		while(flag){
			System.out.println(">What do you want to do (run, train, no,  exit)  ?");
			String command = bufferedReader.readLine();
			
			switch (command) {
			case "run":
				System.out.println(">>>>>>DriverTest run");
				double[][] result = new double[TotalData.TRAININGTEST_DATA.length][TotalData.TRAININGTEST_DATA[0][1].length];
				for(int i=0;i<TotalData.TRAININGTEST_DATA.length;i++){
					for(int j=0;j<TotalData.TRAININGTEST_DATA[0][1].length;j++){
						result[i][j] = neuralNetworkTest.forwardprop(TotalData.TRAININGTEST_DATA[i][0]).getNeurons()[j+NeuralNetworkTest.INPUT_NEURONS+NeuralNetworkTest.HIDDEN_NEURONS].getOutput();
						}
				}
				printResult(result);
				break;
			case "train":
				for(int i=0;i<NUMB_OF_EPOCHS;i++){
					System.out.println("[epoch "+i+"]");
					for(int j=0;j<TotalData.TRAININGTEST_DATA.length;j++){
						for(int k=0;k<TotalData.TRAININGTEST_DATA[0][1].length;k++){
							neuralNetworkTest.forwardprop(TotalData.TRAININGTEST_DATA[j][0]).backpropError(TotalData.TRAININGTEST_DATA[j][1][k],k);
						}
					}
				}
				System.out.println("[done training]");
				break;
			case "no":
				System.out.println(">날짜, 회차를 입력하세요.");
				String Input01 = bufferedReader.readLine();
				String Input02 = bufferedReader.readLine();
				String Input03 = bufferedReader.readLine();
				String Input04 = bufferedReader.readLine();
				String Input05 = bufferedReader.readLine();
				String Input06 = bufferedReader.readLine();
				String Input07 = bufferedReader.readLine();
				String Input08 = bufferedReader.readLine();
				String Input09 = bufferedReader.readLine();
				String Input10 = bufferedReader.readLine();
				String Input11 = bufferedReader.readLine();
				String Input12 = bufferedReader.readLine();
				
				double Year01 = Double.parseDouble(Input01);
				double Year02 = Double.parseDouble(Input02);
				double Year03 = Double.parseDouble(Input03);
				double Year04 = Double.parseDouble(Input04);
				double Month01 = Double.parseDouble(Input05);
				double Month02 = Double.parseDouble(Input06);
				double Day01 = Double.parseDouble(Input07);
				double Day02 = Double.parseDouble(Input08);
				double Count01 = Double.parseDouble(Input09);
				double Count02 = Double.parseDouble(Input10);
				double Count03 = Double.parseDouble(Input11);
				double Count04 = Double.parseDouble(Input12);
				
				System.out.println(Input01+Input02+Input03+Input04+"년"+Input05+Input06+"월"+Input07+Input08+"일"+Input09+Input10+Input11+Input12+"회");
				double[][] TodayResult = new double[1][6];
				double TRAININGTEST_DATA[][][] = new double [][][]{
						{{Year01 , Year02, Year03, Year04, Month01, Month02, Day01, Day02, Count01, Count02, Count03, Count04}}
				};
				for(int j=0;j<6;j++){
					TodayResult[0][j] = neuralNetworkTest.forwardprop(TRAININGTEST_DATA[0][0]).getNeurons()[j+NeuralNetworkTest.INPUT_NEURONS+NeuralNetworkTest.HIDDEN_NEURONS].getOutput();
				}
				TodayprintResult(TodayResult);
				break;
			case "exit":
				flag=false;
				break;
			}
		}
		System.exit(0);
	}

	static void printResult(double[][] result){
		System.out.println("                                     INPUT                                       |                          TARGET                          |                         RESULT                          |");
		System.out.println("-----------------------------------------------------------------");

		for(int i=0;i<TotalData.TRAININGTEST_DATA.length;i++){
			for(int j=0;j<TotalData.TRAININGTEST_DATA[0][0].length;j++){
				System.out.print(TotalData.TRAININGTEST_DATA[i][0][j]+"  ");	//입력
				if(j == (NeuralNetworkTest.INPUT_NEURONS -1)){
					System.out.print(" | ");	
				}
			}
			for(int k=0;k<TotalData.TRAININGTEST_DATA[0][1].length;k++){
				System.out.print(TotalData.TRAININGTEST_DATA[i][1][k] + "  ");		//타겟
				if(k == (NeuralNetworkTest.OUTPUT_NEURONS -1)){
					System.out.print(" | ");
				}
			}
			for(int p=0;p<6;p++){
				System.out.print(String.format("%.2f", result[i][p])+ "  ");		//결과
			}
			System.out.println("");
		}
	}
	
	static void TodayprintResult(double[][] result){
		System.out.println("                                     INPUT                                       |                         RESULT                          |");
		System.out.println("-----------------------------------------------------------------");

			for(int j=0;j<TotalData.TRAININGTEST_DATA[0][0].length;j++){
				System.out.print(TotalData.TRAININGTEST_DATA[0][0][j]+"  ");	//입력
				if(j == (NeuralNetworkTest.INPUT_NEURONS -1)){
					System.out.print(" | ");	
				}
			}
			for(int p=0;p<6;p++){
				System.out.print(String.format("%.2f", result[0][p])+ "  ");		//결과
			}
			System.out.println("");
	}
	
}
