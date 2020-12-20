package experiment9.exp1;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.data.general.DefaultPieDataset;

public class TestJFree {
    public TestJFree() {
    }

    public static void main(String[] args){
        DefaultPieDataset dpd = new DefaultPieDataset();
        dpd.setValue("������Ա",25);
        dpd.setValue("�г���Ա",25);
        dpd.setValue("������Ա",45);
        dpd.setValue("������Ա",5);

//Create JFreeChart object
//�������Բ鿴Դ��
        JFreeChart pieChart = ChartFactory.createPieChart("CityInfoPort��˾��֯�ܹ�ͼ",dpd,true,true,false);
        ChartFrame pieFrame = new ChartFrame("CityInfoPort��˾��֯�ܹ�ͼ",pieChart);
        pieFrame.pack();
        pieFrame.setVisible(true);
    }
}
