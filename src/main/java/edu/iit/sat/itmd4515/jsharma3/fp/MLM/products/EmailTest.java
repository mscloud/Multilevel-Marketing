/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM.products;

/**
 *
 * @author Jay
 */
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.service.CustomerService;
import java.util.Properties;
import javax.ejb.EJB;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailTest {

    @EJB CustomerService customerService;


	public static void main(String[] args) throws MessagingException {

		String mailSmtpHost = "google.mail.com";

		String mailTo = "jay_rsharma1993@yahoo.com";
		String mailCc = "jays@yahoo.com";
		String mailFrom = "js@gamil.com";
		String mailSubject = "Order Confirm";
		String mailText = "This is an Confirmation Email of Your Order";

		sendEmail(mailTo, mailCc, mailFrom, mailSubject, mailText, mailSmtpHost);
	}

	public static void sendEmail(String to, String cc, String from, String subject, String text, String smtpHost) throws MessagingException {
		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.host", smtpHost);
			Session emailSession = Session.getDefaultInstance(properties);

			Message emailMessage = new MimeMessage(emailSession);
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			emailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
			emailMessage.setFrom(new InternetAddress(from));
			emailMessage.setSubject(subject);
			emailMessage.setText(text);

			emailSession.setDebug(true);

			Transport.send(emailMessage);
		} catch (AddressException e) {
			e.printStackTrace();
		}
	}
}