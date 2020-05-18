package Main;

import javax.swing.JOptionPane;

public class main {
	public static void main(String[] args) {
		
			hi();
			
		}
	static int cnt = 3;
	static int count = 0;
	static int total = 0;
	static String[] YN = {"Yes","No"};
	static String[] DK = {"Next","First","Equal","Exit"};
	static String[][] deck = {{"1 heart","1 spade","1 clubs","1 diamond"},{"2 heart","2 spade","2 clubs","2 diamond"},{"3 heart","3 spade","3 clubs","3 diamond"},{"4 heart","4 spade","4 clubs","4 diamond"},{"5 heart","5 spade","5 clubs","5 diamond"},{"6 heart","6 spade","6 clubs","6 diamond"},{"7 heart","7 spade","7 clubs","7 diamond"},{"8 heart","8 spade","8 clubs","8 diamond"},{"9 heart","9 spade","9 clubs","9 diamond"},{"10 heart","10 spade","10 clubs","10 diamond"},{"J heart","J spade","J clubs","J diamond"},{"Q heart","Q spade","Q clubs","Q diamond"},{"K heart","K spade","K clubs","K diamond",}};
	static String[][] deck2 = {{"1 heart","1 spade","1 clubs","1 diamond"},{"2 heart","2 spade","2 clubs","2 diamond"},{"3 heart","3 spade","3 clubs","3 diamond"},{"4 heart","4 spade","4 clubs","4 diamond"},{"5 heart","5 spade","5 clubs","5 diamond"},{"6 heart","6 spade","6 clubs","6 diamond"},{"7 heart","7 spade","7 clubs","7 diamond"},{"8 heart","8 spade","8 clubs","8 diamond"},{"9 heart","9 spade","9 clubs","9 diamond"},{"10 heart","10 spade","10 clubs","10 diamond"},{"J heart","J spade","J clubs","J diamond"},{"Q heart","Q spade","Q clubs","Q diamond"},{"K heart","K spade","K clubs","K diamond",}};
	
	public static void hi() {
		JOptionPane.showMessageDialog(null, "Welcome to the High and Low Game, you have three chances to get things wrong. Try and guess if the next card is higher, lower, or equal. You win by guessing 6 questions right before your losees are up.");
		while(cnt >0) {
			
				int a = (int)(Math.random()*13);
				int b = (int)(Math.random()*4);
				int c = (int)(Math.random()*13);
				int d = (int)(Math.random()*4);
				int s  = JOptionPane.showOptionDialog(null, "Guess if the next card is higher? " + deck[a][b] ,"Losses left: " + cnt + " Correct: " + count,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,DK,null);
				
				if(s == 1) {
					if(a <c) {
						JOptionPane.showMessageDialog(null, "Correct, next one..");
						count = count + 1;
						
						deck[a][b] = deck2[c][d];
						total = total +1;
						
					}
					else if(a>c) {
						cnt = cnt-1;
						total = total +1;
						deck[a][b] = deck2[c][d];
						JOptionPane.showMessageDialog(null, "Wrong, next one..");
					}
					else if(c == a) {
						total = total +1;
						deck[a][b] = deck2[c][d];
						JOptionPane.showMessageDialog(null, "They are equal, no point, next one..");
					}
					
				}
				if(s==0) {
					if(a>c ) {
						count = count + 1;
						total = total +1;
						deck2[c][d] = deck[a][b];
						JOptionPane.showMessageDialog(null, "Correct, next one..");
					
					}
					else if(a< c) {
						cnt = cnt-1;
						total = total +1;
						deck[a][b] = deck2[c][d];
						JOptionPane.showMessageDialog(null, "Wrong, next one..");
					}
					else if(c == a) {
						total = total +1;
						deck[a][b] = deck2[c][d];
						JOptionPane.showMessageDialog(null, "They are equal, no point, next one..");
					}
				}
				if(s== 2) {
					if(c == a) {
						total = total +1;
						deck[a][b] = deck2[c][d];
						JOptionPane.showMessageDialog(null, "They are equal, no point, next one..");
					}
					else {
						total = total +1;
						deck[a][b] = deck2[c][d];
						JOptionPane.showMessageDialog(null, "They are not equal, no point, next one..");
					}
				}
				if(s==3) {
					System.exit(0);
				}
				if(count == 6) {
					int g  = JOptionPane.showOptionDialog(null, "You Won, You got: " + count + " correct. " + "Would you like to play again","High and Low",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,YN,null);
					if(g==0) {
						cnt = cnt+3;
						count = 0;
						total = 0;
						hi();
					}
					if(g==1) {
						
						JOptionPane.showMessageDialog(null, "Thanks for playing, goodbye...");
						System.exit(0);
					}
				}
			}
		
		if(cnt == 0 &&count <6) {
			
			int s  = JOptionPane.showOptionDialog(null, "Unfortunately, you lost, You got: " + count + " correct. " + "You have lost 3 times, yout current game has ended, would you like to play again","High and Low",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,YN,null);
			if(s==0) {
				cnt = cnt+3;
				count = 0;
				total = 0;
				hi();
			}
			if(s==1) {
				
				JOptionPane.showMessageDialog(null, "Thanks for playing, goodbye...");
				System.exit(0);
			}
		}
		}
	}