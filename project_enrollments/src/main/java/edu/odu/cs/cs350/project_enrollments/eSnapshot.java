package edu.odu.cs.cs350.project_enrollments;

import java.util.List;
import java.util.ArrayList;


public class eSnapshot {
	private String seats;
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
	private String blank4;
		
		
	public eSnapshot(String s) {
		
		String[] fields = s.split(",");
		
		CRN = fields[0];
		subj = fields[1];
		crse = fields[2];
		xlst_cap = fields[3];
		enr = fields[4];
		link = fields[5];
		xlst_group = fields[6];
		overall_cap = fields[7];
		overall_enr = fields[8];
		
		/*//seats = fields[0];
		CRN = fields[1];
		subj = fields[2];
		crse = fields[3];
		//title = fields[4];
		//cr_hrs = fields[5];
		xlst_cap = fields[6];
		enr = fields[7];
		link = fields[8];
		xlst_group = fields[9];
		//sched_type = fields[10];
		//blank1 = fields[11];
		//campus = fields[12];
		//insm = fields[13];
		//print = fields[14];
		//time = fields[15];
		//days = fields[16];
		//bldg = fields[17];
		//room = fields[18];
		//override = fields[19];
		//instructor = fields[20];
		//blank4 = fields[21];
		overall_cap = fields[22];
		overall_enr = fields[23];
		//blank2 = fields[24];
		//blank3 = fields[25];
		//ptrm_start = fields[26];
		//ptrm_end = fields[27];
		//wl_cap = fields[28];
		//wl = fields[29];
		//wl_remain = fields[30];
		//notes = fields[31];
		//comments = fields[32];
		//coll = fields[33];*/
	}
	
	public void print() {
		//System.out.println("SEATS="+seats);
		System.out.println("CRN="+CRN);
		System.out.println("SUBJ="+subj);
		System.out.println("CRSE="+crse);
		//System.out.println("TITLE="+title);
		//System.out.println("CR_HRS="+cr_hrs);
		System.out.println("XLST_CAP="+xlst_cap);
		System.out.println("ENR="+enr);
		System.out.println("LINK="+link);
		System.out.println("XLST_GROUP="+xlst_group);
		//System.out.println("SCHED_TYPE="+sched_type);
		//System.out.println("CAMPUS="+campus);
		//System.out.println("INSM="+insm);
		//System.out.println("PRINT="+print);
		//System.out.println("TIME="+time);
		//System.out.println("DAYS="+days);
		//System.out.println("BLDG="+bldg);
		//System.out.println("ROOM="+room);
		//System.out.println("OVERRIDE="+override);
		//System.out.println("INSTRUCTOR="+instructor);
		System.out.println("OVERALL_CAP="+overall_cap);
		System.out.println("OVERALL_ENR="+overall_enr);
		//System.out.println("PTRM_START="+ptrm_start);
		//System.out.println("PTRM_END="+ptrm_end);
		//System.out.println("WL_CAP="+wl_cap);
		//System.out.println("WL="+wl);
		//System.out.println("WL_REMAIN="+wl_remain);
		//System.out.println("NOTES="+notes);
		//System.out.println("COMMENTS="+comments);
		//System.out.println("COLL="+coll);	
	}

	
}
