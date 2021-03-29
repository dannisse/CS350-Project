package edu.odu.cs.cs350.project_enrollments;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class eSnapshot {
	/*private String seats;
	private String CRN;
	private String subj;
	private String crse;
	private String title;
	private String cr_hrs;
	private String xlst_cap;
	private String enr;
	private String link;
	private String xlst_group;
	private String sched_type;
	private String campus;
	private String insm;
	private String print;
	private String time;
	private String days;
	private String bldg;
	private String room;
	private String override;
	private String instructor;
	private String overall_cap;
	private String overall_enr;
	private String ptrm_start;
	private String ptrm_end;
	private String wl_cap;
	private String wl;
	private String wl_remain;
	private String notes;
	private String comments;
	private String coll;	
	
	private String blank1;	
	private String blank2;	
	private String blank3;	
	private String blank4;*/
	
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
	
	public String blank1;	
	public String blank2;	
	public String blank3;	
	public String blank4;
		
		
	public eSnapshot(String[] fields) {
		
		//String[] fields = s.split(",");
		
		seats = fields[0];
		CRN = fields[1];	// important
		subj = fields[2];	// imp
		crse = fields[3];	// imp
		title = fields[4];
		cr_hrs = fields[5];
		xlst_cap = fields[6];	
		enr = fields[7];	// important
		link = fields[8];	// important
		xlst_group = fields[9];	// imp
		sched_type = fields[10];
		campus = fields[12];	// skip index on purpose
		insm = fields[13];
		print = fields[14];
		time = fields[15];
		days = fields[16];
		bldg = fields[17];
		room = fields[18];
		override = fields[19];
		instructor = fields[20];
		overall_cap = fields[22];	// skip index on purpose
		overall_enr = fields[23];	//important
		ptrm_start = fields[26];	// skip 2 forwards
		ptrm_end = fields[27];
		wl_cap = fields[28];
		wl = fields[29];
		wl_remain = fields[30];
		//notes = fields[31];
		//comments = fields[31];
		//coll = fields[32];
	}
	
	public eSnapshot(eSnapshot rhs) {
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
	public static Comparator<eSnapshot> eSnapNum = new Comparator<eSnapshot>() {

		public int compare(eSnapshot s1, eSnapshot s2) {

		   int num1 = s1.getNum();
		   int num2 = s2.getNum();
		   
		   return num1-num2;

	   }};
	   
	   public static Comparator<eSnapshot> eSnapCRN = new Comparator<eSnapshot>() {

			public int compare(eSnapshot s1, eSnapshot s2) {

			   int num1 = s1.getCRNum();
			   int num2 = s2.getCRNum();
			   
			   return num1-num2;

		   }};
	
	
	public static void mathFR(ArrayList<eSnapshot> data) {
		ArrayList<eSnapshot> alpha = new ArrayList<eSnapshot>();
		int sum = 0;
		int capSum = 0;
		
		char spec = ' ';
		
		int j = data.size();
		Collections.sort(data, eSnapshot.eSnapCRN);
		Collections.sort(data, eSnapshot.eSnapNum);
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
				
				alpha.add(new eSnapshot(data.get(i)));
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
		Collections.sort(alpha, eSnapshot.eSnapNum);
		
		for(int i = 0; i < alpha.size(); i++) {
			System.out.print(spec + alpha.get(i).getCourse() + "\t" + alpha.get(i).getEnr() + "\t\t\t\t" + alpha.get(i).getCap() + "\n");
			}
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
	
	
	
}
