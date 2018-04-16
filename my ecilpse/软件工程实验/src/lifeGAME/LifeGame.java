package lifeGAME;

import javax.swing.*;


public class LifeGame extends JFrame{
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	    LifeGame game = new LifeGame(); 
	    game.setSize(600,580);  
        game.setTitle("生命游戏[LifeGame]DEMO");  
        game.add(new WorldMap());  
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        game.setLocationRelativeTo(null);  
        game.setResizable(false);  
        game.setVisible(true); 
	}
}
