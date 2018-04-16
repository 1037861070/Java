package 第三次实验;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LifeGame extends JFrame{

private final World world;
	
	public LifeGame(int rows, int columns)
	{
		world = new World(rows, columns);
		 new  Thread(world).start();
		add(world);		
	}
	
  public static void main(String[] args) {
    final LifeGame frame = new LifeGame(40, 50);
    final  JMenuBar menu = new JMenuBar();
    frame.setJMenuBar(menu);       
    final JMenu options = new JMenu("Style");
    menu.add(options);  
    final  JMenuItem arrow = options.add("Arrow");
    arrow.addActionListener(frame.new ArrowActionListener()); 
    final JMenuItem square = options.add("Square");
    square.addActionListener(frame.new SquareActionListener());          
    final JMenuItem zhuan = options.add("砖块");
    zhuan.addActionListener(frame.new ZhuanActionListener()); 
    final JMenuItem feng = options.add("蜂窝");
    feng.addActionListener(frame.new FengActionListener());
    final JMenuItem zha = options.add("眨眼者");
    zha.addActionListener(frame.new ZhaActionListener());
    final JMenuItem deng = options.add("灯塔");
    deng.addActionListener(frame.new DengActionListener()); 
    final JMenuItem yikk = options.add("一字型");
    yikk.addActionListener(frame.new YiActionListener()); 
    final JMenuItem erkk = options.add("两竖列");
    erkk.addActionListener(frame.new ErActionListener()); 
    final JMenuItem wan = options.add("顽固者");
    wan.addActionListener(frame.new WanActionListener());
    final  JMenuItem shui = options.add("水龙头");
    shui.addActionListener(frame.new ShuiActionListener()); 
    final JMenuItem hua = options.add("滑翔机");
    hua.addActionListener(frame.new HuaActionListener()); 
    final JMenuItem hua_fa = options.add("滑翔机发射器");
    hua_fa.addActionListener(frame.new Hua_faActionListener());        
    final JMenuItem rand = options.add("随机");
    rand.addActionListener(frame.new RandActionListener()); 
    final JMenu speed = new JMenu("Speed");        
    menu.add(speed);
    final JMenuItem low = speed.add("Low");
    low.addActionListener(frame.new LowActionListener());
    final JMenuItem mid = speed.add("Mid");
    mid.addActionListener(frame.new MidActionListener()); 
    final JMenuItem high = speed.add("High");
    high.addActionListener(frame.new HighActionListener()); 
    final JMenu help = new JMenu("Help");        
    menu.add(help);
    final JMenuItem hel = help.add("帮助");
    hel.addActionListener(frame.new HelpActionListener());              
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1007, 859);
    final int windowWidth = frame.getWidth(); //获得窗口宽
    final int windowHeight = frame.getHeight(); //获得窗口高
    final Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
    final Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
    final int screenWidth = screenSize.width; //获取屏幕的宽
    final int screenHeight = screenSize.height; //获取屏幕的高
    frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示               
    frame.setTitle("Game of Life");
    frame.setVisible(true);
    frame.setResizable(false);
    }
	
	class ArrowActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
    world.setArrow();
    }
    }
    
    class SquareActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
   	world.setSquare();
    }
    } 
    
    class ZhuanActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    world.setZhuan();
    }
    }
    
    class FengActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    world.setFeng();
    }
    }
    
    class ZhaActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
   	world.setZha();
    }
    }
    
    class DengActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    world.setDeng();
    }
    }
    
    class YiActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    world.setYi();
    }
    }
    
    class ErActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    world.setEr();
    }
    }
    
    class WanActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    world.setWan();
    }
    }
    
    class ShuiActionListener implements ActionListener{
   	public void actionPerformed(ActionEvent e){
    world.setShui();
    }
    }
    
    class HuaActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    world.setHua();
    }
    }
    
    class Hua_faActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    world.setHua_fa();
    }
    }
    
    class RandActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    world.setRand();
    }
    }
    
    class HelpActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    final JFrame frame = new JFrame();
    JOptionPane.showMessageDialog(frame,"1.style  ——  选择样式\n\n2.speed  ——  挑选变化速度\n\n3.help  ——  显示帮助\n");
    }
    }
    
    class LowActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
   	world.setSpeed(1000);
    }
    }
    
    class MidActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
    world.setSpeed(500);
    }
    }
    
    class HighActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
   	world.setSpeed(100);
    }
    }
}
