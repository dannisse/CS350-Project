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
		
	}
	
	public eSnapshot(String s) {
		
		String[] fields = s.split(",");
		
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
		campus = fields[11];
		insm = fields[12];
		print = fields[13];
		time = fields[14];
		days = fields[15];
		bldg = fields[16];
		room = fields[17];
		override = fields[18];
		instructor = fields[19];
		overall_cap = fields[20];
		overall_enr = fields[21];
		ptrm_start = fields[22];
		ptrm_end = fields[23];
		wl_cap = fields[24];
		wl = fields[25];
		wl_remain = fields[26];
		notes = fields[27];
		comments = fields[28];
		coll = fields[29];
	}
}
