package com.nci.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nci.api.dao.BinDao;
import com.nci.api.dao.InBoxDao;
import com.nci.api.dao.SentBoxDao;
import com.nci.api.model.BinModel;
import com.nci.api.model.InBoxModel;
import com.nci.api.model.SentBoxModel;

@Service
@Transactional
public class BinService {
	@Autowired
	InBoxDao inboxdao;
	@Autowired
	SentBoxDao sentboxdao;
	@Autowired
	BinDao bindao;
	
	private Logger logger=Logger.getLogger(getClass().getName());

	public  void deleteByBinId(int id) {
		
		logger.info("\nPermanently Deleting mail from bin id :"+id);
		
		bindao.deleteById(id);
	}
	
	public  BinModel getMailById(int id) {
		
		BinModel mail=bindao.findById(id);
		logger.info("\nGetting binn mail by id:"+id);
		return mail;

	}
	
	public  List<BinModel> getBinMailsByMailId(String usermail){
		List<BinModel> list=bindao.findByUsermail(usermail);
		logger.info("\nGetting all bin mails of "+usermail);
		
		if(list.size()>0)
		return list.stream().sorted((m1,m2)->-m1.getDate().compareTo(m2.getDate()))
				.collect(Collectors.toCollection(ArrayList::new));
		
		return list;
	
	}
	
	public  void addInboxMailtoBin(int mailid) {
		
		
			
		InBoxModel mail=inboxdao.findById(mailid);
		BinModel binmail=new BinModel();
		
		binmail.setMailid(mail.getId());
		binmail.setMessage(mail.getMessage());
		binmail.setReciever(mail.getReciever());
		binmail.setSender(mail.getSender());
		binmail.setSubject(mail.getSubject());
		binmail.setType("inbox");
		binmail.setUsermail(mail.getReciever());
		binmail.setDate(mail.getDate());
		
		bindao.save(binmail);
		inboxdao.deleteById(mailid);
			
			
	}
	
	public  void addSentBoxMailtoBin(int mailid) {
		SentBoxModel mail=sentboxdao.findById(mailid);
		BinModel binmail=new BinModel();
		
		binmail.setMailid(mail.getId());
		binmail.setMessage(mail.getMessage());
		binmail.setReciever(mail.getReciever());
		binmail.setSender(mail.getSender());
		binmail.setSubject(mail.getSubject());
		binmail.setType("sentbox");
		binmail.setUsermail(mail.getSender());
		binmail.setDate(mail.getDate());
		
		bindao.save(binmail);
		sentboxdao.deleteById(mailid);

	
	}
	
	public  String retriveFromBin(int id) {
		
		BinModel mail=getMailById(id);
		
		if(mail.getType().equalsIgnoreCase("inbox"))
			inboxdao.save(new InBoxModel(mail.getReciever(),mail.getSender()
				,mail.getMessage(),mail.getDate(),mail.getSubject()));
		
		else if(mail.getType().equalsIgnoreCase("sentbox")) 
			sentboxdao.save(new SentBoxModel(mail.getReciever(),mail.getSender()
					,mail.getMessage(),mail.getDate(),mail.getSubject()));
			
		
		deleteByBinId(id);
		
		return mail.getType();
	}
}
