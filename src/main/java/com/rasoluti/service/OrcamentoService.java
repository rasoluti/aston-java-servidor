package com.rasoluti.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rasoluti.model.dto.OrcamentoDtoGerador;
import com.rasoluti.model.entidade.Cliente;
import com.rasoluti.model.entidade.Garagem;
import com.rasoluti.model.entidade.Orcamento;
import com.rasoluti.model.entidade.Preco;
import com.rasoluti.repository.ClienteRepository;
import com.rasoluti.repository.OrcamentoRepository;
import com.rasoluti.repository.OrcamentoRepositoryTeste;
import com.rasoluti.repository.PrecoRepository;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class OrcamentoService {
	
	 @Autowired private PrecoRepository precoRepository;
	 @Autowired private OrcamentoRepository orcamentoRepository;
	 @Autowired private ClienteRepository clienteRepository;
	 
//	 @Autowired private GaragemRepository garagemRepository;


	public Long gravaPdf(List<OrcamentoDtoGerador> listaItens,String pais) throws JRException, FileNotFoundException {
		List<OrcamentoDtoGerador> listaItens1 = new ArrayList<>() ;
		Double valorTotal = 0.0;
		Long cod = 0L;
		
		Garagem g = new Garagem();
		g.setId(2L);
	
		Cliente c = new Cliente();
		c.setNomeCliente(listaItens.get(0).getNomeCliente());
		c.setModeloCarro(listaItens.get(0).getModeloCarro());
		c.setAnoCarro(listaItens.get(0).getAnoCarro());
		c.setPlacaCarro(listaItens.get(0).getPlacaCarro());
		c.setGaragem(g);
		
		Cliente clienteSalvo = clienteRepository.save(c);
		
		for (OrcamentoDtoGerador v: listaItens) {
			
			Double valorP =  precoRepository.valorNative(v.getTamP(), "P");
			Double valorM =  precoRepository.valorNative(v.getTamM(), "M");
			Double valorG =  precoRepository.valorNative(v.getTamG(), "G");
			valorP = v.getAluminio().equalsIgnoreCase("aluminio")? 
					Math.floor(((valorP/100 )*20) + valorP):valorP;
			valorM = v.getAluminio().equalsIgnoreCase("aluminio")?
					Math.floor(((valorM/100 )*20) + valorM):valorM ;
			valorG = v.getAluminio().equalsIgnoreCase("aluminio")? 
					Math.floor(((valorG/100 )*20) + valorG):valorG ;
						
			v.setValor(valorP + valorM + valorG);
			
			listaItens1.add(v);
			
			Orcamento o =  new Orcamento();
			o.setCliente(clienteSalvo);
			o.setAluminio(v.getAluminio().equals("aluminio"));
			o.setAno(v.getAnoCarro());
			o.setItem(v.getItem());
			o.setModelo(v.getModeloCarro());
			o.setPlaca(v.getPlacaCarro());
			o.setStatus("A");
			o.setTamP(v.getTamP());
			o.setTamM(v.getTamM());
			o.setTamG(v.getTamG());
			o.setTipo(v.getTipo());
			o.setValor(v.getValor());
			o.setCod(clienteSalvo.getId());
			o.setTva(pais.equalsIgnoreCase("FR")?20.0:23.0);
		
		    o = orcamentoRepository.save(o);
		    
		    cod = o.getCod();
				
		}
		
		
		for (OrcamentoDtoGerador v: listaItens1) {	
				valorTotal =  v.getValor() + valorTotal;			
			}
		
		return cod;

	}
	
	
//	@Override
//	public byte[] montar(List<OrcamentoDtoGerador> listaItens) throws JRException, FileNotFoundException {
//		List<OrcamentoDtoGerador> listaItens1 = new ArrayList<>() ;
//		Double valorTotal = 0.0;
//		
//		Garagem g = new Garagem();
//		g.setId(1L);
//	
//		Cliente c = new Cliente();
//		c.setNomeCliente(listaItens.get(0).getNomeCliente());
//		c.setModeloCarro(listaItens.get(0).getModeloCarro());
//		c.setAnoCarro(listaItens.get(0).getAnoCarro());
//		c.setPlacaCarro(listaItens.get(0).getPlacaCarro());
//		c.setGaragem(g);
//		
//		Cliente clienteSalvo = clienteRepository.save(c);
//		
//		for (OrcamentoDtoGerador v: listaItens) {
//			
//			Double valorP =  precoRepository.valorNative(v.getTamP(), "P");
//			Double valorM =  precoRepository.valorNative(v.getTamM(), "M");
//			Double valorG =  precoRepository.valorNative(v.getTamG(), "G");
//			valorP = v.getAluminio().equalsIgnoreCase("aluminio")? 
//					Math.floor(((valorP/100 )*20) + valorP):valorP;
//			valorM = v.getAluminio().equalsIgnoreCase("aluminio")?
//					Math.floor(((valorM/100 )*20) + valorM):valorM ;
//			valorG = v.getAluminio().equalsIgnoreCase("aluminio")? 
//					Math.floor(((valorG/100 )*20) + valorG):valorG ;
//						
//			v.setValor(valorP + valorM + valorG);
//			
//			listaItens1.add(v);
//			
//			Orcamento o =  new Orcamento();
//			o.setCliente(clienteSalvo);
//			o.setAluminio(v.getAluminio().equals("aluminio"));
//			o.setAno(v.getAnoCarro());
//			o.setItem(v.getItem());
//			o.setModelo(v.getModeloCarro());
//			o.setPlaca(v.getPlacaCarro());
//			o.setStatus("A");
//			o.setTamP(v.getTamP());
//			o.setTamM(v.getTamM());
//			o.setTamG(v.getTamG());
//			o.setTipo(v.getTipo());
//			o.setValor(v.getValor());
//			o.setCod(clienteSalvo.getId());
//		
//		    o = orcamentoRepository.save(o);
//				
//		}
//		
//		
//		
//	for (OrcamentoDtoGerador v: listaItens1) {	
//			valorTotal =  v.getValor() + valorTotal;			
//		}
//		
//		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaItens1);
//		JasperReport compileReport = null;
//		
//		compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/orcamento.jrxml"));
//		
//			HashMap<String, Object> map = new HashMap<>();
//			
//			map.put("id", 1L);
//			map.put("nomeCliente", listaItens.get(0).getNomeCliente());
//			map.put("garagem", listaItens.get(0).getGaragem());
//			map.put("modeloCarro", listaItens.get(0).getModeloCarro());
//			map.put("anoCarro", listaItens.get(0).getAnoCarro());
//			map.put("placaCarro", listaItens.get(0).getPlacaCarro());
//			
//			map.put("subtot", valorTotal); 	
//			map.put("tax", 0.0);
//			map.put("des", 0.0);
//			map.put("tot", valorTotal);
//			
//			
//		JasperPrint report =  JasperFillManager.fillReport(compileReport, map,beanCollectionDataSource);
//		JasperExportManager.exportReportToPdfFile(report, "orcamento.pdf");
//		//gerarDados();
//	
//		return JasperExportManager.exportReportToPdf(report);
//	}
	
	
//	public byte[] buscarUltimoPdf() throws JRException, FileNotFoundException {
//		Double valorTotal = 0.0;
//		
//		List<Orcamento> orc =  orcamentoRepository.firstOrcamento();
//		
//		List<OrcamentoDtoGerador> listaItens = new ArrayList<>() ;
//		
//		List<OrcamentoDtoGerador> listaItens1 = new ArrayList<>() ;
//		
//		for (Orcamento v: orc) {	
//		OrcamentoDtoGerador gerador = new OrcamentoDtoGerador();
//
//			gerador.setAluminio(v.getAluminio().equals("aluminio"));
//			gerador.setAnoCarro(v.getAno());
//			gerador.setGaragem("Particular");
//			gerador.setItem(v.getItem());
//			gerador.setModeloCarro(v.getModelo());
//			gerador.setNomeCliente(v.getCliente().getNomeCliente());
//			gerador.setPlacaCarro(v.getPlaca());
//			gerador.setTamP(v.getTamP());
//			gerador.setTamM(v.getTamM());
//			gerador.setTamG(v.getTamG());
//			gerador.setTipo(v.getTipo());
//			gerador.setValor(v.getValor());
//		
//			listaItens.add(gerador);		
//		}
//		
//		for (OrcamentoDtoGerador v: listaItens) {
//			
//			Double valorP =  precoRepository.valorNative(v.getTamP(), "P");
//			Double valorM =  precoRepository.valorNative(v.getTamM(), "M");
//			Double valorG =  precoRepository.valorNative(v.getTamG(), "G");
//			valorP = v.getAluminio().equalsIgnoreCase("aluminio")? 
//					Math.floor(((valorP/100 )*20) + valorP):valorP;
//			valorM = v.getAluminio().equalsIgnoreCase("aluminio")?
//					Math.floor(((valorM/100 )*20) + valorM):valorM ;
//			valorG = v.getAluminio().equalsIgnoreCase("aluminio")? 
//					Math.floor(((valorG/100 )*20) + valorG):valorG ;
//						
//			v.setValor(valorP + valorM + valorG);
//			
//			listaItens1.add(v);
//				
//		}
//		
//		for (OrcamentoDtoGerador v: listaItens1) {	
//			valorTotal =  v.getValor() + valorTotal;			
//		}
//		
//		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaItens1);
//		JasperReport compileReport = null;
//		
//		compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/orcamento.jrxml"));
//		
//			HashMap<String, Object> map = new HashMap<>();
//			
//			map.put("id", 1L);
//			map.put("nomeCliente", listaItens.get(0).getNomeCliente());
//			map.put("garagem", listaItens.get(0).getGaragem());
//			map.put("modeloCarro", listaItens.get(0).getModeloCarro());
//			map.put("anoCarro", listaItens.get(0).getAnoCarro());
//			map.put("placaCarro", listaItens.get(0).getPlacaCarro());
//			
//			map.put("subtot", valorTotal); 	
//			map.put("tax", 0.0);
//			map.put("des", 0.0);
//			map.put("tot", valorTotal);
//			
//			
//			
//		JasperPrint report =  JasperFillManager.fillReport(compileReport, map,beanCollectionDataSource);
//		JasperExportManager.exportReportToPdfFile(report, "orcamento.pdf");
//		//gerarDados();
//	
//		return JasperExportManager.exportReportToPdf(report);
//
//	}
	
	public byte[] buscarPdfById(Long cod) throws JRException, FileNotFoundException {
		Double valorTotal = 0.0;
		Double tva = 0.0;
		
		List<Orcamento> orc =  orcamentoRepository.findOrcamento(cod);
		
		List<OrcamentoDtoGerador> listaItens = new ArrayList<>() ;
		
		List<OrcamentoDtoGerador> listaItens1 = new ArrayList<>() ;
		
		for (Orcamento v: orc) {	
		OrcamentoDtoGerador gerador = new OrcamentoDtoGerador();

			gerador.setAluminio(v.getAluminio().equals("aluminio"));
			gerador.setAnoCarro(v.getAno());
			gerador.setGaragem("Particular");
			gerador.setItem(v.getItem());
			gerador.setModeloCarro(v.getModelo());
			gerador.setNomeCliente(v.getCliente().getNomeCliente());
			gerador.setPlacaCarro(v.getPlaca());
			gerador.setTamP(v.getTamP());
			gerador.setTamM(v.getTamM());
			gerador.setTamG(v.getTamG());
			gerador.setTipo(v.getTipo());
			gerador.setValor(v.getValor());
			
		
			listaItens.add(gerador);		
		}
		
		for (OrcamentoDtoGerador v: listaItens) {
			
			Double valorP =  precoRepository.valorNative(v.getTamP(), "P");
			Double valorM =  precoRepository.valorNative(v.getTamM(), "M");
			Double valorG =  precoRepository.valorNative(v.getTamG(), "G");
			valorP = v.getAluminio().equalsIgnoreCase("aluminio")? 
					Math.floor(((valorP/100 )*20) + valorP):valorP;
			valorM = v.getAluminio().equalsIgnoreCase("aluminio")?
					Math.floor(((valorM/100 )*20) + valorM):valorM ;
			valorG = v.getAluminio().equalsIgnoreCase("aluminio")? 
					Math.floor(((valorG/100 )*20) + valorG):valorG ;
			
			if(v.getTipo().equalsIgnoreCase("Pintura")) {
				valorP = Math.floor(valorP - ((valorP/100 )*20) );
				valorM = Math.floor(valorM - ((valorP/100 )*20) );
				valorG = Math.floor(valorG - ((valorP/100 )*20) );	
			}
						
			v.setValor(valorP + valorM + valorG);
			listaItens1.add(v);
				
		}
		
		for (OrcamentoDtoGerador v: listaItens1) {	
			valorTotal =  v.getValor() + valorTotal;			
		}
		
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaItens1);
		JasperReport compileReport = null;
		
		compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/orcamento.jrxml"));
		
			HashMap<String, Object> map = new HashMap<>();
			
			map.put("id", 1L);
			map.put("nomeCliente", listaItens.get(0).getNomeCliente());
			map.put("garagem", listaItens.get(0).getGaragem());
			map.put("modeloCarro", listaItens.get(0).getModeloCarro());
			map.put("anoCarro", listaItens.get(0).getAnoCarro());
			map.put("placaCarro", listaItens.get(0).getPlacaCarro());
			
			map.put("subtot", valorTotal); 	
			map.put("tax", orc.get(0).getTva());
			//map.put("des", 0.0);
			
			map.put("fieldItens",  orc.get(0).getTva()==23.0?"Itens amassados":"articles froissés");
			map.put("fieldQuantidade",orc.get(0).getTva()==23.0?"Quantidade":"montant");
			map.put("fieldTipo",  orc.get(0).getTva()==23.0?"Tipo":"taper");
			map.put("fieldValor",  orc.get(0).getTva()==23.0?"Valor":"valeur");
					
			double percentual = orc.get(0).getTva() / 100.0; 
			double valorFinal = valorTotal + (percentual * valorTotal );
			map.put("tot", valorFinal);
			
			
			
		JasperPrint report =  JasperFillManager.fillReport(compileReport, map,beanCollectionDataSource);
		JasperExportManager.exportReportToPdfFile(report, "orcamento.pdf");
		//gerarDados();
	
		return JasperExportManager.exportReportToPdf(report);

	}
	
	
	
	public void enviaEmail() throws IOException {
		
		Email from = new Email("raqueltst.costa@hotmail.com");
	    String subject = "raquel-teste";
	    Email to = new Email("roussian23@gmail.com");
	    Content content = new Content("text/plain", "test teste teste-raquel");
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid("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");
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	      throw ex;
	    }
	
	}
		
	public void gerarDados(){
		
		List<Preco> pp = new ArrayList<>();
		
		for (int x = 1; x<=2; x++) {
			
			Preco p = new Preco();
			p.setImpacto(x);
			p.setTamanho("P");
			p.setValor(44.0);
			
			pp.add(p);
				
			Preco m = new Preco();
			m.setImpacto(x);
			m.setTamanho("M");
			m.setValor(65.0);
			
			pp.add(m);
			
			Preco g = new Preco();
			g.setImpacto(x);
			g.setTamanho("G");
			g.setValor(77.0);
			
			pp.add(g);
		   
		}
		
		for (int x = 3; x<=5; x++) {
			
			Preco p = new Preco();
			p.setImpacto(x);
			p.setTamanho("P");
			p.setValor(77.0);
			
			pp.add(p);
				
			Preco m = new Preco();
			m.setImpacto(x);
			m.setTamanho("M");
			m.setValor(109.0);
			
			pp.add(m);
			
			Preco g = new Preco();
			g.setImpacto(x);
			g.setTamanho("G");
			g.setValor(136.0);
			
			pp.add(g);
		   
		}
		
		for (int x = 6; x<=10; x++) {
			
			Preco p = new Preco();
			p.setImpacto(x);
			p.setTamanho("P");
			p.setValor(109.0);
			
			pp.add(p);
				
			Preco m = new Preco();
			m.setImpacto(x);
			m.setTamanho("M");
			m.setValor(142.0);
			
			pp.add(m);
			
			Preco g = new Preco();
			g.setImpacto(x);
			g.setTamanho("G");
			g.setValor(196.0);
			
			pp.add(g);
		   
		}
		
	for (int x = 11; x<=20; x++) {
			
			Preco p = new Preco();
			p.setImpacto(x);
			p.setTamanho("P");
			p.setValor(163.0);
			
			pp.add(p);
				
		}
	
	for (int x = 11; x<=15; x++) {
					
		Preco m = new Preco();
		m.setImpacto(x);
		m.setTamanho("M");
		m.setValor(175.0);
		
		pp.add(m);
		
		Preco g = new Preco();
		g.setImpacto(x);
		g.setTamanho("G");
		g.setValor(250.0);
		
		pp.add(g);
	   
	}
	
	for (int x = 21; x<=30; x++) {
		
		Preco p = new Preco();
		p.setImpacto(x);
		p.setTamanho("P");
		p.setValor(217.0);
		
		pp.add(p);
			
	}
	
	for (int x = 16; x<=20; x++) {
		
		Preco m = new Preco();
		m.setImpacto(x);
		m.setTamanho("M");
		m.setValor(261.0);
		
		pp.add(m);
		
		Preco g = new Preco();
		g.setImpacto(x);
		g.setTamanho("G");
		g.setValor(349.0);
		
		pp.add(g);
	   
	}
	
	for (int x = 31; x<=50; x++) {
		
		Preco p = new Preco();
		p.setImpacto(x);
		p.setTamanho("P");
		p.setValor(273.0);
		
		pp.add(p);
			
	}
	
	for (int x = 21; x<=30; x++) {
		
		Preco m = new Preco();
		m.setImpacto(x);
		m.setTamanho("M");
		m.setValor(327.0);
		
		pp.add(m);
		
		Preco g = new Preco();
		g.setImpacto(x);
		g.setTamanho("G");
		g.setValor(436.0);
		
		pp.add(g);
	   
	}
	
	for (int x = 51; x<=70; x++) {
		
		Preco p = new Preco();
		p.setImpacto(x);
		p.setTamanho("P");
		p.setValor(327.0);
		
		pp.add(p);
			
	}
	
	for (int x = 31; x<=40; x++) {
		
		Preco m = new Preco();
		m.setImpacto(x);
		m.setTamanho("M");
		m.setValor(392.0);
		
		pp.add(m);
		
		Preco g = new Preco();
		g.setImpacto(x);
		g.setTamanho("G");
		g.setValor(523.0);
		
		pp.add(g);
	   
	}
	
	for (int x = 71; x<=100; x++) {
		
		Preco p = new Preco();
		p.setImpacto(x);
		p.setTamanho("P");
		p.setValor(436.0);
		
		pp.add(p);
			
	}
	
	for (int x = 41; x<=50; x++) {
		
		Preco m = new Preco();
		m.setImpacto(x);
		m.setTamanho("M");
		m.setValor(457.0);
		
		pp.add(m);
		
		Preco g = new Preco();
		g.setImpacto(x);
		g.setTamanho("G");
		g.setValor(611.0);
		
		pp.add(g);
	   
	}
	
	for (int x = 101; x<=130; x++) {
		
		Preco p = new Preco();
		p.setImpacto(x);
		p.setTamanho("P");
		p.setValor(545.0);
		
		pp.add(p);
			
	}
	
	for (int x = 51; x<=60; x++) {
		
		Preco m = new Preco();
		m.setImpacto(x);
		m.setTamanho("M");
		m.setValor(567.0);
		
		pp.add(m);
		
		Preco g = new Preco();
		g.setImpacto(x);
		g.setTamanho("G");
		g.setValor(720.0);
		
		pp.add(g);
	   
	}
	
	for (int x = 131; x<=180; x++) {
		
		Preco p = new Preco();
		p.setImpacto(x);
		p.setTamanho("P");
		p.setValor(655.0);
		
		pp.add(p);
			
	}
	
	for (int x = 61; x<=80; x++) {
		
		Preco m = new Preco();
		m.setImpacto(x);
		m.setTamanho("M");
		m.setValor(676.0);
		
		pp.add(m);
	
	   
	}
	
	for (int x = 61; x<=70; x++) {
		
		Preco g = new Preco();
		g.setImpacto(x);
		g.setTamanho("G");
		g.setValor(828.0);
		
		pp.add(g);
	   
	}
	
	for (int x = 181; x<=250; x++) {
		
		Preco p = new Preco();
		p.setImpacto(x);
		p.setTamanho("P");
		p.setValor(763.0);
		
		pp.add(p);
			
	}
	
	for (int x = 81; x<=100; x++) {
		
		Preco m = new Preco();
		m.setImpacto(x);
		m.setTamanho("M");
		m.setValor(763.0);
		
		pp.add(m);
	
	   
	}
	
	for (int x = 71; x<=80; x++) {
		
		Preco g = new Preco();
		g.setImpacto(x);
		g.setTamanho("G");
		g.setValor(926.0);
		
		pp.add(g);
	   
	}
	
	for (int x = 251; x<=350; x++) {
		
		Preco p = new Preco();
		p.setImpacto(x);
		p.setTamanho("P");
		p.setValor(872.0);
		
		pp.add(p);
			
	}
	
	for (int x = 101; x<=120; x++) {
		
		Preco m = new Preco();
		m.setImpacto(x);
		m.setTamanho("M");
		m.setValor(872.0);
		
		pp.add(m);
	
	   
	}
	
	for (int x = 81; x<=100; x++) {
		
		Preco g = new Preco();
		g.setImpacto(x);
		g.setTamanho("G");
		g.setValor(1035.0);
		
		pp.add(g);
	   
	}
	
	for (int x = 351; x<=450; x++) {
		
		Preco p = new Preco();
		p.setImpacto(x);
		p.setTamanho("P");
		p.setValor(1089.0);
		
		pp.add(p);
			
	}
	
	for (int x = 121; x<=150; x++) {
		
		Preco m = new Preco();
		m.setImpacto(x);
		m.setTamanho("M");
		m.setValor(981.0);
		
		pp.add(m);
	
	   
	}
	
	for (int x = 101; x<=120; x++) {
		
		Preco g = new Preco();
		g.setImpacto(x);
		g.setTamanho("G");
		g.setValor(1145.0);
		
		pp.add(g);
	   
	}
	
	for (int x = 451; x<=600; x++) {
		
		Preco p = new Preco();
		p.setImpacto(x);
		p.setTamanho("P");
		p.setValor(1308.0);
		
		pp.add(p);
			
	}
	for (int x = 151; x<=180; x++) {
		
		Preco m = new Preco();
		m.setImpacto(x);
		m.setTamanho("M");
		m.setValor(1089.0);
		
		pp.add(m);
	
	   
	}
	
	for (int x = 121; x<=140; x++) {
		
		Preco g = new Preco();
		g.setImpacto(x);
		g.setTamanho("G");
		g.setValor(1254.0);
		
		pp.add(g);
	   
	}
	
	for (int x = 601; x<=800; x++) {
		
		Preco p = new Preco();
		p.setImpacto(x);
		p.setTamanho("P");
		p.setValor(1525.0);
		
		pp.add(p);
			
	}
	
	for (int x = 181; x<=220; x++) {
		
		Preco m = new Preco();
		m.setImpacto(x);
		m.setTamanho("M");
		m.setValor(1199.0);
		
		pp.add(m);
	
	   
	}
	
	for (int x = 141; x<=160; x++) {
		
		Preco g = new Preco();
		g.setImpacto(x);
		g.setTamanho("G");
		g.setValor(1362.0);
		
		pp.add(g);
	   
	}
		
		precoRepository.saveAll(pp);
		
	}


	
}
