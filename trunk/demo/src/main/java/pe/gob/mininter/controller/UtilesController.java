package pe.gob.mininter.controller;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("session") 
public class UtilesController {
	
	private static final Logger logger = Logger.getLogger(UtilesController.class);
	
	
	@RequestMapping("/menuSemanal.htm")
	 public String menuSemanal() {
		logger.debug("test");
		return "/menuSemanal";
	}
	
	@RequestMapping("/vision.htm")
	public String vision() {
		return "/vision";
	}
		
	@RequestMapping("/cap.htm")
	public String cap() {
		return "/cap";
	}
	
	@RequestMapping("/mof.htm")
	public String mof() {
		return "/mof";
	}	
	
	@RequestMapping("/rof.htm")
	public String rof() {
		return "/rof";
	}	
	
	@RequestMapping("/tupa.htm")
	public String tupa() {
		return "/tupa";
	}	
	
	@RequestMapping("/directivas.htm")
	public String directivas() {
		return "/directivas";
	}	
	
	@RequestMapping("/organigrama.htm")
	public String organigrama() {
		return "/organigrama";
	}	
	
	@RequestMapping("/procedimientos.htm")
	public String procedimientos() {
		return "/procedimientos";
	}
}
