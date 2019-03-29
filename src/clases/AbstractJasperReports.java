package clases;

import java.sql.Connection;
import javax.swing.JOptionPane;
import com.itextpdf.text.DocumentException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.ClassLoaderResource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.util.Map;

public class AbstractJasperReports {
	private static JasperReport	report;
	private static JasperPrint	reportFilled;
	private static JasperViewer	viewer;
	

	public void createReport( Connection conn, String path )
	{
		try {
			report = (JasperReport) JRLoader.loadObject(ClassLoader.getSystemResource(path));
			//report = (JasperReport) JRLoader.loadObjectFromFile( path );
			reportFilled = JasperFillManager.fillReport( report, null, conn );
		}
		catch( JRException ex ) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public void createReport( Connection conn, String path, Map parameters)
	{
		try {
			report = (JasperReport) JRLoader.loadObject(ClassLoader.getSystemResource(path));
			reportFilled = JasperFillManager.fillReport( report, parameters, conn );
		}
		catch( JRException ex ) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
			ex.printStackTrace();
		}
	}
	

	public static void showViewer()
	{
		viewer = new JasperViewer( reportFilled ,false);
		viewer.setVisible( true );
	}

	public static void exportToPDF( String destination )
	{
		try { 
			JasperExportManager.exportReportToPdfFile( reportFilled,destination );
		}
		catch(Exception ex ) {
			ex.printStackTrace();
		}
	}
	
}
