package com.juarakoding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.juarakoding.main.dao.DaoBiodata;
import com.juaracoding.main.model.Biodata;
import com.juaracoding.main.model.BiodataRowMapper;

@RestController
public class testingController {
	
	@Autowired
	JdbcTemplate jdbc ;
	
	public List<Biodata> getBiodata() {
		
		String sql = "Select * from Biodata";
		
		List <Biodata> biodata =  jdbc.query(sql,new BiodataRowMapper());
		
		return biodata;
		
		
	}
	
	public int insertBiodata(Biodata biodata) {
		return jdbc.update("insert into biodata(nik,nama,alamat,id_salary) values ('"+biodata.getNik()+"','"+biodata.getNama()+"','"+biodata.getAlamat()+"',"+biodata.getId_salary()+")");
		
	}
	//PR
	public int updateBiodata(String nik) {
		return 0;
		
	}
	
	public int deleteBiodata(String nik) {
		return 0;
	}
	
	@RequestMapping("/delete/")
	public String deleteBiodata() {
		
		
		return "";
	}
	
	@RequestMapping("/update/")
	public String updateBiodata() {
		
		
		return "";
	}
	

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String homeIndex() {
		return "<html><body><h1><b>Hello World</b></body></h1></html>";
	}
	
	public int insertBiodata1(Biodata Biodata) {
		return jdbc.update("INSERT INTO biodata(nik,nama,alamat,id_salary) values ('"+Biodata.getNik()+"','"+Biodata.getNama()+"','"+Biodata.getAlamat()+"',"+Biodata.getId_salary()+")");
	}
	
	public int updateBiodata(Biodata biodata) {
		return jdbc.update("UPDATE biodata SET nama = '"+biodata.getNama()+"', alamat = '"+biodata.getAlamat()+"', id_salary = '"+biodata.getId_salary()+"' WHERE nik = '"+biodata.getNik()+"' ");
	}
	
	public int deleteBiodata(Biodata biodata) {
		return jdbc.update("DELETE FROM biodata WHERE nik = '"+biodata.getNik()+"'");
	}
	
	@RequestMapping("/testing")
	public String testPage() {
		
		//DaoBiodata tblBiodata = new DaoBiodata();
		
		List<Biodata> lstbiodata = getBiodata();
		
		String dummy ="";
		for(int x =0 ; x< lstbiodata.size();x++) {
			
			dummy += lstbiodata.get(x).getNama() +",";
			
		}
		return dummy;
		
	}
	
	@RequestMapping("/insert")
	public String insertBiodata () {
		
		Biodata biodata = new Biodata();
		biodata.setNik("125676");
		biodata.setNama("holi ganteng");
		biodata.setAlamat("bekasi");
		biodata.setId_salary(123);
		
		if(this.insertBiodata(biodata) == 1) {
			return "Insert data berhasil";
		}else {
			return "Insert data gagal";
		}		
}

	@RequestMapping("/update")
	public String updatebiodata() {	
		
		Biodata biodata = new Biodata();
		biodata.setNik("N05");
		biodata.setNama("holi ganteng");
		biodata.setAlamat("kranji");
		biodata.setId_salary(14045);
		
		if(this.updateBiodata(biodata) == 1) {
			return "Update Biodata Berhasil"+"<br>"+testPage();
		} else {
			return "Update Biodata Gagal";			
		}
	}

	@RequestMapping("/delete")
	public String deletebiodata() {	
		
		Biodata biodata = new Biodata();
		biodata.setNik("N07");
		
		if(this.deleteBiodata(biodata) == 1) {
			return "Delete Biodata Berhasil"+"<br>"+testPage();
		} else {
			return "Delete Biodata Gagal";			
		}
	}
	
}