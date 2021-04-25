package edu.odu.cs.cs350.project_enrollments;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.chart.AxisPosition;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xddf.usermodel.chart.LegendPosition;
import org.apache.poi.xddf.usermodel.chart.MarkerStyle;
import org.apache.poi.xddf.usermodel.chart.XDDFCategoryAxis;
import org.apache.poi.xddf.usermodel.chart.XDDFChartLegend;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.apache.poi.xddf.usermodel.chart.XDDFLineChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFValueAxis;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("PMD")
public class DetailedReport { 
	
	public static Date d3;
	public static long st;
	
	public static void deadlineD(String path) throws Throwable {
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		File directoryPath = new File(path);	    
	    File filesList[] = directoryPath.listFiles();
	    Date d1;
	    Date d2;
	    long diffInMillies;
	    long diff;
	    long perc;
	    String d;
	    
	    Scanner sc = null;
	    for(File file : filesList) {	
			sc = new Scanner(new File(path + file.getName()));
			String t = file.getName();
			if(!t.equals("dates.txt")) {
				d = file.getName();
				d=d.substring(0,10);
				//System.out.print("Snap format: " + d + "\n");
				//d3 = sdformat.parse(d);
				d3 = sdformat.parse(d);
				//System.out.print("Snap Date: " + d3 + "\n");
			}
			if(t.equals("dates.txt")) {		
				
				d1 = sdformat.parse(sc.nextLine());
				//Date d2 = sdformat.parse(sc.next());
				d2 = sdformat.parse(sc.next());
				//System.out.print(d1 +"\n");
				//System.out.print(d2 + "\n");
				
				diffInMillies = Math.abs(d2.getTime() - d1.getTime());
				diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
				perc = diff;
				
				//System.out.print("difference: " + diff + "\n");
				diffInMillies = (d3.getTime() - d1.getTime());
				diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
				//System.out.print("Third: " + diff + "\n");
				//System.out.print("percentage: " + diff + " " + perc + "\n");
				st = (diff*100)/perc;
				if(st <= 0){
					//System.out.print("percentage: %" + 0);
					st=0;
				}else if(st >= 100){
					//System.out.print("percentage: %" + 100);
					st = 100;
				}//else
					//System.out.print("percentage: %" + st);
				//System.exit(0);
			}
			
			sc.close();
	    }
	}
	public void createExcel(SortedMap<String, Course> hist, SortedMap<String, Course> curr, String path) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		 double[] dHist = new double[]{.1,.2,.5,.75,1.05,0,0};
		 double[] date1 = new double[]{30,35,50,52,54,0,0};
		 double[] dcurr = new double[] {0,.25,5,0,0,0,0};
		 double[] date2 = new double[]{0,0,25,60,0,0,0};
		 double[] dProj = new double[]{0,0,0,.5,1,0,0};
		 double[] proj = new double[] {0,0,0,60,80,0,0};
		 
		 String headDate1 = "Season/Year";
		 String headDate2 = "Season/Year";
		
		for (String key : hist.keySet()) {
			XSSFSheet sheet = workbook.createSheet(hist.get(key).getCourseTitle());
			for (int i = 0; i < 6; i++) {

		            Row row = sheet.createRow((short) 0);
		            Cell cell = row.createCell((short) 0);
		            cell.setCellValue("dHistorical");
		            sheet.autoSizeColumn(0);

		            cell = row.createCell((short) 1);
		            cell.setCellValue(headDate1);
		            sheet.autoSizeColumn(1);

		            cell = row.createCell((short) 2);
		            cell.setCellValue("d current");
		            sheet.autoSizeColumn(2);

		            cell = row.createCell((short) 3);
		            cell.setCellValue(headDate2);
		            sheet.autoSizeColumn(3);

		            cell = row.createCell((short) 4);
		            cell.setCellValue("d projected");
		            sheet.autoSizeColumn(4);
		            
		            cell = row.createCell((short) 5);
		            cell.setCellValue("Projected");
		            sheet.autoSizeColumn(5);	            
		            
		            for (int j = 0; j < dHist.length; j++) {
		                row = sheet.createRow((short) j+1);
		                cell = row.createCell((short) 0);
		                cell.setCellValue(dHist[j]);
		                cell = row.createCell((short) 1);
		                cell.setCellValue(date1[j]);
		                cell = row.createCell((short) 2);
		                cell.setCellValue(dcurr[j]);
		                cell = row.createCell((short) 3);
		                cell.setCellValue(date2[j]);
		                cell = row.createCell((short) 4);
		                cell.setCellValue(dProj[j]);
		                cell = row.createCell((short) 5);
		                cell.setCellValue(proj[j]);
		            }

		            

		            XSSFDrawing drawing = sheet.createDrawingPatriarch();
		            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 8, 0, 15, 15);

		            XSSFChart chart = drawing.createChart(anchor);
		            chart.setTitleText("Enrollment Projection");
		            chart.setTitleOverlay(false);

		            XDDFChartLegend legend = chart.getOrAddLegend();
		            legend.setPosition(LegendPosition.RIGHT);

		            XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
		            XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
		     

		            XDDFNumericalDataSource<Double> historical = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
		                    new CellRangeAddress(1, 7, 0, 0));

		            XDDFNumericalDataSource<Double> hSeason = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
		                    new CellRangeAddress(1, 7, 1, 1));

		            XDDFNumericalDataSource<Double> current = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
		                    new CellRangeAddress(1, 7, 2, 2));
		            
		            XDDFNumericalDataSource<Double> cSeason = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
		                    new CellRangeAddress(1, 7, 3, 3));
		            
		            XDDFNumericalDataSource<Double> projected = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
		                    new CellRangeAddress(1, 7, 4, 4));
		            
		            XDDFNumericalDataSource<Double> eProjected = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
		                    new CellRangeAddress(1, 7, 5, 5));
		            
		            XDDFLineChartData data = (XDDFLineChartData) chart.createData(ChartTypes.LINE, bottomAxis, leftAxis);

		            XDDFLineChartData.Series series1 = (XDDFLineChartData.Series) data.addSeries(historical, hSeason);
		            series1.setTitle("History", null);
		            series1.setSmooth(false);
		            series1.setMarkerStyle(MarkerStyle.NONE);

		            XDDFLineChartData.Series series2 = (XDDFLineChartData.Series) data.addSeries(current, cSeason);
		            series2.setTitle("Season/Year", null);
		            series2.setSmooth(false);
		            series2.setMarkerStyle(MarkerStyle.NONE);
		            
		            XDDFLineChartData.Series series3 = (XDDFLineChartData.Series) data.addSeries(projected, eProjected);
		            series3.setTitle("Projected", null);
		            series3.setSmooth(false);
		            series3.setMarkerStyle(MarkerStyle.NONE);

		            chart.plot(data);
			}
						
		}
		try (FileOutputStream outputStream = new FileOutputStream(path)) {
	        workbook.write(outputStream);
	        workbook.close();
  
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}