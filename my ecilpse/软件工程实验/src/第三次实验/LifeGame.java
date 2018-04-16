package ������ʵ��;
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
    final JMenuItem zhuan = options.add("ש��");
    zhuan.addActionListener(frame.new ZhuanActionListener()); 
    final JMenuItem feng = options.add("����");
    feng.addActionListener(frame.new FengActionListener());
    final JMenuItem zha = options.add("գ����");
    zha.addActionListener(frame.new ZhaActionListener());
    final JMenuItem deng = options.add("����");
    deng.addActionListener(frame.new DengActionListener()); 
    final JMenuItem yikk = options.add("һ����");
    yikk.addActionListener(frame.new YiActionListener()); 
    final JMenuItem erkk = options.add("������");
    erkk.addActionListener(frame.new ErActionListener()); 
    final JMenuItem wan = options.add("�����");
    wan.addActionListener(frame.new WanActionListener());
    final  JMenuItem shui = options.add("ˮ��ͷ");
    shui.addActionListener(frame.new ShuiActionListener()); 
    final JMenuItem hua = options.add("�����");
    hua.addActionListener(frame.new HuaActionListener()); 
    final JMenuItem hua_fa = options.add("�����������");
    hua_fa.addActionListener(frame.new Hua_faActionListener());        
    final JMenuItem rand = options.add("���");
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
    final JMenuItem hel = help.add("����");
    hel.addActionListener(frame.new HelpActionListener());              
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1007, 859);
    final int windowWidth = frame.getWidth(); //��ô��ڿ�
    final int windowHeight = frame.getHeight(); //��ô��ڸ�
    final Toolkit kit = Toolkit.getDefaultToolkit(); //���幤�߰�
    final Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�
    final int screenWidth = screenSize.width; //��ȡ��Ļ�Ŀ�
    final int screenHeight = screenSize.height; //��ȡ��Ļ�ĸ�
    frame.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//���ô��ھ�����ʾ               
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
    JOptionPane.showMessageDialog(frame,"1.style  ����  ѡ����ʽ\n\n2.speed  ����  ��ѡ�仯�ٶ�\n\n3.help  ����  ��ʾ����\n");
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
