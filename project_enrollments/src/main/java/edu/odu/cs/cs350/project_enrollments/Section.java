package edu.odu.cs.cs350.project_enrollments;

//import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


@SuppressWarnings("PMD")
public class Section {	
	public String seats;
	public String CRN;
	public String subj;
	public String crse;
	public String title;
	public String cr_hrs;
	public String xlst_cap;
	public String enr;
	public String link;
	public String xlst_group;
	public String sched_type;
	public String campus;
	public String insm;
	public String print;
	public String time;
	public String days;
	public String bldg;
	public String room;
	public String override;
	public String instructor;
	public String overall_cap;
	public String overall_enr;
	public String ptrm_start;
	public String ptrm_end;
	public String wl_cap;
	public String wl;
	public String wl_remain;
	public String notes;
	public String comments;
	public String coll;			
		
	public Section(String[] fields) {		
		seats = fields[0];
		CRN = fields[1];
		subj = fields[2];
		crse = fields[3];
		title = fields[4];
		cr_hrs = fields[5];
		xlst_cap = fields[6];	
		enr = fields[7];
		link = fields[8];
		xlst_group = fields[9];
		sched_type = fields[10];
		campus = fields[12];	// skip forwards one on purpose
		insm = fields[13];
		print = fields[14];
		time = fields[15];
		days = fields[16];
		bldg = fields[17];
		room = fields[18];
		override = fields[19];
		instructor = fields[20];
		overall_cap = fields[22];	// skip forwards one
		overall_enr = fields[23];
		ptrm_start = fields[26];	// skip forwards two
		ptrm_end = fields[27];
		wl_cap = fields[28];
		wl = fields[29];
		wl_remain = fields[30];
	}
		
		public Section() {		
			seats = "";
			CRN = "0";
			subj = "";
			crse = "000L";
			title = "";
			cr_hrs = "";
			xlst_cap = "0";
			enr = "0";
			link = "";
			xlst_group = "";
			sched_type = "";
			campus = "";// skip forwards one on purpose
			insm = "";
			print = "";
			time = "";
			days = "";
			bldg = "";
			room = "";
			override = "";
			instructor = "";
			overall_cap = "0";// skip forwards one
			overall_enr = "0";
			ptrm_start = "";// skip forwards two
			ptrm_end = "";
			wl_cap = "";
			wl = "";
			wl_remain = "";
			
		
		// We can effectively disregard these latter fields.
		notes = "";
		comments = "";
		coll = "";
	}
	
	public Section(Section rhs) {
		this.CRN = rhs.CRN;
		this.subj = rhs.subj;
		this.crse = rhs.crse;
		this.xlst_cap = rhs.xlst_cap;
		this.enr = rhs.enr;
		this.link = rhs.link;
		this.xlst_group = rhs.xlst_group;
		this.overall_cap = rhs.overall_cap;
		this.overall_enr = rhs.overall_enr;
	}
	
	public void print() {
		System.out.println("SEATS="+seats);
		System.out.println("CRN="+CRN);
		System.out.println("SUBJ="+subj);
		System.out.println("CRSE="+crse);
		System.out.println("TITLE="+title);
		System.out.println("CR_HRS="+cr_hrs);
		System.out.println("XLST_CAP="+xlst_cap);
		System.out.println("ENR="+enr);
		System.out.println("LINK="+link);
		System.out.println("XLST_GROUP="+xlst_group);
		System.out.println("SCHED_TYPE="+sched_type);
		System.out.println("CAMPUS="+campus);
		System.out.println("INSM="+insm);
		System.out.println("PRINT="+print);
		System.out.println("TIME="+time);
		System.out.println("DAYS="+days);
		System.out.println("BLDG="+bldg);
		System.out.println("ROOM="+room);
		System.out.println("OVERRIDE="+override);
		System.out.println("INSTRUCTOR="+instructor);
		System.out.println("OVERALL_CAP="+overall_cap);
		System.out.println("OVERALL_ENR="+overall_enr);
		System.out.println("PTRM_START="+ptrm_start);
		System.out.println("PTRM_END="+ptrm_end);
		System.out.println("WL_CAP="+wl_cap);
		System.out.println("WL="+wl);
		System.out.println("WL_REMAIN="+wl_remain);
		System.out.println("NOTES="+notes);
		System.out.println("COMMENTS="+comments);
		System.out.println("COLL="+coll);	
	}
	public static Comparator<Section> eSnapNum = new Comparator<Section>() {

		public int compare(Section s1, Section s2) {

		   int num1 = s1.getNum();
		   int num2 = s2.getNum();
		   
		   return num1-num2;

	   }};
	   
	   public static Comparator<Section> eSnapCRN = new Comparator<Section>() {

			public int compare(Section s1, Section s2) {

			   int num1 = s1.getCRNum();
			   int num2 = s2.getCRNum();
			   
			   return num1-num2;

		   }};
	
	
/*	public static void mathFR(ArrayList<Section> data) {
		ArrayList<Section> alpha = new ArrayList<Section>();
		int sum = 0;
		int capSum = 0;
		
		char spec = ' ';
		
		int j = data.size();
		Collections.sort(data, Section.eSnapCRN);
		Collections.sort(data, Section.eSnapNum);
		for(int i = 0; i < data.size(); i++) {
			//System.out.print(data.get(i).getCourse() + "\n");
			
			if(i+1 <= j-1) {
				
				
				if(data.get(i).getCourse().equals(data.get(i+1).getCourse())){
					sum = sum+data.get(i).getEnr();
					if(!data.get(i).getCRN().equals(data.get(i+1).getCRN())){
						if(data.get(i).getCap().equals("")) {
							data.get(i).setCap(0);
						}
					capSum = capSum+(Integer.parseInt(data.get(i).getCap()));
					//System.out.print(data.get(i).getEnr() + "\n");
					//System.out.print(data.get(i).getCap() + "\n");
					
					}
				}
				if(!data.get(i).getCourse().equals(data.get(i+1).getCourse())) {
				
				alpha.add(new Section(data.get(i)));
				//System.out.print("i =" + i + "\n");
				alpha.get(alpha.size()-1).setEnr(sum);
				alpha.get(alpha.size()-1).setCap(capSum);
				//System.out.print(data.get(i).getCourse()+ "   and    " +data.get(i+1).getCourse() + "  " + sum + "\n"  );
				//System.out.print(data.get(i).getCourse() + " sum: " + capSum + "\n");
				sum =0;
				capSum = 0;
				//System.out.print(sum + "\n");
				
					//System.out.print(data.get(i) + "\n");
			}	
				
		}			
			else
				alpha.add(data.get(j-1));
				
				//System.out.print(data.get(j-1).getCourse() + "\n");
			
		}
		Collections.sort(alpha, Section.eSnapNum);
		
		for(int i = 0; i < alpha.size(); i++) {
			System.out.print(spec + alpha.get(i).getCourse() + "\t" + alpha.get(i).getEnr() + "\t\t\t\t" + alpha.get(i).getCap() + "\n");
			}
	}*/
	
	public String getCrse() {	
		return crse;
	}
	
	public String getCourse() {
		return (subj+crse);
	}
	
	public int getNum() {
		int i = Integer.parseInt(crse.substring(0,3));
		return i;
	}
	
	public int getCRNum() {
		int i = Integer.parseInt(CRN);
		return i;
	}
	
	public int getEnr() {
		return Integer.parseInt(enr);
	}
	
	public void setEnr(int x) {
		this.enr = String.valueOf(x);
	}
	
	public String getCap() {
		return overall_cap;
	}
	
	public void setCap(int x) {
		this.overall_cap = String.valueOf(x);
	}
	
	public String getCRN() {
		return CRN;
	}
	
	public String getSubj() {
		return subj;
	}
	/*
	 * Display for testing purposes
	 */
	public void display()
	{
		System.out.println(this.getCourse() + " | " + this.getCRN());
	}
}
