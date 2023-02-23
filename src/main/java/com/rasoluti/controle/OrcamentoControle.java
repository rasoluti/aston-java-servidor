package com.rasoluti.controle;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rasoluti.model.dto.OrcamentoDtoGerador;
import com.rasoluti.service.OrcamentoService;

import jakarta.servlet.http.HttpServletRequest;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@RequestMapping("/orcamento")
public class OrcamentoControle {
	
	@Autowired
	private OrcamentoService orcamentoService;
	
//	@CrossOrigin(origins = "*")
//	@PostMapping(value = "/v2")
//	private ResponseEntity<?> get(@RequestBody List<OrcamentoDtoGerador> list,HttpServletRequest request)throws Exception {	
//		byte[] data = orcamentoService.montar(list);
//		HttpHeaders headers = new HttpHeaders();
//		headers.set(HttpHeaders.CONTENT_DISPOSITION, "");
//		
//		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
//	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/v3")
	private ResponseEntity<?> gravaPdf(@RequestBody List<OrcamentoDtoGerador> list,@RequestParam("pais") String pais,
			HttpServletRequest request)throws Exception {
		Long  data = orcamentoService.gravaPdf(list,pais);
		 return ResponseEntity.ok().body(data);
	}
	

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/v4")
	private ResponseEntity<?> get(@RequestParam("id") Long id, HttpServletRequest request)throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "");	
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(orcamentoService.buscarPdfById(id));
	}
	

}
