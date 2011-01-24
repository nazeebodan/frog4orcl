/**
 * 
 */
package com.frog4orcl.framework;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

/**
 * @说明:
 * @author: dandan
 * @email: xrzp_dh@yahoo.com.cn
 * @create date:Jan 5, 2011 2:29:35 PM
 * @version: 1.0
 */
public class Test1 extends ApplicationFrame {

	public Test1(String s) {
		super(s);
		setContentPane(createDemoPanel());
	}

	// 生成显示图表的面板
	public static JPanel createDemoPanel() {
		JFreeChart jfreechart = createChart(createDataset());
		return new ChartPanel(jfreechart);
	}

	// 生成饼图数据集对象
	public static PieDataset createDataset() {
		DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
		defaultpiedataset.setValue("管理人员", 10.02D);
		defaultpiedataset.setValue("市场人员", 20.23D);
		defaultpiedataset.setValue("开发人员", 60.02D);
		defaultpiedataset.setValue("OEM人员", 10.02D);
		defaultpiedataset.setValue("其他人员", 5.11D);

		return defaultpiedataset;
	}

	// 生成图表主对象JFreeChart
	public static JFreeChart createChart(PieDataset piedataset) {
		// 定义图表对象
		JFreeChart jfreechart = ChartFactory.createPieChart(
				"CityInfoPort公司组织架构图", piedataset, true, true, false);
		// 获得图表显示对象
		PiePlot pieplot = (PiePlot) jfreechart.getPlot();
		// 设置图表标签字体
		pieplot.setLabelFont(new Font("SansSerif", Font.BOLD, 12));
		pieplot.setNoDataMessage("No data available");
		pieplot.setCircular(true);
		pieplot.setLabelGap(0.01D);// 间距

		pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator(
				"{0} ={1}"));

		return jfreechart;
	}

//	public static void main(String[] args) {
//		Test1 fjc = new Test1("CityInfoPort公司组织架构图");
//		fjc.pack();
//		RefineryUtilities.centerFrameOnScreen(fjc);
//		fjc.setVisible(true);
//	}
	 /** 
     * @param args 
     */  
    public static void main(String[] args) throws IOException{  
        JFreeChart chart=ChartFactory.createBarChart3D(  
                "图书销量统计图",  
                "图书",//目录轴的显示标签  
                "销量",//数值轴的显示标签  
                getDataSet(),  
                PlotOrientation.VERTICAL,//设置图表方向  
                true,//复杂柱状图  
                false,  
                false          
        );  
        //取得统计图表的第一个图例  
        LegendTitle legend =chart.getLegend(0);  
        //修改图例的字体  
        legend.setItemFont(new Font("宋体",Font.BOLD,14));  
          
          
        //设置标题  
        chart.setTitle(new TextTitle("图书销量统计图",new Font("黑体",Font.ITALIC,22)));  
        //设置图表部分  
        CategoryPlot plot=(CategoryPlot)chart.getPlot();  
          
        CategoryAxis categoryAxis=plot.getDomainAxis();//取得横轴  
        categoryAxis.setLabelFont(new Font("宋体",Font.BOLD,22));//设置横轴显示标签的字体  
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);//分类标签以４５度倾斜  
        categoryAxis.setTickLabelFont(new Font("宋体",Font.BOLD,18));//分类标签字体  
          
        NumberAxis numberAxis=(NumberAxis)plot.getRangeAxis();//取得纵轴  
        numberAxis.setLabelFont(new Font("宋体",Font.BOLD,42));//设置纵轴显示标签字体  
        FileOutputStream fos=null;  
        fos=new FileOutputStream("c://book2.jpg");  
        ChartUtilities.writeChartAsJPEG(  
                fos,  
                1,  
                chart,  
                800,  
                600,  
                null  
          
        );  
        fos.close();  
    }  
    private static CategoryDataset getDataSet(){  
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();  
        dataset.addValue(47000,"北京", "Spring2.0宝典");  
        dataset.addValue(38000,"北京","轻量级的J@EEE");  
        dataset.addValue(38000, "北京", "JavaScript权威指南");  
        dataset.addValue(25000, "北京", "Ajax In Action");  
        dataset.addValue(37000,"上海", "Spring2.0宝典");  
        dataset.addValue(37000,"上海","轻量级的J@EEE");  
        dataset.addValue(24000, "上海", "JavaScript权威指南");  
        dataset.addValue(26000, "上海", "Ajax In Action");  
        dataset.addValue(17000,"广州", "Spring2.0宝典");  
        dataset.addValue(48000,"广州","轻量级的J@EEE");  
        dataset.addValue(21000, "广州", "JavaScript权威指南");  
        dataset.addValue(35000, "广州", "Ajax In Action");  
        dataset.addValue(46000,"长春", "Spring2.0宝典");  
        dataset.addValue(21000,"长春","轻量级的J@EEE");  
        dataset.addValue(22000, "长春", "JavaScript权威指南");  
        dataset.addValue(22000, "长春", "Ajax In Action");  
        return dataset;  
          
          
    }  
}
